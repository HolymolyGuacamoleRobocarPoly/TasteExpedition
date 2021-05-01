<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ page import="com.mj.event.model.vo.*, java.util.*"  %>	
<%
				// Object --> Board
	ArrayList<EventAdmin> elist = (ArrayList<EventAdmin>)request.getAttribute("elist"); // 서블릿이 보낸 ReviewList 받아오기 
%>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>이벤트 목록</title>
<script src="/tastyServer/assets/js/jquery-3.6.0.min.js"></script>

<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">

<style>
p { margin:20px 0px; }

.review_container{
   width: 100%; 
   display: flex;
   justify-content: center;
}

.event_writearea {
    display: inline;
    width: 1000px;
    height: 1000px;
    border: solid 1px #c8c8c8;
    border-left: none;
    border-right: none;
    border-top: 2px solid #c8c8c8;
    border-bottom: 2px solid #c8c8c8;
    margin-bottom: 50px;
    margin-top: 130px;
    
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
  margin-top: 850px;
  }

button:hover {
  background-color: #FFBEBE;
  box-shadow: 0px 15px 20px rgba(255, 234, 255, 0.4);
  color: #fff;
  transform: translateY(-7px);
}

.row{
	margin-top: 20px;
}

.footer-col .social-links a {
	padding: 10px;
}

</style>
</head>
<body>
  
   <%@ include file="../common/header.jsp" %>
    
    <p style="text-align:center; margin-bottom: -130px; margin-top: 60px; font-size: 40px; font-weight: normal;">Event<p>
      <div class="review_container">
      <div class="event_writearea" >
      <div class="row">
        
        <div class="col-4">
        <!-- 시퀀스 이벤트 번호 가져오기 -->
          <p>이벤트 번호</p>
          
          <% for(EventAdmin e : elist) { %>
         	
          <div class="card">
          <!-- 관리자가 등록한 사진 가져오기 -->
            <img src="/tastyServer/assets/images/no-image.jpg" alt="" class="card-img-top" />
            <div class="card-body">
              <h5 class="card-title"><%= e.geteDuration() %></h5>
              <p class="card-text"><%= e.geteContent() %></p>
              <a href="/tastyServer/views/event/eventDetail.jsp" class="btn btn-primary">자세히 보기</a>
            </div>
          </div>
          <% } %>
        </div>

		

      </div>
      <div>
      	<button type="button" onclick="location.href='/tastyServer/views/event/eventInsert.jsp'">등록하기</button>
        <button type="button" onclick="location.href='/tastyServer/views/event/eventInsert.jsp'">삭제하기</button>
      </div>
       
    </div>
   </div>

    
     <%@ include file="../common/footer.jsp" %>
  
  </body>
  
  
  
  
 
</html>