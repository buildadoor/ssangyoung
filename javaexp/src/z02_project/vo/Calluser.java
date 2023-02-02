package z02_project.vo;

public class Calluser {
	private int callno; 
	private int usersno;
	private int manageno;
	private String callcontents;
	private String callanswers;
	public Calluser() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Calluser(int callno, int usersno, int manageno, String callcontents, String callanswers) {
		this.callno = callno;
		this.usersno = usersno;
		this.manageno = manageno;
		this.callcontents = callcontents;
		this.callanswers = callanswers;
	}
	public Calluser(int callno, int usersno, String callcontents) {
		this.callno = callno;
		this.usersno = usersno;
		this.callcontents = callcontents;
	}
	
	public Calluser(int usersno) {
		this.usersno = usersno;
	}
	public int getCallno() {
		return callno;
	}
	public void setCallno(int callno) {
		this.callno = callno;
	}
	public int getUserno() {
		return usersno;
	}
	public void setUserno(int usersno) {
		this.usersno = usersno;
	}
	public int getManageno() {
		return manageno;
	}
	public void setManageno(int manageno) {
		this.manageno = manageno;
	}
	public String getCallcontents() {
		return callcontents;
	}
	public void setCallcontents(String callcontents) {
		this.callcontents = callcontents;
	}
	public String getCallanswers() {
		return callanswers;
	}
	public void setCallanswers(String callanswers) {
		this.callanswers = callanswers;
	}
	
}

