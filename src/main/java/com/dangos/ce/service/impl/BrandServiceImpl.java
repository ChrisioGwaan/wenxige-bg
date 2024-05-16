package com.dangos.ce.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.ObjectUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dangos.ce.dto.BrandCreateOrUpdateDTO;
import com.dangos.ce.entity.Brand;
import com.dangos.ce.jwt.JwtService;
import com.dangos.ce.mapper.BrandMapper;
import com.dangos.ce.service.BrandService;
import com.dangos.ce.util.R;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@Slf4j
@RequiredArgsConstructor
public class BrandServiceImpl extends ServiceImpl<BrandMapper, Brand> implements BrandService {

    private final JwtService jwtService;

    @Override
    public IPage<Brand> listBrand(Page<Brand> page) {
        return baseMapper.selectPage(page, null);
    }

    @Override
    public Brand findById(Long id) {
        return this.getById(id);
    }

    @Override
    public R createNew(BrandCreateOrUpdateDTO brandCreateOrUpdateDTO) {
        Brand brand = new Brand();
        BeanUtils.copyProperties(brandCreateOrUpdateDTO, brand);
        brand.setCreateUser(jwtService.getUsernameFromToken());
        brand.setCreateTime(LocalDateTime.now());
        return R.ok(this.save(brand), "Create Success!");
    }

    @Override
    public R updateBrand(BrandCreateOrUpdateDTO brandCreateOrUpdateDTO) {
        Brand existedBrand = this.getById(brandCreateOrUpdateDTO.getId());

        if (ObjectUtils.isEmpty(existedBrand)) {
            return R.failed(null, "Brand not found!");
        }

        BeanUtils.copyProperties(brandCreateOrUpdateDTO, existedBrand);
        existedBrand.setModifiedTime(LocalDateTime.now());
        existedBrand.setModifiedUser(jwtService.getUsernameFromToken());
        return R.ok(this.updateById(existedBrand), "Update Success!");
    }


}
