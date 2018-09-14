<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="commons/headercheck.jsp"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <title>비트캠프 신촌</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="mystylesheet/mystylesheet.css">
</head>

<body>

<%@include file="commons/header.jsp"%>
            <div class="navbarmain">
                <div class="navbar" id="myTopnav">
                    <a href="index.jsp" >Home</a>
                    <a href="board.jsp" >자유게시판</a>
                    <a href="study.jsp" class="active">스터디게시판</a>
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
        <div class="main">
            <div style="height:445px;font-size: 100px; font-weight: bold; padding-left: 30%;"><br>스터디 게시판입니다.</div>
        </div>
    </div>

	<%@include file="commons/footer.jsp"%>

</body>

</html>