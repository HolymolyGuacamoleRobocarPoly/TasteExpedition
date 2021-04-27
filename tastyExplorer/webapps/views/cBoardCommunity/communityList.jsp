<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.mj.cBoardCommunity.model.vo.*, java.util.*" %>
<%
	ArrayList<Community> list = (ArrayList<Community>)request.getAttribute("list");
	//PageInfo pi = (PageInfo).request.getAttribute("pi");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="/tastyServer/assets/js/jquery-3.6.0.min.js"></script>
<title>#소통해요</title>
</head>
<body>
	<!-- <%@ include file = "" %> -->
	
	
	<!-- 게시글 목록 -->
	<section>
		<h2 align="center">게시글 목록</h2>
		
		<div class="tableArea">
			<table align="center" id="listArea">
				<tr>
					<td width="75px;">글번호</td>
					<td width="300px;">제목</td>
					<td width="75px;">팀원수</td>
					<td width="100px;">작성자</td>
					<td width="150px;">작성일</td>
					<td width="70px;">조회수</td>
					<td width="80px;">첨부파일</td>
				</tr>
				<% for(Community c : list) { %>
				<tr>
					<td><%= c.getCboardno() %></td>
					<td><%= c.getCboardtitle()%></td>
					<td><%= c.getCboardteam()%></td>
					<!-- 회원번호 -->
					<td><%= c.getCdate()%></td>
					<td><%= c.getCcount() %></td>
				</tr>
				
				<% } %>
			</table>
		</div>
		
		<!-- 버튼 클릭시 -->
		<div class="btnArea" align="center">
		<br>
		<% if (m != null) { %>
		<
		<button onclick="location.href='views/community/communityInsert.jsp'">작성하기</button>
			<script>
				$('#listArea td').on('mouseenter'), function() {
					$(this).parent().css({'background' : 'white',
										  'curor' : 'porinter',
										  'color' : 'gray'});
				}).on('mouserout', function(){
					$('this').parent().css({'backgrond' : 'white',
											'color' : 'white'});
				}).on('click', function(){
					var nno = $('this').parent.children().first().attr('id');
					
					console.log(nno);
					
					location.href = "/tastyExplorer/selecOne.co?cno=" + cno;
				});
			</script>
		<% } %>
			
		</div>
		
		
		
	</section>


</body>
</html>