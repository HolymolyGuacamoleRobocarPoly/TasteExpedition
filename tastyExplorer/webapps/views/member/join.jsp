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
		margin-top: 50px;
		padding : 5px;
		}
		
		#idCheck, #ckZip, #nickCheck, #joinBtn {
		background:#d4e157;
		border-radius:5px;
		width:130px;
		height:25px;
		text-align:center;
	}
		
		
</style>
<body>

	<%@ include file="../common/header.jsp" %>
	
	<h1 align="center" style="color:#d4e157;">Join Us</h1>
	<br>
	
	<section>
	
	<form action="/tastyServer/insert.me" method="post" id="joinForm">
		 			
			<table align="center">
				<tr>
					<td width="200px">아이디 </td>
					<td><input type="text" name="userId" id="userId" required="required"></td>
					<td width="200px"><div id="idCheck">중복 확인</div></td>
				</tr>
				<tr>
					<td>비밀번호</td>
					<td><input type="password" id="userPwd" name="userPwd" required="required"></td>
					<td></td>
				</tr>
				<tr>
					<td>비밀번호 확인</td>
					<td><input type="password" id="userPwd2" name="userPwd2"></td>
					<td><label id="pwdResult"></label></td>
				</tr>
				<tr>
					<td>이름</td>
					<td><input type="text" maxlength="5" name="userName" required="required"></td>
					<td></td>
				</tr>
				<tr>
					<td>닉네임</td>
					<td><input type="text" maxlength="5" name="nickName" required="required"></td>
					<td width="200px"><div id="nickCheck">중복 확인</div></td>
					<td></td>
				</tr>
				<tr>
					<td>연락처 </td>
					<td>
						<input type="text" maxlength="3" name="tel1" size="2">-
						<input type="text" maxlength="4" name="tel2" size="2">-
						<input type="text" maxlength="4" name="tel3" size="2">
					</td>
					<td></td>
				</tr>
				<tr>
					<td>이메일 </td>
					<td><input type="email" name="email"></td>
					<td></td>
				</tr>
				<tr>
					<td>우편번호</td>
					<td><input type="text" id="zipCode" name="zipCode"></td>
					<td><div id="ckZip" onclick="addrSearch();">우편번호 검색</div></td>
				</tr>
				<tr>
					<td>주소</td>
					<td><input type="text" id="address1" name="address1"></td>
					<td></td>
				</tr>
				<tr>
					<td>상세주소</td>
					<td><input type="text" id="address2" name="address2"></td>
					<td></td>
				</tr>
				<tr>
					<td>상세주소</td>
					<td><input type="text" id="address2" name="address2"></td>
					<td></td>
				</tr>
			</table>
		
		<div id="page-wrapper" class="contact-wrap">
		
	<div class="container">
		<div class="main-visual visual-contact">
			<div class="visual">	
				<div class="hr"></div>
			</div>
		</div>
		<!-- /.main-visual -->
		
		<div class="view-table">
			<div class="form-group text-center pb-3 pt-3">
				<p style="color:class="pb-3"><strong>개인정보 이용 약관</strong></p>
				
				<textarea cols="100" rows="10" class="terms-block mx-3" style="resize: none; overflow-y: auto;" readonly>
-이용약관 -

제1조(목적) 
이 약관은 “맛좀볼래”(이하 "회사"라 합니다)가 “맛좀볼래 웹페이지”으로 제공하는 인터넷 플랫폼 관련 서비스(이하 "서비스"라 합니다)를 이용함에 있어 회사와 이용자의 권리•의무 및 책임사항을 규정함을 목적으로 합니다. 

제2조(용어의 정의)
①	이 약관에서 사용하는 용어의 정의는 다음과 같습니다.
1.	"서비스"라 함은 회사가 PC, 휴대형단말기 등의 각종 유무선 전자장치를 통해 제공하는 인맥 정보 관리 및 공유 시스템, 인맥 간 소통 및 교류 활동 지원 시스템, 기업 정보, 콘텐츠, 그 외 비즈니스의 원활한 수행을 위해 필요한 각종 정보 등의 ㈜트니트니 관련 제반 서비스를 통칭합니다.
2.	"회원"이라 함은 회사의 서비스에 접속하여 이 약관에 따라 회사와 이용계약을 체결하고 회사가 제공하는 서비스를 이용하는 고객을 말합니다.
3.	"아이디"라 함은 회원의 식별과 서비스 이용을 위하여 회원이 정하고 회사의 서비스에 등록한 이메일 주소를 말합니다.
4.	"비밀번호"라 함은 회사의 서비스를 이용하려는 사람이 회원과 동일인임을 확인하고 권익을 보호하기 위하여 회원 자신이 선정한 문자 또는 문자와 숫자의 조합을 말합니다.
5.	“본인확인”이라 함은 휴대전화번호를 이용한 본인 인증을 통하여 회원이 본인인지 여부를 확인하는 행위를 말합니다. 
6.	“관리자”라 함은 회사에서 제공하는 서비스의 전반적인 관리와 원활한 운영을 위하여 회사에서 지정한 사람 및 유지보수 업체를 말합니다.
②	이 약관에서 사용하는 용어의 정의는 제1항에서 정하는 것을 제외하고는 관련 법령에서 정하는 바에 따르며, 관련 법령에서 정하지 않는 것은 일반적인 상관례에 따릅니다.

제3조(적용 범위 및 효력, 효력의 우선순위)
이 약관은 회사에서 제공하는 전체 서비스에 적용됩니다. 규정이 상충할 때에는 개별 서비스 관련 규정이 전체 서비스 관련 규정보다 우선적 효력을 갖습니다. 

제4조(약관 등의 명시와 개정) 
①	회사는 이 약관의 내용과 아래 표기된 상호, 영업소 소재지 주소(소비자의 불만을 처리할 수 있는 곳의 주소를 포함), 사업자등록번호, 전화번호, FAX번호 및 개인정보보호책임자, 이메일주소 등을 이용자가 쉽게 알 수 있도록 플랫폼의 회원 가입 시 노출되는 초기 화면에 게시합니다. 
	
	</textarea>
	
	<span class="input_chk">
		<input type="checkbox" id="termsPrivacy" class="chk">
		<label for="termsPrivacy">개인정보 수집 및 이용 동의(필수)</label>
	</span>
	
	</div>
	
	<div class="view-table2">
			<div class="form-group text-center pb-3 pt-4">
				<p class="pb-4"><strong>위치기반 서비스 이용약관</strong></p>
				
				<textarea cols="100" rows="10" class="terms-block mx-4" style="resize: none; overflow-y: auto;" readonly>
[서비스 이용약관]
 
제 1장 총칙
 
제 1조 (목적) 

서비스 이용 약관(이하 ‘약관’이라 함)은 맛좀볼래가 제공하는 식신, 식신Plus 등을 포함한 맛좀볼래에서 제공하는 서비스 (이하 ‘서비스’)를 이용함에 있어 ‘회사’와 ‘회원’(제 2조에서 정의합니다)의 권리, 의무, 책임사항 및 ‘회원’의 ‘서비스’이용절차에 관한 사항을 규정함을 목적으로 합니다. ‘서비스’의 제공 방식에 따라 별도로 회원가입을 했더라도 ‘회원’은 ‘회사’에서 운영하는 ‘서비스’에 추가 약관 동의 없이 이용 할 수 있습니다. 

제 2 조 (용어의정의) 

1. ‘서비스’라 함은 구현되는 단말기 (PC, 휴대형단말기 등의 각종 유무선장치를 포함)와 상관없이 ‘회사’에 종속되어 ‘회원’을 대상으로 제공하는 모든 기능을 의미합니다. 

1) 맛좀볼래 서비스 
① 맛좀볼래 서비스(이하 ‘맛좀볼래’이라 함) : 위치 기반으로 전세계 맛집을 추천 받거나 검색 하고 방문기록을 남기는 서비스 입니다. 
② 맛좀볼래매장 : ‘맛좀볼래매장’이란 ‘맛좀볼래’를 통해 정보를 제공하는 모든 음식점 및 술집 등을 지칭합니다. 
③ 맛좀볼래리뷰 : ‘회원’이 식신 상에서 ‘매장’에 직접 남긴 평가점수, 글, 사진, 동영상을 의미합니다. 
	
	</textarea>
	
	<span class="input_chk">
			<input type="checkbox" id="chk_all" class="chk">
                                  
			<label for="chk_all">위치기반 서비스 이용 동의(필수)</span></label>
    </span>
	</div>
			<br>
			<div class="btns" align="center">
				<div id="joinBtn" onclick="insertMember();">JOIN</div>
			</div>
		</form>
		
		</section>
	

	
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
		$("#joinForm").submit();
	}
	
	$("#joinForm").submit(function(event){
		if($("#userPwd").val() == "" || $("#userId").val() == "") alert("아이디와 비밀번호를 필수로 입력해주세요.");
		else if($('#userPwd').val() != $('#userPwd2').val()) alert("비밀번호 확인 값과 다릅니다.");
		else return;
		event.preventDefault();
	});
    
    // 아이디
		
	$('#idCheck').on('click', function(){
		$.ajax({
			url : '/tastyServer/idcheck.me',
			type : 'post',
			data : { userId : $('#userId').val() },
			success : function( data ) {
				console.log(data);
				
				// 전달된 결과가 0이면 : 사용 가능
				// 전달된 결과가 1이면 : 사용 불가
				if( data == 0) {
					alert("사용 가능한 아이디입니다.");
				} else {
					alert("이미 사용 중인 아이디입니다.");
				}
				
			}, error : function(){
				console.log("전송 실패!");
			}
		});
	});
	
	</script>
	
	<%@ include file ="../common/footer.jsp" %>

	

</body>
</html>