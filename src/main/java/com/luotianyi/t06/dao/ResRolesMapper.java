package com.luotianyi.t06.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.luotianyi.t06.entity.ResRoles;

@Repository
public interface ResRolesMapper {
	public int insertByResRoles(@Param("resRoles") ResRoles resRoles);

	public int deleteById(@Param("resId") int resId, @Param("rolesId") int rolesId);

	public int updateByResRoles(@Param("resRoles") ResRoles resRoles, @Param("retResRoles") ResRoles retResRoles);

	public ResRoles selectOne(@Param("resId") int resId, @Param("rolesId") int rolesId);

	public List<ResRoles> selectAll();

}
