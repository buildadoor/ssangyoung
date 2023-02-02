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
<%-- 범위별로 session scope로 데이터 설정 --%>

<%
pageContext.setAttribute("pname01","마우스(판매물품page)");
application.setAttribute("pname02","키보드(장바구니application)");
%>
<h2><%=pageContext.getAttribute("pname01") %></h2>
<h2><%=application.getAttribute("pname02") %></h2>
<a href="a07_show.jsp">장바구니 확인</a>

</body>
<script type="text/javascript">
/*

 */
</script>
</html>