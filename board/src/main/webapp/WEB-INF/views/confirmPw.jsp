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
		opener.document.getElementById("pInput").value = opener.num;
		opener.al();
		window.close();
	}
</script>
</head>
<body>
	<table>
		<tr>
			<td>비밀번호</td>
			<td><input type="password"></td>
			<td><button type="button" id="confirm" onclick="setParentText()">확인</button></td>
		</tr>
	</table>
</body>
</html>