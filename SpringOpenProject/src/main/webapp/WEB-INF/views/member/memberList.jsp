<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="/WEB-INF/views/common/headercheck.jsp"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/default.css">
<style>
h2 {
	padding: 10px;
}

table {
	margin-top: 10px;
}

td {
	padding: 10px 20px;
}

#memberPhoto {
	background-size: 100%;
	width: 150px;
	height: 150px;
	border: 1px solid #333333;
	margin: 20px 0;
}
</style>
</head>
<body>

	<%@ include file="/WEB-INF/views/common/header.jsp"%>

	<div id="contents">
		<h2>회원리스트</h2>

		<hr>

		<table border="1">
			<tr>
				<td>아이디</td>
				<td>비밀번호</td>
				<td>이름</td>
				<td colspan="2">사진</td>
				<td>관리</td>
			</tr>
			<c:forEach var="member" items="${members}">
				<tr>
					<td>${member.userId}</td>
					<td>${member.password}</td>
					<td>${member.userName}</td>
					<td>${member.userPhoto}</td>
					<td id="memberPhoto"
						style="background-image: url('<%=request.getContextPath()%>/uploadfile/userphoto/${member.userPhoto}');"></td>
					<td><a href="<%=request.getContextPath()%>/memberModify/${member.userId}">수정</a>
						<a href="<%=request.getContextPath()%>/memberDelete/${member.userId}/${member.userPhoto}">삭제</a>
					</td>
				</tr>
			</c:forEach>
		</table>


	</div>





</body>
</html>