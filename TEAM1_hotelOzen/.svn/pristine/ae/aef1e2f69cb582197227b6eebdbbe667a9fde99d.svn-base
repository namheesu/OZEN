<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form"  prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags"  prefix="spring"%>

<link href="${pageContext.request.contextPath}/resources/css/emp/pagingCss.css" rel="stylesheet">

<div class="col mb-3">
	<div class="card h-100">
		<div class="card-header">
			<div class="row flex-between-end">
				<nav style="--falcon-breadcrumb-divider: url(&#34;data:image/svg+xml,%3Csvg xmlns='http://www.w3.org/2000/svg' width='8' height='8'%3E%3Cpath d='M2.5 0L1 1.5 3.5 4 1 6.5 2.5 8l4-4-4-4z' fill='%23748194'/%3E%3C/svg%3E&#34;);" aria-label="breadcrumb">
					<ol class="breadcrumb">
						<li class="breadcrumb-item"><a href="${pageContext.request.contextPath}/emp/index.do">Home</a></li>
						<li class="breadcrumb-item">인사관리</li>
						<li class="breadcrumb-item active" aria-current="page">연차관리</li>
					</ol>
				</nav>
				
<!-- 				<input name="bgn" type="date"/> -->
<!-- 				<input name="end" type="date"/> -->
				
				
				
				<!-- 테이블 -->
				<div id="yrycListTable">
					<div>
						<form id="searchForm" action="<c:url value='/emp/hrm/dclz/yryc'/>">
							<input type="hidden" name="page" />
							<input type="hidden" name="searchWord" value="${simpleCondition.searchWord }"/>
							<input type="hidden" name="selectOneSearchWord" value="${simpleCondition.selectOneSearchWord }"/>
						</form>
						<div class="row justify-content-end g-0" data-pg-role="searchUI" data-pg-target="#searchForm">
							<div class="col-auto px-3">
								<div class="input-group">
									<select class="form-select form-select-sm mb-3"
										name="selectOneSearchWord"
										data-pg-init-value="${simpleCondition.selectOneSearchWord }">
									<option value>==부서==</option>
									<option value="FTO">프론트오피스부</option>
									<option value="HKP">하우스키핑부</option>
									<option value="FMT">시설관리부</option>
									<option value="CRM">고객관리부</option>
									<option value="POS">재무부</option>
									<option value="HRM">인사부</option>
									</select>
								</div>
							</div>
							<div class="col-auto col-sm-3 mb-3">
								<div class="input-group">
									<input class="form-control form-control-sm shadow-none search" 
										type="search" placeholder="검색" aria-label="search" 
										name ="searchWord" value="${simpleCondition.searchWord }"/>
									<div class="input-group-text bg-transparent">
										<span class="fa fa-search fs-10 text-600" data-pg-role="searchBtn"></span> <!-- 스타일 변경 -->
									</div>
								</div>
							</div>
						</div>
					</div>

				
				<div class="table-responsive scrollbar">
					<table class="table mb-0 center">
						<thead class="bg-oran">
							<tr style="color: #FAFAFA">
								<th class="align-middle wdf " data-sort="runm">번호</th>
								<th class="align-middle" data-sort="runm">이름</th>
								<th class="align-middle" data-sort="runm">부서명</th>
								<th class="align-middle" style="{ vertical-align : middle; }" data-sort="runm" colspan="2">기간</th>
								<th class="align-middle" data-sort="runm">사용일수</th>
								<th class="align-middle" data-sort="runm">사유</th>
								<th class="align-middle" data-sort="runm">상세</th>
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

<!-- 연차내용 상세조회 -->

			<div class="modal fade" id="detail-modal" tabindex="-1" role="dialog" aria-hidden="true">
			  <div class="modal-dialog modal-dialog-centered" role="document" style="max-width: 500px">
			    <div class="modal-content position-relative">
			      <div class="position-absolute top-0 end-0 mt-2 me-2 z-1">
			        <button class="btn-close position-absolute top-0 end-0 mt-2 me-2" data-bs-dismiss="modal" aria-label="Close"></button>
			      </div>
			      <div class="modal-body p-0">
			        <div class="modal-header px-5 position-relative bg-secondary">
			          <h4 class="mb-0 text-white" id="modalExampleDemoLabel">연차 사용 내역</h4>
			        </div>
			        <div class="p-4 pb-0">
			          <form>
			            <table class="table table-bordered">
						  <thead>
						    <tr>
						      <th class="table-info" scope="col">사번</th>
						      <td id="empNo" scope="col" colspan="3"></td>
						    </tr>
						  </thead>
						  <tbody>
						    <tr>
						      <th class="table-info" >신청자</th>
						      <td id="empNm" scope="col" colspan="3"></td>
						    </tr>
						    <tr>
						      <th class="table-info" scope="col">연락처</th>
						      <td id="empTel" scope="col" colspan="3"></td>
						    </tr>
						    <tr>
						      <th class="table-info" scope="col">부서명</th>
						      <td id="empDept" scope="col" colspan="3"></td>
						    </tr>
						    <tr>
						      <th class="table-info" scope="col">기간</th>
						      <td class="text-center" id="anlLeaBgnYmd" scope="col"></td>
						      <td style="text-align:center;">~</td>
						      <td class="text-center" id="anlLeaEndYmd" scope="col"></td>
						    </tr>
						    <tr>
						      <th class="table-info" scope="col">사용연차</th>
						     <td id="useDate" scope="col" colspan="3"></td>
						    </tr>
						    <tr>
						      <th class="table-info" scope="col">잔여연차</th>
						      <td id=empAnnualLeave scope="col" colspan="3"></td>
						    </tr>
						     <tr>
						      <th class="table-info" scope="col">결재자</th>
						      <td id="empRqNm" scope="col" colspan="3"></td>
						    </tr>
						  </tbody>
						</table>
			          </form>
			        </div>
			      </div>
			      <div class="modal-footer">
			        <button class="btn btn-outline-secondary me-1 mb-1 " type="button" data-bs-dismiss="modal">Close</button>
			      </div>
			    </div>
			  </div>
			</div>
			
		</div>
	</div>
</div>


<script src="<c:url value='/resources/js/app/emp/hrm/dclz/yrycList.js'/>"></script>
<script src="<c:url value='/resources/js/app/common/paging.js'/>"></script>
