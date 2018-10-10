package com.luotianyi.t06.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.luotianyi.t06.entity.UsersRole;

@Repository
public interface UsersRoleMapper {
	public int insertByUsersRole(@Param("usersRole") UsersRole usersRole);

	public int deleteById(@Param("userId") int userId, @Param("rolesId") int rolesId);

	public int updateByUsersRole(@Param("usersRole") UsersRole usersRole, @Param("retUsersRole") UsersRole usersRole2);

	public UsersRole selectOne(@Param("userId") int userId, @Param("rolesId") int rolesId);

	public List<UsersRole> selectAll();

}
