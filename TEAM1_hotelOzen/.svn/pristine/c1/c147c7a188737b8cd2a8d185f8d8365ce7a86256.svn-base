<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form"  prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags"  prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>


<link href="${pageContext.request.contextPath}/resources/css/emp/hrm/emply/empList.css" rel="stylesheet">


<div class="col mb-3">
	<div class="card h-100">
		<div class="card-header">
			<div class="row flex-between-end">
				<nav style="--falcon-breadcrumb-divider: url(&#34;data:image/svg+xml,%3Csvg xmlns='http://www.w3.org/2000/svg' width='8' height='8'%3E%3Cpath d='M2.5 0L1 1.5 3.5 4 1 6.5 2.5 8l4-4-4-4z' fill='%23748194'/%3E%3C/svg%3E&#34;);" aria-label="breadcrumb">
				  <ol class="breadcrumb">
				    <li class="breadcrumb-item"><a href="${pageContext.request.contextPath}/emp">Home</a></li>
				    <li class="breadcrumb-item active" aria-current="page">직원조회</li>
				  </ol>
				</nav>
              
              <!--                     전체직원조회 -->
               <div class="mb-3" id="allEmpList" data-list>
                <div class="card-header border-bottom border-200 px-0">
                	<div class=""  style="float: left;">총 직원 수: ${fn:length(hrmEmpList)} 명 (</div>
<%--                 	<input type="hidden" id="emps" name="hrmEmps" value="${hrmEmpList}" /> --%>
                	<c:set var="fto" value="0"/>
                	<c:set var="hkp" value="0"/>
                	<c:set var="fmt" value="0"/>
                	<c:set var="crm" value="0"/>
                	<c:set var="pos" value="0"/>
                	<c:set var="hrm" value="0"/>
                	<c:if test="${not empty hrmEmpList}">
		               	<c:forEach items="${hrmEmpList }" var="emp"> 
		               		<c:if test="${emp.empDept eq '프론트오피스부'}">
								<c:set var="fto" value="${fto+1}"/>
							</c:if>
		               		<c:if test="${emp.empDept eq '하우스키핑부'}">
		               			<c:set var="hkp" value="${hkp+1}"/>
		               		</c:if>
		               		<c:if test="${emp.empDept eq '시설관리부'}">
		               			<c:set var="fmt" value="${fmt+1}"/>
		               		</c:if> 
		               		<c:if test="${emp.empDept eq '고객관리부'}">
		               			<c:set var="crm" value="${crm+1}"/>
		               		</c:if> 
		               		<c:if test="${emp.empDept eq '재무부'}">
		               			<c:set var="pos" value="${pos+1}"/>
		               		</c:if> 
		               		<c:if test="${emp.empDept eq '인사부'}">
		               			<c:set var="hrm" value="${hrm+1}"/>
		               		</c:if> 
		               	</c:forEach>
                	</c:if>
                	<div class="deptCnt">
		                	<c:out value="프론트오피스부: ${fto } 명, "/>
		                	<c:out value="하우스키핑부: ${hkp } 명, "/>
							<c:out value="시설관리부: ${fmt } 명,"/>
							<c:out value="고객관리부: ${crm } 명, "/>
							<c:out value="재무부: ${pos }명, "/>
							<c:out value="인사부: ${hrm }명 )"/>
					</div>

                	<div class="">현재 출근 직원 수: ${fn:length(hrmEmpDclzList)} 명</div>
                	<div class="">퇴사자 수: ${fn:length(hrmEmpRtrmList)} 명</div>
                  <div class="justify-content-end g-0">
                    <div class="row justify-content-end g-0" >
                      <div class="col-auto" >
                        <form>
	                        <div class="d-flex">
	                          <select  id="myDept" class="form-select form-select-sm" aria-label="Bulk actions">
	                            <option selected value="">전체</option>
	                            <option value="프론트오피스부">프론트오피스부</option>
	                            <option value="하우스키핑부">하우스키핑부</option>
	                            <option value="시설관리부">시설관리부</option>
	                            <option value="고객관리부">고객관리부</option>
	                            <option value="재무부">재무부</option>
	                            <option value="인사부">인사부</option>
	                          </select>
	                		<div class="input-group">
	                            <input class="form-control form-control-sm shadow-none search ms-2" type="search" placeholder="검색" aria-label="search">
	                            <button class="btn btn-sm btn-outline-secondary border-300 hover-border-secondary">
	                            <span class="fa fa-search fs--1"></span></button>
	                          </div>
	                        </div>
                        </form>
                      </div>
                    </div>
                   
                  </div>
                </div>
                <div class="card-body p-0 pb-3">
                  <div class="table-responsive scrollbar">
                    <table class="table mb-0 center">
                      <thead class="bg-oran">
                        <tr style="color: #FAFAFA">
                          
<!--                           <th class="sort align-middle ps-2" data-sort="rnum">순번</th> -->
                          
                          <th class="sort align-middle pe-5" data-sort="empNo">사번</th>
                          <th class="sort align-middle pe-5" data-sort="empDept">부서명</th>
                          <th class="sort align-middle pe-5" data-sort="empNm">이름</th>
                          <th class="sort align-middle pe-5" data-sort="empTel">전화번호</th>
                          <th class="sort align-middle text-end" data-sort="empJbgd">직급</th>
                          <th class="sort align-middle text-end" data-sort="empJncmpYmd">입사일</th>
                          <th class="sort align-middle text-end" data-sort="dclzStts">출근시각</th>
                          <th class="sort align-middle text-end" data-sort="empRtrmYn">퇴사여부</th>
             
                        </tr>
                      </thead>
                      <tbody class="list" id="retired-body">

		<c:if test="${not empty hrmEmpList }">
			<c:forEach items="${hrmEmpList }" var="hrmEmp" varStatus="vs">
			<tr>
<%-- 			<td class="align-middle rnum text-center">${hrmEmp.rnum }</td> --%>
			<td class="align-middle empNo">${hrmEmp.empNo }</td>
			<td class="align-middle empDept">${hrmEmp.empDept }</td>
			<td class="align-middle pe-5 empNm">
				<div class="row position-relative">
<%-- 					<h6 class="mb-0"><a class="stretched-link text-900" href="${pageContext.request.contextPath}/emp/pbl/emply/view">${hrmEmp.empNm }</a></h6> --%>
					<h6 class="mb-0"><a class="stretched-link text-900" id="empView" data-bs-toggle="modal" data-bs-target="#empInfo${vs.index}" href="${pageContext.request.contextPath}/emp/pbl/emply/view">${hrmEmp.empNm }</a></h6>
				</div>
			</td>
			
			<td class="align-middle empTel">${hrmEmp.empTel }</td>
			
			<c:if test="${hrmEmp.empJbgd eq '사원' }">
				<td class="align-middle empJbgd fs-0 text-end"><span class="badge bg-primary">${hrmEmp.empJbgd }</span></td>
<!-- 				<td class="align-middle empJbgd fs-0 text-end"><span class="badge bg-primary">STF</span> -->
			</c:if>
			<c:if test="${hrmEmp.empJbgd ne '사원'}">
				<td class="align-middle empJbgd fs-0 text-end"><span class="badge bg-danger">${hrmEmp.empJbgd }</span></td>
			</c:if>
			<td class="align-middle empJncmpYmd text-end ps-4">${hrmEmp.empJncmpYmd }
			</td>
			
			<c:set var="cnt"  value="0"/>
			<c:if test="${not empty hrmEmpDclzList }">
				<c:forEach items="${hrmEmpDclzList }" var="dclz">
						<c:if test="${dclz.empNo eq hrmEmp.empNo }">
							<fmt:parseDate value="${dclz.dclz.dclzBgnDt}" pattern="yyyy-MM-dd'T'HH:mm:ss" var="parsedDateTime" type="both"/>
							<c:set var="cnt"  value="${cnt+1}"/>
						</c:if>
				</c:forEach>
						<c:if test="${cnt eq 1 }">
						<td class="align-middle dclzStts text-end ps-4">
						<span class="badge badge rounded-pill badge-subtle-success"><fmt:formatDate pattern="yyyy-MM-dd, HH시 mm분" value="${parsedDateTime}" /></span>
						</td>
						</c:if>
			</c:if>
			<c:if test="${cnt eq 0 }"><td class="align-middle dclzStts text-end ps-4"><span class="badge badge rounded-pill badge-subtle-secondary">출근 전</span></td></c:if>
			<c:set var="cnt"  value="${cnt-1}"/>
<%-- 			<c:if test="${empty hrmEmpDclzList }"><td class="align-middle dclzStts text-end ps-4"><span class="badge badge rounded-pill badge-subtle-secondary">출근 전</span></td></c:if>			 --%>
			<td class="align-middle empRtrmYn text-end pe-5" >${hrmEmp.empRtrmYn }
			</td>
		</tr>
		
<!-- 직원 상세 조회 모달	 -->
		
<div class="modal fade" id="empInfo${vs.index}" data-bs-keyboard="false" data-bs-backdrop="static" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
  <div class="modal-dialog modal-lg mt-6" role="document">
    <div class="modal-content border-0">
      <div class="position-absolute top-0 end-0 mt-3 me-3 z-1">
        <button class="btn-close btn btn-sm btn-circle d-flex flex-center transition-base" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      <div class="modal-body p-0">
        <div class="rounded-top-3 bg-body-tertiary py-3 ps-4 pe-6">
          <h4 class="mb-1" id="staticBackdropLabel">직원 상세 정보</h4>
<!--           <p class="fs-11 mb-0">Added by <a class="link-600 fw-semi-bold" href="#!">Antony</a></p> -->
        </div>
        <div class="p-4">
          <div class="row">
            <div class="col-lg-12">
              <div class="d-flex">
                <div class="flex-1">
                  
                  <div class="d-flex">
                  <div class="card-body bg-light">
                    <div class="card border rounded-3 bg-white dark__bg-1000 shadow-none">
                      <div class="bg-holder bg-card d-none d-sm-block d-xl-none" style=background-image:url(${pageContext.request.contextPath}/resources/assets/img/icons/spot-illustrations/corner-2.png);>
                      </div>
                      <!--/.bg-holder-->

                      <div class="card-body row g-0 flex-column flex-sm-row flex-xl-column z-index-1 align-items-center">
                        <div class="col-auto text-center me-sm-x1 me-xl-0">
<%--                         <img class="ticket-preview-avatar" src="${pageContext.request.contextPath}/resources/assets/img/team/5-thumb.png" alt="" /></div> --%>
                        					<spring:eval expression="@appInfo.empLogicalPath" var="empProfPath"/>
                        					<c:choose>
						<c:when test="${not empty hrmEmp.empProflUuid}">
	                    <img class="profile-img rounded-circle-profile" style="width: 100px; height: 100px;"
	                        src="<c:url value='${empProfPath }${hrmEmp.empProflUuid}'/>" alt="Profile" id="currentProfl" />
						</c:when>
						<c:when test="${empty hrmEmp.empProflUuid}">
	                    <img class="ticket-preview-avatar" src="${pageContext.request.contextPath}/resources/assets/img/team/5-thumb.png" alt="" />
						</c:when>
					</c:choose>
					</div>
                        <div class="col-sm-8 col-md-6 col-lg-4 col-xl-12 ps-sm-1 ps-xl-0">
                          <p class="fw-semi-bold mb-0 text-800 text-center text-sm-start text-xl-center mb-3 mt-3 mt-sm-0 mt-xl-3">${hrmEmp.empNm}</p>
                          <div class="d-flex gap-2 justify-content-center">
                          	<c:if test="${hrmEmp.empJbgd eq '사원' }">
                            <button class="btn btn-primary btn-sm px-2 text-nowrap w-50"><span class="fas fa-id-badge me-1" data-fa-transform="shrink-3 down-1"></span><span class="fs--2">${hrmEmp.empJbgd }</span></button>
                          	</c:if>
                          	<c:if test="${hrmEmp.empJbgd eq '팀장' }">
                            <button class="btn btn-danger btn-sm px-2 text-nowrap w-50"><span class="fas fa-id-badge me-1" data-fa-transform="shrink-3 down-1"></span><span class="fs--2">${hrmEmp.empJbgd }</span></button>
                          	</c:if>
                            <button class="btn btn-sm btn-falcon-default w-50"><span class="fas fa-landmark me-1" data-fa-transform="shrink-4"></span><span class="fs--2">${hrmEmp.empDept}</span></button>
                          </div>
                        </div>
                      </div>
                    </div>
                    <div class="border rounded-3 p-x1 mt-3 bg-white row mx-0 g-0">
                    
                    	<div class="d-flex flex-wrap mb-4" style="height: 300px;">
							
						  <div class="p-2" style="width: 330px;"><h6 class="mb-1 false">이메일</h6><p class="mb-0 text-700 fs--1">${hrmEmp.empEml }</p></div>
						  <div class="p-2" style="width: 330px;"><h6 class="false mb-1">전화번호</h6><p class="mb-0 text-700 fs--1">${hrmEmp.empTel }</p></div>
						  <div class="p-2" style="width: 330px;"><h6 class="false mb-1">주소</h6><p class="mb-0 text-700 fs--1">${hrmEmp.empAddr }</p></div>
						  <div class="p-2" style="width: 330px;"><h6 class="false mb-1">자택 전화번호</h6><p class="mb-0 text-700 fs--1">${hrmEmp.empAddr }</p></div>
						  <div class="p-2" style="width: 330px;"><h6 class="false mb-1">생년월일</h6><p class="mb-0 text-700 fs--1">${hrmEmp.empBirth }</p></div>
						  <div class="p-2" style="width: 330px;"><h6 class="false mb-1">퇴사여부</h6><p class="mb-0 text-700 fs--1">${hrmEmp.empRtrmYn }</p></div>
						  <div class="p-2" style="width: 330px;"><h6 class="false mb-1">입사일</h6><p class="mb-0 text-700 fs--1">${hrmEmp.empJncmpYmd }</p></div>
						  <div class="p-2" style="width: 330px;"><h6 class="false mb-1">사번</h6><p class="mb-0 text-700 fs--1">${hrmEmp.empNo }</p></div>
						  <div class="p-2" style="width: 330px;"><h6 class="false mb-1">잔여연차</h6><p class="mb-0 text-700 fs--1">${hrmEmp.empAnnualLeave }</p></div>
					</div>
                    	
                     
                    </div>
                  </div>
                             
                  </div>
                  <hr class="my-4" />
                </div>
              </div>
              <div class="d-flex"><span class="fa-stack ms-n1 me-3"><i class="fas fa-circle fa-stack-2x text-200"></i><i class="fa-inverse fa-stack-1x text-primary fas fa-align-left" data-fa-transform="shrink-2"></i></span>
                <div class="flex-1">
					<c:if test="${empty hrmEmp.empRtrmYn}"><button onclick="fnDel()" data-emp-no= "${hrmEmp.empNo }" data-rtrm-yn="${hrmEmp.empRtrmYn }" data-check="delete" class="btn btn-outline-info me-1 mb-1 delBtn">퇴사자 처리</button></c:if>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</div>		
			
<!-- 		직원상세 조회 모달 끝		 -->
		
	</c:forEach>
</c:if>
                      
 
                    
                        </tbody>
                    </table>
                    <div class="text-center d-none" id="contact-table-fallback">
                      <p class="fw-bold fs-1 mt-3">No contact found</p>
                    </div>
                  </div>
                </div>
                <div class="card-footer d-flex justify-content-center">
                  <button class="btn btn-sm btn-falcon-default me-1" type="button" title="Previous" data-list-pagination="prev"><span class="fas fa-chevron-left"></span></button>
                  <ul class="pagination mb-0"></ul>
                  <button class="btn btn-sm btn-falcon-default ms-1" type="button" title="Next" data-list-pagination="next"><span class="fas fa-chevron-right"></span></button>
                </div>
              </div>
                 
          
<!--                     전제직원 조회 끝 -->

              </div>
              </div>
              </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
<script src="<c:url value='/resources/js/app/emp/hrm/emply/empList.js'/>" ></script>
