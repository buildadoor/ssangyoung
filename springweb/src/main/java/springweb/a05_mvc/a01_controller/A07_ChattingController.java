package springweb.a05_mvc.a01_controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import springweb.a06_util.A02_ChatHandler;

@Controller
public class A07_ChattingController {
	@Autowired
	private A02_ChatHandler chHandl;
	
	@RequestMapping("chatting.do")
	public String chatting(Model d) {

		// a07_chattingForm.jsp
		return "WEB-INF\\views\\a05_mvc\\a07_chattingForm.jsp";
	}
	// /chatting.do
	// /chGroup.do
	@GetMapping("chGroup.do")
	public String chGroup(Model d) {
		d.addAttribute("group", chHandl.getIdx());
		return "pageJsonReport";
	}
	
}
