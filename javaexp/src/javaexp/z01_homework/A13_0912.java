package javaexp.z01_homework;

public class A13_0912 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
/*
 2022-09-12
[1단계:확인] 1. [매개변수+필드] Caffee 클래스 선언,
필드 : 주문커피종류, 주문 가격, 주문 갯수
메서드 : orderName - 주문커피종류 저장
orderCoffee - 주문커피종류, 가격, 갯수 저장
getPay - 총비용(가격갯수) 리턴
getName() - 주문커피종류 리턴
showAll() - 저장된 주문커피종류,가격,갯수,총액 문자열리턴
[1단계:확인] 2. [필드+로직처리] Gugu 클래스 선언
필드 : 단수, 시작단수, 마지막단수
메서드 : schGrade - 단수지정
showResult - 해당 단수의 1~9까지 연산 출력
setFromTo - 시작단수,마지막단수 지정
showResult2 - 범위가 있는 단수 출력
[1단계:확인] 3. [필드+로직처리] Bus 클래스 선언 
필드 : 버스번호, 구간, 비용
메서드 : basicInfo - 입력 버스번호, 구간, 비용
takeBus - 입력 : 인원수 리턴:비용*인원수
화면 출력 : 구간 @@ 인  @@번 @@명 탑승
 */
		/*
class Caffee{
	private String cname;
	private int price;
	private int cnt;
	public void orderName(String cname) {
		this.cname = cname;
	}
	public void orderCoffee(String name, int price, int cnt) {
		this.cname = cname;
		this.price = price;
		this.cnt = cnt;
	}
	public int getPay() {
		return this.price*this.cnt;
	}
	public String getname() {
		return this.cname;
	}
	public String showAll() {
		String ret = "커피종류:"+this.cname+",가격:"+this.price+",갯수:"+this.cnt+", 총액:"+this.price*this.cnt;
		return ret;
	}
}
*/
class Gugu{
	int grade;
	int start;
	int end;
	void schGrade(int grade) {
		this.grade = grade;
	}
	void showResult() {
		System.out.println("#"+this.grade+"단 #");
		for(int cnt =1;cnt<=9;cnt++) {
			System.out.println(this.grade+"X"+cnt+"="+this.grade*cnt);
		}
	}
	void setFromTo(int start, int end) {
		this.start = start;
		this.end = end;
	}
	void showResult2() {
		//showResult2 = 범위가 있는 단수 출력 지역변수??
		
		for(int grade = this.start;grade<=this.end;grade++) {
			System.out.println("#"+grade+"단 #");
			for(int cnt =1;cnt<=9;cnt++) {
				System.out.println(grade+"X"+cnt+"="+grade*cnt);
			}
		}
	}
	}
//3번 
class Bus{
	private int no;
	private String fromTo="";
	private int pay;
	public void basicInfo(int no, String fromTo, int pay) {
		this.no = no;
		this.fromTo = fromTo;
		this.pay = pay;
	}
	public int takeBus(int cnt) { //인원수 입력
		System.out.println("구간 : "+fromTo+"인");
		System.out.println(this.no+"번 "+cnt+"명 탑승");
		return this.pay*cnt;// 리턴 : 비용*인원수
	}
	}
}
}
