package test;

public class MiWatch implements Watch {

	public MiWatch() {
		System.out.println("미밴드 생성자 호출됨");
	}
	
	@Override
	public void volumeUp() {
		System.out.println("샤오미 밴드로 ++");
	}

	@Override
	public void volumeDown() {
		System.out.println("샤오미 밴드로 --");
	}

}
