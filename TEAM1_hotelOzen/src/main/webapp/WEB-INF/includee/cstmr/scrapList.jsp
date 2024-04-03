<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security"%>

<link href="${pageContext.request.contextPath}/resources/css/cstmr/scrapList.css" rel="stylesheet">
<script src="https://unpkg.com/feather-icons"></script>

<div class="tab_start">
<img src="${pageContext.request.contextPath}/resources/assets/img/ico_wishlist.png" alt="모달 이미지" id="modalButton" style="cursor: pointer;width : 45px;height : 45px;">
      
<!-- 모달 탭 -->
	<div class="modal" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog modal-dialog-scrollable modal-lg modalBody">
			<div class="modal-content scrapModal">
				<div class="modal-body" style="overflow-y: auto;">
<!-- 탭 내용 -->
					<ul class="nav nav-tabs nav-justified" id="myTabs">
						<li class="nav-item" role="presentation">
							<a class="nav-link active" id="tab1" data-bs-toggle="tab" href="#content1" role="tab">렌트카</a>
						</li>
						<li class="nav-item" role="presentation">
							<a class="nav-link" id="tab2" data-bs-toggle="tab" href="#content2" role="tab">부대시설</a>
						</li>
					</ul>


					<div class="tab-content">

<!-- 렌터카 스크랩 -->
						<security:authorize access="isAuthenticated()">
							<div class="tab-pane fade show active" id="content1" role="tabpanel">
								<c:if test="${not empty carScrapList}">
									<c:forEach items="${carScrapList}" var="scrapCar" varStatus="loop">
	           							<div class="card-header d-flex align-items-center">
	           
											<div class="recom-div">
												<div class="col-auto">
													<div class="card mt-3 mb-3 container">
														<div class="card-header">
															<div class="card-img-top mx-3 col-5">
																<img class="carDdit" alt="배너" src="${pageContext.request.contextPath}/resources/assets/img/recomCar/${scrapCar.carVO.carNo}.jpg">
															</div>
														</div>
													</div>
												</div>
											</div>
											<div class="mx-2">
												<table class="table">
													<tr>
														<th>차량명</th>
														<td class="carNm">${scrapCar.carVO.carNm}</td>
													</tr>
													<tr>
														<th>승차정원</th>
														<td class="carLim">${scrapCar.carVO.carLim}</td>
													</tr>
													<tr>
														<th>차종</th>
														<td class="carKind">${scrapCar.carVO.carKind}</td>
													</tr>
													<tr>
														<th>연식</th>
														<td class="carAge">${scrapCar.carVO.carAge}</td>
													</tr>
												</table>
											</div>
	
											<div class="wish-area" data-carno="${scrapCar.carVO.carNo}">
												<i class="bi bi-heart-fill scrapHeartIcon" id="scrapHeartIcon${loop.index}"></i>
											</div>
	          
										</div>
									</c:forEach>
								</c:if>
								
								<!-- 렌터카 스크랩한 결과 업을경우 -->
								<c:if test="${empty carScrapList}">
									<ul>
										<li class="noData">
											<p class="txt">스크랩 내역이 없습니다.</p>
										</li>
									</ul>
								</c:if>
							</div>
						</security:authorize>
						<security:authorize access="isAnonymous()">
							<div class="tab-pane fade show active" id="content1" role="tabpanel">
								<ul>
									<li class="bi bi-person-circle noLogin" style="color:gray;">
										<p class="noLogin_txt">로그인 후 관심 기능을 사용해보세요.</p>
										<button class="noLogin_login bg-gold" type="button" onclick="scrap_login();">로그인</button>
									</li>
								</ul>
							</div>
						</security:authorize>

<!-- 부대시설 스크랩 -->
						<security:authorize access="isAuthenticated()">
							<div class="tab-pane fade" id="content2" role="tabpanel">
								<c:if test="${not empty sbrsScrapList}">
									<c:forEach items="${sbrsScrapList}" var="scrapSbrs" varStatus="loop">
										<div class="card-header d-flex align-items-center">
											<div class="recom-div">
												<div class="col-auto">
													<div class="card mt-3 mb-3 container">
														<div class="card-header">
															<div class="card-img-top col-5">
																<img src="${pageContext.request.contextPath}/resources/assets/img/sbrs/${scrapSbrs.sbrsVO.sbrsCd}.png" alt="ben" />
															</div>
														</div>
													</div>
												</div>
											</div>
											
											<div class="mx-3"> ${scrapSbrs.sbrsVO.sbrsDetail }</div>
											
											<div class="wish-area" data-sbrscd="${scrapSbrs.sbrsVO.sbrsCd }">
												<i class="bi bi-heart-fill scrapHeartIcon" id="scrapHeartIcon${loop.index}"></i>
											</div>
		          
										</div>
									</c:forEach>
								</c:if> 
								
								<!-- 부대시설 스크랩한 결과 업을경우 -->
								<c:if test="${empty sbrsScrapList}">
									<ul>
				                 	 <li class="noData">
				                    	  <p class="txt">
			                        	  	스크랩 내역이 없습니다.
				                    	  </p>
				                	  </li>
				             	  </ul>
								</c:if>
							</div>
						</security:authorize>
						<security:authorize access="isAnonymous()">
							<div class="tab-pane fade" id="content2" role="tabpanel">
								<ul>
									<li class="bi bi-person-circle noLogin" style="color:gray;">
										<p class="noLogin_txt">로그인 후 관심 기능을 사용해보세요.</p>
										<button class="noLogin_login bg-gold" type="button" onclick="scrap_login();">로그인</button>
									</li>
								</ul>
							</div>
						</security:authorize>
							
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>

	
<script>

feather.replace()

document.getElementById('modalButton').addEventListener('click', function () {
    var myModal = new bootstrap.Modal(document.getElementById('exampleModal'));
    myModal.show();
});

// const icon = document.getElementById(`heartIcon${loop.index}`);
// 모달창에서 스크랩 제거
$(function(){
	$(".scrapHeartIcon").on("click", function(){
		const sbrsCd = this.parentElement.dataset.sbrscd;
		const carNo = this.parentElement.dataset.carno;
		console.log("iconnnnnn :", this);
		console.log("sbrscdddd :", sbrsCd);
		console.log("carNooooo :", carNo);
		
		// 부대시설 스크랩인 경우
		if (sbrsCd) {
			data = {'scrapNo': sbrsCd};
		}
		
		// 렌터카 스크랩인 경우
		if (carNo) {
			data = {'scrapNo': carNo};
		}
		
		$.ajax({
			url: "${pageContext.request.contextPath}/scrap/deleteScrap"
			, method : "POST"
			, data : data
			, dataType : "json"
			, success : function(jsonObj) {
				$(this).addClass('bi-heart');
				Swal.fire({
				    icon: 'success',
				    title: '나의 관심목록에서 삭제 되었습니다.',
				    showCancelButton: false, // 확인 버튼만 표시
				    confirmButtonColor: '#3085d6',
				    confirmButtonText: '확인', // 확인 버튼 텍스트
				}).then((result) => {
				    if (result.isConfirmed) { // 확인 버튼이 클릭된 경우
				        window.location.reload(); // 페이지 새로고침
				    }
				});
			},
			
			error: function(jqXHR, txt, status){
				console.log(txt, status, jqXHR);
			}
		});
	});
});

function scrap_login() {
	location.href = "${pageContext.request.contextPath}/auth/Login.do";
}	
	
	/* icon.addEventListener('click', function() {
		if (icon.classList.contains('bi-heart')) {
			icon.classList.remove('bi-heart-fill');
			icon.classList.add('bi-heart');
			var data = {};
			
			// 부대시설 스크랩인 경우
			if (sbrsCd) {
			data = {'scrapNo': sbrsCd};
			}
			
			// 렌터카 스크랩인 경우
			if (carNo) {
			data = {'scrapNo': carNo};
			}
			
			$.ajax({
				url: "${pageContext.request.contextPath}/scrap/deleteScrap"
				, method : "POST"
				, data : data
				, dataType : "json"
				, success : function(jsonObj) {
					icon.classList.add('bi-heart');
					alert("나의 관심목록에서 삭제되었습니다.");
					
					setTimeout(function() {
						window.location.reload();
					}, 10);
				},
				error: function(jqXHR, txt, status){
					console.log(txt, status, jqXHR);
				}
			});
		});
	}); */


</script>