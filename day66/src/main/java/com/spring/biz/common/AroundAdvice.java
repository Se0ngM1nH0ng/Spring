package com.spring.biz.common;

import org.aspectj.lang.ProceedingJoinPoint;

public class AroundAdvice {
	public Object aroundPrintLog(ProceedingJoinPoint pjp) throws Throwable {
		System.out.println("around 로그 전");
		
		Object obj=pjp.proceed();
		// 외부의 비즈니스 메서드를 호출함
		
		System.out.println("around 로그 후");
		
		return obj;
	}
}

