package a01_diexp;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import a01_diexp.z01_vo.Bus;
import a01_diexp.z06_vo.Music;
import a01_diexp.z06_vo.Person;
import a01_diexp.z06_vo.Product;

public class DIExp52 {

   public static void main(String[] args) {

      //컨테이너 객체 호출 처리
      String path="a01_diexp\\di52.xml";
      AbstractApplicationContext ctx = new GenericXmlApplicationContext();
      ctx = new GenericXmlApplicationContext(path);
      //DL(dependency lookup)으로 id명으로 객체를 찾아서 가져온다.
      Person person = ctx.getBean("person",Person.class);
      Product product = ctx.getBean("product",Product.class);
      Music music = ctx.getBean("music",Music.class);
      System.out.println("컨테이너 객체 호출:"+music);
      System.out.println("컨테이너 객체 호출:"+person);
      System.out.println("컨테이너 객체 호출:"+product);
      
      
      Bus obj = ctx.getBean("bus01",Bus.class);
      System.out.println("컨테이너객체호출"+obj);
      
      
      System.out.println("종료");
      ctx.close();
      //di10.xml
      // <bean id="obj" class="java.lang.Object"/>
   }

}