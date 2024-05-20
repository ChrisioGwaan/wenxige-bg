package com.dangos.ce.service.impl;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.HttpMethod;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.GeneratePresignedUrlRequest;
import com.baomidou.mybatisplus.core.toolkit.ObjectUtils;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dangos.ce.entity.SysFile;
import com.dangos.ce.jwt.JwtService;
import com.dangos.ce.mapper.SysFileMapper;
import com.dangos.ce.service.SysFileService;
import com.dangos.ce.util.R;
import com.dangos.ce.vo.SysFileInfoVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

@Service
@Slf4j
@RequiredArgsConstructor
public class SysFileServiceImpl extends ServiceImpl<SysFileMapper, SysFile> implements SysFileService {

    private final AmazonS3 s3Client;
    private final JwtService jwtService;

    @Value("${cloudflare.r2.bucketName}")
    private String BUCKET_NAME;

    @Override
    public R getSysFileInfo(String fileId) {
        SysFile sysFile = this.getById(fileId);
        if (ObjectUtils.isEmpty(sysFile)) {
            return R.failed("File not found");
        }
        SysFileInfoVO sysFileInfoVO = new SysFileInfoVO();
        BeanUtils.copyProperties(sysFile, sysFileInfoVO);

        Date expiration = new Date();
        long expTimeMillis = expiration.getTime();
        expTimeMillis += 1000 * 60 * 60 / 3; // 20 minutes
        expiration.setTime(expTimeMillis);

        GeneratePresignedUrlRequest generatePresignedUrlRequest =
            new GeneratePresignedUrlRequest(BUCKET_NAME, sysFile.getPath())
                .withMethod(HttpMethod.GET)
                .withExpiration(expiration);

        sysFileInfoVO.setUrl(s3Client.generatePresignedUrl(generatePresignedUrlRequest).toString());
        return R.ok(sysFileInfoVO, "File information obtained successfully");
    }

    @Override
    public R uploadFile(MultipartFile multipartFile) {
        try {
            String originalFilename = multipartFile.getOriginalFilename();
            String currentDate = new SimpleDateFormat("yyyyMMdd").format(new Date());
            String path = currentDate + "/" + originalFilename;
            File file = new File(System.getProperty("java.io.tmpdir") + "/" + originalFilename);
            multipartFile.transferTo(file);

            if (multipartFile.getSize() > 20 * 1024 * 1024) {
                log.error("File size exceeds 20MB");
                return R.failed("File size exceeds 20MB");
            }
            s3Client.putObject(BUCKET_NAME, path, file);

            SysFile sysFile = SysFile.builder()
                    .fileName(originalFilename)
                    .bucketName(BUCKET_NAME)
                    .path(path)
                    .type(multipartFile.getContentType())
                    .size(multipartFile.getSize())
                    .createUser(jwtService.getUsernameFromToken())
                    .createTime(LocalDateTime.now())
                    .build();
            this.save(sysFile);
        } catch (AmazonServiceException | IOException e) {
            log.error("Error uploading file to S3: {}", e.getMessage());
            return R.failed("Error uploading file to S3");
        }
        return R.ok("File uploaded successfully");
    }

    @Override
    public R deleteFile(String fileId) {
        SysFile sysFile = this.getById(fileId);
        if (ObjectUtils.isEmpty(sysFile)) {
            return R.failed("File not found");
        }
        try {
            s3Client.deleteObject(BUCKET_NAME, sysFile.getPath());

            // Record the deletion time of the file
            sysFile.setModifiedTime(LocalDateTime.now());
            this.updateById(sysFile);

            // Set the deletion status of the file to 1
            this.removeById(fileId);
        } catch (AmazonServiceException e) {
            log.error("Error deleting file from S3: {}", e.getMessage());
            return R.failed("Error deleting file from S3");
        }
        return R.ok("File deleted successfully");
    }

}
