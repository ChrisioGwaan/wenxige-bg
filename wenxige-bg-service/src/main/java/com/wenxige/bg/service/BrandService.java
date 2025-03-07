package com.wenxige.bg.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.wenxige.bg.dto.BrandCreateOrUpdateDTO;
import com.wenxige.bg.dto.BrandPageQueryDTO;
import com.wenxige.bg.entity.Brand;
import com.wenxige.bg.util.R;
import com.wenxige.bg.vo.BrandPageVO;

import java.util.List;

public interface BrandService extends IService<Brand> {

    IPage<BrandPageVO> listBrand(Page<Brand> page, BrandPageQueryDTO brandPageQueryDTO);

    Brand findById(Long id);

    BrandPageVO selectById(Long id);

    R createNew(BrandCreateOrUpdateDTO brandCreateOrUpdateDTO);

    R updateBrand(BrandCreateOrUpdateDTO brandCreateOrUpdateDTO);

    List<BrandPageVO> dropDownList(String args);

}
