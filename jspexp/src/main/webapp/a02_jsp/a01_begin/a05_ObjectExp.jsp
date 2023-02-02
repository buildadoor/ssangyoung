<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
     import="jspexp.vo.Player"
    import="java.util.*"
    import="java.vo.*"
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<link href="/a00_com/a01_common.css" rel="stylesheet">
<script type="text/javascript">
/*
 
 
*/
</script>

</head>
<body>

<%--팀명 선수명 성적을 Player라는 vo 클래스를 만들고 출력처리해보세요 --%>


    <%
    List<Player> plist = new ArrayList<Player>();
    plist.add(new Player("SSG","최정",0.476));
    plist.add(new Player("키움","송성문",0.381));
    plist.add(new Player("SSG","김성현",0.348));
 
  	for(int idx=0;idx<plist.size();idx++){
  		Player p = plist.get(idx);
  		log(p.getTeam()+":"+p.getPname()+":"+p.getScore());
  	}
    %>
   <table width=300px border>
	<tr><th>소속팀</th><th>선수명</th><th>성적</th></tr>
	<%for(Player p:plist){%>
	<tr><td><%=p.getTeam()%></td><td><%=p.getPname()%></td><td><%=p.getScore()%></td></tr>
	<%}%>
</table> 
    
</body>
</html>