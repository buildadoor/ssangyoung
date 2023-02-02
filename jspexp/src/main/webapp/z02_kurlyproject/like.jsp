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



<h6 id="h6" align="right"><span id="ttop"><%=session.getAttribute("id") %>님 로그인|&ensp;고객센터</h6></span>
<p><img src="kurly.jpg" id="logo"><strong><span id="top">&ensp;&ensp;마켓컬리</strong></span>|<span>뷰티컬리</span>
<input type="text" name="search" id="search" size="22px" placeholder="검색어를 입력하세요" style="width:1000px;"/></p><br><br>
<div id="menu">
	<ul>
		<li><a href="#">≡ 카테고리</a>
			<ul><li><a href="#">채소</a></li>
				<li><a href="#">과일·견과·쌀</a></li>
				<li><a href="#">수산·해산·건어물</a></li>
				<li><a href="#">정육·계란</a></li>
				<li><a href="#">국·반찬·메인요리</a></li></ul></li>
		<li><a href="#">신상품</a></li>
		<li><a href="#">베스트</a></li>
		<li><a href="#">알뜰쇼핑</a></li>
		<li><a href="#">특가/혜택</a></li>
		<li><a href="#">샛별·낮 배송안내</a></li>
	</ul>
</div>

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