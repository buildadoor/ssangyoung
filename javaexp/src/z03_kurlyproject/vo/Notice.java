package z03_kurlyproject.vo;

public class Notice {
	public int userno;
	public String noticename;
	public String contents;
	public String regisdate;
	public String enddate;
	public Notice() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Notice(int userno, String noticename, String contents, String regisdate, String enddate) {
		this.userno = userno;
		this.noticename = noticename;
		this.contents = contents;
		this.regisdate = regisdate;
		this.enddate = enddate;
	}
	public Notice(String enddate) {
		this.enddate = enddate;
	}
	public int getUserno() {
		return userno;
	}
	public void setUserno(int userno) {
		this.userno = userno;
	}
	public String getNoticename() {
		return noticename;
	}
	public void setNoticename(String noticename) {
		this.noticename = noticename;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public String getRegisdate() {
		return regisdate;
	}
	public void setRegisdate(String regisdate) {
		this.regisdate = regisdate;
	}
	public String getEnddate() {
		return enddate;
	}
	public void setEnddate(String enddate) {
		this.enddate = enddate;
	}
	
}
