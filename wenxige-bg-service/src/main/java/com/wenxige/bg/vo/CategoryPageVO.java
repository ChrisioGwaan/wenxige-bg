package com.wenxige.bg.vo;

import lombok.Data;

@Data
public class CategoryPageVO {

    /**
     * 類別ID
     */
    private String id;

    /**
     * 品牌ID
     */
    private String brandId;

    /**
     * 品牌名稱（通过 JOIN 获取）
     */
    private String brandName;

    /**
     * 類別名稱
     */
    private String categoryName;

    /**
     * 類別描述
     */
    private String categoryDescription;

    /**
     * 創建時間
     */
    private String createTime;
}
