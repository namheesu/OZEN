<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<link href="${pageContext.request.contextPath}/resources/css/cstmr/myinfo/updateInfo.css"
rel="stylesheet">
	

<div class="mypage-detail-title">
	개인정보 수정 페이지
</div>

<div class="mypage-contain mx-4 mt-4">
	<div class="frmInfo">
	<form method="post" action="${pageContext.request.contextPath }/myinfo/updateInfo.do" id="infoUpdateForm">
	<input type="hidden" name="cstNo" value="${user.cstNo }">
		<ul class="intList">
			<li>
				<div class="defaultTit">MY INFORMATION</div>
				<div class="defaultInfo">${user.cst.cstNm }/${user.cst.cstBirth }/ ${user.cst.cstGen }</div>
			</li>

			<li>
				<div class="intWrap">
					<span class="tit">
						<label for="phone">PHONE NUMBER</label>
						<span class="essential">필수</span>
					</span>
				</div>
				<div class="intInner phoneInp">
					<span class="intArea">
						<input type="text" id="telFrstNo" title="first phone number" style="width: 430px"
						aria-required="true" readonly="" value="${user.cst.cstHp }">
					</span> 
				</div>
			</li>
			<li class="intList-address">
				<div class="intWrap">
					<span class="tit"><label for="address">Address</label><span
						class="essential">필수</span>
					</span>
				</div>
				<div class="intBox"></div>
				<div class="intInner">
					<span class="intArea">
						<input type="text" id="postcode" style="width: 305px" aria-required="true" readonly="" value="">
					</span>
					<button type="button" class="btnSC btnM"
						onclick="execDaumPostcode();">
						우편번호 검색
					</button>
				</div>
				<div class="intInner duobuleInp">
					<span class="intArea">
						<input type="text" id="mberAddr" name="mberAddr" style="width: 400px" title="주소" aria-required="true" value="${user.mberAddr }">
					</span> 
					<span class="intArea">
						<input type="text" id="mberDetailAddress" name="mberDetailAddr" style="width: 400px" title="상세주소" aria-required="true" value="">
					</span> 
				</div>
			</li>
			<li>
				<div class="intWrap">
					<span class="tit">
						<label for="eMail">E-MAIL</label>
						<span class="essential">필수</span>
					</span>
				</div>
			<div class="mt-4 mb-4">
				<label class="label-font">* Email</label>
				<br>
				<input class="input-phone wd-170 bor-none" type="text" name="cstMail" value="${user.cst.cstMail }"/>
				@
				<input class="input-phone wd-170 bor-none" type="text" name="mailAddr" id="mailAddr" value="${user.cst.mailAddr }"/>
				<select id="mailAddrSelect"  class="bor-none wd-170 mx-2">
					<option value="" label="직접 입력"/>
					<option value="naver.com" label="naver.com"/>
					<option value="gmail.com" label="gmail.com"/>
					<option value="daum.net" label="daum.net"/>
					<option value="hanmail.net" label="hanmail.net"/>
					<option value="hotmail.com" label="hotmail.com"/>
					<option value="nate.com" label="nate.com"/>
				</select>
			<button id="emlDupChkBtn" type="button" class="btnSC btnM"
				onclick="fncEmlDupChk(); return false;">
				중복 확인
			</button>
			</div>
			<div class="mb-4">
				<label class="label-font">Mbti</label>
				<br>
				<select name="mberMbti" class="bor-none wd-170" id="${user.mberMbti }">
					<option value="" label="MBTI" id="MBTI" selected/>
					
					<option value="ENFP" label="ENFP" id="ENFP"/>
					<option value="ENFJ" label="ENFJ" id="ENFJ"/>
					<option value="ENTP" label="ENTP" id="ENTP"/>
					<option value="ENTJ" label="ENTJ" id="ENTJ"/>
					
					<option value="ESFP" label="ESTJ" id="ESTJ"/>
					<option value="ESFJ" label="ESFJ" id="ESFJ"/>
					<option value="ESTP" label="ESTP" id="ESTP"/>
					<option value="ESTJ" label="ESTJ" id="ESTJ"/>
					
					<option value="INFP" label="INFP" id="INFP"/>
					<option value="INFJ" label="INFJ" id="INFJ"/>
					<option value="INTP" label="INTP" id="INTP"/>
					<option value="INTJ" label="INTJ" id="INTJ"/>
					
					<option value="ISFP" label="ISFP" id="ISFP"/>
					<option value="ISFJ" label="ISFJ" id="ISFJ"/>
					<option value="ISTP" label="ISTP" id="ISTP"/>
					<option value="ISTJ" label="ISTJ" id="ISTJ"/>
					
				</select>
			</div>
			</li>
		</ul>
		<button type="submit" class="btnSC btnM">
			변경
		</button>		
		</form>
	</div>
</div>

