<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>restaurantInsert</title>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
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

[id*=ImgArea]:hover {
	cursor: pointer;
}
</style>
</head>
<body>

	<%@ include file="../common/header.jsp"%>

	<!--  로그인 시 식당 등록 화면이 보일 수 있도록 if else 사용하기  -->

	<form action="/tastyServer/insert.mj" method="get" enctype="multipartform-data">
		<input type="hidden" name="userId" value="<%=m.getMno() %>" />
			<table id="MJName">
				<tr>
					<th>
						<h2>
							<input type="text" id="mjName" placeholder="식당 이름 작성">
						</h2> <!-- 맛집 이름 -->
					</th>
				</tr>
			</table>

		<section>
			<div id="insertArea">
				<%--   <!-- <input type="hidden" name="userId" value="<%=m.getUserId() %>" /> --> --%>
				<table id="MJImg">
					<tr>
						<th>
							<div id="contentImgArea1">
								<img src="/tastyServer/assets/images/no-image.jpg" id="contentImg1"
									width="200" height="150" />
							</div>
						</th>
						<th>
							<div id="contentImgArea2">
								<img src="/tastyServer/assets/images/no-image.jpg" id="contentImg2"
									width="200" height="150" />
							</div>
						</th>
						<th>
							<div id="contentImgArea3">
								<img src="/tastyServer/assets/images/no-image.jpg" id="contentImg3"
									width="200" height="150" />
							</div>
						</th>
						<th>
							<div id="contentImgArea4">
								<img src="/tastyServer/assets/images/no-image.jpg" id="contentImg4"
									width="200" height="150" />
							</div>
						</th>
					</tr>
				</table>
			</div>
			<div class="fileArea" id="fileArea">
				<!--  첨부 사진 추가 영역 -->
				<!-- (input:file#thumbImg$[name=thumbImg$ onchange=loadImg(this,$)])*4  -->
				<input type="file" accept="image/*" name="thumbImg1" id="thumbImg1"
					onchange="loadImg(this, 1);" /> <input type="file"
					accept="image/*" name="thumbImg2" id="thumbImg2"
					onchange="loadImg(this, 2);" /> <input type="file"
					accept="image/*" name="thumbImg3" id="thumbImg3"
					onchange="loadImg(this, 3);" /> <input type="file"
					accept="image/*" name="thumbImg4" id="thumbImg4"
					onchange="loadImg(this, 4);" />
			</div>
			<br>
			<br>
			<br>

			<div class="infor">
				<fieldset>
					<legend>편의시설 유무</legend>
					<input type="checkbox" name="hobby" value="bathroom" /> 화장실 남/여 구분
					<br> <input type="checkbox" name="hobby" value="toGo" /> 포장 <br>
					<input type="checkbox" name="hobby" value="smoke" /> 흡연구역 <br>
					<input type="checkbox" name="hobby" value="animal" /> 애견동반가능 <br>
					<input type="checkbox" name="hobby" value="nokids" /> no-kids <br>
					<input type="checkbox" name="hobby" value="parkingLot" /> 주차장 <br>
					<input type="checkbox" name="hobby" value="reserve" /> 예약 <br>
					<input type="checkbox" name="hobby" value="delivery" /> 배달 <br>
				</fieldset>
			</div>

			&nbsp;&nbsp;&nbsp;

			<div class="infor">
				<!-- 오른쪽으로 절대 위치 설정 -->
				<fieldset>
					<legend>식당 정보 입력</legend>
					<table id="address">
						<!-- ul or table choice-->
						<tr>
							<td>주소 :</td>
							<td><input type="text" name="address" id="address"></td>
							<!-- 맛집 주소 입력-->
						</tr>
						<tr>
							<td>전화번호 :</td>
							<td><input type="tel" name="tel" id="tel"></td>
							<!-- 맛집 전화번호 입력-->
						</tr>
						<tr>
							<td>영업시간 :</td>
							<!-- 맛집 영업시간 입력-->
							<td><input type="datetime" name="openTime" id="openTime"></td>
						</tr>
						<tr>
							<td>Break Time :</td>
							<td><input type="datetime" name="brTime" id="brTime"></td>
							<!-- 맛집 break time 입력-->
						</tr>
						<tr>
							<td>휴무일 :</td>
							<!-- 맛집 영업시간 입력-->
							<td><input type="text" name="holiday" id="holiday"></td>
						</tr>
					</table>
				</fieldset>
			</div>

			&nbsp;&nbsp;&nbsp;


			<!-- 메뉴 전용 servlet 으로 따로 전송하기    값을 한번에 입력받고 한번에 어떻게 보내는가  ajax?  -->
			<div class="infor">
				<table id="menu" border="1">
					<caption style="font-weight: bold;">메뉴 입력</caption>
					<tr>
						<th>메뉴명</th>
						<th>가격</th>
						<th></th>
					</tr>
					<tr>
						<td><input type="text" class="meenuName" placeholder="메뉴명 입력"></td>
						<td><input type="number" class="menuPrice"
							placeholder="가격 입력"></td>
						<td><button onclick="menuInsert();">+</button></td>
					</tr>
					<tr>
						<td><input type="text" class="meenuName" placeholder="메뉴명 입력"></td>
						<td><input type="number" class="menuPrice"
							placeholder="가격 입력"></td>
						<td><button onclick="menuInsert();">+</button></td>
					</tr>
					<tr>
						<td><input type="text" class="meenuName" placeholder="메뉴명 입력"></td>
						<td><input type="number" class="menuPrice"
							placeholder="가격 입력"></td>
						<td><button onclick="menuInsert();">+</button></td>
					</tr>
					<tr>
						<td><input type="text" class="meenuName" placeholder="메뉴명 입력"></td>
						<td><input type="number" class="menuPrice"
							placeholder="가격 입력"></td>
						<td><button onclick="menuInsert();">+</button></td>
					</tr>
					<tr>
						<td><input type="text" class="meenuName" placeholder="메뉴명 입력"></td>
						<td><input type="number" class="menuPrice"
							placeholder="가격 입력"></td>
						<td><button onclick="menuInsert();">+</button></td>
					</tr>
				</table>
			</div>
		</section>
		<br>
		<br>
		<button type="submit">전송 완료</button>
		&nbsp;
		<button type="reset">작성 취소</button>
	</form>
	<aside>
		<!-- 오른쪽에 최근본 목록 구현 or 광고-->
	</aside>
	

	<%@ include file="../common/footer.jsp"%>



	<script>
        $('#contentImgArea1').on('click', function() { 
			$('#thumbImg1').click();
		});
		
		$('#contentImgArea2').on('click', function() {
			$('#thumbImg2').click();
		});
		
		$('#contentImgArea3').on('click', function() {
			$('#thumbImg3').click();
		});
		
		$('#contentImgArea4').on('click', function() {
			$('#thumbImg4').click();
		});
		
		$('#fileArea').hide();

        function loadImg(img, num) {
			if (img.files && img.files[0]) {

				var reader = new FileReader();

				reader.onload = function(e) {

					switch (num) {
					case 1: 
						$('#titleImg').attr('src', e.target.result); 
						break;
					case 2:
						$('#contentImg1').attr('src', e.target.result);
						break;
					case 3:
						$('#contentImg2').attr('src', e.target.result);
						break;
					case 4:
						$('#contentImg3').attr('src', e.target.result);
						break;
					}
				}

				reader.readAsDataURL(img.files[0]);
			}
			
		}
    </script>


</body>
</html>