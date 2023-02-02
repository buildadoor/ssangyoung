package javaexp.z01_homework;

import java.util.Scanner;

public class A10_0909 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
/*
 2022-09-09
[1단계:코드] 1. 짜장면(5000), 짬뽕(6000)의 가격으로 되었을 때, 증감 연산자를 활용해서
1~3, 1~5까지의 총비용을 출력하세요.
		int jajang = 5000;
		int jjambbong = 6000;
		int totPay01 = 0;
		int totPay02 = 0;
		for(int cnt=1;cnt<=3;cnt++) {
			System.out.println("짜장"+cnt+"그릇 "+jajang*cnt+"원");
				totPay01+=jajang*cnt;
		}
		for(int cnt1=1;cnt1<=5;cnt1++) {
			System.out.println("짬뽕"+cnt1+"그릇 "+jjambbong*cnt1+"원");
			totPay02+=jjambbong*cnt1;
		}
		System.out.println("짜장 총비용:"+totPay01+"원");
		System.out.println("짬뽕 총비용:"+totPay02+"원");
		
		}
	}
[1단계:개념] 2. 단항연산자, 이항연산자, 삼항 연산자의 차이점을 개념과 예제를 통해 기술하세요.
			 단항, 이항, 삼항 연산자는 피연산자의 갯수로 나누어진다.
			 단항 연산자: 부호 연산자(+,-) 증감 연산자(++,--) 등 
			 이항 연산자: 산술연산자(+.-,*,/,%), 비교연산자(<,<=,>=,==,!=),논리연산자
			 			(&&,||,&)등
			 삼항 연산자: 조건식으로 true/false를 실행 
			 			ex)숫자를 2로 나눴을때 짝수 홀수 
			 			int numb = 3;
				String enter = ((numb%2==0)?"짝수":"홀수");
					System.out.println(enter);
	}
		}
[1단계:코드] 3. 100에서 1/4로  4회 누적해서 나눈 값을 아래의 형식으로 출력 하세요
초기데이터 100
1회  25
2회  6.2..
3회  1.54...
4회  0.38..
[2단계:코드] 4. [continue 활용]1~12월까지 마지막일수10으로 월급여 산정하되,
31일만 있는 월만 산정해서 출력하고 나머지 월(30일, 28일까지 있는 달)은 산정 처리하지 않고 총 급여을 아래와 같이 출력하세요
월  일수   월급여 누적연봉
1월 31일  310만 310만원
3월 31일  310만 620만원
5월 31일  310만 930만원
..
12 31일  ..
 int salary = 3100000;
		int saTot = 0;
		System.out.println("월\t일수\t월 급여\t\t누적 연봉");
		for(int mt= 1;mt <= 12;mt++){
			if(mt==2)
			if(mt==4)
			if(mt==6)
			if(mt==9)
			if(mt==11) continue; 
			saTot+=salary;
			System.out.println(mt+"월\t"+31+"일\t"+salary+"원\t"+saTot+"원");
	}
	}
	}
[2단계:응용] 5. 두명(컴퓨터vs컴퓨터)의 구슬 홀짝게임 : 한명이 구슬 10개를 가지고 임의의로 쥐게 하여,
다른 한명이 이것을 맞추었는지 여부에 따라 승/패로 출력하게 하세요.
///*****비교 연산자가 틀린건지 승/패여부가 섞여서 나옴 
		int game = (int)(Math.random()*10+1);//0.1
		System.out.println("@@~구슬 홀짝 게임~@@");
		int com01 = (int)(Math.random()*10+1);
		int com02 = (int)(Math.random()*10+1);
		System.out.println("컴퓨터의 선택:"+com01);	
		System.out.print("다른 컴퓨터의 정답:");
		if(com01%2==0) {
			System.out.println("@짝@");
		}else if(com01%2==1){	
			System.out.println("@홀@");
		}
		if(com02==com01) {
			System.out.println("컴퓨터2가 이겼습니다.");
		}else { 
			System.out.println("컴퓨터1이 이겼습니다.");
		}
	}
}
[1단계:응용] 6. 두 팀(홍/청-컴퓨터vs컴퓨터)이 주사위를 던져 홍팀의 결과를 출력하세요(승/무/패)
	System.out.println("#주사위 게임 #");
		String player01 = ("청팀");
		String player02 = ("홍팀");
		int player01Dice = (int) (Math.random()*6+1);
		int player02Dice = (int) (Math.random()*6+1);
		System.out.println(player01+":"+player01Dice);
		System.out.println(player02+":"+player02Dice);
		String rs = player01Dice>player02Dice?player01+"승":(player01Dice<player02Dice?player02+"승":"무승부");
		System.out.println("결과:"+rs);
	}
	}
		
[2단계:응용] 7. while문 숫자 맞추기 게임, 컴퓨터가 임의로 1~100범위의 숫자를 저장하면,
while문을 통해서 해당 숫자를 입력한다. 비교해서 동일하면 종료,
//**컴퓨터의 임의 범위 , 내가 입력하는 숫자까지 .. 
		
		System.out.println("숫자 맞추기 게임");
		Scanner sc = new Scanner(System.in);
		System.out.print("내가 선택한 숫자:");
		String myChoice = sc.nextLine();
		int comCho = 100;
		while(comCho>=1) {
			int ran = (int)(Math.random()*100+1);
				System.out.print("컴퓨터의 랜덤 숫자:"+ran);		
		}
		}
	}

[1단계:개념] 8. 참조변수가 무엇인지? 메모리 영역을 기본 데이터유형과 비교하여
기본 예제를 통해서 설명하세요.
기본 타입 변수 - 실제 값을 변수 안에 저장
 stack영역에 선언하고 실제 데이터를 할당
 int phoneCase = 15000;
참조 타입 변수 - 주소를 통해 객체 참조
heap영역에 저장하고 이 heap영역의 주소값을 stack영역에 저장한다.
int[] phoneCase = {15000}; // heap영역에 주소를, stack영역에 phoneCase
[1단계:확인] 9. Music 클래스를 선언하고, 해당 m01, m02 참조변수를 선언하고, 비교하세요.
Music m01 =new Music();
		Music m02 =new Music();
		System.out.println(m01); 
		System.out.println(m02);
	}
	}
		class Music{
		}
		2022-09-09
[1단계:코드] 1. 짜장면(5000), 짬뽕(6000)의 가격으로 되었을 때, 증감 연산자를 활용해서
1~3, 1~5까지의 총비용을 출력하세요.
[1단계:개념] 2. 단항연산자, 이항연산자, 삼항 연산자의 차이점을 개념과 예제를 통해 기술하세요.
[1단계:코드] 3. 100에서 1/4로  4회 누적해서 나눈 값을 아래의 형식으로 출력 하세요
초기데이터 100
1회  25
2회  6.2..
3회  1.54...
4회  0.38..
[2단계:코드] 4. [continue 활용]1~12월까지 마지막일수10으로 월급여 산정하되,
31일만 있는 월만 산정해서 출력하고 나머지 월(30일, 28일까지 있는 달)은 산정 처리하지 않고 총 급여을 아래와 같이 출력하세요
월  일수   월급여 누적연봉
1월 31일  310만 310만원
3월 31일  310만 620만원
5월 31일  310만 930만원
..
12 31일  ..
[2단계:응용] 5. 두명(컴퓨터vs컴퓨터)의 구슬 홀짝게임 : 한명이 구슬 10개를 가지고 임의의로 쥐게 하여,
다른 한명이 이것을 맞추었는지 여부에 따라 승/패로 출력하게 하세요.
[1단계:응용] 6. 두 팀(홍/청-컴퓨터vs컴퓨터)이 주사위를 던져 홍팀의 결과를 출력하세요(승/무/패)
[2단계:응용] 7. while문 숫자 맞추기 게임, 컴퓨터가 임의로 1~100범위의 숫자를 저장하면,
while문을 통해서 해당 숫자를 입력한다. 비교해서 동일하면 종료,
[1단계:개념] 8. 참조변수가 무엇인지? 메모리 영역을 기본 데이터유형과 비교하여
기본 예제를 통해서 설명하세요.
[1단계:확인] 9. Music 클래스를 선언하고, 해당 m01, m02 참조변수를 선언하고, 비교하세요.


 */
	}

}
