<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<link href="${pageContext.request.contextPath}/resources/css/cstmr/myinfo/couponList.css" rel="stylesheet">

<div class="mypage-detail-title">
	쿠폰
</div>

<div>
	<c:if test="${not empty user.couponList }">
	<div class="listBox">
		<div class="countList">
			<span class="count">총 <em>${user.totalCoupon }</em>건</span>
		</div>
		<ul id="couponInofUL" class="cardList coupon">
		<c:forEach items="${user.couponList }" var="coupon">
			<li>
				<div class="cardInner">
					<span class="keyword">
						${coupon.cpnUse }
					</span>
					<p class="tit">
						<em>${coupon.cpnkNm}</em>  
						<c:if test="${empty coupon.cpnkNm }">
							<em>
								<fmt:formatNumber value="${coupon.cpnDscntPrice }" pattern="#,###" />원 할인권
							</em>
						</c:if>
					</p>
					<p class="number">
						<!-- 쿠폰번호 -->
						쿠폰번호&nbsp&nbsp<em>${coupon.cpnNo }</em>
					</p>
					<p class="period">
						<em>${coupon.cpnIssuYmd } ~ ${coupon.cpnExprtYmd }</em>
						<c:if test="${not empty coupon.cpnUseYmd }">
							이용 날짜
						<em>${coupon.cpnUseYmd }</em>
						</c:if>
					</p>
					<p class="period">
						사용 가능 여부 &nbsp&nbsp
						<span class="avail">
						<c:if test="${coupon.cpnAvailYn eq 'Y' }">
							사용 가능
						</c:if>
						<c:if test="${coupon.cpnAvailYn eq 'N' }">
							사용 기한 초과
						</c:if>
						<c:if test="${coupon.cpnAvailYn eq 'U' }">
							사용됨
						</c:if>
						</span>
					</p>
				</div>
			</li>
		</c:forEach>
		</ul>
	</div>
	
	</c:if>
	<c:if test="${empty user.couponList }">
		<ul class="membershipCashList">
          	 <li class="noData">
             	  <p class="txt">
                 	  쿠폰 내역이 없습니다.
             	  </p>
         	  </li>
      	  </ul>		
	</c:if>
</div>