package day59;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("sTv")
public class SamsungTV implements TV {

	@Autowired
	private Remote remote;
//	의존관계가 생겼으니 의존 주입해야함
//
//	1. 의존 관계 발생
//	2. 의존 주입(DI)
//		1) 생성자 주입
//		2) setter 주입
//
//	3. 설정(.xml)
//		: POJO -> 스프링 컨테이너한테 설정을 해야하므로 appliactionContext.xml
//		만약에 not POJO(서블릿)이었다면 서블릿 컨테이너(톰캣)한테 설정을 해야하므로 web.xml
	
	public SamsungTV() {
		System.out.println("삼성 TV 기본 생성자");
	}
	
	public SamsungTV(Remote remote) { // 생성자 DI(2-1)을 위한 생성자를 오버로딩
		this.remote = remote;
		System.out.println("삼성 TV 생성자");
	}
	
	
	@Override
	public void funcA() {
		remote.funcA();
		System.out.println("삼성 TV 전원 ON OFF");
		
	}

	@Override
	public void funcB() {
		remote.funcB();
		System.out.println("삼성 TV 채널변경");
		
	}

}
