<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<link rel="stylesheet" type="text/css" href="http://cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/css/toastr.min.css" />

<div class="col mb-3">
    <div class="card h-100">
        <div class="card-header">
            <div class="row flex-between-end">
                <nav style="--falcon-breadcrumb-divider: url(&#34;data:image/svg+xml,%3Csvg xmlns='http://www.w3.org/2000/svg' width='8' height='8'%3E%3Cpath d='M2.5 0L1 1.5 3.5 4 1 6.5 2.5 8l4-4-4-4z' fill='%23748194'/%3E%3C/svg%3E&#34;);" aria-label="breadcrumb">
                    <ol class="breadcrumb">
                        <li class="breadcrumb-item"><a href="${pageContext.request.contextPath}/emp/index.do">호텔관리</a></li>
                        <li class="breadcrumb-item active" aria-current="page">호텔오젠 프런트 CCTV</li>
                    </ol>
                </nav>
                <video id="video" width="640" height="650" autoplay></video> <!-- controls 속성 추가 -->
            </div>
        </div>
    </div>
</div>
                
<script>
    var cnt_human = 0;
    var cnt = 0;
    var startTime = new Date();
    console.log(startTime)

    function captureYolo() {
        cnt++;
        canvas.width = video.videoWidth;
        canvas.height = video.videoHeight;
        context.drawImage(video, 0, 0, canvas.width, canvas.height);
        canvas.toBlob(function(blob) {
            var formData = new FormData();
            formData.append('file', blob, 'image'+cnt+'.jpg');
            formData.append('mem_id', Math.random());
            jQuery.ajax({
                url: "http://localhost:5000/cam_capture_upload.ajax",
                processData: false,
                contentType: false,
                data: formData,
                type: "POST",
                success: function(response) {
                    response.flag
                    console.log("파이썬 ", response.flag);
                    if(response.flag=="Y"){
                        cnt_human++;
                    }else{
                        cnt_human = 0;
                    }
                    if(cnt_human>3){
                        toastrShow("손님 입장하셨습니다.")
                        cnt_human = 0;
                    }
                }
            });
        }, 'image/jpeg', 0.9);
    }
    var video = document.getElementById('video');
    var canvas = document.createElement('canvas');
    var context = canvas.getContext('2d');
       
    // MP4 파일 경로
    var mp4FilePath = "${pageContext.request.contextPath}/resources/assets/frontCCTV.mp4"; // 여기에 MP4 파일 경로를 입력하세요.

    // 비디오 엘리먼트에 MP4 파일 경로 설정
    video.src = mp4FilePath;

    function fn_loop(){
        setInterval(() => captureYolo(), 2000);
    }
    
    fn_loop();
    
    function toastrShow(title) {
        var nowTime = new Date() - startTime;
        
        var minutes = Math.floor(nowTime / (1000 * 60));
        
        toastr.options.closeButton = true; // 닫기 버튼 비활성화
        toastr.options.timeOut = 0; // 시간 초과를 0으로 설정하여 자동으로 사라지지 않음
        toastr.options.positionClass = "toast-bottom-right";
        toastr.options.preventDuplicates = false;
        toastr.options.newestOnTop = false;
        toastr.options.tapToDismiss = false;
        toastr.options.extendedTimeOut = 0;
        toastr.options.showEasing = 'swing';
        toastr.options.hideEasing = 'linear';
        toastr.options.closeEasing = 'linear';
        toastr.success(title + ' (' + minutes + '분 전)');
        
    };
    
    
</script>
<script type="text/javascript" src="http://cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/toastr.min.js"></script>
