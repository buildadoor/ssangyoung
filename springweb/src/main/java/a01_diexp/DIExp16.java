package a01_diexp;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import a01_diexp.z01_vo.CarRacer;
import a01_diexp.z01_vo.HPUser;

public class DIExp16 {

   public static void main(String[] args) {

      //컨테이너 객체 호출 처리
      String path="a01_diexp\\di16.xml";
      AbstractApplicationContext ctx = new GenericXmlApplicationContext();
      ctx = new GenericXmlApplicationContext(path);
      //DL(dependency lookup)으로 id명으로 객체를 찾아서 가져온다.
    HPUser obj = ctx.getBean("us01",HPUser.class);
    System.out.println("컨테이너객체호출"+obj);
    obj.usingMyPhone();
    //vo에도 추가하기.
    CarRacer obj2 = ctx.getBean("carRacer01",CarRacer.class);
    System.out.println("컨테이너객체호출"+obj2);
    obj2.driving();
    System.out.println("종료");
    ctx.close();
      //di10.xml
      // <bean id="obj" class="java.lang.Object"/>
    //a01_diexp.z01_vo.HPUser
    //a01_diexp.z01_vo.HandPhone
      
   
   }

}