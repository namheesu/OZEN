<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<section>
	<div>
		<div class="notice-header mx-10">
			<h1 class="cstmr-title mx-5">Find Password</h1>
		</div>
	<hr class="mt-4 mx-8">
	</div>
	<div class="g-3 mx-10 container row justify-content-center">
	<div class="p-4 p-sm-5 col-md-6 ">
		<div class="d-flex justify-content-between align-items-center mb-2 ">
		</div>	
	
		<form:form method="post" id="checkUserByIdForm">
			<div class="mb-3">
				<input placeholder="아이디를 입력하세요" name="mberId" type="text" id="mberId"
					class="form-control" value="" />
			</div>
			<div class="mb-3">
				<input placeholder="성함을 입력하세요" name="cstNm" type="text" id="cstNm"
					class="form-control" value="" />
			</div>
			<div class="mb-3">
				<input placeholder="가입 시 등록한 전화번호를 입력하세요" name="cstHp" type="text" id="cstHp"
					class="form-control" value="" />
			</div>
			<div>
				<button type="submit" class="mt-3 w-100 custom-btn btn-7">확인</button>
			</div> 
		</form:form>
		<div id="otpAuth" style="display: none;">
			<form:form method="post" class="mt-4" id="otpAuthForm" action="${pageContext.request.contextPath }/auth/otp.do">
				<input class="form-control" type="text" name="otpCd" id="otpCd" readonly="readonly"/>
				<div class="mb-2"></div>
				<input class="form-control" type="text" placeholder="Your Otp Number" name="otpNo" id="otpNo"/>
				<div class="mb-2"></div>
				<button class="custom-btn btn-6 d-block w-100 mt-3" type="submit" name="submit"><span>비밀번호 변경</span></button>
			</form:form>
			<div class="fs-10 text-600" style="display: none;" id="failDiv">인증 실패! 다시 인증해주세요</div>
		</div>
			<div class="d-flex justify-content-between align-items-center mb-4 ">
			<h5></h5>
			<p class="fs-10 text-600 mt-2 mb-2">
				이용이 처음이신가요? <a href="/authentication/simple/register">가입하기</a>
			</p>
		</div>
			<div class="w-100 position-relative text-center mt-4">
				<div class="divider-content-center"></div>
				<div>
	           	 <a class="fs-10 text-600" href="${pageContext.request.contextPath }/auth/Login.do" id="loginPage">로그인<span class="d-inline-block ms-1">&rarr;</span></a>
	            </div>
	            <div>
               	 <a class="fs-10 text-600" href="${pageContext.request.contextPath }/auth/findId.do">아이디 찾기<span class="d-inline-block ms-1">&rarr;</span></a>
	            </div>
			</div>
		</div>
	</div>
	<hr class="mx-8">
</section>
<div class="modal fade" id="changePwdModal" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
	<div class="modal-dialog modal-dialog-centered">
		<div class="modal-content">
			<div class="position-absolute top-0 end-0 mt-3 me-3 z-1" data-bs-theme="dark">
				<button class="btn-close btn btn-sm d-flex flex-center transition-base" data-bs-dismiss="modal" aria-label="Close"></button>
			</div>
			<div class="modal-body p-0">
				<div class="py-3 ps-4 pe-6 bg-1000">
					<h4 class="mb-1 text-light" id="modalExampleDemoLabel"> 비밀번호 변경 </h4>
				</div>
				<div class="p-x1 border-end-md border-bottom border-bottom-md-0 border-dashed bg-200">
					<h6 class="fs-10 mb-3">Change Password</h6>
					<form:form method="post" action="${pageContext.request.contextPath }/auth/changePwd.do" id="changePwdForm">
						<div class="row mt-2">
						<div class="col-5 col-sm-2 col-md-3 col-lg-4">
							<p class="mb-0 fs-10 fw-semi-bold text-600 text-nowrap">새 비밀번호</p>
						</div>
						<div class="col-7 col-sm-10 col-md-9 col-lg-8 d-flex align-items-center">
							<input class="form-control" id="newPwd" name="newPw" placeholder="New Password" type="password"/>
						</div>
						<div class="col-5 col-sm-2 col-md-3 col-lg-4">
							<p class="mb-0 fs-10 fw-semi-bold text-600 text-nowrap">새 비밀번호 확인</p>
						</div>
						<div class="col-7 col-sm-10 col-md-9 col-lg-8 d-flex align-items-center mt-2">
							<input class="form-control" id="newPwdChk" placeholder="New Password Check" type="password"/>
						</div>
						<div class="fs-10 text-600" style="display: none;" id="dismatch">새 비밀번호와 새 비밀번호 확인을 동일하게 입력해주세요.</div>
						</div>
						<div class="fs-10 text-600" style="display: none;" id="changedFail"></div>
					</form:form>
				</div>
			</div>
			<div class="modal-footer bg-200">
				<a class="fs-10 text-600 badge badge-subtle-danger me-1 py-1 rounded-1" type="button" href="#" data-bs-dismiss="modal">close</a>
				<a class="fs-10 text-600 badge badge-subtle-primary me-1 py-1 rounded-1" type="button" id="changeBtn">change</a>
			</div>
		</div>
	</div>
</div>

<script src="<c:url value='/resources/js/app/cstmr/auth/findPwd.js'/>"></script>