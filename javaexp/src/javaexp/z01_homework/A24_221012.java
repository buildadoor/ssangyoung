package javaexp.z01_homework;

public class A24_221012 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
/*
2022-10-12
[1단계:개념] 1. 데이터베이스의 연결 공통 객체 생성에 필요한 객체들과 정보를 소스를 통해 설명하세요.
   // 필드 선언
   private Connection con;
   private Statement stmt;
   private ResultSet rs;
   // 출력 기능메서드
   public void showDepAll() {
     // 연결객체
      try {
         con = DB.con();
         // 대화객체
         stmt = con.createStatement();
         // 결과객체
         String sql = "SELECT * FROM dept";
         rs = stmt.executeQuery(sql);
         // while문처리 - 부서번호 출력 select * from dept
         while(rs.next()) {
            System.out.print(rs.getInt("deptno")+"\t");
            System.out.print(rs.getString("dname")+"\t");
            System.out.print(rs.getString("loc")+"\n");
         } 
         //자원해제 : 제일 마지막에 생성 ==> 가장 최초 생성
         rs.close();   // 중간에 예외가 발생해서 자원해제가 안되는 경우.
         stmt.close();
         con.close();
      } catch (SQLException e) {
         System.out.println("기타 sql 처리 예외:"+e.getMessage());
      } catch(Exception e) {
         System.out.println("기타 예외 처리:"+e.getMessage());
      }finally { // 예외 여부에 상관없이 처리할 내용
         if(rs!=null) rs = null;
         if(stmt!=null) stmt = null;
         if(con!=null) con = null;
      }
   }
	
[1단계:개념] 2. select문을 통해서 데이터를 가져와서 출력할려고 한다. 객체들간의 연관관계를 기술하세요.
1) sql 만들어 실행
      SELECT * FROM emp01
      WHERE ename LIKE '%'||'A'||'%'
      AND job LIKE '%'||'ER'||'%'
2) sql안에 조건으로 넘길 데이터 유형과 이름 정리
      ename, job
      ==> String ename, String job
3) 기능 메서드에 매개변수 타입 결정
      데이터유형으로 선언 : schEmp(String ename, String job)
      객체로 선언 : - vo 객체를 생성(ename, job 포함)
         schEmp(Emp sch)
4) 문자열 sql에 동적문자열로 선언처리
   - 데이터유형으로 선언
      String sql =    "SELECT * " +
            "FROM emp01" +
            "WHERE ename LIKE '%'||'"+ename+"'||'%'"+
            "AND job LIKE '%'||'"+job+"'||'%'";
   - 객체유형으로 선언
      String sql =    "SELECT * " +
            "FROM emp01" +
            "WHERE ename LIKE '%'||'"+sch.getEname()+"'||'%'"+
            "AND job LIKE '%'||'"+sch.getJob+"'||'%'";

[1단계:코드] 3. 부서별 최고 급여자를 sql를 만들고 이것을 출력하는 기능메서드를 만들고 처리하세요.
package javaexp.z01_homework;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


import javaexp.a13_database.DB;

public class A25_1012 {
   private Connection con;
   private Statement stmt;
   private ResultSet rs;

   public void empListMaxSalPrint() {
     
   
   public static void main(String[] args) {
      // TODO Auto-generated method stub
      A24_1012 dao = new A24_1012();
      dao.empListMaxSalPrint();
   }
}
*/
/*
[1단계:개념] 4. ResultSet 객체의 기능메서드를 기능별로 분류하여 기술하세요.
ResultSet : next() - 행단위로 이동 처리
       getXXXX("컬럼명") - 열단위에 데이터 유형에 맞게 접근
      XXXX
      char/varchar2() ==> String 
      number() ==> int/double
      date ==> Date
      while(rs.next()){ ## 데이터가 마지마행까지 행단위로 이동
         rs.getInt("empno") : 각 행의 empno컬럼의 데이터를 정수형으로 가져옴
         rs.getString("ename")
         rs.getDate("hiredate")
      }
      ==> 자원해제 및 예외처리
         만들어진 단계별 객체 .close() 메모리 해제
         필수예외에 대한 내용을 try{}catch(SQLException e){} 예외 처리
         
[1단계:개념] 5. Dao의 자원해제 순서와 방법을 기술하세요
자원 해제 : 제일 마지막에 생성 ==> 가장 최초 생성 
		만들어진 단계별 객체 .close() 메모리해제 
		rs.close();
		stmt.close();
		con.close();
		또는 
		DB.close(rs, stmt, con);
		필수예외에 대한 내용을 try{}catch(SQLException e){} 예외처리 
		
[1단계:순서] 6. 검색조건에 대한 dao 처리를 위하여 처리되는 순서를 기술하세요.
1. sql 작성
	1) 매개변수로 조건처리할 데이터 확인 
		==> ename, job ==> VO로 ename, job 필드 선언, 객체 
	2) 리턴값으로 리턴 List의 단위 데이터 확인
		String sql = "SELECT *"+
		 				 "FROM emp01"+
						 "WHERE ename LIKE '%'||'"+sch.getEname()+"'||'%'"+
						 "AND job LIKE '%'||'"+sch.getJob()+"'||'%'";
		select * ==> 통해서 나올 데이터를 단위로 객체 선언 
		empno, ename, job, mgr, hiredate, sal , comm, deptno
2. VO 만들기 		
		==> 저장할 수 있는 단위 VO객체 선언 ==> ArrayList<VO>
			생성자로 전체데이터를 가져오는 생성자1
			생성자로 조회조건 가져오는 생성자2 
		class Emp{
			private int empno;
			private String ename;
			private String job;
			private int mgr;
			private Date hiredate;
			private double sal;
			private double comm;
			private int deptno;
		}
		
3. List 메서드 초기에 선언하고, while()를 통해서 객체 하나씩 생성해서 추가하기
	리턴한 기능메서드와 매개변수 처리할 내용 선언
	// Emp sch : 조건으로 처리할 데이터  
	// public List<Emp> : select로 처리할 데이터 리스트화  
	
	public List<Emp> getEmpListSch(Emp sch){
		List<Emp> list = new ArrayList<Enp>();
	
		return list;
	}
4. ResultSet 객체를 통해서 데이터를 가져와서 list에 while문을 통해서 할당
	while(rs.next()){
		list.add(new Emp(rs.getInt("empno"),rs.getString("ename"),....));
	}
	System.out.println("데이터 건수:"+list.size());
5. 호출하는 곳에서 향상된 for문으로 처리
	for(Emp emp:dao.getEmpListSch(new Emp("","")){
		System.out.print(emp.getEmpno());
	}
	List<Emp> list = new 	

	
[1단계:코드] 7. salgrade테이블을 등급별, 급여별 데이터를 검색할려고 한다. Dao에 추가하여 처리하세요.
 
public class A04_SalDao {
	private Connection con;
	private Statement stmt;
	private ResultSet rs;
	public void empListSalGradePrint() {
	     try {
	         con = DB.con();
	         
	         String sql = "SELECT * FROM salgrade";
	         stmt = con.createStatement();
	         
	         rs = stmt.executeQuery(sql);
	         System.out.println("grade\tlosal\thisal");
	         while(rs.next()) {
	            System.out.print(rs.getInt("grade")+"\t");
	            System.out.print(rs.getInt("losal")+"\t");
	            System.out.print(rs.getInt("hisal")+"\n");
	         }
	         
	         DB.close(rs, stmt, con);

	      } catch (SQLException e) {
	         
	         System.out.println("기타 sql 처리 예외:"+e.getMessage());
	      } catch(Exception e) {
	         System.out.println("기타 예외:"+e.getMessage());
	      }finally {
	         if(rs!=null) rs=null;
	         if(stmt!=null) stmt=null;
	         if(con!=null) con=null;
	      }
	   }
	   
	   public static void main(String[] args) {
	      // TODO Auto-generated method stub
	      A04_SalDao dao = new A04_SalDao();
	      dao.empListSalGradePrint();
	   }

	}

[1단계:코드] 8. select deptno, empno, ename, job, sal 
         from emp01 where sal between @@@ and @@#
      를 처리할려고 한다. VO를 만들고 ArrayList<VO>로 리턴한 결과를 처리하세요.


== 평가대비(자바) 객관식 문제 ==
1. 자바에서 데이터베이스 연결에 필요한 객체가 아닌 것은?
1) Connection  2) Statement
3) Result      4) Sql 
정답:4 ==> connection연결 , statement 대화, result는 결과 객체


2. 데이터베이스 처리시 처리할 예외 ?
1) NullPointerException  2) NumberFormatException
3) SQLException      4) 
정답:3 ==> database 서버 접속 객체 - 예외처리(try{}catch(SQLExpption e){})
NumberFormatException - 숫자형 문자열이 아닐때
NullPointerException - 객체 참조가 없는 상태
*/
		
	}

}
