package com.dangos.ce.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dangos.ce.entity.SysUser;
import com.dangos.ce.mapper.SysUserMapper;
import com.dangos.ce.service.SysUserService;
import com.dangos.ce.util.R;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements SysUserService {

    private final PasswordEncoder passwordEncoder;

    @Override
    public SysUser findByUsername(String username) {
        LambdaQueryWrapper<SysUser> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(SysUser::getUsername, username);
        return this.getOne(queryWrapper);
    }

    @Override
    public R createNew(SysUser sysUser) {
        sysUser.setPassword(passwordEncoder.encode(sysUser.getPassword()));
        sysUser.setCreateTime(LocalDateTime.now());

        this.save(sysUser);
        return R.ok();
    }

}
