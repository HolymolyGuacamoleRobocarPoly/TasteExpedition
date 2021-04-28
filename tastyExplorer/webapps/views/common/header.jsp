<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>scroll header</title>
    <link rel="stylesheet" href="../resources/css/headerStyle.css">
    <link rel="stylesheet" href="../resources/css/userprofile.css">

</head>
<body>
    <header>
        <a href="#" class="logo">ㅁㅈ</br>ㅂㄹ<span class="question">?</span></a>
        <ul>
            <li><a href="#">Home</a></li>
            <li><a href="#">About</a></li>
            <li><a href="#">Service</a></li>
            <li><a href="#">Portfolio</a></li>
            <li><a href="#">Team</a></li>
            <li><a href="#">Contact</a></li>
        </ul>

<<<<<<< HEAD
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
					<li><a href="/tastyServer/views/event/eventList.jsp">Event</a></li>
					<li><a href="#price">#소통해요</a></li>
					<li><a href="#contact">Contact</a></li>
					<li class="login"><a href="#">Sign In</a></li>
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
	

	
=======
        <div class="action">
            <div class="profile" onclick="menuToggle();">
                <img src="../resources/image/cat.jpg">
            </div>
            <div class="menu">
                <h3>Youngman<br><span>초보 탐험가</span></h3>
                <ul>
                    <li><img src="../resources/image/user.png"><a href="#">Profile</a></li>
                    <li><img src="../resources/image/logout.png"><a href="#">Logout</a></li>
                </ul>
            </div>
        </div>
    </header>
    <section class="banner"></section>
    <script type="text/javascript">
        window.addEventListener("scroll", function(){
            var header = document.querySelector("header");
            header.classList.toggle("sticky",window.scrollY > 0);
        })
        function menuToggle(){
            const toggleMenu = document.querySelector('.menu');
            toggleMenu.classList.toggle('active')
        }
    </script>
>>>>>>> refs/remotes/origin/youngman
</body>
</html>