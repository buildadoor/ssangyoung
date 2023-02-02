package javaexp.a13_database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javaexp.a13_database.vo.Dept;
import javaexp.a13_database.vo.EmpQua;

public class A06_PreparedDao {
	// 전역변수 선언 
	private Connection con;
	private PreparedStatement pstmt;
	private ResultSet rs;
	// 조회 처리 
	public List<Dept> getDeptList(Dept sch){
		List<Dept> dlist = new ArrayList<Dept>();
		String sql = "SELECT * \r\n"
				+ "FROM books\r\n"
				+ "WHERE bname LIKE '%'||'?'||'%'";
		try {
			con = DB.con();
			pstmt = con.prepareStatement(sql); //중요 앞에 먼저 sql넘겨주기
			// 위 sql의 ?에 해당하는 문자열을 mapping해서 데이터를 전달 
			//1. 위 형태로 ?로 설정하는 해당 데이터 형태만 입력이 되지,
			// sql injection이 처리되지 않는다. 
			//2. ?로 같은 유형을 sql을 먼저 서버에 전달되기에 한번 컴파일된 이후로는
			// 	빠르게 수행될 수 있다. 
			//pstmt.setString(1번부터 ?에 해당하는 순서, 데이터);
			pstmt.setString(1, sch.getDname());//
			pstmt.setString(2, sch.getLoc());
			rs = pstmt.executeQuery(); //sql을 넣지 않는다. 
			while(rs.next()) {
				dlist.add(new Dept(rs.getInt("deptno"),
									rs.getString("dname"),
									rs.getString("loc"))
						);
			}
			System.out.println("데이터 건수:"+dlist.size());
			
		} catch (SQLException e) {
			System.out.println("DB에러:"+e.getMessage());
		} catch(Exception e) {
			System.out.println("일반에러:"+e.getMessage());
		}finally {
			DB.close(rs, pstmt, con);
		}
		
		return dlist;
	}
	// 등록
	//transaction 에러로 제대로 등록/수정/삭제 되지 않을때,
	//다시 eclipse재부팅해서 DB확인도 하고 다시 실행한다.
	public void insertDept(Dept d) {
		String sql = "INSERT INTO dept100 values(?,?,?)";
		try {
			con = DB.con();
			con.setAutoCommit(false);
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, d.getDeptno());
			pstmt.setString(2, d.getDname());
			pstmt.setString(3, d.getLoc());
			System.out.println("등록건수:"+pstmt.executeUpdate());
			con.commit();
		} catch (SQLException e) {
			System.out.println("DB에러:"+e.getMessage());
			try {
				con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				System.out.println("rollback 에러:"+e.getMessage());
			}
		} catch(Exception e) {
			System.out.println("일반에러:"+e.getMessage());
		}finally {
			DB.close(rs, pstmt, con);
		}
	}
	


	// update - 10 ==> 55 , 인사, 부산 
	//주의하기 deptno까지 바꾸기 때문 
	public void updateDept(int deptno,Dept upt) {
		String sql = "UPDATE DEPT100 \r\n"
				+ "	SET deptno = ?, \r\n"
				+ "		dname = ?,\r\n"
				+ "		loc = ?\r\n"
				+ "	WHERE deptno = ?";
		try {
			con = DB.con();
			con.setAutoCommit(false);
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, upt.getDeptno());
			pstmt.setString(2, upt.getDname());
			pstmt.setString(3, upt.getLoc());
			pstmt.setInt(4, deptno);
			System.out.println("수정건수:"+pstmt.executeUpdate());
			con.commit();
		} catch (SQLException e) {
			System.out.println("DB에러:"+e.getMessage());
			try {
				con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				System.out.println("rollback 에러:"+e.getMessage());
			}
		} catch(Exception e) {
			System.out.println("일반에러:"+e.getMessage());
		}finally {
			DB.close(rs, pstmt, con);
		}
	}
	// 삭제 
	public void deleteDept(int deptno) {
		String sql = "DELETE FROM dept100\r\n"
				+ "WHERE deptno =?";
		try {
			con = DB.con();
			con.setAutoCommit(false);
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, deptno);
			System.out.println("삭제건수:"+pstmt.executeUpdate());
			con.commit();
		} catch (SQLException e) {
			System.out.println("DB에러:"+e.getMessage());
			try {
				con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				System.out.println("rollback 에러:"+e.getMessage());
			}
		} catch(Exception e) {
			System.out.println("일반에러:"+e.getMessage());
		}finally {
			DB.close(rs, pstmt, con);
		}
	}
	// 조회 처리 
	public List<EmpQua> getEmpQuaList(EmpQua sch){
		List<EmpQua> dlist = new ArrayList<EmpQua>();
		String sql = "SELECT empno, ename, qm.qu||'/4' qu, sal \r\n"
				+ "FROM emp e, (\r\n"
				+ "	SELECT to_char(hiredate, 'Q') qu, max(sal) msal\r\n"
				+ "	FROM emp \r\n"
				+ "	GROUP BY to_char(hiredate,'Q')\r\n"
				+ ") qm\r\n"
				+ "WHERE to_char(e.hiredate,'Q') = qu\r\n"
				+ "AND sal = msal\r\n"
				+ "AND sal BETWEEN ? AND ?";
		if(sch.getQu()!=null)
			/*
			 #동적 sql
			 1. sql구문이 데이터에 따라, 조건에 따라 변경되는 것을 말한다.
			 2. 데이터는 가능한한 ?으로 처리하고 preparedStatement에 처리한다.
			 3. 조건문에 따른 내용은 sql 조건도 처리하고
			 	select *
			 	from emp
			 	where 1=1
			 	if(sch.getEname()!=null){
			 		and ename like '%'||?||'%'
			 	}
			 	if(sch.getJob()!=null){
			 		and job like '%'||?||'%'
			 	}
			 	if(sch.getEname()!=null) pstmt.setString(1,...) ==> 고정적으로 할 수 없어서 
			 	if(sch.getJob()!=null) pstmt.setString(2,...)		변수를 사용하게 된다. 
			 	
			 4. pstmt부분도 조건처리하여야한다.
			 5. 특히, 동적 sql이 복잡해질 때는 순서 index부분도 변수를 선언하여 처리하여야한다.
			 	int cnt = 0; 
			 	if(sch.getXXX()!=null) pstmt.setString(++cnt,...)
			 	if(sch.getXXX()!=null) pstmt.setString(++cnt,...)
			 	if(sch.getXXX()!=null) pstmt.setString(++cnt,...)
			 * */
			sql	+= "AND qu =?\r\n";
				
		System.out.println(sql);
		try {
			con = DB.con();
			pstmt = con.prepareStatement(sql); //중요 앞에 먼저 sql넘겨주기
			// 위 sql의 ?에 해당하는 문자열을 mapping해서 데이터를 전달 
			//1. 위 형태로 ?로 설정하는 해당 데이터 형태만 입력이 되지,
			// sql injection이 처리되지 않는다. 
			//2. ?로 같은 유형을 sql을 먼저 서버에 전달되기에 한번 컴파일된 이후로는
			// 	빠르게 수행될 수 있다. 
			//pstmt.setString(1번부터 ?에 해당하는 순서, 데이터);
			pstmt.setDouble(1, sch.getFrSal());//
			pstmt.setDouble(2, sch.getToSal());
			if(sch.getQu()!=null) {
				pstmt.setString(3, sch.getQu());
				
			}
			rs = pstmt.executeQuery(); //sql을 넣지 않는다. 
			while(rs.next()) {
				//select * ==> deptno, dname, loc
				dlist.add(new EmpQua(
						//select에 해당하는 컬럼에 맞는 컬럼명, 데이터 유형에
						//맞게 rs.get타입("컬럼명")처리해야한다 
						rs.getInt("empno"),
						rs.getString("ename"),
						rs.getString("qu"),
						rs.getDouble("sal")
						)
						);
			}
			System.out.println("데이터 건수:"+dlist.size());
			
		} catch (SQLException e) {
			System.out.println("DB에러:"+e.getMessage());
		} catch(Exception e) {
			System.out.println("일반에러:"+e.getMessage());
		}finally {
			DB.close(rs, pstmt, con);
		}
		
		return dlist;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		A06_PreparedDao dao = new A06_PreparedDao();
		for(EmpQua eq:dao.getEmpQuaList(new EmpQua("3", 1000,5000))) {
			System.out.print(eq.getEmpno()+"\t");
			System.out.print(eq.getEname()+"\t");
			System.out.print(eq.getQu()+"\t");
			System.out.print(eq.getSal()+"\n");
		}
		//dao.insertDept(new Dept(11,"총무","부산"));
		//10 ==> 55 , 인사, 부산
		//dao.updateDept(10, new Dept(55,"인사","부산"));
//		dao.deleteDept(55);
//		for(Dept d: dao.getDeptList(new Dept("",""))) {
//			System.out.print(d.getDeptno()+"\t");
//			System.out.print(d.getDname()+"\t");
//			System.out.print(d.getLoc()+"\n");
		}
		//List<Dept> DeptList = dao.getDeptList(new Dept("인사","인천"));
	}


//ex) 부서등록 처리 
