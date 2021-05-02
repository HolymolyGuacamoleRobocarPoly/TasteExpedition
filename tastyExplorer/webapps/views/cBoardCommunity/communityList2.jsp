<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="/myWeb/assets/js/jquery-3.6.0.min.js"></script>
<style>
	section {
		width : 900px;
		height : auto;
		/* 좌우 가운데 정렬 */
		margin-left : auto;
		margin-right: auto;
		margin-top : 50px;
		padding : 30px;
		background : black;
		color : white;
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
</style>
<title>Insert title here</title>
</head>
<body>
	<div class="contatiner">
		<div class="tableArea">
			<table align="center" id="listArea">
				<thead>
					<!-- th*6 -->
					<th width="75px;">글번호</th>
					<th width="300px;">제목</th>
					<th width="100px;">작성자</th>
					<th width="150px;">작성일</th>
					<th width="70px;">조회수</th>
					<th width="80px;">첨부파일</th>
				</thead>
				<tbody>
					<td>1</td>
					<td>2</td>
					<td>3</td>
					<td>4</td>
					<td>5</td>
					<td>6</td>
				</tbody>
			</table>
			<a href="write.jsp">글쓰기</a>
		</div>
	</div>
	
	
</body>
</html>