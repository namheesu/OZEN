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

		let dataList = jsonObj.rsvtList;
		let pagingHTML = jsonObj.pagingHTML;
		
		let trTags = null;
		
		if(dataList.length > 0){
			$.each(dataList, function(index, rsvt){
				trTags += `
					<tr>
						<td class="rnum align-middle wdf">${rsvt.rnum }</td>
						<td class="rsvtNo align-middle">
							<a href="#" class="rsvtNoLink" data-rsvt-no="${rsvt.rsvtNo}">${rsvt.rsvtNo}</a>
						</td>
						<td class="cstNm align-middle">${rsvt.cstmr.cstNm }</td>
						<td class="rsvtYmd align-middle">${rsvt.rsvtYmd }</td>
						<td class="rsvtCheckinYmd align-middle">${rsvt.rsvtCheckinYmd }</td>
						<td class="rmtTypeCd align-middle">${rsvt.rsvtDetails[0].roomTypeVO.rmtNmDetails }</td>
						<td class="rsvtRoomCnt align-middle">${rsvt.rsvtRoomCnt }</td>
						<td class="rsvtAdultCnt align-middle">${rsvt.rsvtAdultCnt }</td>
						<td class="rsvtChildCnt align-middle">${rsvt.rsvtChildCnt }</td>
						<td class="rsvtSe align-middle">${rsvt.rsvtDetails[0].rsvtSe }</td>
					</tr>	
				`;
			});
		}else{
			trTags = `
				<tr>
					<td colspan="10">조건에 맞는 예약내역이 없음.</td>
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

let rsvt;

$(document).ready(function () {
    $(document).on('click', '.rsvtNoLink', function (e) {
        e.preventDefault(); // 기본 링크 이벤트 방지
        var rsvtNo = $(this).data('rsvt-no'); // 클릭된 예약번호
        let url = './rsvtList/modal?rsvtNo=' + rsvtNo;

        // AJAX 요청을 통해 컨트롤러에 해당 예약번호를 전달하고 데이터를 받아옵니다.
        $.ajax({
            type: 'GET',
            url: url,
            dataType: "json",
            success: function (jsonObj) {
                rsvt = jsonObj.rsvtVO;
                var price = rsvt.rsvtAmnt;
                var formattedPrice = Number(price).toLocaleString(); // 변환 후 쉼표 표기
                rsvt.rsvtAmnt = formattedPrice;

                let modalHeader = `
                    <table class="table table-bordered text-center custom-body-table-bd">
                        <tbody class="custom-th-bg custom-body-td-size4">
                            <tr>
                                <th>예약번호</th>
                                <th>고객이름</th>
                                <th>휴대폰</th>
                                <th>생년월일</th>
                            </tr>
                            <tr>
                                <td>${rsvt.rsvtNo}</td>
                                <td>${rsvt.cstmr.cstNm}</td>
                                <td>${rsvt.cstmr.cstHp}</td>
                                <td>${rsvt.cstmr.cstBirth}</td>
                            </tr>
                        </tbody>
                    </table>
					<table class="table table-bordered text-center custom-body-table-bd">
						<tbody class="custom-th-bg custom-body-td-size4">
							<tr>
								<th>예약상태</th>
								<th>예약일</th>
								<th>투숙일</th>
								<th>퇴실일</th>
							</tr>
							<tr>
								<td>${rsvt.rsvtDetails[0].rsvtSe}</td>
								<td>${rsvt.rsvtYmd}</td>
								<td>${rsvt.rsvtCheckinYmd}</td>
								<td>${rsvt.rsvtCheckoutYmd}</td>
							</tr>
						</tbody>
					</table>
					<table class="table table-bordered text-center custom-body-table-bd">
						<tbody class="custom-th-bg custom-body-td-size3">
							<tr>
								<th>객실수</th>
								<th>성인수</th>
								<th>아동수</th>
							</tr>
							<tr>
								<td>${rsvt.rsvtRoomCnt}</td>
								<td>${rsvt.rsvtAdultCnt}</td>
								<td>${rsvt.rsvtChildCnt}</td>
							</tr>
						</tbody>
					</table>
					<table class="table table-bordered text-center custom-body-table-bd">
						<tbody class="custom-th-bg custom-body-td-size4">
							<tr>
								<th>객실종류</th>
								<th>예약상태</th>
								<th>총가격</th>
							</tr>
							<tr>
								<td>${rsvt.rsvtDetails[0].rmtTypeCd}</td>
								<td>${rsvt.rsvtDetails[0].rsvtSe}</td>
								<td>${rsvt.rsvtAmnt}</td>
							</tr>
						</tbody>
					</table>
					<div class="text-end">
						<button class="btn btn-outline-danger  me-1 mb-1 rsvtCXL" 
							data-bs-dismiss="modal" aria-label="Close" type="button">예약취소</button>
						<button class="btn btn-outline-secondary me-1 mb-1" 
							data-bs-dismiss="modal" aria-label="Close" type="button">확인</button>
					</div>
			`

                 $('#rsvtList-select .modal-body').html(modalHeader);
                $('#rsvtList-select').modal('show'); // 모달 띄우기
            },
            error: function () {
                alert('데이터를 불러오는 중 오류가 발생했습니다.');
            }
        });
    });

    // 예약 취소 버튼 클릭 시
    $(document).on("click", ".rsvtCXL", function () {
        if (rsvt.rsvtDetails[0].rsvtSe == "예약중") {
            $.ajax({
                type: "PUT",
                url: "./rsvtList/updatemodal?rsvtNo=" + rsvt.rsvtNo,
                data: { rsvtNo: rsvt.rsvtNo },
                success: function (response) {
                    console.log(response);
                    location.reload();
                },
                error: function (xhr, status, error) {
                    console.error(error);
                }
            });
        } else {
            console.log("예약중 아님");
        }
    });
});

$("select[name=selectOneSearchWord]").on("change", function(event){
	event.preventDefault();
	var selected = $("select[name=selectOneSearchWord]").val();
	console.log(selected);
	$("#selectBtn").click();
	return false;
	
})