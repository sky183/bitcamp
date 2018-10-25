<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="../css/default.css">
</head>
<body>
<%@ include file="/WEB-INF/views/common/header.jsp" %>
	<h1>${id}</h1>
	<table border="1">
		<tr>
			<td>메시지 번호: ${message.id} <br /> 손님 이름: ${message.guestName} <br />
				메시지: ${message.message} <br /> <a
				href="<%=request.getContextPath()%>/deleteMessage?messageId=${message.id}"> [삭제하기]</a> <a
				href="<%=request.getContextPath()%>/list">돌아가기</a>
			</td>
		</tr>
	</table>
</body>
</html>