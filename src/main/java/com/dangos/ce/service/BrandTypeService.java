package com.dangos.ce.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.dangos.ce.dto.BrandTypeCreateOrUpdateDTO;
import com.dangos.ce.dto.BrandTypePageQueryDTO;
import com.dangos.ce.entity.BrandType;
import com.dangos.ce.util.R;
import com.dangos.ce.vo.BrandTypeInfoVO;
import com.dangos.ce.vo.BrandTypePageVO;

import java.util.List;

public interface BrandTypeService extends IService<BrandType> {

    IPage<BrandTypePageVO> listBrandType(Page<BrandType> page, BrandTypePageQueryDTO brandTypePageQueryDTO);

    BrandTypeInfoVO findById(Long id);

    R createNew(BrandTypeCreateOrUpdateDTO brandTypeCreateOrUpdateDTO);

    R updateBrandType(BrandTypeCreateOrUpdateDTO brandTypeCreateOrUpdateDTO);

    List<BrandTypePageVO> dropdownList(String args);

}
