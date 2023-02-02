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
	<form>
		이동할 페이지

		<select name="page01">
			<option value="a07_admin.jsp">부서페이지</option>
		</select>
	
		<input type = "button" value="이동(클라이언트단)" onclick="goPage()"/>
	</form>
<%--
2022-11-24
[1단계:개념] 1. response는 request와 대비해서 어떤 역할을 하는 객체인가?
		# response 기본 객체
		1. 웹 브라우저에 전송하는 응답 정보 설정
		2. 주요 기능
			1) 헤더 정보 입력
			2) 리다이렉트 처리
		3. 기능 메서드
			1) addDateHeather(String name, long date)
				name 헤더에 date를 추가처리 1971/1/1 기준으로 1/1000초 단위 설정
			2) addHeader(String name, String value)
			3) addIntHeader(String name, in value)
				name 헤더에 정수값 value를 추가한다.
			4) setDateHeader(String name, long date)
				name 헤더의 값을 date로 지정한다. date는 1970년 1월1일 이후
				흘러간 시간을 1/1000초 단위로 나타낸다.
			5) setHeader(String name, String value)
				name 헤더의 값을 value로 지정한다.
			6) setIntHeader(String name, int value)
				name 헤더의 값을 정수값 value로 지정한다.
	
			
[1단계:개념] 2. response.sendRedirect와 location.href의 차이점을 기술하세요.
response.sendRedirect
1) 특정 페이지로 이동하라고 웹 브라우저에 응답
2) 서버 안에서 명령문으로 특정 페이지로 이동 처리
	response.sendRedirect(String location)
cf) location.href="이동페이지" 브라우저에 특정한 페이지로 이동 처리
[1단계:확인] 3. 조건(부서번호 부서명이 있을 때, 해당 부서페이지로 이동하고, 그렇지 않을 때, 해당 부서가 없습니다. 경고창 처리하세요.
--%>

<%--
	
[2단계:확인] 3. (DB처리)부서번호와 부서명이 있을 때, 해당 부서페이지로 이동하고, 그렇지 않을 때, 해당 부서가 없습니다. 경고창 처리하세요.
--%>

<%--
[1단계:확인] 4. [화면구현] 배열로 월드컵 D조팀  ul로 리스트 출력하세요.
--%>

<%
String[]TeamA = {"네덜란드","에콰도르","세네갈","카타르"};	
String[]TeamB = {"잉글랜드","웨일스","미국","이란"};	
String[]TeamD = {"프랑스","튀니지","덴마크","호주"};	
%>
<br><br><br>
<h3>월드컵 D조</h3>
<ul> 
	<%
	for(String team:TeamD){
		out.print("<li>"+team+"</li>");
	}
	%>
</ul>
<%--

[2단계:확인] 5. [화면구현] 2차원 배열로 월드컵 A,B조 및 그 팀들을 선언하고 ol/ul을 계층적으로 출력하세요.
--%>
<h3> 월드컵 A,B조</h3>
<ol>
<%
	String[]Team={"A조"};
	for(String team:Team){
	out.print("<li>"+team+"</li>");
}
%>

	<%
	for(String team:TeamA){
		out.print("<ui>"+team+"</ui>");
	}
%>
<%
	String[]Team2={"B조"};
	for(String team2:Team2){
	out.print("<li>"+team2+"</li>");
}
%>
<%
	for(String team:TeamB){
		out.print("<ui>"+team+"</ui>");
	}
	%>

</ol>

<%--
[1단계:확인] 6. [화면구현] 오늘 월드컵 출전 팀과 경기 시간을 배열로 선언하고 select의 value는 시간, 레이블은 팀명을 출력하되, 선택했을 시간을 경고창으로 출력되게 하세요.(배열, Code객체)
--%>
<%
	String[]today = {"E조","F조","G조","H조"};	
	String[]time = {"01:00","04:00","19:00","22:00"};	

%>
<h3>11월24일 월드컵 경기</h3>
<select name="today" onchange="alert(this.value)">
	<%for(int idx=0;idx<today.length;idx++){ %>
	<option value="<%=time[idx]%>"><%=today[idx] %></option>
<%} %>
</select>
<%--
		
[1단계:확인] 7. [화면구현] 사이트 상단 메뉴항목을 배열로 5개 선언하고, 각 메뉴별로 배경색상을 지정한후, 수평으로 리스트 출력되게 하세요.
--%>

<%--

[1단계:확인] 8. [화면구현] jsp에서 테이블로 2X3, 3X4, 5X2를 만들고, 2의 배수, 4의 배수, 5의 배수로 출력하세요.(배경색상은 홀짝 다르게 출력)
 --%>
 <table>
  <%
  int number=0;
  int tot = 3;
  for(int cel=1;cel<=6;cel++){
     out.print("<tr>");
  
        tot += number+3;
        if(tot%2==0){
           out.print("<td style='background-color:pink'>"+tot+"</td>");
        }else {
           out.print("<td>"+tot+"</td>");
        }
     }
     out.print("</tr>");
 	
  %>
   
</table>
</body>
<script type="text/javascript">

</script>

</html>