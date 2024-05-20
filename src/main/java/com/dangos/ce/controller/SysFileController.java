package com.dangos.ce.controller;

import com.dangos.ce.service.SysFileService;
import com.dangos.ce.util.R;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/sysFile")
public class SysFileController {

    private final SysFileService sysFileService;

    @GetMapping("/getFileInfo")
    public R getSysFileInfo(@RequestParam("fileId") String fileId) {
        return sysFileService.getSysFileInfo(fileId);
    }

    @PostMapping("/upload")
    public R uploadFile(@RequestParam("file") MultipartFile multipartFile) {
        return sysFileService.uploadFile(multipartFile);
    }

    @DeleteMapping("/delete")
    public R deleteFile(@RequestParam("fileId") String fileId) {
        return sysFileService.deleteFile(fileId);
    }

}
