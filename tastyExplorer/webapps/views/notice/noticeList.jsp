<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.mj.notice.model.vo.*, java.util.*" %>
<%
	ArrayList<Notice> list = (ArrayList<Notice>)request.getAttribute("list");
	PageInfo pi = (PageInfo)request.getAttribute("pi");

	int st = pi.getStartPage();
	int ed = pi.getEndPage();
	int mx = pi.getMaxPage();
	int limit = pi.getLimit();
	int listCount = pi.getListCount();
	int cur = pi.getCurrentPage();
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="/tastyExplorer/assets/js/jquery-3.6.0.min.js"></script>
<title>공지사항</title>
</head>
<body>

	
	<!-- 게시글 목록 -->
	<section>
		<h2 align="center">게시글 목록</h2>
		
		<div class="tableArea">
			<table align="center" id="listArea">
				<tr>
					<td>글번호</td>
					<td>제목</td>
					<td>작성일</td>
					<td>조회수</td>
					<td>첨부파일</td>
				</tr>
				<% for (Notice n : list) { %>
				<tr>
					<td id="<%= n.getnNo() %>"><%= n.getnNo() %></td>
					<td><%= n.getnTitle()%></td>
					<td><%= n.getnDate()%></td>
					<td><%= n.getnCount()%></td>
				</tr>
				<% } %>
			</table>
		</div>
		
		<!-- 버튼 클릭시 -->
		<div class="btnArea" align="center">
		<br>
		<button onclick="location.href='views/notice/noticeInsert.jsp'">작성하기</button>
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
					
					location.href = "/tastyExplorer/selectOne.no?nno=" + nno;
				});
			</script>
			
			
		</div>
		
		<div class="pagingArea" align="center">
			<button onclick="location.href='/tastyExplorer/NoticeSelectList.no?currentPage=1'">
			&lt;&lt;
			</button>
			
	
		</div>
		
	</section>



</body>
</html>