<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="java.util.*"    
    import="jspexp.vo.*"
    import="jspexp.a13_database.*"    
    import="jspexp.a13_database.vo.*"     
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="/a00_com/a01_common.css" rel="stylesheet">
<script type="text/javascript">
/*
 
 */
</script>
</head>
<body>
<div id="container"></div>
<%-- 
#쿠키만들기
--%>
<%
	//1. 쿠키만들기
	Cookie c1 = new Cookie("cnt","8");
	//2. 쿠키 클라이언트에 보내기 
	response.addCookie(c1);
%>
	<h2>쿠키값 생성</h2>
	<a href="a05_CookieList.jsp">내가 만든 쿠키~🍪🍪🍪🍪</a>



</body>
<script type="text/javascript">
function go(proc){
	document.querySelector("[name=proc]").value=proc
	document.forms[0].submit();
	
}
/*
# 요청값을 통한 쿠키의 생성/수정/삭제 처리
1. 파일 정보 
	1) a05_CookieList.jsp : 쿠키값 전체 리스트
	2) a09_proc.jsp : 생성/수정/삭제 따라서 변경 처리 
2. 개발 순서
	1) 쿠키값 전체 리스트 확인
	 	- 기능 버튼 처리
	 		등록/수정/삭제
	 	- form action = "a09_proc.jsp"
	 	- 기능요청값 처리 : <input type="hidden" name="proc"/>
		- 버튼을 눌렀을 때, script 처리
			function go(proc){
				document.querySelector("[name=proc]").value=proc
		}
	2) 요청값에 따른 쿠키데이터 처리 (a09_proc.jsp)
		-cidx : index로 체크된 값만 전달
		 ckey : 쿠키의 요청 키를 전달
		 cval : 쿠키의 요청 값을 전달
		-proc : 쿠키의 등록/수정/삭제 처리..add upt del
		String proc = request.getParamater("proc");
	 	String [] cidx= request.getParameterValues("cidx");
	 	String [] ckey= request.getParameterValues("ckey");
	 	String [] cval= request.getParameterValues("cval");
	 	
		if(proc!=null){
			for(String cidxS:cidx){
				// check box로 선택되어진 key/value
				int idx = Integer.parseInt(cidxS);
				String key = ckey[idx];
				String val = ckey[cval];
				if(proc.equals.("add")||proc.equals("upt")){
					Cookie c = new Cookie(key,val);
					response.addCookie(c);
				}
				if(proc.equals("del")){
					for(Cookie : request.getCookie()){
						if(c.getName().equals("key")){
							c.setMaxAge(0);
							response.addCookie(c);
						}
					}
				
				}
					
				}
}
			response.sendRedirect("a05_CookieList.jsp");
				*/

var div = document.querySelector("#container")
div.innerHTML+="<br>"
</script>
</html>