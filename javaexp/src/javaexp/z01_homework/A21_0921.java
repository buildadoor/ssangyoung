package javaexp.z01_homework;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class A21_0921 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 2022-09-21
[1단계:개념] 1. Collections의 핵심 3가지 인터페이스와 특징을 기술하세요.

			1)List - ArrayList, Vector, LinkedList
		 			주요기능: 순서를 유지하고 저장, 중복 저장 가능
		 	2)Set - HashSet, TreeSet
		 			주요기능: 순서를 유지하지 않고 저장, 중복 저장 안됨
		 	3)Map - Hashmap, Hashtable, TreeMap, Properties
		 			주요기능:키와 값의 쌍으로 저장, 키는 중복 저장이 안됨
		
[1단계:개념] 2. List에서 지원하는 메서드의 기능을 예제를 통하여 설명하세요.

			boolean add()
		 	Void add(int index, 추가객체)
		 	set(int index, 변경객체)
		 	
		 	boolean contains(요소객체) : 요소 객체가 있는지 여부
		 	get (int index):특정 위치에 있는 요소객체 가져오기
		 	isEmpty() : 컬렉션이 비어있는지 확인
		 	int size() : 크기
		 	
		 	void clear(): 포함된 모든 객체를 삭제
		 	remove(int index) : 해당 위치의 객체를 삭제
		 	boolean remove(Object o): 주어진 객체를 삭제 
		
			List<String> slist = new ArrayList<String>();
			slist.add("메론");
			slist.add("망고");
			slist.add(0,"귤"); //첫번째에 추가객체 귤을 넣는다.
			System.out.println(slist);
			slist.set(1, "키위");//두번째 객체를 키위로 수정한다
			slist.remove(1);//키위 삭제
			
[1단계:코드] 3. List<Player>를 통해 Player팀명,선수명,성적을 선언하고, 회원등록/수정/삭제 처리를 하세요.
		List<Player> plist = new ArrayList<Player>();
		plist.add(new Player("SSG","한유섬","타점94"));
		plist.add(new Player("LG","김현수","타점100"));
		plist.add(new Player("키움","이정후","타점104"));
		Player p = plist.get(0);
		System.out.println("회원등록여부1"+plist.contains(p));
		Player p2 = new Player("LG","김현수","타점100");
		System.out.println("회원등록여부2"+plist.contains(p));
		Player p3 = new Player("키움","이정후","타점104");
		System.out.println("수정:"+plist.set(0, new Player("삼성","피렐라","타점101"))); //수정???
		System.out.println("크기:"+plist.size());
		plist.clear();
		System.out.println("삭제여부:"+plist.isEmpty());
		System.out.println("크기:"+plist.size());
	}
}
class Player{
	private String team;
	private String name;
	private String score;
	public Player(String team, String name, String score) {
		this.team = team;
		this.name = name;
		this.score = score;
	}
	public String getTeam() {
		return team;
	}
	public void setTeam(String team) {
		this.team = team;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getScore() {
		return score;
	}
	public void setScore(String score) {
		this.score = score;
	}
}
[1단계:코드] 4. List<Card>를 통해 카드(모양,번호) 52장을 만들고, 임의의 카드 7장을 추출하여 출력하세요.
 		List <Card> card = new ArrayList<Card>();
	      
	      for(int cnt=1; cnt<=13; cnt++) {
	            card.add(new Card("♠",cnt));
	      }
	      for(int cnt=1; cnt<=13; cnt++) {
	         card.add(new Card("♣",cnt));
	      }
	      for(int cnt=1; cnt<=13; cnt++) {
	         card.add(new Card("♥",cnt));
	      }
	      for(int cnt=1; cnt<=13; cnt++) {
	         card.add(new Card("◆",cnt));
	      }
	      System.out.println("^Random Card^");
	      
	      for(int cnt = 0; cnt<=6; cnt++) {
	         int rIdx = (int)(Math.random()*card.size());
	         Card c = card.get(rIdx);
	         if(c.getNum()==11) {
	            System.out.println((cnt+1)+"번 카드 "+c.getShape()+"J");
	         }else if(c.getNum()==12) {
	            System.out.println((cnt+1)+"번 카드 "+c.getShape()+"Q");
	         }else if(c.getNum()==13) {
	            System.out.println((cnt+1)+"번 카드 "+c.getShape()+"K");
	         }else {
	            System.out.println((cnt+1)+"번 카드 "+c.getShape()+c.getNum());
	         }
	      }

	}
}

class Card{
   
   String shape;
   int num;
   
   public Card(String shape, int num) {
      this.shape = shape;
      this.num = num;
   }
   
   public String getShape() {
      return shape;
   }
   public void setShape(String shape) {
      this.shape = shape;
   }
   public int getNum() {
      return num;
   }
   public void setNum(int num) {
      this.num = num;
   }  
}

[2단계:코드] 5. 위 3번 선수데이터를 임의로 5명 정도 등록하고, 선수의 이름과 성적으로 검색되는 로직를 처리하세요.

////////
[1단계:코드] 6. 주머니속에 1000원 2장, 5000원 3장, 10000원 2장을 넣었을 때, Set객체로 처리하여 안에 있는
      금액의 합산을 출력하세요
      	Set<Integer> pocket = new HashSet<Integer>();
			pocket.add(1000);
			pocket.add(1000);
			pocket.add(5000);
			pocket.add(5000);
			pocket.add(5000);
			pocket.add(10000);
			pocket.add(10000);		
			System.out.println("내 주머니에 있는 돈");
			for(Integer money:pocket) {
				System.out.println(money);
			}
		System.out.println("총 금액:"+pocket.hashCode());
		}
	
	}
[1단계:개념] 7. Map의 기능메서드를 기본 예제와 함께 나열하세요.

put(Key, Value): 주어진 키와 값을 추가, 저장이 되면 값을 리턴
containsKey(Object key): 주어진 키가 있는지 여부 
containsValue(Object val): 주어진 값이 있는지 여부
Set<Map.Entry<K,V>> entrySet() : 키와 값의 쌍으로 구성된 모든 Map.Entry 객체를 Set에 담아서 리턴
V get(Object key) :컬렉션이 비어있는지 여부
keySet() : 모든 키를 Set객체에 담아서 리턴
size(): 저장된 크기
clear(): 전체 삭제
remove(Object key):키로 해당 구성 데이터 삭제.
			 	

[2단계:코드] 8. Map<String, Civilian> 형태로 주민번호와 주민(이름, 사는곳)을 설정하여 5명을 할당하고, 출력하세요
		Map<String, Civilian> person = new HashMap<String,Civilian>();
		person.put("900101-1010111", new Civilian("이윤아", "목동"));
		person.put("920202-2020222", new Civilian("김둘리", "서교동"));
		person.put("930303-1313333", new Civilian("이또치", "동교동"));
		person.put("940404-2424444", new Civilian("마이콜", "불당동"));
		person.put("950505-1515555", new Civilian("고길동", "화곡동"));
	      Set <String> ckey = person.keySet();
	      for (String c:ckey) {
	         System.out.println("주민번호 : "+c);
	         Civilian c2 = person.get(c);
	         System.out.println("이름 : "+c2.getName());
	         System.out.println("주소 : "+c2.getHome()+"\n");
	      }
	}
	}
	   class Civilian{
		      String name;
		      String home;
		      public Civilian(String name, String home) {
		         this.name = name;
		         this.home = home;
		      }
		      public String getName() {
		         return name;
		      }
		      public String getHome() {
		         return home;
		      }
	   }
== 평가대비(자바) 객관식 문제 ==
1. Collections 유형이 아닌 것은 ?
1) Map 2) List 3) Set 4) Long
정답 4 ==>Long 정수형 데이터 타입

2. List 기능 메서드 가운데, 전체 데이터의 삭제를 처리해주는 메서드는?
1) get() 2) remove() 3) clear() 4) removeAll()
정답 3 ==> get은 특정한 위치에 있는 요소를 가지고 오고
		remove는 특정한 요소를 지우는 메소드

3. 빈번한 객체 삭제와 삽입이 일어나는 곳에서는 좋은 성능 가진 List 하위 객체는?
1) ArrayList 2) Vector 3) LinkedList 4) HashMap
정답 3 ==>  인접 참조를 링크해서 체인처럼 관리하여 특정 인덱스에서 객체를 제거하거나 추가하면 앞뒤 링크만 변경
		 	빈번한 객체 삭제와 삽입이 일어나는 곳에서는 1. ArrayList보다 좋은 성능 

4. 아래의 메서드에서 Set이 지원하지 않는 메서드를 선택하세요.
1) add(E) 2) contains(E) 3) clear() 4) remove(index)
정답 4 ==> remove (Object key) 

5. 아래 기술된 내용 중, Map과 관련성이 먼 내용을 선택하세요.
1) 키(key)와 값(value)으로 구성된 Map.Entry 객체를 저장하는 구조
2) 순서를 유지하여 저장이 가능하다.
3) 키와 값은 모두 객체
4) 키는 중복될 수 없지만 값은 중복 저장 가능
정답 2 ==> Map은 순서 유지X list는 순서를 유지하며 지정 Set도 순서 유지X

정답 : 4,3,3,4,2

== 평가대비(알고리즘) 객관식 문제 ==
1. ArrayList<Integer>로 데이터를 1~100까지 임의로 할당 후, 가장 적은 데이터를 가져오는 로직 중,
   잘못된 line은 무엇인가?
   ArrayList<Integer> points = new ArrayList<Integer>();
1) points.add(new Integer(70));
2) points.add(90);
   points.add(new Integer("80"));
3) int minPoint = 100;
   for(int num01:points){
4)   if(minPoint < num01){
       minPoint=num01;
   }
   }
   System.out.println("최소값:"+minPoint);

정답 4
==>데이터가 1~100 사이인데 minPoint =100인 상황에서는
minPoint<num01가 아니라 minPoint>=num01로 해야 
위에 있는 90-80-70으로 최소값이 나온다. 
		 */
		
		 
		   
		ArrayList<Integer> points = new ArrayList<Integer>();
	   	points.add(new Integer(70));
		points.add(90);
		points.add(new Integer("80"));
		int minPoint = 100;//배열에서 최소값을 도출할때는 나올 수 있는 최대값을
		int maxPoint = 0;
		 //초기값을 설정하고
		for(int num01:points){
			  System.out.println("최솟값-"+num01+":"+minPoint);
			  System.out.println("최댓값-"+num01+":"+maxPoint);
			 //초기 최소값보다 적은 값이 나올떄 최소값으로 설정
			  if(minPoint > num01){
				 minPoint=num01;
		   }
			  if(num01 > maxPoint ) {//나온값이 현재 설정된 최대값보다 많을때
				  maxPoint=num01;
				  
			  }
		   }
		   System.out.println("최소값:"+minPoint);
		   System.out.println("최댓값:"+maxPoint);
		
	/*3번
	Player 클래스 선언 
	add(new Player())
	set(index, new Player())
	remove(index)
	*//*
		List<Player> plist = new ArrayList<Player>();
		//객체 등록 
		//기본 제일 뒤에
		plist.add(new Player("LG","김길동",0.342));
		plist.add(new Player("SK","신길동",0.292));
		plist.add(new Player("삼성","마길동",0.321));
		System.out.println("크기:"+plist.size());
		//3번째 위치에 할당(0부터 index)
		plist.add(2,new Player("삼성","김철수",0.341));
		//객체 수정
		plist.set(1,new Player("KT","오길동",0.285));
		//객체 삭제
		plist.remove(0);
		for(Player p : plist) {
			System.out.println(p.getName()+":"+p.getTname()+":"+p.getRecord());
		}
	/*
	 4번
	 1. Card 클래스 shape, no
	 2. 2중 for문을 이용해서 Card 생성
	 	모양 배열 선언
	 	번호 ArrayList 선언
	 	for(){}모양
	 		for(){} 번호
	 			cardList.add(new Card(모양,번호));
	 3. 임의의 카드 7장 추출	
	  	Random r = new Random();
	  	ArrayList<Card> team01 = new ArrayList<Card>();
	  	for(1~7)
	  		int rIdx = (int)(Math.random(52);//0~51임의값 추출
	 	 	team01.add(cardList.ger(rIdx));
	 	 */ /*
		String[] shapes = {"♥","♣","♠","◆"};
		ArrayList<String>nums = new ArrayList<String>();
		nums.add("A");
		for(int cnt =2;cnt<=10;cnt++) 
			nums.add(""+cnt);//자동형변환
		//	nums.add(Integer.valueOf(cnt).toString());
		nums.add("J");nums.add("Q");nums.add("K");
		List<Card> cardList = new ArrayList<Card>();
		int idx =1;
		for(String shape :shapes) { //모양반복
			for(String num : nums) {//번호반복
				cardList.add(new Card(shape,num));
			}
		}
		int cnt = 1;
		for (Card c: cardList) {
			System.out.println(cnt+++":"+c.getShape()+c.getNo());
		//7개 카드 추출
		List<Card> team01 = new ArrayList<Card>();
		List<Card> team02 = new ArrayList<Card>();
		Random r = new Random();
		for(cnt=1;cnt<=7;cnt++) {
			int rIdx = r.nextInt(42);
			team02.add(cardList.get(rIdx));
		}
		System.out.println("#1번째 팀카드#");
		for(Card d:team01) System.out.print(d.getShape()+d.getNo());
		System.out.println();
		System.out.println("#2번째 팀카드#");
		for(Card d:team02) System.out.print(d.getShape()+d.getNo()+" ");
		System.out.println();
		//로직에 의해 중복을 배제 1
		//기능 객체에 의해 섞어주는 처리
		Collections.shuffle(cardList);//52객체를 
		cnt=1;
		System.out.println("#1번팀#");
		for(int idx=0;idx<7;idx++) { //1~7
			Card d= cardList.get(idx);
			System.out.println(d.getShape()+d.getNo()+"");
		}
		System.out.println();
		System.out.println("#2번팀#");
		for(int idx=7;idx<14;idx++) {//8~14
			Card d= cardList.get(idx);
			System.out.println(d.getShape()+d.getNo()+"");
		}		
			}		
		}
		
		/*for(Card d:cardList) {
			if(cnt<=7) {
				System.out.print(d.getShape()+d.getNo()+" ");
				if(cnt==7) System.out.println();
			}
			if (cnt>=7 && cnt<=14) {
				System.out.print(d.getShape()+d.getNo()+" ");
			}
			cnt++;
		}
		}*/
		/*5번
		1. 선수등록 plist.add(new Player())
		2. Scanner 생성
			이름: ==> schName
			성적: ==>schRecord 형변환 처리 Double.parseDouble()
			둘 중에 하나만 맞으면 검색 (or)
		3. 
			List<Player> schRList = new ArrayList<Player>();
			for(Plater p : plist)
				if(p.getName().equals(schName){//정확한 이름이 있을때
				}
				if(p.getName().indexOf(schName)!=-1)||
						schRecord==p.getRecord()){//해당 keyword가 있으면 검색 
					schRList.add(p);
				}
		}
		4. 검색 결과 출력
			if(schRlist.size()>0){
				for(Player p : schRlist){
					p.getTname(), p.getName(), p.getRecord()
					}
			}else{
				검색된 결과가 업습니다.
			}
	
		*//*
		System.out.println(plist.size());
		plist.add(new Player("KT","이영철",0.301));
		plist.add(new Player("SK","홍현만",0.312));
		System.out.println("데이터건수:"+plist.size());
		System.out.println("#전체 list#");
		for(Player p:plist) {
			System.out.println(p.getTname()+"\t"+p.getName()+"\t"+p.getRecord());
		}
		Scanner sc = new Scanner(System.in);
		System.out.println("검색할 이름");
		String schName = sc.nextLine();
		System.out.println("검색할 성적");
		double schRecord = Double.parseDouble(sc.nextLine());
		List<Player> schRList = new ArrayList<Player>();//검색된 결과 내용
		for(Player p : plist) {
			//indexOf(): 해당 문자열이 포함되어 있으며 해당 index위치를 리턴 
			//equals(): 해당 문자열이 정확하게 있으면 ..
		//	System.out.println("이름"+p.getName()+p.getName().indexOf(schName));
			if(p.getName().indexOf(schName)!=-1 ||
					schRecord==p.getRecord()){//해당 keyword가 있으면 검색 
				schRList.add(p);
			}
	}
	System.out.println("검색 결과");
	if(schRList.size()>0){
		for(Player p : schRList){
			System.out.println(p.getTname()+"\t"+p.getName()+"\t"+p.getRecord());
			}
	}else{
		System.out.println("검색된 결과가 없습니다");
	}
*/
	}
	
}
class Card{
	private String shape;
	private String no;
	public Card(String shape, String no) {
		this.shape = shape;
		this.no = no;
	}
	public String getShape() {
		return shape;
	}
	public void setShape(String shape) {
		this.shape = shape;
	}
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	
}
class Player{
	private String tname;
	private String name;
	private double record;
	public Player(String tname, String name, double record) {
		this.tname = tname;
		this.name = name;
		this.record = record;
	}
	public String getTname() {
		return tname;
	}
	public void setTname(String tname) {
		this.tname = tname;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getRecord() {
		return record;
	}
	public void setRecord(double record) {
		this.record = record;
	}
	
	
}