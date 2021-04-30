<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.mj.mRestaurant.model.vo.*, com.mj.review.model.vo.*, java.util.*"  %>	
<%
				// Object --> Board
	MRestaurant mj = (MRestaurant)request.getAttribute("mj"); // 서블릿이 보낸 MRestaurant 받아오기
	ArrayList<Review> rlist = (ArrayList<Review>)request.getAttribute("rlist"); // 서블릿이 보낸 ReviewList 받아오기 
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

.reviewHashTag {
	display: inline-block;
}

#reviewImgPack #reviewHash {
	display: inline-block;
}
.bdiv {
	
}

</style>
</head>
<body>

	<%@ include file="../common/header.jsp"%>

	
		<table id="MJName">
			<tr>
				<th>
					<h2><%--= mj.getmRestaurantTitle() --%>(연어롭다)</h2> <!-- 맛집 이름 -->
				</th>
				<th>
					(별점이미지)<!-- review 에서 가져온 별점에 맞춘 이미지 -->
				</th> 
				<th colspan="2" align="left">
					(별점) <!-- review 에서 가져온 별점의 평균-->
				<%-- 
				<% int sum = 0; 
				   
					for (int i = 0; i < rlist.size(); i++ ) {
						sum += rlist.get(i).getrScore(); 
						
					} int avr = sum / rlist.size(); %>
				--%>
				</th>
			</tr>
		</table>
	
	<div class="bdiv">	
	<section>
		<table id="MJImg">
			<tr>
				<!-- 식당 첨부파일 불러오는 코드 작성  -->
				
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
				<td>(리뷰수)<%= rlist.size() + 1 %></td>
				<td>(찜하기카운트) <%= mj.getmRestaurantLike() %></td>
				--%>
				<!-- <td>정보수정</td>  (관리자 페이지에서만 보이게 )-->
			</tr>
		</table>
		<div class="infor">
			<table id="icon">
				<tr>
					<!-- if else 로  있으면 띄우고 없으면 빈공간-->
					<%--if ( ) --%>
					
					<td><img src="/tastyServer/assets/images/take out2.png" alt="식당 편의시설"
					width="50px" height="50px" name="mjInfo" id="toGo"></td>
					<td><img src="/tastyServer/assets/images/no-smoking.png" alt="식당 편의시설"
					width="50px" height="50px" name="mjInfo" id="noSmoke"></td>
					<td><img src="/tastyServer/assets/images/toilet1.png" alt="식당 편의시설"
					width="50px" height="50px" name="mjInfo" id="toilet"></td>
					<td><img src="/tastyServer/assets/images/dog.png" alt="식당 편의시설"
					width="50px" height="50px" name="mjInfo" id="dog"></td>
					<td><img src="/tastyServer/assets/images/no-kids.png" alt="식당 편의시설"
					width="50px" height="50px" name="mjInfo" id="noKids"></td>
					<td><img src="/tastyServer/assets/images/parking zone.png" alt="식당 편의시설"
					width="50px" height="50px" name="mjInfo" id="parkingLot"></td>
					<td><img src="/tastyServer/assets/images/reserve.png" alt="식당 편의시설"
					width="50px" height="50px" name="mjInfo" id="reserve"></td>
					<td><img src="/tastyServer/assets/images/delivery.png" alt="식당 편의시설"
					width="50px" height="50px" name="mjInfo" id="delivery"></td>
				</tr>
			</table>
		</div>

		&nbsp;&nbsp;&nbsp;

		<div class="infor">
			<!-- 오른쪽으로 절대 위치 설정 -->
			<table id="address">
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
		<div class="infor">
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
			<button onclick="goReview();">리뷰 쓰기</button>
		</div>

		<!-- 첨부파일 연결해서 사진 불러오기  -->
		<div id="reviewImgPack">
			<div class="imgArea">
				<img src="/tastyServer/assets/images/no-image.jpg" alt="식당 사진입니다."
					width="150px" height="90px">
			</div>
			<div class="imgArea">
				<img src="/tastyServer/assets/images/no-image.jpg" alt="식당 사진입니다."
					width="150px" height="90px">
			</div>
			<div class="imgArea">
				<img src="/tastyServer/assets/images/no-image.jpg" alt="식당 사진입니다."
					width="150px" height="90px">
			</div>
			<div class="imgArea">
				<img src="/tastyServer/assets/images/no-image.jpg" alt="식당 사진입니다."
					width="150px" height="90px">
			</div>
		</div>


	
		<!--  리뷰 페이지 연결해서 list 받아오기  -->
		<%-- 
		<% for ( int i = 0; i < rlist.size(); i++) { %>
		
		<% } %>
		--%>
		<div id="reviewHash">
			<div class="reviewHashTag" id="hash1">#연어맛집</div>
		
			
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

		<textarea name="" id="" cols="80" rows="10" style="resize: none;">
           <%--= rlist.getrContent() --%>
            연어가 정말 맛있고 싱싱합니다. 노르웨이 강에서 먹던 그 맛이 납니다. 
            둘이 먹다 하나 죽어도 모를 맛입니다. 잘 먹고 잘~ 놀다 갑니다.  
        </textarea>
	
	</div>



	<%@ include file="../common/footer.jsp"%>


	<script>
		function goReview() {
			location.href = "/tastyServer/views/review/reviewWrite.jsp"; // 리뷰작성 페이지로 이동 
		}
		
		

		
	</script>



</body>
</html>