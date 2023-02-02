<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"
   import="java.util.*"
     import="jspexp.vo.*"
    import="jspexp.a13_database.*"%>
        <%@ taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix = "fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
 <fmt:requestEncoding value="UTF-8"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>쌍용 대학교</title>
<link href="main.css" type="text/css" rel="stylesheet">
<style>
@charset "UTF-8";

body {
   margin: 0;
   padding: 0px;
   background-color: #f2f2f9;
   font-weight: bold;
}

.flex-box1 {
   display: flex;
   width: 100%;
   justify-content: space-between;
   height: 80px;
   box-shadow: 1px 1px;
   background-color: white;
}

#top-box1 {
   text-align: center;
   font-size: 25px;
   height: 100%;
   position: relative;
   width: 340px;
   background-color: rgb(41, 128, 185);
   color: white;
}

#tob-box1-span {
   position: relative;
   top: 25px;
}

#tob-box2-span {
   position: relative;
   top: 30px;
   right: 40px;
}

#top-box2 {
   margin-right: 20px;
   height: 100%;
}

#box1 {
   width: 200px;
}

.flex-box2 {
   display: flex;
   width: 100%;
   justify-content: space-between;
}

#flex-box2_box1 {
   height: 899px;
   background: rgb(41, 128, 185);
}

#flex-box2_box2 {
   width: 90%;
}

.main-box-flex {
   display: flex;
   justify-content: center;
   margin: 40px;
}

#main-box1 {
   display: flex;
   justify-content: space-between;
   align-items: center;
   width: 100%;
   height: 50px;
   border: 1px solid gray;
   box-shadow: 1px 1px;
   background-color:white;
}

#main-box2 {
   width: 100%;
   height: 650px;
   border: 1px solid gray;
   box-shadow: 1px 1px;
   background-color:white;
   
}

.span-margin{
   margin-left:40px;
   margin-right:40px;
}

#span1{
   font-size:20px;
}

#nav-box {
   width: 100%;
}

ul#navi {
   width: 200px;
   text-indent: 10px;
   font-size: 15px;
}

ul#navi, ul#navi ul {
   margin: 0;
   padding: 0;
   list-style: none;
   width: 340px;
}

li.group {
   color: white;
}

li.group div.title {
   height: 50px;
   line-height: 50px;
   background: rgb(64, 89, 106);
   cursor: pointer;
   padding-left: 25px;
   font-weight: 600;
   background-image: url("img/down.png");
   background-position: right 10px center;
   background-repeat: no-repeat;
   background-size: 15px 15px;
   font-size: 17px;
}

ul.sub li {
   height: 35px;
   line-height: 35px;
   background: rgb(41, 128, 185);
   cursor: pointer;
   padding-left: 40px;
   font-weight: 550;
}

ul.sub li a {
   display: block;
   width: 100%;
   height: 100%;
   text-decoration: none;
   color: white;
}

ul.sub li:hover {
   background: rgb(64, 89, 106);
}
#bt2{
font-size: 15px;
border-radius:4px; 
background:#0066CC;
color:white;
border:1px solid gray;
font-size:15px;
}
.tui{
	overflow-y:scroll;
	height:600px;
	align:center;
	width:700px;
	margin-left:300px;

	margin-top:30px;

}
.img{
	margin-left:100px;
	margin-right:auto;
	width:530px;
	heght:380px;
}
</style>
<script type="text/javascript"
   src="http://code.jquery.com/jquery-1.8.3.min.js"></script>
</head>
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
                        <span class="span-margin" id="span1">등록금고지서</span>
                     </div>
                     <div>
                        <span class="span-margin">학적 > 등록금고지서 조회</span>
                     </div>
                  </div>
               </div>

               <div class="main-box-flex">
                  <div id="main-box2">
                     <div>
                    
                     	<jsp:useBean id="dao" class="jspexp.a13_database.stdMgr"></jsp:useBean>
                        <jsp:useBean id="sch" class="jspexp.vo.Tuition"></jsp:useBean>
                       <jsp:setProperty property="*" name="sch"/>
	                     	 <c:if test="${empty mem.id}">${sch.setId("")}</c:if>
	                     	 <c:forEach var="tui" items="${dao.getFileName(mem.id)}">
	                     	 <div class="tui">
	                     	 	<img class="img" src="${tui.fileName}"/>
	                     	 </div>
	                     	 </c:forEach>
	                     	
	                     	
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