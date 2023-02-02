package springweb.a03_ajax;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class A02_Contoller {
	// http://localhost:7080/springweb/empForAjax.do
	@GetMapping("/empForAjax.do")
	public String empForAjax() {
		return "a01_jquery\\a17_ajax.html";
	}
	// http://localhost:7080/springweb/deptForAjax.do
	@GetMapping("/deptForAjax.do")
	public String deptForAjax() {
		return "a01_jquery\\a18_ajax.html";
	}
	// http://localhost:7080/springweb/buyProd99.do
	// view단 :	$("h2").text("jquery Ajax")
      @GetMapping("hw2301181.do")
      public String buyProd99(){
         return "a01_jquery\\z02_hw.html";
      }
  	@GetMapping("/memListAjax.do")
  	public String memListAjax(){
  		return "z01_homework\\230118.jsp";
  	}
}
