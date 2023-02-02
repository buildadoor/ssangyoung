package javaexp.z01_homework;

import java.util.ArrayList;

public class A15_0914 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
/*
 2022-09-14
[1단계:개념] 1. (연습이 필요한 분)1:1관계 설정 연습 - 연필/종이, TV/리모콘, 어머니/자식, 스포츠팀/감독
			1:1 관계 연습 Student(이름,ElementSch) ElementSch(학교명, 졸업연도)
	//	1) ElementSch - 필드와 기본 정보 출력
	// 2) Student - 이름, ElementSch,
		// 생성자, ElementSch 추가메서드, 출력메서드
[1단계:개념] 2. 데이터의 처리 단계별 내용을 예제와 함께 기술하세요. 기본유형 ~~~  1:다 객체형까지.. 
-byte : bit가 8개 모여 데이터의 기본 유형 시작
-char: 문자단위 - char ch01 = '가';
-int: 정수 - int num01 = 1;
-double: 실수 - double num02 = 0.1;
-배열형 데이터 
1) 기본데이터 유형
	int[] arry = {1,2,3};
	double[] arry = {1.5,1.7...};
2) 문자열
	char[] carry = {'금','은','동'};
	String name = "금은동"; 
-객체형 데이터
1) 다른 유형의 데이터를 모아서 처리
	class coffee{
		String menu;
		int price;
		}
		Coffee c01 = new Coffee();
-1:1 관계 클래스의 선언과 객체 형성
	선언 방식: 종속될 클래스 선언, 포함할 클래스 선언
-1:다 관계 객체 활용
	선언 방식: 다중의 포함될 객체의 단일 유형의 클래스 선언, 포함할 클래스 선언 
				
[1단계:개념] 3. 정적배열과 동적배열의 차이점을 예제를 통해서 설명하세요.
	-객체형 배열
 		고정된 배열안에 객체를 담는 처리로 크기가 고정되어서 추가하거나 삭제하는 것이 불가능하다
 	-객체형 동적배열
 		데이터타입 List, ArrayList 선형 형식으로 선언되고 크기가 동적으로 변경이 가능하다.

		 				
[1단계:코드] 4. 구매한 물건(물건명,가격,갯수) 3개를 클래스를 선언하고 정적배열로 선언 할당 후, 배열을 통해서 출력하세요.
	ArrayList<Product01> pList = new ArrayList<Product01>();
		pList.add(new Product01("연필",300,10));
		pList.add(new Product01("지우개",500,3));
		pList.add(new Product01("필통",7000,1));
		for(int idx=0;idx<pList.size();idx++) {
			Product01 p = pList.get(idx);
			System.out.println("*"+p.getpName()+"*");
			System.out.print(p.getpPrice()+"원");
			System.out.println(p.getpCnt()+"개");
		}
}
}
class Product01{
	private String pName;
	private int pPrice;
	private int pCnt;
	public Product01 (String pName, int pPrice, int pCnt) {
		this.pName = pName;
		this.pPrice = pPrice;
		this.pCnt = pCnt;
	}
	public String getpName() {
		return pName;
	}
	public void setpName(String pName) {
		this.pName = pName;
	}
	public int getpPrice() {
		return pPrice;
	}
	public void setpPrice(int pPrice) {
		this.pPrice = pPrice;
	}
	public int getpCnt() {
		return pCnt;
	}
	public void setpCnt(int pCnt) {
		this.pCnt = pCnt;
	}
	
}

[1단계:코드] 5. 팀(팀명,승,무,패) 3개의 클래스를 정적배열객체로 선언 for문을 통해 getXXX메서드로 출력하세요.




[1단계:개념] 6. 동적배열처리하는 객체 ArrayList에서 사용하는 메서드의 기능을 기본예제를 통하여 설명하세요.
	/*
		 # 동적 배열(ArrayList)에 객체할당하여 처리하기.
		 1. 유형의 선언.
		 	ArrayList list; : 기본 Object형 데이터 선언.
		 2. 특정한 객체의 유형의 데이터 처리.
		 	ArrayList<클래스명> list = new
		 		ArrayList<클래스명>();
		 	<> : generic
		 		해당 유형의 동적배열을 선언한다는 의미이다.

[1단계:코드] 7. 읽어야할 도서명 5권을 ArrayList로 선언/추가하고 출력하세요.
		System.out.println("읽어야하는 8월 마지막 주 베스트셀러 ");
		ArrayList books = new ArrayList();
		books.add("하얼빈");
		books.add("불편한 편의점2");
		books.add("역행자");
		books.add("잘될 수밖에 없는 너에게");
		for(int idx=0;idx<books.size();idx++) {
			System.out.println(idx+":"+books.get(idx));
		}
		books.add("원씽");
		for(int idx=0;idx<books.size();idx++) {
			System.out.println(idx+":"+books.get(idx));
	}
}
}

[1단계:개념] 8. 1:다관계와 1:1관계 처리 구조의 차이점을 기술하세요.
	-1:1 관계는 하나의 객체안에 하나의 객체를 사용할 수 있다 
	-1:다 관계는 하나의 객체안에 여러개의 객체를 사용할 수 있다


[1단계:코드] 9. 아래의 1:다관계 동적처리 구조의 데이터를 처리하세요.
      1) 마트/구매물건 2) 도서관/빌린도서  3) 컴퓨터/구성하는부품
      
      #처리 순서
      1. 포함될 클래스
      	필드/get/set/출력메서드
      2. 포함할 클래스
      	필드(고유속성, 포함될 클래스 ArrayList)
      	생성자(고유 속성 초기화, ArrayList객체 생성)
      	메서드(단일 추가메서드 / 다중 추가메서드/ 전체 출력내용처리)
      	
 */ //에러 .
		/*. 
	Mart m1 = new Mart("HomePlus");
	m1.showAll();
	m1.addlist(new BuyingList("요거트"));
	m1.addlist(new BuyingList("시리얼"));
	ArrayList<BuyingList> = new ArrayList <BuyingList>();
    mlist.addlist(new BuyingList("블루베리"));
    mlist.addlist(new BuyingList("망고"));
    m1.addlist(mlist);
    m1.showAll();		
	}
	}
class Mart{
	private String mName;
	private ArrayList <BuyingList> mlist;
	public Mart(String mName) {
		this.mName = mName;
		this.mlist = new ArrayList<BuyingList>();
	}
	public String getmName() {
		return mName;
	}
	public void addlist(BuyingList m) {
		this.mlist.add(m);
		System.out.println(m.getProduct()+"장바구니에 추가되었습니다.");
	}
	public void getMlist() {
		this.mlist.addAll(mlist);
		System.out.println(mlist.size()+"구매목록 ");
	}
	public void showAll(ArrayList<BuyingList> mlist) {
		System.out.println("*"+this.mName+"에서 구매물건");
	if(this.mlist.size()>0);{
		for(BuyingList m:this.mlist) {
			System.out.println(m.getProduct());
			}
		}else {
			System.out.println("");
		}
	
}
class BuyingList{
	private String name;

	public BuyingList(String name) {
		this.name = name;
	}

	public String getProduct() {
		return name;
	}

	public void setProduct(String name) {
		this.name = name;
	}
	*/
		/*
		Mart m = new Mart("행복");
		m.calcu();
		m.addBuyList(new Product("사과",2000,2));
		m.addBuyList(new Product("바나나",4000,3));
		m.addBuyList(new Product("오렌지",1200,5);
		m.calcu();
	}
}
class Mart{
private String mname;
private ArrayList<Product> blist;
public Mart(String mname) {
	this.mname = mname;
	this.blist = new ArrayList<Product>();
}
public void addBuyList(Product product) {
	this.blist.add(product);
	System.out.println(product.getName()+""+product.getCnt+"구매목록에 담았습니다.");
}
public void calcu() {
	System.out.println(mname+"마트에서 구매 및 계산서");
	if(blist.size()>0) {
		int cnt = 0;
		int tot = 0;
		System.out.println("no\t물건명\t가격\t갯수\t계");
		for(Product prod:blist) {
			System.out.println(++cnt+"\t");
			tot+=prod.buyInfo();
		}
		System.out.println("총계:"+tot);
		
	}else {
		System.out.println("아직 구매내역이 없습니다.");
	}
	
}
}
class Product{
private String name;
private int price;
private int cnt;
public Product(String name, int price, int cnt) {
	this.name = name;
	this.price = price;
	this.cnt = cnt;
}
public void buyInfo() {
	System.out.print(this.name+"\t");
	System.out.print(this.price+"\t");
	System.out.print(this.cnt+"\t");
	System.out.print(this.cnt*this.price+"\n");
	return this.price*this.cnt;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getCnt() {
		return cnt;
	}
	public void setCnt(int cnt) {
		this.cnt = cnt;
	}
	
}
*//*
		Library lb = new Library("서울 시립도서관");
		lb.showLentList();
		lb.addLendList(new LBook("himan","기초자바","2022-10-10"));
		lb.addLendList(new LBook("higirl","jsp향상","2022-10-15"));
		lb.addLendList(new LBook("goodMan","스프링완성","2022-11-14"));
	}
	}
class Library{
	private String name;
	private ArrayList<LBook> lblist;
	public Library(String name) {
		this.name = name;
		this.lblist = new ArrayList<LBook>();
	}
	public void addLendList(LBook book) {
		this.lblist.add(book);
		System.out.println(book.getLendId()+"님이 "+book.getTitle()+"대출하였습니다.");
	}
	public void showLentList() {
		System.out.println(name+"에서 대출된 대출 내역");
		if(lblist.size()>0) {
			System.out.println("번호\t대출자\t도서명\t반납일");
			for(int idx=0;idx<lblist.size();idx++) {
				LBook bk = lblist.get(idx);
				bk.lendInfo(idx+1); //번호리스트 
		}
		System.out.println("총 "+lblist.size()+"권 대출되었습니다!");
	}else {
		System.out.println("대출된 내역이 없습니다");
	}
}
class LBook{
	//빌린 사람 도서명 반납일
	private String lendId;
	private String title;
	private String endDate;
	public LBook(String lendId, String title, String endDate) {
		this.lendId = lendId;
		this.title = title;
		this.endDate = endDate;
	}
	public void lendInfo(int no) {
		System.out.println(no+"\t");
		System.out.println(lendId+"\t");
		System.out.println(title+"\t");
		System.out.println(endDate+"\t");
	}
	public String getLendId() {
		return lendId;
	}
	public void setLendId(String lendId) {
		this.lendId = lendId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	}
}
*/
		Computer01 com = new Computer01("데스크탑","조립품");
		com.setPlist(new Part("CPU","인텔","i7 3.5GHZ"));
		com.setPlist(new Part("Ram","하이닉스","16G"));
		com.setPlist(new Part("ssd","삼성","250G"));
		com.showPartList();
	}
}
class Computer01{
	private String kind; //종류
	private String comp; //제조사
	private ArrayList<Part> plist;
	public Computer01(String kind, String comp) {
		this.kind = kind;
		this.comp = comp;
		this.plist = new ArrayList<Part>();
	}
	public void setPlist(Part p) {
		this.plist.add(p);
		System.out.println(p.getPname()+"부품 추가");
	}
	public void showPartList() {
		System.out.println("#컴퓨터 사양#");
		System.out.println("종류:" +kind);
		System.out.println("제조사:"+comp);
		if(plist.size()==0) {
			System.out.println("부품이 아직 없네요.");
		}else {
			System.out.println("포함된 부품리스트");
			for(Part p : plist) {
				System.out.println(p);
			}
	}
}
	public String getKind() {
		return kind;
	}
	public void setKind(String kind) {
		this.kind = kind;
	}
	public String getComp() {
		return comp;
	}
	public void setComp(String comp) {
		this.comp = comp;
	}
	public ArrayList<Part> getPlist() {
		return plist;
	}

	}
	

class Part{
	//부품 종류, 제조사, 사양
	private String pname;
	private String comp;
	private String perform;
	public Part(String pname, String comp, String perform) {
		this.pname = pname;
		this.comp = comp;
		this.perform = perform;
	}
	@Override
	public String toString() {
		return "Part [pname=" + pname + ", comp=" + comp + ", perform=" + perform + "]";
	}


	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getComp() {
		return comp;
	}
	public void setComp(String comp) {
		this.comp = comp;
	}
	public String getPerform() {
		return perform;
	}
	public void setPerform(String perform) {
		this.perform = perform;
	}
}
	