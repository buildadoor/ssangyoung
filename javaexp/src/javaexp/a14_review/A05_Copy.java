package javaexp.a14_review;

import java.util.ArrayList;
import java.util.List;

public class A05_Copy {

	public static void main(String[] args) {
//	      List<ComPart> cp = new ArrayList<ComPart>();
//	      cp.add(new Cpu("i7 3.2Ghz"));
//	      cp.add(new Ram("16G"));
//	      cp.add(new Ssd("1TB"));
//	      for(ComPart p: cp) {
//	         p.partFun();
//	      }

		Computer com = new Computer("조립컴퓨터");
		com.addPart(new Cpu("i7 3.2Ghz"));
		com.addPart(new Ram("16G"));
		com.addPart(new Ssd("1TB"));
		com.addPart(new GraphCard("1TB"));
		com.showComInfo();
	}

}
/*
 * #추상클래스를 상속받은 하위클래스의 내용을 다형성으로 처리하여, 1:다 관계를 처리하는 경우 1. 예제 컴퓨터의 여러가지 부품을
 * Part라는 추상클래스를 상속받은 하위 실제 클래스로 생성하여 다양한 형태를 실제객체를 할당 할 수 있는 구조로 처리하는 1:다 구조를
 * 말한다. 2. 처리순서 1) 추상클래스 선언 2) 상속받은 하위클래스 선언 3) 위 내용을 포함하는 1:다 형태의 클래스 선언 -필드선언
 * -생성자 선언 -기능 메서드 선언 하나씩 담기 리스트 처리하기
 */

abstract class ComPart {
	private String kind;
	private String perFrm;

	public ComPart(String kind, String perFrm) {
		this.kind = kind;
		this.perFrm = perFrm;
	}

	public String getKind() {
		return kind;
	}

	public abstract void partFun();

	// public abstract void partFun2(String perFrm2);
	public String getPerFrm() {
		return perFrm;
	}

}

class Cpu extends ComPart {
	public Cpu(String perFrm) {
		super("CPU", perFrm);
	}
	public void partFun() {
		System.out.println(getKind() + " " + getPerFrm() + " 성능을 가지고있다.");
		System.out.println("주로 중앙 처리를 해주는 부품이다.");
	}

}
class Ram extends ComPart {

	public Ram(String perFrm) {
		super("Ram", perFrm);
	}
	public void partFun() {
		System.out.println(getKind() + "는 " + getPerFrm() + " 성능을 가지고있다.");
		System.out.println("일시적 처리 장치");

	}
}
class Ssd extends ComPart {

	public Ssd(String perFrm) {
		super("Ssd", perFrm);
	}
	public void partFun() {
		System.out.println(getKind() + "는 " + getPerFrm() + " 성능을 가지고있다.");
		System.out.println("저장장치");

	}

}
class GraphCard extends ComPart {

	public GraphCard(String perFrm) {
		super("그래픽 카드", perFrm);
		// TODO Auto-generated constructor stub
	}

	public void partFun() {
		System.out.println(getKind() + "는 " + getPerFrm() + "성능을 가진다.");
		System.out.println("메모리와 버스 속도에따라 컴퓨터 그래픽을 효과적으로 처리한다.");
	}

}

class Computer {
	private String company;
	private List<ComPart> cp;

	public Computer(String company) {
		this.company = company;
		cp = new ArrayList<ComPart>();
	}

	// 부품을 하나씩 추가/장착할 수 있는 기능 메서드
	public void addPart(ComPart part) {
		System.out.println(part.getKind() + "부품을 장착합니다.");
		cp.add(part);
	}

	public void showComInfo() {
		System.out.println(company + " 제조 컴퓨터!");
		if (cp.size() > 0) {
			System.out.println("장착된 부품 리스트");
			for (ComPart p : cp) {
				p.partFun();
			}
		} else {
			System.out.println("장착된 부품이 없습니다.");
		}

	}
}
