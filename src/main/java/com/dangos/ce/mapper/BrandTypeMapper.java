package com.dangos.ce.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dangos.ce.dto.BrandTypePageQueryDTO;
import com.dangos.ce.entity.BrandType;
import com.dangos.ce.vo.BrandTypeInfoVO;
import com.dangos.ce.vo.BrandTypePageVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface BrandTypeMapper extends BaseMapper<BrandType> {

    IPage<BrandTypePageVO> getPageResult(Page<BrandType> page,
                                         @Param("args") BrandTypePageQueryDTO brandTypePageQueryDTO);

    List<BrandTypePageVO> dropDownList(@Param("args") String args);

    BrandTypeInfoVO getBrandTypeInfo(@Param("id") Long id);

}
