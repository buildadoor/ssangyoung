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
	부서번호 : <input type="text" name="deptno"/>
	부서명 : <input type="text" name="dname"/>
	<input type="submit" value="등록확인" />
</form>
<%
String deptnoS = request.getParameter("deptno");
int deptno = 0; if(deptnoS!=null) deptno = Integer.parseInt(deptnoS);
String dname =request.getParameter("dname");
boolean isInValid = false;
if(deptnoS!=null && dname!=null){
	
	A06_PreparedDao dao = new A06_PreparedDao();
	if(dao.chkDept(deptno, dname)){
		response.sendRedirect("z04_main.jsp");
	}else{
		isInValid = true;
	}
}

%>
<script type="text/javascript">
var isInValid = <%=isInValid%>
if(isInValid){
	alert("해당 부서정보가 없습니다");
}
</script>
<%-- 
#
3번
1) 화면 구현
	부서번호[] 
	부서명 []
	[등록확인]
2) 요청값 처리: null, 숫자형
	String deptnoS = request.getParameter("deptno");
	int deptno = 0; if(deptnoS!=null) deptno = Integer.parseInt(deptnoS);
	String dname =request.getParameter("dname");
	
3) 요청값에 따른 페이지 전환
	boolean isInValid = false;
	if(deptnoS!=null && dname!=null){
		if(deptno==10 && dname.equals("회계")){
			response.sendRedirect("z04_main.jsp");
		}else{
			isInValid = true;
		}
	}
	var isInValid = <%=isInValid%>
	if(isInValid){
		alert("해당 부서정보가 없습니다");
	}



3단계 확인
1. dao 기능 메서드 선언
	1) sql : select * from dept where deptno = ? and dname = ? 
	2) vo 
	3) 기능메서드 선언
		public boolean chkDept(int deptno, String dname){
		}
2. jsp
	if(deptnoS!=null && dname!=null){
		if(dao.ckDept(deptno, dname)){
			response.sendRedirect("@@@@.jsp");
		}else{
		
		}
	}
	
5번 
--%>
<%
String[][]teams = {{"카타르","에콰도르","세네갈","네덜란드"},
					{"잉글랜드","이란","미국","웨일스"},
					{"아르헨티나","사우디","멕시코","폴란드"},
					{"한국","한국","코리아","코리아"}};
out.print("<ol type='A'>");
for(String team[]:teams){//나라들 배열은 1차원 배열
	out.print("<li>조");
	out.print("		<ul>");
	for(String nation:team){//나라명은 문자열 하나씩 입력된다.
		out.print("<li>"+nation+"</li>");
	}
	out.print("		</ul>");
	out.print("</li>");
}
out.print("</ol>");
%>


<%--
6번
--%>
<h2>월드컵 대전팀과 일정 (해당 팀을 클릭시 시간 확인)</h2>
<select onchange="alert(this.value)"> 
<%
List<Code> sch = new ArrayList<Code>();
sch.add(new Code("오늘 오후7:00","웨일스:이란"));
sch.add(new Code("오늘 오후10:00","카타르:세네갈"));
sch.add(new Code("내일 오전1:00","네덜란드:에콰도르"));
sch.add(new Code("내일 오전4:00","잉글랜드:미국"));
for(Code c:sch){
	out.print("<option value='"+c.getKey()+"'>"+c.getVal()+"</option>");
}
%>
	<!-- <option value='튀니지:호주'>튀니지:호주</option> -->
	<option >튀니지:호주</option> 
	<!-- 레이블은 설정하면 value도 동일하게 적용되므로 value를 설정할 필요가 없다.  -->
</select>


<%--7번
<style> css 메뉴 리스트 
for문 배열 처리. 
<ul><li><a href="#">메뉴내용</a></li></ul>
--%>
<style>span{border-radius:5px;padding:5px;}
</style>
<%
String []menus={"로그인","메인화면","상품분류1","상품분류2","관리자"};
String []bks={"orange","pink","yellowgreen","aliceblue","silver"};
for(int idx=0;idx<menus.length;idx++){
%>
	<span style='background:<%=bks[idx]%>'><%=menus[idx] %></span>
	
<%} %>
<%--8번--%>
<td >

<h2>2x3</h2>
<table>
<%
for(int cnt=1;cnt<=6;cnt++){
	if(cnt%3==1)out.print("<tr>");
	out.print("<td style='background:"+(cnt%2==0?"aliceblue":"pink")+"'>"+cnt*2+"</td>");
	if(cnt%3==0)out.print("</tr>");
}
%>
</table>
<h2>3x4</h2>
<table>
<%
for(int cnt=1;cnt<=12;cnt++){
	if(cnt%4==1)out.print("<tr>");
	out.print("<td style='background:"+(cnt%2==0?"orange":"pink")+"'>"+cnt*4+"</td>");
	if(cnt%4==0)out.print("</tr>");
}
%>
</table>
<h2>5x2</h2>
<table>
<%
for(int cnt=1;cnt<=10;cnt++){
	if(cnt%2==1)out.print("<tr>");
	out.print("<td style='background:"+(cnt%2==0?"gold":"pink")+"'>"+cnt*5+"</td>");
	if(cnt%2==0)out.print("</tr>");
}
%>
</table>
</body>
<script type="text/javascript">
/*

 */
</script>
</html>