package javaexp.z01_homework;

public class A25_221013 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
/*
2022-10-13
[1단계:개념] 1. sql을 통한 데이터 처리(dao)의 핵심 단계와 핵심 소스를 기술하세요.

1. 기본 개발 프로세스
	1) sql 작성
	2) vo 작성
	3) 기능 메서드 선언
		- 연결처리
		- Connection 객체의 autocommit을 false로 지정 
		- 대화객체 updateQuery
		- commit()
		- 예외 처리 rollback
2. 사원정보 수정 
	1) 복사테이블 만들기 
		create table emp100
		as select * from emp;
		alter table emp100
		modify(
			job varchar2(50),
			ename varchar2(50)
			empno number(4) primary key
		);
		sequence 만들기 (primary key 설정)
		create sequence emp100_seq
			start with 1000
			minvalue 1000
			maxvalue 9999;
	2) sql 작성
	 	insert into emp100 values(emp100_seq.nextval,'홍길동','사원',7800,
	 		to_date('2022/01/01','YYYY/MM/DD'), 3500,100,10);
	3) 입력 내용을 기준으로 vo생성
		private int empno;
		private String ename;
		private String job;
		private int mgr;
		private String hiredateS;
		private double sal;
		private double comm;
		private int deptno;
	4) 메서드 선언 
		public void insert(Emp ins){
			
		}

[1단계:코드] 2. 다음의 내용을 dao 처리를 하세요 a13_databas, A05_HWDao2
       # 처리 순서
       1. sql
       2. vo
       3. 기능메서드 선언
       4. 내용처리        
                1) 분기별 또는 부서명 조건으로 사원의 이름, 부서명, 급여와 급여등급 출력
                
                2) 조건없음. 연도별 사원의 수와 최대급여를 출력하세요.SELECT count(to_char(hiredate,'YYYY')), max(sal)
*/

/*


                3) 사번을 기준으로 홀/짝인 경우 홀인경우 보너스를 50%, 짝인 경우 보너스를 100% 추가하여 급여를 계산하기로 했다.
                    조건(홀/짝/전체)  이름, 사번, 구분, 급여, 보너스(%), 총급여   를 출력하세요
*/

/*                
                4) 사원정보의 특정 근무일(YYYY/MM/DD)기준(조건)으로 근무연한/개월 수를 표현하세요    
                
                5) 사원명을 조건으로 해당 사원과 같은 입사일의 분기를 가진 사원전체 정보를 출력하세요.
*/

/*
                6) 관리자명을 기준(조건)으로 관리자 하위에 포함된 직원정보(직원명, 부서번호, 급여) 출력하세요.
 */

/*               
                
                7) 조건(월) 에 입사한 사원과 동일한 부서번호를 가진 사원을 출력하세요.
 */

/*               
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
                
[1단계:개념] 3. 액터와 유스케이스와의 관계를 기술하세요.
	 1) 유스케이스 사이의 포함 관계 (include)
	 	다른 유스케이스에서 기존 유스케이스를 재사용할 수 있음을 나타냄
	 2) 유스케이스 사이의 확장 관계 (extend)
	 	기존 유스케이스에 진행 단계를 추가하여 새로운 유스케이스를 만들어내는 관계
	 3) 엑터 사이의 일반화 관계 
	 4) 연관 관계
	 	해당 엑터와 정보를 주고받는 유스케이스와 설정함
	 	
[1단계:개념] 4. 유스케이스의 종류에 대하여 기술하세요.
       
1. 확장관계
	1) 확장하는 유스케이스는 상위 유스케이스로부터 어떠한 특정 조건에 의해 수행
	2) 기본 유스케이스를 수정하지 않고 새로운 요구 사항을 추가로 표현하고자 할 때 사용 
	고객 --- ktx예약 <---- 예약확인
			ktx를 예약한 후 결과를 확인하거나 확인하지 않을 수 있다.
	고객 --- 메일도착 <--- 메일확인
			메일이 도착했으나 확인은 선택이다.
			
2.확장과 포함 관계의 차이 (확장 관계)
	1) 기준 유스케이스 이후의 이벤트 흐름은 확장 유스케이스의 수행 결과에 의존한다.
		ex) 결제		(확장관계)	신용카드결제
								포인트결제	
		- 기준 유스케이스인 결제에 기술된 이벤트 흐름이 차례로 수정
		- 확장 부분에서 확장 유스케이스인 신용카드 결제나 포인트 결제로 분기
		- 확장 유스케이스에 기술된 이벤트 흐름의 수행이 완료
		- 다시 기준 유스케이스로 되돌아와서 이후의 이벤트 흐름을 수행
	2) 목적 
		기준 유스케이스에 부가적으로 추가된 기능 표현하기위해 사용된다.
	3) 이벤트 흐름
		기준 유스케이스에 기술된 조건에 따라 분기가 선택적으로 수행된다.
		기준 유스케이스 이후에 이벤트 흐름이 확장 유스케이스의 결과에 의존하지 않는다.
3. 확장과 포함 관계의 차이(포함 관계) include 
	1) 포함 유스케이스의 수행 결과에 따라서 기준 유스케이스의 이벤트 흐름이 영향을 받음
		ex) 동전투입	 (포함관계)	금액표시	
		- 기준 유스케이스인 동전 투입에 기술된 이벤트 흐름이 차례로 수행
		- 특정 지점에서 포함된 유스케이스(금액 표기)로 바로 분기
		- 금액 표시 유스케이스의 이벤트 흐름이 모두 수행되면 다시 동적 투입 
		- 유스케이스의 이벤트 흐름으로 돌아와 이후의 이벤트를 수행 
	2) 목적 
		여러 유스케이스에 공통적인 기능을 표현하기 위해 사용된다.
	3) 이벤트 흐름
		포함 유스케이스로 분기되는 이벤트 흐름이 필수적이다.
		기준 유스케이스 이후의 이벤트 흐름이 포함 유스케이스의 수행 결과에 의존한다.

[1단계:개념] 5. 유스케이스의 확장관계와 포함관계의 차이점을 기술하세요
	1) 기준 유스케이스 이후의 이벤트 흐름은 확장 유스케이스의 수행 결과에 의존한다.
		ex) 결제		(확장관계)	신용카드결제
								포인트결제	
		- 기준 유스케이스인 결제에 기술된 이벤트 흐름이 차례로 수정
		- 확장 부분에서 확장 유스케이스인 신용카드 결제나 포인트 결제로 분기
		- 확장 유스케이스에 기술된 이벤트 흐름의 수행이 완료
		- 다시 기준 유스케이스로 되돌아와서 이후의 이벤트 흐름을 수행
	2) 목적 
		기준 유스케이스에 부가적으로 추가된 기능 표현하기위해 사용된다.
	3) 이벤트 흐름
		기준 유스케이스에 기술된 조건에 따라 분기가 선택적으로 수행된다.
		기준 유스케이스 이후에 이벤트 흐름이 확장 유스케이스의 결과에 의존하지 않는다.

[1단계:실습] 6. actor로 회원/비회원/쇼핑몰 관리자, 유즈케이스로 로그인, 회원가입, 회원관리, 물건조회, 구매, 물품등록
               유즈케이스를 작성하세요.
               
               
               
*/
	}

}
