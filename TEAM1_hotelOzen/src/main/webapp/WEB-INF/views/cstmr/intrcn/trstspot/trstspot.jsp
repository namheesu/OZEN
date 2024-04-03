<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<link
	href="${pageContext.request.contextPath}/resources/css/cstmr/intrcn/trstspot/trstspot.css"
	rel="stylesheet">
<section>
	<div>
		<div class="recomCar-header mx-10">
			<h1 class="cstmr-title mx-5">주변 관광지</h1>
			<p class="cstmr-content mx-5 mb-5">호텔 오젠 주변 관광지</p>
		</div>
	</div>
	<div class="d-flex justify-content-center mt-7 mb-6">
		<div class="trst-box">
			<div class="d-flex trst-inner end justify-content-center">
				<div style="margin: 0px;">
					<div class="col-auto">
						<div class=" container">
							<div class="swiper-container theme-slider"
								data-swiper='{"autoplay":true,"spaceBetween":5,"loop":true,"loopedSlides":5,"slideToClickedSlide":true}'>
								<div class="swiper-wrapper">
									<div class="swiper-slide">
										<img class="rounded-1 img-fluid"
											src="<c:url value='/resources/assets/img/trstspot/trstspot1.jpg'/>"
											alt="" />
									</div>
									<div class="swiper-slide">
										<img class="rounded-1 img-fluid"
											src="<c:url value='/resources/assets/img/trstspot/trstspot2.jpg'/>"
											alt="" />
									</div>
									<div class="swiper-slide">
										<img class="rounded-1 img-fluid"
											src="<c:url value='/resources/assets/img/trstspot/trstspot3.jpg'/>"
											alt="" />
									</div>
									<div class="swiper-slide">
										<img class="rounded-1 img-fluid"
											src="<c:url value='/resources/assets/img/trstspot/trstspot4.jpg'/>"
											alt="" />
									</div>
								</div>
								<div class="swiper-nav">
									<div class="swiper-button-next swiper-button-white"></div>
									<div class="swiper-button-prev swiper-button-white"></div>
								</div>
							</div>
						</div>
					</div>
				</div>
				<div>
					<div class="margin-left">
						<div class="trst-title-box">
							<h1 class="trst-title">엉또폭포</h1>
							<h5 class="trst-subti">제주 서귀포시 강정동</h5>
						</div>
						<div>
							<p>
								엉또폭포는 위치적으로는 강정동에 속해 있지만, 지리적으로는 한라산에 위치해 있는 폭포다. <br>한국에서
								설악산에 있는 토왕성 폭포와 함께 유이하게 비가 올때에만 물이 흐르는 건 폭포이기도 하다. 제주도내 다른 폭포들은
								평상시에도 물이 흐르지만, 엉또폭포는 70mm 이상의 비가 와야 물이 흐르고 보통은 물이 흐르지 않고 마른 상태를
								유지한다.
							</p>
						</div>
						<div>
							<h5 class="trst-amnt">입장비 : 무료</h5>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="d-flex justify-content-center mb-6">
		<div class="trst-box">
			<div class="d-flex justify-content-center">
				<div class="end">
					<div class="margin-right">
						<div class=" trst-title-left">
							<h1 class="trst-title right">법환포구</h1>
							<h5 class="margin-left right" style="margin-top: 15px;">제주특별자치도 서귀포시 막숙포로 46 (법환동)</h5>
						</div>
						<div class="mb-3" style="text-align: right;">
								제주 올레 7코스에 속해 있어, 도보 여행객들이 주변의 경치를 	감상하기에 좋다. <br>
								이곳에서 바다 위에 범섬, 섶섬, 문섬, 새섬을 한눈에 볼 수 있다. 해녀 조각상이 설치된 <br>
								‘잠녀 광장’이 조성되어 있고, 낚시를 즐기는 사람들의 모습도 볼 수 있어, <br>
								바다와 자연스럽게 조화된 제주만의 아름다운 분위기를 느낄 수 있다. <br>
						</div>
						<div>
							<h5 class="right">입장비 : 무료</h5>
						</div>
					</div>
				</div>
				<div style="margin: 0px;">
					<div class="col-auto">
						<div class="container">
							<div class="swiper-container theme-slider"
								data-swiper='{"autoplay":true,"spaceBetween":5,"loop":true,"loopedSlides":5,"slideToClickedSlide":true}'>
								<div class="swiper-wrapper">
									<div class="swiper-slide">
										<img class="rounded-1 img-fluid"
											src="<c:url value='/resources/assets/img/trstspot/trstspaot_2_1.jpg'/>"
											alt="" />
									</div>
									<div class="swiper-slide">
										<img class="rounded-1 img-fluid"
											src="<c:url value='/resources/assets/img/trstspot/trstspaot_2_2.jpg'/>"
											alt="" />
									</div>
									<div class="swiper-slide">
										<img class="rounded-1 img-fluid"
											src="<c:url value='/resources/assets/img/trstspot/trstspaot_2_3.jpg'/>"
											alt="" />
									</div>
								</div>
								<div class="swiper-nav">
									<div class="swiper-button-next swiper-button-white"></div>
									<div class="swiper-button-prev swiper-button-white"></div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</section>
