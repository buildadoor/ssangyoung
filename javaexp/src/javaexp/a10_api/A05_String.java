package javaexp.a10_api;

import java.io.UnsupportedEncodingException;

public class A05_String {

	private static final byte Goodjob = 0;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 # String 클래스 메소드 
		 1. 문자열의 추출, 비교, 찾기, 분리, 변환등과 같은 다양한
		 	메소드를 가진다.
		 2. 사용빈도가 높은 메소드
		 	1) charAt(int idx) : 특정 위치에 문자 리턴
		 */
		String str01 = "EMP1061521";
		System.out.println("첫번째 문자:"+str01.charAt(0));
		System.out.println("마지막 문자:"+str01.charAt(9));
		//ex) 주민번호로 생년월일의 문자를 charAt로 추출하여 출력하세요.
		String civilNum="901212-1702618";
		System.out.print("19");
		System.out.print(civilNum.charAt(0));
		System.out.print(civilNum.charAt(1));
		System.out.print("년");
		System.out.print(civilNum.charAt(2));
		System.out.print(civilNum.charAt(3));
		System.out.print("월");
		System.out.print(civilNum.charAt(4));
		System.out.print(civilNum.charAt(5));
		System.out.println("일");
		//System.out.println("생년월일:"+civilNum.charAt(0)+civilNum.charAt(1)+civilNum.charAt(2)
		//+civilNum.charAt(3)+civilNum.charAt(4)+civilNum.charAt(5));
	/*
	 # String 문자열
	 1. 숫자
	 	0,1 : 데이터 최소단위 bit 
	 	01000112 ==> 8개 byte ==> 정수형의 가장 기본 데이터
	 	==> 숫자들에 코드를 대입해서 'A' 'B'문자를 설정하여 생성되었다.
	 	문자들이 배열로 만들어서 일상에 문자열을 사용하게 되었음
	 	('H','e','1','o')
	 	==>(25,34,72,43,22): 코드값으로 bytes배열은 문자가 오면 문자열로 사용할 수 있다.
	 	==> 객체 지향 프로그램에서 char[]배열에서 한단계 더 나아가 String 문자열 객체를 만들게 되었다.
	 	
	 */
		System.out.println(62);
		System.out.println((char)65);
		/*
	2. String은 생성자로 byte[]를 받아서 처리할 수 있다.
		 */
	byte[] bytes = {72,101,108,108,111,32,74,97,118,97};
	/*
	 # 코드값배열 <==> 문자열
	 */
	String str30 = "Himan";
	//문자열을 code값으로 가져오는 방법
	byte[]arr30 = str30.getBytes();
	// 코드값 배열을 문자열로 처리 
	String str31 = new String(arr30);
	//숫자에 해당하는 문자(char)가 모여서 문자열을 이루게 한다는 개념하에
	//String생성자를 통해서 문자열을 만들 수 있게 하였다.
	String str1 = new String(bytes);
	System.out.println("출력:"+str1);
	//ex) Good job을 위 byte배열에 의해 문자열로 만드려고 한다.
	//해당 문자들의 코드값을 확인하고 문자열 Good job을 생성하고 출력하세요 .
	//1) Good job1 각각의 문자열의 코드값 확인 (int)G
	//2) 해당 코드값의 byte배열에 할당
	//3) new String(byte배열)에 할당 및 문자열 확인
	System.out.print((int)'G'+", ");
	System.out.print((int)'o'+", ");
	System.out.print((int)'o'+", ");
	System.out.print((int)'d'+", ");
	System.out.print((int)' '+", ");
	System.out.print((int)'j'+", ");
	System.out.print((int)'o'+", ");
	System.out.print((int)'b'+", ");
	System.out.println((int)'!'+", ");
	byte[]arr = {71, 111, 111, 100, 32, 106, 111, 98, 33};
	String str2 = new String(arr);
	System.out.println("문자열:"+str2);
	System.out.println((int)'대');
	System.out.println((int)'한');
	/*
	 #String의 여러가지 기능 메서드
	 1. charAt(index)
	 2. getBytes():문자열의 byte배열을 가져온다. 이때 매개변수 값을 EUC-KR이나
	 	UTF-8로 한글 encoding형식을 지정할 수 있다.
	 
	 */
	String str3 = "반가워요";
	byte[] bytes3 = str3.getBytes();
	for(byte b:bytes3) {
		System.out.println(b+" ");
	}
	System.out.println();
	String str4 = new String(bytes3);
	System.out.println("다시 문자열 출력:"+str4);
	try {
	byte[] bytes5 = str4.getBytes("EUC-KR");
		String str6 = new String(bytes5);
		System.out.println("문자열6:"+str6);
		byte[]bytes6 = str4.getBytes("UTF-8");
		String str7 = new String(bytes6);
		System.out.println("문자열7:"+str7);
		
	}catch(UnsupportedEncodingException e) {
		e.printStackTrace();
	}
//ex)오늘도 좋은하루!! 문자열을 선언하고encoding으로 EUC-KR과 UTF-8로 
//bytes배열을 만들고 다시 문자열 생성자에 할당한 후 출력하세요.
	String great = "오늘도 좋은 하루!!";
	try {
	byte[] byte10= great.getBytes("EUC-KR");
	byte[] byte20= great.getBytes("UFT-8");
	String str10 = new String(byte10);
	String str20 = new String(byte20);
	System.out.println("euc-kr"+str10);
	System.out.println("utf-8"+str20);
	}catch (UnsupportedEncodingException e) {
		e.printStackTrace();
	}
	
	// String 생성자로 매개값을 처리할 수 있는 데이터 유형
	// 1. 문자열 자체 new String("안녕하세요");
	// 2. 문자 배열 : new String({'안','녕','하','세','요'});
	// 3. byte 배열 : new String({102,105,301,420});
	// 65 ==> 'A' ==> "A.."

	String str100 = new String();
	/*
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
	 */
	}}