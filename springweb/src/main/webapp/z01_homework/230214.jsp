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
2023-02-14
[1단계:개념] 1. 오라클에서 merge의 기능을 예제 코드와 함께 기술하세요.

Merge Into 문은 조건에 따라서 데이터를 
삽입(Insert), 갱신(Update), 삭제(Delete)를 할 수 있다.
조건이 맞으면 Update나 Delete를 수행하고 그렇지 않으면 Insert를 수행한다. 
여러 조건을 줘서 INSERT, UPDATE, DELETE를 한 번에 수행할 수도 있다.

MERGE INTO 테이블명 // Update 혹은 Insert 원하는 테이블
USING(SELECT 문)
ON(조건)
WHEN MATCHED THEN
UPDATE SET 컬럼1 = 컬럼1값, 컬럼2, 컬럼2값
WHEN NOT MATCHED THEN
INSERT(컬럼1, 컬럼2, 컬럼3) VALUES(컬럼1값, 컬럼2값, 컬럼3값);
[1단계:개념] 2. 게시판에 로그인 후, session 처리하는 주요 기능 기능에 대하여 기술하세요.
HttpSession session
HttpSession은 둘 이상의 페이지의 요청 또는 웹사이트를 방문한 사용자를 식별하고 해당 사용자에 대한 정보를 저장하는 방법을 제공,
Session은 사용자의 둘 이상의 연결 또는 페이지 요청을 통해 지정된 기간 동안 유지된다.
Session은 보통 웹사이트를 여러번 방문하는 하나의 사용자에 해당한다.
서버는 쿠키를 사용하거나 URL 다시쓰기 등과 같은 여러가지 방법으로 session을 유지할 수 있다.
HttpSession은 서블릿이 다음 작업을 수행하도록 허용한다.
Session 식별자, 생성시간, 마지막 접근 시간과 같은 세션에 대한 정보를 조작하고 볼 수 있다.
객체를 Session에 바인딩하여 여러 사용자 연결에서 사용자 정보가 유지되도록 한다.
어플리케이션이 Session에 객체를 저장하거나 제거할 때, Session은 객체가 HttpSessionBindingListener인터페이스 구현여부를 확인한다. 이 경우 서블릿은 객체가 Session에 바인딩 되거나 바인딩 해제되었음을 바인딩 메서드의 실행이 완료된 후에 알려준다. 해제되거나 만료된 Session은 Session이 해제되거나 만료된 후에 알려준다.
컨테이너가 분산 컨테이너 설정에서 VM간의 세션을 옮겨갈 때 HttpSessionActivationListener인터페이스를 구현하는 모든 Session의 속성을 알려준다.


[1단계:확인] 3. 스프링 웹에서 로그인 후, session 설정하여, 성공했을 때는 main페이지(@@@ 로그인중), 실패시는 login 페이지로 나타나게 처리하세요.
	   public String login(Member m, Model d, HttpSession session) {
	      if(m.getId()==null) {
	         d.addAttribute("msg", "메인페이지"); 
	         return "WEB-INF\view\a01_boardList.jsp";
	      }else (dao.login(m)==null) {
	         d.addAttribute("msg", "로그인 실패");
	         return "WEB-INF\view\a04_login.jsp";
	      }

[1단계:확인] 4. 위에서 main페이지 메뉴 리스트를 설정하여, 관리자 권한만 있는 사용자만 접속할 수 있는 페이지와 그렇지 않는 페이지를 설정하세요.
	      if(m.getId()==null) {
	         d.addAttribute("msg", "메인페이지"); 
	         return "WEB-INF\view\a01_boardList.jsp";
	      }else if(dao.login(m)==null) {
	         d.addAttribute("msg", "로그인 실패");
	         return "WEB-INF\view\a04_login.jsp";
	      }else {
	         session.setAttribute("mem", dao.login(m));
	         if(dao.login(m).getAuth().equals("관리자")) {
	            return "WEB-INF\\views\\mvc\\a00_main.jsp";
	         }else return "redirect:/list.do";
	      }
	   }
[1단계:개념] 5. 일반 인라인 css, 클래스선언과  vue 속성으로 선언하는 것의 차이점을 기술하세요.
css 속성을 객체로 전환하여, 동적으로 변환되어 속성값을 바꿀 수 있게
vue에서는 json형태의 객체로 선언이 가능하다.

[1단계:확인] 6. 선택 select  배경색상 : [빨/주/노/초/파/남/보] 글자색상 : [빨/주/노/초/파/남/보] 크기  [100px, 200px 300px]
               ==> 위에 선택한 내용을 따라서, 색상박스의  배경색상과 글자색상, 크기가 변경되게 처리하세요.
 <!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/springweb/a00_com/bootstrap.min.css" >
<style>
   td{text-align:center;}
</style>
<script src="/springweb/a00_com/jquery.min.js"></script>
<script src="/springweb/a00_com/bootstrap.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.js"></script>
<script src="https://developers.google.com/web/ilt/pwa/working-with-the-fetch-api" type="text/javascript"></script>
<script type="text/javascript">
/*
선택 select  배경색상 : [빨/주/노/초/파/남/보] 글자색상 : [빨/주/노/초/파/남/보] 크기  [100px, 200px 300px]
               ==> 위에 선택한 내용을 따라서, 색상박스의  배경색상과 글자색상, 크기가 변경되게 처리하세요.

 */
 $(document).ready(function(){
     var vm = new Vue({
        el:".container",
        data:{msg:"과제", p01:"orange", p02:"red", p03:"100px"}
     });   
  });
</script>
</head>
<body>
<style>

</style>
<div class="container">
   <div class="jumbotron text-center">
     <h2 >{{msg}}</h2>
     <select v-model="p01">
        <option>red</option>
        <option>orange</option>
        <option>yellow</option>
        <option>green</option>
        <option>blue</option>
        <option>navy</option>
        <option>purple</option>
     </select>
     <select v-model="p02">
        <option>red</option>
        <option>orange</option>
        <option>yellow</option>
        <option>green</option>
        <option>blue</option>
        <option>navy</option>
        <option>purple</option>
     </select>
     <select v-model="p03">
        <option>100px</option>
        <option>200px</option>
        <option>300px</option>
     </select>
     <h3 :style="{color:p01,backgroundColor:p02,fontSize:p03,}">적용시키기</h3>
   </div>
</div>
 
 
 
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
<div class="jumbotron text-center">
  <h2 data-toggle="modal" data-target="#exampleModalCenter">타이틀</h2>

</div>
<div class="container">
	<form id="frm01" class="form-inline"  method="post">
  	<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
	    <input class="form-control mr-sm-2" placeholder="제목" />
	    <input class="form-control mr-sm-2" placeholder="내용" />
	    <button class="btn btn-info" type="submit">Search</button>
 	</nav>
	</form>
   <table class="table table-hover table-striped">
   	<col width="10%">
   	<col width="50%">
   	<col width="15%">
   	<col width="15%">
   	<col width="10%">
    <thead>
    
      <tr class="table-success text-center">
        <th>번호</th>
        <th>제목</th>
        <th>작성자</th>
        <th>작성일</th>
        <th>조회</th>
      </tr>
    </thead>	
    <tbody>
    	<tr><td></td><td></td><td></td><td></td><td></td></tr>
    	<tr><td></td><td></td><td></td><td></td><td></td></tr>
    	<tr><td></td><td></td><td></td><td></td><td></td></tr>
    </tbody>
	</table>    
    
</div>
<div class="modal fade" id="exampleModalCenter" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
  <div class="modal-dialog modal-dialog-centered" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLongTitle">타이틀</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
		<form id="frm02" class="form"  method="post">
	     <div class="row">
	      <div class="col">
	        <input type="text" class="form-control" placeholder="사원명 입력" name="ename">
	      </div>
	      <div class="col">
	        <input type="text" class="form-control" placeholder="직책명 입력" name="job">
	      </div>
	     </div>
	    </form> 
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
        <button type="button" class="btn btn-primary">Save changes</button>
      </div>
    </div>
  </div>
</div>
</body>
</html>