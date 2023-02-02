package jspexp.vo;


public class Grade {
	private int lecNum;
	private String lecName;
	private String sort;
	private int grade;
	private int midtest;
	private int endtest;
	private int attendance;
	private String total;
	private String lecYear;
	private String semester;
	public Grade() {
		// TODO Auto-generated constructor stub
	}
	public Grade(int lecNum, String lecName, String sort, int grade, int midtest, int endtest, int attendance,
			String total, String lecYear, String semester) {
		this.lecNum = lecNum;
		this.lecName = lecName;
		this.sort = sort;
		this.grade = grade;
		this.midtest = midtest;
		this.endtest = endtest;
		this.attendance = attendance;
		this.total = total;
		this.lecYear = lecYear;
		this.semester = semester;
	}
	public Grade(int lecNum, String lecName, String sort, int grade, int midtest, int endtest, int attendance,
			String total) {
		this.lecNum = lecNum;
		this.lecName = lecName;
		this.sort = sort;
		this.grade = grade;
		this.midtest = midtest;
		this.endtest = endtest;
		this.attendance = attendance;
		this.total = total;
	}
	public int getLecNum() {
		return lecNum;
	}
	public void setLecNum(int lecNum) {
		this.lecNum = lecNum;
	}
	public String getLecName() {
		return lecName;
	}
	public void setLecName(String lecName) {
		this.lecName = lecName;
	}
	public String getSort() {
		return sort;
	}
	public void setSort(String sort) {
		this.sort = sort;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	public int getMidtest() {
		return midtest;
	}
	public void setMidtest(int midtest) {
		this.midtest = midtest;
	}
	public int getEndtest() {
		return endtest;
	}
	public void setEndtest(int endtest) {
		this.endtest = endtest;
	}
	public int getAttendance() {
		return attendance;
	}
	public void setAttendance(int attendance) {
		this.attendance = attendance;
	}
	public String getTotal() {
		return total;
	}
	public void setTotal(String total) {
		this.total = total;
	}
	public String getLecYear() {
		return lecYear;
	}
	public void setLecYear(String lecYear) {
		this.lecYear = lecYear;
	}
	public String getSemester() {
		return semester;
	}
	public void setSemester(String semester) {
		this.semester = semester;
	}
	
}