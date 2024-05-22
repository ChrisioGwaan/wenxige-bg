package com.dangos.ce.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.dangos.ce.dto.BrandCreateOrUpdateDTO;
import com.dangos.ce.dto.BrandPageQueryDTO;
import com.dangos.ce.entity.Brand;
import com.dangos.ce.util.R;
import com.dangos.ce.vo.BrandPageVO;

import java.util.List;

public interface BrandService extends IService<Brand> {

    IPage<BrandPageVO> listBrand(Page<Brand> page, BrandPageQueryDTO brandPageQueryDTO);

    Brand findById(Long id);

    BrandPageVO selectById(Long id);

    R createNew(BrandCreateOrUpdateDTO brandCreateOrUpdateDTO);

    R updateBrand(BrandCreateOrUpdateDTO brandCreateOrUpdateDTO);

    List<BrandPageVO> dropDownList(String args);

}
