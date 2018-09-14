<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	int Dice1 = (int)(Math.random()*6+1);
	int Dice2 = (int)(Math.random()*6+1);
	%>
	<h1>
	<img alt="" src="/dice/dice<%=Dice1%>.jpg">
	<img alt="" src="/dice/dice<%=Dice2%>.jpg">
	</h1>
</body>
</html>