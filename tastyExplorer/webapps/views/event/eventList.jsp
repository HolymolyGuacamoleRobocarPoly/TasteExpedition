<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Bootstrap 4</title>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">

<style>
p { margin:20px 0px; }

.header {
	text-align: center;
	margin-right: -10%;
	padding-top: 8px;
	padding-bottom: 8px;
	margin-left: -10%;
	border-radius: 15px;
	border: none;
	color : #c8c8c8;
}

button {
  height: 40px;
  font-size: 15px;
  text-transform: uppercase;
  letter-spacing: 2.5px;
  font-weight: 600; 
  background-color: #FFF0F0;
  border: none;
  border-radius: 5px;
  /*box-shadow: 0px 8px 15px rgba(0, 0, 0, 0.1);*/
  transition: all 0.3s ease 0s;
  cursor: pointer;
  outline: none;
  padding: 0 13px;
  display: inline;
  margin-bottom: 10px;  
  cursor: pointer;
  float: right;   
  margin-right: 13px;
  cursor: pointer;
  }

button:hover {
  background-color: #FFBEBE;
  box-shadow: 0px 15px 20px rgba(255, 234, 255, 0.4);
  color: #fff;
  transform: translateY(-7px);
}


</style>
</head>
<body>
  
   <div class="header">
          <h1>Event1</h1> <hr>
       </div>
    <div class="container">
      <div class="row">
        
        <div class="col-4">
        <!-- 시퀀스 이벤트 번호 가져오기 -->
          <p>이벤트 번호</p>
          <div class="card">
          <!-- 관리자가 등록한 사진 가져오기 -->
            <img src="/tastyServer/assets/images/no-image.jpg" alt="" class="card-img-top" />
            <div class="card-body">
              <h5 class="card-title">관리자가 등록한 유효기간</h5>
              <p class="card-text">관리자가 작성한 이벤트 내용</p>
              <a href="/tastyServer/views/event/eventDetail.jsp" class="btn btn-primary">자세히 보기</a>
            </div>
          </div>
        </div>
        <div class="col-4">
          <p>Card</p>
          <div class="card">
            <img src="/tastyServer/assets/images/no-image.jpg" alt="" class="card-img-top" />
            <div class="card-body">
              <h5 class="card-title">Lorem</h5>
              <p class="card-text">Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nullam egestas sed sem ut malesuada.</p>
              <a href="#" class="btn btn-primary">More</a>
            </div>
          </div>
        </div>
        <div class="col-4">
          <p>Card</p>
          <div class="card">
            <img src="/tastyServer/assets/images/no-image.jpg" alt="" class="card-img-top" />
            <div class="card-body">
              <h5 class="card-title">Lorem</h5>
              <p class="card-text">Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nullam egestas sed sem ut malesuada.</p>
              <a href="#" class="btn btn-primary">More</a>
            </div>
          </div>
        </div>
        <br>
        <div class="col-4">
          <p>Card</p>
          <div class="card">
            <img src="/tastyServer/assets/images/no-image.jpg" alt="" class="card-img-top" />
            <div class="card-body">
              <h5 class="card-title">Lorem</h5>
              <p class="card-text">Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nullam egestas sed sem ut malesuada.</p>
              <a href="#" class="btn btn-primary">More</a>
            </div>
          </div>
        </div>
        <div class="col-4">
          <p>Card</p>
          <div class="card">
            <img src="/tastyServer/assets/images/no-image.jpg" alt="" class="card-img-top" />
            <div class="card-body">
              <h5 class="card-title">Lorem</h5>
              <p class="card-text">Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nullam egestas sed sem ut malesuada.</p>
              <a href="#" class="btn btn-primary">More</a>
            </div>
          </div>
        </div>

      </div>
      
       <div>
      	<button type="button" onclick="location.href='/tastyServer/views/event/eventInsert.jsp'">등록하기</button>
        <button type="button" onclick="location.href='/tastyServer/views/event/eventInsert.jsp'">수정하기</button>
      </div>
    </div>
    
  
  </body>
  
  
  
  
 
</html>