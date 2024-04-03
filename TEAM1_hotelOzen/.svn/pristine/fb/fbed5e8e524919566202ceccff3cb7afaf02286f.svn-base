/**
 * 
 */


const cPath = document.body.dataset.contextPath;


$("select[name=selectOneSearchWord]").on("change", function(event){
	event.preventDefault();
//	console.log(event);
	var selected = $("select[name=selectOneSearchWord]").val();
//	console.log(selected);
	$("#selectOneSearchWord").val(selected);
	$("#selectBtn").click();
//	$("#selectOneSearchWord").val();
	return false;
	
})


// //목록조회, 페이지 처리
$("#searchForm").on("submit", function(event){
	event.preventDefault();
	let form = this;
	let url = form.action;
	let method = form.method;
	let data = $(form).serialize();
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
			
			let dataList = jsonObj.empNoticeList;
			let pagingHTML = jsonObj.pagingHTML;
			
			let trTags = null;
			
			if(dataList.length > 0){
				$.each(dataList, function(index, empNt){
					var att = '<span class="text-700 fs-8 bi-files"></span>';
					console.log("첨부파일이...??",empNt.atchList[0].atcEmpFileNm);
					if(empNt.atcCnt<1)
						att = '-';
						
					console.log("이름",empNt.hrmEmp.empNm);
					trTags += `
						<tr>
							<td>${empNt.rnum }</td>
							<td>${empNt.empNtClassification }</td>
							<td><a href="${cPath}/emp/empnotice/${empNt.empNtNo}" onclick='fnShowOne()'>${empNt.empNtNm }</a></td>
							<td>${empNt.hrmEmp.empNm }</a></td>
							<td>${empNt.empNtYmd }</td>
							<td>${att}</td>
							<td>${empNt.empNtCnt }</td>
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
			
		}, error : function(jqXHR, txt, status){
			console.log(txt, status, jqXHR);
		}
	}).done(()=>{
		form.page.value="";
	});
	return false;
}).submit(); //이벤트를 한번 강제로 발생시켜 1페이지 요청


let delUrl = null;

//새 공지 등록 비동기 이동
function fnMakeEmpNotice() {

//	console.log("여기입니다.", `\${cPath}`); //jsp스크립트에서 바로 jquery를 사용하고 있다면  \사용해야 할 수 있다.
//	console.log("여기입니다.", cPath); 
//	var url = `\${cPath}/emp/hrm/empnotice/insert`
	var url = `${cPath}/emp/hrm/empnotice/insert`
	fetch(url, {method:"get", headers:{ "accept": "text/html"}})
	.then(resp=>{
		if(resp.ok){
			//console.log("fetch로부터 온 응답: ",resp)
			//console.log("resp.text()",resp.text());
			return resp.text();
		}else{
			throw new Error(`상태코드 ${resp.status} 수신`, {cause:resp});
		}
	}).then(html=>{
		
		
		fragment = document.createRange().createContextualFragment(html);
        var partialHtml = fragment.querySelector('#getThis');
        var target = document.getElementById('target');

        
        target.innerHTML = ""; 
        target.appendChild(partialHtml.cloneNode(true)); 
        
        tinymce.init({
			selector: '.tinymce',
			setup: function (editor) {
		        editor.on('change', function () {
		            tinymce.triggerSave();
		        })
		    }
				
// 			width: 600,
			, height: 300,
			plugins: [
			  'advlist autolink link image lists charmap print preview hr anchor pagebreak',
			  'searchreplace wordcount visualblocks code fullscreen insertdatetime media nonbreaking',
			  'table emoticons template paste help'
			],
			toolbar: 'undo redo | styleselect | bold italic | alignleft aligncenter alignright alignjustify | ' +
			  'bullist numlist outdent indent | link image | print preview media fullscreen | ' +
			  'forecolor backcolor emoticons | help',
			menu: {
			  favs: {title: 'My Favorites', items: 'code visualaid | searchreplace | emoticons'}
			},
			menubar: 'favs file edit view insert format tools table help',
 	  		content_style: 'body { font-family:Helvetica,Arial,sans-serif; font-size:14px }'
           	
          });
		
        var optional_config = {
        		dateFormat: "Y/m/d",
        }
        
        $(".datetimepicker").flatpickr(optional_config);


		var tiny = document.querySelector(".tinymce");
		console.log("tiny", tiny);

		if(!insertBtn) {	
			insertBtn = document.getElementById("insertBtn");
			console.log("insertBtn", insertBtn);
			
		}
		fnInsert(insertBtn);
        
	}).catch(err=>console.error(err));	
	
}


function fnAuto() {
	
//	console.log("자동완성이 클릭되었습니다.");
//	console.log($('input[name=empNtNm]'));
//	console.log($('textarea[name=empNtCn]'));
 	$('input[name=empNtNm]').val("오젠 직원 교육 일정을 알립니다.");
// 	$('textarea[name=empNtCn]').html("다가오는 4월 첫째 주 월요일에 전 직원 교육이 있을 예정입니다. 많은 참여 부탁드립니다.");
 	$('#my-empNtClassification').val("직원교육");
	tinymce.activeEditor.setContent("<p>다가오는 4월 첫째 주 금요일에 전 직원 교육이 있을 예정입니다. 많은 참여 부탁드립니다.</p>");
	
}




//새 공지 등록
//var insertBtn = null;
//
function fnInsert(insertBtn){
	
	$('#insertBtn').on("click", function(){
	console.log("등록하기 버튼을 눌렀을 때",event);
	event.preventDefault();
	
	let form = document.getElementById("insertForm");
	console.log(form.action);
	
	//	console.log("form");
	let url = form.action;
	console.log(url);
	url = `${cPath}/emp/hrm/empnotice`
	console.log("url",  "변경한 url");
	let method = form.method;
	console.log(method);
	
	//tinyMCE.triggerSave();
	//let data = $(form).serialize(); //직렬화하면 파일은 그냥 이름만 가게 되는..??  formData를 써야 한다.
	//form.submit();
	
	
	
//	let data = formToObject(form);
//	
//	console.log("data", data);
//	
//	let body = JSON.stringify(data); 
//	console.log("body", body);
//	
	let formData = new FormData(form);
	console.log(formData);
	
//	console.log(data);
//
	$.ajax({
		url:url
		, method:"POST"
		, data : formData
		, dataType : "json"
		, contentType: false
		, processData: false
		, success:function(jsonObj){
			console.log("jsonObj---------",jsonObj);
			Swal.fire({
			    title: '직원 공지 등록',
			    text: '직원 공지가 성공적으로 등록되었습니다.',
			    icon: 'success'
			}).then((result) => {
			    // SweetAlert 창이 닫힌 후에 실행될 코드
			    location.replace(cPath+"/emp/hrm/empnotice");
			});
			//location.href = cPath+"/emp/hrm/empnotice/"+jsonObj.empNt.empNtNo;
		}, error : function(jqXHR, txt, status){
			console.log("에러.")
			console.log(txt, status, jqXHR);
		}
	}).done(()=>{
		form.page.value="";
	});
	return false;
	
});
	
}
	

	
//}

//공지 또는 직원 단건 조회 비동기
function fnShowOne() {
//	console.log("a.", `\${cPath}`); //jsp에서 스크립트를 쓰고, 제이쿼리를 동시에 사용하면 \사용해야 한다
	
// 	console.log(event);
	event.preventDefault();
	var aTag = event.target;
	var url = aTag.href;
	//delUrl = aTag.href;
	console.log("url:",url);
	fetch(url, {method:"get", headers:{ "accept": "text/html"}})
	.then(resp=>{
		if(resp.ok){
			return resp.text();
		}else{
			throw new Error(`상태코드 ${resp.status} 수신`, {cause:resp});
		}
	}).then(html=>{
		fragment = document.createRange().createContextualFragment(html);
		console.log("fragment",fragment );
        var partialHtml = fragment.querySelector('#getThis');
		console.log("단건 조회",partialHtml );
        var target = document.getElementById('target');
       
        var originalgetThis = document.getElementById('getThis');
        
        target.innerHTML = ""; 
        target.appendChild(partialHtml.cloneNode(true)); 

	}).catch(err=>console.error(err));	
}

//직원 공지 수정 폼에서 다시 개별 공지로 돌아가는 함수
function fnReset() {
	event.preventDefault();
	var empNtNo = $('#resetBtn').data('empNtNo');
	//console.log(empNtNo);
	var url = cPath+"/emp/empnotice/"+empNtNo;
	fetch(url, {method:"get", headers:{ "accept": "text/html"}})
	.then(resp=>{
		if(resp.ok){
			return resp.text();
		}else{
			throw new Error(`상태코드 ${resp.status} 수신`, {cause:resp});
		}
	}).then(html=>{
		fragment = document.createRange().createContextualFragment(html);
		//console.log("fragment",fragment );
        var partialHtml = fragment.querySelector('#getThis');
		//console.log("단건 조회",partialHtml );
        var target = document.getElementById('target');
        var originalgetThis = document.getElementById('getThis');
        target.innerHTML = ""; 
        target.appendChild(partialHtml.cloneNode(true)); 

	}).catch(err=>console.error(err));	
}


function fnDelete(){
	
	var urlInfo = window.location.href;
	if(urlInfo.indexOf("pbl") != -1) {
		Swal.fire({
		   title: '직원 공지 삭제 불가',
		   text: '직원 공지사항 삭제는 인사관리에서만 가능합니다.',
		   icon: 'warning'
		})
		return;
	}
	
	
	
	var empNtNo = $('#delBtn').data('empNtNo');
	//console.log(empNtNo);
	Swal.fire({
	   title: '정말로 그렇게 하시겠습니까?',
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
	     
			var url = cPath+'/emp/hrm/empnotice/'+empNtNo;
			//console.log("여기에서 삭제 됩니다.", url);

		fetch(url, {method:"delete"})
		.then(resp=>{
			Swal.fire({
				  title :'공지 삭제가 완료 되었습니다.',         
				  icon:'success',                         
				}).then(result=> {
	 				location.replace(cPath+`/emp/hrm/empnotice/`);
				});
			if(resp.ok){

				return resp.text();
			}else{
				throw new Error(`상태코드 ${resp.status} 수신`, {cause:resp});
			}
		}).then(html=>{
			
	
		}).catch(err=>console.error(err));	

	   }
	});

}


function fnGoList(){
	
	var url = cPath+`/emp/hrm/empnotice`;
	
	var urlInfo = window.location.href;
	if(urlInfo.indexOf("pbl") != -1) {
		url= cPath+`/emp/pbl/empnotice`;
	}
	
	fetch(url, {method: "get"})
	.then(resp=>{
		if(resp.ok){
			return resp.text();
		}else{
			throw new Error(`상태코드 ${resp.status} 수신`, {cause:resp});
		}
	}).then(html=>{
		location.replace(url);
	
	}).catch(err=>console.error(err));	
	
} 

const formToObject = (form)=>{
	let data = {};
	
	let formData = new FormData(form);
	
	for(let n of formData.keys()){
		data[n] = formData.get(n);
	}
	
	return data;
};


//수정 폼 보여주기
function fnUpdate() {
	
	var urlInfo = window.location.href;
	if(urlInfo.indexOf("pbl") != -1) {
		Swal.fire({
		   title: '직원 공지 수정 불가',
		   text: '직원 공지사항 수정은 인사관리에서만 가능합니다.',
		   icon: 'warning'
		})
		return;
	}
	
	var empNtNo = $(editBtn).data('empNtNo');

	var url=cPath+'/emp/hrm/empnotice/update?empNtNo='+empNtNo;
	
	//location.replace(url);
	fetch(url, {method:"get", headers:{ "accept": "text/html"}})
	.then(resp=>{
		if(resp.ok){
			
			return resp.text();
		}else{
			throw new Error(`상태코드 ${resp.status} 수신`, {cause:resp});
		}
	}).then(html=>{
		
		fragment = document.createRange().createContextualFragment(html);
		
        var partialHtml = fragment.querySelector('#getThis');
		
        var target = document.getElementById('target');
       
        var originalgetThis = document.getElementById('getThis');
        
        target.innerHTML = ""; 
        target.appendChild(partialHtml.cloneNode(true)); 

		 tinymce.init({
			selector: '.tinymce',
			setup: function (editor) {
		        editor.on('change', function () {
		            tinymce.triggerSave();
		        })
		    }
				
// 			width: 600,
			, height: 300,
			plugins: [
			  'advlist autolink link image lists charmap print preview hr anchor pagebreak',
			  'searchreplace wordcount visualblocks code fullscreen insertdatetime media nonbreaking',
			  'table emoticons template paste help'
			],
			toolbar: 'undo redo | styleselect | bold italic | alignleft aligncenter alignright alignjustify | ' +
			  'bullist numlist outdent indent | link image | print preview media fullscreen | ' +
			  'forecolor backcolor emoticons | help',
			menu: {
			  favs: {title: 'My Favorites', items: 'code visualaid | searchreplace | emoticons'}
			},
			menubar: 'favs file edit view insert format tools table help',
 	  		content_style: 'body { font-family:Helvetica,Arial,sans-serif; font-size:14px }'
           	
          });
		
		var tiny = document.querySelector(".tinymce");
		//console.log("tiny", tiny);
		
		$("a").on("click",function(event){ 
			event.preventDefault();
			var aTag = $(event.target);
			var url = aTag.prop('href');
			
			if(aTag.data('delAtc')==='atc') {
				delBtn(url, aTag);
			}
			return false;
		});

//		if(!updateBtn) {	
//			updateBtn = document.getElementById("updateBtn");
//			console.log("updateBtn", updateBtn);
//			
//		}
//		fnEdit(updateBtn);


	}).catch(err=>console.error(err));
}


//공지 수정
function fnEdit() {
	let form = document.getElementById("updateForm");
	//console.log(form);
	var method = "POST";
	var url = form.action;
	let formData = new FormData(form);
	//console.log(formData);
	$.ajax({
		url:url
		, method:method
		, data : formData
		, dataType : "json"
		, contentType: false
		, processData: false
		, success:function(jsonObj){
			console.log("일단 수정은 성공함..");
			//console.log("jsonObj---------",jsonObj);
			var url = cPath+jsonObj.url;
			//location.replace(cPath+"/emp/hrm/empnotice");
			//location.href = cPath+"/emp/hrm/empnotice/"+jsonObj.empNt.empNtNo;
			fetch(url, {method:"get", headers:{ "accept": "text/html"}})
				.then(resp=>{
					if(resp.ok){
						
						return resp.text();
					}else{
						throw new Error(`상태코드 ${resp.status} 수신`, {cause:resp});
					}
				}).then(html=>{
					
					Swal.fire({
						    title: '직원 공지 수정',
						    text: '직원 공지가 성공적으로 수정되었습니다.',
						    icon: 'success'
						}).then((result) => {
						    fragment = document.createRange().createContextualFragment(html);
					
					        var partialHtml = fragment.querySelector('#getThis');
							
					        var target = document.getElementById('target');
					       
					        var originalgetThis = document.getElementById('getThis');
					        
					        target.innerHTML = ""; 
					        target.appendChild(partialHtml.cloneNode(true)); 
						});
								
					
			
				}).catch(err=>console.error(err));	
		}, error : function(jqXHR, txt, status){
			console.log(txt, status, jqXHR);
		}
	}).done(()=>{
		
	});
	return false;
	
	
}


//공지사항 수정 중에 첨부파일을 삭제
function delBtn(url, aTag) {
	fetch(url, {method:"delete", dataType:"application/json"})
		 		.then(resp=>{
 			if(resp.ok){
 				return resp.json();
 			}else{
 				throw new Error(`상태코드 ${resp.status} 수신`, {cause:resp});
 			}
 		}).then(jsonObj=>{
			//console.log(jsonObj);
			if(jsonObj.success){
				aTag.remove();
			}
		}).catch(err=>console.error(err));	
}



// function fnCommFetch(url, options, fnResolve){
// 	fetch(url, options)
// 		.then(resp=>{
// 			if(resp.ok){
// 				return resp.json();
// 			}else{
// 				throw new Error(`상태코드 ${resp.status} 수신`, {cause:resp});
// 			}
// 		}).then(fnResolve)
// 		  .catch(err=>console.error(err));	
// }