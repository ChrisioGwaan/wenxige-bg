package com.dangos.ce.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dangos.ce.dto.BrandBatchQueryDTO;
import com.dangos.ce.dto.BrandCreateOrUpdateDTO;
import com.dangos.ce.dto.BrandPageQueryDTO;
import com.dangos.ce.entity.Brand;
import com.dangos.ce.service.BrandService;
import com.dangos.ce.util.R;
import com.dangos.ce.vo.BrandPageVO;
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
    public R<IPage<BrandPageVO>> getPage(Page<Brand> page, BrandPageQueryDTO brandPageQueryDTO) {
        return R.ok(brandService.listBrand(page, brandPageQueryDTO));
    }

    /**
     * Get brand by ID
     *
     * @param id brand ID
     * @return R<Product>
     */
    @GetMapping("/{id}")
    public R<BrandPageVO> selectById(@PathVariable("id") Long id) {
        return R.ok(brandService.selectById(id));
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
     * Delete multiple brands, logical delete
     *
     * @param brandBatchQueryDTO brand batch query DTO object
     * @return R
     */
    @DeleteMapping("/batchDelete")
    public R batchDelete(@RequestBody BrandBatchQueryDTO brandBatchQueryDTO) {
        return R.ok(brandService.removeByIds(brandBatchQueryDTO.getBrandIds()));
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
