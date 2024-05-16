package com.dangos.ce.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.dangos.ce.dto.BrandTypeCreateOrUpdateDTO;
import com.dangos.ce.entity.BrandType;
import com.dangos.ce.util.R;

public interface BrandTypeService extends IService<BrandType> {

    IPage<BrandType> listBrandType(Page<BrandType> page);

    BrandType findById(Long id);

    R createNew(BrandTypeCreateOrUpdateDTO brandTypeCreateOrUpdateDTO);

    R updateBrandType(BrandTypeCreateOrUpdateDTO brandTypeCreateOrUpdateDTO);

}
