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
#
--%>
<h2>계산기</h2>
<table>
	<tr>
		<td><input type="text" name="num01" value="0" size="2"/></td>
		<td><select name="cal">
				<option value="0">+</option>
				<option value="1">-</option>
				<option value="2">*</option>
				<option value="3">/</option>
		</select></td>
		<td><input type="text" name="num02" value="0" size="2"/></td>
		<td><input type="button"  value="결과 확인" onclick="result()"/></td>
	</tr>
	
</table>
<script type="text/javascript">

	var num01Ob = document.querySelector("[name=num01]")
	var num02Ob = document.querySelector("[name=num02]")
	var calOb = document.querySelector("[name=cal]")
	var options = document.querySelectorAll("[name=cal]>option")
	//임의의 값 할당 
	num01Ob.value = Math.floor(Math.random()*10+1);
	num02Ob.value = Math.floor(Math.random()*10+1);
	for(var idx=0;idx<options.length;idx++){
		if(rIdx==idx){
			//selected선택되어진 것에 대한 속성
			option[idx].checked=true;
		}
	}
	var rIdx = Math.floor(Math.random()*4);
	
	function result(){
		 
		var num01 = num01Ob.value
		var num02 = num02Ob.value
		var cIx = calOb.value
		var calR = [num01+num02,num01-num02,num01*num02,num01/num02]
		var cal = [" + ", "- "," X","/"]
		alert (num01+cal[cIx]+num02+" = "+calR[cIx])
	}
</script>
</body>
<script type="text/javascript">
/*

 */

var div = document.querySelector("#container")
div.innerHTML+="<br>"
</script>
</html>