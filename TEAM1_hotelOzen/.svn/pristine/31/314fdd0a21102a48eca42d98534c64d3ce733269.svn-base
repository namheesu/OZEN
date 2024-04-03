/**
 * 
 */


const cPath = document.body.dataset.contextPath;

//$(document).ready(function(){
//	var date = new Date();
//	var firstDay = new Date(date.getFullYear(), date.getMonth(), 1);
//	var lastDay = new Date(date.getFullYear(), date.getMonth() + 1, 0);
//	var bgnInput = document.querySelector('input[name="bgn"]');
//	var endInput = document.querySelector('input[name="end"]');
//	console.log(firstDay);
//	console.log(format(firstDay));
//	bgnInput.value = format(firstDay);
//	endInput.value = format(lastDay);
//	
//
//});
//
//function format(date){
//    var date = date;
//    var year = date.getFullYear();
//    var month = ("0" + (1 + date.getMonth())).slice(-2);
//    var day = ("0" + date.getDate()).slice(-2);
//
//    return year + "-" + month + "-" + day;
//}



//필터 검색
$("select[name=selectOneSearchWord]").on("change", function(event){
	//event.preventDefault();
	//console.log(event);
	var selected = $("select[name=selectOneSearchWord]").val();
	console.log(selected);
	$("#selectBtn").click();
	return false;
	
})

//목록조회, 페이지 처리
$("#searchForm").on("submit", function(event){
	
	event.preventDefault();
	let form = this;
	let url = form.action;
	let method = form.method;
	let data = $(form).serialize();
	
//	var bgnInput = document.querySelector('input[name="bgn"]');
//	
//	var endInput = document.querySelector('input[name="end"]');
//
//	
//	var bgnDate = bgnInput.value;
//	var endDate = endInput.value;
//	
//	console.log(endDate);
//	console.log(bgnDate);
//	data=data+'&bgn='+bgnDate+"&end="+endDate;
//	console.log(data);
	
	let $listBody = $('#listBody');
	let $pagingArea = $(pagingArea);
	$.ajax({
		url:url
		, method:method
		, data : data
		, dataType : "json"
		, success:function(jsonObj){
			$listBody.empty();
			$pagingArea.empty();
			
			//console.log(jsonObj);
			let dataList = jsonObj.yrycList;
			let pagingHTML = jsonObj.pagingHTML;
			
			let trTags = "";
			
			if(dataList.length > 0){
				$.each(dataList, function(index, yryc){
					
//					trTags += `
//						<tr>
//							<td>${empNt.rnum }</td>
//							<td>${empNt.empNtClassification }</td>
//							<td><a href="${cPath}/emp/hrm/empnotice/${empNt.empNtNo}" onclick='fnShowOne()'>${empNt.empNtNm }</a></td>
//							<td><a href="${cPath}/emp/pbl/emply/view" onclick='fnShowOne()'>${empNt.hrmEmp.empNm }</a></td>
//							<td>${empNt.empNtYmd }</td>
//							<td>${att}</td>
//							<td>${empNt.empNtCnt }</td>
//						</tr>
//					`;
					var formatDept = yryc.empDept;
					if( formatDept==="FTO")  formatDept='프론트오피스';
					if( formatDept==="HKP")  formatDept='하우스키핑';
					if( formatDept==="FMT")  formatDept='시설관리';
					if( formatDept==="CRM")  formatDept='고객관리';
					if( formatDept==="POS")  formatDept='재무부';
					if( formatDept==="HRM")  formatDept='인사부';


					trTags += `
						<tr class="${yryc.anlLeaUseNo }">
							<td>${yryc.rnum }</td>
							<td>${yryc.empNm }</td>
							<td>${formatDept }</td>
							<td>${yryc.anlLeaBgnYmd }</td>
							<td>${yryc.anlLeaEndYmd }</td>
							<td>${yryc.useDate }일</td>
							<td>${yryc.anlLeaRm }</td>
							<td><button class="btn btn-outline-info btn-sm detailBtn " type="button" data-bs-toggle="modal" data-bs-target="#detail-modal" data-annual-no="${yryc.anlLeaUseNo}">상세보기</button></td>
						</tr>
					`;
					

				});
			}else{
				trTags = `
					<tr>
						<td colspan="7">조건에 맞는 공지가 없음.</td>
					</tr>
				`;
			}
			
			$listBody.append(trTags);
			$pagingArea.append(pagingHTML);
			//console.log("====>>>",trTags);
			
		}, error : function(jqXHR, txt, status){
			console.log(txt, status, jqXHR);
		}
	}).done(()=>{
		form.page.value="";
	});
	
	
	return false;
}).submit(); //이벤트를 한번 강제로 발생시켜 1페이지 요청


//$('#detail-modal').on('show.bs.modal', function(event){
//	event.preventDefault();
//	console.log(event.target);
//	$('.d')
////	var $btn = $('detailBtn');
////	
////	console.log("dfdfd", $btn.val());
//});

$(document).on('click', $('.detailBtn'), function(event) {
	//event.preventDefault();
	var anlLeaUseNo = $(event.target).data('annualNo');
	if(anlLeaUseNo == null ) return ;
	if(anlLeaUseNo == undefined ) return;
	//alert("dfdfd");
	
	
	$.ajax({
		url: cPath+'/emp/hrm/dclz/yryc/'+anlLeaUseNo
		, type : 'GET'
		, dataType : 'json'
		, success: function(result) {
			//console.log(result);
					$('#empNo').html(result.hrmAnnualVO.empNo);
					$('#empNm').html(result.hrmAnnualVO.empNm);
					$('#empTel').html(result.hrmAnnualVO.empTel);
					$('#empDept').html(result.hrmAnnualVO.empDept);
					$('#anlLeaBgnYmd').html(result.hrmAnnualVO.anlLeaBgnYmd);
					$('#anlLeaEndYmd').html(result.hrmAnnualVO.anlLeaEndYmd);
					$('#useDate').html(result.hrmAnnualVO.useDate);
					$('#empAnnualLeave').html(result.hrmAnnualVO.empAnnualLeave);
					$('#empRqNm').html(result.hrmAnnualVO.empRqNm);
		}
		, error: function() {
			
		}
	})
});




