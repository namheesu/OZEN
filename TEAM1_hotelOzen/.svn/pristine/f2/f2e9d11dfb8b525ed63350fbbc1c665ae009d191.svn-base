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
				    <li class="breadcrumb-item">투숙관리</li>
				    <li class="breadcrumb-item active" aria-current="page">체크인 예정 명단</li>
				  </ol>
				</nav>

				<div id="chkinListTable">
					<div>
						<form id="searchForm" action="<c:url value='/emp/pms/stay/checkinList.do'/>">
							<input type="hidden" name="page" />
							<input type="hidden" name="searchWord" value="${simpleCondition.searchWord }"/>
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
						<a class="btn float-end border mb-2 mx-2 col-auto" href="#qrCode" data-bs-toggle="modal"> 
							<i class="fas fa-qrcode"></i>
							QR코드
						</a>
					</div>
					
					
					<div class="table-responsive scrollbar">
						<table class="table mb-0 center" >
							<thead class="bg-oran">
								<tr>
									<th class="align-middle wdf" data-sort="rnum">번호</th>
									<th class="align-middle" data-sort="rsvtNo">예약번호</th>
									<th class="align-middle" data-sort="cstNm">고객이름</th>
									<th class="align-middle" data-sort="rsvtYmd">예약일</th>
									<th class="align-middle" data-sort="rsvtCheckinYmd">투숙일</th>
									<th class="align-middle" data-sort="rmtTypeCd">객실종류</th>
									<th class="align-middle" data-sort="rsvtRoomCnt">객실수</th>
									<th class="align-middle" data-sort="rsvtAdultCnt">성인수</th>
									<th class="align-middle" data-sort="rsvtChildCnt">아동수</th>
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
			
			<!-- 예약 상세 조회 -->
			<div class="modal fade" id="rsvtList-select" tabindex="-1"
				role="dialog" aria-labelledby="authentication-modal-label"
				aria-hidden="true">
				<div class="modal-dialog modal-80size modal-lg mt-6" role="document">
					<div class="modal-content modal-80size border-0">
						<div class="modal-header px-5 position-relative bg-secondary  ">
							<div class="position-relative z-1">
								<h4 class="mb-0 text-white" id="authentication-modal-label">예약
									상세내역 조회</h4>
							</div>
							<button class="btn-close position-absolute top-0 end-0 mt-2 me-2"
								data-bs-dismiss="modal" aria-label="Close"></button>
						</div>
						<div class="modal-body py-4 px-5">
							
						</div>
					</div>
				</div>
			</div>
			
			<!-- QR Modal -->
			<div class="modal fade" id="qrCode" tabindex="-1" role="dialog"
				aria-labelledby="authentication-modal-label" aria-hidden="true">
				<div class="modal-dialog modal-lg mt-6" role="document">
					<div class="modal-content border-0">
						<div class="modal-header px-5 position-relative bg-secondary  ">
							<div class="position-relative z-1">
								<h4 class="mb-0 text-white" id="authentication-modal-label">QR
									코드 인식</h4>
							</div>
							<button class="btn-close position-absolute top-0 end-0 mt-2 me-2"
								data-bs-dismiss="modal" aria-label="Close"></button>
						</div>
						<div class="modal-body py-4 px-5">
							<div class="qr">
								<div id="test" class="qr-div">
									<h1>QR 코드 리더</h1>
									<div id="output">
										<div id="outputMessage">QR코드를 카메라에 노출시켜 주세요</div>
										<div id="outputLayer" hidden>
											<span id="outputData"></span>
										</div>
									</div>
								</div>
								<div>&nbsp;</div>
								<div>
									<h1>스캔</h1>
									<div id="frame">
										<div id="loadingMessage">
											🎥 비디오 스트림에 액세스 할 수 없습니다<br />웹캠이 활성화되어 있는지 확인하십시오
										</div>
										<canvas id="canvas"></canvas>

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

<script src="<c:url value='/resources/js/app/emp/pms/stay/checkInList.js'/>"></script>
<script src="<c:url value='/resources/js/app/common/paging.js'/>"></script>

<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jsQR.js"></script>
<script src="<c:url value='/resources/js/app/common/qr.js'/>"></script>