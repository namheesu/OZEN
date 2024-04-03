<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form"  prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags"  prefix="spring"%>


<div class="col-lg-12 col-xl-12 col-xxl-6 h-100" id="getThis" data-div-before="before">
  <div class="position-xl-sticky top-0">
                <div class="card">
                  <div class="card-header d-flex align-items-center justify-content-between py-2">
                  <button class="btn btn-falcon-default btn-sm" type="button"><span class="fas fa-arrow-left"></span></button>
                    <h6 class="mb-0">직원 상세 정보</h6>
                    <div class="dropdown font-sans-serif btn-reveal-trigger">
                      <button class="btn btn-link text-600 btn-sm dropdown-toggle dropdown-caret-none btn-reveal" type="button" id="dropdown-contact-information" data-bs-toggle="dropdown" data-boundary="viewport" aria-haspopup="true" aria-expanded="false"><span class="fas fa-ellipsis-h fs--2"></span></button>
                      <div class="dropdown-menu dropdown-menu-end border py-2" aria-labelledby="dropdown-contact-information"><a class="dropdown-item" href="#!">-----</a><a class="dropdown-item" href="#!">Disabled</a>
                        <div class="dropdown-divider"></div><a class="dropdown-item text-danger" href="#!">Delete</a>
                      </div>
                    </div>
                  </div>
                  <div class="card-body bg-light">
                    <div class="card border rounded-3 bg-white dark__bg-1000 shadow-none">
                      <div class="bg-holder bg-card d-none d-sm-block d-xl-none" style=background-image:url(${pageContext.request.contextPath}/resources/assets/img/icons/spot-illustrations/corner-2.png);>
                      </div>
                      <!--/.bg-holder-->

                      <div class="card-body row g-0 flex-column flex-sm-row flex-xl-column z-index-1 align-items-center">
                        <div class="col-auto text-center me-sm-x1 me-xl-0"><img class="ticket-preview-avatar" src="${pageContext.request.contextPath}/resources/assets/img/team/5-thumb.png" alt="" /></div>
                        <div class="col-sm-8 col-md-6 col-lg-4 col-xl-12 ps-sm-1 ps-xl-0">
                          <p class="fw-semi-bold mb-0 text-800 text-center text-sm-start text-xl-center mb-3 mt-3 mt-sm-0 mt-xl-3">김은대</p>
                          <div class="d-flex gap-2 justify-content-center">
                            <button class="btn btn-primary btn-sm px-2 text-nowrap w-50"><span class="fas fa-id-badge me-1" data-fa-transform="shrink-3 down-1"></span><span class="fs--2">STF</span></button>
                            <button class="btn btn-sm btn-falcon-default w-50"><span class="fas fa-landmark me-1" data-fa-transform="shrink-4"></span><span class="fs--2">프론트오피스</span></button>
                          </div>
                        </div>
                      </div>
                    </div>
                    <div class="border rounded-3 p-x1 mt-3 bg-white dark__bg-1000 row mx-0 g-0">
                      <div class="col-md-6 col-xl-12 pe-md-4 pe-xl-0">
                      <div class="d-flex"">
                      	<div class="flex-fill mb-4">
                          <h6 class="mb-1 false">이메일</h6><a class="fs--1" href="mailto:mattrogers@gmail.com">dmseo1111@naver.com</a>
                        </div>
                        <div class="flex-fill mb-4">
                          <h6 class="false mb-1">전화번호</h6><a class="fs--1" href="tel:+6(855)747677">010-4444-3355</a>
                        </div>
                      </div>
                        <div class="d-flex"></div>
                        <div class="flex-fill mb-4">
                          <h6 class="false false">주소</h6>
                          <p class="mb-0 text-700 fs--1">대전시 중구</p>
                        </div>
                        <div class="flex-fill mb-4">
                          <h6 class="false false">자택 전화번호</h6>
                          <p class="mb-0 text-700 fs--1">042-000-0000</p>
                        </div>
                        <div class="flex-fill mb-4">
                          <h6 class="false false">생년월일</h6>
                          <p class="mb-0 text-700 fs--1">0000/00/00</p>
                        </div>
                      </div>
                      <div class="col-md-6 col-xl-12 ps-md-4 ps-xl-0">
                        <div class="mb-4">
                          <h6 class="false false">퇴사여부</h6>
                          <p class="mb-0 text-700 fs--1">N</p>
                        </div>
                        <div class="mb-4">
                          <h6 class="false false">입사일</h6>
                          <p class="mb-0 text-700 fs--1">0000/00/00</p>
                        </div>
                        <div class="mb-4">
                          <h6 class="false false">사번</h6>
                          <p class="mb-0 text-700 fs--1">E240001</p>
                        </div>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
            </div>