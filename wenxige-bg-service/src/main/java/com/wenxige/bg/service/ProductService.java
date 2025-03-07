package com.wenxige.bg.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.wenxige.bg.dto.ProductCreateOrUpdateDTO;
import com.wenxige.bg.dto.ProductPageQueryDTO;
import com.wenxige.bg.entity.Product;
import com.wenxige.bg.util.R;
import com.wenxige.bg.vo.ProductInfoVO;
import com.wenxige.bg.vo.ProductPageVO;

public interface ProductService extends IService<Product> {

    IPage<ProductPageVO> listProduct(Page<Product> page, ProductPageQueryDTO productPageQueryDTO);

    ProductInfoVO findById(String id);

    R createNew(ProductCreateOrUpdateDTO productCreateOrUpdateDTO);

    R updateProduct(ProductCreateOrUpdateDTO productCreateOrUpdateDTO);

}
