<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<link href="${pageContext.request.contextPath}/resources/css/cstmr/myinfo/mileage.css" rel="stylesheet">

<div class="mypage-detail-title">
	마일리지
</div>
<div class="myAccountBox mt-4">
	<div class="myAccountInfo">
		<dl>
			<dt>
				<!-- 사용가능 포인트 -->
				사용가능 포인트
			</dt>
			<dd>
				<span class="usablePoint">${user.mberMileage }</span>
				<p class="txtGuide">2024.03.23 기준</p>
			</dd>
		</dl>
	</div>
</div>

<table class="tblH myPoint mt-6">
	<colgroup>
		<col style="width: auto">
		<col style="width: 15%">
		<col style="width: 20%%">
		<col style="width: 20%">
		<col style="width: 20%">
	</colgroup>
	<thead>
		<tr>
			<th scope="col">
				날짜
			</th>
			<th scope="col">
				구분
			</th>
			<th scope="col">
				내역
			</th>
			<th scope="col">
				적립 포인트
			</th>
			<th scope="col">
				차감 포인트
			</th>
		</tr>
	</thead>
	<tbody id="pointHistTbody">
		<c:if test="${not empty mileageList }">
			<c:forEach items="${mileageList }" var="mlg">
				<tr>
					<td>${mlg.mlgYmd } </td>
					<td>${mlg.mlgUseCd }</td>
					<td>${mlg.mlgSort }</td>
					<c:choose>
						<c:when test="${mlg.mlgUseCd eq '추가' }">
							<td><fmt:formatNumber value="${mlg.mlgAmnt }" pattern="#,###" ></fmt:formatNumber> </td>
							<td>-</td>
						</c:when>
						<c:otherwise>
							<td>-</td>
							<td><fmt:formatNumber value="${mlg.mlgAmnt }" pattern="#,###"></fmt:formatNumber></td>
						</c:otherwise>
					</c:choose>
				</tr>
			</c:forEach>
		</c:if>
		<c:if test="${empty mileageList }">
		<tr>
			<td colspan="5" class="noData">
				<p class="txt">
					조회 내역이 없습니다.
				</p>
			</td>
		</tr>
		</c:if>
	</tbody>
</table>
