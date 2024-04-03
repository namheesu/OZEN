<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<link
	href="${pageContext.request.contextPath}/resources/css/emp/pms/fxtrs/rqstListadd.css"
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
				    <li class="breadcrumb-item active" aria-current="page">비품 요청서 작성</li>
				  </ol>
				</nav>


				<div class="container px-5">
					<div class="row">
						<div class="col-sm-4">
							<h4 class="px-5 py-5">비품요청서</h4>
						</div>
						<!-- 우측 여백 -->
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
										<tr>
											<td class="hkp-dpm-Nm"></td>
											<td class="text-colr-ccc">-</td>
										</tr>
										<tr>
											<td class="text-colr-ccc">요청 결재일</td>
											<td class="text-colr-ccc">구매 결재일</td>
										</tr>
									</tbody>
								</table>
							</div>
						</div>
					</div>
					<!-- 결잭자 사번 -->
					<input type="hidden" id="empRqNo">
					<table
						class="table table-bordered text-center custom-body-table-bd">
						<tbody class="custom-th-bg">
							<tr>
								<th>요청번호</th>
								<td class="rqstNo">${rqstNo }</td>

								<th>작성자</th>
								<td class="empNm" id="${empNo }">${empNm }</td>

								<th>작성일</th>
								<td class="ymd"></td>
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
								<td>
									<!-- 내부 테이블 시작 -->
									<table
										class="table table-bordered text-center custom-body-td-size">
										<thead>
											<tr>
												<th style="width: 7%;"></th>
												<th>비품코드</th>
												<th>비품명</th>
												<th>현재수량</th>
												<th>적정수량</th>
												<th>필요수량</th>
												<th>단위</th>
												<th>수량</th>
												<th>총수량</th>
												<th>가격</th>
											</tr>
										</thead>
										<tbody id="fxRqstListBody">

										</tbody>
									</table>
								</td>
								<!-- 내부 테이블 끝 -->
							</tr>
							<tr>

							</tr>
						</tbody>
					</table>
					<div class="text-end">
						<a class="btn btn-outline-danger me-1 mb-1"
							href="javascript:history.back()" type="button">취소</a>
						<button class="btn btn-outline-info me-1 mb-1 fxClick"
							type="button">제출</button>
					</div>
				</div>


			</div>
		</div>
	</div>
</div>

<script type="text/javascript" id="commonScript">
	const msgUrl = 'ws://' + window.location.host
			+ '${pageContext.request.contextPath}/messageServerEndpoint';
	const userName = '${loginVO.name}';
</script>
<script
	src="<c:url value='/resources/js/app/emp/pms/fxtrs/rqstListadd.js'/>"></script>
<script src="<c:url value='/resources/js/websocketMessage.js'/>"></script>