package com.wenxige.bg.controller;

import com.wenxige.bg.dto.SysRoleCreateOrUpdateDTO;
import com.wenxige.bg.entity.SysRole;
import com.wenxige.bg.service.SysRoleService;
import com.wenxige.bg.util.R;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/role")
public class SysRoleController {

    private final SysRoleService sysRoleService;

    @PostMapping
    public R createRole(@RequestBody SysRoleCreateOrUpdateDTO sysRoleCreateOrUpdateDTO) {
        return sysRoleService.createRole(sysRoleCreateOrUpdateDTO);
    }

}
