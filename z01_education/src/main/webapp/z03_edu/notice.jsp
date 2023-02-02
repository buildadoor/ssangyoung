<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>쌍용 대학교</title>
<link href="main.css" type="text/css" rel="stylesheet">
<script type="text/javascript"
   src="http://code.jquery.com/jquery-1.8.3.min.js"></script>
</head>
<style>
@import url(a00_main.css);  
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
table th {
  padding-top: 5px;
  padding-bottom: 12px;
  background-color: #808080;
  color: white;
  
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
               <span id="tob-box2-span">ID ${mem.id}교수</span>
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
                              <li><a href="#">-공지게시판</a></li>
                           </ul>
                        </li>
                        <li class="group">
                           <div class="title">강의관리</div>
                           <ul class="sub">
                              <li><a href="lectureadd.jsp">-강의 등록</a></li>
                              <li><a href="lecturemodify.jsp">-강의 수정</a></li>
                              <li><a href="lecturedelete.jsp">-강의 삭제</a></li>
                              <li><a href="lecplanadd.jsp">-강의계획서 관리</a></li>
                           </ul>
                        </li>
                        <li class="group">
                           <div class="title">학생관리</div>
                           <ul class="sub">
                              <li><a href="search.jsp">-학생 조회</a></li>
                              <li><a href="sendemail.jsp">-이메일 발송</a></li>
                              <li><a href="#">-출결 등록</a></li>
                              <li><a href="#">-출결 삭제</a></li>
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
                        <span class="span-margin" id="span1">공지사항 조회</span>
                     </div>
                     <div>
                        <span class="span-margin">공지사항 > 공지사항 조회</span>
                     </div>
                  </div>
               </div>

               <div class="main-box-flex">
                  <div id="main-box2">
                     <div>
                     <table width="100%" height="500" align="center">
                           <col width="10px">
                           <col width="10px">
                           <col width="100px">
                           <col width="10px">
                           <col width="50px">
                           <col width="10px">
                           <thead>
                              <tr><th>번호</th><th>분류</th><th>제목</th><th>작성자</th><th>등록일</th><th>조회수</th></tr>
                           </thead>
                           <tbody>
                              
                           </tbody>
                       </table>
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
 function logout(){
	      if(confirm("로그아웃하시겠습니까?")){
	         location.href="a01_login_DB.jsp"
	      }
	   }
</script>
</html>