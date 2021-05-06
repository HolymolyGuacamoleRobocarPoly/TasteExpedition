<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.mj.event.model.vo.*, java.util.*, com.mj.member.model.vo.*" %>	
<%
	EventAdmin ev = (EventAdmin)request.getAttribute("event"); 
	ArrayList<Attachment> eventAttList = (ArrayList<Attachment>)request.getAttribute("eventAttList");
%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>이벤트 상세 페이지</title>
<script src="/tastyServer/assets/js/jquery-3.6.0.min.js"></script>
<style>


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
  background-color: #839903;
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
  color: white;
  }

.button:hover {
  background-color: #cddc39;
  color: black;
  transform: translateY(-7px);
}



</style>
</head>
<body>
	<%@ include file="/views/common/header.jsp" %>
	
	
   	<p style="text-align: center; margin-top: 60px; margin-bottom: 50px; font-size:40px;" >Event</p>
    
   	<% if (eventAttList != null && eventAttList.size()!= 0 ) { %>
	   	<div class="contentImgArea">      
	       	<img class="uploadreviewImg" src="/tastyServer/resources/event/<%= eventAttList.get(0).getAttMFileName()%>"/>
	    </div> 
	<% } %>
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
     
     
     
     
     
    <%@ include file="/views/common/footer.jsp" %>
     
     


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