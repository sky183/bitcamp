<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>비트캠프 신촌</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="mystylesheet/mystylesheet.css">
</head>
<body>

	<%@include file="commons/sessionCheck.jsp"%>
	<%@include file="commons/header.jsp"%>
	<div>
		<div class="navbar">
			<a class="left"></a> <a href="index.jsp">Home</a> <a
				href="board.jsp">자유게시판</a> <a href="study.jsp">스터디게시판</a> <a
				href="data.jsp">자료실</a> <a href="image.jsp">이미지</a> <a href="#"
				class="right">임시</a>
		</div>
	</div>


	<div class="row">
		<!-- <div class="side">
      <h2>About Me</h2>
      <h5>Photo of me:</h5>
      <div class="fakeimg" style="height:200px;">Image</div>
      <p>Some text about me in culpa qui officia deserunt mollit anim..</p>
      <h3>More Text</h3>
      <p>Lorem ipsum dolor sit ame.</p>
      <div class="fakeimg" style="height:60px;">Image</div><br>
      <div class="fakeimg" style="height:60px;">Image</div><br>
      <div class="fakeimg" style="height:60px;">Image</div>
  </div> -->
		<div class="vertical-menu">
			<a href="index.jsp" class="active">학원 메인</a> <a
				href="vertical2.jsp">학원 소개</a> <a href="vertical3.jsp">강사 소개</a> <a
				href="vertical4.jsp">학생 소개</a> <a href="vertical5.jsp">스터디 신청</a>
			<a class="bottom">&nbsp;</a>
		</div>
		<div class="main">
			<!-- <h2>제목</h2> -->
			<h5>2018년 8월 8일</h5>
			<div class="fakeimg" style="height: 200px; width: 900px;"></div>
			<!-- style="height:200px; background-image: url('background/13.jpg'); text-align: center; color: white; font-size: 50px;"-->
			<!-- <img src="background/13.jpg" alt="" height="600px" width="1000px"> -->
			<p>동해물과 백두산이 마르고 닳도록 하느님이 보우하사 우리나라 만세</p>
			<p>laboreo.</p>
			<br>
		</div>
	</div>

	<%@include file="commons/footer.jsp"%>
</body>
</html>
