/**
 * 
 */
var yrycListInit = true;
const cPath = document.body.dataset.contextPath;

$(document).ready(function(){
	var date = new Date();
	//이번 달의 첫날과 마지막날
//	var firstDay = new Date(date.getFullYear(), date.getMonth(), 1);
//	var lastDay = new Date(date.getFullYear(), date.getMonth() + 1, 0);

	//이전 달의 급여를 계산해야 한다.
	var firstDay = new Date(date.getFullYear(), date.getMonth()-1, 1);
	var lastDay = new Date(date.getFullYear(), date.getMonth(), 0);
	
	var bgnInput = document.querySelector('input[name="bgn"]');
	var endInput = document.querySelector('input[name="end"]');
//	console.log(firstDay);
//	console.log(format(firstDay));
	bgnInput.value = format(firstDay);
	endInput.value = format(lastDay);
	

});

function format(date){
    var date = date;
    var year = date.getFullYear();
    var month = ("0" + (1 + date.getMonth())).slice(-2);
    var day = ("0" + date.getDate()).slice(-2);

    return year + "-" + month + "-" + day;
}

//필터 검색
$("select[name=selectOneSearchWord]").on("change", function(event){
	//event.preventDefault();
	//console.log(event);
	//	var beforeSelectPay = document.getElementById('beforeSelectPay');
	//	if (beforeSelectPay) {
	//	    return; // beforeSelectPay가 있으면 함수 종료
	//	}
	
	var selected = $("select[name=selectOneSearchWord]").val();
	//console.log(selected);
	$("#selectBtn").click();
	return false;
	
})


// //목록조회, 페이지 처리
$("#searchForm").on("submit", function(event){
	event.preventDefault();
	if(yrycListInit) return;
	
	let $listBody = $('#listBody');
	let $pagingArea = $(pagingArea);
	
	
	let form = this;
	let url = form.action;
	let method = form.method;
	let data = $(form).serialize();
	//console.log(data);
	var bgnInput = document.querySelector('input[name="bgn"]');
	var endInput = document.querySelector('input[name="end"]');

	
	var bgnDate = bgnInput.value;
	var endDate = endInput.value;
	
//	console.log(endDate);
//	console.log(bgnDate);
	data=data+'&bgn='+bgnDate+"&end="+endDate;
//	console.log(data);

	

	$.ajax({
		url:url
		, method:method
		, data : data
		, dataType : "json"
		, success:function(jsonObj){
			$listBody.empty();
			$pagingArea.empty();
			$('#beforeSelectPay').remove();
			
			let dataList = jsonObj.salaryGiveAutoList;
			
			let pagingHTML = jsonObj.pagingHTML;
	

			let totalGive = 0;
			let totalDeduct = 0;
			let net = 0;
			let empCnt = 0;
			
			let trTags = null;
			
			if(dataList.length > 0){
			
				$.each(dataList, function(index, salary){


					var detail = cPath+'/emp/hrm/pay/paysilp/detail';
					var jsonSalary = JSON.stringify(salary);
				
					trTags += `
						<tr>
							<td>${salary['empNo'] }</td>
							<td>${salary.empNm }</td>
							<td>${salary.empJncmpYmd}</td>
							<td>${salary.empDept }</td>
							<td class="pay-number">${salary.empPaymentAmnt }</td>
							<td class="pay-number">${salary.empDeductionAmnt }</td>
							<td class="pay-number">${salary.empThePay }</td>
							<td><button class="btn btn-outline-info btn-sm" data-detail='${jsonSalary}' onclick='showPayslip()'>급여</button></td>
						</tr>
					`; 
					
					
					//<td><button class="btn btn-info" type="button" data-bs-toggle="modal" data-bs-target="#exampleModal">급여</button></td>
					
					var reg = /[\{\}\[\]\/?.,;:|\)*~`!^\-_+<>@\#$%&\\\=\(\'\"]/gi;
					totalGive +=parseInt(salary.empPaymentAmnt.replace(reg, ''));
					totalDeduct +=parseInt(salary.empDeductionAmnt.replace(reg, ''));
					net +=parseInt(salary.empThePay.replace(reg, ''));
					empCnt++;

				});
			}else{
				trTags = `
					<tr>
						<td colspan="7">조건에 맞는 급여 목록이 없음.</td>
					</tr>
				`;
			}
			
			$listBody.append(trTags);
			$pagingArea.append(pagingHTML);
			var today = new Date();
			
			
			$('#pay-month').empty().text(bgnDate.substring(0, 7));
			$('#period').empty().text(bgnDate+"~"+endDate);
			$('#pay-give-date').empty().text(format(today));
			$('#total-give').empty().text(addComma(totalGive)+" 원");
			$('#total-deduct').empty().text(addComma(totalDeduct)+" 원");
			$('#net').empty().text(addComma(net)+" 원");
			$('#empCnt').empty().text(empCnt+" 명");
			
			
		}, error : function(jqXHR, txt, status){
			console.log(txt, status, jqXHR);
		}
	}).done(()=>{
		form.page.value="";
	});
	
	return false;
})//.submit(); //이벤트를 한번 강제로 발생시켜 1페이지 요청


function showPayslip(){

	var detailBtn = $(event.target);
	var data = detailBtn.data('detail');
	var form = $('#myForm');
	var url= cPath+"/emp/hrm/pay/payslip/detail";
	var target = '타이틀 제목';
    window.open(url, target, "width=800,height=970,top=0,left=0");

 	form.attr('action', url);
    form.attr('target', target); // window.open 타이틀과 매칭 되어야함
    form.attr('method', 'post');
	
	$('#empHealthInsrnc').val(data.empHealthInsrnc);
	$('#empPaymentAmnt').val(data.empPaymentAmnt);
	$('#empNm').val(data.empNm);
	$('#empEmplymInsrnc').val(data.empEmplymInsrnc);
	$('#empThePay').val(data.empThePay);
	$('#empDept').val(data.empDept);
	$('#empNo').val(data.empNo);
	$('#empNightWorkAllowance').val(data.empNightWorkAllowance);
	$('#empJncmpYmd').val(data.empJncmpYmd);
	$('#empNationalPension').val(data.empNationalPension);
	$('#empLongTermCareInsrnc').val(data.empLongTermCareInsrnc);
	$('#empDeductionAmnt').val(data.empDeductionAmnt);
	$('#empMslay').val(data.empMslay);
	$('#empJbgd').val(data.empJbgd);
	
	//form.append(data); // 동적으로 값을 추가할때
    form.submit();

}



function showPayslip2(){
	console.log(event.target);
	var detailBtn = $(event.target);
	var data = detailBtn.data('detail');
	console.log(data);
	var url= cPath+"/emp/hrm/pay/payslip/detail";
	
	$.ajax({
		url:url
		, method:"post"
		, contentType: "application/json"
		, data : JSON.stringify(data)
		, dataType : "json"
		, success:function(jsonObj){
			console.log("json성공!!", jsonObj );
			
		}, error : function(jqXHR, txt, status){
			console.log(txt, status, jqXHR);
		}
	}).done(()=>{
		
	});
	//window.open(url, data, "width=640, height=400")
}



//급여 자동계산: 해당 월의 근무기록을 바탕으로 급여를 계산
var salaryBtn= document.querySelector('#salaryBtn');
$(document).on('click', '#salaryBtn', function(e) {
	e.preventDefault();
	var $salaryBtn = $(this);
	//console.log("여기", $salaryBtn);
	
	var url = $salaryBtn.data('payUrl');
	var method = $salaryBtn.data('payMethod');
	yrycListInit = false;
	$('#searchForm').submit();
	$('#autoSalaryGive').modal('hide');
	
	//location.replace(url); //동기, get방식 이동, 단순 자원요청
	//$.ajax()
});

// 급여 확정: 급여 내역이 DB에 저장, 급여 명세서 pdf파일 생성
$(document).on('click', '#confirmedSalaryBtn', function(e){
	console.log('여기2',this);
	var $confirmedSalaryBtn = $(this)
	e.preventDefault();
	
	var url = $confirmedSalaryBtn.data('payUrl');
	var method = $confirmedSalaryBtn.data('payMethod');
	
	//let data = $(form).serialize();
	$.ajax({
		url:url
		, method:method
		//, data : data
		, dataType : "json"
		, success:function(jsonObj){
			console.log("성공입니다!!!!!");
			
			let dataList = jsonObj.salaryGiveAutoList;
			console.log("dataList", dataList);

		}, error : function(jqXHR, txt, status){
			console.log(txt, status, jqXHR);
		}
	}).done(()=>{
		
	});
	return false;

});


$(document).on('click', '#newPay', function(e){
	e.preventDefault();
	console.log("안녕");
	location.replace(cPath+"/emp/hrm/pay/payslip/detail");
});

//천단위 콤마 펑션
function addComma(value){
	value = value.toString();
	return value.replace(/\B(?=(\d{3})+(?!\d))/g, ",");
}










//document.addEventListener("DOMContentLoaded", () => {
//	
//	
//	let options ={"valueNames":["name","email","age"], "filter":{"key":"name"}, "filter2":{"key2":"age"},  "filter3":{"key3":"dept"} ,"page":5,"pagination":true}
//
//	empList3 = new List('tableExample3', options)
//	
//	let keyTarget = '';
//	let key2Target = '';
//	
////	var listFilter = document.querySelector('[data-list-filter]');
//	var listFilter = document.querySelector('#myname');
//	var key = options.filter.key;
//	listFilter.addEventListener("change", function(e){
//
//		empList3.filter(function(item){
//			keyTarget = e.target.value;
//			if(!(item.values()[key2].toLowerCase().includes(key2Target.toLowerCase()))) return false;
//              if (e.target.value === '') {
//                return true;
//              }
//
//
//              return item.values()[key].toLowerCase().includes(e.target.value.toLowerCase());
//            });			
//		})
//		
//	
//	
//	var listFilter2 = document.querySelector('#myage');
//	var key2 = options.filter2.key2;
//	listFilter2.addEventListener("change", function(e){
//
//		var filterValue2 = listFilter2.value;
//		
//		empList3.filter(function(item){
////			console.log("item",item);
////			console.log("item",item.values()[key]);
////			console.log("item",item.values()[key2]);
////			console.log("item",item.values());
//			key2Target = e.target.value;
//			if(!(item.values()[key].toLowerCase().includes(keyTarget.toLowerCase()))) return false;
//			
//              if (e.target.value === '') {  //n월이 아니라 ''이면 전체 달을 의미하므로 전부 true처리
//                return true;
//              }
//              return item.values()[key2].toLowerCase().includes(e.target.value.toLowerCase());
//            });			
//		})	
//		
////	$("#submitForm").submit();
//});
