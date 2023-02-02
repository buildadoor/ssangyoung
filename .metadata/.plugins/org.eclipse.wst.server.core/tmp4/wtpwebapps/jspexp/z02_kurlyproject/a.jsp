<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="java.util.*"    
    import="jspexp.vo.*"
    import="jspexp.a13_database.*"    
    import="jspexp.a13_database.vo.*"     
    %>
<title>ID 중복 확인</title>
<script type="text/javascript">


</script>
</head>
<body>

<%
String id = request.getParameter("id");
if(id!=null){
   LoginDao Dao = new LoginDao();
   request.setAttribute("hasId",Dao.checkId(id)?"Y":"N");
   // dao.checkId(id) boolean값으로 처리된다.
%>
   <jsp:forward page="join.jsp"/>
<%}%>


</body>
</html>