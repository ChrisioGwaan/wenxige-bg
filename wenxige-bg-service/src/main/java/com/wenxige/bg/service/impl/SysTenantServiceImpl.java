package com.wenxige.bg.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wenxige.bg.entity.SysTenant;
import com.wenxige.bg.mapper.SysTenantMapper;
import com.wenxige.bg.service.SysTenantService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class SysTenantServiceImpl extends ServiceImpl<SysTenantMapper, SysTenant> implements SysTenantService {
}
