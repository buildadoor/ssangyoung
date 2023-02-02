package javaexp.a13_database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javaexp.a13_database.vo.Dept;
import javaexp.a13_database.vo.Emp;

public class A03_DeptDao {
	//공통 필드 선언
	private Connection con;
	private Statement stmt;
	private ResultSet rs;
	//출력 기능 메서드 
	public void showDeptAll() {
		//연결 객체
		try {	
			con = DB.con();
			//대화 객체
			stmt = con.createStatement();
			String sql = "SELECT * FROM dept";
			//결과 객체
			rs = stmt.executeQuery(sql);
			//while문 처리 - 부서 번호 출력 select * from dept 
			while(rs.next()) { 
				//String s = ""+25; (0) : 문자열로 다 표현하는 건 가능  
				//int number = "홍길동"; (X) 
				//데이터 유형은 가능한한 맞게 처리하여야 한다.
				System.out.print(rs.getInt("deptno")+"\t");
				System.out.print(rs.getString("dname")+"\t");
				System.out.print(rs.getString("loc")+"\n");
		} 
		//자원 해제 : 제일 마지막에 생성 ==> 가장 최초 생성 
		rs.close();// 중간에 에외가 발생해서 자원해제가 안되는 경우.
		stmt.close();
		con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("SQL 처리에러:"+e.getMessage());
		} catch(Exception e) {
			System.out.println("기타 예외 처리:"+e.getMessage());
		} finally { //예외 여부에 상관없이 처리할 내용 
			if(rs!=null) rs = null;
			if(stmt!=null) stmt = null;
			if(con!=null) con = null;
			
		}
		System.out.println("종료!!");
	}
//	select 
//* from dept where dname like '%'||''||''%
// 1. vo만들기-class
// 2. 메서드선언
//		public void deptSch(Emp sch) {
// 3. 연결
// 4. 대화
// 5. 결과 
// 		while()
// }
		public void deptSch(Dept sch) {
			
		try {
			con = DB.con();
//			4. 대화
			String sql = "SELECT *\r\n"
					+ "FROM dept \r\n"
					+ "WHERE dname LIKE '%'||'"+sch.getDname()+"'||'%'\r\n"
					+ "AND loc LIKE '%'||'"+sch.getLoc()+"'||'%'";
			stmt = con.createStatement();
//			5. 결과
			rs = stmt.executeQuery(sql);
				//while문 처리 
			while(rs.next()) {
				System.out.print(rs.getInt("deptno")+"\t");
				System.out.print(rs.getString("dname")+"\t");
				System.out.print(rs.getString("loc")+"\n");
			}
			//	6. 자원해제 - 예외 처리 
				DB.close(rs, stmt, con);
		}	catch(SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("DB처리 예외:"+e.getMessage());
		}	catch(Exception e) {
			System.out.println("기타 예외:"+e.getMessage());
		}
		}
		public void insertDept(Dept ins) {
			String sql = "insert into dept10 values("+ins.getDeptno()+",'"+ins.getDname()+"','"+ins.getLoc()+"')";
			System.out.println(sql);
			try {
				con = DB.con();
				con.setAutoCommit(false);
				stmt = con.createStatement();
				int cnt = stmt.executeUpdate(sql);
				System.out.println("등록건수:"+cnt);
				con.commit();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("DB에러:"+e.getMessage());
				try {
					con.rollback();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					System.out.println("rollback에러:"+e1.getMessage());
				}
			}catch(Exception e) {
				System.out.println("기타에러:"+e.getLocalizedMessage());
			}finally {
				DB.close(rs, stmt, con);
			}
			
		}
		
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		A03_DeptDao dao = new A03_DeptDao();
		dao.insertDept(new Dept(12,"회계","대전"));
	//	dao.showDeptAll();
		dao.deptSch(new Dept("",""));
	}

}
