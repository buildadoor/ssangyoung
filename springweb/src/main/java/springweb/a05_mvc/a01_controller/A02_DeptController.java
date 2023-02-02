package springweb.a05_mvc.a01_controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import springweb.a05_mvc.a02_service.A02_DeptService;
import springweb.z01_vo.Dept;

@Controller("mydeptCtrl")
public class A02_DeptController {

	@Autowired(required = false)
	private A02_DeptService service;
	// http://localhost:7080/springweb/myDeptList.do
	@RequestMapping("myDeptList.do")
	public String myDeptList(@ModelAttribute("sch")Dept sch, Model d) {
		d.addAttribute("dlist",service.getDeptList(sch));
		return "WEB-INF\\views\\a05_mvc\\a02_deptList.jsp";
	}
	
	@GetMapping("deptAjaxInit.do")
	public String deptAjaxInit() {
		return "WEB-INF\\views\\a05_mvc\\a04_ajaxList.jsp";
	}
	// Get/Post ==> 둘다 가능 
	@PostMapping("deptAjax.do")
	public String deptAjaxInitData(Dept sch, Model d) {
		d.addAttribute("dlist",service.getDeptList(sch));
		return "pageJsonReport";
	}
	//http://localhost:7080/springweb/getDept.do?deptno=30
	@GetMapping("getDept.do")
	public String getDept(@RequestParam("deptno") int deptno, Model d) {
		d.addAttribute("dept",service.getDept(deptno));
		return "pageJsonReport";
	}
	@RequestMapping("/updateDept.do")
	public String deptUpt(Dept upt, Model d) {
		service.uptDept(upt);
		// 수정된 이후에 데이터를 로딩 처리
		d.addAttribute("dept", service.getDept(upt.getDeptno()));
		d.addAttribute("dlist",service.getDeptList(upt));
		return "pageJsonReport";
	} 
	@RequestMapping("/deleteDept.do")
	public String deptUpt(@RequestParam("deptno") int deptno, Model d) {
		service.delDept(deptno);
		d.addAttribute("dlist",service.getDeptList(new Dept()));
		return "pageJsonReport";
	}
	//http://localhost:7080/springweb/deptAjaxInit.do
}
