<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<link href="${pageContext.request.contextPath}/resources/css/emp/pagingCss.css" rel="stylesheet">

<div class="card mb-3">
	<div class="card h-100">
		<div class="card-header">
			<div class="row flex-between-end">
				<nav style="--falcon-breadcrumb-divider: url(&#34;data:image/svg+xml,%3Csvg xmlns='http://www.w3.org/2000/svg' width='8' height='8'%3E%3Cpath d='M2.5 0L1 1.5 3.5 4 1 6.5 2.5 8l4-4-4-4z' fill='%23748194'/%3E%3C/svg%3E&#34;);" aria-label="breadcrumb">
				  <ol class="breadcrumb">
				    <li class="breadcrumb-item"><a href="${pageContext.request.contextPath}/emp">Home</a></li>
				    <li class="breadcrumb-item">자산관리</li>
				    <li class="breadcrumb-item">회계</li>
				    <li class="breadcrumb-item active" aria-current="page">환불내역</li>
				  </ol>
				</nav>				
				<div id="refunListTable">
					<div>
						<form id="searchForm" action="<c:url value='/emp/pos/acnt/refnd/refndList'/>">
							<input type="hidden" name="page" /> 
							<input type="hidden" name="searchWord" value="${simpleCondition.searchWord }" /> 
							<input type="hidden" name="selectOneSearchWord" value="${simpleCondition.selectOneSearchWord }" />
						</form>
						<div class="row justify-content-end g-0" data-pg-role="searchUI" data-pg-target="#searchForm">
							<div class="col-auto col-sm-5 mb-3 d-flex" style=" justify-content: right;">
								<div class="input-group" style="width:280px; ">
									<input class="form-control form-control-sm shadow-none search "
										type="search" placeholder="Search..." aria-label="search"
										name="searchWord" value="${simpleCondition.searchWord }" />
									<div class="input-group-text bg-transparent">
										<span class="fa fa-search fs-10 text-600" id="selectBtn"
											data-pg-role="searchBtn"></span>
										<!-- 스타일 변경 -->
									</div>
								</div>
							</div>
						</div>
					</div>
					<div class="table-responsive scrollbar">
						<table class="table mb-0 center">
							<thead class="bg-oran">
								<tr>
									<th class="align-middle" data-sort="rnum">번호</th>
									<th class="align-middle" data-sort="setleNo">결제번호</th>
									<th class="align-middle" data-sort="cstName">고객명</th>
									<th class="align-middle" data-sort="setleYmd">결제일</th>
									<th class="align-middle" data-sort="refndYmd">환불일</th>
									<th class="align-middle" data-sort="setleAmnt">결제금액</th>
									<th class="align-middle" data-sort="refndAmnt">환불금액</th>
									<th class="align-middle" data-sort="refndRatio">환불비율</th>
								</tr>
							</thead>
							<tbody class="list" id="listBody">
					
							</tbody>
						</table>
					</div>
					<div class="card-footer d-flex justify-content-center paging-div-height"
							id="pagingArea">
					</div>
				</div>
			</div>
		</div>
	</div>
</div>

<script defer src="<c:url value='/resources/js/app/common/paging.js'/>"></script>
<script defer src="<c:url value='/resources/js/app/emp/pos/acnt/refund/refndList.js'/>"></script>