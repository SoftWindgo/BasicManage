package com.luotianyi.t06.shiro.realm;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.ClassPathResource;

import com.luotianyi.t06.dao.PermissionMapper;
import com.luotianyi.t06.dao.UsersMapper;
import com.luotianyi.t06.entity.Permission;
import com.luotianyi.t06.entity.Users;

@PropertySource(value= {"classpath:users.properties"})
public class LoginRealm extends AuthorizingRealm {


	@Autowired
	private PermissionMapper permissionMapper;

	@Override
	public boolean supports(AuthenticationToken token) {
		return true;
	}

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
		Set<String> set = new HashSet<>();
		List<Permission> permissions = permissionMapper.selectAll();
		for (Permission permission : permissions) {
			set.add(permission.getPermisName());
		}
		simpleAuthorizationInfo.addStringPermissions(set);
		return simpleAuthorizationInfo;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		ClassPathResource pathResource = new ClassPathResource("users.properties");
		Properties properties = new Properties();
		
		try {
			properties.load(new FileInputStream(pathResource.getFile()));
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(properties);
		Users users = new Users(10,properties.getProperty("shirousername") , properties.getProperty("shiropassword"));
		token = users;
		SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(users.getUsername(),
				users.getPassword(), super.getName());
		simpleAuthenticationInfo.setCredentialsSalt(ByteSource.Util.bytes("luotianyi" + users.getUsername()));
		return simpleAuthenticationInfo;
	}
}
