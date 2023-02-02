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
<style>iframe{border:1px solid blue; width:30%;height:30%;}</style>
<script type="text/javascript">
function alloc(idx){
	var tname=document.querySelector("[name=tname]").value
	if(idx==0) group01.document.body.innerHTML+=tname+","
	if(idx==1) group02.document.body.innerHTML+=tname+","
	if(idx==2) group03.document.body.innerHTML+=tname+","
}

</script>
16강 확정팀<input type="text" name="tname">
<input type="button" value="16강 1번째 그룹 할당" onclick="alloc(0)">
<input type="button" value="16강 2번째 그룹 할당" onclick="alloc(1)"><br>
<input type="button" value="16강 3번째 그룹 할당" onclick="alloc(2)"><br>

<iframe name="group01" src="a13_sub.jsp" ></iframe>
<iframe name="group02" src="a14_sub.jsp" ></iframe>
<iframe name="group03" src="a15_sub.jsp" ></iframe>


</body>
<script type="text/javascript">

/*

 */

var div = document.querySelector("#container")

</script>
</html>