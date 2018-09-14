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
    <div class="navbarmain">
        <div class="navbar" id="myTopnav">
            <a href="index.jsp" class="active">Home</a>
            <a href="board.jsp">자유게시판</a>
            <a href="study.jsp">스터디게시판</a>
            <a href="data.jsp">자료실</a>
            <a href="image.jsp">이미지</a>
            <a href="javascript:void(0);" class="icon" onclick="myFunction()">
                <i class="fa fa-bars"></i>
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
            <a href="index.jsp">학원 메인</a>
            <a href="vertical2.jsp">학원 소개</a>
            <a href="vertical3.jsp" class="active">강사 소개</a>
            <a href="vertical4.jsp">학생 소개</a>
            <a href="vertical5.jsp">스터디 신청</a>
            <a class="bottom">&nbsp;</a>
            <a class="bottom">&nbsp;</a>
            <a class="bottom">&nbsp;</a>
            <a class="bottom">&nbsp;</a>
        </div>
        <div class="main">
            <!-- <h2>제목</h2> -->
            <!-- <h5>2018년 8월 8일</h5> -->
            <div style="height:200px; width: 900px; color: blue; font-size: 100px; font-weight: bold; padding-left: 60px;">
                <br>3페이지입니다.</div>
            <br>
        </div>
    </div>

	<%@include file="commons/footer.jsp"%>

</body>

</html>