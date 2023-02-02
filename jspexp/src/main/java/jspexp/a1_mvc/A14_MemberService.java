package jspexp.a1_mvc;

import jspexp.a13_database.A06_PreparedDao;

public class A14_MemberService {
	private A06_PreparedDao dao;
	public A14_MemberService() {
		dao = new A06_PreparedDao();
	}
		public String checkIdJson(String id){
			//boolean ==> 문자열로 형변환
			return ""+dao.checkId(id);
		
		}
}
