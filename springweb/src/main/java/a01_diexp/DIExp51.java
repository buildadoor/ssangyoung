package a01_diexp;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import a01_diexp.z01_vo.BaseTeam;
import a01_diexp.z01_vo.Car;
import a01_diexp.z01_vo.Pocket;

public class DIExp51 {

   public static void main(String[] args) {

      //컨테이너 객체 호출 처리
      String path="a01_diexp\\di51.xml";
      AbstractApplicationContext ctx = new GenericXmlApplicationContext();
      ctx = new GenericXmlApplicationContext(path);
      //DL(dependency lookup)으로 id명으로 객체를 찾아서 가져온다.
      Pocket pk01 = ctx.getBean("pk01",Pocket.class);
      System.out.println("호주머니 컨테이너 객체 호출:"+pk01);
      System.out.println(pk01.getBall());
      
      Car c01 = ctx.getBean("c01",Car.class);
      System.out.println("자동차 컨테이너 객체 호출:"+c01);
      c01.TireList();
      
      BaseTeam bt100 = ctx.getBean("bt100",BaseTeam.class);
      System.out.println("컨테이너 객체 호출:"+bt100);
      System.out.println("컨테이너 객체 호출:"+bt100.getHitOrders());
      System.out.println("컨테이너 객체 호출:"+bt100.getDefends());
      
      
      System.out.println("종료");
      ctx.close();
   }

}