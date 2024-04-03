<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<link
	href="${pageContext.request.contextPath}/resources/css/cstmr/rsvt/rsvt.css"
	rel="stylesheet">
<link
	href="${pageContext.request.contextPath}/resources/css/common/btn.css"
	rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.3.1.min.js"
	integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="
	crossorigin="anonymous"></script>
<section>
	<div>
		<div class="tab-content pt-2 mt-5">
			<div id="rsvting" class="tab-pane fade active show" role="tabpanel">
				<c:choose>
					<c:when test="${not empty nberRsvtList}">
						<div class="center">
							<div class="accordion container mb-5" id="accordionExample">
								<div class="accordion-item mb-4">
									<h2 class="accordion-header" id="heading1">
										<button class="accordion-button" type="button"
											data-bs-toggle="collapse" data-bs-target="#collapse1"
											aria-expanded="true" aria-controls="collapse1">예약번호
											${nberRsvtList.rsvtNo}&nbsp;&nbsp; 성인
											${nberRsvtList.rsvtAdultCnt},&nbsp; 어린이
											${nberRsvtList.rsvtChildCnt}</button>
									</h2>
									<c:set var="rsvtRoomCnt" value="${nberRsvtList.rsvtRoomCnt}" />
									<c:set var="roomCnt" value="${rsvtRoomCnt - 1 }" />
									<c:forEach var="j" begin="0" end="${roomCnt}">
										<div class="accordion-collapse collapse show" id="collapse1"
											aria-labelledby="heading1" data-bs-parent="#accordionExample">
											<div class="accordion-body">
												<div class="d-flex mt-3 mb-3">
													<div class="rom-img container mx-0">
														<div class="swiper-container theme-slider"
															data-swiper='{"autoplay":true,"spaceBetween":5,"loop":true,"loopedSlides":5,"slideToClickedSlide":true}'>
															<div class="swiper-wrapper">
																<div class="swiper-slide">
																	<img class="rounded-1 img-fluid"
																		src="${pageContext.request.contextPath}/resources/assets/img/room/${nberRsvtList.rsvtDetails[j].roomTypeVO.rmtTypeCd}/${nberRsvtList.rsvtDetails[j].roomTypeVO.rmtTypeCd}_1.jpg"
																		alt="" />
																</div>
																<div class="swiper-slide">
																	<img class="rounded-1 img-fluid"
																		src="${pageContext.request.contextPath}/resources/assets/img/room/${nberRsvtList.rsvtDetails[j].roomTypeVO.rmtTypeCd}/${nberRsvtList.rsvtDetails[j].roomTypeVO.rmtTypeCd}_2.jpg"
																		alt="" />
																</div>
																<div class="swiper-slide">
																	<img class="rounded-1 img-fluid"
																		src="${pageContext.request.contextPath}/resources/assets/img/room/${nberRsvtList.rsvtDetails[j].roomTypeVO.rmtTypeCd}/${nberRsvtList.rsvtDetails[j].roomTypeVO.rmtTypeCd}_3.jpg"
																		alt="" />
																</div>
															</div>
															<div class="swiper-nav">
																<div class="swiper-button-next swiper-button-white">
																</div>
																<div class="swiper-button-prev swiper-button-white">
																</div>
															</div>
														</div>
													</div>
													<div class="mx-3 mt-2">
														<div class="mx-3 mb-3">
															<h5 class="mb-2">
																${nberRsvtList.rsvtDetails[j].roomTypeVO.rmtNm}</h5>
															<h1 class="rsvt-title">
																${nberRsvtList.rsvtDetails[j].roomTypeVO.rmtNmDetails}</h1>
														</div>
														<div>
															<table class="rs-table table">
																<tr>
																	<th>호텔 및 객실</th>
																	<td>오젠호텔,
																		${nberRsvtList.rsvtDetails[j].roomTypeVO.rmtNmDetails}
																	</td>
																</tr>
																<tr>
																	<th>투숙날짜</th>

																	<td>${nberRsvtList.rsvtCheckinYmd}&nbsp;&nbsp;~&nbsp;&nbsp;${nberRsvtList.rsvtCheckoutYmd}&nbsp;
																		(${nberRsvtList.rsvtDay}박)</td>
																</tr>
																<tr>
																	<th>예약인원</th>
																	<td>성인
																		${nberRsvtList.rsvtDetails[j].rsvtDtlAdultCnt} , 어린이
																		${nberRsvtList.rsvtDetails[j].rsvtDtlChildCnt}</td>
																</tr>

															</table>
														</div>
													</div>
												</div>

											</div>
										</div>
									</c:forEach>
									<div class="right">
										<button type="submit" id="rsvtCancelBtn"
											class="btn btn-danger" onclick="cancelPay()">예약취소</button>
									</div>
								</div>
							</div>
						</div>
					</c:when>
					<c:when test="${empty nberRsvtList }">
						<script type="text/javascript">
							Swal.fire({
								title:'조회되는 예약정보가 없습니다.',
								icon:"error",
								confirmButtonText:"확인",
								allowOutsideClick : false
							}).then((result)=>{
								if(result.isConfirmed){
									window.history.back();
								}
							});
						</script>
						<h4 class="center">해당 예약내역이 없습니다.</h4>

					</c:when>
				</c:choose>
			</div>
		</div>
	</div>
	<c:set var="today" value="<%= new java.util.Date() %>"/>
	<c:set var="date"><fmt:formatDate value="${today}" pattern="yyyy-MM-dd"/> </c:set>
	<input type="hidden" value="${date}" id="currentDate">
</section>
<script>
const cPath = document.body.dataset.contextPath;

// 취소메소드
function cancelPay() {
	// 1일 형식
	var oneDay = 24 * 60 * 60 * 1000;
	// 현재 일
	var currentDate = new Date(document.getElementById("currentDate").value);
	// 체크인 일 
	var rsvtCheckinYmd = new Date('${nberRsvtList.rsvtCheckinYmd}');
	// 체크인날과 현재일 비교
	var diff = Math.round(Math.abs((rsvtCheckinYmd - currentDate)/oneDay));
	console.log("diff", diff);
	// 예약 금액
	var setleAmnt = ${nberRsvtList.rsvtAmnt};
	// 환불비율
	var ratio;
	if(diff>=3){
		ratio = "100%";
	}else if(diff>=1){
		setleAmnt = setleAmnt  * 0.5
		ratio = "50%";
	}else{
		setleAmnt = 0;
		ratio = "0%";
	}
	// 금액 컴마 설정
	var formatAmnt = new Intl.NumberFormat('ko-KR').format(setleAmnt);
	
	 Swal.fire({
			title:'정말 예약취소를 하시겠습니까.'
			, html : '취소   ' + diff + ' 일 전     '+'\u00A0'+'     환불비율:   ' + ratio + '\u00A0' + '             환불 금액:   ' + formatAmnt + '원'
			, icon:"info"
			, confirmButtonColor: '#3085d6'
			, cancelButtonColor: '#d33'
			, confirmButtonText:"확인"
			, cancelButtonText:"취소"
			, showCancelButton: true
			, allowOutsideClick : false
		}).then((result)=>{
			if(result.isConfirmed){
				var data={
						setleMerchantUid: '${setleVO.setleMerchantUid}'
					    , refndAmnt: '${setleVO.setleAmnt}'
					    , rsvtCheckinYmd : '${nberRsvtList.rsvtCheckinYmd}'
					    , reason: "예약취소"
					    , cstNo :'${nberRsvtList.cstNo}' 
					    , rsvtNo : '${nberRsvtList.rsvtNo}'
					    , setleNo : '${setleVO.setleNo}'
					     };
				$.ajax({
				     type: "POST",
				     url: cPath + `/cstmr/rsvt/rsvtCancel`, 
				     dataType: "json",
				     contentType: "application/json",
				     data: JSON.stringify(data), 
				     success: function(resp) {
				    	 Swal.fire({
								title:'예약취소가 완료되었습니다.',
								icon:"success",
								confirmButtonText:"확인",
								allowOutsideClick : false
							}).then((result)=>{
								if(result.isConfirmed){
									window.location.href = ${pageContext.request.contextPath}/;
								}
							});
				     }, error: function(request, status, error){
				    	 console.log(error);
				     }
				   });
				}
			});
}

</script>
<script defer
	src="<c:url value='/resources/js/app/cstmr/rsvt/rsvtView.js'/>"></script>