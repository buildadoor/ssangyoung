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
<form>
	아이디:<input type="text" name="id"/>
	<input type="submit"/>
</form>
	<%
	String id = request.getParameter("id");
	if(id!=null){
		String page01 = "a20_error.jsp";
		if(id.equals("himan")){
			page01="a19_main.jsp";
		}
	%>
		<jsp:forward page="<%=page01%>"/>
	<%
	}
	 %>

</body>
<script type="text/javascript">
/*

 */

var div = document.querySelector("#container")
div.innerHTML+="<br>"
</script>
</html>