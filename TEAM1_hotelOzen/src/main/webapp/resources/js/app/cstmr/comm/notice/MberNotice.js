/**
 * 
 */

// //목록조회, 페이지 처리
$(searchForm).on("submit", function(event){
	event.preventDefault();
	let cPath = document.body.dataset.contextPath
	let form = this;
	let url = form.action;
	let method = form.method;
	let data = $(form).serialize();
	let $listBody = $(listBody);
	let $pagingArea = $(pagingArea);
	
	$.ajax({
		url:url
		, method:method
		, data : data
		, dataType : "json"
		, success:function(jsonObj){
			$listBody.empty();
			$pagingArea.empty();
			
			let dataList = jsonObj.memNoticeList;
			let pagingHTML = jsonObj.pagingHTML;
			
			let trTags = null;
			
			if(dataList.length > 0) {
				$.each(dataList, function(index, mberNt){
					trTags += `
						<tr>
							<td class="number">${dataList.length - index}</td>
							<td class="title">
								<a href="${cPath}/comm/notice/noticeView.do/${mberNt.mberNtNo }">${mberNt.mberNtNm}</a>
							</td>
							<td class="cnt">${mberNt.mberNtCnt}</td>
							<td class="file"><span class="bi bi-link-45deg"></span></td>
							<td class="date">${mberNt.mberNtYmd}</td>
						</tr>
					`;
				}); 
			} else {
				trTags = `
					<tr>
						<td colspan="5">조건에 맞는 공지사항이 없음.</td>
					</tr>
				`;
			}
			
			$listBody.append(trTags);
			$pagingArea.append(pagingHTML);
			
		}, error : function(jqXHR, txt, status) {
			console.log(txt, status, jqXHR);
		}
	}).done(()=>{
		form.page.value="";
	});
	return false;
}).submit();