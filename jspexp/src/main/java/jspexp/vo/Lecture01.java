package jspexp.vo;

public class Lecture01 {
/*
 lecNum NUMBER PRIMARY KEY,
   lecName varchar2(30),
   lecLoc varchar2(30),
   lecPlan varchar2(500),
   lecYear NUMBER,
   semester NUMBER,
   grade NUMBER,
   major varchar2(30),
   times varchar2(20),
   sort varchar2(20),
   class NUMBER, --학년
 */
	private int lecNum;
	private String lecName;
	private String lecLoc;
	private String lecPlan;
	private int lecYear;
	private int semester; //학기
	private int grade; // 학점
	private String major; // 학과
	private String times;
	private String sort; // 전공유무
	private int class_I; // 학년
	private String majorName;
	private String id;
	private String day;//시간표 요일
	private int t01; //시간표 시간1
	private int t02; //시간표 시간2
	private String lecEval;
	
	
	
	public Lecture01(int lecNum, String lecName, int grade, String sort,String lecEval, String id) {
		this.lecNum = lecNum;
		this.lecName = lecName;
		this.grade = grade;
		this.sort = sort;
		this.id = id;
		this.lecEval = lecEval;
	}


	public String getLecEval() {
		return lecEval;
	}


	public void setLecEval(String lecEval) {
		this.lecEval = lecEval;
	}


	public Lecture01(int lecNum, String lecName, String lecLoc,String times, int grade,String lecPlan) {
		this.lecNum = lecNum;
		this.lecName = lecName;
		this.lecLoc = lecLoc;
		this.lecPlan = lecPlan;
		this.grade = grade;
		this.times = times;
	}


	public String getDay() {
		return day;
	}


	public void setDay(String day) {
		this.day = day;
	}


	public int getT01() {
		return t01;
	}


	public void setT01(int t01) {
		this.t01 = t01;
	}


	public int getT02() {
		return t02;
	}


	public void setT02(int t02) {
		this.t02 = t02;
	}


	public Lecture01(String day, int t01, int t02) {
		this.day = day;
		this.t01 = t01;
		this.t02 = t02;
	}


	public Lecture01(String lecName, String lecLoc, String times, String day, int t01, int t02) {
		this.lecName = lecName;
		this.lecLoc = lecLoc;
		this.times = times;
		this.day = day;
		this.t01 = t01;
		this.t02 = t02;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}




	public String getMajorName() {
		return majorName;
	}
	

	public Lecture01(int lecNum) {
		this.lecNum = lecNum;
	}


	public Lecture01(int class_I, String majorName) {
		this.class_I = class_I;
		this.majorName = majorName;
	}

	public Lecture01(String majorName) {
		this.majorName = majorName;
	}

	public void setMajorName(String majorName) {
		this.majorName = majorName;
	}

	//lecNum,major,class,sort,lecName,lecLoc,times,grade
	public Lecture01() {
		// TODO Auto-generated constructor stub
	}
	
	public Lecture01(String sort,int lecNum) {
		this.lecNum = lecNum;
		this.sort = sort;
	}

	public Lecture01(String sort,String lecName) {
		this.lecName = lecName;
		this.sort = sort;
	}

	public Lecture01(int lecNum,String majorName,int class_I,String sort, String lecName,String lecLoc,String times, int grade) {
		this.lecNum = lecNum;
		this.lecName = lecName;
		this.lecLoc = lecLoc;
		this.grade = grade;
		this.majorName = majorName;
		this.times = times;
		this.sort = sort;
		this.class_I = class_I;
	}
	public Lecture01(int lecNum, String lecLoc, String lecPlan, int lecYear, int semester, int grade, String majorName,
			String times, String sort, int class_I) {
		this.lecNum = lecNum;
		this.lecLoc = lecLoc;
		this.lecPlan = lecPlan;
		this.lecYear = lecYear;
		this.semester = semester;
		this.grade = grade;
		this.majorName = majorName;
		this.times = times;
		this.sort = sort;
		this.class_I = class_I;
	}
	public String getLecName() {
		return lecName;
	}
	public void setLecName(String lecName) {
		this.lecName = lecName;
	}
	public int getLecNum() {
		return lecNum;
	}
	public void setLecNum(int lecNum) {
		this.lecNum = lecNum;
	}
	public String getLecLoc() {
		return lecLoc;
	}
	public void setLecLoc(String lecLoc) {
		this.lecLoc = lecLoc;
	}
	public String getLecPlan() {
		return lecPlan;
	}
	public void setLecPlan(String lecPlan) {
		this.lecPlan = lecPlan;
	}
	public int getLecYear() {
		return lecYear;
	}
	public void setLecYear(int lecYear) {
		this.lecYear = lecYear;
	}
	public int getSemester() {
		return semester;
	}
	public void setSemester(int semester) {
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
	public String getTimes() {
		return times;
	}
	public void setTimes(String times) {
		this.times = times;
	}
	public String getSort() {
		return sort;
	}
	public void setSort(String sort) {
		this.sort = sort;
	}
	public int getclass_I() {
		return class_I;
	}
	public void setclass_I(int class_I) {
		this.class_I = class_I;
	}
	
}
