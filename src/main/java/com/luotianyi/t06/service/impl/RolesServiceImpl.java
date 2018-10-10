package com.luotianyi.t06.service.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luotianyi.t06.entity.Roles;
import com.luotianyi.t06.bean.ResponseBean;
import com.luotianyi.t06.dao.RolesMapper;
import com.luotianyi.t06.service.RolesService;

@Service
public class RolesServiceImpl implements RolesService {
	@Autowired
	RolesMapper rolesMapper;
	@Autowired
	DataSource dataSource;

	public ResponseBean insertByRoles(Roles roles) {
		String sql = "select roles_id from roles order by roles_id desc limit 1";
		ResultSet resultSet;
		try {
			resultSet = dataSource.getConnection().prepareStatement(sql).executeQuery();
			resultSet.next();
			int i = resultSet.getInt(1);
			roles.setRolesId(i + 1);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ResponseBean.getResponseBean(200, "添加成功", rolesMapper.insertByRoles(roles));
	}

	public ResponseBean deleteById(int rolesId) {
		return ResponseBean.getResponseBean(200, "删除成功", rolesMapper.deleteById(rolesId));
	}

	public ResponseBean updateByRoles(Roles roles) {
		return ResponseBean.getResponseBean(200, "更新成功", rolesMapper.updateByRoles(roles));
	}

	public ResponseBean selectOne(int rolesId) {
		return ResponseBean.getResponseBean(200, "", rolesMapper.selectOne(rolesId));
	}

	public ResponseBean selectAll() {
		return ResponseBean.getResponseBean(200, "", rolesMapper.selectAll());
	}
}
