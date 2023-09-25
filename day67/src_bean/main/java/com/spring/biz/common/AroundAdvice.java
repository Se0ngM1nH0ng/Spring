package com.spring.biz.common;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.util.StopWatch;

// around 를 성능채크 용으로 쓰기
public class AroundAdvice {
	public Object aroundPrintLog(ProceedingJoinPoint pjp) throws Throwable {
		System.out.println("around 로그 전");
		
		StopWatch sw = new StopWatch();
		
		
		sw.start();
		
		Object obj=pjp.proceed();
		// 외부의 비즈니스 메서드를 호출함
		
		sw.stop();
		System.out.println(pjp.getSignature().getName()+" 메서드 수행하는데 소요 시간: "+sw.getTotalTimeSeconds()+"초");
		
		System.out.println("around 로그 후");
		
		return obj;
	}
}

