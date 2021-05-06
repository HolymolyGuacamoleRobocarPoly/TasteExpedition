<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!--  기원 수정  ok  -->
<%@ page import="com.mj.mRestaurant.model.vo.*, com.mj.common.model.vo.*, java.util.*"  %>	
<%
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
    <link rel="stylesheet" href="https://unpkg.com/swiper/swiper-bundle.min.css" />
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.css"/>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous">

    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.1/dist/umd/popper.min.js" integrity="sha384-SR1sx49pcuLnqZUnnPwx6FCym0wLsk5JZuNx2bPPENzswTNFaQU1RDvt3wT4gWFG" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.min.js" integrity="sha384-j0CNLUeiqtyaRmlzUHCPZ+Gy5fQu0dQ6eZ/xAww941Ai1SxSY+0EQqNXNE6DZiVc" crossorigin="anonymous"></script>
    <script src="assets/js/jquery-3.6.0.min.js"></script>

    <link rel="stylesheet" href="/tastyServer/assets/css/header.css">
    <link rel="stylesheet" href="/tastyServer/assets/css/userprofile.css">
    <link rel="stylesheet" href="/tastyServer/assets/css/index.css">
    <link rel="stylesheet" href="/tastyServer/assets/css/footer.css">

</head>
<body>
	
<div class="section">
    <div class="circle"></div>
    <%@ include file="views/common/indexHeader.jsp" %>
    <div class="content">
     <div class="textBox">
      <h2>맛집탐험단</h2>
       <p>맛집 맛집 탐험단 맛집맛집 맛집 맛집집 맛있는거 많이 먹으면서, 살고싶다 아무리 먹어도
       살 안찌고 배불러도 원할때 다시 배고파지면 좋겠다. 먹는건 제일 좋아 친구들 모여라
       언제나 즐거워 </p> <br />
       <br />
       <br />
       
		<form action="/tastyServer/selectList.mj" method="post">
		  <div class="input-group mb-3">																											<!--  기원 수정 ok -->
		    <input type="text" class="form-control" placeholder="원하는 맛집 정보를 입력하세요" 
		    aria-label="Recipient's username" aria-describedby="button-addon2" name="keyword">
		    <button class="btn btn-outline-secondary" type="submit" id="button-addon2">맛좀볼래?</button>
		  </div>
		</form>
     </div>
     
     <div class="imgBox">
       <div class="swiper-container mySwiper">
         <div class="swiper-wrapper">
           <div class="swiper-slide"><img src="/tastyServer/assets/images/indeximg/frenchfries.jpg"></div>
           <div class="swiper-slide"><img src="/tastyServer/assets/images/indeximg/hamburger.jpg"></div>
           <div class="swiper-slide"><img src="/tastyServer/assets/images/indeximg/steak.jpg"></div>
           <div class="swiper-slide"><img src="/tastyServer/assets/images/indeximg/risotto.jpg"></div>
           <div class="swiper-slide"><img src="/tastyServer/assets/images/indeximg/떡볶이.jpg"></div>
           <div class="swiper-slide"><img src="/tastyServer/assets/images/indeximg/회세트.jpg"></div> 
         </div>
       </div>
     </div>
     
    
 </div>
 </div>
 <script src="https://unpkg.com/swiper/swiper-bundle.min.js"></script>
 <!-- Initialize Swiper -->
 <script>
  var swiper = new Swiper(".mySwiper", {
    effect: "coverflow",
    grabCursor: true,
    centeredSlides: true,
    slidesPerView: "auto",
    coverflowEffect: {
      rotate: 0,
      stretch: 0,
      depth: 200,
      modifier: 1,
      slideShadows: true,
    },
    pagination: {
      el: ".swiper-pagination",
    },
    loop: true, 
  });
 </script>
<%@ include file="views/common/footer.jsp" %>
</body>
</html> 



