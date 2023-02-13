package springweb.mvc.a01_controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import springweb.mvc.a02_service.A01_MemberService;
import springweb.mvc.a02_service.A02_ProductService;
import springweb.mvc.a03_dao.A01_MemberDao;
import springweb.vo.OvMember;
import springweb.vo.OvProduct;

@Controller
public class A01_MemberController {
	 //메인화면
	 // http://localhost:7080/springweb_oliveyoung/main.do
	 @GetMapping("/main.do")
		public String oliveyoungmain(){
			return "WEB-INF\\views\\mvc\\a00_main.jsp";
		}
	//회원조회
	@Autowired
	private A01_MemberService service;
	// http://localhost:7080/springweb_oliveyoung/ovMemberList.do
	@RequestMapping("ovMemberList.do")
	public String OvMemberList(@ModelAttribute("sch")OvMember sch, Model d) {
		d.addAttribute("OvMemberList",service.OvMemberList(sch));
			return "WEB-INF\\views\\mvc\\a01_OvMemberList.jsp";
	}
	//회원가입
	// http://localhost:7080/springweb_oliveyoung/insertFrm.do
	 @GetMapping("/insertFrm.do")
		public String insertFrm(){
			return "WEB-INF\\views\\mvc\\a03_join.jsp";
		}
	 @PostMapping("/insert.do")
		public String insert(OvMember ins, Model d){
			service.insertOvMember(ins);
			d.addAttribute("msg","회원가입완료");
			return "WEB-INF\\views\\mvc\\a03_join.jsp";
		}
	 // http://localhost:7080/springweb_oliveyoung/idChk.do?id=txt
	 //아이디 중복체크 json 디스패쳐에 선언 필수 !
	 @RequestMapping("/idChk.do")
	   public String idChk(@RequestParam("id") String id, Model d) {
	      d.addAttribute("idCheck", service.idChk(id));
	      return "pageJsonReport";
	   }
	 //로그인
	 // http://localhost:7080/springweb_oliveyoung/login.do
	 @Autowired(required=false)
	 private A01_MemberDao dao;
	   @RequestMapping("login.do")
	   public String login(OvMember m, Model d, HttpSession session) {
	      if(m.getId()==null) {
	         d.addAttribute("msg", "초기화면"); 
	         return "WEB-INF\\views\\mvc\\a03_login.jsp";
	      }else if(dao.login(m)==null) {
	         d.addAttribute("msg", "로그인 실패");
	         return "WEB-INF\\views\\mvc\\a03_login.jsp";
	      }else {
	         session.setAttribute("mem", dao.login(m));
	         if(dao.login(m).getAuth().equals("1")) {
	            return "WEB-INF\\views\\mvc\\a00_main.jsp";
	         }else return "redirect:/ovMemberList.do";
//	         session.setAttribute("mem", dao.login(m));
//	         return page;
	      }
	   }
	 //상품조회
	 @Autowired
		private A02_ProductService service2;
		// http://localhost:7080/springweb_oliveyoung/ovProductrList.do
		@RequestMapping("ovProductrList.do")
		public String OvMemberList(@ModelAttribute("sch")OvProduct sch, Model d) {
			d.addAttribute("OvProductList",service2.OvProductList(sch));
				return "WEB-INF\\views\\mvc\\a03_OvProductList.jsp";
		}
	
}