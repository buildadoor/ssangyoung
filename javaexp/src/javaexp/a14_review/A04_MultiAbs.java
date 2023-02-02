package javaexp.a14_review;

import java.util.ArrayList;
import java.util.List;

public class A04_MultiAbs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Robot에 다양한 형태로 할당 및 attack()호출 .. 
//		List<Robot> rlist = new ArrayList<Robot>();
//		rlist.add(new Mz());
//		rlist.add(new Tv());
//		rlist.add(new Dagan());
//		for(Robot b:rlist) {
//			b.attack();
//		}
		RobotWar w1 = new RobotWar("로봇1차대전");
		w1.attnedRobot(new Mz());
		w1.attnedRobot(new Tv());
		w1.attnedRobot(new Dagan());
		w1.showAttendList();
	}

}
//class로 RobotWar
//필드로 로봇1차대전 List<Robot>
//메서드 attendRobot(Robot b)
//메서드 showAttendList()

class RobotWar{
	private String wname;
	private List<Robot> rlist;
	public RobotWar(String wname) {
		this.wname = wname;
		rlist = new ArrayList<Robot>();
	}
	public void attnedRobot(Robot b) {
System.out.println(wname+"에 "+b.getKind()+"참석");
rlist.add(b);
System.out.println("참석 로봇의 수:"+rlist.size());
	
	}
	public void showAttendList() {
		System.out.println(wname+"에 참석한 로봇의 공격 정보");
		if(rlist.size()>0) {
			for(Robot b:rlist) {
				b.attack();
			}
		}else {
			System.out.println("참석한 로봇이 없군요");
		}
		
	}
	}
// ex) Rob을 추상 필드 종류, attack() 재정의 메서드 공격 방법 
// 		상속받은 하위 클래스 Mz 로켓포 발사.. 
// 		상속받은 하위 클래스 Tv 발차기 공격을 하다..
// 		상속받은 하위 클래스 Dagan 변신 공격을 하다..
abstract class Robot{
	private String kind;

	public Robot(String kind) {
		this.kind = kind;
	}

	public String getKind() {
		return kind;
	}
	public abstract void attack();
}
class Mz extends Robot{
	public Mz() {
		super("MZ");
		// TODO Auto-generated constructor stub
	}
	@Override
	public void attack() {
		// TODO Auto-generated method stub
		System.out.println(getKind()+"는 로켓발사로 공격을 하다.");
	}
}
class Tv extends Robot{
	public Tv() {
		super("TV");
		// TODO Auto-generated constructor stub
	}
	@Override
	public void attack() {
		// TODO Auto-generated method stub
		System.out.println(getKind()+"는 발차기 공격을 하다.");
	}
}
class Dagan extends Robot{
	public Dagan() {
		super("다간");
		// TODO Auto-generated constructor stub
	}
	@Override
	public void attack() {
		// TODO Auto-generated method stub
		System.out.println(getKind()+"는 변신 공격을 하다.");
	}
}