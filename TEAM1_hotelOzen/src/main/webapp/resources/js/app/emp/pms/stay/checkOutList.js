$(searchForm).on("submit", function(event){
	event.preventDefault();
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

		let dataList = jsonObj.chkoutList;
		let pagingHTML = jsonObj.pagingHTML;
		
		console.log(dataList)
		
		var currentDate = new Date();
			
		var year = currentDate.getFullYear();
		var month = (currentDate.getMonth() + 1).toString().padStart(2, '0');
		var day = currentDate.getDate().toString().padStart(2, '0');
		var sysdate = year + "-" + month + "-" + day;
		
		let checkOutYmdTag;
		
		let trTags = null;
		
		if(dataList.length > 0){
			$.each(dataList, function(index, chkout){
				if(chkout.chkin.ciCowillYmd < sysdate){
					checkOutYmdTag = `
						<td class="rsvtCheckinYmd align-middle" style="color:red">${chkout.chkin.ciCowillYmd }</td>
					`
				}else{
					checkOutYmdTag = `
						<td class="rsvtCheckinYmd align-middle">${chkout.chkin.ciCowillYmd }</td>
					`
				}
				
				var price = chkout.rmsOrder[0].rsodSetleAmnt;
                var formattedPrice = Number(price).toLocaleString(); // 변환 후 쉼표 표기
                chkout.rmsOrder[0].rsodSetleAmnt = formattedPrice;
				
				trTags += `
					<tr>
						<td class="rnum align-middle wdf">${chkout.rnum }</td>
						<td class="chkinNo align-middle">
							<a href="#" class="chkoutNoLink" data-chkin-no="${chkout.chkinNo }">${chkout.chkinNo }</a>
						</td>
						<td class="cstNm align-middle">${chkout.chkin.cstmr.cstNm }</td>
						<td class="ciDt align-middle">${chkout.chkin.ciDt }</td>
						${checkOutYmdTag}
						<td class="rmNo align-middle">${chkout.chkin.rmNo }</td>
						<td class="rsodSetleAmnt align-middle">${chkout.rmsOrder[0].rsodSetleAmnt }</td>
						<td class="ciCarNo align-middle">${chkout.chkin.ciCarNo }</td>
					</tr>	
				`;
			});
		}else{
			trTags = `
				<tr>
					<td colspan="8">조건에 맞는 체크아웃내역이 없음.</td>
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

// 예약번호를 클릭할 때마다 모달을 열고 해당 예약번호를 전달하는 JavaScript 함수
$(document).ready(function () {
	$(document).on('click', '.chkoutNoLink', function (e) {
        e.preventDefault(); // 기본 링크 이벤트 방지

        var chkinNo = $(this).data('chkin-no'); // 클릭된 예약번호
		
		console.log("chkinNo", chkinNo)
		let url = './chkoutList/modal?chkinNo='+chkinNo;
		
        // AJAX 요청을 통해 컨트롤러에 해당 예약번호를 전달하고 데이터를 받아옵니다.
        $.ajax({
            type: 'GET'
            ,url: url
			, dataType : "json"
            , success: function (jsonObj) {
				console.log(jsonObj)
				chkout = jsonObj.chkout;
				chkoutRms = jsonObj.chkoutRms;
				console.log(chkout)
				console.log(chkoutRms)
	                // 받아온 데이터를 모달 내부에 채워넣습니다.
				let trTags= "";
				let rmsTags = '';
				
				let Amnt;
				
				if(chkoutRms.length > 0){ //룸서비스 내역이 있는 경우
					Amnt = chkoutRms[0].rmsOrder[0].rsodSetleAmnt;
					$.each(chkoutRms, function(index, chkoutRms){
						
						if(chkoutRms.rmsOrder[0].rmServiceDList.length > 0){
							$.each(chkoutRms.rmsOrder[0].rmServiceDList, function(index, chkoutRmsDTL){
								
								Amnt = 
										chkoutRms.rmsOrder[0].rmServiceDList[index].rsdDtlCnt * chkoutRms.rmsOrder[0].rmServiceDList[index].rmService.rsAmnt;
								
								var price = Amnt;
					            var formattedPrice = Number(price).toLocaleString(); // 변환 후 쉼표 표기
					            Amnt = formattedPrice;
								trTags += `
									<tr>
										<td>${chkoutRms.rmsOrder[0].rmServiceDList[index].rsCd}</td>
										<td>${chkoutRms.rmsOrder[0].rmServiceDList[index].rmService.rsMenuNm}</td>
										<td>${chkoutRms.rmsOrder[0].rmServiceDList[index].rsdDtlCnt}</td>
										<td>${Amnt}</td>
									</tr>	
								`;
							});
						};
					});
					
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
									<tr>
										${trTags}
									</tr>	
									<tr>
										<th colspan="2">총 가격</th>
										<td colspan="2">${Amnt}</td>
									</tr>
								<tbody>
							</table>
						</td>
					`
				}else{
					rmsTags = `
						<td>
							룸서비스 이용내역이 없습니다.
						</td>
					`
				}				
				
				let modalHeader = `
					<table class="table table-bordered text-center custom-body-table-bd">
						<tbody class="custom-th-bg custom-body-td-size4">
							<tr>
								<th>체크인번호</th>
								<th>고객이름</th>
								<th>고객 휴대폰</th>
								<th>고객 차량번호</th>
							</tr>
							<tr>
								<td>${chkout.chkinNo}</td>
								<td>${chkout.chkin.cstmr.cstNm}</td>
								<td>${chkout.chkin.cstmr.cstHp}</td>
								<td>${chkout.chkin.ciCarNo}</td>
							</tr>
						</tbody>
					</table>
					<table class="table table-bordered text-center custom-body-table-bd">
						<tbody class="custom-th-bg custom-body-td-size3">
							<tr>
								<th>체크인 시간</th>
								<th>퇴실일</th>
								<th>객실 호수</th>
							</tr>
							<tr>
								<td>${chkout.chkin.ciDt}</td>
								<td>${chkout.chkin.ciCowillYmd}</td>
								<td>${chkout.chkin.rmNo}</td>
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
					
					<div class="text-end">
						<button class="btn btn-outline-danger  me-1 mb-1 chkout" 
							data-bs-dismiss="modal" aria-label="Close" type="button">체크아웃</button>
						<button class="btn btn-outline-secondary me-1 mb-1" 
							data-bs-dismiss="modal" aria-label="Close" type="button">확인</button>
					</div>
			`

                var $modalBody = $('#chkoutList-select .modal-body');
				$modalBody.html(modalHeader);
				
                $('#chkoutList-select').modal('show'); // 모달 띄우기
            }
            , error: function () {
                alert('데이터를 불러오는 중 오류가 발생했습니다.');
            }
        });
    });

	$(document).on("click", ".chkout", function(){
	   
		console.log(chkout.chkinNo)
        $.ajax({
            type: "PUT"
            ,url: "./chkoutList/updatemodal?chkinNo="+chkout.chkinNo
            ,data: {rsvtNo: chkout.chkinNo}
            ,success: function(response) {
                // 성공적으로 서버에서 응답을 받았을 때 실행할 코드
                Swal.fire({
				    title: '체크아웃!',
				    text: '체크아웃이 정상적으로 처리되었습니다.',
				    icon: 'success'
				}).then((result) => {
	                location.reload();
				});
            }
            ,error: function(xhr, status, error) {
                // 요청이 실패했을 때 실행할 코드
                console.error(error);
            }
        });
	    
	    
	});
	  
});
