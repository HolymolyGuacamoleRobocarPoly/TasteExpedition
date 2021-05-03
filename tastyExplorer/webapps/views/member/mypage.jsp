<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.mj.event.model.vo.*, java.util.*" %>	
<%
	EventAdmin ev = (EventAdmin)request.getAttribute("event"); // 서블릿이 보낸 ReviewList 받아오기 

	ArrayList<EventAdmin> elist = (ArrayList<EventAdmin>)request.getAttribute("elist"); // 서블릿이 보낸 ReviewList 받아오기 

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="/tastyServer/assets/js/jquery-3.6.0.min.js"></script>
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<link rel="stylesheet" href="/tastyServer/assets/css/header.css" />
<title>마이페이지</title>
</head>
<body>

<%@ include file="../common/header.jsp" %>

<h1 align="center" style="color:#d4e157;">MY PAGE</h1>
<br>
   <% for(EventAdmin e : elist) { %>
	<div>이벤트 번호: <%= e.geteNo() %></div>
	<div>이벤트 제목: <%= e.geteTitle() %></div>
	<div>이벤트 내용: <%= e.geteContent() %></div>
	<div>이벤트 기간: <%= e.geteDuration() %></div>
	<% } %>
	
	
<%@ include file ="../common/footer.jsp" %>

</body>
</html>