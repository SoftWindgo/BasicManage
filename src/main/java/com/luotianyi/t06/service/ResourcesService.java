package com.luotianyi.t06.service;


import com.luotianyi.t06.bean.ResponseBean;
import com.luotianyi.t06.entity.Resources;

public interface ResourcesService {

	public ResponseBean insertByResources(Resources resources);

	public ResponseBean deleteById(int resId);

	public ResponseBean updateByResources(Resources resources);

	public ResponseBean selectOne(int resId);

	public ResponseBean selectByUsersId(int userId);

	public ResponseBean selectAll();
}
