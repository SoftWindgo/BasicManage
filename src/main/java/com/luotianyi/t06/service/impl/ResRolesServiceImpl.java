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
		return ResponseBean.getResponseBean(200, "添加成功", resRolesMapper.insertByResRoles(resRoles));
	}

	public ResponseBean deleteById(int resId, int rolesId) {
		return ResponseBean.getResponseBean(200, "删除成功", resRolesMapper.deleteById(resId, rolesId));
	}

	public ResponseBean updateByResRoles(ResRoles resRoles, ResRoles retResRoles) {
		return ResponseBean.getResponseBean(200, "更新成功", resRolesMapper.updateByResRoles(resRoles, retResRoles));
	}

	public ResponseBean selectOne(int resId, int rolesId) {
		return ResponseBean.getResponseBean(200, "", resRolesMapper.selectOne(resId, rolesId));
	}

	public ResponseBean selectAll() {
		return ResponseBean.getResponseBean(200, "", resRolesMapper.selectAll());
	}
}
