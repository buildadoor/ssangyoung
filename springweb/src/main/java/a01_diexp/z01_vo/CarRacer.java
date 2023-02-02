package a01_diexp.z01_vo;

public class CarRacer {
	private String name;
	private Car car;
	public CarRacer() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CarRacer(String name) {
		this.name = name;
	}
	public void driving() {
		System.out.println("운행자:"+name);
		if(car!=null) {
			System.out.println("#차랑운행#");
			System.out.println("운행합니다~");
			System.out.println("자동차 모델명:"+car.getName());
			System.out.println("최고속도:"+car.getMaxSpeed());
		}else {
			System.out.println("차가 없습니다.");
		}
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Car getCar() {
		return car;
	}
	public void setCar(Car car) {
		this.car = car;
	}
	//컨테이너의 id와 메서드의 property가 동일할 때, 해당 객체 할당하는 것 byName
	public void setCar03(Car car){
		      this.car = car;
	}
	}
