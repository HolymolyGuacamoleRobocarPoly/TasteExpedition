<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>Bootstrap 4</title>
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
  </style>
</head>
<body>
  
   <div class="header">
          <h1>Event1</h1> <hr>
       </div>
    <div class="container">
      <div class="row">
        
        <div class="col-4">
          <p>이벤트 번호</p>
          <div class="card">
            <img src="/tastyServer/assets/images/no-image.jpg" alt="" class="card-img-top" />
            <div class="card-body">
              <h5 class="card-title">[2021.04.28 - 2021.04.30]</h5>
              <p class="card-text">Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nullam egestas sed sem ut malesuada.</p>
              <a href="/tastyServer/views/event/eventDetail.jsp" class="btn btn-primary">더보기</a>
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

      </div>
      
      <div>
      	<button type="button" onclick="location.href='/tastyServer/views/event/eventInsert.jsp'">등록하기</button>
      	
      </div>
    </div>
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
  </body>
  
  
  
  
 
</html>