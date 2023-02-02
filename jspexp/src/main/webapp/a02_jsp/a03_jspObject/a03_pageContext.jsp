<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="java.util.*"    
    import="jspexp.vo.*"
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
<%
pageContext.setAttribute("name","이윤아");
pageContext.setAttribute("age",26);
pageContext.setAttribute("loc","천안 불당동");
%>
 <h2>이름:<%= pageContext.getAttribute("name")%></h2>
 <h2>나이(+10년 후):<%= ((Integer)pageContext.getAttribute("age")+10)%></h2>
 <%--기본적으로 형변환이 없으면 문자열로 출력은 되나, 원하는 데이터 연산을 위해서는
 	형변환이 반드시 필요로 하다. --%>
 <h2>사는 곳:<%= pageContext.getAttribute("loc")%></h2>
<%--ex) Product객체로 물건명 가격 갯수를 pageContext로 설정한 후 호출하세요--%>

<%
pageContext.setAttribute("prod", new Product("마우스",35000,1)); 
%>
<%
//할당된 내용을 사용하려면 typecasting 필요 
Product prod = (Product)pageContext.getAttribute("prod");
%>
<hr>페이지범위 객체
 <h3>(물건명):<%=prod.getProduct()%></h3>
 <h3>(가격):<%=prod.getPrice()%></h3>
 <h3>(갯수):<%=prod.getCnt()%></h3>
</body>
<script type="text/javascript">
/*

 */
</script>
</html>