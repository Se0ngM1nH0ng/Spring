package com.spring.view.controller;

import java.util.HashMap;
import java.util.Map;

public class HandlerMapping {
	//FrontController에서 사용되는 factory 클래스의 이름
	// 팩토리 패턴 사용하기 떄문에 싱글톤 유지
	
	private HandlerMapping handlerMapping;
	
	public void init() {
		// 핸들러맵핑에 대한 의존성 주입
		// 특이하게 init으로 주입함(기존의 setter, 생성자 주입 방식 사용하지 않음)
		handlerMapping = new HandlerMapping();
	}
	
	private Map<String, Controller> mappings; //얘를 갖고 싶은게 아니라 컨트롤러를 갖고 싶은 것
	
	public HandlerMapping() {
		mappings = new HashMap<String, Controller>();
//		mappings.put("/main.do", new MainController());
//		mappings.put("/login.do", new LoginController());
	}
	
	public Controller getController(String command) {
		return mappings.get(command);
		// mappings가 get이라는 행위를 하는 주체가 됨
		// 의존성 주입 필요
		
	}

}
