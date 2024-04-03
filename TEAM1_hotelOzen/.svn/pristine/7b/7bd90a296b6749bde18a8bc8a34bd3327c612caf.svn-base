<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form"  prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags"  prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions"  prefix="fn"%>



 <div class="card mt-3" id="getThis" data-div-before="before">
 			<form id="thisForm" method="post" enctype="multipart/form-data">
                <div class="card-header bg-light">
                	<button onclick="fnGoList()" class="btn btn-falcon-default btn-sm fs--10 me-2" type="button" ><span class="fas fa-reply"></span><span class="d-none d-sm-inline-block ms-1">목록</span></button>
                  <h5 style="display: inline-block;"><span style="margin-top: 10px;">[${empNt.empNtClassification}] ${empNt.empNtNm }</span></h5>
                  <div class="text-end"><span>등록일 : ${empNt.empNtYmd }</span></div>
                </div> 
                <div class="card-body">
                  <div class="d-md-flex d-xl-inline-block d-xxl-flex align-items-center justify-content-between mb-x1">
                    <div class="d-flex align-items-center gap-2">
         
                      <p class="mb-0"><a class="fw-semi-bold mb-0 text-800" >${empNt.empNm }</a><span class="fs--2 text-800 fw-normal mx-2">${empNt.empDept }</span><a class="mb-0 fs--1 d-block text-500" href="mailto:emma@watson.com">${empNt.empEml }</a></p>
                    </div>
                    
                  </div>
                  <div>
                  	<div class="col-xl-12">
                    <p class="mb-0">${empNt.empNtCn }</p>
                  	</div>
                    
                
                    <div class="p-x1 bg-light rounded-3 mt-3">
                      <div class="d-inline-flex flex-column">
           
                      		<c:forEach items="${empNt.atchList }" var="atc">
                      			<a href='<c:url value="/emp/empnotice/download/${atc.attNo}"/>'>${atc.atcEmpFileNm }</a>
                      		</c:forEach>
                      </div>
                      <hr class="my-x1" />
                      <div class="row flex-between-center gx-4 gy-2">
                        <div class="col-auto">
                          <p class="fs--1 text-1000 mb-sm-0 font-sans-serif fw-medium mb-0"><span class="fas fa-link me-2"></span>
                          <c:if test="${ not empty empNt.atchList[0].attNo}">
                          	 ${fn:length(empNt.atchList)} files attached
                          </c:if>
                          <c:if test="${ empty empNt.atchList[0].attNo}">
                          	첨부된 파일이 없습니다.
                         </c:if>
                          </p>
                        </div>
                        <div class="col-auto">
<%--                           <button id='allDownLoad' data-files="${empNt.atchList}" class="btn btn-falcon-default btn-sm"><span class="fas fa-file-download me-2"></span>Download all(미구현)</button> --%>
                        </div>
                      </div>
                    </div>
                  </div>
                </div>
                <div class="card-footer bg-light" id="preview-footer">
                  <button id='editBtn' onclick="fnUpdate()" class="btn btn-falcon-default btn-sm fs--1" type="button" data-emp-nt-no="${empNt.empNtNo }" ><span class="far fa-edit"></span><span class="d-none d-sm-inline-block ms-1">수정하기</span></button>
                  <button data-emp-nt-no="${empNt.empNtNo }" id="delBtn" onclick="fnDelete()" class="btn btn-falcon-default btn-sm fs--1" type="button" ><span class="fas fa-trash"></span><span class="d-none d-sm-inline-block ms-1">삭제하기</span></button>
                </div>
              </div>
		    </form>
			
			
			
			
<script>
const cPath = document.body.dataset.contextPath;
var url = `\${cPath}/emp/hrm/empnotice`

</script>
