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
<title>로그인 페이지</title>
<link href="logo.ico" rel="shortcut icon" type="image/x-icon">
<style>

h2{font-size:20px;}
h6{font-size:18px;}

#category{margin-left:100px;}
#category2{margin-right:30px;
			font-size:15px;}
/* ul li태그에 리스트 스타일을 없앰 */
	ul li{
		list-style: none;
	}
/* a태그에 텍스트 밑줄을 없애고 색상을 #333 */
	a {
		text-decoration: none;
		color:black;
	}
/* 글자크기를 16px 맑은 고딕 굵게하고 width넓이 700, 높이 50만큼 배경색은 #ccc, 글자색은 검정색, 라인높이50px
menu박스 가운데정렬, 글자가운데 정렬 */
	#menu {
		font:bold 22px "malgun gothic";
		width:100%;
		height:50px;
		background: white;
		color:black;
		line-height: 50px; 
		margin:0 auto;
		text-align: center;
	}

/* menu태그 자식의 ul의 자식 li를 왼쪽정렬과 넓이 140설정 */
	#menu > ul > li {
		float:left;
		width:300px;
		position:relative;
	}
	#menu > ul > li > ul {
		width:200px;
		display:none;
		position: absolute;
		font-size:14px;
		background: white;
		color:indigo;
	}
	
		#menu > ul > li:hover > ul {
		display:block;
		
	}
	#menu > ul > li > ul > li:hover {
  color: indigo;
		}
	#menu ul li a:hover{
		color:indigo;
		}
#search{ 
 			margin-left:10%;
 			width:400px; height:35px; padding-left:10px; 
 			border:2px solid indigo;   
           background-image:url('search.jpg');
           background-repeat: no-repeat;
           background-size: 80px;
           background-position: right;           
           border-color:indigo;
	       border-radius:10px;       
			}
#like{ 
 			margin-left:200px;}
#id,#pass{
  display: flex;
  width: 30%;
  padding: 12px;
  border: 1px solid indigo;
  border-radius: 4px;
  resize: vertical;
  margin : 0 auto;
}

input[type=button], input[type=submit] {
  background-color: indigo;
  color: white;
  padding: 12px 20px;
  border: none;
  border-radius: 4px;
  cursor: pointer;
  float: right;
}
input[type=button]:hover, input[type=submit]:hover {
  background-color: indigo;
}
#login{
margin-right:48%
}

</style>
<script type="text/javascript">
/*
 
 */
</script>
</head>
<body>
<h6 align="right"><span id="ttop" onclick="location.href='join.jsp'">회원가입&ensp;</span>|<span id="ttop1" onclick="location.href='login.jsp'">&ensp;로그인&ensp;|&ensp;고객센터</h6></span>
<p>
<img src="kurly.jpg" id="logo"><strong><span id="top">&ensp;&ensp;마켓컬리</strong></span>|<span>뷰티컬리</span>
<input type="text" name="search" id="search" size="22px" placeholder="검색어를 입력하세요" style="width:1000px;"/>
</p><br><br>
<div id="menu">

	<ul>
		<li><a href="#">≡ 카테고리</a>
			<ul><li><a href="#">채소</a></li>
				<li><a href="#">과일·견과·쌀</a></li>
				<li><a href="#">수산·해산·건어물</a></li>
				<li><a href="#">정육·계란</a></li>
				<li><a href="#">국·반찬·메인요리</a></li>
			</ul></li>
		<li><a href="#">신상품</a></li>
		<li><a href="#">베스트</a></li>
		<li><a href="#">알뜰쇼핑</a></li>
		<li><a href="#">특가/혜택</a></li>
		<li><a href="#">샛별·낮 배송안내</a></li></ul>
</div>


<h3 align="center">로그인</h3>
<form>

	<br><input type="text" name="id" placeholder="아이디를 입력하세요" id="id"/><br>
	<br><input type="password" name="password" placeholder="비밀번호를 입력하세요"id="id"/><br>
	<input type="submit" value="로그인" id="login"/>
</form>
<%
String id = request.getParameter("id");
String password = request.getParameter("password");
boolean isFail = false;
if(id!=null&&password!=null){
	LoginDao dao = new LoginDao();
	if(dao.login(id, password)){
		response.sendRedirect("0.jsp");
	}else{
		isFail =true;
	}
}
%>
</body>
<script type="text/javascript">
	var isFail =<%=isFail%>
	if(isFail){
		alert("로그인 실패\n아이디 비밀번호 오류입니다.")
	}

</script>
</html>