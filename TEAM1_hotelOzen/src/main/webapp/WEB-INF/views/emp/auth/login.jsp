<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<link href="${pageContext.request.contextPath}/resources/css/emp/auth/login.css" rel="stylesheet">

        <div class="row min-vh-100" style="background-image:url(${pageContext.request.contextPath}/resources/assets/img/lobby.png); background-size:cover;">
          <div class="col-6 d-none d-lg-block position-relative">
            <div class="bg-holder" >
            </div>
          </div>
          <div class="col-sm-10 col-md-6 px-sm-0 align-self-center mx-auto py-5">
            <div class="row justify-content-center g-0">
              <div class="col-lg-9 col-xl-6 col-xxl-6">
               <div class="card">
              <div class="card-body p-5 p-sm-5">
                <div class="row flex-between-center mb-2">
                  <div class="col-auto">
                    <h5>Log in</h5>
                  </div>
                </div>
                <form:form method="post">
                  <div class="mb-3">
                    <input class="form-control" type="text" placeholder="ID" name="username"/>
                  </div>
                  <div class="mb-3">
                    <input class="form-control" type="password" placeholder="Password" name="password"/>
                  </div>
                  <div class="row flex-between-center">
                    <div class="col-auto">
                    </div>
                    <div class="col-auto"><a class="fs-10" href="${pageContext.request.contextPath }/emp/auth/findId.do">Forgot ID</a>
                    <a class="fs-10" href="${pageContext.request.contextPath }/emp/auth/findPwd.do"> / Forgot Password</a></div>
                  </div>
                  <div class="mb-3">
                    <button class="custom-btn btn-5 d-block w-100 mt-3" type="submit" name="submit">Log in</button>
                  </div>
                </form:form>
				<select name="login" class="select">
				  <option selected value="" id="blankLogin">Login</option>
				  <c:forEach items="${empList }" var="emp">
				  	<option value="${emp.empNo }">${emp.empDept } / ${emp.empJbgd }</option>
				  </c:forEach>
				</select>
                <div class="position-relative mt-4">
                </div>
                <div class="row g-2 mt-2">
                </div>
              </div>
            </div>
          </div>
          </div>
        </div>
        </div>
<script src="<c:url value='/resources/js/app/emp/auth/login.js'/>"></script>