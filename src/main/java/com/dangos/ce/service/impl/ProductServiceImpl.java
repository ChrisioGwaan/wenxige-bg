package com.dangos.ce.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.ObjectUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dangos.ce.dto.ProductCreateOrUpdateDTO;
import com.dangos.ce.entity.Product;
import com.dangos.ce.jwt.JwtService;
import com.dangos.ce.mapper.ProductMapper;
import com.dangos.ce.service.ProductService;
import com.dangos.ce.util.R;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@Slf4j
@RequiredArgsConstructor
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product> implements ProductService {

    private final JwtService jwtService;

    @Override
    public IPage<Product> listProduct(Page<Product> page) {
        return baseMapper.selectPage(page, null);
    }

    @Override
    public Product findById(Long id) {
        return this.getById(id);
    }

    @Override
    public R createNew(ProductCreateOrUpdateDTO productCreateOrUpdateDTO) {
        Product newProduct = new Product();
        BeanUtils.copyProperties(productCreateOrUpdateDTO, newProduct);
        newProduct.setCreateTime(LocalDateTime.now());
        newProduct.setCreateUser(jwtService.getUsernameFromToken());

        this.save(newProduct);
        return R.ok(null, "Create Success!");
    }

    @Override
    public R updateProduct(ProductCreateOrUpdateDTO productCreateOrUpdateDTO) {
        Product existedProduct = this.getById(productCreateOrUpdateDTO.getId());

        if (ObjectUtils.isEmpty(existedProduct)) {
            return R.failed(null, "Product not found!");
        }

        BeanUtils.copyProperties(productCreateOrUpdateDTO, existedProduct);
        existedProduct.setModifiedTime(LocalDateTime.now());
        existedProduct.setModifiedUser(jwtService.getUsernameFromToken());
        this.updateById(existedProduct);
        return R.ok(null, "Update Success!");
    }

}
