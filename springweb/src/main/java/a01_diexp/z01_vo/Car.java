package a01_diexp.z01_vo;

import java.util.List;

public class Car {
	private String name;
	private int maxSpeed;
	private List<Tire> tlist;
	public Car() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Car(String name, int maxSpeed) {
		this.name = name;
		this.maxSpeed = maxSpeed;
	}
	public void TireList() {
		System.out.println(name+" 타이어 정보");
		if(tlist!=null && tlist.size()>0) {
			System.out.println("제조사\t가격");
			for(Tire t:tlist) {
				System.out.print(t.getCompany()+"\t");
				System.out.print(t.getPrice()+"\n");
			}
		}else {
			System.out.println("타이어 정보가 없습니다");
		}
	}
	
	public List<Tire> getTlist() {
		return tlist;
	}
	public void setTlist(List<Tire> tlist) {
		this.tlist = tlist;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getMaxSpeed() {
		return maxSpeed;
	}
	public void setMaxSpeed(int maxSpeed) {
		this.maxSpeed = maxSpeed;
	}
	
}
