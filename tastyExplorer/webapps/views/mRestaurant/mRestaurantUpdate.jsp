<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" %>
<%@ page import="com.mj.mRestaurant.model.vo.*, com.mj.common.model.vo.*, java.util.*"  %>	
<%
				
	MRestaurant mj = (MRestaurant)request.getAttribute("mj"); // 서블릿이 보낸 MRestaurant 받아오기
	ArrayList<Attachment> mjAttList = (ArrayList<Attachment>)request.getAttribute("mjAttList"); // 서블릿이 보낸 mjAttList 받아오기
	ArrayList<Menu> menu = (ArrayList<Menu>)request.getAttribute("menu");	// 메뉴 List 받아오기 
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>식당 수정</title>
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

	<form action="/tastyServer/update.mj" method="post" enctype="multipart/form-data"> 
			<table id="MJName">
				<tr>
					<th>
						<h2>
							<input type="text" id="mjName" value="<%= mj.getmRestaurantTitle() %>">
						</h2> 
					</th>
				</tr>
			</table>
		<section>
			<div id="insertArea">
				<table id="MJImg">
					<span>사진은 첫번째 사진이 대표사진입니다. 좋은 사진으로 골라서 입력해주세요~</span>
					<tr>

						<% for (int i = 0; i < mjAttList.size(); i ++) { %>
						<th>
							<div id="contentImgArea<%=i%>">
								<img src="/tastyServer/assets/images/<%=mjAttList.get(i).getAttMFileName()%>" 
								id="contentImg<%=i%>" class="inImg" width="200" height="150" />
							</div>
							<input type="file" accept="image/*" name="thumbImg<%=i%>" id="thumbImg<%=i%>" class="fileArea"
								onchange="loadImg(this, <%=i%>);" /> 
						</th>
						
						<% } %>
						
						
						
					</tr>
				</table>
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
							<td style="text-align : center;">주소</td>
							<td><%= mj.getmRestaurantAdrress() %></td>
						</tr>
						
						<tr>
							<td>전화번호 :</td>
							<td><input type="tel" name="tel" id="tel" class="inin" size="30" value="<%= mj.getmRestaurantTel()%>"></td>
						</tr>
						<tr>
							<td>영업시간 :</td>
							<td><input type="datetime" name="openTime" id="openTime" class="inin" size="30" value="<%= mj.getOpenTime()%>"></td>
						</tr>
						<tr>
							<td>Break Time :</td>
							<td><input type="datetime" name="brTime" id="brTime" class="inin" size="30" value="<%= mj.getBrTime()%>"></td>
						</tr>
						<tr>
							<td>휴무일 :</td>
							<td><input type="text" name="holiday" id="holiday" class="inin" size="30" value="<%= mj.getHoliday()%>"></td>
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
				                 
					<textarea rows="8" cols="18" name="mjContent" style="resize:none;"> 
					<%= mj.getmRestaurantContent() %>
					</textarea>
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
					
					<%-- 
					<% for ( int i = 0; i < menu.size(); i ++ ) {  %>
					<tr>
						<td><input type="text" class="menuName" 
							value="<%= menu.get(i).getMenuName()%>"></td>
						<td><input type="number" class="menuPrice"
							value="<%= menu.get(i).getMenuPrice()%>"></td>
						<td><button onclick="menuInsert();" style="width: 26px;">+</button></td>
					</tr>
					<% } %>
					--%>
					
					
					<tr>
						<td><input type="text" class="menuName" placeholder="메뉴명 입력"></td>
						<td><input type="number" class="menuPrice"
							placeholder="가격 입력"></td>
						<td><button onclick="menuInsert();" style="width: 26px;">+</button></td>
					</tr>
					<tr>
						<td><input type="text" class="menuName" placeholder="메뉴명 입력"></td>
						<td><input type="number" class="menuPrice"
							placeholder="가격 입력"></td>
						<td><button onclick="menuInsert();" style="width: 26px;">+</button></td>
					</tr>
					<tr>
						<td><input type="text" class="menuName" placeholder="메뉴명 입력"></td>
						<td><input type="number" class="menuPrice"
							placeholder="가격 입력"></td>
						<td><button onclick="menuInsert();" style="width: 26px;">+</button></td>
					</tr>
					<tr>
						<td><input type="text" class="menuName" placeholder="메뉴명 입력"></td>
						<td><input type="number" class="menuPrice"
							placeholder="가격 입력"></td>
						<td><button onclick="menuInsert();" style="width: 26px;">+</button></td>
					</tr>
					<tr>
						<td><input type="text" class="menuName" placeholder="메뉴명 입력"></td>
						<td><input type="number" class="menuPrice"
							placeholder="가격 입력"></td>
						<td><button onclick="menuInsert();" style="width: 26px;">+</button></td>
					</tr>
				</table>
			</div>
		</section>
		<br>
		<br>
		<button type="submit" id="submitbt"> 수정 완료 </button>
		&nbsp;
		<button onclick="goMjOne();"> 수정 취소 </button>
	</form>
	<aside>
		<!-- 오른쪽에 최근본 목록 구현 or 광고-->
	</aside>
	

	<%@ include file="../common/footer.jsp"%>



	<script>
	
		function goMjOne() {
			location.href = '/tastyServer/selectOne.mj?mjNo=' + <%--= mj.getmRestaurantNo() --%>;
		}
		
		$('input:checkbox').each(function(){
			if( $(this).val() == '<%--=mj.getmRestaurantInfo()--%>')
			  $(this).prop('checked', true);
			else 
			  $(this).prop('checked', false);
		});
	
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
						$('#contentImg1').attr('src', e.target.result); 
						break;
					case 2:
						$('#contentImg2').attr('src', e.target.result);
						break;
					case 3:
						$('#contentImg3').attr('src', e.target.result);
						break;
					case 4:
						$('#contentImg4').attr('src', e.target.result);
						break;
					}
				}

				reader.readAsDataURL(img.files[0]);
			}
			
		}
        

    </script>


</body>
</html>