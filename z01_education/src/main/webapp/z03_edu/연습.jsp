<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="java.util.*"    
    import="jspexp.vo.*"
    import="javaexp.sql.*"
    import="jspexp.a13_database.*"    
    import="jspexp.a13_database.vo.*"     
    %>
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
margin-left: 50%;
border-radius:4px; 
background:#0066CC;
color:white;
border:1px solid gray;
font-size:15px;
}

#center{
margin-top:5%;
margin-left:45%;
font-size:15px;
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
                              <li><a href="studentAt.jsp">-출결 관리</a></li>
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
                        <span class="span-margin" id="span1">강의계획서등록/수정</span>
                     </div>
                     <div>
                        <span class="span-margin">강의관리 > 강의계획서등록/수정</span>
                     </div>
                  </div>
               </div>

               <div class="main-box-flex">
                  <div id="main-box2">
                     <div>
                     <%-- z01_upload.jsp  lecplanupload.jsp --%>
					<form action="lecplanupload.jsp" method="post" 
						enctype="multipart/form-data" id="center"><br><br>
						강의명<input type="text" name="lecName" placeholder="등록할 강의명"/><br><br>
						파일　<input type="file" name="lecPlan"/><br><br>
						<input type="button" id="bt3" value="등록 및 수정" onclick="ckValid()"/><br>
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
 
	function ckValid(){
		   var lecName= document.querySelector("[name=lecName]")
		   var lecNameV = lecName.value.trim();
		   var lecPlan = document.querySelector("[name=lecPlan]")
		   var lecPlanV = lecPlan.value.trim();
		
		   if(lecNameV==""){
		      alert("강의명을 입력해주세요.")
		      lecName.focus()
		      return;
		   }
		   if(lecPlanV==""){
			      alert("강의계획서를 첨부해주세요.")
			      lecPlan.focus()
			      return;
			   }
		   document.querySelector("form").submit();
		}
</script>
</html>