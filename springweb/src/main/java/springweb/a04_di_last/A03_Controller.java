package springweb.a04_di_last;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class A03_Controller {
		@Autowired
	  private A04_Service service;
		// http://localhost:7080/springweb/diCall02.do
		 @GetMapping("/diCall02.do")
		 public String diCall02(Model d) {
			 System.out.println("#의존성 주입이 되었는지#\n"+service.getGreet());
			 d.addAttribute("show",service.getGreet());		
			 return "WEB-INF\\views\\a01_start\\a21_showView.jsp";
		
		 
}
}