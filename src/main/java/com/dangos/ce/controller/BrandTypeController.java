package com.dangos.ce.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dangos.ce.dto.BrandTypeBatchQueryDTO;
import com.dangos.ce.dto.BrandTypeCreateOrUpdateDTO;
import com.dangos.ce.dto.BrandTypePageQueryDTO;
import com.dangos.ce.entity.BrandType;
import com.dangos.ce.service.BrandTypeService;
import com.dangos.ce.util.R;
import com.dangos.ce.vo.BrandTypePageVO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/brandType")
public class BrandTypeController {
    
    private final BrandTypeService brandTypeService;

    /**
     * Get brand type list in pagination
     *
     * @param page page info
     * @return IPage<BrandType>
     */
    @GetMapping("/page")
    public R<IPage<BrandTypePageVO>> getPage(Page<BrandType> page, BrandTypePageQueryDTO brandTypePageQueryDTO) {
        return R.ok(brandTypeService.listBrandType(page, brandTypePageQueryDTO));
    }

    /**
     * Get brand type by ID
     *
     * @param id brand type ID
     * @return R<BrandType>
     */
    @GetMapping("/{id}")
    public R<BrandTypePageVO> selectById(@PathVariable("id") Long id) {
        return R.ok(brandTypeService.findById(id));
    }

    /**
     * Create new brand type
     *
     * @param brandTypeCreateOrUpdateDTO brand type create or update DTO object
     * @return R
     */
    @PostMapping("/create")
    public R createNew(@RequestBody BrandTypeCreateOrUpdateDTO brandTypeCreateOrUpdateDTO) {
        return brandTypeService.createNew(brandTypeCreateOrUpdateDTO);
    }

    /**
     * Update brand type
     *
     * @param brandTypeCreateOrUpdateDTO brand type create or update DTO object
     * @return R
     */
    @PutMapping("/update")
    public R updateProduct(@RequestBody BrandTypeCreateOrUpdateDTO brandTypeCreateOrUpdateDTO) {
        return brandTypeService.updateBrandType(brandTypeCreateOrUpdateDTO);
    }

    /**
     * Delete brand type, logical delete
     *
     * @param id brand type ID
     * @return R
     */
    @DeleteMapping("/{id}")
    public R deleteBrandType(@PathVariable("id") Long id) {
        return R.ok(brandTypeService.removeById(id));
    }

    /**
     * Delete multiple brand types, logical delete
     *
     * @param brandTypeBatchQueryDTO brand type batch query DTO object
     * @return R
     */
    @DeleteMapping("/batchDelete")
    public R batchDeleteBrandType(@RequestBody BrandTypeBatchQueryDTO brandTypeBatchQueryDTO) {
        return R.ok(brandTypeService.removeByIds(brandTypeBatchQueryDTO.getBrandTypeIds()));
    }

    /**
     * dropdown list
     *
     * @return R<List<BrandType>>
     */
    @GetMapping("/dropdown")
    public R dropdownList(@RequestParam(value = "args", required = false) String args) {
        return R.ok(brandTypeService.dropdownList(args));
    }

}
