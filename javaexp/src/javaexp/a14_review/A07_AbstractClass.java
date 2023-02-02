package javaexp.a14_review;

import java.util.ArrayList;
import java.util.List;

public class A07_AbstractClass {
//패턴 자바 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Worker1 w1 = new PoliceMan1(); //상위 클래스가 상속을 하면 다양한 형태로 
		Worker1 w2 = new FireMan1();	   // 메모리 할당 가능 : 다형성
		w1.working(); // 상위 클래스에 의해 생성된 객체가 하위 기능 메서드를 사용
		w2.working();
		//상위 클래스에 리스트형 선언을 하고,
		//하위 클래스에 의한 객체 생성이 다형성에 의해서 가능
		//1대 다 관계의 마지막 단계인 추상클래스에 의한 다중의 객체 생성 가능 
		List<Worker1> wlist = new ArrayList<Worker1>();
		wlist.add(new PoliceMan1());
		wlist.add(new FireMan1());
		for(Worker1 w:wlist) {
			w.working(); //for 반복문을 통해서 각각의 기능 메서드를 처리할 수 있다.
		}
		//1:다관계에서 핵심 클래스의 코드를 변경하지 않고, 상속받는 하위 클래스만
		//선언하면 확장적인 프로그램을 할 수 있는 처리를 할 수 있다.
		//ex) 컴퓨터 객체에 부품클래스를 추상화하여 이를 상속받은 하위 클래스를 처리하면 
//			컴퓨터에 대한 클래스 내용을 변경하지 않고도 추가적인 부품 내용을 처리할 수 있다.
		Larba l1 = new Dron();
		Larba l2 = new Zerggling();
		Larba l3 = new Hydra();
		l1.attack(); l1.moving();
		l2.attack(); l2.moving();
		l3.attack(); l3.moving();
		List<Larba> list2 = new ArrayList<Larba>();
		list2.add(new Zerggling());
		list2.add(new Dron());
		list2.add(new Dron());
		list2.add(new Dron());
		list2.add(new Zerggling());
		list2.add(new Hydra());
		list2.add(new Hydra());
		System.out.println(" #여러가지 다양한 객체를 생성한 list# ");
		for(Larba lb:list2) {
			lb.moving(); lb.attack();
		}
	}
}
//ex) Zerg ==> Larba 상속받은 Dron, Zerggling, Hydra
//				공통메서드 이동, 재정의 공격하다. 
abstract class Larba{
	private String ukind;
	public Larba(String ukind) { //상위 매개변수가 하나 있는 생성자 
		this.ukind = ukind;
	}
	void moving() { //공통 메서드 
		System.out.println(ukind+" 이동합니다");
	}
	//하위에서 ukind를 호출한 공통 메서드 
	public String getUkind() {
		return ukind;
	}
	abstract void attack(); //재정의할 추상메서드 
}
class Dron extends Larba{

	public Dron() {
		super("드론"); 
		//super() 첫라인에 선언한다. 상위 클래스에서 선언한 생성자 호출
	}
//method두번 
	@Override
	void attack() {
		System.out.println(getUkind()+" 아주 미약하게 원거리 공격을 한다.");
	}
	//상속은 상위에 생성자를 반드시 호출하여야한다. 
	//추상 클래스인 경우 추상메서드를 재정의 하여야한다. 
}
class Zerggling extends Larba{
	
	public Zerggling() {
		super("저글링"); 
	}
	@Override
	void attack() {
		System.out.println(getUkind()+" 빠른 근거리 공격을 한다.");
	}
}
class Hydra extends Larba{
	
	public Hydra() {
		super("히드라리스크"); 
	}
	@Override
	void attack() {
		System.out.println(getUkind()+" 강한 원거리 공격을 한다.");
	}
}

/*
추상클래스
1. 기본 상속 구조
2. 재정의 메서드
3. 다형성 처리
4. 추상클래스 필요성
	-하위 객체만 활용하는 경우
	-반드시 기능메서드 재정의 필요
 */
abstract class Worker1{
	 //상위 클래스에 의한 생성은 필요가 없고,
	//다형성에 의해서 하위 객체를 통해서만 사용할 때, 즉 상위 클래스가 추상화될 때..
	//재정의 메서드 실제 ==> 추상메서드 변환
	//추상메서드가 하나라도 있으면 ==> 추상클래스 선언하여야 한다.
	//추상 클래스를 상속받은 하위클래스는 반드시 추상메서드를 재정의하여야한다. 
	//==> 컴파일 에러 ==> 메서드명 통일을 유지가 가능하다. 
	abstract void working();
} 
//Worker1 w1 = new PoliceMan1(); //상위 클래스가 상속을 하면 다양한 형태로 
  //Worker1 w2 = new FireMan1();	   // 메모리 할당 가능 : 다형성
  //w1.working(); // 상위 클래스에 의해 생성된 객체가 하위 기능 메서드를 사용
  //w2.working();
 //w1.call();  X  다형성은 상위에 있는 메서드를 재정의까지만 가능 
 //				  하위에서 정의된 내용은 처리가 되지 않는다. 
 // PoliceMan1 [ = new PoliceMan1();
 // p.call(); O 하위에 추가적인 ㅔㅁ서드는 하위 객체를 선언, 객체 생성일 때 가능 

class PoliceMan1 extends Worker1{
	@Override
	void working() {
	 //상위 클래스에 정의된 메서드를 재정의 처리 
	
		System.out.println("도둑을 잡다");
	}
	void call() {}
}

class FireMan1 extends Worker1{
	@Override
	void working() {
		System.out.println("불을 끄다");
	}
}
