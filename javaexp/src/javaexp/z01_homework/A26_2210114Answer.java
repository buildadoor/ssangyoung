package javaexp.z01_homework;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javaexp.a13_database.DB;

public class A26_2210114Answer {

	private Connection con;
	private Statement stmt;
	private ResultSet rs;
	/*3번
	 사원명과 부서명의 통합테이블 EmpDept100 테이블을 복사 만들고, 해당 정보를 메서드를 만들고 데이터를 입력하세요.
	1. 테이블 만들기
	2. sql 만들기
	3. 입력한 VO객체 만들기
	4. 기능 메서드 선언 메서드 선언
	5. 입력 처리 코드
	
	4번
	테이블생성
	sql 등록 조회
	vo
	기능메서드선언
		내용처리 
	*/	
	
	
	
	public void insertEmpDept(EmpDept100 ins) {
	String sql = "INSERT INTO EMPDEPT100 values(EMPDEPT100_seq.nextval,\r\n"
			+ "'"+ins.getEname()+"','"+ins.getJob()+"',"+ins.getMgr()+",to_date('"+ins.getHiredateS()+"','YYYYMMDD'),\r\n"
			+ ins.getSal()+","+ins.getComm()+",'"+ins.getDname()+"','"+ins.getLoc()+"')";
	
	
	System.out.println("입력");
	System.out.println(sql);
	try {
		con = DB.con();
		con.setAutoCommit(false);
		stmt = con.createStatement();
		stmt.executeUpdate(sql);
		con.commit();
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		System.out.println("DB에러:"+e.getMessage());
		try {
			con.rollback();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			System.out.println("rollback에러:"+e.getMessage());
		}
	}catch(Exception e) {
		System.out.println("일반에러:"+e.getMessage());
	}finally {
		DB.close(rs, stmt, con);
	}
	}

		
		
		/*3번
	 사원명과 부서명의 통합테이블 EmpDept100 테이블을 복사 만들고, 해당 정보를 메서드를 만들고 데이터를 입력하세요.
	1. 테이블 만들기
	2. sql 만들기
	3. 입력한 VO객체 만들기
	4. 기능 메서드 선언 메서드 선언
	5. 입력 처리 코드
	
	4번
	테이블생성
	sql 등록 조회
	vo
	기능메서드선언
		내용처리 
	*/	
	
	
	
	public void insertMember(Member100 ins) {
	String sql = "INSERT INTO Member100 values('"+ins.getId()+"','"+ins.getPass()+"','"+ins.getName()+"','"+ins.getAuth()+"',"+ins.getPoint()+",sysdate)";
	
	
	System.out.println("입력");
	System.out.println(sql);
	try {
		con = DB.con();
		con.setAutoCommit(false);
		stmt = con.createStatement();
		stmt.executeUpdate(sql);
		con.commit();
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		System.out.println("DB에러:"+e.getMessage());
		try {
			con.rollback();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			System.out.println("rollback에러:"+e.getMessage());
		}
	}catch(Exception e) {
		System.out.println("일반에러:"+e.getMessage());
	}finally {
		DB.close(rs, stmt, con);
	}
	}



		/*3번
	 사원명과 부서명의 통합테이블 EmpDept100 테이블을 복사 만들고, 해당 정보를 메서드를 만들고 데이터를 입력하세요.
	1. 테이블 만들기
	2. sql 만들기
	3. 입력한 VO객체 만들기
	4. 기능 메서드 선언 메서드 선언
	5. 입력 처리 코드
	
	4번
	테이블생성
	sql 등록 조회
	vo
	기능메서드선언
		내용처리 
	*/	
	
	
	
	public List<Member100> memberList(Member100 ins) {
		List<Member100> list = new ArrayList<Member100>();
 		String sql = "SELECT * FROM member100 \r\n"
 				+ "WHERE id LIKE '%/'||'"+ins.getId()+"'||'%',\r\n"
 				+ "OR name LIKE '%'||'"+ins.getName()+"'||'%'";
	
	
	System.out.println("입력");
	System.out.println(sql);
	try {
		con = DB.con();
		con.setAutoCommit(false);
		stmt = con.createStatement();
		rs = stmt.executeQuery(sql);
		while(rs.next()) {
			list.add(new Member100(
						rs.getString("id"),
						rs.getString("pass"),
						rs.getString("name"),
						rs.getString("auth"),
						rs.getInt("point"),
						rs.getDate("regdte")
					));
		}
	
		System.out.println("조회건수:"+list.size());
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		System.out.println("조회건수:"+e.getMessage());
	}catch(Exception e) {
		System.out.println("일반에러:"+e.getMessage());
	}finally {
		DB.close(rs, stmt, con);
	}
	return list;
	}



		/*3번
	 사원명과 부서명의 통합테이블 EmpDept100 테이블을 복사 만들고, 해당 정보를 메서드를 만들고 데이터를 입력하세요.
	1. 테이블 만들기
	2. sql 만들기
	3. 입력한 VO객체 만들기
	4. 기능 메서드 선언 메서드 선언
	5. 입력 처리 코드
	
	4번
	테이블생성
	sql 등록 조회
	vo
	기능메서드선언
		내용처리 
	*/	
	
	
	
	public boolean login(Member100 sch) {
		boolean isLogin=false;
		String sql = "SELECT * FROM Member100 where id='"+sch.getId()+"' and pass='"+sch.getPass()+"' ";

	System.out.println("입력");
	System.out.println(sql);
	try {
		con = DB.con();
		con.setAutoCommit(false);
		stmt = con.createStatement();
		rs = stmt.executeQuery(sql);
		isLogin=rs.next();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		System.out.println("조회건수:"+e.getMessage());
	}catch(Exception e) {
		System.out.println("일반에러:"+e.getMessage());
	}finally {
		DB.close(rs, stmt, con);
	}
	return isLogin;
	}



		public static void main(String[] args) {
		// TODO Auto-generated method stub
			A26_2210114Answer dao = new A26_2210114Answer();
			//EmpDept100 ins = new EmpDept100(
			//	"마길동","대리",7800,"20221001",4000,1000,"회계","서울 신림동");
		//	dao.insertEmpDept(ins);
		//	dao.insertMember(new Member100("goodman","888","오길동","일반사용자",1000,null));
		//	for(Member100 mem:dao.memberList(new Member100("",""))){
			//	System.out.print(mem.getId()+"\t");
				//System.out.print(mem.getName()+"\t");
				//System.out.print(mem.getAuth()+"\n");
		Scanner sc = new Scanner(System.in);
		Member100 mLogin = new Member100();
		boolean isFirst = true;
		do {
			if(!isFirst) 
				System.out.println("로그인실패! 다시~");

			
			System.out.println("로그인");
			System.out.print("아이디를 입력하세요:");
			String id = sc.nextLine();
			System.out.print("패스워드를 입력하세요:");
			String pass = sc.nextLine();
			mLogin.setId(id);
			mLogin.setPass(pass);
			isFirst=false;
		} while (!dao.login(mLogin)); //do문은 해당 데이터가 false 
		System.out.println("로그인 성공!! ");
		
		}



		public A26_2210114Answer() {
			super();
			// TODO Auto-generated constructor stub
		}

}
class Member100{
	private String id;
	private String pass;
	private String name;
	private String auth;
	private int point;
	private Date regdte;
	
	public Member100() {
		this.id = id;
		this.pass = pass;
	}
	public Member100(String id, String pass, String name, String auth, int point, Date regdte) {
		this.id = id;
		this.pass = pass;
		this.name = name;
		this.auth = auth;
		this.point = point;
		this.regdte = regdte;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAuth() {
		return auth;
	}
	public void setAuth(String auth) {
		this.auth = auth;
	}
	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point = point;
	}
	public Date getRegdte() {
		return regdte;
	}
	public void setRegdte(Date regdte) {
		this.regdte = regdte;
	}

}


//기본 생성자
//조회를 위한 생성자 : hiredateS 삭제
//입력을 위한 생성자  : empno, hiredate 삭제 
class EmpDept100{
	private int empno;
	private String ename;
	private String job;
	private int mgr;
	private String hiredateS;
	private Date hiredate;
	private double sal;
	private double comm;
	private String dname;
	private String loc;
	//기본 생성자 
	//조회를 위한 생성자 hiredateS X 
	
	public EmpDept100() {
		super();
		// TODO Auto-generated constructor stub
	}
	public EmpDept100(int empno, String ename, String job, int mgr, Date hiredate, double sal, double comm,
			String dname, String loc) {
		this.empno = empno;
		this.ename = ename;
		this.job = job;
		this.mgr = mgr;
		this.hiredate = hiredate;
		this.sal = sal;
		this.comm = comm;
		this.dname = dname;
		this.loc = loc;
	}
	//입력을 위한 생성자 empX hiredateX
	public EmpDept100(String ename, String job, int mgr, String hiredateS, double sal, double comm, String dname,
			String loc) {
		this.ename = ename;
		this.job = job;
		this.mgr = mgr;
		this.hiredateS = hiredateS;
		this.sal = sal;
		this.comm = comm;
		this.dname = dname;
		this.loc = loc;
	}
	public int getEmpno() {
		return empno;
	}
	public void setEmpno(int empno) {
		this.empno = empno;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public int getMgr() {
		return mgr;
	}
	public void setMgr(int mgr) {
		this.mgr = mgr;
	}
	public String getHiredateS() {
		return hiredateS;
	}
	public void setHiredateS(String hiredateS) {
		this.hiredateS = hiredateS;
	}
	public Date getHiredate() {
		return hiredate;
	}
	public void setHiredate(Date hiredate) {
		this.hiredate = hiredate;
	}
	public double getSal() {
		return sal;
	}
	public void setSal(double sal) {
		this.sal = sal;
	}
	public double getComm() {
		return comm;
	}
	public void setComm(double comm) {
		this.comm = comm;
	}
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	public String getLoc() {
		return loc;
	}
	public void setLoc(String loc) {
		this.loc = loc;
	}
	
}