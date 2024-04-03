<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<link href="${pageContext.request.contextPath}/resources/css/cstmr/intrcn/location/location.css" rel="stylesheet">

<section>
	<div>
		<div class="location-header mx-10">
			<h1 class="cstmr-title mx-5">오시는길</h1>
			<p class="cstmr-content mx-5 mb-5">호텔 오젠에 오신걸 환영합니다.</p>
		</div>
		<div id="map" class="hotelMap mx-8"></div>
	</div>
	
	<div class="wrap">
		<div class="location-info mx-9">
			<div class="location-info_inner">
				<h2 class="location_title">주소</h2>
				<hr class="hr_title mb-5">
			</div>
			<div class="location_detail">
				<p>제주특별자치도 서귀포시 강정동 724-3</p>
			</div>
			<div class=" d-flex location_addr">
				<b>MAIL</b>
				<p>ozen@hotelozen.com</p>
				<b class="b_inner">TEL</b>
				<p>064-233-3426</p>
				<b class="b_inner">FAX</b>
				<p>064-233-3777</p>
			</div>
			<div class="location-info_inner">
				<h2 class="location_title">대중교통 이용 시</h2>
				<hr class="hr_title">
			</div>
		</div>
		
		<div class="acc_top">
			<div class="accordion accordion-flush mx-9" id="accordionFlushExample">
			  <div class="accordion-item">
			    <h2 class="busHeader">
			      <button class="accordion-button collapsed text-dark py-5 busButton" type="button" data-bs-toggle="collapse" data-bs-target="#flush-collapseTwo" aria-expanded="false" aria-controls="flush-collapseTwo">
			        <p>버스</p>
			      </button>
			    </h2>
			    <div id="flush-collapseTwo" class="accordion-collapse collapse" data-bs-parent="#accordionFlushExample">
			      <div class="accordion-body busBody">
				      <b>제주국제공항</b>
				      <ul class="busUi">
				      	<li>급행182(제주국제공항5) -> 중문환승정류장 하차 -> 502번(중문환승정류장) -> 뒷동산 하차 -> 제주올레길 방면 도보</li>
				      </ul>
			      </div>
			    </div>
			  </div>
			</div>
		</div>
		
	</div>	
</section>

<script defer
   src="<c:url value='/resources/js/app/cstmr/intrcn/location/location.js'/>"></script>
<script defer
   src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCF5O0ZkWw9veiDPj7XPTzkMNIwdVQJllk&callback=initMap"></script>

