package a01_diexp;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import a01_diexp.z01_vo.Bus;
import a01_diexp.z01_vo.Monitor;
import a01_diexp.z01_vo.Sensor;
import a01_diexp.z01_vo.Student;

public class DIExp14 {

   public static void main(String[] args) {

      //컨테이너 객체 호출 처리
      String path="a01_diexp\\di14.xml";
      AbstractApplicationContext ctx = new GenericXmlApplicationContext();
      ctx = new GenericXmlApplicationContext(path);
      //DL(dependency lookup)으로 id명으로 객체를 찾아서 가져온다.
      Sensor sensor01 = ctx.getBean("sensor01",Sensor.class);
      System.out.println("컨테이너 객체 호출:"+sensor01);
      System.out.println(sensor01.getAgent());
      System.out.println("구매정보(addInfo):\n"
    		  			+sensor01.getAddInfo());
      
      System.out.println("종료");
      // ex) class Bus setPassenger(Set<String> names)
      //di로 할당한 후, getPassenger()호출하여 출력하세요.
      Bus bus01 = ctx.getBean("bus01",Bus.class);
      System.out.println("탑승 승객 명단"+bus01.getNames());
      System.out.println("버스(busInfo):\n"
	  			+bus01.getBusInfo());

      //Monitor
      Monitor monitor01 = ctx.getBean("monitor01",Monitor.class);
      System.out.println(monitor01.getConfig());
      //class Student Map<String, Integer> records
      //	과목당 점수를 설정할 수 있는 Map 선언 di에서 할당 후
      //	출력하세요.
      Student st01 = ctx.getBean("st01",Student.class);
      System.out.println(st01.getRecords());
      ctx.close();
   }

}