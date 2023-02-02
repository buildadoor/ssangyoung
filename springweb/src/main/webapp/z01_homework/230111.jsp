<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="java.util.*"
    %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="path" value="${pageContext.request.contextPath }"/>
<fmt:requestEncoding value="utf-8"/>     
<!DOCTYPE html>
<%--


 --%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${path}/a00_com/bootstrap.min.css" >
<link rel="stylesheet" href="${path}/a00_com/jquery-ui.css" >
<style>
	td{text-align:center;}
</style>
<script src="${path}/a00_com/jquery.min.js"></script>
<script src="${path}/a00_com/popper.min.js"></script>
<script src="${path}/a00_com/bootstrap.min.js"></script>
<script src="${path}/a00_com/jquery-ui.js"></script>
<script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.js"></script>
<script src="https://developers.google.com/web/ilt/pwa/working-with-the-fetch-api" type="text/javascript"></script>
<script type="text/javascript">
	$(document).ready(function(){
		<%-- 
		
		--%>	
	});
</script>
</head>

<body>
<%--
2023-01-11
[1단계:개념] 1. 스프링에서 매개변수로 VO객체를 선언하는 의미를 기술하세요.
스프링은 요청값을 VO객체로 property개념으로 처리할 수 있다.
		-이것을 modelAttribute라는 개념으로 사용하기도 한다.
-스프링에서 요청값의 VO객체 할당 처리
	public String empSch(Emp sch){
		1. 이렇게 선언만 하면, 요청값이 위 객체 Emp에 property에 
		   타입과 이름이 맞는 요청값이 들어오면 객체에 할당이 된다.
			 모델명을 객체의 *소문자 시작명으로 처리된다.
			 Emp ==> emp, Dept ==> dept
			 주의) 클래스명은 반드시 대문자로 시작해서 정의
		2. 모델데이터까지 객체로 선언이 자동으로 된다.
			 ${emp.ename}
		3. 요청값이 없으면 해당 객체로 default 처리를 한다.
		 	 주의) emp.do 요청값이 없으면 VO객체가 해당 내용을 자동으로 설정하는데
			 emp.do?empno=홍길동 : 이렇게 VO객체에 type이 다른 property를 
		 	 호출하면 url 호출 조차 안된다.
		 	 emp.do?empno=&ename= : 이 경우도 empno를 차라리 설정하지 않으면 
		 		호출되지만 empno=은 ""공백데이터를 전달하기 setEmpno(int empno)
				와 맞지 않아, http://localhost:7080/springweb/emp.do 자체가
				호출되지 않는 페이지가 된다.
	
[1단계:확인] 2. VO 객체 요청 활용
      1) 카운트 클릭시, 모델단에서 증가되게 하여 증가된 카운트 버튼을 출력되게 하세요
         [카운트: @@] 
         
      2) 선수이름, 타석과 안타를 입력시, 선수명과 타율(모델에서 계산)이 출력되게 하세요.
      
      
      
      
해결 하다 만 것 .. 
      // http://localhost:7080/springweb/baseball.do
			@RequestMapping("/baseball.do")
			public String baseball(Player pl) {
				System.out.println("선수명:"+pl.getPname());
				System.out.println("타석:"+pl.getBat());
				System.out.println("안타:"+pl.getHit());
				pl.setAvg(pl.getHit()&pl.getBat());
				System.out.println("타율:"+pl.getAvg());
				return "WEB-INF\\views\\z01_hw\\a10_baseball.jsp";
			}
      
      <form id="frm01" class="form-inline"  method="post">
  		<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
	    <input name="pname" value="${baseball.pname}" class="form-control mr-sm-2" placeholder="선수이름" />
	    <input name="bat" value="${baseball.bat}" class="form-control mr-sm-2" placeholder="타석" />
	    <input name="hit" value="${baseball.hit}" class="form-control mr-sm-2" placeholder="안타" />
	    <input value="${baseball.avg}"class="form-control mr-sm-2" placeholder="타율" />
	    <button class="btn btn-info" type="submit">
	    타율확인</button>
[1단계:개념] 3. 스프링을 데이터베이스를 처리시, 처리 순서를 기술하세요.
1. 흐름 순서
	1) url 요청값 처리
	2) controller호출
	3) 모델 데이터 처리 (dao호출 후, 데이터 설정)
	4) view 화면 호출, 모델 데이터 출력
2. 처리 순서
	1) 처리할 데이터 sql, dao 처리
	2) controller 작성 및 초기화면 로딩
	3) dao호출 및 모델 데이터 할당 
	4) 모델 데이터에 맞게 화면단 구현 
3. 실제 핵심 코드
	1) DAO 환경 구현 
[1단계:확인] 4. DAO에 있는 회원리스트 화면을 구현하세요.
[1단계:확인] 5. 회원 등록 처리를 구현하세요
컨트롤러
package springweb.z02_hw;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import springweb.a13_database.A06_PreparedDao;
import springweb.z01_vo.Dept;
import springweb.z01_vo.Member;
@Controller
public class A02_230111 {
	 private A06_PreparedDao dao;
	   public A02_230111() {
	      dao = new A06_PreparedDao();
}
	// http://localhost:7080/springweb/memberList.do
	   //id pass name auth point address
	   @RequestMapping("/memberList.do")
	   public String memberList(Member sch, Model d) {
	      if(sch.getName()==null) sch.setName("");
	      if(sch.getAuth()==null) sch.setName("");
	      d.addAttribute("mlist", dao.getMemberList(sch));
	      return "WEB-INF\\views\\z01_hw\\a08_member.jsp";
	   }
	   @RequestMapping("/insertMember.do")
	   public String insertMember(Member ins, Model d) {
	      dao.insertMember(ins);
	      return "redirect:/memberList.do";
	   }
}
뷰단
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="java.util.*"
    %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="path" value="${pageContext.request.contextPath }"/>
<fmt:requestEncoding value="utf-8"/>     
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${path}/a00_com/bootstrap.min.css" >
<link rel="stylesheet" href="${path}/a00_com/jquery-ui.css" >
<style>
   td{text-align:center;}
</style>
<script src="${path}/a00_com/jquery.min.js"></script>
<script src="${path}/a00_com/popper.min.js"></script>
<script src="${path}/a00_com/bootstrap.min.js"></script>
<script src="${path}/a00_com/jquery-ui.js"></script>
<script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.js"></script>
<script src="https://developers.google.com/web/ilt/pwa/working-with-the-fetch-api" type="text/javascript"></script>
<script type="text/javascript">
   $(document).ready(function(){
   });
</script>
</head>

<body>
<div class="jumbotron text-center">
  <h2>회원정보</h2>

</div>
<div class="container">
   <form id="frm01" class="form"  method="post">
     <nav class="navbar navbar-expand-sm bg-dark navbar-dark">
       <input name="name" value="${member.name}" class="form-control mr-sm-2" placeholder="회원명" />
       <input name="auth" value="${member.auth}" class="form-control mr-sm-2" placeholder="권한" />
       <button class="btn btn-info" type="submit">검색</button>
       &nbsp;&nbsp;
       <button class="btn btn-success" type="button"
           data-toggle="modal"
          data-target="#exampleModalCenter">등록</button>
    </nav>
   </form>
   <table class="table table-hover table-striped">
   
    <thead>
    
      <tr class="table-success text-center">
        <th>아이디</th>
        <th>패스워드</th>
        <th>회원명</th>
        <th>권한</th>
        <th>포인트</th>
        <th>주소</th>
       
      </tr>
    </thead>   
    <tbody>
       <c:forEach var="member" items="${mlist}">
          <tr>
             <td>${member.id}</td>
             <td>${member.pass}</td>
             <td>${member.name}</td>
             <td>${member.auth}</td>
             <td>${member.point}</td>
             <td>${member.address}</td>
          </tr>
       </c:forEach>
    </tbody>
   </table>    
    
</div>
<div class="modal fade" id="exampleModalCenter" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
  <div class="modal-dialog modal-dialog-centered" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLongTitle">회원정보등록</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
      <form id="frm02" action="insertMember.do" class="form"  method="post">
        <div class="row">
         <div class="col">
           <input name="id" type="text" class="form-control" placeholder="아이디 입력">
         </div>	 
         </div>
          <div class="row">
         <div class="col">
           <input name="pass" type="text" class="form-control" placeholder="패스워드 입력" >
         </div>
         </div>
          <div class="row">
         <div class="col">
           <input name="name" type="text" class="form-control" placeholder="회원명 입력" >
         </div>
         </div>
          <div class="row">
         <div class="col">
           <input name="auth" type="text" class="form-control" placeholder="권한 입력" >
         </div>
         </div>
          <div class="row">
         <div class="col">
           <input name="point" type="text" class="form-control" placeholder="포인트 입력" >
         </div>
         </div>
          <div class="row">
         <div class="col">
           <input name="address" type="text" class="form-control" placeholder="주소 입력" >
         </div>
         </div>
        </div>
       </form> 
       <script>
          function insertMember(){
             document.querySelector("#frm02").submit();
          }
       </script>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
        <button type="button" onclick="insertMember()" class="btn btn-success">회원등록</button>
      </div>
    </div>
  </div>
</div>
</body>
</html>
[1단계:확인] 6. 로그인 화면에서 로그인 되었을 때는 회원리스트 화면, 그렇지 않을 때는 로그인 화면으로 가게 처리하세요. --%>

 </body>
</html>