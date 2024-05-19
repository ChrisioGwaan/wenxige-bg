package com.dangos.ce.vo;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class ProductPageVO {

    /**
     * Product ID 產品ID
     */
    private String id;

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
    private String manufactureDateStr;

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

    /**
     * Create time 創建時間
     */
    private String createTime;

    /**
     * Modified time 修改時間
     */
    private String modifiedTime;

    /**
     * Lock status 禁用狀態 0-啟用 1-禁用
     */
    private Character isLock;

}
