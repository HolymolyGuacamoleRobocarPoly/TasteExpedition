<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>이벤트 상세 페이지</title>
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

.container{
	width: 600px;
	height: atuo;
	border: 1px solid  #c8c8c8;
	border-radius: 3px;
	margin-left: auto;
	margin-right: auto;
	margin-top:50px;
	
}

.contentImgArea{
	width: 600px;
	height: 1000px;
	border: 1px solid #c8c8c8;
	border-radius: 3px;
	margin-right: auto;
	margin-left: auto;
	
}
.uploadreviewImg{
	width: 600px;
	height: 1000px;
}

button {
  height: 40px;
  font-size: 15px;
  text-transform: uppercase;
  letter-spacing: 2.5px;
  font-weight: 600; 
  background-color: #FFF0F0;
  border: none;
  border-radius: 5px;
  /*box-shadow: 0px 8px 15px rgba(0, 0, 0, 0.1);*/
  transition: all 0.3s ease 0s;
  cursor: pointer;
  outline: none;
  padding: 0 13px;
  display: block;
  margin-bottom: 50px;
  margin-right: auto;
  margin-left: auto;
  cursor: pointer;
  }

.button:hover {
  background-color: #FFBEBE;
  box-shadow: 0px 15px 20px rgba(255, 234, 255, 0.4);
  color: #fff;
  transform: translateY(-7px);
}


</style>
</head>
<body>

	<div class="header">
    	<h1>Event Detail</h1> <hr>
    </div>
     
    <div class="container">
    	<div class="contentImgArea">      
        	<img class="uploadreviewImg" src="/tastyServer/assets/images/event1.PNG"/>
        </div> 
    </div>
     
	<div class="button_area" style="margin-top:50px;">     
      	<button class="button" onclick="showPopup();">참여하기</button>
   	</div>
    
     
     
     
     
     


</body>

<script>
	function showPopup() { 
		var windowW = 700;  // 창의 가로 길이
	    var windowH = 700;  // 창의 세로 길이
	    var left = Math.ceil((window.screen.width - windowW)/2);
	    var top = Math.ceil((window.screen.height - windowH)/2);
		window.open("/tastyServer/views/event/eventPopUp.jsp", "이벤트 참여 완료","l top="+top+", left="+left+", height="+windowH+", width="+windowW);
		}
	
	
	
</script>

</html>