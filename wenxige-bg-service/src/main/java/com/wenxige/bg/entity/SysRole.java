package com.wenxige.bg.entity;

import com.baomidou.mybatisplus.annotation.TableLogic;
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
@TableName(value = "sys_role")
public class SysRole {

    /**
     * Role ID 角色ID
     */
    private Long id;

    /**
     * Role Name 角色名稱
     */
    private String roleName;

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
    @TableLogic
    private Character isDel;

}
