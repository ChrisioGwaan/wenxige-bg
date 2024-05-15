package com.dangos.ce.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.dangos.ce.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@TableName(value = "sys_user")
public class SysUser implements UserDetails {

    @TableId(type = IdType.ASSIGN_UUID)
    private String id;

    private String username;

    private String firstname;

    private String lastname;

    private String password;

    private String email;

    @TableField(value = "role")
    private Role role;

    private String createUser;

    private String modifiedUser;

    private LocalDateTime createTime;

    private LocalDateTime modifiedTime;

    @TableLogic
    private Character isDel;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role.name()));
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
