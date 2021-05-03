<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="/tastyServer/assets/js/jquery-3.6.0.min.js"></script>
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<link rel="stylesheet" href="/tastyServer/assets/css/header.css" />
<title>마이페이지</title>
</head>
<style>

#mypage .mypagelist a span {
	background: #d4e157;
	margin: 22px 0px 0px 15px;
	height: 17px;
	}
	
#main_cont {
	padding: 15px 0px 40px;
	width: 820px;
	min-height: 650px;
	}
</style>
<body>

	<%@ include file="../common/header.jsp" %>
	<br>
<h1 align="center" style="color:#d4e157;">MY PAGE</h1>
	<br>
	
	<section>
	<form action="/tastyServer/update.me" method="post" id="updateForm">
	
			
<aside>
<div id="main_cont">
	<div id=mypage>
	<ul class="mypagelist">
	<li id="mypage1">
	<a href="/tastyServer/views//member/memberUpdate.jsp">
	<span>회원정보</span>
	</a>
	</li>
		<li id="mypage2">
		<a href="/tastyServer/list.ev" class>
		<span>이벤트 내역</span>
		</a>
		</li>
		<li id="mypage4">
		<a href="" class>
		<span>찜하기</span>
		</a>
		</li>
	</ul>
	</div>
</aside>
	
	
	



<%@ include file ="../common/footer.jsp" %>

</body>
</html>