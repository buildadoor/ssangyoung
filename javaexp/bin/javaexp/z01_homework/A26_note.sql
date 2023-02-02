create table salgrade1000
as select * from SALGRADE;
SELECT * FROM salgrade1000;

ALTER TABLE salgrade1000
		modify(
			losal number,
			hisal number
		);
	--public void insert(Salgrade ins){	
		
----member100(아이디, 패스워드, 이름, 권한, 포인트, 등록일) 만들고, 데이
--고, 데이터를 등록 후, 조회하는 메서드를 선언 및 출력하세요.
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
  class Person{
	private String name;
	private int age;
	private String loc;
}


      
CREATE TABLE empdept100
AS SELECT dname, loc, e.* FROM emp e, dept d
WHERE e.DEPTNO = d.DEPTNO ;
public void insert(Empdept ins){	
		}

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
	
	public List<Salgrade> getSalSch(Emp sch){
		List<Emp> list = new ArrayList<Emp>();
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

	