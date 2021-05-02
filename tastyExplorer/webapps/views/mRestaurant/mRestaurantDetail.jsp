<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.mj.mRestaurant.model.vo.*, com.mj.review.model.vo.*, com.mj.common.model.vo.*, java.util.*"  %>	
<%
				// Object --> Board
	MRestaurant mj = (MRestaurant)request.getAttribute("mj"); // 서블릿이 보낸 MRestaurant 받아오기
	ArrayList<Review> rlist = (ArrayList<Review>)request.getAttribute("rlist"); // 서블릿이 보낸 ReviewList 받아오기 
	ArrayList<Attachment> mjAttList = (ArrayList<Attachment>)request.getAttribute("mjAttList"); // 서블릿이 보낸 mjAttList 받아오기
	Menu menu = (Menu)request.getAttribute("menu");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>식당 자세히 보기</title>
<script src="/tastyServer/assets/js/jquery-3.6.0.min.js"></script>
<style>
#head {
	width: auto;
	height: 150px;
	background: rgb(245, 217, 93);
}

#mjName {
	margin-left: 50px;
    margin-right: 30px;
}

#logo {
	width: 200px;
	height: 50px;
	background: beige;
	border-radius: 30%;
}

.infor {
	display: inline-block;
}

#reviewHead {
	background: rgb(235, 235, 166);
	text-align: center;
	padding-top : 15px;
	padding-bottom : 15px;
}

.rh {
	display: inline-block;
}

.main {
	width: 500px;
	height: 250px;
	border: 2px solid black;
}

.imgArea {
	margin: 10px;
	/* float: left; */
	display: inline-block;
}

#reviewHash {
	margin-left : 310px;
}

.reviewHashTag {
	display: inline-block;
	margin-left : 30px;
}

#reviewImgPack #reviewHash {
	display: inline-block;
}

.conv {
	margin-left : 10px;
}

.info {
	display : inline-block;
}

#infoDetail {
	margin-left : 70px;
	margin-right : 50px;
}

#menu {
	margin-left : 50px;
}

.starImg {
	margin-top : 20px;
	
}

#stSco {
	margin-left : 20px;
}

#rebtn {
    width: 100px;
    height: 35px;
    background: mintcream;
}

.rImg {
	margin-left : 50px;
}

#rcontent {
	margin-left : 300px;
}

#reviewImgPack {
	margin-left : 100px;
}

#mjUpdateGo {
	margin-left : 40px;
	margin-right : 10px;
	width : 60px;
	height : 30px;
	background: mintcream;
}

#mjDeleteGo {
	width : 60px;
	height : 30px;
	background: mintcream;
}
</style>
</head>
<body>

	<%@ include file="../common/header.jsp"%>

	
		<table id="MJName">
			<tr>
				<th>
					<h1 id="mjName"><%--= mj.getmRestaurantTitle() --%>연어롭다</h1> <!-- 맛집 이름 -->
				</th>
				<%--
				<!-- 별점 평균 -->
				<% int sum = 0; 
				   double avr = 0;
					for (int i = 0; i < rlist.size(); i++ ) {
						sum += rlist.get(i).getrScore(); 
					} 	avr = sum / rlist.size(); %>
				 --%>
				<th >
					<%--  별점 이미지 반복문
					<!-- 반복문으로 avr 크기만큼 색 채우고 나머지는  -->
					<% for( int i = 0; i < 5; i++) {%>
						<% if ( ) { %>
							<img src="/tastyServer/assets/images/stardot.png" alt="별점사진"  
								width="50px" height="50px"/>
						<% } else { %>
							<img src="/tastyServer/assets/images/stardotx.png" alt="별점사진"  
								width="50px" height="50px"/>
						<% } %>
					<% } %>
					--%>
					<!--  임시 작성 공간 -->
						<img src="/tastyServer/assets/images/stardot.png" alt="별점사진"  
							width="40px" height="40px" class="starImg" />
						<img src="/tastyServer/assets/images/stardot.png" alt="별점사진"  
							width="40px" height="40px" class="starImg" />
						<img src="/tastyServer/assets/images/stardot.png" alt="별점사진"  
							width="40px" height="40px" class="starImg" />
						<img src="/tastyServer/assets/images/stardot.png" alt="별점사진"  
							width="40px" height="40px" class="starImg" />
						<img src="/tastyServer/assets/images/stardotx.png" alt="별점사진"  
							width="40px" height="40px" class="starImg"/>
					<!--  임시 작성 공간 -->
						
				</th> 
				<th colspan="2">
					 <!-- review 에서 가져온 별점의 평균-->
					<span id="stSco"><%--= avr --%>(4.4)</span>
				</th>
				<th>
					<button onclick="mjUpdateGo();" id="mjUpdateGo">정보 수정</button>
					<button onclick="mjDeleteGo();" id="mjDeleteGo"> 삭제 </button>
				</th>
			</tr>
		</table>
		
	
	<div class="bdiv">	
	<section>
		<table id="MJImg">
			<tr>
				<%-- 
				<% for ( int i = 0; i < mjAttList.size(); i++) { %>
                   	<th><img src="/tastyServer/assets/images/<%= mjAttList.get(i).getAttMFileName() %>" 
                   	alt="식당 사진입니다." width="300px" height="200px"></th>
               	<% } %>
				--%>
				
				<th><img src="/tastyServer/assets/images/no-image.jpg" alt="식당 사진입니다."
					width="300px" height="200px"></th>
				<th><img src="/tastyServer/assets/images/no-image.jpg" alt="식당 사진입니다."
					width="300px" height="200px"></th>
				<th><img src="/tastyServer/assets/images/no-image.jpg" alt="식당 사진입니다."
					width="300px" height="200px"></th>
				<th><img src="/tastyServer/assets/images/no-image.jpg" alt="식당 사진입니다."
					width="300px" height="200px"></th>
			</tr>
		</table>
		<table id="overview">
			<tr>
				<%--
				<td>(리뷰수)<%= rlist.size()%></td>
				<td>(찜하기카운트) <%= mj.getmRestaurantLike() %></td>
				--%>
			</tr>
		</table>
		<div class="info">
			<table id="icon">
				<tr>
					<!-- if else 로  있으면 띄우고 없으면 빈공간-->
					<%--if ( ) --%>
					
					<td><img src="/tastyServer/assets/images/take out2.png" alt="식당 편의시설"
					width="50px" height="50px" name="Convenience" id="toGo" class="conv"></td>
					<td><img src="/tastyServer/assets/images/no-smoking.png" alt="식당 편의시설"
					width="50px" height="50px" name="Convenience" id="noSmoke" class="conv"></td>
					<td><img src="/tastyServer/assets/images/toilet1.png" alt="식당 편의시설"
					width="50px" height="50px" name="Convenience" id="bathroom" class="conv"></td>
					<td><img src="/tastyServer/assets/images/dog.png" alt="식당 편의시설"
					width="50px" height="50px" name="Convenience" id="animal" class="conv"></td>
					<td><img src="/tastyServer/assets/images/no-kids.png" alt="식당 편의시설"
					width="50px" height="50px" name="Convenience" id="noKids" class="conv"></td>
					<td><img src="/tastyServer/assets/images/parking zone.png" alt="식당 편의시설"
					width="50px" height="50px" name="Convenience" id="parkingLot" class="conv"></td>
					<td><img src="/tastyServer/assets/images/reserve.png" alt="식당 편의시설"
					width="50px" height="50px" name="Convenience" id="reserve" class="conv"></td>
					<td><img src="/tastyServer/assets/images/delivery.png" alt="식당 편의시설"
					width="50px" height="50px" name="Convenience" id="delivery" class="conv"></td>
				</tr>
			</table>
		</div>

		&nbsp;&nbsp;&nbsp;

		<div class="info">
			<table id="infoDetail">
				<tr>
					<td>주소 :</td>
					<td><%--= mj.getmRestaurantAdrress() --%>서울 마포구</td>
				</tr>
				<tr>
					<td>전화번호 :</td>
					<td><%--= mj.getmRestaurantTel() --%>02-111-2222</td>
				</tr>
				<tr>
					<td>영업시간 :</td>
					<td>매일 12:00 - 02:00</td>
				</tr>
				
				<!--  값을 어떻게 받아올지 고민  -->
				<tr>
					<td>Break Time : </td>
					<td>15:00 - 16:00</td>
				</tr>
				<tr>
					<td>휴무일 :</td>
					<td>월요일 휴무</td>
				</tr>
			</table>
		</div>

		&nbsp;&nbsp;&nbsp;

		<!-- 절대 위치 설정 -->
		<div class="info">
			<table id="menu" border="1">
				<caption style="font-weight: bold;">메뉴</caption>
				<tr>
					<th>메뉴명</th>
					<th>가격</th>
				</tr>
				<tr>
					<td><%--= menu.getMenuName --%>생연어 모듬</td>
					<td><%--= menu.getMenuPrice --%>33,000원</td>
				</tr>
				<tr>
					<td><%--= menu.getMenuName --%>생연어 사시미</td>
					<td><%--= menu.getMenuPrice --%>23,000원</td>
				</tr>
				<tr>
					<td><%--= menu.getMenuName --%>생연어 타다끼</td>
					<td><%--= menu.getMenuPrice --%>18,000원</td>
				</tr>
				<tr>
					<td><%--= menu.getMenuName --%>구운연어와 오일파스타</td>
					<td><%--= menu.getMenuPrice --%>18,000원</td>
				</tr>
				<tr>
					<td><%--= menu.getMenuName --%>명란 로제 파스타</td>
					<td><%--= menu.getMenuPrice --%>18,000원</td>
				</tr>
			</table>
		</div>


	</section>
	<aside>
		<!-- 오른쪽에 최근본 목록 구현 or 광고-->
	</aside>
	
		<div class="rh" id="foot">
			<h2 id="reviewHead" style="width: 1100px;">리뷰 페이지</h2>
		</div>
		&nbsp;
		
		<div class="rh">
			<!-- review 연결 -->
			<button onclick="reviewGo()" id="rebtn">리뷰 쓰기</button>
		</div>
	
		

		<!-- 첨부파일 연결해서 사진 불러오기  -->
		<div id="reviewImgPack">
			<div class="imgArea">
				<img src="/tastyServer/assets/images/no-image.jpg" alt="식당 사진입니다."
					width="150px" height="90px" class="rImg">
			</div>
			<div class="imgArea">
				<img src="/tastyServer/assets/images/no-image.jpg" alt="식당 사진입니다."
					width="150px" height="90px" class="rImg">
			</div>
			<div class="imgArea">
				<img src="/tastyServer/assets/images/no-image.jpg" alt="식당 사진입니다."
					width="150px" height="90px" class="rImg">
			</div>
			<div class="imgArea">
				<img src="/tastyServer/assets/images/no-image.jpg" alt="식당 사진입니다."
					width="150px" height="90px" class="rImg">
			</div>
		</div>


	
		<!--  리뷰 페이지 연결해서 list 받아오기  -->
		<%-- 
		<% for ( int i = 0; i < rlist.size(); i++) { %>
		
		<% } %>
		--%>
		<div id="reviewHash">
			<div class="reviewHashTag" id="hash1">#연어맛집</div>
			<div class="reviewHashTag" id="hash2">#곰</div>
			
			<!-- 
			&nbsp;
			<div class="reviewHashTag" id="hash2">#곰</div>
			&nbsp;
			<div class="reviewHashTag" id="hash3">#베어그릴스</div>
			&nbsp;
			<div class="reviewHashTag" id="hash4">#깔끔</div>
			&nbsp;
			<div class="reviewHashTag" id="hash5">#단골</div>
			&nbsp;
			 -->
		</div>

		<textarea name="rContent" id="rcontent" cols="80" rows="10" style="resize: none;">
           <%--= rlist.getrContent() --%>
            연어가 정말 맛있고 싱싱합니다. 노르웨이 강에서 먹던 그 맛이 납니다. 
            둘이 먹다 하나 죽어도 모를 맛입니다. 잘 먹고 잘~ 놀다 갑니다.  
        </textarea>
	
	</div>



	<%@ include file="../common/footer.jsp"%>


	<script>
	
		function reviewGo() {
			
			location.href = '/tastyServer/views/review/reviewWrite.jsp' <%-- + "&mjNo=" + = mj.getmRestaurantNo() --%>;
		}
	
		function mjUpdateGo() {
					
			location.href = '/tastyServer/update.mj?mjNo='  <%--= mj.getmRestaurantNo() --%>;
			
		}
		
		function mjDeleteGo() {
			
			location.href = '/tastyServer/delete.mj?mjNo='  <%--= mj.getmRestaurantNo() --%>;
			
		}
		
		
		
		
	</script>



</body>
</html>