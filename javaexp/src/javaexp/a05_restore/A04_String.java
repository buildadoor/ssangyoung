package javaexp.a05_restore;

import java.util.Scanner;

public class A04_String {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
/*
 #String타입
 1. 문자열을 저장하는 클래스 타입
 	string name = "홍길동";
 	String subject = "자바";
 	스택영역에 name이라는 이름으로 heap영역에 있는 "홍길동"문자열을 호출하여 사용
 	스택영영에 subject이라는 이름으로 heap영역에 있는 "자바"문자열을 호출하여 사용
 	char c = '홍';
 	char[]ary = {'홍','길','동'};
 	==> 문자열을 많이 사용하기에 보다 손쉽게 처리하기 위해서
 		String 타입을 만들어서 처리 
 */
		String name= "홍길동";
		String subject = "자바";
		/*
		 #문자열 할당시 차이
		 1. String name1 = "홍길동";
			String name2 = "홍길동";
			"홍길동"을 기준해서 heap영역 할당된 도일한 주소를 name1, name2에서 호출해서 사용
			ex) name1 == name 2 ==> true 같은 문자열은 같은 주소에 있다.
		 2.	String name3 = new String("홍길동");
			String name4 = new String("홍길동");
		 new String()라고 하는 순간 다른 heap영역에 주소를 사용하여 "홍길동"을 할당하여
		 name3과 name4에 각각 대입하여 사용한다.
		 cf) 객체는 new 라는 키워드를 이용하여 객체를 생성하면 heap영역에 다른 주소를 사용한다.
		 	{} : 내부적으로 new 타입[] 생략
			ex) name3 == name 4 ==> false 같은 문자열이지만 new 통해서 다른 주소에 할당되었기때문 
			
			
		 3. 문자열 내용으로 비교하여 유효성을 체크하거나 조건문과 반복문에서 활용하는 경우가 많다.
		 	이때, 사용하는 것은 String의 주소값을 확인하는 것보다 문자열 자체가 동일한지 여부를 확인하는
		 	경우가 많으므로, 이럴때는 문자열1.equals(문자열2) 형태의 메서드를 사용하여야 한다.
		# 실무적으로 코드로 직접적으로 대입하는 것보다,
		사용자 인터페이스(Scanner, DB호출. 파일로드, 네트워크 전송)등에 의해서 가져오는 
		문자열 데이터는 new String ()형식으로 heap영역에 따로 메모리를 만들어 가져오는 경우가 많다.
		 */
		
		/*
		String name1 = "홍길동";
		String name2 = "홍길동";
		System.out.println("주소값 비교1:"+(name1 == name2));
		String name3 = new String("홍길동");
		String name4 = new String("홍길동");
		System.out.println("주소값 비교2:"+(name3 == name4));
		System.out.println("주소값 비교3:"+(name1 == name3));
		System.out.println("문자열 내용 비교1:"+name1.equals(name2));
		System.out.println("문자열 내용 비교2:"+name1.equals(name4));
		System.out.println("문자열 내용 비교3:"+name1.equals(name3));
		*/
		//ex1)문자열로 유효한 id, pass를 선언하고 Scanner를 통해 입력된 id,pass를 통해
		//==(주소값)을 비교한 경우와 equals()를 통해 비교한 처리 결과가 어떻게 다른지 확인해보세요.
		/*
		 Scanner sc = new Scanner(System.in);
		System.out.print("id를 입력하세요");
		String id = sc.nextLine();
		System.out.print("password를 입력하세요");
		String pass = sc.nextLine();
		System.out.println("아이디 패스워드 비교:"+(id == pass));
		System.out.println("아이디 패스워드 비교2:"+id.equals(pass));
		*/
		Scanner sc = new Scanner(System.in);
		String id = "himan";
		String pass = "7777";
		System.out.println("# 로그인 #");
		System.out.print("아이디를 입력하세요:");
		String inputId = sc.nextLine();
		System.out.print("비밀번호를 입력하세요:");
		String inputPass = sc.nextLine();
		System.out.println("# 비교 연산자 비교 #");
		System.out.println("id==inputId:"+(id==inputId));
		System.out.println("pass==inputPass:"+(pass==inputId));
		System.out.println("# equals 연산자 비교 #");
		System.out.println("id.equals(inputId):"+(id.equals(inputId)));
		System.out.println("pass.equals(inputPass):"+(pass.equals(inputPass)));
		System.out.println("#로그인 인증 여부 처리#");
		if(id.equals(inputId) && pass.equals(inputPass)) {
			System.out.println("로그인 성공");
		}else { 
			System.out.println("로그인 실패");
		}

	}

}
