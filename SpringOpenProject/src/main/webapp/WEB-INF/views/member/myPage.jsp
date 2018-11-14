<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="/WEB-INF/views/common/headercheck.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/default.css">
<style>
h2, td {
	padding: 10px;
}

#memberPhoto {
	background-image: url('<%=request.getContextPath()%>/photo/${memberInfo.userPhoto}');
	background-size: 100%;
	width: 150px;
	height: 150px;
	border: 1px solid #333333;
	border-radius: 75px;
	margin: 20px 0;
}
</style>
</head>
<body>

	<%@ include file="../common/header.jsp" %>


	<div id="contents">

		<h2>회원 정보</h2>

		<div id="memberPhoto"></div>
	
		<hr>
		<table>
			<tr>
				<td>아이디(이메일)</td>
				<td>${memberInfo.userId}</td>
			</tr>
			<tr>
				<td>이름</td>
				<td>${memberInfo.userName}</td>
			</tr>
			<tr>
			<td><a href="<%=request.getContextPath()%>/memberModify/${memberInfo.userId}">수정</a></td>
			</tr>
		</table>



	</div>











</body>
</html>
<%-- <%}%> --%>