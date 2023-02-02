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
<%-- 


ex)a15_sessionExp.jsp 물건명 가격 갯수 구매처를 각 4가지 session 범위로
설정하여 출력하고, session 범위 확인 클릭시, a16_showSession.jsp로 4가지 session범위에
해당하는지 확인하세요.

--%>
<%
pageContext.setAttribute("pname","사과()");
request.setAttribute("age",3000);
session.setAttribute("cnt",4);
application.setAttribute("bloc","이마트(application)");
%>
<h2>물건명 page : <%=pageContext.getAttribute("pname") %></h2>
<h2>가격 request : <%=request.getAttribute("age") %></h2>
<h2>갯수 session : <%=session.getAttribute("cnt") %></h2>
<h2>구매처 application : <%=application.getAttribute("bloc")%></h2>
<a href="a16_showSession.jsp"> session테스트를 합니다.</a>
</body>
<script type="text/javascript">

/*

 */

var div = document.querySelector("#container")
div.innerHTML+="<br>"
</script>
</html>