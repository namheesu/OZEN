<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<link
	href="${pageContext.request.contextPath}/resources/css/cstmr/rsvt/rsvtList.css"
	rel="stylesheet">
<section>
	<div>
		<div class="mt-7 mb-3 ban-img container ">
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
	<div class="inner">
		<div class="container recom-table text-center mb-5">
			<div class="btn-group btn-group-lg container text-center" role="group"
				aria-label="...">
				<a class="btn btn-dark btn-outline-dark mb-1 text-white"
					id="recomCar" href="${pageContext.request.contextPath}/cstmr/rsvt/recomRsvtList">추천 객실 조회</a>
				<a class="btn btn-outline-dark mb-1" id="recomSbrs"
					href="${pageContext.request.contextPath}/cstmr/rsvt/rsvtStep01">객실 조회</a>
			</div>
		</div>
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
							<th class="bak">1박</th>
							<th class="cost">${attRmtMap.attRmt1.rmtype.rmtAmnt}</th>
						</tr>
					</table>
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
							<th class="bak">1박</th>
							<th class="cost">${attRmtMap.attRmt2.rmtype.rmtAmnt}</th>
						</tr>
					</table>
				</div>
			</div>
		</div>

	</div>
</section>