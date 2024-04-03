<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>


<link href="${pageContext.request.contextPath}/resources/css/emp/pbl/yryc/yrycView.css" rel="stylesheet">

<div class="col mb-3">
	<div class="card h-100">
		<div class="card-header">
			<div class="row flex-between-end">
				<nav style="--falcon-breadcrumb-divider: url(&#34;data:image/svg+xml,%3Csvg xmlns='http://www.w3.org/2000/svg' width='8' height='8'%3E%3Cpath d='M2.5 0L1 1.5 3.5 4 1 6.5 2.5 8l4-4-4-4z' fill='%23748194'/%3E%3C/svg%3E&#34;);" aria-label="breadcrumb">
				  <ol class="breadcrumb">
				    <li class="breadcrumb-item"><a href="${pageContext.request.contextPath}/emp">Home</a></li>
				    <li class="breadcrumb-item">업무현황</li>
				    <li class="breadcrumb-item active" aria-current="page">연차 신청서 상세</li>
				  </ol>
				</nav>


				<div class="container px-5">
					<div class="row">
						<div class="col-sm-4"><h4 class="px-5 py-5">연차 신청서</h4></div> <!-- 우측 여백 -->
						<div class="col-sm-8 ">
							<div class="table-responsive float-end">
								<table class="table table-bordered custom-table text-center">
									<thead class="custom-thead-bg">
										<tr>
											<th>연차 결재자</th>
										</tr>
									</thead>
									<tbody>
										<tr>
											<td class="rqstEmpNo" id="${annual.empRqNo}">${annual.empRqNm } 팀장</td>
<!-- 											<td class="text-colr-ccc">이름</td> -->
										</tr>
										<tr>
											<td class="ymd" >${annual.rqstPurchsYmd }</td>
<!-- 											<td class="text-colr-ccc">-</td> -->
										</tr>
									</tbody>
								</table>
							</div>
						</div>
					</div>
					<table class="table table-bordered text-center custom-body-table-bd">
						<tbody class="custom-th-bg">
							<tr>
								<th>연차 신청 번호</th>
								<td class="rqstNo">${annual.anlLeaUseNo }</td>

								<th>연차 신청 상태</th>
								<td class="rqstSe">${annual.rqstSe }</td>
							</tr>
							<tr>
								<th>신청자</th>
								<td>${annual.empNm }</td>

								<th>신청일</th>
								<td>${annual.anlLeaYmd }</td>
							</tr>
						</tbody>
					</table>

					<table
						class="table table-bordered text-center custom-body-td-size custom-body-table-bd">
						<tbody class="custom-th-bg">
							<tr>
								<th>연차 신청 상세</th>
							</tr>
							<tr>
								<td> <!-- 내부 테이블 시작 -->
									<table class="table table-bordered text-center custom-body-td-size">
										<thead>
											<tr>
												<th>소속</th>
												<td>${annual.empDept }</td>
												<th>사번</th>
												<td>${annual.empNo }</td>
												<th>직급</th>
												<td>${annual.empJbgd }</td>
											</tr>
										</thead>
										<tbody>
												
												<tr>
													<th>기간</th>
													<td  class="fxtrsTotalAmnt">${annual.anlLeaBgnYmd } ~ ${annual.anlLeaEndYmd }</td>
													<th>사용연차수</th>
													<td  class="fxtrsTotalAmnt">${annual.useDate}일</td>
													<th>잔여연차수</th>
													<td  class="fxtrsTotalAmnt">${annual.empAnnualLeave }일</td>
												</tr>
												
												
												<tr>
													<th colspan="3">연차 신청 사유</th>
													<td colspan="3" class="fxtrsTotalAmnt">${annual.anlLeaRm }</td>
												</tr>
										</tbody>
									</table>
								</td> <!-- 내부 테이블 끝 -->
							</tr>
						</tbody>
					</table>
					<input type="hidden" class="empNo" value="${empUser.empNo }">
					<div id="approvalBody">
					
					</div>
					
				</div>


			</div>
		</div>
	</div>
</div>

<script src="<c:url value='/resources/js/app/emp/hrm/dclz/yrycView.js'/>"></script>
