package javaexp.a13_database.vo2;

import java.sql.Date;

import oracle.sql.DATE;

public class EmpHw02 {
	private DATE hiredate;
	private double sal;
	private int empno;
	public EmpHw02() {
		super();
		// TODO Auto-generated constructor stub
	}
	public EmpHw02(String hireq, int empno, double sal) {
		this.hiredate = hiredate;
		this.sal = sal;
		this.empno = empno;
	}
	
	public EmpHw02(DATE hiredate) {
		this.hiredate = hiredate;
	}
	public DATE getHiredate() {
		return hiredate;
	}
	public void setHiredate(DATE hiredate) {
		this.hiredate = hiredate;
	}
	public double getSal() {
		return sal;
	}
	public void setSal(double sal) {
		this.sal = sal;
	}
	public int getEmpno() {
		return empno;
	}
	public void setEmpno(int empno) {
		this.empno = empno;
	}
	
}
