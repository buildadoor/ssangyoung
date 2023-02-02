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
<h2>로그인</h2>
<form action="z11_checkValid.jsp" method="post">
	아이디:<input type="text" name="id"/>
	패스워드:<input type="password" name="pass"/>
	<input type="submit" value="로그인"/>
</form>
<%
String id = request.getParameter("id");
		boolean isInvalid = false;
		if(id!=null){
			isInvalid = true;
		}
 %>		
</body>
<script type="text/javascript">
var isInvalid = <%=isInvalid%>;
if(isInvalid) alert("<%=id%>는 인증된 계정이 아닙니다");
</script>
</html>