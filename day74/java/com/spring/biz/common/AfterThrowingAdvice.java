package com.spring.biz.common;

import org.aspectj.lang.JoinPoint;

// 서비스하기전까지 예외 및 에러를 확인하려는 용도로 사용
public class AfterThrowingAdvice {
	// 발생한 예외를 바인딩변수로 받아올수있음
	// Exception == 최상위 예외 클래스
	public void afterThrowingPrintLog(JoinPoint jp, Exception exceptObj) {
		String methodName = jp.getSignature().getName();
		
		System.out.println("횡단 관심 : "+methodName+"에서 예외가 발생해서 출력되는 로그");
		System.out.println("예외 메세지 : "+exceptObj.getMessage());
	}
	// 이미 try-catch 처리가 되어있으면 호출 x
	// Service 레이어에서 발생한 경우에만 어드바이스와 결합됨
	// DAO, SQL, ... xxxxx
}
