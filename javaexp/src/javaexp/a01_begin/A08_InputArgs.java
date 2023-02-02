package javaexp.a01_begin;

public class A08_InputArgs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
/*
 # 외부입력값에 의한 데이터 처리
 1. main()메서드 매개변수(String[] args)를 통한 처리
 2. 처리프로세스
 	java A08_InputArgs 사과 바나나
 	실행하면, 문자열 사과 바나나가 
 	String[] args로 할당되어 {"사과","바나나"}로 처리된다.
 	ex) 대부분 언어. ["사과","바나나"] 
 3 배열 문자열로 할당된 데이터는 
 java A08_InoutArgs 문자열 1,2,3
 java A08_InoutArgs 사과 바나나 딸기
 java A08_InoutArgs "사 과" "바 나 나" "딸 기"
 -띄어쓰기를 하나의 문자열에 포함시켜 처리할 때는
 ""로 씌워서 처리한다. 
 arges[0]
 arges[1]
 arges[2]
 arges[3]
 0index로부터 하나씩 할당되어 사용할 수 있다.
 
 
 
 */
		System.out.println("첫번째"+args[0]);
		System.out.println("두번째"+args[1]);
		System.out.println("세번째"+args[2]);
		
	}

}
