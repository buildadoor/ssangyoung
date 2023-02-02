package a01_diexp;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import a01_diexp.mybatis.dao.A01_EmpDao;
import springweb.z01_vo.Emp;

public class DIExp53 {

   public static void main(String[] args) {
      // TODO Auto-generated method stub
      // 컨테이너 객체 호출 처리
      String path = "a01_diexp\\di22.xml";
      AbstractApplicationContext 
      ctx = new GenericXmlApplicationContext(path);
      // DL(dependency lookup)으로 id명으로 객체를 찾아서 가져온다.
      // A01_EmpDao
      A01_EmpDao dao = ctx.getBean("a01_EmpDao", A01_EmpDao.class);
      System.out.println("4번");
      System.out.println("1) 최고 관리자 번호:"+dao.hw01());
      System.out.println("2) 40번 부서의 최근 입사자의 입사일:"+dao.hw02());
      System.out.println("3) 직책이 SALESMAN의 최저 급여:"+dao.hw03());
      System.out.println("4) 연봉이 2000~4000 구간의 사원의 수:"+dao.hw04());
      System.out.println("5) 1/4분기에 입사한 사원의 수:"+dao.hw05());
      System.out.println("5번");
      System.out.println("1) 직책이 MANAGER인 사원의 최고 급여자:"+dao.hw06());
      System.out.println("2) 부서번호가 10인 부서정보:"+dao.hw07());
      System.out.println("3) 사원명이 TURNER인 사원의 정보:"+dao.hw08());
      System.out.println("4) 최초 입사자의 사원 정보 :"+dao.hw09());
      System.out.println("5) 2/4분기 최고 급여자의 정보:"+dao.hw10());
      ctx.close();
      // di10.xml
      // <bean id="obj" class="java.lang.Object" />

      
      
   }

}