<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"
    import="java.util.*"
     import="jspexp.vo.*"
    import="jspexp.a13_database.*"
   
   %>
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
.sel01{
	width:100px; height:38px; margin-left:5px;
	border-radius:4px; 
}
#input01{
	width:220px; height:35px; margin-left:10px;
	border-radius:4px; 
	border:1px solid gray;

}
#input02{
	width:220px; height:37px; margin-left:15px;
	border-radius:4px; 
	border:1px solid gray;
}
.btn{
	width:57px; height:33px; margin-left:20px;
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
  border:1px solid lightgray;
  color: white;
  
}
table{
	 border-collapse: collapse;
	 border:1px solid lightgray;
	 
}
table td{
	border:1px solid lightgray;
	text-align:center;
}
.entry{
   background-color: rgb(52, 152, 219);
    color: #fff;
    padding: 0px 12px;
    height: 40px;
    display: inline-block;
    border-radius: 20px;
    line-height: 40px;
    font-size: 14px;
    font-weight: 600;
    margin-right: 10px;
    border: 1px solid lightgray;
}

.del{
   background-color: rgb(211, 84, 0);
    color: #fff;
    padding: 0px 12px;
    height: 40px;
    display: inline-block;
    border-radius: 20px;
    line-height: 40px;
    font-size: 14px;
    font-weight: 600;
    border: 1px solid lightgray;
}
#bt2{
font-size: 15px;
border-radius:4px; 
background:#0066CC;
color:white;
border:1px solid gray;
font-size:15px;
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
                        <span class="span-margin" id="span1">수강신청</span>
                     </div>
                     <div>
                        <span class="span-margin">수강신청 > 수강신청</span>
                     </div>
                  </div>
               </div>

               <div class="main-box-flex">
                  <div id="main-box2">
                     <div>
                     	<form>
	                     	<h5 style="color:#A0A0A0; margin-left:25px; margin-top:30px; display:inline-block;">구분</h5>
	                     	<select class="sel01" name="majSection">
	                     		<option value="major">전공</option>
	                     		<option value="liberal">교양</option>
	                     	</select>
	                     	<h5 style="color:#A0A0A0; margin-left:15px; margin-top:30px; display:inline-block;">종류</h5>
	                     	<select class="sel01" name="lecSection">
	                     		<option value="lecName">강의명</option>
	                     		<option value="lecNo">강의번호</option>
	                     	</select>
	                     	<h5 style="color:#A0A0A0; margin-left:15px; margin-top:30px; display:inline-block;">입력</h5>
	                     	<input id="input01" type="text" name="search" placeholder="검색어를 입력하세요"/>
	                     	<input class="btn" type="submit" value="확인">
                     	</form>
                     	<%
                     	String sort = "";
                     	                     	   String lecName = "";
                     	                     	   int lecNo = 0;
                     	                     	   String majSection = request.getParameter("majSection");
                     	                     	   String lecSection = request.getParameter("lecSection");
                     	                     	   String search = request.getParameter("search");
                     	                     	   if(majSection==null){
                     	                     	         majSection="";
                     	                     	   }
                     	                     	   if(lecSection==null){
                     	                     	         lecSection="";
                     	                     	   }
                     	                     	   if(majSection.equals("major")){
                     	                     	         sort="전공";
                     	                     	   }else if(majSection.equals("liberal")){
                     	                     	         sort="교양";
                     	                     	   }
                     	                     	   if(lecSection.equals("lecName")){
                     	                     	         lecName=search;
                     	                     	   }else if(lecSection.equals("lecNo")){
                     	                     	         lecNo=Integer.parseInt(search);
                     	                     	   }
                     	                     	         stdMgr dao01 = new stdMgr();
                     	                     	         Lecture01 sch01 = new Lecture01(sort,lecName);
                     	                     	         Lecture01 sch02 = new Lecture01(sort,lecNo);
                     	%>
                     	
                     	<br>
                     	<form>
	                     	<h5 style="color:#A0A0A0; margin-left:25px; margin-top:30px; display:inline-block;">학부</h5>
	                     	<jsp:useBean id="dao" class="jspexp.a13_database.stdMgr"/>
	                     	<jsp:useBean id="sch" class="jspexp.vo.Major"/>
	                     	<jsp:setProperty property="*" name="sch"/>
	                     	<select class="sel01" name="major">
	                     		<c:forEach var="maj" items="${dao.getMajorList()}">
	                     			<option value="${maj.majorName}">${maj.majorName}</option>
	                     		</c:forEach>
	                     	</select>
	                     	<h5 style="color:#A0A0A0; margin-left:15px; margin-top:30px; display:inline-block;">학년</h5>
	                     	<select class="sel01" name="class_I">
	                     		<option value="0">전체</option>
	                     		<option value="1">1</option>
	                     		<option value="2">2</option>
	                     		<option value="3">3</option>
	                     		<option value="4">4</option>
	                     	</select>
	                     	<input class="btn" type="submit" value="확인">
                     	</form>
                     	<%
                     	String major = request.getParameter("major");
                     	                     		String class_I = request.getParameter("class_I");
                     	                     		if(major==null){
                     	                     			major="";
                     	                     		}
                     	                     		if(class_I==null){
                     	                     			class_I="0";
                     	                     		}
                     	                     		
                     	                     		Lecture01 sch03 = new Lecture01(major);
                     	                     		Lecture01 sch04 = new Lecture01(Integer.parseInt(class_I),major);
                     	%>
                     
                     	<table width="1370" align="center">
                     		<col width="100px">
                     		<col width="100px">
                     		<col width="100px">
                     		<col width="100px">
                     		<col width="500px">
                     		<col width="150px">
                     		<col width="100px">
                     		<col width="100px">
	                     	<thead>
	                     		<tr><th>강의번호</th><th>학부</th><th>학년</th><th>구분</th><th>강의명</th><th>강의실</th><th>강의시간</th><th>학점</th><th></th></tr>
	                     	</thead>
	                     	<tbody>
	                     		<%
	                     		if(lecName!=""){
	                     			                     				for(Lecture01 lec : dao01.checkLecName(sch01)){
	                     		%>
	                     		<tr><td><%=lec.getLecNum()%></td><td><%=lec.getMajorName()%></td>
	                     		<td><%=lec.getclass_I()%></td><td><%=lec.getSort()%></td><td><%=lec.getLecName()%></td>
	                     			<td><%=lec.getLecLoc()%></td><td><%=lec.getTimes()%></td><td><%=lec.getGrade()%></td>
	                     			<td><input name="addBtn" class="entry" type="button" value="담기" onclick="addLec('<%=lec.getLecNum()%>','<%=lec.getTimes()%>','<%=lec.getMajorName()%>')"/></td>
	                     		</tr>
	                     		<%
	                     		}
	                     			                     			}else if(lecNo!=0){
	                     			                     				for(Lecture01 lec : dao01.checkLecNum(sch02)){
	                     		%>
	                     		<tr><td><%=lec.getLecNum()%></td><td><%=lec.getMajorName()%></td>
	                     		<td><%=lec.getclass_I()%></td><td><%=lec.getSort()%></td><td><%=lec.getLecName()%></td>
	                     			<td><%=lec.getLecLoc()%></td><td><%=lec.getTimes()%></td><td><%=lec.getGrade()%></td>
	                     			<td><input class="entry" type="button" value="담기" onclick="addLec('<%=lec.getLecNum()%>','<%=lec.getTimes()%>','<%=lec.getMajorName()%>')"></td>
	                     		</tr>
	                     		<%
	                     		} } 
	                     			                     			if(major!="" && Integer.parseInt(class_I)==0){
	                     			                     				for(Lecture01 lec : dao01.checkMajor(sch03)){
	                     		%>
	                     			<tr><td><%=lec.getLecNum()%></td><td><%=lec.getMajorName()%></td>
	                     			<td><%=lec.getclass_I()%></td><td><%=lec.getSort()%></td><td><%=lec.getLecName()%></td>
	                     			<td><%=lec.getLecLoc()%></td><td><%=lec.getTimes()%></td><td><%=lec.getGrade()%></td>
	                     			<td><input class="entry" type="button" value="담기" onclick="addLec('<%=lec.getLecNum()%>','<%=lec.getTimes()%>','<%=lec.getMajorName()%>')"/></td>
	                     		</tr>
	                     		<%
	                     		}} else if(major!="" && Integer.parseInt(class_I)!=0){
	                     			                     			for(Lecture01 lec : dao01.checkClass(sch04)){
	                     		%>
		                     			<tr><td><%=lec.getLecNum()%></td><td><%=lec.getMajorName()%></td>
		                     			<td><%=lec.getclass_I()%></td><td><%=lec.getSort()%></td><td><%=lec.getLecName()%></td>
		                     			<td><%=lec.getLecLoc()%></td><td><%=lec.getTimes()%></td><td><%=lec.getGrade()%></td>
		                     			<td><input class="entry" type="button" value="담기" onclick="addLec('<%=lec.getLecNum()%>','<%=lec.getTimes()%>','<%=lec.getMajorName()%>')"/></td>
		                     		</tr> 
	                     		 <%}} %>
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
function logout(){
    if(confirm("로그아웃하시겠습니까?")){
       location.href="a01_login_DB.jsp"
    }
 }

	function addLec(lecNum,lecTimes,major){
	
		callAjax(lecNum,lecTimes,major)
		
	}
	
	function callAjax(lecNum,lecTimes,major){
	
		var xhr = new XMLHttpRequest()
		var qstr = "?id=${mem.id}&lecNum="+lecNum+"&lecTimes="+lecTimes+"&major="+major
		xhr.open("get","insStdLec.jsp"+qstr,true)
		xhr.send()
		xhr.onreadystatechange=function(){
			if(xhr.readyState==4&&xhr.status==200){
				var data = JSON.parse(xhr.responseText)
				
				console.log(data.hasLec)
				
				if(data.hasLec){
					alert("중복된 강의입니다.\n강의번호 또는 강의시간 또는 학과를 확인하세요")
				}else{
					alert("수강신청이 완료되었습니다")
				}
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