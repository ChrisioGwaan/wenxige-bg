package com.dangos.ce.controller;

import com.dangos.ce.service.SysFileService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/sysFile")
public class SysFileController {

    private final SysFileService sysFileService;

    @PostMapping("/upload")
    public void uploadFile(@RequestParam("file") MultipartFile multipartFile) {
        sysFileService.uploadFile(multipartFile);
    }

}
