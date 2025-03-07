package com.wenxige.bg.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wenxige.bg.dto.BrandPageQueryDTO;
import com.wenxige.bg.entity.Brand;
import com.wenxige.bg.vo.BrandPageVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BrandMapper extends BaseMapper<Brand> {

    IPage<BrandPageVO> getPageResult(Page<Brand> page, BrandPageQueryDTO brandPageQueryDTO);

    List<BrandPageVO> dropDownList(String args);

}
