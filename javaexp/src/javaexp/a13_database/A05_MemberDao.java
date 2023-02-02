package javaexp.a13_database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javaexp.a13_database.vo.Member;


public class A05_MemberDao {
	private Connection con;
	private Statement stmt;
	private ResultSet rs;

	public void membersListAllPrint() {
		try {
			con = DB.con();
			String sql = "SELECT * FROM members";
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()) { //행 단위로 커서변경
				//열단위 컬럼 접근 rs.get 데이터 유형("컬럼명")
				System.out.print(rs.getmnames

			}
			//4) 자원해제 		ex) 전화 끊기 
			DB.close(rs, stmt, con);
		//	rs.close();
		//	stmt.close();
		//	con.close();
			
			//5) SQL예외 처리 상세 및 기타 예외 처리하기 ex) 통신 장애시 처리 방법 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("기타 sql 처리 예외:"+e.getMessage());
		}catch(Exception e) {
			System.out.println("기타 예외:"+e.getMessage());
		}finally {
			if(rs!=null) rs=null;
			if(stmt!=null) stmt=null;
			if(con!=null) con=null;
		}
	}
	//id pw name author pount regis 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 A05_MemberDao dao = new A05_MemberDao();
	      dao.insertMember(new Member("buildadoor",,"이윤아","관리자?",16000,"2022/10/14"));
	      
		// List<Member> list = dao.insertMfember("buildadoor","","이윤아","관리자?",
//				 					16000,"sysdate");
	  
	

}
}