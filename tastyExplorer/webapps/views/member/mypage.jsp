<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.mj.event.model.vo.*, java.util.*" %>	
<%
	EventAdmin ev = (EventAdmin)request.getAttribute("event"); // 서블릿이 보낸 ReviewList 받아오기 

	ArrayList<EventAdmin> elist = (ArrayList<EventAdmin>)request.getAttribute("elist"); // 서블릿이 보낸 ReviewList 받아오기 

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>마이페이지</title>
<script src="/tastyServer/assets/js/jquery-3.6.0.min.js"></script>
<link rel="stylesheet" href="/tastyServer/assets/css/header.css" />
<link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<style>
.sidebar1 {
    background: #F17153;
    /* For browsers that do not support gradients */
    background: -webkit-linear-gradient(#F17153, #F58D63, #f1ab53);
    /* For Safari 5.1 to 6.0 */
    background: -o-linear-gradient(#F17153, #F58D63, #f1ab53);
    /* For Opera 11.1 to 12.0 */
    background: -moz-linear-gradient(#F17153, #F58D63, #f1ab53);
    /* For Firefox 3.6 to 15 */
    
    /* Standard syntax */
    padding: 0px;
    min-height: 100%;
    width: 250px;
    padding: 10px;
    margin-top:30px;
    margin-bottom: 20px;
    width: 250px;
    height:900px;
    margin-left:0px;
    background: white;
    border-right: 1px solid #bdbdbd;
    border-radius: 2px;
   
}
.logo {
    max-height: 130px;
}
.logo>img {
    margin-top: 30px;
    padding: 3px;
    border: 3px solid white;
    border-radius: 100%;
}
.list {
    color: black;
    list-style: none;
    padding-left: 0px;
}
.list::first-line {
    color: rgba(255, 255, 255, 0.5);
}
.list> li, h5 {
    padding: 5px 0px 5px 40px;
}
.list>li:hover {
    background-color: rgba(255, 255, 255, 0.2);
    border-left: 5px solid white;
    color: white;
    font-weight: bolder;
    padding-left: 35px;
}.main-content{
text-align:center;
}

li{
	font-size: 20px;
}

b, strong{
color: #111;
font-size: 20px;
}

h5{
	text-align: center;
	padding: 5px 0px;
}
</style>



</head>

<body>

<%@ include file ="../common/header.jsp" %>


    <div class="container-fluid">
        <div class="row">
            <div class="col-md-2 col-sm-4 sidebar1">
                <div class="logo">
                    <img src="/tastyServer/assets/images/미모지.png" class="img-responsive center-block" alt="Logo">
                </div>
                <br>
                <div class="left-navigation">
                    <ul class="list">
                        <h5><strong>김영인 님</strong></h5>
                        
                        <div>
                        <li>Home</li>
                        <li>Office</li>
                        <li>School</li>
                        <li>Gym</li>
                        </div>
                    </ul>

                    <br>

                   
                </div>
            </div>
            
    </div>
    </div>
<%@ include file ="../common/footer.jsp" %>

</body>
</html>