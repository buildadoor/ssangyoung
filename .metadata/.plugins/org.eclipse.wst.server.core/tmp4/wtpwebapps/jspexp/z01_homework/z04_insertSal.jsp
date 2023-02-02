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
<script>
/*
 grade lowsal hisal 
 */
</script>
</head>
<body>
<%

String gradeS = request.getParameter("grade");
String losalS = request.getParameter("losal");
String hisalS = request.getParameter("hisal");

int grade = 0;
if(gradeS!=null&&!gradeS.equals("")){
	grade = Integer.parseInt(gradeS);
}
int losal = 0;
if(losalS!=null&&!losalS.equals("")){
	losal = Integer.parseInt(losalS);
}
int hisal = 0;
if(hisalS!=null&&!hisalS.equals("")){
	hisal = Integer.parseInt(hisalS);
}
boolean isInsert = false;
if(grade!=0){
	SalGrade ins = new SalGrade(grade,losal,hisal);
	isInsert = true;
	A04_salgrade dao = new A04_salgrade();
	dao.insertSalgrade(ins);
}
	%>
	
	<h2>연봉입력</h2>
<script type="text/javascript">
var isInsert = <%=isInsert%>
	if (isInsert) {
		if(confirm("등록성공\n조회화면으로 이동하시겠습니까?")){
			location.href="a00_practice.jsp"
		}
		
	}
</script>
<form>
	
	등급:<input type="text" name="grade" value="0"/>
	최저연봉:<input type="text" name="losal" value="0"/>
	최고연봉:<input type="text" name="hisal" value="0"/>

		<input type="submit" value="등록"/>
</form>
	
	
	
</body>
<script>
/*

 */
</script>
</html>