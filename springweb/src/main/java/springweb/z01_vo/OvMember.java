package springweb.z01_vo;

public class OvMember {
	private String id;
	private String pass;
	private String auth;
	private String nickname;
	private String address;
	private int point;
	public OvMember() {
		super();
		// TODO Auto-generated constructor stub
	}
	public OvMember(String id, String pass, String auth, String nickname, String address, int point) {
		this.id = id;
		this.pass = pass;
		this.auth = auth;
		this.nickname = nickname;
		this.address = address;
		this.point = point;
	}
	public OvMember(String id, String pass) {
		this.id = id;
		this.pass = pass;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getAuth() {
		return auth;
	}
	public void setAuth(String auth) {
		this.auth = auth;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point = point;
	}
	
}
