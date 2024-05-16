package com.dangos.ce.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.dangos.ce.dto.BrandCreateOrUpdateDTO;
import com.dangos.ce.entity.Brand;
import com.dangos.ce.util.R;

public interface BrandService extends IService<Brand> {

    IPage<Brand> listBrand(Page<Brand> page);

    Brand findById(Long id);

    R createNew(BrandCreateOrUpdateDTO brandCreateOrUpdateDTO);

    R updateBrand(BrandCreateOrUpdateDTO brandCreateOrUpdateDTO);

}
