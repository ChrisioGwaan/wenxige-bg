package com.wenxige.bg.service;

import com.wenxige.bg.entity.SysUser;
import com.wenxige.bg.util.R;

public interface SysUserService {

    SysUser findByUsername(String username);

    R createNew(SysUser sysUser);

}
