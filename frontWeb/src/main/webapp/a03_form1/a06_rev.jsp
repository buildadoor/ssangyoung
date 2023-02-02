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
	<h2>주문메뉴:${param.coffee}</h2>
	<h2>주문갯수:${param.coffeecnt}</h2>


	<h2>등록된 물건:${param.pname}</h2>
	<h2>등록된 물건가격:${param.pprice}</h2>
	
	<h2>구매과일:${param.fruits}</h2>
	<h2>구매가격:${param.fruitsprice}</h2>
</body>
</html>