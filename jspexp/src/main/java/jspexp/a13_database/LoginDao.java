package jspexp.a13_database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class LoginDao {
	private PreparedStatement pstmt;
	private Connection con;
	private Statement stmt;
	private ResultSet rs;
	static LoginDao login = new LoginDao();
	static Scanner sc = new Scanner(System.in);
	static String scanid, scanpassword;
	public static int checkdiv;

	
	public boolean login (String id, String password){
		   boolean isSuccess = false;
	      String sql = "SELECT 1 \r\n"
	      		+ "FROM kurlyuser\r\n"
	      		+ "WHERE id=? and password=?";
	      try {
	         con = DB.con();
	         pstmt = con.prepareStatement(sql);
	         pstmt.setString(1, id);
	         pstmt.setString(2, password);
	         rs = pstmt.executeQuery();
	         isSuccess = rs.next(); //해당 id,pass로 조회될때만 true 그 외는 false
	         
	      } catch (SQLException e) {
	         System.out.println("DB에러:"+e.getMessage());
	      } catch(Exception e) {
	         System.out.println("일반 에러:"+e.getMessage());
	      }finally {
	         DB.close(rs, pstmt, con);
	      }
	      
	      return isSuccess;
	   }
	   public boolean checkId (String id){
		   boolean isSuccess = false;
	      String sql = "SELECT 1 FROM KURLYUSER WHERE id=?";
	      try {
	         con = DB.con();
	         pstmt = con.prepareStatement(sql);
	         pstmt.setString(1, id);
	         rs = pstmt.executeQuery();
	         isSuccess = rs.next(); //해당 id,pass로 조회될때만 true 그 외는 false
	         
	      } catch (SQLException e) {
	         System.out.println("DB에러:"+e.getMessage());
	      } catch(Exception e) {
	         System.out.println("일반 에러:"+e.getMessage());
	      }finally {
	         DB.close(rs, pstmt, con);
	      }
	      
	      return isSuccess;
	   }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LoginDao dao = new LoginDao();	
		System.out.println("이전 페이지로 돌아갑니다.");
	}
}
