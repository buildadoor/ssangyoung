<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="java.util.*"    
    import="jspexp.vo.*"
    import="jspexp.a13_database.*"    
    import="jspexp.a13_database.vo.*"     
    %>
   <%
  request.setCharacterEncoding("utf-8");
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
<div id="container"></div>
<%-- 
#세션생성
--%>
<%
Member m = new Member("홍길동","관리자");
session.setAttribute("mem",m);
%>
<h2>세션 생성</h2>
<h3>세션 확인하러 가깅</h3>
</body>
<script type="text/javascript">
document.querySelector("h3").onclick=function(){
	location.href="a04_sessionMenu.jsp";
}
/*

 */

var div = document.querySelector("#container")
div.innerHTML+="<br>"
</script>
</html>