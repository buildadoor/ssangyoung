package a01_diexp;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import a01_diexp.z01_vo.CarRacer;
import a01_diexp.z01_vo.HPUser;

public class DIExp12 {

   public static void main(String[] args) {
	   // http:/localhost:7080
      //컨테이너 객체 호출 처리
      String path="a01_diexp\\di12.xml";
      AbstractApplicationContext ctx = new GenericXmlApplicationContext();
      ctx = new GenericXmlApplicationContext(path);
      //DL(dependency lookup)으로 id명으로 객체를 찾아서 가져온다.
      HPUser hu01 = ctx.getBean("hu01",HPUser.class);
      HPUser hu02 = ctx.getBean("hu02",HPUser.class);
      hu01.usingMyPhone();
      hu02.usingMyPhone();
      // ex) Car (name, maxSpeed), CarRacer(name, car)
      // 1:1 관계 설정 				driving() 운행합니다/ 차가 없네요.
      CarRacer cr01 = ctx.getBean("cr01",CarRacer.class);
      CarRacer cr02 = ctx.getBean("cr02",CarRacer.class);
      cr01.driving();
      cr02.driving();
      System.out.println("종료");
      ctx.close();
      //di10.xml
      // <bean id="obj" class="java.lang.Object"/>
     
   }

}