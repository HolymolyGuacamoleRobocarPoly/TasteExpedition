<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "com.mj.cBoardCommunity.model.vo.*, com.mj.bComment.model.vo.*, java.util.*"%>
<%
	Community c = (Community)request.getAttribute("Community");
	//ArrayList<Comment> clist = ()
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="/tasty/assets/js.jquery-3.6.0.min.js"></script>
<title>커뮤니티 게시글 상세보기</title>
</head>
<body>
	<section>
		<h2 align="center"><%= c.getcBoardTitle() %></h2>
		
		<div id="tableArea">
			<table algin="center">
				<tr>
					<td>작성자</td>
					<td>
						<b>
							<%=  %>
						</b>
					</td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					
				</tr>
			</table>
		</div>
		
	</section>

</body>
</html>