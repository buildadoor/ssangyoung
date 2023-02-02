package jspexp.a13_database;

public class stdLectureVO {
	private int lecNum;
	private String id;
	private int attendance;
	private String midtest;
	private String endtest;
	private int total;
	private String lecEval;
	public stdLectureVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public stdLectureVO(int lecNum, String id, int attendance, String midtest, String endtest, int total,
			String lecEval) {
		this.lecNum = lecNum;
		this.id = id;
		this.attendance = attendance;
		this.midtest = midtest;
		this.endtest = endtest;
		this.total = total;
		this.lecEval = lecEval;
	}
	public stdLectureVO(int lecNum, String id, int attendance) {
		this.lecNum = lecNum;
		this.id = id;
		this.attendance = attendance;
	}
	
	public stdLectureVO(String id) {
		this.id = id;
	}
	public int getLecNum() {
		return lecNum;
	}
	public void setLecNum(int lecNum) {
		this.lecNum = lecNum;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getAttendance() {
		return attendance;
	}
	public void setAttendance(int attendance) {
		this.attendance = attendance;
	}
	public String getMidtest() {
		return midtest;
	}
	public void setMidtest(String midtest) {
		this.midtest = midtest;
	}
	public String getEndtest() {
		return endtest;
	}
	public void setEndtest(String endtest) {
		this.endtest = endtest;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public String getLecEval() {
		return lecEval;
	}
	public void setLecEval(String lecEval) {
		this.lecEval = lecEval;
	}
	
}
