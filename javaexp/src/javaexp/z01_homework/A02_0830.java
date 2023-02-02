package javaexp.z01_homework;

public class A02_0830 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

/*
 2022-08-30
 				

 
[1단계:개념] 1. 기본 출력형식과 특수문자에 대하여 예제를 통해 기술하세요
			기본 출력 형식은 console창에 출력할 내용을 ""(문자열)로 처리할 때 사용한다.
			println()는 줄바꿈 기능을 포함하고, print는 줄바꿈을 포함하지 않을때 사용한다.
			특수 문자는 \n과 \t를 사용한다.
			\n은 줄바꿈을, \t는 탭 간격으로 일정한 간격을 처리할 때 사용한다.

[1단계:개념] 2. 변수명의 선언 규칙을 예제를 통하여 기술하세요.
				int num01; 변수의 선언 규칙
				
			ex) int num01 = 3; 
				int tot = num01 + 10; 
				위에 int num01 = 3;이 없을 경우엔 초기화가 되지 않아 에러가 발생한다.
				
[1단계:코드] 3. 21억, 15억 데이터를 int에 할당하고, 합산결과를 변수를 선언하여 할당 출력하세요
			int num01 = 2100000000;
			int num02 = 1500000000;
			System.out.println(num01+num02);
			
			
[1단계:개념] 4. 150라는 데이터는 기본데이터유형 중에 어디에 할당이 가능한가를 기술하고 그 이유에 대하여 설명하세요
			150은 char에 할당이 가능하다.
			char의 범위는 0~65535이므로 150이 여기에 속한다.
			
[2단계:코드] 5. 알파벳의 코드값 범위와 문자 0부터 9까지 범위의 코드값 범위를 확인하고 출력하세요.
			char ch01 = '0';
			int code1 = ch01;
			System.out.println(ch01);
			char ch02 = '1';
			int code2 = ch02;
			System.out.println(ch02);
			char ch03 = '2';
			int code3 = ch03;
			System.out.println(ch03);
			char ch04 = '3';
			int code4 = ch04;
			System.out.println(ch04);
			char ch05 = '4';
			int code5 = ch05;
			System.out.println(ch05);
			char ch06 = '5';
			int code6 = ch06;
			System.out.println(ch06);
			char ch07 = '6';
			int code7 = ch07;
			System.out.println(ch07);
			char ch08 = '7';
			int code8 = ch08;
			System.out.println(ch08);
			char ch09 = '8';
			int code9 = ch09;
			System.out.println(ch09);
			char ch10 = '9';
			int code10 = ch10;
			System.out.println(ch10);
			
[1단계:개념] 6. 형변환 두가지 유형을 예제를 통해서 기술하고 설명하세요..
문자열 + 숫자 => 자동형변환에 의해서 숫자는 문자열로 변환되어 이어져서 나온다. 					
int num01 = 10;			
int num02 = 20;			
숫자를 문자열로 나오는 것이 아닌 연산을 하고싶으면 중간에 ()를 넣는다.
System.out.println(""+num01 + num02);	//출력값 = 1020	
System.out.println(""+(num01 + num02));	//출력값 = 30	
					

[1단계:코드] 7. 500cc의 오렌지쥬스를 3잔에 나누어 할당할려고 한다. 소숫점 이하가 처리된 경우와
            소숫점 이하가 처리되지 않는 경우를 나누어 코딩하세요
 		int juice = 500;
        int div = 3;
        System.out.println(juice/(double)div);  
        System.out.println(juice/div); 

 
 */
						

//	[1단계:개념] 1. 기본 출력형식과 특수문자에 대하여 예제를 통해 기술하세요
		/* 1)메서드
		 	System.out.println(); //줄바꿈
		 	System.out.print(); //줄변경없이
		 2) 출력처리 내용
		 	\n : 문자열로 줄바꿈 기능 포함
		 	\t : 문자열로 탭 간격 처리
		 	\"
		 	System.out.print("사과\t바나나\t");
		 
		 
//	[1단계:개념] 2. 변수명의 선언 규칙을 예제를 통하여 기술하세요.
 * 				1) 숫자는 첫자로 사용하지 않아야한다.
 					int 10num; (X) int num01; (O)
	*			2) 변수명에 특수문자는 허용되지 않는다. 단 _,$는 허용
	*				int $name;(O), String #a1is;(X)
	*			3) 대소문자는 구분하여 다른 변수명으로 인식한다.
					int num01;
					int nuM01; - 구분되어 다른 문자로 인식
				4) 예약어 - 명령어(내장 keyword)는 변수명으로 사용하지 못한다.
					int if;(X)
				5) 합성어 대문자로 시작하여 구분하여 사용한다.(가독성을 위함)
					String setName;
 */
//	[1단계:코드] 3. 21억, 15억 데이터를 int에 할당하고, 합산결과를 변수를 선언하여 할당 출력하세요
				int num01 = 2100000000;
				int num02 = 1500000000;
				int sum = num01+num02;
				long sum2 = (long)num01+(long)num02;
				System.out.println("합산결과:"+sum);
				System.out.println("합산결과:"+sum2);
		//  [1단계:개념] 4. 150라는 데이터는 기본데이터유형 중에 어디에 할당이 가능한가를 기술하고 그 이유에 대하여 설명하세요
			/*	150은 byte 범위는 1byte를 초과하여 할당이 불가능하여
			 * 에러가 발생한다. 그외 2byte 이상의 데이터 유형에는 할당이 가능하다. 
			 * byte num11 = 150; 에러 
			 */
				short num12 = 150;
				int num13 = 150;
				long num14 = 150;
				System.out.println(num12);
				System.out.println(num13);
				System.out.println(num14);

//	[2단계:코드] 5. 알파벳의 코드값 범위와 문자 0부터 9까지 범위의 코드값 범위를 확인하고 출력하세요.
				//A~Z, a~z
				int code13 = 'A';
				int code14 = 'Z';
				int code15 = 'a';
				int code16 = 'z';
				System.out.println("알파벳");
				System.out.println("A:"+code13);
				System.out.println("Z:"+code14);
				System.out.println("a:"+code15);
				System.out.println("z:"+code16);
				System.out.println("알파벳");
				int code11 = '0';
				int code12 = '9';
				System.out.println("코드값:"+code11);
				System.out.println("코드값:"+code12);
				//48~57
				for(int cnt = 48; cnt<=57;cnt++);{
		//	System.out.println(cnt+":"+(char)cnt);
				}
//	[1단계:개념] 6. 형변환 두가지 유형을 예제를 통해서 기술하고 설명하세요..
	//				형변환은 데이터유형(타입)이 변경되는 것을 말한다.
	//				크게 promote(자동형변환)과 casting(강제형변환)이 있다.
	//				promote는 보통 작은 데이터 유형의 데이터를 큰 데이터유형에서
			//		변경할때 주로 발생하는데, 별다른 처리없이 데이터를 할당하여 변경된다
			int num30 = 10;
			double num31 = num30;
			System.out.println(num30);
			
//	[1단계:코드] 7. 500cc의 오렌지쥬스를 3잔에 나누어 할당할려고 한다. 소숫점 이하가 처리된 경우와
//	 소숫점 이하가 처리되지 않는 경우를 나누어 코딩하세요
			int juicy = 500; 
			int glasses = 3;
			System.out.println("한잔당용량(int):"+(juicy/glasses));
			System.out.println("한잔당용량(double):"+(double)juicy/glasses);
			
		
	}

}
