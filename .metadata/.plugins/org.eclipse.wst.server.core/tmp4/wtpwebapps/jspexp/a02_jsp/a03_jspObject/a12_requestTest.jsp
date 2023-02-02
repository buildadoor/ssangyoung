<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="java.util.*"    
    import="jspexp.vo.*"
    import="jspexp.a13_database.*"    
    import="jspexp.a13_database.vo.*"     
    %>
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
<body>

<%-- 
ex)
a12_requestTest.jsp
0. 현재 페이지에서 page 설정한 내용
	이 페이지에서 page scope 데이터를 이름으로 설정하고,
	request scope 데이터를 나이로 설정한다.
	요청페이지 이동으로 a href = "a13_requestForward.jsp" 
	이동되게 처리한다. 
	
1. a13_requestForward.jsp
	이 페이지에서 page scope 데이터를 이름으로 설정하고,
	request scope 데이터를 나이로 설정한다.
	request foward 처리 
2. a14_showSessionView.jsp
	page scope 데이터인 이름과 request scope 데이터인 나이를 출력하세요
--%>

<%
pageContext.setAttribute("name","홍길동");
request.setAttribute("age",25);
%>

<h2>페이지 범위 데이터: <%=pageContext.getAttribute("name")%></h2>
<h2>페이지 범위 데이터: <%=request.getAttribute("age")%></h2>
<a href = "a13_requestForward.jsp">요청범위확인</a>
<script type="text/javascript">
/*

 */
</script>
</html>