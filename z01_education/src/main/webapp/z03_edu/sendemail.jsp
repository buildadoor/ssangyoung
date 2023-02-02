<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="java.util.*"  
    import="jspexp.vo.*"  
    import="jspexp.a13_database.*"
   %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:requestEncoding value="UTF-8" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>이메일 발송</title>
<link href="/a00_com/a01_common.css" rel="stylesheet">
<style type="text/css">
.field {
  margin-bottom: 10px;
}

.field label {
  display: block;
  font-size: 15px;
  color: #777;
}

.field input {
  display: block;
  min-width: 250px;
  line-height: 1.5;
  font-size: 15px;
}

input[type="submit"] {
	height: 35px;
	margin-left: 97%;
	border-radius: 4px;
	background: #0066CC;
	color: white;
	border: 1px solid gray;
	font-size: 14px;
}

</style>
<script>
/*
 
 */
</script>
</head>
<body>
<form id="form">
  <div class="field">
    <label for="give_men">받는 사람 이메일</label>
    <input type="text" name="give_men" id="give_men">
  </div>
  <div class="field">
    <label for="to_name">받는 사람 이름</label>
    <input type="text" name="to_name" id="to_name">
  </div>
 <div class="field">
    <label for="message">내용</label>
    <textarea rows="34" cols="50" 
placeholder="내용을 입력해주세요" name="message"  id="message"></textarea>
  </div>
  <input type="submit" id="button" value="이메일 발송" >
</form>





<script type="text/javascript"
  src="https://cdn.jsdelivr.net/npm/@emailjs/browser@3/dist/email.min.js"></script>

<script type="text/javascript">
  emailjs.init('RiFbUdAbgZITXTWWa') //개인정보
</script>
<%--
# 

 --%>
<%

%>
</body>
<script>
const btn = document.getElementById('button');

document.getElementById('form')
 .addEventListener('submit', function(event) {
   event.preventDefault();

   btn.value = '메일 발송중...';

   const serviceID = 'default_service'; //개인정보
   const templateID = 'template_mqsdgau'; //개인정보

   emailjs.sendForm(serviceID, templateID, this)
    .then(() => {
      btn.value = 'Send Email';
      alert('메일이 발송되었습니다.\n학생 조회 페이지로 이동합니다.');
      location.href="search.jsp"
    }, (err) => {
      btn.value = 'Send Email';
      alert(JSON.stringify(err));
    });
});
/*

 */
</script>
</html>