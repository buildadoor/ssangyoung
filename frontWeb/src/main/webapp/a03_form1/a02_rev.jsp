<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
 	<h2>서버에서 입력받은 아이디와 패스워드</h2>
 	<h3>아이디:${param.id}</h3>
 		<!-- name="id"를 이 친구가 받는다. -->
 	<h3>아이디:${param.pass}</h3>
 		<!-- name="pass"를 이 친구가 받는다. -->
 		
 		<hr>
 	<h2>1102 예제 10번 ㅎㅎ</h2>
 	<h3>아이디:${param.expid}</h3>
 	<h3>비밀번호:${param.exppass}</h3>
 	<h3>포인트:${param.exppoint}</h3>
 	<h3>구분:${param.expdiv}</h3>
</body>
</html>