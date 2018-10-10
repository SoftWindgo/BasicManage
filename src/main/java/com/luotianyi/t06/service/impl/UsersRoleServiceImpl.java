package com.luotianyi.t06.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luotianyi.t06.bean.ResponseBean;
import com.luotianyi.t06.dao.UsersRoleMapper;
import com.luotianyi.t06.entity.UsersRole;
import com.luotianyi.t06.service.UsersRoleService;

@Service
public class UsersRoleServiceImpl implements UsersRoleService {
	@Autowired
	UsersRoleMapper usersRoleMapper;

	public ResponseBean insertByUsersRole(UsersRole usersRole) {
		return ResponseBean.getResponseBean(200, "添加成功", usersRoleMapper.insertByUsersRole(usersRole));
	}

	public ResponseBean deleteById(int userId, int rolesId) {
		return ResponseBean.getResponseBean(200, "删除成功", usersRoleMapper.deleteById(userId, rolesId));
	}

	public ResponseBean updateByUsersRole(UsersRole usersRole,UsersRole usersRole1) {
		return ResponseBean.getResponseBean(200, "更新成功", usersRoleMapper.updateByUsersRole(usersRole,usersRole1));
	}

	public ResponseBean selectOne(int userId, int rolesId) {
		return ResponseBean.getResponseBean(200, "", usersRoleMapper.selectOne(userId, rolesId));
	}

	public ResponseBean selectAll() {
		return ResponseBean.getResponseBean(200, "", usersRoleMapper.selectAll());
	}

}
