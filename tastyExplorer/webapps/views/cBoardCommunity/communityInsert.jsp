<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.mj.member.model.vo.*" %>
<%
	Member m = (Member)session.getAttribute("member");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8"> 
<title>커뮤니티 게시글 작성</title>
<script src="/tastyServer/assets/js/jquery-3.6.0.min.js"></script>
</head>
<body>
	

	
	<section>
		<h2 algin="center">게시글 작성</h2>
		
		<div class="tableArea">
			<form action="/tastyServer/insert.co" method="post"
				enctype="mulipart/form-data">
				<table>
					<tr>
						<td>제목</td>
						<td colspan="3"><input type="text" name="ctitle" size="80" />
						</td>
					</tr>
					<tr>
						<td>작성자</td>
						<td colspan="3">
							<%= m.getNickName() %> 
							<input type="hidden" name="nickName" value="<%= m.getNickName() %>">
						</td>
					</tr>
					<tr>
						<td>첨부파일</td>
						<td colspan="3"><input type="file" name="file" id="file" />
						</td>
					</tr>
					<tr>
						<td>내용</td>
						<td colspan="3"><textarea name="Ccontent" cols="50" rows="20"
								style="resize: none;"></textarea></td>
			 		</tr>
				</table>
				<div align="center">
					<button>작성 완료</button>
					<button>작성 취소</button>
				</div>
			</form>
		</div>
	</section>
	<%@ include  file = "../common/footer.jsp" %>

</body>
</html>