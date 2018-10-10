package com.luotianyi.t06.entity;

import java.io.Serializable;

@SuppressWarnings("serial")
public class UsersRole implements Serializable {

	private int userId;
	private int rolesId;
	private Users users;
	private Roles roles;

	public UsersRole() {
		super();
	}

	public UsersRole(int userId, int rolesId) {
		super();
		this.userId = userId;
		this.rolesId = rolesId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getUserId() {
		return this.userId;
	}

	public void setRolesId(int rolesId) {
		this.rolesId = rolesId;
	}

	public int getRolesId() {
		return this.rolesId;
	}

	public Users getUsers() {
		return users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	public Roles getRoles() {
		return roles;
	}

	public void setRoles(Roles roles) {
		this.roles = roles;
	}

	public String toString() {
		return "UsersRole [" + "userId:" + this.userId + "," + "rolesId:" + this.rolesId + "]";
	}
}
