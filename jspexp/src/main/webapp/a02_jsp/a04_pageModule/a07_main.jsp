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
<div id="container"></div>
<%-- 
#
--%>
<form>
	물건명 <input type="text" name="name"/>
	가격 <input type="text" name="price"/>
	 <input type="submit" name="구매"/>

</form>
</body>
<div style="border:1px solid indigo">
	<%@ include file="a08_sub.jsp" %>
	<h2><%=name %></h2>
	<h2><%=price %></h2>
</div>
<script type="text/javascript">
/*

 */

var div = document.querySelector("#container")
div.innerHTML+="<br>"
</script>
</html>