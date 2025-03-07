package com.wenxige.bg.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wenxige.bg.entity.SysUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Optional;

@Mapper
public interface SysUserMapper extends BaseMapper<SysUser> {

    Optional<SysUser> selectByUsername(@Param("username") String username);

}
