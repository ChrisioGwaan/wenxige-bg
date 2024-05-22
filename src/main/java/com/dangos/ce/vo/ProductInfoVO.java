package com.dangos.ce.vo;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class ProductInfoVO {

    private String id;

    private String brandId;

    private String brandName;

    private String brandTypeId;

    private String brandTypeName;

    private String productName;

    private String specification;

    private LocalDate manufactureDate;

    private String manufactureDateStr;

    private Character hasSpecificDay;

    private BigDecimal retailPrice;

    private BigDecimal sellPrice;

    private Integer unitType;

    private Integer currentQuantity;

    private String comment;

    private String createTime;

    private String modifiedTime;

    private Character isLock;

}
