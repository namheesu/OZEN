<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="security"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/cstmr/header.css" />

<div class="total-header fixed-top bg-white" style="box-shadow: 0px 2px 7px rgb(0,0,0,0.3);">
	<div class="logo_start">
		<a class="logo" href="${pageContext.request.contextPath}"> <img
			src="${pageContext.request.contextPath}/resources/assets/img/generic/hotelozen.png"
			alt="Logo" class="d-inline-block align-text-top">
		</a>
	</div>

	<div
		class="tnb py-2 d-flex flex-row-reverse collapse navbar-collapse px-5">
		<div class="reser-check">
			<a class="nav-link"
				href="${pageContext.request.contextPath}/cstmr/rsvt/rsvtList"> <span>예약조회</span>
			</a>
		</div>
		<security:authorize access="isAnonymous()">
			<div class="login">
				<a class="nav-link"
					href="${pageContext.request.contextPath}/auth/Login.do"> <span>로그인</span>
				</a>
			</div>
			<div class="join">
				<a class="nav-link"
					href="${pageContext.request.contextPath}/auth/join/terms.do"> <span>회원가입</span>
				</a>
			</div>
		</security:authorize>
		<security:authorize access="isAuthenticated()">
			<div class="logout">
				<form:form id="logoutForm" method="post"
					action="${pageContext.request.contextPath }/logout">
					<a class="nav-link" href="#" id="logoutATag"> <span>로그아웃</span>
					</a>
				</form:form>
			</div>
			<div class="mypage">
				<a class="nav-link"
					href="${pageContext.request.contextPath}/myinfo/mypage.do"> <span>마이페이지</span>
				</a>
			</div>
		</security:authorize>
		<div class="membership">
			<a class="nav-link" href="${pageContext.request.contextPath}/mbrsh">
				<span>멤버십</span>
			</a>
		</div>
	</div>




	<!--  -->
	<header id="top_layout" class="clearfix">
		<nav class="main-layout navbar clearfix w100">
			<div id="gnb">
				<div class="container-fluid menuStart w100 d-flex">

					<div class="gnb_inner d-flex">
						<ul class="navi clearfix menuNavi">
							<li class="navi_layout-accom">
								<p>Accommodation</p>
								<ul class="sub01">
									<li><a
										href="${pageContext.request.contextPath}/room/standard.do">STANDARD</a></li>
									<li><a
										href="${pageContext.request.contextPath}/room/deluxe.do">DELUXE</a></li>
									<li><a
										href="${pageContext.request.contextPath}/room/suite.do">SUITE</a></li>
									<li><a
										href="${pageContext.request.contextPath}/room/special.do">SPECIAL</a></li>
								</ul>
							</li>
							<li class="navi_layout-comm">
								<p>Community</p>
								<ul class="sub01">
									<li><a
										href="${pageContext.request.contextPath}/comm/notice/noticeList.do">공지사항</a></li>
									<li><a href="${pageContext.request.contextPath}/comm/FAQ">FAQ</a></li>
								</ul>
							</li>
							<li class="navi_layout-about">
								<p>About us</p>
								<ul class="sub01">
									<li><a href="${pageContext.request.contextPath}/intrcn/sbrsLiar">부대시설</a></li>
									<li><a href="${pageContext.request.contextPath}/intrcn/trstspot.do">관광지</a></li>
									<li><a href="${pageContext.request.contextPath}/intrcn/location">오시는길</a></li>
									<li><a href="${pageContext.request.contextPath}/intrcn/floormap.do">층별안내도</a></li>
								</ul>
							</li>
							<li class="navi_layout-recom"><a
								href="${pageContext.request.contextPath}/recom/recomCar">Recommendation</a>
							</li>
						</ul>
					</div>
					<!-- 날씨 -->
					<div class="weather">
						<div class="weather_inline">
							<!-- icon1=맑음 // icon2=구름 icon3=흐림 icon4=비 icon5=눈 icon6=천둥 -->
							<div class="weather_box d-flex">
								<span class="Jejutemp mx-3"></span>
								<span class="Jejudust mx-3">미세먼지</span>
								<i class="JejuIcon"></i>
							</div>
						</div>
					</div>
				</div>
			</div>
		</nav>
	</header>
</div>

<script src="<c:url value='/resources/js/app/cstmr/layout/header.js'/>"></script>