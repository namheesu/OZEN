<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form"  prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags"  prefix="spring"%>

<style>


</style>

<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.4.0/font/bootstrap-icons.css" />
<link href="${pageContext.request.contextPath }/resources/vendors/flatpickr/flatpickr.min.css" rel="stylesheet" />
<link href="${pageContext.request.contextPath}/resources/css/emp/pagingCss.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/resources/css/emp/hrm/empnotice/empNoticeList.css" rel="stylesheet">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/sweetalert2@11.4.10/dist/sweetalert2.min.css">



<div class="col mb-3" id="target">
<div  class="card h-100" id="getThis">
	<div class="card-header">
	 <div class="row flex-between-end" >
		<nav style="--falcon-breadcrumb-divider: url(&#34;data:image/svg+xml,%3Csvg xmlns='http://www.w3.org/2000/svg' width='8' height='8'%3E%3Cpath d='M2.5 0L1 1.5 3.5 4 1 6.5 2.5 8l4-4-4-4z' fill='%23748194'/%3E%3C/svg%3E&#34;);" aria-label="breadcrumb">
			<ol class="breadcrumb">
				<li class="breadcrumb-item"><a href="${pageContext.request.contextPath}/emp">Home</a></li>
				<li class="breadcrumb-item active" aria-current="page">직원 공지사항</li>
			</ol>
		</nav>
	</div>
	<div class="card-header">
		<div class="row flex-between-end">

					
			<!-- 직원 공지사항 목록 조회 -->
			<div id="empNoticeList">
			
			<div>
<!-- 				<div class="col-auto col-sm-5 mb-3"> -->
					<form id="searchForm" >
						<input type="hidden" type="text" name="page" placeholder="page"/>
						<input type="hidden" name="searchType" placeholder="searchType"/>
						<input type="hidden" name="searchWord" placeholder="searchWord"/>
						<input type="hidden" id="selectOneSearchWord" name="selectOneSearchWord" placeholder="selectOneSearchWord"/>
				 	</form>
				
				<div class="row justify-content-end g-0" data-pg-role="searchUI" data-pg-target="#searchForm" id="searchUI">
					<div class="col-sm-5 me-1 empNtSelect">
						<select name="selectOneSearchWord" data-pg-init-value="${simpleCondition.selectOneSearchWord}" class="form-select form-select-sm mb-3">
							<option selected="" value="">공지 전체</option>
							<option value="워크샵">워크샵</option>
							<option value="회사휴무">회사휴무</option>
							<option value="시설유지보수">시설유지보수</option>
							<option value="직원교육">직원교육</option>
							<option value="일반">일반</option>
						</select>
					</div>				
					<div class="col-sm-5 me-1 empNtSelect">
						<select name="searchType" class="form-select form-select-sm mb-3">
							<option value="" label="전체" />
							<option value="empNtNm" label="제목" />
							<option value="empNm" label="작성자" />
							<option value="empNtCn" label="내용" />
						</select>
					</div>
					<div class="col-auto col-sm-3 mb-3">
						<div class="input-group">
							<input name="searchWord" class="form-control form-control-sm shadow-none search" type="search" placeholder="Search..." aria-label="search" />
							<div class="input-group-text bg-transparent">
					          	<span class="fa fa-search fs-10 text-600" id="selectBtn" data-pg-role="searchBtn"></span>
					        
							</div>
						</div>
					</div>
				</div>
			</div>
			
			
			
			
			<div class="card shadow-none">
			  <div class="table-responsive scrollbar">
			    <table class="table mb-0 center">
			      <thead class="bg-oran">
			        <tr style="color: #FAFAFA">
			          <th class="align-middle" data-sort="rnum">번호</th>
			          <th class="align-middle" data-sort="empNtClassification">공지분류</th>
			          <th class="align-middle" data-sort="empNtNm">제목</th>
			          <th class="align-middle" data-sort="empNm">작성자</th>
			          <th class="align-middle" data-sort="empNtYmd">작성일</th>
			          <th class="align-middle" data-sort="empAtch">첨부파일</th>
			          <th class="align-middle" data-sort="empNtCnt">조회수</th>
			        </tr>
			      </thead>
			      <tbody id="listBody"></tbody>
			    </table>
			  </div>
			<!-- 페이징 -->
			  <div class="card-footer d-flex justify-content-center paging-div-height" id="pagingArea"></div>
			  <div>
			  <button class="btn btn-outline-info btn-sm" type="button" onclick="fnMakeEmpNotice()" id="newNotice">+ 새 공지</button>
			</div>
		</div>
	</div>
</div>
</div>
</div>
</div>
</div>



<script>

</script>

<script src="<c:url value='/resources/js/app/emp/hrm/empnotice/empNotice.js'/>"></script>
<script src="${pageContext.request.contextPath }/resources/vendors/tinymce/tinymce.min.js"></script>
<script src="${pageContext.request.contextPath }/resources/assets/js/flatpickr.js"></script>
<script src="<c:url value='/resources/js/app/common/paging.js'/>"></script>
<script src="https://cdn.jsdelivr.net/npm/sweetalert2@11.4.10/dist/sweetalert2.min.js"></script>