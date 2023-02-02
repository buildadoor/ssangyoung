package a01_diexp;

import java.util.List;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import a01_diexp.mybatis.dao.A02_ExpDao;
import springweb.z01_vo.Dept;
import springweb.z01_vo.Emp;

public class DIExp23 {

   public static void main(String[] args) {
		// http://localhost:7080/springweb/start.do
      //컨테이너 객체 호출 처리
      String path="a01_diexp\\di22.xml";
      AbstractApplicationContext
      ctx = new GenericXmlApplicationContext(path);
      //DL(dependency lookup)으로 id명으로 객체를 찾아서 가져온다.
      A02_ExpDao dao = ctx.getBean("a02_ExpDao",A02_ExpDao.class);
      List<Emp> empList = dao.getEmpData();
      System.out.println("데이터 건수:"+empList.size());
      for(Emp e:empList) {
    	  System.out.print(e.getEmpno()+"\t");
    	  System.out.print(e.getEname()+"\t");
    	  System.out.print(e.getSal()+"\n");
      }
      
      List<Emp> hw01List = dao.getHw01();
      System.out.println("hw01 데이터 건수:"+hw01List.size());
      for(Emp hw01:hw01List) {
    	  System.out.print(hw01.getEname()+"\t");
    	  System.out.print(hw01.getMgr()+"\t");
    	  System.out.print(hw01.getSal()+"\n");
      }
      List<Dept> hw02List = dao.getHw02();
      System.out.println("hw02 데이터 건수:"+hw02List.size());
      for(Dept hw02:hw02List) {
    	  System.out.print(hw02.getDeptno()+"\t");
    	  System.out.print(hw02.getDname()+"\t");
    	  System.out.print(hw02.getLoc()+"\n");
      }
      System.out.println("종료");
      ctx.close();
   }

}