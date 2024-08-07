package com.dangos.ce.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.ObjectUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dangos.ce.dto.BrandTypeCreateOrUpdateDTO;
import com.dangos.ce.dto.BrandTypePageQueryDTO;
import com.dangos.ce.entity.BrandType;
import com.dangos.ce.jwt.JwtService;
import com.dangos.ce.mapper.BrandMapper;
import com.dangos.ce.mapper.BrandTypeMapper;
import com.dangos.ce.service.BrandTypeService;
import com.dangos.ce.util.R;
import com.dangos.ce.vo.BrandTypeInfoVO;
import com.dangos.ce.vo.BrandTypePageVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class BrandTypeServiceImpl extends ServiceImpl<BrandTypeMapper, BrandType> implements BrandTypeService {

    private final JwtService jwtService;

    private final BrandMapper brandMapper;

    @Override
    public IPage<BrandTypePageVO> listBrandType(Page<BrandType> page, BrandTypePageQueryDTO brandTypePageQueryDTO) {
        return baseMapper.getPageResult(page, brandTypePageQueryDTO);
    }

    @Override
    public BrandTypeInfoVO findById(Long id) {
        return baseMapper.getBrandTypeInfo(id);
    }

    @Override
    public R createNew(BrandTypeCreateOrUpdateDTO brandTypeCreateOrUpdateDTO) {
        BrandType newBrandType = new BrandType();
        BeanUtils.copyProperties(brandTypeCreateOrUpdateDTO, newBrandType);
        newBrandType.setCreateTime(LocalDateTime.now());
        newBrandType.setCreateUser(jwtService.getUsernameFromToken());
        return R.ok(this.save(newBrandType), "Create Success!");
    }

    @Override
    public R updateBrandType(BrandTypeCreateOrUpdateDTO brandTypeCreateOrUpdateDTO) {
        BrandType existedBrandType = this.getById(brandTypeCreateOrUpdateDTO.getId());
        if (ObjectUtils.isEmpty(existedBrandType)) {
            return R.failed(null, "Brand Type not found!");
        }
        BeanUtils.copyProperties(brandTypeCreateOrUpdateDTO, existedBrandType);
        existedBrandType.setModifiedTime(LocalDateTime.now());
        existedBrandType.setModifiedUser(jwtService.getUsernameFromToken());
        return R.ok(this.updateById(existedBrandType), "Update Success!");
    }

    @Override
    public List<BrandTypePageVO> dropdownList(String args) {
        return baseMapper.dropDownList(args);
    }

}
