<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="/tastyServer/assets/js/jquery-3.6.0.min.js"></script>
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<link rel="stylesheet" href="/tastyServer/assets/css/header.css" />
<title>아이디 찾기</title>
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
		
		
</style>
<body>
<%@ include file="../common/header.jsp" %>

<h1 align="center" style="color:#d4e157;">아이디 찾기</h1>
	<br>
	<section>
<form action="findIdLogic.jsp" method="post">
	<table>
	
		<tr>
			<td><input align="center" type="text" name="email" placeholder="이메일을 입력하세요"></td>
		</tr>
		<tr>
			<td align="center"><input type="submit" value="아이디 찾기"></td>
		</tr>
	</table>
</form>
</section>




<%@ include file ="../common/footer.jsp" %>
</body>
</html>