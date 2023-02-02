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
# form의 데이터 처리하는 Bean객체
1. useBean을 활용하면 form의 데이터를 효과적으로 property명으로 mapping시켜서 처리가 가능하다.
2. form요청값과 bean객체 연관관계
	<input name="ename" value="홍길동"/>
	전송하면 ?ename=홍길동
	class Emp{
		public setEname(String ename){
		}
	}
	<jsp:setProperty name="참조명" property="ename"
	선언하면 요청값을 property와 연동하여 값이 할당된다.
	
	${emp.ename} ==> 이렇게 가져올 수 있다.
	
	요청값호출(?ename=홍길동) ==> <jsp:useBean이 선언되고> 메서드가 setEname(String)
							<jsp:setProperty로 할당되어
	==> 객체를 호출하여 사용가능하다.

--%>
<form>
	사원번호:<input type="text" name="empno"/>
	사원명:<input type="text" name="ename"/>
	<input type="submit" value="등록"/>
</form>
	<jsp:useBean id="emp" class="jspexp.vo.Emp"/>
	<jsp:setProperty property="empno" name="emp"/>
	<jsp:setProperty property="ename" name="emp"/>
	<h2>입력한 사원번호:${emp.empno }</h2>
	<h2>입력한 사원명:${emp.ename }</h2>
<%
//ex) 물건명, 가격, 갯수를 입력받아 Product 객체를 통해서 받아서 출력 처리하세요

%>
<form>
	물건명:<input type="text" name="product"/>
	가격:<input type="text" name="price"/>
	갯수:<input type="text" name="cnt"/>
	<input type="submit" value="구매"/>
</form>
	<jsp:useBean id="prod" class="jspexp.vo.Product"/>
	<jsp:setProperty property="*" name="prod"/>
	<%--
	위와 같이 선언시, Bean객체 내부에 
		아래 요청값을 받을 수 있는 property와 타입이 같으면 자동으로 할당된다.
	?name=사과&price=3000&cnt=2 
	setName(String s) setPrice(int price) setCnt(int cnt)
	
	?callname=사과
	setName(String s)
	
	요청값(query string)과 property가 다를 때..	
	<jsp:setProperty property="name" param="callname" name="prod"/>
	--%>
	<%--
	<jsp:setProperty property="product" name="prod"/>
	<jsp:setProperty property="price" name="prod"/>
	<jsp:setProperty property="cnt" name="prod"/>
	 --%>
	<h2>입력한 물건:${prod.product}</h2>
	<h2>입력한 가격:${prod.price}</h2>
	<h2>입력한 갯수:${prod.cnt}</h2>
</body>

<script type="text/javascript">
/*

 */

var div = document.querySelector("#container")
div.innerHTML+="<br>"
</script>
</html>