package com.dangos.ce.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dangos.ce.entity.Brand;
import com.dangos.ce.mapper.BrandMapper;
import com.dangos.ce.service.BrandService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class BrandServiceImpl extends ServiceImpl<BrandMapper, Brand> implements BrandService {


}
