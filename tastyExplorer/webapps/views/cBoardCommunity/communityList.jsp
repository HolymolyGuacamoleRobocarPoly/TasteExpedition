<%@page import="jdk.internal.misc.FileSystemOption"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.mj.cBoardCommunity.model.vo.*, java.util.*"%>
<%
ArrayList<Community> list = (ArrayList<Community>) request.getAttribute("list");
PageInfo pi = (PageInfo) request.getAttribute("pi");

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
<link rel="stylesheet" href="/tastyServer/assets/css/community.css" />
<script src="/tastyServer/assets/js/jquery-3.6.0.min.js"></script>

<title>#소통해요</title>

</head>
<body>
	<%@ include file="../common/header.jsp"%>
	<!-- 게시글 목록임 -->
	
	<section>
		<h2 align="center">#소통해요</h2>
		<button class="button" onclick="location.href='views/cBoardCommunity/communityInsert.jsp'">
			<h3 class="button-text">작성하기</h3>
		</button>
		<!-- 게시판 목록 -->
		<div class="tableArea">
			<table align="center" id="listArea">
				<tr>
					<th width="75px;">No</th>
					<th width="400px;">제목</th>
					<th width="75px;">팀원수</th>
					<th width="100px;">작성자</th>
					<th width="150px;">작성일</th>
					<th width="70px;">조회수</th>
				</tr>
				<% for (Community c : list) { %>
				<tr>
					<td id="<%=c.getcBoardNo()%>"><%=c.getcBoardNo()%></td>
					<td><%=c.getcBoardTitle()%></td>
					<td><%=c.getcBoardTeam()%></td>
					<td><%=c.getcBoardWriter()%></td>
					<td><%=c.getcBoardDate()%></td>
					<td><%=c.getcBoardCount()%></td>
				</tr>
				<% } %>
			</table>
		</div>
		<!-- 게시판 목록끝 -->

		<!-- 게시물 클릭시 -->
		<% if (m != null) { %>	
		<div class="btnArea" align="center">
			<br>
			<!--<button href='views/cBoardCommunity/communityInsert.jsp'>작성하기</button>-->
			<script>
				$('#listArea td').on('mouseenter', function() {
					$(this).parent().css({'background' : 'white',
										  'cursor' : 'pointer',
										  'color' : 'gray'});  
				}).on('mouseout', function(){
					$(this).parent().css({'background' : 'white',
											'color' : 'black'});
				}).on('click', function(){
					var cboardno = $(this).parent().children().first().attr('id');
					
					console.log(cboardno);
					location.href = "/tastyServer/selectOne.co?cboardno=" + cboardno;
					
					
				});
			</script>
			<%	} %>
		</div>
		<!-- 게시물 클릭 끝 -->

		<!-- 페이지 부분 -->
		<div class="pagingArea" align="center">
			<button
				onclick="location.href='/tastyServer/selectList.co?currentPage=1'">
				&lt;&lt;</button>
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
			<button
				onclick="location.href='/tastyServery/selectList.co?currentPage=<%=mx%>'">
				&gt;&gt;</button>

		</div>
		<!-- 페이지 부분끝 -->
		
		
		<!-- 검색창 -->
		<div class="main-div">
			<form action="" class="search-form">
				<input type="text" value="검색" class="search-input"
					placeholder="search" />
				<div class="search-history"></div>
			</form>

		</div>
		<!-- 검색창끝-->
		
		
		<!-- 검색창 테스트 -->
		<form action="" class="table-form">
			<fieldset>
				<legend class="hidden">#소통해요 검색필드</legend>
				<label class="hidden">검색 분류</label>
				<select name="f" >
					<option ${(param.f == "cBoardTitle")?"selected":"" }selected value="cBoardNo">제목</option>
					<option ${(param.f == "cBoardWriter")?"selected":"" } value="cBoardWriter">작성자</option>
				</select>
				<label class="hidden">검색어</label>
				<!-- 파라미터에 q가 있으면 출력해달라 -->
				<input type="text" name="q" value="${param.q}" />
				<input class="btn btn-search" type="submit" value="검색"  />
			</fieldset>
		</form>
		
		
		
		<!-- 프로필 -->
		<div class="card">
			<div class="card-container">
				<div class="upper-container">
					<div class="image-container">
						<img src="/tastyServer/assets/images/boo.png">
					</div>
				</div>
				<div class="lower-container">
					<div>
						<h3>효자동불효자</h3>
						<br>
						<h4>Lv.금수저</h4>
					</div>
					<div>
						<p>냠냠쩝쩝</p>
					</div>
					<div>
						<a href="/tastyServer/views/member/mypage.jsp"  class="btn">view profile</a> 
					</div>

				</div>
			</div>
		</div>
		<!-- 프로필 끝 -->
	
		<!--script 부분 -->
		<script>
			//작성하기로 이동하는 함수
			function goInsert() {
				location.href="/tastyServer/Insert.co";
			}
			
			// 프로필 마이페이지 누르면 이동하는 함수
			function goProfile() {
				loaction.href="tastyServer/views/member/mypage.jsp"
			}
			
			
			// 프로필 예약 내역 누르면 예약페이지로 이동하는 함수
			
			
			//btn 함수
			
		</script>
		<!-- 이script 부분 끝-->
	</section>

	<%@ include file="../common/footer.jsp"%>


</body>
</html>