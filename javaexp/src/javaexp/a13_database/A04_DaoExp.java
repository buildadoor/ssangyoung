package javaexp.a13_database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javaexp.a13_database.vo.Dept;
import javaexp.a13_database.vo.Emp;
import javaexp.a13_database.vo2.Emp01;
import javaexp.a13_database.vo2.Emp02;
import javaexp.a13_database.vo2.Emp03;
import javaexp.a13_database.vo2.Emp04;
import javaexp.a13_database.vo2.Emp05;
import javaexp.a13_database.vo.Person;


public class A04_DaoExp {
   
   private Connection con;
   private Statement stmt;
   private ResultSet rs;
   // 여러가지 sql을 통해 vo ==> 기능메서드 선언.
   // ex) 기능 메서드 선언 : 리턴값, 매개변수, 기본 객체 생성
   public List<Emp01> getSch01(int deptno) {
      List<Emp01> list = new ArrayList<Emp01>();
      String sql = "SELECT deptno, ename, job, sal\r\n"
            + "FROM emp \r\n"
            + "WHERE deptno = "+deptno;
      // 1. 연결
      try {
         con = DB.con();
         // 2. 대화
         stmt = con.createStatement();
         // 3. 결과
         rs = stmt.executeQuery(sql);
         // 4. while 처리 - 이해를 바탕으로 코딩
         while(rs.next()) {
            Emp01 e = new Emp01(rs.getInt("deptno"), 
                             rs.getString("ename"),
                             rs.getString("job"),
                             rs.getDouble("sal"));
            list.add(e);
         }
         System.out.println("데이터의 건수: "+list.size());
         
      } catch (SQLException e) {
         // TODO Auto-generated catch block
         System.out.println("DB 관련 예외: "+e.getMessage());
      } catch (Exception e) {
         System.out.println("일반 예외: "+e.getMessage());
      } finally {
         DB.close(rs, stmt, con);
      }
      
      return list;
   }
   
   public List<Emp02> getSch02(Emp02 sch) {
      List<Emp02> list = new ArrayList<Emp02>();
      String sql = "SELECT empno, ename, sal \r\n"
            + "FROM emp \r\n"
            + "WHERE ename LIKE '%' || '"+sch.getEname()+"' || '%' \r\n"
            + "AND sal BETWEEN "+sch.getFrSal()+" AND "+sch.getToSal();
      // 1. 연결
      try {
         con = DB.con();
         // 2. 대화
         stmt = con.createStatement();
         // 3. 결과
         rs = stmt.executeQuery(sql);
         // 4. while 처리 - 이해를 바탕으로 코딩
         //      while문과 resultSet 처리
         while(rs.next()) {
            Emp02 e = new Emp02(rs.getInt(1), 
                    rs.getString(2),
                    rs.getDouble("sal"));
            list.add(e);
         }

         System.out.println("데이터의 건수: "+list.size());
               
      } catch (SQLException e) {
         // TODO Auto-generated catch block
         System.out.println("DB 관련 예외: "+e.getMessage());
      } catch (Exception e) {
         System.out.println("일반 예외: "+e.getMessage());
      } finally {
         DB.close(rs, stmt, con);
      }
      return list;
   }
   
   public List<Emp03> getSch03(Emp03 sch) {
      List<Emp03> list = new ArrayList<Emp03>();
      String sql = "SELECT empno, ename, job, deptno \r\n"
            + "FROM emp \r\n"
            + "WHERE job LIKE '%' || '"+sch.getJob()+"' || '%' \r\n"
            + "OR deptno = "+sch.getDeptno();
      // 1. 연결
      try {
         con = DB.con();
         // 2. 대화
         stmt = con.createStatement();
         // 3. 결과
         rs = stmt.executeQuery(sql);
         // 4. while 처리 - 이해를 바탕으로 코딩
         //      while문과 resultSet 처리
         while(rs.next()) {
            list.add(
                  new Emp03(rs.getInt(1), 
                          rs.getString(2),
                          rs.getString(3),
                          rs.getInt(4)
                  )
            );
         }

      System.out.println("데이터의 건수: "+list.size());
                     
      } catch (SQLException e) {
         // TODO Auto-generated catch block
         System.out.println("DB 관련 예외: "+e.getMessage());
      } catch (Exception e) {
         System.out.println("일반 예외: "+e.getMessage());
      } finally {
         DB.close(rs, stmt, con);
      }
      return list;
   }
   
   public List<Emp04> getSch04(Emp04 sch) {
      List<Emp04> list = new ArrayList<Emp04>();
      String sql = "SELECT dname, ename, hiredate, sal \r\n"
            + "FROM emp e, dept d \r\n"
            + "WHERE e.deptno = d.deptno \r\n"
            + "AND dname LIKE '%' || '"+sch.getDname()+"' || '%' \r\n"
            + "AND to_char(hiredate, 'Q') = '"+sch.getDiv()+"'";
      // 1. 연결
      try {
         con = DB.con();
         // 2. 대화
         stmt = con.createStatement();
         // 3. 결과
         rs = stmt.executeQuery(sql);
         // 4. while 처리 - 이해를 바탕으로 코딩
         //      while문과 resultSet 처리
         while(rs.next()) {
            Emp04 e = new Emp04(rs.getString("dname"), 
                           rs.getString("ename"),
                           rs.getDate("hiredate"),
                           rs.getDouble("sal"));
            list.add(e);
         }

      System.out.println("데이터의 건수: "+list.size());
                           
      } catch (SQLException e) {
         // TODO Auto-generated catch block
         System.out.println("DB 관련 예외: "+e.getMessage());
      } catch (Exception e) {
         System.out.println("일반 예외: "+e.getMessage());
      } finally {
         DB.close(rs, stmt, con);
      }
      
      return list;
   }
   
   // select * from emp where empno=7000
   // 1. vo
   // 2. 기능메서드 : 결과가 한개의 row일 때는 객체를 선언.
   public Emp05 getEmpSch05(int empno) {
      Emp05 emp = null;
      String sql = "select * \r\n"
            + "from emp \r\n"
            + "where empno = "+empno;
      try {
         con = DB.con();
         stmt = con.createStatement();
         rs = stmt.executeQuery(sql);
         // 단일 데이터의 경우 한번만 호출 while ==> if
         if(rs.next()) {
            emp = new Emp05(
                     rs.getInt("empno"),
                     rs.getString("ename"),
                     rs.getString("job"),
                     rs.getInt("mgr"),
                     rs.getDate("hiredate"),
                     rs.getDouble("sal"),
                     rs.getDouble("comm"),
                     rs.getInt("deptno")
                  );
         }
                           
         } catch (SQLException e) {
            // TODO Auto-generated catch block
            System.out.println("DB 관련 예외: "+e.getMessage());
         } catch (Exception e) {
            System.out.println("일반 예외: "+e.getMessage());
         } finally {
            DB.close(rs, stmt, con);
         }
      return emp;
   }
   public void insertPerson(Person ins) {
      String sql = "INSERT INTO person values('"+ins.getName()+"',"+ins.getAge()+",'"+ins.getLoc()+"')";
      System.out.println("등록 sql");
      System.out.println(sql);
      try {
         con = DB.con();
         con.setAutoCommit(false);
         stmt = con.createStatement();
         int cnt = stmt.executeUpdate(sql);
         System.out.println("등록 데이터 : "+cnt);
         con.commit();
         
      } catch (SQLException e) {
         // TODO Auto-generated catch block
         System.out.println("DB 처리: "+e.getMessage());
         try {
            con.rollback();
         } catch (SQLException e1) {
            // TODO Auto-generated catch block
            System.out.println("rollback에러: "+e1.getMessage());
         }
      } catch(Exception e) {
         System.out.println("기타 예외: "+e.getMessage());
      } finally {
         DB.close(rs, stmt, con);
      }
   }

   public static void main(String[] args) {
      // TODO Auto-generated method stub
      A04_DaoExp dao = new A04_DaoExp();
      dao.insertPerson(new Person("임창균",27,"서울 압구정"));
      /*
      List<Emp01> list = dao.getSch001(10);
      for(Emp001 e:list) {
         System.out.print(e.getDeptno()+"\t");
         System.out.print(e.getEname()+"\t");
         System.out.print(e.getJob()+"\t");
         System.out.print(e.getSal()+"\n");
      }
      List<Emp02> list02 = dao.getSch02(new Emp02("A",1000,6000));
      for(Emp02 e:list02) {
         System.out.print(e.getEmpno()+"\t");
         System.out.print(e.getEname()+"\t");
         System.out.print(e.getSal()+"\n");
      }
      List<Emp03> list03 = dao.getSch03(new Emp03("",10));
      for(Emp03 e:list03) {
         System.out.print(e.getEmpno()+"\t");
         System.out.print(e.getEname()+"\t");
         System.out.print(e.getJob()+"\t");
         System.out.print(e.getDeptno()+"\n");
      }
      List<Emp04> list04 = dao.getSch04(new Emp04("SALES","1"));
      for(Emp04 e:list04) {
         System.out.print(e.getDname()+"\t");
         System.out.print(e.getEname()+"\t");
         System.out.print(e.getHiredate()+"\t");
         System.out.print(e.getSal()+"\n");
      }
      Emp05 empOne = dao.getEmpSch05(7369);
      if(empOne!=null) {
         System.out.print(empOne.getEmpno()+"\t");
         System.out.print(empOne.getEname()+"\t");
         System.out.print(empOne.getJob()+"\n");
      }else {
         System.out.println("데이터 없음");
      }
      */

   }
}