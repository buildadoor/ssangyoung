package javaexp.a01_begin;

import java.util.Scanner;

public class A11_InputScanner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
/*
 ex  A11_InputScanner
 
 좋아하는 과일명 입력:
 입력...
 과일명: @@@@
  Scanner sc01 = new Scanner(System.in);
		System.out.println("데이터를 입력하세요!!");
		String strData01 = sc01.nextLine();
		System.out.println("입력된 문자열 출력"+strData01);
 
Scanner sc01 = new Scanner(System.in);
System.out.println("좋아하는 과일명을 입력하세요!");
String strData01 = sc01.nextLine();
System.out.println("입력된 문자열 출력"+strData01);
 
 */
		//해설
		Scanner sc = new Scanner(System.in);
		System.out.println("좋아하는 과일명을 입력하세요");
		String favFruit = sc.nextLine();
		System.out.println("입력한 과일명:"+favFruit);
	}

}
