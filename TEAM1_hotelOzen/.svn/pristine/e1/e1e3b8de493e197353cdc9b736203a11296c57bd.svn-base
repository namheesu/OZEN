<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
         
          <div class="col-6 d-none d-lg-block position-relative">
            <div class="bg-holder" >
            </div>
          </div>
          
        <div class="row flex-center min-vh-100 py-6 text-center">
          <div class="col-sm-10 col-md-8 col-lg-6 col-xl-4 col-xxl-4">
          <a class="d-flex flex-center mb-4" href="${pageContext.request.contextPath }/emp">
          <img class="me-2" src="${pageContext.request.contextPath }/resources/assets/img/generic/hotelozen.png" alt="" style="margin-left: 70px;"/>
          </a>
            <div class="card">
              <div class="card-body p-4 p-sm-5">
                <h5 class="mb-0">Forgot your ID?</h5><small>Enter your name and phone-number.</small>
                <button class="custom-btn btn-7 d-block w-100 mt-3" type="button" id="autoComplete" >자동완성</button>
                <form:form method="post" class="mt-4" id="findIdForm" action="${pageContext.request.contextPath }/emp/auth/findLogic.do">
                  <input class="form-control" type="text" placeholder="Your Name" name="empNm" id="empNm"/>
                  <div class="mb-2"></div>
                  <input class="form-control" type="text" placeholder="Your Phone Number" name="empTel" id="empTel"/>
                  <div class="mb-2"></div>
                  <button class="custom-btn btn-7 d-block w-100 mt-3" type="submit" name="submit">인증하기</button>
                </form:form>
                
                  <div id="otpAuth" style="display: none;">
					<form:form method="post" class="mt-4" id="otpAuthForm" action="${pageContext.request.contextPath }/emp/auth/otp.do">
			            <div id="countDown" class="text-end">test</div>
	                  <input class="form-control" type="text" placeholder="Your Name" name="otpCd" id="otpCd" readonly="readonly"/>
	                  <div class="mb-2"></div>
	                  <input class="form-control" type="text" placeholder="Your Otp Number" name="otpNo" id="otpNo"/>
	                  <div class="mb-2"></div>
	                  <button class="custom-btn btn-7 d-block w-100 mt-3" type="submit" name="submit">아이디 확인</button>
	                </form:form>
	              <div class="fs-10 text-600" style="display: none;" id="failDiv">인증 실패! 다시 인증해주세요</div>
                  </div>
	            <div>
	           	 <a class="fs-10 text-600" href="${pageContext.request.contextPath }/emp/auth/Login.do">로그인<span class="d-inline-block ms-1">&rarr;</span></a>
	            </div>
	            <div>
               	 <a class="fs-10 text-600" href="${pageContext.request.contextPath }/emp/auth/findPwd.do">비밀번호 찾기<span class="d-inline-block ms-1">&rarr;</span></a>
	            </div>
              </div>
            </div>
          </div>
        </div>
        
        <div class="modal fade" id="showIdModal" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
	        <div class="modal-dialog modal-dialog-centered">
			  <div class="modal-content">
			      <div class="position-absolute top-0 end-0 mt-3 me-3 z-1">
			        <button class="btn-close btn btn-sm d-flex flex-center transition-base" data-bs-dismiss="modal" aria-label="Close"></button>
			      </div>
			      <div class="modal-body p-0">
			        <div class="rounded-top-3 py-3 ps-4 pe-6 bg-body-tertiary">
			          <h4 class="mb-1" id="modalExampleDemoLabel">사번 조회 결과 </h4>
				        </div>
				        <div class="p-x1 border-end-md border-bottom border-bottom-md-0 border-dashed">
                      <h6 class="fs-10 mb-3">Search results</h6>
                      <div class="row mt-2">
                        <div class="col-3 col-sm-2 col-md-3 col-lg-2">
                          <p class="mb-0 fs-10 fw-semi-bold text-600 text-nowrap">Emp No</p>
                        </div>
                        <div class="col-9 col-sm-10 col-md-9 col-lg-10 d-flex align-items-center">
							<textarea class="form-control" rows="1" readonly="readonly" id="showId"></textarea>
                        </div>
                      </div>
                    </div>
			      </div>
			      <div class="modal-footer">
			      	<a class="fs-10 text-600 badge badge-subtle-danger me-1 py-1 rounded-1" type="button" href="#" data-bs-dismiss="modal">close</a>
                    <a class="fs-10 text-600 badge badge-subtle-primary me-1 py-1 rounded-1" type="button" href="${pageContext.request.contextPath }/emp/auth/Login.do">Login</a>
			      </div>
			    </div>
			</div>
		</div>
<script src="<c:url value='/resources/js/app/emp/auth/findId.js'/>"></script>