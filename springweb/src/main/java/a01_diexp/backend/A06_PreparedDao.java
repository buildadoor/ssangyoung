package a01_diexp.backend;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import springweb.z01_vo.Dept;
import springweb.z01_vo.Member;
// jspexp.a13_database.A06_PareparedDao
// getDeptList(Dept sch)
@Repository
public class A06_PreparedDao implements A03_Dao {
   // 전역변수 선언
   private Connection con;
   private PreparedStatement pstmt;
   private ResultSet rs;

   // 조회 처리
   public List<Dept> getDeptList(Dept sch) {
      List<Dept> dlist = new ArrayList<Dept>();
      String sql = "SELECT *\r\n" + "FROM dept100\r\n" + "WHERE dname LIKE '%'|| ? ||'%'\r\n"
            + "AND loc LIKE '%'|| ? ||'%'";
      try {
         con = DB.con();
         pstmt = con.prepareStatement(sql);
         // 위 sql의 ?에 해당하는 문자열을 mapping해서 데이터를 전달
         // 1. 위 형태로 ?로 설정하는 해당 데이터 형태만 입력이 되지,
         // sql injection이 처리되지 않는다.
         // 2. ?로 같은 유형을 sql을 먼저 서버에 전달되기에 한번 컴파일된 이후로는
         // 빠르게 수행될 수 있다.
         // pstmt.setString(1번부터 ?에 해당하는 순서, 데이터 );
         pstmt.setString(1, sch.getDname()); //
         pstmt.setString(2, sch.getLoc());
         rs = pstmt.executeQuery(); // sql를 넣지 않는다.!!(주의)
         // select * ==> deptno, dname, loc
         while (rs.next()) {
            // select에 해당 컬럼에 맞는 컬럼명, 데이터유형에
            // 맞게 rs.get타입("컬럼명") 지정하여야 한다.
            dlist.add(new Dept(rs.getInt("deptno"), rs.getString("dname"), rs.getString("loc")));
         }
         System.out.println("데이터 건수:" + dlist.size());

      } catch (SQLException e) {
         System.out.println("DB에러:" + e.getMessage());
      } catch (Exception e) {
         System.out.println("일반 에러:" + e.getMessage());
      } finally {
         DB.close(rs, pstmt, con);
      }

      return dlist;
   }

   // transaction 에러로 제대로 등록/수정/삭제되지 않을 때.
   // 다시 eclipse 재부팅해서 DB도 확인하고, 다시 실행한다.
   public void insertDept(Dept d) {
      String sql = "INSERT INTO dept100 values(?,?,?)";
      try {
         con = DB.con();
         con.setAutoCommit(false);
         pstmt = con.prepareStatement(sql);
         pstmt.setInt(1, d.getDeptno());
         pstmt.setString(2, d.getDname());
         pstmt.setString(3, d.getLoc());
         System.out.println("등록건수:" + pstmt.executeUpdate());
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

   // 10 ==> 55, 인사, 부산
   public void updateDept(int deptno, Dept upt) {
      String sql = "UPDATE dept100\r\n" + "   SET deptno = ?,\r\n" + "       dname = ?,\r\n" + "       loc = ?\r\n"
            + "   WHERE deptno = ?";
      try {
         con = DB.con();
         con.setAutoCommit(false);
         pstmt = con.prepareStatement(sql);
         pstmt.setInt(1, upt.getDeptno());
         pstmt.setString(2, upt.getDname());
         pstmt.setString(3, upt.getLoc());
         pstmt.setInt(4, deptno);
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

   public void deleteDept(int deptno) {
      String sql = "DELETE FROM dept100\r\n" + "WHERE deptno = ?";
      try {
         con = DB.con();
         con.setAutoCommit(false);
         pstmt = con.prepareStatement(sql);
         pstmt.setInt(1, deptno);
         System.out.println("삭제건수:" + pstmt.executeUpdate());
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

   public List<Member> getMemberList(Member sch) {
      List<Member> list = new ArrayList<Member>();
      String sql = "SELECT *\r\n"
            + "FROM MEMBER\r\n"
            + "WHERE name LIKE '%'||?||'%'\r\n"
            + "AND auth LIKE '%'||?||'%'";
      System.out.println(sql);
      try {
         con = DB.con();
         pstmt = con.prepareStatement(sql);
         pstmt.setString(1, sch.getName());
         pstmt.setString(2, sch.getAuth());
         rs = pstmt.executeQuery(); // sql를 넣지 않는다.!!(주의)
         while (rs.next()) {
            list.add(new Member(rs.getString("id"), 
                           rs.getString("pass"), 
                           rs.getString("name"), 
                           rs.getString("auth"),
                           rs.getInt("point"),
                           rs.getString("address")
                  ));
         }
      } catch (SQLException e) {
         System.out.println("DB에러:" + e.getMessage());
      } catch (Exception e) {
         System.out.println("일반 에러:" + e.getMessage());
      } finally {
         DB.close(rs, pstmt, con);
      }
      return list;
   }

   // transaction 에러로 제대로 등록/수정/삭제되지 않을 때.
   // 다시 eclipse 재부팅해서 DB도 확인하고, 다시 실행한다.
   public void insertMember(Member ins) {
      String sql = "insert into member values(?,?,?,?,?,?)";
      try {
         con = DB.con();
         con.setAutoCommit(false);
         pstmt = con.prepareStatement(sql);
         // values('아이디','패스워드','이름','권한',1000,'주소')
         pstmt.setString(1, ins.getId());
         pstmt.setString(2, ins.getPass());
         pstmt.setString(3, ins.getName());
         pstmt.setString(4, ins.getAuth());
         pstmt.setInt(5, ins.getPoint());
         pstmt.setString(6, ins.getAddress());
         System.out.println("등록건수:" + pstmt.executeUpdate());
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
   public boolean login(String id, String pass) {
      boolean isSuccess = false;
      String sql = "SELECT *\r\n"
            + "FROM MEMBER\r\n"
            + "WHERE id=? and pass=?";
      try {
         con = DB.con();
         pstmt = con.prepareStatement(sql);
         pstmt.setString(1, id);
         pstmt.setString(2, pass);
         rs = pstmt.executeQuery();
         isSuccess = rs.next(); // 해당 id, pass로 조회 될때만 true 그 외는 false
      } catch (SQLException e) {
         System.out.println("DB에러:" + e.getMessage());
      } catch (Exception e) {
         System.out.println("일반 에러:" + e.getMessage());
      } finally {
         DB.close(rs, pstmt, con);
      }
      return isSuccess;
   }

   public boolean deptlogin(int deptno, String dname) {
      boolean isSuccess = false;
      String sql = "SELECT *\r\n"
            + "FROM dept\r\n"
            + "WHERE deptno=? and dname=?";
      try {
         con = DB.con();
         pstmt = con.prepareStatement(sql);
         pstmt.setInt(1, deptno);
         pstmt.setString(2, dname);
         rs = pstmt.executeQuery();
         isSuccess = rs.next(); // 해당 id, pass로 조회 될때만 true 그 외는 false
      } catch (SQLException e) {
         System.out.println("DB에러:" + e.getMessage());
      } catch (Exception e) {
         System.out.println("일반 에러:" + e.getMessage());
      } finally {
         DB.close(rs, pstmt, con);
      }
      return isSuccess;
   }

   // 조회 처리
   public boolean chkDept(int deptno, String dname) {
      boolean hasInfo = false;
      String sql = "SELECT *\r\n" 
            + "FROM dept100\r\n" 
            + "WHERE deptno = ?\r\n"
            + "AND dname = ?";
      try {
         con = DB.con();
         pstmt = con.prepareStatement(sql);
         pstmt.setInt(1, deptno); //
         pstmt.setString(2, dname);
         rs = pstmt.executeQuery(); 
         hasInfo = rs.next(); // 
      } catch (SQLException e) {
         System.out.println("DB에러:" + e.getMessage());
      } catch (Exception e) {
         System.out.println("일반 에러:" + e.getMessage());
      } finally {
         DB.close(rs, pstmt, con);
      }
      return hasInfo;
   }

   public boolean checkId(String id) {
      boolean isSuccess = false;
      String sql = "SELECT *\r\n"
            + "FROM MEMBER\r\n"
            + "WHERE id=?";
      try {
         con = DB.con();
         pstmt = con.prepareStatement(sql);
         pstmt.setString(1, id);
         rs = pstmt.executeQuery();
         isSuccess = rs.next(); // 해당 id, pass로 조회 될때만 true 그 외는 false
      } catch (SQLException e) {
         System.out.println("DB에러:" + e.getMessage());
      } catch (Exception e) {
         System.out.println("일반 에러:" + e.getMessage());
      } finally {
         DB.close(rs, pstmt, con);
      }
      return isSuccess;
   }

   public Member login(Member m) {
      Member mem = null;
      String sql = "SELECT *\r\n"
            + "FROM MEMBER\r\n"
            + "WHERE id=? and pass=?";
      try {
         con = DB.con();
         pstmt = con.prepareStatement(sql);
         pstmt.setString(1, m.getId());
         pstmt.setString(2, m.getPass());
         rs = pstmt.executeQuery();
         if( rs.next()) { // 해당 id, pass로 조회 될때만 true 그 외는 false
            mem = new Member(rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getInt(5),
                        rs.getString(6)
                  );
         }
      } catch (SQLException e) {
         System.out.println("DB에러:" + e.getMessage());
      } catch (Exception e) {
         System.out.println("일반 에러:" + e.getMessage());
      } finally {
         DB.close(rs, pstmt, con);
      }
      return mem;
   }

   public static void main(String[] args) {
      // TODO Auto-generated method stub

      A06_PreparedDao dao = new A06_PreparedDao();

      // 12:15~
      // dao.insertDept(new Dept(11,"총무","부산"));
      // // 10 ==> 55, 인사, 부산
//      dao.updateDept(10, new Dept(55, "인사","부산"));
//      dao.deleteDept(55);
//      for(Dept d: dao.getDeptList(new Dept("",""))) {
//         System.out.print(d.getDeptno()+"\t");
//         System.out.print(d.getDname()+"\t");
//         System.out.print(d.getLoc()+"\n");
//      }
   }
}
// ex) 부서등록 처리(PreparedStatement)