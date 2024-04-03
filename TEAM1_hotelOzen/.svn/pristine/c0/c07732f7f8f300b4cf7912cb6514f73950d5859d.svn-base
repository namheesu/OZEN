<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<link href="${pageContext.request.contextPath}/resources/css/emp/pms/fxtrs/rqstListadd.css"
	rel="stylesheet">

<div class="col mb-3">
	<div class="card h-100">
		<div class="card-header">
			<div class="row flex-between-end">
				<nav style="--falcon-breadcrumb-divider: url(&#34;data:image/svg+xml,%3Csvg xmlns='http://www.w3.org/2000/svg' width='8' height='8'%3E%3Cpath d='M2.5 0L1 1.5 3.5 4 1 6.5 2.5 8l4-4-4-4z' fill='%23748194'/%3E%3C/svg%3E&#34;);" aria-label="breadcrumb">
				  <ol class="breadcrumb">
				    <li class="breadcrumb-item"><a href="${pageContext.request.contextPath}/emp">Home</a></li>
				    <li class="breadcrumb-item">호텔관리</li>
				    <li class="breadcrumb-item">비품관리</li>
				    <li class="breadcrumb-item active" aria-current="page">비품 요청서 상세</li>
				  </ol>
				</nav>


				<div class="container px-5">
					<div class="row">
						<div class="col-sm-4"><h4 class="px-5 py-5">비품요청서</h4></div> <!-- 우측 여백 -->
						<div class="col-sm-8 ">
							<div class="table-responsive float-end">
								<table class="table table-bordered custom-table text-center">
									<thead class="custom-thead-bg">
										<tr>
											<th>요청 결재자</th>
											<th>구매 결재자</th>
										</tr>
									</thead>
									<tbody>
										<c:if test="${not empty fxtrs.empPurNm}">
											<tr>
												<td class="rqstEmpNo" id="${fxtrs.fxtrsRqst.empRqNo}">${fxtrs.empRqNm } 부장</td>
												<td class="purEmpNo" id="${fxtrs.fxtrsRqst.empPurchsNo}">${fxtrs.empPurNm} 부장</td>
											</tr>
											<tr>
												<td class="ymd">${fxtrs.fxtrsRqst.rqstRqYmd }</td>
												<td>${fxtrs.fxtrsRqst.rqstPurchsYmd }</td>
											</tr>
											
										</c:if>
										<c:if test="${empty fxtrs.empPurNm}">
											
											<tr>
												<td class="rqstEmpNo" id="${fxtrs.fxtrsRqst.empRqNo}">${fxtrs.empRqNm } 부장</td>
												<td class="purEmpNo text-colr-ccc">-</td>
											</tr>
											<tr>
												<c:if test="${empty fxtrs.fxtrsRqst.rqstRqYmd}">
													<td class="text-colr-ccc ymd">요청 결재일</td>
												</c:if>
												<c:if test="${not empty fxtrs.fxtrsRqst.rqstRqYmd}">
													<td class="ymd">${fxtrs.fxtrsRqst.rqstRqYmd }</td>
												</c:if>
												<td class="text-colr-ccc">구매 결재일</td>
											</tr>
										</c:if>
									</tbody>
								</table>
							</div>
						</div>
					</div>
					<table class="table table-bordered text-center custom-body-table-bd">
						<tbody class="custom-th-bg">
							<tr>
								<th>요청번호</th>
								<td class="rqstNo">${fxtrs.fxtrsRqst.rqstNo }</td>

								<th>요청상태</th>
								<td class="rqstSe">${fxtrs.fxtrsRqst.rqstSe }</td>
							</tr>
							<tr>
								<th>작성자</th>
								<td>${fxtrs.fxtrsRqst.empNm }</td>

								<th>요청일</th>
								<td>${fxtrs.fxtrsRqst.rqstYmd }</td>
							</tr>
						</tbody>
					</table>

					<table
						class="table table-bordered text-center custom-body-td-size custom-body-table-bd">
						<tbody class="custom-th-bg">
							<tr>
								<th>비품 요청 내역</th>
							</tr>
							<tr>
								<td> <!-- 내부 테이블 시작 -->
									<table class="table table-bordered text-center custom-body-td-size">
										<thead>
											<tr>
												<th>비품코드</th>
												<th>비품명</th>
												<th>단위</th>
												<th>수량</th>
												<th>총수량</th>
												<th>가격</th>
											</tr>
										</thead>
										<tbody>
											<c:forEach var="fxtrsList" items="${fxtrs.fxtrsRqst.fxtrsRqstDtl }">
												<tr>
													<td>${fxtrsList.fxCd }</td>
													<td>${fxtrsList.fxtrs.fxNm }</td>
													<td>${fxtrsList.fxtrs.fxUnit }</td>
													<td>${fxtrsList.fxRqstCnt }</td>
													<td><c:out value="${fxtrsList.fxtrs.fxUnit * fxtrsList.fxRqstCnt}" /></td>
													<td class="fxtrsAmnt">${fxtrsList.fxRqstTotalamnt }</td>
												</tr>
											</c:forEach>
												<tr>
													<th colspan="3">총가격</th>
													<td colspan="3" class="fxtrsTotalAmnt"></td>
												</tr>
										</tbody>
									</table>
								</td> <!-- 내부 테이블 끝 -->
							</tr>
						</tbody>
					</table>
					<input type="hidden" class="empNo" value="${empNo }">
					<div id="approvalBody">
					
					</div>
					
				</div>


			</div>
		</div>
	</div>
</div>

<script src="<c:url value='/resources/js/app/emp/pms/fxtrs/rqstView.js'/>"></script>