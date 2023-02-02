<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
  import="java.util.*"  
  import="jspexp.vo.*"  
    import="jspexp.a13_database.*"    
    import="jspexp.a13_database.vo.*" 
     isErrorPage="true"
    %>
  <%
  request.setCharacterEncoding("utf-8");
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

<h2 align="center">numberFormat 예외 발생</h2>
   <h3 align="center">형변환에는 숫자를 입력해야합니다.</h3>
  <table>
     <tr><th><%=exception.getClass().getName() %></th></tr>
     <tr><th><%=exception.getMessage() %></th></tr>
  </table>
</body>
<script type="text/javascript">
/*
 
*/
</script>
</html>