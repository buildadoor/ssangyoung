package javaexp.a01_begin;

public class A07_ConsolePrint {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
/* 
 #자바프로그램의 console 창 출력
 1. System.out.println("");
 	자바에서 기본적으로 console창에 출력할 내용을 ""(문자열)로 처리할 때, 사용한다.
 	println()줄바꿈 가능을 포함하고 있다.
 2. system.out.print();
 	줄바꿈을 포함하지 않을때, 사용하는 명렁어.
 
 * /
		System.out.println("안녕하세요1");
		System.out.println("안녕하세요1");
		System.out.println("안녕하세요1");
		System.out.print("안녕하세요2 ");
		System.out.print("안녕하세요2 ");
		System.out.print("안녕하세요2 ");
		/*
		 # 자바의 출력 메서드에서 사용하는 특수문자
		 1. \n : 줄바꿈 
		 2. \t : 탭간격으로 일정한 간격을 처리할 때, 활용된다.
		 3. 내부적으로 "을 출력하고자 할 때, 
		  \",
		  
		 */
		System.out.println("\"안녕\" ");
		System.out.println("1\n2\n3\n4\n5");
		System.out.println("1\t2\t3\t4\t5");
		System.out.println("12\t22\t33\t44\t55");
		System.out.println("123\t222\t333\t444\t555");
		
		//ex) 학생 3명의 국어, 영어, 수학 성적으로 
		//이름과 함께 출력하되 \n, \t를 활용하여
		//정렬을 처리하여 나타내세요
		
		System.out.println("김일일\t90\t80\t90\n김이이\t70\t60\t100\n김삼삼\t85\t95\t50");
		String st1name="홍길동";
		String st2name="김길동";
		String st3name="신길동";
		int st1kor = 70; int st2kor = 80; int st3kor = 90;
		int st1eng = 80; int st2eng = 70; int st3eng = 50;
		int st1math = 90; int st2math = 60; int st3math = 80;
		
		System.out.println("이름\t국어\t영어\t수학");
		System.out.print(st1name+"\t");
		System.out.print(st1kor+"\t");
		System.out.print(st1eng+"\t");
		System.out.print(st1math+"\n");
		System.out.print(st2name+"\t");
		System.out.print(st2kor+"\t");
		System.out.print(st2eng+"\t");
		System.out.print(st2math+"\n");
		System.out.print(st3name+"\t");
		System.out.print(st3kor+"\t");
		System.out.print(st3eng+"\t");
		System.out.print(st3math+"\n");
		
	}

}
