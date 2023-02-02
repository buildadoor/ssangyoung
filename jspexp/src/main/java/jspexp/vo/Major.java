package jspexp.vo;

public class Major {
	private int majorNo;
	private String majorName;
	public Major() {
		// TODO Auto-generated constructor stub
	}
	
	public Major(String majorName) {
		this.majorName = majorName;
	}

	public Major(int majorNo, String majorName) {
		this.majorNo = majorNo;
		this.majorName = majorName;
	}
	public int getMajorNo() {
		return majorNo;
	}
	public void setMajorNo(int majorNo) {
		this.majorNo = majorNo;
	}
	public String getMajorName() {
		return majorName;
	}
	public void setMajorName(String majorName) {
		this.majorName = majorName;
	}
	
}
