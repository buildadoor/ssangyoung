<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="java.util.*"    
    import="jspexp.vo.*"
    import="javaexp.sql.*"
    import="jspexp.a13_database.*"    
    import="jspexp.a13_database.vo.*"     
    %>
<%
	// post방식에서 한글요청값을 받을 때, 반드시 설정되어야한다.
	request.setCharacterEncoding("utf-8");
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:requestEncoding value="UTF-8"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>쌍용 대학교</title>
<link href="main.css" type="text/css" rel="stylesheet">
<script type="text/javascript" src="http://code.jquery.com/jquery-1.8.3.min.js"></script>
</head>
<body>


</body>
<script type="text/javascript">
<%String id = request.getParameter("id");
String address = request.getParameter("address"); 
String stdPhone = request.getParameter("stdPhone"); 
String stdEmail = request.getParameter("stdEmail"); 
String proc = request.getParameter("proc");
if( proc!=null && proc.equals("upt") ){
	Student01 upt = new Student01(address, stdPhone, stdEmail, id);
	UniversityDao dao = new UniversityDao();
	dao.uptInform(upt);
	response.sendRedirect("std_inform_sch.jsp");
}%>
</script>
</html>