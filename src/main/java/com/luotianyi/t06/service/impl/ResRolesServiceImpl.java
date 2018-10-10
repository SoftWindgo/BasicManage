package com.luotianyi.t06.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luotianyi.t06.bean.ResponseBean;
import com.luotianyi.t06.dao.ResRolesMapper;
import com.luotianyi.t06.entity.ResRoles;
import com.luotianyi.t06.service.ResRolesService;

@Service
public class ResRolesServiceImpl implements ResRolesService {
	@Autowired
	ResRolesMapper resRolesMapper;

	public ResponseBean insertByResRoles(ResRoles resRoles) {
		return ResponseBean.getResponseBean(200, "��ӳɹ�", resRolesMapper.insertByResRoles(resRoles));
	}

	public ResponseBean deleteById(int resId, int rolesId) {
		return ResponseBean.getResponseBean(200, "ɾ���ɹ�", resRolesMapper.deleteById(resId, rolesId));
	}

	public ResponseBean updateByResRoles(ResRoles resRoles, ResRoles retResRoles) {
		return ResponseBean.getResponseBean(200, "���³ɹ�", resRolesMapper.updateByResRoles(resRoles, retResRoles));
	}

	public ResponseBean selectOne(int resId, int rolesId) {
		return ResponseBean.getResponseBean(200, "", resRolesMapper.selectOne(resId, rolesId));
	}

	public ResponseBean selectAll() {
		return ResponseBean.getResponseBean(200, "", resRolesMapper.selectAll());
	}
}
