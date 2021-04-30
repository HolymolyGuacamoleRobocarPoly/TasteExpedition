<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.mj.cBoardCommunity.model.vo.*"%>
<%
	Community c = (Community)request.getAttribute("Communuity");
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
		<input type="hidden" name="cboardno" value="<%= c.getcBoardNo() %>" />
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
						<%= m.getnickName() %>
						<input type="hidden" name="nickName" value="<%= m.getnickName()%>" />
					</td>
				</tr>
				<tr>
					<td>내용</td>
					<td colpan="3">
						<textarea name="cboardconetent" cols="50" rows="15"
						 		  style="resize:none;"><%= c.getcBoardContent() %>
						</textarea>
					</td>
				</tr>
			</table>
			<br />
			<div align="center">
				<button type="submit">작성 완료</button>
				<button type="button" onclick="deleteCommunityBoard();">게시글 삭제</button>
			</div>
		</form>
	</div>
	<script>
		function deleteCommunityBoard() {
			var cboardno = '  <%= c.getcBoardNo() %>  ';
			
			location.href = '/tastyServer/delete.co?cBoardNo=' + cBoardNo;
		}
	</script>
	
	<%@ include file = "../common/footer.jsp" %>
</body>
</html>