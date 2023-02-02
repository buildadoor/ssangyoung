package springweb.mvc.a01_controller;

import java.util.List;

import org.aspectj.apache.bcel.classfile.Code;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
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
		d.addAttribute("OvMemberList",service.getOvMemberList(sch));
			return "\\WEB-INF\\views\\mvc\\a01_OvMemberList.jsp";
	}
	
}