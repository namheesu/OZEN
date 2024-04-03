<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>


<link href="${pageContext.request.contextPath}/resources/css/cstmr/auth/findResult.css" rel="stylesheet">

<section>
	<div>
		<div class="notice-header">
			<h1 class="cstmr-title mx-6">MEMBERSHIP</h1>
			<p class="cstmr-content mx-6 mb-5">
			오젠 멤버십은 품격있는 라이프스타일과 특별한 경험을 제안합니다.
			<br>
			오젠 호텔에서 다채로운 혜택과 최상의 서비스를 누려보세요.
			</p>
		</div>
	</div>
	
	<div class="text-center d-flex justify-content-center">
	<div class="g-3 mx-10 container row justify-content-center">
	<div class="p-4 p-sm-5 col-md-8 ">
		
	<div class="complete-info-inner ">
		<div class="complete-info">
			<div class="complete-box" data-target="cardBox">
				<div class="box-item text-center">
					<div class="img-area ">
						<img src="${pageContext.request.contextPath }/resources/assets/img/mbrsh/${mbsGrdCd }.png" alt="card" class="m-none" style="width:220px; height:142px; border-radius:12px;">
					</div>
					<div>
						<h4 class="mt-2 mbsGrdCd"> 
							${mbsGrdCd }
						</h4>
					</div>
				</div>
				<div class="box-item">
					<div class="text-area">
						<p class="m-none">
							<span class="type f-bold">성명</span>
							<br>
							<span class="info" data-name="">${realUser.cst.cstNm }</span>
						</p>
						<p class="webAccountId" style="display: inline-block;">
							<span class="type f-bold">가입일자</span>
							<br>
							<span class="info" id="subDay"></span>
						</p>
						<br>
						<p class="webAccountId" style="display: inline-block;">
							<span class="type f-bold">만료일자</span>
							<br>
							<span class="info" id="expDay"></span>
						</p>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="row mx-2 justify-content-center mt-6" >
		<button class="custom-btn btn-1 home-btn" onclick="location.href='${pageContext.request.contextPath}/'">HOME</button>
	</div> 

	</div>
	</div>
	</div>
	<hr class="mx-8">
	
</section>
<script>
	let today = new Date();
	
	subDay.innerHTML =  today.toLocaleDateString();
	expDay.innerHTML = new Date(today.setDate(today.getDate() + 365)).toLocaleDateString();
</script>
