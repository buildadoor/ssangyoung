package javaexp.a13_database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javaexp.a13_database.vo2.EmpHw01;
import javaexp.a13_database.vo2.EmpHw02;

public class A05_HWDao {
	private static A05_HWDao dao;
	private Connection con;
	private Statement stmt;
	private ResultSet rs;

	
	
	//여러가지 sql을 통해 vo ==> 기능메서드 선언.
	//ex) 기능 메서드 선언 : 리턴값, 매개변수, 기본 객체 생성 
	public List<EmpHw01> getSchHw01(String dname, String hireq){
		List<EmpHw01> list = new ArrayList<EmpHw01>();
		String sql = "SELECT ename,DNAME, sal, grade\r\n"
				+ "FROM emp e, SALGRADE s ,DEPT d \r\n"
				+ "WHERE  sal BETWEEN losal AND hisal\r\n"
				+ "AND e.DEPTNO  = d.DEPTNO\r\n"
				+ "AND to_char(hiredate,'q') ='"+1+"'\r\n"
				+ "OR dname ="+"ACCOUNTING";
		// 1.연결 - 복사 O
		try {
			con = DB.con();
		//2. 대화 - 복사 O
			stmt=con.createStatement();
		//3. 결과 - 복사 O
			rs = stmt.executeQuery(sql);
		//4. while 처리 - 이해를 바탕으로 코딩 - 복사X 
			while(rs.next()) { //ename,DNAME, sal, grade
				EmpHw01 e = new EmpHw01(rs.getString("ename"),
										rs.getDouble("sal"),
										rs.getInt("s.grade")); 
						
			list.add(e);
			}
			System.out.println("데이터의 건수:"+list.size());
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("DB 관련 예외:"+e.getMessage());
		} catch (Exception e) {
			System.out.println("일반 예외:"+e.getMessage());
		} finally {
			DB.close(rs, stmt, con);
		}
		
		return list;
	}
	
	public List<EmpHw02> getSch02(EmpHw02 sch){
		List<EmpHw02> list2 = new ArrayList<EmpHw02>();
		String sql = "SELECT  to_char(hiredate,'YY'), count(empno), max(sal)\r\n"
				+ "FROM EMP e \r\n"
				+ "GROUP BY to_char(hiredate,'YY')\r\n"
				+ "HAVING to_char(hiredate,'YY')=81";
	// 1.연결 - 복사 O
			try {
				con = DB.con();
			//2. 대화 - 복사 O
				stmt=con.createStatement();
			//3. 결과 - 복사 O
				rs = stmt.executeQuery(sql);
			//4. while 처리 - 이해를 바탕으로 코딩 - 복사X 
				while(rs.next()) {
					EmpHw02 e = new EmpHw02(rs.getDate("hiredate"),
								rs.getInt("empno"), getDouble("sal"));
					list2.add(e);
				}
				System.out.println("데이터의 건수:"+list2.size());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("DB 관련 예외:"+e.getMessage());
			} catch (Exception e) {
				System.out.println("일반 예외:"+e.getMessage());
			} finally {
				DB.close(rs, stmt, con);
			}
			
			return list2;
		}


	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//A05_HWDaoExp dao = new A05_HWDaoExp(); 
	}}
