<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/springweb/a00_com/bootstrap.min.css" >
<style>
   td{text-align:center;}
</style>
<script src="/springweb/a00_com/bootstrap.min.js"></script>
<script src="/springweb/a00_com/jquery.min.js"></script>
<script type="text/javascript">
   $(document).ready(function(){
   $("h2").text("회원정보 ajax조회")
   $(".sch").keyup(function(){
		if(event.keyCode==13){
			$.ajax({
				url:"${path}/memListAjax.do",
				type:"post",
				data:$("#frm01").serialize(),
				dataType:"json",
				success:function(mlist){
					var addHTML=""
					$(mlist).each(function(idx,mem){
						addHTML+="<tr>"
						addHTML+="<td>"+mem.getId()+"</td>"
						addHTML+="<td>"+mem.getName()+"</td>"
						addHTML+="<td>"+mem.getPoint()+"</td>"
						addHTML+="<td>"+mem.getAuth()+"</td>"
						addHTML+="</tr>"
					})
				},
			})
		}
	});

</script>
</head>
<body>

<div class="container">
   <div class="jumbotron text-center">
     <h2 ></h2>
   </div>
   <form id="frm01" class="form-inline"  method="post">
     <nav class="navbar navbar-expand-sm bg-dark navbar-dark">
       <input class="sch" name="name" class="form-control mr-sm-2" placeholder="회원명" />
       <input class="sch" name="auth"  class="form-control mr-sm-2" placeholder="권한" />
       <button class="btn btn-info" type="button">Search</button>
    </nav>
   </form>
   <table class="table table-hover table-striped">
      <col width="25%">
      <col width="25%">
      <col width="25%">
      <col width="25%">
    <thead>
    
      <tr class="table-success text-center">
        <th>아이디</th>
        <th>회원명</th>
        <th>포인트</th>
        <th>권한</th>
      </tr>
    </thead>   
    <tbody>
    </tbody>
   </table>       
</div>
</body>
</html>