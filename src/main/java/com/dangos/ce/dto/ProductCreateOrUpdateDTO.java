package com.dangos.ce.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class ProductCreateOrUpdateDTO {

    /**
     * Product ID 產品ID
     */
    private Long id;

    /**
     * Type ID of the specific brand 產品所在品牌的種類id
     */
    private Long brandTypeId;

    /**
     * Name of the Product 產品名稱
     */
    private String productName;

    /**
     * Specification of the Product 產品規格
     */
    private String specification;

    /**
     * Manufacture date of the Product 產品生產日期
     */
    private LocalDate manufactureDate;

    /**
     * If the manufacture date has a specific day 生產日期是否精確到天
     */
    private Character hasSpecificDay;

    /**
     * National uniform retail price 全國統一零售價
     */
    private BigDecimal retailPrice;

    /**
     * Sell price (Take retail price if sell price is not specifically set) 銷售價格（如無特殊情況，取統一零售價）
     */
    private BigDecimal sellPrice;

    /**
     * Unit type of the Product 單位類型
     */
    private Integer unitType;

    /**
     * Current quantity of the Product 產品現有數量
     */
    private Integer currentQuantity;

    /**
     * Comment 備註
     */
    private String comment;

}
