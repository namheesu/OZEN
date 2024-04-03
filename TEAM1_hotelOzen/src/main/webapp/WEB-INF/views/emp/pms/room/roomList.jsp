<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<link href="${pageContext.request.contextPath}/resources/css/emp/pms/modalCss.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/resources/css/emp/pagingCss.css" rel="stylesheet">

<div class="col mb-3">
	<div class="card h-100">
		<div class="card-header">
			<div class="row flex-between-end">
				<nav style="--falcon-breadcrumb-divider: url(&#34;data:image/svg+xml,%3Csvg xmlns='http://www.w3.org/2000/svg' width='8' height='8'%3E%3Cpath d='M2.5 0L1 1.5 3.5 4 1 6.5 2.5 8l4-4-4-4z' fill='%23748194'/%3E%3C/svg%3E&#34;);" aria-label="breadcrumb">
				  <ol class="breadcrumb">
				    <li class="breadcrumb-item"><a href="${pageContext.request.contextPath}/emp">Home</a></li>
				    <li class="breadcrumb-item">호텔관리</li>
				    <li class="breadcrumb-item active" aria-current="page">객실관리</li>
				  </ol>
				</nav>
				
				<div id="roomListTable">
					<div>
						<form id="searchForm" action="<c:url value='/emp/pms/room/roomList.do'/>">
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
									<a class="col-sm-auto selectOneSearchWordATag" data-value=""> 전체 객실 수 : ${roomListMap.totalRecord }</a>
									<a class="col-sm-auto selectOneSearchWordATag" data-value="빈객실"> 빈 객실 : ${roomListMap.emptyRecord }</a>
									<a class="col-sm-auto selectOneSearchWordATag" data-value="투숙중"> 투숙중인 객실 : ${roomListMap.stayRecord }</a>
									<a class="col-sm-auto selectOneSearchWordATag" data-value="청소"> 청소중인 객실 : ${roomListMap.cleanRecord }</a>
									<a class="col-sm-auto selectOneSearchWordATag" data-value="고장"> 고장난 객실 : ${roomListMap.breakRecord }</a>
								</div>
							</div>
						</div>
					</div>
					<div class="table-responsive scrollbar">
						<table class="table mb-0 center">
							<thead class="bg-oran">
								<tr>
									<th class="align-middle wdf " data-sort="rnum">번호</th>
									<th class="align-middle " data-sort="rmNo">객실번호</th>
									<th class="align-middle " data-sort="rmtTypeCd">객실타입</th>
									<th class="align-middle " data-sort="rmAvlblDetails">객실상태</th>
									<th class="align-middle " data-sort="rmClean">청소여부</th>
									<th class="align-middle " data-sort="rmCleanClear"></th>
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
			
			<!-- 객실 상세 조회 -->
			<div class="modal fade" id="roomList-select" tabindex="-1"
				role="dialog" aria-labelledby="authentication-modal-label" aria-hidden="true">
				<div class="modal-dialog modal-lg mt-6" role="document">
					<div class="modal-content border-0">
						<div class="modal-header px-5 position-relative bg-secondary  ">
							<div class="position-relative z-1">
								<h4 class="mb-0 text-white" id="authentication-modal-label">
									객실 상세 조회</h4>
							</div>
							<button class="btn-close position-absolute top-0 end-0 mt-2 me-2"
								data-bs-dismiss="modal" aria-label="Close"></button>
						</div>
						<div class="modal-body py-4 px-5">
							
						</div>
					</div>
				</div>
			</div>
			
		</div>
	</div>
</div>

<script src="<c:url value='/resources/js/app/emp/pms/room/roomList.js'/>"></script>
<script src="<c:url value='/resources/js/app/common/paging.js'/>"></script>