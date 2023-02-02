package javaexp.z01_homework;
import java.util.Scanner;
public class A03_0831 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
/*
 2022-08-31
[1단계:개념] 1. Scanner객체의 사용방법을 예제를 통하여 기술하세요.
			1) import java.utill.Scanner;
			2) 객체생성 Scanner sc01 = new Scanner(System.in);
			3) 기능메서드 
			String strLine= sc01.nextLine();
			int num01 = sc01.nextInt();
			double num02 = sc01.nextDouble();
			String str = sc01.next();
			
[1단계:코드] 2. Scanner객체를 활용하여 타율계산방법을 확인(검색)하고, 선수명과 함께 입력데이터를 입력 받아 해당 타자의 타율을 출력하세요.
*/ 
		/* 
		Scanner sc01 = new Scanner(System.in);
		// ctrl+shift+o : import 처리 단축키
		System.out.println("# 타율 계산 #");
		System.out.println("타석의 횟수를 입력하세요:");
		int bset = sc01.nextInt();
		System.out.println("안타수를 입력하세요:");
		int hit = sc01.nextInt();
		double hitRatio = (double)hit/bset;
		System.out.println("타율:"+hitRatio);
		*/
/*			
[1단계:개념] 3. 숫자형 문자열의 숫자 변환 형식을 예제를 통하여 기술하세요.
			정수형 변환 : int num01 = Integer.parseInt("25");
			실수형 변환 : double num02 = Double.parseDouble("25.25");
			
[1단계:코드] 4. args로 물건1 가격1 갯수1 물건2 가격2 갯수2로 입력받아 계산서를 출력하세요.
			argument 추가 
			*/
			/*String pname01 = args[0];
			int price01 = Integer.parseInt(args[1]);
			int cnt01 = Integer.parseInt(args[2]);
			String pname02 = args[3];
			int price02 = Integer.parseInt(args[4]);
			int cnt02 = Integer.parseInt(args[5]);
			int tot = 0;
			System.out.println("\t # 계산서 #");
			System.out.println("물건명\t가격\t갯수\t계");
			System.out.print(pname01+"\t");
			System.out.print(price01+"\t");
			System.out.print(cnt01+"\t");
			System.out.print(price01*cnt01+"\n");
			tot += price01*cnt01;
			System.out.print(pname02+"\t");
			System.out.print(price02+"\t");
			System.out.print(cnt02+"\t");
			System.out.print(price02*cnt02+"\n");
			tot += price02*cnt02;
			System.out.println("총계:"+tot);
		/*
[1단계:개념] 5. 연산자와 피연산자, 연산식의 개념을 예제와 함께 기술하세요.
			연산자 : 산술연산자, 대입연산자, 비교 연산자, 논리연산자로 
					대상이 되는 데이터를 연산식으로 처리해주는 기능을 가지고 있다.
			피연산자 : 실제 연산자를 처리하는 대상이 되는 데이터를 말한고, 
					리터럴 데이터(25,3.14..), 변수 등이 있다.
			연산식 : 연산자와 피연산자를 통해서 원하는 데이터를 처리하는 식을 말한다.
					25 + 30, num01 * num02, point>90

[2단계:코드] 6. 방어율 계산 방법을 찾아보고, 해당 항목을 입력받아 방어율을 출력하세요.
		방어율 : (종 자책점*9)/총 던진 이닝수 
		Scanner sc03 = new Scanner (System.in);
		System.out.print("총 자책점을 입력하세요:");
		int pt = sc03.nextInt();
		System.out.print("총 던진 이닝수를 입력하세요:");
		int inning = sc03.nextInt();
		double defRatio = (double)pt*9/inning;
		System.out.println("방어율:"+defRatio);
		
[1단계:개념] 7. 연산자의 종류를 기본 예제와 함께 기술해보세요
	산술 : +. -, *, /, % 
		25%3 ==> 1
		*****정수형/정수형 ==> 정수값 (자바의 특징)
	부호 : +, - 
		int num01 = -25; -num01= 25
	문자열 : +
		"12" + "13" ==> "1213"
		ps) java에서는 엄격하게 산술연산자를 숫자인 경우만 처리
		하지만 script(파이썬, 자바스크립트)등에서는 숫자형 문자열의
		경우 자동형변환으로 연산을 처리해준다.
		"2"+"3"==> 6 (자바에서는 지원하지 않음)
	대입 : =, +=, *=... 기본적으로 왼쪽에서 오른쪽을 데이터 할당
		int num01 = 25; num02+=3;
	증감 : ++, --, num01++, --num01 1씩 증가 감소 
	비교 : --, !-, >, <, >=, <= boolean(true/false)을 리턴하여 
		결과로 처리해준다.
	논리 : 	&&(and), II(or), !(not)
		비교연산자를 두개 이상 또는 not(!)를 이용해서 
		논리값을 처리하는 것을 말한다. 
	조건(삼항연산자) : 조건식?true일때:false일때 
	
[2단계:코드] 8. 아래와 같은 일일 가계부를 처리할려고 한다. 초기 잔액 10000
              Scanner를 통해 입력에 필요한 연산식을 만들고 아래 형식으로 출력하세요
      날짜   내용   입금액    출금액     잔액
      8/31  용돈   30000    0        40000
      9/1   식사       0    5000     35000
     
     방법
     1) Scanner 2개 (문자열 처리, 숫자형 처리)
     2) 문자열을 다 입력한 후, 숫자형을 입력..(순서가 맞지 않음)
     3) .nextLin() 받고, 정수형이 필요한 경우.
     	Integer.parseInt(sc.nextLine());
    */
		/*
		// 문자열 변수 선언 
		String date01, cont01, date02, cont02;
		//숫자형 변수 선언
		int income01, spend01, income02, spend02;
		//누적 변수 
		int rest = 10000;
		System.out.println("#첫번째 항목#");
		Scanner sc06 = new Scanner(System.in);
		System.out.print("날짜를 입력:"); date01=sc06.nextLine();
		System.out.print("내용를 입력:"); cont01=sc06.nextLine();
		System.out.print("입금액을 입력:"); income01=Integer.parseInt(sc06.nextLine());
		System.out.print("출금액을 입력:"); spend01=Integer.parseInt(sc06.nextLine());
		System.out.println("#두번째 항목#");
		System.out.print("날짜를 입력:"); date02=sc06.nextLine();
		System.out.print("내용를 입력:"); cont02=sc06.nextLine();
		System.out.print("입금액을 입력:"); income02=Integer.parseInt(sc06.nextLine());//숫자형 변환
		System.out.print("출금액을 입력:"); spend02=Integer.parseInt(sc06.nextLine());
		System.out.println("날짜\t내용\t입금액\t출금액\t잔액");
		System.out.print(date01+"\t");
		System.out.print(cont01+"\t");
		System.out.print(income01+"\t");
		System.out.print(spend01+"\t");
		rest+=income01-spend01; 
		//누적 변수는 해당 프로세스에서 처리하기에 라인에서 연산처리
		System.out.print(rest+"\n");
		System.out.print(date02+"\t");
		System.out.print(cont02+"\t");
		System.out.print(income02+"\t");
		System.out.print(spend02+"\t");
		rest+=income02-spend02;
		//누적 변수는 해당 프로세스에서 처리하기에 라인에서 연산처리
		System.out.print(rest+"\n");
	*/
	/*
		 
     
[2단계:코드] 9.구매하는 김밥의 갯수를 선언하고, 1씩 증가하여 김밥의 단가(2500) 아래와 같이 출력
      김밥 1개 구매  2500 
      김밥 2개 구매  5000
      김밥 3개 구매  10000
 */
		/*
	int cnt = 0; //카운트 변수
	int tot = 0; //누적 금액
	int foodPrice = 2500; // 김밥의 개당 가격
	System.out.println("김밥 "+(++cnt)+"개 구매 "+(tot+=foodPrice));
	System.out.println("김밥 "+(++cnt)+"개 구매 "+(tot+=foodPrice));
	System.out.println("김밥 "+(++cnt)+"개 구매 "+(tot+=foodPrice));

[1단계:개념] 10. 비교연산자의 종류를 예시와 함께 기술하세요.
			==, !=, >=, <=, >, <
			instanceOf : 객체의 참조변수인지 여부
			
			point>=80 점수가 80이상일 때, true처리 
			
	

내 답 
[1단계:개념] 1. Scanner객체의 사용방법을 예제를 통하여 기술하세요.
	import를 통해 선언
	1) import java.util.Scanner;을 클래스 명 위에 선언한다.
	2) 객체의 생성
ex) Scanner no01 = new Scanner(System.in);
- 객체유형 참조변수 = new name();
객체유형에 생성되는 생성자의 매개변수로
기본 입력 Stream인 System.in으로 전달된다. (out은 출력)

[1단계:코드] 2. Scanner객체를 활용하여 타율계산방법을 확인(검색)하고, 선수명과 함께 입력데이터를 입력 받아 해당 타자의 타율을 출력하세요.
	타율(batAverg)) = 타수(bat)/안타수(hit)
	
	Scanner sc = new Scanner(System.in);
	System.out.print("홍길동의 안타");
	int hit = sc.nextInt();
	System.out.print("홍길동의 타수");
	int bat = sc.nextInt();
	
	System.out.print("홍길동의 안타:"+hit+"타"+"\t");
	System.out.print("홍길동의 타수:"+bat+"타"+"\t");
	System.out.println("홍길동의 타율:"+(double)(bat/hit)+"\n");
	
[1단계:개념] 3. 숫자형 문자열의 숫자 변환 형식을 예제를 통하여 기술하세요.
		String numStr = "25"; //숫자형 문자열
	 숫자형인 문자열이어야 처리 가능.
	//"이십오" ==> 에러발생
	System.out.println(30 + Integer.parseInt(numStr));
	int num01 = Integer.parseInt(numStr);
	System.out.println(25 + num01);
	System.out.println(25 + numStr);
	String num02Str = "3.14"; 
	System.out.println(50.15 + Double.parseDouble(num02Str));
	double num02 = Double.parseDouble(num02Str);
	System.out.println(50.15 + num02);
	System.out.println(50.15 + num02Str);
	String noNumStr = "이십오";
	
[1단계:코드] 4. args로 물건1(args0) 가격1(1) 갯수1(2) 물건2(3) 가격2(4) 갯수2(5)로 입력받아 계산서를 출력하세요.
		1)  run as - configuration - arguments에 물건 가격 갯수 정보 추가
		System.out.println(" #물건 구매 계산서# ");
		String pname1 = args [0];
		String pname2 = args [3];
		int price1 = Integer.parseInt(args[1]);
		int price2 = Integer.parseInt(args[4]);
		int cnt1 = Integer.parseInt(args[2]);
		int cnt2 = Integer.parseInt(args[5]);
		System.out.println("물건1:"+pname1);
		System.out.println("물건2:"+pname2);
		System.out.println("연필가격:"+price1+"원");
		System.out.println("지우개가격:"+price2+"원");
		System.out.println("연필수량:"+cnt1+"개");
		System.out.println("지우개수량:"+cnt2+"개");
		System.out.println("총액:"+((price1*cnt1)+(price2*cnt2)+"원"+"\n"));;
		
[1단계:개념] 5. 연산자와 피연산자, 연산식의 개념을 예제와 함께 기술하세요.
			연산자 : 연산에 사용되는 표시나 기호 ex) +,-,*,/,%,=,!=(!는 not을 의미)
			피연산자 : 연산 대상이 되는 데이터 ex) 리터럴, 변수
			연산식 : 연산자와 피연산자를 이용하여 연산 과정을 기술 한 것.
			ex) num01 + num02 / 40 - 3
				

[2단계:코드] 6. 방어율 계산 방법을 찾아보고, 해당 항목을 입력받아 방어율을 출력하세요.
			투수 방어율 - (총 자책점(lostScore) * 9) / 등판 이닝수 (gameCnt)
			
		Scanner sc = new Scanner(System.in);
		System.out.print("총 자책점:"); //옆에 바로 입력가능
		int lostScore = sc.nextInt();
		System.out.print("등판 이닝수:"); //옆에 바로 입력가능
		int gameCnt = sc.nextInt();
		int tot = ((lostScore*9)/(gameCnt));
		System.out.println("투수 방어율:"+(double)tot);
		
	
[1단계:개념] 7. 연산자의 종류를 기본 예제와 함께 기술해보세요
			1) 산술연산자 : +, -, /, * ,%
			2) 부호 : +,- ex) int num01 = 25; -num01;
			3) 문자열 : + 문자열과 문자열을 이어주는 역할 ex) "안"+"녕"="안녕"
			4) 대입 : = 왼쪽 데이터에서 오른쪽 변수에 할당
					ex) num01 = num01 + 2;
						증감대입연산자 (사칙연산자대입)
						num01 + = 2;
						num01 +=2;
						num01 +=5;
						num01 += num01*2;
						num01 *= 2;
			5) 증감 :++, -- 변수를 1씩 증가/감소 처리
					ex) cnt++; / cnt--;
			6) 비교 :==,!= 
					true/false인 boolean값을 리턴처리
					ex) int point=10;
						System.out.println(point==30); false
						System.out.println(point!=30); true				
			7) 논리 : 비교 연산식이 2개 이상 또는 not(!)을 처리할때 사용
					ex) age>=14 && age<=18 두가지 비교 연산자가 모두 true 일때 true
					age < 5 II age >=65
					두가지 비교 연산자 중에 하나라도 true이면 true
					!(age>=14 && age<=18) ==> age < 14 II age > 18
					!(age==13)
			8) 조건 : 조건? A : B
					if(age>18){
								성인
					}else{
								미성년자
					}
					age>18 ?"성인":"미성년자"
					
[2단계:코드] 8. 아래와 같은 일일 가계부를 처리할려고 한다. 초기 잔액 10000
              Scanner를 통해 입력에 필요한 연산식을 만들고 아래 형식으로 출력하세요
      날짜   내용   입금액    출금액     잔액
      8/31  용돈   30000    0        40000
      9/1   식사       0    5000     35000
      
  	int budget = 10000;
		int in01 = 30000;
		int out01 = 0;
		int in02 = 0;
		int out02 = 5000;

		String date01 = "8/31";
		String date02 = "9/1";	
		String con01 = "용돈"; 
		String con02 = "식사"; 
		System.out.print("날짜\t");		
		System.out.print("내용\t");		
		System.out.print("입금액\t");		
		System.out.print("출금액\t");		
		System.out.print("잔액\n");		
		System.out.print(date01+"\t");
		System.out.print(con01+"\t");
		System.out.print(in01+"\t");
		System.out.print(out01+"\t");
		int rest01 = (budget-out01+in01);
		System.out.print(rest01+"\n");
		System.out.print(date02+"\t");
		System.out.print(con02+"\t");
		System.out.print(in02+"\t");
		System.out.print(out02+"\t");
		int rest02 = (rest01-out02+in02);
		System.out.print(rest02);
		
[2단계:코드] 9.구매하는 김밥의 갯수를 선언하고, 1씩 증가하여 김밥의 단가(2500) 아래와 같이 출력
      김밥 1개 구매  2500 
      김밥 2개 구매  5000
      김밥 3개 구매  10000
    
		  int gimbap = 0;
	      System.out.println("김밥1줄:"+(gimbap+=2500)+"원");
	      System.out.println("김밥2줄:"+(gimbap+=2500)+"원");
	      System.out.println("김밥3줄:"+(gimbap+=2500)+"원");
	      
[1단계:개념] 10. 비교연산자의 종류를 예시와 함께 기술하세요.
 		종류: ==,!=(!은 not 의미 ),>=,<=,>,<
 		int num01 = 22;					
		int num02 = 2;					
		System.out.println("#비교 연산 결과#");					
		System.out.println(num01+" == "+num02+" = "+(num01==num02));					
		System.out.println(num01+" != "+num02+" = "+(num01!=num02));					
		System.out.println(num01+" >= "+num02+" = "+(num01>=num02));					
		System.out.println(num01+" <= "+num02+" = "+(num01<=num02));					
		System.out.println(num01+" > "+num02+" = "+(num01>num02));					
		System.out.println(num01+" < "+num02+" = "+(num01<num02));					

 
 
 

 */	

	}

}
