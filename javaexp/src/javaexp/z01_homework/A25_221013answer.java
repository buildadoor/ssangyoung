package javaexp.z01_homework;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;//해당 패키지 하위 클래스 모두 import

import javaexp.a13_database.DB;
import javaexp.a13_database.vo.Emp;

public class A25_221013answer {
	// 전역변수 선언 (공통)
	private Connection con;
	private Statement stmt;
	private ResultSet rs;
	

/*
2. 다음의 내용을 dao 처리를 하세요 a13_databas, A05_HWDao2
# 처리 순서
1. sql
2. vo
3. 기능메서드 선언
4. 내용처리        
         1) 분기별 또는 부서명 조건으로 사원의 이름, 부서명, 급여와 급여등급 출력
         
         2) 조건없음. 연도별 사원의 수와 최대급여를 출력하세요.SELECT count(to_char(hiredate,'YYYY')), max(sal)
*/
	public List<Exp02> getExp02List() {
		List<Exp02> list = new ArrayList<Exp02>();
		String sql ="select to_char(hiredate,'YYYY') year,\r\n"
				+ "		count(*),max(sal)\r\n"
				+ "from emp \r\n"
				+ "group by to_char(hiredate,'YYYY')";
		//1. 연결 
		try {
			con = DB.con();
			//2. 대화
			stmt = con.createStatement();
			//3. 결과/반복문 
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				list.add(
				new Exp02(
				rs.getString("year"), rs.getInt("count"),
				rs.getDouble("sal")
				  )
				);
			}
			System.out.println("데이터 건수:"+list.size());
			//4. 예외/ 자원해제 	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("DB예외:"+e.getMessage());
		}catch(Exception e) {
			System.out.println("기타에러:"+e.getMessage());
		}finally {
			DB.close(rs, stmt, con);
		}
		return list;
	}
	
/*


         3) 사번을 기준으로 홀/짝인 경우 홀인경우 보너스를 50%, 짝인 경우 보너스를 100% 추가하여 급여를 계산하기로 했다.
             조건(홀/짝/전체)  이름, 사번, 구분, 급여, 보너스(%), 총급여   를 출력하세요
*/
	public List<Exp03> getExp03List(String div) {
		if(div!=null) {
			if(div.equals("")||div.equals("전체")){
				div = "0,1";
			}
			if(div.equals("짝")) div="0";
			if(div.equals("홀")) div="1";
		}else {
			div = "0,1";
		}
		
		List<Exp03> list = new ArrayList<Exp03>();
		String sql =" SELECT e.*, decode(div,0,'짝','홀') div,\r\n"
				+ "		decode(div,0,'100%','50%') bonus_per, --보너스 표시\r\n"
				+ "		round(decode(div,0,1,0.5)*sal) bonus, --보너스 금액\r\n"
				+ "		sal + round(decode(div,0,1,0.5)*sal) totpay -- 총 금액 \r\n"
				+ "FROM (\r\n"
				+ "	SELECT empno, mod(empno,2) div,\r\n"
				+ "			ename, sal\r\n"
				+ "	FROM emp )e\r\n"
				+ "	WHERE div IN ("+div+")";
		//1. 연결 
		try {
			con = DB.con();
			//2. 대화
			stmt = con.createStatement();
			//3. 결과/반복문 
			rs = stmt.executeQuery(sql);			
			//String ename, int deptno, String div2, double sal, String bonus_per, int bonus, int totpay
			while(rs.next()) {
				list.add(
					new Exp03(
						rs.getString("ename"),
						rs.getInt("empno"),
						rs.getString("div2"),
						rs.getDouble("sal"),
						rs.getString("bonus_per"),
						rs.getInt("bonus"),
						rs.getInt("totpay")
				  )
				);
			}
			System.out.println("데이터 건수:"+list.size());
			//4. 예외/ 자원해제 	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("DB예외:"+e.getMessage());
		}catch(Exception e) {
			System.out.println("기타에러:"+e.getMessage());
		}finally {
			DB.close(rs, stmt, con);
		}
		return list;
	}

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
	
	
	         3) 사번을 기준으로 홀/짝인 경우 홀인경우 보너스를 50%, 짝인 경우 보너스를 100% 추가하여 급여를 계산하기로 했다.
	             조건(홀/짝/전체)  이름, 사번, 구분, 급여, 보너스(%), 총급여   를 출력하세요
	*/
		public List<Exp04> getExp04List(String std) {
		System.out.println("기준일"+std);
			List<Exp04> list = new ArrayList<Exp04>();
			if(std==null||std.equals("")) std="2022년10월14일";
			String sql ="SELECT e.*,\r\n"
					+ "	floor(mm/12) YEAR,\r\n"
					+ "	floor(MOD(mm,12)) mon,\r\n"
					+ "	floor(mm/12)||'년'||floor(MOD(mm,12))||'개월' workmonth\r\n"
					+ "FROM (\r\n"
					+ "	SELECT ename, \r\n"
					+ "		MONTHS_BETWEEN(to_date('"+std+"','YYYY/MM/DD'),\r\n"
					+ "		hiredate) mm\r\n"
					+ "	FROM emp\r\n"
					+ "	) ";
					//1. 연결 
			try {
				con = DB.con();
				//2. 대화
				stmt = con.createStatement();
				//3. 결과/반복문 
				rs = stmt.executeQuery(sql);			
				//String ename, int deptno, String div2, double sal, String bonus_per, int bonus, int totpay
				
				while(rs.next()) {
					list.add(
						new Exp04(
								rs.getString("ename"),
								rs.getString("workmonth")
							)				 	
					);
				}
				System.out.println("데이터 건수:"+list.size());
				//4. 예외/ 자원해제 	
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("DB예외:"+e.getMessage());
			}catch(Exception e) {
				System.out.println("기타에러:"+e.getMessage());
			}finally {
				DB.close(rs, stmt, con);
			}
			return list;
		}

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
			
			
			         3) 사번을 기준으로 홀/짝인 경우 홀인경우 보너스를 50%, 짝인 경우 보너스를 100% 추가하여 급여를 계산하기로 했다.
			             조건(홀/짝/전체)  이름, 사번, 구분, 급여, 보너스(%), 총급여   를 출력하세요
			*/
				public List<Emp> getExp05List(String ename) {
					List<Emp> list = new ArrayList<Emp>();
					
					String sql ="SELECT *\r\n"
							+ "FROM emp \r\n"
							+ "WHERE to_char(hiredate,'Q')=(\r\n"
							+ "	SELECT to_char(hiredate,'Q')\r\n"
							+ "	FROM emp \r\n"
							+ "	WHERE ename = '"+ename+"'";
							
							//1. 연결 
					try {
						con = DB.con();
						//2. 대화
						stmt = con.createStatement();
						//3. 결과/반복문 
						rs = stmt.executeQuery(sql);						
						while(rs.next()) {
							list.add(
								new Emp(	
									rs.getInt(1),			 	
									rs.getString(2),			 	
									rs.getString(3),			 	
									rs.getInt(4),			 	
									rs.getDate(5),			 	
									rs.getDouble(6),			 	
									rs.getDouble(7),			 	
									rs.getInt(8)			 	
						
									)
							);
						}
						System.out.println("데이터 건수:"+list.size());
						//4. 예외/ 자원해제 	
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						System.out.println("DB예외:"+e.getMessage());
					}catch(Exception e) {
						System.out.println("기타에러:"+e.getMessage());
					}finally {
						DB.close(rs, stmt, con);
					}
					return list;
				}

public static void main(String[] args){
		// TODO Auto-generated constructor stub
A25_221013answer dao = new A25_221013answer();
dao.getExp05List("ALLEN");
//for(Exp02 e:dao.getExp02List()) {
	//System.out.print(e.getYear()+"\t");
	//System.out.print(e.getCnt()+"\t");
	//System.out.print(e.getSal()+"\n");
	//}       
//for(Exp03 e:dao.getExp03List("")) {
//	System.out.print(e.getEname()+"\t");
//	System.out.print(e.getBonus_per()+"\t");
//	System.out.print(e.getSal()+"\t");
//	System.out.print(e.getTotpay()+"\n");
//}       
//for(Exp04 e:dao.getExp04List("2001년01월01일")) {
//	System.out.print(e.getEname()+"\t");
//	System.out.print(e.getWorkmonth()+"\n");

//}       
}
}
class Exp04{
 	private String ename;
 	private String workmonth;
	public Exp04() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Exp04(String ename, String workmonth) {
		this.ename = ename;
		this.workmonth = workmonth;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public String getWorkmonth() {
		return workmonth;
	}
	public void setWorkmonth(String workmonth) {
		this.workmonth = workmonth;
	}
 
}
class Exp03{
	private String ename;
	private int deptno;
	private String div2;
	private double sal;
	private String bonus_per;
	private int bonus;
	private int totpay;
	public Exp03() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Exp03(String ename, int deptno, String div2, double sal, String bonus_per, int bonus, int totpay) {
		this.ename = ename;
		this.deptno = deptno;
		this.div2 = div2;
		this.sal = sal;
		this.bonus_per = bonus_per;
		this.bonus = bonus;
		this.totpay = totpay;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public int getDeptno() {
		return deptno;
	}
	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}
	public String getDiv2() {
		return div2;
	}
	public void setDiv2(String div2) {
		this.div2 = div2;
	}
	public double getSal() {
		return sal;
	}
	public void setSal(double sal) {
		this.sal = sal;
	}
	public String getBonus_per() {
		return bonus_per;
	}
	public void setBonus_per(String bonus_per) {
		this.bonus_per = bonus_per;
	}
	public int getBonus() {
		return bonus;
	}
	public void setBonus(int bonus) {
		this.bonus = bonus;
	}
	public int getTotpay() {
		return totpay;
	}
	public void setTotpay(int totpay) {
		this.totpay = totpay;
	}
	
}

class Exp02{
private String year;
private int cnt;
private double sal;

public Exp02(String year, int cnt, double sal) {
	this.year = year;
	this.cnt = cnt;
	this.sal = sal;
}
public String getYear() {
	return year;
}
public void setYear(String year) {
	this.year = year;
}
public int getCnt() {
	return cnt;
}
public void setCnt(int cnt) {
	this.cnt = cnt;
}
public double getSal() {
	return sal;
}
public void setSal(double sal) {
	this.sal = sal;
}
}

