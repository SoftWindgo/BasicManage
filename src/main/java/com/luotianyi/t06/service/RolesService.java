package com.luotianyi.t06.service;

import com.luotianyi.t06.bean.ResponseBean;
import com.luotianyi.t06.entity.Roles;

public interface RolesService {

	public ResponseBean insertByRoles(Roles roles);

	public ResponseBean deleteById(int rolesId);

	public ResponseBean updateByRoles(Roles roles);

	public ResponseBean selectOne(int rolesId);

	public ResponseBean selectAll();
}
