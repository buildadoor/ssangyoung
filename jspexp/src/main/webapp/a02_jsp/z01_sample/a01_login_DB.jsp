<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="java.util.*"
    import="jspexp.vo.*"
    import="jspexp.a13_database.*"
    import="jspexp.a13_database.vo.*"%>
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
      <title>Insert title here</title>
      <link href="/a00_com/a01_common.css" rel="stylesheet">
      <script type="text/javascript">
      /*
      
      */
      </script>
   </head>
   <body>
   <%--로그아웃을 하거나 로그인할 때, 기존의 session을 
   필요없으므로 초기화 처리 --%>
      <c:remove var="mem" scope="session"/>
      <h2>로그인 페이지</h2>
      <form method="post" action="a02_makeSession_DB.jsp">
         아이디 : <input type="text" name="id">
         패스워드 : <input type="password" name="pass">
         <input type="submit" value="로그인">
      </form>
   </body>
   <script type="text/javascript">
   /*
      
   */
   </script>
</html>