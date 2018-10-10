package com.luotianyi.t06.entity;

import java.io.Serializable;


@SuppressWarnings("serial")
public class Resources implements Serializable {

	private int resId;
	private String resName;
	private String resUrl;
	public Resources() {
		super();
	}

	public Resources (int resId,String resName,String resUrl) {
		super();
		this.resId = resId;
		this.resName = resName;
		this.resUrl = resUrl;
	}

	public void setResId(int resId) {
		this.resId = resId;
	}

	public int getResId() {
		return this.resId;
	}

	public void setResName(String resName) {
		this.resName = resName;
	}

	public String getResName() {
		return this.resName;
	}

	public void setResUrl(String resUrl) {
		this.resUrl = resUrl;
	}

	public String getResUrl() {
		return this.resUrl;
	}

	public String toString() {
		return "Resources ["+"resId:"+this.resId+","+"resName:"+this.resName+","+"resUrl:"+this.resUrl+"]";
	}
}
