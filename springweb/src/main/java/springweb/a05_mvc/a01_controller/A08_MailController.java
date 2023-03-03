package springweb.a05_mvc.a01_controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import springweb.a05_mvc.a02_service.A07_MailSenderService;
import springweb.z01_vo.Mail;

@Controller
public class A08_MailController {
	@Autowired(required=false)
	private A07_MailSenderService service;
	
	// 메일발송 초기화면
	@GetMapping("mailForm.do")
	public String mailForm() {
		return "WEB-INF\\views\\a05_mvc\\a08_mailForm.jsp";
	}
	// 메일발송 처리화면
	@PostMapping("mailSender.do")
	public String mailSender(Mail mail, Model d) {
		d.addAttribute("msg",service.sendMail(mail));
		return "WEB-INF\\views\\a05_mvc\\a08_mailForm.jsp";
	}
}
