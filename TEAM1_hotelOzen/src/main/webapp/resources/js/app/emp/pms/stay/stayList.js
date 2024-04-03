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
					let ciSeCd = null;
					
					if(chkout.chkin.ciSeCd === 'R'){
						ciSeCd = '예약';
					}else if(chkout.chkin.ciSeCd === 'W'){
						ciSeCd = '워크인';
					};
					
					let coExcclc = null;
					
					if(chkout.coExcclcYn === 'Y'){
						coExcclc = '투숙중';
					}else if (chkout.coExcclcYn === 'N'){
						coExcclc = '투숙완료';
					};
					
					trTags += `
						<tr>
							<td class="rnum align-middle wdf">${chkout.rnum }</td>
							<td class="rsvtNo align-middle">
								<a href="#" class="stayListLink" data-chkin-no="${chkout.chkinNo }">${chkout.chkinNo }</a>
							</td>
							<td class="chkinType">${ciSeCd }</td>
							<td class="cstNm align-middle">${chkout.chkin.cstmr.cstNm }</td>
							<td class="rsvtYmd align-middle">${chkout.chkin.ciDt }</td>
							<td class="rsvtCheckinYmd align-middle">${chkout.chkin.ciCowillYmd }</td>
							<td class="rmtTypeCd align-middle">${chkout.chkin.rmNo }</td>
							<td class="rsvtAdultCnt align-middle">${chkout.chkin.ciCarNo }</td>
							<td class="stayState align-middle">${coExcclc }</td>
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
        let url = './stayList/modal?chkinNo=' + chkinNo;

        // AJAX 요청을 통해 컨트롤러에 해당 예약번호를 전달하고 데이터를 받아옵니다.
        $.ajax({
            type: 'GET',
            url: url,
            dataType: "json",
            success: function (jsonObj) {
                let stay = jsonObj.stay;
                console.log("stay",stay);

                let order = jsonObj.order;
                console.log("order",order);
				
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
                        <div class="col-sm-12 text-end">
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

});






