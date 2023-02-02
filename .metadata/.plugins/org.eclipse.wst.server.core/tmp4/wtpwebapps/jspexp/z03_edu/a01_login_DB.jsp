<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="java.util.*"    
    import="jspexp.a13_database.*"    
    import="jspexp.a13_database.vo.*"     
    %>
<%
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
<style>
h1{
margin-top:12%;
font-size:40px;
color:white;
text-shadow: 6px 2px 2px black;

}
form{
  margin-top:3%
  }
#id,#pass{
  display: flex;
  width: 15%;
  padding: 12px;
  border: 1px solid navy;
  border-radius: 4px;
  resize: vertical;
  margin : 0 auto;
}
input[type=submit] {
  background:#0066CC;
  color: white;
  padding: 12px 20px;
  border: none;
  border-radius: 4px;
  cursor: pointer;
  float: right;
}
#login{
margin-top:1%;
margin-right:48%;
}
</style>
     
<script type="text/javascript">
</script>
</head>
	<body style="background-image:url('img/backimg.jpg'); background-size: 100%">
	<style>
	@import url(a1_top.css);  
	</style>
	  <h1 align="center">사람을 변화시키는 교육, 세상을 변화시키는 대학</h1>

      <c:remove var="mem" scope="session"/>
      <form method="get" action="a02_makeSession_DB.jsp">
         <input type="text" name="id" placeholder="아이디(학번)를 입력하세요" id="id"><br>
         <input type="password" name="password" placeholder="비밀번호를 입력하세요"id="pass"><br>
         <input type="submit" value="로그인" id="login">
      </form>
   </body>
   <script type="text/javascript">
   /*
      
   */
   </script>
</html>