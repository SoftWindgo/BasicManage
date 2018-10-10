package com.luotianyi.t06.service;


import com.luotianyi.t06.bean.ResponseBean;
import com.luotianyi.t06.entity.RolesPermission;

public interface RolesPermissionService {

	public ResponseBean insertByRolesPermission(RolesPermission rolesPermission);

	public ResponseBean deleteById(int rolesId, int permisId);

	public ResponseBean updateByRolesPermission(RolesPermission rolesPermission,RolesPermission retRolesPermission);

	public ResponseBean selectOne(int rolesId, int permisId);

	public ResponseBean selectAll();
}
