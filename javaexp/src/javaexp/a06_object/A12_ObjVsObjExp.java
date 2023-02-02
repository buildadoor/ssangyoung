package javaexp.a06_object;

public class A12_ObjVsObjExp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	//ex1) 1:1 관계 연습 Student(이름,ElementSch) ElementSch(학교명, 졸업연도)
	//	1) ElementSch - 필드와 기본 정보 출력
	// 2) Student - 이름, ElementSch,
		// 생성자, ElementSch 추가메서드, 출력메서드
		Student st01 = new Student("이철수");
		st01.showInfo();
		System.out.println(st01);
		st01.setElementSch(new ElementSch("홍대부속초등학교",2008));
		
	}
	}
class ElementSch{
	private String sname;
	private int gradYear;
	public ElementSch(String sname, int gradYear) {
		this.sname = sname;
		this.gradYear = gradYear;
	}
	}
	
class Student {
	private String name;
	private ElementSch elementSch;
	public Student(String name) {
		this.name = name;
	}
	public void setElementSch(ElementSch elementSch2) {
		// TODO Auto-generated method stub
		
	}
	public void showInfo() {
		// TODO Auto-generated method stub
		
	}
	
}
}