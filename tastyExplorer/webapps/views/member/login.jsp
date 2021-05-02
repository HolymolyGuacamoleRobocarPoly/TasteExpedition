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

section {
		width : 700px;
		height: auto;
		color: black;
		margin-left: auto;
		margin-right: auto;
		margin-top: 50px;
		padding : 5px;
		}

#loginBtn {
		background:#d4e157;
		border-radius:5px;
		width:130px;
		height:25px;
		text-align:center;
	}
</style>
<body>

<%@ include file="../common/header.jsp" %>

<h1 align="center" style="color:#d4e157;">LOGIN</h1>
	<br>
	
	<section>
	<div class="loginbox" style="display: block;">

		<form action="/tastyServer/login.me" method="post" id="loginForm" autocomplete="off">
			<fieldset>
								<ul align="center" class="inform">
									<li>
										 											<label for="userId">아이디</label>
											<input type="text" name="userId" id="userId" value="" class="placeholder" autocomplete='new-password'>
										 									</li>
									<li>
										<label for="userPwd">비밀번호</label>
										<input type="password" name="userPwd" id="userPwd" class="placeholder" autocomplete='new-password'>
									</li>
								</ul>
								<ul align="center" class="option">
<!-- 									<li><input type="checkbox" id="auto" name="auto" checked><label for="auto">자동 로그인</label></li> -->
									<li><input type="checkbox" id="save" name="save" ><label for="save">아이디 저장</label>
								</ul>
								<ul align="center" class="linkbox">
								<a href="/tastyServer/views/member/findId.jsp">아이디찾기</a>
						
								<a hrdf="">비밀번호찾기</a>
								
								</ul>
						
								<div align="center" id="loginBtn" class="btn" onclick='login()'>로그인</div>
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

<%@ include file ="../common/footer.jsp" %>

</body>
</html>