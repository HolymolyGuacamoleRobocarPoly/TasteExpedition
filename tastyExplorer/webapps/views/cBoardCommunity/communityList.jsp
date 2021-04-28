<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.mj.cBoardCommunity.model.vo.*, java.util.*" %>
<%
	ArrayList<Community> list = (ArrayList<Community>)request.getAttribute("list");
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
<script src="/tastyServer/assets/js/jquery-3.6.0.min.js"></script>
<title>#소통해요</title>
<style>
	section {
		width : 900px;
		height : auto;
		/* 좌우 가운데 정렬 */
		margin-left : auto;
		margin-right: auto;
		margin-top : 50px;
		padding : 30px;
		background : black;
		color : white;
	}
	.tableArea {
		width : 800px;
		height: auto;
		margin-left : auto;
		margin-right : auto;
	}
	
	table {
		padding : 15px;
		border: 1px solid yellow;
		text-align : center; 
	}
	
</style>
</head>
<body>
	
	
	
	<!-- 게시글 목록 -->
	<section>
		<h2 align="center">게시글 목록</h2>
		
		<div class="tableArea">
			<table align="center" id="listArea">
				<tr>

					<td width="75px;">No</td>
					<td width="300px;">제목</td>
					<td width="75px;">작성자</td>
					<td width="100px;">팀원수</td>
					<td width="150px;">작성일</td>
					<td width="70px;">조회수</td>
				</tr>
				<% for(Community c : list) { %>
				<tr>
					<td id="<%= c.getcBoardNo() %>"><%= c.getcBoardNo() %></td>
					<td><%= c.getcBoardTitle()%></td>
					<td><%= c.getcBoardwriter() %></td>
					<td><%= c.getcBoardTeam()%></td>
					<td><%= c.getcBoardDate()%></td>
					<td><%= c.getcBoardCount() %></td>
				</tr>
				
				<% } %>
			</table>
		</div>
		
		<!-- 버튼 클릭시 -->
		<div class="btnArea" align="center">
		<br>
		<if (m != null) { %> 	
		<!-- button 아이콘으로 들어갈거임 -->
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
					
					location.href = "/tastyServer/selecOne.co?cno=" + cno;
				});
			</script>
		} 

					<td width="75px;">글번호</td>
					<td width="300px;">제목</td>
					<td width="75px;">팀원수</td>
					<td width="100px;">작성자</td>
					<td width="150px;">작성일</td>
					<td width="70px;">조회수</td>
				</tr>
				<% for(Community c : list) { %>
				<tr>
					<td id="<%= c.getcBoardNo() %>"><%= c.getcBoardNo() %></td>
					<td><%= c.getcBoardTitle()%></td>
					<td><%= c.getcBoardTeam()%></td>
					<td><%= c.getmNo() %></td>
					<td><%= c.getcBoardDate()%></td>
					<td><%= c.getcBoardCount() %></td>
				</tr>
				
				<% } %>
			</table>
		</div>
		
		<!-- 버튼 클릭시 -->
		<div class="btnArea" align="center">
		<br>
		<% if (m != null) { %> 
		
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
					
					location.href = "/tastyServer/selecOne.co?cno=" + cno;
				});
			</script>
		<% } %>

			
		</div>

		<!-- 페이지 부분 -->
		<div class="pagingArea" align="center">
			<button onclick="location.href='/tastyServer/selectList.co?currentPage=1'">
			&lt;&lt;
			</button>
				<% if (cur <= 1) { %>
				<button disabled> &lt; </button>
			<% } else { %>
				<button onclick="location.href='/tastyServer/selectList.co?currentPage=<%= cur - 1 %>'"> &lt;</button>
			<% } %>
			
			<% for(int p = st ; p <= ed ; p++)  { %>
			
				<% if( p == cur) { %>
					<button disabled> <%= p %> </button>
				<% } else { %>
					<button onclick="location.href='/tastyServer/selectList.co?currentPage=<%= p %>'"> <%= p %> </button>
				<% } %>
			<% } %>
			
			<% if (cur >= mx) { %>
				<button disabled> &gt; </button>
			<% } else { %>
				<button onclick="location.href='/tastyServer/selectList.co?currentPage=<%= cur + 1 %>'"> &gt;</button>
			<% } %>
			
			<button onclick="location.href='/tastyServery/selectList.co?currentPage=<%= mx %>'">
				&gt;&gt;
			</button>
	
		</div>
		
		
		
		
		
	</section>


</body>
</html>