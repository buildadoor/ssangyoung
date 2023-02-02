package javaexp.a03_calcu;

public class A03_incre_des {



	public static void main(String[] args) {
		// TODO Auto-generated method stub
/*
 #증감 연산자
 1. 변수명++, 변수명--
 	1씩 증가/감소처리
 	++cnt01 증가된 내용을 출력
 	cnt01++ 다음 호출시 증가된 내용 확인
 	
 	
 	
 #증갑 대입 연산자
 	특정한 단위로 증감하는 연산자.
 1. 변수명 +=증가단위;
 	변수명 -=감소단위;
 	
 	cnt01+=3 증가된 내용을 출력
 	
 	
 	
 	
 */
	/*int cnt =1;
	System.out.println(cnt++);
	System.out.println(cnt++);
	System.out.println(cnt++);
	System.out.println(cnt--);
	System.out.println(cnt--);
	System.out.println(cnt--);
	System.out.println(cnt++);
	System.out.println(cnt++);
	System.out.println(cnt+=3);
	System.out.println(cnt+=3);
	System.out.println(cnt+=3);
	System.out.println(cnt+=5);
	System.out.println(cnt+=5);
	System.out.println(cnt+=5);
	System.out.println(cnt+=5);
	System.out.println(cnt+=5);
	System.out.println(cnt+=5);
	*/
	//ex1) 1~5가지 증가 5~1 감소 처리하세요
//++cnt01 증가된 내용을 출력 cnt01++ 다음 호출시 증가된 내용 확인 
	/*int cnt =1;
	System.out.println(cnt+++"\t");
	System.out.println(cnt++);
	System.out.println(cnt++);
	System.out.println(cnt++);
	System.out.println(cnt++);
	System.out.println(cnt--);
	System.out.println(cnt--);
	System.out.println(cnt--);
	System.out.println(cnt--);
	System.out.println(cnt--);
	System.out.println(cnt--);	
	*/
	int cnt01=1;
	System.out.println(cnt01+++"\t");
	System.out.println(cnt01+++"\t");
	System.out.println(cnt01+++"\t");
	System.out.println(cnt01+++"\t");
	System.out.println(cnt01+++"\n");
//cnt01 =6
	System.out.println(--cnt01+"\t");
	System.out.println(--cnt01+"\t");
	System.out.println(--cnt01+"\t");
	System.out.println(--cnt01+"\t");
	System.out.println(--cnt01+"\n");
	//ex2) 증감 대입연산자를 활용해서 3의 배수로 5회 증가하세요
	/*System.out.println(cnt+=3);
	System.out.println(cnt+=3);
	System.out.println(cnt+=3);
	System.out.println(cnt+=3);
	System.out.println(cnt+=3);
	*/
	int cnt02=0;
	System.out.print((cnt02+=3)+"\t");
	System.out.print((cnt02+=3)+"\t");
	System.out.print((cnt02+=3)+"\t");
	System.out.print((cnt02+=3)+"\t");
	System.out.print((cnt02+=3)+"\t");
	System.out.print((cnt02+=3)+"\n");
	
	//ex3) 증가 연산자로 1~10까지 누적합산값을 처리하세요
	/*int cnt01 =1;
	System.out.println(cnt01++);
	System.out.println(cnt01++);
	System.out.println(cnt01++);
	System.out.println(cnt01++);
	System.out.println(cnt01++);
	System.out.println(cnt01++);
	System.out.println(cnt01++);
	System.out.println(cnt01++);
	System.out.println(cnt01++);
	System.out.println(cnt01++);
*/
	int cnt03=0;
	System.out.println((cnt03+=1)+"/t");
	System.out.println((cnt03+=2)+"/t");
	System.out.println((cnt03+=3)+"/t");
	System.out.println((cnt03+=4)+"/t");
	System.out.println((cnt03+=5)+"/t");
	System.out.println((cnt03+=6)+"/t");
	System.out.println((cnt03+=7)+"/t");
	System.out.println((cnt03+=8)+"/t");
	System.out.println((cnt03+=9)+"/t");
	System.out.println((cnt03+=10)+"/n");
			
	//ex)초기값 cnt04 100을 할당한 후 -5씩 3회 감소
	/*int cnt04=100;
	System.out.println(cnt04-5+"\t");
	System.out.println(cnt04-5+"\t");
	System.out.println(cnt04-5+"\t");
	괄호 안넣었*/
	
	
	}





}
