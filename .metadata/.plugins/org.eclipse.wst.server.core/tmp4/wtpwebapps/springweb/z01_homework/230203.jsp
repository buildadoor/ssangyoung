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
2023-02-03
[1단계:개념] 1. 스프링의 container파일명과 위치를 변경하는 web.xml 설정부분을 기술하세요.
컨테이너 분리
   <init-param>
            <param-name>contextConfigLocation</param-name>
            <param-value>classpath:resource/a01_container.xml</param-value>
    </init-param>

[1단계:개념] 2. 스프링의 공통 정보를 설정할려고 하는 컨테이너 설정 내용과 사용 방법을 기술하세요.
설정 파일 - DB접속, 파일업로드 ..
   <context:property-placeholder 
      location="classpath:resource/a00_config"/>
   a00_config
      jdbc.driver = oracle.jdbc.driver.OracleDriver 
      jdbc.url= jdbc:oracle:thin:@localhost:1521:xe
      jdbc.user=scott
      jdbc.pass=tiger 

[1단계:개념] 3. 스프링의 jsp뷰단에 설정을 하려고 한다, 처리할 내용을 기술하세요.
   <bean class="org.springframework.web.servlet.view.InternalResourceViewResolver">
         <property name="order" value="1"/>
         <property name="prefix" value="/WEB-INF/view/"/>
         <property name="suffix" value=".jsp"/> 
[1단계:개념] 4. 게시판의 핵심 기능을 DB설계, 화면 구현을 나누어서 설명하세요.
- DB설계
    1) db생성/기본 데이터 입력
   2) 조회를 위한 sql
   3) vo 작성 
   4) 공통 mybatis 등록 
   5) dao
   6) mapper처리
   - 화면 설계
   1) controller를 통한 초기 화면 호출-url mapping
    2) 초기 조회 화면 구현 (UI구현)
   3) 비지니스 로직 처리(service)
   4) controller - public String boardList(Board sch, Model d)
   5) 화면단 list <c:forEach var="" items="">   

[1단계:확인] 5. 현재 프로젝트에 게시판 내용이 있으면 적용하고, 적용된 거 올리고, 아니면 아래와 같이 진행해주세요
      1) boardexp 프로젝트를 만들어서 스프링을 처리할 수 있게 설정하고 boardexp/listexp.do로 게시판 초기화면이 로딩되게 하세요.
      2) BoardExp.java로  VO를 만들고, boardexp테이블(bno, title, writer,  rcnt, credte) /boardexp_seq를 만들어 기본 조회리스트가 나오게 처리하세요 

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