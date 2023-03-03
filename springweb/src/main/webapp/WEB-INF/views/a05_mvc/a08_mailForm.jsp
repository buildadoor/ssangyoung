<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="java.util.*"
    %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="path" value="${pageContext.request.contextPath }"/>
<fmt:requestEncoding value="utf-8"/>     
<!DOCTYPE html>
<%--


 --%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${path}/a00_com/bootstrap.min.css" >
<link rel="stylesheet" href="${path}/a00_com/jquery-ui.css" >

<style>
	.input-group-text{width:100%;background-color:linen;
		color:black;font-weight:bolder;}
	.input-group-prepend{width:20%;}
	#chatArea{
		width:80%;height:200px;overflow-y:auto;text-align:left;
		border:1px solid green;
	}
</style>
<script src="${path}/a00_com/jquery.min.js"></script>
<script src="${path}/a00_com/popper.min.js"></script>
<script src="${path}/a00_com/bootstrap.min.js"></script>
<script src="${path}/a00_com/jquery-ui.js"></script>
<script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.js"></script>
<script src="https://developers.google.com/web/ilt/pwa/working-with-the-fetch-api" type="text/javascript"></script>
<script type="text/javascript">
	$(document).ready(function(){
		<%-- 
		
		--%>	
		var msg = "${msg}"
		if(msg!=""){
			alert(msg)
		}
	});
</script>
</head>

<body>
<div class="jumbotron text-center">
  <h2>메일 발송</h2>
</div>
<div class="container">
	<form id="frm01" class="form" action="${path}/mailSender.do" method="post">
		<div class="input-group mb-3">	
			<div class="input-group-prepend">
				<span class="input-group-text  justify-content-center">수신자</span>
			</div>
			<input name="receiver"  placeholder="수신자 메일 주소 입력하세요" class="form-control" value=""/>
		</div>	
		<div class="input-group mb-3">	
			<div class="input-group-prepend">
				<span class="input-group-text  justify-content-center">발신자</span>
			</div>
			<input  value="janexagnes@gmail.com" class="form-control" readonly/>
		</div>	
		<div class="input-group mb-3">	
			<div class="input-group-prepend">
				<span class="input-group-text  justify-content-center">제 목</span>
			</div>
			<input name="title"  placeholder="제목을 입력하세요" class="form-control" value=""/>
		</div>					
		<div class="input-group mb-3">	
			<div class="input-group-prepend">
				<span class="input-group-text  justify-content-center">내용</span>
			</div>
			<textarea name="content" rows="10"  class="form-control" ></textarea>
		</div>		
		<div class="text-right">
			<button class="btn btn-success">메일발송</button>
		</div>
	</form>
</div>		
</body>
</body>
</html>