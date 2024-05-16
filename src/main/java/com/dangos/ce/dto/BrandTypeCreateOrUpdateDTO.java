package com.dangos.ce.dto;

import lombok.Data;

@Data
public class BrandTypeCreateOrUpdateDTO {

    /**
     * Brand Type ID 品牌種類ID
     */
    private Long id;

    /**
     * Brand ID 品牌ID
     */
    private Long brandId;

    /**
     * Brand Type Name 品牌種類名稱
     */
    private String brandTypeName;

    /**
     * Comment 備註
     */
    private String comment;

}
