package com.luotianyi.t06.config;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authz.AuthorizationException;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import com.luotianyi.t06.bean.ResponseBean;
import com.luotianyi.t06.utils.ObjectUtils;

@Component
public class ExceptionHandler implements HandlerExceptionResolver {

	@Override
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
			Exception ex) {
		ModelAndView modelAndView = new ModelAndView();
		MappingJackson2JsonView view = new MappingJackson2JsonView();
		if (ex instanceof AuthenticationException) {
			try {
				modelAndView
						.addAllObjects(ObjectUtils.objectToMap(ResponseBean.getResponseBean(500, "用户名或密码不正确", null)));
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			}
		}else if(ex instanceof AuthorizationException){
			try {
				modelAndView
						.addAllObjects(ObjectUtils.objectToMap(ResponseBean.getResponseBean(500, "没有权限使用该功能", null)));
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			}
		
		}else {
			try {
				modelAndView.addAllObjects(
						ObjectUtils.objectToMap(ResponseBean.getResponseBean(500, ex.getMessage(), null)));
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			}
		}
		ex.printStackTrace();
		modelAndView.setView(view);
		return modelAndView;
	}

}
