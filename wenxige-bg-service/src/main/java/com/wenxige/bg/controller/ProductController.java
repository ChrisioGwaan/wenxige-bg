package com.wenxige.bg.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wenxige.bg.dto.ProductBatchQueryDTO;
import com.wenxige.bg.dto.ProductCreateOrUpdateDTO;
import com.wenxige.bg.dto.ProductPageQueryDTO;
import com.wenxige.bg.entity.Product;
import com.wenxige.bg.service.ProductService;
import com.wenxige.bg.util.R;
import com.wenxige.bg.vo.ProductInfoVO;
import com.wenxige.bg.vo.ProductPageVO;
import lombok.RequiredArgsConstructor;
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
     * @return R<ProductInfoVO>
     */
    @GetMapping("/{id}")
    public R<ProductInfoVO> selectById(@PathVariable("id") String id) {
        return R.ok(productService.findById(id));
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
