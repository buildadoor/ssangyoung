package springweb.a05_mvc.a01_controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import springweb.a05_mvc.a02_service.A04_SalService;
import springweb.z01_vo.Dept;

@Controller
public class A04_SalController {

	@Autowired(required = false)
	private A04_SalService service;

	@GetMapping("salgradeInit.do")
	public String salgradeInit() {
		return "WEB-INF\\views\\a05_mvc\\a05_salgradeList.jsp";
	}	
	//http://localhost:7080/springweb/salgradeList.do?grade=1
	@RequestMapping("salgradeList.do")
	public String salgradeList( Model d) {
		d.addAttribute("slist", service.getSalList());
		return "pageJsonReport";
	}

	// http://localhost:7080/springweb/
	@GetMapping("salgrade.do")
	public String salgrade(@RequestParam("grade") int grade, Model d) {
		d.addAttribute("sal",service.getSalgrade(grade));
		return "pageJsonReport";
	}
	
}
