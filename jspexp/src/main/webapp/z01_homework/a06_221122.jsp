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
<%-- 
2022-11-22
[1단계:개념] 1. jsp의 request 객체의 기능와 기능메서드를 기술하세요
 jsp의 request 
1. 웹 브라우저가 웹 서버에 전송한 요청 관련 정보 제공
2. 주요 기능
   1) 클라이언트(웹 브라우저)와 관련된 정보 읽기 기능
   2) 서버와 관련된 정보 읽기 기능
   3) 클라이언트가 전송한 요청 파라미터 읽기 기능
   4) 클라이언트가 전송한 쿠키 읽기 기능
   5) 속성 처리 기능
3. request 기본 객체 - 주요 정보 제공 메소드
   기준이 되는 서버 : http:local
   1) getRemoteAddr()
      웹 서버에 연결한 클라이언트의 ip 주소를 구한다.
      게시판이나 방명록 등에서 글 작성자의 ip 주소가 자동으로 입력되기도 하는데,
         이 때, 입력되는 ip주소가 바로 이 메서드를 사용하여 구현되는 것이다.
   2) getMethod()
      웹 브라우저가 정보를 전송할 때, 사용한 방식을 구한다.
   3) getRequestURI() : 웹브라우저가 요청한 URL에서 경로를 구한다.
   4) getContextPath() : JSP 페이지가 속한 웹 어플리케이션의 컨텍스트 경로를 구한다.
   5) getServerName() : 연결할 때 사용한 서버 이름을 구한다.
   6) getServerPort() : 서버가 실행중인 포트 번호를 구한다.
   
[1단계:개념] 2. request.getParameter(), request.getParameterValues()의 차이를 기술하세요.
request.getParameter 단일 값을 요청받을때 getParameterValues 다중 값을 요청받을때 사용한다.

[1단계:확인] 3. form 하위 요소객체와 request.getParameterNames()를 이용하여 사원명/사원번호/부서이름을 등록리스트하세요
--%>
 <form>
	사원명: <input type="text" name="사원명" ><br>
	사원번호: <input type="text" name="사원번호"><br>
	부서이름: <input type="text" name="부서명"><br>
	<input type="submit" value="등록">
</form>
	<%
	Enumeration e = request.getParameterNames();
	while(e.hasMoreElements()){
		String key = (String)e.nextElement();
	String value = request.getParameter(key); //요청값을 가지고 온다.
	%>
    	<h3><%=key%>:<%=value%></h3>
    <%} %>
 <%-- 
[1단계:확인] 4.(선택) form요소객체를 이용하여 학생3명의 이름입력하고 요청값을 처리하세요.
--%>
 <form>
	학생1: <input type="text" name="student01" ><br>
	학생2: <input type="text" name="student02"><br>
	학생3: <input type="text" name="student03"><br>
	 <input type="submit" value="처리">
</form>
<table>
	<tr><th>이름</th></tr>
	<%
	Enumeration e1 = request.getParameterNames();
	while(e.hasMoreElements()){
		String key = (String)e.nextElement();
	%>
    	<tr><td><%=request.getParameter(key) %></td></tr>
    
    <%} %>
    </table>
 <%-- 
[2단계:확인] 4.(선택) form요소 객체를 이용하여 학생3명의 국어점수를 입력하고 요청값을 처리하여 합산을 출력하세요
--%>
 
 <%-- 
[3단계:확인] 4.(선택) form요소객체를 이용하여 학생3명의 이름/국어/영어/수학 입력하고 요청값을 처리하세요.
               각, 학생의 평균 점수와 과목별 평균점수를 출력하세요.
 --%>
 
 <%--               
[1단계:확인] 5. form요소 객체를 활용하여 장바구니 담긴 물건 3개 중, check된 물건명 요청하여 구매갯수와 물건명 출력
--%>
 <h2>장바구니 (물건선택)</h2>
 <form>
 <input type="checkbox" name="product" value="키보드">키보드
 <input type="checkbox" name="price" value="85000">85000원<br>
 <input type="checkbox" name="product" value="마우스">마우스
 <input type="checkbox" name="price" value="65000">65000원<br>
 <input type="checkbox" name="product" value="이어폰">이어폰
 <input type="checkbox" name="price" value="20000">20000원<br>


 <input type="submit">
 </form>
 <%String []products = request.getParameterValues("product");
 	String []prices = request.getParameterValues("price");
 %>
 
 <table>
 	<tr><th>물건명</th><th>가격</th></tr>
 	<%
 	
	if(products!=null){
		for(String product:products){
			out.print("<tr><td>"+product+"</td>");
		}
	} 
	if(prices!=null){
		for(String price:prices){
			out.print("<td>"+price+"</td></tr>");
		}
	} 

 	%>
 <%-- 
[2단계:확인] 5. form요소 객체를 활용하여 장바구니 담긴 물건 3개 중, check된 물건명의 가격을 계산하여 총가격 출력하세요
--%>
 
 <%-- 
[3단계:확인] 5. form요소 객체를 활용하여 장바구니 담긴 물건 3개 중, check된 물건명과 가격 구매갯수 총계가 계산 되게 하세요.
--%>
 
 <%-- 
[1단계:개념] 6. 요청값을 encoding하는 이유를 기술하고, meothod의 get방식과 post방식의 차이점을 기술하세요.
파일의 인코딩 방식, 웹 브라우저의 인코딩 방식이 달라서 나타나는 문제로, 인코딩 방식을 통일 해 주어야 함
	1) get 방식 : url 주소창에 쿼리스트링으로 전송을 한다.
		-tomcat 서버에서 요청값 encoding을 처리
	2) post 방식 : 요청 몸체에서 쿼리스트링을 숨겨서 전송한다.
		-직접적으로 코드를 통해 encoding을 처리
			request.setCharacterEncoding("utf-8");
			
[1단계:확인] 7. post 방식으로 월드컵 A조의 팀명과 점수를 입력하고 현재 대전 결과를 출력하세요.
                     팀1    팀2 
                팀명[   ]  [    ]
                점수[   ]  [    ]
                      [결과] 
                    @@@ vs @@@
                      1 - 2
                      @@@ 승

--%>
  <%
      String T1point = request.getParameter("1team_point");
      int T1pointInt = 0;
      if(T1point!=null){ T1pointInt=Integer.parseInt(T1point);}
      String T2point = request.getParameter("2team_point");
      int T2pointInt = 0;
      if(T2point!=null){ T2pointInt=Integer.parseInt(T2point);}
      
      String div = "";
      if(T1pointInt>T2pointInt){
         div="1팀승";
      }else{
         div="2팀승";
      }
      
      
      
%>
   <form>
      팀1 팀명<input type="text" name="1team">
      팀1 점수 <input type="text" name="1team_point">
      팀2 팀명<input type="text" name="2team">
      팀2 점수 <input type="text" name="2team_point">
         <input type="submit" value="제출">
   </form>   
         <h3>1팀점수:<%=T1pointInt %></h3>
         <h3>2팀점수:<%=T2pointInt %></h3>
         <h3>최종결과:<%=div %></h3>
</body>
<script type="text/javascript">
/*

 */
</script>
</html>