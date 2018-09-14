<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.net.URLDecoder"%>


<!DOCTYPE html>

<head>
<title>비트캠프 신촌</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="mystylesheet/mystylesheet.css?version=1">
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.2.0/css/all.css"
	integrity="sha384-hWVjflwFxL6sNzntih27bfxkr27PmbbK/iSvJ+a4+0owXq79v+lsFkW54bOGbiDQ"
	crossorigin="anonymous">
</head>

<body>
	<%@include file="commons/sessionCheck.jsp"%>
	<%@include file="commons/header.jsp"%>

	<div class="navbarmain">
		<div class="navbar" id="myTopnav">
			<a href="index.jsp" class="active">Home</a> <a href="board.jsp">자유게시판</a>
			<a href="study.jsp">스터디게시판</a> <a href="data.jsp">자료실</a> <a
				href="image.jsp">이미지</a> <a href="javascript:void(0);" class="icon"
				onclick="myFunction()"> <i class="fa fa-bars"></i>
			</a>
			<%@include file="commons/status.jsp"%>

		</div>
	</div>

	<script>
		function myFunction() {
			var x = document.getElementById("myTopnav");
			if (x.className === "navbar") {
				x.className += " responsive";
			} else {
				x.className = "navbar";
			}
		}
	</script>


	<div class="row">
		<div class="vertical-menu">
			<a href="index.jsp" class="active">학원 메인</a> <a href="vertical2.jsp">학원
				소개</a> <a href="vertical3.jsp">강사 소개</a> <a href="vertical4.jsp">학생
				소개</a> <a href="vertical5.jsp">스터디 신청</a> <a class="bottom">&nbsp;</a> <a
				class="bottom">&nbsp;</a> <a class="bottom">&nbsp;</a> <a
				class="bottom">&nbsp;</a>
		</div>
		<div class="main">
			<div>
				<h5 style="color: black; padding-left: 60px;">2018년 8월 8일</h5>
				<div
					style="color: black; font-size: 60px; font-weight: bold; padding-left: 60px;">
					메인화면입니다.</div>
			</div>
			<br>
		</div>
	</div>

	<%@include file="commons/footer.jsp"%>

</body>

</html>