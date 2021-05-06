.<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "com.mj.cBoardCommunity.model.vo.*, com.mj.bComment.model.vo.*, com.mj.common.model.vo.*, java.util.*, com.mj.member.model.vo.Member"%>
<%
	Community c = (Community)request.getAttribute("Community"); //커뮤니티 가져오기
	ArrayList<BComment> clist = (ArrayList<BComment>)request.getAttribute("clist"); // 댓글 리스트 가져오기
	ArrayList<Attachment> cAttList = (ArrayList<Attachment>)request.getAttribute("cAttList"); // 첨부파일 가져오기
%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/tastyServer/assets/css/header.css" />
<script src="/tastyServer/assets/js/jquery-3.6.0.min.js"></script>
<style>
.commu {
	width : 800px;
	height: auto;
	background : white;
	color : #111;
	margin-left:auto;
	margin-right:auto;
	margin-top: 50px;
	padding: 30px;
}

.comuInfo {
	border-bottom: 0.2px solid #111;
}
#tableArea {
	background : white;
	color : black;
	height : 400px;
}

#replyArea {
	width:auto;
	color:black;;
	background:white;
	margin-left:auto;
	margin-right:auto;
	padding-bottom : 5px;
	border: 2px solid #111;
	margin-top : 10px;
}
#replyArea textArea {
	border-radius: 10px;
	resize: none;
}

table[class*=replyList] td{
	color: black;
}

.replyList1 td{ background : white; }


.button {
  position: relative;
  width: 90px;
  height: 30px;
  border: 2px solid #839903;
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
  background-color: #839903;
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


</style>


<title>커뮤니티 게시글 상세보기</title>
</head>
<body>

	<%@ include file="../common/header.jsp"%>
	
	<section class="commu">
		<h2 align="center"><%= c.getcBoardTitle() %></h2>
		
		<!-- 글 틀 -->
		<div id="tableArea">
			
					<div class="comuInfo">작성자 : <%= c.getcBoardWriter() %>
					</div>
					<div class="comuInfo">작성일 : <%= c.getcBoardDate() %>
					</div>
					<div class="comuInfo">조회수 : <%= c.getcBoardCount() %>
					</div>
					
				<% if( cAttList != null ) { %>
				<tr>
					<%-- 파일이 0이 아니면서 널이아닐때 파일을 보여주고 아니라면 없음을 보여줌 --%>
					<td>첨부 파일</td>
					<% if( cAttList.size() != 0 && cAttList.get(0).getAttMFileName() != null){ %>
					<td colspan="5">		<!-- 여기서 오류남 -->
						<a href="/tastyServer/resources/cAtt/<%= cAttList.get(0).getAttMFileName() %>" download>
						<%= cAttList.get(0).getAttMFileName() %>
						</a>
					</td>
					<% } else { %>
					<td colspan="5">		
						없음
					</td>
					<% } %>
				</tr>
					<%--<% { --%>
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
			<button class="button"  onclick="goSelectList();"><p class="button-text">돌아가기</p></button>
			<%-- 닉네임 왜 못가져오는데; --%>
			<button class="button"   onclick="goDelete();"><p class="button-text">삭제하기</p> </button>
			
			<% if (c.getcBoardWriter().equals(m.getNickName())) { %>
			<button class="button"  onclick="goUpdatePage();"><p class="button-text">수정하기</p></button>
			<% } %>
			
			<script>
				function goSelectList(){
					location.href = '/tastyServer/selectList.co';
				}
				
				function goUpdatePage(){
					location.href = '/tastyServer/updateView.co?cBoardNo=' + <%= c.getcBoardNo() %>;
				}
				
				function goDelete() {
					location.href = '/tastyServer/delete.co';
				}
			</script>
		</div>
		<!-- 돌아가기 버튼 끝 -->
		
		<!-- 댓글 달기 -->
		<div id="replyArea">
			<div id="replyWriteArea">
				<form action="<%= request.getContextPath() %>/insert.bc" method="post">
					<input type="hidden" name="mNo" value="<%= m.getmNo()%>">
					<input type="hidden" name="cboardno" value="<%= c.getcBoardNo() %>" />
					<input type="hidden" name="btype" value="2" />	 
					<table align="center">
						<tr>
							<td>댓글</td>
							<td>작성</td>
							<td>
								<textarea name="replyContent" id="replyContent" 
								          cols="80" rows="3" style=""></textarea>
							</td>
							<td>
								<button class="button"   type="submit" id="addReply">
									<p class="button-text">댓글 등록</p>
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
				<span>등록된 댓글이 없습니다.</span>
			<% } else { %>
				<% for(BComment bco : clist) { %>
				
			<table id="replySelectTable"
		      	 class="replyList<%=bco.getCommentNo()%>">
		  		<tr>
		  			<td rowspan="2"> </td>
					<td><b><%= bco.getmNo() %></b></td>
					<td><%= bco.getCommentDate() %></td>
					<td align="center">
 					<%if( m.getmNo() == bco.getmNo() ) { %>
						<input type="hidden" name="cBoardNo" value="<%=bco.getcBoardNo()%>"/>
							  
						<button class="button"   type="button" class="updateBtn" 
							onclick="updateReply(this);"><p class="button-text">수정하기</p></button>
							
						<button class="button"  type="button" class="updateConfirm"
							onclick="updateConfirm(this);"
							style="display:none;" ><p class="button-text">수정완료</p></button> &nbsp;&nbsp;
							
						<button class="button"  type="button" class="deleteBtn"
							onclick="deleteReply(this);"><p class="button-text">삭제하기</p></button>
							
					<% } %>
					</td>
				</tr>
				<tr class="comment replyList<%=bco.getCommentNo()%>">
					<td colspan="3" style="background : transparent;">
					<textarea class="reply-content" cols="88" rows="3"
					 readonly="readonly" style="resize: none;" ><%= bco.getCommentContent() %></textarea>
					</td>
				</tr>
			</table>		
				<% } %>
				<% } %>
				
			
			</div>
		<!-- 댓글 목록 끝 -->
		
		<!-- 게시글 번호 가져오기 -->
		<script>
		// 게시글 번호 가져오기
		var cboardno = '<%= c.getcBoardNo() %>';
		var btype= 2;
		
		
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
			var commentContent = $(obj).parent().parent().next().find('textarea').val();
			
			// 댓글 번호 가져오기
			var commentNo = $(obj).siblings('input').val();
			
			location.href = "/tastyServer/update.bc?"
					      + "cboardno=" + cboardno 				// 게시판 번호
					      + "&commentNo=" + commentNo			// 코멘트 번호
					      + "&commentContent=" + commentContent //코멘트내용
					      + "&btype=" + btype // 게시글 타입
	
		}			      
		
		function deleteReply(obj){
			// 댓글 번호 가져오기
			var commentNo = $(obj).siblings('input').val();
			
			//console.log("삭제 댓글 번호 : " + cno + " / " + bno);
			
			location.href="/tastyServer/delete.bc?commentNo=" + commentNo + "&cboardno=" + cboardno;
			
		}
	</script>
	</div>
		
	</section>
	<%@ include file="../common/footer.jsp"%>
</body>
</html>