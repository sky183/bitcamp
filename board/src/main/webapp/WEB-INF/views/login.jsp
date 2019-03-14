<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	.login{
		width: 90px;
		height: 100px;
	}
	
	td, tr, table{
 	border-collapse:collapse;  
	border: 1px solid black;
	text-align: center;
	}
	
	#wrapper{
	width: 380px;
	margin: 100px auto;
	}
</style>
</head>
<body>
	<div id="wrapper">
		<form method="post">
			<table>
				<tr>
					<td>ID</td>
					<td>
						<input type="text" name="id">
					</td>
					<td rowspan="3">
						<button type="submit" class="login">로그인</button>
					</td>
				</tr>
				<tr>
					<td>PASSWORD</td>
					<td>
						<input type="password" name="pw">
					</td>
				</tr>
				<tr>
					<td colspan="2">
						<label for="remem">로그인 유지 </label> 
						<input type="checkbox" name="rememberSession" id="remem">
					</td>
				</tr>
			</table>
		</form>
		
		<div style="color: red;">${error}</div>
	</div>
</body>
</html>