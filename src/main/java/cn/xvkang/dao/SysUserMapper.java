package cn.xvkang.dao;


import java.util.List;

import cn.xvkang.pojo.SysUser;

public interface SysUserMapper {

    List<SysUser> selectByUserCode(String userCode);

   
}