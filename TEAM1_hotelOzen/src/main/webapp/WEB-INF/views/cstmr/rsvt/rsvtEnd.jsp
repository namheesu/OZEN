<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<link
	href="${pageContext.request.contextPath}/resources/css/cstmr/rsvt/rsvtEnd.css"
	rel="stylesheet">
<section>
	<div>
		<div>
			<div class="mx-10 text-center">
				<h1 class="cstmr-title jungChultFont">예약이 완료되었습니다.</h1>
				<h6 class="cstmr-content jungChultFont">오젠 호텔에서 최고의 휴식을 누리세요.</h6>
			</div>
		</div>
		<script>
			console.log("나와라 : ",${realMber});
		</script>
		<div class="center mt-5">
			<table class="table">
				<tr class="black">
					<th id="rsvtNo">예약번호</th>
					<th id="cstmrNm">고객명</th>
					<th id="rsvtYmd">예약일자</th>
					<th id="roomCnt" class="text-center">객실수</th>
					<th id="adultCnt" class="text-center">성인수</th>
					<th id="childCnt" class="text-center">아동수</th>
				</tr>
				
				<tr>
					<td>${rsvtVO.rsvtNo}</td>
					<td>${realMber.cst.cstNm}</td>
					<td>${rsvtVO.rsvtCheckinYmd}&nbsp;&nbsp;-&nbsp;&nbsp;${rsvtVO.rsvtCheckoutYmd}(${rsvtVO.rsvtDay}박)</td>
					<td class="text-center">${rsvtVO.rsvtRoomCnt}&nbsp;개</td>
					<td class="text-center">${rsvtVO.rsvtAdultCnt}&nbsp;명</td>
					<td class="text-center">${rsvtVO.rsvtChildCnt}&nbsp;명</td>
				</tr>
			</table>
		</div>
		<c:set var="rsvtRoomCnt" value="${rsvtVO.rsvtRoomCnt}" />
		<c:set var="roomCnt" value="${rsvtRoomCnt - 1 }" />
		<c:forEach var="i" begin="0" end="${roomCnt}">
			<div class="box">
				<div class="g-3 mx-10 container row justify-content-center mt-3">
					<div class="card-body" style="background-color: #F9F9F9;">
						<div class="justify-content-center row">
							<div class="col-xxl-6 col-lg-8 center">
								<div class="card-body mt-4 center">
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
														<td>오젠호텔,
															${roomType.rmtype.rmtNmDetails}</td>
													</tr>
													<tr>
														<th>투숙날짜</th>

														<td>${rsvtVO.rsvtCheckinYmd }&nbsp;&nbsp;-&nbsp;&nbsp;${rsvtVO.rsvtCheckoutYmd }&nbsp;
															(${rsvtVO.rsvtDay}박)</td>
													</tr>
													<tr>
														<th>예약인원</th>
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
					</div>
				</div>
			</div>
		</c:forEach>
	</div>
</section>
>
