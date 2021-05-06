<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>이벤트 팝업</title>
<script src="/tastyServer/assets/js/jquery-3.6.0.min.js"></script>
<style>
.header {
	text-align: center;
	margin-right: -10%;
	padding-top: 8px;
	padding-bottom: 8px;
	margin-left: -10%;
	border-radius: 15px;
	border: none;
	color : #c8c8c8;
}

.button {
  height: 40px;
  font-size: 15px;
  text-transform: uppercase;
  letter-spacing: 2.5px;
  font-weight: 600; 
  background-color: #839903;
  border: none;
  border-radius: 5px;
  /*box-shadow: 0px 8px 15px rgba(0, 0, 0, 0.1);*/
  transition: all 0.3s ease 0s;
  cursor: pointer;
  outline: none;
  padding: 0 13px;
  display: block;
  margin-top: 70px;
  margin-right: auto;
  margin-left: auto;
  cursor: pointer;
  }

.button:hover {
  background-color: #cddc39;
  box-shadow: 0px 15px 20px rgba(255, 234, 255, 0.4);
  color: #fff;
  transform: translateY(-7px);
}

.container {
	width: 600px;
	height: 300px;
	border: 1px solid  #c8c8c8;
	border-radius: 3px;
	margin-left: auto;
	margin-right: auto;
	margin-top:50px;
	text-align: center;
	
}


</style>
</head>
<body>

<div class="header">
    	<h1>Event PopUp</h1> <hr>
    </div>
     
    <div class="container">
    	<p style="font-weight: bold; font-size: 50px;">이벤트 참여가 <br> 완료되었습니다!</p>
    </div>
     
	<div>
		<input type="button" class="button" value="닫기" onclick="self.close();" />
	</div>


	

</body>

<script>
	/*function moveClose() {
	  	opener.location.href="회원가입.html";
	  	self.close();
	}*/
</script>
</html>