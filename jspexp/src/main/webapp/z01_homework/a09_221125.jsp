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
2022-11-25
[2단계:확인] 1. [jsp] 회원등록리스트(회원아이디,회원명,포인트,권한(select-관리자/일반사용자/방문객))로 출력 리스트를 처리하세요.
--%>
      <table>
       <col width="10%">
       <col width="20%">
       <col width="25%">
       <col width="20%">
       <col width="25%">
       <tr><th>선택</th><th>id</th><th>회원명</th><th>포인트</th><th>권한</th></tr>
       <%
       // public Emp(int empno, String ename, double sal, int deptno) 
       List<Member> mlist = new ArrayList<Member>();
       mlist.add(new Member("abc","홍길동","사용자",1000));
       mlist.add(new Member("ssangyong","송길동","관리자",99999));
       mlist.add(new Member("gildong","김길동","방문객",4000));
       mlist.add(new Member("ohoh","박길동","사용자",5000));
    
       %>
       
       <%for(int idx=0;idx<mlist.size();idx++){ 
          Member m = mlist.get(idx);
       %>
       <tr><td><input type="checkbox" name="ck" value="<%=idx%>"/></td>
          <td><input type="text" name="id" value="<%=m.getId()%>"/></td>
          <td><input type="text" name="name" value="<%=m.getName()%>"/></td>
          <td><input type="text" name="point" value="<%=m.getPoint()%>"/></td>
          <td><select name="auth">
                <option value="관리자" <%=m.getAuth()=="관리자"?"selected":"" %>>관리자</option>
                <option value="일반사용자" <%=m.getAuth()=="일반사용자"?"selected":"" %>>일반사용자</option>
                <option value="방문객" <%=m.getAuth()=="방문객"?"selected":"" %>>방문객</option>
             </select>
          </td></tr>
          <%} %>
       </table>
</body>

</body>
<script type="text/javascript">
/*

 */
</script>
</html>