<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	#save{
		width: 90px;
		height: 100px;
	}
	
	td, tr, table{
 	border-collapse:collapse;  
	border: 1px solid black;
	text-align: center;
	}
</style>
</head>
<body>
			<table>
				<tr>
					<td>비밀번호</td>
					<td>
						<input type="password" id="password1">
					</td>
					<td rowspan="2">
						<button type="button" id="save">저장</button>
					</td>
				</tr>
				<tr>
					<td>비밀번호재입력</td>
					<td>
						<input type="password" id="password2">
					</td>

				</tr>
			</table>
</body>
<script type="text/javascript">
	
	$('#save').click(function(){
		var pw1 = $('#password1').val();
		var pw2 = $('#password2').val();
		
		if (pw1 == pw2) {
			opener.document.getElementById("password").value = pw1;
			window.close();
		} else {
			opener.error();
		}
	});
	
</script>
</html>