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
<div id="container"></div>
<form>
	아이디:<input type="text" name="id"/>
	<input type="submit"/>
</form>
	<%
	String id = request.getParameter("id");
	if(id!=null){
		if(id.equals("himan")){
	%>
			<jsp:forward page="a19_main.jsp"/>
		<% }else{%>
			<jsp:forward page="a20_error.jsp"/>
		<%}%>
	<%
	}
	 %>

<%-- a19_main.jsp 
		<h2><%=request.getParameter("id")%>로그인 성공</h2>
	a20_error.jsp 	
		<h2><%=request.getParameter("id")%>로그인 실패</h2>
--%>
</body>
<script type="text/javascript">
/*

 */

var div = document.querySelector("#container")
div.innerHTML+="<br>"
</script>
</html>