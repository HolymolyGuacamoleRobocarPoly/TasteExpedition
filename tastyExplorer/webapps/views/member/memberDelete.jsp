<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="/tastyServer/assets/js/jquery-3.6.0.min.js"></script>
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<link rel="stylesheet" href="/tastyServer/assets/css/header.css" />
<title>회원탈퇴</title>
<style>
	section {
		width : 700px;
		height: 500px;
		color: black;
		margin-left: auto;
		margin-right: auto;
		margin-top: 50px;
		padding : 5px;
		}
		
		#ckZip, #deleteBtn {
		background:#d4e157;
		border-radius:5px;
		width:130px;
		height:25px;
		text-align:center;
	}
	
	#deleteBtn:hover {
		cursor:pointer;
	}
	
</style>

</head>

<body>

<%@ include file="../common/header.jsp" %>
	
	<h1 align="center" style="color:#d4e157;">회원 정보</h1>
	<br>
	
	<section>
	
	<form action="/tastyServer/update.me" method="post" id="updateForm">
		 			
			<table align="center">
				<tr>
					<td width="200px">아이디 </td>
					<td><%= m.getUserId() %></td>
				</tr>
				<tr>
					<td>이름</td>
					<td><%= m.getUserName() %></td>
					<td></td>
				</tr>
				<tr>
					<td>닉네임</td>
					<td><%= m.getNickName() %></td>
					<td></td>
				</tr>
				<tr>
				<td>생년월일</td>
				<td><%= m.getBirthday() %>	</td>
				<td></td>
				</tr>				
				<tr>
					<td>연락처</td>
					<td><%= m.getPhone() %></td>
					<td></td>
				</tr>
				<tr>
					<td>이메일 </td>
					<td><%= m.getEmail() %></td>
					<td></td>
				</tr>
				<tr>
					<td>주소</td>
					<td><%= m.getAddress() %></td>
					<td></td>
				</tr>
			</table>
			
		<br>
			<div class="btns" align="center">
				<div id="deleteBtn" onclick="deleteMember();">탈퇴하기</div>
			</div>
		</form>
		
		</section>
	

	
	<script>
	
    function deleteMember() {
    	location.href ="/tastyServer/delete.me?mid=<%= m.getUserId() %>";
    }
    
    var phoneArr = '<%= m.getPhone() %>'.split('-');

	$('input[name*="tel"]').each(function(index){
		$(this).val(phoneArr[index]);
	});
	
	var addressArr = '<%= m.getAddress() %>'.split(', ');
	
	$('#zipCode').val(addressArr[0]);
	$('#address1').val(addressArr[1]);
	$('#address2').val(addressArr[2]);
    
   
    
    
	</script>
	
	<%@ include file ="../common/footer.jsp" %>


</body>
</html>