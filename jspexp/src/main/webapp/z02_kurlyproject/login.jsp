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
<title>로그인 페이지</title>
<link href="logo.ico" rel="shortcut icon" type="image/x-icon">
<style>

#id,#pass{
  display: flex;
  width: 15%;
  padding: 12px;
  border: 1px solid indigo;
  border-radius: 4px;
  resize: vertical;
  margin : 0 auto;
}

input[type=button], input[type=submit] {
  background-color: indigo;
  color: white;
  padding: 12px 20px;
  border: none;
  border-radius: 4px;
  cursor: pointer;
  float: right;
}
input[type=button]:hover, input[type=submit]:hover {
  background-color: indigo;
}
#login{
margin-right:48%
}

</style>
<script type="text/javascript">

</script>
</head>
<body>
<style>
@import url(a1_top.css);  
</style>
<jsp:include page="top.jsp"></jsp:include> <br><br><br><br><br>

<h3 align="center">로그인</h3>
<form>
	<br><input type="text" name="id" placeholder="아이디를 입력하세요" id="id"/><br>
	<br><input type="password" name="password" placeholder="비밀번호를 입력하세요"id="id"/><br>
	<input type="submit" value="로그인" id="login" onclick="ckValid()"/>
</form>
<%
String id = request.getParameter("id");
String password = request.getParameter("password");
boolean isFail = false;
if(id!=null&&password!=null){
	LoginDao dao = new LoginDao();
	if(dao.login(id, password)){
		session.setAttribute("id",id);
		response.sendRedirect("like.jsp");
	}else{
		isFail =true;
	}
}
%>
</body>
<script type="text/javascript">

	function ckValid(){
		   var id = document.querySelector("[name=id]")
		   var idV = id.value.trim();
		   var password = document.querySelector("[name=password]")
		   var passwordV = password.value.trim();
		   if(idV==""){
		      alert("아이디를 입력해주세요.")
		      id.focus()
		      return;
		   }
		   if(passwordV==""){
		      alert("비밀번호를 입력해주세요.")
		      password.focus()
		      return;
		   }
		   document.querySelector("form").submit();
		}
	var isFail =<%=isFail%>
	if(isFail){
		alert("<%=id%>님 로그인 실패\n아이디 비밀번호 오류입니다.")
	}

</script>
</html>