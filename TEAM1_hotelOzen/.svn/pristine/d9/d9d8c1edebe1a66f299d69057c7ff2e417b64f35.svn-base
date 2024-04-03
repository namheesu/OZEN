<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<div class="card mb-3" >
	<div class="card-header">
		<div>
			<div class="col-auto align-self-center">
				<h5 data-anchor="data-anchor">결제내역리스트</h5>
				<div id="tableExample3"
					data-list='{"valueNames":["fnum","fday","fxnm","amnt","empnm","stts"],"page":20,"pagination":true}'>
					<div class="row justify-content-end g-0">
						<div class="col-auto col-sm-5 mb-3">
							<form>

								<select class="form-select form-select-sm"
									aria-label="Bulk actions" data-list-filter="data-list-filter">
									<option selected="" value="">Select payment status</option>
									<option value="Pending">완료</option>
									<option value="Success">대기</option>
								</select>
							</form>
						</div>
					</div>
					<div class="card shadow-none">
						<div class="card-body p-0 pb-3">
							<div class="table-responsive scrollbar">
								<table class="table mb-0">
									<thead class="bg-oran">
										<tr  style="color: #FAFAFA">
											<th class="align-middle white-space-nowrap">
												<div class="form-check mb-0">
													<input class="form-check-input" type="checkbox"
														data-bulk-select='{"body":"bulk-select-body","actions":"bulk-select-actions","replacedElement":"bulk-select-replace-element"}' />
												</div>
											</th>
											<th class="align-middle wdf ">번호</th>
											<th class="align-middle ">요청일</th>
											<th class="align-middle">구매일</th>
											<th class="align-middle ">비품명</th>
											<th class="align-middle ">요청수</th>
											<th class="align-middle ">총비용</th>
											<th class="align-middle ">결재상태</th>
											<th class="align-middle white-space-nowrap pe-7 ">결제자</th>
										</tr>
									</thead>
									<tbody id="bulk-select-body">
										<c:forEach var="index" begin="1" end="15">
											<tr>
												<td class="align-middle white-space-nowrap">
													<div class="form-check mb-0">
														<input class="form-check-input" type="checkbox"
															id="checkbox-${index}"
															data-bulk-select-row="data-bulk-select-row" />
													</div>
												</td>
												<th class="align-middle wdf">${index}</th>
												<td class="align-middle">2024.02.14</td>
												<td class="align-middle">2024.02.26</td>
												<td class="align-middle">이불</td>
												<td class="align-middle">100</td>
												<td class="align-middle">1,800,000</td>
												<td class="align-middle "><span
													class="badge badge rounded-pill badge-subtle-success">완료
														<span class="ms-1 fas fa-stream"
														data-fa-transform="shrink-2"></span>
												</span></td>
												<td class="align-middle white-space-nowrap text-end pe-7">윤태섭</td>
											</tr>
										</c:forEach>
									</tbody>
								</table>
							</div>
						</div>
					</div>

					<div class="d-flex justify-content-center mt-3">
						<button class="btn btn-sm btn-falcon-default me-1" type="button"
							title="Previous" data-list-pagination="prev">
							<span class="fas fa-chevron-left"></span>
						</button>
						<ul class="pagination mb-0"></ul>
						<button class="btn btn-sm btn-falcon-default ms-1" type="button"
							title="Next" data-list-pagination="next">
							<span class="fas fa-chevron-right"> </span>
						</button>
					</div>
				</div>

			</div>
		</div>
	</div>
</div>