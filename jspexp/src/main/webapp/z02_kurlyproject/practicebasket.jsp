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
<title>장바구니 연습 </title>
<link href="logo.ico" rel="shortcut icon" type="image/x-icon">
<link href="/z02_kurlyproject/a1_top.css" rel="stylesheet">
<style>
h1{font-size:35px; font-family:"Times New Roman";color:indigo;text-align:left;}

#box{
	margin-top:50px;
	accent-color:indigo;
}
p#fixed{
		position:fixed;
		width:350px;height:300px;
		right:50px;
		background:white;
	}

#order{width:100%}

</style>
<script type="text/javascript">

/*
 
 */
</script>
</head>
<body>
<h6 id="h6" align="right"><span id="ttop">회원가입&ensp;</span>|<span id="ttop1">&ensp;로그인&ensp;|&ensp;고객센터</h6></span>

<p>
<img src="kurly.jpg" id="logo"><strong><span id="top">&ensp;&ensp;마켓컬리</strong></span>|<span>뷰티컬리</span>
<input type="text" name="search" id="search" size="22px" placeholder="검색어를 입력하세요" style="width:1000px;"/>
</p><br><br>
<div id="menu">
<ul>
		<li><a href="#">≡ 카테고리</a>
			<ul>
				<li><a href="#">채소</a></li>
				<li><a href="#">과일·견과·쌀</a></li>
				<li><a href="#">수산·해산·건어물</a></li>
				<li><a href="#">정육·계란</a></li>
				<li><a href="#">국·반찬·메인요리</a></li>
			</ul>
		</li>
		<li><a href="#">신상품</a>
		</li>
		<li><a href="#">베스트</a>
		</li>
		<li><a href="#">알뜰쇼핑</a>
		</li>
		<li><a href="#">특가/혜택</a>
		</li>
		<li><a href="#">샛별·낮 배송안내</a>
		</li>
	</ul>
</div>

<h2 align="center">장바구니</h2><br>
<h4><input type="checkbox"> 전체선택 | 선택삭제</h4>
<hr>
<p id="fixed" style="font-size:20px;"><strong>배송지</strong><br><br>충남 천안시 불당동 <br>지웰푸르지오<br><br>
<input type="button" value="배송지 변경" onclick="location.href='changead.html'" id="order"
style="background-color:white;color:indigo;border-color:indigo;font-size:20px" ><br><br></p>

<p id="fixed"  style="font-size:20px; margin-top:230px; id="back">
상품금액&emsp;&emsp;&emsp;134,500원</a><br>상품할인금액&emsp;4,500원
<br>배송비&emsp;&emsp;&emsp;&emsp;0원<br><br>결제예정금액&emsp;130,000원<br>

<input type="button" value="　　 주문하기　　" onclick="location.href='order.html'" id="order"
style="background-color:indigo;color:white;border-color:indigo;font-size:20px">
</p>
 <table width="80%" height="100%">
 	<col width="100px"><col width="500px"><col width="300px">
 	
 	<tr><td><input id="box" type="checkbox"></td><td><img src="product01.jpg" id="img"/></td>
 	<td align:"left" text-color:"darkgray">[미트클레버] 소갈비찜</td>
 	<td><input type="number" id="pcnt" min="1" max="10" placeholder="1"></td><td>35,000원</td>
 	<td><input type="button" value="X" onclick="alert('장바구니 목록에서 삭제되었습니다.')"></td></tr>
 	
 	<tr><td><input id="box" type="checkbox"></td><td><img src="product02.jpg" id="img"/></td>
 	<td align:"left" text-color:"darkgray">[이치류] 드라이에이징 양갈비 구이</td>
 	<td><input type="number" id="pcnt1" min="1" max="20" placeholder="2"></td><td>23,900원</td>
 	<td><input type="button" value="X" onclick="alert('장바구니 목록에서 삭제되었습니다.')"></td></tr>
 	
 	<tr><td><input id="box" type="checkbox"></td><td><img src="product03.jpg" id="img"/></td>
 	<td align:"left" text-color:"darkgray">김장용 평창 고랭지 절임 배추 10kg</td>
 	<td><input type="number" id="pcnt2" min="1" max="10" placeholder="5"></td><td>38,703원</td>
 	<td><input type="button" value="X" onclick="alert('장바구니 목록에서 삭제되었습니다.')"></td></tr>
 
 	<tr><td><input id="box" type="checkbox"></td><td><img src="product04.jpg" id="img"/></td>
 	<td align:"left" text-color:"darkgray">[달콘]초당옥수수(레토로트)1입</td>
 	<td><input type="number" id="pcnt2" min="1" max="10" placeholder="10"></td><td>3,690원</td>
 	<td><input type="button" value="X" onclick="alert('장바구니 목록에서 삭제되었습니다.')"></td></tr>
 
 	<tr><td><input id="box" type="checkbox"></td><td><img src="product05.jpg" id="img"/></td>
 	<td align:"left" text-color:"darkgray">[딸부자네불백]돼지불고기</td>
 	<td><input type="number" id="pcnt2" min="1" max="10" placeholder="3"></td><td>8,800원</td>
 	<td><input type="button" value="X" onclick="alert('장바구니 목록에서 삭제되었습니다.')"></td></tr>
 
 	<tr><td><input id="box" type="checkbox"></td><td><img src="product06.jpg" id="img"/></td>
 	<td align:"left" text-color:"darkgray">땅콩호박</td>
 	<td><input type="number" id="pcnt2" min="1" max="10" placeholder="2"></td><td>5,990원</td>
 	<td><input type="button" value="X" onclick="alert('장바구니 목록에서 삭제되었습니다.')"></td></tr>
 
</table>

</body>
<script type="text/javascript">
/*

 */

var div = document.querySelector("#container")
div.innerHTML+="<br>"
</script>
</html>