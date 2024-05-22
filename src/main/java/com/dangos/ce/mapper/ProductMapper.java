package com.dangos.ce.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dangos.ce.dto.ProductPageQueryDTO;
import com.dangos.ce.entity.Product;
import com.dangos.ce.vo.ProductInfoVO;
import com.dangos.ce.vo.ProductPageVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ProductMapper extends BaseMapper<Product> {

    IPage<ProductPageVO> getPageResult(Page<Product> page,
                                       @Param("productPageQueryDTO") ProductPageQueryDTO productPageQueryDTO);

    ProductInfoVO getProductById(@Param("id") String id);

}
