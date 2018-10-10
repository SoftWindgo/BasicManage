package com.luotianyi.t06.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.luotianyi.t06.entity.RolesPermission;

@Repository
public interface RolesPermissionMapper{
	public int insertByRolesPermission(@Param("rolesPermission") RolesPermission rolesPermission);

	public int deleteById(@Param("rolesId") int rolesId, @Param("permisId") int permisId);

	public int updateByRolesPermission(@Param("rolesPermission") RolesPermission rolesPermission,@Param("retRolesPermission") RolesPermission retRolesPermission);

	public RolesPermission selectOne(@Param("rolesId") int rolesId, @Param("permisId") int permisId);

	public List<RolesPermission> selectAll();

}
