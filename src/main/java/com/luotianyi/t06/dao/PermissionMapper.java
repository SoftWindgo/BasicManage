package com.luotianyi.t06.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.luotianyi.t06.entity.Permission;

@Repository
public interface PermissionMapper{
	public int insertByPermission(@Param("permission") Permission permission);

	public int deleteById(@Param("permisId") int permisId);

	public int updateByPermission(@Param("permission") Permission permission);

	public Permission selectOne(@Param("permisId") int permisId);

	public List<String> selectPermisByUserId(@Param("usersId") int usersId);

	public List<Permission> selectAll();

}
