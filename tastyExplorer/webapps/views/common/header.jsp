<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<!-- 맨 윗부분 (이거 없으면 헤더 윗 부분이 비우므로 채우는게 나을 것 같음) -->
	<section id="social" class="social">
		<div class="container">
			<!-- Example row of columns -->
			<div class="row">
				<div class="social-wrapper">
					<div class="col-md-6">
						<div class="social-icon">
							<a href="#"><i class="fa fa-facebook"></i></a> <a href="#"><i
								class="fa fa-twitter"></i></a> <a href="#"><i
								class="fa fa-google-plus"></i></a> <a href="#"><i
								class="fa fa-linkedin"></i></a>
						</div>
					</div>
					<div class="col-md-6">
						<div class="social-contact">
							<a href="#"><i class="fa fa-phone"></i>+011 54925849</a> <a
								href="#"><i class="fa fa-envelope"></i>contact@softech.com</a>
						</div>
					</div>
				</div>
			</div>
		</div>
		<!-- /container -->
	</section>

	<nav class="navbar navbar-default">
		<div class="container">
			<!-- 아이콘으로 할지 아님 그냥 텍스트로 할지 정해야함 -->
			<!-- 아이콘은 이미지로 만들 것인지? 텍스트로 할경우 이부분은 삭제 -->
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
					aria-expanded="false">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#"><img
					src="assets/images/logo.png" alt="Logo" /></a>
			</div>

			<!-- Collect the nav links, forms, and other content for toggling -->
			<div class="collapse navbar-collapse"
				id="bs-example-navbar-collapse-1">
				<!-- 메뉴 부분 -->
				<ul class="nav navbar-nav navbar-right">
					<li class="active"><a href="#home">Home</a></li>
					<li><a href="#features">Notice</a></li>
					<li><a href="#service">Event</a></li>
					<li><a href="#price">#소통해요</a></li>
					<li><a href="#contact">Contact</a></li>

					<li><a href="/tastyServer/views/review/reviewWrite.jsp">리뷰</a></li>
					<li class="login"><a href="#">Sign In</a></li>

					<li class="login"><a href="/tastyServer/views/member/login.jsp">Login</a></li>
					<li class="joinUs"><a href="/tastyServer/views/member/join.jsp">Join Us</a></li>

				</ul>

			</div>
			<!-- /.navbar-collapse -->
		</div>
		<!-- /.container-fluid -->
	</nav>

	<!--Home page style-->
	<header id="home" class="home">
		<div class="overlay-fluid-block">
			<div class="container text-center">
				<div class="row">
					<div class="home-wrapper">
						<div class="col-md-10 col-md-offset-1">
							<div class="home-content"></div>
						</div>
					</div>

				</div>
			</div>
		</div>

	</header>
	

	
</body>
</html>