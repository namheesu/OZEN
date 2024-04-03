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
				    <li class="breadcrumb-item active" aria-current="page">비품 요청서 목록</li>
				  </ol>
				</nav>

				<div id="fxtrsRqstListTable">
					<div>
						<form id="searchForm" action="<c:url value='/emp/pms/fxtrs/rqstList.do'/>">
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
						          	<span class="fa fa-search fs-10 text-600" id="selectBtn" data-pg-role="searchBtn"></span>
						          </div>
						        </div>
							</div>
							
							<div class="row mb-2">
								<input type="hidden"
										id="selectOneSearchWordInput"
										name="selectOneSearchWord"
										data-pg-init-value="${simpleCondition.selectOneSearchWord }">
								<div class="row col-sm-8 align-items-center">
									<a class="col-sm-auto selectOneSearchWordATag" data-value=""> 전체요청 건 : ${fxtrsrqstList.totalRecord }</a>
									<a class="col-sm-auto selectOneSearchWordATag" data-value="요청대기"> 요청대기 건: ${fxtrsrqstList.rqstRecord }</a>
									<a class="col-sm-auto selectOneSearchWordATag" data-value="구매대기"> 구매대기건 : ${fxtrsrqstList.payRecord }</a>
									<a class="col-sm-auto selectOneSearchWordATag" data-value="구매완료"> 구매완료 건 : ${fxtrsrqstList.payClearRecord }</a>
									<a class="col-sm-auto selectOneSearchWordATag" data-value="반려"> 반려 건 : ${fxtrsrqstList.returnRecord }</a>
								</div>
							</div>
						</div>
					</div>
					<div class="table-responsive scrollbar">
						<table class="table mb-0 center">
							<thead class="bg-oran">
								<tr>
									<th class="align-middle wdf" data-sort="no">번호</th>
 									<th class="align-middle" data-sort="rqstNo">요청번호</th>
									<th class="align-middle" data-sort="empNm">요청자</th>
									<th class="align-middle" data-sort="rqstYmd">작성일</th>
									<th class="align-middle" data-sort="rqstAmnt">총가격</th>
									<th class="align-middle" data-sort="rqstSe">요청상태</th>
									<th class="align-middle" data-sort="empRqNm">요청결재자</th>
									<th class="align-middle" data-sort="rqstRqYmd">요쳥결재일</th>
									<th class="align-middle" data-sort="empPurchsNm">구매결재자</th>
									<th class="align-middle" data-sort="rqstPurchsYmd">구매결재일</th>
								</tr>
							</thead>
							<tbody class="list" id="listBody">
								
							</tbody>
						</table>
					</div>
					
					<!-- 페이징 -->
					<div class="card-footer d-flex justify-content-center paging-div-height" id="pagingArea">
					
					</div>
				</div>
				
			</div>
		</div>
	</div>
</div>

<script src="<c:url value='/resources/js/app/emp/pms/fxtrs/rqstList.js'/>"></script>
<script src="<c:url value='/resources/js/app/common/paging.js'/>"></script>