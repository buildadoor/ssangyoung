package z02_project.vo;

public class Bookusers {
	private String usersno;
	private String div;
	private String uname;
	private String rrn;
	private String address;
	private String phone_number;
	private String id;
	private String password;
	private int rentalcnt;
	public Bookusers() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Bookusers(String uname) {
		this.uname = uname;
	}

	public Bookusers(String id, String password) {
		this.id = id;
		this.password = password;
	}

	public Bookusers(String usersno, String div, String uname, String rrn, String address, String phone_number,
			String id, String password, int rentalcnt) {
		this.usersno = usersno;
		this.div = div;
		this.uname = uname;
		this.rrn = rrn;
		this.address = address;
		this.phone_number = phone_number;
		this.id = id;
		this.password = password;
		this.rentalcnt = rentalcnt;
	}
	public Bookusers(String div, String uname, String rrn, String address, String phone_number, String id,
			String password, int rentalcnt) {
		this.div = div;
		this.uname = uname;
		this.rrn = rrn;
		this.address = address;
		this.phone_number = phone_number;
		this.id = id;
		this.password = password;
		this.rentalcnt = rentalcnt;
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
	public String getPhone_number() {
		return phone_number;
	}
	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
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
	public int getRentalcnt() {
		return rentalcnt;
	}
	public void setRentalcnt(int rentalcnt) {
		this.rentalcnt = rentalcnt;
	}
	
}

