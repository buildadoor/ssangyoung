<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="java.util.*"  
    import="jspexp.vo.*"  
    import="jspexp.a13_database.*"
   %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:requestEncoding value="UTF-8" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="/a00_com/a01_common.css" rel="stylesheet">
<script>
/*
 
 */
</script>
</head>
<body>
<%
//특정한 session 삭제
session.removeAttribute("sesMem");
//session.invalidate(): 모든 세션값 날리기 

//쿠키 삭제 1.
/*
Cookie[] cookies=request.getCookies();
if(cookies!=null){
	for()
}
*/
//쿠키 삭제 2.
Cookie c1 = new Cookie("id","");
Cookie c2 = new Cookie("pass","");
c1.setMaxAge(0); c2.setMaxAge(0);
response.addCookie(c1);
response.addCookie(c2);
%>
	<script type="text/javascript">
	alert("로그아웃!!");
	location.href="a10_loginAuto.jsp";
	</script>
</body>
<script>
/*

 */
</script>
</html>