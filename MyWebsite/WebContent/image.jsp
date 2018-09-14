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
			<a href="index.jsp">Home</a> <a href="board.jsp">자유게시판</a> <a
				href="study.jsp">스터디게시판</a> <a href="data.jsp">자료실</a> <a
				href="image.jsp" class="active">이미지</a> <a
				href="javascript:void(0);" class="icon" onclick="myFunction()">
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


	<div class="row" style="background-color: black;">
		<div class="main"
			style="margin-left: auto; margin-right: auto; max-width: 1400px;">
			<h2
				style="text-align: center; color: white; background-color: black; margin: 0%; padding: 10px; height: 50px;">슬라이드
				쇼</h2>
			<div class="container">
				<div class="mySlides">
					<div class="numbertext">1 / 6</div>
					<img class="mainimg" src="background/11.jpg">
				</div>

				<div class="mySlides">
					<div class="numbertext">2 / 6</div>
					<img class="mainimg" src="background/12.jpg">
				</div>

				<div class="mySlides">
					<div class="numbertext">3 / 6</div>
					<img class="mainimg" src="background/13.jpg">
				</div>

				<div class="mySlides">
					<div class="numbertext">4 / 6</div>
					<img class="mainimg" src="background/14.jpg">
				</div>

				<div class="mySlides">
					<div class="numbertext">5 / 6</div>
					<img class="mainimg" src="background/15.jpg">
				</div>

				<div class="mySlides">
					<div class="numbertext">6 / 6</div>
					<img class="mainimg" src="background/16.jpg">
				</div>

				<a class="prev" onclick="plusSlides(-1)">❮</a> <a class="next"
					onclick="plusSlides(1)">❯</a>

				<div class="caption-container">
					<p id="caption"></p>
				</div>


				<div class="column">
					<img class="demo cursor" src="background/11.jpg"
						style="width: 100%; height: 90%;" onclick="currentSlide(1)"
						alt="The Woods">
				</div>
				<div class="column">
					<img class="demo cursor" src="background/12.jpg"
						style="width: 100%; height: 90%;" onclick="currentSlide(2)"
						alt="Cinque Terre">
				</div>
				<div class="column">
					<img class="demo cursor" src="background/13.jpg"
						style="width: 100%; height: 90%;" onclick="currentSlide(3)"
						alt="Mountains and fjords">
				</div>
				<div class="column">
					<img class="demo cursor" src="background/14.jpg"
						style="width: 100%; height: 90%;" onclick="currentSlide(4)"
						alt="Northern Lights">
				</div>
				<div class="column">
					<img class="demo cursor" src="background/15.jpg"
						style="width: 100%; height: 90%;" onclick="currentSlide(5)"
						alt="Nature and sunrise">
				</div>
				<div class="column">
					<img class="demo cursor" src="background/16.jpg"
						style="width: 100%; height: 90%;" onclick="currentSlide(6)"
						alt="Snowy Mountains">
				</div>
			</div>


			<script>
				var slideIndex = 1;
				showSlides(slideIndex);

				function plusSlides(n) {
					showSlides(slideIndex += n);
				}

				function currentSlide(n) {
					showSlides(slideIndex = n);
				}

				function showSlides(n) {
					var i;
					var slides = document.getElementsByClassName("mySlides");
					var dots = document.getElementsByClassName("demo");
					var captionText = document.getElementById("caption");
					if (n > slides.length) {
						slideIndex = 1
					}
					if (n < 1) {
						slideIndex = slides.length
					}
					for (i = 0; i < slides.length; i++) {
						slides[i].style.display = "none";
					}
					for (i = 0; i < dots.length; i++) {
						dots[i].className = dots[i].className.replace(
								" active", "");
					}
					slides[slideIndex - 1].style.display = "block";
					dots[slideIndex - 1].className += " active";
					captionText.innerHTML = dots[slideIndex - 1].alt;
				}
				function myFunction() {
					var x = document.getElementById("myNavbar");
					if (x.className === "navbar") {
						x.className += " responsive";
					} else {
						x.className = "navbar";
					}
				}
			</script>
		</div>
	</div>


</body>
</html>
