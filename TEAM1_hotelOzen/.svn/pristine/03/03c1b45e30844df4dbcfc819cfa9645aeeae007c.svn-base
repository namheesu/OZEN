let dataList;

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
		dataList = jsonObj.roomListMap.roomList;
		let pagingHTML = jsonObj.pagingHTML;
		
		let trTags = null;
		let statusBadge = '';
		
		if(dataList.length > 0){
			$.each(dataList, function(index, room){
				
				if (room.rmClean  == '완료'){
					statusBadge= `
						<span class="badge badge rounded-pill badge-subtle-success"> 완료
			 				<span class="ms-1 fas fa-check" data-fa-transform="shrink-2"></span>
						</span>
					`;
				}else if (room.rmClean  == '고장'){
					statusBadge = `
						<span class="badge badge rounded-pill badge-subtle-warning"> 고장
							<span class="ms-1 fas fa-broom" data-fa-transform="shrink-2"></span>
						</span>
					`;
				}else if (room.rmClean == '청소요청'){
					statusBadge = `
						<span class="badge badge rounded-pill badge-subtle-danger"> 청소요청
							<span class="ms-1 fas fa-spinner" data-fa-transform="shrink-2"></span>
						</span>
					`;
				}
				
				if(room.rmClean == '청소요청'){
					rmCleanButton = `
						<button class="btn badge badge rounded-pill badge-subtle-primary roomClean btn-sm" 
								type="button" data-value1="${room.rmNo }" data-value2="${room.rmClean}">청소완료 처리</button>
					`
				}else{
					rmCleanButton = `
					`
				}
		
				trTags += `
					<tr>
						<td class="rnum align-middle wdf ">${room.rnum }</td>
						<td class="rmNo align-middle ">${room.rmNo }</a></td>
						<td class="rmtTypeCd align-middle ">${room.roomType.rmtNmDetails }</td>
						<td class="rmAvlblDetails align-middle ">${room.rmAvlblDetails }</td>
						<td class="rmClean align-middle ">${statusBadge}</td>
						<td class="rmClean align-middle ">${rmCleanButton}</td>						
					</tr>		
				`;
			});
		}else{
			trTags = `
				<tr>
					<td colspan="6">조건에 맞는 객실이 없음.</td>
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
    
    // 청소요청 버튼 클릭 시
    $(document).on("click", ".roomClean", function () {
		var value1 = $(this).data('value1')
		var value2 = $(this).data('value2')
		console.log(value1)
		console.log(value2)
        if (value2  == "청소요청") {
            $.ajax({
                type: "PUT",
                url: "./roomList/updatemodal?roomNo=" + value1 ,
                data: { roomNo: value1 },
                success: function (response) {
                    console.log(response);
					Swal.fire({
					    title: '청소완료',
					    text: '청소완료가 성공적으로 처리되었습니다.',
					    icon: 'success'
					}).then((result) => {
	                    location.reload();
					});
                },
                error: function (xhr, status, error) {
                    console.error(error);
                }
            });
        } else {
            console.log("청소요청 상태가아님");
        }
    });

	$(".selectOneSearchWordATag").click(function() {
        var value = $(this).data("value");
        $("#selectOneSearchWordInput").val(value);

		$("#selectBtn").click();
    });
});
