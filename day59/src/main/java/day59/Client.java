package day59;

import java.util.Map;
import java.util.Set;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Client {
	public static void main(String[] args) {
				
		AbstractApplicationContext factory = new GenericXmlApplicationContext("applicationContext.xml");
		
		TV tv = (TV)factory.getBean("sTv");
		tv.funcA();
		tv.funcB();

		System.out.println("\n");
		
		TV tv2 = (TV)factory.getBean("lTv");
		tv2.funcA();
		tv2.funcB();
//		
//		 TestBean tb = (TestBean)factory.getBean("tb");
//		 List<String> list = tb.getTestList();
//		 for(String v:list) {
//			 System.out.println(v);
//		 }
		
//		TestBean2 tb2=(TestBean2)factory.getBean("tb2");
//	      Map<String, String> map=tb2.getTestMap();
//	      Set<String> set=map.keySet();
//	      for(String v:set) {
//	         System.out.print(v+" :");
//	         System.out.println(map.get(v));
//	      }
		 
		 factory.close();

	}
}
