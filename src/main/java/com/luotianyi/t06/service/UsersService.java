package com.luotianyi.t06.service;

import com.luotianyi.t06.bean.ResponseBean;
import com.luotianyi.t06.entity.Users;

public interface UsersService {

	public ResponseBean insertByUsers(Users users);

	public ResponseBean deleteById(int usersId);

	public ResponseBean updateByUsers(Users users);

	public ResponseBean selectOne(int usersId);

	public ResponseBean selectAll();
}
