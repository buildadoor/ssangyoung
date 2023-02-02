<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="java.util.*"
    import="jspexp.a13_database.*"
    import="jspexp.a13_database.vo.*" %>
<%
	// post방식에서 한글요청값을 받을 때, 반드시 설정되어야한다.
	request.setCharacterEncoding("utf-8");
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:requestEncoding value="UTF-8"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>쌍용 대학교</title>
<link href="main.css" type="text/css" rel="stylesheet">
<script type="text/javascript" src="http://code.jquery.com/jquery-1.8.3.min.js"></script>
<style>
#bt2{
font-size: 20px;
border-radius:4px; 
background:#0066CC;
color:white;
border:1px solid gray;
}
textarea {
width: 95%;
height: 350px;
padding: 10px;
font-size: 20px;
}
fieldset{
height: 100px;
background-color:#D5D5D5;
}
</style>
</head>
<body>
<div style="margin:20px;">
	<form>
		<h2><span id="lecNum" style="display:none">${param.lecNum}</span>
			<span id="id" style="display:none">${param.id}</span>강의평가</h2><hr>
	    <fieldset>
		<h3>Q. 이번 강의에서 좋았던 점, 개선사항 또는 건의사항이 있으면 기재해 주시기 바랍니다.
			(강의평가는 한번만 가능하며, 수정이 불가합니다.)</h3>
		</fieldset>
		<textarea id="lecEval" name="lecEval" style="margin-top:10px;" rows="50" cols="60"></textarea>
		<div style="margin-top:10px;" align="center">
		<input type="button" id="bt2" value="제출" onclick="return goExit()"/>
		</div>
	</form>
</div>
</body>
<script type="text/javascript">
function goExit(){
	var lecEval = document.querySelector("[name=lecEval]").value
	if(lecEval==""){
		alert("내용을 입력해주세요.")
		address.focus();
		return false;
	}else{
		location.href="std_lecEval_sub.jsp?lecEval="+lecEval+"&lecNum="+${param.lecNum}+"&id="+${param.id}
	}
}
</script>
</html>