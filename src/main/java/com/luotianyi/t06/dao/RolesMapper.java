package com.luotianyi.t06.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.luotianyi.t06.entity.Roles;

@Repository
public interface RolesMapper{
	public int insertByRoles(@Param("roles") Roles roles);

	public int deleteById(@Param("rolesId") int rolesId);

	public int updateByRoles(@Param("roles") Roles roles);

	public Roles selectOne(@Param("rolesId") int rolesId);

	public Roles selectByUserId(@Param("usersId") int userId);
	
	public List<Roles> selectAll();

}
