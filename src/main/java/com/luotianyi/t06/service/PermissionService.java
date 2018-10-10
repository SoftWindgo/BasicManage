package com.luotianyi.t06.service;


import com.luotianyi.t06.bean.ResponseBean;
import com.luotianyi.t06.entity.Permission;

public interface PermissionService {

	public ResponseBean insertByPermission(Permission permission);

	public ResponseBean deleteById(int permisId);

	public ResponseBean updateByPermission(Permission permission);

	public ResponseBean selectOne(int permisId);

	public ResponseBean selectAll();
}
