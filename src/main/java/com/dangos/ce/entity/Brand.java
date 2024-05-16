package com.dangos.ce.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.time.Year;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@TableName(value = "brand")
public class Brand {

    /**
     * Brand ID 品牌ID
     */
    @TableId(type = IdType.ASSIGN_ID)
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
