package jspexp.a13_database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jspexp.vo.Grade;
import jspexp.vo.Lecture01;
import jspexp.vo.Student01;

public class UniversityDao {

	private Connection con;
	private PreparedStatement pstmt;
	private ResultSet rs;

	// 학적정보조회
	public List<Student01> schStdInform(String id) {
		List<Student01> list = new ArrayList<Student01>();
		String sql = "SELECT s.Id,stdName,stdYear,enterYear,address"
				+ ",birthday,stdEmail,stdPhone,status,m.majorno,m.majorName\r\n" + "FROM STUDENT s , major m\r\n"
				+ "WHERE s.majorNo = m.majorNo and id=?";
		try {
			con = DB.con();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				list.add(new Student01(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getString(5),
						rs.getDate(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getInt(10),
						rs.getString(11)));
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

	// 학적정보변경
	public int uptInform(Student01 upt) {
		int cnt = 0;
		String sql = "UPDATE student SET address = ?, stdPhone = ?, stdEmail = ? WHERE id = ?";
		try {
			con = DB.con();
			con.setAutoCommit(false);
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, upt.getAddress());
			pstmt.setString(2, upt.getStdPhone());
			pstmt.setString(3, upt.getStdEmail());
			pstmt.setString(4, upt.getId());
			cnt = pstmt.executeUpdate();
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
		return cnt;
	}

	// 비밀번호변경
	public int uptPw(String id, String curpass, String newpass) {
		int rows = 0;
		String sql = "UPDATE member_s SET password = ? WHERE id = ? and password = ?";
		try {
			con = DB.con();
			con.setAutoCommit(false);
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, newpass);
			pstmt.setString(2, id);
			pstmt.setString(3, curpass);
			rows = pstmt.executeUpdate();
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
		return rows;
	}

	// 강의계획서조회
	public List<Lecture01> schLecPlan(Lecture01 sch) {
		List<Lecture01> list = new ArrayList<Lecture01>();
		String sql = "SELECT lecNum,lecName,lecLoc,times,grade,lecPlan\r\n" + "FROM lecture\r\n"
				+ "WHERE lecName LIKE '%'|| ? ||'%'";
		try {
			con = DB.con();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, sch.getLecName());
			rs = pstmt.executeQuery();
			while (rs.next()) {
				list.add(new Lecture01(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5),
						rs.getString(6)));
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

	// 성적조회
	public List<Grade> schGrade(String id, Grade sch) {
		List<Grade> list = new ArrayList<Grade>();
		String sql = "SELECT l.LECNUM , LECNAME , SORT ,GRADE ,s.MIDTEST ,s.ENDTEST ,s.ATTENDANCE ,s.TOTAL \r\n"
				+ "FROM LECTURE l ,STDLECTURE s  \r\n" + "WHERE l.LECNUM = s.LECNUM \r\n"
				+ "AND LECYEAR LIKE '%'|| ? ||'%' AND SEMESTER LIKE '%'|| ? ||'%' and s.id=?";
		try {
			con = DB.con();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, sch.getLecYear());
			pstmt.setString(2, sch.getSemester());
			pstmt.setString(3, id);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				list.add(new Grade(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5),
						rs.getInt(6), rs.getInt(7), rs.getString(8)));
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

	// 강의평가조회
	public List<Lecture01> schLecEval(String id) {
		List<Lecture01> list = new ArrayList<Lecture01>();
		String sql = "SELECT l.LECNUM , LECNAME , GRADE , SORT , s.LECEVAL, s.ID \r\n"
				+ "FROM LECTURE l , STDLECTURE s ,STUDENT s2\r\n" + "WHERE l.LECNUM = s.LECNUM\r\n"
				+ "AND s.ID = s2.ID AND s.LECEVAL IS NULL\r\n" + "AND s2.id=?";
		try {
			con = DB.con();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				list.add(new Lecture01(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getString(5),
						rs.getString(6)));
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

	// 강의평가등록
	public void uptlecEval(String id, int lecNum, String lecEval) {
		String sql = "UPDATE STDLECTURE SET LECEVAL =? WHERE id =? and lecNum =?";
		try {
			con = DB.con();
			con.setAutoCommit(false);
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, lecEval);
			pstmt.setString(2, id);
			pstmt.setInt(3, lecNum);
			pstmt.executeUpdate();
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

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UniversityDao dao = new UniversityDao();
		dao.uptInform(new Student01("서울","010","000","20219009"));
		
	}
}