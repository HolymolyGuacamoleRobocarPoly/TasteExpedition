<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="/tastyServer/assets/js/jquery-3.6.0.min.js"></script>
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<link rel="stylesheet" href="/tastyServer/assets/css/header.css" />
<title>로그인 페이지</title>
</head>
<style>
@import url('https://fonts.googleapis.com/css2?family=Fredoka+One&display=swap');

.signinMain {
	width : 700px;
	color: black;
	margin-left: auto;
	margin-right: auto;
	margin-top: 20px;
	margin-bottom: 130px;
	padding : 0px;
	font-family: 'Noto Sans KR', sans-serif;
}
		
	section .signinMain {
		height: 1400px;
	}
		
		.contents > h2 {
		padding: 0 0 45px 0;
		margin-top: 20px;
		min-height: 60px;
		font-family: 'Fredoka One', cursive;
		font-size: 40px;
		color:#d4e157;
		text-align: center;
	}
	
	.login {
		margin: 0 auto;
		width: 590px;
	}
	
	form, fieldset {
	margin: 0;
    padding: 0;
    border: 0;
    font-size: 100%;
    font: inherit;
    vertical-align: baseline;
	}
	
	form {
	 display: block;
	}
	
	.inform {
		margin: 0 0 28px 0;
	}
	
	ol, ul {
	list-style: none;
	padding: 0;
    border: 0;
    font-size: 100%;
    font: inherit;
    vertical-align: baseline;
	}
	
	.link-box {
	margin: 0 0 30px 0;
    font-size: 100%;
    text-align: center;
	}
	
	a {
	color: inherit;
    text-decoration: none;
	}
	
	.link-box li {
	display: inline-block;
    position: relative;
    font-size: 16px;
    color: #585858;
	}
	
	.option {
	text-align: left;
	padding-left: 25%;
	}
	
	.option li {
	display: inline-block;
    margin: 0 0 0 24px;
	}
	
	.option li label {
	line-height: 30px;
    height: 28px;
    display: inline-block;
    font-size: 16px;
    color: # 585858;
	}
	
	input[type="checkbox"]{
		position:absolute;
		clip: rect(0,0,0,0);
	}
	
	input[type="checkbox"] + label::before{
		content : "\a0";
		display: inline-block;
		width: 1em; height: 1em;
		color: white;
		background-color: white;
		border: 1px solid #d4e157;
		border-radius: 0.2em;
		margin: 0.1em; 
	}
	
	input[type="checkbox"]:checked + label::before {
		content: "\2174";
		background-color: #d4e157;
		text-indent: 0.1em;
	}
	


		


	
</style>
<body>

<%@ include file="/views/common/header.jsp" %>

<div class="contents">
	<h2>Sign In</h2>
	</div>
	
	<section class="signinMain">
	<div class="login">

		<form action="/tastyServer/login.me" method="post" id="loginForm" autocomplete="off">

			<fieldset>
								<ul class="inform">
									<li>
										 	<label for="userId">아이디</label>
											<input type="text" name="userId" id="userId" value="" class="placeholder" autocomplete='new-password' placeholder="아이디를 입력해주세요.">
									</li>
									
									<li>
										<label for="userPwd">비밀번호</label>
										<input type="password" name="userPwd" id="userPwd" class="placeholder" autocomplete='new-password' placeholder="비밀번호를 입력해주세요.">
									</li>
								</ul>
								
								<ul class="option">
									<li>
										<input type="checkbox" id="save" name="save">
										<label for="save">아이디 저장</label>
										</li>
							<li>
										<input type="checkbox" id="auto" name="auto" checked>
										<label for="auto">로그인 상태 유지</label>
									</li>
								</ul>
								
								<ul class="link-box">
									<li>
										<a href="#">아이디찾기</a>
									</li>
									<li>
										<a href="#">비밀번호찾기</a>
									</li>
								</ul>
						
								<div class="login1" id="loginBtn" class="btn-1-black" onclick='login()'>로그인</div>
							</fieldset>
						</form>
					
						</div>
					
	
	
	</section>
	
	<script>
	
	 function login(){
		 if($("#userId").val() == "") alert("아이디를 입력해주세요.");
		 else if($("#userPwd").val() == "") alert("비밀번호를 입력해주세요.");
		 else $('#loginForm').submit();
     }
	 
	</script>

<%@ include file ="/views/common/footer.jsp" %>

</body>
</html>