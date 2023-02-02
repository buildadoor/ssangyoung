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
<script>
/*
 
 */
</script>
</head>
<body>
<% 
String low=request.getParameter("low");      if(low==null) low="0";
String hi=request.getParameter("hi");      if(hi==null) hi="9999";
int losalInt = Integer.parseInt(low);
int hisalInt = Integer.parseInt(hi);
A04_salgrade SDao = new A04_salgrade();
SalGrade sch3 = new SalGrade(losalInt, hisalInt);
%>
<form>
   <table>
      <tr><th>최저등급</th><td colspan="2"><input type="text" name="low" value="<%=low %>"/></td></tr>
      <tr><th>최고등급</th><td colspan="2"><input type="text" name="hi" value="<%=hi %>"/></td></tr>
      <tr><td colspan="3"><input type="submit" value="검색"/></td>
      <tr><td colspan="3"><input type="button" value="등록" onclick="insertSalgrade()"/></td>
      </tr>
   </table>
</form>

<table>
         <tr><th>등급</th><th>최저연봉</th><th>최고연봉</th></tr>
         <%
         for(SalGrade s:SDao.getGradeSch(sch3)){
         %>
         <tr>
            <td><%=s.getGrade() %></td>
            <td><%=s.getLowsal() %></td>
            <td><%=s.getHisal() %></td>
         </tr>
         <%} %>
      </table>
	
</body>
<script>
function insertSalgrade(){
	if(confirm("등록하시겠습니까?")){
	location.href="z04_insertSal.jsp"
	}
}
/*

 */
</script>
</html>