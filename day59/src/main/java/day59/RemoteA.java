package day59;

import org.springframework.stereotype.Component;

@Component
public class RemoteA implements Remote{

	@Override
	public void funcA() {
		System.out.println("리모콘 A");
		
	}

	@Override
	public void funcB() {
		System.out.println("리모콘 A");
		
	}

}
