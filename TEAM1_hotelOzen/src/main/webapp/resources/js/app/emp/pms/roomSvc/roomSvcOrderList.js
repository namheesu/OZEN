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

		let dataList = jsonObj.rmSOrderList;
		let pagingHTML = jsonObj.pagingHTML;
		
		console.log(dataList);
		
		let trTags = null;
		let statusBadge = '';
		
		if(dataList.length > 0){
			$.each(dataList, function(index, rmso){
				
			var rsodDt = new Date(rmso.rsodDt);
        	var formattedDate = 
				rsodDt.getFullYear() + '-' + ('0' + (rsodDt.getMonth() + 1)).slice(-2) + '-' + 
					('0' + rsodDt.getDate()).slice(-2) + ' ' + ('0' + rsodDt.getHours()).slice(-2) + ':' + 
					('0' + rsodDt.getMinutes()).slice(-2) + ':' + ('0' + rsodDt.getSeconds()).slice(-2);
				
				trTags += `
					<tr>
						<td class="rnum wdf">${rmso.rnum }</td>
						<td class="rmsvcNo">${rmso.rsodNo }</td>
						<td class="rsCd">${rmso.rmServiceDList[0].rmService.rsCd }</td>
						<td class="rsCd">${rmso.rmServiceDList[0].rmService.rsMenuNm }</td>
						<td class="rsodDt">${formattedDate }</td>
						<td class="rmNo">${rmso.chkin.rmNo }</td>
						<td class="cstNm">${rmso.chkin.cstmr.cstNm }</td>
					</tr>		
				`;
			});
		}else{
			trTags = `
				<tr>
					<td colspan="6">조건에 맞는 룸서비스내역이 없음.</td>
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
