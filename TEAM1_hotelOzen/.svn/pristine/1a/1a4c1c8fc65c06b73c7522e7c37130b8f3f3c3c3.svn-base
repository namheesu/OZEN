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

		let dataList = jsonObj.chkinList;
		let pagingHTML = jsonObj.pagingHTML;
		
		let trTags = null;
		
		// 현재 날짜 객체 생성
		var currentDate = new Date();
		
		var year = currentDate.getFullYear();
		var month = (currentDate.getMonth() + 1).toString().padStart(2, '0');
		var day = currentDate.getDate().toString().padStart(2, '0');
		var sysdate = year + "-" + month + "-" + day;
		
		let checkInYmdTag;
		
		if(dataList.length > 0){
			$.each(dataList, function(index, chkin){
				if(chkin.rsvtCheckinYmd < sysdate){
					checkInYmdTag = `
						<td class="rsvtCheckinYmd align-middle" style="color:red">${chkin.rsvtCheckinYmd }</td>
					`

				}else{
					checkInYmdTag = `
						<td class="rsvtCheckinYmd align-middle">${chkin.rsvtCheckinYmd }</td>
					`
				}
				trTags += `
					<tr>
						<td class="rnum align-middle wdf">${chkin.rnum }</td>
						<td class="rsvtNo align-middle">
							<a href="#" class="chkinNoLink">${chkin.rsvtDetails[0].rsvtDtlNo }</a>
						</td>
						<td class="cstNm align-middle">${chkin.cstmr.cstNm }</td>
						<td class="rsvtYmd align-middle">${chkin.rsvtYmd }</td>
						${checkInYmdTag}
						<td class="rmtTypeCd align-middle">${chkin.rsvtDetails[0].roomTypeVO.rmtNmDetails }</td>
						<td class="rsvtRoomCnt align-middle">${chkin.rsvtRoomCnt }</td>
						<td class="rsvtAdultCnt align-middle">${chkin.rsvtAdultCnt }</td>
						<td class="rsvtChildCnt align-middle">${chkin.rsvtChildCnt }</td>
					</tr>	
				`;
			});
		}else{
			trTags = `
				<tr>
					<td colspan="9">조건에 맞는 체크인내역이 없음.</td>
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
	$(document).on('click', '.chkinNoLink', function (e) {
        e.preventDefault(); // 기본 링크 이벤트 방지

        var rsvtDtlNo = $(this).text(); // 클릭된 예약번호
        console.log("rsvtDtlNo", rsvtDtlNo);

        let url = './chkin?rsvtDtlNo=' + rsvtDtlNo;

        // AJAX 요청을 통해 컨트롤러에 해당 예약번호를 전달하고 데이터를 받아옵니다.
        $.ajax({
            type: 'GET',
            url: url,
            dataType: "json",
            success: function (jsonObj) {
				window.location.href = url;
            },
            error: function () {
                alert('데이터를 불러오는 중 오류가 발생했습니다.');
            }
        });
    });
});
