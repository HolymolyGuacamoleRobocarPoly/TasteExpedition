<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.mj.event.model.vo.*, java.util.*"  %>	
<%
	ArrayList<EventAdmin> elist = (ArrayList<EventAdmin>)request.getAttribute("elist"); // 서블릿이 보낸 ReviewList 받아오기 
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0"> 
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>이벤트 내역</title>

<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

<link rel="stylesheet" href="/tastyServer/assets/css/header.css" />
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="apple-touch-icon" href="apple-touch-icon.png">
<link rel="stylesheet" href="/tastyServer/assets/css/userprofile.css">
<script src="/tastyServer/assets/js/jquery-3.6.0.min.js"></script>
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
</head>
<style>
.sidebar1 {
    background: #F17153;
    /* For browsers that do not support gradients */
    background: -webkit-linear-gradient(#F17153, #F58D63, #f1ab53);
    /* For Safari 5.1 to 6.0 */
    background: -o-linear-gradient(#F17153, #F58D63, #f1ab53);
    /* For Opera 11.1 to 12.0 */
    background: -moz-linear-gradient(#F17153, #F58D63, #f1ab53);
    /* For Firefox 3.6 to 15 */
    background: linear-gradient(#F17153, #F58D63, #f1ab53);
    /* Standard syntax */
    padding: 0px;
    min-height: 100%;
    width: 230px;
}
.logo {
    max-height: 130px;
}
.logo>img {
    margin-top: 30px;
    padding: 3px;
    border: 3px solid white;
    border-radius: 100%;
}
.list {
    color: #fff;
    list-style: none;
    padding-left: 0px;
}
.list::first-line {
    color: rgba(255, 255, 255, 0.5);
}
.list> li, h5 {
    padding: 5px 0px 5px 40px;
    font-size: 25px;
}
.list>li:hover {
    background-color: rgba(255, 255, 255, 0.2);
    border-left: 5px solid white;
    color: white;
    font-weight: bolder;
    padding-left: 35px;
}.main-content{
text-align:center;
}

b, strong{
padding-right: 40px;
}

.container{
margin-top: 60px;
}

.table{
height: 200px;
font-size: 20px;
}

section .myPage {
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
<body>

<%@ include file="../common/header.jsp" %>

    <div class="container-fluid">
        <div class="row">
            <div class="col-md-2 col-sm-4 sidebar1">
                <div class="logo">
                    <img src="http://lorempixel.com/output/people-q-g-64-64-1.jpg" class="img-responsive center-block" alt="Logo">
                </div>
                <br>
                <div class="left-navigation" style="height: 700px;">
                    <ul class="list">
                        <h5 style="text-align: center"><strong><%= m.getNickName() %> 님</strong></h5>
                        <li><a href="/tastyServer/views/member/memberUpdate.jsp">정보수정</a></li>
                        <li>찜하기</li>
                        <li>이벤트 내역</li>
                        <li><a href="/tastyServer/views/member/memberDelete.jsp">회원탈퇴</a></li>
                    </ul>

                    <br>
                </div>
            </div>
            <div class="col-md-10 col-sm-8 main-content">
            <!--Main content code to be written here -->
				<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
					integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
					crossorigin="anonymous"></script>
				<script
					src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
					integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
					crossorigin="anonymous"></script>
				<script
					src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
					integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
					crossorigin="anonymous"></script>
				<div class="container">
					
					<h1 align="center" style="color:#d4e157;">회원 정보</h1>
	<br>
	
	<section class="myPage">
	
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
					
					
				</div>


			</div>
    </div>
    
    <%@ include file="../common/footer.jsp" %>
    
</body>
