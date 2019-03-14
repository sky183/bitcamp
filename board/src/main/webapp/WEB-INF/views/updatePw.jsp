<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">

	function setParentText(){
		
		var pw1 = $('#password1').val();
		var pw2 = $('#password2').val();
		
		if (pw1 != pw2) {
			window.close();
			opener.error();
		} else {
			$.ajax({
				url : '<%=request.getContextPath()%>/upPw?num=' + opener.num + '&password=' + pw1,
				method : 'GET',
				error : function(error) {
			        alert("Error!");
			    },
				success : function(data) {
					window.close();
				}
			});
		}
		
	}
</script>
</head>
<body>
			<table>
				<tr>
					<td>비밀번호</td>
					<td>
						<input type="password" id="password1">
					</td>
					<td rowspan="2">
						<button type="button" id="save" onclick="setParentText()">저장</button>
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
</html>