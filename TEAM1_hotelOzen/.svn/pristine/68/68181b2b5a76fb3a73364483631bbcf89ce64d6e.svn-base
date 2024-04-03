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

		let dataList = jsonObj.rmSRqstList;
		let pagingHTML = jsonObj.pagingHTML;
		
		console.log(dataList);
		
		let trTags = null;
		let statusBadge = '';
		
		if(dataList.length > 0){
			$.each(dataList, function(index, rmrq){
				
				if (rmrq.rsodSe  == '완료'){
					statusBadge= `
						<span class="badge badge rounded-pill badge-subtle-success">완료
							<span class="ms-1 fas fa-check" data-fa-transform="shrink-2"></span>
						</span>
					`;
				}else if (rmrq.rsodSe == '준비중'){
					statusBadge = `
						<span class="badge badge rounded-pill badge-subtle-info">준비중
							<span class="ms-1 fas fa-utensils" data-fa-transform="shrink-2"></span>
						</span>
					`;
				}
		
				trTags += `
					<tr>
						<td class="rnum">${rmrq.rnum }</td>
						<td class="rmsvcNo">
							<a href="#rmsvco-select" data-bs-toggle="modal">${rmrq.rsodNo }</a></td>
						<td class="rsCd">${rmrq.rmServiceDList[0].rmService.rsCd }</td>
						<td class="rsMenuNm">${rmrq.rmServiceDList[0].rmService.rsMenuNm }</td>
						<td class="rmNo">${rmrq.chkin.rmNo }</td>
						<td class="cstNm">${rmrq.chkin.cstmr.cstNm }</td>
						<td class="rsodSe text-center">${statusBadge}</td>
					</tr>		
				`;
			});
		}else{
			trTags = `
				<tr>
					<td colspan="7">조건에 맞는 예약내역이 없음.</td>
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
