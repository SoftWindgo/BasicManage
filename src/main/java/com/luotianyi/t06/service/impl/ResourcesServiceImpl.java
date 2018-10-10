package com.luotianyi.t06.service.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luotianyi.t06.entity.Resources;
import com.luotianyi.t06.bean.ResponseBean;
import com.luotianyi.t06.dao.ResourcesMapper;
import com.luotianyi.t06.service.ResourcesService;

@Service
public class ResourcesServiceImpl implements ResourcesService {
	@Autowired
	ResourcesMapper resourcesMapper;
	@Autowired
	DataSource dataSource;

	public ResponseBean insertByResources(Resources resources) {
		String sql = "select res_id from resources order by res_id desc limit 1";
		ResultSet resultSet;
		try {
			resultSet = dataSource.getConnection().prepareStatement(sql).executeQuery();
			resultSet.next();
			int i = resultSet.getInt(1);
			resources.setResId(i + 1);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return ResponseBean.getResponseBean(200, "添加成功", resourcesMapper.insertByResources(resources));
	}

	public ResponseBean deleteById(int resId) {
		return ResponseBean.getResponseBean(200, "删除成功", resourcesMapper.deleteById(resId));
	}

	public ResponseBean updateByResources(Resources resources) {
		return ResponseBean.getResponseBean(200, "更新成功", resourcesMapper.updateByResources(resources));
	}

	public ResponseBean selectOne(int resId) {
		return ResponseBean.getResponseBean(200, "", resourcesMapper.selectOne(resId));
	}

	public ResponseBean selectAll() {
		return ResponseBean.getResponseBean(200, "", resourcesMapper.selectAll());
	}

	@Override
	public ResponseBean selectByUsersId(int userId) {
		List<Resources> resourceses = resourcesMapper.selectByUserId(userId);
		if (resourceses == null) {
			return ResponseBean.getResponseBean(404, "", null);
		}
		return ResponseBean.getResponseBean(200, "", resourceses);
	}
}
