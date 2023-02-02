package a01_diexp;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import a01_diexp.z01_vo.BaseBallPlayer;

public class DIExp50 {

   public static void main(String[] args) {

      //컨테이너 객체 호출 처리
      String path="a01_diexp\\di50.xml";
      AbstractApplicationContext ctx = new GenericXmlApplicationContext();
      ctx = new GenericXmlApplicationContext(path);
      // ex) Car (name, maxSpeed), CarRacer(name, car)
      // 1:1 관계 설정 				driving() 운행합니다/ 차가 없네요.
      BaseBallPlayer bp01 = ctx.getBean("bp01",BaseBallPlayer.class);
      BaseBallPlayer bp02 = ctx.getBean("bp02",BaseBallPlayer.class);
      bp01.baseball();
      bp02.baseball();
      System.out.println("종료");
      ctx.close();
      //di10.xml
      // <bean id="obj" class="java.lang.Object"/>
     
   }

}