<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<link
	href="${pageContext.request.contextPath}/resources/css/cstmr/auth/join.css"
	rel="stylesheet">
	

<script type="text/javascript">

	<c:if test="${not empty message }">
		console.log("${message }")
		Swal.fire({
			title:"${message }"
			, icon:"error"
		})
	</c:if>
</script>
<section>
	<div>
		<div class="clickwrap-header mx-10">
			<h1 class="cstmr-title mx-5">회원가입</h1>
			
			<p class="cstmr-content mx-5 mb-5">정보 입력</p>
		</div>
		<div class="mx-10">
			*은 필수항목입니다
			<hr>
			<form:form method="post" modelAttribute="newMber" id="joinForm">
			<div class="mb-3 d-flex">
				<div class="me-2">
					<label class="label-font">* ID</label> 
					<br>
					<form:input class="input-phone wd-170 bor-none" type="text" path="mberId" required="true" id="mberId"/>
					<form:errors path="mberId" cssClass="text-danger"/>
					<button type="button" onclick="checkMberId()" class="custom-btn btn-7">중복 확인</button>
					<div id="checkResult" >
					</div>
				</div>
			</div>
			<div class="mb-3">
				<label class="label-font">* Name</label> 
				<br>
				<form:input class="input-phone wd-170 bor-none" type="text" id="cstNm" path="cstNm"/>
				<form:errors path="cstNm" cssClass="text-danger"/>
			</div>
				
			<div class="mb-3">
				<label class="label-font">* Gender</label> 
				<br>
				<form:select path="cstGen" class="bor-none  wd-170" id="cstGen" required="true">
					<form:option value="" label="Gender"/>
					<form:option value="F" label="Female"/>
					<form:option value="M" label="Male" />
				</form:select>
				<div class="mt-2" id="genCheckField" class="text-danger">
	
				</div>
			</div>
			<div class="d-flex">
				<div class="mb-2 me-2">
					<label class="label-font mr-3">* PassWord</label> 
					<br>
					<form:input class="input-phone wd-170 bor-none" type="password" path="mberPw" id="mberPw"/>
					<form:errors path="mberPw" cssClass="text-danger"/>
				</div>
				<div class="flex-fill">
					<label class="label-font">* PassWord Confirm</label> 
					<br>
					<input class="input-phone wd-170 bor-none" type="password" id="mberPwCheck" />
				</div>
			</div>
			<div id="pwCheckField" class="text-danger" style="display:none;">
				비밀번호와 비밀번호 확인을 동일하게 입력해주세요
			</div>	
			<div class="mt-4 mb-4">
				<label class="label-font">* Email</label>
				<br>
				<form:input class="input-phone wd-170 bor-none" type="text" id="cstMail" path="cstMail"/>
				<form:errors path="cstMail" cssClass="text-danger"/>
				@
				<form:input class="input-phone wd-170 bor-none" type="text" path="mailAddr" id="mailAddr"/>
				<form:errors path="cstMail" cssClass="text-danger"/>
				<select id="mailAddrSelect"  class="bor-none wd-170 mx-2">
					<option value="" label="직접 입력"/>
					<option value="naver.com" label="naver.com"/>
					<option value="gmail.com" label="gmail.com"/>
					<option value="daum.net" label="daum.net"/>
					<option value="hanmail.net" label="hanmail.net"/>
					<option value="hotmail.com" label="hotmail.com"/>
					<option value="nate.com" label="nate.com"/>
				</select>
			</div>

			<div class="mb-4">
				<label class="label-font">* Tel Number</label>
				<br>
				<form:input class="input-phone wd-450 bor-none" path="cstHp" id="cstHp" type="text"/>
				<form:errors path="cstHp" cssClass="text-danger"/>
			</div>
				
			<div class="mb-4">
				<label class="label-font">Home Tel Number</label>
				<br>
				<form:input class="input-phone wd-450 bor-none" path="mberHomeTel" type="text"/>
				<form:errors path="mberHomeTel" cssClass="text-danger"/>
			</div>
				
			<div class="mb-4">
				<label class="label-font">* BirthDay</label>
				<br>
				<form:input path="cstBirth" id="cstBirth" type="hidden" />
				<input class="input-phone wd-145 bor-none mx-2" type="text" maxlength="4" data-valid="Y" aria-required="true" id="birYear"
				placeholder="YYYY">
				<span>-</span>
				<input class="input-phone wd-145 bor-none mx-2" type="text" maxlength="2" data-valid="Y" aria-required="true" id="birMon"
				placeholder="MM">
				<span>-</span>
				<input class="input-phone wd-145 bor-none mx-2" type="text" maxlength="2" data-valid="Y" aria-required="true" id="birDay"
				placeholder="DD">
				<form:errors path="cstBirth" cssClass="text-danger"/>
				<br>
				* 만 19세 미만은 가입이 불가합니다.
			</div>
				
			<div class="mb-4">
				<label class="label-font">Address</label>
				<br>
				<input class="input-phone wd-170 bor-none mx-2" type="text" id="postcode" placeholder="우편번호" />
				<input class="custom-btn btn-6" type="button" onclick="execDaumPostcode()" value="우편번호 찾기"><br>
				<form:input class="input-phone wd-450 bor-none mx-2" type="text" path="mberAddr" id="mberAddr" placeholder="주소"/><br>
				<form:input class="input-phone wd-450 bor-none mx-2" type="text" path="mberDetailAddr" id="mberDetailAddress" placeholder="상세주소"/>
			
			</div>
			<div class="mb-4">
				<label class="label-font">Mbti</label>
				<br>
				<form:select path="mberMbti" class="bor-none  wd-170">
					<form:option value="" label="MBTI"/>
					
					<form:option value="ENFP" label="ENFP" />
					<form:option value="ENFJ" label="ENFJ" />
					<form:option value="ENTP" label="ENTP" />
					<form:option value="ENTJ" label="ENTJ" />
					
					<form:option value="ESFP" label="ESTJ" />
					<form:option value="ESFJ" label="ESFJ" />
					<form:option value="ESTP" label="ESTP" />
					<form:option value="ESTJ" label="ESTJ" />
					
					<form:option value="INFP" label="INFP" />
					<form:option value="INFJ" label="INFJ" />
					<form:option value="INTP" label="INTP" />
					<form:option value="INTJ" label="INTJ" />
					
					<form:option value="ISFP" label="ISFP" />
					<form:option value="ISFJ" label="ISFJ" />
					<form:option value="ISTP" label="ISTP" />
					<form:option value="ISTJ" label="ISTJ" />
					
				</form:select>
			</div>
				
				<form:button type="submit" class="custom-btn btn-11">
					전송
				</form:button>
			</form:form>
			<div id="liveAlertPlaceholder"></div>
		</div>
	</div>
</section>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script src="<c:url value='/resources/js/app/cstmr/auth/join.js'/>"></script>