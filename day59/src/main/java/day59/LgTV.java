package day59;

public class LgTV implements TV {
	
	private Remote remote;
	
	
	public void setRemote(Remote remote) {
		this.remote = remote;
	}

	public LgTV() {
		System.out.println("Lg TV 기본 생성자");
	}
	
	public LgTV(Remote remote) {
		this.remote = remote;
		System.out.println("Lg TV 생성자");
	}

	@Override
	public void funcA() {
		remote.funcA();
		System.out.println("LG TV 전원 ON OFF");
		
	}

	@Override
	public void funcB() {
		remote.funcB();
		System.out.println("LG TV 음량");
		
	}

}
