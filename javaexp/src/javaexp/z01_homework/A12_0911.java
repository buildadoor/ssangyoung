package javaexp.z01_homework;


public class A12_0911 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
/*
 2022-09-11
[1단계:확인] 1. [리턴유형연습] 쇼핑몰에서 구매한 물건, 가격, 갯수, 배송지를 리턴값으로 선언하는 메서드와,
리턴값이 없이 위 정보를 출력하는 메서드를 선언하세요
		Product p01 = new Product();
		p01.pName = "노트북";
		p01.price = 1500000;
		p01.cnt = 2;
		p01.adr = "서울특별시 마포구 서교동 447-5";
		
		System.out.println("물건명:"+p01.pName);
		System.out.println("가격:"+p01.price);
		System.out.println("갯수:"+p01.cnt);
		System.out.println("주소:"+p01.adr);

		}

}
class Product{
	String pName;
	int price;
	int cnt;
	String adr;

	String inf() {
		
		return this.pName+this.price+this.cnt+this.adr;
	}

	}

//리턴값 없이 출력은 위에 inf부터 삭제??
[1단계:확인] 2. [매개변수연습] driving메서드에 매개변수로 1~3개를 각각 선언하되,
차량명, 목적지, 거리를 선언하여 출력하되 오버로딩 규칙에 따라 처리하세요.
		Driving d01 = new Driving();
		System.out.println("차종:"+d01.car);
		System.out.println("목적지:"+d01.des);
		System.out.println("거리: "+d01.km);
		Driving d02 = new Driving("그랜저","서울");
		System.out.println("차종:"+d02.car);
		System.out.println("목적지:"+d02.des);
		System.out.println("거리:"+d02.km);
		Driving d03 = new Driving("아반떼",150);
		System.out.println("차종:"+d03.car);
		System.out.println("목적지:"+d03.des);
		System.out.println("거리:"+d03.km);	
		
	}

}
class Driving{
	String car;
	String des;
	int km;
	Driving(){
		this.car="소나타";
		this.des="천안";
		this.km=80;
	}
	Driving(String car, String des){
		this.car = car;
		this.des = des;
		this.km = 280;
	}
	Driving(String car, int km){
		this.car = car;
		this.des = "대전";
		this.km = km;
}
}
[1단계:확인] 3. [매개변수+리턴] Student 클래스
tot() 매개변수:국어,영어,수학점수 리턴값:총점수(정수)
avg() 매개변수:국어,영어,수학점수 리턴값:평균값(실수)
reg() 매개변수:번호,이름  리턴값:@@번 @@@(문자열)
show() 매개변수:이름,국어,영어,수학  리턴값:없음, 출력:매개변수값
		Student s01 = new Student();
		s01.name = "김둘리"; 
		s01.kor = 90;
		s01.eng = 80;
		s01.math = 55;	
		s01.sNum = 38;
		int tot = s01.kor+s01.eng+s01.math;
		double avg = tot/3;
		System.out.println("학생명:"+s01.name);
		System.out.println("번호:"+s01.sNum+"번");
		System.out.println("국어점수:"+s01.kor+"점");
		System.out.println("영어점수:"+s01.eng+"점");
		System.out.println("수학점수:"+s01.math+"점");
		System.out.println("총점:"+tot+"점");
		System.out.println("평균:"+avg+"점");
//show 매개변수 설정 하는 방법??		System.out.println("show");
		}

}
class Student{
	String name;
	int kor;
	int eng;
	int math;
	int sNum;
	
	String reg() {
		return this.sNum+this.name;
	}

	}

[1단계:확인] 4. [매개변수+리턴] Member 클래스 선언하고, regdate()메서드로
회원명, 아이디, 패스워드 매개변수로 입력과 String으로 등록 내용을 리턴
usePoint()메서드로 사용한 포인트를 입력받아 10%적립포인트 리턴(실수)
addPoint()메서드로 추가할포인트를 입력받아 지역변수로 있는 point=1000
에 추가하여 리턴처리하세요.
	Member m01 = new Member();
		System.out.println(c01.plus());
		System.out.println(c01.minus());
		System.out.println(c01.multi());
		System.out.println(c01.divide());
	}


class Member{
	String mName;
	String id;
	String pw;	
	void usePoint() {
	}
	//use add 메서드 입력??
	 2022-09-11
[1단계:확인] 1. [리턴유형연습] 쇼핑몰에서 구매한 물건, 가격, 갯수, 배송지를 리턴값으로 선언하는 메서드와,
리턴값이 없이 위 정보를 출력하는 메서드를 선언하세요
[1단계:확인] 2. [매개변수연습] driving메서드에 매개변수로 1~3개를 각각 선언하되,
차량명, 목적지, 거리를 선언하여 출력하되 오버로딩 규칙에 따라 처리하세요.
[1단계:확인] 3. [매개변수+리턴] Student 클래스
tot() 매개변수:국어,영어,수학점수 리턴값:총점수(정수)
avg() 매개변수:국어,영어,수학점수 리턴값:평균값(실수)
reg() 매개변수:번호,이름  리턴값:@@번 @@@(문자열)
show() 매개변수:이름,국어,영어,수학  리턴값:없음, 출력:매개변수값
[1단계:확인] 4. [매개변수+리턴] Member 클래스 선언하고, regdate()메서드로
회원명, 아이디, 패스워드 매개변수로 입력과 String으로 등록 내용을 리턴
usePoint()메서드로 사용한 포인트를 입력받아 10%적립포인트 리턴(실수)
addPoint()메서드로 추가할포인트를 입력받아 지역변수로 있는 point=1000
에 추가하여 리턴처리하세요.

 */
		/*
		 //2
class Car {
	String name;
	String target;
	int distance;
	Car(){
		this.name="정하지않음";
		this.target="없음";
}
	//차량명, 목적지, 거리
	void driving() {//매개변수없음
		System.out.println("차량명:"+this.name);
		System.out.println("목적지:"+this.target);
		System.out.println("거리:"+this.distance);
}
	void driving(String name) { //1개 매개변수
		this.name = name;
		this.driving();
	}
	void driving(int distance) { //매개 변수 타입이 다름
		this.distance = distance;
		this.driving();
	}
	void driving(String name, int distance) {
		this.name = name;
		this.distance = distance;
		this.driving();
	}
	void driving(int distance, String name) {//매개 변수 타입의 순서가 다름
		this.name = name;
		this.distance = distance;
		this.driving();
	}
	}
	*/
		//4
		
class Member01{
	String name;
	String id;
	String pass;
	double point;
	String regdate (String name, String id, String pass) {
		this.name = name;
		this.id = id;
		this.pass = pass;
		String ret = "이름:"+name+",아이디:"+id+",패스워드:"+pass;
		return ret;
	}
		double usePoint(double point) {
			this.point = point*0.1;
	
			return this.point;
}
		double addPoint(double addPt){
			int point = 1000;
			point += addPt;
			return point;
		}
}
}
}