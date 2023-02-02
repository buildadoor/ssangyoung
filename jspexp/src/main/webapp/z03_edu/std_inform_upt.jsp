<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="java.util.*"
    import="jspexp.a13_database.*"
    import="jspexp.a13_database.vo.*" %>
<%
	// post방식에서 한글요청값을 받을 때, 반드시 설정되어야한다.
	request.setCharacterEncoding("utf-8");
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:requestEncoding value="UTF-8"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>쌍용 대학교</title>
<link href="main.css" type="text/css" rel="stylesheet">
<script type="text/javascript" src="http://code.jquery.com/jquery-1.8.3.min.js"></script>
</head>
<style>

#input{
width:300px;
height:30px;
}
#bt2{
font-size: 15px;
border-radius:4px; 
background:#0066CC;
color:white;
border:1px solid gray;
font-size:15px;
}
#input01{
	width:290px; height:35px; margin-left:5px;
	border-radius:4px; 
	border:1px solid gray;

}
table td{
	border:1px solid lightgray;
}
.btn{
	width:57px; height:33px; margin-left:20px;
	border-radius:4px; 
	background:#0066CC;
	color:white;
	border:1px solid gray;
	font-size:15px;
	margin-top:20px;
}
table{
	margin-top:100px;
}
</style>
<body>
	<div>
		<div>
			<div class="flex-box1">
				<div id="box1">
					<div id="top-box1">
						<span id="tob-box1-span">쌍용대학교</span>
					</div>
				</div>
				<div id="top-box2">
					<span id="tob-box2-span">ID ${mem.id} 학생</span>
					<span id="tob-box2-span"><input type="button" id="bt2" value="로그아웃" onclick="logout()" /></span>
				</div>
			</div>
			<div class="flex-box2">
				<div id="flex-box2_box1">
					<div>
						<div id="nav-box">
							<ul id="navi">
								<li class="group">
									<div class="title">공지사항</div>

                           <ul class="sub">
                              <li><a href="noticeBoard.jsp">공지게시판</a></li>
                           </ul>
                        </li>
                        <li class="group">
                           <div class="title">수강신청</div>
                           <ul class="sub">
                              <li><a href="regLecture_01.jsp">수강신청</a></li>
                              <li><a href="regLecture_02.jsp">수강신청내역</a></li>
                              <li><a href="timeTable.jsp">시간표</a></li>
                           </ul>
                        </li>
                        <li class="group">
                           <div class="title">강의 관리</div>
                           <ul class="sub">
                              <li><a href="std_grade_sch.jsp">성적조회</a></li>
                              <li><a href="std_lecPlan_sch.jsp">강의계획서 조회</a></li>
                              <li><a href="std_lecEval_ins.jsp">강의평가</a></li>
                           </ul>
                        </li>
                        <li class="group">
                           <div class="title">학적 관리</div>
                           <ul class="sub">
                              <li><a href="std_inform_sch.jsp">학적정보</a></li>
                              <li><a href="std_inform_upt.jsp">학적정보 변경</a></li>
                              <li><a href="std_inform_uptpw.jsp">비밀번호 변경</a></li>
                              <li><a href="tuition_bill.jsp">등록금 고지서 조회</a></li>
                           </ul>
								</li>
							</ul>
						</div>
					</div>
				</div>
				<div id="flex-box2_box2">
					<div class="main-box-flex">
						<div id="main-box1">
							<div id="main-box1-iteam">
								<span class="span-margin" id="span1">학적 관리</span>
							</div>
							<div>
								<span class="span-margin">학적 관리 > 학적정보 변경</span>
							</div>
						</div>
					</div>
					<div class="main-box-flex">
						<div id="main-box2">
							<div>
								<h3 style="margin:30px">학적정보 변경</h3>
								<form method="post" name="uptForm" align="center">
								<input type="hidden" name="proc"/>
								<table align="center" style="height:300px;">
								<colgroup>
									<col width="200px">
									<col width="300px">
								</colgroup>
									<tr><th>아이디(학번)</th><td style="padding-left:10px;text-align:left;border:1px solid #D8D9DA;">${mem.id}
									<input id="input01" type="hidden" name="id" value="${mem.id}"/></td></tr>
									<tr><th>주소*</th><td><input id="input01" type="text" name="address"
										placeholder="변경할 주소를 입력하세요"/><span id="ckadd"></span></td></tr>
									<tr><th>전화번호*</th><td><input id="input01" type="text" name="stdPhone"
										placeholder="변경할 전화번호를 입력하세요"/><span id="ckphone"></span></td></tr>
									<tr><th>이메일*</th><td><input id="input01" type="text" name="stdEmail"
										placeholder="변경할 이메일를 입력하세요"/><span id="ckemail"></span></td></tr>
								</table>
								<input type="button" class="btn" value="변경" onclick="uptIn(${mem.id});"/>
								</form>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div></div>
</body>
<script>
function logout(){
	if(confirm("로그아웃하시겠습니까?")){
		location.href="a01_login_DB.jsp"
	}
}
window.onload=function(){
	uptForm.address.focus();
}

function uptIn(id){
	var addressV = document.querySelector("[name=address]").value
	var stdPhoneV = document.querySelector("[name=stdPhone]").value
	var stdEmailV = document.querySelector("[name=stdEmail]").value
	if(addressV=="" || stdPhoneV=="" || stdEmailV==""){
		if(addressV==""){
			alert("주소 입력은 필수입니다.")
			address.focus();
		}else if(stdPhoneV==""){
			alert("전화번호 입력은 필수입니다.")
			stdPhone.focus();
		}else if(stdEmailV==""){
			alert("이메일 입력은 필수입니다.")
			stdEmail.focus();
		}
	}else{
		if(confirm("변경하시겠습니까?")){
			document.querySelector("form").action="std_inform_ckupt.jsp"
			document.querySelector("[name=proc]").value="upt";
			document.querySelector("form").submit()
		}
	}
}


	$(document).ready(function() {
		//모든 서브 메뉴 감추기
		$(".sub").css({
			display : "none"
		});
		//$(".sub").hide(); //위코드와 동일 
		$(".title").click(function() {
			//일단 서브메뉴 다 가립니다.
			//$(".sub").css({display:"none"});
			//열린 서브메뉴에 대해서만 가립니다.
			$(".sub").each(function() {
				console.log($(this).css("display"));
				if ($(this).css("display") == "block") {
					//$(".sub").css({display:"none"});
					//$(this).hide();
					$(this).slideUp("fast");
				}
			});
			//현재 요소의 다음 요소를 보이게 합니다.
			//$(this).next("ul").css({display:"block"});
			//$(this).next("ul").show();
			$(this).next("ul").slideDown("fast");
		})
	});
	  
</script>
</html>