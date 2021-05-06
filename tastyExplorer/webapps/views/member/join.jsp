<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="/tastyServer/assets/js/jquery-3.6.0.min.js"></script>
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<link rel="stylesheet" href="/tastyServer/assets/css/header.css" />
</head>
<style>

	section {
		width : 700px;
		height: auto;
		color: black;
		margin-left: auto;
		margin-right: auto;
		margin-top: 0px;
		padding : 0px;
		}
		
		#idCheck {
		background:#d4e157;
		border-radius:5px;
		width:75px;
		height:25px;
		text-align:center;
		cursor:pointer;
		margin-top: 3px;
	}
	
	 #ckZip {
	 	background:#d4e157;
		border-radius:5px;
		width:120px;
		height:25px;
		text-align:center;
		cursor:pointer;
		margin-top: 3px;
	 
	 }
	
	.contents > h2 {
		padding: 0 0 45px 0;
		min-height: 60px;
		font-size: 40px;
		color:#d4e157;
		text-align: center;
	}
	
	input[type="checkbox"]{
		position:absolute;
		clip: rect(0,0,0,0);
	}
	
	input[type="checkbox"] + label::before{
		content : "\a0";
		display: inline-block;
		width: 1em; height: 1em;
		color: white;
		background-color: white;
		border: 1px solid #d4e157;
		border-radius: 0.2em;
		margin: 0.1em;
		padding: 0px 2px 5px;
	}
	
	input[type="checkbox"]:checked + label::before {
		content: "\2174";
		background-color: #d4e157;
		text-indent: 0.1em;
	}
	
	.use_txt {
		border: solid 1px #e6e6e6;
		}
		
	.agree {
		padding: 12px 0 15px 14px;
		border-bottom: solid 1px #e6e6e6;
		background: #f9f9f9;
	}
	
	.text {
		overflow:auto;
		padding: 14px;
		height:117px;
		font-size: 13px;
		color: #777;
		line-height: 1.3;
	}
	
	#joinBtn {
	    background:#d4e157;
		border-radius:5px;
		width:100px;
		height:40px;
		text-align:center;
		cursor:pointer;
	}
	
	.join {
		padding-top: 5px;
		font-size: 20px;
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
	
	
	
	
			
</style>
<body>

	<%@ include file="../common/header.jsp" %>
	<div class="contents">
	<h2>Sign Up</h2>
	</div>
	
	<section>
	<form action="/tastyServer/insert.me" method="post" id="joinForm">	
	<fieldset>
			<ul class="form-box">
				<li>
					<p class="tit">아이디</p>
					<p class="form">
						<input type="text" name="userId" id="userId" required="required"
						placeholder="아이디를 입력해주세요."></p>
					<p id="idCheck">중복 확인</p>
					
				</li>
				
				<li>
					<p class="tit">비밀번호</p>
					<p class="form">
					<input type="password" id="userPwd" name="userPwd" required="required"
					placeholder="비밀번호를 입력해주세요.">
					</p>
				</li>
				
				<li>
					<p class="tit">비밀번호 확인</p>
					<p class="form">
					<input type="password" id="userPwd2" name="userPwd2">
					<label id="pwdResult"></label>
					</p>
				</li>
				
				<li>
					<p class="tit">이름</p>
					<p class="form">
					<input type="text" maxlength="5" id="userName" name="userName" required="required"
					placeholder="이름을 입력해주세요.">
					</p>
				</li>
				
				<li>
					<p class="tit">닉네임</p>
					<p class="form">
					<input type="text" maxlength="5" id="nickName" name="nickName" required="required"
					placeholder="닉네임을 입력해주세요.">
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
					<input type="text" id="zipCode" name="zipCode" placeholder="우편번호를 입력해주세요."></p>
					<div id="ckZip" onclick="addrSearch();">우편번호 검색</div>
					
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
			</ul>
			</fieldset>
			
		<div class="use_txt">
			<div class="agree">
				<p><strong>개인정보 이용 약관</strong></p>
			</div>
				
				<div class="text">
				<pre>
-이용약관 -

제1조(목적) 
이 약관은 “맛좀볼래”(이하 "회사"라 합니다)가 “맛좀볼래 웹페이지”으로 제공하는 인터넷 플랫폼 관련 서비스(이하 "서비스"라 합니다)
를
이용함에 있어 회사와 이용자의 권리•의무 및 책임사항을 규정함을 목적으로 합니다. 

제2조(용어의 정의)
①이 약관에서 사용하는 용어의 정의는 다음과 같습니다.
1."서비스"라 함은 회사가 PC, 휴대형단말기 등의 각종 유무선 전자장치를 통해 제공하는 인맥 정보 관리 및 공유 시스템, 
인맥 간 소통 및 교류 활동 지원 시스템, 기업 정보, 콘텐츠, 그 외 비즈니스의 원활한 수행을 위해 필요한 각종 정보 등의 
㈜트니트니 관련 제반 서비스를 통칭합니다.
2."회원"이라 함은 회사의 서비스에 접속하여 이 약관에 따라 회사와 이용계약을 체결하고 회사가 제공하는 서비스를 이용하는
고객을 말합니다.
3."아이디"라 함은 회원의 식별과 서비스 이용을 위하여 회원이 정하고 회사의 서비스에 등록한 이메일 주소를 말합니다.
4."비밀번호"라 함은 회사의 서비스를 이용하려는 사람이 회원과 동일인임을 확인하고 권익을 보호하기 위하여 
회원 자신이 선정한 문자 또는 문자와 숫자의 조합을 말합니다.
5.“본인확인”이라 함은 휴대전화번호를 이용한 본인 인증을 통하여 회원이 본인인지 여부를 확인하는 행위를 말합니다. 
6.“관리자”라 함은 회사에서 제공하는 서비스의 전반적인 관리와 원활한 운영을 위하여 회사에서
지정한 사람 및 유지보수 업체를 말합니다.
②이 약관에서 사용하는 용어의 정의는 제1항에서 정하는 것을 제외하고는 관련 법령에서 정하는 바에 따르며,
관련 법령에서 정하지 않는 것은 일반적인 상관례에 따릅니다.

제3조(적용 범위 및 효력, 효력의 우선순위)
이 약관은 회사에서 제공하는 전체 서비스에 적용됩니다. 규정이 상충할 때에는 개별 서비스 관련 규정이
전체 서비스 관련 규정보다 우선적 효력을 갖습니다. 

제4조(약관 등의 명시와 개정) 
①회사는 이 약관의 내용과 아래 표기된 상호, 영업소 소재지 주소(소비자의 불만을 처리할 수 있는 곳의 주소를 포함),
사업자등록번호, 전화번호, FAX번호 및 개인정보보호책임자, 이메일주소 등을 이용자가 쉽게 알 수 있도록 플랫폼의
회원 가입 시 노출되는 초기 화면에 게시합니다. 
	
	</pre>
	</div>
	
	<span class="input_chk">
		<input type="checkbox" id="termsPrivacy" class="chk">
		<label for="termsPrivacy"> 개인정보 수집 및 이용 동의(필수)</label>
	</span>
	
	</div>
	<br>
	
	<div class="use_txt">
			<div class="agree">
				<p><strong>위치기반 서비스 이용 약관</strong></p>
			</div>
				
				<div class="text">
				<pre>
[서비스 이용약관]
 
제 1장 총칙
 
제 1조 (목적) 

서비스 이용 약관(이하 ‘약관’이라 함)은 맛좀볼래가 제공하는 식신, 식신Plus 등을 포함한 맛좀볼래에서 제공하는 
서비스 (이하 ‘서비스’)를 이용함에 있어 ‘회사’와 ‘회원’(제 2조에서 정의합니다)의 권리, 의무, 
책임사항 및 ‘회원’의 ‘서비스’이용절차에 관한 사항을 규정함을 목적으로 합니다. 
‘서비스’의 제공 방식에 따라 별도로 회원가입을 했더라도 ‘회원’은 ‘회사’에서 운영하는 ‘서비스’에 
추가 약관 동의 없이 이용 할 수 있습니다. 

제 2 조 (용어의정의) 

1. ‘서비스’라 함은 구현되는 단말기 (PC, 휴대형단말기 등의 각종 유무선장치를 포함)와 상관없이 ‘회사’에 종속되어
‘회원’을 대상으로 제공하는 모든 기능을 의미합니다. 

1) 맛좀볼래 서비스 
① 맛좀볼래 서비스(이하 ‘맛좀볼래’이라 함) : 위치 기반으로 전세계 맛집을 추천 받거나 
검색 하고 방문기록을 남기는 서비스 입니다. 
② 맛좀볼래매장 : ‘맛좀볼래매장’이란 ‘맛좀볼래’를 통해 정보를 제공하는 모든 음식점 및 술집 등을 지칭합니다. 
③ 맛좀볼래리뷰 : ‘회원’이 식신 상에서 ‘매장’에 직접 남긴 평가점수, 글, 사진, 동영상을 의미합니다. 
	</pre>
	</div>
	
	<span class="input_chk">
		<input type="checkbox" id="on" class="chk">
		<label for="on"> 위치기반 서비스 이용 동의(필수)</label>
	</span>
	
	<div class="btns" align="center">
				<div class="join" id="joinBtn" onclick="insertMember();">가입하기</div>
	</div>
	
	<br>
	</form>
	
	</section>
		
		<br>
		
	
		<br>
		<br>
		
		

	
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
		}else if($("#on").is(":checked") == false){
			alert("위치기반 서비스 이용약관에 동의해주세요.");
		}else $("#joinForm").submit();
	}
    
    $('#idCheck').on('click', function(){
    	$.ajax({
    		url : '/tastyServer/idcheck.me',
    		type : 'post',
    		data : { userId : $('#userId').val() },
    		success : function( data ) {
    			console.log(data);
    			
    			if(data == 0){
    				alert ("사용 가능한 아이디입니다.");
    			} else {
    				alert ("이미 사용 중인 아이디입니다.");
    			}
    		}, error : function() {
    			console.log("전송 실패!");
    		}
    	});
    });
    
	</script>
	
	<%@ include file ="../common/footer.jsp" %>

	

</body>
</html>