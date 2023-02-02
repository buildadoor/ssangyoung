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
<title>Insert title here</title>
<link href="/a00_com/a01_common.css" rel="stylesheet">
<style type="text/css">
.field {
  margin-bottom: 10px;
}

.field label {
  display: block;
  font-size: 12px;
  color: #777;
}

.field input {
  display: block;
  min-width: 250px;
  line-height: 1.5;
  font-size: 14px;
}

input[type="submit"] {
  display: block;
  padding: 6px 30px;
  font-size: 14px;
  background-color: #4460AA;
  color: #fff;
  border: none
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
    <label for="give_men">받는 이메일</label>
    <input type="text" name="give_men" id="give_men">
  </div>
  <div class="field">
    <label for="to_name">받는 사람</label>
    <input type="text" name="to_name" id="to_name">
  </div>

 <div class="field">
    <label for="message">내용</label>
    <textarea rows="30" cols="50" 
placeholder="내용을 입력해주세요" name="message"  id="message"></textarea>
							
  </div>
  <input type="submit" id="button" value="Send Email" >
</form>





<script type="text/javascript"
  src="https://cdn.jsdelivr.net/npm/@emailjs/browser@3/dist/email.min.js"></script>

<script type="text/javascript">
  emailjs.init('RiFbUdAbgZITXTWWa')
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

   btn.value = '발송중...';

   const serviceID = 'default_service';
   const templateID = 'template_mqsdgau';

   emailjs.sendForm(serviceID, templateID, this)
    .then(() => {
      btn.value = 'Send Email';
      alert('메일이 발송되었습니다.');
    }, (err) => {
      btn.value = 'Send Email';
      alert(JSON.stringify(err));
    });
});
/*

 */
</script>
</html>