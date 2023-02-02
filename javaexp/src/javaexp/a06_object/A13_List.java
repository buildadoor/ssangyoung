package javaexp.a06_object;

import java.util.ArrayList;

public class A13_List {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
/*
 		#객체형 배열
 		1. 고정된 배열안에 객체를 담는 처리 
 		2. 크기가 고정되어서 추가나 삭제가 불가능
 		*/
		int[] arry = {1000,2000,3000};
		Food01[] obArray = {new Food01("짜장면",6000),
							new Food01("짬뽕",7000),
							new Food01("탕수육",15000)
							};
		//cf) 참조변수, 메서드명, 일반변수는 소문자로 시작한되, 합성어 구분자로 대문자를
		//		중간에 추가한다.
		for (int idx=0;idx<arry.length;idx++) {
			System.out.println(idx+":"+arry[idx]); //stack영역데이터
		}
		for (int idx=0;idx<obArray.length;idx++) {
			System.out.println(idx+":"+obArray[idx]);
			Food01 f01 = obArray[idx];//stack영역 데이터 
			System.out.println(f01.getName()+":"+f01.getPrice());
	}
		Student01[] stArry = {
				new Student01("홍길동",80,80), 
				new Student01("김길동",80,90), 
				new Student01("신길동",70,80)
		};
		for(int idx=0;idx<stArry.length;idx++) {
			System.out.println(idx+":"+stArry[idx]);
			Student01 st = stArry[idx];
			System.out.print(st.getName()+":");
			System.out.print(st.getKor()+":");
			System.out.print(st.getEng()+"\n");
		}

		/*
		int[] student = {90,80,100};
		Student[] stArray = {new Student("홍길동",80,90,100),
							new Student("김둘리",90,40,50),
							new Student("이또치",60,100,80)
							};
		System.out.println("#학생별 점수#");
		for (int idx=0;idx<student.length;idx++) {
			System.out.println(idx+"점"+student[idx]);
		}
		for (int idx=0;idx<stArray.length;idx++) {
			System.out.println(idx+":"+stArray[idx]);
			Student s01 = stArray[idx];
			System.out.println("이름"+s01.getName()+" 국어"+s01.getKor()+"점"+" 영어"+s01.getEng()+"점");
		*/
		
		//ex) Student 이름 국어 영어 속성 생성자, set/get 메소드, 
		//Student[]선언하고 학생 정보 3명을 할당
		//for문을 통해서 이름 국어 , 영어, 출력 
		/* 1. 클래스 선언 
		 *		필드, 생성, get/set
		 * 2. 객체형 배열 선언 및 할당
		 * 3. for 배열처리 기본형식
		 * 		for(int idx=0;idx<배열명.length;idx++)
		 * 4. for문 안에 단위 객체 할당.
		 * 		객체 참조변수 = 배열명[idx]
		 * 5. 객체의 get메서드 호출 및 출력 처리.
 	
 		#객체형 동적배열
 		1. 데이터타입 List, ArrayList 선형 형식으로 선언된다.
 		2. 크기가 동적으로 변경이 가능하다.
 */	
	ArrayList list = new ArrayList(); //java.util.Array (import)
	//Objaect
	Object ob; // 자바의 모든 객체의 최상위 객체 최상위 ㅐㄱ체
	// 모든 객체를 할당할 수 있다. 
	ob="홍길동";
	ob= new Student01("홍길동",70,80);
	//ArrayList<Object> list; default로 된거나 다름없음
	//.add(추가할 데이터)
	list.add("사과");
	list.add("바나나");
	list.add("딸기");
	System.out.println("크기:"+list.size()); //.size();동적 배열 크기 
	for(int idx=0;idx<list.size();idx++) {
		//list.get(인덱스)
		System.out.println(idx+":"+list.get(idx));
	}
	list.add("오렌지");
	for(int idx=0;idx<list.size();idx++) {
	System.out.println(idx+":"+list.get(idx));
	}
	

	//좋아하는 3곡명을 ArrayList를 선언하고 추가하여 반복문을 통해서 출력하세요
	ArrayList fmusics = new ArrayList();
	fmusics.add("AfterLike");
	fmusics.add("Attention");
	//삭제처리 
	fmusics.remove(0);//첫번째 데이터 삭제 
	System.out.println("삭제후..");
	fmusics.add("Pink Venom");
	for(int idx=0;idx<fmusics.size();idx++) {
		System.out.println(idx+":"+fmusics.get(idx));
	}
	//add(),get(),remove(),size()
	//향상된 반복문
	//for 단위 데이터 배열형 객체
	System.out.println("#향상된 반복문 처리#");
	//ArrayList는 기본유형으로 Object가 담긴다
	for(Object music:fmusics) {
		System.out.println(music);
	}
		/*
		 # 동적 배열(ArrayList)에 객체할당하여 처리하기.
		 1. 유형의 선언.
		 	ArrayList list; : 기본 Object형 데이터 선언.
		 2. 특정한 객체의 유형의 데이터 처리.
		 	ArrayList<클래스명> list = new
		 		ArrayList<클래스명>();
		 	<> : generic
		 		해당 유형의 동적배열을 선언한다는 의미이다.
		 				 */
		ArrayList<Student01> stList = new ArrayList<Student01>();
		stList.add(new Student01("홍길동",70,92));
		stList.add(new Student01("김길동",70,92));
		stList.add(new Student01("신길동",70,92));
		for(int idx=0;idx<stList.size();idx++) {
			Student01 st = stList.get(idx);
			System.out.println(idx+":"+st);
			System.out.println(" "+st.getName());
			System.out.println(":"+st.getKor());
			System.out.println(":"+st.getEng());
		}
		ArrayList<Food01> fdList = new ArrayList<Food01>();
		fdList.add(new Food01("짜장면",6000));
		fdList.add(new Food01("짬뽕",7000));
		fdList.add(new Food01("탕수육",15000));
		for(Food01 food:fdList) {
			System.out.print(food.getName()+"\t");
			System.out.println(food.getPrice());
	}
	}
}
class Student01{
	private String name;
	private int kor;
	private int eng;
	public Student01(String name, int kor, int eng) {
		this.name = name;
		this.kor = kor;
		this.eng = eng;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getKor() {
		return kor;
	}
	public void setKor(int kor) {
		this.kor = kor;
	}
	public int getEng() {
		return eng;
	}
	public void setEng(int eng) {
		this.eng = eng;
	}
	
}	

class Student02{
	private String name;
	private int kor;
	private int eng;
	private int math;
	public Student02
	(String name, int kor, int eng, int math) {
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getKor() {
		return kor;
	}
	public void setKor(int kor) {
		this.kor = kor;
	}
	public int getEng() {
		return eng;
	}
	public void setEng(int eng) {
		this.eng = eng;
	}
	public int getMath() {
		return math;
	}
	public void setMath(int math) {
		this.math = math;
	}

}

class Food01{
	private String name;
	private int price;
	public Food01(String name, int price) {
		this.name = name;
		this.price = price;
	}// 필드값을 호출할때 (간접적)
	public String getName() {
		return name;
	}// 필드값을 저장할떄 (간접적)
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
}

