<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="security"%>
<link href="${pageContext.request.contextPath}/resources/css/cstmr/intrcn/mbrsh/mbrshView.css" rel="stylesheet">
<script type="text/javascript">
	let auth = false;
</script>
	<security:authorize access="isAuthenticated()">
<script type="text/javascript">
		auth = true;
</script>
	</security:authorize>

<security:authorize access="isAnonymous()">

<script type="text/javascript">
		auth = false;
</script>
</security:authorize>


<section class="${mbsGrdCd }">

	<div class="d-flex justify-content-center">
		<div class="col-md-10">
			<div class="d-flex b-class justify-content-center mt-6">
				<div class="">
					<img src='<c:url value="/resources/assets/img/mbrsh/B${mbsGrdCd }.png"/>' class="mbrsh-card" />
					<div class="row mt-3">
						<div class="col-md-5 card-tax">
							<p class="mt-4 mbsGrdNm">${mbsGrdList[0].mbsGrdCd }</p>
							<p class="mbsGrdAmnt"><fmt:formatNumber value="${mbsGrdList[0].mbsGrdAmnt }" pattern="#,###" />KRW</p>
							<p><button type="button" class="btnLine" onclick="layerPopUp(this.name)" name="B${mbsGrdCd }">
			                      more details
		                      </button></p>
						</div>
						<div class="col-md-6">
	                    <button class="custom-btn btn-6 mt-4" onclick="subLocate(event);" id="${mbsGrdList[0].mbsGrdCd }">
	                    <span>
		                	 구매
	                	 </span>
		                </button>						
						</div>
					</div>
				</div>
				<div class="benetfitPrev" style="margin-right: 0px; margin-top: 60px;">
                    <div class="benetfitPrevList">
                        <span class="tit">객실 숙박권</span>
                        <strong class="tax">
                        	<em>${mbsGrdList[0].accomCouponCnt }</em>
                        	<span class="unit type01">night</span>
                       	</strong>
                        <span class="txt">${mbsGrdList[0].accomCoupon }형 ${mbsGrdList[0].accomCouponCnt }매</span>

                    </div>
                    <div class="benetfitPrevList">
                        <span class="tit">금액 할인권</span>
                        <strong class="tax">
                        	<em>
                        		<fmt:formatNumber value="${mbsGrdList[0].discount }" pattern="#,###" />
                        	</em>
                        </strong>
                        <span class="txt">객실·레스토랑 사용 가능</span>
                    </div>
                    <div class="benetfitPrevList"> 
                        <span class="tit">할인 특전</span>
                        <strong class="tax"><span class="grd-prk">${mbsGrdList[0].mbsGrdPrk }</span></strong>
                        <span class="txt">이용 및 할인권</span>
                        <span class="txt"><em> ${mbsGrdList[0].totalCoupon }매</em> 제공</span>
                    </div>
                </div>
			</div>
			
			
			<div class="b-classmt-5 d-flex justify-content-center" style="display: flex; justify-content: center;"mt-5 d-flex justify-content-center" style="display: flex; justify-content: center;">
				<div class="d-flex second-mbrsh">
				<div class="benetfitPrev" style="margin-left: 0px; margin-top: 60px;">
                    <div class="benetfitPrevList">
                        <span class="tit">객실 숙박권</span>
                        <strong class="tax">
                        	<em>${mbsGrdList[1].accomCouponCnt }</em>
                        	<span class="unit type01">night</span>
                       	</strong>
                        <span class="txt">${mbsGrdList[1].accomCoupon }형 ${mbsGrdList[1].accomCouponCnt }매</span>
                    </div>
                    <div class="benetfitPrevList">
                        <span class="tit">금액 할인권</span>
                        <strong class="tax">
                        	<em>
                        		<fmt:formatNumber value="${mbsGrdList[1].discount }" pattern="#,###" />
                        	</em>
                        </strong>
                        <span class="txt">객실·레스토랑 사용 가능</span>
                    </div>
                    <div class="benetfitPrevList"> 
                        <span class="tit">할인 특전</span>
                        <strong class="tax"><span class="grd-prk">${mbsGrdList[1].mbsGrdPrk }</span></strong>
                        <span class="txt">이용 및 할인권</span>
                        <span class="txt"><em> ${mbsGrdList[1].totalCoupon }매</em> 제공</span>

                    </div>
                </div>				
				<div class="second-card">
					<img src='<c:url value="/resources/assets/img/mbrsh/L${mbsGrdCd }.png"/>' class="mbrsh-card" />
					<div class="row mt-3">
						<div class="col-md-5 card-tax">
							<p class="mt-4 mbsGrdNm">${mbsGrdList[1].mbsGrdCd }</p>
							<p class="mbsGrdAmnt"><fmt:formatNumber value="${mbsGrdList[1].mbsGrdAmnt }" pattern="#,###" />KRW</p>
							<p><button type="button" class="btnLine" onclick="layerPopUp(this.id)" id="L${mbsGrdCd }">
			                      more details
		                      </button></p>						
						</div>
						<div class="col-md-6">
	                    <button class="custom-btn btn-6 mt-4" onclick="location.href='${pageContext.request.contextPath}/mbrsh/subscribe/${mbsGrdList[0].mbsGrdCd }'">
	                    <span>
		                	 구매
	                    </span>
		                </button>						
						</div>
					</div>
				</div>
				</div>
			</div>
			
			
			<div class="d-flex b-class  mt-5 justify-content-center" style="display: flex; justify-content: center;">
				<div class="">
					<img src='<c:url value="/resources/assets/img/mbrsh/D${mbsGrdCd }.png"/>' class="mbrsh-card" />
					<div class="row mt-3">
						<div class="col-md-5 card-tax" >
							<p class="mt-4 mbsGrdNm">${mbsGrdList[2].mbsGrdCd }</p>
							<p class="mbsGrdAmnt"><fmt:formatNumber value="${mbsGrdList[2].mbsGrdAmnt }" pattern="#,###" />KRW</p>
							<p><button type="button" class="btnLine" onclick="layerPopUp(this.id)" id="D${mbsGrdCd }">
			                      more details
		                      </button></p>						
						</div>
						<div class="col-md-6">
	                    <button class="custom-btn btn-6 mt-4" onclick="location.href='${pageContext.request.contextPath}/mbrsh/subscribe/${mbsGrdList[0].mbsGrdCd }'">
	                    <span>
		                	 구매
	                    </span>
		                </button>						
						</div>
					</div>
				</div>
				<div class="benetfitPrev" style="margin-right: 0px; margin-top: 60px;">
                    <div class="benetfitPrevList">
                        <span class="tit">객실 숙박권</span>
                        <strong class="tax">
                        	<em>${mbsGrdList[2].accomCouponCnt }</em>
                        	<span class="unit type01">night</span>
                       	</strong>
                        <span class="txt">${mbsGrdList[2].accomCoupon }형 ${mbsGrdList[2].accomCouponCnt }매</span>

                    </div>
                    <div class="benetfitPrevList">
                        <span class="tit">금액 할인권</span>
                        <strong class="tax">
                        	<em>
                        		<fmt:formatNumber value="${mbsGrdList[2].discount }" pattern="#,###" />
                        	</em>
                        </strong>
                        <span class="txt">객실·레스토랑 사용 가능</span>
                    </div>
                    <div class="benetfitPrevList"> 
                        <span class="tit">할인 특전</span>
                        <strong class="tax"><span class="grd-prk">${mbsGrdList[2].mbsGrdPrk }</span></strong>
                        <span class="txt">이용 및 할인권</span>
                        <span class="txt"><em> ${mbsGrdList[2].totalCoupon }매</em> 제공</span>
                    </div>
                </div>
			</div>
		</div>
	</div>

</section>

<div id="layerPop1" class="layerPop" style="display: none;">
	<div class="layerCont" tabindex="0" style="top: 50%; left: 50%; margin-top: -245.338px; margin-left: -470px;" data-gtm-vis-recent-on-screen36519946_61="1150" data-gtm-vis-first-on-screen36519946_61="1150" data-gtm-vis-total-visible-time36519946_61="100" >
		<div class="compLayer" >
            <h2 class="compTit" >오젠 멤버십 구매</h2>
            <div class="membershipInfoArea" >                
                <div class="membershipInfo" >
                    <span class="tit" >아직 회원이 아니신가요?</span>
                    <span class="txt" >회원이 아닌 경우, 신규 회원가입 후 멤버십 구매가 가능합니다.</span>
                    <a href="${pageContext.request.contextPath }/auth/join/terms.do" class="btnSC btnM" >회원가입</a>
                </div>
                <div class="membershipInfo" >
                    <span class="tit" >이미 회원이신가요?</span>
                    <span class="txt" >로그인 시 바로 멤버십 구매가 가능합니다.</span>
                    <a href="${pageContext.request.contextPath }/auth/Login.do" class="btnSC btnM active" >로그인</a>
                </div>
            </div>
		</div>
		<button type="button" class="btn-close btnClose" onclick="fncCancel()" >닫기</button>
	</div>
</div>

<div id="layerPop2" class="layerPop" style="display: none;">
	<div class="layerCont" style="top: 50%; left: 50%; margin-top: -375.438px; margin-left: -540px;" tabindex="">
		<div class="membershipConsult">
			<h2 class="compTit" >멤버십 혜택</h2>
			<div class="designScroll" style="height: 465px; width: 100%; overflow: hidden;" >
				<div class="scrollWrap" tabindex="0" style="margin-right: -25px; overflow-y: scroll; padding-right: 40px; box-sizing: border-box;">
					<div class="customScrollBox">
						<h3 class="titDep3">멤버십 상세 혜택</h3>
						<ul class="toggleList agreeCont">
							<li class="toggleOn" >
								<div class="toggleInner" >
									<p class="notiTxt" >
											오젠 호텔 멤버십은 특별한 당신께 호텔에서의 격조 높은 서비스와 다양한 혜택을 제공하는 고품격 유료 멤버십입니다.
									</p>
										<table class="tblH" >
											<colgroup >
												<col style="width: 34%">
												<col style="width: 33%">
												<col style="width: auto">
											</colgroup>
											<thead >
												<tr >
												<th scope="col">쿠폰 사용처</th>
												<th scope="col">혜택</th>
												<th scope="col">지급 수량</th>
											</tr>
											</thead>
											<tbody id="mbrshDetail">

										</tbody>
										</table>

								</div>
							</li>
						</ul>
					</div>
					<div class="scrollbar-wrap" style="height: 465px;">
						<div class="scrollbar" style="height: 148.333px; top: 0px;"></div>
					</div>
				</div>
			</div>
			<div class="btnArea" x`>
				<button type="button" class="btnSC btnM" onclick="fncCancel2();">확인</button>
			</div>
		</div>
		<button type="button" class="btn-close btnClose" onclick="fncCancel2();" aria-label="Close">닫기</button>
	</div>
</div>
<div id="dimmed" class="dimmed" style="display: none;"></div>
<script>
	
	const cPath = document.body.dataset.contextPath;

	let section = document.querySelector('section')
	
	let sectionClass = section.classList;
	
	if (sectionClass.contains('BLUE')) {
		
		section.style.backgroundColor = "#5f8395";
		
	} else if (sectionClass.contains('GREEN')) {
		
		section.style.backgroundColor = "#427f63";
		
	} else if (sectionClass.contains('RED')) {
		
		section.style.backgroundColor = "#7f4242";
		
	} else if (sectionClass.contains('BLACK')) {
		
		section.style.backgroundColor = "#4f4f5f";
		
	}else{
		window.location.href = cPath + "/error/404"
	}
</script>
<script src="<c:url value='/resources/js/app/cstmr/intrcn/mbrsh/mbrshView.js'/>"></script>