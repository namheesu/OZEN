const cPath = document.body.dataset.contextPath;

$(document).ready(function() {
	
	let rqstEmpNo = $('.rqstEmpNo').attr('id');
	let realEmpNo = $('.empNo').val();
	let rqstSe = $('.rqstSe').text();
	
	let purEmpNo = $('.purEmpNo').attr('id');
	
	
	let $approvalBody = $("#approvalBody");
	let tags;
	
	console.log("rqstEmpNo",rqstEmpNo)
	console.log("realEmpNo",realEmpNo)
	console.log("rqstSe",rqstSe)
	
	if((rqstEmpNo != realEmpNo && purEmpNo != realEmpNo)
	){
		console.log("다름");
		tags = '';
	}else if(rqstSe == '요청대기'){
		console.log("같음");
		tags = `
		<div class="text-end">
			<a class="btn btn-outline-danger me-1 mb-1" type="button" onclick="refusalClick()">거부</a>
			<a class="btn btn-outline-info me-1 mb-1" type="button" onclick="approvalClick()">승인</a>
		</div>
		`;	
	}else if(rqstSe == '구매대기'){
		console.log("구매");
		tags = `
		<div class="text-end">
			<a class="btn btn-outline-danger me-1 mb-1" type="button" onclick="purBtnClick('N')">반려</a>
			<a class="btn btn-outline-info me-1 mb-1" type="button" onclick="purBtnClick('Y')">승인</a>
		</div>
		`;	
	}
	
	$approvalBody.append(tags);	
	
	$('.fxtrsAmnt').each(function() {
        // 텍스트 내용을 가져옵니다.
        var amount = $(this).text();

        var price = amount;
        var formattedPrice = Number(price).toLocaleString(); // 변환 후 쉼표 표기
        amount = formattedPrice;

        $(this).text(amount);
    });
	
    var totalAmnt = 0;
	var totalAmnt = 0;
    $('.fxtrsAmnt').each(function() {
	
		
		var amountText = $(this).text();
	
		var amnt = parseFloat(amountText.replace(/,/g, ''));
		console.log(amnt);
		totalAmnt += amnt;
		
    });
	var price = totalAmnt;
    var formattedPrice = Number(price).toLocaleString(); // 변환 후 쉼표 표기
    totalAmnt = formattedPrice;
    $('.fxtrsTotalAmnt').text(totalAmnt);

//	var purNm = document.getElementsByClassName('purEmpNo');
//	if(purNm[0].innerText != null){
//		purNm[0].innerText += ' 부장';
//	}
});

function approvalClick(){
	
	console.log("승인 누름");
	
	let fxRqstNo = $('.rqstNo').text();
	console.log("fxRqstNo",fxRqstNo);
		
	let url =  cPath + "/emp/pms/fxtrs/fxtrsUseApproval?fxRqstNo="+fxRqstNo;
	
	$.ajax({
		url: url,
		type: "POST",
		dataType : "json",
	    success: function(response) {
	        // 요청이 성공한 경우의 처리
	    	console.log("요청이 성공적으로 처리되었습니다.");
	    	console.log(response); // 서버에서 받은 응답 확인
			Swal.fire({
			    title: '요청서 승인',
			    text: '요청서 승인이 성공적으로 처리되었습니다.',
			    icon: 'success'
			}).then((result) => {
			    // SweetAlert 창이 닫힌 후에 실행될 코드
			    window.location.href = response;
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
	
	console.log("거부 누름");
	
	let fxRqstNo = $('.rqstNo').text();
	console.log("fxRqstNo",fxRqstNo);
		
	let url = cPath + "/emp/pms/fxtrs/fxtrsUseRefusal?fxRqstNo="+fxRqstNo;
	
	$.ajax({
		url: url,
		type: "POST",
		dataType : "json",
	    success: function(response) {
	        // 요청이 성공한 경우의 처리
	    	console.log("요청이 성공적으로 처리되었습니다.");
	    	console.log(response); // 서버에서 받은 응답 확인
			Swal.fire({
			    title: '요청서 반려',
			    text: '요청서 반려가 성공적으로 처리되었습니다.',
			    icon: 'success'
			}).then((result) => {
			    // SweetAlert 창이 닫힌 후에 실행될 코드
			    window.location.href = response;
			});
			
 			window.location.href = response;
	  	},
	  	error: function(xhr, status, error) {
	     	 // 요청이 실패한 경우의 처리
	      	console.error("요청을 처리하는 도중 오류가 발생했습니다.");
	      	console.error(error); // 발생한 오류 출력
	  	}
	});
};

function purBtnClick(cd){
	
	let fxRqstNo = $('.rqstNo').text();
	let url = cPath + "/emp/pms/fxtrs/fxtrsPur?fxRqstNo="+fxRqstNo;
	
	$.ajax({
		url:url
		, type:"POST"
		, dataType : "json"
		, data : JSON.stringify(cd)
		, contentType:"application/json"
		, success : function(response){
			console.log("요청이 성공적으로 처리되었습니다.",cd);
		if(cd ==="Y"){
			Swal.fire({
			    title: '비품구매가 완료되었습니다.',			
			    icon: 'success',
				confirmButtonText:"확인",
				allowOutsideClick : false
			}).then((result) => {
				if(result.isConfirmed){
			    window.location.href = cPath+'/emp/pbl/oprtnstts/oprtnsttsList.do' ;
				}
			});
			}else{
			Swal.fire({
			    title: '반려가 완료되었습니다.',			
			    icon: 'success',
				confirmButtonText:"확인",
				allowOutsideClick : false
			}).then((result) => {
			    if(result.isConfirmed){
			   window.location.href = cPath+'/emp/pbl/oprtnstts/oprtnsttsList.do' ;
				}
			});
			}
			
			
		},
		error : function(xhr, status, error){
			console.error("요청을 처리하는 도중 오류가 발생했습니다.");
			console.error(error);
		}
	});
	
}