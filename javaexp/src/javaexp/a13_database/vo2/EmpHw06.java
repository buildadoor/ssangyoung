package javaexp.a13_database.vo2;

public class EmpHw06 {
	private String mname;
	private String ename;
	private int deptno;
	private double sal;
	public EmpHw06() {
		super();
		// TODO Auto-generated constructor stub
	}
	public EmpHw06(String mname, String ename, int deptno, double sal) {
		this.mname = mname;
		this.ename = ename;
		this.deptno = deptno;
		this.sal = sal;
	}
	public String getMname() {
		return mname;
	}
	public void setMname(String mname) {
		this.mname = mname;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public int getDeptno() {
		return deptno;
	}
	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}
	public double getSal() {
		return sal;
	}
	public void setSal(double sal) {
		this.sal = sal;
	}

	
	}