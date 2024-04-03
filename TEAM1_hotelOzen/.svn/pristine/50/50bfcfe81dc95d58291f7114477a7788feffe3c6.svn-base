<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="security"%>
	
<link href="${pageContext.request.contextPath}/resources/css/cstmr/intrcn/mbrsh/subscribe.css" rel="stylesheet">

<script type="text/javascript"
	src="https://cdn.iamport.kr/js/iamport.payment-1.1.5.js"></script>

<section class="${mbrsh.mbsGrdCd }">
	<div>
		<div class="notice-header">
			<h1 class="cstmr-title mx-6">MEMBERSHIP</h1>
			<p class="cstmr-content mx-6 mb-5">
			오젠 멤버십은 품격있는 라이프스타일과 특별한 경험을 제안합니다.
			<br>
			오젠 호텔에서 다채로운 혜택과 최상의 서비스를 누려보세요.
			</p>
		</div>
	</div>

<div class="inner">
		<div class="rsvRoomWrap">
             <div class="lCont">
                 <h2 class="titDep2">${mbrsh.mbsGrdCd }</h2>
				<div style="display: inline-block;" id="subDay"></div>&nbsp;-&nbsp;
				<div style="display: inline-block;" id="expDay"></div>	(1년간)
                 <div class="myContents mt-4">
                 	<div class="defaultTit ">MY INFORMATION</div>
					<ul class="defaultInfo">
                        <li>
                            <p>${realUser.cst.cstNm } / ${realUser.cst.cstHp } / ${realUser.cst.cstMail }</p>
                            <p>
                            	[자택] ${realUser.mberAddr }
                            </p>
                        </li>
                    </ul>
                    <p class="txtGuide">전화번호 및 주소, 이메일 등 개인 정보 변경을 원하시면 '바로가기' 버튼을 통해 'My page'에서 변경 가능합니다.
                    </p>
                    <button type="button" class="btnLine" onclick="location.href='${pageContext.request.contextPath}/myinfo/mypage.do';">바로가기</button>
                 	<!-- //멤버십 구입 정보 -->
                 
                 	<!-- 이용 동의 -->
					<h3 class="titDep3">이용 약관</h3>
					<ul class="toggleList agreeCont">
                        <li class="toggleOn">
                            <span class="frm type02">
	                            <input type="checkbox" id="agree1"><label for="agree1">본인 사용 규정</label>
	                        </span>
                            <div class="toggleCont" style="display: block;">
                                <div class="toggleInner">
									<div class="designScroll">
										<div class="scrollWrap" style="">
											<div class="customScrollBox">
												멤버십 카드는 회원 본인에 한해 사용 가능하며, 타인에게 대여, 양도할 수 없습니다.<br> 본
												규정을 위반한 경우 이로 인해 발생하는 회원의 불이익에 대해 호텔은 그 책임이 없으며, <br>
												호텔의 판단에 의해 회원 자격 정지 등의 불이익을 받을 수 있습니다.
											</div>
										</div>
									</div>
								</div>
                            </div>
                        </li>
						<li class="toggleOn">
	                        <span class="frm type02"> 
	                        	<input type="checkbox" id="cancelAgree">
								<label for="cancelAgree" class="cancelAgree">멤버십 취소 규정</label>
							</span>
							<div class="toggleCont" style="display: block;">
								<div class="toggleInner">
									<div class="designScroll">
										<div class="scrollWrap" style="">
											<div class="customScrollBox">
												멤버십 카드 및 혜택 이용 실적이 없는 회원에 한해 멤버십 연회비 결제일 기준 14일 이내에 환불을 요청할 수 있습니다. 
												<br> 
											</div>
										</div>
									</div>
								</div>
							</div>
						</li>

                     </ul>
                 </div>
            </div>
            
			<!-- 결제 상자 -->
			<div class="rCont floating" style="transition: margin-top 0.3s ease-out 0s;">
				<ul class="toggleList rsvList">
					<li>
						<strong class="listTit">
							멤버십 연회비
							<span class="price mt-2">
								<em>
									<fmt:formatNumber value="${mbrsh.mbsGrdAmnt}" pattern="#,###" />KRW
								</em></span>
						</strong>
					</li>
				</ul>
				<div class="totalCont">
					<div class="totalPrice">
						<span class="txt">총 결제금액</span>
						<span class="price">
							<em>
								 <fmt:formatNumber value="${mbrsh.mbsGrdAmnt}" pattern="#,###" />KRW
							</em>
						</span>
					</div>
					<div class="btnArea row">
						<div>
							<button class="col-md-4 custom-btn btn-6 mt-4" onclick="location.href='${pageContext.request.contextPath}/mbrsh'"><span>취소</span></button>
							<button class="col-md-4 custom-btn btn-6 mt-4" onclick="javascript:inicis()">구매하기</button>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<form:form id="submitForm" method="post" > 
		
		
		<!-- setleVO에게 필요한 정보들 -->
		<input type="hidden" id="cstNo" name="cstNo" value="${realUser.cst.cstNo}">
		<input type="hidden" id="setleAmnt" name="setleAmnt"  value="${mbrsh.mbsGrdAmnt}">
		<input type="hidden" id="setleImpUid" name="setleImpUid">
		<input type="hidden" id="setleMerchantUid" name="setleMerchantUid">
		<input type="hidden" id="setleCardNm" name="setleCardNm">
		<input type="hidden" id="setleCardNumber" name="setleCardNumber">
		<input type="hidden" id="setlePayMethod" name="setlePayMethod">

		<!-- MbrshSetle에게 필요한 정보들 -->
		<input type="hidden" id="mbsSetleAmnt" name="mbsSetleAmnt"  value="${mbrsh.mbsGrdAmnt}">
		<input type="hidden" id="mbsGrdCd" name="mbsGrdCd"  value="${mbrsh.mbsGrdCd }">
		
	</form:form>
</section>
<script type="text/javascript">
	
	
	
	IMP.init('imp84350861');
	
	function inicis() {
		IMP.request_pay({
			pg : 'html5_inicis',
			pay_method : 'card',
			merchant_uid : IMP.makeMerchantUid,
			name : 'Ozen Hotel Membership',
			amount : 100,
			buyer_email : '${realUser.cst.cstMail }',
			buyer_name : '${realUser.cst.cstNm}',
			buyer_tel : '${realUser.cst.cstHp}',
			buyer_addr : '${realUser.mberAddr }',
			buyer_postcode : '123-456'
		}, function(resp) {
			console.log(resp);
			if (resp.success) {
				document.getElementById("setleImpUid").value = resp.imp_uid;
				document.getElementById("setleMerchantUid").value = resp.merchant_uid;
				document.getElementById("setleCardNm").value = resp.card_name;
				document.getElementById("setleCardNumber").value = resp.card_number;
				document.getElementById("setlePayMethod").value = resp.pay_method;
				
				submitForm.requestSubmit();
			}
		});
	}
</script>

<script src="<c:url value='/resources/js/app/cstmr/intrcn/mbrsh/subscribe.js'/>"></script>