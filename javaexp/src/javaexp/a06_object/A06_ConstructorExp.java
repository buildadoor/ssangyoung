package javaexp.a06_object;

public class A06_ConstructorExp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	/*
		Fruit f1 = new Fruit();
		System.out.println("과일 이름:"+f1.fName);
		System.out.println("갯수:"+f1.cnt+"개");
		Fruit f2 = new Fruit("망고",5);
		System.out.println("과일 이름:"+f2.fName);
		System.out.println("갯수:"+f2.cnt+"개");
		Book99 b1 = new Book99();
		System.out.println("도서명: "+b1.bName);
		System.out.println("출판사: "+b1.bComp);
		Book99 b2 = new Book99("지적대화를위한넓고얕은지식","한빛비즈");
		System.out.println("도서명: "+b2.bName);
		System.out.println("출판사: "+b2.bComp);
		Mouse m1 = new Mouse();
		System.out.println("이름: "+m1.mName);
		System.out.println("제조사: "+m1.mComp);
		Mouse m2 = new Mouse("K380","마이크로소프트");
		System.out.println("이름: "+m2.mName);
		System.out.println("제조사: "+m2.mComp);
		Taxi t1 = new Taxi();
		System.out.println("지역: "+t1.locate);
		System.out.println("차종: "+t1.car);
		Taxi t2= new Taxi("서울","그랜저");
		System.out.println("지역 : "+t2.locate);
		System.out.println("차종: "+t2.car);
	}

}*/
		Fruit f1 = new Fruit("딸기",3);
		Book99 b1 = new Book99("자바기초","자바맨");
		Mouse m1 = new Mouse("휠마우스","삼성");
		Taxi t1 = new Taxi("서울경기","그랜저");
	}
}
/*
#아래의 필드값을 초기화하는 생성자를 선언하고, 
필드값을 출력하는 클래스를 정의 및 호출하세요  
과일(종류,갯수), 도서99(도서명, 출판사)
마우스(이름, 제조사), 택시(지역, 차종)
 */
/*
class Fruit{
String fName="바나나";
int cnt=2;
Fruit(){}
Fruit(String fName, int cnt){
	this.fName = fName;
	this.cnt = cnt;
}
}
class Book99{
String bName="백년의 독서";
String bComp="비전과 리더십";
Book99(){}
Book99(String bName, String bComp){
	this.bName = bName;
	this.bComp = bComp;
}
}
class Mouse{
	String mName="m350";
	String mComp="로지텍";
	Mouse(){}
	Mouse(String mName, String mComp){
		this.mName = mName;
		this.mComp = mComp;
	}
}
class Taxi{
	String locate="천안";
	String car="아이오닉5";
	Taxi(){}
	Taxi(String locate, String car){
		this.locate = locate;
		this.car = car;
		*/
class Fruit{
	String kind;
	int cnt;
	Fruit(String kind, int cnt){
		this.kind = kind;
		this.cnt = cnt;
		System.out.println("#과일 객체 생성#");
		System.out.println("종류: "+kind);
		System.out.println("갯수: "+cnt);
	}
}
class Book99{
	String title;
	String publisher;
	Book99(String title, String publisher){
		this.title = title;
		this.publisher = publisher;
		System.out.println("#도서 객체 생성#");
		System.out.println("도서명: "+title);
		System.out.println("출판사: "+publisher);
	}
	}
class Mouse{
	String name;
	String comp;
	Mouse(String name, String comp){
		this.name = name;
		this.comp = comp;
		System.out.println("#마우스 객체 생성#");
		System.out.println("마우스 종류: "+name);
		System.out.println("제조사: "+comp);
	}
}
class Taxi{
	String loc;
	String kind;
	Taxi(String loc, String kind){
		this.loc = loc;
		this.kind = kind;
		System.out.println("#택시 객체 생성#");
		System.out.println("운행지역: "+loc);
		System.out.println("차종: "+kind);
	}
	}
	
	

