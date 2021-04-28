<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>리뷰 작성 페이지</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous">
<script src="/tastyServer/assets/js/jquery-3.6.0.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.1/dist/umd/popper.min.js" integrity="sha384-SR1sx49pcuLnqZUnnPwx6FCym0wLsk5JZuNx2bPPENzswTNFaQU1RDvt3wT4gWFG" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.min.js" integrity="sha384-j0CNLUeiqtyaRmlzUHCPZ+Gy5fQu0dQ6eZ/xAww941Ai1SxSY+0EQqNXNE6DZiVc" crossorigin="anonymous"></script>
<script src="/tastyServer/assets/js/bootstrap-tagsinput.js"></script>



<link rel="stylesheet" href="/tastyServer/assets/css/header.css" />
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<title>Soft-Tect Free Landing Page</title>
<meta name="description" content="">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="apple-touch-icon" href="apple-touch-icon.png">

<!--Google fonts links-->
<link
   href="https://fonts.googleapis.com/css?family=Roboto:100,100i,300,300i,400,400i,500,500i,700,700i,900,900i"
   rel="stylesheet">

<link rel="stylesheet" href="/tastyServer/assets/css/bootstrap.min.css">
<link rel="stylesheet" href="/tastyServer/assets/css/bootstrap-tagsinput.css" />


<!--For Plugins external css-->
<link rel="stylesheet" href="/tastyServer/assets/css/plugins.css" />
<link rel="stylesheet" href="/tastyServer/assets/css/roboto-webfont.css" />

<!--Theme custom css -->
<link rel="stylesheet" href="/tastyServer/assets/css/style1.css">

<!--Theme Responsive css-->
<link rel="stylesheet" href="/tastyServer/assets/css/responsive.css" />

<script src="/tastyServer/assets/js/vendor/modernizr-2.8.3-respond-1.4.2.min.js"></script>
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
}

/*#r_button {
    padding: 0 13px;
    height: 40px;
    color: white;
    font-size: 18px;
    font-weight: 600;
    background: #B4F0B4;
    border-radius: 5px;
    border: none;
    display: inlne;
    margin-bottom: 10px;
    float: right;   
    margin-right: 13px;
    cursor: pointer;
}*/

.review_container{
   width: 100%; 
   display: flex;
   justify-content: center;
}

.text1
{
   width: 500px; 
   border-radius: 2px; 
   border-color:#c8c8c8; 
   resize: none; 
   margin-top:10px; 
   margin-bottom: 20px;
}

textarea::placeholder {
   font-size: 18px;
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
   
   margin-top: 100px;
}

input[type=text]::placeholder{
   font-size: 15px;
}

.button {
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
  display: inlne;
  margin-bottom: 10px;
  float: right;   
  margin-right: 13px;
  cursor: pointer;
  }

.button:hover {
  background-color: #FFBEBE;
  box-shadow: 0px 15px 20px rgba(255, 234, 255, 0.4);
  color: #fff;
  transform: translateY(-7px);
}

.review_textArea .form-control:focus {
    border: 1px solid #c8c8c8;
    box-shadow: 0px 8px 15px rgba(0, 0, 0, 0.1);
}

.label-info{
	background-color: #FFF0F0;
	font-size: 15px;
}

.bootstrap-tagsinput .tag{
	color: black;
}



</style>
</head>
<body>
   
    <div class="temporary">
       <div class="header">
          <h1>리뷰 작성</h1> <hr>
       </div>
       <div class="mjImgArea" 
          style="display: flex; justify-content: center; margin-top: 50px; margin-bottom: 50px; ">
          
       </div>
       <div></div>
    </div>
     
	<!-- onsubmit false 추가 -->
	<!-- 위의 코드를 추가하게되면 엔터키로 submit 되는것을 막을 수 있음 
	     그러나, onsubmit을 막으면 버튼이 작동하지 않게되므로, js에서 form.submit()을 따로 처리해주어야 함 -->
    <form action="/tastyServer/insert.rv" method="post">
        <div class="review_container">
        	<div class="review_writearea">
    			<div class="review_write">
            		<p style="text-align:center; margin-top: 50px; font-size: 25px; font-weight: bold;">이벤트 등록</p>
	               
	                             
                    <div class="review_textArea">
                    	<p style="font-weight: bold;"> # 이벤트 제목</p>  
						<input type="text" name="" id="" class="text1"/>
					</div>  
                </div>
                 
                <div class="review_remain">
                	<p style="font-weight: bold;"> # 이벤트 유효기간</p>             
	            	<input type="text" name="" id="" class="text1"/>
                <!-- review_remain : 첨부파일, 미리보기 이미지, 버튼있는 영역 -->
                <!-- input type="text" id="tagInsert" style="border : solid 1px #c8c8c8; border-radius: 2px; width: 300px; height: 30px"/> <button type="button" id=tagButton onclick="showEvent()" style="border : solid 1px #c8c8c8; border-radius: 2px; width: 140px; height: 30px;">태그 추가하기</button> &nbsp;<button id=tagButton style="border : solid 1px #c8c8c8; border-radius: 2px; width: 140px; height:30px;">태그 삭제하기</button> -->            
                    <div>
                    	<p style="font-weight: bold; margin-top: 20px; margin-bottom:-20px;" >+ 사진 추가</p>
                    </div>
                    <div id="contentImgArea1">
                        <img id="uploadreviewImg1" src="/tastyServer/assets/images/no-image.jpg"/>
                    </div>
                    
                    
               		<div class="fileArea" id="fileArea">
                  	    <input type="file" accept="image/*" name="thumbImg1" id="thumbImg1" onchange="loadImg(this,1);" />
                  		
               		</div>
                           
                    <div class="wrap">
                    	<button class="button" type="reset">작성 취소</button>
                    	<button class="button" type="submit">리뷰 등록</button>
                    </div>
                </div>
          	</div>
       	</div>
    </form>
   
	<script>
	
      

      $('#contentImgArea1').on('click', function(){
         $('#thumbImg1').click();
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
               
               }
            }
            // input type file에 들어있던 파일을 읽어와라 / 읽어오면서 157번 아래의 코드들이 수행됨 ?? 모르겠음...
            // 파일을 하나씩 가지고 있으니깐 그 0번째 파일을 URL의 데이터로써 읽어오세요 라는 뜻 -> ???
            reader.readAsDataURL(img.files[0]);
         }
      }
   
   </script>

</body>
</html>























