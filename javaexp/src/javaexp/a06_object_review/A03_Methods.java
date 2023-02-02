package javaexp.a06_object_review;

public class A03_Methods {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
/*
 		# 메서드
 		1) 필드와 상호관계 속에서 데이터 처리
 			ex) 물건구매시, 구매 물건의 갯수를 저장 및 전체 계 호출 
 		2) 주요 기능 처리
 			- 리턴 타입/실제 리턴값
 			  메서드는 리턴타입을 먼저 선언하고 그 리턴타입에 맞는 
 			  데이터를 마지막에 return 처리 하여야한다.
 			- 매개변수 처리 
 			  이 객체를 호출하는 외부 클래스 객체나 main()에서 데이터를 넘겨서
 			  처리할 때, 필요로 한다.
 			-{}(중괄호블럭안)에 처리할 프로세스 처리  
 */  
		Person2 p01 = new Person2();
		System.out.println(p01.getStr());
		String ret = p01.getStr();
		System.out.println("리턴문자:"+ret);
		System.out.println("필드 리턴:"+p01.getName());
		//ex)클래스 Computer를 선언하고, 필드로 컴퓨터 명을 선언,
		// 메서드 1: 컴퓨터의 이름, 메서드2: 컴퓨터의 수량 리턴 (임의로 지정)
		//해당 메서드를 호출하여 변수에 할당 또는 출력하세요.
		Computer c01 = new Computer();
		System.out.println("컴퓨터 이름:"+c01.getName());
		String name01 = c01.getName();
		System.out.println("이름:"+name01);
		int cnt01 = c01.getCnt();
		System.out.println("리턴값과 + 10"+(cnt01+10));
		c01.showIfo();
		System.out.println("컴퓨터 현재 상태:"+c01.curOnOff());
		c01.pushBtn(true);
		System.out.println("컴퓨터의 현재 상태:"+c01.curOnOff());
		// ex) Mart 클래스 선언 필드 pcnt(구매한 물건의 갯수). 기능 메서드 buyProd(int cnt) 매개변수로 
		//	한번에 구매한 물건의 갯수를 누적 처리 
		// get ProdCnt()는 리턴값 pcnt로 처리하여 현재 구매한 물건의 갯수를 확인할 수 있도록 하자.
		/*Mart as = new Mart();
		as.buyProd();      
		System.out.println("누적된 금액 : "+as.getProdCnt());	
*/
		Mart m01 = new Mart();
		m01.buyProd(5);
		m01.buyProd(8);
		m01.buyProd(7);
		m01.buyProd(3);
		System.out.println("현재 구매한 물건의 누적 갯수:"+m01.getProdCnt());
	//	m01.buyProdName("사과"); //아이패드 캡쳐본 
	//	m01.buyProdName("바나나");
	//	m01.buyProdName("딸기");
		System.out.println("현재 구매한 물건:"+m01.buyList());
		m01.buyProd("컴퓨터");
		m01.buyProd("냉장고");
		m01.buyProd("세탁기");
		m01.buyProd("비누");
		m01.buyProd("치약");
		m01.buyProd("과자");
		m01.showList();
	}

}
/*
class Mart{
	void buyProd() {
		int cnt = 10;
		int price = 10000;
		System.out.println("구매한 물건의 갯수"+cnt);
	}
	int getProdCnt() {
		return this.cnt*this.price;
	}
}
*/
class Mart {
	//초기에 데이터 할당하는 부분은 생성자를 통해서 처리
	//계속 변경을 하고 호출하는 부분에서 메서드를 통해서 처리.
	int pcnt;
	String pnames;
	String[] buylist;
	int buyIdx;
	Mart(){
		this.pnames="";
		buylist = new String[5];
	}	
	void buyProd(String pname) {
		if(buyIdx<5) {
			buylist[buyIdx++] = pname;
		}else {
			System.out.println("물건은 5개까지 구매가능합니다.");
		}
	}
	void showList() {
		for(int idx=0;idx<buylist.length;idx++) {
			System.out.println(idx+1+")"+buylist[idx]);
		}
	}
	void buyProd(int cnt) {
		System.out.println("이번에 구매한 물건 갯수: "+cnt);
		this.pcnt+=cnt;
		
	}
	//구매한 물건을 매개변수로 누적 처리 하는 메서드 .. 사과 바나나
	void buyProd2(String pname) {
		this.pnames+=pnames+",";
	
	}


	//현재 구매된 물건 리스트를 리턴 
	String buyList() {
		return this.pnames;
		
	}
	int getProdCnt() {
		return this.pcnt;
	}
	}

class Computer{
	String cName;
	boolean isOper;//boolean은 설정하지 않으면 default false
	Computer(){
		this.cName = "보통 컴퓨터";
	}
	Computer(String name){
		this.cName = cName;
	}
	void pushBtn(boolean on_or_off) {
		isOper = on_or_off;
	}
	String curOnOff() {
		return isOper?"가동중":"중지중";
	}
	void showIfo() {
		System.out.println("컴퓨터의 이름"+this.cName);
	}
	
	String getName() {
		return this.cName;
	}
	int getCnt() {
		return 25;
	}
}
class Person2{
	String name;
	Person2(){
		this.name = "무명";
	} 
	//문자열을 리턴하는 경우
	String getStr() {
		return "안녕하세요"; //바로 리턴
	}
	int getInt() {
		int num01 = 25;
		return num01;//선언된 데이터를 할당 후 리턴 
	}
	String getName() {
		return this.name; //필드값을 리턴
		
	}
	void show () {
		//리턴값이 없는 경우는 void
		System.out.println("이름을 출력:"+this.name);
	}
}

