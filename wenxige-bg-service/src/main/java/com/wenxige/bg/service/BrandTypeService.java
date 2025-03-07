package com.wenxige.bg.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.wenxige.bg.dto.BrandTypeCreateOrUpdateDTO;
import com.wenxige.bg.dto.BrandTypePageQueryDTO;
import com.wenxige.bg.entity.BrandType;
import com.wenxige.bg.util.R;
import com.wenxige.bg.vo.BrandTypeInfoVO;
import com.wenxige.bg.vo.BrandTypePageVO;

import java.util.List;

public interface BrandTypeService extends IService<BrandType> {

    IPage<BrandTypePageVO> listBrandType(Page<BrandType> page, BrandTypePageQueryDTO brandTypePageQueryDTO);

    BrandTypeInfoVO findById(Long id);

    R createNew(BrandTypeCreateOrUpdateDTO brandTypeCreateOrUpdateDTO);

    R updateBrandType(BrandTypeCreateOrUpdateDTO brandTypeCreateOrUpdateDTO);

    List<BrandTypePageVO> dropdownList(String args);

}
