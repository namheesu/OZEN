<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<div class="mypage-detail-title">
	관심 리스트
</div>

<div>
	<div class="center mt-5 mb-6">
		<ul class="nav nav-tabs nav-tabs-bordered" role="tablist"
				style="height: 73px;">
			<li class="nav-item" role="presentation">
				<button class="nav-link active" data-bs-toggle="tab"
					data-bs-target="#scrabCarList" aria-selected="true" role="tab">렌트카</button>
			</li>
			<li class="nav-item" role="presentation">
				<button class="nav-link" data-bs-toggle="tab"
					data-bs-target="#scrabSbrsList" aria-selected="true" role="tab">부대시설</button>
			</li>
		</ul>
	</div>
	
	<div class="tab-content pt-2">
		<div id="scrabCarList" class="tab-pane fade active show" role="tabpanel">
			<c:choose>
				<c:when test="${not empty carList }">
					<c:forEach items="${carList }" var="car" varStatus="loop">
						<div class="card-header d-flex align-items-center">
							<div class="recom-div">
								<div class="col-auto">
									<div class="card mt-3 mb-3 container">
										<div class="card-header">
											<div class="card-img-top mx-3 col-5">
												<img class="carDdit" alt="배너" src="${pageContext.request.contextPath}/resources/assets/img/recomCar/${car.carVO.carNo}.jpg">
											</div>
										</div>
									</div>
								</div>
							</div>
							<div class="mx-2">
								<table class="table">
									<tr>
										<th>차량명</th>
										<td class="carNm">${car.carVO.carNm}</td>
									</tr>
									<tr>
										<th>승차정원</th>
										<td class="carLim">${car.carVO.carLim}</td>
									</tr>
									<tr>
										<th>차종</th>
										<td class="carKind">${car.carVO.carKind}</td>
									</tr>
									<tr>
										<th>연식</th>
										<td class="carAge">${car.carVO.carAge}</td>
									</tr>
								</table>
							</div>
						</div>						
					</c:forEach>
				</c:when>
				<c:when test="${empty carList }">
					<ul class="membershipCashList">
                 	 <li class="noData">
                    	  <p class="txt">
                        	  등록된 관심 상품이 없습니다.
                    	  </p>
                	  </li>
             	  </ul>
				</c:when>				
			</c:choose>
		</div>
	</div>
	<div class="tab-content pt-2">
		<div id="scrabSbrsList" class="tab-pane fade" role="tabpanel">
			<c:choose>
				<c:when test="${not empty sbrsList }">
					<c:forEach items="${sbrsList }" var="sbrs" varStatus="loop">
						<div class="card-header d-flex align-items-center">
							<div class="recom-div">
								<div class="col-auto">
									<div class="card mt-3 mb-3 container">
										<div class="card-header">
											<div class="card-img-top col-5">
												<img src="${pageContext.request.contextPath}/resources/assets/img/sbrs/${sbrs.sbrsVO.sbrsCd}.jpg" alt="ben" />
											</div>
										</div>
									</div>
								</div>
							</div>
							
							<div class="mx-3"> ${sbrs.sbrsVO.sbrsDetail }</div>
							
						</div>						
					</c:forEach>
				</c:when>
				<c:when test="${empty sbrsList }">
					<ul class="membershipCashList">
                 	 <li class="noData">
                    	  <p class="txt">
                        	  등록된 관심 상품이 없습니다.
                    	  </p>
                	  </li>
             	  </ul>
				</c:when>				
			</c:choose>
		</div>
	</div>
</div>

