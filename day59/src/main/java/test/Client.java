package test;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Client {

	public static void main(String[] args) {
		
		/*
		Phone phone = new GalaxyPhone();
		phone.powerOn();
		phone.volumeUp();
		phone.volumeDown();
		
		
		BeanFactory bf=new BeanFactory();
		Phone phone=(Phone)bf.getBean(args[0]);
		phone.powerOn();
		phone.volumeUp();
		phone.volumeDown();
		*/
		
		
		
		// 스프링 컨테이너(★)가 동작할수있도록해야함
		AbstractApplicationContext factory=new GenericXmlApplicationContext("applicationContext.xml");
		
		Phone phone=(Phone)factory.getBean("gp"); // LookUp(룩업)
		phone.powerOn();
		phone.volumeUp();
		phone.volumeDown();
		
		factory.close();
		
	}

}
