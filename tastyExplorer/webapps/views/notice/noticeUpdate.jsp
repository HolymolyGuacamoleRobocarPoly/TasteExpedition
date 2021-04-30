<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="com.mj.notice.model.vo.*"%>
<%
	Notice n = (Notice)request.getAttribute("Notice");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="/tastyServer/assets/js/jquery-3.6.0.min.js"></script>
<title>공지사항 수정페이지</title>
</head>
<body>

	<h2 align="center">게시글 수정</h2>

	<div class="tableArea">
		<form action="/tastyServer/update.no" method="post"
			enctype="multipart/form-data">
			<input type="hidden" name="nno" value="<%= n.getnNo() %>" />
			<table>
				<tr>
					<td>제목</td>
					<td colspan="3"><input type="text" name="ntitle" size="40"
						value="<%= n.getnTitle() %>" /></td>
				</tr>
				<tr>
					<td>작성자</td>
					<td colspan="3">
						<%= m.getnickName() %>
						<input type="hidden" name="nickName" value="<%= m.getnickName %>" />
					</td>
				</tr>
				<tr>
					<td>내용</td>
					<td colpan="3">
						<textarea name="cboardconetent" cols="50" rows="15"
						 		  style="resize:none;"><%= n.getnContent() %>
						</textarea>
					</td>
				</tr>
			</table>
			<br />
			<div align="center">
				<button type="submit">작성 완료</button>
				<button type="button" onclick="deleteNotice();">게시글 삭제</button>
			</div>
			<script>
			function deleteCommunityBoard() {
			var nno = '<%= n.getnNo() %>';
			
			location.href = '/tastyServer/delete.no=nno=' + nno;
		}
		</script>

		</form>
	</div>

</body>
</html>