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
<title>Insert title here</title>
<link href="/a00_com/a01_common.css" rel="stylesheet">
<script type="text/javascript">
/*
 
 */
</script>
</head>
<body>
<form>
점수:<input type="text" name="score"/><br>
	<input type="submit" value="합격여부"/>
</form>
<div id="container"></div>


<h3>점수 :${param.score}</h3>
<h3>입력여부: ${not empty param.score}</h3>
<h3>70이상 여부:${param.score>=70}</h3>
<h3>구분:${param.score>=70?'합격':'불합격'}</h3>

<%-- 
ex) 점수: [ ] [합격여부]
	클릭시, 70점이상 합격/그외 불합격 출력 처리 하세요
	입력값여부:@@
	70이상여부:@@
	구분: 합격/불합격 -3항 연산자 활용
	
--%>
</body>
<script type="text/javascript">

var div = document.querySelector("#container")
div.innerHTML+="<br>"
</script>
</html>