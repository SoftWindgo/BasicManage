package com.luotianyi.t06.service;


import com.luotianyi.t06.bean.ResponseBean;
import com.luotianyi.t06.entity.UsersRole;

public interface UsersRoleService {

	public ResponseBean insertByUsersRole(UsersRole usersRole);

	public ResponseBean deleteById(int userId, int rolesId);

	public ResponseBean updateByUsersRole(UsersRole usersRole,UsersRole usersRole1);

	public ResponseBean selectOne(int userId, int rolesId);

	public ResponseBean selectAll();
}
