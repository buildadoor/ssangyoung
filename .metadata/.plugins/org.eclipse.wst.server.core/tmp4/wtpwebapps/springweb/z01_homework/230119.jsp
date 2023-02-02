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
2023-01-19
[1단계:개념] 1. 스프링의 컨테이너 안에 backend단 처리순서를 기술하세요.

[1단계:확인] 2. 다음은 컨터이너 객체 처리방법입니다. 단계별로 처리하세요
               1) a01_diexp.z06_vo 패키지 만들기 1:1, 1:다 관계로 (물건, 마트)  (쇼핑몰,회원)클래스 선언
               2) di91.xml에 위 패키지 클래스 로딩 처리
               3) DIExp91.java에 해당 클래스 소스 코딩을 통해 autowire를 호출
[1단계:확인] *3. 다음은 컨터이너 객체 처리방법입니다. 단계별로 처리하세요
               1) a01_diexp.z07_web 패키지 만들기 controller, service, dao, A02_EmpDao.java(기본 dao 복사) 객체 할당.
               2) di92.xml에 위 패키지 클래스 로딩 처리
               3) DIExp92.java에 해당 클래스 소스 코딩을 통해 autowire를 호출 controller를 통해 사원정보 조회 출력하세요.
[1단계:개념] 4. mybatis 환경 설정 순서를 기술하세요.
	1) 마이바티즈라는 DB연동 처리하는 프레임워크를 활용해서 DB연동 sql 처리 
	2) 컨테이너에 DB연결 객체 선언
		DBCP연결 객체를 통해 드라이버, 아이피, 계정, 패스워드를 통해 연결
	3) mybatis 프레임워크 설정
		- 위 선언된 연결객체를 통해서,
		- mybatis 공통 xml 선언
			- 사용하게 될 sql을 처리하는 xml 선언 위치 
	4) 사용하게될 DAO 인터페이스 폴드 선언 : 이 폴드에서 선언된 인터페이스가 실제 dao객체와 연동
      
      
      
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
   
</script>
</head>

<body>
<div class="jumbotron text-center">
  <h2>과제</h2>
  <%--
  <h2 data-toggle="modal" data-target="#exampleModalCenter">
   --%>
</div>
<div class="container">
   
   	<h2>부서번호(autowiring처리)</h2>
    <table id="deptInfo" class="table table-hover table-striped">
      <col width="33%">
      <col width="33%">
      <col width="33%">
     <thead>
      <tr class="table-success text-center">
        <th>부서번호</th>
        <th>부서명</th>
        <th>부서위치</th>
      </tr>
    </thead>   
    <tbody>
		<td>${dept.deptno}</td><td>${dept.dname}</td><td>${dept.loc}</td>
    </tbody>
   </table>   
   
   
   
   
   <h2>회원리스트조회(ajax)</h2>
   <form id="frm02" class="form-inline"  method="post">
     <nav class="navbar navbar-expand-sm bg-dark navbar-dark">
       <input class="form-control mr-sm-2 sch" placeholder="회원명" name="name"/>
       <input class="form-control mr-sm-2 sch" placeholder="회원권한" name="auth" />
    </nav>
   </form>
   
   
   
   
   
   
   
   
   <table id="memList" class="table table-hover table-striped">
      <col width="25%">
      <col width="25%">
      <col width="25%">
      <col width="25%">
     <thead>
    
      <tr class="table-success text-center">
        <th>아이디</th>
        <th>이름</th>
        <th>포인트</th>
        <th>권한</th>
      </tr>
    </thead>   
    <tbody>
    </tbody>
   </table>   
   
   

   <h2>물건명 처리</h2>
   <form id="frm01" class="form-inline"  method="post">
     <nav class="navbar navbar-expand-sm bg-dark navbar-dark">
       <input class="form-control mr-sm-2 sch" placeholder="가격입력" name="price"/>
       <input class="form-control mr-sm-2 sch" placeholder="갯수입력" name="cnt" />
    </nav>
   </form>
  
    
</div>

</body>
</html>