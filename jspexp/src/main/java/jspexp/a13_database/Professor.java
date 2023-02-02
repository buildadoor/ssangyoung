package jspexp.a13_database;


public class Professor {
	private String id;
	private int majorNo;
	private String proName;
	private String proEmail;
	private String proPhone;
	
	public Professor(String id, int majorNo, String proName,  String proEmail, String proPhone) {
		this.id = id;
		this.majorNo = majorNo;
		this.proName = proName;
		this.proEmail = proEmail;
		this.proPhone = proPhone;
	}



	public Professor() {
		// TODO Auto-generated constructor stub
	}



	public Professor(String id) {
		this.id = id;
	}



	public String getId() {
		return id;
	}



	public void setId(String id) {
		this.id = id;
	}



	public String getProName() {
		return proName;
	}



	public void setProName(String proName) {
		this.proName = proName;
	}



	public int getMajorNo() {
		return majorNo;
	}



	public void setMajorNo(int majorNo) {
		this.majorNo = majorNo;
	}



	public String getProEmail() {
		return proEmail;
	}



	public void setProEmail(String proEmail) {
		this.proEmail = proEmail;
	}



	public String getProPhone() {
		return proPhone;
	}



	public void setProPhone(String proPhone) {
		this.proPhone = proPhone;
	}

	
	
	
}
