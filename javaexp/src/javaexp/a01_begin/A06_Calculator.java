package javaexp.a01_begin;

public class A06_Calculator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 1. 자바프로그램에서 산술연산자
		 	1) + : 문자열 이어주는 역할
		 			숫자는 합산처리
		 			cf) 주의
		 			"25" 형변환이 된 숫자형태의 문자열은 문자열이어주는 처리가 된다.
		 			System.out.println(25+25); 50
		 			System.out.println(""25+25); "2525"
		 			System.out.println(""+(25+25)); "50" 연산 후 문자열
		 			()는 연산자 처리의 최우선 순위 
		 			*,/ > +,-
		 			
		 			int num01 = 25;
		 			int num02 = 30;
		 			System.out.println(""+num01 + num02);
					System.out.println(""+(num01 + num02));
		
		 	2) - : 뺄셈
		 		System.out.println(25*5); 75
		 		System.out.println(""+25*5);"75" 
		 		System.out.println(""+(25*5));"75"
		 	3) * : 곱셈
		 		System.out.println(25-5); 20
		 		System.out.println(""+25-5); X에러
		 		System.out.println(""+25-5); X에러		 		
		 	4) / : 나눗셈 (자바만)
		 		정수/정수 : 소숫점이하 절삭 
		 		System.out.println(10/3); 3
		 		정수/실수 : 소숫점이하 표시
		 		System.out.println(10/3.0); 3.3333
		 		System.out.println(10.0/3); 3.333
		 		System.out.println(10.0/3.0); 3.33333
		 		정수/(형변환)실수 : 소숫점이하 표시 
		 		System.out.println(10/(double)3); 3.3333
		 		System.out.println((double)10/3); 3.333
		 		System.out.println((double)10.0/(double)3); 3.33333
		 	5) % : 나머지값
		 		27%5 ==> 2
		 		11%2 ==> 1
		 		
		 		cf) 정수형/정수형 : 몫
		 			정수형%정수형 : 나머지값
		 	ps) 반복적인 처리프로세스에서 활용도가 높다.
		 	1~10까지 중에 짝수만 합산한다.
		 	if(cnt%2==0)
		 	홀수인 번호인 경우에 특정 처리를 한다.
		 	if(cnt%2==1)
		 
		 
		 
		 */
		int num01 = 25;
		int num02 = 30;
		System.out.println(""+num01 + num02);
		System.out.println(""+(num01 + num02));
		System.out.println(""+(num01 - num02));
//		System.out.println(""+num01 - num02); //에러 
		System.out.println(""+num01 * num02); //연산식에서는 자동형변환이 일어나지 않는다.
		System.out.println(25/7);
		System.out.println(25/7.0);
		System.out.println(25/(double)7); //casting으로 형변환처리
		System.out.println("나머지(%):"+25%7);
		//ex) 어떤 수를 홀수 짝술 구분하기 위한 처리를 할때 나머지 연산자를 사용한다.
		System.out.println(1%2);
		System.out.println(2%2);
		System.out.println(3%2);
		System.out.println(4%2);
		System.out.println(5%2);
		
		/* 문제
		 
		 ex1) 사과 (2000)를 5개 구매했을 때, 총계 
		 ex2) 현재 가지고 있는 금액이 100000일때, 위 사과를 구매하고 나머지 잔액
		 ex3) 곰돌이 5마리가 빵을 23개를 먹을 때, 송평하게 나눈 빵의 갯수와 나머지 빵의 갯수  
		 
		 변수 선언, 변수를 통해서 사칙 연산자를 처리한 결과를 출력
		 */
		
		
		/* 내가 푼 것
		 *물건명:사과
		갯수:5
		총계:10000원
		잔액:90000원
		나눈 빵:4개
		남은 빵:3개

		String name = "사과";
		 int price = 2000;
		 int cnt= 5;
		 System.out.println("물건명:"+name);
		 System.out.println("갯수:"+cnt);
		 System.out.println("총계:"+(price*cnt)+"원");
		 
		 System.out.println("잔액:"+((100000-10000)+"원"));
		 
		 int bear = 5;
		 int cnt2 = 23;
		 System.out.println("나눈 빵:"+((cnt2/bear)+"개"));
		 System.out.println("남은 빵:"+((cnt2%bear)+"개"));
		 */
		//해설
		int applePrice = 2000;
		int appleCnt = 5;
		int appleTot = applePrice*appleCnt;
		System.out.println("사과의 구매 총계:"+(appleTot));
		
		int money = 100000;
		System.out.println("구매후 잔액:"+(money-appleTot));
		
		int bearCnt = 5;
		int breadCnt = 23;
		System.out.println("공평하게 나눈 빵의 갯수:"+breadCnt/bearCnt);
		System.out.println("나눈 후 나머지 빵의 갯수:"+breadCnt%bearCnt);
	}

}
