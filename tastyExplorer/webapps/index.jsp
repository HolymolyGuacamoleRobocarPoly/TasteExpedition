<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!--  기원 수정  ok  -->
<%@ page import="com.mj.mRestaurant.model.vo.*, com.mj.common.model.vo.*, java.util.*"  %>	
<%
				// Object --> Board
	ArrayList<MRestaurant> mjList = (ArrayList<MRestaurant>)request.getAttribute("mjList"); // 서블릿이 보낸 mjList 받아오기 
	ArrayList<Attachment> mjAttList = (ArrayList<Attachment>)request.getAttribute("mjAttList"); // 서블릿이 보낸 mjAttList 받아오기
%>  
<!--  기원 수정  ok  -->    
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>맛좀볼래?</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.css"/>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous">

    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.1/dist/umd/popper.min.js" integrity="sha384-SR1sx49pcuLnqZUnnPwx6FCym0wLsk5JZuNx2bPPENzswTNFaQU1RDvt3wT4gWFG" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.min.js" integrity="sha384-j0CNLUeiqtyaRmlzUHCPZ+Gy5fQu0dQ6eZ/xAww941Ai1SxSY+0EQqNXNE6DZiVc" crossorigin="anonymous"></script>
    <script src="assets/js/jquery-3.6.0.min.js"></script>

    <link rel="stylesheet" href="/tastyServer/assets/css/index.css">
    <link rel="stylesheet" href="/tastyServer/assets/css/header.css">
    <link rel="stylesheet" href="/tastyServer/assets/css/userprofile.css">
    <link rel="stylesheet" href="/tastyServer/assets/css/carousel.css">
    <link rel="stylesheet" href="/tastyServer/assets/css/footer.css">

</head>
<body>
	
<%@ include file="views/common/header.jsp" %>
	

    <div class="title">
        <div class="background-video">
        <video src="/tastyServer/assets/video/backgroundVideo.mp4"></video>
            <form action="/tastyServer/selectList.mj" method="post">
        <h1>
            오늘 무엇을 먹을지 고민하는 여러분을 위해
                <div class="input-group mb-3">																											
                    <input type="text" class="form-control" placeholder="맛집 정보를 입력하세요" aria-label="Recipient's username" aria-describedby="button-addon2" name="keyword">
                    <button class="btn btn-outline-secondary" type="submit" id="button-addon2">맛좀볼래?</button>
                </div>
        </h1>
            </form>
        </div>
    </div>

<div class="container"> <h2>추천 맛집</h2>
    <div class="row">
        <div class="col-md-12">
            <div id="carouselExampleIndicators" class="carousel slide" data-bs-ride="carousel" data-bs-interval="false">
                <div class="carousel-indicators">
                    <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="0" class="active" aria-current="true" aria-label="Slide 1"></button>
                    <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="1" aria-label="Slide 2"></button>
                    <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="2" aria-label="Slide 3"></button>
                </div>
                  <div class="carousel-inner">
                
				<!--  기원 수정중  삭제 No  -->   
                        	
                        	<%--  --%>
                       
                        
					<% if (mjList != null) { %>	
						
					<div class="carousel-item active">
                        <div class="row">
							<% for( int i = 0; i < mjList.size(); i ++) { %>
	                            <div class="col-md-4" id="<%= mjList.get(i).getmRestaurantNo() %>">
	                                <div class="single-box">
	                                	<% for ( int j = 0; j < 1; ) { %>
	                                    	<div class="img-area"><img src="/tastyServer/assets/images/
	                                    	<%= mjAttList.get(i).getAttMFileName() %>" alt="식당사진"></div>
	                                	<% } %>
	                                    <div class="img-text">
	                                        <h2><%= mjList.get(i).getmRestaurantTitle() %></h2>
	                                        <p><%= mjList.get(i).getmRestaurantContent() %></p>
	                                    </div>
	                                </div>
	                            </div>
                            <% } %>       
                        </div>
                    </div>
					<% } else { %>   
				<!--  기원 수정중  삭제 No  -->    
				
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
                    <% } %>
                    
                  </div>
            </div>
        </div>
    </div>
</div>


<%@ include file="views/common/footer.jsp" %>
	<script>
	
	<% if (mjList != null ) {%>
		$('.col-md-4').on('click', function(){
			var mjNo = $(this).attr('id');
			
			location.href = '/tastyServer/selectOne.mj?mjNo=' + mjNo;
			

		});
	<% } %>	
	
	</script>
</body>
</html> 



