<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%> 
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security"%>
<link href="${pageContext.request.contextPath}/resources/css/emp/pbl/oprtnstts/oprtnstts.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/resources/css/emp/pagingCss.css" rel="stylesheet">

<div class="col mb-3">
	<div class="card h-100">
		<div class="card-header">
			<div class="row flex-between-end">
				<nav style="--falcon-breadcrumb-divider: url(&#34;data:image/svg+xml,%3Csvg xmlns='http://www.w3.org/2000/svg' width='8' height='8'%3E%3Cpath d='M2.5 0L1 1.5 3.5 4 1 6.5 2.5 8l4-4-4-4z' fill='%23748194'/%3E%3C/svg%3E&#34;);" aria-label="breadcrumb">
					<ol class="breadcrumb">
						<li class="breadcrumb-item"><a href="${pageContext.request.contextPath}/emp">Home</a></li>
						<li class="breadcrumb-item active" aria-current="page">업무현황</li>
					</ol>
				</nav>
					
				<div class="tabcontent">
					<div class="oprTab">
					    <input type="radio" name="tab" checked id="tabmenu01">
					    <label class="oprTxt" for="tabmenu01">연차</label>
					    <security:authorize access="hasAnyRole('ROLE_HKP', 'ROLE_POS')">
						    <input type="radio" name="tab" id="tabmenu02">
						    <label class="oprTxt" for="tabmenu02">비품</label>
					    </security:authorize>
				  </div>
				  <!-- 연차탭 -->
				    <div class="content-box content01">
						
						<div id="tableExample3">
							<div class="row justify-content-end g-0">
								<div class="col-auto col-sm-5 mb-3">
									<form id="annualSearchForm" action="<c:url value='/emp/pbl/oprtnstts/oprtnsttsList.do'/>">
										<input type="hidden" name="page" />
										<input type="hidden" name="annualSearchWord" value="${simpleCondition.annualSearchWord }" />
										<input type="hidden" name="annualOneSearchWord" value="${simpleCondition.annualOneSearchWord }" />
									</form>
									<div class="row justify-content-end g-0" data-pg-role="searchUI" data-pg-target="#annualSearchForm">
										<div class="col-auto px-3">
											<div class="input-group" >
										        <select class="form-select form-select-sm mb-3"
										        		name="annualOneSearchWord" data-pg-init-value="${simpleCondition.annualOneSearchWord }">
													<option selected value="">업무현황</option>
													<option value="승인">승인</option>
													<option value="대기">대기</option>
													<option value="반려">반려</option>
										        </select>
										      </div>
										</div>
										<div class="col-auto col-sm-5 mb-3">
									        <div class="input-group">
									          <input class="form-control form-control-sm shadow-none search" 
									          		type="search" placeholder="Search..." aria-label="search" 
									          		name ="annualSearchWord" value="${simpleCondition.annualSearchWord }"/>
									          <div class="input-group-text bg-transparent">
									          	<span class="fa fa-search fs-10 text-600" data-pg-role="searchBtn"></span>
									          </div>
									        </div>
										</div>
									</div>
								</div>
							</div>
							
							
							<div class="card shadow-none">
								<div class="card-body p-0 pb-3">
								
									<div class="table-responsive scrollbar">
										<table class="table mb-0 center">
											<thead class="bg-oran">
												<tr  style="color: #FAFAFA">
													<th class="align-middle " data-sort="anlRnum">번호</th>
													<th class="align-middle " data-sort="anlLeaUseNo">요청번호</th>
													<th class="align-middle " data-sort="empNm">요청자</th>
													<th class="align-middle " data-sort="anlLeaYmd">요청일</th>
													<th class="align-middle " data-sort="anlStartEnd">시작/종료일</th>
													<th class="align-middle " data-sort="rqstPurchsYmd">승인일</th>
													<th class="align-middle " data-sort="rqstSe">결재상태</th>
													<th class="align-middle " data-sort="empRqNm">결재자</th>
												</tr>
											</thead>
											<tbody class="annList" id="annListBody">
											
											</tbody>
										</table>
									</div>
									
									<div class="card-footer d-flex justify-content-center paging-div-height" id="annPagingArea">
									
									</div>
									
								</div>
							</div>
						</div>
				    </div>
				    
				  <!-- 비품탭 -->
				    <div class="content-box content02">
				    
				    	<div id="tableExample3">
							
							
							<div class="row justify-content-end g-0">
								<div class="col-auto col-sm-5 mb-3">
									<form id="fxtrsSearchForm" action="<c:url value='/emp/pbl/oprtnstts/oprtnsttsList.do'/>">
										<input type="hidden" name="page" />
										<input type="hidden" name="fxtrsSearchWord" value="${simpleCondition.fxtrsSearchWord }" />
										<input type="hidden" name="fxtrsOneSearchWord" value="${simpleCondition.fxtrsOneSearchWord }" />
									</form>
									<div class="row justify-content-end g-0" data-pg-role="searchUI" data-pg-target="#fxtrsSearchForm">
										<div class="col-auto px-3">
											<div class="input-group" >
										        <select class="form-select form-select-sm mb-3"
										        		name="fxtrsOneSearchWord" data-pg-init-value="${simpleCondition.fxtrsOneSearchWord }">
													<option selected value="">업무현황</option>
													<option value="승인">승인</option>
													<option value="대기">대기</option>
													<option value="반려">반려</option>
													<option value="구매대기">구매대기</option>
													<option value="구매승인">구매승인</option>
										        </select>
										      </div>
										</div>
										<div class="col-auto col-sm-5 mb-3">
									        <div class="input-group">
									          <input class="form-control form-control-sm shadow-none search" 
									          		type="search" placeholder="Search..." aria-label="search" 
									          		name ="fxtrsSearchWord" value="${simpleCondition.fxtrsSearchWord }"/>
									          <div class="input-group-text bg-transparent">
									          	<span class="fa fa-search fs-10 text-600" data-pg-role="searchBtn"></span>
									          </div>
									        </div>
										</div>
									</div>
								</div>
							</div>
							
							
							<div class="card shadow-none">
								
								<div class="table-responsive scrollbar">
									<table class="table mb-0 center">
										<thead class="bg-oran">
											<tr style="color: #FAFAFA">
												<th class="align-middle " data-sort="rnum">번호</th>
												<th class="align-middle " data-sort="rqstNo">요청번호</th>
												<th class="align-middle " data-sort="rqstNm">요청자</th>
												<th class="align-middle " data-sort="rqstAmnt">총가격</th>
												<th class="align-middle " data-sort="rqstYmd">요청일</th>
												<th class="align-middle " data-sort="rqstPurchsYmd">최종승인일</th>
												<th class="align-middle " data-sort="rqstSe">결재상태</th>
												<th class="align-middle " data-sort="empRqNm">요청결재자</th>
												<th class="align-middle " data-sort="empPurchsNm">구매승인결재자</th>
											</tr>
										</thead>
										<tbody class="fxtrsList" id="fxtrsListBody">
											
										</tbody>
									</table>
								</div>
								
								<!-- 페이징 -->
								<div class="card-footer d-flex justify-content-center paging-div-height" id="fxtrsPagingArea">
								
								</div>
								
							</div>
						</div>
				    
					</div>
			    </div>
			</div>
		</div>
	</div>
</div>

<script>
// 페이지 로드 후 실행되는 JavaScript 코드
document.addEventListener("DOMContentLoaded", function() {
    // 연차 탭의 내용을 표시하고 비품 탭의 내용을 숨깁니다.
    document.querySelector(".content-box.content01").style.display = "block";
    document.querySelector(".content-box.content02").style.display = "none";

    // 각 탭 메뉴의 DOM 요소를 가져옵니다.
    var tabMenu1 = document.getElementById("tabmenu01");
    var tabMenu2 = document.getElementById("tabmenu02");

    // 탭을 클릭할 때 이벤트를 처리하는 함수
    function handleTabClick(event) {
        // 선택한 탭의 id를 가져옵니다.
        var selectedTabId = event.target.getAttribute("id");

        // 선택한 탭의 id에 따라 활성화/비활성화를 처리합니다.
        if (selectedTabId === "tabmenu01") {
            document.querySelector(".content-box.content01").style.display = "block";
            document.querySelector(".content-box.content02").style.display = "none";
        } else if (selectedTabId === "tabmenu02") {
            document.querySelector(".content-box.content01").style.display = "none";
            document.querySelector(".content-box.content02").style.display = "block";
        }
    }

    // 탭 메뉴에 클릭 이벤트 핸들러를 추가합니다.
    tabMenu1.addEventListener("click", handleTabClick);
    tabMenu2.addEventListener("click", handleTabClick);
});
</script>

<script src="<c:url value='/resources/js/app/emp/pbl/oprtnstts/oprtnstts.js'/>"></script>
<script src="<c:url value='/resources/js/app/common/paging.js'/>"></script>
<!-- 연차 상세 js -->
<script src="<c:url value='/resources/js/app/emp/hrm/dclz/yrycDetail.js'/>"></script>
<!-- 연차 상세 js -->
