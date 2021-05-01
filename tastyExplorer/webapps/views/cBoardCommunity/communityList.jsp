<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.mj.cBoardCommunity.model.vo.*, java.util.*" %>
<%
	ArrayList<Community>  list = (ArrayList<Community>)request.getAttribute("list");
	PageInfo pi = (PageInfo)request.getAttribute("pi");
	
	int st = pi.getStartPage();
	int ed = pi.getEndPage();
	int mx = pi.getMaxPage();
	int cur = pi.getCurrentPage();
	int limit = pi.getLimit();
	int listCount = pi.getListCount();
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/tastyServer/assets/css/header.css" />
<script src="/tastyServer/assets/js/jquery-3.6.0.min.js"></script>
<style>
.banner {
margin-top: 0px;
}

.main-div {
	width : 230px;
	height : 100vh;
	padding : 10px;
	align-items : center;
	margin : 0 auto;
}

.search-form {
	border : 4px solid black;
	border-radius : 24px;
	position : relative;
 }

.search-input {
	width : all;
	height : 40px;
	font-size : 15px;
	padding-left :  38px;
	border : none;
	border-radius : 20px;
	
}

.search-history {
	border-radius : 10px;
	display : none;
}

.search-history a {
	display : inline-block;
	border-radius : 20px;
	width: 274px;
	padding : 10px 10px;
	color : black;
}

.search-history a:hover {
	background-color : orange;
} 

.search-input:focus ~ .search-history {
	display : block;
}

.search-history a:focus {
	display : block;
}

search-input:focus {
	outline : none;
}
section {
	width : 900px;
	height : auto;
	/* 좌우 가운데 정렬 */
	margin-left : auto;
	margin-right: auto;
	margin-top: 50px;
	padding : 30px;
	background : lightblue;
	color : black;
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

.btnArea {
	margin-left : 700px;
	margin-top : 40px;
		height: 10px;
}

</style>
<title>#소통해요</title>

</head>
<body>
	<%@ include  file = "../common/header.jsp" %>
	<!-- 게시글 목록임 -->
	<section>
		<h2 align="center">#소통해요</h2>
		
		<!-- 버튼 클릭시  -->
		<div class="btnArea" align="center">
		<br>
		<button href='views/cBoardCommunity/communityInsert.jsp'>작성하기</button>
		<% if (m != null) { %> 
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
					
					location.href = "/tastyServer/selecOne.co?cboardno=" + cboardno;
				});
			</script>
		<% } %>
			
		</div>
		<br><br>
		<div class="tableArea">
			<table align="center" id="listArea">
				<tr>
					<td width="75px;">No</td>
					<td width="400px;">제목</td>
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
					<td><%= c.getcBoardWriter()%></td>
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
					
					location.href = "/tastyServer/selectOne.co?cboardno=" + cboardno;
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
		
		<!-- 검색창 -->
		<div class="main-div">
			<form action="" class="search-form">
				<input type="text" value="" class="search-input" 
				placeholder="search"/>
				<div class="search-history">
				</div>
			</form>
			
		</div>
		<script>
			
			const searchForm = document.querySelector('.search-form')
			const searchBox = document.querySelector('.search-input')
			const searchHistory = document.querySelector('.search-history')
			
			// var searchHistoryList = 
		
			function handleSearch(event) {
				event.preventDefault();
				const sValue = searchBox.value;	
			}
			
			function search(){
				searchForm.addEventListener("submit", handleSearch)
			}
			
			
			
		</script>
		
		
	</section>
	
	<%@ include  file = "../common/footer.jsp" %>


</body>
</html>