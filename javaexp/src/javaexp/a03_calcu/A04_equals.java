package javaexp.a03_calcu;

public class A04_equals {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
/*
 # 비교연산자
 1. 두개의 피연산자의 값을 비교하여 동일한지(==)
	같지 않는지(!=). 큰지(>), 작은지(<) 등을 
	boolean(true/false)값으로 결과를 처리하는 연산자를 말한다.
 2. 종류
 	==,!=,>=,<=,>,<
 3. 활용
 	조건문이나 반복문에 처리할 때, 사용된다. 

 */
		int num01 = 25;
		int num02 = 5;
		System.out.println("#비교 연산 결과#");
		System.out.println(num01+" == "+num02+" = "+(num01==num02));
		System.out.println(num01+" != "+num02+" = "+(num01!=num02));
		System.out.println(num01+" >= "+num02+" = "+(num01>=num02));
		System.out.println(num01+" <= "+num02+" = "+(num01<=num02));
		System.out.println(num01+" > "+num02+" = "+(num01>num02));
		System.out.println(num01+" < "+num02+" = "+(num01<num02));
		//ex) 획득점수, 합격기준점수를 입력받거나 임의로 입력하여
		//	합격여부를 boolean (true/false)로 출력
		/*int score = 95;
		int pass = 90;
		System.out.println("획득점수"+score);
		System.out.println("합격기준"+pass);
		System.out.println(pass+" <= "+score + " = "+(pass<=score));
		System.out.println("합격기준"+" <= "+"획득점수"+" = " +(("합격점수"<="획득점수"));
		*/
		int score = 70; //획득점수
		int stdpt = 80; //합격여부기준
		System.out.println("합격여부:"+(score>=stdpt));
		//ex1)4지 선다에 정답번호 지정, 체크한 번호 선언 
		// 정답여부 출력 
		int correct = 1; //정답번호지정
		int answer = 2; //체크
		System.out.println("정답여부:"+(correct==answer));
		
		
	}
}