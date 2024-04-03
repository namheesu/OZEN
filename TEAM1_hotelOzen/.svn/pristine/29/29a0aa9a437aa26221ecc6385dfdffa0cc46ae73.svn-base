<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<link href="${pageContext.request.contextPath}/resources/css/emp/pms/fxtrs/useListadd.css"
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
				    <li class="breadcrumb-item active" aria-current="page">비품 사용서 등록</li>
				  </ol>
				</nav>


				<div class="row px-5 py-5">
					<div class="col-lg-7 pe-lg-2">
						<table class="table table-bordered text-center custom-body-table-bd">
							<tbody class="custom-th-bg">
								<tr>
									<th>사용서 번호</th>
									<td id="serviceNumber">${fxUseNo }</td>
	
									<th>객실번호</th>
									<td id="roomNumber"></td>
								</tr>
								<tr>
									<th>작성자</th>
									<td id="empNm" class="${empNo }">${empNm}</td>
	
									<th>작성일</th>
									<td id="ymd"></td>
								</tr>
							</tbody>
						</table>
	
						<table
							class="table table-bordered text-center custom-body-td-size custom-body-table-bd">
							<tbody class="custom-th-bg">
								<tr>
									<th>비품 사용 내역</th>
								</tr>
								<tr>
									<td> <!-- 내부 테이블 시작 -->
										<table class="table table-bordered text-center custom-body-td-size">
											<thead>
												<tr>
													<th style="width: 7%;"></th>
													<th>비품분류</th>
													<th>비품코드</th>
													<th>비품명</th>
													<th>수량</th>
												</tr>
											</thead>
											<tbody id="fxUseListBody">
											
											</tbody>
										</table>
									</td> 
								</tr>
							</tbody>
						</table>
						<div class="text-end">
							<a class="btn btn-outline-danger me-1 mb-1" href="javascript:history.back()"
								type="button">취소</a>
							<a class="btn btn-outline-info me-1 mb-1" type="button" onclick="myclick()">제출</a>
						</div>
					</div>
					
					<div class="col-lg-5 ">
						<div class="sticky-sidebar ">
							<div class="card mb-lg-0 rmselectBG">
								<div class="card-header">
									<h5 class="mb-0 col-sm-8">객실 조회</h5>	
								</div>
								<div class="card-body ">

									<h6>객실타입</h6>
									<div class="row px-4">
										<div class="col-sm-3 mb-3 form-check">
											<input class="form-check-input" id="R5"
												type="radio" name="listingPrivacy"/>
											<label class="form-label mb-0" for="R5">
												<strong>5층</strong></label>
										</div>
										<div class="col-sm-3 mb-3 form-check">
											<input class="form-check-input" id="R6"
												type="radio" name="listingPrivacy" />
											<label class="form-label mb-0" for="R6">
												<strong>6층</strong></label>
										</div>
										<div class="col-sm-3 mb-3 form-check">
											<input class="form-check-input" id="R7"
												type="radio" name="listingPrivacy" />
											<label class="form-label mb-0" for="R7">
												<strong>7층</strong></label>
										</div>

										<div class="col-sm-3 mb-3 form-check">
											<input class="form-check-input" id="R8"
												type="radio" name="listingPrivacy"/>
											<label class="form-label mb-0" for="R8">
												<strong>8층</strong></label>
										</div>
										<div class="col-sm-3 mb-3 form-check">
											<input class="form-check-input" id="R9"
												type="radio" name="listingPrivacy" />
											<label class="form-label mb-0" for="R9">
												<strong>9층</strong></label>
										</div>
										<div class="col-sm-3 mb-3 form-check">
											<input class="form-check-input" id="R10"
												type="radio" name="listingPrivacy" />
											<label class="form-label mb-0" for="R10">
												<strong>10층</strong></label>
										</div>
										<div class="col-sm-3 mb-3 form-check">
											<input class="form-check-input" id="R11"
												type="radio" name="listingPrivacy" />
											<label class="form-label mb-0" for="R11">
												<strong>11층</strong></label>
										</div>

										<div class="col-sm-3 mb-3 form-check">
											<input class="form-check-input" id="R12"
												type="radio" name="listingPrivacy"/>
											<label class="form-label mb-0" for="R12">
												<strong>12층</strong></label>
										</div>
										<div class="col-sm-3 mb-3 form-check">
											<input class="form-check-input" id="R13"
												type="radio" name="listingPrivacy" />
											<label class="form-label mb-0" for="R13">
												<strong>13층</strong></label>
										</div>
										<div class="col-sm-3 mb-3 form-check">
											<input class="form-check-input" id="R14"
												type="radio" name="listingPrivacy" />
											<label class="form-label mb-0" for="R14">
												<strong>14층</strong></label>
										</div>
										<div class="border-bottom border-dashed my-3"></div>

									</div>
									
									<div class="form-check custom-checkbox mb-0">
										<div id="floorListBody">
										
										</div>
									</div>
								</div>
							</div>
						
							<div class="py-4">
								<div class="card mb-lg-0 rmselectBG">
									<div class="card-header">
										<h5 class="mb-0">비품 조회</h5>
									</div>
									<div class="card-body ">
										
										<div class="row">
											<div class="col-sm-4 fxNmBody">
												<select class="rmSvcSelectList">
								                    <option value="">-- 비품 분류명 --</option>
												<c:forEach var="fxCls" items="${fxtrsCdList }">
								                    <option value="${fxCls.fxClsCd }">${fxCls.fxClsNm }</option>												
												</c:forEach>
								                </select>
											</div>
											
										<div class="border-bottom border-dashed my-3"></div>
										
										<div class="form-check custom-checkbox mb-0">
											<div id="fxtrsNmBody">
											
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>

			</div>
		</div>
	</div>
</div>


<script src="<c:url value='/resources/js/app/emp/pms/fxtrs/useListadd.js'/>"></script>