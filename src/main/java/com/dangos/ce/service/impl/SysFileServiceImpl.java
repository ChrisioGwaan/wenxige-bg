package com.dangos.ce.service.impl;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.s3.AmazonS3;
import com.dangos.ce.service.SysFileService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Service
@Slf4j
@RequiredArgsConstructor
public class SysFileServiceImpl implements SysFileService {

    private final AmazonS3 s3Client;

    @Value("${cloudflare.r2.bucketName}")
    private String BUCKET_NAME;

    @Override
    public void uploadFile(MultipartFile multipartFile) {
        try {
            String originalFilename = multipartFile.getOriginalFilename();
            File file = new File(System.getProperty("java.io.tmpdir") + "/" + originalFilename);
            multipartFile.transferTo(file);
            s3Client.putObject(BUCKET_NAME, originalFilename, file);
        } catch (AmazonServiceException | IOException e) {
            log.error("Error uploading file to S3: {}", e.getMessage());
        }
    }

}
