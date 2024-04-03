<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<link href="${pageContext.request.contextPath}/resources/css/emp/pagingCss.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/resources/css/cstmr/comm/noticeList.css" rel="stylesheet">


<section>
	<div>
		<div class="notice-header mx-10">
			<h1 class="cstmr-title mx-5">NOTICE</h1>
			<p class="cstmr-content mx-5 mb-5">호텔 오젠의 새 소식을 알려드립니다.</p>
		</div>
		<div id="tableExample3" class="bg-light mx-10">
			<div>
				<form id="searchForm" action="<c:url value='/comm/notice/noticeList.do'/>">
					<input type="hidden" name="page" />
					<input type="hidden" name="searchWord" value="${simpleCondition.searchWord }" />
				</form>
				
				<div class="row justify-content-end g-0" data-pg-role="searchUI" data-pg-target="#searchForm">
					<div class="col-auto col-sm-2 my-3 mx-2">
				        <div class="input-group">
				          <input class="form-control form-control-sm shadow-none search mx" type="search" placeholder="Search..." aria-label="search" name ="searchWord" value="${simpleCondition.searchWord }"/>
				          <div class="input-group-text bg-transparent">
				          	<span class="fa fa-search fs-10 text-600" data-pg-role="searchBtn"></span>
				          </div>
				        </div>
					</div>
				</div>
			</div>
			
			
			<div class="table-responsive scrollbar">
				<table class="table table-bordered table-striped mb-0 table table-hover">
					<thead class="bg-light notice-menu visually-hidden">
						<tr>
							<th class="notice-list_number" data-sort="number">번호</th>
							<th class="notice-list_title" data-sort="title">제목</th>
							<th class="notice-list_file" data-sort="file">첨부파일</th>
							<th class="notice-list_cnt" data-sort="cnt">조회수</th>
							<th class="notice-list_date" data-sort="date">날짜</th>
						</tr>
					</thead>
					
					<tbody class="list" id="listBody">
					
					</tbody>
				</table>
			</div>
			<div class="card-footer d-flex justify-content-center paging-div-height" id="pagingArea">
			
			</div>
		</div>
	</div>
</section>


<script src="<c:url value='/resources/js/app/cstmr/comm/notice/MberNotice.js'/>"></script>
<script src="<c:url value='/resources/js/app/common/paging.js'/>"></script>