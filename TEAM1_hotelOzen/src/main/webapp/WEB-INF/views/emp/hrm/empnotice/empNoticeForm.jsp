<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form"  prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags"  prefix="spring"%>

<link href="${pageContext.request.contextPath }/resources/vendors/flatpickr/flatpickr.min.css" rel="stylesheet" />

<div class="container" >
<div class="card mb-3" id="getThis" data-div-before="before">
	<div class="card-header">
		<h5 class="mb-0">직원 공지사항 작성</h5>
	</div>
	<div class="card-body bg-light">
		<form class="needs-validation" id="insertForm" method="post" enctype="multipart/form-data" modelAttribute="${HrmEmpNoticeController.MODELNAME }" novalidate>
			<div class="row gx-2">
				<div class="col-sm-6 mb-3">
					<label class="form-label" for="emp-nt-nm">제목</label> <input name="empNtNm"
						class="form-control" id="emp-nt-nm" type="text" placeholder="제목" required/>
				</div>				
<!-- 				 <div class="col-sm-6 mb-3"> -->
<!-- 				    <label class="form-label" for="datepickerVal">작성일</label> -->
<!-- 				    <input name="empNtYmd" class="form-control datetimepicker" id="datepickerVal" type="text" placeholder="dd/mm/yy" required="required" data-options='{"disableMobile":true,"allowInput":true}' /> -->
<!-- 				    <div class="invalid-feedback">This field is required</div> -->
<!-- 				 </div> -->
                    
				<div class="col-sm-6 mb-3">
					<label class="form-label" for="emp-no">사번</label> <input
						name="empNo" class="form-control" id="emp-no" type="text" placeholder="${authEmp.empNo }" value="${authEmp.empNo }" readOnly required/>
				</div>
				<div class="col-sm-6 mb-3">
					<label class="form-label" for="emp-nt-writer">작성자명</label> <input
						class="form-control" id="emp-nt-writer" type="text" placeholder="${authEmp.empNm }" value="${authEmp.empNm }" readOnly required/>
				</div>
				
				<div class="col-sm-6 mb-3">
					<label class="form-label" for="empnotice-type">공지사항 종류 </label> 
					<select id="my-empNtClassification"name="empNtClassification"
						class="form-select" id="empnotice-type" required>
						<option value>공지사항 종류를 선택하세요</option>
						<option value="워크샵">워크샵</option>
						<option value="회사휴무">회사휴무</option>
						<option value="시설유지보수">시설유지보수</option>
						<option value="직원교육">직원교육</option>
						<option value="일반">일반</option>
					</select>
					 <div class="invalid-feedback">
				      Please select a valid state.
				    </div>
				</div>
				
				<div class="col-sm-6 mb-3">
				  <label class="form-label" for="formFileMultiple">첨부파일 등록</label>
				  <input class="form-control" id="formFileMultiple" type="file" multiple="multiple" name="empNtFiles" />
				</div>
				
				<div class="col-12">
					<div class="border-bottom border-dashed my-3"></div>
				</div>
				
				<div class="col-12">
					<label class="form-label" for="emp-nt-cn">내용</label>
					<textarea class="tinymce d-none" data-tinymce="data-tinymce" name="empNtCn" required></textarea>
				</div>
				
			
				<div class="col-12">
					<div class="border-bottom border-dashed my-3"></div>
				</div>
				 <div class="col-auto">
                  <button onclick="fnGoList()" type="reset" class="btn btn-falcon-default btn-sm me-2" role="button">취소</button>
                  <button id="insertBtn" type="button" class="btn btn-falcon-primary btn-sm me-2" role="button">등록하기</button>
					<button class="btn btn-falcon-info btn-sm me-2" onclick="fnAuto()" type="button" >자동완성</button>
                </div>
			</div>
		</form>
	</div>
</div>
</div>

<script>

function fnAuto() {
	
	console.log("자동완성이 클릭되었습니다.");
// 	$('input[name=empNtNm]').val("오젠 직원 교육 일정을 알립니다.");
// 	$('input[name=empNtCn]').val("다가오는 4월 첫째 주 월요일에 전 직원 교육이 있을 예정입니다. 많은 참여 부탁드립니다.");
// 	$('#my-empNtClassification').val("직원교육");
	
}



// var insertBtn = document.getElementById("insertBtn");
// insertBtn.addEventListener("click", function(){
// 	console.log("등록하기 버튼을 눌렀을 때",event);
// 	event.preventDefault();
	
// 	let form = document.getElementById("insertForm");
// 	console.log("form");
// 	let url = form.action;
// 	console.log(url);
// 	let method = form.method;
// 	console.log(method);
// 	let data = $(form).serialize();
// 	console.log(data);

// 	$.ajax({
// 		url:url
// 		, method:method
// 		, data : data
// 		, dataType : "json"
// 		, success:function(jsonObj){
// 			console.log("jsonObj---------",jsonObj);
// 			location.href = "${pageContext.request.contextPath }/emp/hrm/empnotice/"+jsonObj.empNt.empNtNo;
// 		}, error : function(jqXHR, txt, status){
// 			console.log(txt, status, jqXHR);
// 		}
// 	}).done(()=>{
// 		form.page.value="";
// 	});
// 	return false;
	
// });
</script>

<script src="${pageContext.request.contextPath }/resources/vendors/tinymce/tinymce.min.js"></script>
<script src="${pageContext.request.contextPath }/resources/assets/js/flatpickr.js"></script>


