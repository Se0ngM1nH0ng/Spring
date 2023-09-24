package test;

// 특별한 말이 없다면, Bean == 객체
public class BeanFactory {
	public Object getBean(String beanName) { // 메서드 시그니처
		if(beanName.equals("갤럭시")) {
			return new GalaxyPhone();
		}
		else if(beanName.equals("아이폰")) {
			return new IPhone();
		}
		return null;
	}
}
