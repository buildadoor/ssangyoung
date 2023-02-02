package javaexp.z01_homework;

import java.util.ArrayList;

public class A20_0920 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
/*
 2022-09-20
[1단계:개념] 1. String 문자열 byte데이터부터 만들어지는 과정을 기술해보자.
	 숫자 
	 0,1 : 데이터 최소단위 bit 
	 01000112 ==> 8개 byte - 정수형의 가장 기본 데이터
	숫자들에 코드를 대입해서 'A' 'B'문자를 설정하여 생성됨.
	문자들이 배열로 만들어서 일상에 문자열을 사용하게 되었음
	
	String은 생성자로 byte[]를 받아서 처리할 수 있다.
	byte[] bytes = {13,41};
	숫자에 해당하는 문자(char)가 모여서 문자열을 이루게 한다는 개념하에
	String생성자를 통해서 문자열을 만들 수 있게 하였다.

	String str1 = new String(bytes);
	System.out.println("출력:"+str1);
	
[1단계:코드] 2. 한글 무지개 색상 첫자를 코드값을 확인하여 임의의 색상 5가지를 문자열로 만들어 출력하세요.
		System.out.println("무지개 코드값");
		System.out.print((int)'빨'+", ");
		System.out.print((int)'주'+", ");
		System.out.print((int)'노'+", ");
		System.out.print((int)'초'+", ");
		System.out.print((int)'파'+", ");
		System.out.print((int)'남'+", ");
		System.out.print((int)'보'+", \n");
		char[]arr = {48744, 51452, 45432, 52488, 54028, 45224, 48372};
		String str = new String(arr);
		System.out.println("다섯가지 색상 선택:"+(char)45224+(char)51452+(char)48372+(char)52488+(char)48744);
[1단계:코드] 3. Hello! 자바!를 한글 encoding방식 euc-kr와 utf-8로 설정하여 문자열로 출력하세요.
String hello = "Hello! 자바!";
		try {
		   byte[] byte01 = hello.getBytes("EUC-KR");
		   byte[] byte02 = hello.getBytes("UTF-8");
		   String str01 = new String(byte01);
		   String str02 = new String(byte02);
		   System.out.println(str01);
		   System.out.println(str02);
		} catch (UnsupportedEncodingException e) {
		   e.printStackTrace();
		}
}
}
[1단계:개념] 4. 오늘 진행한 문자열 관련 기능메서드의 기능을 기본예제와 함께 정리하세요.
 		1) indexOf("찾을문자열")
 			해당 문자열 안에서 찾을 문자열의 시작 위치를 index로 리턴.
 			해당 문자열을 포함하지 않으면 -1을 리턴한다.
 		2) length(): 문자열의 크기를 나타낸다.
 			cf) length: 배열의 크기와 구분
 
[1단계:코드] 5. switch case문을 활용하여 주문할 메뉴 짜장면, 짬뽕, 탕수육 입니다. indexOf를 사용하여 해당 메뉴가 있으면, @@번 메뉴 주문하였습니다.
             없으면 없는 메뉴입니다로 표시하세요.
      	String menu ="메뉴는 짜장면,짬뽕,탕수육 세가지 입니다.";
	//System.out.println(menu.indexOf("짜장면"));
	//System.out.println(menu.indexOf("짬뽕"));
	//	System.out.println(menu.indexOf("탕수육"));
		System.out.println(menu);
		System.out.println("주문할 메뉴 입력하세요");
		Scanner sc = new Scanner(System.in);
		String food = sc.nextLine();//입력할 과일
		int findIdx = menu.indexOf(food);
		switch(findIdx) {
			case -1 : System.out.println("없는 메뉴입니다"); break;
			case 4 : System.out.println("첫번째 메뉴 "+food+"을 선택했습니다."); break;
			case 8 : System.out.println("두번째 메뉴 "+food+"을 선택했습니다."); break;
			case 11 : System.out.println("세번째 메뉴 "+food+"을 선택했습니다."); break;
			default: System.out.println("입력범위 초과등 기타 유효성 문제");
		}
	System.out.println("프로그램 종료!");
	}
		}
[1단계:코드] 6. 다음과 같은 고등학교 학번을 아래 형식을 기준으로 입력받아 @@고등학교 @@학년 @@반 @@@로 출력하세요
              형식  "세화030523홍길동" ==> 세화고등학교 03학년 05반 23번 홍길동
        String student= "세화030523홍길동";
		System.out.print(student.charAt(0));
		System.out.print(student.charAt(1));
		System.out.print("고등학교 ");
		System.out.print(student.charAt(2));
		System.out.print(student.charAt(3));
		System.out.print("학년 ");
		System.out.print(student.charAt(4));
		System.out.print(student.charAt(5));
		System.out.print("반 ");
		System.out.print(student.charAt(6));
		System.out.print(student.charAt(7));
		System.out.print("번" );
		System.out.print(student.charAt(8));
		System.out.print(student.charAt(9));
		System.out.print(student.charAt(10));
	}
	}
            
[1단계:코드] 7. 를 split을 이용해서 단위별로 출력(이중 for문 활용)하세요
StringTokenizer apple = new StringTokenizer("사과&3000&2","&");
		int count1 = apple.countTokens();
		System.out.println("!사과!");
		for(int cnt=1;cnt<=count1;cnt++) {
			String token = apple.nextToken();
			System.out.println(token);
		}
		StringTokenizer strawberry = new StringTokenizer("딸기&12000&3","&");
		int count2 = strawberry.countTokens();
		System.out.println("~딸기~");
		for(int cnt2=1;cnt2<=count2;cnt2++) {
			String token = strawberry.nextToken();
			System.out.println(token);
		}
		StringTokenizer orange = new StringTokenizer("오렌지&3000&3","&");
		int count3 = orange.countTokens();
		System.out.println("!오렌지!");
		for(int cnt3=1;cnt3<=count3;cnt3++) {
			String token = orange.nextToken();
			System.out.println(token);
		}
		}		
	}
[1단계:개념] 8. StringTokenizer의 기능 메서드를 기술하세요
	*StringTokenizer("문자열","구분자") 객체 활용*
 		countToken() : 구분자를 통해 나온 데이터 건수 
 		nextToken() : 구분자를 통해서 나온 각 데이터 하나씩 , 호출시마다 하나씩 데이터를 가져온다.
 		hasMoreToken() : 해당 데이터가 있을때 True


[1단계:개념] 9. StringBuffer를 문자열 추가시, 사용하는 이유와 주요 기능 메서드를 기술하세요.
 # String 객체의 메모리 문제
		 1. String 문자열은 +를 통해서 새롭게 heap영역에 만들어지기에
		 	반복문을 활용하면 많은 객체가 만들어지게 된다.
		 2. 가능한 한 문자열은 +를 통해서 만들면 새로운 메모리가 만들어지므로
		 	반복문 안에서 사용하는 것은 자제하여야한다.
		   주요 기능 메서드
		 	1) append(...)
		 	2) insert(int offset..)
		 	3) delete(int start, int end) : 범위를 정해서 삭제 
		 	4) deleteCharAt(int index) : 특정한 위치 문자 삭제
		 	5) replace(int start, int end, string str) : 특정한 문자 위치를 대체 
		 	6) reverse() : 문자열을 뒤집어 사용
		 	7) setCharAt(int index, char ch) :특정한 위치에, 문자 대체 

[1단계:코드] 10. StringBuffer로 두 팀의 임의의 주사위 던지기 10회 내용과 결과를 저장하고, 마지막에 출력하세요.
              no  홍  청  결과
              1   3   4  청승
              2   4   4  무
		StringBuffer sbf1 = new StringBuffer("주사위 던지기 10회\n");
		System.out.println("~랜~덤~주~사~위~");
		sbf1.append("no\t홍\t청\t결과\n");
		for(int cnt=1;cnt<=10;cnt++) {
			int rIdx01=(int)(Math.random()*6+1);
			int rIdx02=(int)(Math.random()*6+1);
			int result = Math.max(rIdx01,rIdx02);
			sbf1.append(cnt+"\t"+rIdx01+"\t"+rIdx02+"\t"+result+"\n");
	}
			System.out.println(sbf1.toString());		
			//결고ㅏ..???... 
}
	}
[1단계:개념] 11. Wrapper클래스란 무엇인가? 유형과 형식을 기술하세요
 기본타입 (byte, char, short, int, long, float, double, boolean)값을 
 내부에 두고 포장하는 객체. 객체로 전환되는 순간, 여러가지 기능 메서드가 
 지원되기에 데이터 변환이나 기능처리를 할수 있기 때문이다.
 			Wrapper class(포장클래스)
		 	대부분은 기본 유형 타입에서 대문자로 시작하여 선언한다.
		 	byte ==> Byte, shor ==> Short, double ==>Double
		 	단, 아래 두가지만 긴문자 형식으로 Wrapper클래스를 선언한다
		 	char ==>Character , int ==>Integer
		 	
[1단계:개념] 12. boxing과 auto boxing, unboxing, auto unboxing의 개념을 예제를 통해서 기술하세요
		Boxing, Unboxing
		 	1) Boxing : 기본 타입의 값을 포장(Wrapper)객체로 만드는 과정을 말한다.
		 	2) Unboxing : 포장 객체에서 기본 타입의 값을 얻어내는 과정
		 		byte value01 = obj2.byteValue();
		 		int value02 = obj1.intValue();
		 autoBoxing, autoUnboxing
		 위 기본 박싱과 언박싱을 거치지 않고 바로 할당하는 것을 jvm에서 내부적으로 지원한다.
		 	1) autoBoxing
		 		Integer obj1 = 10;
		 		Double obj2 = 10.11;
		 	2) autoUnboxing
		 		int num01 = onj1;
		 		double obj2 = obj2;
[1단계:코드] 13. Scanner nextLine()으로 문자열로 두개의 수를 입력 받아서 Boxing으로 Wrapper객체를 만든 후, 다시 Unboxing으로 합산된 결과를 출력하세요.
		Scanner sc01 = new Scanner (System.in);
        Scanner sc02 = new Scanner (System.in);
		System.out.println("첫번째 숫자를 입력하세요!");
		int num01= sc01.nextInt();
		System.out.println("두번째 숫자를 입력하세요!");
		int num02= sc02.nextInt();
		Integer obj01 = Integer.valueOf(num01);
		Integer obj02 = Integer.valueOf(num02);
		int value01 = obj01+obj02.intValue();
        System.out.println(value01);

[1단계:코드] 14. ArrayList로 임의의 수학점수(0~100) 정수형데이터 반복문에 의해 5개 데이터를 나오게 한후, autoBoxing에 의해 할당처리하세요.
 		ArrayList<Integer> mList = new ArrayList<Integer>();
        for(int m = 0; m <= 5; m++) {
           mList.add((int)(Math.random()*101));
        }
        Integer obj01 = mList.get(0);
        Integer obj02 = mList.get(1);
        Integer obj03 = mList.get(2);
        Integer obj04 = mList.get(3);
        Integer obj05 = mList.get(4); 
        System.out.println(obj01);
        System.out.println(obj02);
        System.out.println(obj03);
        System.out.println(obj04);
        System.out.println(obj05);
}
}
[1단계:코드] 15. Random 클래스를 이용해서 3과목의 점수를 임의로 출력하세요.
		int kor = ((int)(Math.random()*101));
		int eng = ((int)(Math.random()*101));
		int math = ((int)(Math.random()*101));
		System.out.println("*국/영/수 과목별 점수*");
		System.out.println("국어점수:"+Math.rint(kor));
		System.out.println("영어점수:"+Math.rint(eng));
		System.out.println("수학점수:"+Math.rint(math));
== 평가대비(자바) 객관식 문제 ==

1. 문자열의 생성자 매개변수로 올 수 없는 데이터 유형은 ?

1)byte[] 2) char[] 3) short[] 4) int[]

1. 문자열안에 특정 문자열을 찾을 때, 사용하는 메서드는?

1)charAt() 2) indexOf() 3) length() 4) substring()

3.StringTokenizer에서 사용되는 주요메서드가 아닌 것은?

1) length() 2) countTokens() 3) nextToken() 4) hasMoreTokens()

4.다음 중 StringBuffer에서 특정한 위치의 문자열을 대체하는 메서드는?

1)append() 2) replace() 3) setCharAt() 4) insert()

5.다음 중 Wrapper클래스의 선언이 적절하지 않는 것은?

1)Double 2) Boolean 3) Char 4) Integer

정답 : 3,2,1,2,3

== 평가대비(알고리즘) 객관식 문제 ==

1. 문자열을 검색할 때, 검색하는 형식이 틀린 것은
1)
//배열안에 있는 검색을 전체를 하여 결과를 처리해야되기에
 //{"홍길동","김길동","신길동"} : members
 //"홍": schStr
 //전역변수로 검색 결과 선언 
boolean hasData=false;
for(String mem : members){
if(mem.indexOf(schStr) !=-1){//비슷한 글자
hasData=true;
}
}
//하나라도 검색이 되면 hasData=true;
2)
boolean hasData=false;
for(String mem : members){
if(mem.equals(schStr)){//동일한 문자열 있을때
hasData=true;
}
}
3)
for(String mem : members){
//"홍":schStr
 
String result="";
//for안에 들어가서 초기값 설정
//외부에서 for문에서 검색된 결과를 볼 수 없을뿐만아니라
 //반복문을 통해 다시 ""으로 초기화되어 배열 중에 한개 검색된 내용을
 //정상적 처리가 되지않는다.
if(mem.indexOf(schStr) !=-1){
result="검색됨";
}
}
4) String result="";
for(String mem : members){
if(mem.equals(schStr) ){
result="검색됨";
}
}

정답 : 3
 */
	/*
	 2번
	 #처리 순서
	 1. 색상 문자열 선언
	 2. getBytes byte배열로 확인,     
	    새로 생성할 임의 색상 배열 선언. 
	 3. for 5번 호출 및 랜덤 호출 	
	 	임의 색상 코드값 배열에 할당.
	 4. new String(newByte)할당 후 출력.
	 */
		
		String rbColor="빨주노초파남보";
		//char[] <==> String
		//.toCharArray():String ==>char[]
		//String s = new String(char[]): char[] ==> String 
		char [] arr =rbColor.toCharArray();
		//배열로 위 색상의 한글 코드값 저장 
		char [] ranChar = new char[5];
		for(int cnt=1;cnt<=5;cnt++) {
			int rCIdx = (int)(Math.random()*arr.length);
			//"빨주노초파남보"를 char 배열로 만든 내용 중에 한개를 임의 추출
			char charVal = arr[rCIdx];
			System.out.println(cnt+"번째 색:"+charVal);
			//새로 만든 ranChar에 하나씩 할당 
			ranChar[cnt-1] =charVal;
		}
		String ranColor = new String(ranChar);
		System.out.println("임의의 5가지 색상:"+ranColor);
		/*
		String rbClor2 ="ROYGBNP";
		byte[]b8
		
		
		
		String rbColor = "빨주노초파남보";
		byte [] rbCodes = rbColor.getBytes();
		System.out.println(rbCodes.length);
		//배열로 위 색상의 한글 코드값을 저장. 
		byte [] ranCode = new byte[5];
		for (int cnt=1;cnt<=5;cnt++) {
			int rCIdx = (int)(Math.random()*rbCodes.length);
			byte codVal = rbCodes[rCIdx];
			System.out.println(cnt+"번째"+(char)codVal);		
			ranCode[cnt-1] = codVal;
		}
		String ranColor = new String(ranCode);
		System.out.println("임의의 5가지 색상"+ranColor);
	*/
	 
	 /*
	7번
	#처리순서
	1) - 구분자로 데이터 split처리
	2) for문을 통해서 &구분자로 split처리
	3) 출력 형식을 처리 
	 */
		String data = "사과&3000&2-딸기&12000&3-오렌지&3000&3";
		String []lev1 = data.split("-");
		for(String str1:lev1) {
		//	System.out.println(str1);
			String []lev2 = str1.split("&");
			for(String str2:lev2) {
				System.out.println(str2+"\t");
			}
			System.out.println();
		}
	/*
	 10번
	 #처리 순서
	 1)StringBuffer 초기 선언
	 2)반복문 for 1~10
	 3)홍팀과 청팀 점수 임의(1~6)
	 	int red = (int)(Math.random()*6+1);
	 	int blue = (int)(Math.random()*6+1);
	 	String rs = red>blue?"홍승":(blue>red?)"청승":"무승부");
	 	sbf.append(cnt+"\t"+red+"\t"+blue+"\t"+rs+"\n");
	 4)반복문 후, 출력
	 	sbf.toString();
	 */
	String tlt = "no\t홍\t청\t결과\n";
	StringBuffer sbf = new StringBuffer();
	for(int cnt=1;cnt<=10;cnt++) {
		int red = (int)(Math.random()*6+1);
	 	int blue = (int)(Math.random()*6+1);
	 	String rs = red>blue?"홍승":(blue>red?"청승":"무승부");
	 	sbf.append(cnt+"\t"+red+"\t"+blue+"\t"+rs+"\n");
	}
	System.out.println(sbf.toString());
	/*
	 13번
	 #처리순서
	 1) Scanner 객체 생성
	 2) 입력문자열, 입력문자열2
	 3) Wrapper Integer num01Obj, num02Obj할당
	 	(Boxing처리) 숫자형 문자열 ==> Wrapper객체
	 4) AutoUnboxing
	 	int num01 = num01Obj;
	 	int num02 = num02Obj;
	 5) 합산출력
	 	num01 + num02; 
	 *//*
	Scanner sc = new Scanner (System.in);
	System.out.println("첫번쨰 숫자를 입력하세요:");
	String str1 = sc.nextLine();
	System.out.println("두번쨰 숫자를 입력하세요:");
	String str2 = sc.nextLine();
	// boxing으로 데이터 할당 
	Integer num01Obj = Integer.valueOf(str1);
	Integer num02Obj = Integer.valueOf(str2);
	//autoUnboxing
	int num01 = num01Obj;
	int num02 = num02Obj;
	System.out.println("합산값:"+(num01+num02));
	*/
	/*
	 14번
	 #처리 순서 
	 */	//기본 정수 ==> autoboxing에 의해 Wrapper할당
		Integer numObj = (int)(Math.random()*101);
		System.out.println("Auto Boxing"+numObj);
		
		
		ArrayList<Integer> iList = new ArrayList<Integer>();
		///Integer형태의 객체가 ArrayList로 만들어진 구조
		//int num01 = (int)(Math.random()*101); 정수
		//iList.add(new Integer(num01); Boxing 
		//이렇게 해서 
		for(int cnt=1;cnt<=5;cnt++) {
			iList.add((int)(Math.random()*101));
			System.out.println(iList);
		}
	}
	
}
