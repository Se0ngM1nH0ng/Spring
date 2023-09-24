package test;

public class IPhone implements Phone {

	private Watch watch;
	private String name;
	
	public void setWatch(Watch watch) {
		this.watch = watch;
		System.out.println("setter 호출됨");
	}
	public void setName(String name) {
		this.name = name;
	}

	public IPhone() {
		System.out.println("아이폰 생성자 호출됨");
	}
	
	public void destroyMethod() {
		System.out.println("객체 소멸할때에 호출될 메서드");
		// 보통 .close()와 같은 연결해제 코드가 작성되어있음
	}
	
	@Override
	public void powerOn() {
		System.out.println("아이폰 ON");
	}

	@Override
	public void powerOff() {
		System.out.println("아이폰 OFF");
	}

	@Override
	public void volumeUp() {
		watch.volumeUp();
		System.out.println("name: "+name);
	}

	@Override
	public void volumeDown() {
		watch.volumeDown();
	}
	
}
