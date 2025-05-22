package com.wenxige.bg.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wenxige.bg.dto.SysRoleCreateOrUpdateDTO;
import com.wenxige.bg.entity.SysRole;
import com.wenxige.bg.jwt.JwtService;
import com.wenxige.bg.mapper.SysRoleMapper;
import com.wenxige.bg.service.SysRoleService;
import com.wenxige.bg.util.R;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@Slf4j
@RequiredArgsConstructor
public class SysRoleServiceImpl extends ServiceImpl<SysRoleMapper, SysRole> implements SysRoleService {

    private final JwtService jwtService;

    public R createRole(SysRoleCreateOrUpdateDTO sysRoleCreateOrUpdateDTO) {
        SysRole sysRole = new SysRole();

        sysRole.setRoleName(sysRoleCreateOrUpdateDTO.getRoleName());
        sysRole.setCreateUser(jwtService.getUsernameFromToken());
        sysRole.setCreateTime(LocalDateTime.now());

        try {
            this.save(sysRole);
        } catch (Exception e) {
            log.error("Error creating role: {}", e.getMessage());
            return R.failed("Failed to create role");
        }

        return R.ok(sysRole, "Role created successfully");
    }

}
