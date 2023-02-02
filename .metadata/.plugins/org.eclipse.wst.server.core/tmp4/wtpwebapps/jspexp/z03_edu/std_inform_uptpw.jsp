<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="java.util.*"
    import="jspexp.a13_database.*"
    import="jspexp.a13_database.vo.*"%>
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
#bt{
width:80px;
height:30px;
}
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
	width:75px; height:33px; margin-left:20px;
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
								<span class="span-margin">학적 관리 > 비밀번호 변경</span>
							</div>
						</div>
					</div>
					<div class="main-box-flex">
						<div id="main-box2">
							<div>
								<h3 style="margin:30px">비밀번호 변경</h3>
								<form name="passForm" align="center">
								<table align="center" style="height:300px;">
								<colgroup>
									<col width="200px">
									<col width="300px">
								</colgroup>
									
									<tr><th>현재 비밀번호</th><td><input id="input01" type="hidden" name="id" value="${mem.id}"/>
									<input id="input01" type="password" 
										name="pass1" placeholder="현재 비밀번호 입력"/></td></tr>
									<tr><th>새 비밀번호</th><td><input id="input01" type="password" 
										name="pass2" placeholder="새 비밀번호 입력"/></td></tr>
									<tr><th>새 비밀번호 확인</th><td><input id="input01" type="password" 
										name="pass3" placeholder="새 비밀번호 확인"/></td></tr>
								</table>
								<input type="button" class="btn" value="변경하기" onclick="passwdCheck(passForm);"/>
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
window.onload=function(){
	passForm.pass1.focus();
}

function passwdCheck(form){
	if( form.pass1.value == "" ){
		alert("현재 비밀번호를 입력해주세요.");
		form.pass1.focue();
		return;
	}
	if( form.pass2.value == "" ){
		alert("새 비밀번호를 입력해주세요.");
		form.pass2.focue();
		return;
	}
	if( form.pass3.value == "" ){
		alert("새 비밀번호 확인을 입력해주세요.");
		form.pass3.focue();
		return;
	}
	if( form.pass1.value == form.pass2.value ){
		alert("현재 비밀번호와 새 비밀번호가 일치합니다.");
		form.pass1.value="";
		form.pass2.value="";
		form.pass3.value="";
		form.pass1.focue();
		return;
	}
	if( form.pass2.value != form.pass3.value ){
		alert("새 비밀번호와 새 비밀번호 확인이 일치하지 않습니다.");
		form.pass2.value="";
		form.pass3.value="";
		form.pass2.focue();
		return;
	}
	form.method="POST";
	form.action="std_inform_ckpw.jsp";
	form.submit();
	
}

function logout(){
	if(confirm("로그아웃하시겠습니까?")){
		location.href="a01_login_DB.jsp"
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