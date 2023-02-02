package javaexp.a13_database.vo2;



public class EmpHw04 {

private int empno;
private String ename;
private double floor;
private double mod;
public EmpHw04() {
	super();
	// TODO Auto-generated constructor stub
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
public double getFloor() {
	return floor;
}
public void setFloor(double floor) {
	this.floor = floor;
}
public double getMod() {
	return mod;
}
public void setMod(double mod) {
	this.mod = mod;
}
public EmpHw04(int empno, String ename, double floor, double mod) {
	this.empno = empno;
	this.ename = ename;
	this.floor = floor;
	this.mod = mod;
}
}


