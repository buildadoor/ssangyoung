package javaexp.a13_database.vo2;

import oracle.sql.DATE;

public class EmpHw05 {
	private int empno;
	private String ename;
	private double sal;
	public EmpHw05() {
		super();
		// TODO Auto-generated constructor stub
	}
	public EmpHw05(int empno, String ename, double sal) {
		this.empno = empno;
		this.ename = ename;
		this.sal = sal;
	}
	public int getEmpno() {
		return empno;
	}
	public void setEmpno(int empno) {
		this.empno = empno;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public double getSal() {
		return sal;
	}
	public void setSal(double sal) {
		this.sal = sal;
	}
	
}
