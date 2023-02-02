package javaexp.z01_homework;

import java.util.Scanner;

public class A06_0905 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
/*
 2022-09-05
[1단계:개념] 1. stack영역과 heap영역의 차이점을 기술하세요.
[1단계:코드] 2. 정수형 배열(arr05)로 물건의 가격을 3개 할당하고, 
			새로운 배열 변수(arr06)에 물건의 가격 변수(arry05)
      		를 할당하고 arr06에 중간데이터를 변경 후 두 변수를 비교시 동일한 데이터가 나오는 이유를 기술하세요.
[1단계:개념] 3. 객체형 데이터를 선언하여 초기화(null)후, 구성요소를 호출할 때 나오는 에러와 원인을 예제를 통해서
      		설명하세요
[1단계:개념] 4. 배열에서 사용하는 구성요소와 선언 및 할당 처리를 기본 예제와 함께 설명하세요.
[1단계:코드] 5. 유럽챔피언스리그 팀과 성적을 배열로 선언하고 출력하세요.
[1단계:코드] 6. 학생3명의 이름과 국어 점수를 배열로 선언하고 Scanner로 입력한 후, 출력하세요.
[3단계:코드] 7. 임시비번에 사용할 임의의 데이터를 입력후(갯수 입력 후 문자입력), 
문자 5개로 구성된 임시 비밀번호를 생성출력하세요.
 */
		/*
//내답 
[1단계:개념] 1. stack영역과 heap영역의 차이점을 기술하세요.
			1) stack
			기본 타입 변수는 실제 값을 변수 안에 저장하는데 
			stack영역에 선언하고 실제 데이터를 할당한다.
			2) heap
			참조 타입 변수는 주소를 통해 객체를 참조하는데
			heap영역에 저장하고 이 영역의 값의 주소값을 stack영역에 저장한다.
			
[1단계:코드] 2. 정수형 배열(arr05)로 물건의 가격을 3개 할당하고, 
			새로운 배열 변수(arr06)에 물건의 가격 변수(arry05)
      		를 할당하고 arr06에 중간데이터를 변경 후 두 변수를 비교시 동일한 데이터가 나오는 이유를 기술하세요.
      		int[] arr05,arr06;
			arr05 = new int[]{5000,6000,8000};
			arr06 = arr05;
			arr06[1] = 7000;
			System.out.println(arr05[1]);
			System.out.println(arr06[1]);
      		
      		
[1단계:개념] 3. 객체형 데이터를 선언하여 초기화(null)후, 구성요소를 호출할 때 나오는 에러와 원인을 예제를 통해서
      		설명하세요
      			/*	
		int num01;
//		System.out.println(num01); 초기화를 해야 사용 가능
		num01=0; 		//초기데이터를 0 :stack
		System.out.println(num01);	
		Alphabet abc01;
//		System.out.println(abc01);
		abc01 = null;		//객체는 초기화를 stack영역에 null
							//heap영역의 객체는 생성되지 않았다.
		System.out.println(abc01);
//		System.out.println(abc01.number);
//		java.lang.NullPointerException
//		객체가 heap영역에 생성되지 않았을 때 구성요소를
//		호출하면 runtime error인 NullPointerException 발생한다.

 	abc01 = new alpha(); //객체가 heap영역에 생성된다.
		System.out.println(abc01);
		abc01.number=24;
		System.out.println(abc01.number);
		//모든 객체는 객체가 생성됨과 동시에 구성요소들이 초기화된다
		//숫자는 0, 객체(String포함) null
		System.out.println(p01.age);
		System.out.println(p01.height);
		System.out.println(p01.name);
		}
	}
	class Alphabet{ // 사용정의 class 선언해야함 
	int number;
	double @@@@;
	String name;
	}
	
[1단계:개념] 4. 배열에서 사용하는 구성요소와 선언 및 할당 처리를 기본 예제와 함께 설명하세요.
		
			배열에서는 같은 이름이기때문에 각 구성 데이터를 구분하는 구분자는 
		 	index로 0부터 시작하여 처리한다.
		 	
		 	int[] array01 = {1,2,3};
		 	System.out.println(array01); // heap의 주소값
			System.out.println(array01[0]);
			System.out.println(array01[1]);
			System.out.println(array01[2]);
			System.out.println(array01[3]);
		
		 	String[] array02 = {"마우스","키보드","컴퓨터"};
		 	System.out.println(array02);
			System.out.println(array02[0]);
			System.out.println(array02[1]);
			System.out.println(array02[2]);
			
[1단계:코드] 5. 유럽챔피언스리그 팀과 성적을 배열로 선언하고 출력하세요.
		String []uefa = {"FC Bayern München","Manchester City FC","Liverpool FC","Chelsea FC","Real Madrid CF","Paris Saint-Germain",
						"FC Barcelona","Juventus","Manchester United","Club Atlético de Madrid"};
		int[] point = {136000,127000,124000,118000,115000,112000,109000,107000,105000,101000};
		System.out.println("#2022년 4월 기준 유럽 축구 클럽 TOP"+uefa.length+"#");
		for(int idx=0;idx<uefa.length;idx++) {
			System.out.println((idx+1+"위 "+uefa[idx])+"\n\t"+point[idx]+"point");
		}

			}
}
			
[1단계:코드] 6. 학생3명의 이름과 국어 점수를 배열로 선언하고 Scanner로 입력한 후, 출력하세요.
String []names = new String[3];
		System.out.println("학생 이름을 입력하세요.");
		Scanner sc = new Scanner(System.in);
		for(int idx=0;idx<names.length;idx++) {
			System.out.print(idx+1+"번째 학생 이름: ");
			names[idx] = sc.nextLine();
		}
		int []score = new int[3];
		System.out.println("국어 점수를 입력하세요.");
		for(int idx=0;idx<score.length;idx++) {
		System.out.print(idx+1+"번째 학생 국어 점수: ");
		int grade = Integer.parseInt(sc.nextLine());
		}
		System.out.println("#학생 세명의 국어 점수#");
		for(int idx=0;idx<names.length;idx++){
		System.out.println(idx+1+"번째 학생"+"이름: "+names[idx]+"\t"+"점수: "+score[idx]+"점");
		//점수가 계속 0으로 나옵니다...ㅠㅠ 
[3단계:코드] 7. 임시비번에 사용할 임의의 데이터를 입력후(갯수 입력 후 문자입력), 
문자 5개로 구성된 임시 비밀번호를 생성출력하세요.
String []letters = {"A","B","C","D","E","F","G","H","I","J","K","L",
				"M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
		String password [] = new String[26];
		int cIdx=0;
		System.out.println();
		System.out.println("#임시 비밀번호 다섯자리#");
		for(int cnt =1;cnt<=5;cnt++) {
			int rIdx = (int)(Math.random()*letters.length);
			System.out.print(letters[rIdx]);
			}
		 */
//해설
/*

[1단계:개념] 1. stack영역과 heap영역의 차이점을 기술하세요.
			객체를 사용하느냐에 따라 heap영역의 사용여부를 결정한다.
			stack영역
			1. 기본데이터 유형 : 변수명 선언과 실제 데이터 할당
			2. 객체 유형 : 변수명 선언과 heap영역 주소값 할당. 
			heap영역
			1. 객체 유형에 실제 객체 유형의 데이터 할당.
			
[1단계:코드] 2. 정수형 배열(arr05)로 물건의 가격을 3개 할당하고, 
		  새로운 배열 변수(arr06)에 물건의 가격 변수(arry05)
		  를 할당하고 arr06에 중간데이터를 변경 후 두 변수를 비교시 동일한 데이터가 나오는 이유를 기술하세요.

		int []arr05 = {3000,4000,5000};
		//stack영역에 arr05라는 이름으로 실제 할당되 heap영역의 주소를 저장 
		//heap영역에는 {3000,4000,5000} 객체 데이터를 저장.
		int []arr06=arr05;
		//arr05에 있는 할당되어 있는 stack 영역에 있는 주소를 복사해서 arr06에 할당처리 
		arr06[1]=7000;
		System.out.println("중간 데이터 변경:"+arr06[1]);
		System.out.println("#변경 후 데이터 arr05[01]의 데이터 확인:"+arr05[1]);
		//주소값이 같으므로 한쪽에 있는 데이터를 변경하더라도 다른쪽 데이터(arr05[1])가 변경되는 것을 확인 할 수 있다.

[1단계:개념] 3. 객체형 데이터를 선언하여 초기화(null)후, 구성요소를 호출할 때 나오는 에러와 원인을 예제를 통해서
		   	설명하세요
		   	
		int[] arry07;
		arry07 = null;
		//밑에 적기class Person{
	//	String name="홍길동";
	//}
		Person p01;
		p01 = null;
//		System.out.println("배열 구성 요소 호출:" +arry07[0]); NullPointerException
//		System.out.println("객체 구성 요소 호출:" +p01.name); NullPointerException
// 		heap영역에 객체가 만들어져 있지 않은 상황에서 구성요소를 호출하므로 에러가 발생한다.
		arry07 = new int[] {100,200,300};
		p01 = new Person();
		System.out.println("배열 구성 요소 호출:" +arry07[0]);
		System.out.println("객체 구성 요소 호출:" +p01.name);
//		heap영역에서 객체가 만들어진 후에는 구성요소를 호출하여도 에러가 발생하지 않는다.		
		   	
[1단계:개념] 4. 배열에서 사용하는 구성요소와 선언 및 할당 처리를 기본 예제와 함께 설명하세요.
[1단계:코드] 5. 유럽챔피언스리그 팀과 성적을 배열로 선언하고 출력하세요.
[1단계:코드] 6. 학생3명의 이름과 국어 점수를 배열로 선언하고 Scanner로 입력한 후, 출력하세요.
*/
		//데이터를 할당할 수 있게 배열 객체 선언/객체 생성
	/*
	String[]names = new String[3];
	int [] kors = new int[3];
	Scanner sc = new Scanner(System.in);
	for(int idx=0;idx<names.length;idx++) {
		System.out.print(idx+1+"번째 학생의 이름 입력: ");
		names[idx] = sc.nextLine();
		System.out.print(idx+1+"번째 학생의 국어점수 입력: ");
		kors[idx] = Integer.parseInt(sc.nextLine());
	}
	System.out.println("번호\t이름\t국어점수");
	for(int idx=0;idx<names.length;idx++) {
		System.out.println(idx+1+"\t"+names[idx]+"\t"+kors[idx]);
	}
	*/
/*[3단계:코드] 7. 임시비번에 사용할 임의의 데이터를 입력후(갯수 입력 후 문자입력), 
		문자 5개로 구성된 임시 비밀번호를 생성출력하세요.
		 */
	//임시 비밀번호로 사용할 배열 선언 후,
	/*
	 String []tmpStrs = new String[10];
	Scanner sc2 = new Scanner(System.in);
	System.out.println("임시 비밀번호로 사용할 문자열 10개를 입력하세요");
	for(int idx=0; idx<tmpStrs.length;idx++) {
		System.out.print(idx+1+"번째 문자입력:");
		tmpStrs[idx] = sc2.nextLine();
	}
	System.out.println("임시 비밀번호로 사용할 문자열");
	for(int idx=0; idx<tmpStrs.length;idx++) {
		System.out.print(tmpStrs[idx]+",");
	}
	String tmPass ="";
	for(int cnt=1;cnt<=5;cnt++) {
		int rIdx = (int)(Math.random()*tmpStrs.length);
		tmPass+=tmpStrs[rIdx];
	}
	System.out.println("임시 비밀번호:+tmPass");
	*/
	//48~57. 65~90, 97~122 : 숫자, 소문자, 대문자 : 배열을 char로 만들어서 이 범위에 있는 문자만 입력, 랜덤 
	//33~126 : 숫자, 소문자, 대문자, 특수문자
	char []tmpPassC = new char[8];
	for(int idx=0;idx<tmpPassC.length;idx++) {
		int ranCod = (int)(Math.random()*93+33); // 경우의 수 93가지 시작수 33
		tmpPassC[idx] = (char)ranCod;
	}
	for(int idx=0;idx<tmpPassC.length;idx++) {
		System.out.println(tmpPassC[idx]);
	}
	System.out.println();
	// char[] ==>String으로 변환 처리
	String tmpPass = new String(tmpPassC);
	System.out.println("최종 임시 비밀번호:"+tmpPass);
	Scanner sc =new Scanner(System.in);
	
	}
	}

class Person{
	String name="홍길동";

}