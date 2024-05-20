package com.dangos.ce.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.ObjectUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dangos.ce.dto.BrandCreateOrUpdateDTO;
import com.dangos.ce.dto.BrandPageQueryDTO;
import com.dangos.ce.entity.Brand;
import com.dangos.ce.jwt.JwtService;
import com.dangos.ce.mapper.BrandMapper;
import com.dangos.ce.service.BrandService;
import com.dangos.ce.util.R;
import com.dangos.ce.vo.BrandPageVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.Year;

@Service
@Slf4j
@RequiredArgsConstructor
public class BrandServiceImpl extends ServiceImpl<BrandMapper, Brand> implements BrandService {

    private final JwtService jwtService;

    @Override
    public IPage<BrandPageVO> listBrand(Page<Brand> page, BrandPageQueryDTO brandPageQueryDTO) {
        IPage<BrandPageVO> brandPageVOIPage = baseMapper.getPageResult(page, brandPageQueryDTO);
        brandPageVOIPage.getRecords().forEach(brandPageVO -> {
            brandPageVO.setOriginYear(brandPageVO.getOriginYear().substring(0, 4));
        });
        return brandPageVOIPage;
    }

    @Override
    public Brand findById(Long id) {
        return this.getById(id);
    }

    @Override
    public BrandPageVO selectById(Long id) {
        Brand brand = this.getById(id);
        BrandPageVO brandPageVO = new BrandPageVO();
        BeanUtils.copyProperties(brand, brandPageVO);
        brandPageVO.setId(brand.getId().toString());
        brandPageVO.setIsLock(String.valueOf(brand.getIsLock()));
        brandPageVO.setCreateTime(brand.getCreateTime().toString());
        brandPageVO.setOriginYear(brand.getOriginYear().toString().substring(0, 4));
        if (ObjectUtils.isNotEmpty(brand.getModifiedTime())) {
            brandPageVO.setModifiedTime(brand.getModifiedTime().toString());
        }

        return brandPageVO;
    }

    @Override
    public R createNew(BrandCreateOrUpdateDTO brandCreateOrUpdateDTO) {
        Brand brand = new Brand();
        BeanUtils.copyProperties(brandCreateOrUpdateDTO, brand);
        brand.setOriginYear(Year.parse(brandCreateOrUpdateDTO.getOriginYear()));
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
        Year year = Year.parse(brandCreateOrUpdateDTO.getOriginYear());
        existedBrand.setOriginYear(year);
        existedBrand.setModifiedTime(LocalDateTime.now());
        existedBrand.setModifiedUser(jwtService.getUsernameFromToken());
        return R.ok(this.updateById(existedBrand), "Update Success!");
    }


}
