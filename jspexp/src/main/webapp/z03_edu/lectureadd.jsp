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
<link href="PJ_css/a00_main.css" type="text/css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/sweetalert2@9"></script>
<script type="text/javascript"
   src="http://code.jquery.com/jquery-1.8.3.min.js"></script>
</head>
<style>

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
                        <span class="span-margin" id="span1">강의등록</span>
                     </div>
                     <div>
                        <span class="span-margin">강의관리 > 강의등록</span>
                     </div>
                  </div>
               </div>

               <div class="main-box-flex">
                  <div id="main-box2">
                     <div>
                     <form>
                     <table id="addtable">
                     	<tr><td id="th">교수ID</td><td>
						 <input type="text" readOnly value="${mem.id}" name="id"/>
                     	</td></tr>
                     	<tr><td id="th">강의번호</td><td><input type="text" name="lecNum" placeholder="강의번호"/></td></tr>
                     	<tr><td id="th">연도</td><td>
                     		<select name="lecYear">
	                     	<option value="2018년">2018</option>
	                     	<option value="2019년">2019</option>
	                     	<option value="2020년">2020</option>
	                     	<option value="2021년">2021</option>
	                     	<option value="2022년" selected>2022</option>
	                     	<option value="2023년">2023</option>
	                     	</select>
                     	</td></tr>
                     	<tr><td id="th">학기</td><td>
                     	 	<select name="semester">
	                     	<option value="1학기">1학기</option>
	                     	<option value="2학기" selected>2학기</option>
	                     	</select>
                     	</td></tr>
                     	<tr><td id="th">강의명</td><td><input type="text" name="lecName" placeholder="강의명"/></td></tr>
                     	<tr><td id="th">강의실 위치</td><td><input type="text" name="lecLoc" placeholder="강의실 위치"/></td></tr>
                     	<tr><td id="th">학점</td><td>
							<select name="grade">
	                     	<option value="1">1</option>
	                     	<option value="2">2</option>
	                     	<option value="3" selected>3</option>
	                     	</select>
                   	  	</td></tr>
                		<tr><td id="th">학과</td><td>
                     		<select name="majorNo">
	                     	<option value="10">농산학과</option>
	                     	<option value="11">바이오섬유소재학과</option>
	                     	<option value="12">식품자원경제학과</option>
	                     	<option value="20">문헌정보학과</option>
	                     	<option value="21">사화학과</option>
	                     	<option value="22">심리학과</option>
	                     	<option value="30">문헌정보학과</option>
	                     	<option value="31">사화학과</option>
	                     	<option value="32">심리학과</option>
	                     	<option value="40">국악학과</option>
	                     	<option value="41">디자인학과</option>
	                     	<option value="42">미술학과</option>
	                     	<option value="50">전자공학과</option>
	                     	<option value="51">화학공학과</option>
	                     	<option value="52" selected>컴퓨터공학과</option>
	                     	<option value="60">고고인류학과</option>
	                     	<option value="61">국어국문학과</option>
	                     	<option value="62">노어노문학과</option>
	                     	<option value="70">물리학과</option>
	                     	<option value="71">수학학과</option>
	                     	<option value="72">통계학과</option>
	                     	<option value="80">간호학과</option>
	                     	<option value="90">의예과</option>
	                     	<option value="91">의학과</option>
	                     	</select>       	
                     	</td></tr>
						<tr><td id="th">학년</td><td>
	                     	<select name="class_I">
	                     	<option value="1">1학년</option>
	                     	<option value="2" selected>2학년</option>
	                     	<option value="3">3학년</option>
	                     	<option value="4">4학년</option>
	                     	</select>
                     	</td></tr>
                     	<tr><td id="th">시간</td><td><input type="text" name="times" placeholder="시간"/></td></tr>
                     	<tr><td id="th">구분</td><td>
	                     	<select name="sort">
	                     	<option value="전공" selected>전공</option>
	                     	<option value="교양">교양필수</option>
	                     	</select>
                     	</td></tr>
                     </table>
                     <input type="button" id="bt" value="등록" onclick="ckValid()"/>
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
	String lecName = request.getParameter("lecName");
	String lecLoc = request.getParameter("lecLoc");
	String lecPlan = null;
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
	String lecYear = request.getParameter("lecYear");
	String semester = request.getParameter("semester");
	String grade = request.getParameter("grade");
	int gradeInt = 0;
	if(grade!=null&&!grade.equals("")){
		System.out.println("문자열크기:"+grade.length());
		try{
			gradeInt = Integer.parseInt(grade);
		}catch(Exception e){
			log(e.getMessage());
		}
	}
	
	String majorNo = request.getParameter("majorNo");
	int majorNoInt = 0;
	if(majorNo!=null&&!majorNo.equals("")){
		System.out.println("문자열크기:"+majorNo.length());
		try{
			majorNoInt = Integer.parseInt(majorNo);
		}catch(Exception e){
			log(e.getMessage());
		}
	}
	String times = request.getParameter("times");
	String sort = request.getParameter("sort");
	String id = request.getParameter("id");
	String class_I = request.getParameter("class_I");
	int class_IInt = 0;
	if(class_I!=null&&!class_I.equals("")){
		System.out.println("문자열크기:"+class_I.length());
		try{
			class_IInt = Integer.parseInt(class_I);
		}catch(Exception e){
			log(e.getMessage());
		}
	}
	   boolean isInsert = false;
	   if(lecNum!=null&& !lecNum.equals("")){
			 lectureVO ins = new lectureVO(lecNumInt, lecName, lecLoc, lecYear, semester, gradeInt, majorNoInt, times, sort, id, class_IInt);
			 eduDao dao = new eduDao();
		      dao.insertLecture(ins);
		      isInsert = true;
		   }
	
   %>   
   function ckValid(){
	   var lecNum = document.querySelector("[name=lecNum]")
	   var lecNumV = lecNum.value.trim();
	   var lecName = document.querySelector("[name=lecName]")
	   var lecNameV = lecName.value.trim();
	   var lecLoc = document.querySelector("[name=lecLoc]")
	   var lecLocV = lecLoc.value.trim();
	   var lecYear = document.querySelector("[name=lecYear]")
	   var lecYearV = lecYear.value.trim();
	   var semester = document.querySelector("[name=semester]")
	   var semesterV = semester.value.trim();
	   var grade = document.querySelector("[name=grade]")
	   var gradeV = grade.value.trim();
	   var majorNo = document.querySelector("[name=majorNo]")
	   var majorNoV = majorNo.value.trim();
	   var times = document.querySelector("[name=times]")
	   var timesV = times.value.trim();
	   var sort = document.querySelector("[name=sort]")
	   var sortV = sort.value.trim();
	   var class_I = document.querySelector("[name=class_I]")
	   var class_IV = class_I.value.trim();
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
	   else if(lecYearV==""){
		  Swal.fire({
			  title: '연도를 선택해주세요.',
			  icon: 'warning',
			  showCancelButton: false,
			  confirmButtonColor: '#3085d6',
			  confirmButtonText: '확인'
			}).then((result) => {
			  if (result.value) {
			      lecYear.focus()
			      return;
			  }
		  })		      

		      }
	   else if(semesterV==""){
	      alert("학기를 선택해주세요.")
	      semester.focus()
	      return;
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
	   else if(lecLocV==""){
	      Swal.fire({
			  title: '강의실을 입력해주세요.',
			  icon: 'warning',
			  showCancelButton: false,
			  confirmButtonColor: '#3085d6',
			  confirmButtonText: '확인'
			}).then((result) => {
			  if (result.value) {
			      lecLoc.focus()
			      return;
			  }
		  })	

	   }
	   else if(gradeV==""){
	      Swal.fire({
			  title: '학점을 선택해주세요.',
			  icon: 'warning',
			  showCancelButton: false,
			  confirmButtonColor: '#3085d6',
			  confirmButtonText: '확인'
			}).then((result) => {
			  if (result.value) {
			      grade.focus()
			      return;
			  }
		  })	      

	   }

	   else if(majorNoV==""){
	      Swal.fire({
			  title: '학과를 선택해주세요.',
			  icon: 'warning',
			  showCancelButton: false,
			  confirmButtonColor: '#3085d6',
			  confirmButtonText: '확인'
			}).then((result) => {
			  if (result.value) {
			      majorNo.focus()
			      return;
			  }
		  })	      

	   }
	   else if(class_IV==""){
	      Swal.fire({
			  title: '학년을 입력해주세요.',
			  icon: 'warning',
			  showCancelButton: false,
			  confirmButtonColor: '#3085d6',
			  confirmButtonText: '확인'
			}).then((result) => {
			  if (result.value) {
			      class_I.focus()
			      return;
			  }
		  })		      

		}
	   else if(timesV==""){
	      Swal.fire({
			  title: '강의 시간을 입력해주세요.',
			  icon: 'warning',
			  showCancelButton: false,
			  confirmButtonColor: '#3085d6',
			  confirmButtonText: '확인'
			}).then((result) => {
			  if (result.value) {
			      times.focus()
			      return;
			  }
		  })	      

	   }
	   else if(sortV==""){
	      Swal.fire({
			  title: '전공 구분을 입력해주세요.',
			  icon: 'warning',
			  showCancelButton: false,
			  confirmButtonColor: '#3085d6',
			  confirmButtonText: '확인'
			}).then((result) => {
			  if (result.value) {
			      sort.focus()
			      return;
			  }
		  })	      

	   }else{
		   document.querySelector("form").submit();
	   }

		
	   
	   
	}
</script>
</html>