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
2번 
--%>
<h2>회원 아이디 유효성 check</h2>
회원아이디 : <input type="text" name="id"/>
<input type="button" value="유효check" onclick="ckValid(this)"/>
<input type="checkbox" id="isValid"/> 유효여부 
<script type="text/javascript">
	var idOb = document.querySelector("[name=id]")
	var ckValOb = document.querySelector("#isValid")
	function ckValid(obj){
		if(obj.value=="유효check"){
			var len = idOb.value.length
			if(len>=8 && len<=16 && idOb.value!='himan'){
				ckValOb.checked = true
				idOb.readOnly = true
				obj.value="아이디재입력"
				//실무적으로는 입력내용과 패턴만 유효성 check하고 
				//데이터에 대한 확인은 ajax(비동기적으로 서버 접근) 처리하여 
				//유효 여부를 확인한다.
			}
		}else{
			ckValOb.checked = false
			idOb.readOnly = false
			idOb.value="";idOb.focus()
			obj.value="유효check"
		}
	}
</script>

	<%-- 
	6번
	--%>
<h2>구매</h2>
물건명:<input type="text" name="pname"/>
가격:<select name="price" onchange="cal()"></select>
갯수:<select name="cnt" onchange="cal()"></select>
<h3 id="shwBuy"></h3>
<script type="text/javascript">
var pnameOb = document.querySelector("[name=pname]")
var priceOb = document.querySelector("[name=price]")
var cntOb = document.querySelector("[name=cnt]")
var shwBuyOb = document.querySelector("#shwBuy")
var add1 = ""
var add2= ""
for (var cnt=1;cnt<=9;cnt++){
	add1+="<option>"+cnt*1000+"</option>"
	add2+="<option>"+cnt+"</option>"
} 
priceOb.innerHTML =add1;
cntOb.innerHTML =add2;
function cal(){ //주의 : 반드시 선택할 당시 value를 가져오게 처리
	var tot = priceOb.value*cntOb.value
	shwBuyOb.innerText="구매물건:"+pnameOb.value+", 총 비용:"+tot
}

</script>
<%-- 
8번
1) 세션 처리 페이지 및 리스트 페이지 이동(ex)로그인 후 세션설정 후 리스트 페이지)
	z43_makesession.jsp
2)a18_answer.jsp 
	-세션가져오기(만약에 session이 없으면 세션페이지에서 세션처리하기)
	-현재 페이지에서 테이블 리스트 출력
		메뉴 리스트를 클릭시, 지정된 메뉴의 권한 내용과 세션에
		있는 권한과 비교하여 같으면 접근, 다르면 접근 불가능 경고창 처리
	--%>
   
   <%
   Emp emp = (Emp)session.getAttribute("emp");
   boolean hasSess = emp!=null; // null이 아니면 true
   // 세션이 있을 때만 메서드 호출, 없을 때는 0으로 할당.
   // js 코드로 넘겨서 메뉴 check시 활용..
   int deptno = hasSess?emp.getDeptno():0;
   
   List<Dept> dlist = new ArrayList<Dept>();
   dlist.add(new Dept(10,"인사",""));
   dlist.add(new Dept(20,"회계",""));
   dlist.add(new Dept(30,"네트웤",""));
   dlist.add(new Dept(40,"총무",""));
   %>
   <table>
      <tr><th>부서리스트</th></tr>
      <%for(Dept d:dlist){ %>
      <tr><td onclick="ckAuth('<%=d.getDeptno()%>')"><%=d.getDname() %></td></tr>
      <%} %>
   </table>
   
</body>
<script type="text/javascript">
var hasSess = <%=hasSess%>
if(!hasSess){
   alert("세션이 없습니다. \n세션 설정 페이지로 이동하겠습니다.")
   location.href="z43_makeSession.jsp"
}

var sesNo = <%=deptno%> //주의 세션이 없으면 sesNo=
function ckAuth(deptno){
   // 세션에 있는 deptno와 부서리스트에서 전달하는 deptno가 같을 때는 
   // 권한이 있기 때문에 이동 가능
   if(sesNo==deptno){ //< %=emp.getEmpno %>100퍼에러
      alert("권한이 있습니다. 이동 성공")
   }else{
      alert("메뉴사용권한이 없습니다.")
   }
   
}
/*
z43_makeSession.jsp
<h2>세션설정</h2>
 */
var div = document.querySelector("#container")
div.innerHTML+="<br>"
</script>
</html>