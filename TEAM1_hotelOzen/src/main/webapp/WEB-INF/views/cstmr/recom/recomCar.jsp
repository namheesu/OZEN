<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<script defer src="<c:url value='/resources/js/app/cstmr/recomCar.js'/>"></script>
<link href="${pageContext.request.contextPath}/resources/css/cstmr/recom/recomCar.css" rel="stylesheet">

<section>
	<div>
		<div class="recomCar-header mx-10">
			<h1 class="cstmr-title mx-5">추천</h1>
			<p class="cstmr-content mx-5 mb-5">성별&연령대</p>
		</div>
	</div>
	<div class="container recom-table text-center mb-4">
		<div class="btn-group btn-group-lg container text-center" role="group"
			aria-label="...">
			<a href="${pageContext.request.contextPath}/recom/recomCar" class="btn btn-dark btn-outline-dark mb-1 text-white"
				id="recomCar" type="button" style="border-radius: unset;">렌터카추천</a>
			<a href="${pageContext.request.contextPath}/recom/recomSbrs" class="btn btn-outline-dark mb-1" id="recomSbrs"
				type="button" style="border-radius: unset;">부대시설추천</a>
		</div>
	</div>
	<div class="d-flex justify-content-center">
		<div>
			<h5 class="text-center mb-2" >${cstmr.name } 님의 추천 기반데이터</h5>
			<div class="d-flex justify-content-center mb-3">
				<h4 style="margin-right: 30px;">성별 : ${cstmr.gen }</h4>
				<h4>나이 : ${cstmr.bir }세</h4>
			</div>
		</div>
	</div>
<c:forEach items="${recomCarList}" var="recomCar" varStatus="loop">
	<div class="card mb-3 container recom-table">
		<div class="card-header d-flex align-items-center">
			<div class="recom-div">
				<div class="col-auto">
					<div class="card mt-3 mb-3 container">
						<div class="card-header">
							<div class="card-img-top mx-3 col-5">
								<img class="carDdit" alt="배너"
									src="${pageContext.request.contextPath}/resources/assets/img/recomCar/${recomCar.carNo}.jpg">
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="mx-2">
				<table class="table">
					<tr>
						<th>차량명</th>
						<td class="carNm">${recomCar.carNm}</td>
					</tr>
					<tr>
						<th>승차정원</th>
						<td class="carLim">${recomCar.carLim}</td>
					</tr>
					<tr>
						<th>차종</th>
						<td class="carKind">${recomCar.carKind}</td>
					</tr>
					<tr>
						<th>연식</th>
						<td class="carAge">${recomCar.carAge}</td>
					</tr>
				</table>
			</div>

			<c:choose>
				<c:when test="${checkCarList[loop.index] == 1}">
					<div class="wish-area" data-carno="${recomCar.carNo}">
					    <i class="bi bi-heart-fill" id="heartIcon${loop.index}"></i>
					</div>
				</c:when>
				<c:otherwise>
					<div class="wish-area" data-carno="${recomCar.carNo}">
					    <i class="bi bi-heart" id="heartIcon${loop.index}"></i>
					</div>
				</c:otherwise>
			</c:choose>


			
			<script>
			document.addEventListener('DOMContentLoaded', function () {
			    const icon = document.getElementById(`heartIcon${loop.index}`);
			    const carNo = icon.parentElement.dataset.carno;

			    icon.addEventListener('click', function () {
			        if (icon.classList.contains('bi-heart')) {
			            icon.classList.remove('bi-heart');
			            icon.classList.add('bi-heart-fill');
			            var data = {'carNo': carNo};
			            $.ajax({
			                url: "${pageContext.request.contextPath}/recom/insertCar",
			                method: "POST",
			                data: data,
			                dataType: "json",
			                success: function (jsonObj) {
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
			                error: function (jqXHR, txt, status) {
			                    console.log(txt, status, jqXHR);
			                }
			            });
			        } else {
			        	icon.classList.remove('bi-heart-fill');
                    	icon.classList.add('bi-heart');
                    	var data = {'carNo': carNo};
                    	
                    	$.ajax({
                    		url : "${pageContext.request.contextPath}/recom/deleteCar"
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
			        console.log('carNo : ', carNo);
			    });
			});
			</script>

		</div>
	</div>
</c:forEach>
</section>
