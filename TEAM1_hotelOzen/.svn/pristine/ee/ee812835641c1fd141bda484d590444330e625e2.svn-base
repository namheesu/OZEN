<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<link href="${pageContext.request.contextPath}/resources/css/cstmr/comm/clickwrap.css" rel="stylesheet">

<section>
	<div>
		<div class="clickwrap-header mx-10">
			<h1 class="cstmr-title mx-5">회원가입</h1>
			<p class="cstmr-content mx-5 mb-5">회원 가입 약관 동의</p>
		</div>
		
		<div class="mx-9">
			<label for="agree" class="cstmr-content chk_box mt-6">
			<input type="checkbox" id="agree" />
			<span class="on"></span>
				<h5 class="mx-2">
			전체 이용약관에 동의합니다.
			아래 동의 항목을 개별적으로 동의하실 수 있습니다.
			</h5>
			</label>
		<hr> 
		
		<c:forEach items="${termList }" var="cw">
			<div class="accordion accordion-flush" id="accordionTerms">
			  <div class="accordion-item">
			    <h2 class="accordion-header">
       				<label for="${cw.cwNo }" class="cstmr-content chk_box">
					<input type="checkbox" id="${cw.cwNo }" />
					<span class="on" style="margin-top: 16px;"></span>
			  	    <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#${cw.cwNo }" aria-expanded="false" aria-controls="flush-collapseOne">
			   	    	${cw.cwCt }  ${cw.cwNm }
			       	</label>
			      </button>
			    </h2>
			    <div id="${cw.cwNo }" class="accordion-collapse collapse" data-bs-parent="#accordionFlushExample">
		      	<div class="accordion-body">
					${cw.cwCn }
			    </div>
			    </div>
			  </div>
			</div>
		</c:forEach>
		
		
		<div class="d-flex mb-3 flex-row-reverse">
		  <button class="custom-btn btn-3 mx-2" id="cancelBtn"><span>취소</span></button>
		  <button class="custom-btn btn-6 mx-2" id="confirmBtn"><span>확인</span></button>
		</div>
		</div>
		
	</div>
</section>

<script src="<c:url value='/resources/js/app/cstmr/auth/clickwrap.js'/>"></script>