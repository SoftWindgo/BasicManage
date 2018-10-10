package com.luotianyi.t06.service.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luotianyi.t06.entity.Users;
import com.luotianyi.t06.bean.ResponseBean;
import com.luotianyi.t06.dao.UsersMapper;
import com.luotianyi.t06.service.UsersService;

@Service
public class UsersServiceImpl implements UsersService {
	@Autowired
	UsersMapper usersMapper;
	@Autowired
	DataSource dataSource;

	public ResponseBean insertByUsers(Users users) {
		String sql = "select users_id from users order by users_id desc limit 1";
		ResultSet resultSet;
		try {
			resultSet = dataSource.getConnection().prepareStatement(sql).executeQuery();
			resultSet.next();
			int i = resultSet.getInt(1);
			users.setUsersId(i + 1);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ResponseBean.getResponseBean(200, "添加成功", usersMapper.insertByUsers(users));
	}

	public ResponseBean deleteById(int usersId) {
		return ResponseBean.getResponseBean(200, "删除成功", usersMapper.deleteById(usersId));
	}

	public ResponseBean updateByUsers(Users users) {
	
		return ResponseBean.getResponseBean(200, "更新成功", usersMapper.updateByUsers(users));
	}

	public ResponseBean selectOne(int usersId) {
		return ResponseBean.getResponseBean(200, "", usersMapper.selectOne(usersId));
	}

	public ResponseBean selectAll() {
		return ResponseBean.getResponseBean(200, "", usersMapper.selectAll());
	}
}
