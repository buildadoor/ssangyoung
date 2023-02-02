<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="java.util.*"    
    import="jspexp.vo.*"
    import="javaexp.sql.*"
    import="jspexp.a13_database.*"    
    import="jspexp.a13_database.vo.*"     
    %>
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
<link href="PJ_css/a00_main.css" type="text/css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/sweetalert2@9"></script>
<script type="text/javascript" src="http://code.jquery.com/jquery-1.8.3.min.js"></script>
</head>
<style>
@import url(a00_main.css);  

#addtable{
margin-top:5%;
margin-left: 40%;
font-size: 15px;
}
#bt{
margin-top:3%;
margin-left: 50%;
width:57px; height:33px;
border-radius:4px; 
background:#0066CC;
color:white;
border:1px solid gray;
font-size:15px;
}
#bt2{
font-size: 15px;
border-radius:4px; 
background:#0066CC;
color:white;
border:1px solid gray;
font-size:15px;
}

#bt3{
font-size: 15px;
margin-left: 50%;
border-radius:4px; 
background:#0066CC;
color:white;
border:1px solid gray;
}
#center{
margin-top:5%;
margin-left:45%;
font-size:18px;
}



</style>

</script>
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
               <span id="tob-box2-span">${pro.proName} 교수</span>
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
								<li><a href="noticeNo1.jsp">공지사항 조회</a></li>
							</ul>                       	
                           <div class="title">강의 관리</div>
                           <ul class="sub">
							  <li><a href="lectureadd.jsp">강의 등록</a></li>
                              <li><a href="lecturemodify.jsp">강의 수정</a></li>
                              <li><a href="lecturedelete.jsp">강의 삭제</a></li>
                              <li><a href="lecEval.jsp?id=${pro.id}">강의평가 조회</a></li>
                              <li><a href="lecplanadd.jsp">강의계획서 관리</a></li>
                           </ul>
                        </li>
                        <li class="group">
                           <div class="title">성적 관리</div>
                           <ul class="sub">
                              <li><a href="schStudent.jsp?id=${pro.id}">성적 입력</a></li>
                           </ul>
                        </li>
                        <li class="group">
                           <div class="title">학생관리</div>
                           <ul class="sub">
                              <li><a href="search.jsp">학생 조회</a></li>
                              <li><a href="sendemail.jsp">이메일 발송</a></li>
                              <li><a href="studentAt.jsp">출결 관리</a></li>
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
                           <span class="span-margin" id="span1">학생조회</span>
                     </div>
                     <div>
                        <span class="span-margin">학생관리 > 학생조회</span>
                     </div>
                  </div>
               </div>
               <div class="main-box-flex">
                  <div id="main-box2">
                     <div>
                        <h3 style="margin:30px"></h3>
                        <jsp:useBean id="dao" class="jspexp.a13_database.eduStDao"/>
                        <jsp:useBean id="sch" class="jspexp.a13_database.eduSt"/>
                        <jsp:setProperty property="*" name="sch"/>
								<form action="" method="post">
									<table align="center">
									<col width="200px">
									<col width="300px">
									<tr><th>　학생이름　</th>
									<td><input type="text" name="stdName" value="${sch.stdName}">
									<input type="button" value="검색" id="bt2" onclick="ckValid()"/></td></tr>
									</table>
								</form>
								<table style="border: 1px solid #D8D9DA" align="center">
								<colgroup>
									<col width="200px">
									<col width="300px">
								</colgroup>
									<c:forEach var="student" items="${dao.getStudentList(sch)}">
									<tr><th>아이디(학번)</th><td>${student.id}</td></tr>
									<tr><th>이름</th><td>${student.stdName}</td></tr>
									<tr><th>학년</th><td>${student.stdYear}</td></tr>
									<tr><th>입학날짜</th><td>${student.enterYear}</td></tr>
									<tr><th>주소</th><td>${student.address}</td></tr>
									<tr><th>생년월일</th><td>${student.birthday}</td></tr>
									<tr><th>이메일</th><td id="myDiv">${student.stdEmail}</td></tr>
									<tr><th><td><button id="myButton">이메일복사</button></td></tr>
									<tr><th>전화번호</th><td>${student.stdPhone}</td></tr>
									<tr><th>학적상태</th><td>${student.status}</td></tr>
									<tr><th>학과번호</th><td>${student.majorNo}</td></tr>
									<tr><th>학과</th><td>${student.majorName}</td></tr>
									<tr><th><td> 
										<input type="button" value="이메일발송" onclick="email()" id="bt2"/>
									</td></tr>
									</c:forEach>
                        </div>
                     </div>
                    </div>
</body>
<script>
function logout(){
	   Swal.fire({
			  title: '로그아웃하시겠습니까?',
			  icon: 'question',
			  showCancelButton: true, // cancel버튼 보이기. 기본은 원래 없음
			  confirmButtonColor: '#3085d6', // confrim 버튼 색깔 지정
			  cancelButtonColor: '#d33', // cancel 버튼 색깔 지정
			  confirmButtonText: '확인', // confirm 버튼 텍스트 지정
			  cancelButtonText: '취소' // cancel 버튼 텍스트 지정
			}).then((result) => {
			  if (result.value) {
				//"확인" 버튼을 눌렀을 때 작업할 내용
				  location.href="a01_login_DB.jsp"
			  }
			})
}
function email(){
	   Swal.fire({
			  title: '이메일을 발송 페이지로 이동하시겠습니까?',
			  icon: 'question',
			  showCancelButton: true, // cancel버튼 보이기. 기본은 원래 없음
			  confirmButtonColor: '#3085d6', // confrim 버튼 색깔 지정
			  cancelButtonColor: '#d33', // cancel 버튼 색깔 지정
			  confirmButtonText: '확인', // confirm 버튼 텍스트 지정
			  cancelButtonText: '취소' // cancel 버튼 텍스트 지정
			}).then((result) => {
			  if (result.value) {
				//"확인" 버튼을 눌렀을 때 작업할 내용
				  location.href="sendemail.jsp"
			  }
			})

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
   const myDiv = document.getElementById("myDiv");
   document.getElementById("myButton").onclick = () => {
     window.navigator.clipboard.writeText(myDiv.textContent).then(() => {
       alert("이메일 정보가 클립보드에 복사되었습니다.");
     });
   };
   function ckValid(){
	   var stdName = document.querySelector("[name=stdName]")
	   var stdNameV = stdName.value.trim();
	   if(stdNameV==""){
		  Swal.fire({
			  title: '성명을 입력해주세요.',
			  icon: 'warning',
			  showCancelButton: false,
			  confirmButtonColor: '#3085d6',
			  confirmButtonText: '확인'
			}).then((result) => {
			  if (result.value) {
			      stdName.focus()
			      return;
			  }
		  })		      

		}else{
			document.querySelector("form").submit();
		}
	   
	}
</script>
</html>