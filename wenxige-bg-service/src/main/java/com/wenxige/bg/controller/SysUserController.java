package com.wenxige.bg.controller;

import com.wenxige.bg.entity.SysUser;
import com.wenxige.bg.service.SysUserService;
import com.wenxige.bg.util.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/user")
public class SysUserController {

    @Autowired
    private SysUserService sysUserService;

    @GetMapping("/find")
    public SysUser find(String username) {
        return sysUserService.findByUsername(username);
    }

    @PostMapping("/save")
    public R save(@RequestBody SysUser sysUser) {
        return sysUserService.createNew(sysUser);
    }

}
