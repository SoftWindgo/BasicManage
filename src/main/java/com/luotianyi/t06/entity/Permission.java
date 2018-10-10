package com.luotianyi.t06.entity;

import java.io.Serializable;


@SuppressWarnings("serial")
public class Permission implements Serializable {

	private int permisId;
	private String permisName;
	private String permisUrl;
	public Permission() {
		super();
	}

	public Permission (int permisId,String permisName,String permisUrl) {
		super();
		this.permisId = permisId;
		this.permisName = permisName;
		this.permisUrl = permisUrl;
	}

	public void setPermisId(int permisId) {
		this.permisId = permisId;
	}

	public int getPermisId() {
		return this.permisId;
	}

	public void setPermisName(String permisName) {
		this.permisName = permisName;
	}

	public String getPermisName() {
		return this.permisName;
	}

	public void setPermisUrl(String permisUrl) {
		this.permisUrl = permisUrl;
	}

	public String getPermisUrl() {
		return this.permisUrl;
	}

	public String toString() {
		return "Permission ["+"permisId:"+this.permisId+","+"permisName:"+this.permisName+","+"permisUrl:"+this.permisUrl+"]";
	}
}
