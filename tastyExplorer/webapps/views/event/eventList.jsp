<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ page import="com.mj.event.model.vo.*, com.mj.common.model.vo.*, java.util.*"  %>	
<%
	ArrayList<EventAdmin> elist = (ArrayList<EventAdmin>)request.getAttribute("elist"); // 서블릿이 보낸 ReviewList 받아오기
	ArrayList<Attachment> alist = (ArrayList<Attachment>)request.getAttribute("alist");
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
   display: block;
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


.button1 {
  height: 40px;
  font-size: 15px;
  text-transform: uppercase;
  letter-spacing: 2.5px;
  font-weight: 600; 
  background-color: #d4e157;
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

.button2 {
  height: 40px;
  font-size: 15px;
  text-transform: uppercase;
  letter-spacing: 2.5px;
  font-weight: 600; 
  background-color: #d4e157;
  border: none;
  border-radius: 5px;
  /*box-shadow: 0px 8px 15px rgba(0, 0, 0, 0.1);*/
  transition: all 0.3s ease 0s;
  cursor: pointer;
  outline: none;
  padding: 0 13px;
  display: inline;
  margin-bottom: -5px;  
  cursor: pointer;
  float: right;   
  margin-right: -13px;
  cursor: pointer;
}

button:hover {
  background-color: #8AE634;
  box-shadow: 0px 15px 20px rgba(255, 234, 255, 0.4);
  color: #fff;
  transform: translateY(-7px);
}

.footer-col .social-links a {
	padding: 10px;
}

#row1{
	margin-top: 200px;
	margin-bottom: 200px;
	margin-right: auto;
	margin-left: auto;
	width: 1000px;
	
}

.card{
	padding: 10px;
}

.card-img-top {
    width: 100%;
    height: 340px;
    border-top-left-radius: calc(.25rem - 1px);
    border-top-right-radius: calc(.25rem - 1px);
}
</style>
</head>
<body>
  
   <%@ include file="../common/header.jsp" %>
    <input type="hidden" name="attMFlevel" value=4 />
    <p style="text-align:center; margin-bottom: -130px; margin-top: 60px; font-size: 40px; font-weight: normal;">Event<p>
    
       	
        
        <div class="row" id="row1">
        <!-- 시퀀스 이벤트 번호 가져오기 -->
        <% if (elist.size() == alist.size()) { %>  
        
          <% for(int i = 0; i < elist.size(); i++) { %>
         <div class="col-4" style="padding: 10px;">
          <div class="card">
          <!-- 관리자가 등록한 사진 가져오기 -->
            <p><%= elist.get(i).geteNo() %> <%= elist.get(i).geteTitle() %></p>
            <img src="/tastyServer/resources/event/<%= alist.get(i).getAttMFileName() %> "alt="" class="card-img-top" />
            <div class="card-body">
            	<h5 class="card-title">기간 : <%= elist.get(i).geteDuration() %></h5>             	
            	<p class="card-text"><%= elist.get(i).geteContent() %></p>
            	<button class="button2" id="<%= elist.get(i).geteNo() %>">자세히 보기</button>
            </div>
          </div>
          </div>
          <% } %>
        <% } %>
        
        </div>
	
		<button class="button1" type="button" onclick="location.href='/tastyServer/views/event/eventInsert.jsp'">등록하기</button>
       	<button class="button1" type="button" onclick="location.href='/tastyServer/views/event/eventInsert.jsp'">삭제하기</button>
      
     
      <!-- 관리자인 경우, 버튼 2개 보임-->
  
      	

     
       
    	

    
	
	
	<script>
  	 
	$('.button2').on('click', function(){
		var eNo = $(this).attr('id');
		
		location.href = '/tastyServer/selectOne.ev?eNo=' + eNo;
  		 
  	 });
  	 
  	 
  	</script>
  
	<%@ include file="../common/footer.jsp" %>
  
  </body>
</html>