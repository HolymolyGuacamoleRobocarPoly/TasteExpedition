<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="com.mj.member.model.vo.Member" %>
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
        <a href="/tastyServer/index.jsp" class="logo">ㅁㅈ</br>ㅂㄹ<span class="question">?</span></a>
        <ul>
            <li><a href="/tastyServer/views/map/map.jsp">지도</a></li>
            <li><a href="/tastyServer/selectList.ev">이벤트</a></li>
            <li><a href="/tastyServer/selectList.co">#소통해요</a></li>

            <% if( m != null) { %>
            <li><a href="/tastyServer/views/mRestaurant/mRestaurantInsert.jsp">맛집등록</a></li>
            
            <li><a href="/tastyServer/select.eh?mNo=<%= m.getmNo()%>">마이페이지</a></li>
            <% } %>

 
        </ul>
        <div class="action">
            <div class="profile" onclick="menuToggle();">
                <img src="/tastyServer/assets/images/no-image.jpg">
            </div>
            <div class="menu">
                <ul>
                <% if ( m== null) { %>
                	<li><img src="/tastyServer/assets/images/user.png" /><a href="/tastyServer/views/member/join.jsp">Sign Up</a></li>
                    <li><img src="/tastyServer/assets/images/log-out.png" /><a href="/tastyServer/views/member/login.jsp">Sign In</a></li>

				<% } else { %>
				 	<%= m.getUserName() %>
                    <li><img src="/tastyServer/assets/images/user.png" /><a href="/tastyServer/select.eh?mNo=<%= m.getmNo()%>">Profile</a></li>
                    <li><img src="/tastyServer/assets/images/log-out.png"/><div  onclick='logout()'>Logout</div>
                    </li>
                </ul>
            </div>
            <% } %>
        </div>
        
        <div class="sidebanner">
        <img src="" alt="" />
        </div>
    </header>
    <script type="text/javascript">
        window.addEventListener("scroll", function(){
            var header = document.querySelector("header");
            header.classList.toggle("sticky",window.scrollY > 0);
        })
        function menuToggle(){
            const toggleMenu = document.querySelector('.menu');
            toggleMenu.classList.toggle('active')
        }
         
        function logout(){
        	location.href="/tastyServer/logout.me";
        }
        

    </script>
</body>
</html>