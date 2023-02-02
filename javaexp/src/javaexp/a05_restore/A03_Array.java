package javaexp.a05_restore;

import java.util.Scanner;

public class A03_Array {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 #배열이란
		 1. 같은 타입의 데이터를 같은 이름으로 연속된 공간에 
		 	저장하는 자료 구조를 말한다.
		 2. 같은 이름이기때문에 각 구성 데이터를 구분하는 구분자는 
		 	index로 0부터 시작하여 처리한다.
		 
		 	무궁화호100(서울~부산)
		 	1호, 2호, 3호 ....
		 	무궁화호100 1호차
		 	무궁화호100 2호차
		 	무궁화호100 3호차
		 */
		// 배열을 선언하고 바로 할당하는 경우 
		int[] array01 = {1000,2000,3000,4000};
		System.out.println(array01); // heap의 주소값
		System.out.println(array01[0]);
		System.out.println(array01[1]);
		System.out.println(array01[2]);
		System.out.println(array01[3]);
		String[] array02 = {"사과","바나나","딸기"};
		System.out.println(array02);
		System.out.println(array02[0]);
		System.out.println(array02[1]);
		System.out.println(array02[2]);
		//ex1) 좋아하는 영화제목 3개를 배열로 선언할당하고
		//	출력하세요
		/*String[] array03 = {"토르","헐크","어벤져스"};
		System.out.println(array03);
		System.out.println(array03[0]);
		System.out.println(array03[1]);
		System.out.println(array03[2]);
		*/
		String []movies = {"공조","알라딘","블랙폰"};
		//ex2) KBO타율 rank number 3 선언 할당 출력하세요 		
		double []hitRatios = {0.347,0.349,0.317};
		//배열 length 배열의 길이
		System.out.println("영화의 길이:"+movies.length);
		System.out.println("타율배열의 길이:"+hitRatios.length);
		//index와 길이는 1차이가 난다. 반복조건문에 
		//idx < 배열.length
		for(int idx=0;idx<movies.length;idx++) {
			System.out.println(idx+":"+movies[idx]);
		}
		for(int idx=0;idx<hitRatios.length;idx++) {
		System.out.println(idx+1+"]"+hitRatios[idx]);
		}
		//ex) 맛집5를 배열로 선언하고, for문을 통해서 출력.
		String []food = {"스타벅스","파리바게트","이디야","메가커피","컴포즈커피"};
		System.out.println("#홍대입구맛집#");
		for(int idx=0;idx<food.length;idx++) {
			System.out.println(idx+1+"."+food[idx]);
		}
		/*
		 #배열의 처리
		 1. 배열의 선언
		 	타입[] 변수명;
		 	타입 변수명 [];
		 	cf) 배열의 기본 유형으로 선언할 수 있을 뿐만 아니라 객체형도 배열로 선언이 간으하다.
		 	int[] arry;
		 	Person[] arry01;
		 	
		 2. 배열의 초기화
		 	변수명 = null; //주소는 할당되지 않음
		 	-모든 객체(배열, enum, 내장 객체, 사용자 정의 객체)
		 3. 배열의 할당
			1) 값이 할당되지 않았지만 주소는 생성
			변수명 = new 타입[크기];
			2) 선언 후 할당.
			타입[] 변수명 = null;
			변수명 = new 타입[]{데이터1, 데이터2, 데이터3};
			타입[] 변수명 = {데이터2, 데이터2, 데이터3}; 
			ex)
			int []arry01 = null;
			aary01 = new int[3];
			int [] arry02 = new int[5];
			int [] arry03 = null;
			arry03 = new int[]{1000,2000,3000};
			int [] arry04 = {4000,5000,6000}; 
		 */
		int arry10[];
		int arry11[];
		arry10 = null;
		arry11 = null;
		int[] arry12 = null;
		int[] arry13 = new int[3];
		arry12 = new int[] {1000,2000,3000};
		int[] arry14 = {5000,6000,7000};
		System.out.println(arry10);
		System.out.println(arry11);
		System.out.println(arry11);
		System.out.println(arry12);
		System.out.println(arry13);
		System.out.println(arry14);
		// ex1) 도서명배열, 운동선수배열, 핸드폰회사배열을 선언,
		//		선언후 할당, 빈배열 3가지 형태로 선언과 할당하세요.
		/* String [] book; 
		String [] athle;
		String [] phone;
		book = null;
		athle = null;
		phone = null;
		

		System.out.println(book);
		System.out.println(athle);
		System.out.println(phone);
		*/
		String [] book = null;
		String [] player = null;
		player = new String[] {"홍길동","김길동","신길동"};
		String[] elCom = new String[3];
		System.out.println(book);
		System.out.println(player);
		System.out.println(elCom);
		/*
		 #여러가지 응용 예제를 활용하기..
		 1. 배열의 index를 랜덤으로 호출하여 출력//
		 */
		String[]games = {"가위","바위","보"};
		int rIdx1 = (int)(Math.random()*games.length);
		int rIdx2 = (int)(Math.random()*games.length);
		System.out.println(games[rIdx1]+":"+games[rIdx2]);
		
		// ex)홀/짝 게임을 5회 처리하여 출력하세요
		String[]game = {"홀","짝"};
		for(int cnt =1; cnt<=5;cnt++) {
			int rIdx3= (int)(Math.random()*game.length);
			System.out.println(cnt+"번째 "+game[rIdx3]);
		}
		/* 내가 쓴거 
		int num1 = (int)(Math.random()*game.length);
		int num2 = (int)(Math.random()*game.length);
		int num3 = (int)(Math.random()*game.length);
		int num4 = (int)(Math.random()*game.length);
		int num5 = (int)(Math.random()*game.length);
		System.out.println("#홀짝게임#");
		System.out.println(game[num1]+":"+game[num2]+":"+game[num3]+":"+game[num4]+":"+game[num5]);
		 */
		/*
		 2. 초기의 배열의 크기를 설정한 후, 데이터 할당 처리
		 */
		/*
		Scanner sc = new Scanner(System.in);
		System.out.print("등록할 회원의 이름을 입력:");
		int cnt = Integer.parseInt(sc.nextLine());
		
		String []names = new String[cnt];
		System.out.println("# 회원 "+cnt+"명의 이름을 입력하세요 #");
		
		for(int idx=0;idx<names.length;idx++) {
			System.out.print(idx+1+"번째 회원명:");
			names[idx] = sc.nextLine();			
		}
		System.out.println(" #등록한 회원명단# ");
		for(int idx=0;idx<names.length;idx++) {
			System.out.println(idx+1+"번째 회원 - "+names[idx]);
		}
		
		// ex) 대출할 책의 수를 입력하고, 도서명을 입력후,
		//	대출도서 리스트를 출력하세요.
		/*
		Scanner sc = new Scanner(System.in);
		System.out.print("대출 할 책의 권수를 입력하세요: ");
		int cnt = Integer.parseInt(sc.nextLine());
		
		String []books = new String[cnt];
		System.out.println("도서명을 입력하세요: ");
		for(int idx=0;idx<books.length;idx++) {
			System.out.print(idx+1+"번째 도서명: ");
			books[idx] = sc.nextLine();			
		}
		System.out.println("# 대출 도서 리스트 #");
		for(int idx=0;idx<books.length;idx++) {
			System.out.println(books[idx]);
		}
		*/
		/*
		Scanner sc2 = new Scanner(System.in);
		System.out.print("대출할 책의 권수를 입력하세요: ");
		blist[idx] = new String[bCnt];
		int bCnt = Integer.parseInt(sc2.nextLine());
		for(int idx=0;idx<blist.length;idx++);{
		System.out.println(idx+1+"번째 도서 입력:");	
		blist[idx] = sc2.nextLine();
		}
		System.out.println("#대출할 도서 리스트#");
		for(for(int idx=0;idx<blist.length;idx++);{
			System.out.println(idx+1+")" +blist[idx]);
		}
		}
		*//*
		String shape [] = {"♠","♥","♣","◈"};
		String []nums = {"A","2","3","4","5","6","7","8","9","J","Q","K"};
		String cards[] = new String[52];
		int cIdx=0;
		for(int idx=0;idx<shape.length;idx++); {
			for(int jdx=0;jdx<nums.length;jdx++) {
				cards[cIdx]=shape[idx]+""+nums[jdx];
				System.out.print(cards[cIdx]+",");
				cIdx++;
			}
		}
		System.out.println();
		System.out.println("#임의의 7장 카드#");
		for(int cnt =1;cnt<=7;cnt++) {
			int rIdx = (int)(Math.random()+cards.length);
			System.out.print(cards[rIdx]+",");
			
		
		}
		*/
		}
}