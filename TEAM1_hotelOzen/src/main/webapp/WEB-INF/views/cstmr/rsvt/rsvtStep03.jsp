<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<link
	href="${pageContext.request.contextPath}/resources/css/cstmr/rsvt/rsvtStep03.css"
	rel="stylesheet">

<script type="text/javascript"
	src="https://cdn.iamport.kr/js/iamport.payment-1.1.5.js"></script>


<c:set var="cstGen" value="${realMber.cst.cstGen}" />
<section>
	<c:choose>
		<c:when test="${cstGen == 'M'}">
			<c:set var="cstGen" value="MALE" />
		</c:when>
		<c:when test="${cstGen == 'F'}">
			<c:set var="cstGen" value="FEMALE" />
		</c:when>
	</c:choose>
	<div class=" mt-8 inner">
		<form:form id="submitForm" method="post"
			action="${pageContext.request.contextPath}/cstmr/rsvt/rsvtStep04">
			<div class=" d-flex">
				<div class="wid-900 pl-25">
					<div class="mb-7">
						<h1 class="title-35 font-jung">RESERVATION INFORMATION</h1>
					</div>
					<div>
						<label class="label-font ">RESERVATION NAME</label>
					</div>
					<c:set var="cstNo" value="${realMber.cstNo }" />
					<c:choose>
						<c:when test="${cstNo == null }">
							<div class="mb-6 d-flex">
								<input class=" input-phone wd-170 bor-none mar-right"
									type="text" koreanOnly data-valid="Y" aria-required="true"
									name="cstNm" id="cstNm"> <select
									class="bor-none  wd-170" name="cstGen" id="cstGen">
									<option disabled selected>성별</option>
									<option value="M">MALE</option>
									<option value="F">FEMALE</option>
								</select>
							</div>
							<div class="mb-6">
								<label class="label-font">BIRTH DATE</label>
								<div>
									<input type="hidden" id="hibir"> <input
										class="input-phone wd-145 bor-none" type="text" maxlength="4"
										data-valid="Y" aria-required="true" id="bir1" name="bir1"
										placeholder="YYYY" value=""> <span>-</span> <input
										class="input-phone wd-145 bor-none" type="text" maxlength="2"
										data-valid="Y" aria-required="true" id="bir2" name="bir2"
										placeholder="MM" value=""> <span>-</span> <input
										class="input-phone wd-145 bor-none" type="text" maxlength="2"
										data-valid="Y" aria-required="true" id="bir3" name="bir3"
										placeholder="DD" value="">
								</div>
							</div>
							<div>
								<label class="label-font">PHONE NUMBER</label>
							</div>
							<div class="d-flex mb-6">

								<input class="input-phone wd-145 bor-none" type="text"
									numberOnly data-valid="Y" aria-required="true" id="hp1"
									maxlength="3" name="hp1"> <span>-</span> <input
									class="input-phone wd-145 bor-none" type="text" numberOnly
									data-valid="Y" aria-required="true" id="hp2" maxlength="4"
									name="hp2"> <span>-</span> <input
									class="input-phone wd-145 bor-none" type="text" numberOnly
									data-valid="Y" aria-required="true" id="hp3" maxlength="4"
									name="hp3">
							</div>
							<div>
								<label class="label-font">E-MAIL</label>
							</div>
							<div class="d-flex mb-6 form-group">

								<input class="input-phone wd-170 bor-none" type="text" noKorean
									data-valid="Y" aria-required="true" id="email-front"> <span>@</span>
								<input class="input-phone wd-170 bor-none mar-right" type="text"
									noKorean data-valid="Y" aria-required="true" id="email-end">
								<form:errors path="cstMail" cssClass="text-danger" />
								<select class="bor-none  wd-170" id="mailAddrSelect">
									<option value="" label="직접 입력" />
									<option value="naver.com" label="naver.com" />
									<option value="gmail.com" label="gmail.com" />
									<option value="daum.net" label="daum.net" />
									<option value="hanmail.net" label="hanmail.net" />
									<option value="hotmail.com" label="hotmail.com" />
									<option value="nate.com" label="nate.com" />
								</select>
							</div>
						</c:when>
						<c:when test="${cstNo != null }">
							<div class="mb-6 d-flex">
								<input class=" input-phone wd-170 bor-none mar-right"
									type="text" koreanOnly readonly data-valid="Y"
									aria-required="true" name="cstNm" id="cstNm"
									value="${realMber.cst.cstNm }"> <select
									class="bor-none  wd-170" name="cstGen" id="cstGen">
									<option>${cstGen}</option>
								</select>
							</div>
							<div class="mb-6">
								<label class="label-font">BIRTH DATE</label>
								<div>
									<input type="hidden" id="hibir"
										value="${realMber.cst.cstBirth}"> <input
										class="input-phone wd-145 bor-none" type="text" maxlength="4"
										readonly data-valid="Y" aria-required="true" id="bir1"
										name="bir1" placeholder="YYYY" value=""> <span>-</span>
									<input class="input-phone wd-145 bor-none" type="text"
										maxlength="2" readonly data-valid="Y" aria-required="true"
										id="bir2" name="bir2" placeholder="MM" value=""> <span>-</span>
									<input class="input-phone wd-145 bor-none" type="text"
										maxlength="2" readonly data-valid="Y" aria-required="true"
										id="bir3" name="bir3" placeholder="DD" value="">
								</div>
							</div>
							<div>
								<label class="label-font">PHONE NUMBER</label>
							</div>
							<div class="d-flex mb-6">

								<input class="input-phone wd-145 bor-none" type="text"
									numberOnly readonly data-valid="Y" aria-required="true"
									id="hp1" maxlength="3" name="hp1"
									value="${realMber.cst.cstHp.substring(0,3)}"> <span>-</span>
								<input class="input-phone wd-145 bor-none" type="text"
									numberOnly readonly data-valid="Y" aria-required="true"
									id="hp2" maxlength="4" name="hp2"
									value="${realMber.cst.cstHp.substring(4,8)}"> <span>-</span>
								<input class="input-phone wd-145 bor-none" type="text"
									numberOnly readonly data-valid="Y" aria-required="true"
									id="hp3" maxlength="4" name="hp3"
									value="${realMber.cst.cstHp.substring(9,13)}">
							</div>
							<div>
								<label class="label-font">E-MAIL</label>
							</div>
							<div class="d-flex mb-6 form-group">

								<input class="input-phone wd-170 bor-none" type="text" noKorean
									readonly data-valid="Y" aria-required="true"
									value="${realMber.cst.cstMail.split("@")[0]}" id="email-front">
								<span>@</span> <input
									class="input-phone wd-170 bor-none mar-right" type="text"
									noKorean data-valid="Y" aria-required="true" id="email-end"
									readonly value="${realMber.cst.cstMail.split("@")[1]}">
								<form:errors path="cstMail" cssClass="text-danger" />
							</div>
						</c:when>
					</c:choose>
					<label class="can-sty mb-0">취소 규정</label>

					<div class="accordion container mb-5" style="padding-left: 0px;"
						id="accordionExample">
						<div class="">
							<h2 class="accordion-header" id="heading1">
								<button class="accordion-button wid-650 font-gray" type="button"
									data-bs-toggle="collapse" data-bs-target="#collapse1"
									aria-expanded="true" aria-controls="collapse1">[필독] 취소
									규정에 동의합니다.</button>
							</h2>
							<div class="accordion-collapse collapse show" id="collapse1"
								aria-labelledby="heading1" data-bs-parent="#accordionExample">
								<div class="">
									<div class="btn-refnd wid-650">
										<table class=" font-gray">
											<tr>
												<th class="refnd-th">체크인 3일전</th>
												<td class="refnd-td">위약금 없이 취소 가능</td>
											</tr>
											<tr>
												<th class="refnd-th">체크인 1일전</th>
												<td class="refnd-td">위약금 50% 발생</td>
											</tr>
											<tr>
												<th class="refnd-th">체크인 당일</th>
												<td class="refnd-td">위약금 100% 발생 및 취소</td>
											</tr>
										</table>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
				<c:set var="roomAmnt" value="${roomType.rmtype.rmtAmnt}" />
				<c:set var="rsvtRoomCnt" value="${rsvtVO.rsvtRoomCnt}" />
				<c:set var="rsvtDay" value="${rsvtVO.rsvtDay}" />
				<c:set var="totalAmnt" value="${roomAmnt * rsvtRoomCnt * rsvtDay}" />
				<div>
					<c:forEach var="i" begin="0" end="${rsvtRoomCnt - 1}">
						<div class="r-box">

							<h5 class="mb-2">${roomType.rmtype.rmtNmDetails}${i+1}</h5>

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
						<input type="hidden" id="rsvtDetails[${i}].rsvtDtlAmnt"
							name="rsvtDetails[${i}].rsvtDtlAmnt"
							value="${roomAmnt * rsvtDay}">
					</c:forEach>
					<div class="mt-4 mb-6">
						<c:if test="${cstNo != null }">
							<div>
								<label class="label-font ">COUPON</label>
							</div>
							<div>
								<select id="coupon" style="width: 385.6px; padding-left: 20px;">
									
									<c:if test="${not empty couponList}">
										<script>console.log("null이 아님")</script>
										<option label="쿠폰" value="쿠폰">쿠폰</option>
										<c:forEach var="item" items="${couponList}" begin="0"
											end="${couponList.size() }" step="1">
											<option label="${item.couponVO.cpnkNm}"
												value="${item.couponVO.cpnUse}|${item.couponVO.cpnNo}">${item.couponVO.cpnkNm}</option>
										</c:forEach>
									</c:if>
									<c:if test="${empty couponList }">
									<script>console.log("null임")</script>
										<option>사용 가능한 쿠폰이 없습니다.</option>
									</c:if>
								</select>
							</div>
						</c:if>
					</div>
					<div id="discount" class="d-flex mt-5 rs-fo mb-3"
						style="justify-content: space-between; display: none !important;">
						<h5>할인금액</h5>
						<h5 id="discountAmnt" style="color: blue"></h5>
					</div>
					<div class="d-flex  rs-fo">
						<h5 class="py-cus">총 예약금액</h5>
						<h2 class="rsvt-cost" id="total">
							<fmt:formatNumber value="${totalAmnt}" pattern="#,###" />
							원
						</h2>
					</div>
					<c:choose>
						<c:when test="${cstNo == null }">
							<button class="btn btn-outline-dark rsv-btn mb-1 mt-3 un-radi"
								type="button" onclick="javascript:inicis()" id="submitBtn"
								disabled="disabled">예약하기</button>
						</c:when>
						<c:when test="${cstNo != null }">
							<button class="btn btn-outline-dark rsv-btn mb-1 mt-3 un-radi"
								type="button" onclick="javascript:inicis()" id="submitBtn">예약하기</button>
						</c:when>
					</c:choose>
				</div>
			</div>
			<input type="hidden" id="cstMail" name="cstMail">
			<input type="hidden" id="cstHp" name="cstHp">
			<input type="hidden" id="cstBirth" name="cstBirth">
			<input type="hidden" id="cstNo" name="cstNo"
				value="${realMber.cst.cstNo}">
			<input type="hidden" id="setleAmnt" name="setleAmnt"
				value="${totalAmnt}">
			<input type="hidden" id="setleImpUid" name="setleImpUid">
			<input type="hidden" id="setleMerchantUid" name="setleMerchantUid">
			<input type="hidden" id="setleCardNm" name="setleCardNm">
			<input type="hidden" id="setleCardNumber" name="setleCardNumber">
			<input type="hidden" id="setlePayMethod" name="setlePayMethod">
			<input type="hidden" id="defaultAmnt" value="${totalAmnt}">
			<input type="hidden" id="cpnNo" name="cpnNo">

		</form:form>
	</div>


</section>


<script type="text/javascript">
	IMP.init('imp84350861');
	var amnt = document.getElementById('setleAmnt');
	function inicis() {

		if (amnt.value == 0) {

			document.getElementById("setlePayMethod").value = "coupon";
			combine();
			$("#submitForm").submit();

		} else {

			IMP
					.request_pay(
							{
								pg : 'html5_inicis',
								pay_method : 'card',
								merchant_uid : IMP.makeMerchantUid, // Example: order_no_0001
								name : 'Ozen Hotel',
								amount : 100,
								buyer_email : '${realMber.cst.cstMail}',
								buyer_name : '${realMber.cst.cstNm}',
								buyer_tel : '${realMber.cst.cstHp}',
								buyer_addr : '',
								buyer_postcode : '123-456'

							// m_redirect_url: '{Mobile only - URL to redirect to after payment approval}' // Example: https://www.my-service.com/payments/complete/mobile
							},
							function(resp) {
								console.log(resp);
								if (resp.success) {
									document.getElementById("setleImpUid").value = resp.imp_uid;
									document.getElementById("setleMerchantUid").value = resp.merchant_uid;
									document.getElementById("setleCardNm").value = resp.card_name;
									document.getElementById("setleCardNumber").value = resp.card_number;
									document.getElementById("setlePayMethod").value = resp.pay_method;
									combine();

									$("#submitForm").submit();
								}
							});
		}
	}
</script>
<script defer
	src="<c:url value='/resources/js/app/cstmr/rsvt/rsvtStep03.js'/>"></script>
