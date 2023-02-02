<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="java.util.*"    
    import="jspexp.vo.*"
    import="javaexp.sql.*"
    import="jspexp.a13_database.*"    
    import="jspexp.a13_database.vo.*"     
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>회원가입</title>
</head>
<style>
@import url(a1_top.css);  
h2{text-align:center;}
td{
	font-size:20px;}
#bt{background:indigo;
	color:white;
	font-size:23px;
	margin-left:48%}
table{margin:0 auto;}
</style>

<script type="text/javascript">
function ckId(obj){
	var len = obj.value.length
	var spanOb = document.querySelector("#check")
	var msg = "4자~10자만 가능합니다."
	spanOb.style.color="red"
	if(len>=4 && len<=10){
		msg = "유효한 아이디입력"
			spanOb.style.color="indigo"
}
	spanOb.innerText = msg
}
function ckValid(){
	   var uname = document.querySelector("[name=uname]")
	   var unameV = uname.value.trim();
	   var rrn = document.querySelector("[name=rrn]")
	   var rrnV = rrn.value.trim();
	   var address = document.querySelector("[name=address]")
	   var addressV = address.value.trim();
	   var id = document.querySelector("[name=id]")
	   var idV = id.value.trim();
	   var password = document.querySelector("[name=password]")
	   var passwordV = password.value.trim();
	   if(unameV==""){
	      alert("이름은 필수사항입니다.")
	      uname.focus()
	      return;
	   }
	   if(rrnV==""){
	      alert("주민등록번호는 필수사항입니다.")
	      rrn.focus()
	      return;
	   }
	   if(addressV==""){
	      alert("주소는 필수사항입니다.")
	      address.focus()
	      return;
	   }
	   if(idV==""){
	      alert("아이디는 필수사항입니다.")
	      id.focus()
	      return;
	   }
	   if(passwordV==""){
	      alert("비밀번호는 필수사항입니다.")
	      password.focus()
	      return;
	   }
	   document.querySelector("form").submit();
	}
    </script>
<body>
<jsp:include page="top.jsp"></jsp:include> 
<br><br><br>
<form >
</form>
<b><br><br><h2>회원가입</h2></b><br><hr>
<form method="post" action="a.jsp">
<table><tr><td>
	아이디</td><td><input type="text" name="id" onkeyup="ckId(this)" placeholder="아이디를 입력하세요"/>
		<input type="submit" value="중복여부" />
		<span id="check"></span><br>
</form></td></tr>
<tr><td>비밀번호</td><td><input type="password" name="password" placeholder="비밀번호를 입력하세요"></td></tr>
<tr><td>이름</td><td><input type="text" name="uname" placeholder="이름을 입력하세요"></td></tr>
<tr><td>주민등록번호</td><td><input type="text" name="rrn" placeholder="'-'을 포함하여 입력하세요" ></td></tr>
<tr><td>핸드폰번호</td><td><input type="text" name="phonenumber" placeholder="'-'을 포함하여 입력하세요"></td></tr>
<tr><td>주소</td><td><input type="text" name="address" placeholder="주소를 입력하세요"></td></tr>
</table>
<br>
<input type="submit" value="회원가입" onclick="ckValid()" id="bt"><br>
<%
String hasId = (String)request.getAttribute("hasId");
boolean isCheck = false;
if(hasId!=null){
		isCheck = true;
}
String id = request.getParameter("id");
%>
<script type="text/javascript">
var isCheck = <%=isCheck%>
if(isCheck){
	var hasId = "<%=hasId%>"
	if(hasId=="Y"){
		alert("등록된 아이디가 있습니다.");
	}else{
		alert("등록 가능한 아이디입니다.");
		document.querySelector("[name=id]").value="<%=id%>"
	}
}
</script>
<%
String uname = request.getParameter("uname"); 
String rrn = request.getParameter("rrn");
String address = request.getParameter("address");
String phonenumber = request.getParameter("phonenumber");
String id2 = request.getParameter("id");
String password = request.getParameter("password");
String pointS = request.getParameter("point");
int point = 0;
String div = "회원";

boolean isInsert = false;
if(id!=null&& !id.equals("")){
   User ins = new User(div, uname, rrn, address, phonenumber, id, password);
  Join dao = new Join();
   dao.insertKurlyuser(ins);
   isInsert = true;
}

%>
</body>
<script>

document.querySelector("table").submit();

</script>
</html>