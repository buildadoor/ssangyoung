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
<%-- 
#	<!-- logEnagled debugLevel-->

ex) web.xml name, age, loc로 데이터를 할당하고, 화면에서 출력하세요.
--%>
<h2>초기 서버 설정값</h2>
<h3>logEnagled:<%=application.getInitParameter("logEnagled") %></h3>
<h3>debugLevel:<%=application.getInitParameter("debugLevel") %></h3>
<h2>회원정보</h2>
<h3>이름:<%=application.getInitParameter("name") %></h3>
<h3>나이:<%=application.getInitParameter("age") %></h3>
<h3>지역:<%=application.getInitParameter("loc") %></h3>
<h3>한번에 설정값 가져오기</h3>
<%
	Enumeration<String> initParams = application.getInitParameterNames();
	while(initParams.hasMoreElements()){
		String name = initParams.nextElement();
		out.println("<h4>"+name+":"+application.getInitParameter(name)+"</h4>");
	}
	application.log("@@@@ 서버 단위 로그####");
	log("@@@@@@@@@jsp 기본 로그@@@@@@@@@");
	
	
%>


</body>
<script type="text/javascript">
/*

 */
</script>
</html>