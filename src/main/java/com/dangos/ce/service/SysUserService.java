package com.dangos.ce.service;

import com.dangos.ce.entity.SysUser;
import com.dangos.ce.util.R;

public interface SysUserService {

    SysUser findByUsername(String username);

    R createNew(SysUser sysUser);

}
