package com.wenxige.bg.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.wenxige.bg.dto.CategoryCreateOrUpdateDTO;
import com.wenxige.bg.dto.CategoryPageQueryDTO;
import com.wenxige.bg.entity.Category;
import com.wenxige.bg.util.R;
import com.wenxige.bg.vo.CategoryInfoVO;
import com.wenxige.bg.vo.CategoryPageVO;

import java.util.List;

public interface CategoryService extends IService<Category> {

    /**
     * 分页查询分类
     */
    IPage<CategoryPageVO> listCategory(Page<Category> page, CategoryPageQueryDTO categoryPageQueryDTO);

    /**
     * 根据 ID 查询分类详情
     */
    CategoryInfoVO findById(Long id);

    /**
     * 创建新分类
     */
    R createNew(CategoryCreateOrUpdateDTO categoryCreateOrUpdateDTO);

    /**
     * 更新分类
     */
    R updateCategory(CategoryCreateOrUpdateDTO categoryCreateOrUpdateDTO);

    /**
     * 获取下拉选项（支持模糊查询）
     */
    List<CategoryPageVO> dropdownList(String args);
}
