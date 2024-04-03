<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<link
	href="${pageContext.request.contextPath}/resources/css/cstmr/rsvt/rmtList.css"
	rel="stylesheet">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/flatpickr/dist/flatpickr.min.css">
<script src="https://cdn.jsdelivr.net/npm/flatpickr"></script>
<script src="https://npmcdn.com/flatpickr/dist/flatpickr.min.js"></script>
<script src="https://npmcdn.com/flatpickr/dist/l10n/ko.js"></script>
<script defer src="<c:url value="/resources/assets/js/flatpickr.js"/>"></script>

<section>

	<div>
		<div class="mt-5 mb-5 ban-img container ">
			<div class="swiper-container theme-slider"
				data-swiper='{"autoplay":true,"spaceBetween":5,"loop":true,"loopedSlides":5,"slideToClickedSlide":true}'>
				<div class="swiper-wrapper">
					<div class="swiper-slide">
						<img class="rounded-1 img-fluid"
							src="${pageContext.request.contextPath}/resources/assets/img/recomCar/dummy1.jpg"
							alt="" />
					</div>
					<div class="swiper-slide">
						<img class="rounded-1 img-fluid"
							src="${pageContext.request.contextPath}/resources/assets/img/recomCar/banner02.jpg"
							alt="" />
					</div>
					<div class="swiper-slide">
						<img class="rounded-1 img-fluid"
							src="${pageContext.request.contextPath}/resources/assets/img/recomCar/banner03.jpg"
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
	<div class="selResult mb-5">
		<div class="inner">
			<div class="infoArea d-flex">
				<div>
					<dl class="dlType01">
						<dt>HOTEL</dt>
						<dd>호텔 오젠</dd>
					</dl>
				</div>
				<div>

					<dl class="dlType02">
						<dt>DATE</dt>
						<dd class="dataText">${rsvtVO.rsvtCheckinYmd}&nbsp;~&nbsp;
							${rsvtVO.rsvtCheckoutYmd}</dd>

					</dl>
				</div>

				<div>
					<dl class="dlType03">
						<dt>ROOMS</dt>
						<dd>${rsvtVO.rsvtRoomCnt}</dd>
					</dl>
				</div>
				<div>
					<dl class="dlType03">
						<dt>ADULTS</dt>
						<c:set var="rsvtAdult1" value="${rsvtVO.rsvtAdultCnt }" />
						<c:set var="rsvtAdult2"
							value="${rsvtVO.rsvtDetails[1].rsvtDtlAdultCnt }" />
						<c:set var="rsvtAdult3"
							value="${rsvtVO.rsvtDetails[2].rsvtDtlAdultCnt }" />
						<c:set var="rsvtAdult"
							value="${rsvtAdult1 + rsvtAdult2 + rsvtAdult3 }" />
						<dd>${rsvtAdult }</dd>
					</dl>
				</div>
				<div>
					<dl class="dlType03" style="padding-right: 50px">
						<dt>CHILDREN</dt>
						<c:set var="rsvtChild1" value="${rsvtVO.rsvtChildCnt }" />
						<c:set var="rsvtChild2"
							value="${rsvtVO.rsvtDetails[1].rsvtDtlChildCnt }" />
						<c:set var="rsvtChild3"
							value="${rsvtVO.rsvtDetails[2].rsvtDtlChildCnt }" />
						<c:set var="rsvtChild"
							value="${rsvtChild1 + rsvtChild2 + rsvtChild3 }" />
						<dd>${rsvtChild}</dd>
					</dl>
				</div>
			</div>
		</div>
	</div>
	<div class="text-center mb-3 mt-5">
		<div class="btn-group btn-group-lg  text-center" role="group"
			aria-label="...">
			<ul class=" nav nav-tabs nav-tabs-bordered" role="tablist"
				style="height: 73px;">
				<c:if test="${ mmb eq true}">
					<li class="nav-item" role="presentation">
						<button class="nav-link active" data-bs-toggle="tab"
							data-bs-target="#recomRmt" aria-selected="true" role="tab">추천객실조회</button>
					</li>
					<li class="nav-item" role="presentation">
						<button class="nav-link" data-bs-toggle="tab"
							data-bs-target="#rsvtRmt" tabindex="-1" aria-selected="false"
							role="tab">객실조회</button>
					</li>
				</c:if>
				<c:if test="${ mmb eq false}">
					<li class="nav-item" role="presentation">
						<button class="nav-link active" data-bs-toggle="tab"
							data-bs-target="#rsvtRmt" aria-selected="true" role="tab">객실조회</button>
					</li>
				</c:if>
			</ul>
		</div>
	</div>
	<div class="tab-content pt-2">
		<c:if test="${ mmb eq true}">
			<div id="recomRmt" class="tab-pane fade active show" role="tabpanel">
				<div class="d-flex justify-content-center">
					<div>
						<div class="text-center mb-4" >[예약인원수 & 나이]</div>
						<h5 class="text-center mb-2" >${cstmr.cstNm } 님의 추천 기반데이터</h5>
						<div class="d-flex justify-content-center mb-3">
							<h4 style="margin-right: 30px;">인원수 : ${totalNmpr } 명</h4>
							<h4>나이 : ${age }0 대</h4>
						</div>
					</div>
				</div>
				<div class="inner">
					<div class="d-flex mb-7 container">
						<div class="">
							<div class="mt-7 mb-7 rom-img container ">
								<div class="swiper-container theme-slider"
									data-swiper='{"autoplay":true,"spaceBetween":5,"loop":true,"loopedSlides":5,"slideToClickedSlide":true}'>
									<div class="swiper-wrapper">
										<div class="swiper-slide">
											<img class="rounded-1 img-fluid"
												src="<c:url value='/resources/assets/img/room/${attRmtMap.attRmt1.rmtTypeCd}/${attRmtMap.attRmt1.attRmtFilename01}'/>"
												alt="" />
										</div>
										<div class="swiper-slide">
											<img class="rounded-1 img-fluid"
												src="<c:url value='/resources/assets/img/room/${attRmtMap.attRmt1.rmtTypeCd}/${attRmtMap.attRmt1.attRmtFilename02}'/>"
												alt="" />
										</div>
										<div class="swiper-slide">
											<img class="rounded-1 img-fluid"
												src="<c:url value='/resources/assets/img/room/${attRmtMap.attRmt1.rmtTypeCd}/${attRmtMap.attRmt1.attRmtFilename03}'/>"
												alt="" />
										</div>
										<div class="swiper-slide">
											<img class="rounded-1 img-fluid"
												src="<c:url value='/resources/assets/img/room/${attRmtMap.attRmt1.rmtTypeCd}/${attRmtMap.attRmt1.attRmtFilename04}'/>"
												alt="" />
										</div>
									</div>
									<div class="swiper-nav">
										<div class="swiper-button-next swiper-button-white"></div>
										<div class="swiper-button-prev swiper-button-white"></div>
									</div>
								</div>
							</div>
							<div class="col-auto align-self-center">
								<form:form id="submitForm" method="post"
									action="${pageContext.request.contextPath}/cstmr/rsvt/rsvtStep02">
									<table class="container room-table">
										<tr>
											<th colspan="10" class="roomType-e">${attRmtMap.attRmt1.rmtype.rmtNm}</th>
										</tr>
										<tr>
											<th colspan="10" class="roomType">${attRmtMap.attRmt1.rmtype.rmtNmDetails}</th>
										</tr>

										<tr class="content">
											<th class="bedType tr-pad">침대타입</th>
											<td colspan="4" class="bedCon tr-pad">${attRmtMap.attRmt1.rmtype.rmtBedType}</td>
											<th class="tr-pad">투숙인원</th>
											<td colspan="4" class="tr-pad">${attRmtMap.attRmt1.rmtype.rmtMaxnbrCnt}명</td>
										</tr>
										<tr class="content">
											<th class="bedType tr-pad">체크인시간</th>
											<td colspan="4" class="bedCon tr-pad">${attRmtMap.attRmt1.rmtype.rmtChkinTime}</td>
											<th class="tr-pad">체크아웃시간</th>
											<td colspan="4" class="tr-pad">${attRmtMap.attRmt1.rmtype.rmtChkoutTime}</td>
										</tr>
										<tr class="co-mid">
											<th colspan="4" class="tr-pad ">
												<button
													class="btn btn-outline-dark cost btn-res2 btn-res mb-1 un-radi"
													type="submit" id="submitBtn">
													<fmt:formatNumber
														value="${attRmtMap.attRmt1.rmtype.rmtAmnt}"
														pattern="#,###" />
													won
												</button>
											</th>
										</tr>
									</table>
									<input type="hidden" name="rmtTypeCd"
										value="${attRmtMap.attRmt1.rmtTypeCd}">
								</form:form>
							</div>
						</div>
						<div class="">
							<div class="mt-7 mb-7 rom-img container">
								<div class="swiper-container theme-slider"
									data-swiper='{"autoplay":true,"spaceBetween":5,"loop":true,"loopedSlides":5,"slideToClickedSlide":true}'>
									<div class="swiper-wrapper">
										<div class="swiper-slide">
											<img class="rounded-1 img-fluid"
												src="<c:url value='/resources/assets/img/room/${attRmtMap.attRmt2.rmtTypeCd}/${attRmtMap.attRmt2.attRmtFilename01}'/>"
												alt="" />
										</div>
										<div class="swiper-slide">
											<img class="rounded-1 img-fluid"
												src="<c:url value='/resources/assets/img/room/${attRmtMap.attRmt2.rmtTypeCd}/${attRmtMap.attRmt2.attRmtFilename02}'/>"
												alt="" />
										</div>
										<div class="swiper-slide">
											<img class="rounded-1 img-fluid"
												src="<c:url value='/resources/assets/img/room/${attRmtMap.attRmt2.rmtTypeCd}/${attRmtMap.attRmt2.attRmtFilename03}'/>"
												alt="" />
										</div>
										<div class="swiper-slide">
											<img class="rounded-1 img-fluid"
												src="<c:url value='/resources/assets/img/room/${attRmtMap.attRmt2.rmtTypeCd}/${attRmtMap.attRmt2.attRmtFilename04}'/>"
												alt="" />
										</div>
									</div>
									<div class="swiper-nav">
										<div class="swiper-button-next swiper-button-white"></div>
										<div class="swiper-button-prev swiper-button-white"></div>
									</div>
								</div>
							</div>
							<div class="col-auto align-self-center">
								<form:form id="submitForm" method="post"
									action="${pageContext.request.contextPath}/cstmr/rsvt/rsvtStep02">
									<table class="container room-table">
										<tr>
											<th colspan="10" class="roomType-e">${attRmtMap.attRmt2.rmtype.rmtNm}</th>
										</tr>
										<tr>
											<th colspan="10" class="roomType">${attRmtMap.attRmt2.rmtype.rmtNmDetails}</th>
										</tr>

										<tr class="content">
											<th class="bedType tr-pad">침대타입</th>
											<td colspan="4" class="bedCon tr-pad">${attRmtMap.attRmt2.rmtype.rmtBedType}</td>
											<th class="tr-pad">투숙인원</th>
											<td colspan="4" class="tr-pad">${attRmtMap.attRmt2.rmtype.rmtMaxnbrCnt}명</td>
										</tr>
										<tr class="content">
											<th class="bedType tr-pad">체크인시간</th>
											<td colspan="4" class="bedCon tr-pad">${attRmtMap.attRmt2.rmtype.rmtChkinTime}</td>
											<th class="tr-pad">체크아웃시간</th>
											<td colspan="4" class="tr-pad">${attRmtMap.attRmt2.rmtype.rmtChkoutTime}</td>
										</tr>
										<tr class="co-mid">
											<th colspan="4" class="tr-pad ">
												<button
													class="btn btn-outline-dark cost btn-res2 btn-res mb-1 un-radi"
													type="submit" id="submitBtn">
													<fmt:formatNumber
														value="${attRmtMap.attRmt2.rmtype.rmtAmnt}"
														pattern="#,###" />
													won
												</button>
											</th>
										</tr>
									</table>
									<input type="hidden" name="rmtTypeCd"
										value="${attRmtMap.attRmt2.rmtTypeCd}">
								</form:form>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div id="rsvtRmt" class="tab-pane fade " role="tabpanel">
				<div class="inner row">
					<c:forEach var="item" items="${attatchRmTypeVO}" varStatus="cnt">
						<div class="col-sm-6">
							<div class="mt-5 mb-7 rom-img container ">
								<div class="swiper-container theme-slider"
									data-swiper='{"autoplay":true,"spaceBetween":5,"loop":true,"loopedSlides":5,"slideToClickedSlide":true}'>
									<div class="swiper-wrapper">
										<div class="swiper-slide">
											<img class="rounded-1 img-fluid"
												src="${pageContext.request.contextPath}/resources/assets/img/room/${item.rmtype.rmtTypeCd}/${item.attRmtFilename01}"
												alt="" />
										</div>
										<div class="swiper-slide">
											<img class="rounded-1 img-fluid"
												src="${pageContext.request.contextPath}/resources/assets/img/room/${item.rmtype.rmtTypeCd}/${item.attRmtFilename02}"
												alt="" />
										</div>
										<div class="swiper-slide">
											<img class="rounded-1 img-fluid"
												src="${pageContext.request.contextPath}/resources/assets/img/room/${item.rmtype.rmtTypeCd}/${item.attRmtFilename03}"
												alt="" />
										</div>
										<div class="swiper-slide">
											<img class="rounded-1 img-fluid"
												src="${pageContext.request.contextPath}/resources/assets/img/room/${item.rmtype.rmtTypeCd}/${item.attRmtFilename04}"
												alt="" />
										</div>
									</div>
									<div class="swiper-nav">
										<div class="swiper-button-next swiper-button-white"></div>
										<div class="swiper-button-prev swiper-button-white"></div>
									</div>
								</div>
							</div>

							<div class="col-auto align-self-center "
								style="margin-left: 10px;">
								<form:form id="submitForm" method="post"
									action="${pageContext.request.contextPath}/cstmr/rsvt/rsvtStep02">
									<table class="container room-table">

										<tr>
											<th colspan="10" class="roomType-e">${item.rmtype.rmtNm}</th>
										</tr>
										<tr>
											<th colspan="10" class="roomType">${item.rmtype.rmtNmDetails}</th>
										</tr>

										<tr class="content">
											<th class="bedType tr-pad">침대타입</th>
											<td colspan="4" class="bedCon tr-pad">${item.rmtype.rmtBedType}
												${item.rmtype.rmtBedCnt}개</td>
											<th class="tr-pad">투숙인원</th>
											<td colspan="4" class="tr-pad">${item.rmtype.rmtMaxnbrCnt}명</td>
										</tr>
										<tr class="content">
											<th class="bedType tr-pad">체크인시간</th>
											<td colspan="4" class="bedCon tr-pad">15:00</td>
											<th class="tr-pad">체크아웃시간</th>
											<td colspan="4" class="tr-pad">11:00</td>
										</tr>
										<tr class="co-mid">
											<th colspan="4" class="tr-pad ">
												<button
													class="btn btn-outline-dark cost btn-res2 btn-res mb-1 un-radi"
													type="submit" id="submitBtn">
													<fmt:formatNumber value="${item.rmtype.rmtAmnt}"
														pattern="#,###" />
													won
												</button>
											</th>
										</tr>
									</table>
									<input type="hidden" name="rmtTypeCd"
										value="${item.rmtype.rmtTypeCd}">

								</form:form>
							</div>
						</div>
					</c:forEach>
				</div>
			</div>
		</c:if>
		<c:if test="${ mmb eq false}">
			<div id="rsvtRmt" class="tab-pane fade active show" role="tabpanel">
				<div class="inner row">
					<c:forEach var="item" items="${attatchRmTypeVO}" varStatus="cnt">
						<div class="col-sm-6">
							<div class="mt-5 mb-7 rom-img container ">
								<div class="swiper-container theme-slider"
									data-swiper='{"autoplay":true,"spaceBetween":5,"loop":true,"loopedSlides":5,"slideToClickedSlide":true}'>
									<div class="swiper-wrapper">
										<div class="swiper-slide">
											<img class="rounded-1 img-fluid"
												src="${pageContext.request.contextPath}/resources/assets/img/room/${item.rmtype.rmtTypeCd}/${item.attRmtFilename01}"
												alt="" />
										</div>
										<div class="swiper-slide">
											<img class="rounded-1 img-fluid"
												src="${pageContext.request.contextPath}/resources/assets/img/room/${item.rmtype.rmtTypeCd}/${item.attRmtFilename02}"
												alt="" />
										</div>
										<div class="swiper-slide">
											<img class="rounded-1 img-fluid"
												src="${pageContext.request.contextPath}/resources/assets/img/room/${item.rmtype.rmtTypeCd}/${item.attRmtFilename03}"
												alt="" />
										</div>
										<div class="swiper-slide">
											<img class="rounded-1 img-fluid"
												src="${pageContext.request.contextPath}/resources/assets/img/room/${item.rmtype.rmtTypeCd}/${item.attRmtFilename04}"
												alt="" />
										</div>
									</div>
									<div class="swiper-nav">
										<div class="swiper-button-next swiper-button-white"></div>
										<div class="swiper-button-prev swiper-button-white"></div>
									</div>
								</div>
							</div>

							<div class="col-auto align-self-center "
								style="margin-left: 10px;">
								<form:form id="submitForm" method="post"
									action="${pageContext.request.contextPath}/cstmr/rsvt/rsvtStep02">
									<table class="container room-table">

										<tr>
											<th colspan="10" class="roomType-e">${item.rmtype.rmtNm}</th>
										</tr>
										<tr>
											<th colspan="10" class="roomType">${item.rmtype.rmtNmDetails}</th>
										</tr>

										<tr class="content">
											<th class="bedType tr-pad">침대타입</th>
											<td colspan="4" class="bedCon tr-pad">${item.rmtype.rmtBedType}
												${item.rmtype.rmtBedCnt}개</td>
											<th class="tr-pad">투숙인원</th>
											<td colspan="4" class="tr-pad">${item.rmtype.rmtMaxnbrCnt}명</td>
										</tr>
										<tr class="content">
											<th class="bedType tr-pad">체크인시간</th>
											<td colspan="4" class="bedCon tr-pad">15:00</td>
											<th class="tr-pad">체크아웃시간</th>
											<td colspan="4" class="tr-pad">11:00</td>
										</tr>
										<tr class="co-mid">
											<th colspan="4" class="tr-pad ">
												<button
													class="btn btn-outline-dark cost btn-res2 btn-res mb-1 un-radi"
													type="submit" id="submitBtn">
													<fmt:formatNumber value="${item.rmtype.rmtAmnt}"
														pattern="#,###" />
													won
												</button>
											</th>
										</tr>
									</table>
									<input type="hidden" name="rmtTypeCd"
										value="${item.rmtype.rmtTypeCd}">

								</form:form>
							</div>
						</div>
					</c:forEach>
				</div>
			</div>
		</c:if>
	</div>
</section>

<script>
	$(document).ready(function() {
		$("#submitBtn").click(function() {
			$("#submitForm").submit();
		});
	});
</script>