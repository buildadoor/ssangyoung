package javaexp.a06_object;

public class A02_Field {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 #클래스의 구성 멤버
		 1. 필드 : 객체의 데이터가 저장되는 곳
		 2. 생성자 : 객체 생성시 초기화 역할 담당
		 3. 메소드: 객체의 동작에 해당하는 실행 블록
		 */
		Baby b1 = new Baby("홍길동(아기)");
		System.out.println("이름:"+b1.name);
		b1.move();
		Baby b2 = new Baby("마길동(아기)");
		System.out.println("이름:"+b2.name);
		b2.move();
		/*
		 #필드
		 1. 클래스(객체)의 전역변수역할을 하는 클래스명 바로 밑에 선언하는 변수/상수를 말한다.
		 2. 데이터 유형
		 	기본 데이터 유형
		 	객체(배열, 외부 선언된 객체, 내장된 객체 등등)
		 3. 필드의 내용
		 	객체의 고유 데이터
		 	객체가 가져야할 부품 객체
		 	객체의 현재 상태 데이터
		 	ex)
		 	현실 세계			자동차 클래스
		 	자동차			class Car
		 		고유 데이터
		 			제작회사		String company;
		 			모델			String model;
		 			색깔			int maxSpped;
		 		상태
		 			현재속도		int speed;
		 			엔진회전수		int rmp;
		 		부품 (외부객체) : 객체 안에 객체를 사용하여 조합적인 처리를 할때 
		 			차체			Body body;
		 			엔진			Engine engin;
		 			타이어		Tire tire;
		 4. 필드의 사용
		 	1) 필드는 초기에 할당된 경우도 있고
		 	2) main()에서 할당해서 사용하는 경우
		 	3) 생성자를 통해서 초기값 설정/생성자를 통해서 할당하는 경우 
		 */
/*	Car c1 = new Car();//객체 생성 후 
	System.out.println(c1.company); //호출하여 사용
	c1.company = "삼성전자";
	System.out.println(c1.company);
	Car c2 = new Car("LG전자"); //생성자를 통해서 필드 초기화
	System.out.println(c2.company);
*/	
	//ex) Product 클래스를 선언하고 필드 물건명 가격 갯수를 선언하되, 위에 예제와 같이
	//	1)초기에 할당한 경우
	//	2)main()에서 할당한 경우를 구분해서 할당하고, 출력하세요. 
		/*
	Product p1 = new Product();
	System.out.println("초기에 할당된 데이터 호출");
	System.out.println("물건명"+p1.name);
	System.out.println("가격"+p1.price+"원");
	System.out.println("갯수"+p1.cnt+"개");
	Product p2 = new Product();
	p2.name="오렌지"; p2.price= 4000; p2.cnt=3;
	System.out.println("main()에서 할당하여 호출하는 경우");
	System.out.println("물건명"+p2.name);
	System.out.println("가격"+p2.price+"원");
	System.out.println("갯수"+p2.cnt+"개");
	Product p3 = new Product("샤인머스켓",12000,3);
	System.out.println("생성자를 통해 초기화된 데이터 사용");
	System.out.println("물건명:"+p3.name);
	System.out.println("가격:"+p3.price);
	System.out.println("갯수:"+p3.cnt);
*/
// ex) Computer클래스 선언, 생성자를 통해서 제조사, CPU사양, 가격을 할당하게 하고, 할당된 필드를 출력하게 하세요.
/*	Computer01 c1 = new Computer01();
	System.out.println("초기에 할당된 데이터 호출");
	System.out.println("제조사"+c1.company01);
	System.out.println("cpu사양"+c1.cpu);
	System.out.println("가격"+c1.price01);
*//*
	Computer01 c01 = new Computer01("아이맥","I7 3.6GHZ",1500000);
	System.out.println("제조사"+c01.company01);
	System.out.println("cpu사양"+c01.cpu);
	System.out.println("가격"+c01.price01);
	*/
	// ex) Bus(최고속도,탑승가능인원, 버스 번호) 클래스선언, 생성자를 통해 필드를 초기화하고 출력
		Bus bb1 = new Bus();
		System.out.println("초기 최대 속도:"+bb1.maxSpeed);
		bb1.maxPerson = 35;
		bb1.no = "8001";
		System.out.println("#버스1의 정보#");
		System.out.println("버스번호:"+bb1.no);
		System.out.println("최고속도:"+bb1.maxSpeed);
		System.out.println("탑승가능인원:"+bb1.maxPerson);//생성자를 통해 초기화된 데이터 사용
		Bus bb2 = new Bus("M3001");
		System.out.println("초기 최대 속도:"+bb2.maxSpeed);
		System.out.println("#버스2의 정보#");
		System.out.println("버스번호:"+bb2.no);
		System.out.println("최고속도:"+bb2.maxSpeed);
		System.out.println("탑승가능인원:"+bb2.maxPerson);
	}	
}
	class Bus{
	int maxSpeed=120;
	int maxPerson=40;
	String no;
	Bus(){}
	Bus(String no){
		this.no = no;
	}
	Bus(String no, int maxSpeed, int maxPerson){
		this.no=no;
		this.maxSpeed = maxSpeed;
		this.maxPerson = maxPerson;
		
	}
	}
	class Computer01{
	String company01;
	String cpu;
	int price01;
	Computer01(){} // 클래스는 여러 유형의 생성자를 선언할 수 있다. - 매개변수가 다를때 
	Computer01(String company01, String cpu, int price01){
		this.company01 = company01;
		this.cpu = cpu;
		this.price01 = price01;
	}
}
class Product{
	String name="사과";
	int price =3000;
	int cnt = 2;
	Product(){}
	Product(String name, int price, int cnt){ //클래스명과 동일 매개변수 1,2,3
		this.name = name; //name 매개변수의 명과 필드의 이름이 동일한 경우 구분해주기 위해 this.를 붙여서 할당
		this.price = price;
		this.cnt = cnt;
	}
}
class Car{
	String company="회사1";
	Car(){}//기존 생성자 선언 (매개변수 없음)
	Car(String company){
		this.company = company;
	}
}
class Baby{
	String name;//필드 : 객체의 구성요소의 모든 공간에 전역적으로 할당 및 호출이 가능한 데이터 
	Baby(String name){
		this.name = name; //생성자의 매개변수로 이름을 저장
		//생성자
		System.out.println("생성자(이름 저장)");
	}
	void move() {
		//메서드
		System.out.println(name+"이 아장아장 걷다");
	}
}
	
