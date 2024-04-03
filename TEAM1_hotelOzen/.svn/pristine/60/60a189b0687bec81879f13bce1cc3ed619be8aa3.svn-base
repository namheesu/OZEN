<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>


<link
	href="${pageContext.request.contextPath}/resources/css/cstmr/intrcn/floormap/floormap.css"
	rel="stylesheet">

<section>
	<div>
		<div class="faq-header mx-10">
			<h1 class="cstmr-title mx-5">층별안내도</h1>
			<p class="cstmr-content mx-5 mb-5">호텔 오젠의 층별안내도</p>
		</div>
	</div>
	<div class="d-flex" style="justify-content: center; margin-left: 100px;">
		<div class="d-flex" style="width: 1200px; justify-content: center;">
			<div class="floor-title" id="floor-title">
				<ul id="floorList">
					<li value="15">15층</li>
					<li value="514">5~14층</li>
					<li value="4">4층</li>
					<li value="3">3층</li>
					<li value="2">2층</li>
					<li value="1">1층</li>
					<li value="0">B1층</li>
				</ul>
			</div>
			<div class="floor-box" id="for-15">
				<div class="d-flex">
					<h2 class="floor">15층</h2>
					<h4 class="floor-ex">LoopTop</h4>
				</div>
				<div>
					<div>
						<h5>휴게시설</h5>
					</div>
					<div>
						<table class="floor-table">
							<tr class="d-flex">
								<td class="table-td">루프탑</td>
								<td class="table-td table-sec">이그제큐티브 클럽 라운지</td>
							</tr>
						</table>
					</div>
				</div>
			</div>
			<div class="floor-box display-no" id="for-514">
				<div class="d-flex">
					<h2 class="floor">5 ~ 14층</h2>
					<h4 class="floor-ex">Guest Room</h4>
				</div>
				<div>
					<div>
						<h5>객실</h5>
					</div>
					<div>
						<table class="floor-table">
							<tr class="d-flex">
								<td class="table-td">객실</td>
								<td class="table-td table-sec"></td>
							</tr>
						</table>
					</div>
				</div>
			</div>
			<div class="floor-box display-no" id="for-4">
				<div class="d-flex">
					<h2 class="floor">4층</h2>
					<h4 class="floor-ex">4F</h4>
				</div>
				<div>
					<div>
						<h5>4층</h5>
					</div>
					<div>
						<table class="floor-table">
							<tr class="d-flex">
								<td class="table-td">스타벅스</td>
								<td class="table-td table-sec">북카페</td>
							</tr>
							<tr class="d-flex">
								<td class="table-td">아케이드센터</td>
								<td class="table-td table-sec">실내골프장</td>
							</tr>
						</table>
					</div>
				</div>
			</div>
			<div class="floor-box display-no" id="for-3">
				<div class="d-flex">
					<h2 class="floor">3층</h2>
					<h4 class="floor-ex">3F</h4>
				</div>
				<div>
					<div>
						<h5>3층</h5>
					</div>
					<div>
						<table class="floor-table">
							<tr class="d-flex">
								<td class="table-td">수영장</td>
								<td class="table-td table-sec">헬스장</td>
							</tr>
						</table>
					</div>
				</div>
			</div>
			<div class="floor-box display-no" id="for-2">
				<div class="d-flex">
					<h2 class="floor">2층</h2>
					<h4 class="floor-ex">Lobby</h4>
				</div>
				<div>
					<div>
						<h5>로비</h5>
					</div>
					<div>
						<table class="floor-table">
							<tr class="d-flex">
								<td class="table-td">프론트 데스크</td>
								<td class="table-td table-sec">나킨스 게이트 와인 & 다인</td>
							</tr>
							<tr class="d-flex">
								<td class="table-td">라운지 & 바</td>
								<td class="table-td table-sec">대연회장</td>
							</tr>
							<tr class="d-flex">
								<td class="table-td">비즈니스 센터</td>
								<td class="table-td table-sec"></td>
							</tr>
						</table>
					</div>
				</div>
			</div>
			<div class="floor-box display-no" id="for-1">
				<div class="d-flex">
					<h2 class="floor">1층</h2>
					<h4 class="floor-ex">Lower Lobby</h4>
				</div>
				<div>
					<div>
						<h5>로어 로비</h5>
					</div>
					<div>
						<table class="floor-table">
							<tr class="d-flex">
								<td class="table-td">마리아 뷔페 레스토랑</td>
								<td class="table-td table-sec">홍연 중식당</td>
							</tr>
							<tr class="d-flex">
								<td class="table-td">오젠 베이커리숍</td>
								<td class="table-td table-sec">오젠 플라워 숍</td>
							</tr>
							<tr class="d-flex">
								<td class="table-td">이탈리안 레스토랑</td>
								<td class="table-td table-sec"></td>
							</tr>
						</table>
					</div>
				</div>
			</div>
			<div class="floor-box display-no" id="for-0">
				<div class="d-flex">
					<h2 class="floor">B1층</h2>
					<h4 class="floor-ex">Parking</h4>
				</div>
				<div>
					<div>
						<h5>주차장</h5>
					</div>
					<div>
						<table class="floor-table">
							<tr class="d-flex">
								<td class="table-td">주차장</td>
								<td class="table-td table-sec"></td>
							</tr>
						</table>
					</div>
				</div>
			</div>

		</div>
	</div>
</section>
<script defer src="<c:url value="/resources/js/app/cstmr/intrcn/floormap/floormap.js"/>"></script>