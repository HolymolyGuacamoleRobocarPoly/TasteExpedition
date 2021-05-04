<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.mj.event.model.vo.*, java.util.*, com.mj.member.model.vo.*" %>	
<%
	EventAdmin ev = (EventAdmin)request.getAttribute("event"); 
	
%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>이벤트 상세 페이지</title>
<script src="/tastyServer/assets/js/jquery-3.6.0.min.js"></script>
<style>


.container{
	width: 600px;
	height: auto;
	border: 1px solid  #c8c8c8;
	border-radius: 3px;
	margin-left: auto;
	margin-right: auto;
	margin-top: 100px;
	display: inline;
	
}

.contentImgArea{
	width: 600px;
	height: 1000px;
	margin-top: -10px;
	border: 1px solid #c8c8c8;
	border-radius: 3px;
	margin-right: auto;
	margin-left: auto;
	border-left: none;
    border-right: none;
	
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

p{
	font-size: 30px;
}


</style>
</head>
<body>
	<%@ include file="../common/header.jsp" %>
	
	
   	<p style="text-align: center; margin-top: 70px; margin-bottom: 20px;" >이벤트</p>
    
   	
	   	<div class="contentImgArea">      
	       	<img class="uploadreviewImg" src="/tastyServer/assets/images/event1.PNG"/>
	    </div> 
	<form action="/tastyServer/insert.ev" method="post">

		<input type="hidden" name="eNo" value=<%= ev.geteNo() %> />		
		<input type="hidden" name="mNo" value="<%= m.getmNo() %>"/>

		<div class="button_area" style="margin-top:50px;">     
		<% if ( ev.getCheck().equals("Y")) { %>
	      	<button class="button" onclick="showPopup(true);">참여하기</button>
	    <% } else { %>
	        <button type="button" class="button" onclick="alert('이미 참여 하셨습니다.');">참여하기</button>
	    <% } %>
	   	</div>
    </form>
     
     
     
     
     
    <%@ include file="../common/footer.jsp" %>
     
     


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