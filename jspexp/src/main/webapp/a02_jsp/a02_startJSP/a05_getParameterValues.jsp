<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="java.util.*"    
    import="jspexp.a13_database.*"    
    import="jspexp.vo.*"     
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
# request.getParameterValues("다중의 키")
1. 동일한 이름으로 여러개의 요청값을 받을 때 사용한다.
2. 기본 리턴 데이터 유형은 문자열 배열이다.
	
--%>

<form>
	과일1 : <input type="text" name="fruit" value="사과"/>
	과일2 : <input type="text" name="fruit" value="바나나"/>
	과일3 : <input type="text" name="fruit" value="딸기"/>
	<input type="checkbox" name="food" value="소고기"/>소고기,
	<input type="checkbox" name="food" value="돼지고기"/>돼지고기,
	<input type="checkbox" name="food" value="닭고기"/>닭고기,
	<input type="checkbox" name="food" value="오리고기"/>오리고기<br>
	<input type="submit"> 
</form>
<%
	//?fruit=사과&fruit=바나나&fruit=딸기&food=소고기&food=닭고기
	// 같은 이름으로 여러 개의 요청값을 받을 수 있다
	// type="text"는 모두 요청값으로 배열로 전달 
	String fruits[] = request.getParameterValues("fruit");
	// type="checkbox" 체크가 된 것만 배열로 전달
String foods[] = request.getParameterValues("food");
%>
	<h2>과일 종류:
		<%
		  if(fruits!=null){
		  for(String fruit:fruits){ %>
			<%=fruit%>,
		<%} 
		}
	%>
		<%--
		
		PrintWriter out = response.getWriter(); 
		jsp ==> servlet으로 처리될 때,  선언된 내장 객체 out 사용
		out.print("<h2>servlet은 jsp가 만드는 것 </h2>");
		 --%>
	</h2>
	<h2>선택한 육류:
	<%
		  if(foods!=null){
		  for(String food:foods){
				out.print(food+","); // out : 내장된 출력을 처리해주는 객체
			} 
		}
	 %>
	</h2>
<%--
ex) form으로 가고싶은 여행지 
	[]인도 []남태평양 []제주도 []유럽		
	[확인]
 	==> 테이블 형식으로 선택된 여행지 출력
 --%>
 <h2>가고 싶은 여행지를 선택하세요! (다중선택)</h2>
 <form>
 <input type="checkbox" name="trip" value="인도"/>인도<br>
 <input type="checkbox" name="trip" value="남태평양"/>남태평양<br>
 <input type="checkbox" name="trip" value="제주도"/>제주도<br>
 <input type="checkbox" name="trip" value="유럽"/>유럽<br>
 <input type="submit">
 </form>
 <%String []trips = request.getParameterValues("trip"); %>
 
 <table>
 	<tr><th>여행지</th></tr>
 	<%
	if(trips!=null){
		for(String trip:trips){
			out.print("<tr><td>"+trip+"</td></tr>");
		}
	} 
 
 	%>
 </table>
  <h2>가고 싶은 여행지를 선택하세요! (단일선택)</h2>
 <form>
 <input type="radio" name="trip" value="인도"/>인도<br>
 <input type="radio" name="trip" value="남태평양"/>남태평양<br>
 <input type="radio" name="trip" value="제주도"/>제주도<br>
 <input type="radio" name="trip" value="유럽"/>유럽<br>
 <input type="submit"/>
 </form>
<%	//radio는 name이 동일한 내용에서 단일 선택만 가능하다.
	String trip = request.getParameter("trip");
%>
<h3>선택한 여행지: <%=trip!=null?trip:""%></h3>

<%
	List<Product> plist = new ArrayList<Product>();
	plist.add(new Product("사과",3000,2));
	plist.add(new Product("바나나",4000,3));
	plist.add(new Product("딸기",12000,5));
	plist.add(new Product("오렌지",12000,4));
%>
<form>
<h3>장바구니 담기</h3>
<table>
	<tr><th>선택</th><th>물건명</th><th>가격</th><th>갯수</th></tr>
	<%for (int idx=0;idx<plist.size();idx++){
		Product pro = plist.get(idx);
		%>
	
	<tr><td><input type="checkbox" name="ch" value="<%=idx%>"/></td>
		<td><input type="text" name="product" value="<%=pro.getProduct()%>"/></td>
		<td><input type="text" name="price" value="<%=pro.getPrice()%>"/></td>
		<td><input type="text" name="cnt" value="<%=pro.getCnt()%>"/></td>
		</tr>
	<%}%>	
	<tr><td colspan="4"><input type="submit" value="결제하기"/></td></tr>
</table>

</form>
<%--
ch : 요청값은 checkbox이게기에 체크한 index만 전송
{0,3}
names : [사과,바나나,딸기,오렌지] 		product[0] products[3]
prices : [3000,4000,12000,1200] 	prices[0] prices[3]
cnts : [2,5,3,1] 					cnts[0] cnts[3]
 --%>
<p align="center">
<%
String ch[] = request.getParameterValues("ch");
String products[] = request.getParameterValues("product");
String prices[] = request.getParameterValues("price");
String cnts[] = request.getParameterValues("cnt");
if(ch!=null){
	//type=checkbox인 ch는 check가 된 index를 넘기지만,
	//type이 text은 경우는 모두 전송이 된다.
	for(String cidx:ch){
		int idx = Integer.parseInt(cidx);
		out.print(cidx+":"+products[idx]+":"+prices[idx]+":"+cnts[idx]+"<br>");
	}
}
%>
</body>
<script type="text/javascript">
/*

 */
</script>
</html>