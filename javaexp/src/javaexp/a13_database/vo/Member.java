package javaexp.a13_database.vo;

import java.sql.Date;

public class Member {
	private String id;
	private int password;
	private String name;
	private String authority;
	private int point;
	private Date register;
	public Member() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Member(String id, int password, String name, String authority, int point, Date register) {
		this.id = id;
		this.password = password;
		this.name = name;
		this.authority = authority;
		this.point = point;
		this.register = register;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getPassword() {
		return password;
	}
	public void setPassword(int password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAuthority() {
		return authority;
	}
	public void setAuthority(String authority) {
		this.authority = authority;
	}
	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point = point;
	}
	public Date getRegister() {
		return register;
	}
	public void setRegister(Date register) {
		this.register = register;
	}
	
}
