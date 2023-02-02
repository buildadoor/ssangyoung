package jspexp.a13_database;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jspexp.vo.Dept;
import jspexp.vo.Member;


public class eduDao {
	// 전역변수 선언
	private Connection con;
	private PreparedStatement pstmt;
	private ResultSet rs;
	public void insertLecture(lectureVO in) {
		String sql = "INSERT INTO lecture values(?,?,?,?,?,?,?,?,?,?,?,?)";
		try {
			con = DB.con();
			con.setAutoCommit(false);
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, in.getLecNum());
			pstmt.setString(2, in.getLecName());
			pstmt.setString(3, in.getLecLoc());
			pstmt.setString(4, in.getLecPlan());
			pstmt.setString(5, in.getLecYear());
			pstmt.setString(6, in.getSemester());
			pstmt.setInt(7, in.getGrade());
			pstmt.setInt(8, in.getMajorNo());
			pstmt.setString(9, in.getTimes());
			pstmt.setString(10, in.getSort());
			pstmt.setString(11, in.getId());
			pstmt.setInt(12, in.getClass_I());
			System.out.println("등록건수:"+pstmt.executeUpdate());
			con.commit();
		} catch (SQLException e) {
			System.out.println("DB에러:"+e.getMessage());
			try {
				con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				System.out.println("rollback 에러:"+e1.getMessage());
			}
		} catch(Exception e) {
			System.out.println("일반 에러:"+e.getMessage());
		}finally {
			DB.close(rs, pstmt, con);
		}
	}
	public void updatelecture(int lecNum,lectureVO upt) {
		String sql = "UPDATE lecture\r\n"
				+ "   SET LECNUM = ?,\r\n"
				+ "       LECNAME = ?,\r\n"
				+ "       LECLOC = ?,\r\n"
				+ "       LECYEAR = ?,\r\n"
				+ "       SEMESTER = ?,\r\n"
				+ "       GRADE = ?,\r\n"
				+ "       MajorNo = ?,\r\n"
				+ "       TIMES = ?,\r\n"
				+ "       SORT = ?\r\n"
				+ "   WHERE LECNUM = ?";
		try {
			con = DB.con();
			con.setAutoCommit(false);
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, upt.getLecNum());
			pstmt.setString(2, upt.getLecName());
			pstmt.setString(3, upt.getLecLoc());
			pstmt.setString(4, upt.getLecYear());
			pstmt.setString(5, upt.getSemester());
			pstmt.setInt(6, upt.getGrade());
			pstmt.setInt(7, upt.getMajorNo());
			pstmt.setString(8, upt.getTimes());
			pstmt.setString(9, upt.getSort());
			pstmt.setInt(10, lecNum);
			System.out.println("수정건수:"+pstmt.executeUpdate());
			con.commit();
		} catch (SQLException e) {
			System.out.println("DB에러:"+e.getMessage());
			try {
				con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				System.out.println("rollback 에러:"+e1.getMessage());
			}
		} catch(Exception e) {
			System.out.println("일반 에러:"+e.getMessage());
		}finally {
			DB.close(rs, pstmt, con);
		}
	}
	public void updatelecPlan(String lecName, String lecPlan) {
		//int Update = 0;
		String sql = "UPDATE lecture\r\n"
				+ "   SET LECPLAN = ?\r\n"
				+ "   WHERE LECNAME = ?";
		try {
			con = DB.con();
			con.setAutoCommit(false);
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, lecPlan);
			pstmt.setString(2, lecName);
			System.out.println("수정건수:"+pstmt.executeUpdate());
			con.commit();
		} catch (SQLException e) {
			System.out.println("DB에러:"+e.getMessage());
			try {
				con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				System.out.println("rollback 에러:"+e1.getMessage());
			}
		} catch(Exception e) {
			System.out.println("일반 에러:"+e.getMessage());
		}finally {
			DB.close(rs, pstmt, con);
		}
	}
	public void deletelec(int lecNum, String lecName,lectureVO del) {
		String sql = "DELETE FROM lecture WHERE LECNUM  = ? AND LECNAME = ?";
		try {
			con = DB.con();
			con.setAutoCommit(false);
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, lecNum);
			pstmt.setString(2, lecName);
			System.out.println("삭제건수:"+pstmt.executeUpdate());
			con.commit();
		} catch (SQLException e) {
			System.out.println("DB에러:"+e.getMessage());
			try {
				con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				System.out.println("rollback 에러:"+e1.getMessage());	
			}
		} catch(Exception e) {
			System.out.println("일반 에러:"+e.getMessage());
		}finally {
			DB.close(rs, pstmt, con);
		}
	}
	
	public void updateAt(int attendance, String id, int lecNum) {
		String sql = "UPDATE STDLECTURE SET ATTENDANCE = ? WHERE id = ? AND lecnum = ?";
		try {
			con = DB.con();
			con.setAutoCommit(false);
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, attendance);
			pstmt.setString(2, id);
			pstmt.setInt(3, lecNum);
			System.out.println("수정건수:"+pstmt.executeUpdate());
			con.commit();
		} catch (SQLException e) {
			System.out.println("DB에러:"+e.getMessage());
			try {
				con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				System.out.println("rollback 에러:"+e1.getMessage());
			}
		} catch(Exception e) {
			System.out.println("일반 에러:"+e.getMessage());
		}finally {
			DB.close(rs, pstmt, con);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		eduDao dao = new eduDao();

	}
}

