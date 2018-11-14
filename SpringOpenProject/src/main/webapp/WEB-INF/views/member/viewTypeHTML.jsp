<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="/WEB-INF/views/common/headercheck.jsp"%>
<tr>
	<td>아이디</td>
	<td>비밀번호</td>
	<td>이름</td>
	<td colspan="2">사진</td>
	<td>가입일</td>
	<td>관리</td>
</tr>

<c:forEach var="member" items="${members}">
	<tr>
		<td>${member.userId}</td>
		<td>${member.password}</td>
		<td>${member.userName}</td>
		<td>${member.userPhoto}</td>
		<td id="memberPhoto"
			<%-- style="background-image: url('<%=request.getContextPath()%>/uploadfile/userphoto/${member.userPhoto}');"></td> --%>
			style="background-image: url('<%=request.getContextPath()%>/photo/${member.userPhoto}');"></td>
		<td>${member.regDate}</td>
		<td><a
			href="<%=request.getContextPath()%>/memberModify/${member.userId}">수정</a>
			<a
			href="<%=request.getContextPath()%>/memberDelete/${member.userId}/${member.userPhoto}">삭제</a>
		</td>
	</tr>
</c:forEach>
