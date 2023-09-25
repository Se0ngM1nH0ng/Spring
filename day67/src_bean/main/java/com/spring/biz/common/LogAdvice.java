package com.spring.biz.common;

import org.aspectj.lang.JoinPoint;

import com.spring.biz.member.MemberVO;

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
	// pjp는 jp를 상속받은 객체
	// pjp는 aroundAdvice에서는 필수
	// 다른 advice들은 필수가 아님
	// 비즈니스 메서드의 정보를 받고 싶을때 jp
	public void printReturn(JoinPoint jp, Object returnObj) {
		String methodName = jp.getSignature().getName();
		// 비즈니스 메서드의 이름
		// 현재 해당 어드바이스와 결합된 비즈니스 메서드

		System.out.println("[횡단관심] : after-returning / "+methodName+"의 반환 후 로그");
		
		// returnObj가 관리자면 로그에 [관리자 입장]이라고 출력
		if(returnObj instanceof MemberVO) {
			MemberVO mVO = (MemberVO)returnObj;
			if(mVO.getRole().equals("ADMIN")) {
				System.out.println("[관리자 입장]");
			}
			else{
				System.out.println("[사용자 입장]");
			}
			
		}
		else {
			System.out.println("[데이터 열람]");
		}
			
	}
	
	// after-throwing
	// 발생한 예외자체를 바인딩변수로 받아올 수 있다
	// Exception은 예외 최상위 객체 클래스
	// 예외발생시 trycatch 되어있으면 어드바이스 호출안함
	// Service 레이어에서 발생한 경우에만 어드바이스와 결합됨
	// DAO, SQL에러, ... XXXXXXXX
	// 서비스하기 전까지 예외 및 에러를 확인하려는 용도로 넣는것
	// 실제 서브스시 넣진 않음
	public void printThrow(JoinPoint jp, Exception exceptObj) {
		String methodName = jp.getSignature().getName();
		
		System.out.println("[횡단관심] : after-throwing / "+methodName+"의 예외 발생 후 로그");
		System.out.println("예외 메세지: "+ exceptObj);
	}

}
