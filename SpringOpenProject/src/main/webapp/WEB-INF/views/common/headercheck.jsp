<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%-- <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 <c:if test="${memberInfo == null}">
<script>
	alert('로그인 후 사용가능한 서비스입니다.');
	location.href = 'member/login';
</script>
</c:if> 
 --%>