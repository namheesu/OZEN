<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<c:choose>
	<c:when test="${ empty cstNm }">
		<script>
			location.href = document.body.dataset.contextPath + "/error/404"
		</script>
	</c:when>
</c:choose>

<section>
	<div>
		<div class="mx-10 text-center">
			<h1 class="cstmr-title ">회원가입이 완료되었습니다.</h1>
			<h6 class="cstmr-content ">오젠 호텔의 회원이 되신 것을 환영합니다.</h6>
		</div>
	</div>
	
	<div class="text-center d-flex justify-content-center"> 
	<div class="g-3 mx-10 container row justify-content-center mt-3">

		<div class="card-body" style="background-color: #F9F9F9;">
			<div class="justify-content-center row">
				<div class="col-xxl-6 col-lg-8">
					<div class="card-body mt-6">
						<h3 class="fw-semibold">안녕하십니까 ${cstNm }님</h3>
						<p>오젠 호텔에 가입하신 것을 진심으로 환영합니다.</p>
						<div class="text-center">
							<button type="button" class="my-3 custom-btn btn-15 btn-lg"
								onclick="location.href='${pageContext.request.contextPath }/auth/Login.do'">
								<span>Login</span>
							</button>
						</div>

						<hr>
						<div class="g-3 mb-6 row">
							<div class="col-sm-6">
								<div class="overflow-hidden card" style="min-width: 12rem;">
									<div class="position-relative card-body">
										<a class="col-md-6"
											href="${pageContext.request.contextPath }/myinfo/mypage.do">
											<span class="icoArr">부가 정보 등록</span>
											<p class="txt">
												맞춤형 서비스 제공을 위해 고객님의 <br>추가 정보를 입력해주세요.
											</p> <span class="fw-semibold fs-10 text-nowrap">My Page <span
												class="fas fa-angle-right fs-10"></span>
										</span>
										</a>
									</div>
								</div>
							</div>
							<div class="col-sm-6">
								<div class="overflow-hidden card" style="min-width: 12rem;">
									<div class="position-relative card-body">
										<a class="col-md-6" href="/membership/event.do?_method=list">
											<span class="icoArr">멤버십 이벤트 보러가기</span>
											<p class="txt">
												멤버십 회원님만을 위해 준비 된 <br>다양한 이벤트를 확인해보세요.
											</p> <span class="fw-semibold fs-10 text-nowrap">See all <span
												class="fas fa-angle-right fs-10"></span>
										</span>
										</a>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	</div>
</section>
