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
<!-- <link href="/z02_kurlyproject/a1_top.css" rel="stylesheet"> -->

<style type="text/css">

#button {background: indigo;}
</style>
</head>
<body>

<h6 id="h6" align="right"><span id="ttop" onclick="location.href='join.jsp'">회원가입&ensp;</span>
	|<span id="ttop1" onclick="location.href='login.jsp'">&ensp;로그인&ensp;|&ensp;고객센터</h6></span>
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
