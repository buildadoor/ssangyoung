package javaexp.a08_inherit;

import java.util.ArrayList;

public class A06_Interface {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Mz m01 = new Mz();
		m01.flying();
		m01.setWing(new Wing01());
		m01.flying();
		m01.setWing(new Wing02());
		m01.flying();
		m01.setWing(new Wing03());
		m01.addAttackWay(new RocketMissile());
		m01.attack01();
		m01.addAttackWay(new RocketMissile());
		m01.addAttackWay(new LasorBeam());
		m01.addAttackWay(new Kick());
	
		m01.addAttackWay(new LasorBeam());
		m01.attack02();
		
	}

}
//ex) 인터페이스로  AttackWay attack()여러가지 공격 형태를
// 선언할 수 있게 추상 메서드 선언. 
// 상속받은 클래스 RocketMissile 로켓 미사일공격 
interface AttackWay{
	void attack();
}
class RocketMissile implements AttackWay{
	@Override
	public void attack() {
		// TODO Auto-generated method stub
		System.out.println("로켓 미사일 공격");
	}
}
class LasorBeam implements AttackWay{
	@Override
	public void attack() {
		// TODO Auto-generated method stub
		System.out.println("로켓 레이저빔 공격");
	}
}
class Kick implements AttackWay{
	@Override
	public void attack() {
		// TODO Auto-generated method stub
		System.out.println("발차기 공격");
	}
}
interface Wing{
	void fly(); // public abstract 가 생략될 수 있다.
}
// 실제 객체 날개1호를 구현
// 인터페이스는 implements를 통해 상속 
class Wing01 implements Wing{
	@Override
	public void fly() {
		// TODO Auto-generated method stub
		System.out.println("날개2호를 통해서 우리 동네를 날다!");
	}	
}
class Wing02 implements Wing{
	@Override
	public void fly() {
		// TODO Auto-generated method stub
		System.out.println("날개3호을 통해서 전 세계를 날다!");
	}	
}

//날개3 선언 우주를 나르다 
class Wing03 implements Wing{
	@Override
	public void fly() {
		// TODO Auto-generated method stub
		System.out.println("날개를 통해서 우주를 날다!");
	}	
}
class Mz{
	private Wing wing;
	private AttackWay attackway;
	private ArrayList<AttackWay> attackList;
	public void setAttackWay(AttackWay attackway) {
		this.attackway = attackway;
	}
	// 여러가지 공격형태를 누적 .. 
	public void addAttackWay(AttackWay attackway) {
		if(attackList == null) attackList = new ArrayList<AttackWay>();
		this.attackList.add(attackway);
	}
	public void attack01() {
		attackway.attack();//하나의 할당된 공격형태 .. 
	}	
	public void attack02() {
		if(attackList!=null) {
			int rIdx = (int)(Math.random()*attackList.size());
		attackList.get(rIdx).attack();//하나의 할당된 공격형태 .. 
		}
	}
	public void setWing(Wing wing) {
		this.wing = wing;
	}
	public void flying() {
		if(this.wing!=null) {
			this.wing.fly(); //실제 객체가 할당되었을때,
			//하위에 실제 객체가 overriding한 내용을 처리한다.
		}else {
			System.out.println("날개가 장착이 되지 않았습니다~");
		}
	}
}
/*
 # 인터페이스란?
 1. 개발 코드와 객체가 서로 통신하는 접점
  -개발 코드는 인터페이스의 메소드만 알고 있으면 OK
 2. 인터페이스의 역할
  -개발 코드가 객체에 종속되지 않게
   ==> 객체 교체할 수 있도록 하는 역할
  - 개발 코드 변경 없이 리턴값 또는 실행 내용이 다양해질 수 있음
  	(다형성)
 ex) MZ 간단접점(인터페이스) : 날개와 통신 (접점, 인식할 수 있는 중앙처리)
  		날개(실제 객체) - 박사가 계속 개발하면서 update처리 ..
  	인터페이스(기능적 접점만 선언)
  		기능적 접점을 연결시킬 수 있는 날개1, 날개2 ...
  		계속적 upgrade되는 실제 객체를 만들어감 
  		
  	
  	
 # 인터페이스의 선언
 1. 인터페이스 이름 - 자바 식별자 작성 규칙에 의해서 대문자로 시작
 2. 소스 파일 생성 - 인터페이스 이름과 대소문자가 동일한 소스 파일 생성
 3. 인터페이스 선언 
  public interface 인터페이스명{...}
 4. 인터페이스 구성 멤버
 	interface 인터페이스명{
 		//상수
 		 타입 상수명 = 값;
 		 ex)
 		 [public static final] String FUN01="저장기능";
 		 // 추상 메소드 
 		 타입 메소드(매개변수,....)
 		 [public abstract] void show();
 		 // 디폴트 메소드
 		 default 타입 메소드(매개변수...){}
 		 [public] default String getName(){
 		 	return "홍길동";
 		 }
 		 //정적 메소드
 		 static 타입 메소드명(매개변수){}
 		 [public] static void show(){
 		 	System.out.println("기능 내용 출력");
 		 }
 		  */
 		  
 		 
 	
 	
