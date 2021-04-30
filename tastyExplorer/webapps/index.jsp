<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>맛좀볼래?</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.css"/>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous">
    <script src="/assets/js/jquery-3.6.0.min.js"></script>
    <link rel="stylesheet" href="/tastyServer/assets/css/index.css">
    <link rel="stylesheet" href="/tastyServer/assets/css/header.css">
    <link rel="stylesheet" href="/tastyServer/assets/css/userprofile.css">
    <link rel="stylesheet" href="/tastyServer/assets/css/footer.css">
</head>
<body>
	
<%@ include file="views/common/header.jsp" %>

<div class="mapbox">
	
    <div class="title">
        <h1>
            오늘 무엇을 먹을지 고민하는 여러분을 위해
            <form action="">
                <div class="input-group mb-3">
                    <input type="text" class="form-control" placeholder="맛집 정보를 입력하세요" aria-label="Recipient's username" aria-describedby="button-addon2">
                    <button class="btn btn-outline-secondary" type="button" id="button-addon2">맛좀볼래?</button>
                </div>
            </form>
        </h1>
    </div>
	
	<!-- 지도를 표시할 div 입니다 -->
	<div id="map" style="width:100%;height:500px;"></div>
	
	<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=145829b4f38274b6165d84e3615be1bf"></script>
	<script>
	var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
	    mapOption = { 
	        center: new kakao.maps.LatLng(37.510935, 126.981733), // 지도의 중심좌표
	        level: 6 // 지도의 확대 레벨
	    };
	
	// 지도를 표시할 div와  지도 옵션으로  지도를 생성합니다
	var map = new kakao.maps.Map(mapContainer, mapOption); 
	</script>
</div>


<%@ include file="views/common/footer.jsp" %>


</body>
</html> 