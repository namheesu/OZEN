/**
 * 
 */
const cPath = document.body.dataset.contextPath;

/* 연차 */
$(annualSearchForm).on("submit", function(event){
	event.preventDefault();
	let form = this;
	let url = form.action;
	let method = form.method;
	let data = $(form).serialize();
	let $annListBody = $(annListBody);
	let $annPagingArea = $(annPagingArea);
	
	$.ajax({
		url : url
		, data : data
		, method : method
		, dataType : "json"
		, success : function(jsonObj) {
			$annListBody.empty();
			$annPagingArea.empty();
			
		let annualDataList = jsonObj.annualList;
		let annPagingHtml = jsonObj.annPagingHtml;
		
		let trTags = null;
		let statusBadge = '';
		
			if(annualDataList.length > 0) {
				$.each(annualDataList, function(index, oprtnAnnual){
					if (oprtnAnnual.rqstSe  == '승인'){
						statusBadge= `
							<span class="badge badge rounded-pill badge-subtle-success">승인
				 				<span class="ms-1 fas fa-check" data-fa-transform="shrink-2"></span>
							</span>
						`;
					}else if (oprtnAnnual.rqstSe  == '반려'){
						statusBadge = `
							<span class="badge badge rounded-pill badge-subtle-danger">반려
								<span class="ms-1 fas fa-times" data-fa-transform="shrink-2"></span>
							</span>
						`;
					}else if (oprtnAnnual.rqstSe == '대기'){
						statusBadge = `
							<span class="badge badge rounded-pill badge-subtle-warning">대기
								<span class="ms-1 fas fa-hourglass-half" data-fa-transform="shrink-2"></span>
							</span>
						`;
					}
					
					if (oprtnAnnual.empRqNm == null) oprtnAnnual.empRqNm = "-";
					if (oprtnAnnual.rqstPurchsYmd == null) oprtnAnnual.rqstPurchsYmd = "-";
					
					trTags += `
						<tr>
							<td class="anlRnum">${oprtnAnnual.anlRnum}</td>
							<td class="anlLeaUseNo"><a href='${cPath}/emp/pbl/dclz/yryc/${oprtnAnnual.anlLeaUseNo}'>${oprtnAnnual.anlLeaUseNo}</a></td>
							<td class="empNm">${oprtnAnnual.empNm}</td>
							<td class="anlLeaYmd">${oprtnAnnual.anlLeaYmd}</td>
							<td class="anlStartEnd">${oprtnAnnual.anlLeaBgnYmd} ~ ${oprtnAnnual.anlLeaEndYmd}</td>
							<td class="rqstPurchsYmd">${oprtnAnnual.rqstPurchsYmd}</td>
							<td class="rqstSe">${statusBadge}</td>
							<td class="empRqNm">${oprtnAnnual.empRqNm}</td>
						</tr>
					`;
					
				});
			} else {
				trTags = `
					<tr>
						<td colspan="8">금일 결재건 없음</td>
					</tr>
				`;
			}
		$annListBody.append(trTags);
		$annPagingArea.append(annPagingHtml);
		
		}, error : function(jqXHR, txt, status){
			console.log(txt, status, jqXHR);
		}
	}).done(()=>{
		form.page.value="";
	});
	return false;
}).submit();



/* 비품 */
$(fxtrsSearchForm).on("submit", function(event){
	event.preventDefault();
	let form = this;
	let url = form.action;
	let method = form.method;
	let data = $(form).serialize();
	let $fxtrsListBody = $(fxtrsListBody);
	let $fxtrsPagingArea = $(fxtrsPagingArea);
	
	$.ajax({
		url : url
		, data : data
		, method : method
		, dataType : "json"
		, success : function(jsonObj) {
			$fxtrsListBody.empty();
			$fxtrsPagingArea.empty();
			
		let fxtrsDataList = jsonObj.fxtrsList;
		let fxtrsPagingHtml = jsonObj.fxPagingHtml;
		
		let trTags = null;
		let statusBadge = '';
		
		if(fxtrsDataList.length > 0) {
				$.each(fxtrsDataList, function(index, oprtnFxtrs){
					
					if (oprtnFxtrs.rqstSe  == '요청대기'){
						statusBadge= `
							<span class="badge badge rounded-pill badge-subtle-primary">요청대기
				 				<span class="ms-1 fas fa-won-sign" data-fa-transform="shrink-2"></span>
							</span>
						`;
					}else if (oprtnFxtrs.rqstSe  == '반려'){
						statusBadge = `
							<span class="badge badge rounded-pill badge-subtle-danger">반려
								<span class="ms-1 fas fa-times" data-fa-transform="shrink-2"></span>
							</span>
						`;
					}else if (oprtnFxtrs.rqstSe == '구매완료'){
						statusBadge = `
							<span class="badge badge rounded-pill badge-subtle-success">구매완료
								<span class="ms-1 fas fa-check" data-fa-transform="shrink-2"></span>
							</span>
						`;
					}else if (oprtnFxtrs.rqstSe == '구매대기'){
						statusBadge = `
							<span class="badge badge rounded-pill badge-subtle-warning">구매대기
								<span class="ms-1 fas fa-hourglass-half" data-fa-transform="shrink-2"></span>
							</span>
						`;
					}
					
					if (oprtnFxtrs.rqstRqYmd == null) oprtnFxtrs.rqstRqYmd = "-";
					if (oprtnFxtrs.empPurchsNm == null) oprtnFxtrs.empPurchsNm = "-";
					if (oprtnFxtrs.rqstPurchsYmd == null) oprtnFxtrs.rqstPurchsYmd = "-";
					
					trTags += `
						<tr>
							<td class="rnum">${oprtnFxtrs.rnum}</td>
							<td class="rqstNo"><a href="${cPath}/emp/pms/fxtrs/rqstView?fxtrsRqstNo=${oprtnFxtrs.rqstNo}">${oprtnFxtrs.rqstNo}</td>
							<td class="rqstNm">${oprtnFxtrs.empNm}</td>
							<td class="rqstAmnt">${oprtnFxtrs.rqstAmnt.toLocaleString('ko-KR') + "원"}</td>
							<td class="rqstYmd">${oprtnFxtrs.rqstYmd}</td>
							<td class="rqstPurchsYmd">${oprtnFxtrs.rqstPurchsYmd}</td>
							<td class="rqstSe">${statusBadge}</td>
							<td class="empRqNm">${oprtnFxtrs.empRqNm}</td>
							<td class="empPurchsNm">${oprtnFxtrs.empPurchsNm}</td>
						</tr>
					`;
					
				});
			} else {
				trTags = `
					<tr>
						<td colspan="9">금일 결재건 없음</td>
					</tr>
				`;
			}
			
		$fxtrsListBody.append(trTags);
		$fxtrsPagingArea.append(fxtrsPagingHtml);
		
		}, error : function(jqXHR, txt, status){
			console.log(txt, status, jqXHR);
		}
	}).done(()=>{
		form.page.value="";
	});
	return false;
}).submit();