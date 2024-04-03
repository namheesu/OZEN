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
				    <li class="breadcrumb-item">룸서비스 관리</li>
				    <li class="breadcrumb-item active" aria-current="page">룸서비스 조리내역</li>
				  </ol>
				</nav>

				<div id="rmSRqstList">
					<div>
						<form id="searchForm"
							action="<c:url value='/emp/pms/roomSvc/roomSvcRqstList.do'/>">
							<input type="hidden" name="page" /> <input type="hidden"
								name="searchWord" value="${simpleCondition.searchWord }" /> <input
								type="hidden" name="selectOneSearchWord"
								value="${simpleCondition.selectOneSearchWord }" />
						</form>
						<div class="row justify-content-end g-0" data-pg-role="searchUI"
							data-pg-target="#searchForm">
							<div class="col-auto px-3">
								<div class="input-group">
									<select class="form-select form-select-sm mb-3"
										name="selectOneSearchWord"
										data-pg-init-value="${simpleCondition.selectOneSearchWord }">
										<option selected="" value="">== 상태 ==</option>
										<option value="준비중">준비중</option>
										<option value="완료">완료</option>
									</select>
								</div>
							</div>
							<div class="col-auto col-sm-5 mb-3">
								<div class="input-group">
									<input class="form-control form-control-sm shadow-none search"
										type="search" placeholder="Search..." aria-label="search"
										name="searchWord" value="${simpleCondition.searchWord }" />
									<div class="input-group-text bg-transparent">
										<span class="fa fa-search fs-10 text-600"
											data-pg-role="searchBtn"></span>
									</div>
								</div>
							</div>
						</div>
					</div>

					<div class="table-responsive scrollbar">
						<table
							class="table table-bordered table-striped fs-10 mb-0 bg-light">
							<thead class="bg-200 border border-bottom">
								<tr>
									<th class="text-900 sort" data-sort="no">번호</th>
									<th class="text-900 sort" data-sort="rmsvcNo">룸 서비스 주문번호</th>
									<th class="text-900 sort" data-sort="rmsvcCd">룸서비스 코드</th>
									<th class="text-900 sort" data-sort="rsMenuNm">룸서비스 메뉴</th>
									<th class="text-900 sort" data-sort="rmNo">객실번호</th>
									<th class="text-900 sort" data-sort="cstNm">고객이름</th>
									<th class="text-900 sort" data-sort="rsodSe">상태</th>
								</tr>
							</thead>
							<tbody class="list" id="listBody">

							</tbody>
						</table>
					</div>
					
					<!-- 페이징 -->
					<div class="card-footer d-flex justify-content-center paging-div-height"
						id="pagingArea"></div>

				</div>
			</div>

			<!-- 예약 상세 조회 -->
			<div class="modal fade" id="rmsvc-select" tabindex="-1" role="dialog"
				aria-labelledby="authentication-modal-label" aria-hidden="true">
				<div class="modal-dialog modal-lg mt-6" role="document">
					<div class="modal-content border-0">
						<div class="modal-header px-5 position-relative bg-secondary  ">
							<div class="position-relative z-1">
								<h4 class="mb-0 text-white" id="authentication-modal-label">
									룸서비스 상세내역 조회</h4>
							</div>
							<button class="btn-close position-absolute top-0 end-0 mt-2 me-2"
								data-bs-dismiss="modal" aria-label="Close"></button>
						</div>
						<div class="modal-body py-4 px-5">
							<form>
								<div class="row gx-2">
									<div class="mb-3 col-sm-4">
										<label class="form-label" for="model-rsvt-no">객실 번호</label> <input
											class="form-control" type="text" autocomplete="on"
											id="model-rsvt-no" />
									</div>
									<div class="mb-3 col-sm-4">
										<label class="form-label" for="model-rsvt-name">고객 이름</label>
										<input class="form-control" type="text" autocomplete="on"
											id="model-rsvt-name" />
									</div>
									<div class="mb-3 col-sm-4">
										<label class="form-label" for="model-rsvt-name">고객
											전화번호</label> <input class="form-control" type="text"
											autocomplete="on" id="model-rsvt-name" />
									</div>
								</div>
								<div class="row gx-2">
									<div class="mb-3 col-sm-6">
										<label class="form-label" for="model-rsvt-no">룸
											서비스주문번호</label> <input class="form-control" type="text"
											autocomplete="on" id="model-rsvt-no" />
									</div>
									<div class="mb-3 col-sm-6">
										<label class="form-label" for="model-rsvt-name">룸 서비스
											주문 수량</label> <input class="form-control" type="text"
											autocomplete="on" id="model-rsvt-name" />
									</div>
								</div>
								<div class="row gx-2 " id="rmsvc-cnt">
									<div class="mb-3 col-sm-4">
										<label class="form-label" for="model-rsvt-no">룸 서비스 코드</label>
										<input class="form-control" type="text" autocomplete="on"
											id="model-rsvt-no" />
									</div>
									<div class="mb-3 col-sm-4">
										<label class="form-label" for="model-rsvt-name">메뉴 명</label> <input
											class="form-control" type="text" autocomplete="on"
											id="model-rsvt-name" />
									</div>
									<div class="mb-3 col-sm-4">
										<label class="form-label" for="model-rsvt-name">가격</label> <input
											class="form-control" type="text" autocomplete="on"
											id="model-rsvt-name" />
									</div>
									<div class="mb-3 col-sm-4">
										<label class="form-label" for="model-rsvt-no">룸 서비스 코드</label>
										<input class="form-control" type="text" autocomplete="on"
											id="model-rsvt-no" />
									</div>
									<div class="mb-3 col-sm-4">
										<label class="form-label" for="model-rsvt-name">메뉴 명</label> <input
											class="form-control" type="text" autocomplete="on"
											id="model-rsvt-name" />
									</div>
									<div class="mb-3 col-sm-4">
										<label class="form-label" for="model-rsvt-name">가격</label> <input
											class="form-control" type="text" autocomplete="on"
											id="model-rsvt-name" />
									</div>
								</div>

								<div>
									<div class="mb-3 ps-1 col-sm-4 float-end">
										<button class="btn btn-secondary d-block w-100 mt-3"
											type="submit" name="submit">완료</button>
									</div>
								</div>
								<div>
									<div class="mb-3 ps-1 col-sm-4 float-end">
										<button class="btn btn-secondary d-block w-100 mt-3"
											type="submit" name="submit">승인</button>
									</div>
								</div>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>

<script src="<c:url value='/resources/js/app/emp/pms/roomSvc/roomSvcRqstList.js'/>"></script>
<script src="<c:url value='/resources/js/app/common/paging.js'/>"></script>
