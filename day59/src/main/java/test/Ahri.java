package test;

public class Ahri implements Champion {
	private Item item;
	
	public Ahri() {
		System.out.println("아리 소환");
	}
	
	public Ahri(Item item) {
		System.out.println("아리 소환");
		this.item = item;
		System.out.println(item + " 구매 완료");
	}
	
	public void use() {
		item.use();
	}
	
	public void q() {
		System.out.println("현혹의 구슬 !");
	}
	public void w() {
		System.out.println("여우불 !");
	}
	public void e() {
		System.out.println("매혹 !");
	}
	public void r() {
		System.out.println("혼령 질주 !");
	}
}
