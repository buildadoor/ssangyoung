package javaexp.a13_database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javaexp.a13_database.vo2.EmpHw01;
import javaexp.a13_database.vo2.EmpHw02;
import javaexp.a13_database.vo2.EmpHw03;
import javaexp.a13_database.vo2.EmpHw04;
import javaexp.a13_database.vo2.EmpHw05;
import javaexp.a13_database.vo2.EmpHw06;
import javaexp.a13_database.vo2.EmpHw07;

public class A05_HWDao2 {
	   private Connection con;
	   private Statement stmt;
	   private ResultSet rs;
	   public List<EmpHw01> Hwsch01(String dname, String hireq) {
		      List<EmpHw01> list= new ArrayList<EmpHw01>();
		      try {
		         con = DB.con();
		         stmt = con.createStatement();
		         String sql="SELECT ename,DNAME, sal, grade\r\n"
		               + "FROM emp e, SALGRADE s ,DEPT d \r\n"
		               + "WHERE  sal BETWEEN losal AND hisal\r\n"
		               + "AND e.DEPTNO  = d.DEPTNO\r\n"
		               + "AND to_char(hiredate,'q') ='"+hireq+"'\r\n"
		               + "OR dname = '"+dname+"'";
		         rs= stmt.executeQuery(sql);
		         while(rs.next()) {
		            list.add(
		            new EmpHw01(
		                  rs.getString("ename"),
		                  rs.getString("dname"),
		                  rs.getDouble("sal"),
		                  rs.getInt("grade")));
		         }
		      } catch (SQLException e) {
		         System.out.println("DB에러:"+e.getMessage());
		      }catch (Exception e) {
		         System.out.println("기타에러:"+e.getMessage());
		      }finally {
		         DB.close(rs, stmt, con);
		      }
		      return list;
		   }
//	    2) 조건없음. 연도별 사원의 수와 최대급여를 출력하세요.
	   public List<EmpHw02> Hwsch02() {
	      List<EmpHw02> list= new ArrayList<EmpHw02>();
	      try {
	         con = DB.con();
	         stmt = con.createStatement();
	         String sql="SELECT  to_char(hiredate,'YY') yy, count(empno) empnoc, max(sal) msal\r\n"
	               + "FROM EMP e \r\n"
	               + "GROUP BY to_char(hiredate,'YY')";
	         rs= stmt.executeQuery(sql);
	         while(rs.next()) {
	            list.add(
	            new EmpHw02(
	                  rs.getString
	                  (1),
	                  rs.getInt(2),
	                  rs.getDouble(3)));
	         }
	      } catch (SQLException e) {
	         System.out.println("DB에러:"+e.getMessage());
	      }catch (Exception e) {
	         System.out.println("기타에러:"+e.getMessage());
	      }finally {
	         DB.close(rs, stmt, con);
	      }
	      return list;
	   }
//	    3) 사번을 기준으로 홀/짝인 경우 홀인경우 보너스를 50%, 짝인 경우 보너스를 100% 추가하여 급여를 계산하기로 했다.
//	    조건(홀/짝/전체)  이름, 사번, 구분, 급여, 보너스(%), 총급여   를 출력하세요.
	   public List<EmpHw03> HWsch03() {
	      List<EmpHw03> list= new ArrayList<EmpHw03>();
	      try {
	         con = DB.con();
	         stmt = con.createStatement();
	         String sql=" SELECT ENAME, EMPNO, mod(empno, 2) div,sal, \r\n"
	               + "      decode (mod(empno, 2),0,sal,sal*0.5) bonus, \r\n"
	               + "      nvl2(NULLIF(mod(empno,2),0),sal+(sal*0.5),sal*2)  totsal\r\n"
	               + "FROM EMP e";
	         rs= stmt.executeQuery(sql);
	         while(rs.next()) {
	            list.add(
	            new EmpHw03(
	                  rs.getString(1),
	                  rs.getInt(2),
	                  rs.getInt(3),
	                  rs.getDouble(4),
	                  rs.getDouble(5)));
	         }
	      } catch (SQLException e) {
	         System.out.println("DB에러:"+e.getMessage());
	      }catch (Exception e) {
	         System.out.println("기타에러:"+e.getMessage());
	      }finally {
	         DB.close(rs, stmt, con);
	      }
	      return list;
	   }
	//4) 사원정보의 특정 근무일(YYYY/MM/DD)기준(조건)으로 근무연한/개월 수를 표현하세요
	   public List<EmpHw04> HWsch04() {
	      List<EmpHw04> list= new ArrayList<EmpHw04>();
	      try {
	         con = DB.con();
	         stmt = con.createStatement();
	         String sql="SELECT empno,ENAME,floor(months_between(sysdate, hiredate)/12) yyyy,\r\n"
	               + "      mod(floor(MONTHS_BETWEEN(sysdate, hiredate)),12) mmmm\r\n"
	               + "FROM emp";
	         rs= stmt.executeQuery(sql);
	         while(rs.next()) {
	            list.add(
	            new EmpHw04(
	                  rs.getInt(1),
	                  rs.getString(2),
	                  rs.getDouble(3),
	                  rs.getDouble(4)));
	         }
	      } catch (SQLException e) {
	         System.out.println("DB에러:"+e.getMessage());
	      }catch (Exception e) {
	         System.out.println("기타에러:"+e.getMessage());
	      }finally {
	         DB.close(rs, stmt, con);
	      }
	      return list;
	   }
	//5) 사원명을 조건으로 해당 사원과 같은 입사일의 분기를 가진 사원전체 정보를 출력하세요.
	   public List<EmpHw05> HWsch05(String ename) {
	      List<EmpHw05> list= new ArrayList<EmpHw05>();
	      try {
	         con = DB.con();
	         stmt = con.createStatement();
	         String sql="SELECT empno,ename,sal\r\n"
	               + "FROM EMP e \r\n"
	               + "WHERE to_char(hiredate,'q') in(\r\n"
	               + "   SELECT to_char(hiredate,'q') FROM emp \r\n"
	               + "   WHERE ename  = '"+ename+"')";
	         rs= stmt.executeQuery(sql);
	         while(rs.next()) {
	            list.add(
	            new EmpHw05(
	                  rs.getInt(1),
	                  rs.getString(2),
	                  rs.getDouble(3)));
	         }
	      } catch (SQLException e) {
	         System.out.println("DB에러:"+e.getMessage());
	      }catch (Exception e) {
	         System.out.println("기타에러:"+e.getMessage());
	      }finally {
	         DB.close(rs, stmt, con);
	      }
	      return list;
	   }
	//6) 관리자명을 기준(조건)으로 관리자 하위에 포함된 직원정보(직원명, 부서번호, 급여) 출력하세요.
	   public List<EmpHw06> VOsch06(String enameM) {
	      List<EmpHw06> list= new ArrayList<EmpHw06>();
	      try {
	         con = DB.con();
	         stmt = con.createStatement();
	         String sql="SELECT m.ENAME \"관리자\",e.ENAME \"하위직원\", e.EMPNO,e.SAL  \r\n"
	               + "FROM EMP e ,emp m\r\n"
	               + "WHERE e.mgr=m.EMPNO\r\n"
	               + "AND m.ENAME = '"+enameM+"'";
	         rs= stmt.executeQuery(sql);
	         while(rs.next()) {
	            list.add(
	            new EmpHw06(
	                  rs.getString(1),
	                  rs.getString(2),
	                  rs.getInt(3),
	                  rs.getDouble(4)));
	         }
	      } catch (SQLException e) {
	         System.out.println("DB에러:"+e.getMessage());
	      }catch (Exception e) {
	         System.out.println("기타에러:"+e.getMessage());
	      }finally {
	         DB.close(rs, stmt, con);
	      }
	      return list;
	   }
//	    7) 조건(월) 에 입사한 사원과 동일한 부서번호를 가진 사원을 출력하세요.
	   public List<EmpHw07> Hwsch07(String MMMM) {
	      List<EmpHw07> list= new ArrayList<EmpHw07>();
	      try {
	         con = DB.con();
	         stmt = con.createStatement();
	         String sql=" SELECT ENAME,DEPTNO\r\n"
	               + "FROM EMP  \r\n"
	               + "WHERE DEPTNO = (\r\n"
	               + "   SELECT deptno\r\n"
	               + "FROM EMP e \r\n"
	               + "WHERE to_char(hiredate,'MM')= '"+MMMM+"'\r\n"
	               + "GROUP BY DEPTNO)";
	         rs= stmt.executeQuery(sql);
	         while(rs.next()) {
	            list.add(
	            new EmpHw07(
	                  rs.getInt(2),
	                  rs.getString(1)));
	         }
	      } catch (SQLException e) {
	         System.out.println("DB에러:"+e.getMessage());
	      }catch (Exception e) {
	         System.out.println("기타에러:"+e.getMessage());
	      }finally {
	         DB.close(rs, stmt, con);
	      }
	      return list;
	   }   

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
	}

}
