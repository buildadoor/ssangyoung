package javaexp.a13_database.vo2;

import java.sql.Date;

public class EmpHw01 {
	private String ename;
	private String dname;
	private double sal;
	private int grade;
	private Date hiredate;
	public EmpHw01() {
	
		super();
		// TODO Auto-generated constructor stub
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	public double getSal() {
		return sal;
	}
	public void setSal(double sal) {
		this.sal = sal;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	public Date getHiredate() {
		return hiredate;
	}
	public void setHiredate(Date hiredate) {
		this.hiredate = hiredate;
	}
	public EmpHw01(String dname, String ename, double sal, int grade) {
		this.dname = dname;
		this.ename = ename;
		this.sal = sal;
		this.grade = grade;
	}

	}

