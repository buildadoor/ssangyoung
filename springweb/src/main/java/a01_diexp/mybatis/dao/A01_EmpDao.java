package a01_diexp.mybatis.dao;

import java.util.List;

import springweb.z01_vo.Dept;
import springweb.z01_vo.Emp;
import springweb.z01_vo.EmpDept;
import springweb.z01_vo.EmpGrade;

public interface A01_EmpDao {
   public List<Emp> getEmpList(Emp sch);
   //단일 리턴값
   public int empCount();
   public double empMaxSal();
   public String getEname();
   public double getMaxSalByDept();
   public int getMaxMgr();
   public String getJboByEname();
   //객체형 리턴값
   public Emp getEmpByEmpno();
   public Emp getEmpByEname();
   //과제   
		public int hw01();
		public String hw02();
		public double hw03();
		public int hw04();
		public int hw05();
		public String hw06();
		public String hw07();
		public String hw08();
		public String hw09();
		public String hw10();
		public Dept getDeptByDeptno();
		public Emp getInitHire();
		public Emp getMaxSalByTerms();
	//다중행객체 리턴값
	public List<EmpDept> getEmpDeptList();
	public List<EmpGrade> getEmpSalGrade();
}