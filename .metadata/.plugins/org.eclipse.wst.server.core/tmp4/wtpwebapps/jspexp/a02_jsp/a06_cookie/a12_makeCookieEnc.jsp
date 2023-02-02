<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="java.util.*"    
    import="jspexp.vo.*"
    import="jspexp.a13_database.*"    
    import="jspexp.a13_database.vo.*"   
    import="java.net.URLEncoder"  
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
#쿠키만들기(한글처리)
1. 설정 
	    import="java.net.URLEncoder"  
	URLEncoder.encoder("쿠키의 key/value값","utf-8")
	ex) new Cookie(URLEncoder.encodr("홍길동","utf-8")
2. 쿠키값 가져오기
	import="java.net.URLDecoder"
	URLDecoder.decode("저장된 쿠키key/value값","utf-8")
	ex) for(Cookie ck : request.getCookies(){
		URLDecoder.decode(ck.getName(),"utf-8");
		URLDecoder.decode(ck.getValue(),"utf-8");
	}
--%>
<%
	//1. 쿠키만들기
	String key=URLEncoder.encode("이름","UTF-8");
	String val=URLEncoder.encode("홍길동","UTF-8");
	Cookie c1 = new Cookie(key,val);
	response.addCookie(c1);
	%>

	
	<h2>쿠키 굽기 완료~</h2>
	<a href="a13_showCookie.jsp">내가 만든 쿠키~🍪🍪🍪🍪</a>



</body>
<script type="text/javascript">
/*

 */

var div = document.querySelector("#container")
div.innerHTML+="<br>"
</script>
</html>