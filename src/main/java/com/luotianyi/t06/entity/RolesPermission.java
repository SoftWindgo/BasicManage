package com.luotianyi.t06.entity;

import java.io.Serializable;

@SuppressWarnings("serial")
public class RolesPermission implements Serializable {

	private int rolesId;
	private int permisId;
	private Roles roles;
	private Permission permission;

	public RolesPermission() {
		super();
	}

	public RolesPermission(int rolesId, int permisId) {
		super();
		this.rolesId = rolesId;
		this.permisId = permisId;
	}

	public void setRolesId(int rolesId) {
		this.rolesId = rolesId;
	}

	public int getRolesId() {
		return this.rolesId;
	}

	public void setPermisId(int permisId) {
		this.permisId = permisId;
	}

	public int getPermisId() {
		return this.permisId;
	}

	public Roles getRoles() {
		return roles;
	}

	public void setRoles(Roles roles) {
		this.roles = roles;
	}

	public Permission getPermission() {
		return permission;
	}

	public void setPermission(Permission permission) {
		this.permission = permission;
	}

	public String toString() {
		return "RolesPermission [" + "rolesId:" + this.rolesId + "," + "permisId:" + this.permisId + "]";
	}
}
