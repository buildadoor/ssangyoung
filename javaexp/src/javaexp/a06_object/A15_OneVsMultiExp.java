package javaexp.a06_object;

import java.util.ArrayList;

public class A15_OneVsMultiExp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//아이패드 캡쳐본 다시 해보기 
		
		SchClass sc = new SchClass("1~1");
		sc.addStudent(new SchStudent(1,"홍길동"));
		sc.addStudent(new SchStudent(2,"김길동"));
		sc.addStudent(new SchStudent(3,"신길동"));
		ArrayList<SchStudent> list = new ArrayList<SchStudent>
	
	}
	}
class SchClass{
	private String cname;
	private ArrayList<SchStudent> slist;
	public SchClass(String cname, ArrayList<SchStudent> slist) {
		this.cname = cname;
		this.slist = slist;
	}
	public void addStudent(SchStudent st) {
		//현재 데이터 크기에서 하나씩 증가시켜 번호로 등록
		st.setNo(slist.size()+1);
		this.slist.add(st);
		System.out.println(st.getName()+"등록!!");
	}
	pulic void addStudentAll(ArrayList<SchStudent> slist) {
		//this.slist = slist;
		for(SchStudent st:alist) {
			this.addStudent(st); //기존에 선언한 기능 메서드 활용
		}
		System.out.println(slist.size()+"명 등록!!");
	}
	public void showList() {
		System.out.println(cname+"반의 학생 리스트");
		if(slist.size()>0) {
			for(SchStudent ss:slist) {
				System.out.println(ss.getNo);
			}
		}
	}
}