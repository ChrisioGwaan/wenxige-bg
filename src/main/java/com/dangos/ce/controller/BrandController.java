package com.dangos.ce.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dangos.ce.dto.BrandCreateOrUpdateDTO;
import com.dangos.ce.entity.Brand;
import com.dangos.ce.service.BrandService;
import com.dangos.ce.util.R;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/brand")
public class BrandController {

    private final BrandService brandService;

    /**
     * Get brand list in pagination
     *
     * @param page page info
     * @return IPage<Brand>
     */
    @GetMapping("/page")
    public IPage<Brand> getPage(Page<Brand> page) {
        return brandService.listBrand(page);
    }

    /**
     * Get brand by ID
     *
     * @param id brand ID
     * @return R<Product>
     */
    @GetMapping("/{id}")
    public R<Brand> selectById(@PathVariable("id") Long id) {
        return R.ok(brandService.findById(id));
    }

    /**
     * Create new brand
     *
     * @param brandCreateOrUpdateDTO brand create or update DTO object
     * @return R
     */
    @PostMapping("/create")
    public R createNew(@RequestBody BrandCreateOrUpdateDTO brandCreateOrUpdateDTO) {
        return brandService.createNew(brandCreateOrUpdateDTO);
    }

    /**
     * Update brand
     *
     * @param brandCreateOrUpdateDTO brand create or update DTO object
     * @return R
     */
    @PutMapping("/update")
    public R updateBrand(@RequestBody BrandCreateOrUpdateDTO brandCreateOrUpdateDTO) {
        return brandService.updateBrand(brandCreateOrUpdateDTO);
    }

    /**
     * Delete brand, logical delete
     *
     * @param id brand ID
     * @return R
     */
    @DeleteMapping("/{id}")
    public R deleteBrand(@PathVariable("id") Long id) {
        return R.ok(brandService.removeById(id));
    }

    /**
     * dropdown list
     *
     * @return R<List<Brand>>
     */
    @GetMapping("/dropdown")
    public R<List<Brand>> dropDownList() {
        return R.ok(brandService.list());
    }

}
