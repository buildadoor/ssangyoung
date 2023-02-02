<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//post
	request.setCharacterEncoding("utf-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 
	ex) a09_sellProduct.jsp
		물건명:[ ] 구매갯수:[ ]
		[구매]
		
		구매내역
		물건명: @@@
		갯수: @@
	 -->
<h2>구매처리</h2>
	<form method="post">
	물건명: <input type="text" name="pname"/><br>
	가격: <input type="text" name="price"/><br>
	구매갯수:<input type="text" name="cnt"/><br>
	  	<input type="submit" value="구매"/>
	</form>
	
	<h3>구매내역</h3>
	<h4>물건명:${param.pname}</h4>
	<h4>가격:${param.price}</h4>
	<h4>갯수:${param.cnt}</h4>
	<h4>총계:${param.price*param.cnt}</h4>
</body>
</html>