package com.dangos.ce.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.dangos.ce.dto.ProductCreateOrUpdateDTO;
import com.dangos.ce.dto.ProductPageQueryDTO;
import com.dangos.ce.entity.Product;
import com.dangos.ce.util.R;
import com.dangos.ce.vo.ProductPageVO;

public interface ProductService extends IService<Product> {

    IPage<ProductPageVO> listProduct(Page<Product> page, ProductPageQueryDTO productPageQueryDTO);

    Product findById(Long id);

    R createNew(ProductCreateOrUpdateDTO productCreateOrUpdateDTO);

    R updateProduct(ProductCreateOrUpdateDTO productCreateOrUpdateDTO);

}
