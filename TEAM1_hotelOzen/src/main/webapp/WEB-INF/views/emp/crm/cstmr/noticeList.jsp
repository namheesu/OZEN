<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<link href="${pageContext.request.contextPath }/resources/css/emp/pagingCss.css" rel="stylesheet"/>
<link href="${pageContext.request.contextPath }/resources/vendors/flatpickr/flatpickr.min.css" rel="stylesheet" />
<link href="${pageContext.request.contextPath }/resources/css/emp/crm/cstmrnotice/noticeList.css" rel="stylesheet" />

<div class="col mb-3">
   <div class="card h-100">
      <div class="card-header">
         <div class="row flex-between-end">
            <div class="col-auto align-self-center">
            <div>
			<nav style="--falcon-breadcrumb-divider: url(&#34;data:image/svg+xml,%3Csvg xmlns='http://www.w3.org/2000/svg' width='8' height='8'%3E%3Cpath d='M2.5 0L1 1.5 3.5 4 1 6.5 2.5 8l4-4-4-4z' fill='%23748194'/%3E%3C/svg%3E&#34;);" aria-label="breadcrumb">
	           <ol class="breadcrumb">
	             <li class="breadcrumb-item"><a href="${pageContext.request.contextPath}/emp">Home</a></li>
	             <li class="breadcrumb-item active" aria-current="page">고객 공지사항</li>
	           </ol>
	         </nav>
			</div>
           </div>
           
<form:form id="searchForm" method="post">
	<input type="hidden" name="page"/>
	<input type="hidden" name="searchType" id="searchType" value="${simpleCondition.searchType }"/>
	<input type="hidden" name="searchWord" id="searchWord" value="${simpleCondition.searchWord }"/>
</form:form>

<div id="noticeList">
  <div class="row justify-content-end g-0">
    <div class="col-auto col-sm-5 mb-3">
      <div class="input-group" data-pg-role="searchUI" data-pg-target="#searchForm">
      <select name="searchType" data-pg-init-value="${simpleCondition.searchType }" class="form-select form-select-sm mx-2" aria-label="Bulk actions" data-list-filter="data-list-filter">
        <option value>Select Category</option>
        <option value="empNm">작성자</option>
        <option value="mberNtNm">제목</option>
        <option value="mberNtCtgry">카테고리</option>
        <option value="mberNtCn">내용</option>
      </select>
          <input class="form-control form-control-sm shadow-none search" name="searchWord" data-pg-init-value="${simpleCondition.searchWord }" type="text" placeholder="Search..." aria-label="search" />
          <button type="button" class="btn btn-light" data-pg-role="searchBtn">
	          <span class="fa fa-search fs-10 text-600"></span>
          </button>
     </div>
    </div>
  </div>
  <div class="table-responsive scrollbar">
<table class="table center">
      <thead class="thead-light text-center bg-oran">
        <tr>
          <th>No</th>
          <th>Title</th>
          <th>Writer</th>
          <th>Category</th>
          <th>Date</th>
          <th>Hit</th>
        </tr>
      </thead>
      <tbody class="text-center" id="listBody">
       
      </tbody>
    </table>
  </div>
  <div class="d-flex justify-content-center mt-3" id="pagingArea">
  </div>
  <div class="d-flex justify-content-end"">
  <button class="btn btn-outline-primary btn-sm" id="insertBtn">작성</button>
  </div>
</div>
</div>
</div>
</div>
</div>

<div class="row mt-5">
            <div class="col-lg-6 col-xl-12 col-xxl-6 h-100" id="insertDiv" style="display:none;">
              <div class="d-flex mb-4">
              	<i class="fas fa-pencil-alt"></i>
                <div class="col">
                  <h5 class="mb-0 text-primary position-relative"><span class="bg-200 dark__bg-1100 pe-3">Write</span>
                  	<span class="border position-absolute top-50 translate-middle-y w-100 start-0 z-n1"></span>
                  </h5>
                  <p class="mb-0">공지사항 작성</p>
                </div>
              </div>
              <div class="card theme-wizard mb-5">
                <div class="card-body py-4">
		<form class="needs-validation" id="insertForm" method="post" action="${pageContext.request.contextPath }/emp/crm/cstmr/noticeInsert">
			<div class="row gx-2">
				<div class="col-sm-6 mb-3">
					<label class="form-label" for="emp-nt-nm">제목</label> <input name="mberNtNm"
						class="form-control" type="text" placeholder="제목" required/>
				</div>				
				<div class="col-sm-6 mb-3">
					<label class="form-label" for="emp-no">사번</label> <input
						name="empNo" class="form-control" type="text" value="${empUser.empNo }" readOnly required/>
				</div>
				<div class="col-sm-6 mb-3">
					<label class="form-label" for="emp-nt-writer">작성자명</label> <input
						class="form-control" type="text" value="${empUser.empNm }" readOnly required/>
				</div>
				
				<div class="col-sm-6 mb-3">
					<label class="form-label" for="empnotice-type">공지사항 카테고리</label> 
					<select name="mberNtCtgry"
						class="form-select" id="empnotice-type" required>
						<option value>공지사항 카테고리</option>
						<option value="[예약]">[예약]</option>
						<option value="[숙박]">[투숙]</option>
						<option value="[계정]">[계정]</option>
						<option value="[시설]">[시설]</option>
						<option value="[공사]">[공사]</option>
						<option value="[점검]">[점검]</option>
					</select>
				</div>
				
				<div class="col-12">
					<label class="form-label" for="emp-nt-cn">내용</label>
					<textarea class="tinymce d-none" data-tinymce="data-tinymce" name="mberNtCn" required></textarea>
				</div>
				 <div class="mt-4 col-auto">
                  <button type="reset" class="btn btn-falcon-default btn-sm me-2" id="insertCancel">취소</button>
                  <button id="insertBtn" type="submit" class="btn btn-falcon-primary btn-sm">등록하기</button>
                </div>
			</div>
		</form>
                </div>
              </div>
            </div>
            
            <div class="col-lg-6 col-xl-12 col-xxl-6 h-100" id="updateDiv" style="display:none;">
              <div class="d-flex mb-4">
              	<i class="fas fa-edit"></i>
                <div class="col">
                  <h5 class="mb-0 text-primary position-relative"><span class="bg-200 dark__bg-1100 pe-3">Edit</span>
                  	<span class="border position-absolute top-50 translate-middle-y w-100 start-0 z-n1"></span>
                  </h5>
                  <p class="mb-0">공지사항 수정</p>
                </div>
              </div>
              <div class="card theme-wizard mb-5">
                <div class="card-body py-4">
                  <div class="tab-content">
                    <div class="tab-pane active px-sm-3 px-md-5" role="tabpanel" aria-labelledby="bootstrap-wizard-tab1" id="bootstrap-wizard-tab1">
      		<form class="needs-validation" id="updateForm" method="post" action="${pageContext.request.contextPath }/emp/crm/cstmr/noticeUpdate">
      		<input type="hidden" >
			<div class="row gx-2">
				<div class="col-sm-6 mb-3">
					<label class="form-label" for="emp-nt-nm">제목</label> 
					<input name="mberNtNm" class="form-control" id="modMberNtNm" type="text" placeholder="제목" required/>
				</div>				
				<div class="col-sm-6 mb-3">
					<label class="form-label" for="emp-no">사번</label> <input
						name="empNo" class="form-control" type="text" value="${empUser.empNo }" readOnly required/>
				</div>
				<div class="col-sm-6 mb-3">
					<label class="form-label" for="emp-nt-writer">작성자명</label>
					 <input class="form-control" type="text" value="${empUser.empNm }" readOnly required/>
				</div>
				
				<div class="col-sm-6 mb-3">
					<label class="form-label" for="empnotice-type">공지사항 카테고리</label> 
					<select name="mberNtCtgry" id="modMberNtCtgry"
						class="form-select">
						<option value>공지사항 카테고리</option>
						<option value="[예약]">[예약]</option>
						<option value="[숙박]">[투숙]</option>
						<option value="[계정]">[계정]</option>
						<option value="[시설]">[시설]</option>
						<option value="[공사]">[공사]</option>
						<option value="[점검]">[점검]</option>
					</select>
				</div>
				
				<div class="col-12">
					<label class="form-label" for="emp-nt-cn">내용</label>
					<textarea class="tinymce d-none" data-tinymce="data-tinymce" name="mberNtCn" id="modMberNtCn" required></textarea>
				</div>
				 <div class="mt-4 col-auto">
                  <button type="reset" class="btn btn-falcon-default btn-sm me-2" id="updateCancel">취소</button>
                  <button id="updateBtn" type="submit" class="btn btn-falcon-primary btn-sm">등록하기</button>
                </div>
			</div>
			</form>
          </div>
        </div>
      </div>
    </div>
  </div>
</div>
<script src="<c:url value='/resources/js/app/common/paging.js'/>"></script>
<script src="<c:url value='/resources/js/app/emp/crm/cstmrnotice/cstmrNoticeList.js'/>"></script>
<script src="${pageContext.request.contextPath }/resources/vendors/tinymce/tinymce.min.js"></script>
<script src="${pageContext.request.contextPath }/resources/assets/js/flatpickr.js"></script>