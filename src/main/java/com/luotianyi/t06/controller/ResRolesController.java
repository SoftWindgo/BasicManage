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
import com.luotianyi.t06.entity.ResRoles;
import com.luotianyi.t06.service.ResRolesService;

@RestController
@RequestMapping("ResRoles")
public class ResRolesController {
	@Autowired
	ResRolesService resRolesService;

	@GetMapping
	public ResponseBean selectAll() {
		
		return resRolesService.selectAll();
	}

	@GetMapping("/{first}/{second}")
	public ResponseBean selectOne(@PathVariable("first") int rolesId, @PathVariable("second") int permisId) {
	
		return resRolesService.selectOne(rolesId, permisId);
	}

	@PostMapping
	public ResponseBean insert(ResRoles resRoles) {
		return resRolesService.insertByResRoles(resRoles);
	}

	@DeleteMapping("{first}/{second}")
	public ResponseBean delete(@PathVariable("first") int rolesId, @PathVariable("second") int permisId) {
		return resRolesService.deleteById(rolesId, permisId);
	}

	@PutMapping
	public ResponseBean update(ResRoles resRoles, int firstId, int secondId) {
		return resRolesService.updateByResRoles(new ResRoles(firstId, secondId), resRoles);
	}
}
