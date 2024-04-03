<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<link
	href="${pageContext.request.contextPath}/resources/css/cstmr/rsvt/rsvt.css"
	rel="stylesheet">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/flatpickr/dist/flatpickr.min.css">
<script src="https://cdn.jsdelivr.net/npm/flatpickr"></script>
<script src="https://npmcdn.com/flatpickr/dist/flatpickr.min.js"></script>
<script src="https://npmcdn.com/flatpickr/dist/l10n/ko.js"></script>
<script type="text/javascript"
	src="http://code.jquery.com/jquery-2.1.4.js"></script>
<section>

	<div class=" mt-5 inner">
		<form:form id="submitForm" method="post"
			action="${pageContext.request.contextPath}/cstmr/rsvt/rsvtStep03">
			<div class=" d-flex">
				<div class="accordion container mb-5 mar" id="accordionExample">
					<c:set var="rsvtRoomCnt" value="${rsvtVO.rsvtRoomCnt}" />
					<c:set var="roomCnt" value="${rsvtRoomCnt - 1 }" />
					<c:forEach var="i" begin="0" end="${roomCnt}">
						<div class="accordion-item">
							<h2 class="accordion-header" id="heading${i+1}">
								<button class="accordion-button" type="button"
									data-bs-toggle="collapse" data-bs-target="#collapse${i+1}"
									aria-expanded="true" aria-controls="collapse${i+1}">객실${i+1}</button>
							</h2>
							<div class="accordion-collapse collapse show" id="collapse${i+1}"
								aria-labelledby="heading${i+1}"
								data-bs-parent="#accordionExample">
								<div class="accordion-body">
									<div class="d-flex mt-3 mb-3">
										<div class="rom-img container mx-0">
											<div class="swiper-container theme-slider"
												data-swiper='{"autoplay":true,"spaceBetween":5,"loop":true,"loopedSlides":5,"slideToClickedSlide":true}'>
												<div class="swiper-wrapper">
													<div class="swiper-slide">
														<img class="rounded-1 img-fluid"
															src="${pageContext.request.contextPath}/resources/assets/img/room/${roomType.rmtTypeCd}/${roomType.attRmtFilename01 }"
															alt="" />
													</div>
													<div class="swiper-slide">
														<img class="rounded-1 img-fluid"
															src="${pageContext.request.contextPath}/resources/assets/img/room/${roomType.rmtTypeCd}/${roomType.attRmtFilename02}"
															alt="" />
													</div>
													<div class="swiper-slide">
														<img class="rounded-1 img-fluid"
															src="${pageContext.request.contextPath}/resources/assets/img/room/${roomType.rmtTypeCd}/${roomType.attRmtFilename03 }"
															alt="" />
													</div>
												</div>
												<div class="swiper-nav">
													<div class="swiper-button-next swiper-button-white"></div>
													<div class="swiper-button-prev swiper-button-white"></div>
												</div>
											</div>
										</div>
										<div class="mx-3 mt-2">
											<div class="mx-3 mb-3">
												<h5 class="mb-2">${roomType.rmtype.rmtNm}</h5>
												<h1 class="rsvt-title">${roomType.rmtype.rmtNmDetails}</h1>
											</div>
											<div>
												<table class="rs-table table">
													<tr>
														<th>호텔 및 객실</th>
														<td>오젠호텔, ${roomType.rmtype.rmtNmDetails}</td>
													</tr>
													<tr>
														<th>투숙날짜</th>

														<td>${rsvtVO.rsvtCheckinYmd }&nbsp;월&nbsp;-&nbsp;${rsvtVO.rsvtCheckoutYmd }&nbsp;수
															(${rsvtVO.rsvtDay}박)</td>
													</tr>
													<tr>
														<th>인원</th>
														<td>성인 ${rsvtVO.rsvtDetails[i].rsvtDtlAdultCnt} , 어린이
															${rsvtVO.rsvtDetails[i].rsvtDtlChildCnt}</td>
													</tr>

												</table>
											</div>
										</div>
									</div>
								</div>

							</div>
						</div>
					</c:forEach>
				</div>
				<c:set var="roomAmnt" value="${roomType.rmtype.rmtAmnt}" />
				<c:set var="rsvtRoomCnt" value="${rsvtVO.rsvtRoomCnt}" />
				<c:set var="rsvtDay" value="${rsvtVO.rsvtDay}" />
				<c:set var="totalAmnt" value="${roomAmnt * rsvtRoomCnt * rsvtDay}" />
				<div>
					<c:forEach var="i" begin="1" end="${rsvtVO.rsvtRoomCnt}">
						<div class="r-box">

							<h5 class="mb-2">객실${i}</h5>

							<h2 class="rsvt-title mb-4">
								<fmt:formatNumber value="${roomAmnt * rsvtDay}" pattern="#,###" />
								원
							</h2>

							<table class="rs-body">
								<tr>
									<td>1박</td>
									<th><fmt:formatNumber value="${roomType.rmtype.rmtAmnt}"
											pattern="#,###" />원</th>
								</tr>
							</table>
						</div>
					</c:forEach>
					<div class="d-flex mt-5 rs-fo">
						<h5 class="py-cus">총 예약금액</h5>
						<h2 class="rsvt-cost">

							<fmt:formatNumber value="${totalAmnt}" pattern="#,###" />
							원
						</h2>
					</div>
					<button class="btn btn-outline-dark rsv-btn mb-1 mt-3 un-radi"
						type="submit" id="submitBtn">예약하기</button>
				</div>
			</div>
		</form:form>
	</div>
</section>
<script>
	$(document).ready(function() {
		$("#submitBtn").click(function() {
			$("#submitForm").submit();
		});
	});
</script>
<script defer
	src="<c:url value='/resources/js/app/cstmr/rsvt/rsvtStep02.js'/>"></script>