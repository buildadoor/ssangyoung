package a01_diexp;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import a01_diexp.z01_vo.Person;
import a01_diexp.z01_vo.Product;

public class DIExp15 {
   public static void main(String[] args) {
      //컨테이너 객체 호출 처리
      String path="a01_diexp\\di15.xml";
      AbstractApplicationContext ctx = new GenericXmlApplicationContext();
      ctx = new GenericXmlApplicationContext(path);
      //DL(dependency lookup)으로 id명으로 객체를 찾아서 가져온다.
      Person p01 = ctx.getBean("p01",Person.class);
      Person p02 = ctx.getBean("p02",Person.class);
      Person p03 = ctx.getBean("p03",Person.class);
      System.out.println("컨테이너 객체 호출:"+p01);
      System.out.println("컨테이너 객체 호출:"+p01.getName());
      System.out.println("컨테이너 객체 호출:"+p02.getName());
      System.out.println("컨테이너 객체 호출:"+p01.getAge());
      System.out.println("컨테이너 객체 호출:"+p01.getLoc());
      System.out.println("종료");
      Product pro01 = ctx.getBean("pro01",Product.class);
      Product pro02 = ctx.getBean("pro02",Product.class);
      Product pro03 = ctx.getBean("pro03",Product.class);
      System.out.println("컨테이너 객체 호출:"+pro01);
      System.out.println("컨테이너 객체 호출:"+pro01.getName());
      System.out.println("컨테이너 객체 호출:"+pro02.getName());
      System.out.println("컨테이너 객체 호출:"+pro03.getName());
      System.out.println("컨테이너 객체 호출:"+pro01.getPrice());
      System.out.println("컨테이너 객체 호출:"+pro02.getPrice());
      System.out.println("컨테이너 객체 호출:"+pro03.getPrice());
      System.out.println("컨테이너 객체 호출:"+pro01.getCnt());
      System.out.println("컨테이너 객체 호출:"+pro03.getCnt());
      System.out.println("종료");
      ctx.close();
      //di10.xml
      // <bean id="obj" class="java.lang.Object"/>
   }

}