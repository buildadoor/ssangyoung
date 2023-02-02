<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    //post방식에서 한글 요청값을 받을때 반드시 설정해주어야 한다.
    // a05_rev.jsp
     request.setCharacterEncoding("UTF-8");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!--  <h2>검색된 내용:${param.sch}</h2>-->
	
	<h3>도서명:${param.bname}</h3>
	<h3>출판사:${param.publisher}</h3>
	<h3>가격:${param.price}</h3>
	<div style="background-color:skyblue">
	<h2>1103 일일과제 예시4번</h2>
	<h3>내용:${param.exp1103}</h3></div>
</body>
</html>