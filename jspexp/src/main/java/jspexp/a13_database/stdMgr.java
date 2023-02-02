package jspexp.a13_database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jspexp.vo.Lecture01;
import jspexp.vo.Lecture02;
import jspexp.vo.Major;
import jspexp.a13_database.noticeVO;
import jspexp.vo.Tuition;
// jspexp.a13_database.stdMgr
public class stdMgr {
	private Connection con;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	
	public List<Lecture01> checkLecName(Lecture01 sch) {
		List<Lecture01> llist = new ArrayList<Lecture01>();
		String sql ="SELECT lecNum,majorName,class_I,sort,lecName,lecLoc,times,grade FROM "
				+ "lecture l,major m WHERE l.majorNo=m.majorNo AND sort=? AND lecName LIKE '%'||?||'%'";
		try {
			con=DB.con();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,sch.getSort());
			pstmt.setString(2,sch.getLecName());
			rs=pstmt.executeQuery();
			while(rs.next()) {
				llist.add(new Lecture01(rs.getInt("lecNum"),rs.getString("majorName"),rs.getInt("class_I"),rs.getString("sort")
						,rs.getString("lecName"),rs.getString("lecLoc"),rs.getString("times"),rs.getInt("grade")));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch(Exception e) {
			System.out.println("일반 에러:"+e.getMessage());
		}finally {
			DB.close(rs, pstmt, con);
		}
		
		return llist;
	}
	public List<Lecture01> checkLecNum(Lecture01 sch) {
		List<Lecture01> llist = new ArrayList<Lecture01>();
		String sql ="SELECT lecNum,majorName,class_I,sort,lecName,lecLoc,times,grade FROM"
				+ " lecture l,major m WHERE l.majorNo=m.majorNo AND sort=? AND lecNum LIKE '%'||?||'%'";
		try {
			con=DB.con();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,sch.getSort());
			pstmt.setInt(2,sch.getLecNum());
			rs=pstmt.executeQuery();
			while(rs.next()) {
				llist.add(new Lecture01(rs.getInt("lecNum"),rs.getString("majorName"),rs.getInt("class_I"),rs.getString("sort")
						,rs.getString("lecName"),rs.getString("lecLoc"),rs.getString("times"),rs.getInt("grade")));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch(Exception e) {
			System.out.println("일반 에러:"+e.getMessage());
		}finally {
			DB.close(rs, pstmt, con);
		}
		
		return llist;
	}
	public List<Lecture01> checkMajor(Lecture01 sch) {
		List<Lecture01> llist = new ArrayList<Lecture01>();
		String sql ="SELECT lecNum,majorName,class_I,sort,lecName,lecLoc,times,grade from\r\n"
				+ "(SELECT lecNum,majorName,class_I,sort,lecName,lecLoc,times,grade"
				+ " FROM lecture l,major m WHERE l.majorNo=m.majorNo)\r\n"
				+ "WHERE majorName LIKE '%'||?||'%'";
		try {
			con=DB.con();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,sch.getMajorName());
			rs=pstmt.executeQuery();
			while(rs.next()) {
				llist.add(new Lecture01(rs.getInt("lecNum"),rs.getString("majorName"),rs.getInt("class_I"),rs.getString("sort")
						,rs.getString("lecName"),rs.getString("lecLoc"),rs.getString("times"),rs.getInt("grade")));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch(Exception e) {
			System.out.println("일반 에러:"+e.getMessage());
		}finally {
			DB.close(rs, pstmt, con);
		}
		
		return llist;
	}
	public List<Lecture01> checkClass(Lecture01 sch) {
		List<Lecture01> llist = new ArrayList<Lecture01>();
		String sql ="SELECT lecNum,majorName,class_I,sort,lecName,lecLoc,times,grade from\r\n"
				+ "(SELECT lecNum,majorName,class_I,sort,lecName,lecLoc,times,grade "
				+ "FROM lecture l,major m WHERE l.majorNo=m.majorNo)\r\n"
				+ "WHERE class_I=? and majorName LIKE '%'||?||'%'";
		try {
			con=DB.con();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1,sch.getclass_I());
			pstmt.setString(2,sch.getMajorName());
			
			rs=pstmt.executeQuery();
			while(rs.next()) {
				llist.add(new Lecture01(rs.getInt("lecNum"),rs.getString("majorName"),rs.getInt("class_I"),rs.getString("sort")
						,rs.getString("lecName"),rs.getString("lecLoc"),rs.getString("times"),rs.getInt("grade")));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch(Exception e) {
			System.out.println("일반 에러:"+e.getMessage());
		}finally {
			DB.close(rs, pstmt, con);
		}
		
		return llist;
	}
	public List<Major> getMajorList() {
		List<Major> mlist = new ArrayList<Major>();
		String sql ="SELECT majorName from major";
		try {
			con=DB.con();
			pstmt = con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				mlist.add(new Major(rs.getString("majorName")));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch(Exception e) {
			System.out.println("일반 에러:"+e.getMessage());
		}finally {
			DB.close(rs, pstmt, con);
		}
		return mlist;
		
	}
	
	public void insStdLec(String id,int lecNum) {
		String sql = "INSERT INTO stdLecture(id,lecNum) values(?,?)";
		
		try {
			con = DB.con();
			con.setAutoCommit(false);
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,id);
			pstmt.setInt(2,lecNum);
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
	public void delStdLec(String id,int lecNum) {
		String sql = "DELETE from stdlecture WHERE id=? AND lecNum=?";
		
		try {
			con = DB.con();
			con.setAutoCommit(false);
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,id);
			pstmt.setInt(2,lecNum);
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
	public boolean checkDupLec(String id,String lecTimes,int lecNum,String major){
		boolean isSuccess = false;
		String sql="SELECT a.lecNum,a.t01,a.t02,a.majorName from\r\n"
				+ "(SELECT substr(l.times,1,2) t01, concat(substr(l.times,1,1),substr(l.times,3,1)) t02, l.times,sl.id,l.lecNum,m.MAJORNAME  \r\n"
				+ "FROM STDLECTURE sl, LECTURE l, major m, student s\r\n"
				+ "WHERE sl.LECNUM = l.LECNUM AND s.majorNo = m.majorNo  AND l.majorNo = m.MAJORNO AND sl.id=?)a \r\n"
				+ "WHERE a.lecNum=? OR a.t01=substr(?,1,2) \r\n"
				+ "OR a.t02=substr(?,1,2)\r\n"
				+ "OR a.t01=concat(substr(?,1,1),substr(?,3,1))\r\n"
				+ "OR a.t02=concat(substr(?,1,1),substr(?,3,1))\r\n"
				+ "OR a.majorName not LIKE '%'||?||'%'";
		try {
			con=DB.con();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,id);
			pstmt.setInt(2,lecNum);
			pstmt.setString(3,lecTimes);
			pstmt.setString(4,lecTimes);
			pstmt.setString(5,lecTimes);
			pstmt.setString(6,lecTimes);
			pstmt.setString(7,lecTimes);
			pstmt.setString(8,lecTimes);
			pstmt.setString(9,major);
			rs=pstmt.executeQuery();
			isSuccess = rs.next();
			
		}catch (SQLException e) {
			System.out.println("DB에러:"+e.getMessage());
		} catch(Exception e) {
			System.out.println("일반 에러:"+e.getMessage());
		}finally {
			DB.close(rs, pstmt, con);
		}
		return isSuccess;
		
	}
	public boolean checkLec(String id,int lecNum){
		boolean isSuccess = false;
		String sql="SELECT lecNum,id FROM STDLECTURE WHERE lecNum=? AND id=?";
		try {
			con=DB.con();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1,lecNum);
			pstmt.setString(2,id);
			rs=pstmt.executeQuery();
			isSuccess = rs.next();
			
		}catch (SQLException e) {
			System.out.println("DB에러:"+e.getMessage());
		} catch(Exception e) {
			System.out.println("일반 에러:"+e.getMessage());
		}finally {
			DB.close(rs, pstmt, con);
		}
		return isSuccess;
		
	}
	public boolean checkTimes(String id,String lecTimes){
		boolean isSuccess = false;
		String sql="SELECT substr(l.times,1,2), concat(substr(l.times,1,1),substr(l.times,3,1)) FROM STDLECTURE sl, LECTURE l\r\n"
				+ "WHERE sl.LECNUM = l.LECNUM AND sl.id=? AND times LIKE '%'||?||'%'";
		try {
			con=DB.con();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,id);
			pstmt.setString(2,lecTimes);
			rs=pstmt.executeQuery();
			isSuccess = rs.next();
			
		}catch (SQLException e) {
			System.out.println("DB에러:"+e.getMessage());
		} catch(Exception e) {
			System.out.println("일반 에러:"+e.getMessage());
		}finally {
			DB.close(rs, pstmt, con);
		}
		return isSuccess;
		
	}
	public List<Lecture01> getStdLecture(String id) {
		List<Lecture01> llist = new ArrayList<Lecture01>();
		String sql ="SELECT l.lecNum,majorName,class_I,sort,lecName,lecLoc,times,grade FROM\r\n"
				+ "lecture l,major m,STDLECTURE s  "
				+ "WHERE l.majorNo=m.majorNo AND s.LECNUM = l.LECNUM AND s.id=?";
		try {
			con=DB.con();
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1,id);
			
			rs=pstmt.executeQuery();
			while(rs.next()) {
				llist.add(new Lecture01(rs.getInt("lecNum"),rs.getString("majorName"),
						rs.getInt("class_I"),rs.getString("sort")
						,rs.getString("lecName"),rs.getString("lecLoc"),
						rs.getString("times"),rs.getInt("grade")));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch(Exception e) {
			System.out.println("일반 에러:"+e.getMessage());
		}finally {
			DB.close(rs, pstmt, con);
		}
		
		return llist;
	}
	public List<Lecture02> getTimes(String id) {
		List<Lecture02> llist = new ArrayList<Lecture02>();
		String sql ="SELECT times,l.LECNAME FROM lecture l,STDLECTURE s WHERE l.lecNum=s.lecNum AND s.id=?";
		try {
			con=DB.con();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,id);	
			rs=pstmt.executeQuery();
			while(rs.next()) {
				llist.add(new Lecture02(rs.getString("times"),rs.getString("lecName")));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch(Exception e) {
			System.out.println("일반 에러:"+e.getMessage());
		}finally {
			DB.close(rs, pstmt, con);
		}
		return llist;
	
	}

	public List<Tuition> getFileName(String id) {
		List<Tuition> tlist = new ArrayList<Tuition>();
		String sql ="SELECT fileName FROM tuition WHERE id=?";
		try {
			con=DB.con();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,id);	
			rs=pstmt.executeQuery();
			while(rs.next()) {
				tlist.add(new Tuition(rs.getString("fileName")));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch(Exception e) {
			System.out.println("일반 에러:"+e.getMessage());
		}finally {
			DB.close(rs, pstmt, con);
		}
		return tlist;
	
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		stdMgr dao = new stdMgr();
		
//		for(Notice n:dao.checkTitle(new Notice("학사"))) {
//			System.out.println(n.getNo()+","+n.getTitle());
//		}
//		for(Notice n:dao.checkContents(new Notice("재입학"))) {
//			System.out.println(n.getNo()+","+n.getTitle());
//		}
//		for(Lecture l : dao.checkLecNum(new Lecture("전공",1))){
//			System.out.println(l.getLecNum());
//		}
//		for(Lecture l : dao.checkLecName(new Lecture("전공","3"))){
//			System.out.println(l.getLecName());
//		}
//		for(Lecture l : dao.checkMajor(new Lecture("바이오"))){
//			System.out.println(l.getMajorName());
//		}
//		for(Lecture l : dao.checkClass(new Lecture(1,"농"))){
//			System.out.println(l.getMajorName()+","+l.getclass_I());
//		}
//		for(Major m : dao.getMajorList()){
//			System.out.println(m.getMajorName());
//		}
		//dao.insStdLec(new StdLecture("20193000",102));
		//System.out.println(dao.checkLec("20193000",102));
		//dao.insStdLec("20193000",951);
		//System.out.println(dao.checkTimes("20193000","수1/2"));
		// 
//		
		for(Lecture02 l : dao.getTimes("20191000")){
			System.out.println(l.getTimes());
			System.out.println(l.getLecName());
		}
		for(Tuition t : dao.getFileName("20191000")){
			System.out.println(t.getFileName());
		
		}
//		
		dao.getTimes("20191000");
		//dao.delStdLec("20193000", 951);
		//System.out.println(dao.checkDupLec("20191000","수89",123));
		
	}

}
