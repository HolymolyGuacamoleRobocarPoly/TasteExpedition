<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.mj.cBoardCommunity.model.vo.*"%>
<%
	Community c = (Community)request.getAttribute("Community");
%>
<!DOCTYPE html>
<html>
<style>
.button {
  position: relative;
  width: 90px;
  height: 30px;
  border: 2px solid #d4e157;
  border-radius: 10px;
  background-color: #fff;
  cursor: pointer;
  overflow: hidden;
}
.button::after {
  content: "";
  position: absolute;
  top: 0;
  left: 0;
  background-color: #d4e157;
  width: 100%;
  height: 100%;
  z-index: 1;
  transform: scale(0, 1);
  transform-origin: 50% 0%;
  /* transform: translateX(100%); */
  transition: transform 0.35s;
}

.button-text {
  position: relative;
  z-index: 2;
  transition: color 0.35s;
  color : black;
}
.button:hover::after {
  transform: scale(1, 1);
}
.button:hover .button-text {
  color: white;
}

title {
	text-align : center;
}
.tableArea {
	width : 800px;
	height: auto;
	background : white;
	color : #111;
	margin-left:auto;
	margin-right:auto;
	margin-top: 50px;
	padding: 30px;
	

}

.margin {
	margin-top : 20px;
}

.rpArea {
	text-align : center;
}

</style>

<head>
<meta charset="UTF-8">
<script src="/tastyServer/assets/js/jquery-3.6.0.min.js"></script>
<title >게시글 수정</title>
</head>
<body>
	<%@ include file = "../common/header.jsp" %>
	<h2 align="center" class="margin">게시글 수정</h2>
	
	<div class="tableArea">
		<form action="/tastyServer/update.co" method="post" enctype="multipart/form-data">
		<input type="hidden" name="cBoardNo" value="<%= c.getcBoardNo() %>" />
			<table class="center">
				<tr>
					<td>제목  </td>
					<td colspan="3">
						<input type="text" name="cBoardTitle" 
						       size="40" value="<%= c.getcBoardTitle() %>" />
					</td>
				</tr>
				<tr>
					<td>작성자  </td>
					<td colspan="3">
						"<%= c.getmNickname() %>"
						<input type="hidden" name="nickName" value="<%= c.getmNickname()%>" />
					</td>
				</tr>
				<tr>
					<td>내용</td>
					<td colpan="3">
						<textarea name="cBoardContent" cols="80" rows="20"
						 		  style="resize:none;"><%= c.getcBoardContent() %></textarea>
					</td>
				</tr>
			</table>
			<br />
			<div align="center" class="rpArea">
				<button type="submit" class="button">수정 완료</button>
				<button type="button"  class="button" onclick="deleteCommunityBoard();"><p class="button-text">게시글 삭제</p></button>
			</div>
		</form>
	</div>
	<script>
		// 게시글 삭제 버튼
		function deleteCommunityBoard() {
			var cBoardNo = '<%= c.getcBoardNo() %>';
			
			location.href = '/tastyServer/delete.co?cBoardNo=' + cBoardNo;
		}
		
	
	
 	</script>
	
	<%@ include file = "../common/footer.jsp" %>
</body>
</html>