package com.wenxige.bg.dto;

import lombok.Data;

@Data
public class CategoryPageQueryDTO {

    /**
     * 類別名稱（模糊查詢）
     */
    private String categoryName;

    /**
     * 品牌ID（篩選條件）
     */
    private Long brandId;
}
