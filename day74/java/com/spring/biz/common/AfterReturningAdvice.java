package com.spring.biz.common;

import org.aspectj.lang.JoinPoint;

import com.spring.biz.member.MemberVO;

public class AfterReturningAdvice {
	// pjp는 jp를 상속받은 객체
	// pjp는 aroundAdvice에서는 필수
	// 다른 advice들은 필수가 아님
	// 비즈니스 메서드의 정보를 받고싶을때 jp를 사용
	public void afterReturningPrintLog(JoinPoint jp, Object returnObj) {
		String methodName=jp.getSignature().getName();
		// 비즈니스 메서드의 이름
		// 현재 해당 어드바이스와 결합된 비즈니스 메서드

		System.out.println("횡단관심 : "+methodName+"의 반환 이후의 로그");



		// returnObj가 관리자라면, 로그에 [관리자 입장]이라고 출력하고싶음
		if(returnObj instanceof MemberVO) {
			MemberVO mVO=(MemberVO)returnObj;
			if(mVO.getRole().equals("ADMIN")) {
				System.out.println("[관리자 입장]");
			}
			else {
				System.out.println("[사용자 입장]");
			}
		}
		else {
			System.out.println("[데이터 열람]");
		}
	}
}
