<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2 align="center">로그인</h2>
	<table border="1" align="left" width="50%">
		<col width="50%">
		<col width="50%">
		<thead>
			<tr>
			<th>ID</th><th>PW</th></tr>
		</thead>
		<tbody>
			<tr><td>${param.id}</td><td>${param.pw}</td></tr>
		</tbody>
		<tr></tr>
	</table>
</body>
</html>