package com.luotianyi.t06.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.luotianyi.t06.entity.Resources;

@Repository
public interface ResourcesMapper {
	public int insertByResources(@Param("resources") Resources resources);

	public int deleteById(@Param("resId") int resId);

	public int updateByResources(@Param("resources") Resources resources);

	public Resources selectOne(@Param("resId") int resId);

	public List<Resources> selectAll();

	public List<Resources> selectByUserId(@Param("userId") int userId);

}
