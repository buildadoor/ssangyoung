<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="java.util.*"
    %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="path" value="${pageContext.request.contextPath }"/>
<fmt:requestEncoding value="utf-8"/>     
<!DOCTYPE html>

<html lang="en">
<style>
    body {
      min-height: 100vh;

      background: -webkit-gradient(linear, left bottom, right top, from(#92b5db), to(#1d466c));
      background: -webkit-linear-gradient(bottom left, #92b5db 0%, #1d466c 100%);
      background: -moz-linear-gradient(bottom left, #92b5db 0%, #1d466c 100%);
      background: -o-linear-gradient(bottom left, #92b5db 0%, #1d466c 100%);
      background: linear-gradient(to top right, #FFFFFF 100%, #FFFFFF 100%);
    }

    .input-form {
      max-width: 680px;

      margin-top: 80px;
      padding: 32px;

      background: #fff;
      -webkit-border-radius: 10px;
      -moz-border-radius: 10px;
      border-radius: 10px;
      -webkit-box-shadow: 0 8px 20px 0 rgba(0, 0, 0, 0.15);
      -moz-box-shadow: 0 8px 20px 0 rgba(0, 0, 0, 0.15);
      box-shadow: 0 8px 20px 0 rgba(0, 0, 0, 0.15)
    }
  </style>
<head>
<head>
<meta charset="utf-8">
    <title>올리브영</title>
    <meta content="width=device-width, initial-scale=1.0" name="viewport">
    <meta content="Free HTML Templates" name="keywords">
    <meta content="Free HTML Templates" name="description">
   <link rel="stylesheet" href="${path}/resources/a00_com/bootstrap.min.css" >
   <link rel="stylesheet" href="${path}/resources/a00_com/jquery-ui.css" >
    <!-- Favicon -->
    <link href="${path}/resources/img/favicon.ico" rel="icon">

    <!-- Google Web Fonts -->
    <link rel="preconnect" href="https://fonts.gstatic.com">
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@100;200;300;400;500;600;700;800;900&display=swap" rel="stylesheet"> 

    <!-- Font Awesome -->
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.10.0/css/all.min.css" rel="stylesheet">

    <!-- Libraries Stylesheet -->
    <link href="${path}/resources/lib/owlcarousel/assets/owl.carousel.min.css" rel="stylesheet">

    <!-- Customized Bootstrap Stylesheet -->
    <link href="${path}/resources/css/style.css" rel="stylesheet">
  
<script src="${path}/a00_com/jquery.min.js"></script>
<script src="${path}/a00_com/popper.min.js"></script>
<script src="${path}/a00_com/bootstrap.min.js"></script>
<script src="${path}/a00_com/jquery-ui.js"></script>
<script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.js"></script>
<script src="https://developers.google.com/web/ilt/pwa/working-with-the-fetch-api" type="text/javascript"></script>
<script type="text/javascript">
	$(document).ready(function(){
			$("#regBtn").click(function(){
		location.href="${path}/insertFrm.do"
		})
		$("#goProduct").click(function(){
		location.href="${path}/ovProductrList.do"
		})
		$("#goMain").click(function(){
			location.href="${path}/main.do"	
		})
		$("#goLogin").click(function(){
			location.href="${path}/login.do"		
		});
	});
</script>
</head>
<body>
<!-- Topbar Start -->
    <div class="container-fluid">
        
        <div class="row align-items-center py-3 px-xl-5">
            <div class="col-lg-4 d-none d-lg-block">
                <a href="${path}/main.do" class="text-decoration-none">
                  　<img style="width:80%" src="${path}/resources/img/main.png">
                </a>
            </div>
            <div class="col-lg-5 col-8 text-left">
                <form action="">
                    <div class="input-group">
                        <input type="text" class="form-control" placeholder="Search for products">
                        <div class="input-group-append">
                            <span class="input-group-text bg-transparent text-primary">
                                <i class="fa fa-search"></i>
                            </span>
                        </div>
                    </div>
                </form>
            </div>
            <div style="margin-left:150px;" class="col-lg-4 col-4">
               <!-- 회원가입 -->
               <a class="text-dark" id="regBtn" >회원가입</a>
               <span class="text-muted px-2">|</span>
                <!-- 로그인 -->
               <a class="text-dark" id="goLogin">로그인</a>
               <span class="text-muted px-2">|</span>
               <a class="text-dark" href="${path}/csFrm.do">고객센터</a><br>
               <a class="text-dark" ><b><u>${mem.id}님 로그인</u></b></a>
        </div>
    </div>
    <!-- Topbar End -->
  

    <!-- Navbar Start -->
    <div style="margin-top:30px" class="container-fluid">
        <div class="row border-top px-xl-5">
            <div class="col-lg-3 d-none d-lg-block">
                <a class="btn shadow-none d-flex align-items-center justify-content-between bg-primary text-white w-100" data-toggle="collapse" href="#navbar-vertical" style="height: 65px; margin-top: -1px; padding: 0 30px;">
                       
                    <h6 class="m-0"><b>카테고리</b></h6>
                    <i class="fa fa-angle-down text-dark"></i>
                </a>
                <nav class="collapse position-absolute navbar navbar-vertical navbar-light align-items-start p-0 border border-top-0 border-bottom-0 bg-light" id="navbar-vertical" style="width: calc(100% - 30px); z-index: 1;">
                    <div class="navbar-nav w-100 overflow-hidden" style="height: 410px">
                        <div class="nav-item dropdown">
                            <a href="#" class="nav-link" data-toggle="dropdown">기초화장품 <i class="fa fa-angle-down float-right mt-1"></i></a>
                            <div class="dropdown-menu position-absolute bg-secondary border-0 rounded-0 w-100 m-0">
                                <a href="" class="dropdown-item">스킨케어</a>
                                <a href="" class="dropdown-item">마스크팩</a>
                                <a href="" class="dropdown-item">클렌징</a>
                                <a href="" class="dropdown-item">선케어</a>
                            </div>
                        </div>
                        <a href="" class="nav-item nav-link">더모코스메틱</a>
                        <a href="" class="nav-item nav-link">메이크업/네일</a>
                        <a href="" class="nav-item nav-link">바디케어</a>
                        <a href="" class="nav-item nav-link">헤어케어</a>
                        <a href="" class="nav-item nav-link">향수/디퓨저</a>
                    </div>
                </nav>
            </div>
                <div class="col-lg-9">
                <nav class="navbar navbar-expand-lg bg-light navbar-light py-3 py-lg-0 px-0">
                    <a href="" class="text-decoration-none d-block d-lg-none">
                        <h1 class="m-0 display-5 font-weight-semi-bold"><span class="text-primary font-weight-bold border px-3 mr-1">E</span>Shopper</h1>
                    </a>
                    <button type="button" class="navbar-toggler" data-toggle="collapse" data-target="#navbarCollapse">
                        <span class="navbar-toggler-icon"></span>
                    </button>
                    <div class="collapse navbar-collapse justify-content-between" id="navbarCollapse">
                        <div class="navbar-nav mr-auto py-0">
                        <a id="goProduct" class="nav-item nav-link"><b>오특</b></a>
                            <a href="index.html" class="nav-item nav-link"><b>신상</b></a>
                            <a href="index.html" class="nav-item nav-link"><b>랭킹</b></a>
                            <a href="index.html" class="nav-item nav-link"><b>프리미엄관</b></a>
                            <a href="index.html" class="nav-item nav-link"><b>기획전</b></a>
                            <a href="index.html" class="nav-item nav-link"><b>세일</b></a>
                            <a href="index.html" class="nav-item nav-link"><b>기프트카드</b></a>
                            <a href="index.html" class="nav-item nav-link"><b>멤버쉽/쿠폰</b></a>
                            <a href="index.html" class="nav-item nav-link"><b>이벤트</b></a>
                        </div>
                    </div>
                </nav>
            </div>
        </div>
    </div>
               
            </div>
        </div>
    </div>
    <!-- Navbar End -->
      <!-- main -->
      
    <h2 style="font-weight:bold;margin-left:320px;margin-top:30px;">
    회원 조회</h2>
 
	<div class="row">
		<div class="col-2"></div>
		<div style="border:2px solid #A6CD48;border-left:none;
		border-right:none;" class="col-8">
		<form id="frm01" class="form"  method="post">
			<div style="margin-top:15px;" class="row text-center">
				<div class="col">
					<span style="font-size:18px;font-weight:bold; "></span>
					<input type="text" size="10"  name="id" value="${sch.id}" 
					placeholder="회원 id입력">
				</div>
				
				<div class="col">
					<span style="font-size:18px;font-weight:bold;"> </span>
					<input type="text" size="10" name="nickname"
					value="${sch.nickname}" placeholder="회원명 입력">
				</div>    
				<button class="btn btn-info" type="submit" 
				style="background-color:#A6CD48">검색</button>
			</div>
			
	<br><br>
	<div class="row">
		<div class="col-2"></div>
		<div class="col-10 text-center">
			<table width="80%">
			<thead>
				<tr><th>id</th><th>권한<br>(0 관리자/ 1 회원)</th>
		        <th>이름</th><th>주소</th>
		        <th>포인트</th></tr></thead>
			<tbody>
			<c:forEach var="OvMember" items="${OvMemberList}">
    		<tr><td>${OvMember.id}</td><td>${OvMember.auth}</td>
    		<td>${OvMember.nickname}</td>
    		<td>${OvMember.address}</td>
    		<td>${OvMember.point}</td>
    		</tr>
    		</c:forEach>
			</tbody>
			</table>
		</div>
		<div class="col-2"></div>
	</div>
	


</form>
</div>
</div>
 	  <!-- Footer Start -->
    <div class="container-fluid bg-secondary text-dark mt-5 pt-5">
        <div class="row px-xl-5 pt-5">
            <div class="col-lg-4 col-md-12 mb-5 pr-3 pr-xl-5">
                <a href="" class="text-decoration-none">
                    <h1 class="mb-4 display-5 font-weight-semi-bold">
                    <img src="${path}/resources/img/foot_logo.png"></h1>
                </a>
          
                <p class="mb-2">공지사항</p>
                <p class="mb-2">고객센터이용안내</p>
                <p class="mb-2">온라인몰 고객센터</p>
                <h1 class="mb-4 display-5 font-weight-semi-bold">
                <p class="mb-4">
                    <span class="text-primary font-weight-bold border px-3 mr-1">1522-0882</span></p></h1>
                <p class="mb-2">매장 고객센터</p>
                <h1 class="mb-4 display-5 font-weight-semi-bold">
                <p class="mb-4">
                    <span class="text-primary font-weight-bold border px-3 mr-1">1577-4887</span></p></h1>
            </div>
            <div class="col-lg-8 col-md-12">
                <div class="row">
                    <div class="col-md-4 mb-5">
                        <h5 class="font-weight-bold text-dark mb-4">고객센터 운영<br>[평일09:00-18:00]</h5>
                        <div class="d-flex flex-column justify-content-start">
                            <a class="text-dark mb-2" href="index.html">주말 및 공휴일은<br> 1:1문의하기를 이용해주세요</a>
                            <a class="text-dark mb-2" href="shop.html">업무가 시작되면 바로 처리해드립니다.</a>
                            <button class="footbtn">1:1문의하기</button>
                           <button class="footbtn">자주하는 질문</button>
                        </div>
                    </div>
                    <div class="col-md-4 mb-5">
                        <h5 class="font-weight-bold text-dark mb-4"></h5>
                        <div class="d-flex flex-column justify-content-start">
                            <a class="text-dark mb-2" href="index.html"></a>
                            <a class="text-dark mb-2" href="shop.html"></a>
   
                        </div>
                    </div>
                    <div class="col-md-4 mb-5">
                        <h5 class="font-weight-bold text-dark mb-4">올리브영 모바일웹</h5>
                      <img src="${path}/resources/img/qr.png">
            </div>
        </div>
        <div class="row border-top border-light mx-xl-5 py-4">
            <div class="col-md-6 px-xl-0">
                <p class="mb-md-0 text-center text-md-left text-dark">
                    &copy; <a class="text-dark font-weight-semi-bold" href="#">씨제이올리브영 주식회사</a>. 
대표이사 : 구창근 | 사업자등록번호 : 809-81-01574
주소 : (04323) 서울특별시 용산구 한강대로 372, 24층
(동자동, KDB타워)
호스팅사업자 : CJ 올리브네트웍스
통신판매업신고번호 : 2019-서울용산-1428
                </p>
            </div>
            <div class="col-md-6 px-xl-0 text-center text-md-right">
                <img class="img-fluid" src="${path}/resources/img/payments.png" alt="">
            </div>
        </div>
    </div>
    <!-- Footer End -->


    <!-- Back to Top -->
    <a href="#" class="btn btn-primary back-to-top"><i class="fa fa-angle-double-up"></i></a>


    <!-- JavaScript Libraries -->
    <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.bundle.min.js"></script>
    <script src="<c:url value="/resources/lib/easing/easing.min.js" />"></script>
    <script src="<c:url value="/resources/lib/owlcarousel/owl.carousel.min.js" />"></script>

    <!-- Contact Javascript File -->
    <script src="<c:url value="/resources/mail/jqBootstrapValidation.min.js" />"></script>
    <script src="<c:url value="/resources/mail/contact.js" />"></script>

    <!-- Template Javascript -->
    <script src="<c:url value="/resources/js/main.js" />"></script>
</body>
</html>