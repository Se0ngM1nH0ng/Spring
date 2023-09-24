package test;

public class GalaxyWatch implements Watch{
	public GalaxyWatch() {
		System.out.println("갤럭시 워치 객체 생성됨");
	}
	
	@Override
	public void volumeUp() {
		System.out.println("갤럭시 워치로 음량++");
	}
	@Override
	public void volumeDown() {
		System.out.println("갤럭시 워치로 음량--");
	}
}
