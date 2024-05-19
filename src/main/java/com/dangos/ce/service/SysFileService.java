package com.dangos.ce.service;

import org.springframework.web.multipart.MultipartFile;

public interface SysFileService {

    void uploadFile(MultipartFile file);

}
