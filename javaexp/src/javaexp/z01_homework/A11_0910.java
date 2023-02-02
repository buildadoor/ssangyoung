package javaexp.z01_homework;

public class A11_0910 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
/*
2022-09-10
[1단계:개념] 1. 배열과 반복문의 관계를 기술하고, 학생 30명을 임의의 점수(0~100)로 배열에 할당/출력하세요.
		  
		  처리하고자 하는 데이터가 대량일 경우 반복적으로 처리하는데에 반복문을 이용한다면 그 많은 데이터를 정리하는데에 배열을 이용한다.
(배열은 데이터들의 집합이고, 반복문은 많은 데이터들의 반복되는 작업을 처리하는 도구이기 때문에,
특히나 for문은 반복횟수가 정해진 경우에 사용하는 것이 좋아서 배열과 같이 쓰기에 유용)
		 		int grade = (int)(Math.random()*101);		
				for(int cnt=1;cnt<=30;cnt++) {
				int[] student = new int[30];  
				System.out.println(cnt+"번째 학생의 점수:"+(int)(Math.random()*101));
			}
	
	}
}
		
[1단계:응용] 2. 무지개 색상을 배열로 선언하고, 이 중에서 임의의 색상 3개를 출력하세요
		String[]rainbow = {"빨강색","주황색","노랑색","초록색","파랑색","남색","보라색"};
		int ranCo1 = (int)(Math.random()*rainbow.length);
		int ranCo2 = (int)(Math.random()*rainbow.length);
		int ranCo3 = (int)(Math.random()*rainbow.length);
		System.out.println("#세가지 랜덤 무지개색깔#");
		System.out.println(rainbow[ranCo1]+","+rainbow[ranCo2]+","+rainbow[ranCo3]);
	}
		}
[1단계:개념] 3. 클래스와 객체의 관계를 메모리를 활용하여 설명하고, 주소값을 출력하세요..
		 	1)현실세계 : 설계도 ==> 구체적은 사물/객체 
		    	자바 : 클래스 ==> 객체
		 	2)클래스에는 객체를 생성하기 위한 필드와 메소드가 정의
		 	3)클래스로부터 만들어진 객체를 해당 클래스와 인스턴스(instance)
		 	4)하나의 클래스로부터 여러개의 인스턴스를 만들 수 있다.
		 	하나의 롯데월드타워 도면으로 부터 서울, 부산, 제주도에 실제 건물을 건축할 수 있다.
			Computer c1 =new Computer();
			System.out.print(c1);
[1단계:개념] 4. 클래스를 통해 만들어진 객체와 일반 primitive 데이터와 어떠한 차이점이 있는지 기술하세요.
			기본 타입 변수 primitive 데이터는  실제 값을 변수 안에 저장한다
			cf) stack영역에 선언하고 실제 데이터를 할당함
			참조 타입 변수 클래스로 만들어진 객체는 주소를 통해 객체 참조한다
			cf) heap영역에 저장하고 이 heap영역의 주소값을 stack영역에 저장함
[1단계:확인] 5. 아래와 같이 여러가지 생성자를 초기화하고 출력하세요.
1) Singer 클래스를 선언하고 매개변수로 이름, 소속사, 메인곡을 선언하고, 생성자를 통해서 초기화 하고 출력하세요.
2) Game 클래스를 선언하고 출시회사, 비용, 인기순

	Singer s1 = new Singer();
		s1.singer = "블랙핑크";
		s1.company = "YG";
		s1.song = "PinkVenom";
		System.out.println("#첫번째 걸그룹#");
		System.out.println("가수 :"+s1.singer);
		System.out.println("소속사 :"+s1.company);
		System.out.println("메인곡 :"+s1.song);//생성자를 통해 초기화된 데이터 사용
		Singer s2 = new Singer();
		System.out.println("#두번째 걸그룹#");
		System.out.println("가수:"+s2.singer);
		System.out.println("소속사:"+s2.company);
		System.out.println("메인곡:"+s2.song);
	}
	}

class Singer{
	String singer="레드벨벳";
	String company="SM";
	String song="Feel My Rhythm";
	Singer(){}
	Singer(String singer, String company, String song){
		this.singer = singer;
		this.company = company;
		this.song = song;
	}
	Singer(String company, String song){
		this.singer = singer;
		this.company = company;
		this.song = song;
		
	}
			Game g1 = new Game();
		Game g2 = new Game("넥슨", 3);
		Game g3 = new Game("넷마블");
		Game g4 = new Game(1000000000,1);
		System.out.println(g1);
		System.out.println(g1.gCom);
		System.out.println(g1.money);
		System.out.println(g1.rank);
		System.out.println(g2);
		System.out.println(g2.gCom);
		System.out.println(g2.money);
		System.out.println(g2.rank);
		System.out.println(g3);
		System.out.println(g3.gCom);
		System.out.println(g3.money);
		System.out.println(g3.rank);
		System.out.println(g4);
		System.out.println(g4.gCom);
		System.out.println(g4.money);
		System.out.println(g4.rank);
	}

}
class Game{
	String gCom;
	int money;
	int rank;
	Game(){
		this.gCom= "없음";
		this.money = 0;
		this.rank=0;
	}
	Game(String gCom, int money){
	this.gCom="넷마블";
	this.money =50000000;
	}
	Game(String gCom){
	this.money = 200000000;
	this.rank = 2;
}
	Game(int money, int rank){
	this.gCom="데브시스터즈";
	}
}

2022-09-10
[1단계:개념] 1. 배열과 반복문의 관계를 기술하고, 학생 30명을 임의의 점수(0~100)로 배열에 할당/출력하세요.
[1단계:응용] 2. 무지개 색상을 배열로 선언하고, 이 중에서 임의의 색상 3개를 출력하세요
[1단계:개념] 3. 클래스와 객체의 관계를 메모리를 활용하여 설명하고, 주소값을 출력하세요..
[1단계:개념] 4. 클래스를 통해 만들어진 객체와 일반 primitive 데이터와 어떠한 차이점이 있는지 기술하세요.
[1단계:확인] 5. 아래와 같이 여러가지 생성자를 초기화하고 출력하세요.
1) Singer 클래스를 선언하고 매개변수로 이름, 소속사, 메인곡을 선언하고, 생성자를 통해서 초기화 하고 출력하세요.
2) Game 클래스를 선언하고 출시회사, 비용, 인기순
*/

	}
}