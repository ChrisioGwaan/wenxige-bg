package com.dangos.ce.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dangos.ce.dto.ProductCreateOrUpdateDTO;
import com.dangos.ce.entity.Product;
import com.dangos.ce.util.R;

public interface ProductService {

    IPage<Product> listProduct(Page<Product> page);

    Product findById(Long id);

    R createNew(ProductCreateOrUpdateDTO productCreateOrUpdateDTO);

    R updateProduct(ProductCreateOrUpdateDTO productCreateOrUpdateDTO);

}
