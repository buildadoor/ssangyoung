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
<script>
/*
 
 */
</script>
</head>
<body>
<script type="text/javascript">
function call(){
	var pH2Ob = parent.document.querySelector("h2")
	pH2Ob.style.background="pink"
}
function sendFrame02(){
	var pnameVal = document.querySelector("#pname").value
	parent.sendFrame(pnameVal); //상위에 있는 js호출
}
function change01(val){
	parent.sendFrameDp(val)
}
/*
a01_frame.jsp
function sendFrame(pname){
	var fm02H2Ob = frame02.document.querySelector("h2")
	fm02H2Ob.innerText = "전송된 물건명:"+pname
}
function sendFrameDp(dname){
	var fm02H2Ob = frame02.document.querySelector("h2")
	fm02H2Ob.innerText="전송된 부서"+dname
}
ex) <select>로 부서정보를 출력하고 선택했을 때, 부서정보가 frame2에 출력되게 처리하세요
*/

</script>
<h2>프레임1</h2>
<button type="button" onclick="call()">상위 타이틀 변경</button><br>
데이터전송:<input type="text" id="pname"/>
<button type="button" onclick="sendFrame02()">frame2에 입력된 데이터 전송</button><br>
부서정보
<select onchange="change01(this.value)">
<option>총무</option>
<option>인사</option>
<option>경영</option>
<option>IT</option>
</select>
<%--
# 

 --%>
<%

%>
</body>
<script>
/*

 */
</script>
</html>