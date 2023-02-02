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
<%@ taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix = "fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
 <fmt:requestEncoding value="UTF-8"/>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>쌍용대학교</title>
		<link href="img/ss.png" rel="shortcut icon" type="image/x-icon">
		<style type="text/css">
			table, tr, td{
				border: 2px solid rgb(204, 204, 204);
				border-collapse: collapse;
			}
			
			
			table thead {
				background-color: rgba(204, 204, 204, 0.46);
				height: 80px;
			}
			table tbody tr{
				height: 30px;
				font-size: 13px;
			}
			th{
		    	padding: 0px 40px 0px 40px;
		    }
			td{
		    	padding: 0px 10px 0px 10px;
		    }
			
		</style>
	</head>
	<body>
		<h2>&nbsp;강 의 평 가</h2>
		<hr>
		<br>
		<jsp:useBean id="dao" class="jspexp.a13_database.A02_stdLecture"/>
		<jsp:useBean id="sch" class="jspexp.a13_database.StdLecture"/>
		<jsp:setProperty property="*" name="sch"/>
		<%
			String lecNum = request.getParameter("lecNum");
			int lecNumInt = 0;
			if(lecNum != null) lecNumInt = Integer.parseInt(lecNum);
			session.setAttribute("lecNum", lecNumInt);
			
			if(lecNum != null){
		%>
			<c:if test="${lecNum eq lecNumInt}">${sch.setLecNum(lecNumInt)}</c:if>
		<% } %>
		<table>
			<thead>
				<tr><th> Q. 이 강의에서 좋았던 점, 개선사항 또는 건의사항이 있으면 기재해주시기 바랍니다. </th></tr>
			</thead>
			<tbody>
				<c:forEach var="std" items="${dao.getListEval(sch)}">
				<tr>
					<td>${std.lecEval}</td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
	</body>
	<script type="text/javascript">
	/*
		
	*/
	</script>
</html>