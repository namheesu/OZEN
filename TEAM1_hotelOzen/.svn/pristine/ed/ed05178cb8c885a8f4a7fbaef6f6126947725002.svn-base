$(searchForm).on("submit", function(event){
	event.preventDefault();
	let form = this;
	let url = form.action;
	let method = form.method;
	let data = $(form).serialize();
	let $BtrListBody = $(BtrListBody);
	let $KtcListBody = $(KtcListBody);
	let $BdnListBody = $(BdnListBody);
	let $CnvListBody = $(CnvListBody);
	let $pagingArea = $(pagingArea);
	
	$.ajax({
		url : url
		, method : method
		, data : data
		, dataType : "json"
		, success: function(jsonObj) {
            $BtrListBody.empty();
			$pagingArea.empty();

		let dataList = jsonObj.fxtrsList;
		let pagingHTML = jsonObj.pagingHTML;
		
		let btrTrTags = null;
		let ktcTrTags = null;
		let bdnTrTags = null;
		let cnvTrTags = null;
		let statusBadge = '';
		let ttrtn = '';
		
		if(dataList.length > 0){
			$.each(dataList, function(index, fxtrs){
				console.log(fxtrs);
				let fxCnt = fxtrs.fxTtrtnCnt - fxtrs.fxPresCnt
				if (fxCnt > 0){
					statusBadge= `
						<span class="badge badge rounded-pill badge-subtle-danger">높음
			 				<span class="ms-1 fas fa-times" data-fa-transform="shrink-2"></span>
						</span>
					`;
					Pres = `
						<td class="fxPresCnt" style="color:red">${fxtrs.fxPresCnt }</td>
					`;
				}else if (fxCnt < 0){
					statusBadge = `
						<span class="badge badge rounded-pill badge-subtle-success">낮음
							<span class="ms-1 far fa-circle" data-fa-transform="shrink-2"></span>
						</span>
					`;
					Pres = `
						<td class="fxPresCnt">${fxtrs.fxPresCnt }</td>
					`;
				}
		
				if(fxtrs.fxClsCd == 'BTR'){
					btrTrTags += `
						<tr>
							<td class="align-middle white-space-nowrap">
			              		<div class="form-check mb-0">
				                	<input class="form-check-input" type="checkbox" id="checkbox-'${fxtrs.fxCd }'" data-bulk-select-row="data-bulk-select-row" />
				                </div>
				            </td>
							<td class="fxCd">${fxtrs.fxCd }</td>
							<td class="fxNm">${fxtrs.fxNm }</td>
							<td class="fxPresCnt">${fxtrs.fxTtrtnCnt }</td>
							${Pres}							
							<td class="fxPrfrn text-center">${statusBadge}</td>
						</tr>		
					`;
				}else if(fxtrs.fxClsCd == 'KTC'){
					ktcTrTags += `
						<tr>
							<td class="align-middle white-space-nowrap">
			              		<div class="form-check mb-0">
				                	<input class="form-check-input" type="checkbox" id="checkbox-'${fxtrs.fxCd }'" data-bulk-select-row="data-bulk-select-row" />
				                </div>
				            </td>
							<td class="fxCd">${fxtrs.fxCd }</td>
							<td class="fxNm">${fxtrs.fxNm }</td>
							<td class="fxPresCnt">${fxtrs.fxTtrtnCnt }</td>
							${Pres}
							<td class="fxPrfrn text-center">${statusBadge}</td>
						</tr>		
					`;
				}else if(fxtrs.fxClsCd == 'BDN'){
					bdnTrTags += `
						<tr>
							<td class="align-middle white-space-nowrap">
			              		<div class="form-check mb-0">
				                	<input class="form-check-input" type="checkbox" id="checkbox-'${fxtrs.fxCd }'" data-bulk-select-row="data-bulk-select-row" />
				                </div>
				            </td>
							<td class="fxCd">${fxtrs.fxCd }</td>
							<td class="fxNm">${fxtrs.fxNm }</td>
							<td class="fxPresCnt">${fxtrs.fxTtrtnCnt }</td>
							${Pres}
							<td class="fxPrfrn text-center">${statusBadge}</td>
						</tr>		
					`;
				}else if(fxtrs.fxClsCd == 'CNV'){
					cnvTrTags += `
						<tr>
							<td class="align-middle white-space-nowrap">
			              		<div class="form-check mb-0">
				                	<input class="form-check-input" type="checkbox" id="checkbox-'${fxtrs.fxCd }'" data-bulk-select-row="data-bulk-select-row" />
				                </div>
				            </td>
							<td class="fxCd">${fxtrs.fxCd }</td>
							<td class="fxNm">${fxtrs.fxNm }</td>
							<td class="fxPresCnt">${fxtrs.fxTtrtnCnt }</td>
							${Pres}
							<td class="fxPrfrn text-center">${statusBadge}</td>
						</tr>		
					`;
				}
			});
		}
		
		$BtrListBody.append(btrTrTags);
		$KtcListBody.append(ktcTrTags);
		$BdnListBody.append(bdnTrTags);
		$CnvListBody.append(cnvTrTags);
		
		}, error : function(jqXHR, txt, status){
			console.log(txt, status, jqXHR);
		}
	}).done(()=>{
		form.page.value="";
	});
	return false;
}).submit();

$(document).ready(function() {
	
	$('input[type="checkbox"][data-bulk-select-row]:checked').prop('checked', false);
	
    $('.fxpresAdd').click(function(event) {
        event.preventDefault(); // 기본 동작 중지

        var checkedItems = $('input[type="checkbox"][data-bulk-select-row]:checked').map(function() {
            return $(this).attr('id').split("-")[1]; // 체크된 체크박스의 id에서 fxtrs.fxCd 값 추출
        }).get();

		console.log(checkedItems);

        if (checkedItems.length > 0) {
            var url = './rqstListadd.do?checkedItems=' + checkedItems.join(',');
            window.location.href = url; // URL로 이동하면서 체크된 항목 전달
        } else {
            Swal.fire({
				title:'비품 요청 실패!',
				text:'체크된 비품이 없습니다.',
				icon:"error"
			});

        }
    });
});

