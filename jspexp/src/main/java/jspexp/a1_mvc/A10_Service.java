package jspexp.a1_mvc;

import java.util.List;

import jspexp.a13_database.A06_PreparedDao;
import jspexp.vo.Dept;

public class A10_Service {
	private A06_PreparedDao dao;
	public A10_Service() {
		dao = new A06_PreparedDao();
	}
	
	public List<Dept> getDeptList(Dept sch){
		if(sch.getDeptno()==0) sch.setDeptno(10);
		if(sch.getDname()==null) sch.setDname("");
		if(sch.getLoc()==null) sch.setLoc("");
		return dao.getDeptList(sch);
	}
}