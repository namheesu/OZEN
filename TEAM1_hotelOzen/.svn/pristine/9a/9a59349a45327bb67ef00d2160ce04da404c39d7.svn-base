<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<link href="${pageContext.request.contextPath}/resources/css/emp/pms/stay/checkIn.css" rel="stylesheet">

<div class="col mb-3">
	<div class="card h-100">
		<div class="card-header">
			<div class="row flex-between-end">
				<nav style="--falcon-breadcrumb-divider: url(&#34;data:image/svg+xml,%3Csvg xmlns='http://www.w3.org/2000/svg' width='8' height='8'%3E%3Cpath d='M2.5 0L1 1.5 3.5 4 1 6.5 2.5 8l4-4-4-4z' fill='%23748194'/%3E%3C/svg%3E&#34;);" aria-label="breadcrumb">
				  <ol class="breadcrumb">
				    <li class="breadcrumb-item"><a href="${pageContext.request.contextPath}/emp">Home</a></li>
				    <li class="breadcrumb-item">호텔관리</li>
				    <li class="breadcrumb-item">투숙관리</li>
				    <li class="breadcrumb-item active" aria-current="page">QR코드 조회</li>
				  </ol>
				</nav>

				<div class="row g-0 px-5 py-5">
					<div class="col-lg-7 pe-lg-2">
						<div class="card-body">
							<c:forEach var="i" begin="0" end="${rsvtDtlList.size()-1 }" >
								<button class="btn btn-outline-secondary me-1 mb-1 rsvtDtlLink" type="button">${rsvtDtlList[i].rsvtDtlNo}</button>
							</c:forEach>
							
							<form:form method="post" modelAttribute="newChkin" id="walkInForm" action="./chkin.do">
								<div class="col-sm-5 mb-4">
									<label class="form-label" for="rsvtDtl-no">예약번호</label>
									<input class="form-control input-color" id="rsvtDtl-no" type="text" name="rsvtDtlNo"
										placeholder="Reservation" value=""/>
								</div>

								<div class="col-12">
									<div class="border-bottom border-dashed my-3"></div>
								</div>
								<div class="row gx-2">
									<div class="col-sm-3 mb-3">
										<label class="form-label" for="cstmr-name">고객이름</label>
										<input class="form-control input-color" id="cstmr-name" type="text" name="cstmr.cstNm"
											placeholder="Name" value=""/>
									</div>
									<div class="col-sm-3 mb-3">
										<label class="form-label" for="cstmr-hp">휴대폰 </label>
										<input class="form-control datetimepicker input-color" id="cstmr-hp" name="cstmr.cstHp"
											type="text" placeholder="phone" value=""/>
									</div>
									<div class="col-sm-3 mb-3">
										<label class="form-label" for="cstmr-carNo">차량번호</label>
										<input class="form-control datetimepicker input-color" id="cstmr-carNo" name="ciCarNo"
											type="text" placeholder="car No" />
									</div>
									<div class="col-sm-3 mb-3">
										<label class="form-label" for="cstmr-carKind">차종</label>
										<input class="form-control datetimepicker input-color" id="cstmr-carKind" name="ciCarKind"
											type="text" placeholder="car Kind" />
									</div>

									<div class="col-12">
										<div class="border-bottom border-dashed my-3"></div>
									</div>

									<div class="col-sm-6 mb-3">
										<label class="form-label" for="start-datetime">체크인시간</label>
										<input class="form-control datetimepicker input-color" id="start-datetime" name="ciDt" 
									    type="datetime-local"/>
									</div>
									<div class="col-sm-6 mb-3">
										<label class="form-label" for="end-date">퇴실일</label>
										<input class="form-control datetimepicker input-color" id="end-date" name="ciCowillYmd"
											type="date" placeholder="YYYY-DD-MM" value=""/>
									</div>

									<div class="col-12">
										<div class="border-bottom border-dashed my-3"></div>
									</div>

									<div class="col-sm-4 mb-3">
										<label class="form-label" for="total-cnt">총인원수</label>
										<input class="form-control input-color" id="total-cnt" type="text" name="ciTotalNmpr"
											placeholder="number of rooms" value=""/>
									</div>
									<div class="col-sm-4 mb-3">
										<label class="form-label" for="adults-cnt">성인수</label>
										<input class="form-control input-color" id="adults-cnt" type="text" name="ciAdultCnt"
											placeholder="number of adults" value=""/>
									</div>
									<div class="col-sm-4 mb-3">
										<label class="form-label" for="children-cnt">아동수</label>
										<input class="form-control input-color" id="children-cnt" type="text" name="ciChildCnt"
											placeholder="number of children" value=""/>
									</div>

									<div class="col-12">
										<div class="border-bottom border-dashed my-3"></div>
									</div>

									<div class="col-sm-4">
										<label class="form-label" for="room-type">객실종류</label>
										<input class="form-control datetimepicker input-color" id="room-type" name="room.rmtTypeCd"
											type="text" placeholder="room Type" value="" readonly/>
									</div>
									<div class="col-sm-4">
										<label class="form-label" for="room-No">객실 호수</label>
										<input class="form-control datetimepicker input-color" id="room-No" name="rmNo"
											type="text" placeholder="room Number" readonly/>
									</div>
									<div class="col-sm-4">
										<label class="form-label" for="room-price">가격</label>
										<input class="form-control datetimepicker input-color" id="room-price" name="setle.setleAmnt"
											type="text" placeholder="price" value="" readonly/>
									</div>
								</div>
								<input type="hidden" id="cstmrNo" name="cstmr.cstNo" value=""/>
								<div class="py-5">
									<div class="float-end">
										<button class="btn btn-outline-info me-1 mb-1  "
											type="submit">CHECK-IN</button>
									</div>
									<div class="float-end">
										<button class="btn btn-outline-warning me-1 mb-1 carKind" type="button">차종 자동입력</button>
									</div>
								</div>
							</form:form>
							<input type="hidden" id="rmtTypehidden" value=""/>
							<input type="hidden" id="adultCnthidden" value=""/>
							<input type="hidden" id="childCnthidden" value=""/>
							<input type="hidden" id="rsvtAmnthidden" value=""/>
						</div>
					</div>

					<div class="col-lg-5 ">
						<div class="sticky-sidebar ">
							<div class="card mb-lg-0 rmselectBG">
								<div class="card-header">
									<h5 class="mb-0">객실 조회</h5>
								</div>
								<div class="card-body ">

									<h6>객실타입</h6>
									<div class="row px-4">
										<div class="col-sm-4 mb-3 form-check">
											<input class="form-check-input" id="STD"
												type="radio" name="listingPrivacy"/>
											<label class="form-label mb-0" for="STD">
												<strong>스탠다드 더블</strong></label>
										</div>
										<div class="col-sm-4 mb-3 form-check">
											<input class="form-check-input" id="STT"
												type="radio" name="listingPrivacy" />
											<label class="form-label mb-0" for="STT">
												<strong>스탠다드 트윈</strong></label>
										</div>
										<div class="col-sm-4 mb-3 form-check">
											<input class="form-check-input" id="STF"
												type="radio" name="listingPrivacy" />
											<label class="form-label mb-0" for="STF">
												<strong>스탠다드 패밀리</strong></label>
										</div>

										<div class="col-sm-4 mb-3 form-check">
											<input class="form-check-input" id="DRD"
												type="radio" name="listingPrivacy"/>
											<label class="form-label mb-0" for="DRD">
												<strong>디럭스 더블</strong></label>
										</div>
										<div class="col-sm-4 mb-3 form-check">
											<input class="form-check-input" id="DRT"
												type="radio" name="listingPrivacy" />
											<label class="form-label mb-0" for="DRT">
												<strong>디럭스 트윈</strong></label>
										</div>
										<div class="col-sm-4 mb-3 form-check">
											<input class="form-check-input" id="DRF"
												type="radio" name="listingPrivacy" />
											<label class="form-label mb-0" for="DRF">
												<strong>디럭스 패밀리</strong></label>
										</div>

										<div class="col-sm-4 mb-3 form-check">
											<input class="form-check-input" id="SUD"
												type="radio" name="listingPrivacy"/>
											<label class="form-label mb-0" for="SUD">
												<strong>스위트 더블</strong></label>
										</div>
										<div class="col-sm-4 mb-3 form-check">
											<input class="form-check-input" id="SUT"
												type="radio" name="listingPrivacy" />
											<label class="form-label mb-0" for="SUT">
												<strong>스위트 트윈</strong></label>
										</div>
										<div class="col-sm-4 mb-3 form-check">
											<input class="form-check-input" id="SUF"
												type="radio" name="listingPrivacy" />
											<label class="form-label mb-0" for="SUF">
												<strong>스위트 패밀리</strong></label>
										</div>

										<div class="col-sm-4 mb-3 form-check">
											<input class="form-check-input" id="SPA"
												type="radio" name="listingPrivacy"/>
											<label class="form-label mb-0" for="SPA">
												<strong>스파 룸</strong></label>
										</div>
										<div class="col-sm-4 mb-3 form-check">
											<input class="form-check-input" id="OND"
												type="radio" name="listingPrivacy" />
											<label class="form-label mb-0" for="OND">
												<strong>온돌 룸</strong></label>
										</div>
										<div class="col-sm-4 mb-3 form-check">
											<input class="form-check-input" id="PTY"
												type="radio" name="listingPrivacy" />
											<label class="form-label mb-0" for="PTY">
												<strong>파티 룸</strong></label>
										</div>


										<div class="border-bottom border-dashed my-3"></div>

									</div>
									
									<div class="form-check custom-checkbox mb-0">
										<div id="roomListBody">
										
										</div>
									</div>
								</div>
							</div>
						
							<div class="py-4">
								<div class="card mb-lg-0 rmselectBG">
									<div class="card-header">
										<h5 class="mb-0">차량 조회</h5>
									</div>
									<div class="card-body ">
										
										<div class="row">
											<label class="form-label" for="cstmr-carNo">차량번호</label>
											<div class="col-sm-7">
												<input class="form-control datetimepicker" id="carNo" name="CarNo" type="text" placeholder="car No" />
											</div>
											<div class="col-sm-5">
												<button class="btn btn-outline-secondary me-1 mb-1 mx-2" id="carYN" type="button">검색</button>
												<button class="btn btn-outline-warning me-1 mb-1 autoTextCar" type="button">자동완성</button>
											</div>
										</div>
										
										<div class="border-bottom border-dashed my-3"></div>
										
										<div class="form-check custom-checkbox mb-0">
											<div id="carYNBody">
											
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
	</div>
</div>

<script src="<c:url value='/resources/js/app/emp/pms/rsvt/qrRsvtList.js'/>"></script>