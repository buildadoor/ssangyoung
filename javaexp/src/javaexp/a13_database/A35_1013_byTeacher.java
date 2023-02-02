package javaexp.a13_database;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javaexp.a13_database.vo.Emp;
import javaexp.a13_database.DB;

public class A35_1013_byTeacher {
// 전역변수 선언(공통)
   private Connection con;
   private Statement stmt;
   private ResultSet rs;
   
   /*
    # 처리순서
    1. sql
    2. vo
    3. 기능메서드 선언
    4. 내용 처리      
    */
         

//         2022-10-13
//         [1단계:개념] 1. sql을 통한 데이터 처리(dao)의 핵심 단계와 핵심 소스를 기술하세요.
//         [1단계:코드] 2. 다음의 내용을 dao 처리를 하세요
//                         1) 분기별 또는 부서명 조건으로 사원의 이름, 부서명, 급여와 급여등급 출력
//                         2) 조건없음. 연도별 사원의 수와 최대급여를 출력하세요.
   public List<Exp02> getExp02List() {
      List<Exp02> list = new ArrayList<Exp02>();
      String sql = "SELECT to_char(hiredate, 'YYYY') year, \r\n"
            + "     count(*), max(sal) SAL\r\n"
            + "FROM EMP e  \r\n"
            + "GROUP BY TO_CHAR(hiredate, 'YYYY')";
      // 1. 연결
      try {
         con = DB.con();
         // 2. 대화
         stmt = con.createStatement();
         // 3. 결과 /반복문
         rs = stmt.executeQuery(sql);
         while(rs.next()) {
            list.add(
            new Exp02(
               rs.getString("year"),
               rs.getInt("count(*)"),
               rs.getDouble("sal")
                  ));
            
         }
         System.out.println("데이터 건수 : "+list.size());
         // 4. 예외/자원해제 
         
      } catch (SQLException e) {
         // TODO Auto-generated catch block
         System.out.println("DB 관련 에러 : "+e.getMessage());
      } catch(Exception e) {
         System.out.println("기타 에러 : "+e.getMessage());
      } finally {
         DB.close(rs, stmt, con);
      }
      return list;
   }
//            3) 사번을 기준으로 홀/짝인 경우 홀인경우 보너스를 50%, 짝인 경우 보너스를 100% 추가하여 급여를 계산하기로 했다.
//                 조건(홀/짝/전체)  이름, 사번, 구분, 급여, 보너스(%), 총급여   를 출력하세요
   

   

      public List<Exp03> getExp03List(String div) {
         if(div!=null) {
            if(div.equals("") || div.equals("전체")) {
               div = "0, 1";
            }
            if(div.equals("짝")) div = "0";
            if(div.equals("홀")) div = "1";
         }else { 
            div = "0, 1";
            
         }
         List<Exp03> list = new ArrayList<Exp03>();
         String sql = " SELECT e.*, decode(div,0,'짝','홀') div2,\r\n"
               + "      decode(div,0,'100%','50%') bonus_per, -- 보너스 표시\r\n"
               + "      round(decode(div,0,1,0.5)*sal) bonus,   -- 보너스 금액\r\n"
               + "      sal+ round(decode(div,0,1,0.5)*sal) totpay\r\n"
               + "FROM (\r\n"
               + "      SELECT empno, MOD(empno,2) div,\r\n"
               + "      ename, sal \r\n"
               + "      FROM emp) e\r\n"
               + "WHERE div IN("+div+") ";
//         에러찾기 : System.out.println(sql);
         // 1. 연결
         try {
            con = DB.con();
            // 2. 대화
            stmt = con.createStatement();
            // 3. 결과 /반복문
            rs = stmt.executeQuery(sql);
            while(rs.next()) {
//               에러찾기 : System.out.println(rs.getString(1));
               list.add(
               new Exp03(
                  rs.getString("ename"),
                  rs.getInt("empno"),
                  rs.getString("div2"),
                  rs.getDouble("sal"),
                  rs.getString("bonus_per"),
                  rs.getInt("bonus"),
                  rs.getInt("totpay")
                     ));
               
            }
            System.out.println("데이터 건수 : "+list.size());
            // 4. 예외/자원해제 
            
         } catch (SQLException e) {
            // TODO Auto-generated catch block
            System.out.println("DB 관련 에러 : "+e.getMessage());
         } catch(Exception e) {
            System.out.println("기타 에러 : "+e.getMessage());
         } finally {
            DB.close(rs, stmt, con);
         }
         return list;
      }


   //                  4) 사원정보의 특정 근무일(YYYY/MM/DD)기준(조건)으로 근무연한/개월 수를 표현하세요
      
      
      
         
      
            public List<Exp04> getExp04List(String std) {
               System.out.println("기준일 : "+std);
               if(std==null || std.equals("")) std = "2022/10/14"; // 에러방지용 특정날짜 지정
               List<Exp04> list = new ArrayList<Exp04>();
               String sql = " SELECT ename, \r\n"
                     + "      floor(mm/12)||'년'||floor(MOD(mm,12))||'개월' workmonth\r\n"
                     + "FROM (\r\n"
                     + "SELECT ename, \r\n"
                     + "   MONTHS_BETWEEN(to_date('"+std+"', 'YYYY/MM/DD'), hiredate) mm \r\n"
                     + "FROM emp\r\n"
                     + ")";
               
//               public List<Exp04> getExp04List(String std) {
//                  System.out.println("기준일 : "+std);
//                  if(std==null || std.equals("")) std = "2022년10월14일"; // 에러방지용 특정날짜 지정
//                  List<Exp04> list = new ArrayList<Exp04>();
//                  String sql = "SELECT ename, \r\n"
//                        + "      floor(mm/12)||'년'||floor(MOD(mm,12))||'개월' workmonth\r\n"
//                        + "FROM (\r\n"
//                        + "SELECT ename, \r\n"
//                        + "   MONTHS_BETWEEN(to_date('2001년01월01일', 'YYYY\"년\"MM\"월\"DD\"일\"'), hiredate) mm \r\n"
//                        + "FROM emp\r\n"
//                        + ")";
//                        '2001년01월01일', 'YYYY"년"MM"월"DD"일"' 
//                         밑에 main함수에서 입력할 때도 '2001년01월01일'과 같은 형식으로 지정을 해줘야 오류가 생기지 않는다!
               
               // 1. 연결
               try {
                  con = DB.con();
                  // 2. 대화
                  stmt = con.createStatement();
                  // 3. 결과 /반복문
                  rs = stmt.executeQuery(sql);
                  while(rs.next()) {
//                     String ename, String workmonth
                     list.add(
                     new Exp04(
                           rs.getString("ename"),
                           rs.getString("workmonth")
                     ));
                     
                  }
                  System.out.println("데이터 건수 : "+list.size());
                  // 4. 예외/자원해제 
                  
               } catch (SQLException e) {
                  // TODO Auto-generated catch block
                  System.out.println("DB 관련 에러 : "+e.getMessage());
               } catch(Exception e) {
                  System.out.println("기타 에러 : "+e.getMessage());
               } finally {
                  DB.close(rs, stmt, con);
               }
               return list;
            }




   //                     5) 사원명을 조건으로 해당 사원과 같은 입사일의 분기를 가진 사원전체 정보를 출력하세요.
            
            
                  
                        public List<Emp> getExp05List(String ename) {
         
                           List<Emp> list = new ArrayList<Emp>();
                           String sql = "SELECT * \r\n"
                                 + "FROM EMP \r\n"
                                 + "WHERE TO_char(HIREDATE,'q') = (\r\n"
                                 + "   SELECT TO_CHAR(HIREDATE,'q') \r\n"
                                 + "   FROM EMP \r\n"
                                 + "   WHERE ename = '"+ename+"'\r\n"
                                 + ") ";
                           
                           
                           // 1. 연결
                           try {
                              con = DB.con();
                              // 2. 대화
                              stmt = con.createStatement();
                              // 3. 결과 /반복문
                              rs = stmt.executeQuery(sql);
                              /*
                               * 
                               */
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
                                 ));
                                 
                              }
                              System.out.println("데이터 건수 : "+list.size());
                              // 4. 예외/자원해제 
                              
                           } catch (SQLException e) {
                              // TODO Auto-generated catch block
                              System.out.println("DB 관련 에러 : "+e.getMessage());
                           } catch(Exception e) {
                              System.out.println("기타 에러 : "+e.getMessage());
                           } finally {
                              DB.close(rs, stmt, con);
                           }
                           return list;
                        }




//                     6) 관리자명을 기준(조건)으로 관리자 하위에 포함된 직원정보(직원명, 부서번호, 급여) 출력하세요.
//                         7) 조건(월) 에 입사한 사원과 동일한 부서번호를 가진 사원을 출력하세요.
   //
//         [1단계:개념] 3. 액터와 유스케이스와의 관계를 기술하세요.
//         [1단계:개념] 4. 유스케이스의 종류에 대하여 기술하세요.
//         [1단계:개념] 5. 유스케이스의 확장관계와 포함관계의 차이점을 기술하세요
//         [1단계:실습] 6. actor로 회원/비회원/쇼핑몰 관리자, 유즈케이스로 로그인, 회원가입, 회원관리, 물건조회, 구매, 물품등록
//                        유즈케이스를 작성하세요.
//         
   public static void main(String[] args) {
      // TODO Auto-generated method stub
      A35_1013_byTeacher dao = new A35_1013_byTeacher();
//      for(Exp02 e : dao.getExp02List()) {
//         System.out.print(e.getYear()+"\t");
//         System.out.print(e.getCnt()+"\t");
//         System.out.print(e.getSal()+"\n");
//   }
      
//      for(Exp03 e : dao.getExp03List("0,1")) {
//         System.out.print(e.getEname()+"\t");
//         System.out.print(e.getBonus_per()+"\t");
//         System.out.print(e.getSal()+"\t");
//         System.out.print(e.getTotpay()+"\n");
//      
//   }
      for(Exp04 e : dao.getExp04List("2001/10/10")) {
         System.out.print(e.getEname()+"\t");
         System.out.print(e.getWorkmonth()+"\n");
   }
      
      dao.getExp05List("ALLEN");

   }
   
}

class Exp04{
    private String ename;
    private String workmonth;
   public Exp04() {
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
   private int empno;
   private String div2;
   private double sal;
   private String bonus_per;
   private int bonus;
   private int totpay;
   
   public Exp03() {
      // TODO Auto-generated constructor stub
   }

   public Exp03(String ename, int empno, String div2, double sal, String bonus_per, int bonus, int totpay) {
      this.ename = ename;
      this.empno = empno;
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

   public int getEmpno() {
      return empno;
   }

   public void setEmpno(int empno) {
      this.empno = empno;
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
   private String year; // 여기서 date형? String형? 고민 많이함
   private int cnt;
   private double sal;
   public Exp02(String year, int cnt, double sal) {
      this.year = year;
      this.cnt = cnt;
      this.sal = sal;
   }
   public Exp02() {
      // TODO Auto-generated constructor stub
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
