<%@page import="java.util.Calendar"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<!-- 멤버십 추천 CSS -->
<link href="${pageContext.request.contextPath }/resources/css/emp/crm/cstmr/cstmrMembsh.css" rel="stylesheet" />
<!-- 멤버십 추천 CSS 끝-->

<!-- swiper.js css -->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/swiper@11/swiper-bundle.min.css" />


<link href="${pageContext.request.contextPath}/resources/css/common/btn.css" rel="stylesheet">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/cstmr/index.css">


<style>
.s0 {
	background-size: cover;
	background-image: url('${pageContext.request.contextPath}/resources/assets/img/cstmr/bg_main01.jpg');
	background-color: black;
}
.s3 {
	background-size: cover;
	background-image: url('${pageContext.request.contextPath}/resources/assets/img/cstmrMain/mainSection03_1.jpg');
}
</style>

<div id="fullpage">

<!-- section1 -->
	<div class="section s0">
		<div class="inner">
			<form:form id="submitForm" method="post"
				action="${pageContext.request.contextPath}/cstmr/rsvt/rsvtStep01">
				<div class="first mx-5">
					<div id="roomBox" style="display: none;">
						<button type="button" onclick="home()">
							<img
								src="${pageContext.request.contextPath}/resources/assets/img/generic/button_x.png"
								alt="x">
						</button>
						<div class="d-flex">
							<div class="room mt-4">
								<div id="room1 " class="d-flex mb-4">
									<div class="room-num">
										<h2>객실1</h2>
									</div>
									<div class="room-btn">
										<button type="button" id="btnAdultDown1"
											onclick="minus('adultCnt1')">
											<img
												src="${pageContext.request.contextPath}/resources/assets/img/generic/button_minus.png"
												alt="-">
										</button>
										<span class="adl-span">성인 <em>2</em></span>
										<button type="button" id="btnAdultUp1"
											onclick="plus('adultCnt1')">
											<img
												src="${pageContext.request.contextPath}/resources/assets/img/generic/button_plus.png"
												alt="+">
										</button>
										<input type="hidden" id="adultCnt1" name="rsvtDetails[0].rsvtDtlAdultCnt"
											value="2">
									</div>
									<div class="room-btn">
										<button type="button" id="btnChildDown1"
											onclick="minus('childCnt1')">
											<img
												src="${pageContext.request.contextPath}/resources/assets/img/generic/button_minus.png"
												alt="-">
										</button>
										<span>어린이 <em>0</em></span>
										<button type="button" id="btnChildUp1"
											onclick="plus('childCnt1')">
											<img
												src="${pageContext.request.contextPath}/resources/assets/img/generic/button_plus.png"
												alt="+">
										</button>
										<input type="hidden" id="childCnt1" name="rsvtDetails[0].rsvtDtlChildCnt"
											value="0">
									</div>
								</div>
								<div id="room2" class="d-flex mb-4">
									<div class="room-num">
										<h2>객실2</h2>
									</div>
									<div class="room-btn">
										<button type="button" id="btnAdultDown2"
											onclick="minus('adultCnt2')">
											<img
												src="${pageContext.request.contextPath}/resources/assets/img/generic/button_minus.png"
												alt="-">
										</button>
										<span>성인 <em>0</em></span>
										<button type="button" id="btnAdultUp2"
											onclick="plus('adultCnt2')">
											<img
												src="${pageContext.request.contextPath}/resources/assets/img/generic/button_plus.png"
												alt="+">
										</button>
										<input type="hidden" id="adultCnt2"
											name="rsvtDetails[1].rsvtDtlAdultCnt"
											oninput="roomCnt('adultCnt2')" value="0">
									</div>
									<div class="room-btn">
										<button type="button" id="btnChildDown2"
											onclick="minus('childCnt2')">
											<img
												src="${pageContext.request.contextPath}/resources/assets/img/generic/button_minus.png"
												alt="-">
										</button>
										<span>어린이 <em>0</em></span>
										<button type="button" id="btnChildUp2"
											onclick="plus('childCnt2')">
											<img
												src="${pageContext.request.contextPath}/resources/assets/img/generic/button_plus.png"
												alt="+">
										</button>
										<input type="hidden" id="childCnt2"
											name="rsvtDetails[1].rsvtDtlChildCnt" value="0">
									</div>
								</div>
								<div id="room3" class="d-flex mb-3">
									<div class="room-num">
										<h2>객실3</h2>
									</div>
									<div class="room-btn">
										<button type="button" id="btnAdultDown3"
											onclick="minus('adultCnt3')">
											<img
												src="${pageContext.request.contextPath}/resources/assets/img/generic/button_minus.png"
												alt="-">
										</button>
										<span>성인 <em>0</em></span>
										<button type="button" id="btnAdultUp3"
											onclick="plus('adultCnt3')">
											<img
												src="${pageContext.request.contextPath}/resources/assets/img/generic/button_plus.png"
												alt="+">
										</button>
										<input type="hidden" id="adultCnt3"
											name="rsvtDetails[2].rsvtDtlAdultCnt"
											oninput="roomCnt('adultCnt3')" value="0">
									</div>
									<div class="room-btn">
										<button type="button" id="btnChildDown3"
											onclick="minus('childCnt3')">
											<img
												src="${pageContext.request.contextPath}/resources/assets/img/generic/button_minus.png"
												alt="-">
										</button>
										<span>어린이 <em>0</em></span>
										<button type="button" id="btnChildUp3"
											onclick="plus('childCnt3')">
											<img
												src="${pageContext.request.contextPath}/resources/assets/img/generic/button_plus.png"
												alt="+">
										</button>
										<input type="hidden" id="childCnt3"
											name="rsvtDetails[2].rsvtDtlChildCnt" value="0">
									</div>
								</div>
							</div>
							<div>
								<button  class="custom-btn btn-7 mt-4">확인</button>
							</div>
						</div>
					</div>
					<div id="title" class="text-center">
						<h1 class="ozen_main-title">"오젠허난 폭삭 속았수다"</h1>
						<h4 class="ozen_main_jeju">"여기까지 오시느라 수고많으셨습니다"의 제주도 방언</h4>
					</div>
					<div class="d-flex tit">
						<div class="hotel">
							<h5 class="ozen_main-reserv">HOTEL</h5>
						</div>
						<div class="chekInBox">
							<h5 class="ozen_main-reserv">CHECK IN</h5>
						</div>
						<div class="chekOutBox">
							<h5 class="ozen_main-reserv">CHECK OUT</h5>
						</div>
						<div class="roomCnt">
							<h5 class="ozen_main-reserv">ROOM</h5>
						</div>
						<div class="adultCnt">
							<h5 class="ozen_main-reserv">ADULT</h5>
						</div>
						<div class="childCnt"> 
							<h5 class="ozen_main-reserv">CHILD
								<svg xmlns="http://www.w3.org/2000/svg" x="0px" y="0px" width="20" height="20" viewBox="0 0 128 128" style="fill:#FFFFFF;" data-bs-toggle="tooltip" data-bs-placement="top" title="37개월 이상 ~ 만 12세 이하">
									<path d="M6,64c0,32,26,58,58,58s58-26,58-58S96,6,64,6S6,32,6,64z M61,41c0-1.7,1.3-3,3-3s3,1.3,3,3v5c0,1.7-1.3,3-3,3s-3-1.3-3-3 V41z M61,61c0-1.7,1.3-3,3-3s3,1.3,3,3v26c0,1.7-1.3,3-3,3s-3-1.3-3-3V61z"></path>
								</svg>
							</h5>
						</div>
					</div>
					<div class="d-flex inputBox">

						<div class="hotel">
							<h3>호텔 오젠</h3>
						</div>
						<div>

							<div class="d-flex">
								<div>
									<input type="date" name="rsvtCheckinYmd" id="rsvtCheckinYmd" />
								</div>
								<div>
									<input type="date" name="rsvtCheckoutYmd" id="rsvtCheckoutYmd" />
								</div>
							</div>
						</div>
						<div class="d-flex" id="input-box">
							<div class="d-flex" onclick="room()" style="cursor:pointer;">
								<div>

									<h3 id="roomCnt">1</h3>
									<input type="hidden" name="rsvtRoomCnt" id="rsvtRoomCnt"
										value="1" />
								</div>
								<div>

									<h3 id="adultCnt">2</h3>
									<input type="hidden" id="rsvtAdultCnt" name="rsvtAdultCnt" value="2" />
								</div>
								<div>

									<h3 id="childCnt">0</h3>
									<input type="hidden" id="rsvtChildCnt" name="rsvtChildCnt" value="0" />
								</div>
							</div>
							<div>
								<div class="btnBox">
									<button class="custom-btn btn-7" type="submit" id="submitBtn">조회하기</button>
								</div>
							</div>
						</div>
					</div>

				</div>
			</form:form>
		</div>
	</div>
<!-- section1 end -->


<!-- section2 -->
	<div class="section">
		<div class="visual-sec">
	        <div class="swiper main-swiper">
	            <div class="swiper-wrapper">
	                <div class="swiper-slide">
	                    <div class="img-box">
	                        <div style="background-image: url('${pageContext.request.contextPath}/resources/assets/img/cstmrMain/mainSection02_1.jpg');"></div>
	                    </div>
	                </div>
	                <div class="swiper-slide">
	                    <div class="img-box">
	                        <div style="background-image: url('${pageContext.request.contextPath}/resources/assets/img/cstmrMain/mainSection02_2.jpg');"></div>
	                    </div>
	                </div>
	                <div class="swiper-slide">
	                    <div class="img-box">
	                        <div style="background-image: url('${pageContext.request.contextPath}/resources/assets/img/cstmrMain/mainSection02_3.jpg');"></div>
	                    </div>
	                </div>
	                <div class="swiper-slide">
	                    <div class="img-box">
	                        <div style="background-image: url('${pageContext.request.contextPath}/resources/assets/img/cstmrMain/mainSection02_4.jpg');"></div>
	                    </div>
	                </div>
	            </div>
	            <div class="all-box">
	                <div class="progress-box">
	                    <div class="swiper-pagination"></div>
	                    <div class="autoplay-progress">
	                       <svg viewBox="0 0 100 10">
                            	<line x1="0" y1="0" x2="100" y2="0"></line>
                        	</svg>
	                    </div>
	                </div>
	                <div class="arrow-box">
	                    <div class="swiper-button-prev"></div>
	                    <div class="swiper-button-next"></div>
	                </div>
	            </div>
	        </div>
	        
			<div class="section2-start">
				<div class="section_two">
					<div class="section_two-body">
						<h2 class="section2_healing">HEALING <br> IN THE PLACE</h2>
						<p class="section2_p">편안한 휴식이 있는 공간</p>
						<ul>
							<li class="section2_room">
								<span>STANDARD</span>
							</li>
							<li class="section2_room">
								<span>DELUXE</span>
							</li>
							<li class="section2_room">
								<span>SUITE</span>
							</li>
							<li class="section2_room">
								<span>SPECIAL</span>
							</li>
						</ul>
						<div class="menu align-center expanded text-center SMN_effect-2">
							<button class="custom-btn btn-11 section_roomDetail" onclick="section_roomDetail();" style="font-size:13px;">VIEW MORE</button>
						</div>
					</div>
				</div>
			</div>
	    </div>
	</div>
<!-- section2 end -->
	
<!-- section3 -->	
	<div class="section s3">
		<div class="mainArea03 inner">
			<strong class="titDep1">Ozen Hotel Membership</strong>
			<p class="txt" >
				품격 있는 서비스와 다채로운 라이프 스타일을
				<br>
				선사하는 오젠호텔 멤버십
				<br>
				지금 회원만을 위한 특별한 혜택과 경험을 확인해보세요.
			</p>
			<a href="${pageContext.request.contextPath }/mbrsh" class="btnSC btnM btnMW"
				data-gtm-vis-has-fired36519946_97="1">VIEW MORE &amp; JOIN</a>
		</div>
	</div>
<!-- section3 end -->
	
<!-- footer -->
	<footer class="section h0 fp-auto-height">
		<div class="footer-video">
			<video muted autoplay loop>
				<source
					src="${pageContext.request.contextPath}/resources/assets/img/ozen.mp4">
			</video>
			<h1 class="footer_text"></h1>
			<div class="text-overlay">
				<div class="main_ozenFooter">
					<div class="mainFooter_top">
						<div class="mainFooter_row">
							<div class="col-lg-4 d-flex mainFooter_title">
								<img src="${pageContext.request.contextPath}/resources/assets/img/ozenWrite.png" class="mainFooter_img">
								<h1 class="text-light mainFooter_logo">HOTEL OZEN</h1>
							</div>
						</div>
					</div>
					
					<!-- end of .container-->
					<div class="footer_bottom">
						<div class="footer_inner-wrap">
							<div class="onText">
								<span class="text">오시는 길</span>
								<span class="text">개인정보처리</span>
								<span class="text">이메일무단수집금지</span>
								<span class="text">영상정보처리기기 운영,관리방침</span>
							</div>
							
							<div class="footer_info">
								<p class="d-flex justify-content-end mx-5">
									<span class="mainFooter_text">제주특별자치도 서귀포시 강정동 724-3</span>
									<span class="mainFooter_text">대표이사 이성엽</span>
									<span class="mainFooter_text">사업자등록번호 123-45-67909</span>
									<span class="mainFooter_text">TEL. 064-233-3426</span>
									<span class="mainFooter_text">FAX. 064-233-3777</span>
								</p>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</footer>
</div>

<!-- 멤버십 추천 팝업 -->

<c:if test="${ not empty vo}">
	<div class="modal modal_frame" id="myModal" tabindex="-1" role="dialog">
	    <div class="modal-dialog modal-80size" role="document">
	        <div class="modal-content modal-80size">
	            <div class="modal-header">
	                <span class="membsh-title-span">Membership Recommendation</span>
	                <button type="button" class="btn-close" data-dismiss="modal" aria-label="Close"></button>
	            </div>
	            <div class="modal-body">
	                <h6 class="explain"><span class="membsh-span">${cstNm }</span> 고객님께 추천드리는 3가지 멤버십입니다.</h6>
	                <h6 class="explain">멤버십은 <span class="membsh-span">호텔 사용 내역</span>을 바탕으로 추천됩니다.</h6>
	                <div class="mbrshContainer">
					    <div class="swiper-container theme-slider" data-swiper='{"autoplay":true,"spaceBetween":1,"loop":true,"loopedSlides":1,"slideToClickedSlide":true}'>
					      <div class="swiper-wrapper">
					        <div class="swiper-slide">
					        <a href='<c:url value="/mbrsh" />'><img class="rounded-1 img-fluid" src="<c:url value='/resources/assets/img/mbrsh/${vo.recomMbrsh1 }.png'/>" alt="${vo.recomMbrsh1}" /></a></div>
					        <div class="swiper-slide">
					        <a href='<c:url value="/mbrsh" />'>
					        <img class="rounded-1 img-fluid" src="<c:url value='/resources/assets/img/mbrsh/${vo.recomMbrsh2 }.png'/>" alt="${vo.recomMbrsh2}" /></a>
					        </div>
					        <div class="swiper-slide">
					        <a href='<c:url value="/mbrsh" />'>
					        <img class="rounded-1 img-fluid" src="<c:url value='/resources/assets/img/mbrsh/${vo.recomMbrsh3 }.png'/>" alt="${vo.recomMbrsh3}" /></a>
					        </div>
					      </div>
				         <div class="swiper-nav">
					        <div class="swiper-button-next swiper-button-white"></div>
					        <div class="swiper-button-prev swiper-button-white"> </div>
					     </div>
					    </div>
	                </div>
	            </div>
	            <div class="modal-footer">
		            <div class="checkbox">
			            <input type="checkbox" id="myCheckbox" name="myCheckbox">
						<label class="check-label" for="myCheckbox">오늘은 그만 보기</label>
		            </div>
	                <button type="button" class="btn btn-dark" id="modal-end" data-dismiss="modal">Close</button>
	            </div>
	        </div>
	    </div>
	</div>
</c:if>

<!-- 멤버십 추천 팝업 종료 -->


<script>
	$(function() {
		$('#fullpage').fullpage({
			//options here
			autoScrolling : true,
			scrollHorizontally : true,
			navigation : true,
			navigationPosition : 'right',
			scrollingSpeed : 1000

		});
	});

	new fullpage('#fullpage', {
		  // fullpage.js 설정
		  afterLoad: function(origin, destination, direction) {
		    // 페이지 전환 후 실행할 코드 작성
		    console.log("다음 페이지로 이동했습니다.");
		    console.log("현재 페이지 인덱스:", destination.index);
		  }
		});

	
</script>
<script>
function section_roomDetail() {
	location.href = "${pageContext.request.contextPath}/room/standard.do";
}
</script>
<script defer src="<c:url value='/resources/js/app/cstmr/layout/index.js'/>"></script>
<!-- swiper.js -->
<script src="https://cdn.jsdelivr.net/npm/swiper@11/swiper-bundle.min.js"></script>

<!-- 멤버십 추천 js -->
<script src="<c:url value='/resources/js/app/emp/crm/cstmr/cstmrMembsh.js'/>"></script>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<!-- 멤버십 추천 js 끝-->