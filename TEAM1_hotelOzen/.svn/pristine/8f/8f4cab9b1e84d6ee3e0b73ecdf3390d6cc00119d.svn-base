const cPath = document.body.dataset.contextPath;

$(document).ready(function() {
    var currentDate = new Date();
    var formattedDate = currentDate.getFullYear() + '-' + (currentDate.getMonth() + 1).toString().padStart(2, '0') + '-' + currentDate.getDate().toString().padStart(2, '0');
    $('.ymd').text(formattedDate);
    // 현재 페이지 URL 가져오기
    var currentUrl = window.location.href;
    console.log('현재 페이지 URL:', currentUrl);

    var queryString = currentUrl.split('?')[1]; // URL에서 '?' 이후의 부분을 추출

    var checkedItems;
    if (queryString) {
        var queryParams = queryString.split('&');
        console.log('쿼리 파라미터 배열:', queryParams);
        
        var data = {};
        
        queryParams.forEach(function(param) {
            var parts = param.split('=');
            var key = decodeURIComponent(parts[0]); 
            var value = decodeURIComponent(parts.slice(1).join('=')); 
            
            data[key] = value;
        });

        console.log('data:', data);
        
        checkedItems = data.checkedItems; 
        console.log('checkedItems:', checkedItems); 
    } else {
        console.log('쿼리 파라미터가 없습니다.');
    }

    let url = currentUrl;

    console.log('checkedItems:', checkedItems); 
    $(document).ready(function() {
	    $.ajax({
	        url: './rqstListadd.do', 
	        method: 'POST', 
	        data: { checkedItems: checkedItems }, // 쿼리 파라미터로 checkedItems 전송
	        dataType: 'json',
	        success: function(jsonObj) {
	            console.log("jsonObj:",jsonObj);
	            let fxtrs = jsonObj.fxtrsList;
	            
	            let $fxRqstListBody = $("#fxRqstListBody");
	            let fxrqstTags = '';
	            
				let fxTotalAmnt;
	
				$('.hkp-dpm-Nm').text(jsonObj.fxRqstEmp.empNm + "  부장");
				$('.hkp-dpm-Nm').each(function() {
				    var empNo = jsonObj.fxRqstEmp.empNo; // jsonObj.fxRqstEmp.empNo로부터 값을 가져옴
				    $(this).attr('id', empNo); // 요소에 id 속성을 추가하고 값을 설정
					$('#empRqNo').attr('value',empNo);
				});
			
				
	            fxtrs.forEach(function(fxtrs) {
	                console.log(fxtrs);
					
					rqdQty = fxtrs.fxTtrtnCnt - fxtrs.fxPresCnt

	                txrqstTags = `
	                    <tr class="fxtrsRqstList">
	                        <td class="fxDelete">
	                            <i class="fas fa-times" style="vertical-align: middle;"></i>
	                        </td>
	                        <td class="fxCd">${fxtrs.fxCd}</td>
	                        <td >${fxtrs.fxNm}</td>
	                        <td class="presCnt">${fxtrs.fxPresCnt}</td>
	                        <td class="fxTtrtnCnt">${fxtrs.fxTtrtnCnt}</td>
	                        <td class="fxTtrtnCnt" style="color: red;">${rqdQty}</td>
	                        <td class="fxUnit">${fxtrs.fxUnit}</td>
	                        <td>
	                            <input type="number" class="inpWidth fxudCnt">
	                        </td>
	                        <td class="totalCnt"></td>
	                        <td class="totalAmnt"></td>
							<input type="hidden" class="amnt" value="${fxtrs.fxAmnt}">
	                    </tr>
	                `;         
					
	
	                $fxRqstListBody.append(txrqstTags);
	            });
	
				totalAmntTags = `
					<tr>
						<th colspan="5"> 총 가격</th>
						<td colspan="5" class="fxTotalAmnt">0</td>
					</tr>				
				`;					
					
				$fxRqstListBody.append(totalAmntTags);         
	
	            $(document).on('click', '.fxDelete', function() {
	                $(this).closest('tr').remove(); // 부모 tr 요소를 찾아서 제거합니다.
	            });
	
	            // ajax 성공 이후에 .fxudCnt 요소에 대한 이벤트 리스너 추가
	            $('.fxudCnt').on('input', function() {
				    var inputVal = $(this).val();
				    var fxTtrtnCnt = $(this).closest('tr').find('.fxUnit').text();
				    var totalVal = inputVal * fxTtrtnCnt;
				    $(this).closest('tr').find('.totalCnt').text(totalVal);
				
				    var fxAmnt = $(this).closest('tr').find('input.amnt').val();
				
				    var totalAmnt = inputVal * fxAmnt;
				
				    var formattedPrice = Number(totalAmnt).toLocaleString(); // 총 금액을 쉼표가 있는 형식으로 변환
				
				    $(this).closest('tr').find('.totalAmnt').text(formattedPrice);
				
				    // 총 금액을 다시 계산하여 출력
				    var fxTotalAmnt = 0;
				    $('.totalAmnt').each(function() {
				        var totalAmntText = $(this).text();
				        var totalAmntValue = parseFloat(totalAmntText.replace(/,/g, '')); // 쉼표 제거 후 변환
				        if (!isNaN(totalAmntValue)) {
				            fxTotalAmnt += totalAmntValue;
				        }
				    });
				    var formattedTotalAmnt = Number(fxTotalAmnt).toLocaleString(); // 변환 후 쉼표 표기
				    $('.fxTotalAmnt').text(formattedTotalAmnt);
				});

	        },
	        error: function(xhr, status, error) {
	            // 요청이 실패했을 때 수행할 작업
				Swal.fire({
					title:'신청 실패!',
					text:'요청서를 제출하는데 실패하였습니다.',
					icon:"success"
				});
	            console.error('요청 실패:', status, error);

	        }
	    });
	});

});

function myclick(){
	
	console.log("제출 누름");

	$('.inpWidth').each(function() {
        if ($(this).val() === '') {
            Swal.fire({
				title:'제출 실패!',
				text:'비품 수량을 입력해주세요.',
				icon:"error"
			});

        }
    });

	var fxtrsData = []; 
	
	let rqstNo =  $('.rqstNo').text(); //요청일련번호
	let ymd =  $('.ymd').text(); //요청일련번호
	let empNo = $('.empNm').attr('id') // 요청자 사번
	let fxTotalAmnt = $('.fxTotalAmnt').text(); // 총가격
	fxTotalAmnt = parseFloat(fxTotalAmnt.replace(/,/g, '')); // 쉼표 제거 후 변환
	fxTotalAmnt = fxTotalAmnt.toString();
	let empRqNo = $('.hkp-dpm-Nm').attr('id') // 요청결재자 사번
	empRqNo = empRqNo.replace('부장', '');
	
	console.log(rqstNo,empNo,fxTotalAmnt,empRqNo)
	
	$('.fxtrsRqstList').each(function() {
	    let fxCd = $(this).find('.fxCd').text(); //비품코드
	    let fxudCnt = $(this).find('.fxudCnt').val(); // 수량
	    let totalAmnt = $(this).find('.totalAmnt').text(); // 비품별 총 가격
		totalAmnt = parseFloat(totalAmnt.replace(/,/g, '')); // 쉼표 제거 후 변환
		totalAmnt = totalAmnt.toString();

	    var fxItem = {
	        rqstNo: rqstNo,
	        empNo: empNo,
	        fxTotalAmnt: fxTotalAmnt,
	        empRqNo: empRqNo,
			ymd:ymd,

			fxCd: fxCd,
			fxudCnt : fxudCnt,
			totalAmnt : totalAmnt,

	    };
	    console.log("fxItem",fxItem);
	 	fxtrsData.push(fxItem);
    });
    console.log("fxtrsData",fxtrsData);
    
	let url = cPath + "/emp/pms/fxtrs/fxtrsRqst";

	$.ajax({
		url: url,
		type: "POST",
		contentType: "application/json", // JSON 형식으로 데이터를 전송
  		data: JSON.stringify({"fxtrsData": fxtrsData}), // 데이터를 JSON 문자열로 변환하여 전송
	    success: function(response) {
	        // 요청이 성공한 경우의 처리
	    	console.log("요청이 성공적으로 처리되었습니다.");
	    	Swal.fire({
			    title: '신청완료 성공',
			    text: '비품 요청서 신청서가 성공적으로 처리되었습니다.',
			    icon: 'success'
			}).then((result) => {
	 			window.location.href = response;
			});
//			alert("성공");
	  	},
	  	error: function(xhr, status, error) {
	     	 // 요청이 실패한 경우의 처리
	      	Swal.fire({
			    title: '신청완료 실패',
			    text: '비품 요청서 신청서가 실패하였습니다.',
			    icon: 'error'
			}).then((result) => {
                location.reload();
			});
	  	}
	});
};