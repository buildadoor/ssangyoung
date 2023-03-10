package a01_diexp.z08_mydb;

import java.util.List;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import a01_diexp.z08_mydb.vo.BuyInfo;
import a01_diexp.z08_mydb.vo.EmpDeptCom;
import a01_diexp.z08_mydb.vo.Salgrade;

public class A01_DIExp93 {

   public static void main(String[] args) {
		// http://localhost:7080/springweb/start.do
      //컨테이너 객체 호출 처리
      String path="a01_diexp\\z08_mydb\\a01_di93.xml";
      AbstractApplicationContext
      ctx = new GenericXmlApplicationContext(path);
      //DL(dependency lookup)으로 id명으로 객체를 찾아서 가져온다.
      A02_ExpDao dao = ctx.getBean("a02_ExpDao",A02_ExpDao.class);
      System.out.println("컨테이너 객체 호출:"+dao.getSalgrade());
      System.out.println("데이터 건수"+dao.getSalgrade().size());
      for(Salgrade s : dao.getSalgrade()) {
    	  System.out.print(s.getGrade()+"\t");
    	  System.out.print(s.getLosal()+"\t");
    	  System.out.print(s.getHisal()+"\n");
      }
      System.out.println("#사원 부서 정보 건수:"+dao.getEmpDeptList().size());
      for(EmpDeptCom com:dao.getEmpDeptList()) {
    	  System.out.print(com.getEmp().getEname()+"\t");
    	  System.out.print(com.getDept().getDname()+"\n");
      }
      //ex) dept와 salgrade를 join하여 복합 EmpSalGd VO를 만들어 처리하세요.
     System.out.println("#급여 등급 정보 건수"+dao.getEmpSalgrade().size());
     //ex) 다중 매개변수
     //System.out.println("#사원 등록");
    // dao.insertEmp(new Emp(1113,"남궁길동","과장",7780,null,5000,1000,10));
     //ex)단일
 	//Emp emp = dao.getEmp(7499);
    //System.out.println("부서조회");
    // 	Dept dept = dao.getDept(10);
     //dao.insertDept(new Dept(10,"회계","천안"));
     //	System.out.println("사원명:"+emp.getEname());
 	//dao.deleteEmp(1028);
 	//System.out.println("데이터 건수"+dao.getMemberList().size());
 	//dao.deleteMember("아이디");
     List<BuyInfo> blist = dao.getBuyInfo();
     System.out.println("구매건수:"+blist.size());
     for(BuyInfo bi:blist) {
    	 System.out.print(bi.getMember().getName()+"\t");
    	 System.out.print(bi.getProduct().getName()+"\t");
    	 System.out.print(bi.getProduct().getBcnt()+"\n");
     }
     System.out.println("종료");
    ctx.close();
   }

}