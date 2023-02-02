package javaexp.a06_object_review;

public class A02_Constructor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//BasePlayer 클래스를 선언하고 팀명,이름, 타율을 필드로 선언하고, 
		// 생성자를 통해서 팀명과 이름을 초기화하고 출력하세요
		BasePlayer b01 = new BasePlayer();
		System.out.println("# 입력 없는 초기값#");
		System.out.println("팀명:"+b01.team);
		System.out.println("이름:"+b01.player);
		System.out.println("타율:"+b01.hit);
		BasePlayer b02 = new BasePlayer("두산","홍길동");
		System.out.println("#매개 변수가 있는 초기값#");
		System.out.println("팀명:"+b02.team);
		System.out.println("이름:"+b02.player);
		System.out.println("타율:"+b02.hit);
	
		Product p1 = new Product();
		System.out.println(" 입력 없는 초기값");
		System.out.println("물건명:"+p1.pd);
		System.out.println("가격:"+p1.price);
		System.out.println("갯수:"+p1.cnt);
		System.out.println("#매개 변수가 있는 초기값#");
		Product p2 = new Product("복숭아",5000);
		System.out.println("물건명:"+p2.pd);
		System.out.println("가격:"+p2.price);
		System.out.println("#오버로딩 규칙에 의한 생성자 선언#");
		Product p3 = new Product(7000,3);
		System.out.println("가격:"+p3.price);
		System.out.println("갯수:"+p3.cnt);
	}

}
class BasePlayer{
	String team;
	String player;
	double hit;
	BasePlayer(){//외부입력없이초기화
		this.team=""; //안하면 null. String은 default 초기값 null;
		this.player="";
	}
	/*
	 #생성자 overloading
	 1. 생성자를 선언할 수 있는 규칙을 말한다 - 메서드 오버로딩 규칙과 동일 
	 2. 규칙
	 	1) 매개변수의 갯수가 다를때 
	 	2) 매개변수의 갯수가 같더라도 타입이 다를때 
	 	3) 매개변수의 갯수가 같고 타입이 같더라도 타입이 선언된 순서가 다를때 
	 */
	
BasePlayer(String team, String player){
		this.team = team;
		this.player = player;
	}
BasePlayer(String team, double hit){
	this.team = team;
	this.hit = hit;
}
BasePlayer(double hit, String team){
	this.team = team;
	this.hit =hit;
}
}
//클래스 내에는 오버로딩 규칙에 의해 여러 생성자를 선언할 수 있고 
//객체를 생성할 때는 이중 하나만 사용하여 처리할 수 있다.
//BasePlayer b1 = new BasePlayer("해태",0.275);
//BasePlayer b2 = new BasePlayer(0.301,"LG");

//ex) 물건클래스에 필드로 물건명 가격 갯수를 선언하되,
//오버로딩 규칙에 의해서 생성자를 선언해보세요 
class Product{
	String pd;
	int price;
	int cnt;
		Product(){
		this.pd="";
		}
		//갯수
Product(String pd, int price){ //매개변수2개 생성자
		this.pd = pd;
		this.price = price;
}
//타입
Product(int price,int cnt){
	this(); //정의된 생성자를 호출할 때 사용 
	this.price = price;
	this.cnt = cnt;
}
//순서가 다른 (타입이 다를때만 가능 )
Product(int price,String pd){
	this.pd = pd;
	this.price = price;
}
}