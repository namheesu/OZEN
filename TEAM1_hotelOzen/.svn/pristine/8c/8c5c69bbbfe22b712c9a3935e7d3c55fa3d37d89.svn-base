<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<script type="text/javascript">

	<c:if test="${not empty message }">
		console.log("${message }")
		Swal.fire({
			title:"${message }"
			, icon:"error"
		})
	</c:if>
</script>
<section>
	<div>
		<div class="notice-header mx-10">
			<h1 class="cstmr-title mx-5">Find Id</h1>
		</div>
	<hr class="mt-4 mx-8">
	</div>
	<div class="g-3 mx-10 container row justify-content-center">
	<div class="p-4 p-sm-5 col-md-6 ">
		<div class="d-flex justify-content-between align-items-center mb-2 ">
		</div>	
	
		<form:form method="post" id="checkUserForm">
			<div class="mb-3">
				<input placeholder="성함을 입력하세요" name="cstNm" type="text"
					class="form-control" value="" />
			</div>
			<div class="mb-3">
				<input placeholder="가입 시 등록한 전화번호를 입력하세요" name="cstHp" type="text" id="cstHp"
					class="form-control" value="" />
			</div>

			<div>
				<button type="submit" class="mt-3 w-100 custom-btn btn-7">확인</button>
			</div> 
			<div class="d-flex justify-content-between align-items-center mb-4 ">
			<h5></h5>
			<p class="fs-10 text-600 mt-2 mb-2">
				이용이 처음이신가요? <a href="/authentication/simple/register">가입하기</a>
			</p>
		</div>
			<div class="w-100 position-relative text-center mt-4">
				<div class="divider-content-center"></div>
				<div>
	           	 <a class="fs-10 text-600" href="${pageContext.request.contextPath }/auth/Login.do">로그인<span class="d-inline-block ms-1">&rarr;</span></a>
	            </div>
	            <div>
               	 <a class="fs-10 text-600" href="${pageContext.request.contextPath }/auth/findPwd.do">비밀번호 찾기<span class="d-inline-block ms-1">&rarr;</span></a>
	            </div>
			</div>
		</form:form>
	</div>
	</div>
	<hr class="mx-8">
	
</section>
<script src="<c:url value='/resources/js/app/cstmr/auth/findId.js'/>"></script>