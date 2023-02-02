package javaexp.z01_homework;

import java.util.ArrayList;

public class A16_0915 {

	public static void main(String[] args) {
	
		// TODO Auto-generated method stub
/*
 2022-09-15
[1단계:개념] 1. (연습이 필요한 분)1:다관계 설정 연습 - 버스/승객, 영화/배우들, 회사/종업원  
[1단계:개념] 2. this/super의 사용을 생성자와 메서드를 나누어 기본예제를 통해 설명하세요.
 		- this 
 			인스턴스 필드/메서드를 호출할때 사용, this.필드명
 			this() 다른 생성자를 호출할때 사용, this(), this(name)
 class Product{
String pName;
int pCnt;
}
Product(String pName, int pCnt){
this.pName =pName;
this.pCnt=pCnt;
}

		- super
		 	상속관계에서 상위/하위 클래스 동일한 이름을 사용할때 
		 	구분하기위하여 활용
		 	      
Class Cook{
Cook(int food){
}
}
Class Menu extends Cook{
Super(3);
}

[1단계:코드] 3. 상위클래스 School 학교의 분류 , 하위클래스 EleSchool/MiddleSchool/HighSchool을 선언하여 상위 생성자를 통해 하위객체를 할당처리하세요.
class School{
	private String kind;
	public School(String kind) {
		this.kind = kind;
	}
	public void studying() {
		System.out.println(this.kind+"에 다녔다");
	}
}
class EleSchool extends School{
	public EleSchool() {
		super("대전대흥초등학교");
	}
	public void studying() {
		super.studying();
		System.out.println("2009년 졸업");
	}
}
class MiddleSchool extends School{
	public MiddleSchool() {
		super("천안신방중학교");
	}
	public void studying() {
		super.studying();
		System.out.println("2012년 졸업");
	}
}
class HighSchool extends School{
	public HighSchool() {
		super("천안쌍용고등학교");
	}
	public void studying() {
		super.studying();
		System.out.println("2015년 졸업");
	}
}
[1단계:개념] 4. 메서드 overriding이란 무엇인가? overloading과 차이점과 함께 기본예제를 통해 기술하세요.
 부모 클래스의 상속 메소드를 동일한 이름으로 수정해서 자식 클래스에서  재정의하는 것이다. 
 동일한 이름이지만 여러 행태로 자식 클래스에서 기능적 처리를 하고자 할 때, 활용된다.
 오버로딩은 매개변수,타입이 달라야하지만 오버라이딩은 동일해야하고
 오버로딩은 리턴타입이 무엇이든 상관없지만 오버라이딩은 동일해야한다. 
 
[1단계:코드] 5. 상위클래스 ComPart 컴퓨터 부품, partFunction()부품의 기능,  하위클래스 Cpu, Ram, Ssd를 선언하여 오버라이딩을 처리하여 구현하세요.
			1:다관계로 다형성 처리 활용 
[1단계:개념] 6. 다형성이란 무엇인가? 개념을 기술하세요.
 		 같은 타입이지만 실행 결과가 다양한 객체 대입(이용)가능한 성질
 			1) 부모 타입에는 모든 자식 객체가 대입 가능
 				-자식 타입은 부모 타입으로 자동 타입 변환

[1단계:코드] 7. 상위클래스 Blabar 나비애벌래로 다양한 나비(호랑나비, 노랑나비, 파랑나비)가 나오게 다형성 처리하고 showColor()메서드를 통해서 재정의 하세요
 		Blabar b01= new Yellow();
		b01.color();
		Blabar b02= new Blue();
		b02.color();
		Blabar b03= new Mix();
		b03.color();
	}
}
class Blabar{
	private String butterfly;
	public Blabar(String butterfly) {
		this.butterfly = butterfly;
	}
	public void color() {
		System.out.println(this.butterfly+"가 있다");
	}
	public String getButterfly() {
		return butterfly;
	}

}
class Yellow extends Blabar{
	public Yellow() {
		super("노랑나비");
	}
	public void color(){
		super.color();
		System.out.println("노란색");
	}
}
class Blue extends Blabar{
	public Blue() {
		super("파랑나비");
	}
	public void color(){
		super.color();
		System.out.println("파란색");
		}
}
class Mix extends Blabar{
	public Mix() {
		super("호랑나비");
	}
	public void color(){
		super.color();
		System.out.println("호랑무늬");
		}
	
}
 */
		Computer02 com = new Computer02("맥 프로 노트북");
		com.setParts(new Cpu());
		com.setParts(new Ram());
		com.setParts(new Ram());
		com.setParts(new Ssd());
		com.setParts(new Ssd());
		com.showPartList();
}
}

//해설 
class Computer02{
	private String kind;
	private ArrayList<ComPart> parts;
	public Computer02(String kind) {
		this.kind = kind;
		this.parts = new ArrayList<ComPart>();
	}
	public void setParts(ComPart parts) {
	//	1. 다형성 개념 이해
		// 상위 = 하위 ComPart part1 = new Cpu();
		//			 ComPart part2 = new Ram();
		//			 ComPart part3 = new Ram();
	//  2. ArrayList 데이터 할당 개념 이해
		// 	ArrayList<Cpu>list = new ArrayList<Cpu>();
		//	list.add(new Cpu()); 
		//	list.add(new Cpu()); 
		//	list.add(new Cpu()); 
		// 	ArrayList<ComPart> list2 = new ArrayList<ComPart>();
		// 	list2.add(new Cpu());
		// 	list2.add(new Ram());
		// 	list2.add(new Ssd());
		this.parts.add(parts);
	}
	public void showPartList() {
		System.out.println("컴퓨터 종류:"+kind);
	//추상 클래스 객체를 자체로 생성하지 못할 뿐이지
	//종속된 하위클래스를 할당해서 사용하는 것은 가능하다.
		for(ComPart cp:this.parts) {
			//각 객체에서 재정의된 내용을 호출 .. 
			cp.partFunction();
		}
	}
	
}
abstract class ComPart{
	private String kind;
	public ComPart(String kind) {
		this.kind = kind;
	}
	//공통 메서드 
	public String getKind() {
		return this.kind;
		
	}
	//다양하게 처리할 메서드
	public abstract void partFunction();
	
}
class Cpu extends ComPart{
	public Cpu() {
		super("CPU");
	}

	@Override
	public void partFunction() {
		// TODO Auto-generated method stub
		System.out.println(getKind()+"컴퓨터의 핵심 중앙처리 장치이다.");
		
	}
	}
class Ram extends ComPart{
	public Ram() {
		super("RAM");
	}

	@Override
	public void partFunction() {
		// TODO Auto-generated method stub
		System.out.println(getKind()+"컴퓨터의 핵심 휘발성 메모리를 처리한다.");
	}		
}
class Ssd extends ComPart{
	public Ssd() {
		super("SSD");
	}
		
	@Override
	public void partFunction() {
		// TODO Auto-generated method stub
		System.out.println(getKind()+"컴퓨터의 하드웨어적 저장을 처리한다.");
			
		}
}