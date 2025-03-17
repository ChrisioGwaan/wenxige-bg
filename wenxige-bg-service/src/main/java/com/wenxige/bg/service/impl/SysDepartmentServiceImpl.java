package com.wenxige.bg.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wenxige.bg.entity.SysDepartment;
import com.wenxige.bg.mapper.SysDepartmentMapper;
import com.wenxige.bg.service.SysDepartmentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class SysDepartmentServiceImpl extends ServiceImpl<SysDepartmentMapper, SysDepartment> implements SysDepartmentService {
}
