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
import com.luotianyi.t06.entity.RolesPermission;
import com.luotianyi.t06.service.RolesPermissionService;

@RestController
@RequestMapping("RolesPermission")
public class RolesPermissionController {
	@Autowired
	RolesPermissionService rolesPermissionService;

	@GetMapping
	public ResponseBean selectAll() {
		return rolesPermissionService.selectAll();
	}

	@GetMapping("/{first}/{second}")
	public ResponseBean selectOne(@PathVariable("first") int rolesId, @PathVariable("second") int permisId) {
		return rolesPermissionService.selectOne(rolesId, permisId);
	}

	@PostMapping
	public ResponseBean insert(RolesPermission rolesPermission) {
		return rolesPermissionService.insertByRolesPermission(rolesPermission);
	}

	@DeleteMapping("{first}/{second}")
	public ResponseBean delete(@PathVariable("first") int rolesId, @PathVariable("second") int permisId) {
		return rolesPermissionService.deleteById(rolesId, permisId);
	}

	@PutMapping
	public ResponseBean update(RolesPermission rolesPermission, int firstId, int secondId) {
		return rolesPermissionService.updateByRolesPermission(new RolesPermission(firstId, secondId), rolesPermission);
	}
}
