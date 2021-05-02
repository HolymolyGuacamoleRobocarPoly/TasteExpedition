<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<link rel="stylesheet" href="/tastyServer/asstes/css/reservation.css" />
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>

<meta charset="UTF-8">

<style>

.site-hero > .container {
  position: relative;
  z-index: 2;
}


.site-hero.overlay {
  position: relative;
}

.site-hero.overlay:before {
  content: "";
  background: rgba(0, 0, 0, 0.5);
  width: 100%;
  z-index: 1;
  position: absolute;
  top: 0;
  left: 0;
  right: 0;
  bottom: 0;
}


</style>
<title>예약페이지</title>
</head>
<body>
	
	<section class="site-hero site-hero-innerpage overlay" data-stellar-background-ratio="0.5" style="background-image: url(images/big_image_1.jpg);">
        <div class="container">
          <div class="row align-items-center site-hero-inner justify-content-center">
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
                        <div class="col-sm-6 form-group">
                            <label for="">예약 날짜</label>
                            <div style="position: relative;">
                              <span class="fa fa-calendar icon" style="position: absolute; right: 10px; top: 10px;"></span>
                              <input type='text' class="form-control" id='Date' />
                            </div>
                            <label for=""></label>
                        </div>
                    </div>
                    <div class="row">
                      <div class="col-md-6 form-group">
                        <label for="room">인원 수</label>
                          <input type="number" id="room" class="form-control">
                      </div>
                    </div>
                    <div class="row">
                      <div class="col-md-12 form-group">
                        <label for="email">Email</label>
                        <input type="email" id="email" class="form-control ">
                      </div>
                    </div>
                    <div class="row">
                      <div class="col-md-12 form-group">
                        <label for="message" style="">요청사항</label>
                        <textarea name="message" id="message" class="form-control " cols="30" rows="8"></textarea>
                      </div>
                    </div>
                    <div class="row">
                      <div class="col-md-6 form-group">
                        <input type="submit" value="Reserve Now" class="btn btn-primary">
                      </div>
                    </div>
                  </form>
                </div>
                <div class="col-md-1"></div>
                <div class="col-md-5">
                  <h3 class="mb-5">Featured Room</h3>
                  <div class="media d-block room mb-0">
                <figure>
                  <img src="images/img_1.jpg" alt="Generic placeholder image" class="img-fluid">
                  <div class="overlap-text">
                    <span>
                      Featured Room 
                      <span class="ion-ios-star"></span>
                      <span class="ion-ios-star"></span>
                      <span class="ion-ios-star"></span>
                    </span>
                  </div>
                </figure>
                <div class="media-body">
                  <h3 class="mt-0"><a href="#">Presidential Room</a></h3>
                  <ul class="room-specs">
                    <li><span class="ion-ios-people-outline"></span> 2 Guests</li>
                    <li><span class="ion-ios-crop"></span> 22 ft <sup>2</sup></li>
                  </ul>
                  <p>Nulla vel metus scelerisque ante sollicitudin. Fusce condimentum nunc ac nisi vulputate fringilla. </p>
                  <p><a href="#" class="btn btn-primary btn-sm">Book Now From $20</a></p>
                </div>
              </div>
                </div>
          </div>
        </div>
      </section>
      <!-- END section -->
		
	<script>
		$(function() { $( "#Date" ).datepicker({ }); });
		
	
		
	</script>


	<script>
  		$( function() {
    	$('.datepicker').pickadate()
  	} );
  
  
	 </script>
</body>
</html>