package jspexp.a13_database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import jspexp.a13_database.DB;
import jspexp.vo.Emp;
import jspexp.a13_database.Lecture;
import jspexp.a13_database.Student;
import jspexp.a13_database.member_s;

public class A01_schStudent {
	private Connection con;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	// 로그인 시에 해당 교수의 강의목록 조회 메서드
	public List<Lecture> getLecSch(Lecture sch){
		List<Lecture> list = new ArrayList<Lecture>();
		String sql = "SELECT lecNum, lecYear, semester, lecName, sort\r\n"
				+ "	FROM lecture\r\n"
				+ "	WHERE id=?\r\n";
		
		try {
			con = DB.con();
			// 2. 대화
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, sch.getId());
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Lecture e = new Lecture(
							rs.getInt(1),
							rs.getString(2),
							rs.getString(3),
							rs.getString(4),
							rs.getString(5)
						);
				list.add(e);
			}

			
		} catch (SQLException e) {
			System.out.println("DB 에러:"+e.getMessage());
		} catch (Exception e) {
			System.out.println("일반 예외:"+e.getMessage());
		} finally {
			DB.close(rs, pstmt, con);
		}
		return list;
	}	
	
	// 해당 과목을 수강하는 수강생 정보 조회 메서드
	public List<Student> schStu(Student sch){
		List<Student> slist = new ArrayList<Student>();
		String sql = "SELECT s.id, stdName, majorName, stdYear\r\n"
				+ "FROM STUDENT s, MAJOR m, STDLECTURE s2\r\n"
				+ "WHERE s.MAJORNO = m.MAJORNO\r\n"
				+ "AND s.id = s2.id\r\n"
				+ "AND LECNUM=?";
		try {
			con = DB.con();
			// 2. 대화
			
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, sch.getLecNum());
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Student s = new Student(
							rs.getString(1),
							rs.getString(2),
							rs.getString(3),
							rs.getInt(4)
						);
				slist.add(s);
			}
			
		} catch (SQLException e) {
			System.out.println("DB 에러:"+e.getMessage());
		} catch (Exception e) {
			System.out.println("일반 예외:"+e.getMessage());
		} finally {
			DB.close(rs, pstmt, con);
		}
		return slist;
	}
	
	
	
	// 성적 입력/수정 page에 해당 수강생 정보 출력 메서드
	
	public List<Student> schStudent(Student sch){
		List<Student> slist = new ArrayList<Student>();
		String sql = "SELECT s.id, stdName, majorName, attendance, midtest, endtest, total\r\n"
				+ "FROM STUDENT s , MAJOR m, STDLECTURE s2 \r\n"
				+ "WHERE s.MAJORNO = m.MAJORNO\r\n"
				+ "AND s.id = s2.id\r\n"
				+ "AND s.id = ?\r\n"
				+ "AND lecNum = ?";
		try {
			con = DB.con();
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, sch.getId());
			pstmt.setInt(2, sch.getLecNum());
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Student s = new Student(
						rs.getString(1),
						rs.getString(2),
						rs.getString(3),
						rs.getInt(4),
						rs.getInt(5),
						rs.getInt(6),
						rs.getString(7)
						);
				slist.add(s);
			}
			
		} catch (SQLException e) {
			System.out.println("DB 에러:"+e.getMessage());
		} catch (Exception e) {
			System.out.println("일반 예외:"+e.getMessage());
		} finally {
			DB.close(rs, pstmt, con);
		}
		return slist;
	}


	
	// 성적 입력/수정 메서드
	public void udtStuLec(Student udt) {
		String sql = "UPDATE stdLecture\r\n"
				+ "SET attendance = ?,\r\n"
				+ "   midtest = ?,\r\n"
				+ "   endtest = ?,\r\n"
				+ "   total = ?\r\n"
				+ "WHERE id = ?\r\n"
				+ "AND lecNum = ?";
		try {
			con = DB.con();
			con.setAutoCommit(false);
			
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, udt.getAttendance());
			pstmt.setInt(2, udt.getMidtest());
			pstmt.setInt(3, udt.getEndtest());
			pstmt.setString(4, udt.getTotal());
			pstmt.setString(5, udt.getId());
			pstmt.setInt(6, udt.getLecNum());
			pstmt.executeUpdate();
			
			con.commit();
		} catch (SQLException e) {
			System.out.println("DB 관련 예외:"+e.getMessage());
			try {
				con.rollback();
			} catch (SQLException e1) {
				System.out.println("rollback 예외:"+e1.getMessage());
			}
		} catch (Exception e) {
			System.out.println("일반 예외:"+e.getMessage());
		} finally {
			DB.close(rs,pstmt, con);
		}
	}
	
	// 성적 삭제[초기화] 메서드
	public void delGrade(Student del) {
		String sql = "UPDATE stdLecture\r\n"
				+ "SET attendance = 0,\r\n"
				+ "   midtest = 0,\r\n"
				+ "   endtest = 0,\r\n"
				+ "   total = ''\r\n"
				+ "WHERE id = ?\r\n"
				+ "AND lecNum = ?";
		try {
			con = DB.con();
			con.setAutoCommit(false);
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, del.getId());
			pstmt.setInt(2, del.getLecNum());
			pstmt.executeUpdate();
			
			con.commit();
		} catch (SQLException e) {
			System.out.println("DB 관련 예외:"+e.getMessage());
			try {
				con.rollback();
			} catch (SQLException e1) {
				System.out.println("rollback 예외:"+e1.getMessage());
			}
		} catch (Exception e) {
			System.out.println("일반 예외:"+e.getMessage());
		} finally {
			DB.close(rs,pstmt, con);
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
