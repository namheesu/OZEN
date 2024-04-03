/**
 * 
 */

const cPath = document.body.dataset.contextPath;

let emps = null; 

document.addEventListener("DOMContentLoaded", () => {
	//let options = { "valueNames": ["cstNo", "mberNm", "mberId", "mberHp", "mberMbrsh", "mberMlg"], "page": 10, "pagination": true }
	
	let allOptions = {"valueNames":["empNm","empNo", "empTel","empDept","empJbgd","empJncmpYmd","dclzStts","empRtrmYn" ],"filter":{"key":"empDept"},"page":10,"pagination":true}
	empList1 = new List('allEmpList', allOptions)
	let dclzOptions = { "valueNames":["name","phone-number","report","subscription","social"],"page":1,"pagination":true}
	empList2 = new List('dclzEmpList', dclzOptions)
	let reitredOptions = {"valueNames":["rnum","empNm","empNo", "empTel","empDept","empJbgd","social"], "filter":{"key":"empNo"},"page":3,"pagination":true}
	empList3 = new List('retiredEmpList', reitredOptions)
	
	
	//var listFilter = document.querySelector('[data-list]');
	var listFilter = document.querySelector('#myDept');
	var key = allOptions.filter.key;
	listFilter.addEventListener("change", function(e){
		console.log("change test")
		var filterValue = listFilter.value;
		console.log(filterValue) 
		empList1.filter(function(item){
              if (e.target.value === '') {
                return true;
              }
              return item.values()[key].toLowerCase().includes(e.target.value.toLowerCase());
            });			
		})
//	$("#submitForm").submit();
	
});



function fnDel(){
	document.addEventListener('click',  function(){
		event.preventDefault();
		if(event.target.innerText ==='퇴사자 처리') {

			var delBtn =event.target;
			var empNo = $(delBtn).data('empNo');
			var empRtrmYn = $(delBtn).data('rtrmYn');
			console.log("퇴사여부", empRtrmYn);
			if (empRtrmYn ==='Y') return false;
			
			//퇴사처리 여부 확인하기
			Swal.fire({
			   title: '정말로 퇴사 처리 하시겠습니까?',
			   text: '다시 되돌릴 수 없습니다. 신중하세요.',
			   icon: 'warning',
			   
			   showCancelButton: true, 
			   confirmButtonColor: '#3085d6', 
			   cancelButtonColor: '#d33', 
			   confirmButtonText: '승인', 
			   cancelButtonText: '취소', 
			   reverseButtons: true, 
		   
			}).then(result => {
		   		if (result.isConfirmed) { 
		
					$.ajax({
						url : cPath+"/emp/hrm/emply/delete/"+empNo
						, method: 'GET'
						, contentType: 'json'
						, success:function(jsonObj){
							console.log("jsonObj---------",jsonObj.empNo);
							
							
				        	Swal.fire({
								title:`사원번호: ${jsonObj.empNo} 퇴사 처리 되었습니다!`
								, icon:"success"
							}).then(result=> {
								location.replace(cPath+"/emp/pbl/emply");
							});
							
							//location.href = cPath+"/emp/hrm/empnotice/"+jsonObj.empNt.empNtNo;
						}, error : function(jqXHR, txt, status){
							console.log(txt, status, jqXHR);
						}
					}).done(()=>{
						
					});
				}else if (result.isDismissed) { 
					console.log("취소버튼 누름");
	    		}
			});
		}
	});
}		


//$("#delBtn").on('click', function(){
//	console.log("퇴사처리 눌렀나요?");
//});