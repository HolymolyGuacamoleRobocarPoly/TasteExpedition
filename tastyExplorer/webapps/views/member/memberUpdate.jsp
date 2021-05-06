<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.mj.event.model.vo.*, java.util.*"  %>	
<%
	ArrayList<EventAdmin> elist = (ArrayList<EventAdmin>)request.getAttribute("elist"); // 서블릿이 보낸 ReviewList 받아오기 
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0"> 
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>정보수정</title>

<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

<link rel="stylesheet" href="/tastyServer/assets/css/header.css" />
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="apple-touch-icon" href="apple-touch-icon.png">
<link rel="stylesheet" href="/tastyServer/assets/css/userprofile.css">
<script src="/tastyServer/assets/js/jquery-3.6.0.min.js"></script>
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
</head>
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
    background: #839903;
    /* Standard syntax */
    padding: 0px;
    min-height: 100%;
    width: 230px;
}
.logo {
    max-height: 130px;
}
.logo>img {
    margin-top: 50px;
    padding: 3px;
    border: 3px solid white;
    border-radius: 100%;
}
.list {
    color: #fff;
    list-style: none;
    padding-left: 0px;
}
.list::first-line {
    color: rgba(255, 255, 255, 0.5);
}
.list> li {
    padding: 5px 0px 5px 40px;
    font-size: 20px;
    margin-top: 25px;
}

h5{
	margin-top: 30px;
	padding: 5px 0px 5px 40px;
	font-size: 20px;
	margin-bottom: 50px;
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

b, strong{
padding-right: 40px;
}

.container{
margin-top: 60px;
}

.table{
height: 200px;
font-size: 20px;
}

a{
	color: white;
}

.logo>img{
	height:160px;
	width: 160px;		
}

 section .mainpage {
      width : 700px;
      height: auto;
      color: black;
      margin-left: auto;
      margin-right: auto;
      margin-top: 50px;
      padding : 5px;
      }
      
      #ckZip {
      background:#839903;
      border-radius:5px;
      width:130px;
      height:25px;
      text-align:center;
      margin-left: 240px;
   }
   
   #updateBtn {
   background:#839903;
      border-radius:5px;
      width:130px;
      height:25px;
      text-align:center;
   
   }
   
   fieldset {
		margin: 0;
		padding: 0;
		border: 0;
		font-size: 100%;
		vertical-align: baseline;
	}
	
	.form-box {
		margin: 0 0 46px 0;
		padding: 55px 83px;
		border-top: solid 2px #39373a;
		border-bottom: solid 2px #39373a;
	}
	
	.form-box > li {
		position: relative;
		padding: 0 0 0 178px;
		min-height: 65px;
	}
	
	.form-box > li > .tit {
		position: absolute;
		left: 45px;
		top: 13px;
		color: #000;
	}
	
	.form-box > li > .form {
		position: relative;
	}
	
	.form-box > li .form input {
		display : inline-box;
		position: relative;
		z-index: 2;
		padding: 0 2px;
		width: 250px;
		height: 35px;
		font-size: 12px;
		color: #000;
		border: none;
		border-bottom: solid 1px #9d9d9d;
		background: transparent;
	}
	
	.form-box > li .form-1 input {
		display : inline-box;
		position: relative;
		z-index: 2;
		padding: 0 2px;
		width: 73px;
		height: 35px;
		font-size: 12px;
		color: #000;
		border: none;
		border-bottom: solid 1px #9d9d9d;
		background: transparent;
	}
	

	
	ul {
		list-style: none;
	}
	
	.form-date > li > * {
		display: block;
		width: 100%;
		height: 35px;
		line-height: 35px;
		font-size: 12px;
		color: #000;
		border: 0;
		border-bottom: solid 1px #9d9d9d;
		box-sizing: border-box;
	}
	
	select {
		padding-right : 15px;
		border-radius: 0px;
		apperance: none;
	}
	
	div > ckZip {
	padding-left: 100px;
	}


 a:link {text-decoration: none;}

 
</style>
<body>

<%@ include file="../common/header.jsp" %>

    <div class="container-fluid">
        <div class="row">
            <div class="col-md-2 col-sm-4 sidebar1">
                <div class="logo">
                    <img src="/tastyServer/assets/images/미모지.png" class="img-responsive center-block" alt="Logo">
                </div>
                <br>
                <div class="left-navigation" style="height: 700px;">
                    <ul class="list">
                        <h5 style="text-align: center"><strong><%= m.getNickName() %> 님</strong></h5>
                        <li><a href="/tastyServer/views/member/memberUpdate.jsp">정보수정</a></li>
                        <li><a href="/tastyServer/select.eh">이벤트 내역</a></li>
                        <li><a href="/tastyServer/views/member/memberDelete.jsp">회원 탈퇴</a></li>
                    </ul>

                    <br>
                </div>
            </div>
            <div class="col-md-10 col-sm-8 main-content">
            <!--Main content code to be written here -->
				<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
					integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
					crossorigin="anonymous"></script>
				<script
					src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
					integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
					crossorigin="anonymous"></script>
				<script
					src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
					integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
					crossorigin="anonymous"></script>
				<div class="container">
					   <div>
   <h1 align="center" style="color:#839903;">회원 정보 수정</h1>
   <br>
   
   <section class="mainpage">
   
   <form action="/tastyServer/update.me" method="post" id="updateForm" enctype="multipart/form-data">


   	<fieldset>
	 		<ul class="form-box">
				<li>
					<p class="tit">아이디</p>
					<p class="form"><%= m.getUserId() %></p>
				</li>
				
				<li>
					<p class="tit">변경할 비밀번호</p>
					<p class="form">
					<input type="password" id="userPwd" name="userPwd" required="required"
					placeholder="비밀번호를 입력해주세요.">
					</p>
				</li>
				
				<li>
					<p class="tit">비밀번호 확인</p>
					<p class="form">
					<input type="password" id="userPwd2" name="userPwd2" placeholder="비밀번호 확인값을 입력해주세요.">
					<label id="pwdResult"></label>
					</p>
				</li>
				
				<li>
					<p class="tit">이름</p>
					<p class="form">
					<%= m.getUserName() %>
					</p>
				</li>
				
				<li>
					<p class="tit">닉네임</p>
					<p class="form">
					<%= m.getNickName() %>
					</p>
				</li>
				
				<li>
					<p class="tit">생년월일</p>
					<ul class="form-date">
							<select id="birthday" name="birth_year">
								<option value=""></option>
								<option value="2021">2021</option>
								<option value="2020">2020</option>
								<option value="2019">2019</option>
								<option value="2018">2018</option>
								<option value="2017">2017</option>
								<option value="2016">2016</option>
								<option value="2015">2015</option>
								<option value="2014">2014</option>
								<option value="2013">2013</option>
								<option value="2012">2012</option>
								<option value="2011">2011</option>
								<option value="2010">2010</option>
								<option value="2009">2009</option>
								<option value="2008">2008</option>
								<option value="2007">2007</option>
								<option value="2006">2006</option>
								<option value="2005">2005</option>
								<option value="2004">2004</option>
								<option value="2003">2003</option>
								<option value="2002">2002</option>
								<option value="2001">2001</option>
								<option value="2000">2000</option>
								<option value="1999">1999</option>
								<option value="1998">1998</option>
								<option value="1997">1997</option>
								<option value="1996">1996</option>
								<option value="1995">1995</option>
								<option value="1994">1994</option>
								<option value="1993">1993</option>
								<option value="1992">1992</option>
								<option value="1991">1991</option>
								<option value="1990">1990</option>
								<option value="1989">1989</option>
								<option value="1988">1988</option>
								<option value="1987">1987</option>
								<option value="1986">1986</option>
								<option value="1985">1985</option>
								<option value="1984">1984</option>
								<option value="1983">1983</option>
								<option value="1982">1982</option>
								<option value="1981">1981</option>
								<option value="1980">1980</option>
								<option value="1979">1979</option>
								<option value="1978">1978</option>
								<option value="1977">1977</option>
								<option value="1976">1976</option>
								<option value="1975">1975</option>
								<option value="1974">1974</option>
								<option value="1973">1973</option>
								<option value="1972">1972</option>
								<option value="1971">1971</option>
								<option value="1970">1970</option>
								<option value="1969">1969</option>
								<option value="1968">1968</option>
								<option value="1967">1967</option>
								<option value="1966">1966</option>
								<option value="1965">1965</option>
								<option value="1964">1964</option>
								<option value="1963">1963</option>
								<option value="1962">1962</option>
								<option value="1961">1961</option>
								<option value="1960">1960</option>
								<option value="1959">1959</option>
								<option value="1958">1958</option>
								<option value="1957">1957</option>
								<option value="1956">1956</option>
								<option value="1955">1955</option>
								<option value="1954">1954</option>
								<option value="1953">1953</option>
								<option value="1952">1952</option>
								<option value="1951">1951</option>
								<option value="1950">1950</option>
								<option value="1949">1949</option>
								<option value="1948">1948</option>
								<option value="1947">1947</option>
								<option value="1946">1946</option>
								<option value="1945">1945</option>
								<option value="1944">1944</option>
								<option value="1943">1943</option>
								<option value="1942">1942</option>
								<option value="1941">1941</option>
								<option value="1940">1940</option>
								<option value="1939">1939</option>
								<option value="1938">1938</option>
								<option value="1937">1937</option>
								<option value="1936">1936</option>
								<option value="1935">1935</option>
								<option value="1934">1934</option>
								<option value="1933">1933</option>
								<option value="1932">1932</option>
								<option value="1931">1931</option>
								<option value="1930">1930</option>
								<option value="1929">1929</option>
								<option value="1928">1928</option>
								<option value="1927">1927</option>
								<option value="1926">1926</option>
								<option value="1925">1925</option>
								<option value="1924">1924</option>
								<option value="1923">1923</option>
								<option value="1922">1922</option>
								<option value="1921">1921</option>
								<option value="1920">1920</option>
							</select>
							
							<span>년</span>
						
							<select id="birthday" name="birth_month">
								<option value=""></option>
								<option value="01">01</option>
								<option value="02">02</option>
								<option value="03">03</option>
								<option value="04">04</option>
								<option value="05">05</option>
								<option value="06">06</option>
								<option value="07">07</option>
								<option value="08">08</option>
								<option value="09">09</option>
								<option value="10">10</option>
								<option value="11">11</option>
								<option value="12">12</option>
							</select>
							<span>월</span>
					
						
							<select id="birthday" name="birth_day">
								<option value=""></option>
								<option value="01">01</option>
								<option value="02">02</option>
								<option value="03">03</option>
								<option value="04">04</option>
								<option value="05">05</option>
								<option value="06">06</option>
								<option value="07">07</option>
								<option value="08">08</option>
								<option value="09">09</option>
								<option value="10">10</option>
								<option value="11">11</option>
								<option value="12">12</option>
								<option value="13">13</option>
								<option value="14">14</option>
								<option value="15">15</option>
								<option value="16">16</option>
								<option value="17">17</option>
								<option value="18">18</option>
								<option value="19">19</option>
								<option value="20">20</option>
								<option value="21">21</option>
								<option value="22">22</option>
								<option value="23">23</option>
								<option value="24">24</option>
								<option value="25">25</option>
								<option value="26">26</option>
								<option value="27">27</option>
								<option value="28">28</option>
								<option value="29">29</option>
								<option value="30">30</option>
								<option value="31">31</option>
							</select>
							<span>일</span>
							
							</ul>
				</li>
				
				<li>
					<p class="tit">연락처</p>
					<p class="form-1">
					<input type="text" maxlength="3" id="tel1" name="tel1" size="4">-
					<input type="text" maxlength="4" id="tel2" name="tel2" size="5">-
					<input type="text" maxlength="4" id="te13" name="tel3" size="5">
					</p>
				</li>
				
				<li>
					<p class="tit">이메일</p>
					<p class="form">
					<input type="email" id="email" name="email" placeholder="이메일을 입력해주세요.">
					</p>
				</li>
				
				<li>
					<p class="tit">우편번호</p>
					<p class="form">
					<input type="text" id="zipCode" name="zipCode" placeholder="우편번호를 입력해주세요."><div id="ckZip" onclick="addrSearch();">우편번호 검색</div>	</p>
				
					
					
				</li>
				
				<li>
					<p class="tit">주소</p>
					<p class="form">
					<input type="text" id="address1" name="address1" placeholder="주소를 입력해주세요.">
					</p>
				</li>
				
				
				<li>
					<p class="tit">상세주소</p>
					<p class="form">
					<input type="text" id="address2" name="address2" placeholder="상세주소를 입력해주세요.">
					</p>
				</li>
				
				<li>
					<p class="tit">프로필사진 변경</p>
					<p class="form">
					 <input type="file" accept="image/*" name="thumbImg1" id="thumbImg1" onchange="loadImg(this,1);" />
					</p>
				</li>
				
				
			</ul>
	</fieldset>
  

      <br>
         <div class="btns" align="center">
            <div id="updateBtn" onclick="updateMember();">수정하기</div> <br>
         </div>
      </form>
      
      </section>
   
</div>
   
   <script>
   
   // 참조 API : http://postcode.map.daum.net/guide
   function addrSearch() {
        new daum.Postcode({
            oncomplete: function(data) {
                // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

                // 각 주소의 노출 규칙에 따라 주소를 조합한다.
                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
                var fullAddr = ''; // 최종 주소 변수
                var extraAddr = ''; // 조합형 주소 변수

                // 사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
                if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
                    fullAddr = data.roadAddress;

                } else { // 사용자가 지번 주소를 선택했을 경우(J)
                    fullAddr = data.jibunAddress;
                }

                // 사용자가 선택한 주소가 도로명 타입일때 조합한다.
                if(data.userSelectedType === 'R'){
                    //법정동명이 있을 경우 추가한다.
                    if(data.bname !== ''){
                        extraAddr += data.bname;
                    }
                    // 건물명이 있을 경우 추가한다.
                    if(data.buildingName !== ''){
                        extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                    }
                    // 조합형주소의 유무에 따라 양쪽에 괄호를 추가하여 최종 주소를 만든다.
                    fullAddr += (extraAddr !== '' ? ' ('+ extraAddr +')' : '');
                }

                // 우편번호와 주소 정보를 해당 필드에 넣는다.
                $('#zipCode').val(data.zonecode); //5자리 새우편번호 사용
                
                $('#address1').val(fullAddr);

                // 커서를 상세주소 필드로 이동한다.
                $('#address2').focus();
            }
        }).open();
    };
    
    function insertMember() {
       if($("#userId").val() == "") alert("아이디를 입력해주세요.");
      else if($("#userPwd").val() == "") alert("비밀번호를 입력해주세요.");
      else if($("#userPwd2").val() == "") alert("비밀번호 확인값을 입력해주세요.");
      else if($("#userName").val() == "") alert("이름을 입력해주세요.");
      else if($("#nickName").val() == "") alert("닉네임을 입력해주세요.");
      else if($("#birthday").val() == "") alert("생년월일을 입력해주세요.");
      else if($("#te11").val() == "" || $("#te12").val() == "" || $("#te13").val() == "") alert("연락처를 입력해주세요.");
      else if($("#email").val() == "") alert("이메일을 입력해주세요.");
      else if($("#zipCode").val() == "") alert("우편번호를 입력해주세요.");
      else if($("#adress1").val() == "") alert("주소를 입력해주세요.");
      else if($("#adress2").val() == "") alert("상세주소를 입력해주세요.");
      else if($('#userPwd').val() != $('#userPwd2').val()) alert("비밀번호 확인 값과 다릅니다.");
      else if($("#termsPrivacy").is(":checked") == false){
         alert("개인정보 이용약관에 동의해주세요.");
      }else if($("#chk_all").is(":checked") == false){
         alert("위치기반 서비스 이용약관에 동의해주세요.");
      }else $("#joinForm").submit();
   }
    
    function updateMember() {
       $('#updateForm').submit();
    }
    
    function deleteMember() {
       lacation.href ="/tastyServer/delete.me?mid=<%= m.getUserId() %>";
    }
    
    var phoneArr = '<%= m.getPhone() %>'.split('-');

   $('input[name*="tel"]').each(function(index){
      $(this).val(phoneArr[index]);
   });
   
   var addressArr = '<%= m.getAddress() %>'.split(', ');
   
   $('#zipCode').val(addressArr[0]);
   $('#address1').val(addressArr[1]);
   $('#address2').val(addressArr[2]);
    
   </script>

				</div>


			</div>
    </div>
    
    <%@ include file="../common/footer.jsp" %>
    
</body>
