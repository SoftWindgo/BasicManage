package com.luotianyi.t06.entity;

import java.io.Serializable;
import java.util.List;

@SuppressWarnings("serial")
public class Roles implements Serializable {

	private int rolesId;
	private String rolesName;
	private List<Permission> permissions;
	private List<Resources> resources;

	public Roles() {
		super();
	}

	public Roles(int rolesId, String rolesName) {
		super();
		this.rolesId = rolesId;
		this.rolesName = rolesName;
	}

	public void setRolesId(int rolesId) {
		this.rolesId = rolesId;
	}

	public int getRolesId() {
		return this.rolesId;
	}

	public void setRolesName(String rolesName) {
		this.rolesName = rolesName;
	}

	public String getRolesName() {
		return this.rolesName;
	}

	public List<Permission> getPermissions() {
		return permissions;
	}

	public void setPermissions(List<Permission> permissions) {
		this.permissions = permissions;
	}

	public List<Resources> getResources() {
		return resources;
	}

	public void setResources(List<Resources> resources) {
		this.resources = resources;
	}

	@Override
	public String toString() {
		return "Roles [rolesId=" + rolesId + ", rolesName=" + rolesName + ", permissions=" + permissions + "]";
	}

}
