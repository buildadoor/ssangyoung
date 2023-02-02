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
#input01{
	width:290px; height:35px; margin-left:5px;
	border-radius:4px; 
	border:1px solid gray;

}
table td{
	border:1px solid lightgray;
	text-align:center;
}
.btn{
	width:90px; height:33px; margin-left:20px;
	border-radius:4px; 
	background:#0066CC;
	color:white;
	border:1px solid gray;
	font-size:15px;
	margin-top:20px;
	margin-bottom:20px;
}
.tab{
	overflow-y:scroll;
	height:500px;
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
								<span class="span-margin" id="span1">강의 관리</span>
							</div>
							<div>
								<span class="span-margin">강의 관리 > 강의계획서 조회</span>
							</div>
						</div>
					</div>
					<div class="main-box-flex">
						<div id="main-box2">
							<div>
								<h3 style="margin:30px">강의계획서 조회</h3>
								<jsp:useBean id="dao" class="jspexp.a13_database.UniversityDao"/>
								<jsp:useBean id="sch" class="jspexp.vo.Lecture01"/>
								<jsp:setProperty property="*" name="sch"/>
								<c:if test="${empty param.lecName}">${sch.setLecName("")}</c:if>
								<form action="" method="post">
									<h5 style="margin-left:40px; display:inline-block">강의이름</h5>
									<input id="input01" type="text" name="lecName" value="${sch.lecName}" placeholder="강의이름을 입력하세요"/>
									<input  class="btn" type="submit" value="검색"/>
								</form>
								<div class="tab">
								<table width="95%" align="center">
									<tr><th>강의번호</th><th>강의이름</th><th>강의실</th><th>강의시간</th><th>학점</th><th>강의계획서</th></tr>
									<c:forEach var="lec" items="${dao.schLecPlan(sch)}">
									<tr><td>${lec.lecNum}</td><td>${lec.lecName}</td><td>${lec.lecLoc}</td>
										<td>${lec.times}</td><td>${lec.grade}</td>
										<span id="lecPlan" style="display:none">${lec.lecPlan}</span><td align="center">
										<input type="button" class="btn" value="강의계획서" onclick="goLecPlan('${lec.lecPlan}');"/></td></tr>
									</c:forEach>
								</table>
								</div>
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

function goLecPlan(lecPlan){
	window.open("std_lecPlan_img.jsp?lecPlan="+lecPlan);
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