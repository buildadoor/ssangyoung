package jspexp.a13_database;
public class Student {
	private String id;
	private String stdName;
	private String majorName;
	private int stdYear;
	private int lecNum;
	private int attendance;
	private int midtest;
	private int endtest;
	private String total;



	public Student() {
		// TODO Auto-generated constructor stub
	}
	
	
	public Student(String id) {
		this.id = id;
	}

	



	public Student(String id, int lecNum) {
		this.id = id;
		this.lecNum = lecNum;
	}


	public Student(String id, String stdName, String majorName, int stdYear) {
		this.id = id;
		this.stdName = stdName;
		this.majorName = majorName;
		this.stdYear = stdYear;
	}

	// 값이 있는지 없는지 check
	public Student(int attendance, int midtest, int endtest, String total) {
		this.attendance = attendance;
		this.midtest = midtest;
		this.endtest = endtest;
		this.total = total;
	}


	// 성적 입력
	public Student(int lecNum, String id, int attendance, int midtest, int endtest, String total) {
		this.lecNum = lecNum;
		this.id = id;
		this.attendance = attendance;
		this.midtest = midtest;
		this.endtest = endtest;
		this.total = total;
	}
	
	

	public Student(String id, String stdName, String majorName) {
		this.id = id;
		this.stdName = stdName;
		this.majorName = majorName;
	}


	public Student(String id, String stdName, String majorName, int attendance, int midtest, int endtest,
			String total) {
		this.id = id;
		this.stdName = stdName;
		this.majorName = majorName;
		this.attendance = attendance;
		this.midtest = midtest;
		this.endtest = endtest;
		this.total = total;
	}
	

	public Student(int attendance, int midtest, int endtest, String total, String id, int lecNum) {
		this.id = id;
		this.attendance = attendance;
		this.midtest = midtest;
		this.endtest = endtest;
		this.total = total;
		this.lecNum = lecNum;
	}


	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getStdName() {
		return stdName;
	}
	public void setStdName(String stdName) {
		this.stdName = stdName;
	}
	public String getMajorName() {
		return majorName;
	}
	public void setMajorName(String majorName) {
		this.majorName = majorName;
	}
	public int getStdYear() {
		return stdYear;
	}
	public void setStdYear(int stdYear) {
		this.stdYear = stdYear;
	}
	
	public int getLecNum() {
		return lecNum;
	}


	public void setLecNum(int lecNum) {
		this.lecNum = lecNum;
	}
	
	public int getAttendance() {
		return attendance;
	}


	public void setAttendance(int attendance) {
		this.attendance = attendance;
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


	public String getTotal() {
		return total;
	}


	public void setTotal(String total) {
		this.total = total;
	}
	
	
}
