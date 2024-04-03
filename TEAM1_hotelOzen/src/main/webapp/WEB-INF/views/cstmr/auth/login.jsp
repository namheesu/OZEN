<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<section>
	<div>
		<div class="mx-10">
			<h1 class="cstmr-title mx-5">Login</h1>
		</div>
	<hr class="mx-8">
	</div>
	<div class="text-center d-flex justify-content-center">

	<div class="g-3 container row justify-content-center">
	<div class="p-4 p-sm-5 col-md-6 ">
		<div class="d-flex justify-content-between align-items-center mb-2 ">
		</div>	
	
		<form:form method="post">
			<div class="mb-3">
				<input placeholder="ID" name="username" type="text" id="username"
					class="form-control" value="" />
			</div>
			<div class="mb-3">
				<input placeholder="password" name="password" type="password" id="password"
					class="form-control" value="" />
			</div>
			<div class="justify-content-between align-items-center row">
				<div class="col-auto">
					<div class="mb-0 form-check">
						<input name="remember" type="checkbox" id="rememberMe"
							class="form-check-input"><label for="rememberMe"
							class="mb-0 text-700 form-check-label">Remember me</label>
					</div>
				</div>
				<div class="col-auto">
					<a class="fs-10 mb-0" href="${pageContext.request.contextPath }/auth/findId.do">
						Forgot Id
					</a>
					/
					<a class="fs-10 mb-0" href="${pageContext.request.contextPath }/auth/findPwd.do">
						Forgot Password
					</a>
				</div>
			</div>
			<div>
				<button type="submit" class="mt-3 w-100 custom-btn btn-7">Log in</button>
			</div> 
			<div class="d-flex justify-content-between align-items-center mb-4 ">
			<h5></h5>
			<p class="fs-10 text-600 mt-2 mb-2">
				이용이 처음이신가요? <a href="${pageContext.request.contextPath }/auth/join/terms.do">가입하기</a>
			</p>
		</div>
			<div class="w-100 position-relative text-center mt-4">
				<hr class="text-300">
				<div class="divider-content-center autocomplete">자동완성</div>
			</div>
		</form:form>
	</div>
	</div>
	</div>
	<hr class="mx-8">
	
</section>

<script>
	$(document).ready(function() {
		$(document).on('click','.autocomplete',function(event){
			username.value = 'ddit';
			password.value = '1111aaaa!';
		});
	});
</script>