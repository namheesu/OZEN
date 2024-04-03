<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<link
	href="${pageContext.request.contextPath}/resources/css/cstmr/rsvt/rsvtList.css"
	rel="stylesheet">
<section>
	<div class="container">
		<div class="mt-8 container text-center">
			<h1>비회원 예약조회</h1>
		</div>
		<div class="container ">
			<form:form id="submitForm" method="post" action="${pageContext.request.contextPath}/cstmr/rsvt/rsvtNberView">
			<div class="ml mt-5">
				<div class="hot-box">오젠호텔</div>
				<div class="d-flex">
					<input class="tel-box" type="text" id="hp1" maxlength="3" placeholder="전화번호"> 
					<input class="tel-box" type="text" id="hp2"	maxlength="4"> 
					<input class="tel-box" type="text" id="hp3" maxlength="4">
				</div>
				<div>
					<input class="hot-box" type="text" id="rsvt[0].rsvtNo" name="rsvt[0].rsvtNo" placeholder="예약번호">
				</div>
				<div class="wid-740">
					<button type="submit" color="primary"
					class="mt-3 custom-btn btn-7 wid-740" id="submitBtn">예약확인</button>
				</div>
			</div>
				<input type="hidden" id="cstHp" name="cstHp" >
			</form:form>
			<div>회원가입 후 더 많은 혜택을 누리세요.</div>
			<div>회원가입</div>
			<div></div>
		</div>
	</div>
</section>
<script>
$(document).ready(function() {
    $("#submitBtn").click(function() {
    	combine();
        $("#submitForm").submit();
    });
});
</script>
<script defer
	src="<c:url value='/resources/js/app/cstmr/rsvt/rsvtList.js'/>"></script>