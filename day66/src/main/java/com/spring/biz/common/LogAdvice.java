package com.spring.biz.common;

public class LogAdvice {
	
	//before
	public void printLog() {
		System.out.println("[횡단관심] : 비즈니스 메서드 수행 전에 호출됨");
	}
	//select문 after
	public void printLogSelect() {
		System.out.println("[횡단관심] : 비즈니스 메서드 중 select 수행 후에 호출됨");
	}
	// after-returning
	
	//after-throwing

}
