<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<link href="${pageContext.request.contextPath}/resources/css/emp/pagingCss.css" rel="stylesheet">

<div class="col mb-3">
	<div class="card h-100">
		<div class="card-header">
			<div class="row flex-between-end">
				<nav style="--falcon-breadcrumb-divider: url(&#34;data:image/svg+xml,%3Csvg xmlns='http://www.w3.org/2000/svg' width='8' height='8'%3E%3Cpath d='M2.5 0L1 1.5 3.5 4 1 6.5 2.5 8l4-4-4-4z' fill='%23748194'/%3E%3C/svg%3E&#34;);" aria-label="breadcrumb">
				  <ol class="breadcrumb">
				    <li class="breadcrumb-item"><a href="${pageContext.request.contextPath}/emp">Home</a></li>
				    <li class="breadcrumb-item">호텔관리</li>
				    <li class="breadcrumb-item">비품관리</li>
				    <li class="breadcrumb-item active" aria-current="page">현재 비품 수량</li>
				  </ol>
				</nav>

				<div id="fxtrsListTable">
					<div>
						<form id="searchForm" action="<c:url value='/emp/pms/fxtrs/presList.do'/>">
							<input type="hidden" name="page" />
							<input type="hidden" name="searchWord" value="${simpleCondition.searchWord }"/>
							<input type="hidden" name="selectOneSearchWord" value="${simpleCondition.selectOneSearchWord }"/>
						</form>
						<div class="row justify-content-end g-0" data-pg-role="searchUI" data-pg-target="#searchForm">
							<div class="col-auto col-sm-5 mb-3">
						        <div class="input-group">
						          <input class="form-control form-control-sm shadow-none search" 
						          		type="search" placeholder="Search..." aria-label="search" 
						          		name ="searchWord" value="${simpleCondition.searchWord }"/>
						          <div class="input-group-text bg-transparent">
						          	<span class="fa fa-search fs-10 text-600" data-pg-role="searchBtn"></span>
						          </div>
						        </div>
							</div>
						</div>
					</div>

					<div class="row justify-content-end g-0">
						<a class="btn float-end border mb-2 col-auto fxpresAdd" href="${pageContext.request.contextPath}/emp/pms/fxtrs/rqstListadd.do">
							<i class="bi bi-plus-lg"></i> 비품 요청서 작성
						</a>
					</div>
					
					<div class="table-responsive scrollbar row">
						<div class="col-sm-6 my-2">
							<h5 class="px-2 py-2">욕실비품</h5>
							<table class="table mb-0 center">
								<thead class="bg-oran">
									<tr>
										<th></th>
										<th class="align-middle wdf" data-sort="fxCd">비품코드</th>
										<th class="align-middle" data-sort="fxNm">비품명</th>
										<th class="align-middle" data-sort="fxTtrtnCnt">적정재고량</th>
	 									<th class="align-middle" data-sort="fxPresCnt">현재고량</th>
										<th class="align-middle" data-sort="fxPrfrn">발주 요청 우선도</th>
									</tr>
								</thead>
								<tbody class="list" id="BtrListBody">
									
								</tbody>
							</table>
						</div>
						
						<div class="col-sm-6 my-2">
							<h5 class="px-2 py-2">주방비품</h5>
							<table class="table mb-0">
								<thead class="bg-oran">
									<tr>
										<th></th>
										<th class="align-middle wdf" data-sort="fxCd">비품코드</th>
										<th class="align-middle" data-sort="fxNm">비품명</th>
										<th class="align-middle" data-sort="fxPresCnt">적정재고량</th>
	 									<th class="align-middle" data-sort="fxTtrtnCnt">현재고량</th>
										<th class="align-middle" data-sort="fxPrfrn">발주 요청 우선도</th>
									</tr>
								</thead>
								<tbody class="list" id="KtcListBody">
									
								</tbody>
							</table>
						</div>
						
						<div class="col-sm-6 my-2">
							<h5 class="px-2 py-2">침구비품</h5>
							<table class="table mb-0">
								<thead class="bg-oran">
									<tr>
										<th></th>
										<th class="align-middle wdf" data-sort="fxCd">비품코드</th>
										<th class="align-middle" data-sort="fxNm">비품명</th>
										<th class="align-middle" data-sort="fxPresCnt">적정재고량</th>
	 									<th class="align-middle" data-sort="fxTtrtnCnt">현재고량</th>
										<th class="align-middle" data-sort="fxPrfrn">발주 요청 우선도</th>
									</tr>
								</thead>
								<tbody class="list" id="BdnListBody">
									
								</tbody>
							</table>
						</div>
						
						<div class="col-sm-6 my-2">
							<h5 class="px-2 py-2">편의비품</h5>
							<table class="table mb-0">
								<thead class="bg-oran">
									<tr>
										<th></th>
										<th class="align-middle wdf" data-sort="fxCd">비품코드</th>
										<th class="align-middle" data-sort="fxNm">비품명</th>
										<th class="align-middle" data-sort="fxPresCnt">적정재고량</th>
	 									<th class="align-middle" data-sort="fxTtrtnCnt">현재고량</th>
										<th class="align-middle" data-sort="fxPrfrn">발주 요청 우선도</th>
									</tr>
								</thead>
								<tbody class="list" id="CnvListBody">
									
								</tbody>
							</table>
						</div>
					</div>
					
					<!-- 페이징 -->
					<div class="card-footer d-flex justify-content-center paging-div-height" id="pagingArea">
					
					</div>
				</div>

			</div>
			
		</div>
	</div>
</div>

<!-- 쿼리파라미터 안보이게  -->
<script>
	$( document ).ready(function() {
	
		history.replaceState({}, null, location.pathname);
	    
	});
</script>

<script src="<c:url value='/resources/js/app/emp/pms/fxtrs/presList.js'/>"></script>
<script src="<c:url value='/resources/js/app/common/paging.js'/>"></script>