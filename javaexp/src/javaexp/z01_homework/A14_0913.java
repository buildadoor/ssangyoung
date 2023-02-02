package javaexp.z01_homework;

public class A14_0913 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
/*
2022-09-13
[1단계:개념] 1. 자바의 접근제어자 4가지 범위를 예제를 통하여 설명하세요.
 				public, default, protected, private
 				1. public : 모든접근을 허용 
 				2. protected : 같은 패키지 (폴더)에 있는 객체와 상속관계의 객체들만 허용
 				3. default : 같은 패키지 (폴더)에 있는 객체들만 허용
 				4. private : 현재 객체 내에서만 허용
​			호출하는 클래스가 같은 패키지인 경우 접근제어자가 public, X(default)경우 자유롭게 
		 	클래스 선언과 생성자 선언이 가능하다.
		 	호출하는 클래스가 다른 패키지인 경우 접근 제어자가 public인 경우에 class 선언이 가능하고
		 	생성자도 public인 경우에 생성이 가능하다.
		 	같은 패키지이더라도 접근제어자가 private인 경우에는 외부 클래스에서 접근이 불가능하다.
[1단계:코드] 2. playroom패키지 선언과 내부적으로 친구1, 친구2 클래스 선언, studyroom패키지선언 학생1, 학생2 클래스 선언, 
             친구1, 학생1에서 private, X(default), public에 적절한 필드값을 선언하고, 상호간에 호출하세요.
             package homework_strudyroom;
			import homework_playroom.Friend1;
			public class Student1 extends Friend1{
			private String school ="쌍용고등학교";
			String name = "이또치";
			protected String score = "학교 성적";
			public String graduate = "2월14일 졸업";
	
			public void callFriend1() {
		//	System.out.println("private:"+school);
			System.out.println("default:"+name);
			System.out.println("protected:"+score);
			System.out.println("public:"+graduate);
			}
}

[1단계:개념] 3. 인스턴스변수와 스태틱변수의 차이점을 기술하세요.
			1)instance
			객체(인스턴스)마다 가지고 있는 필드와 메소드
	 		이들은 각각 인스턴스 필드, 인스턴스 메소드라고 함 
	 		인스턴스 멤버는 객체 소속된 멤버이기때문에 객체가 없이 사용불가능
			2)static 
		 	클래스 고정된 필드와 메서드 - 정적 필드, 정적 메서드
	 		정적 멤버는 클래스에 소속된 멤버
	 		객체 내부에 존재하지 않고, 메소드 영역에 존재
	 		정적 멤버는 객체를 생성하지 않고 클래스로 바로 접근해 사용
[1단계:코드] 4. ScoccerPlayer에 팀명, 팀성적, 이름, 개인성적에서 팀명과 팀성적은 static, 이름과 개인성적으로 instance변수를 선언하여 데이터를 할당하세요.
ScoccerPlayer p01 = new ScoccerPlayer("마동석",5);
			p01.tName = "전북";
			p01.tScore = 3;
			p01.showInfo();
			ScoccerPlayer p02 = new ScoccerPlayer("손석구",7);
			p02.tName = "수원";
			p02.tScore = 2;
			p02.showInfo();
		}
	}

class ScoccerPlayer{
String pName;
int pScore; 
static String tName;
static int tScore;
public ScoccerPlayer(String pName, int pScore) {
	this.pName = pName;
	this.pScore = pScore;
}
public void Score(String tName, int tSocre) {
		this.tName = tName;
		this.tScore = tScore;
	}
	void showInfo() {
		System.out.println("선수 이름 :"+pName);
		System.out.println("개인 득점 :"+pScore);
		System.out.println("팀 이름 :"+tName);
		System.out.println("팀 승리 횟수 :"+tScore);
}
}

[1단계:개념] 5. final와 static final의 필드 차이점을 예제를 통해 기술하세요.
	 # final 
	 	1. 최종적인 값을 갖고 있는 필드 = 값을 변경할 수 없는 필드
	 	2. final 필드는 딱 한번 초기값을 지정하면 해당 값을 변경할 수 없다.
	  	-필드 생성시
	  		final String nation = "한국";
	  	-생성자
	  		Person(String nation){
	  			this.name = nation;
	  		}
	  	cf) final만 붙은 필드는 객체마다 다른 상수를 가질 수 있다.
	  	#static final
	  	1. 상수 = 정적 final 필드
	  		-final 필드: 객체마다 가지는 불변의 인스턴스 필드
	  		-static final
	  			-객체마다 가지고 있지 않음
	  			-메소드 영역에 클래스 별로 관리되는 불변의 정적 필드
	  			- 공용 데이터로서 사용
	  	2. 상수 이름은 전부 대문자로 작성
	  	3. 다른 단어가 결합되면 _로 연결
	  	
	  	
[1단계:코드] 6. 컴퓨터의 종류, 사양내용(cpu,ram,hdd)을 static final, static을 이용하여 초기화 호출하여 출력하세요.
	Computer c01 = new Computer("i9","16G","8TB");
		Computer c02 = new Computer("Ryzen5","8G","4TB");
		Computer c03 = new Computer("i7","8G","4TB");
		c01.comInfo();
		c02.comInfo();
		c03.comInfo();
	}
}
class Computer{
	static final String KIND= "노트북";
	static String cpu;
	static String ram;
	static String hdd;
	public Computer (String cpu, String ram, String hdd) {
		this.cpu = cpu;
		this.ram = ram;
		this.hdd = hdd;
	}
	public void comInfo() {
		System.out.println (" ~컴퓨터 사양~ ");
		System.out.println ("종류: "+KIND);
		System.out.println ("CPU: "+cpu);
		System.out.println ("RAM: "+ram);
		System.out.println ("HDD: "+hdd);
	}
}
[1단계:개념] 7. 1:1관계 객체의 선언 순서를 기술하세요.
			종속될 클래스 선언하고 포함할 클래스 선언한다.
			
[1단계:코드] 8. 아래의 1:1관계 객체를을 선언해보세요.
            1) 자동차(차종,최고속도,배기량)와 자동차의소유주(이름,자동차, takeCar(자동차) driving() ) 를 선언
            2) 학생과 성적표
            3) 결혼할 커플(신랑, 신부)		 
            	Car c01 = new Owner("홍길동","자동차");
		c01.driving();
		c01.takeCar(new Car("G90",220,3470));
		c01.driving();
		c01.takeCar(new Car("G70",200,3000));
	}
}
class Car{
	private String car;
	private int maxSpeed;
	private int cc;
		public Car(String car, int maxSpeed, int cc) {
			this.car = car;
			this.maxSpeed = maxSpeed;
			this.cc = cc;
	}
	public void info() {
		System.out.println(" # 자동차 # ");
		System.out.println("차종: "+this.car);
		System.out.println("최고속도: "+this.maxSpeed); 
		System.out.println("배기량: "+this.cc); 
class Owner{
	private String name;
	private String car;
	public Owner(String name, String car) {
			this.name = name;
			this.car = car;
	}
	public void takeCar(Car carr) { 
		this.car = car; 	
	}
	public void driving() {
	}
}
	
	}
}
	#코드순서
	1. 종속될 클래스 선언
		-속성값(필드, 메서드) 구분
		-출력할 기능 메서드 선언
	2. 포함할 클래스 선언 
		-기본 속성 선언
		-종속될 클래스 선언
		-생성자(기본 속성-필드)
		-종속될 클래스를 할당할 메서드 선언
		-전체 데이터 출력 메서드 선언
 */
		//2번 패키지 확인 
		//4번
		Computer c01 = new Computer("조립식",150000);
		c01.show();
		c01.kind="노트북";
		Computer.comp="삼성컴퓨터";
		c01.show();
		CarOwner co01 = new CarOwner("홍길동");
		co01.driving();
		co01.takeCar( new Car("BMW",280,3500) );
		co01.driving();
		
		Record r1 = new Record ("영어",90);
		System.out.println(r1.toString());
		System.out.println(r1);
		//toSTring()의 내용을 참조변수만 호출했을때, 처리할 내용을 기술.
		Student st = new Student("홍길동");
		st.setR1(r1);
		st.show();
		st.setR1(new Record("수학",85));
		st.show();
		Bride b1 = new Bride("홍영희");
		b1.coupleInfo();
		b1.setWedding(new Groom("홍길동",27));
		b1.coupleInfo();
	}
}

class Groom{
	private String name;
	private int age;
	
	public Groom(String name, int age) {
		this.name = name;
		this.age = age;
	}

	@Override
	public String toString() {
		return "신랑정보 [신랑이름=" + name + ", 나이=" + age + "]";
	}

	public String getName() {
		return name;
	}

}
class Bride{
	private String name;
	private Groom groom;
	public Bride(String name) {
		this.name = name;
	}
	public void setWedding(Groom groom) {
		this.groom = groom;
	System.out.println("신랑"+groom.getName()+"와 결혼하다");
	}
	public void coupleInfo() {
		System.out.println("신부 "+name+"");
		if(this.groom!=null) {
			System.out.println(this.groom);
		}else {
			System.out.println("아직 결혼전 입니다.");
		}
	}
}
class Student{
	private String name;
	private Record r1;
	public Student(String name) {
		this.name = name;
	}
	public void setR1(Record r1) {
		this.r1 = r1;
	}
	public void show() {
		System.out.println("# "+name+"학생 정보 #");
		if(r1!=null) {
			System.out.println(r1);
		}else {
			System.out.println("성적표가 없네요!!");
		}
	}
}
class Record{
	private String subject;
	private int point;
	public Record(String subject, int point) {
		this.subject = subject;
		this.point = point;
	}
	//toString()은 참조변수를 호출했을때, 리턴할 내용을 기술 
	//객체의 참조: 패키지명.클래스명@heap영역의 주소값
	@Override
	public String toString() {
		return "Record [과목=" + subject + ", 점수=" + point + "]";
	}

	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point = point;
	}
	
}
//		이름 자동차 takeCar driving
class CarOwner{
	private String name;
	private Car car;
	public CarOwner(String name) {
		this.name = name;
	}
	public void takeCar(Car car) {
		System.out.println("# 차를 타다 #");
		this.car = car;
	}
	public void driving() {
		System.out.println(this.name+"차를 운행하려고 합니다");
		if(this.car!=null) {//객체가 할당되어 있을때
			System.out.println("차를 운행합니다!!");
			this.car.showCarInfo();
		}else {
			System.out.println("차가 없네요!!");
		}
	}
	
}
		//8번 자동차 차종 최고속도 배기량
class Car {
	private String kind;
	private int maxSpeed;
	private int cc;
	public Car() {}
	public Car(String kind, int maxSpeed, int cc) {
		this.kind = kind;
		this.maxSpeed = maxSpeed;
		this.cc = cc;
	}
	public void showCarInfo() {
		System.out.println("차종:"+this.kind);
		System.out.println("최고속도:"+this.maxSpeed+"km/h");
		System.out.println("배기량:"+this.cc+"cc");
	}
	public String getKind() {
		return kind;
	}
	public void setKind(String kind) {
		this.kind = kind;
	}
	public int getMaxSpeed() {
		return maxSpeed;
	}
	public void setMaxSpeed(int maxSpeed) {
		this.maxSpeed = maxSpeed;
	}
	public int getCc() {
		return cc;
	}
	public void setCc(int cc) {
		this.cc = cc;
	}
}

class Computer{
	//인스턴스 변수 : 객체별, 변경가능
	String kind;
	//final 변수 : 객체별, 객체단위로는 변경 불가
	final int cost; //이것만 하면 에러 source 필드 초기화 후 에러x 
	//static변수 : 클래스 단위 변수 설정, 클래스 단위로는 변경가능
	static String comp;
	//static final 상수 : 클래스 단위로 상수 설정, 변경 불가
	static final String NATION="KOR";
	public Computer(String kind, int cost) {
		this.kind = kind;
		this.cost = cost;
	}
	public void show() {
		System.out.println("#### 컴퓨터정보 ####");
		System.out.println("컴퓨터종류(인스턴스:"+this.kind);
		System.out.println("구매비용(인스턴스단위상수):"+this.cost);
		System.out.println("제조사(static변수):"+comp);
		System.out.println("(클래스상수)made in "+NATION);
	}
}