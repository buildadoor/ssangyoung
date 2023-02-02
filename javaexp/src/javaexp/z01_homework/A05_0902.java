package javaexp.z01_homework;

import java.util.Scanner;

public class A05_0902 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
/*
2022-09-02
[1단계:개념] 1. switch case에 break문의 특징을 기술하세요.
[1단계:코드] 2. switch case문을 이용하여 1980~2010년생의 띠를 출력하세요
[1단계:개념] 3. for문의 기본 구성요소를 기본 예제를 통하여 특징을 기술하세요.
[1단계:코드] 4. for(기본) - 200에서 3씩 차감하여 100까지 차감된 데이터를 출력하세요
[1단계:코드] 5. for(지역/전역) - 곰돌이가 하루 빵을 2개씩 증가해서 먹어(첫째날 2개, 둘째날 4개, 셋째날 6개 ...) 총 10일 동안 먹은 빵의 갯수를 누적하여 아래와 같이 출력하세요
               # 출력 형식
               1일차 2개 2개
               2일차 4개 6개
               3일차 6개 12개
[1단계:코드] 6. for을 이용하여 3,6,9게임을 출력하세요(20까지)- 3의 배수가 아닌 3의 배수란 말이 포함될 때.
		for(int cnt=1;cnt<=20;cnt++) {
			// 10 ==0
			// 11 ==1
			// 12 ==2
			// 13 ==3
			/*
			if(cnt%10!=0 && cnt%10%3==0) {
				System.out.print("짝,");
			}else {
				System.out.print(cnt+",");
			}
			
//위에 지우고 최소코드	System.out.print((cnt%10!=0 && cnt%10%3==0?"짝":cnt)+",");
[1단계:개념] 7. 반복문에서 break와 continue의 차이점을 기본 예제를 통하여 기술하세요
[1단계:개념] 8. while문의 기본 형식을 예제를 통해 설명하세요.
[3단계:코드] 9. while문을 이용해서 학생의 점수를 등록하고 총점과 평균을 
               출력하되, 등록을 종료시 -1를 입력해서 처리하세요.
 */
		
		
		/*
 
 *
 [1단계:개념] 1. switch case에 break문의 특징을 기술하세요.
 			switch문에서는 break;를 만나야지 switch문에서 벗어날 수 있고
 			만나지 않으면 하위 프로세스 처리를 한다 
[1단계:코드] 2. switch case문을 이용하여 1990~2010년생의 생년을 입력받아 띠를 출력하세요
	Scanner sc = new Scanner(System.in);
		System.out.print("태어난 해를 입력하세요 :");
		int born = sc.nextInt();
		System.out.print("당신의 띠는?: ");
		switch(born) {
		case 1990:
		case 2002:
			System.out.println("말띠");
			break;
		case 1991:
		case 2003:
			System.out.println("양띠");
			break;
		case 1992:
		case 2004:
			System.out.println("원숭이띠");
			break;
		case 1993:
		case 2005:
			System.out.println("닭띠");
			break;
		case 1994:
		case 2006:
			System.out.println("개띠");
			break;
		case 1995:
		case 2007:
			System.out.println("돼지띠");
			break;
		case 1996:
		case 2008:
			System.out.println("쥐띠");
			break;
		case 1997:
		case 2009:
			System.out.println("소띠");
			break;
		case 1998:
		case 2010:
			System.out.println("호랑이띠");
			break;
		case 1999:
			System.out.println("토끼띠");
			break;
		case 2000:
			System.out.println("용띠");
			break;
		default : 
			System.out.println("입력 범위는 1990~2010 입니다.");
	}
[1단계:개념] 3. for문의 기본 구성요소를 기본 예제를 통하여 특징을 기술하세요.
		for(초기값설정1;반복조건2;증/감연산자4){
		반복처리할 내용3
		}
		for(int cnt=1;cnt<=10;cnt++) {
		System.out.println(cnt+"번째 안녕하세요!");
		}
		==> 10번째까지 안녕하세요 반복 
[1단계:코드] 4. for(기본) - 200에서 3씩 차감하여 100까지 차감된 데이터를 출력하세요
		System.out.println("차감된 데이터 (200~100))");
		for(int cnt=200;cnt>=100;cnt-=3) {
		System.out.print(cnt+", ");
		}	
	
[1단계:코드] 5. for(지역/전역) - 곰돌이가 하루 빵을 2개씩 증가해서 먹어(첫째날 2개, 둘째날 4개, 셋째날 6개 ...) 총 10일 동안 먹은 빵의 갯수를 누적하여 아래와 같이 출력하세요
               # 출력 형식
               1일차 2개 2개
               2일차 4개 6개
               3일차 6개 12개
     System.out.println(" 곰돌이가 열흘간 먹은 빵 ");
	int bread = 2;
	int sum = 1;
	for(int cnt=1;cnt<=10;cnt++) {
		sum += cnt;
	System.out.println (cnt+"일차 "+(bread*cnt)+"개 "+"누적 "+sum);
	}
[1단계:코드] 6. for을 이용하여 3,6,9게임을 출력하세요(20까지)- 3의 배수가 아닌 3의 배수란 말이 포함될 때.
			* hint 나머지 연산자 2개 
			3,6,9 단위로 짝 출력하기
		for(int cnt=1;cnt<=20;cnt++) {
			if(cnt%3==0) {
				System.out.print("짝~~");
			}else if(cnt{
				System.out.print(cnt+" ");
[1단계:개념] 7. 반복문에서 break와 continue의 차이점을 기본 예제를 통하여 기술하세요
			break;는 반복을 중단처리 하는 역할을 하고
			continue;는 특정step의 내용을 중단하고 다음 내용을 처리하는 역할을 한다.
			for(int cnt=1;cnt<=6;cnt++) {
			if(cnt==5) break;//5부터 제외 
			System.out.print(cnt+", ");
			} 
			System.out.println();
			for(int cnt=1;cnt<=6;cnt++) {
			if(cnt==5) continue;//5빼고 출력
			System.out.print(cnt+", ");
			}
			}
			}

[1단계:개념] 8. while문의 기본 형식을 예제를 통해 설명하세요.
			while 조건이 true일때 반복처리를 한다.
			int cnt =1;
		while(cnt<=10) {
		System.out.println((cnt++)+"번째");
		==>1부터 10까지 처리함 
			
[3단계:코드] 9. while문을 이용해서 학생의 점수를 등록하고 총점과 평균을 
               출력하되, 등록을 종료시 -1를 입력해서 처리하세요.
              
 */
	/* 
	
		//System.out.println("점수를 입력하세요~~!!");
		int score = sc01.nextInt();
		while(true) {
			System.out.println("점수:"+score/////////);
		System.out.println("입력을 중단하시겠습니까?");
			if(sc.nextLine().equals("네")) {
		break;
		}
		System.out.println("입력 종료!");
	}
		////평균--;
		 
		 */
	//해설
	/*
	5. for(지역/전역) - 곰돌이가 하루 빵을 2개씩 증가해서 먹어(첫째날 2개, 둘째날 4개, 셋째날 6개 ...) 총 10일 동안 먹은 빵의 갯수를 누적하여 아래와 같이 출력하세요
              # 출력 형식
              1일차 2개 2개
              2일차 4개 6개
              3일차 6개 12개
		 */
		int dBCnt= 2; //하루에 먹는 빵
		int tot = 0; //누적된 빵의 갯수
		for(int dCnt=1;dCnt<=10;dCnt++) {
			tot+=dBCnt*dCnt;
			System.out.println(dCnt+"일차 "+dBCnt*dCnt+"개 "+tot+"개");
		}
		
//6번
		for(int cnt=1;cnt<=20;cnt++) {
			// 10 ==0
			// 11 ==1
			// 12 ==2
			// 13 ==3
			/*
			if(cnt%10!=0 && cnt%10%3==0) {
				System.out.print("짝,");
			}else {
				System.out.print(cnt+",");
			}
			*/
			//최소코드
System.out.println((cnt%10!=0 && cnt%10%3==0?"짝":cnt)+",");
			}

//9번	while문을 이용해서 학생의 점수를 등록하고 총점과 평균을 
//		출력하되, 등록을 종료시 -1를 입력해서 처리하세요.
		/*
		Scanner sc = new Scanner(System.in);
		int sno =0; //과목수, 평균처리시 필요
		int tot =0; //과목의 점수를 누적 
		while(true) {
			System.out.println(++sno+"번째 과목의 점수 입력(중단시 -1):");
			int pt = sc.nextInt();
			if(pt==-1) {// 중단 처리시
				sno--; // 입력된 과목 증가 취소 처리(입력시 하나 더 +되기 때문에)
				break;
			}
			System.out.println("입력한 점수:"+pt);
			tot += pt;
			}
		System.out.println("입력한 과목수:"+sno);
		System.out.println("총점수:"+tot);
		System.out.println("평균:"+tot/(double)sno);
	*/
	}
		}
	
	
	
