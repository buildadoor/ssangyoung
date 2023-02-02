package jspexp.a13_database;

public class User {
	private String usersno;
	private String div;
	private String uname;
	private String rrn;
	private String address;
	private String phonenumber;
	private String id;
	private String password;
	private int point;
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public User(String uname) {
		this.uname = uname;
	}

	public void User(String rrn, String id) {
		this.rrn = rrn;
		this.id = id;
	}

	public User(String id, String password) {
		this.id = id;
		this.password = password;
	}

	public User(String usersno, String div, String uname, String rrn, String address, String phonenumber,
			String id, String password, int point) {
		this.usersno = usersno;
		this.div = div;
		this.uname = uname;
		this.rrn = rrn;
		this.address = address;
		this.phonenumber = phonenumber;
		this.id = id;
		this.password = password;
		this.point = point;
	}
	public User(String div, String uname, String rrn, String address, String phonenumber, String id,
			String password, int point) {
		this.div = div;
		this.uname = uname;
		this.rrn = rrn;
		this.address = address;
		this.phonenumber = phonenumber;
		this.id = id;
		this.password = password;
		this.point = point;
	}
	
	public User(String div, String uname, String rrn, String address, String phonenumber, String id, String password) {
		this.div = div;
		this.uname = uname;
		this.rrn = rrn;
		this.address = address;
		this.phonenumber = phonenumber;
		this.id = id;
		this.password = password;
	}

	public String getUsersno() {
		return usersno;
	}
	public void setUsersno(String usersno) {
		this.usersno = usersno;
	}
	public String getDiv() {
		return div;
	}
	public void setDiv(String div) {
		this.div = div;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getRrn() {
		return rrn;
	}
	public void setRrn(String rrn) {
		this.rrn = rrn;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhonenumber() {
		return phonenumber;
	}
	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
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
	public int getPoint() {
		return point;
	}
	public void setpoint(int point) {
		this.point = point;
	}
	
}

