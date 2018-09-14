<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <title>비트캠프 신촌</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="mystylesheet/mystylesheet.css">
    <style>
        div.main,
        div.main:before,
        div.main:after {
            box-sizing: inherit;
        }

        .column {
            float: left;
            width: 33.3%;
            margin-bottom: 16px;
            padding: 0 8px;
        }

        @media screen and (max-width: 650px) {
            .column {
                width: 100%;
                display: block;
            }
        }

        .card {
            box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2);
        }

        .container {
            padding: 0 16px;
        }

        .container::after,
        .row::after {
            content: "";
            clear: both;
            display: table;
        }

        .title {
            color: grey;
        }

        .button {
            border: none;
            outline: 0;
            display: inline-block;
            padding: 8px;
            color: white;
            background-color: #000;
            text-align: center;
            cursor: pointer;
            width: 100%;
        }

        .button:hover {
            background-color: #555;
        }
    </style>
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
            <a href="vertical3.jsp">강사 소개</a>
            <a href="vertical4.jsp" class="active">학생 소개</a>
            <a href="vertical5.jsp">스터디 신청</a>
            <a class="bottom">&nbsp;</a>
            <a class="bottom">&nbsp;</a>
            <a class="bottom">&nbsp;</a>
            <a class="bottom">&nbsp;</a>
        </div>
        <div class="main">
            <div class="column">
                <div class="card">
                    <img src="student/team1.jpg" alt="Jane" style="width:100%">
                    <div class="container">
                        <h2>Jane Doe</h2>
                        <p class="title">CEO &Founder</p>
                        <p>Some text that describes me lorem ipsum ipsum lorem.</p>
                        <p>example@example.com</p>
                        <p>
                            <button class="button">Contact</button>
                        </p>
                    </div>
                </div>
            </div>

            <div class="column">
                <div class="card">
                    <img src="student/team2.jpg" alt="Mike" style="width:100%">
                    <div class="container">
                        <h2>Mike Ross</h2>
                        <p class="title">Art Director</p>
                        <p>Some text that describes me lorem ipsum ipsum lorem.</p>
                        <p>example@example.com</p>
                        <p>
                            <button class="button">Contact</button>
                        </p>
                    </div>
                </div>
            </div>
            <div class="column">
                <div class="card">
                    <img src="student/team3.jpg" alt="John" style="width:100%">
                    <div class="container">
                        <h2>John Doe</h2>
                        <p class="title">Designer</p>
                        <p>Some text that describes me lorem ipsum ipsum lorem.</p>
                        <p>example@example.com</p>
                        <p>
                            <button class="button">Contact</button>
                        </p>
                    </div>
                </div>
            </div>
        </div>
    </div>

	<%@include file="commons/footer.jsp"%>

</body>

</html>