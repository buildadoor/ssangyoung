package javaexp.z01_homework;

import java.util.ArrayList;

public class A18_0917 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
/*
 2022-09-16(주말과제:마감-토 21:00)
[1단계:개념] 1. 일반 배열과 동적배열(ArrayList)의 차이점을 예제를 통해서 기술하세요.
1. 고정된 배열안에 객체를 담는 처리 
 		2. 크기가 고정되어서 추가나 삭제가 불가능
[1단계:개념] 2. 동적배열 ArrayList의 활용 방법과 주요 기능 메서드를 기본 예제를 통하여 기술하세요.
		 1. 유형의 선언.
		 	ArrayList list; : 기본 Object형 데이터 선언.
		 2. 특정한 객체의 유형의 데이터 처리.
		 	ArrayList<클래스명> list = new
		 		ArrayList<클래스명>();
		 	<> : generic
		 		해당 유형의 동적배열을 선언한다는 의미이다.
		 		
		 		
[2단계:확인] 3. ArrayList<Product>를 활용하여 구매할 물건 정보 3개를 추가하여 출력처리하세요.
      int tot()메서드로 내용 출력과 물건가격*물건단가를 리턴하게 하여, 물건 3개의 총비용을 누적 처리되게 하세요
      		ArrayList<Product01> pList = new ArrayList<Product01>();
		pList.add(new Product01("아메리카노",4000,10));
		pList.add(new Product01("바닐라라떼",5000,3));
		pList.add(new Product01("에스프레소",3000,5));
		for(int idx=0;idx<pList.size();idx++) {
			Product01 p = pList.get(idx);
			System.out.println("*"+p.getpName()+"*");
			System.out.print(p.getpPrice()+"원");
			System.out.println(" "+p.getpCnt()+"잔");
			System.out.println("총액:"+p.getpTot()+"원");
		}
}
}
class Product01{
	private String pName;
	private int pPrice;
	private int pCnt;
	private int tot; 
	public Product01 (String pName, int pPrice, int pCnt) {
		this.pName = pName;
		this.pPrice = pPrice;
		this.pCnt = pCnt;
		this.tot = pCnt*pPrice;
	}
	public String getpName() {
		return pName;
	}
	public void setpName(String pName) {
		this.pName = pName;
	}
	public int getpPrice() {
		return pPrice;
	}
	public void setpPrice(int pPrice) {
		this.pPrice = pPrice;
	}
	public int getpCnt() {
		return pCnt;
	}
	public void setpCnt(int pCnt) {
		this.pCnt = pCnt;
	}
	public int getpTot() {
		return tot;
	}
	public void setpTot(int tot) {
		this.tot = tot;
	}
}
      
[1단계:개념] 4. static 멤버와 instance 멤버의 차이점을 예제를 통해 기술하세요.
		 instance
		 객체(인스턴스)마다 가지고 있는 필드와 메소드 
		 이들은 각각 인스턴스 필드, 인스턴스 메소드라고 부른다.
		 객체가 생성된 후에 사용할 수 있는 객체 소속 멤버 
		 인스턴스 멤버는 객체 소속된 멤버이기때문에 객체가 없이 사용불가능하다.
		 
 		static
		 클래스 고정된 필드와 메서드 - 정적 필드, 정적 메서드
		 객체의 공유 메모리, 클래스 소속 멤버,
		 객체 생성없이 사용 가능 
		 객체 내부에 존재하지 않고, 메소드 영역에 존재
		 정적 멤버는 객체를 생성하지 않고 클래스로 바로 접근해 사용
		 
class BuildingLotte{
	String loc; //instance변수 - 위치
	int siteCost; // instance변수 - 부지비용
	static int drawingPay; // static변수 - 도면비용



		 	

[1단계:개념] 5. static final 상수와 static 변수의 차이점을 기술하세요.
static final (상수) : 불변의 값을 의미한다 (ex. 지구의 둘레, 원주율 파이 등)
상수는 static이면서 final이어야 한다. static final 필드는 객체마다 저장되지 않고, 클래스에만 포함된다. 
한번 초기값이 저장되면 변경할 수 없다.
static : '고정된' 이란 의미를 가지고 있다. 클래스에 고정된 멤버로서 객체를 생성하지 않고 사용할 수 있다.
 객체마다 데이터를 가지고 있을 필요성이 없는 공용적인 데이터라면 static을 사용한다. 
 클래스명.필드명 으로 접근한다.

[1단계:개념] 6. package란 무엇이고 클래스/접근제어자/import와 함께 설명하세요.
package
클래스의 묶음으로, 서로 관련된 클래스끼리 그룹 단위로 묶어 놓아 클래스를 효율적으로 관리할 수 있다.

class
자바를 이루는 기본단위이다.


접근제어자
해당하는 클래스나 멤버를 외부에서 접근하지 못하도록 제한하는 것을 말하며
클래스나 멤버변수, 메서드, 생성자에 접근 제어자가 지정되어 있지 않다면 접근 제어자는 default를 뜻한다. 
접근 제어자가 사용될 수 있는 곳 => 클래스, 멤버변수, 메서드, 생성자
public : 접근 제한이 전혀 없다.
protected : 같은 패키지에서 접근 가능하다. 그리고 다른 패키지의 자손 클래스에서 접근 가능하다.
default : 같은 패키지 내에서만 접근이 가능하다.
private : 같은 클래스 내에서만 접근이 가능하다.


import
소스코드를 작성할 때 다른 패키지의 클래스를 사용하려면 클래스이름 앞에 패키지명이 있어야한다.
하지만 매번 패키지 명을 붙여서 작성하는 것은 번거롭다. 
이때 사용하는 것이 import 키워드 인데 import문으로 사용하고자 하는 패키지명과 클래스 명을 입력해준다.



[1단계:확인] 7. 아래의 여러가지 1:다 관계 클래스를 선언하고 출력하세요.
      1) 담당교수, 수강 학생
      AddClass ac = new AddClass("22년 2학기 수강신청 시스템");
			ac.setSlist(new Subject("김길동","이윤아","인사관리론"));
			ac.setSlist(new Subject("이둘리","이윤아","컴퓨터의 이해"));
			ac.setSlist(new Subject("송또치","이윤아","국제경영학"));
			ac.showList();
		} 
	}
class AddClass{
	private String system;
	private ArrayList<Subject> slist;
	public AddClass(String system) {
		this.system = system;
		this.slist = new ArrayList<Subject>();	
	}
	public void setSlist(Subject sj) {
		this.slist.add(sj);
		System.out.println(sj.getSubject()+" 과목을 추가합니다");
	}
	public void showList() {
		System.out.println(this.system);
		if(this.slist.size()>0) {
			System.out.println("*수강 신청 내역*");
			System.out.println("강의 교수명\t학생명\t과목명");
			for(Subject s:slist) {
				s.subjectInfo();
			}
		}else {
			System.out.println("수강신청 내역이 없습니다.");
		}
	}
}
class Subject{
	private String professor;
	private String student;
	private String subject;
	public Subject(String professor, String student, String subject) {
		this.professor = professor;
		this.student = student;
		this.subject = subject;
	}
	public void subjectInfo() {
		System.out.print(this.professor+"\t");
		System.out.print(this.student+"\t");
		System.out.print(this.subject+"\n");
	}	
	public String getProfessor() {
		return professor;
	}
	public void setProfessor(String professor) {
		this.professor= professor;
	}
	public String getStudent() {
		return student;
	}
	public void setStudent(String student) {
		this.student = student;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
} 
      2) 기차, 기차 좌석정보
      		OnTrain onSys= new OnTrain("코레일 예약 시스템");
			onSys.setTlist(new Ticketing("서울-수원","6호차1A",3200));
			onSys.setTlist(new Ticketing("대전-광명","9호차40D",20000));
			onSys.setTlist(new Ticketing("대구-진주","1호차3C",15000));
			onSys.showList();
		} 
	}
class OnTrain{

	private String sysName;
	private ArrayList<Ticketing> tlist;
	public OnTrain(String sysName) {
		this.sysName = sysName;
		this.tlist = new ArrayList<Ticketing>();	
	}
	public void setTlist(Ticketing tk) {
		this.tlist.add(tk);
		System.out.println(tk.getFromTo()+" 좌석을 추가합니다");
	}
	public void showList() {
		System.out.println(this.sysName);
		if(this.tlist.size()>0) {
			System.out.println("*예약 내역 리스트*");
			System.out.println("출발-도착\t좌석\t금액");
			for(Ticketing t:tlist) {
				t.ticketingInfo();
			}
		}else {
			System.out.println("예약내역이 없습니다.");
		}
	}
}
class Ticketing{
	private String fromTo;
	private String seat;
	private int pay;
	public Ticketing(String fromTo, String seat, int pay) {
		this.fromTo = fromTo;
		this.seat = seat;
		this.pay = pay;
	}
	public void ticketingInfo() {
		System.out.print(this.fromTo+"\t");
		System.out.print(this.seat+"\t");
		System.out.print(this.pay+"\n");
	}
	
	public String getFromTo() {
		return fromTo;
	}
	public void setFromTo(String fromTo) {
		this.fromTo = fromTo;
	}
	public String getSeat() {
		return seat;
	}
	public void setSeat(String seat) {
		this.seat = seat;
	}
	public int getPay() {
		return pay;
	}
	public void setPay(int pay) {
		this.pay = pay;
	}
}
[1단계:개념] 8. 상속 관계에서 super() 생성자관계에서 사용하는 규칙을 기본 예제를 통해서 기술하세요.
하위 객체는 사위 객체의 생성자를 생성하면서 처리가 된다.
default 생성자에 의해서 기본적으로 호출된다.
		 			class Grandmother {
		 				public Grandmother(){super();} 
		 				Grandmother(String s){}
		 				Grandmother(String name, int age){
		 					this(name); //
		 				}
		 			}
		 			class Mother extends Grandmother{
		 				public Mother(){
		 					super(); 
		 				}
		 				public Mother(){
		 					super("이영희")} 
		 				}
		 			}
		 		
[1단계:확인] 9. 상위로 추상 클래스 Robot 추상 메서드(attack())을 생성자로 로봇의 종류를 할당하게 하고, Dagan, Gundam을
   상속하여 해당 생성자를 통해서  호출하여 처리하고 출력되게 하세요.
   		Robot r1 = new Dagan();
		Robot r2 = new Gundam();
	    r1.attack();
	    r2.attack();
	}
	}
		abstract class Robot{
			private String kind;
			public Robot(String kind) {
				this.kind = kind;
			}
			public void move() {
				System.out.println(this.kind+" 공격을 하다");
			}
			public String getKind() {
				return kind;
			}
			public abstract void attack();
		}

		class Dagan extends Robot{
			public Dagan() {
				super("Dagan");
			}
			@Override
			public void attack() {
				System.out.println(getKind()+"이 공격하다.");
			}
		}
		class Gundam extends Robot{
			public Gundam() {
				super("Gundam");
			}
			@Override
			public void attack() {
				System.out.println(getKind()+"이 공격하다.");
		} 
}
   
   
[1단계:개념] 10. protected의 접근 범위에 대하여 예제를 통하여 기술하세요
위에서 말한대로 같은 패키지에서 접근이 가능하면서, 다른 패키지의 자손클래스에서도 접근이 가능하다.
		System.out.println("private:"+s01.favSea);
		System.out.println("public:"+s01.why);
다른 패키지에 입력하면 public은 출력이 가능하다

 */
		ArrayList<Prod> buyList = new ArrayList<Prod>();
		buyList.add(new Prod("사과",3000,2));
		buyList.add(new Prod("바나나",4000,3));
		buyList.add(new Prod("딸기",12000,4));
		int sum =0; //누적할 변수는 상단에 전역변수 
		for(int idx=0;idx<buyList.size();idx++) {
			Prod p = buyList.get(idx);
			System.out.print(p.getName()+"\t");
			System.out.print(p.getPrice()+"\t");
			System.out.print(p.getCnt()+"\t");
			int tot = p.getPrice()*p.getCnt()
;			sum+=tot; //각 단위 계를 누적해서 전체 총계 처리
			System.out.print(tot+"\n");
		}
		System.out.println("전체총계:"+sum);
	}


}

class Prod{
	 private String name;
	 private int price;
	 private int cnt; 
	public Prod(String name, int price, int cnt) {
		this.name = name;
		this.price = price;
		this.cnt = cnt;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getCnt() {
		return cnt;
	}
	public void setCnt(int cnt) {
		this.cnt = cnt;
	}
	 
 }