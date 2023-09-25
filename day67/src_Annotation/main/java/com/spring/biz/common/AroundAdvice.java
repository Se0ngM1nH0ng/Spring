package com.spring.biz.common;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.util.StopWatch;

public class AroundAdvice {
	public Object aroundPrintLog(ProceedingJoinPoint pjp) throws Throwable {
		System.out.println("around 로그 전");
		
		StopWatch sw=new StopWatch();
		sw.start();
		
		Object obj=pjp.proceed();
		// 외부의 비즈니스 메서드를 호출함
		
		sw.stop();
		String methodName=pjp.getSignature().getName();
		System.out.println(methodName+" 메서드를 수행하는데에 소요한 시간은 "+sw.getTotalTimeMillis()+"초입니다.");
		
		System.out.println("around 로그 후");
		
		return obj;
	}
}
