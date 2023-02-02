package a01_diexp.z01_vo;
//이름, 팀명, 타율
public class BaseBallPlayer {
	private String name;
	private  double avg;
	private BaseBallTeam baseBallTeam;
	public BaseBallPlayer() {
		super();
		// TODO Auto-generated constructor stub
	}
	public BaseBallPlayer(String name, double avg) {
		this.name = name;
		this.avg = avg;
	}
	public void baseball() {
		System.out.println("선수명: "+name);
		System.out.println("타율: "+avg);
		if(baseBallTeam!=null) {
			System.out.println("#KBO리그#");
			System.out.println("팀명:"+baseBallTeam.getTname());
			System.out.println("승:"+baseBallTeam.getWin());
			System.out.println("무:"+baseBallTeam.getDraw());
			System.out.println("패:"+baseBallTeam.getLose());
		}else {
			System.out.println("소속 팀이 없습니다.");
		}
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getAvg() {
		return avg;
	}
	public void setAvg(double avg) {
		this.avg = avg;
	}
	public BaseBallTeam getBaseBallTeam() {
		return baseBallTeam;
	}
	public void setBaseBallTeam(BaseBallTeam baseBallTeam) {
		this.baseBallTeam = baseBallTeam;
	}
	
}
