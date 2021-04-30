<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.mj.member.model.vo.*" %>
<%
	Member m = (Member)session.getAttribute("member");
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>scroll header</title>
    <link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
    <script src="/tastyServer/assets/js/jquery-3.6.0.min.js"></script>
    <link rel="stylesheet" href="/tastyServer/assets/css/header.css">
    <link rel="stylesheet" href="/tastyServer/assets/css/userprofile.css">
</head>
<body>
    <header>
        <a href="#" class="logo">ㅁㅈ</br>ㅂㄹ<span class="question">?</span></a>
        <ul>
            <li><a href="#">Home</a></li>
            <li><a href="/tastyServer/views/review/reviewWrite.jsp">리뷰</a></li>
            <li><a href="/tastyServer/views/event/eventList.jsp">이벤트</a></li>
            <li><a href="#">About</a></li>
            <li><a href="/tastyServer/views/cBoardCommunity/communityList.jsp">#소통해요</a></li>
            <li><a href="#">Portfolio</a></li>
            <li><a href="#">Team</a></li>
            <li><a href="#">Contact</a></li>
            <li><a href="/tastyServer/views/member/join.jsp">Join Us</a></li>
            <li><a href="/tastyServer/views/member/login.jsp">Login</a></li>
 
        </ul>

        <div class="action">
            <div class="profile" onclick="menuToggle();">
                <img src="/tastyServer/assets/images/no-image.jpg">
            </div>
            <div class="menu">
                <h3>Youngman<br><span>초보 탐험가</span></h3>
                <ul>
                    <li><img src="/tastyServer/assets/images/user.png" />
                    <a href="http://localhost:8087/tastyServer/views/member/join.jsp">회원가입</a></li>
                    <li><img src="/tastyServer/assets/images/log-out.png" /><a href="#">로그인</a></li>
                </ul>
            </div>
        </div>
        
        <div class="sidebanner">
        <img src="" alt="" />
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