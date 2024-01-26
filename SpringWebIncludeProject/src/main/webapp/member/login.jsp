<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
.container{
margin-top: 50px;
}
.row {
  margin: 0px auto;
  width: 350px;
}
</style>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
</head>
<body>
  <div class="container">
   <div class="row">
   	<h3 class="text-center">Login</h3>
   	<form method="post" action="../member/login_ok.do">
   	<table class="table">
   		<tr>
   			<th width="20%" class="text-right">ID</th>
   			<td width="80">
   				<input type="text" name=id class=input-sm size=15 required="required">
   			</td>
   		</tr>
   		<tr>
   			<th width="20%" class="text-right">Password</th>
   			<td width="80">
   				<input type="password" name=pwd class=input-sm size=15 required="required">
   			</td>
   		</tr>
   	</table>
   	<input type="submit" value="로그인" class="btn-sm btn-info">
   	</form>
   	</div>
   	</div>
</body>
</html>