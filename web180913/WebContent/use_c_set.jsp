<%@ page contentType="text/html; charset=utf-8"%>
<%@ page import="member.Member"%>
<%@ page import=" java.util.HashMap "%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	Member member = new Member();
	member.setName("Sdf");
	HashMap<String, String> pref = new HashMap<String, String>();
%>
<html>
<body>
	<c:set var="member" value="<%=member%>" />

	<c:set target="${member}" property="name" value="최범균" />

	<c:set var="pref" value="<%=pref%>" />
	<c:set var="favoriateColor" value="${pref.color}" />
	<!-- 없는 값이므로 아무것도 표시 안됨 -->
	회원 이름: ${member.name}, 좋아하는 색: ${favoriateColor}

	<br />
	<c:set target="${pref}" property="color" value="red" />
	<c:set var="favoriateColor" value="${pref.color}" />
	설정 이후 좋아하는 색: ${favoriateColor}

</body>
</html>