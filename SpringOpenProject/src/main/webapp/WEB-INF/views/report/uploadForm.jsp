<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
body {
	line-height: 240%;
}
</style>
</head>
<body>

	<h3>Requestparam 어노테이션을 이용한 업로드 파일 접근</h3>
	<form action="submitReport1" method="post"
		enctype="multipart/form-data">
		학번 <input type="text" name="studentNumber"> <br> 이름 <input
			type="text" name="studentName"> <br> 리포트 파일 <input
			type="file" name="report"> <br> <input type="submit">
	</form>

	<h3>MultipartHttpServletRequest 사용</h3>
	<form action="submitReport2" method="post"
		enctype="multipart/form-data">
		학번: <input type="text" name="studentNumber" /> <br /> 리포트파일: <input
			type="file" name="report" /> <br /> <input type="submit" />
	</form>

	<h3>커맨드 객체 사용</h3>
	<form action="submitReport3" method="post"
		enctype="multipart/form-data">
		학번: <input type="text" name="studentNumber" /> <br /> 리포트파일: <input
			type="file" name="report" /> <br /> <input type="submit" />
	</form>




</body>
</html>