package javaexp.z01_homework;

public class A26_221014 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
/*
 2022-10-14
[1단계:개념] 1. 데이터 등록/수정/삭제시, 기존 select와 차이가 나는 추가 코드를 기술하고 설명하세요.
1) 복사테이블 만들기 
		create table emp100
		as select * from emp;
		alter table emp100
		modify(
			job varchar2(50),
			ename varchar2(50)
			empno number(4) primary key
		);
		sequence 만들기 (primary key 설정)
		create sequence emp100_seq
			start with 1000
			minvalue 1000
			maxvalue 9999;
2) sql 작성
	 	insert into emp100 values(emp100_seq.nextval,'홍길동','사원',7800,
	 		to_date('2022/01/01','YYYY/MM/DD'), 3500,100,10);
3) 입력 내용을 기준으로 vo생성
		private int empno;
		private String ename;
		private String job;
		private int mgr;
		private String hiredateS;
		private double sal;
		private double comm;
		private int deptno;
4) 메서드 선언 
		public void insert(Emp ins){	
		}
	
	public List<Emp> getEmpSch(Emp sch){
		List<Emp> list = new ArrayList<Emp>();
		try {
			con = DB.con();
			String sql = "SELECT empno, ename, job, mgr, hiredate, sal, comm, deptno\r\n"
					+ "FROM emp01\r\n"
					+ "where ename LIKE '%'||'"+sch.getEname()+"'||'%'\r\n"
					+ "AND job LIKE '%'||'"+sch.getJob()+"'||'%'\r\n"
					+ "AND sal BETWEEN "+sch.getToSal()+" AND"+sch.getToSal();
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				//rs.getXXXX(1)....
				list.add(new Emp(
				rs.getInt(1), rs.getString(2),
				rs.getString(3), rs.getInt(4), 
				rs.getDate(5), rs.getDouble(6), 
				rs.getDouble(7), rs.getInt(8)
				));
			}
			System.out.println("검색된 데이터 건수:"+list.size());
			DB.close(rs, stmt, con);
		} catch (SQLException e) {
			System.out.println("DB 관련예외:"+e.getMessage());
		} catch (Exception e) {
			System.out.println("일반 예외:"+e.getMessage());
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
5) 주요 내용
		Connection 객체의 autocommit ==> false 
		Statement 객체의 executeUpdate(sql)
		ResultSet 객체 삭제(사용하지 않음 == while() X)
		Connection 객체의 comm(), 예외 처리 내용을 rollback()
[1단계:확인] 2. 등급테이블의  salgrade1000 테이블을 복사 만들고, 해당 정보를 메서드를 만드세요.
	create table salgrade1000
	as select * from SALGRADE;
	ALTER TABLE salgrade1000
		modify(
			losal number,
			hisal number
		);

[1단계:확인] 3. 사원명과 부서명의 통합테이블 EmpDept100 테이블을 복사 만들고, 해당 정보를 메서드를 만들고
      데이터를 입력하세요.
      ps) 3번 문제 : empdept100 테이블에 데이터를 입력하는 문제, 오늘 주로 다룬 내용..
      
      CREATE TABLE empdept100
	AS SELECT dname, loc, e.* FROM emp e, dept d
	WHERE e.DEPTNO = d.DEPTNO ;
	public void insert(Emp ins){	
		}
	
	
[1단계:확인] 4. member100(아이디, 패스워드, 이름, 권한, 포인트, 등록일) 만들고, 데이터를 등록 후, 조회하는
      메서드를 선언 및 출력하세요.
    CREATE TABLE member100(
	id varchar(10),
	password number, 
	name varchar2(50),
	authority varchar2(30),
	point NUMBER,
	register date
	);
INSERT INTO member100 values('buildadoor',0220,'이윤아','관리자?',16000,sysdate);
SELECT * FROM member100;
      
[1단계:확인] 5. 위 member100테이블을 기준으로 아이디, 패스워드를 입력(Scanner)받아 select문으로 
         데이터를 조회하여 로그인 성공 여부를 출력하는 Dao기능메서드를 만드세요.
         package javaexp.z01_homework;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javaexp.a13_database.A05_MemberDao;
import javaexp.a13_database.DB;
import javaexp.a13_database.vo.Member;

public class A26_221014 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
/*
 2022-10-14
[1단계:개념] 1. 데이터 등록/수정/삭제시, 기존 select와 차이가 나는 추가 코드를 기술하고 설명하세요.
1) 복사테이블 만들기 
		create table emp100
		as select * from emp;
		alter table emp100
		modify(
			job varchar2(50),
			ename varchar2(50)
			empno number(4) primary key
		);
		sequence 만들기 (primary key 설정)
		create sequence emp100_seq
			start with 1000
			minvalue 1000
			maxvalue 9999;
2) sql 작성
	 	insert into emp100 values(emp100_seq.nextval,'홍길동','사원',7800,
	 		to_date('2022/01/01','YYYY/MM/DD'), 3500,100,10);
3) 입력 내용을 기준으로 vo생성
		private int empno;
		private String ename;
		private String job;
		private int mgr;
		private String hiredateS;
		private double sal;
		private double comm;
		private int deptno;
4) 메서드 선언 
		public void insert(Emp ins){	
		}
	
	public List<Emp> getEmpSch(Emp sch){
		List<Emp> list = new ArrayList<Emp>();
		try {
			con = DB.con();
			String sql = "SELECT empno, ename, job, mgr, hiredate, sal, comm, deptno\r\n"
					+ "FROM emp01\r\n"
					+ "where ename LIKE '%'||'"+sch.getEname()+"'||'%'\r\n"
					+ "AND job LIKE '%'||'"+sch.getJob()+"'||'%'\r\n"
					+ "AND sal BETWEEN "+sch.getToSal()+" AND"+sch.getToSal();
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				//rs.getXXXX(1)....
				list.add(new Emp(
				rs.getInt(1), rs.getString(2),
				rs.getString(3), rs.getInt(4), 
				rs.getDate(5), rs.getDouble(6), 
				rs.getDouble(7), rs.getInt(8)
				));
			}
			System.out.println("검색된 데이터 건수:"+list.size());
			DB.close(rs, stmt, con);
		} catch (SQLException e) {
			System.out.println("DB 관련예외:"+e.getMessage());
		} catch (Exception e) {
			System.out.println("일반 예외:"+e.getMessage());
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
5) 주요 내용
		Connection 객체의 autocommit ==> false 
		Statement 객체의 executeUpdate(sql)
		ResultSet 객체 삭제(사용하지 않음 == while() X)
		Connection 객체의 comm(), 예외 처리 내용을 rollback()
[1단계:확인] 2. 등급테이블의  salgrade1000 테이블을 복사 만들고, 해당 정보를 메서드를 만드세요.
	create table salgrade1000
	as select * from SALGRADE;
	ALTER TABLE salgrade1000
		modify(
			losal number,
			hisal number
		);

[1단계:확인] 3. 사원명과 부서명의 통합테이블 EmpDept100 테이블을 복사 만들고, 해당 정보를 메서드를 만들고
      데이터를 입력하세요.
      ps) 3번 문제 : empdept100 테이블에 데이터를 입력하는 문제, 오늘 주로 다룬 내용..
      
      CREATE TABLE empdept100
	AS SELECT dname, loc, e.* FROM emp e, dept d
	WHERE e.DEPTNO = d.DEPTNO ;
	public void insert(Emp ins){	
		}
	
	
[1단계:확인] 4. member100(아이디, 패스워드, 이름, 권한, 포인트, 등록일) 만들고, 데이터를 등록 후, 조회하는
      메서드를 선언 및 출력하세요.
    CREATE TABLE member100(
	id varchar(10),
	password number, 
	name varchar2(50),
	authority varchar2(30),
	point NUMBER,
	register date
	);
INSERT INTO member100 values('buildadoor',0220,'이윤아','관리자?',16000,sysdate);
SELECT * FROM member100;
      
[1단계:확인] 5. 위 member100테이블을 기준으로 아이디, 패스워드를 입력(Scanner)받아 select문으로 
         데이터를 조회하여 로그인 성공 여부를 출력하는 Dao기능메서드를 만드세요.
         
public class A05_MemberDao {
	private Connection con;
	private Statement stmt;
	private ResultSet rs;

	public void insertMember(Member ins) {
		String sql = "INSERT INTO member100 values('" + ins.getId() + "'," + ins.getPassword() + ",'" + ins.getName()
				+ "','" + ins.getAuthority() + "'," + ins.getPoint() + "," + ins.getRegister() + ")";
		System.out.println("등록 sql");
		System.out.println(sql);
		try {
			con = DB.con();
			con.setAutoCommit(false);
			stmt = con.createStatement();
			int cnt = stmt.executeUpdate(sql);
			System.out.println("등록 데이터 : " + cnt);
			con.commit();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("DB 처리: " + e.getMessage());
			try {
				con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				System.out.println("rollback에러: " + e1.getMessage());
			}
		} catch (Exception e) {
			System.out.println("기타 예외: " + e.getMessage());
		} finally {
			DB.close(rs, stmt, con);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 A05_MemberDao dao = new A05_MemberDao();
		 //scanner 비밀번호 입력 , 애초에 출력 오류 
	      dao.insertMember(new Member("buildadoor",,"이윤아","관리자?",16000,"2022/10/14"));
	      
         
 */
	

         
 
	}

}
