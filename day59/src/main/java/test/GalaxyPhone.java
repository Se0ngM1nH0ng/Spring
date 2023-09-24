package test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("gp")
public class GalaxyPhone implements Phone {

	@Autowired
	// 나에게 해당하는 자료형이 메모리에 있다면,
	// 나에게 DI(의존성주입) 해줘!~~
	private Watch watch;
	
	public GalaxyPhone() {
		System.out.println("갤럭시폰 기본 생성자 호출됨");
	}
	
	public GalaxyPhone(Watch watch) {
		this.watch=watch;
		System.out.println("갤럭시폰 생성자 호출됨");
	}
		
	public void initMethod() {
		System.out.println("객체를 처음 생성할때 함께 호출할 메서드");
		System.out.println("보통 일반적으로 멤버변수 초기화와 관련된 코드들이 포함되어있음");
	}
	
	@Override
	public void powerOn() {
		System.out.println("전원ON");
	}
	@Override
	public void powerOff() {
		System.out.println("전원OFF");
	}
	@Override
	public void volumeUp() {
		watch.volumeUp();
	}
	@Override
	public void volumeDown() {
		watch.volumeDown();
	}
	
}
