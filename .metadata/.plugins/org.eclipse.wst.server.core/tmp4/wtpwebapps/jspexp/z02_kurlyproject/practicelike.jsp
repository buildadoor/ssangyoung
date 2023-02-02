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
<title>Kurly 마켓컬리/뷰티컬리</title>
<link href="logo.ico" rel="shortcut icon" type="image/x-icon">
<link href="/z02_kurlyproject/a1_top.css" rel="stylesheet">

<style type="text/css">

#button {background: indigo;}
</style>
</head>
<body>

<style>
@import url(a1_top.css);  
</style>
<%=session.getAttribute("id") %>님 로그인
<jsp:include page="top.jsp"></jsp:include> 

<br><br><br><br>
<p>
<h1 align="left">마이컬리</h1>

<h2 id="h2" style="margin-left:200px;">찜한 상품(6)&nbsp;<span id="h2"style="color:gray;">찜한 상품은 최대 200개까지 저장됩니다.</span></h2>
<hr>
 <table id="like" width="100%" height="100%">
 	<col width="100px"><col width="500px"><col width="300px">
 	
 	<tr><td><img src="product01.jpg" id="img"/></td>
 	<td align:"left" text-color:"darkgray">[미트클레버] 소갈비찜<br>35,000원</td>
 	<td><input type="button" value="삭제" onclick="alert('찜한 목록에서 삭제되었습니다.')"style="color:gray;background-color:white;width:50px;"><br>
 	<input type="button" value="담기" onclick="location.href='basket.html'"style="color:indigo;background-color:white;width:50px;"></td></tr>
 	
 	<tr><td><img src="product02.jpg"id="img"/></td>
 	<td align:"left" text-color:"darkgray">[이치류] 드라이에이징 양갈비 구이<br>23,900원</td>
 	<td><input type="button" value="삭제" onclick="alert('찜한 목록에서 삭제되었습니다.')"style="color:gray;background-color:white;width:50px;"><br>
 	<input type="button" value="담기" onclick="location.href='basket.html'" style="color:indigo;background-color:white;width:50px;"></td></tr>
 	
 	<tr><td><img src="product03.jpg" id="img"/></td>
 	<td align:"left" text-color:"darkgray">김장용 평창 고랭지 절임 배추 10kg<br>38,703원</td>
 	<td><input type="button" value="삭제" onclick="alert('찜한 목록에서 삭제되었습니다.')"style="color:gray;background-color:white;width:50px;"><br>
 	<input type="button" value="담기" onclick="location.href='basket.html'"style="color:indigo;background-color:white;width:50px;"></td></tr>
 	
 	
 	<tr><td><img src="product04.jpg" id="img"/></td>
 	<td align:"left" text-color:"darkgray">[달콘]초당옥수수(레토로트)1입<br>3,690원</td>
 	<td><input type="button" value="삭제" onclick="alert('찜한 목록에서 삭제되었습니다.')"style="color:gray;background-color:white;width:50px;"><br>
 	<input type="button" value="담기" onclick="location.href='basket.html'"style="color:indigo;background-color:white;width:50px;"></td></tr>
 	
 	<tr><td><img src="product05.jpg" id="img"/></td>
 	<td align:"left" text-color:"darkgray">[딸부자네불백]돼지불고기<br>8,800원</td>
 	<td><input type="button" value="삭제" onclick="alert('찜한 목록에서 삭제되었습니다.')"style="color:gray;background-color:white;width:50px;"><br>
 	<input type="button" value="담기" onclick="location.href='basket.html'"style="color:indigo;background-color:white;width:50px;"></td></tr>
 	
 	<tr><td><img src="product06.jpg" id="img"/></td>
 	<td align:"left" text-color:"darkgray">땅콩호박<br>5,990원</td>
 	<td><input type="button" value="삭제" onclick="alert('찜한 목록에서 삭제되었습니다.')"style="color:gray;background-color:white;width:50px;"><br>
 	<input type="button" value="담기" onclick="location.href='basket.html'"style="color:indigo;background-color:white;width:50px;"></td></tr>
 	
</body>
</html>