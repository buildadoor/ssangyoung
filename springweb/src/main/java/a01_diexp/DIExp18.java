package a01_diexp;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import a01_diexp.z03_vo.Car;
import a01_diexp.z03_vo.Member;
import a01_diexp.z03_vo.Music;
import a01_diexp.z03_vo.Person;
import a01_diexp.z03_vo.Product;

public class DIExp18 {

   public static void main(String[] args) {

      //컨테이너 객체 호출 처리
      String path="a01_diexp\\di18.xml";
      AbstractApplicationContext ctx = new GenericXmlApplicationContext();
      ctx = new GenericXmlApplicationContext(path);
      //DL(dependency lookup)으로 id명으로 객체를 찾아서 가져온다.
      Car car = ctx.getBean("car",Car.class);
      Member member = ctx.getBean("member",Member.class);
      Music music = ctx.getBean("music",Music.class);
      Person person = ctx.getBean("person",Person.class);
      Product product = ctx.getBean("product",Product.class);
      System.out.println("컨테이너 객체 호출:"+car);
      System.out.println("컨테이너 객체 호출:"+member);
      System.out.println("컨테이너 객체 호출:"+music);
      System.out.println("컨테이너 객체 호출:"+person);
      System.out.println("컨테이너 객체 호출:"+product);
      System.out.println("종료");
      ctx.close();
      //di10.xml
      // <bean id="obj" class="java.lang.Object"/>
   }

}