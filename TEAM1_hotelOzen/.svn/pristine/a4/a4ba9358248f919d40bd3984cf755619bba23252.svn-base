<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<div class="mypage-detail-title">
	Membership 가입 내역
</div>

<link href="${pageContext.request.contextPath}/resources/css/cstmr/myinfo/mbrshSetle.css" rel="stylesheet">

<c:choose>
	<c:when test="${not empty mbrshList}">
		<div class="listBox">
		<ul id="couponInofUL" class="cardList coupon">
		<c:forEach items="${mbrshList }" var="mbrsh">
			<li>
				<div class="cardInner">
					<span class="keyword">
					</span>
					<p class="tit">
						<em>${mbrsh.mbsGrdCd}</em>  
						<em>
							<fmt:formatNumber value="${mbrsh.mbsSetleAmnt }" pattern="#,###" />원 결제
						</em>
					</p>
					
					<p>
						<img alt="" src="<c:url value='/resources/assets/img/mbrsh/${mbrsh.mbsGrdCd }.png'/>" class="mbrsh-card" style="width:200px; height:120px;">
					</p>
					<p class="number">
						<!-- 쿠폰번호 -->
						쿠폰번호&nbsp&nbsp<em>${coupon.cpnNo }</em>
					</p>
					<p class="period">
						<em>${mbrsh.mbsSbscrbYmd } ~ ${mbrsh.mbsExprtYmd }</em>
					</p>
				</div>
			</li>
		</c:forEach>
		</ul>
	</div>
	</c:when>
	<c:otherwise>
		<ul class="membershipCashList">
			<li class="noData">
				<p class="txt">
					구매한 멤버십 내역이 없습니다.<br>혜택 안내를 확인 후 멤버십을 구매해 보세요.
				</p>
			</li>
		</ul>
	</c:otherwise>
</c:choose>