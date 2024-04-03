const cPath = document.body.dataset.contextPath;

$(searchForm).on("submit", function(event){
	let form = this;
	let url = form.action;
	let method = form.method;
	let data = $(form).serialize();
	let $listBody = $(listBody);
	let $pagingArea = $(pagingArea);
	
	$.ajax({
		url : url
		, method : method
		, data : data
		, dataType : "json"
		, success: function(jsonObj) {
            $listBody.empty();
			$pagingArea.empty();

			let dataList = jsonObj.stayList;
			let pagingHTML = jsonObj.pagingHTML;
			
			console.log(dataList)
			
			let trTags = null;
			
			if(dataList.length > 0){
				$.each(dataList, function(index, chkout){
					
					trTags += `
						<tr>
							<td class="rnum align-middle wdf">${chkout.rnum }</td>
							<td class="rsvtNo align-middle">
								<a href="#" class="stayListLink" data-chkin-no="${chkout.chkinNo }">${chkout.chkinNo }</a>
							</td>
							<td class="cstNm align-middle">${chkout.chkin.cstmr.cstNm }</td>
							<td class="rsvtYmd align-middle">${chkout.chkin.ciDt }</td>
							<td class="rsvtCheckinYmd align-middle">${chkout.chkin.ciCowillYmd }</td>
							<td class="rmtTypeCd align-middle">${chkout.chkin.rmNo }</td>
							<td class="rsvtAdultCnt align-middle">${chkout.chkin.ciCarNo }</td>
						</tr>	
					`;
				});
			}else{
				trTags = `
					<tr>
						<td colspan="8">조건에 맞는 투숙내역이 없음.</td>
					</tr>
				`;
			}
		
			$listBody.append(trTags);
			$pagingArea.append(pagingHTML);
			
		}, error : function(jqXHR, txt, status){
			console.log(txt, status, jqXHR);
		}
	}).done(()=>{
		form.page.value="";
	});
	return false;
}).submit();

let chkinNo;

$(document).ready(function () {
    $(document).on('click', '.stayListLink', function (e) {
		event.preventDefault(); // 기본 폼 제출 방지
        var chkinNo = $(this).data('chkin-no'); // 클릭된 예약번호
        let url = './nowStayList/modal?chkinNo=' + chkinNo;

        // AJAX 요청을 통해 컨트롤러에 해당 예약번호를 전달하고 데이터를 받아옵니다.
        $.ajax({
            type: 'GET',
            url: url,
            dataType: "json",
            success: function (jsonObj) {
                stay = jsonObj.stay;
                console.log(stay);
				
				let order = jsonObj.order;
				
				chkinNo = stay.chkinNo;

                let rmsTags = '';
				let rmsTrTags = '';
                if (typeof order !== 'undefined') {
					$.each(order.rmServiceDList, function(index, orderList){
						console.log("orderList",orderList);
						
						var price = orderList.rmService.rsAmnt;
		                var formattedPrice = Number(price).toLocaleString(); // 변환 후 쉼표 표기
		                orderList.rmService.rsAmnt = formattedPrice;

						rmsTrTags += `
							<tr>
                                <td>${orderList.rsCd}</td>
                                <td>${orderList.rmService.rsMenuNm}</td>
                                <td>${orderList.rsdDtlCnt}</td>
                                <td>${orderList.rmService.rsAmnt}</td>
                            </tr> 
						`;
					});
					
					var price = order.rsodSetleAmnt;
	                var formattedPrice = Number(price).toLocaleString(); // 변환 후 쉼표 표기
	                order.rsodSetleAmnt = formattedPrice;
					
                    rmsTags = `
                        <td>
                            <table class="table table-bordered text-center custom-body-table-bd">
                                <tbody class="custom-th-bg custom-body-td-size4">
                                    <tr>
                                        <th>룸서비스 코드</th>
                                        <th>룸서비스 이름</th>
                                        <th>수량</th>
                                        <th>가격</th>
                                    </tr>
                                    ${rmsTrTags}    
                                    <tr>
                                        <th colspan="2">총 가격</th>
                                        <td colspan="2">${order.rsodSetleAmnt}</td>
                                    </tr>
                                <tbody>
                            </table>
                        </td>
                    `;
                } else {
                    rmsTags = `
                        <td>
                            룸서비스 이용내역이 없습니다.
                        </td>
                    `;
                }
                let modalHeader = `
                    <table class="table table-bordered text-center custom-body-table-bd">
                        <tbody class="custom-th-bg custom-body-td-size4">
                            <tr>
                                <th id="chkinNo">체크인번호</th>
                            </tr>
                            <tr>
                                <td>${stay[0].chkinNo}</td>
                            </tr>
                        </tbody>
                    </table>
                    <table class="table table-bordered text-center custom-body-table-bd">
                        <tbody class="custom-th-bg custom-body-td-size3">
                            <tr>
                                <th>고객이름</th>
                                <th>휴대폰</th>
                                <th>차량번호</th>
                            </tr>
                            <tr>
                                <td>${stay[0].chkin.cstmr.cstNm}</td>
                                <td>${stay[0].chkin.cstmr.cstHp}</td>
                                <td>${stay[0].chkin.ciCarNo}</td>
                            </tr>
                        </tbody>
                    </table>
                    <table class="table table-bordered text-center custom-body-table-bd">
                        <tbody class="custom-th-bg">
                            <tr>
                                <th>체크인시간</th>
                                <th>퇴실일</th>
                                <th>객실종류</th>
                                <th>객실호수</th>
                            </tr>
                            <tr>
                                <td>${stay[0].chkin.ciDt}</td>
                                <td>${stay[0].chkin.ciCowillYmd}</td>
                                <td>${stay[0].chkin.room.rmtTypeCd}</td>
                                <td>${stay[0].chkin.rmNo}</td>
                            </tr>
                        </tbody>
                    </table>
                    <table class="table table-bordered text-center custom-body-table-bd">
                        <tbody class="custom-th-bg custom-body-td-size3">
                            <tr>
                                <th>룸서비스 이용내역</th>
                            </tr>
                            <tr>
                                ${rmsTags}
                            </tr>
                        </tbody>
                    </table>
                    <div class="row">
                        <div class="col-sm-6">
                            <button class="btn btn-outline-success  me-1 mb-1 rmSvc" type="button">룸서비스 이용</button>
                        </div>
                        <div class="col-sm-6 text-end">
                            <button class="btn btn-outline-secondary me-1 mb-1 " 
                                data-bs-dismiss="modal" type="button">확인</button>
                        </div>
                    </div>
                `;
                $('#stayList-select .modal-body').html(modalHeader);
                $('#stayList-select').modal('show'); // 모달 띄우기
            },
            error: function () {
                alert('데이터를 불러오는 중 오류가 발생했습니다.');
            }

        });
    });


	let selectTdTags = '';
	let selectOption = '';
	
	$(document).on('click', '.rmSvc', function (e) {
	    e.preventDefault(); // 기본 폼 제출 방지
	    e.stopPropagation(); // 모달이 닫히지 않도록 이벤트 전파 중지
			

		$("#roomServiceTable").removeClass("d-none").addClass("d-block");
		
		let url = cPath+"/emp/pms/roomSvc/rmSvc";
		console.log(url);
		
	    $("#roomServiceTable").on('click', function(e) {
	        e.stopPropagation();
	    });
		
		$.ajax({
		    type: 'POST',
		    url: url,
		    dataType: "json",
		    success: function (jsonObj) {
		        dataList = jsonObj.rmSvcList;
		        console.log(jsonObj.rmSvcList);
		        
		        if (dataList.length > 0) {
		             $.each(dataList, function(index, rmSvc){
		                var option = `<option value="${rmSvc.rsCd}">${rmSvc.rsMenuNm}</option>`;
		                var selectElement = $('.rmsAdd:last').find('.rmSvcSelectList'); // 마지막으로 추가된 행의 select 엘리먼트 찾기
		                
		                selectElement.append(option);
		            });
		
		        }
	            // select 엘리먼트 변경 이벤트 처리
	            $('.rmSvcSelectList').change(function() {
	                var selectedValue = $(this).val();
	                var tdElement = $(this).closest('tr').find('td:first-child');
	                tdElement.text(selectedValue);
	            });
				$(".rmSvcMenuAdd").click();
		    },
		    error: function () {
		        alert('데이터를 불러오는 중 오류가 발생했습니다.');
		    }
		});
		

		return false;
	});	
	
	$('.rmSvcMenuAdd').on('click', function(event) {
	    event.preventDefault(); // 기본 폼 제출 방지
	    console.log("추가버튼 누름");
	    
	    // 새로운 행 추가
	    var newRow = `
	        <tr class="rmSvcOrderList">
	            <td></td>
	            <td>
	                <select class="rmSvcSelectList">
	                    <option value="">-- 룸서비스 명 --</option>
	                </select>
	            </td>
	            <td>
	                <input type="number"/>
	            </td>
	        </tr>
	    `;
	    $('.rmsAdd').before(newRow);
	    
	    // dataList의 옵션 추가
	    if (dataList.length > 0) {
	        $.each(dataList, function(index, rmSvc){
	            var option = `<option value="${rmSvc.rsCd}">${rmSvc.rsMenuNm}</option>`;
	            var selectElement = $('.rmsAdd').prev().find('.rmSvcSelectList');
	            selectElement.append(option);
	        });
	
	    }
	    
	    // select 엘리먼트 변경 이벤트 처리
	    $('.rmSvcSelectList').change(function() {
	        var selectedValue = $(this).val();
	        var tdElement = $(this).closest('tr').find('td:first-child');
	        tdElement.text(selectedValue);
	    });
	});


});


function myclick(){
	
	let url = cPath + "/emp/pms/roomSvc/rmSvcAdd";
	console.log("주문버튼 누름");
	var orderData = []; // 룸서비스 주문 데이터를 담을 배열
    var tbody = $('.custom-th-bg.custom-body-td-size3');
	
    // chkinNo 값을 가져오기 위한 코드
    var chkinNo = $('#chkinNo').closest('tbody').find('tr:nth-child(2) td').text();
    console.log("체크인번호: " + chkinNo);

	// 각 tr.rmSvcOrderList 요소에 대해 반복합니다.
	tbody.find('tr.rmSvcOrderList').each(function() {
	    var rmSvcCode = $(this).find('td:first-child').text();
	    var rmSvcName = $(this).find('.rmSvcSelectList option:selected').text();
	    var quantity = $(this).find('input[type="number"]').val();
        
        // 룸서비스 코드, 룸서비스명, 수량을 객체로 만들어 배열에 추가
        var orderItem = {
            rsCd: rmSvcCode,
            rsdDtlCnt: quantity,
			chkinNo : chkinNo
        };
    
        orderData.push(orderItem);
    });
    
    console.log(orderData);

    // AJAX 요청
    $.ajax({
        url: url,
        type: "POST",
        contentType: "application/json", // JSON 형식으로 데이터를 전송
		data: JSON.stringify(orderData), // 데이터를 JSON 문자열로 변환하여 전송
        success: function(response) {
            // 요청이 성공한 경우의 처리
            console.log("주문이 성공적으로 처리되었습니다.");
			Swal.fire({
				title:'룸서비스 주문.',
				text:'룸서비스 주문이 성공적으로 처리되었습니다.',
				icon:"success"
			});
        },
        error: function(xhr, status, error) {
            // 요청이 실패한 경우의 처리
            console.error("주문을 처리하는 도중 오류가 발생했습니다.");
        }
    });

	$("#roomServiceTable").removeClass("d-block").addClass("d-none");
	
	$('.rmSvcOrderList').remove();
	
	$('#stayList-select').modal('hide');
		
  }



