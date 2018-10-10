package com.luotianyi.t06.service;

import com.luotianyi.t06.bean.ResponseBean;
import com.luotianyi.t06.entity.ResRoles;

public interface ResRolesService {

	public ResponseBean insertByResRoles(ResRoles resRoles);

	public ResponseBean deleteById(int resId, int rolesId);

	public ResponseBean updateByResRoles(ResRoles resRoles,ResRoles retResRoles);

	public ResponseBean selectOne(int resId, int rolesId);

	public ResponseBean selectAll();
}
