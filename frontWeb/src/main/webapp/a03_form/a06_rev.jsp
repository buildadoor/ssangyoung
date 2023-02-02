<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
	//post방식에서 한글요청값을 받을 때, 반드시 설정되어야 한다.
	//a05_rev.jsp
	request.setCharacterEncoding("utf-8");

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>구매할 물품명:${param.pname}</h2>
<h2>구매할 가격:${param.price}</h2>
</body>
</html>