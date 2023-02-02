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
<%
Member m = (Member)session.getAttribute("name");
boolean hasSess = m!=null;
log("log(hasSess):"+hasSess);
if(hasSess){
%>
	<h2>세션값 확인</h2>
	<h3>이름:<%=m.getName()%></h3>
	<h3>권한:<%=m.getAuth() %></h3>
<%} %>
</body>


<script type="text/javascript">
var hasSess = <%=hasSess%>
if(hasSess){
	alert("해당 메뉴 권한이 없습니다.\n 세션 설정하시겠습니가?")
	location.href="a03_afterLogin.jsp"
}
/*

 */

var div = document.querySelector("#container")
div.innerHTML+="<br>"
</script>
</html>