package z02_project.vo;

public class Week {
	private String pno;
	private String pname;
	private String pcontents;
	private String ptime;
	private String noticedate;
	private String userno;
	public String getPno() {
		return pno;
	}
	public void setPno(String pno) {
		this.pno = pno;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getPcontents() {
		return pcontents;
	}
	public void setPcontents(String pcontents) {
		this.pcontents = pcontents;
	}
	public String getPtime() {
		return ptime;
	}
	public void setPtime(String ptime) {
		this.ptime = ptime;
	}
	public String getNoticedate() {
		return noticedate;
	}
	public void setNoticedate(String noticedate) {
		this.noticedate = noticedate;
	}
	public String getUserno() {
		return userno;
	}
	public void setUserno(String userno) {
		this.userno = userno;
	}
	public Week(String pno, String pname, String pcontents, String ptime, String noticedate, String userno) {
		this.pno = pno;
		this.pname = pname;
		this.pcontents = pcontents;
		this.ptime = ptime;
		this.noticedate = noticedate;
		this.userno = userno;
	}
	public Week() {
		super();
		// TODO Auto-generated constructor stub
	}
}