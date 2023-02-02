package jspexp.a13_database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jspexp.vo.Member;


public class a05_MemberDao {
	// 전역변수 선언
	private Connection con;
	private PreparedStatement pstmt;
	private ResultSet rs;
	// 조회 처리
	public List<Member> getMemberSch(Member mem){
		List<Member> mlist = new ArrayList<Member>();
		String sql = "SELECT * FROM MEMBER";
		try {
			con = DB.con();
			pstmt = con.prepareStatement(sql);
			// 위 sql의 ?에 해당하는 문자열을 mapping해서 데이터를 전달
			// 1. 위 형태로 ?로 설정하는 해당 데이터 형태만 입력이 되지,
			// sql injection이 처리되지 않는다.
			// 2. ?로 같은 유형을 sql을 먼저 서버에 전달되기에 한번 컴파일된 이후로는
			//    빠르게 수행될 수 있다.
			// pstmt.setString(1번부터 ?에 해당하는 순서, 데이터 );
			pstmt.setString(1, mem.getId());
			pstmt.setString(2, mem.getPass());
			pstmt.setString(3, mem.getName());
			pstmt.setString(4, mem.getAuth());
			pstmt.setInt(5, mem.getPoint());
			pstmt.setString(6, mem.getAddress());
			rs = pstmt.executeQuery(); // sql를 넣지 않는다.!!(주의)
			// select * ==> deptno, dname, loc
			while(rs.next()) {
				// select에 해당 컬럼에 맞는 컬럼명, 데이터유형에
				// 맞게 rs.get타입("컬럼명") 지정하여야 한다.
				mlist.add(new Member(rs.getString("id"),
								   rs.getString("pass"),
								   rs.getString("name"),
								   rs.getString("auth"),
								   rs.getInt("point"),
								   rs.getString("address") )
						 );
			}
			System.out.println("데이터 건수:"+mlist.size());
			
		} catch (SQLException e) {
			System.out.println("DB에러:"+e.getMessage());
		} catch(Exception e) {
			System.out.println("일반 에러:"+e.getMessage());
		}finally {
			DB.close(rs, pstmt, con);
		}
		
		return mlist;
	}
	// transaction 에러로 제대로 등록/수정/삭제되지 않을 때.
	// 다시 eclipse 재부팅해서 DB도 확인하고, 다시 실행한다.
	public void insertMember(Member m) {
		String sql = "INSERT INTO Member values(?,?,?,?,?,?)";
		try {
			con = DB.con();
			con.setAutoCommit(false);
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, m.getDeptno());
			pstmt.setString(2, m.getDname());
			pstmt.setString(3, m.getLoc());
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
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		a05_MemberDao dao = new a05_MemberDao();

		// 12:15~
		//dao.insertDept(new Dept(11,"총무","부산"));
		// // 10 ==> 55, 인사, 부산
//		dao.updateDept(10, new Dept(55, "인사","부산"));
//		dao.deleteDept(55);
//		for(Dept d: dao.getDeptList(new Dept("",""))) {
//			System.out.print(d.getDeptno()+"\t");
//			System.out.print(d.getDname()+"\t");
//			System.out.print(d.getLoc()+"\n");
//		}
	}
}
// ex) 부서등록 처리(PreparedStatement)

