const contextPath = document.body.dataset.contextPath;
const empUserNo = document.querySelector(".profile").id
const empUserDept = document.querySelector(".profile-dept").id

$(searchForm).on("submit", function(event){
	event.preventDefault();
	let form = this;
	let url = form.action;
	let method = form.method;
	let data = $(form).serialize();
	let $listBody = $(listBody);
	let $pagingArea = $(pagingArea);
	
	$.ajax({
		url:url
		, method:method
		, data:data
		, dataType:"json"
		, success:function(jsonObj){
            $listBody.empty();
			$pagingArea.empty();
			$listBody.empty();
			let dataList = jsonObj.noticeList;
			let pagingHTML = jsonObj.pagingHTML;
			
			let trTags = null;		
			
			if(dataList.length>0){
				$.each(dataList, function(index, notice){
					trTags += `
					        <tr>
					          <td>${notice.rnum}</td>
					          <td class="text-left" width="50%">
								<div class="accordion-item border-0">
					              <div class="card-header p-0" id="faqAccordionHeading1">
					           		 <button class="accordion-button btn btn-link text-decoration-none d-block w-100 py-2 px-3 border-0 text-start rounded-0 shadow-none collapsed" data-bs-toggle="collapse" data-bs-target="#${notice.mberNtNo}collpase" aria-expanded="false" aria-controls="collapseFaqAccordion1"><svg class="svg-inline--fa fa-caret-right fa-w-6 accordion-icon me-3" data-fa-transform="shrink-2" aria-hidden="true" focusable="false" data-prefix="fas" data-icon="caret-right" role="img" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 192 512" data-fa-i2svg="" style="transform-origin: 0.1875em 0.5em;"><g transform="translate(96 256)"><g transform="translate(0, 0)  scale(0.875, 0.875)  rotate(0 0 0)"><path fill="currentColor" d="M0 384.662V127.338c0-17.818 21.543-26.741 34.142-14.142l128.662 128.662c7.81 7.81 7.81 20.474 0 28.284L34.142 398.804C21.543 411.404 0 402.48 0 384.662z" transform="translate(-96 -256)"></path></g></g></svg>
										<span class="fw-medium font-sans-serif text-900">
										${notice.mberNtNm}
										</span>
									</button>
					                   </div>
					                    <div class="accordion-collapse collapse" id="${notice.mberNtNo}collpase" aria-labelledby="faqAccordionHeading1" data-parent="#accordionFaq" style="">
					                      <div class="accordion-body p-0">
					                        <div class="card-body pt-2">
					                          <div class="ps-3 mb-0">
													${notice.mberNtCn}
					                            <p class="d-flex justify-content-end" id="${notice.mberNtNo}">
					                            	<button class="btn btn-outline-warning btn-sm modbtn" id="${notice.empNo}">수정</button>
					                            	<button class="btn btn-outline-danger btn-sm delbtn" name=${notice.empNo}>삭제</button>
					                           	</p>
					                          </div>
					                        </div>
					                      </div>
					                    </div>
					                  </div>
					          </td>
					          <td>${notice.empNm}</td>
					          <td>${notice.mberNtCtgry}</td>
					          <td>${notice.mberNtYmd}</td>
					          <td>${notice.mberNtCnt}</td>
					        </tr>
					` 
				})
			}else{
				trTags = `
					<tr>
						<td colspan="6">등록된 공지사항이 없습니다.<td
					</tr>
				`
			}
			
			$listBody.append(trTags);
			$pagingArea.append(pagingHTML);
			
		}, error:function(jqXHR, txt, status){
			console.log(txt, status, jqXHR);
		}
	}).done(()=>{
		form.page.value="";
	});
	return false;
}).submit();

$(insertBtn).on("click", function(){
	insertDiv.style.display = "block";
	insertDiv.scrollIntoView({
		behavior:'smooth',
		block:'start'
	});
});

$(insertCancel).on("click", function(){
	insertDiv.style.display = "none";
	let inputElements = insertForm.querySelectorAll('input');
	
	inputElements.forEach(function(input){
		input.value = '';
	});
	
	noticeList.scrollIntoView({
		behavior:'smooth',
		block:'start'
	});
});

insertForm.addEventListener("submit", () => {
    event.preventDefault();
	
	let method = insertForm.method;
	let url = insertForm.action;
	
	let formData = new FormData(insertForm);
	
	let jsonData = {};
	
	formData.forEach((value, key)=>{
		jsonData[key] = value;
	});
	
	console.log(jsonData);
	
	fetch(url,{
		method:method,
		headers:{
			"Content-Type":"application/json",
			"Accept":"application/json"
		},
		body:JSON.stringify(jsonData)
	}).then(resp=>{
		if(resp.ok){
			return resp.json();
		}else{
			throw new Error("오류 발생", {cause:resp})
		}
	}).then(jsonObj=>{
		console.log(jsonObj)
		if(jsonObj['message'].includes("ok")){
			Swal.fire({
				title:"공지사항이 등록되었습니다.",
				icon:"success",
				confirmButtonText:"확인"
			}).then(result=>{
				insertDiv.style.display = "none";
				let inputElements = insertForm.querySelectorAll('input');
				
				inputElements.forEach(function(input){
					input.value = '';
				});
				
				noticeList.scrollIntoView({
					behavior:'smooth',
					block:'start'
				});
				
				window.location.href = '';
			});
		
		}else{
			Swal.fire({
				title:"서버에 오류가 발생했습니다. 다시 시도해주세요.",
				icon:"error"
			})
		}
	});
	
	return false;
})
let modNtNo;

document.addEventListener('click', function(event) {
    if (event.target.classList.contains('modbtn')) {
        let mberNtNo = event.target.parentNode.id;
		modNtNo = mberNtNo;
		console.log(mberNtNo)
		let empNtNo = event.target.id;
		
		if(empNtNo !== empUserNo && empUserDept !== 'CRM'){
			Swal.fire({
				title:"게시글 수정 권한이 없습니다.",
				icon:"error"
			})
			return false;
		}
		let data = {
			'mberNtNo':mberNtNo
		}
		
		fetch(contextPath + "/emp/crm/cstmr/noticeOne",{
			method:"POST",
			headers:{
			"Content-Type":"application/json"
			},
			body:JSON.stringify(data)
		}).then(resp=>{
			if(resp.ok){
				return resp.json();
			}else{
				throw new Error("오류 발생", {cause:resp})
			}
		}).then(jsonObj=>{
			
			updateDiv.style.display = "block";
			
			modMberNtNm.value = jsonObj.notice['mberNtNm']
			modMberNtCtgry.value = jsonObj.notice['mberNtCtgry']
			
			let editor = tinymce.get('modMberNtCn');
			editor.setContent(jsonObj.notice['mberNtCn']);
			
			updateDiv.scrollIntoView({
				behavior:'smooth',
				block:'start'
			});
		});
    }
});
document.getElementById("modMberNtCtgry").addEventListener("mousedown", function(event) {
    event.preventDefault();
});

updateForm.addEventListener('submit', ()=>{
    event.preventDefault();
	
	let method = updateForm.method;
	let url = updateForm.action;
	
	let formData = new FormData(updateForm)
	
	let jsonData = {}
	
	formData.forEach((value, key)=>{
		jsonData[key] = value;
	});
	
	jsonData['mberNtNo'] = modNtNo;
	
	console.log(jsonData);
	
	fetch(url,{
		method:method,
		headers:{
			"Content-Type":"application/json",
			"Accept":"application/json"
		},
		body:JSON.stringify(jsonData)
	}).then(resp=>{
		if(resp.ok){
			return resp.json();
		}else{
			throw new Error("오류 발생", {cause:resp})
		}
	}).then(jsonObj=>{
		if(jsonObj['message'].includes("ok")){
			Swal.fire({
				title:"공지사항이 수정되었습니다.",
				icon:"success",
				confirmButtonText:"확인"
			}).then(result=>{
				insertDiv.style.display = "none";
				
				noticeList.scrollIntoView({
					behavior:'smooth',
					block:'start'
				});
				
				window.location.href = '';
			});
		
		}else{
			Swal.fire({
				title:"서버에 오류가 발생했습니다. 다시 시도해주세요.",
				icon:"error"
			})
		}
	});
	
	
	
	
	return false;
	
})


document.addEventListener('click', function(event) {
    if (event.target.classList.contains('delbtn')) {
        let mberNtNo = event.target.parentNode.id;
		let empNtNo = event.target.name;
		
		if(empNtNo !== empUserNo && empUserDept !== 'CRM'){
			Swal.fire({
				title:"게시글 삭제 권한이 없습니다.",
				icon:"error"
			})
			return false;
		}
		
		Swal.fire({
			title:"정말 삭제하시겠습니까?",
			icon:"info",
			confirmButtonText:"삭제",
			showDenyButton:true,
			denyButtonText: "취소"
			}).then(result=>{
			if(result.isConfirmed){
				let data = {
					"mberNtNo":mberNtNo
				}
				fetch(contextPath + "/emp/crm/cstmr/noticeDelete",{
					method:"POST",
					headers:{
					"Content-Type":"application/json"
					},
					body:JSON.stringify(data)
				}).then(resp=>{
					if(resp.ok){
						return resp.text();
					}else{
						throw new Error("오류 발생", {cause:resp})
					}
				}).then(data=>{
					Swal.fire({
						title:"삭제되었습니다.",
						icon:"success",
						confirmButtonText:"확인"
					}).then(result=>{
						noticeList.scrollIntoView({
							behavior:'smooth',
							block:'start'
						});
						window.location.href = '';
					});
				});
			}else{
				return false;
			}
		})
    }
});
