<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>footer</title>
    <link rel="stylesheet" href="/tastyServer/assets/css/footer.css">
    <link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">

</head>
<body>
  <div class="footwrap">
    <footer class="footer">
        <div class="container">
            <div class="row">
                <div class="footer-col">
                    <h4>company</h4>
                        <ul>
                            <li><a href="#">about us</a></li>
                            <li><a href="tel:+12345678">02-1234-1234</a></li>
                            <li><a href="mailto:knowmore@email.com">knowmore@email.com</a></li>
                            <li><a href="#">location</a></li>
                        </ul>
                </div>
                <div class="footer-col">
                    <h4>바로가기</h4>
                        <ul>
                            <li><a href="#" onclick="goCommunity();">공지사항</a></li>
                            <li><a href="#" onclick="goEvent();">이벤트</a></li>
                            <li><a href="#" onclick="goCommunity();">#소통하기</a></li>
                            <li><a href="/tastyServer/views/map/map.jsp">맛집검색</a></li>
                            <li><a href="/tastyServer/views/map/map.jsp">지도</a></li>
                        </ul>
                </div>
                <div class="footer-col">
                    <h4>예약 페이지</h4>
                        <ul>
                            <li><a href="https://youtu.be/V5WP47jUx9I">식사권 구매</a></li>
                            <li><a href="https://youtu.be/ePVF4CsQSjk">예약내역</a></li>
                            <li><a href="https://youtu.be/L3JIPSz1eJU">예약시간</a></li>
                        </ul>
                </div>
                <div class="footer-col">
                    <h4>company</h4>
                        <div class="social-links">
                            <a href="https://www.facebook.com/"><i class="fab fa-facebook-f"></i></a>
                            <a href="https://twitter.com/?lang=ko"><i class="fab fa-twitter"></i></a>
                            <a href="https://www.instagram.com/"><i class="fab fa-instagram"></i></a>
                            <a href="https://www.youtube.com/"><i class="fab fa-youtube"></i></a>
                </div>
            </div>
    	</div>
    </div>
    </footer>
    <script type="text/javascript">
		
    	
    	
	    function goEvent(){
			location.href="/tastyServer/selectList.ev?attMFlevel=4";
		}
    
    	function goCommunity() {
    		location.href="/tastyServer/selectList.co"
   		}
		
		
    	
		
		
    </script>
    <div class="copyrightText">
        <p>copyright © 2021 Online Tutorials. All Rights Reserved</p>
    </div>
    </div>
</body>
</html>