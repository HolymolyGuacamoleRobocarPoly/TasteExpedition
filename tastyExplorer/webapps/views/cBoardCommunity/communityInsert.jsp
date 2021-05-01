<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="/myWeb/assets/js/jquery-3.6.0.min.js"></script>
<style>
section {
	width: 900px;
	height: auto;
	/* 좌우 가운데 정렬 */
	margin-left: auto;
	margin-right: auto;
	margin-top: 50px;
	padding: 30px;
	background: black;
	color: white;
}

.tableArea {
	width: 800px;
	height: auto;
	margin-left: auto;
	margin-right: auto;
}

table {
	padding: 15px;
	border: 1px solid yellow;
	text-align: center;
}
</style>
<title>Insert title here</title>
</head>
<body>
	<div class="contatiner">
		<div class="tableArea">
			<form method="post">
				<table align="center" id="listArea" actio="wrtieAction.jsp">
					<thead>
						<!-- th*6 -->
						<tr>
							<th colsapn="2">글쓰기 양식</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td><input type="text" class="form-control"
								placehilder="글제목" name="cboardtitle" maxlength="50" /></td>
							<td><textArea type="text" class="form-control"
									placehilder="글제목" name="cboardcontent" maxlength="50" /></textArea></td>
						</tr>
					</tbody>
				</table>
				<input type="submit" value="글쓰기" />
			</form>
			<a href="write.jsp">글쓰기</a>
		</div>
	</div>


</body>
</html>