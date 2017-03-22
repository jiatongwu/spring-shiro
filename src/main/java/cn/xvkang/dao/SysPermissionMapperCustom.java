package cn.xvkang.dao;

import java.util.List;

import cn.xvkang.pojo.SysPermission;

/**
 * 
 * <p>Title: SysPermissionMapperCustom</p>
 * <p>Description: 权限mapper</p>
 * @date	2015-3-23下午2:55:28
 * @version 1.0
 */
public interface SysPermissionMapperCustom {
	
	//根据用户id查询菜单
	public List<SysPermission> findMenuListByUserId(String userid)throws Exception;
	//根据用户id查询权限url
	public List<SysPermission> findPermissionListByUserId(String userid)throws Exception;

}
