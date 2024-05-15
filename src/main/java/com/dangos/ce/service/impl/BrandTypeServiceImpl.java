package com.dangos.ce.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dangos.ce.entity.BrandType;
import com.dangos.ce.mapper.BrandTypeMapper;
import com.dangos.ce.service.BrandTypeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class BrandTypeServiceImpl extends ServiceImpl<BrandTypeMapper, BrandType> implements BrandTypeService {


}
