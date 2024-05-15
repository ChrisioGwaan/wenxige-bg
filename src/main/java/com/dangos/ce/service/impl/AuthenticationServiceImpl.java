package com.dangos.ce.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.dangos.ce.entity.SysUser;
import com.dangos.ce.enums.Role;
import com.dangos.ce.jwt.JwtService;
import com.dangos.ce.mapper.SysUserMapper;
import com.dangos.ce.service.AuthenticationService;
import com.dangos.ce.util.AuthenticationRequest;
import com.dangos.ce.util.AuthenticationResponse;
import com.dangos.ce.util.RegisterRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.time.LocalDateTime;

@Service
@Slf4j
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {

    private final SysUserMapper sysUserMapper;

    private final PasswordEncoder passwordEncoder;

    private final JwtService jwtService;

    private final AuthenticationManager authenticationManager;

    @Override
    public AuthenticationResponse register(RegisterRequest registerRequest) {
        LambdaQueryWrapper<SysUser> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(SysUser::getUsername, registerRequest.getUsername());
        SysUser sysuser = sysUserMapper.selectOne(queryWrapper);
        if (!ObjectUtils.isEmpty(sysuser)) {
            return AuthenticationResponse.builder()
                    .token("Username already exists")
                    .build();
        }
        var sysUser = SysUser.builder()
                .username(registerRequest.getUsername())
                .firstname(registerRequest.getFirstname())
                .lastname(registerRequest.getLastname())
                .email(registerRequest.getEmail())
                .password(passwordEncoder.encode(registerRequest.getPassword()))
                .createUser(jwtService.getUsernameFromToken())
                .createTime(LocalDateTime.now())
                .role(Role.ADMIN)
                .build();
        sysUserMapper.insert(sysUser);
        var jwtToken = jwtService.generateToken(sysUser);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }

    @Override
    public AuthenticationResponse authenticate(AuthenticationRequest authenticationRequest) {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            authenticationRequest.getUsername(),
                            authenticationRequest.getPassword()
                    )
            );
        } catch (Exception e) {
            return AuthenticationResponse.builder()
                    .token("Token Failed. Invalid username or password")
                    .build();
        }

        var sysUser = sysUserMapper.selectByUsername(authenticationRequest.getUsername())
                .orElseThrow();
        var jwtToken = jwtService.generateToken(sysUser);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }
}
