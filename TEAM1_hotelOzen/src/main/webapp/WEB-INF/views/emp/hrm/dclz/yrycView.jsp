<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form"  prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags"  prefix="spring"%>

<div class="col mb-3">
	<div class="card h-100">
		<div class="card-header">
			<div class="row flex-between-end">
				<nav style="--falcon-breadcrumb-divider: url(&#34;data:image/svg+xml,%3Csvg xmlns='http://www.w3.org/2000/svg' width='8' height='8'%3E%3Cpath d='M2.5 0L1 1.5 3.5 4 1 6.5 2.5 8l4-4-4-4z' fill='%23748194'/%3E%3C/svg%3E&#34;);" aria-label="breadcrumb">
				  <ol class="breadcrumb">
				    <li class="breadcrumb-item"><a href="${pageContext.request.contextPath}/emp">Home</a></li>
				    <li class="breadcrumb-item active" aria-current="page">연차 신청</li>
				  </ol>
				</nav>
			<div class="row-auto">
		</div>
      
    <div>
      <div class="">
      <div>
				<form class="row g-3" id="insertForm" method="post" enctype="multipart/form-data" modelAttribute="${EmpYrycController.MODELNAME }">
<!-- 					<div class="col-md-5"> -->
<!-- 						<label class="form-label" for="basic-form-empNo">사원번호</label> <input -->
<!-- 						name="empNo" -->
<!-- 							class="form-control" id="basic-form-empNo" type="text" -->
<%-- 							placeholder="empNo" value="${newEmpNo }" readOnly/>  --%>
<!-- 					</div>				 -->
					<div class="col-md-5">
						<label class="form-label" for="basic-form-dept">소속</label>
						<select
						name="empDept"
							class="form-select" id="basic-form-dept"
							aria-label="Default select example">
							<option value="" selected="selected">소속 선택</option>
							<option <c:if test="${empUser.empDept eq 'FTO'}">selected</c:if>  value="FTO">프론트오피스</option>
							<option <c:if test="${empUser.empDept eq 'HKP'}">selected</c:if> value="HKP">하우스키핑</option>
							<option <c:if test="${empUser.empDept eq 'FMT'}">selected</c:if> value="FMT">시설관리부</option>
							<option <c:if test="${empUser.empDept eq 'CRM'}">selected</c:if> value="CRM">고객관리부</option>
							<option <c:if test="${empUser.empDept eq 'POS'}">selected</c:if> value="POS">재무부</option>
							<option <c:if test="${empUser.empDept eq 'HRM'}">selected</c:if> value="HRM">인사부</option>
						</select>
					</div>
					
<!-- 					<div class="col-md-5"> -->
<!-- 						<label class="form-label" for="basic-form-empHomeTel">소속</label> <input -->
<!-- 						name="empHomeTel" -->
<!-- 							class="form-control" id="basic-form-empHomeTel" type="text" -->
<!-- 							placeholder="02-123-4567" /> -->
<!-- 					</div> -->
					<div class="col-md-5">
						<label class="form-label" for="basic-form-empHomeTel">직급</label>
						<c:if test="${empUser.empJbgd eq '사원'}">
							<input
							name="empJbgd"
								class="form-control" id="basic-form-empHomeTel" type="text"
								placeholder="사원" value="사원"/>
						</c:if>
						<c:if test="${empUser.empJbgd eq '부장'}">
							<input
							name="empJbgd"
								class="form-control" id="basic-form-empHomeTel" type="text"
								placeholder="부장" value="부장"/>
						</c:if>
					</div>
					<div class="col-md-5">
						<label class="form-label" for="basic-form-empNm">성명</label> <input
						name="empNm"
							class="form-control" id="basic-form-empNm" type="text"
							placeholder="Name" value="${empUser.empNm }" />
					</div>
					<div class="col-md-5">
						<label class="form-label" for="basic-form-empTel">연락처</label> <input
						name="empTel"
							class="form-control" id="basic-form-empTel" type="text"
							placeholder="010-1234-5678" value="${empUser.empTel }" />
					</div>

					<div class="col-md-5">
						<label class="form-label" for="basic-form-dob">신청 시작 기간</label> <input
						name="anlLeaBgnYmd" id="bgnInput"
							class="form-control" id="basic-form-dob" type="date" />
					</div>
					<div class="col-md-5">
						<label class="form-label" for="basic-form-empJncmpYmd">신청 종료기간</label> <input
						name="anlLeaEndYmd" id="endInput"
							class="form-control" id="basic-form-empJncmpYmd" type="date" />
					</div>
					
					<div class="col-md-5">
						<label class="form-label" for="basic-form-empNm">결재권자</label> <input
						name="empRqNo"
							class="form-control" id="basic-form-empNm" type="text"
							 placeholder="Name" value="${empRqVO.empRqNm }" />
					</div>
					<div class="col-md-5">
						<label class="form-label" for="basic-form-textarea">연차 사유</label>
						<textarea 
						name="anlLeaRm" id="anlLeaRm"
						class="form-control" id="basic-form-textarea" rows="3"
							placeholder="Description"></textarea>
					</div>
				</form>
					<button type="reset" class="btn btn-secondary">취소</button>
					<button id="insertBtn" type="button" class="btn btn-primary" onclick="fnInsert()">신청</button>
			</div>
      </div>
    </div>
		</div>
	</div>
</div>
</div>

<script>
const cPath = document.body.dataset.contextPath;

document.addEventListener("DOMContentLoaded", ()=> {
	setTodayDate();
});

function getTodayDate() {
    const now = new Date();
    const year = now.getFullYear();
    let month = (now.getMonth() + 1).toString().padStart(2, '0'); 
    let day = now.getDate().toString().padStart(2, '0');
    return year + "-" + month + "-" + day;
}


function setTodayDate() {
    const bgnInput = document.getElementById('bgnInput');
    const endInput = document.getElementById('endInput');
    const todayDate = getTodayDate();
    //console.log(todayDate);
    bgnInput.value = todayDate; 
    endInput.value = todayDate; 
}


function fnInsert() {
// 	var empRq =document.querySelector('input[name=empRqNo]').value;
// 	empRq = '${empRqVO.empRqNo}';
	
	var form = document.querySelector('#insertForm');
	var empRqInput = form.querySelector('input[name=empRqNo]');
	empRqInput.value = '${empRqVO.empRqNo}';
	console.log(form);
	
	var anlLeaRm = form.querySelector('#anlLeaRm');
	console.log(anlLeaRm);
	if(anlLeaRm.value === "") {
		anlLeaRm.value  = " ";
	}
	console.log(anlLeaRm);
	
// 	var data = new FormData(form);
	var data = $(form).serialize();
	//data = JSON.parse(form);
	console.log(data);
	
	$.ajax({
		type: 'post'
		, url : cPath+'/emp/pbl/dclz/yryc/insert.do'
		, data : data
		, dataType : 'json'
		, success: function(jsonObj){
			console.log(jsonObj);
			Swal.fire({
				title: '연차 신청 성공했습니다!'
				, icon:"success"
			}).then(result=> {
				location.replace(cPath+"/emp/pbl/oprtnstts/oprtnsttsList.do");
			});
		}
		, error:function(){  
	            //에러가 났을 경우 실행시킬 코드
		}
	});
}


</script>
