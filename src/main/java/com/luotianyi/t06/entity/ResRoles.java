package com.luotianyi.t06.entity;

import java.io.Serializable;

@SuppressWarnings("serial")
public class ResRoles implements Serializable {

	private int resId;
	private int rolesId;
	private Resources resources;
	private Roles roles;

	public ResRoles() {
		super();
	}

	public ResRoles(int resId, int rolesId) {
		super();
		this.resId = resId;
		this.rolesId = rolesId;
	}

	public void setResId(int resId) {
		this.resId = resId;
	}

	public int getResId() {
		return this.resId;
	}

	public void setRolesId(int rolesId) {
		this.rolesId = rolesId;
	}

	public int getRolesId() {
		return this.rolesId;
	}

	public Resources getResources() {
		return resources;
	}

	public void setResources(Resources resources) {
		this.resources = resources;
	}

	public Roles getRoles() {
		return roles;
	}

	public void setRoles(Roles roles) {
		this.roles = roles;
	}

	public String toString() {
		return "ResRoles [" + "resId:" + this.resId + "," + "rolesId:" + this.rolesId + "]";
	}
}
