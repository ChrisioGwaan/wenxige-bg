package com.dangos.ce.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@TableName(value = "product")
public class Product {

    /**
     * Product ID 產品ID
     */
    @TableId(type = IdType.ASSIGN_ID)
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

    /**
     * Create user 創建的用戶名
     */
    private String createUser;

    /**
     * Modified user 修改的用戶名
     */
    private String modifiedUser;

    /**
     * Create time 創建時間
     */
    private LocalDateTime createTime;

    /**
     * Modified time 修改時間
     */
    private LocalDateTime modifiedTime;

    /**
     * Lock status 禁用狀態 0-啟用 1-禁用
     */
    private Character isLock;

    /**
     * Deletion status 刪除狀態 0-正常 1-已刪除
     */
    @TableLogic
    private Character isDel;

}
