<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script>
alert('로그인 후 사용가능한 서비스입니다.');
	location.href = '<%=request.getContextPath()%>/member/login';
</script>
