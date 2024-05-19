package com.dangos.ce.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dangos.ce.dto.ProductBatchQueryDTO;
import com.dangos.ce.dto.ProductCreateOrUpdateDTO;
import com.dangos.ce.dto.ProductPageQueryDTO;
import com.dangos.ce.entity.Product;
import com.dangos.ce.service.ProductService;
import com.dangos.ce.util.R;
import com.dangos.ce.vo.ProductPageVO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/product")
public class ProductController {

    private final ProductService productService;

    /**
     * Get product list in pagination
     *
     * @param page page info
     * @return IPage<Product>
    */
    @GetMapping("/page")
    public R<IPage<ProductPageVO>> getPage(Page<Product> page, ProductPageQueryDTO productPageQueryDTO) {
        return R.ok(productService.listProduct(page, productPageQueryDTO));
    }

    /**
     * Get product by ID
     *
     * @param id product ID
     * @return R<Product>
     */
    @GetMapping("/{id}")
    public R<ProductCreateOrUpdateDTO> selectById(@PathVariable("id") Long id) {
        ProductCreateOrUpdateDTO productCreateOrUpdateDTO = new ProductCreateOrUpdateDTO();
        Product product = productService.getById(id);
        BeanUtils.copyProperties(product, productCreateOrUpdateDTO);
        productCreateOrUpdateDTO.setId(Long.toString(product.getId()));
        return R.ok(productCreateOrUpdateDTO);
    }

    /**
     * Create new product
     *
     * @param productCreateOrUpdateDTO product create or update DTO object
     * @return R
     */
    @PostMapping("/create")
    public R createNew(@RequestBody ProductCreateOrUpdateDTO productCreateOrUpdateDTO) {
        return productService.createNew(productCreateOrUpdateDTO);
    }

    /**
     * Update product
     *
     * @param productCreateOrUpdateDTO product create or update DTO object
     * @return R
     */
    @PutMapping("/update")
    public R updateProduct(@RequestBody ProductCreateOrUpdateDTO productCreateOrUpdateDTO) {
        return productService.updateProduct(productCreateOrUpdateDTO);
    }

    /**
     * Delete product, logical delete
     *
     * @param id product ID
     * @return R
     */
    @DeleteMapping("/{id}")
    public R deleteProduct(@PathVariable("id") Long id) {
        return R.ok(productService.removeById(id));
    }

    /**
     * Delete multiple products, logical delete
     *
     * @param productBatchQueryDTO product batch query DTO object
     * @return R
     */
    @DeleteMapping("/batchDelete")
    public R batchDelete(@RequestBody ProductBatchQueryDTO productBatchQueryDTO) {
        return R.ok(productService.removeByIds(productBatchQueryDTO.getProductIds()));
    }
}
