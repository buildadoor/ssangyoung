<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="java.util.*"    
    import="jspexp.vo.*"
    import="javaexp.sql.*"
    import="jspexp.a13_database.*"    
    import="jspexp.a13_database.vo.*"     
    %>
<%
 	// post방식에서 한글요청값을 받을 때, 반드시 설정되어야한다.
 	request.setCharacterEncoding("utf-8");
 %>
<%@ taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix = "fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
 <fmt:requestEncoding value="UTF-8"/>
 
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>쌍용대학교</title>
		<link href="img/ss.png" rel="shortcut icon" type="image/x-icon">
		<link href="/a00_com/a01_common.css" rel="stylesheet">
		<script src="https://cdn.jsdelivr.net/npm/sweetalert2@9"></script>
		<script type="text/javascript">
		
		
		/*
		
		*/
		</script>
	</head>
	<body>
		<%
		String id =  request.getParameter("id");
				if(id == null) id = "";
				
		String lecNum = request.getParameter("lecNum");
		int lecNumInt = 0;
		if(lecNum!=null) lecNumInt = Integer.parseInt(lecNum);
		
				boolean isDel = false;
				if(id != null){
			A01_schStudent dao = new A01_schStudent();
			Student del = new Student(id, lecNumInt);
			// 성적 삭제 메서드
			dao.delGrade(del);
			isDel = true;
				}
		%>
	</body>
	<script type="text/javascript">
	
		var lecNum = '${lecNum}'
		var isDel = <%=isDel %>
		if(isDel){
			 Swal.fire({
				  title: '성적이 삭제되었습니다',
				  icon: 'success',
				  showCancelButton: false,
				  confirmButtonColor: '#3085d6',
				  confirmButtonText: '확인'
				}).then((result) => {
				  if (result.value) {
		              //"확인" 버튼을 눌렀을 때 작업할 내용 
					  location.href = "schStudent1.jsp?lecNum="+lecNum;
		              
				  }
				})
		}
	/*
		
	*/
	</script>
</html>