<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<link href="${pageContext.request.contextPath}/resources/css/cstmr/comm/noticeView.css" rel="stylesheet">

<section>
	<div>
		<div class="notice-header mx-10">
			<h1 class="cstmr-title mx-5">NOTICE</h1>
			<p class="cstmr-content mx-5 mb-5">호텔 오젠의 새 소식을 알려드립니다.</p>
			<hr class="hr-detail mx-5">
		</div>
	</div>
	<div class="notice_body">
		<div class="detail-notice_menu mx-10">
			<div class="header-content-container d-flex align-items-center">
				<div class="detail-notice_title mx-7 py-3">${memNoti.mberNtNm }</div>
				<div class="notice_rigth_top d-flex mx-7">
					<div class="mx-2 notice_right_ymd">${memNoti.mberNtYmd }</div>
					<div class="mx-5 notice_right" style="margin-left: 10px;">${memNoti.mberNtCnt }</div>
				</div>
			</div>
			<hr class="hr-detail_inner mx-5">
		</div>
		<div class="detail-notice_content mx-10">
			<div class="mx-7">
				<p class="has-text-align-left mx-7">
					${memNoti.mberNtCn }
				</p>
			</div>
			<hr class="hr-detail_inner mx-5">
		</div>
		<div class="btn-layout d-flex mb-3 flex-row-reverse">
			<button class="custom-btn btn-11" onclick="noticeList();">목록</button>
		</div>
	</div>
</section>

<script>
function noticeList() {
	location.href = "${pageContext.request.contextPath}/comm/notice/noticeList.do";
}
</script>