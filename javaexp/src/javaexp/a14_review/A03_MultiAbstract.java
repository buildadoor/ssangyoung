package javaexp.a14_review;

import java.util.ArrayList;
import java.util.List;

import javaexp.a14_review.Cpu.Ram;
import javaexp.a14_review.Cpu.Ram.Ssd;

public class A03_MultiAbstract {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		List<ComPart> cp = new ArrayList<ComPart>();
//		cp.add(new Cpu("i7 3.2Ghz"));
//		cp.add(new Ram("16Gh"));
//		cp.add(new Ssd("500G"));
//		for(ComPart p : cp) {
//			p.partFun();
//		}
		//부품을 기준으로 더 사양을 추가하여 처리할 수 있다.
		//다형성이 강력한 이유가 여기에 있다. 
	Computer com = new Computer("조립컴퓨터");
	com.addPart(new Cpu("i7 3.2Ghz"));
	com.addPart(new Ram("16G"));
	com.addPart(new Ssd("500G"));
	com.addPart(new GraphCard("1TB"));
	com.showComInfo();
	}

}
/*
# 1대 다관계 처리
1. 하나의 클래스 안에 여러개의 클래스가 선언되는 것을 말한다.
2. 단계별로 이해
	1) 배열형 및 리스트 객체에 대한 이해 
		List<Emp> : Emp클래스가 여러개 있는 것을 말한다.
		list.add(new Emp()); 여러개 객체를 추가 할 때 사용되는 메서드 
		Emp e = list.get(0); index번호로 하나씩 객체를 가져올 수 있다. 
		for(Emp e:list){
			e.getEname() 반복문을 통해서 단위 객체를 가져올 수 있다.
		}
	2) 1:1 객체에 대한 이해
		클래스로 하나의 클래스를 포함관계로 설정하는 경우를 말한다.
		class Woman {
			private Man man;
			public void setMan(Man m){
				this.man = man;
			}
		}
		main()
		Woman w = new Woman();
		w.setMan(new Man()); //선언된 객체에 기능메서드로 객체를 생성/할당 처리 
	3) 1:다관계 객체
		class Mart{
			List<Product> plist;
			Mart(){
				plist = new ArrayList<Product>(); //생성자에 의해 초기화 
			}
			public void buyProduct(Product p){
				plist.add(p); //물건을 하나씩 추가하는 기능메서드 처리.. 
			}
			public void showBuyList(){
				for(Product p:plist){
					p.getName(); p.getPrice(); p.getCnt();
					
				}
			}
		}
		Mart m = new Mart()
		m.buyProduct(new Product("사과",3000,2));
		m.buyProduct(new Product("바나나",4000,3));
		m.buyProduct(new Product("딸기",12000,4));
		m.showBuyList();
 	4) 추상 클래스에 대한 이해
 		추상 개념 : 실제 객체의 공통부분을 가진 개념을 나타낸다.
 		ex) 삼성, 현대, LG (실제 회사) ==> 회사(추상)
 			개, 당나귀, 말 ==> 동물(추상)
 		위 개념에 의해 추상클래스는 독립적으로 객체를 생성하지 못하지만 
 		공통적인 기능과 재정의를 목적으로 선언한다. 
 		abstract class Company{
 			public void working(){
 				회사가 일을 하다.
 			}
 			public void abstract earnMoney();
 		}
 		class Samsung extends Company{
 			public void earnMoney(){ //반드시 재정의해야함(메서드 통일성 유지)
 				전자제품을 만들어 돈을 번다.
 			}
 		}
 		class Hyundai extends Company{
 			public void earnMoney(){
 				배를 건조하여 돈을 번다. 
 			}
 		}
 		Company com1 = new Samsung(); 
 		Company com2 = new Hyundai();
 		List<company> clist = new ArrayList<Company>();
 		clist.add(new Samsung());
 		clist.add(new Hyundai());
 	5) 1:다관계 추상 클래스에서 상속받은 하위 클래스 선언
 		추상 클래스 선언 
 	
 		다형성 처리를 통해 상위 클래스가 여러형태의 다양한 하위 객체를 사용한다.
 		com.working(); 공통 기능메서드
 		com.earnMoney(); 다양한 하위 기능메서드(재정의된 메서드 사용)		
 # 추상 클래스를 상속받은 하위 클래스의 내용을 다형성으로 처리하여,
 
 
 1:다관계를 처리하는 경우 
 1. 예제
 	컴퓨터의 여러가지 부품을 Part라는 추상클래스를 상속받은 
 	하위 실제 클래스로 생성하여 다양한 형태의 실제 객체를 할당할 수 있는
 	구조로 처리하는 1:다 구조를 말한다.
 2. 처리 순서
 	1) 추상 클래스 선언
 	2) 상속받은 하위 클래스 선언 : 필요시 추가적으로 상속받은 하위클래스를 정의하여 처리하여야 한다. 
 	3) 위 내용을 포함하는 1:다 형태의 클래스 선언
 		-필드선언
 		-생성자 선언
 		-기능 메서드 선언 
 			하나씩 담기
 			리스트 처리하기 
*/
abstract class ComPart {
	private String kind;
	private String perFrm;

	public ComPart(String kind, String perFrm) {
		this.kind = kind;
		this.perFrm = perFrm;
	}

	public String getKind() {
		return kind;
	}

	public abstract void partFun();

	// public abstract void partFun2(String perFrm2);
	public String getPerFrm() {
		return perFrm;
	}

}

class Cpu extends ComPart {
	public Cpu(String perFrm) {
		//상속을 하면 상속된 하위클래스는 상위 클래스의 생성자를
		//반드시 호출하여야한다. super (매개변수1, 매개변수2)
		//ComPart(String kind, String perFrm)
		super("CPU", perFrm);
	}
	//abstract로 선언된 추상메서드는 반드시 재정의 하여 선언하여야한다. 
	//추상메서드 ==> 재정의 ==> 다형성(하위에 같은 기능메서드명으로 
	// 								다양한 기능을 처리가 가능)
	public void partFun() {
		System.out.println(getKind() + " " + getPerFrm() + " 성능을 가지고있다.");
		System.out.println("주로 중앙 처리를 해주는 부품이다.");
	}

}
class Ram extends ComPart {

	public Ram(String perFrm) {
		super("Ram", perFrm);
	}
	public void partFun() {
		System.out.println(getKind() + "는 " + getPerFrm() + " 성능을 가지고있다.");
		System.out.println("일시적 처리 장치");

	}
}
class Ssd extends ComPart {

	public Ssd(String perFrm) {
		super("Ssd", perFrm);
	}
	public void partFun() {
		System.out.println(getKind() + "는 " + getPerFrm() + " 성능을 가지고있다.");
		System.out.println("저장장치");

	}

}
class GraphCard extends ComPart {

	public GraphCard(String perFrm) {
		super("그래픽 카드", perFrm);
		// TODO Auto-generated constructor stub
	}

	public void partFun() {
		System.out.println(getKind() + "는 " + getPerFrm() + "성능을 가진다.");
		System.out.println("메모리와 버스 속도에따라 컴퓨터 그래픽을 효과적으로 처리한다.");
	}

}

class Computer {
	private String company;
	private List<ComPart> cp;

	public Computer(String company) {
		this.company = company;
		cp = new ArrayList<ComPart>();
	}

	// 부품을 하나씩 추가/장착할 수 있는 기능 메서드
	//추상클래스를 상속받은 모든 클래스는 이 매개변수로 할당하여 부품을 추가할 수 있다.
	public void addPart(ComPart part) {
		System.out.println(part.getKind() + "부품을 장착합니다.");
		cp.add(part);
	}
	//Computer com
	//com.addPart(new Cpu("3.6GHz")); 다형성	ComPart part = new Cpu("3.6Hz")
	//com.addPart(new Ram("8G")); 다형성 ComPart part = new Ram("8G")
	//com.addPart(new Ssd("8G"));
	public void showComInfo() {
		System.out.println(company + " 제조 컴퓨터!");
		if (cp.size() > 0) {
			System.out.println("장착된 부품 리스트");
			//partFun()이라는 하위에 선언된 각각의 재정의된 메서드가 수행되어 진다. 
			for (ComPart p : cp) {
				p.partFun();
			}
		} else {
			System.out.println("장착된 부품이 없습니다.");
		}

	}
}
