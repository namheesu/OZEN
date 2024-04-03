<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<link href="${pageContext.request.contextPath}/resources/css/cstmr/auth/findResult.css" rel="stylesheet">

<section>
	<div>
		<div class="notice-header mx-10">
			<h1 class="cstmr-title mx-5">Find Id</h1>
		</div>
	<hr class="mt-4 mx-8">
	</div>
	<div class="g-3 mx-10 container row justify-content-center">
	<div class="p-4 p-sm-5 col-md-8 ">
		
	<div class="complete-info-inner ">
		<div class="complete-info">
			<div class="complete-box" data-target="cardBox">
				<div class="box-item">
					<div class="img-area">
						<img src="${pageContext.request.contextPath }/resources/assets/img/account.png" alt="card" class="m-none">
					</div>
				</div>
				<div class="box-item">
					<div class="text-area">
						<p class="m-none">
							<span class="type f-bold">성명</span>
							<br>
							<span class="info" data-name="">${realUser.cstNm }</span>
						</p>
						<p class="webAccountId" style="display: inline-block;">
							<span class="type f-bold">아이디</span>
							<br>
							<span class="info" data-id="">${realUser.mber.mberId }</span>
						</p>
					</div>
				</div>
			</div>
		</div>
	</div>
			<div class="row mx-2">
				<button type="button" class="mt-6 custom-btn btn-3 mx-1 col" onclick="location.href='${pageContext.request.contextPath}'/auth/findPwd.do"><span>비밀번호 찾기</span></button>
				<button type="button" class="mt-6 custom-btn btn-7 mx-1 col" onclick="location.href='${pageContext.request.contextPath}'/auth/Login.do'"><span>로그인</span></button>
			</div> 

	</div>
	</div>
	<hr class="mx-8">
	
</section>