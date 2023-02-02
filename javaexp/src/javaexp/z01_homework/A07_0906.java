package javaexp.z01_homework;

import java.util.Scanner;

public class A07_0906 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
/*
 2022-09-06
[1단계:개념] 1. 문자열 객체 생성 형식 2가지를 기술하고, heap영역 사용의 차이점을 기술하세요.
 			1. String name01 = "김영희";
			String name02 = "김영희";
			"김영희"를 기준해서 heap영역에 할당된 동일한 주소를 name01, name02에서 호출해서 사용한다.
			
		 	2. String name03 = new String("김영희");
			String name04 = new String("김영희");
		 	new String()를 입력, heap영역에 주소를 사용해서 "김영희"를
		 	name03과 name04에 각각 대입하여 사용한다.
		 
[3단계:코드] 2. 문자열 배열로 5개의 회원아이디를 선언/할당 하고, Scanner를 통해서 등록된 아이디가 있는지 여부를 확인하는 프로그램을 처리하세요
              - 온라인에서 회원등록시, 동일한 회원 아이디 등록여부 check
              ex) 회원아이디입력:@@@ 
                  등록된 아이디가 있습니다..
                  등록 가능한 아이디입니다.
                  	Scanner sc = new Scanner(System.in);
			char[]id = new char[5];
			for(int idx=0;idx<id.length;idx++) {
				int rId = (int)(Math.random()*26+97); 
			id[idx] = (char)rId;
			}	
			System.out.println("# 회원가입을 환영합니다 #");
			System.out.print("회원 가입할 아이디를 소문자5글자로 입력하세요:");
			String newId = sc.nextLine();
			System.out.println("# 중복되는 아이디 여부 확인#");
			if(newId.equals(id)) {
				System.out.println("기존에 등록된 아이디가 있습니다");
			}else {
				System.out.println("등록 가능한 아이디 입니다.");
			}

		}
[1단계:개념] 3. 클래스와 객체의 개념와 차이점을 예제와 함께 기술하세요.
			1. 현실 세계 비유
			현실세계 : 설계도 ==> 구체적은 사물/객체
			자바 : 클래스 ==> 객체
			2. 클래스에는 객체를 생성하기 위한 필드와 메소드가 정의
			3. 클래스로부터 만들어진 객체를 해당 클래스와 인스턴스(instance)
			4. 하나의 클래스로부터 여러개의 인스턴스를 만들 수 있다.
			하나의 롯데월드타워 도면으로 부터 서울, 부산, 제주도에 실제 건물을 건축할 수 있다.
			위 Book 클래스를 통해 b1,b2,b3의 객체를 생성하여 이름을 할당..
[1단계:개념] 4. 클래스의 구성요소를 각각의 기능과 내용을 예제를 통해서 기술하세요
	 		 필드 : 객체의 데이터가 저장되는 곳
	 		 생성자 : 객체 생성시 초기화 역할 담당
	 	 	 메소드: 객체의 동작에 해당하는 실행 블록
	 	 	 
			Food f1 = new Food("떡볶이(분식)");
			System.out.println("음식:"+f1.food);
			f1.move();
			Food f2 = new Food("순대(분식)");
			System.out.println("음식:"+f2.food);
			f2.move();
	}	
	}
			class Food{
			String food;//필드 : 객체의 구성요소의 모든 공간에 전역적으로 할당 및 호출이 가능한 데이터 
			Food(String food){
				this.food = food; //생성자의 매개변수로 분식(이름)을 저장
								 //생성자
			System.out.println("생성자/분식 종류");
			}
			void move() {
						//메서드
			System.out.println(food+"를 먹는다");
	}		
}
[1단계:코드] 5. 좋아하는 운동선수의 이름과 성적을 처리할 수 있는 클래스를 선언하고, 
				객체 3개를 생성하여 선수의 정보를 할당/출력(main()에서)하게 하세요.
				//	좋아하는 운동선수의 이름과 성적을 처리할 수 있는 클래스를 선언하고, 
	//	객체 3개를 생성하여 선수의 정보를 할당/출력(main()에서)하게 하세요
		Player p1 = new Player();
		System.out.println("#국내 쇼트트랙 1500m 여자 선수 세계랭킹#");
		System.out.println("이름: "+p1.pName);
		System.out.println("순위: "+p1.score+"위");
		Player p2 = new Player();
		p2.pName="최민정"; p2.score=7;
		System.out.println("이름: "+p2.pName);
		System.out.println("순위: "+p2.score+"위");
		Player p3 = new Player();
		p3.pName="김아랑"; p3.score=8;
		System.out.println("이름: "+p3.pName);
		System.out.println("순위: "+p3.score+"위");
	}
	}
class Player {
	String pName="이유빈";
	int score=1;
	Player(){}
	Player(String pName, int score){
	this.pName = pName;
	this.score = score;
	}

}	
[1단계:개념] 6. default 생성자란 무엇이며, 사라지는 시점은 언제인가 기술하세요.
			 인자가 없는 생성자로 클래스명() 으로 선언되어있는 생성자다.
			모든 클래스는 하나 이상의 생성자를 가지며 그 객체가 사라지면 생성자도 소멸된다.
[1단계:코드] 7. 생성자를 여러 개 선언할 수 있는 규칙이 무엇이라 하고, 이것이 가능한 이유를 예제를 통해 기술하세요.
			"오버로딩 (overloading)"생성자는 매개변수의  갯수, 타입, 순서가 다르면 여러개 선언이 가능하다.
				Phone p1 = new Phone ();
				Phone p2 = new Phone ("삼성");
				Phone p3 = new Phone ("애플"+"아이폰"+1000000);
				Phone p4 = new Phone ("홍마"+"샤오미");
				Phone p5 = new Phone (700000+"LG");
		
	}

		}
class Phone{
String brand;
String pName;
int pPrice;
Phone(){}
Phone(String brand){
this.brand = brand;
}	
Phone(String brand,String pName,int pPrice){
this.brand = brand;
this.pName = pName;
this.pPrice = pPrice;
}
Phone(String pName,String brand){
this.pName = pName;
this.brand = brand;
}	
Phone(int pPrice,String brand){
this.pPrice= pPrice ;
this.brand = brand;
}
}

[1단계:코드] 8. 아래의 클래스를 생성자를 통해서 초기값을 할당하고 필드를 출력하세요(단계별로 선언, 초기값-->main할당-->1개 매개 생성자할당-->여러개 매개 생성자할당)
               1) 볼펜(제조사,심두께), 음식(종류,가격), 산(이름, 위치,해발고도)
		Pen p1 = new Pen();
		System.out.println("초기에 할당된 데이터 호출");
		System.out.println("제조사:"+p1.company);
		System.out.println("심두께:"+p1.mm+"mm");
		Pen p2 = new Pen();
		p2.company="모닝글로리"; p2.mm=0.3;
		System.out.println("main()에서 할당하여 호출하는 경우");
		System.out.println("제조사:"+p2.company);
		System.out.println("심두께:"+p2.mm+"mm");
		Pen p3 = new Pen("동아",1.0);
		System.out.println("생성자를 통해 초기화된 데이터 사용");
		System.out.println("제조사:"+p3.company);
		System.out.println("심두께:"+p3.mm+"mm");

		Food f1 = new Food();
		System.out.println("초기에 할당된 데이터 호출");
		System.out.println("음식 이름:"+f1.menu);
		System.out.println("가격:"+f1.price+"원");
		Food f2 = new Food();
		f2.menu="떡볶이"; f2.price=12000;
		System.out.println("main()에서 할당하여 호출하는 경우");
		System.out.println("음식 이름:"+f2.menu);
		System.out.println("가격:"+f2.price+"원");
		Food f3 = new Food("피자",18000);
		System.out.println("생성자를 통해 초기화된 데이터 사용");
		System.out.println("음식 이름:"+f3.menu);
		System.out.println("가격:"+f3.price+"원");
		
		Mountain m1 = new Mountain();
		System.out.println("초기에 할당된 데이터 호출");
		System.out.println("산 이름:"+m1.name);
		System.out.println("위치:"+m1.place);
		System.out.println("해발 고도:"+m1.high+"m");
		Mountain m2 = new Mountain();
		m2.name="북한산"; m2.place="서울"; m2.high=835;
		System.out.println("초기에 할당된 데이터 호출");
		System.out.println("산 이름:"+m2.name);
		System.out.println("위치:"+m2.place);
		System.out.println("해발 고도:"+m2.high+"m");
		Mountain m3 = new Mountain("지리산","함양",1915);
		System.out.println("초기에 할당된 데이터 호출");
		System.out.println("산 이름:"+m3.name);
		System.out.println("위치:"+m3.place);
		System.out.println("해발 고도:"+m3.high+"m");
		

}
}

	class Pen{
	String company="모나미";
	double mm=0.7;
	Pen(){}
	Pen(String company,double mm){
		this.company = company;
		this.mm = mm;

}
}
	class Food{
	String menu="마라탕";
	int price=15000;
	Food(){}
	Food(String menu,int price){
		this.menu = menu;
		this.price = price;
	}
	}
	class Mountain{
	String name="한라산";
	String place="제주도";
	int high=1947;
	Mountain(){}
	Mountain(String name,String place,int high){
		this.name = name;
		this.place = place;
		this.high = high;
	}
	} 
	*/
	//해설 
		/*
		 2022-09-06
[1단계:개념] 1. 문자열 객체 생성 형식 2가지를 기술하고, heap영역 사용의 차이점을 기술하세요.
[3단계:코드] 2. 문자열 배열로 5개의 회원아이디를 선언/할당 하고, Scanner를 통해서 등록된 아이디가 있는지 여부를 확인하는 프로그램을 처리하세요
              - 온라인에서 회원등록시, 동일한 회원 아이디 등록여부 check
              ex) 회원아이디입력:@@@ 
                  등록된 아이디가 있습니다..
                  등록 가능한 아이디입니다.
             #처리 순서
             1. 등록된 회원아이디가 있는 배열 선언
             2. Scanner 선언
             3. 반복적으로 등록 가능한 아이디입니다. 나올때까지 반복
		 		while(true){} *****핵심
		 	 4. 등록된 회원아이디의 배열 내용을 check해서 
		 	 	한개이상 아이디가 있으면 등록된 아이디가 있습니다.
		 	 	
		 	 	inputId = sc.nextLine();
		 	 	boolean hasId = false; //초기에 없는 것 
		 	 	for(int idx=0;idx<members.length;idx++){
		 	 		if(inputId.equals.(members[idx]){
		 	 			hasId = true; //하나라도 있으면 true 
		 	 		}
		 	 	}
		 	 5. 등록된 아이디가 없을때 반복문을 종료처리 
		 	 	3 while문을 break 처리 
		 	 	if( !hasId ){//not hasI : 등록된 아이디가 없을때//
		 	 		System.out.println("입력된 아이디로 등록 가능합니다");
		 	 		break;
		 	 	}else{
		 	 		system.out.println("입력된 아이디는 등록되었습니다.");
		 	 		system.out.println("다시 아이디를 등록하세요.");
		 	 		}
		 	 	}
		 	 6. 등록 가능한 아이디입니다를 출력..
		 		*/
			String[] mems = {"himan","higirl","goodman","badgirl","happyMan"};
			Scanner sc = new Scanner(System.in);
			while(true) {
				System.out.print("등록할 아이디 입력:");
				String inputId = sc.nextLine(); // 입력한 id
				boolean hasId = false; //아이디가 없는 것을 초기화 
				for(int idx=0;idx<mems.length;idx++) {
				 //배열 내용을 check해서 하나라도 있으면
				//hasId를 true로 처리
					if(inputId.equals(mems[idx])) {
						hasId = true;
					}
					}
				if(!hasId) {
					System.out.println("입력한 아이디는 등록 가능합니다.");
					break; //반복문을 종료
				 }else {
					 System.out.println("등록된 아이디가 있습니다. 다시 아이디를 입력!");
				 }
				 }
				
				
			
		/*
[1단계:개념] 3. 클래스와 객체의 개념와 차이점을 예제와 함께 기술하세요.
[1단계:개념] 4. 클래스의 구성요소를 각각의 기능과 내용을 예제를 통해서 기술하세요
[1단계:코드] 5. 좋아하는 운동선수의 이름과 성적을 처리할 수 있는 클래스를 선언하고, 객체 3개를 생성하여 선수의 정보를 할당/출력(main()에서)하게 하세요.
[1단계:개념] 6. default 생성자란 무엇이며, 사라지는 시점은 언제인가 기술하세요.
[1단계:코드] 7. 생성자를 여러 개 선언할 수 있는 규칙이 무엇이라 하고, 이것이 가능한 이유를 예제를 통해 기술하세요.
[1단계:코드] 8. 아래의 클래스를 생성자를 통해서 초기값을 할당하고 필드를 출력하세요(단계별로 선언, 초기값-->main할당-->1개 매개 생성자할당-->여러개 매개 생성자할당)
               1) 볼펜(제조사,심두께), 음식(종류,가격), 산(이름, 위치,해발고도)
		 */
		
	}

}