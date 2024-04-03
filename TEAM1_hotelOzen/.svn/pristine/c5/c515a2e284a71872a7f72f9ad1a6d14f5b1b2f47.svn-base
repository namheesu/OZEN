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

		let dataList = jsonObj.fxtrsUseList;
		let pagingHTML = jsonObj.pagingHTML;
		
		let trTags = null;
		let statusBadge = '';
		
		if(dataList.length > 0){
			$.each(dataList, function(index, fxtrsUse){
				trTags += `
					<tr>
						<td class="rnum align-middle wdf">${fxtrsUse.rnum}</td>
						<td class="fxuseNo align-middle">
							<a href="#" class="fxuseNoLink" data-fxtrs-no="${fxtrsUse.fxuseNo}">${fxtrsUse.fxuseNo}</a>
						</td>
						<td class="rmNo align-middle">${fxtrsUse.rmNo }</td>
						<td class="empNm align-middle">${fxtrsUse.emp.empNm }</td>
						<td class="fxudYmd align-middle">${fxtrsUse.fxuseYmd }</td>
					</tr>		
				`;
			});
		}else{
			trTags = `
				<tr>
					<td colspan="4">조건에 맞는 사용서 없음.</td>
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

$(document).ready(function () {
    $(document).on('click', '.fxuseNoLink', function (e) {
        e.preventDefault(); // 기본 링크 이벤트 방지
        var fxuseNo = $(this).data('fxtrs-no'); // 클릭된 예약번호
        let url = './useList/modal?fxuseNo=' + fxuseNo;

        // AJAX 요청을 통해 컨트롤러에 해당 예약번호를 전달하고 데이터를 받아옵니다.
        $.ajax({
            type: 'POST',
            url: url,
            dataType: "json",
            success: function (jsonObj) {
                console.log("jsonObj.fxtrs",jsonObj.fxtrs);
				console.log("jsonObj.fxtrsDtl",jsonObj.fxtrsDtl);
				
				var fxtrs = jsonObj.fxtrs;
				var fxtrsDtl = jsonObj.fxtrsDtl;

				let txUseTags = '';

				if(fxtrsDtl.length > 0){
					$.each(fxtrsDtl, function(index, fxtrsDtl){
						txUseTags +=`
							<tr>
                                <td>${fxtrsDtl.fxtrs.fxtrsClsCd.fxClsNm}</td>
                                <td>${fxtrsDtl.fxCd}</td>
                                <td>${fxtrsDtl.fxtrs.fxNm}</td>
                                <td>${fxtrsDtl.fxudCnt}</td>
                            </tr> 
						`
					});
					
					txTags = `
						<td>
                            <table class="table table-bordered text-center custom-body-table-bd">
                                <tbody class="custom-th-bg custom-body-td-size4">
                                    <tr>
                                        <th>비품 분류명</th>
                                        <th>비품 코드</th>
                                        <th>비품 명</th>
                                        <th>수량</th>
                                    </tr>
                                    ${txUseTags}    
                                <tbody>
                            </table>
                        </td>
					`
				}

                let modalHeader = `
                    <table class="table table-bordered text-center custom-body-table-bd">
                        <tbody class="custom-th-bg custom-body-td-size4">
                            <tr>
                                <th>사용서 번호</th>
                                <th>객실번호</th>
                                <th>작성자</th>
                                <th>작성일</th>
                            </tr>
                            <tr>
                                <td>${fxtrs.fxuseNo}</td>
                                <td>${fxtrs.rmNo}</td>
                                <td>${fxtrs.emp.empNm}</td>
                                <td>${fxtrs.fxuseYmd}</td>
                            </tr>
                        </tbody>
                    </table>
                    <table class="table table-bordered text-center custom-body-table-bd">
                        <tbody class="custom-th-bg">
                            <tr>
                                <th>비품 사용 내역</th>
                            </tr>
                            <tr>
                                ${txTags}
                            </tr>
                        </tbody>
                    </table>
					<div class="text-end">
						<button class="btn btn-outline-secondary me-1 mb-1" 
							data-bs-dismiss="modal" aria-label="Close" type="button">확인</button>
					</div>
			`

                 $('#fxtrsList-select .modal-body').html(modalHeader);
                $('#fxtrsList-select').modal('show'); // 모달 띄우기
            },
            error: function () {
                alert('데이터를 불러오는 중 오류가 발생했습니다.');
            }
        });
    });
});
