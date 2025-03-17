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
@TableName(value = "sys_department")
public class SysDepartment {

    private Long id;

    private Long parentDepartmentId;

    private String departmentName;

    private String description;

    private String telNumber;

    private String email;

    private String location;

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

    private Integer status;

    /**
     * Deletion status 刪除狀態 0-正常 1-已刪除
     */
    @TableLogic
    private Character isDel;

}
