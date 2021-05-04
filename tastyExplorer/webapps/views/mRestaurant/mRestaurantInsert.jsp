<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>식당 등록</title>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<script src="/tastyServer/assets/js/jquery-3.6.0.min.js"></script>
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
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

#mjName {
	margin-left : 450px;
	
}

.info {
	margin-left : 70px;
	display : inline-block;
}

.inin {
	size: 100;
}

.inImg {
	margin-left : 50px;
	margin-right : 50px;
}

#submitbt {
	margin-left : 500px;
	margin-right : 50px;
	margin-bottom : 100px;
}

#ckZip:hover{
	cursor:pointer;
	background: #d4e157;
}	

</style>
</head>
<body>

	<%@ include file="../common/header.jsp"%>

	<!--  로그인 시 식당 등록 화면이 보일 수 있도록 if else 사용하기  -->

	<form action="/tastyServer/insert.att" method="post" enctype="multipart/form-data"> <!-- form 앞에 / 추가 -->
		<input type="hidden" name="attMFlevel" value="7" />

			<table id="MJName">
				<tr>
					<th>
						<h2>
							<input type="text" name="mjName" placeholder="식당 이름 작성">
						</h2> 
					</th>
				</tr>
			</table>
		<section>
			<div id="insertArea">
				<table id="MJImg">
					<span>사진은 첫번째 사진이 대표사진입니다. 좋은 사진으로 골라서 입력해주세요~</span>
					<tr>
						<th>
							<div id="contentImgArea1">
								<img src="/tastyServer/assets/images/no-image.jpg" id="titleImg" class="inImg"
									width="200" height="150" />
							</div>
						</th>
						<th>
							<div id="contentImgArea2">
								<img src="/tastyServer/assets/images/no-image.jpg" id="contentImg1" class="inImg"
									width="200" height="150" />
							</div>
						</th>
						<th>
							<div id="contentImgArea3">
								<img src="/tastyServer/assets/images/no-image.jpg" id="contentImg2" class="inImg"
									width="200" height="150" />
							</div>
						</th>
						<th>
							<div id="contentImgArea4">
								<img src="/tastyServer/assets/images/no-image.jpg" id="contentImg3" class="inImg"
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
					onchange="loadImg(this, 1);" /> 
				<input type="file" accept="image/*" name="thumbImg2" id="thumbImg2" 
					onchange="loadImg(this, 2);" /> 
				<input type="file" accept="image/*" name="thumbImg3" id="thumbImg3" 
					onchange="loadImg(this, 3);" /> 
				<input type="file" accept="image/*" name="thumbImg4" id="thumbImg4" 
					onchange="loadImg(this, 4);" />
			</div>
			<br>
			<br>
			<br>

			<div class="info">
				<fieldset>
					<legend>편의시설 유무</legend>
					<input type="checkbox" name="Convenience" value="toGo" /> 포장 <br>
					<input type="checkbox" name="Convenience" value="noSmoke" /> 흡연구역 <br>
					<input type="checkbox" name="Convenience" value="bathroom" /> 화장실 남/여 구분 <br>
					<input type="checkbox" name="Convenience" value="animal" /> 애견동반가능 <br>
					<input type="checkbox" name="Convenience" value="nokids" /> no-kids <br>
					<input type="checkbox" name="Convenience" value="parkingLot" /> 주차장 <br>
					<input type="checkbox" name="Convenience" value="reserve" /> 예약 <br>
					<input type="checkbox" name="Convenience" value="delivery" /> 배달 <br>
				</fieldset>
			</div>

			<div class="info">
				<fieldset>
					<legend>식당 정보 입력</legend>
					<table id="address">
						<tr>
							<td>우편번호 : </td>
							<td><input type="text" id="zipCode" name="zipCode" class="inin" required size="30"></td>
							<td><div id="ckZip" onclick="addrSearch();"> 검색</div></td>
						</tr>
						<tr>
							<td style="text-align : center;">주소</td>
							<td><input type="text" id="address1" name="address1" class="inin" required size="30"></td>
							<td></td>
						</tr>
						<tr>
							<td style="text-align : center;">상세주소</td>
							<td><input type="text" id="address2" name="address2" class="inin" required size="30"></td>
							<td></td>
						</tr>
						<tr>
							<td>전화번호 :</td>
							<td><input type="tel" name="tel" id="tel" class="inin" size="30"></td>
						</tr>
						<tr>
							<td>영업시간 :</td>
							<td><input type="datetime" name="openTime" id="openTime" class="inin" size="30"></td>
						</tr>
						<tr>
							<td>Break Time :</td>
							<td><input type="datetime" name="brTime" id="brTime" class="inin" size="30"></td>
						</tr>
						<tr>
							<td>휴무일 :</td>
							<td><input type="text" name="holiday" id="holiday" class="inin" size="30"></td>
						</tr>
					</table>
				</fieldset>
			</div>

			<div class="info">
				<fieldset>
					<legend>식당 간단한 소개 입력</legend>
								식당분류 :
								<select name="mjLevel">
				                     <option value="1">한식</option>
				                     <option value="2">중식</option>
				                     <option value="3">일식</option>
				                     <option value="4">양식</option>
				                     <option value="5">베트남식</option>
				                     <option value="6">카페/디저트</option>
				                     <option value="7">기타</option>
				                 </select> <br /><br />
				                 
					<textarea rows="8" cols="18" name="mjContent" placeholder="식당의 이름 및 지역, 음식명 등 식당의 소개를 간략하게 적어주세요 ~ 
							ex) 연어롭다, 이태원, 연어맛집, 혼술 등등" style="resize:none;"></textarea>
				</fieldset>
			</div>


			<!-- 메뉴 전용 servlet 으로 따로 전송하기    값을 한번에 입력받고 한번에 어떻게 보내는가  ajax?  -->
			<div class="info">
				<table id="menu" border="1">
					<caption style="font-weight: bold;">메뉴 입력</caption>
					<tr>
						<th>메뉴명</th>
						<th>가격</th>
						<th></th>
					</tr>
					<tr>
						<td><input type="text" class="menuName" name="menuNames" placeholder="메뉴명 입력"></td>
						<td><input type="number" class="menuPrice" name="menuPrices"
							placeholder="가격 입력"></td>
						<td><button onclick="menuInsert();" style="width: 26px;">+</button></td>
					</tr>
					<tr>
						<td><input type="text" class="menuName" name="menuNames" placeholder="메뉴명 입력"></td>
						<td><input type="number" class="menuPrice" name="menuPrices"
							placeholder="가격 입력"></td>
						<td><button onclick="menuInsert();" style="width: 26px;">+</button></td>
					</tr>
					<tr>
						<td><input type="text" class="menuName" name="menuNames" placeholder="메뉴명 입력"></td>
						<td><input type="number" class="menuPrice" name="menuPrices"
							placeholder="가격 입력"></td>
						<td><button onclick="menuInsert();" style="width: 26px;">+</button></td>
					</tr>
					<tr>
						<td><input type="text" class="menuName" name="menuNames" placeholder="메뉴명 입력"></td>
						<td><input type="number" class="menuPrice" name="menuPrices"
							placeholder="가격 입력"></td>
						<td><button onclick="menuInsert();" style="width: 26px;">+</button></td>
					</tr>
					<tr>
						<td><input type="text" class="menuName" name="menuNames" placeholder="메뉴명 입력"></td>
						<td><input type="number" class="menuPrice" name="menuPrices"
							placeholder="가격 입력"></td>
						<td><button onclick="menuInsert();" style="width: 26px;">+</button></td>
					</tr>
				</table>
			</div>
		</section>
		<br>
		<br>
		<button type="submit" id="submitbt"> 입력 완료 </button>
		&nbsp;
		<button type="reset"> 작성 취소 </button>
	</form>
	<aside>
		<!-- 오른쪽에 최근본 목록 구현 or 광고-->
	</aside>
	

	<%@ include file="../common/footer.jsp"%>



	<script>
	
		function menuInsert() {
			location.href = "/tastyServer/insert.mn"; // 메뉴작성 페이지로 이동
		};
	
	
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
        
        function addrSearch() {
            new daum.Postcode({
                oncomplete: function(data) {
                    // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

                    // 각 주소의 노출 규칙에 따라 주소를 조합한다.
                    // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
                    var fullAddr = ''; // 최종 주소 변수
                    var extraAddr = ''; // 조합형 주소 변수

                    // 사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
                    if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
                        fullAddr = data.roadAddress;

                    } else { // 사용자가 지번 주소를 선택했을 경우(J)
                        fullAddr = data.jibunAddress;
                    }

                    // 사용자가 선택한 주소가 도로명 타입일때 조합한다.
                    if(data.userSelectedType === 'R'){
                        //법정동명이 있을 경우 추가한다.
                        if(data.bname !== ''){
                            extraAddr += data.bname;
                        }
                        // 건물명이 있을 경우 추가한다.
                        if(data.buildingName !== ''){
                            extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                        }
                        // 조합형주소의 유무에 따라 양쪽에 괄호를 추가하여 최종 주소를 만든다.
                        fullAddr += (extraAddr !== '' ? ' ('+ extraAddr +')' : '');
                    }

                    // 우편번호와 주소 정보를 해당 필드에 넣는다.
                    $('#zipCode').val(data.zonecode); //5자리 새우편번호 사용
                    
                    $('#address1').val(fullAddr);

                    // 커서를 상세주소 필드로 이동한다.
                    $('#address2').focus();
                }
            }).open();
        };
    </script>


</body>
</html>