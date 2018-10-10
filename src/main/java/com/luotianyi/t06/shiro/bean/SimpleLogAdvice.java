package com.luotianyi.t06.shiro.bean;

import org.aspectj.lang.JoinPoint;

public class SimpleLogAdvice {

	public void after(JoinPoint joinPoint, Object returnVal) {
		System.out.println(
				joinPoint.getTarget().getClass().getName() + "的" + joinPoint.getSignature().getName() + "方法执行了");
	}
	
	public void after1(JoinPoint joinPoint, Object returnVal) {
		System.out.println(
				joinPoint.getTarget().getClass().getName() + "的" + joinPoint.getSignature().getName() + "方法执行了");
	}
}
