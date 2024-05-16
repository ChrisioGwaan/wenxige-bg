package com.dangos.ce.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.dangos.ce.dto.ProductCreateOrUpdateDTO;
import com.dangos.ce.entity.Product;
import com.dangos.ce.util.R;

public interface ProductService extends IService<Product> {

    IPage<Product> listProduct(Page<Product> page);

    Product findById(Long id);

    R createNew(ProductCreateOrUpdateDTO productCreateOrUpdateDTO);

    R updateProduct(ProductCreateOrUpdateDTO productCreateOrUpdateDTO);

}
