package com.wenxige.bg.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wenxige.bg.entity.SysFile;
import com.wenxige.bg.util.R;
import org.springframework.web.multipart.MultipartFile;

public interface SysFileService extends IService<SysFile> {

    R getSysFileInfo(String fileId);

    R uploadFile(MultipartFile file);

    R deleteFile(String fileId);

}
