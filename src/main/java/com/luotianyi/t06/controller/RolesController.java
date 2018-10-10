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
import com.luotianyi.t06.entity.Roles;
import com.luotianyi.t06.service.RolesService;

@RestController
@RequestMapping("Roles")
public class RolesController {
	@Autowired
	RolesService rolesService;

	@GetMapping
	public ResponseBean selectAll() {
		return rolesService.selectAll();
	}

	@GetMapping("/{rolesId}")
	public ResponseBean selectOne(@PathVariable("rolesId") int rolesId) {
		return rolesService.selectOne(rolesId);
	}

	@PostMapping
	public ResponseBean insert(Roles roles) {
		return rolesService.insertByRoles(roles);
	}

	@DeleteMapping("/{rolesId}")
	public ResponseBean delete(@PathVariable("rolesId") int rolesId) {
		return rolesService.deleteById(rolesId);
	}

	@PutMapping
	public ResponseBean update(Roles roles) {
		return rolesService.updateByRoles(roles);
	}
}
