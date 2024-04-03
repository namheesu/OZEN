<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<div class="col mb-3">
   <div class="card h-100">
      <div class="card-header">
         <div class="row flex-between-end">
			<nav style="--falcon-breadcrumb-divider: url(&quot;data:image/svg+xml,%3Csvg xmlns='http://www.w3.org/2000/svg' width='8' height='8'%3E%3Cpath d='M2.5 0L1 1.5 3.5 4 1 6.5 2.5 8l4-4-4-4z' fill='%23748194'/%3E%3C/svg%3E&quot;);" aria-label="breadcrumb">
					<ol class="breadcrumb">
						<li class="breadcrumb-item"><a href="${pageContext.request.contextPath }/emp">Home</a></li>
						<li class="breadcrumb-item active" aria-current="page">고객 목록</li>
					</ol>
				</nav>

<div id="cstmrList" data-list>
  <div class="row justify-content-end g-0">
    <div class="col-auto col-sm-5 mb-3">
      <form id="submitForm" method="post">
        <div class="input-group">
          <input class="form-control form-control-sm shadow-none search" type="search" placeholder="Search..." aria-label="search" />
          <div class="input-group-text bg-transparent"><span class="fa fa-search fs-10 text-600"></span></div>
        </div>
      </form>
      <div class="input-group">
        <select class="form-select form-select-sm mb-3" aria-label="Bulk actions" data-list-filter="data-list-filter">
          <option selected value="">Select Membership</option>
          <option value="Non-subscriber">Non-subscriber</option>
          <c:forEach items="${mbrshList}" var="mbrsh">
	          <option value="${mbrsh.mbsGrdCd }">${mbrsh.mbsGrdCd }</option>
          </c:forEach>
        </select>
      </div>
    </div>
  </div>
  <div class="table-responsive scrollbar">
  	전체 고객 수 : ${mbrshCnt.TOTAL_MBER } &nbsp; &nbsp;
	일반 고객 수 : ${mbrshCnt.NON_MBS_MBER } &nbsp; &nbsp;
	멤버십 고객 수 : ${mbrshCnt.MBS_MBER }
	
    <table class="table fs-10 mb-0">
      <thead class="bg-oran">
        <tr style="color: #FAFAFA">
          <th class="text-900 sort align-middle" data-sort="cstNo" >Cstmr No</th>
          <th class="text-900 sort align-middle" data-sort="cstNm">Name</th>
          <th class="text-900 sort align-middle" data-sort="mberId">ID</th>
          <th class="text-900 sort align-middle" data-sort="mberHp">HP</th>
          <th class="text-900 sort align-middle" data-sort="mberMbrsh">membership</th>
          <th>상세</th>
        </tr>
      </thead>
      <tbody class="list annList" id="listBody">
		<tr>
			<td class="cstNo"></td>
			<td class="cstNm"></td>
			<td class="mberId"></td>
			<td class="mberHp"></td>
			<td class="mberMbrsh"></td>
			<td class="detail"></td>
		</tr>
      </tbody>
    </table>
  </div>
  <div class="d-flex justify-content-center mt-3">
    <button class="btn btn-sm btn-falcon-default me-1" type="button" title="Previous" data-list-pagination="prev"><span class="fas fa-chevron-left"></span></button>
    <ul class="pagination mb-0"></ul>
    <button class="btn btn-sm btn-falcon-default ms-1" type="button" title="Next" data-list-pagination="next"><span class="fas fa-chevron-right"> </span></button>
  </div>
</div>

<div class="modal fade" id="staticBackdrop" data-bs-keyboard="false" data-bs-backdrop="static" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
  <div class="modal-dialog modal-xl mt-6" role="document">
    <div class="modal-content border-0">
      <div class="position-absolute top-0 end-0 mt-3 me-3 z-1">
        <button class="btn-close btn btn-sm btn-circle d-flex flex-center transition-base" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      <div class="modal-body p-0">
        <div class="rounded-top-3 bg-body-tertiary py-3 ps-4 pe-6">
          <h4 class="mb-1" id="staticBackdropLabel">회원 상세 내역</h4>
        </div>
        <div class="p-4">
          <div class="row">
            <div class="col-lg-9">
              <div class="card-body bg-body-tertiary">
                  <form class="row g-3" id="mberDetail">
                    <input class="form-control" id="rnum" type="text" value="" hidden>
                    <div class="col-lg-6">
                      <label class="form-label" for="cstNo" >회원 번호</label>
                      <input class="form-control" id="cstNo" type="text" value="" readonly>
                    </div>
                    <div class="col-lg-6">
                      <label class="form-label" for="cstNm">이름</label>
                      <input class="form-control" id="cstNm" type="text" value="" readonly>
                    </div>
                    <div class="col-lg-6">
                      <label class="form-label" for="mberId">ID</label>
                      <input class="form-control" id="mberId" type="text" value="" readonly>
                    </div>
                    <div class="col-lg-6">
                      <label class="form-label" for="cstHp">Phone</label>
                      <input class="form-control" id="cstHp" type="text" value="" readonly>
                    </div>
                    <div class="col-lg-6">
                      <label class="form-label" for="cstMail">Mail</label>
                      <input class="form-control" id="cstMail" type="text" value="" readonly>
                    </div>
                    <div class="col-lg-6">
                      <label class="form-label" for="cstBirth">Birth</label>
                      <input class="form-control" id="cstBirth" type="text" value="" readonly>
                    </div>
                    <div class="col-lg-6">
                      <label class="form-label" for="cstGen">Gender</label>
                      <input class="form-control" id="cstGen" type="text" value="" readonly>
                    </div>
                    <div class="col-lg-6">
                      <label class="form-label" for="mberMbti">MBTI</label>
                      <input class="form-control" id="mberMbti" type="text" value="" readonly>
                    </div>

                  </form>
                </div>
              <div class="d-flex">
              	<span class="mt-2 fa-stack ms-n1 me-3">
              	<i class="fas fa-circle fa-stack-2x text-200"></i><i class="fa-inverse fa-stack-1x text-primary fas fa-align-left" data-fa-transform="shrink-2"></i></span>
                <div class="flex-1">
                  <h5 class="mt-3 mb-2 fs-9">최근 호텔 사용 내역</h5>
					<table class="table center">
						<thead>
							<tr>
								<th>번호</th>
								<th>예약 일자</th>
								<th>체크인 예정 날짜</th>
								<th>체크아웃 예정 날짜</th>
							</tr>
						</thead>
						<tbody id="RecentlyUsed">
							
						</tbody>
					</table>
                  <p class="text-break fs-10">
                     <div class="col-12 d-flex justify-content-end">
                      <button class="btn btn-primary"  data-bs-dismiss="modal" >확인 </button>
                    </div>
                  </p>
                </div>
              </div>
            </div>
            <div class="col-lg-3">
              <h6 class="mt-5 mt-lg-0">멤버십 가입 이력</h6>
              <ul class="nav flex-lg-column fs-10" id="mbrshSetleList">
                <li class="nav-item me-2 me-lg-0"><a class="nav-link nav-link-card-details" href="#!"><span class="fas fa-user me-2"></span>Members</a></li>
              </ul>
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

<script src="<c:url value='/resources/js/app/emp/crm/cstmr/cstmrList.js'/>"></script>

