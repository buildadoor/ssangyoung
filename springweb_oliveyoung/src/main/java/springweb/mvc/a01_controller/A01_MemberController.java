package springweb.mvc.a01_controller;

import java.util.List;

import org.aspectj.apache.bcel.classfile.Code;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import springweb.mvc.a02_service.A01_MemberService;
import springweb.vo.OvMember;

@Controller
public class A01_MemberController {
	@Autowired
	private A01_MemberService service;
	// http://localhost:7080/springweb_oliveyoung/ovMemberList.do
	@RequestMapping("ovMemberList.do")
	public String OvMemberList(@ModelAttribute("sch")OvMember sch, Model d) {
		d.addAttribute("OvMemberList",service.OvMemberList(sch));
			return "WEB-INF\\views\\mvc\\a01_OvMemberList.jsp";
	}
	// http://localhost:7080/springweb_oliveyoung/insertFrm.do
	 @GetMapping("/insertFrm.do")
		public String insertFrm(){
			return "WEB-INF\\views\\mvc\\a02_join.jsp";
		}
	 @PostMapping("/insert.do")
		public String insert(OvMember ins, Model d){
			service.insertOvMember(ins);
			d.addAttribute("msg","회원가입완료");
			return "WEB-INF\\views\\mvc\\a02_join.jsp";
		}	
	 // http://localhost:7080/springweb_oliveyoung/main.do
	 @GetMapping("/main.do")
		public String oliveyoungmain(){
			return "WEB-INF\\views\\mvc\\a00_main.jsp";
		}
}