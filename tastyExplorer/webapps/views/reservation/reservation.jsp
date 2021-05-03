<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<link rel="stylesheet" href="/tastyServer/asstes/css/reservation.css" />
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>

<meta charset="UTF-8">

<style>
section {
	font-family: 'NEXON Lv1 Gothic OTF';
	line-height: 50px;
}

.site-hero {
	cursor: pointer;
}

.row {
	
}

.btn {
	text-align: center;
	padding-bottom: 50px;
	width: 300px;
	height: 50px;
	padding: 5px;
	border-style: none;
	border-radius: 10px;
	font-family: "NEXON Lv1 Gothic OTF";
	font-size: 20px;
	font-weight: bold;
	background-color: #fff;
	color: #7F45DD;
	cursor: pointer;
	margin: 20px;
}

.btn:hover {
	text-decoration: underline;
	background-color: antiquewhite;
}

#message {
    resize: none;
}
</style>
<title>예약페이지</title>
</head>
<body>

	<section class="site-hero site-hero-innerpage overlay"
		data-stellar-background-ratio="0.5"
		style="background-image: url(images/big_image_1.jpg);">
		<div class="container">
			<div
				class="row align-items-center site-hero-inner justify-content-center">
				<div class="col-md-12 text-center">

					<div class="mb-5 element-animate">
						<h1>예약 페이지</h1>
					</div>

				</div>
			</div>
		</div>
	</section>
	<!-- END section -->

	<section class="site-section">
		<div class="container">
			<div class="row">
				<div class="col-md-6">
					<h2 class="mb-5">Reservation Form</h2>
					<form action="#" method="post">
						<div class="row">
							<div class="col-md-6 form-group">
								<label for="people">예약자 : </label> <input type="text"
									name="people" id="form-control">
							</div>
						</div>
						<div class="row">
							<div class="col-sm-6 form-group">
								<label for="">날짜 선택 </label>
								<div style="position: relative;">
									<span class="fa fa-calendar icon"
										style="position: absolute; right: 10px; top: 10px;"></span> <input
										type='text' class="form-control" id='Date' />
								</div>
								<label for=""></label>
							</div>
						</div>
						<div class="row">
							<div class="col-sm-6 form-group">
								<label for="">시간 선택 </label>
								<div style="position: relative;">
									<span class="fa fa-calendar icon"
										style="position: absolute; right: 10px; top: 10px;"></span> <input
										type='text' class="form-control" id='Time' />
								</div>
								<label for=""></label>
							</div>
						</div>
						<div class="row">
							<div class="col-md-6 form-group">
								<label for="room">인원 선택 </label> <input type="number" id="room"
									class="form-control" min="1" style="width:50px;">명
							</div>
						</div>
						<div class="row">
							<div class="col-md-12 form-group">
								<label for="email">연락처</label> <input type="email" id="email"
									class="form-control" placeholder="전화번호를 입력해주세요.">
							</div>
						</div>
						<div class="row">
							<div class="col-md-12 form-group">
								<label for="message" style="">요청사항</label>
								<textarea name="message" id="message" class="form-control "
									cols="30" rows="8"  size="none;" placeholder="요청사항을 입력해주세요."></textarea>
							</div>
						</div>
						<div class="row">
							<div class="col-md-6 form-group">
								<input type="submit" value="예약하기" class="btn btn-primary">
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
	</section>
	<!-- END section -->

	<script>
		$(function() { $( "#Date" ).datepicker({ }); });
		
		$(function() {$('#Time').timepicker({}); });
	
		
	</script>


	<script>
  		$( function() {
    	$('.datepicker').pickadate()
  	} );
  
  
	 </script>
</body>
</html>