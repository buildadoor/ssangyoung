<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="java.util.*"    
    import="jspexp.vo.*"
    import="jspexp.a13_database.*"    
    import="jspexp.a13_database.vo.*"     
    %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
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
<div id="container"></div>
<%-- 
#useBean을 활용한 객체 생성
1. jsp에서 action 태그의 한 형식으로 useBean을 객체를 생성하여 사용하는데 활용한다.
2. 객체 선언과 생성	
	<jsp:useBean id="참조명" calss="패키지.클래스명" scope="세션범위"/>
3. 호출
	1)<jsp:getProperty name="참조명" property="퍼로퍼티명" value="할당할데이터"/> 
		${참조명.property명}
	2)<jsp:setProperty name="참조명" property="퍼로퍼티명" value="할당할데이터"/>
		${참조명.setXXXX('할당데이터')}
		
--%>
<jsp:useBean id="pl01" class="jspexp.vo.Player"/>
<jsp:setProperty property="team" name="pl01" value="맨유"/>
<jsp:setProperty property="pname" name="pl01" value="박지성"/>
<jsp:setProperty property="score" name="pl01" value="30.0"/>

<h2>팀명:<jsp:getProperty property="team" name="pl01"/></h2>
<h2>이름:<jsp:getProperty property="pname" name="pl01"/></h2>
<h2>성적:<jsp:getProperty property="score" name="pl01"/></h2>
<jsp:useBean id="pl02" class="jspexp.vo.Player"/>
${pl02.setTeam("토드넘")}${pl02.setPname("손흥민") }${pl02.setScore("23") }
<h2>팀명:${pl02.team}</h2>
<h2>이름:${pl02.pname}</h2>
<h2>성적:${pl02.score}</h2>

<%-- ex) Code 클래스를 이용하여 useBean을 이용하여, 두가지 형식으로 저장하고, 출력하세요 --%>
<jsp:useBean id="c01" class="jspexp.vo.Code"/>
<jsp:setProperty property="key" name="c01" value="10"/>
<jsp:setProperty property="val" name="c01" value="인사"/>
<h2>키:<jsp:getProperty property="key" name="c01"/></h2>
<h2>값:<jsp:getProperty property="val" name="c01"/></h2>
<jsp:useBean id="c02" class="jspexp.vo.Code"/>
${c02.setKey("20") }
${c02.setVal("값2") }
<h2>키:${c02.key}</h2>
<h2>값:${c02.val}</h2>


</body>
<script type="text/javascript">
/*

 */

var div = document.querySelector("#container")
div.innerHTML+="<br>"
</script>
</html>