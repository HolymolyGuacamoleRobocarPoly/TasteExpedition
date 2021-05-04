.<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "com.mj.cBoardCommunity.model.vo.*, com.mj.bComment.model.vo.*, java.util.*, com.mj.member.model.vo.Member"%>
<%
	Community c = (Community)request.getAttribute("Community");

	ArrayList<BComment> clist = (ArrayList<BComment>)request.getAttribute("clist");
	
%>

<link rel="stylesheet" href="/tastyServer/assets/css/header.css" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="/tasty/assets/js.jquery-3.6.0.min.js"></script>
<title>커뮤니티 게시글 상세보기</title>
</head>
<body>

	<%@ include file="../common/header.jsp"%>
	
	<section>
		<h2 align="center"><%= c.getcBoardTitle() %></h2>
		
		<!-- 글 틀 -->
		<div id="tableArea">
			<table algin="center">
				<tr>
					<td>작성자</td>
					<td>
						<b>
							<%= c.getcBoardWriter() %>
						</b>
					</td>
					<td>작성일</td>
					<td><b><%= c.getcBoardDate() %></b></td>
					<td>조회수</td>
					<td><b><%= c.getcBoardCount() %></b></td>
				</tr>
				<% if( c.getBoardfile() != null && b.getBoardfile().length() > 0 ) { %>
				<tr>
					<td>첨부 파일</td>
					<td colspan="5">		<!-- 파일vo가 없는데 어떻게 받는거지..? -->
						<a href="/myWeb/resources/boardUploadFiles/<%= c.getBoardfile() %>" download>
						<%= c.getBoardfile() %>
						</a>
					</td>
				</tr>
				<% } %>
				<tr>
					<td colspan="6">
						<p id="content">
							<%= c.getcBoardContent() %>
						</p>
					</td>
				</tr>
			</table>
		</div>
		<!-- 글 틀 끝 -->
		
		<!-- 목록으로 돌아가는 버튼 -->
		<div align="center">
			<button onclick="goSelectList();">목록으로 돌아가기</button>
			<%-- 닉네임 왜 못가져오는데; --%>
			<% if (c.getcBoardWriter().equals(m.getUserId())) { %>
			<button onclick="goUpdatePage();">수정하기</button>
			<% } %>
			
			<script>
				function goSelectList(){
					location.href = '/tastyServer/selectList.co';
				}
				
				function goUpdatePage(){
					location.href = '/tastyServer/updateView.co?cBoardNo=' + <%= c.getcBoardNo() %>;
				}
			</script>
		</div>
		<!-- 돌아가기 버튼 끝 -->
		
		<!-- 댓글 달기 -->
		<div id="replyArea">
			<div id="replyWriteArea">
				<form action="<%= request.getContextPath() %>/insert.co" method="post">
					<input type="hidden" name="writer" value="<%= m.getUserId() %>">
					<input type="hidden" name="cboardno" value="<%= c.getcBoardNo() %>" />
					<input type="hidden" name="commentNo" value="0" />	
					<table align="center">
						<tr>
							<td>댓글 작성</td>
							<td>
								<textarea name="replyContent" id="replyContent" 
								          cols="80" rows="3"></textarea>
							</td>
							<td>
								<button type="submit" id="addReply">
									댓글 등록
								</button>
							</td>
							
						</tr>
					</table>
				</form>	
			</div>
		<!-- 댓글 달기 끝 -->
		<div class="replySelectArea">
			<!-- 댓글 목록 구현 영역 -->
			<% if (clist.size() == 0) { %>
				<span>여러분이 새 댓글의 주인공이 되어 보세요!</span>
			<% } else {
				for(BComment bco : clist) { %>
				
			<table id="replySelectTable"
		      	 class="replyList<%=bco.getcommentNo()%>">
		  		<tr>
		  			<td rowspan="2"> </td>
					<td><b><%= bco.getmNo() %></b></td>
					<td><%= bco.getCommentDate() %></td>
					<td align="center">
 					<%if(m.getUserId().equals(bco.getmNo())) { %>
						<input type="hidden" name="cno" value="<%=bco.getcBoardNo()%>"/>
							  
						<button type="button" class="updateBtn" 
							onclick="updateReply(this);">수정하기</button>
							
						<button type="button" class="updateConfirm"
							onclick="updateConfirm(this);"
							style="display:none;" >수정완료</button> &nbsp;&nbsp;
							
						<button type="button" class="deleteBtn"
							onclick="deleteReply(this);">삭제하기</button>
							
					<% } %>
					</td>
				</tr>
				<tr class="comment replyList<%=bco.getcommentNo()%>">
					<td colspan="3" style="background : transparent;">
					<textarea class="reply-content" cols="105" rows="3"
					 readonly="readonly"><%= bco.getcommentContent() %></textarea>
					</td>
				</tr>
			</table>		
			<% } %>
			</div>
		<!-- 댓글 목록 끝 -->

		<script>
		// 게시글 번호 가져오기
		var cboardno = '<%= c.getcBoardNo() %>';
		var btype= 1;
		
		function reComment(obj) {
			// 추가 완료 버튼
			$(obj).siblings('.insertConfirm').css('display', 'inline');
			
			// 현재 클릭한 버튼 숨기기
			$(obj).css('display', 'none');
			
			// 대댓글 입력공간 만들기
			var htmlForm = 
				'<tr class="comment"><td></td>'
					+'<td colspan="3" style="background : transparent;">'
						+ '<textarea class="reply-content" style="background : ivory;" cols="105" rows="3"></textarea>'
					+ '</td>'
				+ '</tr>';
			
			$(obj).parents('table').append(htmlForm);
		}
	
		
		function updateReply(obj) {
			// 현재 버튼의 위치와 가장 가까운 textarea 접근하기
			$(obj).parent().parent().next().find('textarea').removeAttr('readonly');
			
			// 수정 완료 버튼 보이게 하기
			$(obj).siblings('.updateConfirm').css('display', 'inline');
			
			// 현재 클릭한 수정 버튼 숨기기
			$(obj).css('display', 'none');
		}
		
		function updateConfirm(obj) {
			// 수정을 마친 댓글 내용 가져오기
			var content = $(obj).parent().parent().next().find('textarea').val();
			
			// 댓글 번호 가져오기
			var cno = $(obj).siblings('input').val();
			
			location.href = "/tastyServer/update.co?"
					      + "cboardno=" + cboardno // 게시글 번호
					      + "&commentNo=" + commentNo	/// 코멘트 번호
					      + "&commentContent=" + commentContent //코멘트내용
	
		
		function deleteReply(obj){
			// 댓글 번호 가져오기
			var cno = $(obj).siblings('input').val();
			
			//console.log("삭제 댓글 번호 : " + cno + " / " + bno);
			
			location.href="/tastyServer/delete.co"
			            + "?cboardno=" + cboardno + "&cboardno=" + cboardno;
			
		}
	</script>
	</div>
		
	</section>
	<%@ include file="../common/footer.jsp"%>
</body>
</html>