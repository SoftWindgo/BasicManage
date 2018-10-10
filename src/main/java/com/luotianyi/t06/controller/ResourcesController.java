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
import com.luotianyi.t06.entity.Resources;
import com.luotianyi.t06.service.ResourcesService;

@RestController
@RequestMapping("Resources")
public class ResourcesController {
	@Autowired
	ResourcesService resourcesService;

	@GetMapping("selectByUserId")
	public ResponseBean selectByUserId(String token) {
		return resourcesService.selectAll();
	}

	@GetMapping
	public ResponseBean selectAll() {
		
		return resourcesService.selectAll();
	}

	@GetMapping("/{resId}")
	public ResponseBean selectOne(@PathVariable("resId") int resId) {
		
		return resourcesService.selectOne(resId);
	}

	@PostMapping
	public ResponseBean insert(Resources resources) {
		
		return resourcesService.insertByResources(resources);
	}

	@DeleteMapping("/{resId}")
	public ResponseBean delete(@PathVariable("resId") int resId) {
		
		return resourcesService.deleteById(resId);
	}

	@PutMapping
	public ResponseBean update(Resources resources) {
		
		return resourcesService.updateByResources(resources);
	}
}
