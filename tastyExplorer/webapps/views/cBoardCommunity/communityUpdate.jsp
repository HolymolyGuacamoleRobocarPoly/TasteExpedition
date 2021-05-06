<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.mj.cBoardCommunity.model.vo.*"%>
<%
	Community c = (Community)request.getAttribute("Community");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="/tastyServer/assets/js/jquery-3.6.0.min.js"></script>
<title>게시글 수정</title>
</head>
<body>
	<%@ include file = "../common/header.jsp" %>
	<h2 align="center">게시글 수정</h2>
	
	<div class="tableArea">
		<form action="/tastyServer/update.co" method="post" enctype="multipart/form-data">
		<input type="hidden" name="cBoardNo" value="<%= c.getcBoardNo() %>" />
			<table>
				<tr>
					<td>제목</td>
					<td colspan="3">
						<input type="text" name="ctitle" 
						       size="40" value="<%= c.getcBoardTitle() %>" />
					</td>
				</tr>
				<tr>
					<td>작성자</td>
					<td colspan="3">
						<%= c.getmNickname() %>
						<input type="hidden" name="nickName" value="<%= c.getmNickname()%>" />
					</td>
				</tr>
				<tr>
					<td>내용</td>
					<td colpan="3">
						<textarea name="cboardconetent" cols="50" rows="15"
						 		  style="resize:none;"><%= c.getcBoardContent() %></textarea>
					</td>
				</tr>
			</table>
			<br />
			<div align="center">
				<button type="submit">수정 완료</button>
				<button type="button" onclick="selectOne();">수정 취소</button>
				<button type="button" onclick="deleteCommunityBoard();">게시글 삭제</button>
			</div>
		</form>
	</div>
	<script>
		function deleteCommunityBoard() {
			var cBoardNo = '<%= c.getcBoardNo() %>';
			
			location.href = '/tastyServer/delete.co?cBoardNo=' + cBoardNo;
		}
		
		function selectOne() {
			location.href = "/tastyServer/selectOne.co?cboardno=" + cboardno;
			
		}
 	</script>
	
	<%@ include file = "../common/footer.jsp" %>
</body>
</html>