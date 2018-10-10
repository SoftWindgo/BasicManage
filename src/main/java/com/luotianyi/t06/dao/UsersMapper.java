package com.luotianyi.t06.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.luotianyi.t06.entity.Users;

@Repository
public interface UsersMapper {
	public int insertByUsers(@Param("users") Users users);

	public int deleteById(@Param("usersId") int usersId);

	public int updateByUsers(@Param("users") Users users);

	public Users selectOne(@Param("usersId") int usersId);

	public Users selectByUsername(@Param("username") String username);

	public List<Users> selectAll();

}
