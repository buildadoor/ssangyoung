package springweb.a01_start;
//springweb.a01_start.A04_RequestVo
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import springweb.z01_vo.Dept;
import springweb.z01_vo.Person;
@Controller
public class A04_RequestVo {
	// http://localhost:7080/springweb/person.do
	// ?name=홍길동&age=&loc=서울(X)
	@RequestMapping("/person.do")
	public String callPerson(Person person) {
		// 요청값이 없더라도 해당 메서드가 호출되고,
		// type에 맞게 호출하면 해당 요청값을 Person객체에 할당된다.
		System.out.println("#요청값#");
		System.out.println("이름:"+person.getName());
		System.out.println("나이:"+person.getAge());
		System.out.println("사는 곳:"+person.getLoc());
		return "WEB-INF\\views\\a01_start\\a14_insertPerson.jsp";
	}
	// http://localhost:7080/springweb/deptIns.do
	//부서번호, 부서명, 부서위치를 등록화면을 구현하세요.
	@RequestMapping("/deptIns.do")
	public String callDept(Dept dept, Model d) {
		// 요청값이 없더라도 해당 메서드가 호출되고,
		// type에 맞게 호출하면 해당 요청값을 Person객체에 할당된다.
		System.out.println("#부서정보등록내용#");
		System.out.println("부서번호:"+dept.getDeptno());
		System.out.println("부서명:"+dept.getDname());
		System.out.println("부서위치:"+dept.getLoc());
		return "WEB-INF\\views\\a01_start\\a15_insertDept.jsp";
	}
}