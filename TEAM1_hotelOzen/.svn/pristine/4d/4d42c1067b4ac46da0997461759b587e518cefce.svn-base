<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form"  prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags"  prefix="spring"%>

		<div class="card mb-3">
		<div class="card h-100">
			<div class="card-header">
				<nav style="--falcon-breadcrumb-divider: url(&#34;data:image/svg+xml,%3Csvg xmlns='http://www.w3.org/2000/svg' width='8' height='8'%3E%3Cpath d='M2.5 0L1 1.5 3.5 4 1 6.5 2.5 8l4-4-4-4z' fill='%23748194'/%3E%3C/svg%3E&#34;);" aria-label="breadcrumb">
				  <ol class="breadcrumb">
				    <li class="breadcrumb-item"><a href="${pageContext.request.contextPath}/emp/index.do">Home</a></li>
				    <li class="breadcrumb-item">인사관리</li>
				    <li class="breadcrumb-item active" aria-current="page">신규직원생성</li>
				  </ol>
				</nav>
            <div class="card-body position-relative">
            
              <div class="row">
                <div class="col-lg-8">
                  <h3>신규 계정 일괄 등록</h3>
                  <p>신입 직원 정보를 엑셀로 정리해서 등록해 보세요. 빠른 계정 생성이 가능합니다.</p>
                  
                  
                  <div class="mb-3">
                  		<form id="insertEmpsForm" method="POST" enctype="multipart/form-data" action="/emp/hrm/emply/insertEmps">
							<input name="file" class="form-control" type="file" />
						</form>
					</div>
                </div>
              </div>
				<div class="d-flex mb-3 flex-row-reverse">
					<button id="insertEmpsBtn" class="btn btn-primary" type="button">일괄 등록</button>
				</div>
            </div>
          </div>
          </div>
          </div>
          
<!--           아코디언 -->
<div class="accordion" id="accordionExample">
  <div class="accordion-item">
    <h2 class="accordion-header" id="heading2">
    
    
      
      <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#collapse2" aria-expanded="true" aria-controls="collapse2">
      
  
		<div class="row-auto">
			<div class="col-auto">
				<h3>신규 계정 개별 등록</h3>
				<p>신입 직원 정보를 개별적으로 작성해 보세요.</p>
			</div>
		</div>
      </button>
    </h2>
    <div class="accordion-collapse collapse" id="collapse2" aria-labelledby="heading2" data-bs-parent="#accordionExample">
      <div class="accordion-body">

      
      <div class="tab-pane preview-tab-pane active" role="tabpanel"
				aria-labelledby="tab-dom-160a4566-7e94-45a2-bf04-b36ef49d954f"
				id="dom-160a4566-7e94-45a2-bf04-b36ef49d954f">
				<form class="row g-3" id="insertForm" method="post" enctype="multipart/form-data" modelAttribute="${HrmEmpInsertController.MODELNAME }">
				
					<div class="col-md-5">
						<label class="form-label" for="basic-form-empNo">사원번호</label> <input
						name="empNo"
							class="form-control" id="basic-form-empNo" type="text"
							placeholder="empNo" value="${newEmpNo }" readOnly/> 
					</div>
					<div class="col-md-5">
						<label class="form-label" for="basic-form-password">비밀번호<span >(초기 비밀번호는 자동으로 사번이 부여됩니다.)</span></label> <input
						name="empPw"
							class="form-control" id="basic-form-password" type="password"
							placeholder="Password" value="${newEmpNo }"/>
					</div>
				
					<div class="col-md-5">
						<label class="form-label" for="basic-form-empNm">사원명</label> <input
						name="empNm"
							class="form-control" id="basic-form-empNm" type="text"
							placeholder="Name" />
					</div>
					<div class="col-md-5">
						<label class="form-label" for="basic-form-empTel">전화번호</label> <input
						name="empTel"
							class="form-control" id="basic-form-empTel" type="text"
							placeholder="010-1234-5678" />
					</div>
					<div class="col-md-5">
						<label class="form-label" for="basic-form-empHomeTel">자택 전화번호</label> <input
						name="empHomeTel"
							class="form-control" id="basic-form-empHomeTel" type="text"
							placeholder="02-123-4567" />
					</div>
					<div class="col-md-5">
						<label class="form-label" for="basic-form-empAddr">주소</label> <input
						name="empAddr"
							class="form-control" id="basic-form-empAddr" type="text"
							placeholder="address" />
					</div>
					<div class="col-md-5">
						<label class="form-label" for="basic-form-email">이메일</label> <input
						name="empEml"
							class="form-control" id="basic-form-email" type="text"
							placeholder="name@example.com" />
					</div>
					<div class="col-md-5">
						<label class="form-label" for="basic-form-dob">생년월일</label> <input
						name="empBirth"
							class="form-control" id="basic-form-dob" type="date" />
					</div>
					<div class="col-md-5">
						<label class="form-label" for="basic-form-empJncmpYmd">입사일</label> <input
						name="empJncmpYmd"
							class="form-control" id="basic-form-empJncmpYmd" type="date" />
					</div>
					<div class="col-md-5">
						<label class="form-label" for="basic-form-dept">부서</label> <select id="my-select"
						name="empDept"
							class="form-select" id="basic-form-dept"
							aria-label="Default select example">
							<option selected="selected">부서 선택</option>
							<option value="FTO">프론트오피스</option>
							<option value="HKP">하우스키핑</option>
							<option value="FMT">시설관리부</option>
							<option value="CRM">고객관리부</option>
							<option value="POS">재무부</option>
							<option value="HRM">인사부</option>
						</select>
					</div>
					<div class="col-md-5">
						<div class="form-check form-check-inline">
							<input class="form-check-input" id="flexRadioDefault1"
								type="radio" name="empJbgd" checked="checked" value="STF"/><label
								class="form-check-label mb-0" for="flexRadioDefault1">STF</label>
						</div>
						<div class="form-check form-check-inline">
							<input class="form-check-input" id="flexRadioDefault2"
								type="radio" name="empJbgd"  value="DPM"/><label
								class="form-check-label mb-0" for="flexRadioDefault2">DPM</label>
						</div>
					</div>
<!-- 					<div class="mb-3"> -->
<!-- 						<label class="form-label">프로필 사진 등록</label> <input -->
<!-- 						name="empProflNm" -->
<!-- 							class="form-control" type="file" /> -->
<!-- 					</div> -->
<!-- 					<div class="mb-3"> -->
<!-- 						<label class="form-label" for="basic-form-textarea">기타사항</label> -->
<!-- 						<textarea class="form-control" id="basic-form-textarea" rows="3" -->
<!-- 							placeholder="Description"></textarea> -->
<!-- 					</div> -->
				</form>
					<button type="reset" class="btn btn-secondary">취소</button>
					<button id="insertBtn" type="button" class="btn btn-primary" onclick="fnInsert()">제출</button>
			</div>
      </div>
    </div>
  </div>
<!--   <button onclick="fnAuto()">자동완성</button> -->
</div>  


<script>
const cPath = document.body.dataset.contextPath;


function fnAuto() {
	$('input[name=empNm]').val('세종대왕');
	$('input[name=empTel]').val('010-9876-1245');
	$('input[name=empHomeTel]').val('042-688-7885');
	$('input[name=empAddr]').val('대전광역시 중구 계룡로 846');
	$('input[name=empEml]').val('tpwhd@gmail.com');
	$('input[name=empBirth]').val('1397-05-15');
	$('input[name=empJncmpYmd]').val('2024-04-01');
	$('#my-select').val('FTO');
	
	
	
}




$(function(){
    $('#insertEmpsBtn').on('click', function(){
        insertEmps();
    });
});


//일괄 등록
function insertEmps(){
	    var form = $('#insertEmpsForm')[0];
	    var formData = new FormData(form);
		var url = cPath+'/emp/hrm/emply/insertEmps';
		console.log(url);
	    $.ajax({
	        url : url
	        , method : form.method
	        , data : formData
			, dataType : "json"
	        , contentType : false
	        , processData : false    
			, success:function(jsonObj){
				console.log("jsonObj---------",jsonObj);
				Swal.fire({
					title:`총 \${jsonObj.cnt} 명 등록 성공했습니다!`
					, icon:"success"
				}).then(result=> {
					location.replace(cPath+"/emp/pbl/emply");
				})
				
				
				//location.href = cPath+"/emp/hrm/empnotice/"+jsonObj.empNt.empNtNo;
			}, error : function(jqXHR, txt, status){
				console.log(txt, status, jqXHR);
			}
		}).done(function(data){
			callback(data);
		});    
	    
}

//개별등록
function fnInsert(){
	let form = document.getElementById("insertForm");
	let url = form.action;
	let method = form.method;

	//tinyMCE.triggerSave();
	//let data = $(form).serialize(); //직렬화하면 파일은 그냥 이름만 가게 되는..??  formData를 써야 한다.
	//form.submit();
	
// 	let data = formToObject(form);
// 	console.log("data", data);
	
// 	let body = JSON.stringify(data); 
// 	console.log("body", body);
	
	let formData = new FormData(form);
	console.log("formData",formData);
	
	$.ajax({
		url:url
		, method:method
		, data : formData
		, dataType : "json"
		, contentType: false
		, processData: false
		, success:function(jsonObj){
			console.log("jsonObj---------",jsonObj);
			jsonObj.empNm
			jsonObj.empNo
        	Swal.fire({
				title:`사원번호: \${jsonObj.hrmEmp.empNo}<br>성명: \${jsonObj.hrmEmp.empNm}<br> 등록 성공했습니다!`
				, icon:"success"
			}).then(result=> {
				location.replace(cPath+"/emp/pbl/emply");
			});
			
			//location.href = cPath+"/emp/hrm/empnotice/"+jsonObj.empNt.empNtNo;
		}, error : function(jqXHR, txt, status){
			console.log(txt, status, jqXHR);
		}
	}).done(()=>{
		form.page.value="";
	});
}


const formToObject = (form)=>{
	let data = {};
	let formData = new FormData(form);
	for(let n of formData.keys()){
		data[n] = formData.get(n);
	}
	return data;
};
</script>

