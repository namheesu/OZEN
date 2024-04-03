<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form"  prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags"  prefix="spring"%>

<link href="${pageContext.request.contextPath}/resources/css/cstmr/intrcn/sbrsliar/sbrsLiarList.css" rel="stylesheet">

<section>
	<div>
		<div class="location-header mx-10">
			<h1 class="cstmr-title mx-5">FACILITIES</h1>
			<p class="cstmr-content mx-5 mb-5">더 유용한 라이프스타일을 맞춘 최상의 품격으로 호텔 내 부대시설을 이용하실 수 있습니다.</p>
		</div>
	</div>
<div style="display:flex; justify-content: center;">
<div class="sbrsLiar_main text-center mb-5">
	
	<c:forEach items="${sbrsLiarList }" var="sbrsLiar" varStatus="st">

		<c:if test="${st.count mod 2 == 1}">
			<c:set var="location" value="Left"/>
			<div class="sbrs_wrap">
				<div class="row sbrs_inner d-flex">
		</c:if>
		<c:if test="${st.count mod 2 == 0}">
			<c:set var="location" value="Right"/>
		</c:if>
	
		<!-- 왼쪽 -->
		<div class="col-md-6 main_<c:out value="${location}"/>">
			<div class="sbrsImg <c:out value="${location}"/>">
				<div class="sbrsImginner">
					<div id="carouselExampleIndicators<c:out value="${location}"/>${st.count}" class="carousel slide" data-bs-interval="false">
					<div class="carousel-indicators">
						  <button type="button" data-bs-target="#carouselExampleIndicators<c:out value="${location}"/>${st.count}" data-bs-slide-to="0" class="active" aria-current="true" aria-label="Slide 1"></button>
						  <button type="button" data-bs-target="#carouselExampleIndicators<c:out value="${location}"/>${st.count}" data-bs-slide-to="1" aria-label="Slide 2"></button>
					</div>
					<div class="carousel-inner">
						<c:forEach var="i" begin="1" end="2" varStatus="carouselStatus">
							<c:choose>
						        <c:when test="${carouselStatus.first}">
						            <div class="carousel-item active">
						        </c:when>
						        <c:otherwise>
						            <div class="carousel-item">
						        </c:otherwise>
						    </c:choose>
						        <img src="${pageContext.request.contextPath}/resources/assets/img/sbrsLiar/${sbrsLiar.sbrsEn}${i}.png" class="d-block sbrsImg" alt="one">
						    </div>
						</c:forEach>
					</div>
					<button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleIndicators<c:out value="${location}"/>${st.count}" data-bs-slide="prev">
						<span class="carousel-control-prev-icon" aria-hidden="true"></span>
						<span class="visually-hidden">Previous</span>
					</button>
					<button class="carousel-control-next" type="button" data-bs-target="#carouselExampleIndicators<c:out value="${location}"/>${st.count}" data-bs-slide="next">
						    <span class="carousel-control-next-icon" aria-hidden="true"></span>
						    <span class="visually-hidden">Next</span>
			  			</button>
					</div>
				</div>
			</div>
			<div class="sbrsTitle mt-3">
				<div class="row">
					<div class="col">
						<div class="sbrsList_content">
							<div class="sbrsList_inner" style="text-align: left;">
								<span class="sbrsList_inner-en">${sbrsLiar.sbrsEn }</span>
								<span class="sbrsList_inner-floor">${sbrsLiar.sbrsFloor }F</span>
							</div>
							<h2 class="sbrsList_title">
								<span class="sbrsList_ko">${sbrsLiar.sbrsNm }</span>
							</h2>
						</div>
					</div>
					<div class="col" style="padding-right: 10px;">
						<div class="sbrsList_time" style="text-align: right;">
							<span class="sbrsLiar_inner-time">${sbrsLiar.sbrsUtlztDt }</span>
						</div>
					</div>
				</div>
			</div>
		</div>
	
	
	
	<!-- 오른쪽 -->
	
	<!-- 				<div class="main_right"> -->
	<!-- 					<div class="sbrsImg right"> -->
	<!-- 						<div class="sbrsImginner"> -->
	<!-- 							<div id="carouselExampleIndicatorsRight" class="carousel slide" data-bs-interval="false"> -->
	<!-- 								<div class="carousel-indicators"> -->
	<!-- 									  <button type="button" data-bs-target="#carouselExampleIndicatorsRight" data-bs-slide-to="0" class="active" aria-current="true" aria-label="Slide 1"></button> -->
	<!-- 									  <button type="button" data-bs-target="#carouselExampleIndicatorsRight" data-bs-slide-to="1" aria-label="Slide 2"></button> -->
	<!-- 									  <button type="button" data-bs-target="#carouselExampleIndicatorsRight" data-bs-slide-to="2" aria-label="Slide 3"></button> -->
	<!-- 								</div> -->
	<!-- 								<div class="carousel-inner"> -->
	<!-- 									<div class="carousel-item active"> -->
	<%-- 										<img src="${pageContext.request.contextPath}/resources/assets/img/sbrsLiar/SNOW ADVENTURE2.png" class="d-block sbrsImg" alt="one"> --%>
	<!-- 									</div> -->
	<!-- 									<div class="carousel-item"> -->
	<%-- 									 	<img src="${pageContext.request.contextPath}/resources/assets/img/sbrsLiar/SNOW ADVENTURE2.png" class="d-block sbrsImg" alt="two"> --%>
	<!-- 									</div> -->
	<!-- 									<div class="carousel-item"> -->
	<%-- 									  	<img src="${pageContext.request.contextPath}/resources/assets/img/sbrsLiar/SNOW ADVENTURE2.png" class="d-block sbrsImg" alt="three"> --%>
	<!-- 									</div> -->
	<!-- 								</div> -->
	<!-- 								<button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleIndicatorsRight" data-bs-slide="prev"> -->
	<!-- 									<span class="carousel-control-prev-icon" aria-hidden="true"></span> -->
	<!-- 									<span class="visually-hidden">Previous</span> -->
	<!-- 								</button> -->
	<!-- 								<button class="carousel-control-next" type="button" data-bs-target="#carouselExampleIndicatorsRight" data-bs-slide="next"> -->
	<!-- 								    <span class="carousel-control-next-icon" aria-hidden="true"></span> -->
	<!-- 								    <span class="visually-hidden">Next</span> -->
	<!-- 					  			</button> -->
	<!-- 							</div> -->
	<!-- 						</div> -->
	<!-- 					</div> -->
	<!-- 					<div class="sbrsTitle"> -->
	<!-- 						<div class="sbrsList_content"> -->
	<!-- 							<div class="sbrsList_inner"> -->
	<!-- 								<span class="sbrsList_inner-en">CAFE</span> -->
	<!-- 								<span class="sbrsList_inner-floor">1F</span> -->
	<!-- 							</div> -->
	<!-- 							<h2 class="sbrsList_title"> -->
	<!-- 								<span class="sbrsList_ko">카페</span> -->
	<!-- 							</h2> -->
	<!-- 						</div> -->
	<!-- 						<div class="sbrsList_time"> -->
	<!-- 							<span class="sbrsLiar_inner-time">09:00-21:00</span> -->
	<!-- 						</div> -->
	<!-- 					</div> -->
	<!-- 				</div> -->
	
		<c:if test="${st.count mod 2 == 0}">
				</div>
			</div>
		</c:if>	
	
	</c:forEach>
		<div>
</div>
</section>
	
    
    