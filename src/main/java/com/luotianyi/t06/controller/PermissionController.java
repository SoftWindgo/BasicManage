package com.luotianyi.t06.controller;


import javax.servlet.http.HttpServletRequest;

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
import com.luotianyi.t06.entity.Permission;
import com.luotianyi.t06.service.PermissionService;

@RestController
@RequestMapping("Permission")
public class PermissionController {
	@Autowired
	PermissionService permissionService;

	@GetMapping
	public ResponseBean selectAll() {
		
		return permissionService.selectAll();
	}

	@GetMapping("/{perId}")
	public ResponseBean selectOne(@PathVariable("perId") int perId) {
		
		return permissionService.selectOne(perId);
	}

	@PostMapping
	public ResponseBean insert(Permission permission) {
		
		return permissionService.insertByPermission(permission);
	}

	@DeleteMapping("/{perId}")
	public ResponseBean delete(@PathVariable("perId") int perId) {
		
		return permissionService.deleteById(perId);
	}

	@PutMapping
	public ResponseBean update(Permission permission,HttpServletRequest request) {
		
		return permissionService.updateByPermission(permission);
	}
}
