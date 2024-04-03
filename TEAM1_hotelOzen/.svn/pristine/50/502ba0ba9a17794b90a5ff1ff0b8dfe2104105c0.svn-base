<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form"  prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags"  prefix="spring"%>

<link href="${pageContext.request.contextPath}/resources/css/emp/hrm/dclz/dclzTime.css" rel="stylesheet">

<%-- ${dclz} --%>
<div class="row">
	<!-- 얼굴인식 출퇴근 -->
	<div class="card_main" style="width:20%">
		<div class="card h-75">
			<div class="card-header">
				<h5 class="mb-0 go-btn">출퇴근</h5>
				<div class="time">
					<h6 style="text-align:right" class="go-btn" id="now"></h6>
				</div>
			</div>
			<div class="card-body bg-light pb-0">
				<form>
					<div class="row gx-2">
						<div class="mb-3">
							<label class="form-label" for="registration-deadline">출근일</label>
							<input class="form-control datetimepicker" id="workDate" type="text" value="${today }" readOnly/>
						</div>
						<div class="mb-3">
							<label class="form-label" for="event-name">사번
							</label> <input class="form-control" id="event-name" type="text" value="${authEmp.empNo }" readOnly/>
						</div>
						<div class="mb-3">
							<label class="form-label" for="start-time">출근 시각</label>
							<input class="form-control datetimepicker" id="start-time" type="text" placeholder="--:--" value="${dclz.inTime}"  readOnly/>
						</div>
						<div class="mb-3">
							<label class="form-label" for="end-time">퇴근 시각</label> 
							<input class="form-control datetimepicker" id="end-time" type="text" placeholder="--:--" value="${dclz.outTime}" readOnly/>
						</div>
					</div>
					
					<div class="card-body">
						<div class="row justify-content-center">
							<div class="col-lg-8 text-center">
								<button class="btn btn-falcon-primary btn-sm px-3" type="button" data-bs-toggle="modal" data-bs-target="#scrollinglongcontent" style="margin-bottom:10px;">얼굴인식</button>
								<div class="modal fade" id="scrollinglongcontent" data-keyboard="false" tabindex="-1" aria-labelledby="scrollinglongcontentLabel" aria-hidden="true">
									<div class="modal-dialog">
										<div class="modal-content">
											<div class="modal-header bg-primary">
												<h5 class="modal-title" id="scrollinglongcontentLabel">얼굴인식</h5>
												<button class="btn-close" type="button" data-bs-dismiss="modal" aria-label="Close"></button>
											</div>
											<!--       <div class="modal-body p-0"> -->
												<div class="p-4 pb-0">
												<form>
													<div class="mb-3">
														<label class="form-label" for="recipient-name">사원번호</label>
														<input class="form-control" id="recipient-name" type="text" placeholder="E230001" value="${authEmp.empNo }" readonly/>
													</div>
													<div class="mb-3">
														<!--<button id="capture" class="btn btn-info" onclick="captureAndSend()">사진촬영</button> -->
														<br>
														<a class="btn btn-link btn-sm btn p-0" href="javascript:captureAndSend()" >얼굴 캡처 하기</a>
													</div>
													<div class="mb-3 go-btn">
														<!-- <label class="form-label" for="img">얼굴 등록</label> -->
														<label class="form-label" for="img">결과 : </label>
														<div class="go-btn" id="dclzResult"></div>
													</div>
													<!--<div><button class="btn btn-primary" id="liveToastBtn" type="button">hidden toast</button></div> -->
													<div class="mb-3">
														<video id="video" autoplay width= "400" height="300"></video>
													</div>
												</form>
												</div>
											<!--       </div> -->
											<div class="modal-footer">
												<button class="btn btn-secondary" type="button" data-bs-dismiss="modal">닫기</button>
												<button class="btn btn-primary" type="button" onclick="checkDclz()">출퇴근등록</button>
											</div>
										</div>
									</div>
								</div>
								<button class="btn btn-falcon-default btn-sm px-3 ms-2" type="button">출퇴근확정</button>
							</div>
						</div>
					</div>
					<a class="btn btn-link btn-sm btn p-0" href="<c:url value='/emp/pbl/dclz/yryc'/>">휴가신청
						<span class="fas fa-chevron-right ms-1 fs--2"></span>
					</a>
					<button class="btn btn-link btn-sm btn p-0 go-btn" type="button" data-bs-toggle="modal" data-bs-target="#commute-inquiry-modal">출퇴근문의
						<span class="fas fa-chevron-right ms-1 fs--2"></span>
					</button>
				</form>
			</div>
		</div>
	</div>
				
	<!-- 			출퇴근 문의 모달 -->
	<div class="modal fade" id="commute-inquiry-modal" tabindex="-1" role="dialog" aria-hidden="true">
		<div class="modal-dialog modal-dialog-centered" role="document" style="max-width: 500px">
			<div class="modal-content position-relative">
				<div class="position-absolute top-0 end-0 mt-2 me-2 z-index-1">
					<button class="btn-close btn btn-sm btn-circle d-flex flex-center transition-base" data-bs-dismiss="modal" aria-label="Close"></button>
				</div>
				<div class="modal-body p-0">
					<div class="rounded-top-lg py-3 ps-4 pe-6 bg-light">
						<h4 class="mb-1" id="modalExampleDemoLabel">출퇴근관련 문의 사항 보내기(미구현)</h4>
					</div>
					<div class="p-4 pb-0">
						<form>
							<div class="mb-3">
								<label class="col-form-label" for="recipient-name">발신자:</label>
								<input class="form-control" id="sender" type="text" />
							</div>
							<div class="mb-3">
								<label class="col-form-label" for="recipient-name">수신자(인사부직원이어야 함.):</label>
								<input class="form-control" id="receiver" type="text" />
							</div>
							<div class="mb-3">
								<label class="col-form-label" for="message-text">내용:</label>
								<textarea class="form-control" id="message-text"></textarea>
							</div>
						</form>
					</div>
				</div>
				<div class="modal-footer">
					<button class="btn btn-secondary" type="button" data-bs-dismiss="modal">닫기</button>
					<button class="btn btn-primary" type="button">문의요청하기</button>
				</div>
			</div>
		</div>
	</div>
</div>
		
		
		
<!-- toast -->

<div class="position-fixed bottom-0 end-0 p-3" style="z-index: 5">
	<div class="toast fade" id="liveToast" role="alert" aria-live="assertive" aria-atomic="true">
		<div class="toast-header bg-info text-white"><strong class="me-auto">오늘의 근태 기록</strong><small><span class="bi-bell-fill fs-10"></span></small>
			<div data-bs-theme="dark">
				<button class="btn-close" type="button" data-bs-dismiss="toast" aria-label="Close"></button>
			</div>
		</div>
		<div class="toast-body" id="toastContent">출근이 등록되었습니다. 오늘도 좋은 하루 되세요!</div>
	</div>
</div>

<script type="text/javascript">

const clock = document.querySelector("#now");


//실시간 시계
function getClock(){
	const d = new Date();
	const h = String(d.getHours()).padStart(2,"0");
	const m = String(d.getMinutes()).padStart(2,"0");
	const s = String(d.getSeconds()).padStart(2,"0");
// 	console.log(h,m,s);
// 	console.log(clock)
	clock.innerText = `\${h}:\${m}:\${s}`;
	
}

getClock(); //맨처음에 한번 실행
setInterval(getClock, 1000); //1초 주기로 새로실행




//얼굴인식 출퇴근을 위한 코드
var video = document.getElementById('video');
var canvas = document.createElement('canvas');
var context = canvas.getContext('2d');
var formData = new FormData();
var resultDiv = document.querySelector('#dclzResult');


var toastBtn = document.getElementById('liveToastBtn');



//화면에 웹캠을 보여주는 코드
navigator.mediaDevices.getUserMedia({ video: true }).then(function(stream) {
	video.srcObject = stream;
	video.play();
	
})
.catch(function(error) {
	console.error(error);
});


//얼굴 등록
function captureAndSend() {
	return new Promise(function(resolve, reject){
		var cnt = 0;
		var wantCnt = 50; //원하는 캡처 횟수
		
		function captureWantCnt() {
			canvas.width = video.videoWidth;
		    canvas.height = video.videoHeight;
		    context.drawImage(video, 0, 0, canvas.width, canvas.height);
		    canvas.toBlob(function(blob) {
				formData.append('file[]', blob, cnt+'.jpg');
				formData.append("wantCnt", wantCnt);
				cnt++;
				if(cnt<wantCnt) {
					setTimeout(captureWantCnt);
				} else {
					formData.append('empNo', "${authEmp.empNo}");	
					 
				}
				
				jQuery.ajax({
					url: "http://localhost:5000/cam_capture_upload.ajax",
// 		        	url: "http://192.168.141.5:5000/cam_capture_upload.ajax",
					processData: false,
					contentType: false,
					data: formData,
					type: "POST",
					success: function(response) {
			        	console.log("파이썬 ", response);
			        	resultDiv.innerHTML = `<span>\${response.result}</span>`;
			        	console.log("결과.....", response.result);
			        	if (response.result == "등록 완료"){
			        		//alert(response.result);
			        		setTimeout(() => location.replace("${pageContext.request.contextPath}/emp/hrm/dclz/dclzTime"), 3000);
			        		 Swal.fire({
									title:"등록 성공하였습니다!",
									icon:"success"
								})
			        	}else{
			        		
			        	}
			    	},
			    	error:function(xhr, status, error) {
			    		console.log(xhr,status, error);
			    	}
				});//파이썬 ajax 끝
			}, 'image/jpeg', 0.9);
		}
		captureWantCnt();
	}); //프로미스 종료, captureAndSend의 리턴값 반환 끝
	  
}



function checkDclz() {
    canvas.width = video.videoWidth;
    canvas.height = video.videoHeight;
    context.drawImage(video, 0, 0, canvas.width, canvas.height);
    canvas.toBlob(function(blob) {
		formData.append('file', blob, 'dclz.jpg');
		formData.append('empNo', "${authEmp.empNo}");
		formData.append('inTime', "${dclz.inTime}");
		formData.append('outTime', "${dclz.outTime}");
		jQuery.ajax({
        	url: "http://localhost:5000/dclz.ajax",
//         	url: "http://192.168.141.5:5000/dclz.ajax",
			processData: false,
			contentType: false,
			data: formData,
			type: "POST",
			success: function(response) {
				if(response.result == "성공") {
					resultDiv.innerHTML = `<span style="color : #1FDA11;">\${response.result}</span>`;
					var icon = "success";
					//location.replace("${pageContext.request.contextPath}/emp/hrm/dclz/dclzTime");
					setTimeout(() => location.replace("${pageContext.request.contextPath}/emp/hrm/dclz/dclzTime"), 3000);
	        		 
				}else{
					resultDiv.innerHTML = `<span style="color : #FF0000;">\${response.result}</span>`;
					icon = "error";
				}
	        	console.log("파이썬 ", response);
	        	formData.delete("file")
	        	//toastBtn.click();
	        	Swal.fire({
					title:`등록 \${response.result}하였습니다!`,
					icon:icon
				})
	        	
	        	
	        	
	    	}
		});
	}, 'image/jpeg', 0.9); 
}











// //Canvas
// (function loop(){
//     context.save();
//     context.scale(-1, 1);
//     context.translate(-400, 0);
//     context.drawImage(video, 0, 0, 400, 300);
//     context.restore(); 
//     requestAnimationFrame(loop);
// })();

								
// //카메라 비디오 연결
// navigator.mediaDevices.getUserMedia({ video: true })
// 					.then(function (stream) {
// 					    var video = document.getElementById('videoElement');
// 					    video.srcObject = stream;
// 					})
// 					.catch(function (err) {
// 					    console.log("An error occurred: " + err);
// 					});
					
// //얼굴 비디오 캡처
// function fnCaptureMyVideo() {
// 	event.preventDefault();
// 	//얼굴 사진 캡처
// 	var video = document.getElementById('videoElement');
// 	var rect = video.getBoundingClientRect();

// 	var x = rect.x;
// 	var y = rect.y;
// 	var width = video.offsetWidth;
// 	var height = video.offsetHeight;
// 	html2canvas(document.body).then(
// 			function(canvas) {
// 				//영상 화면 캡처
// 				var img = canvas.getContext('2d').getImageData(x, y, width, height);
// 				var c = document.createElement("canvas");
// 				c.width = width;
// 				c.height = height;
// 				c.getContext('2d').putImageData(img, 0, 0);
// 				console.log("컨버스 엘리먼트", c)
// 				save(c); 
// 			}
// 		);	
// }


// // 캡쳐한 이미지 저장
// function save(canvas) { 
// 	if (navigator.msSaveBlob) {
// 		var blob = canvas.msToBlob();
// 		return navigator.msSaveBlob(blob, 'myface.jpg');
// 	} else {
// 		var el = document.getElementById("target");
// 		el.href = canvas.toDataURL("image/jpeg");
// 		el.download = 'myface.jpg';
// 		el.click();
// 	}
// }



</script>
<script src="https://html2canvas.hertzen.com/dist/html2canvas.min.js"></script>
