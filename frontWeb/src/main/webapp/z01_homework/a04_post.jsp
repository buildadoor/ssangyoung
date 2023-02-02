<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("utf-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>도서명:${param.bname}</h3>
<h3>출판사:${param.company}</h3>
<h3>가격:${param.bprice} </h3>
</body>
</html>