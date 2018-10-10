package com.luotianyi.t06.controller;

import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luotianyi.t06.bean.ResponseBean;
import com.luotianyi.t06.entity.UsersRole;
import com.luotianyi.t06.service.UsersRoleService;

@RestController
@RequestMapping("UsersRole")
public class UsersRoleController {
	@Autowired
	UsersRoleService usersRoleService;

	@GetMapping
	public ResponseBean selectAll() {
		return usersRoleService.selectAll();
	}

	@GetMapping("/{first}/{second}")
	public ResponseBean selectOne(@PathVariable("first") int userId, @PathVariable("second") int rolesId) {
		return usersRoleService.selectOne(userId, rolesId);
	}

	@PostMapping
	public ResponseBean insert(UsersRole usersRole) {
		return usersRoleService.insertByUsersRole(usersRole);
	}

	@DeleteMapping("/{first}/{second}")
	public ResponseBean delete(@PathVariable("first") int userId, @PathVariable("second") int rolesId) {
		return usersRoleService.deleteById(userId, rolesId);
	}

	@PutMapping
	public ResponseBean update(UsersRole usersRole,int firstId,int secondId) {
		return usersRoleService.updateByUsersRole(new UsersRole(firstId, secondId),usersRole);
	}
}
