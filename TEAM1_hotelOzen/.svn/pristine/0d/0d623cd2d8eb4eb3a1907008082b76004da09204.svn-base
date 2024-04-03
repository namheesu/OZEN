<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<link href="${pageContext.request.contextPath}/resources/css/cstmr/recom/recomSbrs.css" rel="stylesheet">


<section>
	<div>
		<div class="location-header mx-10">
			<h1 class="cstmr-title mx-5">추천</h1>
			<p class="cstmr-content mx-5 mb-5">시즌 & 연령대 & MBTI</p>
		</div>
	</div>
	<div class="container recom-table text-center mb-4">
		<div class="btn-group btn-group-lg container text-center" role="group" aria-label="...">
			<a href="${pageContext.request.contextPath}/recom/recomCar" class="btn btn-outline-dark mb-1 " id="recomCar" type="button" style="border-radius: unset;">렌터카추천</a>
			<a href="${pageContext.request.contextPath}/recom/recomSbrs" class="btn btn-outline-dark mb-1 btn-dark text-white" id="recomSbrs" type="button" style="border-radius: unset;">부대시설추천</a>
		</div>
	</div>
	
	<div class="d-flex justify-content-center">
		<div>
			<h5 class="text-center mb-2" >${sbrsCstmr.nameSbrs } 님의 추천 기반데이터</h5>
			<div class="d-flex justify-content-center mb-3">
				<h4 style="margin-right: 30px;">계절 : ${sbrsCstmr.seasonSbrs }</h4>
				<h4 style="margin-right: 30px;">나이 : ${sbrsCstmr.ageSbrs }세</h4>
				<h4>MBTI : ${sbrsCstmr.mbtiSbrs }</h4>
			</div>
		</div>
	</div>
	
	
	<c:forEach items="${recomSbrsList}" var="recomSbrs" varStatus="loop">
		<div class="card mb-3 container recom-table">
			<div class="card-header d-flex align-items-center">
			
				<div class="recom-div">
					<div class="col-auto">
						<div class="card mt-3 mb-3 container">
							<div class="card-header">
								<div class="card-img-top col-5">
									<img src="${pageContext.request.contextPath}/resources/assets/img/sbrs/${recomSbrs.sbrsCd }.png" alt="ben" />
								</div>
							</div>
						</div>
					</div>
				</div>
				<div class="mx-3">
					${recomSbrs.sbrsDetail }
				</div>
				
				
				<c:choose>
					<c:when test="${checkSbrsList[loop.index] == 1 }">
						<div class="wish-area" data-sbrscd="${recomSbrs.sbrsCd }">
							<i class="bi bi-heart-fill" id="heartIcon${loop.index}"></i>
						</div>
					</c:when>
					<c:otherwise>
						<div class="wish-area" data-sbrscd="${recomSbrs.sbrsCd }">
							<i class="bi bi-heart" id="heartIcon${loop.index}"></i>
						</div>
					</c:otherwise>
				</c:choose>
	
	
<script>

document.addEventListener('DOMContentLoaded', function () {
	const icon = document.getElementById(`heartIcon${loop.index}`);
	const sbrsCd = icon.parentElement.dataset.sbrscd;
	
	
	
	
	icon.addEventListener('click', function() {
		if (icon.classList.contains('bi-heart')) {
			icon.classList.remove('bi-heart');
			icon.classList.add('bi-heart-fill');
			var data = {'sbrsCd': sbrsCd};
			console.log('sbrsCdddd', sbrsCd);
			$.ajax({
				url: "${pageContext.request.contextPath}/recom/insertSbrs",
				method: "POST",
				data: data,
				dataType: "json",
				success: function(jsonObj){
					icon.classList.add('bi-heart-fill');
					Swal.fire({
						icon: 'success',
						title: '나의 관심목록에 추가되었습니다.',
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
		} else {
			icon.classList.remove('bi-heart-fill');
			icon.classList.add('bi-heart');
			var data = {'sbrsCd': sbrsCd};
			
			$.ajax({
				url: "${pageContext.request.contextPath}/recom/deleteSbrs"
				, method : "POST"
				, data : data
				, dataType : "json"
				, success : function(jsonObj) {
					icon.classList.add('bi-heart');
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
		}
		console.log('sbrsCd : ', sbrsCd);
	});
});
</script>
	            
			</div>
		</div>
	</c:forEach>
	
<script>
document.addEventListener('DOMContentLoaded', function () {
	const mbtiValue = "${sbrsCstmr.mbtiSbrs}";

    if (mbtiValue === "null" || mbtiValue === "") {
    	Swal.fire({
   		   title: 'MBTI을 입력해주세요',
   		   text: '추천을 원하시면 마이페이지에서 MBTI를 추가해주세요',
   		   icon: 'warning',
   		   
   		   showCancelButton: true, // cancel버튼 보이기. 기본은 원래 없음
   		   confirmButtonColor: '#3085d6', // confrim 버튼 색깔 지정
   		   cancelButtonColor: '#d33', // cancel 버튼 색깔 지정
   		   confirmButtonText: '이동', // confirm 버튼 텍스트 지정
   		   cancelButtonText: '취소', // cancel 버튼 텍스트 지정
   		   
   		   reverseButtons: true, // 버튼 순서 거꾸로
   		   
   		}).then(result => {
   		   // 만약 Promise리턴을 받으면,
   		   if (result.isConfirmed) { // 만약 모달창에서 confirm 버튼을 눌렀다면
				window.location.href = "${pageContext.request.contextPath}/myinfo/mypage.do"; // 페이지 이동
   		   } else if (result.dismiss === Swal.DismissReason.cancel) {
   				window.location.href = "${pageContext.request.contextPath}/recom/recomCar"; // 페이지 이동
   		   }
   		});
    }
});

</script>	
</section>
