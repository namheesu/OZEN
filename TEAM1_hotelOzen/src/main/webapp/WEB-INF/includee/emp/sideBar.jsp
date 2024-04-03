<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles"  prefix="tiles" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<link href="${pageContext.request.contextPath}/resources/css/emp/sideBar.css" rel="stylesheet">

<nav class="navbar navbar-light navbar-vertical navbar-expand-xl navbar-card">
    <script>
        var navbarStyle = localStorage.getItem("navbarStyle");
        if (navbarStyle && navbarStyle !== 'transparent') {
            document.querySelector('.navbar-vertical').classList
                .add(`navbar-${navbarStyle}`);
        }
    </script>
    
    <div class="d-flex align-items-center">
        <a class="navbar-brand" href="${pageContext.request.contextPath }<spring:eval expression="@config.getProperty('empIndex')"/>">
            <div class="d-flex py-3" style="margin-bottom: 9px;" > 
                <img src="${pageContext.request.contextPath}/resources/assets/img/generic/hotelozen.png" alt="" width="230" />
            </div>
        </a>
    </div>
    
    <div class="collapse navbar-collapse" id="navbarVerticalCollapse">
    	
        <div class="navbar-vertical-content scrollbar scrollbar-padding">
            <ul class="navbar-nav flex-column mb-3" id="navbarVerticalNav">

                <!-- 프로필사진 -->
                <div class="profile" id="${empUser.empNo}">
	                <spring:eval expression="@appInfo.empLogicalPath" var="empProfPath"/>
					<c:choose>
						<c:when test="${not empty empUser.empProflUuid}">
	                    <img class="profile-img rounded-circle-profile"
	                        src="<c:url value='${empProfPath }${empUser.empProflUuid}'/>">
						</c:when>
						<c:when test="${empty empUser.empProflUuid }">
	                    <img class="profile-img rounded-circle-profile"
	                        src="<c:url value='${empProfPath }basic.png'/>">
						</c:when>
					</c:choose>
	                    <div class="profile-name-span">
							${empUser.empNm }
	                    </div>
	                    <div class="profile-jbgd-span profile-jbgd" id="${empUser.empJbgd }">${empUser.empJbgd }</div>
	                    <div class="profile-dept-span profile-dept" id="${empUser.empDeptName }">${empUser.empDeptName }</div>
	                    <a href="${pageContext.request.contextPath}<spring:eval expression="@config.getProperty('empMypage')"/>" class="profile-button">
	                        <i class="fas fa-address-card profile-mypage"></i> 마이페이지
	                    </a>
                </div>

                <!-- 카테고리 시작 -->
                <!-- common(직원공통 카테고리) start -->
                <li class="nav-item">
                    <!-- label-->
                    <div class="row navbar-vertical-label-wrapper mt-3 mb-2">
                        <div class="col-auto navbar-vertical-label">common</div>
                        <div class="col ps-0">
                            <hr class="mb-0 navbar-vertical-divider" />
                        </div>
                    </div> 
                    <!-- 직원조회 카테고리 --> 
                    <a class="nav-link" href="${pageContext.request.contextPath}/emp/pbl/emply" role="button">
                        <div class="d-flex align-items-center">
                            <span class="nav-link-icon"> 
                            	<span class="fas fa-user-tie"></span>
                            </span> 
                            <span class="nav-link-text ps-1">직원조회</span>
                        </div>
                    </a> 
                    <!-- 고객조회 카테고리--> 
                    <a class="nav-link" href="${pageContext.request.contextPath }<spring:eval expression="@config.getProperty('cstmrList')"/>" role="button">
                        <div class="d-flex align-items-center">
                            <span class="nav-link-icon"> 
                            	<span class="fas fa-users"></span>
                            </span> 
                            <span class="nav-link-text ps-1">고객조회</span>
                        </div>
                    </a> 
                    <!-- 업무현황 카테고리 --> 
                    <a class="nav-link" href="${pageContext.request.contextPath}<spring:eval expression="@config.getProperty('oprtnstts')"/>" role="button">
                        <div class="d-flex align-items-center">
                            <span class="nav-link-icon"> 
                            	<span class="fab fa-black-tie"></span>
                            </span> 
                            <span class="nav-link-text ps-1">업무현황</span>
                        </div>
                    </a> 
                    <!-- 직원 공지사항 카테고리 --> 
                    <a class="nav-link" href="${pageContext.request.contextPath}<spring:eval expression="@config.getProperty('empNotice')"/>" role="button">
                        <div class="d-flex align-items-center">
                            <span class="nav-link-icon"> 
                            	<span class="fas fa-clipboard-list"></span>
                            </span> 
                            <span class="nav-link-text ps-1">공지사항</span>
                        </div>
                    </a> 
                    <!-- 고객 공지사항 카테고리 --> 
                    <a class="nav-link" href="${pageContext.request.contextPath}<spring:eval expression="@config.getProperty('crmNotice')"/>" role="button">
                        <div class="d-flex align-items-center">
                            <span class="nav-link-icon"> 
                            	<span class="fas fa-clipboard"></span>
                            </span> 
                            <span class="nav-link-text ps-1">고객 공지사항</span>
                        </div>
                    </a> 
                </li>
                <!-- common end --> 
                
                <!-- 부서별 카테고리 start -->
                <li class="nav-item">
                	<div class="row navbar-vertical-label-wrapper mt-3 mb-2">
                        <div class="col-auto navbar-vertical-label"></div>
                        <div class="col ps-0">
                            <hr class="mb-0 navbar-vertical-divider" />
                        </div>
                    </div>
                    
                    <security:authorize access="hasRole('ROLE_HRM')">
		                <!-- 인사관리 카테고리 start --> 
	                	<a class="nav-link dropdown-indicator" href="#humanManage" role="button"
	                  		data-bs-toggle="collapse" aria-expanded="false" aria-controls="humanManage">
		                  	<div class="d-flex align-items-center">
		                  		<span class="nav-link-icon">
		                  			<span class="fas fa-people-arrows"></span>
		                  		</span>
		                  		<span class="nav-link-text ps-1">인사관리</span>
		                  	</div>
	                	</a>
	                	<ul class="nav collapse sho" id="humanManage">
	                		<!-- 신규직원생성 start -->
	                  		<li class="nav-item">
	                  			<a class="nav-link" href="${pageContext.request.contextPath}<spring:eval expression="@config.getProperty('emplyInsert')"/>">
	                    			<div class="d-flex align-items-center hm-li-marjin">
	                    				<span class="nav-link-text ps-1">신규직원생성</span>
	                      			</div>
	                    		</a>
	                  		</li>
	                		<!-- 신규직원생성 end -->
	                		
	                		<!-- 직원공지사항 start -->
	                  		<li class="nav-item">
	                  			<a class="nav-link" href="${pageContext.request.contextPath}<spring:eval expression="@config.getProperty('empNoticeView')"/>">
	                    			<div class="d-flex align-items-center hm-li-marjin">
	                    				<span class="nav-link-text ps-1">직원공지사항</span>
	                      			</div>
	                    		</a>
	                  		</li>
	                		<!-- 직원공지사항 end -->
	                		
	                		<!-- 급여관리 start -->
	                  		<li class="nav-item">
	                  			<a class="nav-link" href="${pageContext.request.contextPath}<spring:eval expression="@config.getProperty('payslip')"/>">
	                    			<div class="d-flex align-items-center hm-li-marjin">
	                    				<span class="nav-link-text ps-1">급여관리</span>
	                      			</div>
	                    		</a>
	                  		</li>
	                		<!-- 급여관리 end -->
	                		
	                		<!-- 근무일정표 start -->
	<!--                   		<li class="nav-item"> -->
	<%--                   			<a class="nav-link" href="${pageContext.request.contextPath}<spring:eval expression="@config.getProperty('workingSchdl')"/>"> --%>
	<!--                     			<div class="d-flex align-items-center hm-li-marjin"> -->
	<!--                     				<span class="nav-link-text ps-1">근무일정표</span> -->
	<!--                       			</div> -->
	<!--                     		</a> -->
	<!--                   		</li> -->
	                		<!-- 근무일정표 end -->
	                		
	                		<!-- 연차관리 start -->
	                  		<li class="nav-item">
	                  			<a class="nav-link" href="${pageContext.request.contextPath}<spring:eval expression="@config.getProperty('yryc')"/>">
	                    			<div class="d-flex align-items-center hm-li-marjin">
	                    				<span class="nav-link-text ps-1">연차관리</span>
	                      			</div>
	                    		</a>
	                  		</li>
	                		<!-- 연차관리 end -->
	                	</ul>
	                	<!-- 인사관리 카테고리 end -->
                    </security:authorize>
					<security:authorize access="hasAnyRole('ROLE_FTO', 'ROLE_HKP', 'ROLE_FMT')">
					
                	<!-- 호텔관리 카테고리 start -->
                	<a class="nav-link dropdown-indicator" href="#hotelManage" role="button"
                  		data-bs-toggle="collapse" aria-expanded="false" aria-controls="hotelManage">
                  		<div class="d-flex align-items-center">
                  			<span class="nav-link-icon"> 
                  				<span class="fas fa-file-alt"></span>
                  			</span>
                  			<span class="nav-link-text ps-1">호텔관리</span>
                  		</div>
                	</a>
                	<ul class="nav collapse" id="hotelManage">
                		<!-- 객실관리 start -->
                		<li class="nav-item">
                  			<a class="nav-link" href="${pageContext.request.contextPath}<spring:eval expression="@config.getProperty('roomList')"/>">
                    			<div class="d-flex align-items-center hm-li-marjin">
                    				<span class="nav-link-text ps-1">객실관리</span>
                      			</div>
                    		</a>
                  		</li> 
                		<!-- 객실관리 start -->
                		
                		<!-- 투숙관리 start -->
                  		<li class="nav-item">
                  			<a class="nav-link dropdown-indicator" href="#staymanage" 
                  				data-bs-toggle="collapse" aria-expanded="false" aria-controls="forms">
                      			<div class="d-flex align-items-center hm-li-marjin">
                      				<span class="nav-link-text ps-1">투숙관리</span>
                      			</div>
                   			</a>
							<ul class="nav collapse" id="staymanage">
		                		<!-- 투숙명단 start -->
	                      		<li class="nav-item">
	                      			<a class="nav-link" href="${pageContext.request.contextPath}<spring:eval expression="@config.getProperty('nowStayList')"/>">
	                          			<div class="d-flex align-items-center hm-li-marjin">
	                          				<span class="nav-link-text ps-1">현재 투숙명단</span>
	                          			</div>
	                        		</a>
	                      		</li>
		                		<!-- 투숙명단 end -->
		                		
    		                	<!-- 룸서비스 주문 내역 start -->   
		                 		<li class="nav-item">
		          					<a class="nav-link" href="${pageContext.request.contextPath}<spring:eval expression="@config.getProperty('roomSvcList')"/>">
		              					<div class="d-flex align-items-center hm-li-marjin">
		              						<span class="nav-link-text ps-1">룸서비스 주문 내역</span>
		              					</div>
		              				</a>
		                 		</li>     		
			               		<!-- 룸서비스 주문 내역 end -->  
		                		
		                		<!-- 체크인 예정자 명단 start -->
								<li class="nav-item">
									<a class="nav-link" href="${pageContext.request.contextPath}<spring:eval expression="@config.getProperty('checkinList')"/>">
										<div class="d-flex align-items-center hm-li-marjin">
											<span class="nav-link-text ps-1">체크인 예정자 명단</span>
										</div>
									</a>
								</li>
		                		<!-- 체크인 예정자 명단 end -->
		                		
		                		<!-- 체크아웃 예정자 명단 start -->
		                      	<li class="nav-item">
		                      		<a class="nav-link"  href="${pageContext.request.contextPath}<spring:eval expression="@config.getProperty('checkoutList')"/>">
		                          		<div class="d-flex align-items-center hm-li-marjin">
		                          			<span class="nav-link-text ps-1">체크아웃 예정자 명단</span>
		                          		</div>
		                        	</a>
		                      	</li>
		                		<!-- 체크아웃 예정자 명단 end -->
		                		
		                		<!-- 투숙내역 start -->
	                      		<li class="nav-item">
	                      			<a class="nav-link" href="${pageContext.request.contextPath}<spring:eval expression="@config.getProperty('stayList')"/>">
	                          			<div class="d-flex align-items-center hm-li-marjin">
	                          				<span class="nav-link-text ps-1">투숙내역</span>
	                          			</div>
	                        		</a>
	                      		</li>
		                		<!-- 투숙명단 end -->
                   			</ul>
             			</li>
                		<!-- 투숙관리 end -->
                		

                		
                		<!-- 예약관리 start -->              		
               			<li class="nav-item">
               				<a class="nav-link dropdown-indicator" href="#rsvtManage" 
               					data-bs-toggle="collapse" aria-expanded="false" aria-controls="forms">
                   				<div class="d-flex align-items-center hm-li-marjin">
                   					<span class="nav-link-text ps-1">예약 관리</span>
                   				</div>
                   			</a>
		                    <ul class="nav collapse" id="rsvtManage">
		                		<!-- 예약내역 start -->              		
								<li class="nav-item">
									<a class="nav-link" href="${pageContext.request.contextPath}<spring:eval expression="@config.getProperty('rsvtList')"/>">
                      					<div class="d-flex align-items-center hm-li-marjin">
                      						<span class="nav-link-text ps-1">예약 내역</span>
                      					</div>
                       				</a>
			                   	</li>
		                		<!-- 예약내역 end -->
		                		              		
		                		<!-- 워크인 start -->              		
                   				<li class="nav-item">
                   					<a class="nav-link" href="${pageContext.request.contextPath}<spring:eval expression="@config.getProperty('rsvtAdd')"/>">
                       					<div class="d-flex align-items-center hm-li-marjin">
                       						<span class="nav-link-text ps-1">워크인</span>
                       					</div>
                       				</a>
		  	                    </li>
		                		<!-- 워크인 end -->              		
		                    </ul>
	                  	</li>
                		<!-- 예약관리 end -->              		
                 			
                		<!-- 비품관리 start -->              		
               			<li class="nav-item">
               				<a class="nav-link dropdown-indicator" href="#fxtrsManage" 
               					data-bs-toggle="collapse" aria-expanded="false" aria-controls="forms">
                   				<div class="d-flex align-items-center hm-li-marjin">
                   					<span class="nav-link-text ps-1">비품관리</span>
                   				</div>
                   			</a>
		                    <ul class="nav collapse" id="fxtrsManage">
		                		<!-- 현재 비품 수량 start -->              		
           			     		<li class="nav-item">
       			     				<a class="nav-link" href="${pageContext.request.contextPath}<spring:eval expression="@config.getProperty('presList')"/>">
                       					<div class="d-flex align-items-center hm-li-marjin">
                       						<span class="nav-link-text ps-1">현재 비품수량</span>
                       					</div>
                       				</a>
			                   	</li>
		                		<!-- 현재 비품 수량 end -->
		                		              		
		                		<!-- 비품 요청서 목록 start -->              		
                   				<li class="nav-item">
                   					<a class="nav-link" href="${pageContext.request.contextPath}<spring:eval expression="@config.getProperty('rqstList')"/>">
                       					<div class="d-flex align-items-center hm-li-marjin">
                       						<span class="nav-link-text ps-1">비품 요청서 목록</span>
                       					</div>
                       				</a>
		  	                    </li>
		                		<!-- 비품 요청서 목록 end -->
		                		              		
		                		<!-- 비품 사용서 목록 start -->              		
                   				<li class="nav-item">
                   					<a class="nav-link" href="${pageContext.request.contextPath}<spring:eval expression="@config.getProperty('userList')"/>">
                       					<div class="d-flex align-items-center hm-li-marjin">
                       						<span class="nav-link-text ps-1">비품 사용서 목록</span>
                       					</div>
                       				</a>
		  	                    </li>
		                		<!-- 비품 사용서 목록 end -->              		
		                    </ul>
	                  	</li>
                		<!-- 비품관리 end -->              		            		
	                  	
                		<!-- 주차관리 start -->              		
               			<li class="nav-item">
               				<a class="nav-link dropdown-indicator" href="#carManage" 
               					data-bs-toggle="collapse" aria-expanded="false" aria-controls="forms">
                   				<div class="d-flex align-items-center hm-li-marjin">
                   					<span class="nav-link-text ps-1">주차관리</span>
                   				</div>
                   			</a>
		                    <ul class="nav collapse" id="carManage">
		                		<!-- 차량조회 start -->              		
           			     		<li class="nav-item">
       			     				<a class="nav-link" href="${pageContext.request.contextPath}<spring:eval expression="@config.getProperty('parkingCarList')"/>">
                       					<div class="d-flex align-items-center hm-li-marjin">
                       						<span class="nav-link-text ps-1">차량조회</span>
                       					</div>
                       				</a>
			                   	</li>
		                		<!-- 차량조회 end -->
		                		              		
		                		<!-- 주차장 start -->              		
                   				<li class="nav-item">
                   					<a class="nav-link" href="${pageContext.request.contextPath}<spring:eval expression="@config.getProperty('parking')"/>">
                       					<div class="d-flex align-items-center hm-li-marjin">
                       						<span class="nav-link-text ps-1">주차장</span>
                       					</div>
                       				</a>
		  	                    </li>
		                		<!-- 주차장 end -->              		
		                    </ul>
	                  	</li> 	
	                  	
						<!-- 프론트CCTV 카테고리 --> 
						<li class="nav-item">
							<a class="nav-link" href="${pageContext.request.contextPath}<spring:eval expression="@config.getProperty('empFrontCCTV')"/>" role="button">
								<div class="d-flex align-items-center">
									<span class="nav-link-text ps-1">프런트</span>
								</div>
							</a>
						</li> 
	                  	
	                  	
	                </ul>
                	<!-- 호텔관리 카테고리 end -->
					</security:authorize>
						
					<security:authorize access="hasRole('ROLE_POS')">
						
					
                	<!-- 자산관리 카테고리 start -->
                	<a class="nav-link dropdown-indicator" href="#assetManage" role="button"
                  		data-bs-toggle="collapse" aria-expanded="false" aria-controls="hotelManage">
                  		<div class="d-flex align-items-center">
                  			<span class="nav-link-icon"> 
                  				<span class="fas fa-file-alt"></span>
                  			</span>
                  			<span class="nav-link-text ps-1">자산관리</span>
                  		</div>
                	</a>
                	<ul class="nav collapse" id="assetManage">
                		<!-- 회계 start -->
                  		<li class="nav-item">
                  			<a class="nav-link dropdown-indicator" href="#asset" 
                  				data-bs-toggle="collapse" aria-expanded="false" aria-controls="forms">
                      			<div class="d-flex align-items-center hm-li-marjin">
                      				<span class="nav-link-text ps-1">회계</span>
                      			</div>
                   			</a>
							<ul class="nav collapse" id="asset">
								<li class="nav-item">
									<a class="nav-link" href="${pageContext.request.contextPath}<spring:eval expression="@config.getProperty('selling')"/>">
										<div class="d-flex align-items-center hm-li-marjin">
											<span class="nav-link-text ps-1">매출 현황</span>
										</div>
									</a>
								</li>
								<li class="nav-item">
									<a class="nav-link" href="${pageContext.request.contextPath}<spring:eval expression="@config.getProperty('spending')"/>">
										<div class="d-flex align-items-center hm-li-marjin">
											<span class="nav-link-text ps-1">지출 현황</span>
										</div>
									</a>
								</li>
								<li class="nav-item">
									<a class="nav-link" href="${pageContext.request.contextPath}<spring:eval expression="@config.getProperty('refund')"/>">
										<div class="d-flex align-items-center hm-li-marjin">
											<span class="nav-link-text ps-1">환불내역</span>
										</div>
									</a>
								</li>
								
							</ul>
             			</li>
             			<li class="nav-item">
                  			<a class="nav-link dropdown-indicator" href="#paymentmanage" 
                  				data-bs-toggle="collapse" aria-expanded="false" aria-controls="forms">
                      			<div class="d-flex align-items-center hm-li-marjin">
                      				<span class="nav-link-text ps-1">결제 관리</span>
                      			</div>
                   			</a>
                   			<ul class="nav collapse" id="paymentmanage">
                   				<li class="nav-item">
									<a class="nav-link"  href="${pageContext.request.contextPath}<spring:eval expression="@config.getProperty('sanctn')"/>">
										<div class="d-flex align-items-center hm-li-marjin">
											<span class="nav-link-text ps-1">비품구매내역</span>
										</div>
									</a>
								</li>
							</ul>
						</li>
          			  </security:authorize> 
					</ul>
				</li> 
				<!-- 부서별 카테고리 end -->
            </ul>
        </div>
    </div>
</nav>

