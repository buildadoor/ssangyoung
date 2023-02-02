package jspexp.vo;

import java.util.Date;

public class Student01 {
	private String id;
	private String stdName;
	private int stdYear;
	private int enterYear;
	private String address;
	private Date birthday;
	private String stdEmail;
	private String stdPhone;
	private String status;
	private int majorNo;
	private String majorName;
	public Student01() {
		// TODO Auto-generated constructor stub
	}
	public Student01(String address, String stdEmail, String stdPhone) {
		this.address = address;
		this.stdEmail = stdEmail;
		this.stdPhone = stdPhone;
	}
	public Student01(String id, String stdName, int stdYear, int enterYear, String address, Date birthday,
			String stdEmail, String stdPhone, String status, int majorNo, String majorName) {
		this.id = id;
		this.stdName = stdName;
		this.stdYear = stdYear;
		this.enterYear = enterYear;
		this.address = address;
		this.birthday = birthday;
		this.stdEmail = stdEmail;
		this.stdPhone = stdPhone;
		this.status = status;
		this.majorNo = majorNo;
		this.majorName = majorName;
	}
	public Student01(String address, String stdPhone,  String stdEmail, String id) {
		this.id = id;
		this.address = address;
		this.stdEmail = stdEmail;
		this.stdPhone = stdPhone;
	}
	public Student01(String id) {
		this.id = id;
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
	public int getStdYear() {
		return stdYear;
	}
	public void setStdYear(int stdYear) {
		this.stdYear = stdYear;
	}
	public int getEnterYear() {
		return enterYear;
	}
	public void setEnterYear(int enterYear) {
		this.enterYear = enterYear;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getStdEmail() {
		return stdEmail;
	}
	public void setStdEmail(String stdEmail) {
		this.stdEmail = stdEmail;
	}
	public String getStdPhone() {
		return stdPhone;
	}
	public void setStdPhone(String stdPhone) {
		this.stdPhone = stdPhone;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
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
