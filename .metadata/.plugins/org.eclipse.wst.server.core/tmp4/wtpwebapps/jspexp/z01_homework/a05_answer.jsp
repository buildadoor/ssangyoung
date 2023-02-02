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
 
 */
</script>
</head>
<body>
<%-- 
#5번 
1) 화면구성
	2) +/-에 대한 이벤트 핸들러 함수 선언과 이벤트 처리 
	3) 메뉴내용과 총금액 처리


#6번 
--%>
<script type="text/javascript">
	
	var orcnts = [0,0,0] //클릭시마다, 함수 전역적으로 주문갯수를 증가 
	function cal( cIdx, ch ){
		
		var menus = ["짜장면","짬뽕","탕수육"]
		var prices = [6000,7000,12000]
		
		if(ch=="+"){
			orcnts[cIdx]++;
		}else{
			if(orcnts[cIdx]<=0){
				alert("0이하는 감소되지 않습니다.")
			}else{
				orcnts[cIdx]--;	
			}
		}
		//하단에 메뉴를 통해 출력 
		var showList = ""
		//총비용출력
		var tot = 0;
		// orcnts = [0,0,0] 주문량이 있을 때만 반복해서 출력
		for(var idx=0; idx< orcnts.length;idx++){
			if(orcnts[idx]>0){
				showList+=menus[cIdx]+"("+prices[idx]+"원) "+orcnts[idx]+"<br>"
				tot += prices[idx]*orcnts[idx] 
			}
		}
		
		showList+="총비용:"+tot+"원"
		document.querySelector("#show").innerHTML = showList
	}
	function calPlus(){
		var num01Ob = document.querySelector("[name=num01]")
		var num01 = num01Ob.value
		var num02Ob = document.querySelector("[name=num02]")
		var num02 = num02Ob.value
		if(num01=="" || isNaN(num01)){
			alert("공백이거나 숫자가 아닙니다.")
			num01Ob.value="";num01Ob.focus()
			return;
		}
		if(num02=="" || isNaN(num02)){
			alert("공백이거나 숫자가 아닙니다.")
			num02Ob.value="";num02Ob.focus()
			return;
		}
		document.querySelector("form").submit();
	}
</script>
<h2>주문하세요</h2>
<style>
	span{border: 1px solid blue; border-radius: 5px; display:inline-block;width:20px;}
</style>

<table>
		<tr><td>짜장면(6000원)<span onclick="cal(0,'+')"> + </span> 
				<span onclick="cal(0,'-')"> - </span></td></tr>
		<tr><td>짬뽕(7000원)<span onclick="cal(1,'+')"> + </span> 
				<span onclick="cal(1,'-')"> - </span></td></tr>
		<tr><td>탕수육(12000원)<span onclick="cal(2,'+')"> + </span> 
				<span onclick="cal(2,'-')"> - </span></td></tr>
</table>
<p id="show" align="center"></p>
<h3>6번</h3>
<script type="text/javascript">
	//js 유효성 check
	function calPlus(){
		var num01Ob = document.querySelector("[name=num01]")
		var num01 = num01Ob.value
		var num02Ob = document.querySelector("[name=num02]")
		var num02 = num02Ob.value
		if(num01=="" || isNaN(num01)){
			alert("공백이거나 숫자가 아닙니다.")
			num01Ob.value="";num01Ob.focus()
			return; //특정 조건에 따라 프로세스를 중단 처리 ..
		}
		if(num02=="" || isNaN(num02)){
			alert("공백이거나 숫자가 아닙니다.")
			num02Ob.value="";num02Ob.focus()
			return;
		}
		document.querySelector("form").submit();//submit 버튼을 클릭한 것과 동일한 효과
	}
</script>
<%
	String num01S = request.getParameter("num01");
	String num02S = request.getParameter("num02");
	int num01 = 0; int num02 = 0; int sum = 0; 
	boolean isValid1 = false;
	boolean isValid2 = false;
	if(num01S!=null&&!num01S.equals("")){ //초기화면이 아니고 요청값을 입력했을 때,
		try{
			num01 = Integer.parseInt(num01S);//형변환 처리
		}catch(Exception e){} //숫자형태 데이터가 아닐 떄, 0으로 처리
		isValid1=true;
	}
	if(num02S!=null&&!num02S.equals("")){ //초기화면이 아니고 요청값을 입력했을 때,
		try{
			num02 = Integer.parseInt(num02S);//형변환 처리
		}catch(Exception e){} //숫자형태 데이터가 아닐 떄, 0으로 처리
		isValid2=true;
	}
%>
	<form>
		첫번째 숫자:<input type="text" name="num01"/><br>
		두번째 숫자:<input type="text" name="num02"/><br>
		<input type=button" onclick="calPlus()" value="합산"/><br>
		<%=isValid1&&isValid2? num01+"+"+num02+"="+(num01+num02):"" %>
	</form>
	
	
<h3>7번</h3>
<%!
	String chPass(String pt){
		String re = "";
		if(pt!=null){
			try{
				int point = Integer.parseInt(pt);
				if(point>=70){
					re="결과: 합격";
				}else{
					re="결과: 불합격";
				}
			}catch(Exception e){
				re = "입력데이터이상(입력, 숫자형)";
				
			}
		}
		return re;
}
%>
<%
	String pt = request.getParameter("pt");
%>
<form>
	점수:<input type="text" name="pt"/>
	<input type="submit"/>
</form>
	<%=chPass(pt) %>

</body>
<script>
/*

 */
</script>
</html>