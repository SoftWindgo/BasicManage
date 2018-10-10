package com.luotianyi.t06.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luotianyi.t06.bean.ResponseBean;
import com.luotianyi.t06.entity.Users;
import com.luotianyi.t06.service.UsersService;

@RestController
@RequestMapping("Users")
public class UsersController {
	@Autowired
	UsersService usersService;

	@PostMapping("/login")
	public ResponseBean login(Users users) {
		Subject subject = SecurityUtils.getSubject();
		subject.login(users);
		if (!subject.isAuthenticated())
			return ResponseBean.getResponseBean(500, "用户名或者密码错误", null);
		return ResponseBean.getResponseBean(200, "登录成功", null);
	}

	@GetMapping
	public ResponseBean selectAll() {
		return usersService.selectAll();
	}

	@GetMapping("/{usersId}")
	public ResponseBean selectOne(@PathVariable("usersId") int usersId) {
		return usersService.selectOne(usersId);
	}

	@PostMapping
	public ResponseBean insert(Users users) {
		return usersService.insertByUsers(users);
	}

	@DeleteMapping("/{usersId}")
	public ResponseBean delete(@PathVariable("usersId") int usersId) {
		return usersService.deleteById(usersId);
	}

	@PutMapping
	public ResponseBean update(Users users) {
		return usersService.updateByUsers(users);
	}
}
