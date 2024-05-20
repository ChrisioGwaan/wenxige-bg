package com.dangos.ce.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dangos.ce.dto.BrandPageQueryDTO;
import com.dangos.ce.entity.Brand;
import com.dangos.ce.vo.BrandPageVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BrandMapper extends BaseMapper<Brand> {

    IPage<BrandPageVO> getPageResult(Page<Brand> page, BrandPageQueryDTO brandPageQueryDTO);

}
