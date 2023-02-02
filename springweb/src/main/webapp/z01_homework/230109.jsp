<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="java.util.*"
    %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="path" value="${pageContext.request.contextPath }"/>
<fmt:requestEncoding value="utf-8"/>     
<!DOCTYPE html>
<%--


 --%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${path}/a00_com/bootstrap.min.css" >
<link rel="stylesheet" href="${path}/a00_com/jquery-ui.css" >
<style>
	td{text-align:center;}
</style>
<script src="${path}/a00_com/jquery.min.js"></script>
<script src="${path}/a00_com/popper.min.js"></script>
<script src="${path}/a00_com/bootstrap.min.js"></script>
<script src="${path}/a00_com/jquery-ui.js"></script>
<script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.js"></script>
<script src="https://developers.google.com/web/ilt/pwa/working-with-the-fetch-api" type="text/javascript"></script>
<script type="text/javascript">
	$(document).ready(function(){
		<%-- 
		
		--%>	
	});
</script>
</head>

<body>
<%--
2023-01-09
[1단계:개념] 1. MVC패턴으로 ajax를 구현할려고 한다. 주요 자바프로그램과 프로세스를 설명하세요
            controller, service, view

		- 모델 : 비즈니스 영역의 상태 정보를 처리한다. 주로 DAO에 전달된 데이터를 로직에 의해서
			모델 데이터를 만든다. View에 전달될 핵심 데이터 처리
			controller단에서 이 데이터를 request.setAttribute("모델명", 데이터)로 설정한다.
			백엔드 자바단에서 핵심 데이터는 모델을 만들기 위해 추가적으로
				service 객체, dao 객체가 필요로 한다.
				service : 비즈니스로직(알고리즘),
				dao : database access object - DB처리 객체
				return해서 결과값을 다시 전달해주어 모델 객체를 만든다.
				
		- 뷰 : 비즈니스 영역에 대한 받은 핵심 데이터(모델)을 controller에서 전달 받아,
			사용자가 보게 될 화면을 처리하는 역할을 한다.
			모델데이터 jsp에서 el, jstl로 활용한다.
			
			
		- 컨트롤러 : 사용자의 요청 페이지, 요청값 등을 전달 받고,
			dao 등을 통해 만들어진 모델데이터를 설정하고,
			이 모델데이터를 view단을 호출함과 동시에 전달하는 역할을 한다.
			즉, 중재자 역할을 주로 한다.

[1단계:개념] 2. Gson lib는 어떤 역할을 하는지 예제를 통해서 설명하세요
[1단계:개념] 3. controller의 PrintWriter out =response.getWriter();는 어떤 역할을 하는가?
[1단계:확인] *4. 회원등록form을 로딩하고, id중복여부를 확인하는 기능을 처리하는 MVC ajax를 구현하세요.
           기존 dao에서 검색메서드 활용
       		Controller
       		A13_MemberController.java (/member.do)
       			String id = request.getParameter("id");
       			
       			if(id==null){
       				request.getRequestDispatcher("WEB-INF\a01_mvc\a12_memberReg.html"
       				).forward(request,response);
       			}else{
       				PrintWriter out = request.getPrintWriter()
       				out.print(service.checkIdJson(id))
       			}
       		
       		Service
       		A14_MemberService.java, A06_PreparedDao.java(checkId(String id))
       			public String checkIdJson(String id){
       				return dao.checkId(id);
       			
       			}
       		
       		
       		View
       		WEB-INF\a01_mvc\a12_memberReg.html
       		<h2>회원등록</h2>
       			아이디:<input type="text" name="id"/>
       				<input type="button" value="등록여부확인" id="chIdBtn"/>
           			<input type="hidden" id="passIdck" value="false"/>
           	<script>
           		var idObj = document.querySelector("[name=id]");
           		var ckIdBtnObj = document.querySelector("#ckIdBtn");
           		var passIdchObj = document.querySelector("#passIdch");
           		idObj.onkeyup=function(){
           			//글자 유효성 check(8~18)
           			if(event.keyCode==13)
				        validChk();  		
					}	
           		}
           		chIdBtn.onclick=validChk;
           		function validChk(){
           			var idVal = idObj.value;
					if(idVal>=8 && idVal<=18){
						idCkAjax()	
					}else{
						alert("등록할 아이디는 8자~18자만 가능합니다.")
						} 
           		}
           		           		
           		function idCkAjax(){
           			var xhr = new XMLHttpRequest();
           			xhr.open("get","/member.do", true);
           			xhr.send()
           			xhr.onreadystatechange=function(){
           				if(xhr.readyState==4 && xhr.status==200){
           					console.log(xhr.responseText)
           					var hasId = JSON.parse(xhr.responseText)
           					if (hasId){
           						alert("이미 등록된 아이디입니다.");
           						passIdckObj.value="true" //최종적으로 회원등록시
           						idObj.readOnly="readOnly"//일단 인증이 되었을 때는 변경 못하게 
           					}else{
           						alert("등록 가능한 아이디입니다.");
           					}
           				}
           			}
           		}
           
           
[1단계:개념] 5. 스프링 환경 설정을 위한 순서를 기술하세요

	1) 단계별 스프링 환경
		- 1단계 : dynamic web project기반 스프링환경 설정
		- 2단계 : sts(spring tool suits) 툴을 이용한 스프링 부트 활용
	2) lib : 필요한 jar 파일 복사 
	3) 컨테이너 설정
		스프링 핵심(core) 처리로 xml파일로 설정한다.
			(dispather-servlet.xml)
		src\main\webapp\WEB-INF 가 default 설정 위치
	4) web.xml 설정 
		스프링 프레임워크 시작 front-controller 설정
			dispatcherservlet(프레임워크 지원 클래스)
			- 위 컨테이너 설정의 위치를 변경할 수 있다.
		요청값(get/post)의 한글 처리를 위한 filtering 선언
			(프레임워크 지원 클래스)
	5) MVC처리를 위한
		사용자 정의 controller/service/dao 선언
		view단 선언 : WEB-INF 하위에 보안폴드로 jsp/html호출
	6) 기타 front 프레임워크 및 lib설정
		- boot strap
		- jquery 설정		
	7) 초기 view단에서 위 front단 프레임워크 lib 호출 처리

[1단계:개념] 6. dispather.xml와 web.xml의 역할을 기술하세요.

dispather.xml
사용자들에게 보여지는 부분에 대한 요청!을 정의한다. url과 관련된 Controller, @(어노테이션), Interceptor, MultipartResolver, ViewResolver 등을 설정할 수 있으며, src/main/java/resources안에 있는 파일들을 사용할 수 있게끔 설정할 수 있다. 
web.xml
스프링 부트가 아닌 스프링을 사용할때, 대부분의 설정들을 xml파일의 형식으로 작성하는데, 이러한 xml파일들을 인식하도록 각 파일을 가르키는 역할을 한다.


[1단계:확인] *7. 다이나믹 웹프로젝트로 springweb2로 만들고, 스프링의 front단과 컨트롤러를 등록하고 backend를 호출하세요.
            ppt자료 작성 및 제출
[1단계:개념] *8. 오늘 한 예제 밑에 바로 및에 기능 메서드 추가하여 start2.do로 a02_start.jsp가 호출되는 예제를 작성하세요.

 --%>

 </body>
</html>