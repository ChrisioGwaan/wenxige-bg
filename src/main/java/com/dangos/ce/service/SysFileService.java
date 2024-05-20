package com.dangos.ce.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.dangos.ce.entity.SysFile;
import com.dangos.ce.util.R;
import org.springframework.web.multipart.MultipartFile;

public interface SysFileService extends IService<SysFile> {

    R getSysFileInfo(String fileId);

    R uploadFile(MultipartFile file);

    R deleteFile(String fileId);

}
