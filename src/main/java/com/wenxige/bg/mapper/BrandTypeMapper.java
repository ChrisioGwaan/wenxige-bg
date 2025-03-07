package com.wenxige.bg.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wenxige.bg.dto.BrandTypePageQueryDTO;
import com.wenxige.bg.entity.BrandType;
import com.wenxige.bg.vo.BrandTypeInfoVO;
import com.wenxige.bg.vo.BrandTypePageVO;
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
