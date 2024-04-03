<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<link href="${pageContext.request.contextPath}/resources/css/cstmr/intrcn/mbrsh/mbrshList.css" rel="stylesheet">

<section>
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
	
	<div class="d-flex justify-content-center" >
	  <div class="row flex-center mbrsh-contain">
	  	<c:forEach items="${mbrshList }" var="mbrsh">
	        <div class="col-md-3 ">
	          <div class="card d-flex card-contain">
				<img alt="" src="<c:url value='/resources/assets/img/mbrsh/${mbrsh.mbsGrdCd }.png'/>" class="mbrsh-card mt-4">
				<div class="mt-2 mbrsh-info text-center">
					<div class="mbrsh-name">
						${mbrsh.mbsGrdNm}	
					</div>
					<div class="mt-1 mbrsh-price">
						<fmt:formatNumber value="${mbrsh.mbsGrdAmnt}" pattern="#,###" />KRW
					</div>
					<div class="mt-3">
					<button type="button" class="custom-btn btn-4" onclick="location.href='${pageContext.request.contextPath}/mbrsh/${mbrsh.mbsGrdNm }'">
						More Details
					</button>
					</div>
				</div>
				<div class="mbrsh-benefit">
					<dl>
						<dt>BENEFIT</dt>
						<dd>${mbrsh.mbsGrdPrk } 특전</dd>
						<dd>무료숙박권(${mbrsh.accomCoupon }) ${mbrsh.accomCouponCnt}매</dd>
                        <dd>20만원 할인권</dd>
                        <dd>10만원 할인권</dd>
						<dd>5만원 할인권</dd>
					</dl>
				</div>
	          </div>
	        </div>
	  	</c:forEach>
      </div>
	</div>
</section>