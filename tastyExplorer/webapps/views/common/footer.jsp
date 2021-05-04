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
                            <li><a href="#" onclick="goNotice();">공지사항</a></li>
                            <li><a href="#">문의하기</a></li>
                            <li><a href="#" onclick="goCommunity();">#소통하기</a></li>
                            <li><a href="#">맛집검색</a></li>
                            <li><a href="#">지도</a></li>
                        </ul>
                </div>
                <div class="footer-col">
                    <h4>online shop</h4>
                        <ul>
                            <li><a href="/tastyServer/views/payment/pay.jsp">식사권 구매</a></li>
                            <li><a href="#">예약하기</a></li>
                            <li><a href="#">뭘 넣징</a></li>
                        </ul>
                </div>
                <div class="footer-col">
                    <h4>company</h4>
                        <div class="social-links">
                            <a href="#"><i class="fab fa-facebook-f"></i></a>
                            <a href="#"><i class="fab fa-twitter"></i></a>
                            <a href="#"><i class="fab fa-instagram"></i></a>
                            <a href="#"><i class="fab fa-youtube"></i></a>
                </div>
            </div>
    	</div>
    </div>
    </footer>
    <script type="text/javascript">
		function goCommunity() {
    		location.href="/tastyServer/selectList.co"
   		}
    	
		function goNotice() {
    		location.href="/tastyServer/notice.co"
   		}
		
    </script>
    <div class="copyrightText">
        <p>copyright © 2021 Online Tutorials. All Rights Reserved</p>
    </div>
    </div>
</body>
</html>