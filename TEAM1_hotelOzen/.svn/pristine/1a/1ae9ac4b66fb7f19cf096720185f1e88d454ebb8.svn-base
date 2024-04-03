/**
 * 
 */


const cPath = document.body.dataset.contextPath;
$(document).ready(function() {
	
	let rqstEmpNo = $('.rqstEmpNo').attr('id');
	let realEmpNo = $('.empNo').val();
	let rqstSe = $('.rqstSe').text();
	
	let $approvalBody = $("#approvalBody");
	let tags;
	
//	console.log("rqstEmpNo",rqstEmpNo)
//	console.log("realEmpNo",realEmpNo)
//	console.log("rqstSe",rqstSe)
	
	if(rqstEmpNo != realEmpNo){
		console.log("다름");
		tags = '';
	}else if(rqstSe == '대기'){
		console.log("같음");
		tags = `
		<div class="text-end">
			<a class="btn btn-outline-danger me-1 mb-1" type="button" onclick="refusalClick()">반려</a>
			<a class="btn btn-outline-info me-1 mb-1" type="button" onclick="approvalClick()">승인</a>
		</div>
		`;	
	}

	$approvalBody.append(tags);	
	
//	var currentDate = new Date();
//    var formattedDate = currentDate.getFullYear() + '-' + (currentDate.getMonth() + 1).toString().padStart(2, '0') + '-' + currentDate.getDate().toString().padStart(2, '0');
//    $('.ymd').text(formattedDate);
	
});

function approvalClick(){
	console.log("승인 누름");
	
	let anlLeaUseNo = $('.rqstNo').text();
	console.log("anlLeaUseNo",anlLeaUseNo);
	console.log(event.target);
	var aTag = event.target;
	
	var rqstSe = aTag.innerText;
	var data = {'anlLeaUseNo': anlLeaUseNo, 'rqstSe': rqstSe, 'anlLeaInfo': "V"}
	data = JSON.stringify(data);
	console.log(data);
		
	let url = cPath+"/emp/pbl/dclz/yryc/"+anlLeaUseNo;
	
	$.ajax({
		url: url
		, type: "POST"
		, data: data
		, contentType : "application/json"
		, dataType : "json"
	    , success: function(response) {
	        // 요청이 성공한 경우의 처리
	    	console.log("요청이 성공적으로 처리되었습니다.");
	    	console.log(response); // 서버에서 받은 응답 확인
			Swal.fire({
			    title: '연차 승인',
			    text: '연차 승인이 성공적으로 처리되었습니다.',
			    icon: 'success'
			}).then((result) => {
			    // SweetAlert 창이 닫힌 후에 실행될 코드
			    window.location.href = cPath + "/"+response;
			});
 			
	  	},
	  	error: function(xhr, status, error) {
	     	 // 요청이 실패한 경우의 처리
	      	console.error("요청을 처리하는 도중 오류가 발생했습니다.");
	      	console.error(error); // 발생한 오류 출력
	  	}
	});
};

function refusalClick(){
	console.log("반려 누름");
	
	Swal.fire({
		title: '반려사유를 입력하세요.',
		input: 'text',
		inputAttributes: {
		autocapitalize: 'off'
	},
	showCancelButton: true,
	confirmButtonText: '반려',
	showLoaderOnConfirm: true,
	preConfirm: (reason) => {
	
		var anlLeaUseNo = $('.rqstNo').text();
		var aTag = event.target;
		var rqstSe = aTag.innerText;
		var anlLeaInfo = reason;
		var data = {'anlLeaUseNo': anlLeaUseNo, 'rqstSe': rqstSe, 'anlLeaInfo': anlLeaInfo}
		data = JSON.stringify(data);
		let url = cPath+"/emp/pbl/dclz/yryc/"+anlLeaUseNo;
	
	return fetch(url, {
			method: 'POST'
			, headers: {
			'accept' : 'application/json'
			, "Content-Type": "application/json" 
			},
			body : data
		}).then(response => {
			if (!response.ok) {
				throw new Error(response.statusText)
			}
			return response.json()
		})
		.catch(error => {
			Swal.showValidationMessage(
				`Request failed: ${error}`
			)
		})
	},
		allowOutsideClick: () => !Swal.isLoading()
	}).then((result) => {
		console.log(result);
		if (result.isConfirmed) {
				Swal.fire({
				title: '정상적으로 반려 처리 되었습니다.'
				, icon: 'success'
				, closeOnClickOutside : false
			}).then(function(){
				console.log(result.value);
				window.location.href = cPath + "/"+result.value;
			});
		}
	})
};