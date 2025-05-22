package com.wenxige.bg.dto;

import lombok.Data;

@Data
public class CategoryCreateOrUpdateDTO {

    /**
     * Category ID 類別ID
     */
    private Long id;

    /**
     * Brand ID 品牌ID
     */
    private Long brandId;

    /**
     * Category Name 類別名稱
     */
    private String categoryName;

    /**
     * Category Description 類別描述
     */
    private String categoryDescription;
}
