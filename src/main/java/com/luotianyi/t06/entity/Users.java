package com.luotianyi.t06.entity;

import java.io.Serializable;

import org.apache.shiro.authc.AuthenticationToken;

@SuppressWarnings("serial")
public class Users implements Serializable, AuthenticationToken {

	private int usersId;
	private String username;
	private String password;

	public Users() {
		super();
	}

	public Users(int usersId, String username, String password) {
		super();
		this.usersId = usersId;
		this.username = username;
		this.password = password;
	}

	public void setUsersId(int usersId) {
		this.usersId = usersId;
	}

	public int getUsersId() {
		return this.usersId;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUsername() {
		return this.username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPassword() {
		return this.password;
	}

	public String toString() {
		return "Users [" + "usersId:" + this.usersId + "," + "username:" + this.username + "," + "password:"
				+ this.password + "]";
	}

	@Override
	public Object getPrincipal() {
		return getUsername();
	}

	@Override
	public Object getCredentials() {
		return getPassword();
	}

	public void setPrincipal() {
	}

	public void setCredentials() {
	}

}
