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

		console.log(jsonObj);
		let dataList = jsonObj.fxtrsrqstList.rqstList;
		console.log(dataList);
		
		let pagingHTML = jsonObj.pagingHTML;
		
		let trTags = null;
		let statusBadge = '';
		
		if(dataList.length > 0){
			$.each(dataList, function(index, fxtrsRqst){
				console.log(fxtrsRqst);
				if (fxtrsRqst.rqstSe  == '요청대기'){
					statusBadge= `
						<span class="badge badge rounded-pill badge-subtle-warning">요청대기
							<span class="ms-1 fas fa-hourglass-half" data-fa-transform="shrink-2"></span>
						</span>
					`;
				}else if (fxtrsRqst.rqstSe  == '반려'){
					statusBadge = `
						<span class="badge badge rounded-pill badge-subtle-danger">반려
							<span class="ms-1 fas fa-times" data-fa-transform="shrink-2"></span>
						</span>
					`;
				}else if (fxtrsRqst.rqstSe == '구매완료'){
					statusBadge = `
						<span class="badge badge rounded-pill badge-subtle-success">구매완료
							<span class="ms-1 fas fa-check" data-fa-transform="shrink-2"></span>
						</span>
					`;
				}else if (fxtrsRqst.rqstSe == '구매대기'){
					statusBadge = `
						<span class="badge badge rounded-pill badge-subtle-info ">구매대기
							<span class="ms-1 fas fa-hourglass-half" data-fa-transform="shrink-2"></span>
						</span>
					`;
				}
				
				if (fxtrsRqst.rqstRqYmd == null) fxtrsRqst.rqstRqYmd = "-";
				if (fxtrsRqst.empPurchsNm == null) fxtrsRqst.empPurchsNm = "-";
				if (fxtrsRqst.rqstPurchsYmd == null) fxtrsRqst.rqstPurchsYmd = "-";
				
				var price = fxtrsRqst.rqstAmnt;
                var formattedPrice = Number(price).toLocaleString(); // 변환 후 쉼표 표기
                fxtrsRqst.rqstAmnt = formattedPrice;
		
				trTags += `
					<tr>
						<td class="rnum align-middle wdf">${fxtrsRqst.rnum }</td>
						<td class="fxCd align-middle">
							<a href="#" class="fxtrsRqstDtlView">${fxtrsRqst.rqstNo }</a>
						</td>
						<td class="fxNm align-middle">${fxtrsRqst.empNm }</td>
						<td class="fxPresCnt align-middle">${fxtrsRqst.rqstYmd }</td>
						<td class="fxTtrtnCnt align-middle">${fxtrsRqst.rqstAmnt }</td>
						<td class="fxPrfrn align-middle">${statusBadge}</td>
						<td class="fxTtrtnCnt align-middle">${fxtrsRqst.empRqNm }</td>
						<td class="fxTtrtnCnt align-middle">${fxtrsRqst.rqstRqYmd }</td>
						<td class="fxTtrtnCnt align-middle">${fxtrsRqst.empPurchsNm }</td>
						<td class="fxTtrtnCnt align-middle">${fxtrsRqst.rqstPurchsYmd }</td>
					</tr>		
				`;
			});
		}else{
			trTags = `
				<tr>
					<td colspan="10">조건에 맞는 요청서 없음.</td>
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
	$(document).on('click', '.fxtrsRqstDtlView', function (e) {
        e.preventDefault(); // 기본 링크 이벤트 방지

        var fxtrsRqstNo = $(this).text(); // 클릭된 예약번호
        console.log("fxtrsRqstNo", fxtrsRqstNo);

        let url = './rqstView?fxtrsRqstNo=' + fxtrsRqstNo;

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

	$(".selectOneSearchWordATag").click(function() {
        var value = $(this).data("value");
        $("#selectOneSearchWordInput").val(value);

		$("#selectBtn").click();
    });
});

