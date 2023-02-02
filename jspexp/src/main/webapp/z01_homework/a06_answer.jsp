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
#4번
--%>
</body>
<h2>학생</h2>
<%
//	String [] names = {"홍길동","이또치","마이콜"};
%>
<form>
<table>
	<tr><td>이름</td><td>국어</td><td>영어</td><td>수학</td></tr>
	<%
	for(int cnt=1;cnt<=3;cnt++){
	%>
		<tr>
		<td><input type='text' name='name' value=""/></td>
		<td><input type='text' name='kor' value="0"/></td>
		<td><input type='text' name='eng' value="0"/></td>
		<td><input type='text' name='matd' value="0"/></td>
		</tr>
	<% 
	}
	%>
	   <tr><td colspan="4"><input type="submit"></td></tr>
	</table>
</form>
	<p align="center">
		<h3>
		<%
			String []names = request.getParameterValues("name");
			String []kors = request.getParameterValues("kor");
			String []engs = request.getParameterValues("eng");
			String []matds = request.getParameterValues("matd");
			int totAll=0;
			if(names!=null){ //초기 로딩 화면과 구분
				
			       for(int idx=0;idx<names.length;idx++){
                       int tot = Integer.parseInt(kors[idx])+
                               Integer.parseInt(engs[idx])+
                                Integer.parseInt(matds[idx]);
                       out.print(names[idx]+", 평균"+(tot/3)+"<br>");
                    }
                 }
			
			
			
			out.print("<br>국어점수:");
			if(kors!=null){
				int tot=0;
				for(String kor:kors){
					//공백, null 숫자형에 대해 처리 ==> 0
					int pt = 0;
					try{
						pt = Integer.parseInt(kor);
						out.print(pt+" ");	
					}catch(Exception e){}
					tot+=pt;	
				}
				out.print("<br>국어합산:"+tot+", 국어평균:"+(tot/3));
				totAll+=tot/3;
			}
			out.print("<br>영어점수:");
			if(engs!=null){
				int tot=0;
				for(String eng:engs){
					//공백, null 숫자형에 대해 처리 ==> 0
					int pt = 0;
					try{
						pt = Integer.parseInt(eng);
						out.print(pt+" ");	
					}catch(Exception e){}
					tot+=pt;	
				}
				out.print("<br>영어합산:"+tot+", 영어평균:"+(tot/3));
				totAll+=tot/3;
			}
			out.print("<br>수학점수:");
			if(matds!=null){
				int tot=0;
				for(String matd:matds){
					//공백, null 숫자형에 대해 처리 ==> 0
					int pt = 0;
					try{
						pt = Integer.parseInt(matd);
						out.print(pt+" ");	
					}catch(Exception e){}
					tot+=pt;	
				}
				out.print("<br>수학합산:"+tot+", 수학평균:"+(tot/3));
				totAll+=tot/3;
			}
			
			out.print("<br>전체과목학생 평균:"+(totAll/3));
		%>
		
		</h3>
<h2>7번</h2>
<form>
	<table>
		<tr><th></th><th>팀1</th><th>팀2</th></tr>
		<tr><th>팀명</th><td><input type="text" name="tname"/></td>
						<td><input type="text" name="tname"/></td></tr>
		<tr><th>점수</th>	<td><input type="text" name="point" value="0"/></td>
						<td><input type="text" name="point" value="0"/></td></tr>
		<tr><td colspan="3"><input type="submit" value="결과"></td></tr>

	</table>
</form>
<%
	String tnames[] = request.getParameterValues("tname");
	String points[] = request.getParameterValues("point");
	if(tnames!=null){
		out.print(tnames[0]+" vs" +tnames[1]+"<br>");
		out.print(points[0]+" :" +points[1]+"<br>");
		int pt1 = Integer.parseInt(points[0]);
		int pt2 = Integer.parseInt(points[1]);
		String result = "무승부";
		if(pt1>pt2) result = tnames[0]+"승";
		if(pt1<pt2) result = tnames[1]+"승";
		out.print(result);
	}
%>
<script type="text/javascript">
/*

 */
</script>
</html>