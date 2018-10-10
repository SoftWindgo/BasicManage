package com.luotianyi.t06.service.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luotianyi.t06.bean.ResponseBean;
import com.luotianyi.t06.dao.PermissionMapper;
import com.luotianyi.t06.entity.Permission;
import com.luotianyi.t06.service.PermissionService;

@Service
public class PermissionServiceImpl implements PermissionService {
	@Autowired
	PermissionMapper permissionMapper;
	@Autowired
	DataSource dataSource;

	public ResponseBean insertByPermission(Permission permission) {
		String sql = "select permis_id from permission order by permis_id desc limit 1";
		ResultSet resultSet;
		try {
			resultSet = dataSource.getConnection().prepareStatement(sql).executeQuery();
			resultSet.next();
			int i = resultSet.getInt(1);
			permission.setPermisId(i+1);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ResponseBean.getResponseBean(200, "添加成功", permissionMapper.insertByPermission(permission));
	}

	public ResponseBean deleteById(int permisId) {
		return ResponseBean.getResponseBean(200, "删除成功", permissionMapper.deleteById(permisId));
	}

	public ResponseBean updateByPermission(Permission permission) {
		return ResponseBean.getResponseBean(200, "更新成功", permissionMapper.updateByPermission(permission));
	}

	public ResponseBean selectOne(int permisId) {
		return ResponseBean.getResponseBean(200, "", permissionMapper.selectOne(permisId));
	}

	public ResponseBean selectAll() {
		return ResponseBean.getResponseBean(200, "", permissionMapper.selectAll());
	}

}
