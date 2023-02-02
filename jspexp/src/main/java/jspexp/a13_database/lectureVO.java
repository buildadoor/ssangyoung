package jspexp.a13_database;

public class lectureVO {
	private int lecNum;
	private String lecName;
	private String lecLoc;
	private String lecPlan;
	private String lecYear;
	private String semester;
	private int grade;
	private String times;
	private String sort;
	private int class_I;
	private String id;
	private int majorNo;
	
	
	public lectureVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public void setClass_I(int class_I) {
		this.class_I = class_I;
	}
	public lectureVO(int lecNum, String lecName, String lecLoc, String lecPlan, String lecYear, String semester,
			int grade, String times, String sort, int class_I, String id, int majorNo) {
		this.lecNum = lecNum;
		this.lecName = lecName;
		this.lecLoc = lecLoc;
		this.lecPlan = lecPlan;
		this.lecYear = lecYear;
		this.semester = semester;
		this.grade = grade;
		this.times = times;
		this.sort = sort;
		this.class_I = class_I;
		this.id = id;
		this.majorNo = majorNo;
	}


	public lectureVO(int lecNum, String lecName, String lecLoc, String lecYear, String semester, int grade, int majorNo,
			String times, String sort) {
		this.lecNum = lecNum;
		this.lecName = lecName;
		this.lecLoc = lecLoc;
		this.lecYear = lecYear;
		this.semester = semester;
		this.grade = grade;
		this.majorNo = majorNo;
		this.times = times;
		this.sort = sort;
		this.class_I=class_I;
	}

	public lectureVO(int lecNum, String lecName, String lecLoc, String lecYear, String semester, int grade, int majorNo,
			String times, String sort, String id, int class_I) {
		this.lecNum = lecNum;
		this.lecName = lecName;
		this.lecLoc = lecLoc;
		this.lecYear = lecYear;
		this.semester = semester;
		this.grade = grade;
		this.majorNo = majorNo;
		this.times = times;
		this.sort = sort;
		this.id = id;
		this.class_I = class_I;
	}

	public lectureVO(int lecNum, String lecName, String lecLoc, String lecYear, String semester, int grade, int majorNo,
			String times, String sort, int class_I) {
		this.lecNum = lecNum;
		this.lecName = lecName;
		this.lecLoc = lecLoc;
		this.lecYear = lecYear;
		this.semester = semester;
		this.grade = grade;
		this.majorNo = majorNo;
		this.times = times;
		this.sort = sort;
		this.class_I = class_I;
	}
	
	public lectureVO(int lecNum, String lecName) {
		this.lecNum = lecNum;
		this.lecName = lecName;
	}

	public lectureVO(String lecName, String lecPlan) {
		this.lecName = lecName;
		this.lecPlan = lecPlan;
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

	public String getLecPlan() {
		return lecPlan;
	}

	public void setLecPlan(String lecPlan) {
		this.lecPlan = lecPlan;
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

	public int getMajorNo() {
		return majorNo;
	}

	public void setMajorNo(int majorNo) {
		this.majorNo = majorNo;
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

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getClass_I() {
		return class_I;
	}

	public void seClass_I(int class_I) {
		this.class_I = class_I;
	}
	
}


