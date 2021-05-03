<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>결제 페이지</title>
<style>
.button {
  height: 40px;
  font-size: 17px;
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
  display: inlne;
  margin-bottom: 20px;
  float: right;   
  margin-right: 13px;
  cursor: pointer;
  }

.button:hover {
  background-color: #6ED746;
  box-shadow: 0px 15px 20px rgba(255, 234, 255, 0.4);
  color: #fff;
  transform: translateY(-7px);
}

   .btna input{
  
   height: 50px;
   color: white;
   font-size: 18px;
   font-weight: 600;
   background: #1f76bc;
   border-radius: 25px;
   border: none;
    }
   .noo td input{
   border:none;
   width:100px;
   }

.review_container{
   width: 100%; 
   display: flex;
   justify-content: center;
}

.review_writearea {
    display: inline;
    width: 1000px;
    border: solid 1px #c8c8c8;
    border-left: none;
    border-right: none;
    border-top: 2px solid #c8c8c8;
    border-bottom: 2px solid #c8c8c8;
    margin-bottom: 50px;
}
    
</style>
</head>
<body>
<%@ include file="../common/header.jsp" %>
      <h2 align="center">결제</h2>   
      
      <form action="/tastyServer/" method="post" id="buyForm" name="buyForm">
       <div class="review_container"> 
        <div class="review_writearea">
      
            <table class="table1" style="border: 1px solid black;">
               <tr>
                  
                  <td>주문자</td>
                  <td>날짜</td>
                  <td>시간</td>           
                  <td>요구사항</td>
                  
               </tr>
               
               <tr class="noo">
                  <td><input type="text" name="mNo" value="1" readonly/></td>
                  <td><input type="text" name="mRestaurantNo" value="1" readonly/></td>
                  <td><input type="text" name="" value="" readonly/></td>
                  <td><input type="text" name="userphone" value="" readonly></td>
               </tr>
            </table>      
           
            
            <p style="margin-top: 500px;"><strong>총 금액 : </strong><input type="text" name="totalPrice" value="" readonly style="border:none;"><p>
          <div class="wrap">
	          <button class="button" type="submit">결제하기</button>
	          <button class="button" type="reset">결제취소</button>
          </div>
        </div>
	</div>
       

      </form>   
 

<%@ include file="../common/footer.jsp" %>
</body>
</html>