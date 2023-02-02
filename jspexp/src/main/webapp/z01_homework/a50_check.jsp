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
#
--%>
<h2>요청 내용에 따른 분기 처리..</h2>
<%
String pname = request.getParameter("pname");
if(pname!=null){
	String page01="";
	if(pname.equals("사과")){
		request.setAttribute("msg","재고 있음");
		page01="a53_main.jsp";
	}else{
		request.setAttribute("msg","재고 없음");
		page01="a54_main.jsp";
	}
	RequestDispatcher rd = request.getRequestDispatcher(page01);
	rd.forward(request,response);
}
%>

</body>
<script type="text/javascript">
/*

 */

var div = document.querySelector("#container")
div.innerHTML+="<br>"
</script>
</html>