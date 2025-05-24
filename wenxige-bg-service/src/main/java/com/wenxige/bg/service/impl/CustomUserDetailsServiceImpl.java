package com.wenxige.bg.service.impl;

import com.wenxige.bg.entity.SysRole;
import com.wenxige.bg.entity.SysUser;
import com.wenxige.bg.mapper.SysRoleMapper;
import com.wenxige.bg.mapper.SysUserMapper;
import com.wenxige.bg.service.CustomUserDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsServiceImpl implements UserDetailsService {

    private final SysUserMapper userMapper;
    private final SysRoleMapper roleMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        SysUser user = userMapper.selectByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        SysRole role = roleMapper.selectById(user.getSysRoleId());
        user.setSysRole(role);
        return user;
    }

}
