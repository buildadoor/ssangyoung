package jspexp.a13_database;


public class StdLecture {
	private int lecNum;
	private String id;
	private int attendance;
	private int midtest;
	private int endtest;
	private String total;
	private String lecEval;

	
	public StdLecture() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
	public StdLecture(int lecNum) {
		this.lecNum = lecNum;
	}




	public StdLecture(int lecNum, String id, int attendance, int midtest, int endtest, String total, String lecEval) {
		this.lecNum = lecNum;
		this.id = id;
		this.attendance = attendance;
		this.midtest = midtest;
		this.endtest = endtest;
		this.total = total;
		this.lecEval = lecEval;
		
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
	public String getLecEval() {
		return lecEval;
	}
	public void setLecEval(String lecEval) {
		this.lecEval = lecEval;
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
	
	
}
