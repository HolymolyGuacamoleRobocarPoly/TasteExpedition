<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>restaurantDetail</title>
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
</style>
</head>
<body>

	<%@ include file="../common/header.jsp"%>

	<header>
		<table id="MJName">
			<tr>
				<th>
					<h2>(연어롭다)</h2> <!-- 맛집 이름 -->
				</th>
				<th>(별점이미지)</th>
				<th colspan="2" align="left">(별점) <!-- review 에서 가져온 별점의 평균-->
				</th>
			</tr>
		</table>
	</header>
	<section>
		<table id="MJImg">
			<tr>
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
				<td>(리뷰수)</td>
				<td>(찜하기카운트)</td>
				<!-- <td>정보수정</td>  (관리자 페이지에서만 보이게 )-->
			</tr>
		</table>
		<div class="infor">
			<table id="icon">
				<tr>
					<!-- if else 로  있으면 띄우고 없으면 빈공간-->
					<td>(포장가능)</td>
					<td>(금연구역)</td>
					<td>(화장실 분리)</td>
					<td>(애견동반)</td>
					<td>(no-kids)</td>
					<td>(주차가능)</td>
					<td>(예약가능)</td>
					<td>(배달가능)</td>
				</tr>
			</table>
		</div>

		&nbsp;&nbsp;&nbsp;

		<div class="infor">
			<!-- 오른쪽으로 절대 위치 설정 -->
			<table id="address">
				<!-- ul or table choice-->
				<tr>
					<td>주소 :</td>
					<td>서울 마포구</td>
					<!-- 맛집 주소 입력-->
				</tr>
				<tr>
					<td>전화번호 :</td>
					<td>02-111-2222</td>
					<!-- 맛집 전화번호 입력-->
				</tr>
				<tr>
					<td>영업시간 :</td>
					<!-- 맛집 영업시간 입력-->
					<td rowspan="2">매일 12:00 - 02:00 <br> 월요일 휴무
					</td>
				</tr>
				<tr></tr>
				<tr>
					<td>Break Time :</td>
					<td>15:00 - 16:00</td>
					<!-- 맛집 break time -->
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
					<td>생연어 모듬</td>

					<td>33,000원</td>
				</tr>
				<tr>
					<td>생연어 사시미</td>
					<td>23,000원</td>
				</tr>
				<tr>
					<td>생연어 타다끼</td>
					<td>18,000원</td>
				</tr>
				<tr>
					<td>구운연어와 오일파스타</td>
					<td>18,000원</td>
				</tr>
				<tr>
					<td>명란 로제 파스타</td>
					<td>18,000원</td>
				</tr>
			</table>
		</div>


	</section>
	<aside>
		<!-- 오른쪽에 최근본 목록 구현 or 광고-->
	</aside>
	<footer>
		<div class="rh" id="foot">
			<h2 id="reviewHead" style="width: 1100px;">리뷰 페이지</h2>
		</div>
		&nbsp;
		<div class="rh">
			<!-- review 연결 -->
			<button onclick="goReview();">리뷰 쓰기</button>
		</div>

		<div id="reviewImgPack">
			<div class="imgArea">
				<img src="../resources/images/item.jpg" alt="식당 사진입니다."
					width="100px" height="60px">
			</div>
			<div class="imgArea">
				<img src="../resources/images/item.jpg" alt="식당 사진입니다."
					width="100px" height="60px">
			</div>
			<div class="imgArea">
				<img src="../resources/images/item.jpg" alt="식당 사진입니다."
					width="100px" height="60px">
			</div>
			<div class="imgArea">
				<img src="../resources/images/item.jpg" alt="식당 사진입니다."
					width="100px" height="60px">
			</div>
		</div>




		<div id="reviewHash">
			<div class="reviewHashTag" id="hash1">#연어맛집</div>
			&nbsp;
			<div class="reviewHashTag" id="hash2">#곰</div>
			&nbsp;
			<div class="reviewHashTag" id="hash3">#베어그릴스</div>
			&nbsp;
			<div class="reviewHashTag" id="hash4">#깔끔</div>
			&nbsp;
			<div class="reviewHashTag" id="hash5">#단골</div>
			&nbsp;
		</div>

		<textarea name="" id="" cols="80" rows="10" style="resize: none;">
            연어가 정말 맛있고 싱싱합니다. 노르웨이 강에서 먹던 그 맛이 납니다. 
            둘이 먹다 하나 죽어도 모를 맛입니다. 잘 먹고 잘~ 놀다 갑니다.  
        </textarea>



	</footer>

	<%@ include file="../common/footer.jsp"%>



	<script>
		function goReview() {
			location.href = "/tastyServer/reviewInsert.re"; // 리뷰작성 페이지로 이동 
		}

		var slideIndex = 1;
		showDivs(slideIndex);

		function plusDivs(n) {
			showDivs(slideIndex += n);
		}

		function showDivs(n) {
			var i;
			var x = document.getElementsByClassName("mySlides");
			if (n > x.length) {
				slideIndex = 1
			}
			if (n < 1) {
				slideIndex = x.length
			}
			for (i = 0; i < x.length; i++) {
				x[i].style.display = "none";
			}
			x[slideIndex - 1].style.display = "block";
		}
	</script>



</body>
</html>