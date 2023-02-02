package jspexp.vo;

public class SalGrade {
private int grade;
private int lowsal;
private int hisal;
public SalGrade() {
}
public SalGrade(int grade, int lowsal, int hisal) {
	this.grade = grade;
	this.lowsal = lowsal;
	this.hisal = hisal;
}
public SalGrade(int grade) {
	this.grade = grade;
}
public SalGrade(int lowsal, int hisal) {
	this.lowsal = lowsal;
	this.hisal = hisal;
}
public int getGrade() {
	return grade;
}
public void setGrade(int grade) {
	this.grade = grade;
}
public int getLowsal() {
	return lowsal;
}
public void setLowsal(int lowsal) {
	this.lowsal = lowsal;
}
public int getHisal() {
	return hisal;
}
public void setHisal(int hisal) {
	this.hisal = hisal;
}



}
