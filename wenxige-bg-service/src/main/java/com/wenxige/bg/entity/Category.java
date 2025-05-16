package com.wenxige.bg.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@TableName(value = "category")
public class Category {

    /**
     * Category ID 類別ID
     */
    private Long id;

    /**
     * Brand ID 品牌ID
     */
    private Long brandId;

    /**
     * Category Name 類別名稱
     */
    private String categoryName;

    /**
     * Category Description 類別描述
     */
    private String categoryDescription;

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
     * Is deleted 是否刪除
     */
    private Character isDel;

}
