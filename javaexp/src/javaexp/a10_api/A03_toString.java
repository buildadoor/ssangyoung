package javaexp.a10_api;

class Food{
	// 재정의 
	public String toString() {
		return "toString(): 참조변수만 호출";
	}
}


public class A03_toString {

	public static void main(String[] args) {
		Food f = new Food();
		System.out.println(f);
		// TODO Auto-generated method stub
/*
# toString()
1. 클래스의 패키지와 클래스명 + 16진수 주소를 리턴
2. 참조변수만 호출 했을때 나타나는 데이터와 동일하다.
3. toString()을 재정의하면 참조변수도 동일한 값으로 
 	변경이 된다.
 */
	Player p01 = new Player("홍길동",0.342);
	Player p02 = new Player("홍길동",0.342);
	Player p03 = new Player("김길동",0.342);
	System.out.println(p01);
	System.out.println(p01.toString());
	System.out.println(p02);
	System.out.println(p03);
	System.out.println(p01==p02);
	System.out.println(p01==p03);
	System.out.println(p01.equals(p02));
	System.out.println(p01.equals(p03));
	//ex) Music에 음악명 가수명을 속성으로 선언하고 toString()을 통해
	//재정의하여 참조값으로 확인되게 하세요. 
	Music m01 = new Music("Home","박효신");
	Music m02 = new Music("Home","박효신");
	Music m03 = new Music("GoodBye","박효신");
	System.out.println(m01);
	System.out.println(m02);
	System.out.println(m03);
	System.out.println(m01.toString());
	System.out.println(m01==m02);
	System.out.println(m01==m03);
	System.out.println(m01.equals(m02));
	System.out.println(m01.equals(m03));
	}

}
class Music{
	private String song;
	private String singer;
	public Music(String song, String singer) {
		this.song = song;
		this.singer = singer;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.singer+":"+this.song;
	}
	
}
class Player{
	private String name;
	private double record; 
	
	public Player(String name, double record) {
		this.name = name;
		this.record = record;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.name+":"+this.record;
	}
	
	
}
