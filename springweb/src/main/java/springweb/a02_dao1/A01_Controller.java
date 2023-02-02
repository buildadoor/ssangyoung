package springweb.a02_dao1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
//springweb.a01_start.A01_Controller
//id a01_Controller.java ==> 한쪽의 id 변경

@Controller("a01_ControllerDpl")
public class A01_Controller {
	// http://localhost:7080/springweb/start.do
	// 중복 url mapping으로 변경 필요!
   // http://localhost:7080/springweb/start22.do
	@RequestMapping("/start22.do")
   public String start() {//요청값과 model선언하고
      return "WEB-INF\\views\\a01_start\\a01_start.jsp";
   }
}