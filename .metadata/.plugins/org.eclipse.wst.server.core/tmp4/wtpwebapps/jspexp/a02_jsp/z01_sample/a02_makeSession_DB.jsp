<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8" import="java.util.*" import="jspexp.vo.*"
   import="jspexp.a13_database.*" import="jspexp.a13_database.vo.*"%>
<%
    // post방식에서 한글요청값을 받을 때, 반드시 설정되어야한다.
    request.setCharacterEncoding("utf-8");
 %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<fmt:requestEncoding value="UTF-8" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="/a00_com/a01_common.css" rel="stylesheet">
<script type="text/javascript">
      /*
      
      */
      </script>
</head>
<%-- Bean DB를 로딩하고, 요청값을 받는 VO 객체 처리 --%>
<jsp:useBean id="dao" class="jspexp.a13_database.A06_PreparedDao" />
<%-- id, pass 값을 받는 객체 --%>
<jsp:useBean id="reMem" class="jspexp.vo.Member" />
<jsp:setProperty property="*" name="reMem" />
<body>
   <%-- dao를 통해서 객체가 있을 때만 session 객체 선언 --%>
   <c:if test="${not empty dao.login(reMem)}">
     	<c:set var="mem" scope="session" 
     		value="${dao.login(reMem)}" />
  <%--
	1. el : 객체를 생생된 내용을 선언한 참조값인
		reMem을 활용(${reMem}), 
		비교연산자 처리(${not empty dao.login(reMem)}
	2. jstl : 객체생성
		<c:set var="변수명 scope="session"
			value="${dao의 기능메서드}"
	--%>
   </c:if>
</body>
<script type="text/javascript">
      var isFail = '${mem.id}'
      if(isFail==''){
         alert("로그인 실패\n 로그인 페이지 이동")
         location.href="a01_login_DB.jsp"
      }else{
         alert("로그인 성공\n 메인페이지이동")
         location.href="a03_checkSession.jsp"
      }
   /*
      
   */
   </script>
</html>