package z02_project.vo;

public class Return {
	private int userno;
	private int rentalno;
	private String returnwhether;
	private String returndate;
	public Return() {
		super();
		// TODO Auto-generated constructor stub
		
	}
	public Return(int userno, int rentalno, String returnwhether, String returndate) {
		this.userno = userno;
		this.rentalno = rentalno;
		this.returnwhether = returnwhether;
		this.returndate = returndate;
	}
	public Return(int userno, int rentalno) {
		this.userno = userno;
		this.rentalno = rentalno;
	}
	public int getUserno() {
		return userno;
	}
	public void setUserno(int userno) {
		this.userno = userno;
	}
	public int getRentalno() {
		return rentalno;
	}
	public void setRentalno(int rentalno) {
		this.rentalno = rentalno;
	}
	public String getReturnwhether() {
		return returnwhether;
	}
	public void setReturnwhether(String returnwhether) {
		this.returnwhether = returnwhether;
	}
	public String getReturndate() {
		return returndate;
	}
	public void setReturndate(String returndate) {
		this.returndate = returndate;
	}
	
}