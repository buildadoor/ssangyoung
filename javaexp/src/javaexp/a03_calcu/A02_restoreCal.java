package javaexp.a03_calcu;

public class A02_restoreCal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
/*
 # 대입연산자
 1. = : 데이터를 오른쪽에서 왼쪽으로 대입하여 할당하는 연산자
 
 */
		int num01 = 25;
		int num02, num03, num04; 
		// 한꺼번에 정수형 데이터를 3개 선언 
		num02 = num03 = num04 =5;
		int num05=6;double num06=1.4;float num07=4.7F;
		System.out.println("# 대입연산자 #");
		System.out.println("num02:"+num02);
		System.out.println("num03:"+num03);
		System.out.println("num04:"+num04);
		System.out.println("num05:"+num05);
		System.out.println("num06:"+num06);
		System.out.println("num07:"+num07);
		//ex) 회원의 id를 3개 만들고, 해당 아이디를 각각 할당하고,
		//	회원 id의 pt를 3개 변수로 만들고, 초기에 10000을
		//	할당하여 id와 pt를 출력하세요
		int cs01, cs02, cs03;
		cs01 = cs02 = cs03 =10000;
		System.out.println("#회원 ID와 PT#");
		System.out.println("cs01:"+cs01+"pt");
		System.out.println("cs02:"+cs02+"pt");
		System.out.println("cs03:"+cs03+"pt");
		//해설
		String id01,id02,id03;
		id01="himan";id02="goodMan";id03="higirl";
		int pt01,pt02,pt03;
		pt01 = pt02 = pt03 = 10000;
		System.out.println("아이디\t포인트");
		System.out.println(id01+"\t+pt01");
		System.out.println(id02+"\t+pt02");
		System.out.println(id03+"\t+pt03");
		
		//ex1) 학생2명의 이름과 국어, 영어, 수학점수를 할당하여
		//		아래와 같이 출력하세요 
		//이름 국어 영어 수학 평균
		//@@@ @@@ @@@ @@ @@
		//@@@ @@@ @@@ @@ @@
		/*
		String st01name ="홍길동";
		String st02name ="이길동";
		int st01Kor = 80;
		int st01Eng = 70;
		int st01Math = 80;
		int st02kor = 60;
		int st02Eng = 90;
		int st02Math = 90;
		System.out.println("학생이름"+st01name);
		System.out.println("국어"+st01Kor);
		System.out.println("영어"+st01Eng);
		System.out.println("수학"+st01Math);
		*/
	String name01,name02;
	name01="홍길동"; name02="김길동";
	int kor1,kor2,eng1,eng2,mat1,mat2;
	kor1=70;kor2=80;eng1=80;eng2=80;mat1=90;mat2=80;
	System.out.println("이름\t");
	System.out.println("국어\t");
	System.out.println("영어\t");
	System.out.println("수학\t");
	System.out.println("평균\n");
	double avg1 = (kor1+eng1+mat1)/3.0;
	double avg2 = (kor2+eng2+mat2)/3.0;
	System.out.println(name01+"\t"+kor1+"\t"+eng1+"\t"+mat1+"\t"+avg1);
	System.out.println(name02+"\t"+kor2+"\t"+eng2+"\t"+mat2+"\t"+avg2);
	
	
	
		
		
	}

}
