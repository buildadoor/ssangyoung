package jspexp.a13_database;

public class Lecture {
	private int lecNum;
	private String lecName;
	private String lecLoc;
	private String lecYear;
	private String semester;
	private int grade;
	private String major;
	private String time;
	private String sort;
	private String id;


	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Lecture() {
		// TODO Auto-generated constructor stub
	}
	public Lecture(int lecNum, String lecYear, String semester, String lecName, String sort) {
		this.lecNum = lecNum;
		this.lecName = lecName;
		this.lecYear = lecYear;
		this.semester = semester;
		this.sort = sort;
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
	public String getLecLoc() {
		return lecLoc;
	}
	public void setLecLoc(String lecLoc) {
		this.lecLoc = lecLoc;
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
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getSort() {
		return sort;
	}
	public void setSort(String sort) {
		this.sort = sort;
	}
	
	
	
}
