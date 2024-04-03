<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form"  prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags"  prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<link href="${pageContext.request.contextPath}/resources/css/emp/hrm/pay/payList.css" rel="stylesheet">



<style>
/* #basic-form-bgn { */
/*       font-size: 10px; */
/*         font-family: Consolas, sans-serif; */
/* } */


/* .container { */
/*      text-align: center; /* 요소를 가운데 정렬합니다. */ */
/*  } */
/*  .container input, */
/*  .container button { */
/*      display: inline-block; /* 요소를 인라인 블록으로 설정합니다. */ */
/*      vertical-align: middle; /* 수직으로 가운데 정렬합니다. */ */
/*  } */


   
/* input 요소의 너비 조절 */
    input[type="date"] {
        width: 200px; /* 원하는 너비로 조정 */
    }


    /* 버튼의 너비와 높이를 조절합니다. */
    #salaryBtn {
    	margin-left: 10px;
        width: 100px; /* 원하는 너비로 조정 */
        height: 30px; /* 원하는 높이로 조정 */
    }

</style>


<div class="col mb-3">
	<div class="card h-100">
		<div class="card-header">
			<div class="row flex-between-end">
				<nav style="--falcon-breadcrumb-divider: url(&#34;data:image/svg+xml,%3Csvg xmlns='http://www.w3.org/2000/svg' width='8' height='8'%3E%3Cpath d='M2.5 0L1 1.5 3.5 4 1 6.5 2.5 8l4-4-4-4z' fill='%23748194'/%3E%3C/svg%3E&#34;);" aria-label="breadcrumb">
					<ol class="breadcrumb">
						<li class="breadcrumb-item"><a href="${pageContext.request.contextPath}/emp">Home</a></li>
						<li class="breadcrumb-item active" aria-current="page">급여관리</li>
					</ol>
				</nav>
				<div class="" style="margin-top:10px; margin-bottom:18px;">
				
					<form id="periodForm">
					<div class="container">
							 기간: <input
							name="bgn"
								class="" id="basic-form-bgn" type="date"/>
							 <input
							name="end"
								class="" id="basic-form-end" type="date"/>
						<button id="salaryBtn" class="btn btn-outline-info btn-sm" type="button" data-pay-url='<c:url value="/emp/hrm/pay/payslip"/>' data-pay-method="get" >급여계산</button>
						</div>
					</div>
					</form>
				</div>


<h5 class="text-center">급여 지급 현황</h5>
<table class="table table-bordered  fs--1 mb-0">
<tr>
<th>귀속연월</th>
<th>산정기간</th>
<th>지급일</th>
<th>지급총액</th>
<th>공제총액</th>
<th>실지급액</th>
<th>총 직원수</th>
</tr>
<tr>
<td id=pay-month>-</td>
<td id=period>시작일 ~ 종료일</td>
<td id=pay-give-date>-</td>
<td class="money" id="total-give">-</td>
<td class="money" id="total-deduct">-</td>
<td class="money" id="net">-</td>
<td id='empCnt'>-</td>
</tr>
<tr>


<%-- <button class="btn btn-danger" id="confirmedSalaryBtn" type="button" data-pay-url='<c:url value="/emp/hrm/pay/payslip/pdf" />' data-pay-method="get">급여확정</button> --%>
</tr>
</table>

<br>
<hr>
<br>


<div id="tableExample3">
  <div>
    <div class="col-auto">
		    <form  hidden id="searchForm" action="${pageContext.request.contextPath }/emp/hrm/pay/payslip">
			   		<input type="text" name="page" placeholder="page"/>
   					<input name="searchType" placeholder="searchType"/>
					<input name="searchWord" placeholder="searchWord"/>
					<input id="selectOneSearchWord" name="selectOneSearchWord" placeholder="selectOneSearchWord"/>
		    </form>
			<div class="row justify-content-end g-0" data-pg-role="searchUI" data-pg-target="#searchForm" id="searchUI">

								<div  class="col-auto px-3">
									<select name="selectOneSearchWord" data-pg-init-value="${simpleCondition.selectOneSearchWord}" class="form-select form-select-sm mb-3">
									<option value>==부서==</option>
									<option value="FTO">프론트오피스부</option>
									<option value="HKP">하우스키핑부</option>
									<option value="FMT">시설관리부</option>
									<option value="CRM">고객관리부</option>
									<option value="POS">재무부</option>
									<option value="HRM">인사부</option>
									</select>
								</div>				
<!-- 								<div class="col-auto px-3"> -->
<!-- 									<select name="searchType" class="form-select form-select-sm mb-3"> -->
<!-- 										<option value="" label="전체" /> -->
<!-- 										<option value="empNo" label="사번" /> -->
<!-- 										<option value="empNm" label="성명" /> -->
<!-- 										<option value="empDept" label="부서" /> -->
<!-- 									</select> -->
<!-- 								</div> -->
								<div class="col-auto col-sm-5 mb-3">
									<div class="input-group">
										<input name="searchWord" class="form-control form-control-sm shadow-none search" type="search" placeholder="Search..." aria-label="search" />
										<div class="input-group-text bg-transparent">
								          	<span class="fa fa-search fs-10 text-600" id="selectBtn" data-pg-role="searchBtn"></span>
								        </div>
									</div>
								</div>
							</div>
							
			<div class="table-responsive scrollbar">
			    <table class="table mb-0 center">
			      <thead class="bg-oran">
			        <tr style="color: #FAFAFA">
			          <th class="align-middle" data-sort="empNo">사번</th>
			          <th class="align-middle" data-sort="empNm">이름</th>
			          <th class="align-middle" data-sort="empJncmpYmd">입사일</th>
			          <th class="align-middle" data-sort="empDept">부서</th>
			          <th class="align-middle" data-sort="give">지급액</th>
			          <th class="align-middle" data-sort="dcc">공제액</th>
			          <th class="align-middle" data-sort="realgive">실지급액</th>
			          <th class="align-middle" data-sort="detail">상세보기</th>
			        </tr>
			      </thead>
			      <tbody id="listBody">
			     	 <h6 id="beforeSelectPay">(현재 조회된 급여 기록이 없습니다.)</h6>
			      </tbody>
			    </table>
			    <div class="card-footer d-flex justify-content-center paging-div-height" id="pagingArea"></div>
			  </div>
		</div>
</div>
				
							



<div>
<!-- paydetail -->
<form id="myForm">
	<input type="hidden" name="empHealthInsrnc" id="empHealthInsrnc" value="empHealthInsrnc" />
	<input type="hidden" name="empPaymentAmnt" id="empPaymentAmnt" value="empPaymentAmnt" />
	<input type="hidden" name="empNm" id="empNm" value="empNm" />
	<input type="hidden" name="empEmplymInsrnc" id="empEmplymInsrnc" value="empEmplymInsrnc" />
	<input type="hidden" name="empThePay" id="empThePay" value="empThePay" />
	<input type="hidden" name="empDept" id="empDept" value="empDept" />
	<input type="hidden" name="empNo" id="empNo" value="empNo" />
	<input type="hidden" name="empNightWorkAllowance" id="empNightWorkAllowance" value="empNightWorkAllowance" />
	<input type="hidden" name="empJncmpYmd" id="empJncmpYmd" value="empJncmpYmd" />
	<input type="hidden" name="empNationalPension" id="empNationalPension" value="empNationalPension" />
	<input type="hidden" name="empLongTermCareInsrnc" id="empLongTermCareInsrnc" value="empLongTermCareInsrnc" />
	<input type="hidden" name="empDeductionAmnt" id="empDeductionAmnt" value="empDeductionAmnt" />
	<input type="hidden" name="empMslay" id="empMslay" value="empMslay" />
	<input type="hidden" name="empJbgd" id="empJbgd" value="empJbgd" />
</form>
<div>



<script src="<c:url value='/resources/js/app/emp/hrm/pay/payList.js'/>"></script>
<script src="<c:url value='/resources/js/app/common/paging.js'/>"></script>

