package cn.xvkang.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.xvkang.dao.SysPermissionMapperCustom;
import cn.xvkang.dao.SysUserMapper;
import cn.xvkang.pojo.SysPermission;
import cn.xvkang.pojo.SysUser;

/**
 * 
 * <p>
 * Title: SysServiceImpl
 * </p>
 * <p>
 * Description:认证和授权的服务接口
 * </p>
 * 
 * @date 2015-3-23上午11:31:43
 * @version 1.0
 */
@Service
public class SysService {

	@Autowired
	private SysUserMapper sysUserMapper;

	@Autowired
	private SysPermissionMapperCustom sysPermissionMapperCustom;

	// 根据用户账号查询用户信息
	public SysUser findSysUserByUserCode(String userCode) throws Exception {

		List<SysUser> list = sysUserMapper.selectByUserCode(userCode);

		if (list != null && list.size() == 1) {
			return list.get(0);
		}

		return null;
	}

	public List<SysPermission> findMenuListByUserId(String userid) throws Exception {

		return sysPermissionMapperCustom.findMenuListByUserId(userid);
	}

	public List<SysPermission> findPermissionListByUserId(String userid) throws Exception {

		return sysPermissionMapperCustom.findPermissionListByUserId(userid);
	}

}
