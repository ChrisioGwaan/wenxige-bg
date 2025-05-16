package com.wenxige.bg.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wenxige.bg.entity.Category;
import com.wenxige.bg.mapper.CategoryMapper;
import com.wenxige.bg.service.CategoryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements CategoryService {

    private final CategoryMapper categoryMapper;



}
