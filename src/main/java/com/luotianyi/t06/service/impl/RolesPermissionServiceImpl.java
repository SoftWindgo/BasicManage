package com.luotianyi.t06.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luotianyi.t06.bean.ResponseBean;
import com.luotianyi.t06.dao.RolesPermissionMapper;
import com.luotianyi.t06.entity.RolesPermission;
import com.luotianyi.t06.service.RolesPermissionService;

@Service
public class RolesPermissionServiceImpl implements RolesPermissionService {
	@Autowired
	RolesPermissionMapper rolesPermissionMapper;

	public ResponseBean insertByRolesPermission(RolesPermission rolesPermission) {
		return ResponseBean.getResponseBean(200, "��ӳɹ�",
				rolesPermissionMapper.insertByRolesPermission(rolesPermission));
	}

	public ResponseBean deleteById(int rolesId, int permisId) {
		return ResponseBean.getResponseBean(200, "ɾ���ɹ�", rolesPermissionMapper.deleteById(rolesId, permisId));
	}

	public ResponseBean updateByRolesPermission(RolesPermission rolesPermission, RolesPermission retRolesPermission) {
		return ResponseBean.getResponseBean(200, "���³ɹ�",
				rolesPermissionMapper.updateByRolesPermission(rolesPermission, retRolesPermission));
	}

	public ResponseBean selectOne(int rolesId, int permisId) {
		return ResponseBean.getResponseBean(200, "", rolesPermissionMapper.selectOne(rolesId, permisId));
	}

	public ResponseBean selectAll() {
		return ResponseBean.getResponseBean(200, "", rolesPermissionMapper.selectAll());
	}
}
