<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="jspexp.vo.DeptClass"
    import="jspexp.vo.Player"
    import="java.util.*"
    %>
    <%
    List<DeptClass> dlist = new ArrayList<DeptClass>();
    dlist.add(new DeptClass(10,"인사","서울"));
    dlist.add(new DeptClass(20,"회계","부산"));
    dlist.add(new DeptClass(30,"총무","제주도"));
  	for(int idx=0;idx<dlist.size();idx++){
  		DeptClass d = dlist.get(idx);
  		log(d.getDeptno()+":"+d.getDname()+":"+d.getLoc());
  	}
    %>
  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
//객체형 List 처리 
//1. 구조만들기/import 처리
//2. 리스트로 데이터 넣기
//3. 반복문 처리하기

%>
<table width=300px border>
	<tr><th>부서번호</th><th>부서명</th><th>부서위치</th></tr>
	<%for(DeptClass d:dlist){%>
	<tr><td><%=d.getDeptno()%></td><td><%=d.getDname()%></td><td><%=d.getLoc()%></td></tr>
	<%}%>
</table>
<%--팀명 선수명 성적을 Player라는 vo 클래스를 만들고 출력처리해보세요 --%>

</body>
</html>