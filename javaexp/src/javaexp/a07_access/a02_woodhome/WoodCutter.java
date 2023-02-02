package javaexp.a07_access.a02_woodhome;

public class WoodCutter {
	private String privSec="개인비밀(선녀의 옷)";
	String payOurHome = "우리집 산림 경비";
	protected String inheritMoney = "상속재산";
	public String announce = "막내딸이 10월의 신부가 됩니다.";
	
	public void callWoodCutter() {
		System.out.println("private:"+privSec);
		System.out.println("default:"+payOurHome);
		System.out.println("protected:"+inheritMoney);
		System.out.println("public:"+announce);
	}
}

