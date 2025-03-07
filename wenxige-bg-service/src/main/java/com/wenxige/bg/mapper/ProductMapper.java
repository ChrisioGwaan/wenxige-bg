package com.wenxige.bg.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wenxige.bg.dto.ProductPageQueryDTO;
import com.wenxige.bg.entity.Product;
import com.wenxige.bg.vo.ProductInfoVO;
import com.wenxige.bg.vo.ProductPageVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ProductMapper extends BaseMapper<Product> {

    IPage<ProductPageVO> getPageResult(Page<Product> page,
                                       @Param("productPageQueryDTO") ProductPageQueryDTO productPageQueryDTO);

    ProductInfoVO getProductById(@Param("id") String id);

}
