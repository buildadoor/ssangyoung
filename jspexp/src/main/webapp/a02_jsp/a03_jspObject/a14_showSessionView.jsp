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
<%
//page범위, request 범위를 저장하고
pageContext.setAttribute("name","홍길동");
request.setAttribute("age",25);
//화면에 오자마자 forward 처리 
request.getRequestDispatcher("a14_showSessionView.jsp").forward(request, response);
%>



<h1>page와 request 범위 확인 request에서 forward</h1>
<h2>이름: <%=pageContext.getAttribute("name")%></h2>
<h2>나이: <%=request.getAttribute("age")%></h2>

</body>
<script type="text/javascript">
/*

 */

 var div = document.querySelector("#container")
 div.innerHTML+="<br>"
</script>
</html>