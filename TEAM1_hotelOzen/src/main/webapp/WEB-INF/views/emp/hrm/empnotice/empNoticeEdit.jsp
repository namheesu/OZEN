<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form"  prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags"  prefix="spring"%>

<link href="${pageContext.request.contextPath }/resources/vendors/flatpickr/flatpickr.min.css" rel="stylesheet" />
<div class="container" >
<div class="card mb-3" id="getThis" data-div-before="before">
	<div class="card-header">
		<h5 class="mb-0">직원 공지사항 수정</h5>
	</div>
	<div class="card-body bg-light">
		<form class="needs-validation" id="updateForm" action="<c:url value='/emp/hrm/empnotice/${empNt.empNtNo }/update'/>" method="put" enctype="multipart/form-data" modelAttribute="${HrmEmpNoticeController.MODELNAME }" novalidate>
			<div class="row gx-2">
				<div class="col-sm-6 mb-3">
					<label class="form-label" for="emp-nt-nm">제목</label> <input name="empNtNm"
						class="form-control" id="emp-nt-nm" type="text" placeholder="제목" value="${empNt.empNtNm }" required/>
				</div>				
<!-- 				 <div class="col-sm-6 mb-3"> -->
<!-- 				    <label class="form-label" for="datepickerVal">작성일</label> -->
<!-- 				    <input name="empNtYmd" class="form-control datetimepicker" id="datepickerVal" type="text" placeholder="dd/mm/yy" required="required" data-options='{"disableMobile":true,"allowInput":true}' /> -->
<!-- 				    <div class="invalid-feedback">This field is required</div> -->
<!-- 				 </div> -->
                    
				<div class="col-sm-6 mb-3">
					<label class="form-label" for="emp-no">사번</label> <input
						name="empNo" class="form-control" id="emp-no" type="text" placeholder="${empNt.empNo }" value="${empNt.empNo }" readOnly required/>
				</div>
				<div class="col-sm-6 mb-3">
					<label class="form-label" for="emp-nt-writer">작성자명</label> <input
						class="form-control" id="emp-nt-writer" type="text" placeholder="${empNt.empNm }" value="${empNt.empNm }" readOnly required/>
				</div>
				
				<div class="col-sm-6 mb-3">
					<label class="form-label" for="empnotice-type">공지사항 종류 </label> 
					
					<select name="empNtClassification"
						class="form-select" id="empnotice-type" required>
						<option value>공지사항 종류를 선택하세요</option>
						<option value="워크샵" <c:if test="${ empNt.empNtClassification eq '워크샵'}">
						
						selected="selected"</c:if>>워크샵</option>
						<option value="회사휴무" <c:if test="${ empNt.empNtClassification eq '회사휴무'}">
						
						selected="selected"</c:if>>회사휴무</option>
						<option value="시설유지보수" <c:if test="${ empNt.empNtClassification eq '시설유지보수'}">
						
						selected="selected"</c:if>>시설유지보수</option>
						<option value="직원교육" <c:if test="${ empNt.empNtClassification eq '직원교육'}">
						
						selected="selected"</c:if>>직원교육</option>
						<option value="일반" <c:if test="${ empNt.empNtClassification eq '일반'}">
						
						selected="selected"</c:if>>일반</option>
					</select>
					 <div class="invalid-feedback">
				      Please select a valid state.
				    </div>
				</div>
				
				<div class="col-sm-6">
				  <label class="form-label" for="formFileMultiple">첨부파일 등록</label>
				  <label class="form-label" for="formFileMultiple" style="padding-left: 10px;">
				  <c:if test="${not empty empNt.atchList }">
				  			<c:forEach items="${empNt.atchList }" var="atc">
				  				<c:if test="${atc.attNo ne null}">
                      			<a data-del-atc='atc' href='<c:url value="/emp/empnotice/atc/${atc.attNo}"/>'>${atc.atcEmpFileNm }<span class="fas fa-window-close ms-1 fs--2"></span></a>
                      			</c:if>
                      		</c:forEach>
                  </c:if>
				  </label>
				  <input class="form-control" id="formFileMultiple" type="file" multiple="multiple" name="empNtFiles" />
				  
				</div>
				
				<div class="col-12">
					<div class="border-bottom border-dashed my-3"></div>
				</div>
				
				<div class="col-12">
					<label class="form-label" for="emp-nt-cn">내용</label>
					<textarea class="tinymce d-none" data-tinymce="data-tinymce" name="empNtCn" required >${empNt.empNtCn}</textarea>
				</div>
				
			
				<div class="col-12">
					<div class="border-bottom border-dashed my-3"></div>
				</div>
				</form>
				 <div class="col-auto">
                  <button id="resetBtn" onclick="fnReset()" data-emp-nt-no="${empNt.empNtNo }" class="btn btn-falcon-default btn-sm me-2" role="button">취소</button>
                  <button onclick="fnEdit()" id="updateBtn" type="button" class="btn btn-falcon-primary btn-sm" role="button">수정하기</button>
                </div>
			</div>
			
		
	</div>
</div>
</div>

<script>
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


