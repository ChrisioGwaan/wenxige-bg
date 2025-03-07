package com.wenxige.bg.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wenxige.bg.dto.BrandBatchQueryDTO;
import com.wenxige.bg.dto.BrandCreateOrUpdateDTO;
import com.wenxige.bg.dto.BrandPageQueryDTO;
import com.wenxige.bg.entity.Brand;
import com.wenxige.bg.service.BrandService;
import com.wenxige.bg.util.R;
import com.wenxige.bg.vo.BrandPageVO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

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
    public R dropDownList(@RequestParam(value = "args", required = false) String args) {
        return R.ok(brandService.dropDownList(args));
    }

}
