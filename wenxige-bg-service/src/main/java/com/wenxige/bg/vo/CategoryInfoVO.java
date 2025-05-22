package com.wenxige.bg.vo;

import lombok.Data;

@Data
public class CategoryInfoVO {

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
     * 創建人
     */
    private String createUser;

    /**
     * 修改人
     */
    private String modifiedUser;

    /**
     * 創建時間
     */
    private String createTime;

    /**
     * 修改時間
     */
    private String modifiedTime;

    /**
     * 是否刪除
     */
    private String isDel;
}
