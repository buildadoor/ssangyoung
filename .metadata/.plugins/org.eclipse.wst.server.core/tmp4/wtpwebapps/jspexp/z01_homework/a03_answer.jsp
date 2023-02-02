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
<script>
/*
 
 */
</script>
</head>
<body>
<%-- 
#
--%>
<p id="show"></p>
<h2 onclick="createInfo()">회원정보 생성</h2>
<table id="tab01"></table>

<h2>12번 구매물건</h2>
<!-- action속성이 있으면 해당 화면 jsp에 데이터를
넘기고 없으면 현재 jsp에 요청데이터를 넘긴다 -->
<form>
	<table>
		<col width="10%">
		<tr><th>no</th><th>물건명</th><th>가격</th></tr>
		<%for(int cnt=1;cnt<=3;cnt++){ %>
		<tr><td><%=cnt %></td>
			<td><input type="text" name="pname<%=cnt%>"/></td>
			<td><input type="text" name="price<%=cnt%>"/></td></tr>
		<%}%>
		<tr><td colspan="3"><input type="submit" value="구매"/><br></td></tr>
	</table>
</form>
<%
int tot=0;
String buyList="";
for(int cnt=0;cnt<=3;cnt++){
	String pname=request.getParameter("pname"+cnt);
	String price=request.getParameter("price"+cnt);
	if(pname!=null) buyList+=pname+", ";
	if(price!=null) tot+=Integer.parseInt(price);
}
if(tot!=0){
%>
	<h2>구매목록리스트:<%=buyList %></h2>
	<h2>총비용:<%=tot %></h2>
<%} %>

</body>
<script>
/*
4번
 */
 <%--
 var num01 = prompt("첫번째 숫자입력","0")
 var num02 = prompt("두번째 숫자입력","0")
 var show = document.querySelector("#show")
 show.innerHTML +=num01+" + "+num02+" = "+(parseInt(num01)+parseInt(num02))+"<br>"
 show.innerHTML +=num01+" - "+num02+" = "+(num01-num02)+"<br>"
 show.innerHTML +=num01+" * "+num02+" = "+(num01*num02)+"<br>"
 show.innerHTML +=num01+" / "+num02+" = "+parseInt(num01/num02)+"<br>"
--%>
 <%--
 9번 
 --%>
 function createInfo(){
	 //ajax를 이용하면 js단에 서버에 접근해서 데이터를 가져와서 동적인 로딩처리가 된다. 
	 var tab01 = document.querySelector("#tab01")
	 var ids = ['himan','goodman','badgirl']
	 var names = ['홍길동','김길동','김영자']
	 var addHTML = "<tr><th>아이디</th><th>이름</th></tr>";
	 for(var idx = 0; idx<ids.length;idx++){
		 addHTML+="<tr><td>"+ids[idx]+"</td><td>"+names[idx]+"</td></tr>"
	 }
 tab01.innerHTML = addHTML;
 }
 
 </script>

 </html>