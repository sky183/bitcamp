<%@page import="com.bit.model.Message"%>
<%@page import="com.bit.model.MessageListView"%>
<%@page import="com.bit.service.GetMessageListService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="/WEB-INF/views/common/headercheck.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/default.css">
</head>
<body>
	<%@ include file="/WEB-INF/views/common/header.jsp"%>
	<form action="writeMessage" method="post">
		<!-- 이름:  -->
		<input type="hidden" name="guest_Name" value="${memberInfo.userId}" />
		<!-- 암호:  -->
		<input type="hidden" name="password" value="1" /> <br />
		<h1 style="margin-left: 15px;">메세지</h1>
		<textarea name="message" cols="30" row="3"
			style="height: 100px; margin: 15px;"></textarea>
		<br /> <input type="submit" value="메시지 남기기" />
	</form>

	<hr>
	<c:set var="viewData" value="${viewData}"></c:set>
	<c:choose>
		<c:when test="${viewData.isEmpty()}">
	등록된 메시지가 없습니다.
		</c:when>
		<c:otherwise>
			<table border="1">
				<tr>
					<td>게시번호</td>
					<td>내용</td>
					<td>작성자</td>
				</tr>
				<c:forEach var="message" items="${viewData.messageList}">
					<tr>
						<td><a
							href="<%=request.getContextPath()%>/view/${message.message_Id}">${message.message_Id}</a>

						</td>
						<td><a
							href="<%=request.getContextPath()%>/view/${message.message_Id}">${message.message}</a>
						</td>
						<td><c:choose>
								<c:when test="${memberInfo.userId.equals(message.guest_Name)}">
									<a
										href="<%=request.getContextPath()%>/memberModify/${message.guest_Name}">${message.guest_Name}</a>
								</c:when>
								<c:otherwise>
						${message.guest_Name}
						</c:otherwise>
							</c:choose></td>
					</tr>
				</c:forEach>
			</table>
			<c:forEach varStatus="i" begin="1" end="${viewData.pageTotalCount}">
				<a href="list?page=${i.index}">[${i.index}] </a>
			</c:forEach>
		</c:otherwise>
	</c:choose>
</body>
</html>