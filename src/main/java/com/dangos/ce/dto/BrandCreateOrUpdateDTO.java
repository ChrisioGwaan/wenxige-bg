package com.dangos.ce.dto;

import lombok.Data;

import java.time.Year;

@Data
public class BrandCreateOrUpdateDTO {

    /**
     * Brand ID 品牌ID
     */
    private Long id;

    /**
     * Brand name 品牌名稱
     */
    private String brandName;

    /**
     * Origin year of the product 品牌產地
     */
    private Year originYear;

    /**
     * Comment 備註
     */
    private String comment;

}
