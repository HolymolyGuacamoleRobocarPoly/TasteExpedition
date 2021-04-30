<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>리뷰 작성 페이지</title>
<script src="/tastyServer/assets/js/jquery-3.6.0.min.js"></script>

<link rel="stylesheet" href="/tastyServer/assets/css/header.css" />
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="apple-touch-icon" href="apple-touch-icon.png">
<link rel="stylesheet" href="/tastyServer/assets/css/bootstrap-tagsinput.css" />
<style>
.header {
    text-align: center;
    margin-right: -10%;
    padding-top: 8px;
    padding-bottom: 8px;
    margin-left: -10%;
    border-radius: 15px;
    border: none;
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

.review_container{
   width: 100%; 
   display: flex;
   justify-content: center;
}

textarea{
   width: 1000px;
   height: 300px; 
   border-radius: 3px; 
   border-color:#c8c8c8; 
   resize: none; 
   margin-top:50px; 
   margin-bottom: 20px;

}

textarea::placeholder {
   font-size: 20px;
}

#star a{ 
   text-decoration: none; 
   color: #c8c8c8; 
   font-size: 55px;
} 

#star a.on{ 
   color: #d4e157; 
}

[id*=uploadreviewImg]{
    width: 100px;
    height: 100px;
    border : solid 1px #c8c8c8;
    text-align : center;
    margin-top: 30px;
    display: inline;
    cursor: pointer;
}

[id*=contentImgArea]{
   display: inline;
   margin: 2px;
   
}

.review_remain{
   
   margin-top: 30px;
}

input[type=text]::placeholder{
   font-size: 15px;
}

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

.review_textArea .form-control:focus {
    border: 1px solid #c8c8c8;
    box-shadow: 0px 8px 15px rgba(0, 0, 0, 0.1);
}

.label-info{
	background-color: #d4e157;
	font-size: 15px;
}

.bootstrap-tagsinput .tag{
	color: black;
}


</style>
</head>
<body>
  <%@ include file="../common/header.jsp" %>
   
    <div class="temporary">      
       <div class="mjImgArea" 
          style="display: flex; justify-content: center; margin-top: 50px; margin-bottom: 50px; ">
          이미지
       </div>
       <div></div>
    </div>
     
	<!-- onsubmit false 추가 -->
	<!-- 위의 코드를 추가하게되면 엔터키로 submit 되는것을 막을 수 있음 
	     그러나, onsubmit을 막으면 버튼이 작동하지 않게되므로, js에서 form.submit()을 따로 처리해주어야 함 -->
    <form action="/tastyServer/insert.att" method="post" enctype="multipart/form-data">
        <div class="review_container">
       
        	<div class="review_writearea">
    			<div class="review_write">   			
    				<input type="hidden" name="mNo" value="1" />
            		<input type="hidden" name="attMFlevel" value="5"/>
            		<input type="hidden" name="mRestaurantNo" value="1"/>
            		<p style="text-align:center; margin-top: 50px; font-size: 25px; font-weight: bold;">당신의 평점은?</p>
	                <P id="star" style="text-align:center; margin-top: 40px;">        
		               <a href="#" class="rScore_star" data="1">★</a> <!-- 부모 -->
		               <a href="#" class="rScore_star" data="2">★</a> <!-- 자식들-->
		               <a href="#" class="rScore_star" data="3">★</a> 
		               <a href="#" class="rScore_star" data="4">★</a> 
		               <a href="#" class="rScore_star" data="5">★</a>  
	            	<p>
	            	<input type="hidden" name="rScore" id="scoreStar" />
	                <script>
	                	$('.rScore_star').on('click', function(){
	                		$(this).attr('data'); // 1,2,3,4,5 나옴
	                			$('#scoreStar').val($(this).attr('data'));
	                	});
	                </script>
                    <div class="review_textArea">
						<textarea class="form-control" id="rContent" name="rContent" cols="95" rows="10" placeholder="주문하신 메뉴 어떠셨나요? 다양한 리뷰로 식당을 소개해주세요!" required="required"></textarea>
					</div>  
                </div>
                 
                <div class="review_remain">
                	
                	<p style="font-weight: bold;"> # 해시태그를 추가해주세요</p>   
                	<!-- name만 정해주면 $('#tags').val();로 " , , " 해시태그 안의 값을 뽑을 수 있음 -->          
	            	<input type="text" name="rHashTag" placeholder="#해시태그" data-role="tagsinput" id="tags" class="form-control label-info bootstrap-tagsinput tag"> <br> <br>     
                	
                <!-- review_remain : 첨부파일, 미리보기 이미지, 버튼있는 영역 -->
                <!-- input type="text" id="tagInsert" style="border : solid 1px #c8c8c8; border-radius: 2px; width: 300px; height: 30px"/> <button type="button" id=tagButton onclick="showEvent()" style="border : solid 1px #c8c8c8; border-radius: 2px; width: 140px; height: 30px;">태그 추가하기</button> &nbsp;<button id=tagButton style="border : solid 1px #c8c8c8; border-radius: 2px; width: 140px; height:30px;">태그 삭제하기</button> -->            
                    <div>
                    	<p style="font-weight: bold; margin-top: 20px; margin-bottom:-20px;" >+ 사진 추가</p>
                    </div>
                    <div id="contentImgArea1">
                        <img id="uploadreviewImg1" src="/tastyServer/assets/images/no-image.jpg"/>
                    </div>
                    <div id="contentImgArea2">      
                    	<img id="uploadreviewImg2" src="/tastyServer/assets/images/no-image.jpg"/>
                    </div>
                    <div id="contentImgArea3"> 
                    	<img id="uploadreviewImg3" src="/tastyServer/assets/images/no-image.jpg"/>
                    </div>
                    <div id="contentImgArea4">  
                    	<img id="uploadreviewImg4" src="/tastyServer/assets/images/no-image.jpg"/>
                    </div>
                    
               		<div class="fileArea" id="fileArea">
                  	    <input type="file" accept="image/*" name="thumbImg1" id="thumbImg1" onchange="loadImg(this,1);" />
                  		<input type="file" accept="image/*" name="thumbImg2" id="thumbImg2" onchange="loadImg(this,2);" />
                  		<input type="file" accept="image/*" name="thumbImg3" id="thumbImg3" onchange="loadImg(this,3);" />
                  		<input type="file" accept="image/*" name="thumbImg4" id="thumbImg4" onchange="loadImg(this,4);" />
               		</div>
                           
                    <div class="wrap">
                    	<button class="button" type="reset">작성 취소</button>
                    	<button class="button" type="submit">리뷰 등록</button>
                    </div>
                </div>
          	</div>
       	</div>
    </form>
    
   
<script src="/tastyServer/assets/js/bootstrap-tagsinput.js"></script>
<script>

	document.getElementById("rContent").style.fontSize = '20px';
	
	$('.bootstrap-tagsinput input').tagsinput({
		confirmKeys: [13, 188]
	});
	// $function(){}으로 감싸줘야 함 -> 화면이 다 준비된 다음에 아래 코드를 실행해야 keycode 바꾸는게 적용됨
	$(function(){
		$('.bootstrap-tagsinput>input').on('keydown', function(event){
			console.log('tagsinput : ' + event.keyCode);
			if(event.keyCode == 13){
				event.keyCode = 188;
				event.preventDefault();
			}
		});
	});
	$('#tags').on('keydown', function(event){
		console.log('tags : ' + event.keyCode);
		if(event.keyCode == 13){
			event.preventDefault();
		}
	});
	
      $('#star a').click(function(){ $(this).parent().children("a").removeClass("on"); 
      
      $(this).addClass("on").prevAll("a").addClass("on"); 
      console.log("value : " + $(this).attr("data")); });

      $('#contentImgArea1').on('click', function(){
         $('#thumbImg1').click();
      });
      
      $('#contentImgArea2').on('click',function(){
         $('#thumbImg2').click();
      });
      
      $('#contentImgArea3').on('click',function(){ 
         $('#thumbImg3').click();
      });
      
      $('#contentImgArea4').on('click',function(){ 
         $('#thumbImg4').click();
      });
      
      $('#fileArea').hide(); // 파일 선택하는 부분 숨겨짐(안보임)
      
      // 사진 미리보기 구현
      // this : image가 들어있는 파일 -> img
      // file 안에는 이미지 데이터가 들어있음
      function loadImg(img, num) {
         // 파일을 꺼냈을때 파일이 존재하고 0번째가 들어있다면(파일이 들어왔는지, 그 중에서도 0번째가 들어왔는지) -> 배열이니깐 0번에 null이 들어있고 1,2,3이 들어있을 수도 있기때문에
         if(img.files && img.files[0]) {
            // 파일을 읽어오는 객체 생성
            var reader = new FileReader();
            
            // 다 읽었다면(읽어왔다면) 함수를 실행하세요 / 이벤트 등록
            reader.onload = function(e){
               // 읽어온 e의 타겟이 되는 결과(읽어온 결과)를 img 태그의 src 속성에 넣어주세요
               
               // attr('src', e.target.result);
               // e(매개변수).= event 발생 시
               // target = 목표(src)에 result = 결과(경로)를 src 속성(attr) 에 넣어라
               switch(num) {
               case 1 : $('#uploadreviewImg1').attr('src', e.target.result);
                      break;
               case 2 : $('#uploadreviewImg2').attr('src', e.target.result);
                      break;
               case 3 : $('#uploadreviewImg3').attr('src', e.target.result);
                       break;
               case 4 : $('#uploadreviewImg4').attr('src', e.target.result);
                       break;
               }
            }
            // input type file에 들어있던 파일을 읽어와라 / 읽어오면서 157번 아래의 코드들이 수행됨 ?? 모르겠음...
            // 파일을 하나씩 가지고 있으니깐 그 0번째 파일을 URL의 데이터로써 읽어오세요 라는 뜻 -> ???
            reader.readAsDataURL(img.files[0]);
         }
      }
   
      
      
   </script>
	 <%@ include file="../common/footer.jsp" %>
</body>
</html>



