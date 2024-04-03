<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<link href="${pageContext.request.contextPath}/resources/css/cstmr/comm/faqList.css" rel="stylesheet">

<section>
    <div>
        <div class="faq-header mx-10">
            <h1 class="cstmr-title mx-5">FAQ</h1>
            <p class="cstmr-content mx-5 mb-5">호텔 오젠의 FAQ</p>
        </div>
    </div>
    <div class="container recom-table text-center mb-5">
        <ul class="nav nav-tabs" id="myTab" role="tablist" style="font-size:50px;">
            <!-- 객실/예약 -->
            <li class="nav-item">
                <a class="nav-link active" id="tab-roomReser" data-bs-toggle="tab" href="#tab-roomReserContent" role="tab" aria-controls="tab-roomReser" aria-selected="true" >객실/예약</a>
            </li>

            <!-- 부대시설 -->
            <li class="nav-item">
                <a class="nav-link" id="tab-bude" data-bs-toggle="tab" href="#tab-budeContent" role="tab" aria-controls="tab-bude" aria-selected="false">부대시설</a>
            </li>

            <!-- 멤버십/계정 -->
            <li class="nav-item">
                <a class="nav-link" id="tab-mbship" data-bs-toggle="tab" href="#tab-mbshipContent" role="tab" aria-controls="tab-mbship" aria-selected="false">멤버십/계정</a>
            </li>

            <!-- 기타 -->
            <li class="nav-item">
                <a class="nav-link" id="tab-other" data-bs-toggle="tab" href="#tab-otherContent" role="tab" aria-controls="tab-other" aria-selected="false">기타</a>
            </li>
        </ul>

		 <div class="tab-content p-3" id="myTabContent">
		    <!-- 객실/예약 -->
		    <div class="tab-pane fade show active" id="tab-roomReserContent" role="tabpanel" aria-labelledby="tab-roomReser">
		        <div class="accordion accordion-flush" id="accordionRoomReser">
		            <div class="accordion" id="accordionRoomReserExample">
		                <c:forEach items="${faqList}" var="faq">
		                    <c:if test="${faq.faqCt eq '객실/예약'}">
		                        <div class="accordion-item">
		                            <h2 class="accordion-header">
		                                <button class="accordion-button content_body" type="button" data-bs-toggle="collapse" data-bs-target="#collapseRoomReser${faq.faqNo}" aria-expanded="true" aria-controls="collapseRoomReser${faq.faqNo}">
		                                    ${faq.faqNm }
		                                </button>
		                            </h2>
		                            <div id="collapseRoomReser${faq.faqNo}" class="accordion-collapse collapse" data-bs-parent="#accordionRoomReserExample">
		                                <div class="accordion-body">
		                                    <span>${faq.faqCn }</span>
		                                </div>
		                            </div>
		                        </div>
		                    </c:if>
		                </c:forEach>
		            </div>
		        </div>
		    </div>
		
		    <!-- 부대시설 -->
		    <div class="tab-pane fade" id="tab-budeContent" role="tabpanel" aria-labelledby="tab-bude">
		        <div class="accordion accordion-flush" id="accordionBude">
		            <div class="accordion" id="accordionBudeExample">
		                <c:forEach items="${faqList}" var="faq">
		                    <c:if test="${faq.faqCt eq '부대시설'}">
		                        <div class="accordion-item">
		                            <h2 class="accordion-header">
		                                <button class="accordion-button content_body" type="button" data-bs-toggle="collapse" data-bs-target="#collapseBude${faq.faqNo}" aria-expanded="true" aria-controls="collapseBude${faq.faqNo}">
		                                    ${faq.faqNm }
		                                </button>
		                            </h2>
		                            <div id="collapseBude${faq.faqNo}" class="accordion-collapse collapse" data-bs-parent="#accordionBudeExample">
		                                <div class="accordion-body">
		                                    <span>${faq.faqCn }</span>
		                                </div>
		                            </div>
		                        </div>
		                    </c:if>
		                </c:forEach>
		            </div>
		        </div>
		    </div>
		
		    <!-- 멤버십/계정 -->
		    <div class="tab-pane fade" id="tab-mbshipContent" role="tabpanel" aria-labelledby="tab-mbship">
		        <div class="accordion accordion-flush" id="accordionMbship">
		            <div class="accordion" id="accordionMbshipExample">
		                <c:forEach items="${faqList}" var="faq">
		                    <c:if test="${faq.faqCt eq '멤버십/계정'}">
		                        <div class="accordion-item">
		                            <h2 class="accordion-header">
		                                <button class="accordion-button content_body" type="button" data-bs-toggle="collapse" data-bs-target="#collapseMbship${faq.faqNo}" aria-expanded="true" aria-controls="collapseMbship${faq.faqNo}">
		                                    ${faq.faqNm }
		                                </button>
		                            </h2>
		                            <div id="collapseMbship${faq.faqNo}" class="accordion-collapse collapse" data-bs-parent="#accordionMbshipExample">
		                                <div class="accordion-body">
		                                    <span>${faq.faqCn }</span>
		                                </div>
		                            </div>
		                        </div>
		                    </c:if>
		                </c:forEach>
		            </div>
		        </div>
		    </div>
		
		    <!-- 기타 -->
		    <div class="tab-pane fade" id="tab-otherContent" role="tabpanel" aria-labelledby="tab-other">
		        <div class="accordion accordion-flush" id="accordionOther">
		            <div class="accordion" id="accordionOtherExample">
		                <c:forEach items="${faqList}" var="faq">
		                    <c:if test="${faq.faqCt eq '기타'}">
		                        <div class="accordion-item">
		                            <h2 class="accordion-header">
		                                <button class="accordion-button content_body" type="button" data-bs-toggle="collapse" data-bs-target="#collapseOther${faq.faqNo}" aria-expanded="true" aria-controls="collapseOther${faq.faqNo}">
		                                    ${faq.faqNm }
		                                </button>
		                            </h2>
		                            <div id="collapseOther${faq.faqNo}" class="accordion-collapse collapse" data-bs-parent="#accordionOtherExample">
		                                <div class="accordion-body">
		                                    <span>${faq.faqCn }</span>
		                                </div>
		                            </div>
		                        </div>
		                    </c:if>
		                </c:forEach>
		            </div>
		        </div>
		    </div>
		</div>
    </div>
</section>