<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<link href="${pageContext.request.contextPath}/resources/css/cstmr/myinfo/pwchange.css"
rel="stylesheet">

<div class="mypage-detail-title">
	비밀번호 변경 페이지
</div>

<div class="myContents">
	<form id="pwChangeForm" method="post" action="${pageContext.request.contextPath }/myinfo/mypwchange.do">
	<input type="hidden" name="cstNo" value="${user.cstNo }">
	<p class="pageGuide tleft">
		현재 비밀번호를 올바르게 입력해야만 비밀번호 변경이 가능합니다.
	</p>
	<div class="frmInfo">
		<ul class="intList">
			<li>
				<div class="intWrap">
					<span class="tit"><label for="userpw">CURRENT
							PASSWORD</label><span class="essential">필수</span></span>
				</div>
				<div class="intInner">
					<span class="intArea"><input type="password"
						id="mberPw" name="mberPw"
						placeholder="현재 비밀번호를 입력해주세요." style="width: 360px"
						aria-required="true">
					</span>
				</div>
			</li>
			<li>
				<div class="intWrap">
					<span class="tit"><label for="userpw">NEW PASSWORD</label><span
						class="essential">필수</span></span>
				</div>
				<div class="intInner">
					<span class="intArea"><input type="password"
						id="newPw" name="newPw"
						placeholder="영문, 숫자, 특수문자 조합 8~12자리를 입력해주세요." style="width: 437px"
						aria-required="true">
						<span class="alertMessage" id="pwdMessage">
							비밀번호를 입력해주세요.
						</span>
					</span>
				</div>
				<p class="txtGuide">
					영어, 숫자, 특수문자를 혼합하여 8~16자리로 입력해주세요.
				</p>
			</li>
			<li class="intList-repwd">
				<div class="intWrap">
					<span class="tit">
						<label for="userpw-re">CONFIRM PASSWORD</label>
						<span class="essential">필수</span>
					</span>
				</div>
				<div class="intInner">
					<span class="intArea">
						<input type="password" id="newPwdChk"
						placeholder="동일한 비밀번호를 입력해주세요." style="width: 437px"
						aria-required="true">
						<span class="alertMessage" id="sameMessage">
							동일한 비밀번호를 입력해주세요.
						</span>
					</span>
				</div>
			</li>
		</ul>
		<div id="errorMessageField">
		
		</div>
	</div>
	<div class="btnArea">
		<button type="submit" class="btnSC btnL active">
			확인
		</button>
	</div>
	</form>
</div>