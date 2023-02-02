<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="java.util.*"    
    import="jspexp.vo.*"
    import="javaexp.sql.*"
    import="jspexp.a13_database.*"
        import="dao.*"
    import="vo.*"    
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>쌍용 대학교</title>
<link href="PJ_css/a00_main.css" type="text/css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/sweetalert2@9"></script>
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
margin-left: 48%;
border-radius:4px; 
background:#0066CC;
color:white;
border:1px solid gray;
font-size:15px;
}
#th {
  padding-top: 2px;
  padding-bottom: 5px;
  background-color: #808080;
  color: white;
  text-align:center;
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
                        <span class="span-margin" id="span1">출결등록/수정</span>
                     </div>
                     <div>
                        <span class="span-margin">학생관리 > 출결등록/수정</span>
                     </div>
                  </div>
               </div>

               <div class="main-box-flex">
                  <div id="main-box2">
                     <div>
                     <form>
                     <table id="addtable">
						<tr><td id="th">강의 번호</td><td><input type="text" name="lecNum" placeholder="강의번호"/></td></tr>
						<tr><td id="th">학번</td><td><input type="text" name="id" placeholder="학번"/></td></tr>
						<tr><td id="th">출결 일수<td><input type="text" name="attendance" placeholder="출결일수"/>
                     	</td></tr><tr><td>　</td></tr>
                     </table>
                     <input type="submit" id="bt3" value="등록/수정" onclick="ckValid()"/>
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
   <%
   
	
	String lecNum = request.getParameter("lecNum");
	int lecNumInt = 0;
	if(lecNum!=null&&!lecNum.equals("")){
		System.out.println("문자열크기:"+lecNum.length());
		try{
			lecNumInt = Integer.parseInt(lecNum);
		}catch(Exception e){
			log(e.getMessage());
		}
	}
	String id = request.getParameter("id");
	String attendance = request.getParameter("attendance");
	int attendanceInt = 0;
	if(attendance!=null&&!attendance.equals("")){
		System.out.println("문자열크기:"+attendance.length());
		try{
			attendanceInt = Integer.parseInt(attendance);
		}catch(Exception e){
			log(e.getMessage());
		}
	}
	
	   boolean isInsert = false;
	   if(lecNum!=null&& !lecNum.equals("")){
		 stdLectureVO ins = new stdLectureVO(lecNumInt, id, attendanceInt);
		  eduDao dao = new eduDao();
	      dao.updateAt(attendanceInt, id, lecNumInt);
	      isInsert = true;
	   }
	
   %>   
	function ckValid(){
		   var id= document.querySelector("[name=id]")
		   var idV = id.value.trim();
		   var lecNum = document.querySelector("[name=lecNum]")
		   var lecNumV = lecNum.value.trim();
		   var attendance = document.querySelector("[name=attendance]")
		   var attendanceV = attendance.value.trim();
		   if(lecNumV==""){
			  Swal.fire({
				  title: '강의 번호를 입력해주세요.',
				  icon: 'warning',
				  showCancelButton: false,
				  confirmButtonColor: '#3085d6',
				  confirmButtonText: '확인'
				}).then((result) => {
				  if (result.value) {
				      lecNum.focus()
				      return;
				  }
			  })		      

		   }
		   else if(lecNameV==""){
			  Swal.fire({
				  title: '강의명을 입력해주세요.',
				  icon: 'warning',
				  showCancelButton: false,
				  confirmButtonColor: '#3085d6',
				  confirmButtonText: '확인'
				}).then((result) => {
				  if (result.value) {
				      lecName.focus()
				      return;
				  }
			  })			      

			}
		   else if(attendanceV==""){
			  Swal.fire({
				  title: '출결 일수를 입력해주세요.',
				  icon: 'warning',
				  showCancelButton: false,
				  confirmButtonColor: '#3085d6',
				  confirmButtonText: '확인'
				}).then((result) => {
				  if (result.value) {
				      attendance.focus()
				      return;
				  }
			  })			      

			}else{
				document.querySelector("form").submit();
			}
		  
		}
</script>
</html>