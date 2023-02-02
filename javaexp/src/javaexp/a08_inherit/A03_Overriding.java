package javaexp.a08_inherit;

public class A03_Overriding {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PoliceMan pm = new PoliceMan();
		pm.working();
		FireMan fm = new FireMan();
		fm.working();
		Programmer pg = new Programmer();
		pg.working();
		
		SamsungEle ss = new SamsungEle();
		ss.earning();
		HyunDae hd = new HyunDae();
		hd.earning();
	}

}
/*
 #메소드 재정의(override) ps)overloading
 1. 부모 클래스으 상속 메소드를 동일한 이름으로 수정해서 자식 클래스에서 
 	재정의하는 것이다. 
 2. 목적
 	1) 동일한 이름이지만 여러 행태로 자식 클래스에서 기능적 처리를 하고자 할 때,
 	 	활용된다.
 		-주로 다형성 (polymorphism)을 위하여 사용된다.
 			상위 클래스 = 하위 클래스
 			cf) Object s = 모든 클래스();
 			
 			 
 		-상위 클래스에 메모리에 상속받은 여러가지 하위 클래스가 
 			객체를 생성하면 사용할 수 있다. (다형성)
*/
//ex) Company 필드: 히사명, 생성자(회사명), earnMoney()@@회사 돈을 번다 
//하위 SamsungEle, HyunDae

//ex) Programmer 클래스를 선언하고 매서드를 재정의하여 main()에서 호출하세요
class Company{
	private String cName;
	public Company(String cName) {
		this.cName = cName;
	}
	public void earning() {
		System.out.println(this.cName+" 돈을 번다");
	}
}
class SamsungEle extends Company{
	public SamsungEle() {
		super("삼성전자");
	}
	public void earning() {
		super.earning();
		System.out.println("전자제품을 만든다");
	}
}
class HyunDae extends Company{
	public HyunDae() {
		super("현대조선");
	}
	public void earning() {
		super.earning();//상위 클래스에 정의된 내용
		System.out.println("배를 건조한다");// 추가된 내용 
	}
}
class Worker{
	private String kind;
//	Worker(){}
	public Worker(String kind) {
		this.kind=kind;
	}
	public void working() {
		System.out.println(this.kind+"열심히 일을 한다");
	}
}
class Programmer extends Worker{
	
	public Programmer() {
		super("프로그래머");
	}
	public void working() {
		super.working();
		//상위에 있는 메서드를 호출 super. : 동일한 이름의 메서드가 있을떄 (재정의시) 구분하기 위해 사용 
		System.out.println("소프트웨어 개발을 하다");
	}
}
class PoliceMan extends Worker{
//public PoliceMAn(){super();}
	public PoliceMan() {
		super("경찰관");
	}
	public void working() { //overriding은 1. 상위와 동일한 이름으로 메서드를 정의
		super.working();//상위에 있는 메서드를 호출 
		System.out.println("치안을 유지하는 일을 한다.");
	}
}
class FireMan extends Worker{
	public FireMan() {
		super("소방관");
	}
	public void working() { 
		super.working();//상위에 있는 메서드를 호출 
		System.out.println("불을 끄는 일을 한다.");
}
}