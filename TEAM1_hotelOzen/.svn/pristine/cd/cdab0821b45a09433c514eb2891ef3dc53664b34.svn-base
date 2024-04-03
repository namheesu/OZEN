<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form"  prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags"  prefix="spring"%>

<link href="${pageContext.request.contextPath }/resources/vendors/swiper/swiper-bundle.min.css" rel="stylesheet" />
<link href="${pageContext.request.contextPath }/resources/css/emp/crm/cstmr/cstmrMembsh.css" rel="stylesheet" />



<style></style>


<div class="modal" id="myModal" tabindex="-1" role="dialog">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title">Membership Recommendation</h5>
                <button type="button" class="btn-close" data-dismiss="modal" aria-label="Close">
<!--                     <span aria-hidden="true">&times;</span> -->
                </button>
            </div>
            <div class="modal-body">
                <h6 class="explain"><span>${mberNm }</span> 고객님께 추천드리는 3가지 멤버십입니다.</h6>
                <h6 class="explain">멤버십은 고객님의 <span>호텔 사용 내역</span>을 바탕으로 추천됩니다.</h6>
                <div class="mbrshContainer">
				    <div class="swiper-container theme-slider" data-swiper='{"autoplay":true,"spaceBetween":5,"loop":true,"loopedSlides":5,"slideToClickedSlide":true}'>
				      <div class="swiper-wrapper">
				        <div class="swiper-slide">
				        <a href="#"><img class="rounded-1 img-fluid" src="<c:url value='/resources/assets/img/mbrsh/${vo.recomMbrsh1 }.png'/>" alt="${vo.recomMbrsh1}" /></a></div>
				        <div class="swiper-slide">
				        <a href="#">
				        <img class="rounded-1 img-fluid" src="<c:url value='/resources/assets/img/mbrsh/${vo.recomMbrsh2 }.png'/>" alt="${vo.recomMbrsh2}" /></a>
				        </div>
				        <div class="swiper-slide">
				        <a href="#">
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
					<label class="explain" for="myCheckbox">오늘은 그만 보기</label>
	            </div>
<!--                 <button type="button" class="btn btn-primary" id = "modal-today-close">today</button> -->
                <button type="button" class="btn btn-dark" id="modal-end" data-dismiss="modal">Close</button>
            </div>
        </div>
    </div>
</div>


<script>
</script>

<script src="<c:url value='/resources/js/app/emp/crm/cstmr/cstmrMembsh.js'/>"></script>
<script src="${pageContext.request.contextPath }/resources/vendors/swiper/swiper-bundle.min.js"></script>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
