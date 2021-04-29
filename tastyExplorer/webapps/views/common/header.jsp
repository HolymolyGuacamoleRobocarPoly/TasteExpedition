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
            <li><a href="/tastyServer/views/member/join.jsp">Join Us</a></li>
 
        </ul>

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
</body>
</html>