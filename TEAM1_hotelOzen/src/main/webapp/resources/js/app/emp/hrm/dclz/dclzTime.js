/**
 * 
 */


const clock = document.querySelector("#now");


//실시간 시계
function getClock(){
	const d = new Date();
	const h = String(d.getHours()).padStart(2,"0");
	const m = String(d.getMinutes()).padStart(2,"0");
	const s = String(d.getSeconds()).padStart(2,"0");
// 	console.log(h,m,s);
// 	console.log(clock)
	clock.innerText = `${h}:${m}:${s}`;
	
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
			        	resultDiv.innerHTML = `<span>${response.result}</span>`;
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
					resultDiv.innerHTML = `<span style="color : #1FDA11;">${response.result}</span>`;
					var icon = "success";
					//location.replace("${pageContext.request.contextPath}/emp/hrm/dclz/dclzTime");
					setTimeout(() => location.replace("${pageContext.request.contextPath}/emp/hrm/dclz/dclzTime"), 3000);
	        		 
				}else{
					resultDiv.innerHTML = `<span style="color : #FF0000;">${response.result}</span>`;
					icon = "error";
				}
	        	console.log("파이썬 ", response);
	        	formData.delete("file")
	        	//toastBtn.click();
	        	Swal.fire({
					title:`등록 ${response.result}하였습니다!`,
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


