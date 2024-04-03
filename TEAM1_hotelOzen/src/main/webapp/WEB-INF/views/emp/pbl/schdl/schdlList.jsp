<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<link href="${pageContext.request.contextPath}/resources/css/emp/pbl/schdl/schdl.css" rel="stylesheet">

<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
  <!-- fullcalendar CDN -->
<link href='https://cdn.jsdelivr.net/npm/fullcalendar@5.8.0/main.min.css' rel='stylesheet' />
<script src='https://cdn.jsdelivr.net/npm/fullcalendar@5.8.0/main.min.js'></script>
<!-- fullcalendar 언어 CDN -->
<script src='https://cdn.jsdelivr.net/npm/fullcalendar@5.8.0/locales-all.min.js'></script>


<!-- calendar 태그 -->
<div id='calendar-container' class="calen-body" style="width:70%; float:right;">
	<div id='calendar'></div>
</div>

<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title" id="exampleModal">일정 추가하기</h5>
				<button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
			</div>
			<div class="modal-body">
				<input type="text" id="schdlTitle" >
				<label>내용</label>
				<span></span>
				<br />
				<input type="datetime-local" id="schdlStart" /><br />
				종료일 : <input type="datetime-local" id="schdlEnd" /><br />
				배경색상 :
				<select id="color">
				  <option value="#f6714f">빨강색</option>
				  <option value="#f9cb71">주황색</option>
				  <option value="#d8fe66">노랑색</option>
				  <option value="#a9fa83">초록색</option>
				  <option value="#77c4f7">파랑색</option>
				  <option value="#fa75c7">남색</option>
				  <option value="#cca7fa">보라색</option>
				</select>
			</div>
			<div class="modal-footer">
			  <button type="button" class="btn btn-secondary" data-bs-dismiss="modal"> 취소 </button>
			  <button type="button" class="btn btn-primary" id="saveChanges"> 추가 </button>
			</div>
		</div>
	</div>
</div>


<script>

$(function () {
	// calendar element 취득
	var calendarEl = $('#calendar')[0];
	// full-calendar 생성하기
	var calendar = new FullCalendar.Calendar(calendarEl, {
	height: '700px', // calendar 높이 설정
	expandRows: true, // 화면에 맞게 높이 재설정
	slotMinTime: '08:00', // Day 캘린더에서 시작 시간
	slotMaxTime: '20:00', // Day 캘린더에서 종료 시간
    
    
    events :[
		<c:forEach items="${empSchdlList }" var="schdl" varStatus="vs">
		<c:if test="${vs.index>0 }">,</c:if>
		{
			title : "${schdl.schdlTitle }",
			start : "${schdl.schdlStart }",
			end : "${schdl.schdlEnd }",
			backgroundColor : "${schdl.bgColor }"
		}
		</c:forEach>
    ],
    
    // 해더에 표시할 툴바
    headerToolbar: {
		left: 'prevYear,prev,today,next,nextYear',
		center: 'title',
		right: 'dayGridMonth,dayGridWeek,dayGridDay'
    },
	initialView: 'dayGridMonth', // 초기 로드 될때 보이는 캘린더 화면(기본 설정: 달)
    navLinks: true, // 날짜를 선택하면 Day 캘린더나 Week 캘린더로 링크
    editable: true, // 수정 가능?
    selectable: true, // 달력 일자 드래그 설정가능
    nowIndicator: true, // 현재 시간 마크
    dayMaxEvents: true, // 이벤트가 오버되면 높이 제한 (+ 몇 개식으로 표현)
    locale: 'ko', // 한국어 설정
    eventAdd: function(obj) { // 이벤트가 추가되면 발생하는 이벤트
		console.log(obj);
    },
    eventChange: function(obj) { // 이벤트가 수정되면 발생하는 이벤트
		console.log(obj);
    },
    eventRemove: function(obj){ // 이벤트가 삭제되면 발생하는 이벤트

    },
    select: function(arg) {
		// 기본 프롬프트 대신 모달 열기
		$("#schdlStart").val(arg.startStr);
 		$("#schdlEnd").val(arg.endStr);
  
		$("#exampleModal").modal("show");
		
	    },
	    
	    // 일정 삭제시
	    eventClick : function(arg) {
	    	var schdlTitle = arg.event.title;
	    	console.log(schdlTitle);
	    	if (confirm("해당 일정을 삭제하시겠습니까? ")){
	    		$.ajax({
	    			url : "${pageContext.request.contextPath}/emp/pbl/schdl/deleteSchdl"
	    			, method : "POST"
	    			, contentType : "application/json"
	    			, data : JSON.stringify(schdlTitle)
	    			, success : function(jsonObj) {
	    				alert("정상적으로 삭제되었습니다.");
	    				
	    				setTimeout(function() {
                            window.location.reload();
                        }, 1);
	    			},
	    			error: function(jqXHR, txt, status){
						console.log("Error Text: ", txt);
						console.log("HTTP Status: ", status);	
						console.log("XHR Object: ", jqXHR);
						console.log("title: ", schdlTitle);
					}
	    		});
	    	} 
	    }
	});
  // 캘린더 랜더링
  calendar.render();
  
  // --------------------- 이벤트 설정
  $("#saveChanges").on("click", function () {
		var eventData = {
			title: $("#schdlTitle").val(),
			start: $("#schdlStart").val(),
			end: $("#schdlEnd").val(),
			color: $("#color").val(),
		};
		console.log("eventData", eventData);
		//빈값입력시 오류
		if ( eventData.title == "" || eventData.start == "" ) {
			alert("입력하지 않은 값이 있습니다.");
			
		//끝나는 날짜가 시작하는 날짜보다 값이 크면 안됨
		} else if ($("#schdlStart").val() > $("#schdlEnd").val()) {
			alert("시간을 잘못입력 하셨습니다.");
		} else {
			// 이벤트 추가
			var empSchdlData = {
				schdlTitle: $("#schdlTitle").val(),
				schdlStart: $("#schdlStart").val(),
				schdlEnd: $("#schdlEnd").val(),
				bgColor: $("#color").val(),
			};
			$.ajax({
				url : "${pageContext.request.contextPath}/emp/pbl/schdl/insertSchdl"
				, method : "POST"
				, contentType : "application/json"
				, data : JSON.stringify(empSchdlData)
				, success : function(jsonObj){
					alert("일정이 저장되었습니다.");			
					calendar.addEvent(eventData);
					
					
					
			 	},
				error: function(jqXHR, txt, status){
					console.log("Error Text: ", txt);
					console.log("HTTP Status: ", status);	
					console.log("XHR Object: ", jqXHR);
				}
			});


				$("#exampleModal").modal("hide");
				$("#schdlTitle").val("");
				$("#schdlStart").val("");
				$("#schdlEnd").val("");
				$("#color").val("");
			}
		});
});
</script>
