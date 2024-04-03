<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<link href="${pageContext.request.contextPath }/resources/css/emp/pagingCss.css" rel="stylesheet"/>
<link href="${pageContext.request.contextPath }/resources/css/emp/myinfo/mypage.css" rel="stylesheet"/>
<link href="${pageContext.request.contextPath}/resources/css/common/btn.css" rel="stylesheet">
<div class="row">

        <div class="col-xl-11">

          <div class="card">
            <div class="card-body pt-3">
              <!-- Bordered Tabs -->
              <ul class="nav nav-tabs nav-tabs-bordered" role="tablist">

                <li class="nav-item" role="presentation">
                  <button class="nav-link active" data-bs-toggle="tab" data-bs-target="#profile-overview" aria-selected="true" role="tab">개인정보</button>
                </li>

                <li class="nav-item" role="presentation">
                  <button class="nav-link" data-bs-toggle="tab" data-bs-target="#profile-edit" aria-selected="false" tabindex="-1" role="tab">개인정보 수정</button>
                </li>

                <li class="nav-item" role="presentation">
                  <button class="nav-link" data-bs-toggle="tab" data-bs-target="#profile-change-password" aria-selected="false" tabindex="-1" role="tab">비밀번호 변경</button>
                </li>

                <li class="nav-item" role="presentation">
                  <button class="nav-link" data-bs-toggle="tab" data-bs-target="#profile-dclzList" aria-selected="false" tabindex="-1" role="tab">근태 조회</button>
                </li>


                <li class="nav-item" role="presentation">
                  <button class="nav-link" data-bs-toggle="tab" data-bs-target="#profile-recom-cert" aria-selected="false" tabindex="-1" role="tab">자격증 추천</button>
                </li>

              </ul>
              <div class="tab-content pt-2">

                <div class="tab-pane fade show active profile-overview" id="profile-overview" role="tabpanel">
                
                  <h5 class="card-title">Profile Details</h5>

                  <div class="row mb-2">
                    <div class="col-lg-3 col-md-4 label ">이름</div>
                    <div class="col-lg-9 col-md-8">${empUser.empNm }</div>
                  </div>

                  <div class="row mb-2">
                    <div class="col-lg-3 col-md-4 label">소속 부서</div>
                    <div class="col-lg-9 col-md-8">${empUser.empDeptName }</div>
                  </div>

                  <div class="row mb-2">
                    <div class="col-lg-3 col-md-4 label">주소</div>
                    <div class="col-lg-9 col-md-8">${empUser.empAddr }</div>
                  </div>

                  <div class="row mb-2">
                    <div class="col-lg-3 col-md-4 label">연락처</div>
                    <div class="col-lg-9 col-md-8">${empUser.empTel }</div>
                  </div>

                  <div class="row mb-2">
                    <div class="col-lg-3 col-md-4 label">자택번호</div>
                    <div class="col-lg-9 col-md-8">${empUser.empHomeTel }</div>
                  </div>

                  <div class="row mb-2">
                    <div class="col-lg-3 col-md-4 label">Email</div>
                    <div class="col-lg-9 col-md-8">${empUser.empEml }</div>
                  </div>

                  <div class="row mb-2">
                    <div class="col-lg-3 col-md-4 label">자격증 및 어학 시험</div>
	                  <c:choose>
    					<c:when test="${not empty certList }">
	                    	<div class="col-lg-9 col-md-8">
	                    		<table class="table table-sm">
	                    			<thead>
		                    			<tr>
		                    				<th scope="col">보유 자격증 및 어학시험명</th>
		                    				<th scope="col">어학시험 점수</th>
		                    			</tr>
	                    			</thead>
	                    			<tbody>
		                    			<c:forEach items="${certList }" var="cert">
		                    				<tr>
		                    					<td>${cert.certNm }</td>
		                    					<td>${cert.score }</td>
		                    				</tr>
		                    			</c:forEach>
	                    			</tbody>
	                    		</table>
	                    	</div>
    					</c:when>
    					<c:otherwise>
                    		<div class="col-lg-9 col-md-8">등록된 정보 없음</div>    						
    					</c:otherwise>
	                  </c:choose>	
					</div>
                </div>

                <div class="tab-pane fade profile-edit" id="profile-edit" role="tabpanel">
                  <h5 class="card-title">Profile Edit</h5>
                  <!-- Profile Edit Form -->
                  <form:form method="post" modelAttribute="empVO" enctype="multipart/form-data" id="myInfoUpdateInfoForm" action="${pageContext.request.contextPath }/emp/myInfo/updateMyInfo.do">
                    <div class="row mb-3">
                      <form:input path="empNo" type="hidden" value="${empUser.empNo}" id="empNo"/>
                      <label for="profileImage" class="col-md-4 col-lg-3 col-form-label">Profile Image</label>
                      <div class="col-md-8 col-lg-9">
	                <spring:eval expression="@appInfo.empLogicalPath" var="empProfPath"/>
					<c:choose>
						<c:when test="${not empty empUser.empProflUuid}">
	                    <img class="profile-img rounded-circle-profile" style="width: 100px; height: 100px;"
	                        src="<c:url value='${empProfPath }${empUser.empProflUuid}'/>" alt="Profile" id="currentProfl" />
						</c:when>
						<c:when test="${empty empUser.empProflUuid}">
	                    <img class="profile-img rounded-circle-profile" style="width: 100px; height: 100px;"
	                        src="<c:url value='${empProfPath }basic.png'/>" alt="Profile" id="currentProfl" />
						</c:when>
					</c:choose>
					<input class="form-control mt-3" type="file" name="proflImg" id="proflImg"/>
                        <div class="pt-2">
                          <a href="javascript:void(0);" onclick="proflDelete();" class="btn btn-danger btn-sm" title="Remove my profile image"><i class="far fa-trash-alt"></i></a>
                        </div>
                      </div>
                    </div>

                    <div class="row mb-3">
                      <label for="Phone" class="col-md-4 col-lg-3 col-form-label">연락처</label>
                      <div class="col-md-8 col-lg-9">
                        <form:input path="empTel" type="text" class="form-control" id="empTel" value="${empUser.empTel}"/>
                      </div>
                    </div>

                    <div class="row mb-3">
                      <label for="Phone" class="col-md-4 col-lg-3 col-form-label">자택번호</label>
                      <div class="col-md-8 col-lg-9">
                        <form:input path="empHomeTel" type="text" class="form-control" id="empHomeTel" value="${empUser.empHomeTel}"/>
                      </div>
                    </div>

                    <div class="row mb-3">
                      <label for="Email" class="col-md-4 col-lg-3 col-form-label">Email</label>
                      <div class="col-md-8 col-lg-9">
                        <form:input path="empEml" type="email" class="form-control" id="empEml" value="${empUser.empEml }"/>
                      </div>
                    </div>
					
                    <div class="text-center">
                      <button type="submit" class="custom-btn btn-6"><span>Save Changes</span></button>
                    </div>
                  </form:form>
                  <!-- End Profile Edit Form -->
                </div>
                <div class="tab-pane fade" id="profile-change-password" role="tabpanel">
                  <h5 class="card-title">Change Password</h5>
                  <!-- Change Password Form -->
                  <form:form method="post" action="${pageContext.request.contextPath }/emp/mypage/changePwd.do" id="myinfoChangePwdForm">
                    <div class="row mb-3">
                      <label for="currentPassword" class="col-md-4 col-lg-3 col-form-label">현재 비밀번호</label>
                      <div class="col-md-8 col-lg-9">
                        <input name="empPw" type="password" class="form-control" id="empPw">
                      </div>
                    </div>

                    <div class="row mb-3">
                      <label for="newPassword" class="col-md-4 col-lg-3 col-form-label">새 비밀번호</label>
                      <div class="col-md-8 col-lg-9">
                        <input name="newPwd" id="newPwd" type="password" class="form-control">
                      </div>
                    </div>

                    <div class="row mb-3">
                      <label for="renewPassword" class="col-md-4 col-lg-3 col-form-label">새 비밀번호 확인</label>
                      <div class="col-md-8 col-lg-9">
                        <input id="newPwdChk" type="password" class="form-control" >
		                  <div class="fs-10 text-danger" style="display: none;" id="dismatch">새 비밀번호와 새 비밀번호 확인을 동일하게 입력해주세요.</div>
                      </div>
                    </div>
                  <p class="fs-10 ps-2 mb-0 text-warning-emphasis">
                  	비밀번호는 문자, 숫자, 특수문자를 혼합하여 8~16자 사이로 입력해주세요.
                  </p>
				<div class="text-danger" id="errorMessageField">
					
				</div>
                    <div class="text-center">
                      <button type="submit" class="btn btn-outline-primary">비밀번호 변경</button>
                    </div>
                  </form:form>
                  <!-- End Change Password Form -->

                </div>

                <div class="tab-pane fade row flex-center" id="profile-dclzList" role="tabpanel">
                  <h5 class="card-title">Attendance</h5>
                  <form:form id="searchForm" action="${pageContext.request.contextPath }/emp/myInfo/dclzList.do">
                  	<input type="hidden" name="page" />
                  	<input type="hidden" name="searchWord" id="searchWord">
                  </form:form>
                  <div class="col-md-7">
                  <table class="table table-sm ">
    	              <tbody>
    	              <tr>
	                  	<td>근무 형태</td>
	                  	<td id="All"><button onclick="workTypeFunction(this)" class="workType btn btn-sm btn-outline-primary rounded-pill mb-1">ALL</button></td>
	                  	<td id="D"><button onclick="workTypeFunction(this)" class="workType btn btn-sm btn-outline-success rounded-pill mb-1">DAY</button></td>
	                  	<td id="E"><button onclick="workTypeFunction(this)" class="workType btn btn-sm btn-outline-info rounded-pill mb-1">EVENING</button></td>
	                  	<td id="N"><button onclick="workTypeFunction(this)" class="workType btn btn-sm btn-outline-warning rounded-pill mb-1">NIGHT</button></td>
	                  	<td id="O"><button onclick="workTypeFunction(this)" class="workType btn btn-sm btn-outline-danger rounded-pill mb-1">OFF</button></td>
	                  	<td id="G"><button onclick="workTypeFunction(this)" class="workType btn btn-sm btn-outline-secondary rounded-pill mb-1">GENERAL</button></td>
    	              </tr>
	                  </tbody>
                  </table>
                  </div>
					<table class="table table-sm">
					  <thead>
					    <tr>
					      <th class="text-900 sort"scope="col">일자</th>
					      <th class="text-900 sort"scope="col">출근 시간</th>
					      <th class="text-900 sort"scope="col">퇴근 시간</th>
					      <th class="text-900 sort"scope="col">근무 형태</th>
					      <th class="text-900 sort"scope="col">근태 상태</th>
					    </tr>
					  </thead>
					  <tbody class="list" id="listBody">
					  </tbody>
					</table>
					<!-- 페이징 -->
					<div class="card-footer d-flex justify-content-center paging-div-height" id="pagingArea">
					
					</div>
                </div>


                
                <div class="tab-pane fade" id="profile-recom-cert" role="tabpanel">
                  <h5 class="card-title">Recommand Certification</h5>
                  <h6>근무 부서와 근속 연차를 기반으로 제안하는 자격증 목록입니다.</h6>
                  <h6>${empUser.empNm } 님의 근무 부서 : ${empUser.empDeptName }서/ 근속 연차 : ${empUser.empCareer }년차</h6>
					<div class="card-group">
					  <div class="card overflow-hidden">
					    <div class="card-img-top"><img class="img-fluid" src="${pageContext.request.contextPath }/resources/assets/img/cert/${recomCertList[0].certNo }.jpg" /></div>
					    <div class="card-body">
					      <h5 class="card-title">${recomCertList[0].certNm }</h5>
							${recomCertList[0].certDetail }
					      <p class="card-text"><small class="text-500 dark__text-500"><a href="${recomCertList[0].certDetailLink }" target="_blank">More Details</a></small></p>
					    </div>
					  </div>
					  <div class="card overflow-hidden">
					    <div class="card-img-top"><img class="img-fluid" src="${pageContext.request.contextPath }/resources/assets/img/cert/${recomCertList[1].certNo }.jpg" /></div>
					    <div class="card-body">
					      <h5 class="card-title">${recomCertList[1].certNm }</h5>
							${recomCertList[1].certDetail }
					      <p class="card-text"><small class="text-500 dark__text-500"><a href="${recomCertList[1].certDetailLink }" target="_blank">More Details</a></small></p>
					    </div>
					  </div>
					  <div class="card overflow-hidden">
					    <div class="card-img-top"><img class="img-fluid" src="${pageContext.request.contextPath }/resources/assets/img/cert/${recomCertList[2].certNo }.jpg" /></div>
					    <div class="card-body">
					      <h5 class="card-title">${recomCertList[2].certNm }</h5>
							${recomCertList[2].certDetail }
					      <p class="card-text"><small class="text-500 dark__text-500"><a href="${recomCertList[2].certDetailLink }" target="_blank">More Details</a></small></p>
					    </div>
					  </div>
					</div>
                </div>

              </div><!-- End Bordered Tabs -->

            </div>
          </div>
        </div>
      </div>
      
<script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.18.0/moment.min.js"></script>
<script src="<c:url value='/resources/js/app/emp/myinfo/mypage.js'/>"></script>      
<script src="<c:url value='/resources/js/app/common/paging.js'/>"></script>