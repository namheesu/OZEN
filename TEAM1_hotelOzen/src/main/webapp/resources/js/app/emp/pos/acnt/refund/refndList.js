/**
 * 
 */

const baseURI = window.location.href;

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

		let dataList = jsonObj.refndList;
		let pagingHTML = jsonObj.pagingHTML;
		let trTags = null;
		
		if(dataList.length > 0){
			$.each(dataList, function(index, refnd){
				trTags += `
					<tr>
						<td class="rnum align-middle wdf">${refnd.rnum}</td>
						<td class="setleNo align-middle">${refnd.setleVO.setleNo}</td>
						<td class="cstName align-middle">${refnd.cstmrVO.cstNo}</td>
						<td class="setleYmd align-middle">${refnd.setleVO.setleYmd}</td>
						<td class="refndYmd align-middle">${refnd.refndYmd.substring(0,10)}</td>
						<td class="setleAmnt align-middle">${refnd.setleVO.setleAmnt.toLocaleString('ko-KR') + "원"}</td>
						<td class="refndAmnt align-middle">${refnd.refndAmnt.toLocaleString('ko-KR') + "원"}</td>
						<td class="refndRatio align-middle">${refnd.refndPolicyVO.refndPlcyRate+"%"}</td>
					</tr>
				`;
			});
			}else{
				trTags = `
				<tr>
					<td colspan="10">조건에 맞는 환불내역이 없음.</td>
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



$("select[name=selectOneSearchWord]").on("change", function(event){
	event.preventDefault();
	var selected = $("select[name=selectOneSearchWord]").val();
	console.log(selected);
	$("#selectBtn").click();
	return false;
});
