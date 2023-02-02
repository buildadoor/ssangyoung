package jspexp.a13_database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jspexp.a13_database.DB;
import jspexp.a13_database.eduSt;

public class eduStDao {

   private Connection con;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	public List<eduSt> getStudentList(eduSt sch) {
		List<eduSt> list = new ArrayList<eduSt>();
		String sql = "SELECT s.Id,stdName,stdYear,enterYear,address"
				+ ",birthday,stdEmail,stdPhone,status,m.majorno,m.majorName\r\n"
				+ "FROM STUDENT s , major m\r\n"
				+ "WHERE s.majorNo = m.majorNo and stdName=?";
		try {
			con = DB.con();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, sch.getStdName()); 
			rs = pstmt.executeQuery(); 
			while (rs.next()) {
				list.add(new eduSt(rs.getString(1), 
									rs.getString(2), 
									rs.getInt(3),
									rs.getInt(4),
									rs.getString(5),
									rs.getDate(6),
									rs.getString(7),
									rs.getString(8),
									rs.getString(9),
									rs.getInt(10),
									rs.getString(11) 
				));
			}
			System.out.println("데이터 건수:" + list.size());
		} catch (SQLException e) {
			System.out.println("DB에러:" + e.getMessage());
		} catch (Exception e) {
			System.out.println("일반 에러:" + e.getMessage());
		} finally {
			DB.close(rs, pstmt, con);
		}
		return list;
	}
	
	public void updateinform(String id, eduSt upt) {
		String sql = "UPDATE student SET address = ?, stdPhone = ?, stdEmail = ? WHERE id = ?;";
		try {
			con = DB.con();
			con.setAutoCommit(false);
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, upt.getAddress());
			pstmt.setString(2, upt.getStdPhone());
			pstmt.setString(3, upt.getStdEmail());
			pstmt.setString(4, id);
			System.out.println("수정건수:" + pstmt.executeUpdate());
			con.commit();
		} catch (SQLException e) {
			System.out.println("DB에러:" + e.getMessage());
			try {
				con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				System.out.println("rollback 에러:" + e1.getMessage());
			}
		} catch (Exception e) {
			System.out.println("일반 에러:" + e.getMessage());
		} finally {
			DB.close(rs, pstmt, con);
		}
	}
}