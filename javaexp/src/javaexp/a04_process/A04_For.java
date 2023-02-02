package javaexp.a04_process;

import java.util.Scanner;

public class A04_For {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
/*
 # 반복문
 1. 중괄호 블럭 내용을 반복적으로 실행할 때 사용한다.
 2. 종류 : for문, while문, do-while문
 3. for문 : 반복 횟수를 알고 있을 때, 주로 사용된다.
 	for(초기값설정1;빈복조건2;증/감연산자4){
 		반복처리할 내용..3
 	}
 	1)처리 순서
 	1,2,3,4,2,3,4,,2,3,4..
 	
 	for(;조건;){
 	}
 	for(;;){} // 무한 반복
 	
 */
	System.out.println("반복문(카운트1~10)");
	for(int cnt=1;cnt<=10;cnt++) {
		System.out.println(cnt+"번째 안녕하세요!");
	}
	System.out.println("디스카운트(10~0)");
	for(int cnt=10;cnt>=0;cnt--) {
		System.out.println("카운트 다운:"+cnt);
	}
	System.out.println("10부터 2개씩 증가");
	for(int cnt=10;cnt<=50;cnt+=2) {
		System.out.println("번호:"+cnt);
	}
	/*
	//ex1) 0부터 20까지 출력
	System.out.println("반복문(0~20)");
	for(int cnt=0;cnt<=20;cnt++) {
		System.out.println(cnt);
	}
	//ex2) 100부터 80까지 출력
	System.out.println("디스카운트(100~80)");
	for(int cnt=100;cnt>=80;cnt--) {
		System.out.println(cnt);
	}
	//ex3) 3부터 21까지 출력 3의 배수 출력
	System.out.println("3부터 21까지 3의 배수");
	for(int cnt=3;cnt<=21;cnt+=3) {
		System.out.println(cnt);
	}
	*/

for (int cnt=10;cnt<=50;cnt+=2) {
		System.out.print(cnt+".");
}
System.out.println();
for (int cnt=100;cnt>=80;cnt--) {
	System.out.print(cnt+",");
}
System.out.println();
for(int cnt=3;cnt<=21;cnt+=3) {
	System.out.println(cnt+"\t");
}
System.out.println();
	


/*
 #for문 밖 전역변수 활용
 1. 누적된 변수를 사용해야할 경우, 반복문 밖에 선언하여 처리한다.
 ex)1~10의 총합 구하기, 문자열 연결데이터 누적 처리하기 
 */

int tot=1;
for(int cnt=1;cnt<=10;cnt++) {
	System.out.print(cnt+"+");
	if(cnt!=10) System.out.print(" + ");
	tot+=cnt; // cnt가 증가하면서 누적처리한다 
}
System.out.println(" = "+tot);

//ex1)김밥 나라의 김밥 단가 2500원
//		반복문을 이용해서 1~20개의 비용
// 		총용을 누적해서 출력하세요
//김밥 1개 2500원 
/*
 System.out.println("디스카운트(10~0)");
	for(int cnt=10;cnt>=0;cnt--) {
		System.out.println("카운트 다운:"+cnt);
 */

/*
int tot1=0;
for(int cnt=1;cnt<=20;cnt++) {
	System.out.println(cnt+"개");
System.out.println((cnt+=2500)+"원");
	tot1+=cnt; // cnt가 증가하면서 누적처리한다 

System.out.println(" 누적 총비용 "+tot1);
}
*/
int kimPab = 2500;
int totPay = 0;
for(int cnt=1;cnt<=20;cnt++) {
	System.out.println("김밥 "+cnt+"개 "+kimPab*cnt+"원");
		totPay+=kimPab*cnt;
}
System.out.println("누적 총비용:"+totPay);
// ex)구구단의 단을 입력받아서 1~9까지 곱한 결과를 출력
// 단 x 1= @@
// 단 x 2= @@
// 단 x 3= @@
/*
 1)1~9까지 출력 
 2)grade데이터 scanner입력 단율출력
 3)단*cnt
 
Scanner sc
System.out.println("구구단을 외우자");
int xxx = 2;
for(int cnt=1;cnt<=9;cnt++) {
System.out.println("결과"+xxx*cnt);
}
	
*/
/*
Scanner sc = new Scanner(System.in);
System.out.println("단 입력");
int grade = sc.nextInt();
System.out.println("##"+grade+"단 ##");
for(int cnt=1;cnt<=9;cnt++) {
	System.out.println(grade+"X"+cnt+"=" +grade*cnt);
}
}
*/
//ex) 전역 변수 + 반복step증감연산자 연습
//1~50까지 중에 홀수의 합을 출력하세요 
//1 3 5 7 .. 49 합:@@@
/*
int tot1 =1;
for(int cnt=1;cnt<=49;cnt++) {
	System.out.print((cnt+=2)+"+");

	tot1+=cnt; // cnt가 증가하면서 누적처리한다 
}
System.out.println(" = "+tot);
*/
int oddTot = 0;
for(int cnt=1;cnt<=50;cnt+=2) {
System.out.println(cnt+"");
oddTot += cnt;
}
System.out.println();
System.out.println("합"+oddTot);

	
	
	
	}
	}
	
