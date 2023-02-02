package a01_diexp.z01_vo;

import java.util.List;

public class ShoppingMall {
	private String sname;
	private List<Member> mlist;
	public ShoppingMall() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ShoppingMall(String sname) {
		this.sname = sname;
	}
	public void memberList() {
		System.out.println(sname+" 회원 정보 리스트");
		if(mlist!=null && mlist.size()>0) {
			System.out.println("아이디\t패스워드\t이름\t권한\t포인트");
			for(Member m:mlist) {
				System.out.print(m.getId()+"\t");
				System.out.print(m.getPass()+"\t");
				System.out.print(m.getName()+"\t");
				System.out.print(m.getAuth()+"\t");
				System.out.print(m.getPoint()+"\n");
			}
		}else {
			System.out.println("회원정보가 없습니다");
		}
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public List<Member> getMlist() {
		return mlist;
	}
	public void setMlist(List<Member> mlist) {
		this.mlist = mlist;
	}
	
}
