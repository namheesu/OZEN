<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<style>
.max-size {
	max-width: 1000px;
}
</style>
<link
	href="${pageContext.request.contextPath}/resources/css/cstmr/recom/recomtrstspot.css"
	rel="stylesheet">

<section>
	<div>
		<div class="location-header mx-10">
			<h1 class="cstmr-title mx-5">추천</h1>
			<p class="cstmr-content mx-5 mb-5">호텔 오젠 추천</p>
		</div>
	</div>
	<div>
		<table class="table table-bordered max-size container text-center">
			<thead>
				<tr>
					<th>관광지추천</th>
					<th>부대시설추천</th>
					<th class="table-dark">룸서비스추천</th>
				</tr>
			</thead>
		</table>
	</div>
	<div>
		<form>
			<div class="location-header mx-10 ">
				<table class="">
					<tr>
						<th colspan="6">취향</th>
						<th colspan="6">구성원</th>
					</tr>
					<tr>
						<td><button
								class="btn btn-falcon-default rounded-pill me-1 mb-1"
								type="button">간단하게</button></td>
						<td><button
								class="btn btn-falcon-default rounded-pill me-1 mb-1"
								type="button">술과함께</button></td>
						<td><button
								class="btn btn-falcon-default rounded-pill me-1 mb-1"
								type="button">분위기있게</button></td>
						<td><button
								class="btn btn-falcon-default rounded-pill me-1 mb-1"
								type="button">건강하게</button></td>
					
						<td><button
								class="btn btn-falcon-default rounded-pill me-1 mb-1"
								type="button">친구</button></td>
						<td><button
								class="btn btn-falcon-default rounded-pill me-1 mb-1"
								type="button">연인</button></td>
						<td><button
								class="btn btn-falcon-default rounded-pill me-1 mb-1"
								type="button">가족</button></td>
						<td><button
								class="btn btn-falcon-default rounded-pill me-1 mb-1"
								type="button">비즈니스</button></td>
						<td><button
								class="btn btn-falcon-default rounded-pill me-1 mb-1"
								type="button">혼캉스</button></td>
					</tr>
				</table>
			</div>
			<div class="container text-center">
			<button class="btn btn-falcon-default rounded-pill me-1 mb-1"
				type="button">조회</button>
			<button class="btn btn-falcon-default rounded-pill me-1 mb-1"
				type="button">초기화</button>
				</div>

		</form>
	</div>
	</section>