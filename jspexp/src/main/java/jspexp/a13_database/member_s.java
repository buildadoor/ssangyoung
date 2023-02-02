package jspexp.a13_database;


public class member_s {
	private String id;
	private String password;
	private int code;
	public member_s() {
		// TODO Auto-generated constructor stub
	}
	public member_s(String id, String password, int code) {
		this.id = id;
		this.password = password;
		this.code = code;
	}
	public member_s(String id, String password) {
		this.id = id;
		this.password = password;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	
}