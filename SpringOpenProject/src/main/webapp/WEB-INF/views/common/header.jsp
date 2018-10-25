<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%-- <%@ page import="com.bit.model.MemberInfo" %> --%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<h1 class="title">OpenProject</h1>
<ul id="gnb">
	<li><a href="<%=request.getContextPath()%>/">메인</a></li>
	<li><a href="<%=request.getContextPath()%>/member/memberReg">회원가입</a></li>
	<c:choose>
		<c:when test="${memberInfo == null}">
			<li><a href="<%=request.getContextPath()%>/member/login">로그인</a></li>
		</c:when>
		<c:otherwise>
			<li><a href="<%=request.getContextPath()%>/member/logout">로그아웃</a></li>
		</c:otherwise>
	</c:choose>
	<li><a href="<%=request.getContextPath()%>/myPage">마이페이지</a></li>
	<li><a href="<%=request.getContextPath()%>/memberList">회원 리스트</a></li>
	<li><a href="<%=request.getContextPath()%>/list">방명록</a></li>
</ul>








