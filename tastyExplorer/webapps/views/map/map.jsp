<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="com.mj.mRestaurant.model.vo.*, com.mj.common.model.vo.*, java.util.*"  %>	
<% 
	ArrayList<MRestaurant> mjList = (ArrayList<MRestaurant>)request.getAttribute("mjList"); // 서블릿이 보낸 mjList 받아오기 
	ArrayList<Attachment> mjAttList = (ArrayList<Attachment>)request.getAttribute("mjAttList"); // 서블릿이 보낸 mjAttList 받아오기
	String keyword = (String)request.getAttribute("keyword");
%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>맛좀볼래 지도</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous">
<link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.1/dist/umd/popper.min.js" integrity="sha384-SR1sx49pcuLnqZUnnPwx6FCym0wLsk5JZuNx2bPPENzswTNFaQU1RDvt3wT4gWFG" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.min.js" integrity="sha384-j0CNLUeiqtyaRmlzUHCPZ+Gy5fQu0dQ6eZ/xAww941Ai1SxSY+0EQqNXNE6DZiVc" crossorigin="anonymous"></script>

<link rel="stylesheet" href="/tastyServer/assets/css/header.css">
<link rel="stylesheet" href="/tastyServer/assets/css/userprofile.css">
<link rel="stylesheet" href="/tastyServer/assets/css/map.css">
<link rel="stylesheet" href="/tastyServer/assets/css/searchbar.css">
<link rel="stylesheet" href="/tastyServer/assets/css/carousel.css">
<link rel="stylesheet" href="/tastyServer/assets/css/footer.css">

<style>
.mjList {
	width: 270px;
    height: 260px;
    display: inline-block;
    text-align: left;
    background-color: #fff;
    color: #111;
    border-radius: 15px;
    margin-left : 100px;
    margin-right : 100px;
}
.mjList:hover {
	cursor: pointer;
}
</style>

</head>
<body>
<%@ include file="../common/header.jsp" %>



<div class="map_wrap">
    <div id="map" style="margin-left:16%;width:80%;height:700px;position:relative;overflow:hidden;"></div>

    <div id="menu_wrap" class="bg_white">
        <div class="option">
            <div>
                <form onsubmit="searchPlaces(); return false;">
                    <input type="text" value="" id="keyword" size="15" placeholder="장소, 키워드 검색"> 
                    <button type="submit"><i class="fas fa-search"></i></button> 
                </form>
            </div>
        </div>
        <hr>
        <ul id="placesList"></ul>
        <div id="pagination"></div>
    </div>
</div>
	<form action="/tastyServer/selectList.mj" method="post">
		<div class="searchbar">
			  <div class="input-group mb-3">																											<!--  기원 수정 ok -->
			    <input type="text" class="form-control" placeholder="키워드로 맛집 검색하기" aria-label="Recipient's username" aria-describedby="button-addon2" name="keyword">
			    <button class="btn btn-outline-secondary" type="submit" id="button-addon2">맛좀볼래?</button>
			  </div>
		</div>
	</form>		
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=145829b4f38274b6165d84e3615be1bf&libraries=services"></script>
<script>
// 마커를 담을 배열입니다
var markers = [];

var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
    mapOption = {
        center: new kakao.maps.LatLng(37.566826, 126.9786567), // 지도의 중심좌표
        level: 3 // 지도의 확대 레벨
    };  

// 지도를 생성합니다    
var map = new kakao.maps.Map(mapContainer, mapOption); 

// 장소 검색 객체를 생성합니다
var ps = new kakao.maps.services.Places();  

// 검색 결과 목록이나 마커를 클릭했을 때 장소명을 표출할 인포윈도우를 생성합니다
var infowindow = new kakao.maps.InfoWindow({zIndex:1});

// 키워드로 장소를 검색합니다
searchPlaces();

// 키워드 검색을 요청하는 함수입니다
function searchPlaces() {

    var keyword = document.getElementById('keyword').value;

   

    // 장소검색 객체를 통해 키워드로 장소검색을 요청합니다
    ps.keywordSearch( keyword, placesSearchCB); 
}

// 장소검색이 완료됐을 때 호출되는 콜백함수 입니다
function placesSearchCB(data, status, pagination) {
    if (status === kakao.maps.services.Status.OK) {

        // 정상적으로 검색이 완료됐으면
        // 검색 목록과 마커를 표출합니다
        displayPlaces(data);

        // 페이지 번호를 표출합니다
        displayPagination(pagination);

    } else if (status === kakao.maps.services.Status.ZERO_RESULT) {

        alert('검색 결과가 존재하지 않습니다.');
        return;

    } else if (status === kakao.maps.services.Status.ERROR) {

        alert('검색 결과 중 오류가 발생했습니다.');
        return;

    }
}

// 검색 결과 목록과 마커를 표출하는 함수입니다
function displayPlaces(places) {

    var listEl = document.getElementById('placesList'), 
    menuEl = document.getElementById('menu_wrap'),
    fragment = document.createDocumentFragment(), 
    bounds = new kakao.maps.LatLngBounds(), 
    listStr = '';
    
    // 검색 결과 목록에 추가된 항목들을 제거합니다
    removeAllChildNods(listEl);

    // 지도에 표시되고 있는 마커를 제거합니다
    removeMarker();
    
    for ( var i=0; i<places.length; i++ ) {

        // 마커를 생성하고 지도에 표시합니다
        var placePosition = new kakao.maps.LatLng(places[i].y, places[i].x),
            marker = addMarker(placePosition, i), 
            itemEl = getListItem(i, places[i]); // 검색 결과 항목 Element를 생성합니다

        // 검색된 장소 위치를 기준으로 지도 범위를 재설정하기위해
        // LatLngBounds 객체에 좌표를 추가합니다
        bounds.extend(placePosition);

        // 마커와 검색결과 항목에 mouseover 했을때
        // 해당 장소에 인포윈도우에 장소명을 표시합니다
        // mouseout 했을 때는 인포윈도우를 닫습니다
        (function(marker, title) {
            kakao.maps.event.addListener(marker, 'mouseover', function() {
                displayInfowindow(marker, title);
            });

            kakao.maps.event.addListener(marker, 'mouseout', function() {
                infowindow.close();
            });

            itemEl.onmouseover =  function () {
                displayInfowindow(marker, title);
            };

            itemEl.onmouseout =  function () {
                infowindow.close();
            };
        })(marker, places[i].place_name);

        fragment.appendChild(itemEl);
    }

    // 검색결과 항목들을 검색결과 목록 Elemnet에 추가합니다
    listEl.appendChild(fragment);
    menuEl.scrollTop = 0;

    // 검색된 장소 위치를 기준으로 지도 범위를 재설정합니다
    map.setBounds(bounds);
}

// 검색결과 항목을 Element로 반환하는 함수입니다
function getListItem(index, places) {

    var el = document.createElement('li'),
    itemStr = '<span class="markerbg marker_' + (index+1) + '"></span>' +
                '<div class="info">' +
                '   <h5>' + places.place_name + '</h5>';

    if (places.road_address_name) {
        itemStr += '    <span>' + places.road_address_name + '</span>' +
                    '   <span class="jibun gray">' +  places.address_name  + '</span>';
    } else {
        itemStr += '    <span>' +  places.address_name  + '</span>'; 
    }
                 
      itemStr += '  <span class="tel">' + places.phone  + '</span>' +
                '</div>';           

    el.innerHTML = itemStr;
    el.className = 'item';

    return el;
}

// 마커를 생성하고 지도 위에 마커를 표시하는 함수입니다
function addMarker(position, idx, title) {
    var imageSrc = 'https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/marker_number_blue.png', // 마커 이미지 url, 스프라이트 이미지를 씁니다
        imageSize = new kakao.maps.Size(36, 37),  // 마커 이미지의 크기
        imgOptions =  {
            spriteSize : new kakao.maps.Size(36, 691), // 스프라이트 이미지의 크기
            spriteOrigin : new kakao.maps.Point(0, (idx*46)+10), // 스프라이트 이미지 중 사용할 영역의 좌상단 좌표
            offset: new kakao.maps.Point(13, 37) // 마커 좌표에 일치시킬 이미지 내에서의 좌표
        },
        markerImage = new kakao.maps.MarkerImage(imageSrc, imageSize, imgOptions),
            marker = new kakao.maps.Marker({
            position: position, // 마커의 위치
            image: markerImage 
        });

    marker.setMap(map); // 지도 위에 마커를 표출합니다
    markers.push(marker);  // 배열에 생성된 마커를 추가합니다

    return marker;
}

// 지도 위에 표시되고 있는 마커를 모두 제거합니다
function removeMarker() {
    for ( var i = 0; i < markers.length; i++ ) {
        markers[i].setMap(null);
    }   
    markers = [];
}

// 검색결과 목록 하단에 페이지번호를 표시는 함수입니다
function displayPagination(pagination) {
    var paginationEl = document.getElementById('pagination'),
        fragment = document.createDocumentFragment(),
        i; 

    // 기존에 추가된 페이지번호를 삭제합니다
    while (paginationEl.hasChildNodes()) {
        paginationEl.removeChild (paginationEl.lastChild);
    }

    for (i=1; i<=pagination.last; i++) {
        var el = document.createElement('a');
        el.href = "#";
        el.innerHTML = i;

        if (i===pagination.current) {
            el.className = 'on';
        } else {
            el.onclick = (function(i) {
                return function() {
                    pagination.gotoPage(i);
                }
            })(i);
        }

        fragment.appendChild(el);
    }
    paginationEl.appendChild(fragment);
}

// 검색결과 목록 또는 마커를 클릭했을 때 호출되는 함수입니다
// 인포윈도우에 장소명을 표시합니다
function displayInfowindow(marker, title) {
    var content = '<div style="padding:5px;z-index:1;">' + title + '</div>';

    infowindow.setContent(content);
    infowindow.open(map, marker);
}

 // 검색결과 목록의 자식 Element를 제거하는 함수입니다
function removeAllChildNods(el) {   
    while (el.hasChildNodes()) {
        el.removeChild (el.lastChild);
    }
}
</script>


			
<% if (mjList != null) { %>

				<!--  기원 수정중  삭제 No  -->   
<h2 style="text-align:center;"> '<%= keyword %>' 검색 결과 </h2>     <br /><br /><br />       
    
		<% for( int i = 0; i < mjList.size(); i ++) { %>
	        <div class="mjList" id="<%= mjList.get(i).getmRestaurantNo() %>">
                	<div class="imgArea">
                		<img src="/tastyServer/resources/mjAtt/<%=mjAttList.get(i).getAttMFileName()%>.jpg" 
                		alt="식당사진" style="width:400px; height:300px;">
                	</div>
	                <div class="textArea">
	                    <h2><%= mjList.get(i).getmRestaurantTitle() %></h2>
	                    <p><%= mjList.get(i).getmRestaurantContent() %></p>
	                </div>
	        </div>
	    <% } %>       
<% } else { %>
<div class="caro-container"> <h2>추천 맛집</h2>
    <div class="row">
        <div class="col-md-12">
            <div id="carouselExampleIndicators" class="carousel slide" data-bs-ride="carousel" data-bs-interval="false">
                <div class="carousel-indicators">
                    <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="0" class="active" aria-current="true" aria-label="Slide 1"></button>
                    <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="1" aria-label="Slide 2"></button>
                    <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="2" aria-label="Slide 3"></button>
                </div>
                  <div class="carousel-inner">
                  
                    <div class="carousel-item active">
                        <div class="row">
							<div class="col-md-4">
	                                <div class="single-box">
	                                    <div class="img-area"><img src="/tastyServer/assets/images/연어롭다.jpg" alt=""></div>
	                                    <div class="img-text">
	                                        <h2>연어롭다</h2>
	                                        <p>홍대 - 일식</p>
	                                    </div>
	                                </div>
	                            </div>
                            <div class="col-md-4">
                                <div class="single-box">
                                    <div class="img-area"><img src="/tastyServer/assets/images/10_소녀방앗간 백반.JPG" alt=""></div>
                                    <div class="img-text">
                                        <h2>소녀방앗간</h2>
                                        <p>성수 - 한식</p>
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-4">
                                <div class="single-box">
                                    <div class="img-area"><img src="/tastyServer/assets/images/4_여의도 다희 칵테일.jpg" alt=""></div>
                                    <div class="img-text">
                                        <h2>다희</h2>
                                        <p>강남 - 칵테일바</p>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="carousel-item">
                        <div class="row">
                            <div class="col-md-4">
                                <div class="single-box">
                                    <div class="img-area"><img src="/tastyServer/assets/images/13_와우신내떡_떡볶이튀김세트.JPG" alt=""></div>
                                    <div class="img-text">
                                        <h2>신내떡볶이</h2>
                                        <p>노량진 - 분식</p>
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-4">
                                <div class="single-box">
                                    <div class="img-area"><img src="/tastyServer/assets/images/1_후라토식당 규카츠.jpg" alt=""></div>
                                    <div class="img-text">
                                        <h2>후라토식당</h2>
                                        <p>광화문 - 일식</p>
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-4">
                                <div class="single-box">
                                    <div class="img-area"><img src="/tastyServer/assets/images/3_오레노라멘 라멘.jpg" alt=""></div>
                                    <div class="img-text">
                                        <h2>오레노라멘</h2>
                                        <p>상수 - 일식</p>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="carousel-item">
                        <div class="row">
                            <div class="col-md-4">
                                <div class="single-box">
                                    <div class="img-area"><img src="/tastyServer/assets/images/5_바스버거 햄버거.jpg" alt=""></div>
                                    <div class="img-text">
                                        <h2>바스버거</h2>
                                        <p>성수 - 수제버거</p>
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-4">
                                <div class="single-box">
                                    <div class="img-area"><img src="/tastyServer/assets/images/8_듁스커피 커피.JPG" alt=""></div>
                                    <div class="img-text">
                                        <h2>듀스커피</h2>
                                        <p>상수 - 카페</p>
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-4">
                                <div class="single-box">
                                    <div class="img-area"><img src="/tastyServer/assets/images/15_구복만두_만두세트.JPG" alt=""></div>
                                    <div class="img-text">
                                        <h2>구복만두</h2>
                                        <p>숙대입구 - 중식</p>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    
                    
                  </div>
            </div>
        </div>
    </div>
</div>

<% } %> 
 
<script>
	
		$('.mjList').on('click', function(){
			var mjNo = $(this).attr('id');
			
			location.href = '/tastyServer/selectOne.mj?mjNo=' + mjNo;
		});
	
</script>

<%@ include file="../common/footer.jsp" %>
</body>
</html>