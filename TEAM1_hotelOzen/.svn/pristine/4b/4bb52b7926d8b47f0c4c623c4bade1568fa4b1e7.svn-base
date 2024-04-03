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

		let dataList = jsonObj.carList;
		let pagingHTML = jsonObj.pagingHTML;
		
		let trTags = null;
		let statusBadge = '';
		let amnt = '';
		
		if(dataList.length > 0){
			$.each(dataList, function(index, car){
				
				if (car.pkgStayYn  == 'Y'){
					statusBadge= `
						<span class="badge badge rounded-pill badge-subtle-primary">
			 				<span class=" far fa-circle" data-fa-transform="shrink-2"></span>
						</span>
					`;
					amnt = '-';
					
				}else if (car.pkgStayYn  == null){
					statusBadge = `
						<span class="badge badge rounded-pill badge-subtle-danger">
							<span class=" fas fa-times" data-fa-transform="shrink-2"></span>
						</span>
					`;
					if(car.pkgAmnt == null){
						amnt = 0;
					}else{
						amnt = car.pkgAmnt;						
					}
					
					var price = amnt;
				    var formattedPrice = Number(price).toLocaleString(); // 변환 후 쉼표 표기
				    amnt = formattedPrice;
				}
		
				if (car.pkgLvvhclTime == null) car.pkgLvvhclTime = "-";
							


				trTags += `
					<tr>
						<td class="rnum align-middle wdf">${car.rnum }</td>
						<td class="fxNm align-middle">${car.pkgCarNo }</td>
						<td class="fxPresCnt align-middle">${car.pkgEntvhclTime }</td>
						<td class="fxTtrtnCnt align-middle">${car.pkgLvvhclTime }</td>
						<td class="fxPrfrn align-middle">${statusBadge}</td>
						<td class="fxPrfrn align-middle">${amnt}</td>
					</tr>		
				`;
			});
		}else{
			trTags = `
				<tr>
					<td colspan="8">조건에 맞는 예약내역이 없음.</td>
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
