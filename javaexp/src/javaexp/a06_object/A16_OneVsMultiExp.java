package javaexp.a06_object;

import java.util.ArrayList;

public class A16_OneVsMultiExp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//ex) 코레일 예매 시스템 OnTrain(시스템명,ArrayList<Ticketing>) Ticketing(구간 좌석 비용 
/* class Ticketing{
	private String length;
	private String seat;
	private int charge;

	public Ticketing(String length, String seat, int charge) {
		this.length = length;
		this.seat = seat;
		this.charge = charge;
	
	}
	public void settlist(Ontrain t) {
		this.tlist.add(t);
		System.out.println(t.getLength()+"구간"+t.getSeat()+"좌석이 추가되었습니다");
	}
	public void showSeatList(){
		System.out.println(" #기차 티켓팅# ");
		System.out.println("구간"+length);
		System.out.println("좌석"+seat);
		System.out.println("금액"+charge);
}
	if(tlist.size()==0) {
		System.out.println("선택된 좌석이 없습니다");
	}else {
		System.out.println("선택된 좌석 목록");
		for(Ontrain t:tlist) {
			System.out.println(t);
		}
	}
	}
		
	public String getLength() {
		return length;
	}
	public void setLength(String length) {
		this.length = length;
	}
	public String getSeat() {
		return seat;
	}
	public void setSeat(String seat) {
		this.seat = seat;
	}
	public int getCharge() {
		return charge;
	}
	public void setCharge(int charge) {
		this.charge = charge;

	} 
	
}
class OnTrain{
	private String sysName;
	private ArrayList<Ticketing>> tlist;
	public OnTrain(String sysName) {
		this.sysName = sysName;
		this.tlist = new ArrayList<Ticketing>();
	}

	@Override
	public String toString() {
		return "OnTrain [sysName=" + sysName + "]";
	}

	public String getSysName() {
		return sysName;
	}

	public void setSysName(String sysName) {
		this.sysName = sysName;
	}
	public ArrayList<Ticketing> getTlist() {
	return tlist;
}
	public void setTlist(ArrayList<Ticketing> tlist) {
	this.tlist = tlist;
	}//class 생성 반대로 함  . . 다시 확인
*/
		
	}

}
class OnTrain{

	private String sysName;
	private ArrayList<Ticketing> tlist;
	public OnTrain(String sysName) {
		this.sysName = sysName;
		this.tlist = new ArrayList<Ticketing>();
		
	}
	public void setTlist(Ticketing tk) {
		this.tlist.add(tk);
		System.out.println(tk.getFromTo()+" 예매 추가");
	}
	public void showList() {
		System.out.println("시스템명:"+this.sysName);
		if(this.tlist.size()>0) {
			System.out.println("예매 내역 리스트");
			System.out.println("구간\t좌석\t비용");
			for(Ticketing t:tlist) {
				t.ticketingInfo();
			}
		}else {
			System.out.println("예매내역이 없습니다.");
		}
	}
}
class Ticketing{
	private String fromTo;
	private String seat;
	private int pay;
	public Ticketing(String fromTo, String seat, int pay) {
		this.fromTo = fromTo;
		this.seat = seat;
		this.pay = pay;
	}
	public void ticketingInfo() {
		System.out.print(this.fromTo+"\t");
		System.out.print(this.seat+"\t");
		System.out.print(this.pay+"\n");
	}
	
	public String getFromTo() {
		return fromTo;
	}
	public void setFromTo(String fromTo) {
		this.fromTo = fromTo;
	}
	public String getSeat() {
		return seat;
	}
	public void setSeat(String seat) {
		this.seat = seat;
	}
	public int getPay() {
		return pay;
	}
	public void setPay(int pay) {
		this.pay = pay;
	}
	

}