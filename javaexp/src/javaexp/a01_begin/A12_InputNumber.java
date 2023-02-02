package javaexp.a01_begin;

import java.util.Scanner;

public class A12_InputNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
/*
 ex
 
 구매한 사과의 갯수
 구매한 바나나의 갯수
 총 과일의 갯수 
 
		//Scanner sc01 = new Scanner 쓰기 
		Scanner sc01 = new Scanner(System.in); //필수
		System.out.println("구매한 사과의 갯수");
		int fruit1 = sc01.nextInt();
		System.out.println("구매한 바나나의 갯수");
		int fruit2 = sc01.nextInt();
		System.out.println("총 과일의 갯수:"+(fruit1+fruit2));
*/	
	//해설
		Scanner sc = new Scanner(System.in);
		System.out.print("사과의 갯수"); //옆에 바로 입력가능
		int appleCnt = sc.nextInt();
		System.out.print("바나나의 갯수"); //옆에 바로 입력가능
		int bananaCnt = sc.nextInt();
		int tot = appleCnt+bananaCnt;
		System.out.println("과일의 총계:"+tot);
		
	}

}
