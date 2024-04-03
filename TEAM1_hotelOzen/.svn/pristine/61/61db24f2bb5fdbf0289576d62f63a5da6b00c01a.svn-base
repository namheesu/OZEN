/**
 * 
 */
const contextPath = document.body.dataset.contextPath;

$(searchForm).on("submit", function(event){
	event.preventDefault();
	let form = this;
	let url = form.action;
	let method = form.method;
	let data = $(form).serialize();
	let $listBody = $(listBody);
	let $pagingArea = $(pagingArea);
	
	$.ajax({
		url:url,
		method:method,
		data:data,
		dataType:"json",
		success:function(jsonObj){
			$listBody.empty();
			$pagingArea.empty();
			
			let dataList = jsonObj.dclzList;
			let pagingHTML = jsonObj.pagingHTML;
			
			let trTags = '';
			let workTypeBadge = '';
			
			if(dataList.length > 0){
				$.each(dataList, function(index,dclz){
					let workTypeCd = dclz.workTypeCd;
					if(workTypeCd=='D'){
						workTypeBadge=`
							<span class="badge round-pill badge-subtle-success">DAY</span>
						`
					}else if(workTypeCd=='E'){
						workTypeBadge=`
							<span class="badge round-pill badge-subtle-info"> EVENING</span>
						`
					}else if(workTypeCd=='N'){						
						workTypeBadge=`
							<span class="badge round-pill badge-subtle-warning"> NIGHT</span>
						`
					}else if(workTypeCd=='O'){
						workTypeBadge=`
							<span class="badge round-pill badge-subtle-primary"> OFF</span>
						`
					}else if(workTypeCd=='G'){
						workTypeBadge=`
							<span class="badge round-pill badge-subtle-secondary"> GENARAL</span>
						`
					}else{
						workTypeBadge=`
							<span class="badge round-pill badge-subtle-secondary"> OFF</span>
						`
					}
					
					let bgnDt = moment(dclz.dclzBgnDt).format('YYYY-MM-DD HH:mm:ss');
					let endDt = moment(dclz.dclzEndDt).format('YYYY-MM-DD HH:mm:ss');
					
					trTags += `
						<tr>
							<td> ${dclz.dclzYmd}</td>
							<td> ${bgnDt}</td>
							<td> ${endDt}</td>
							<td> ${workTypeBadge}</td>
							<td> ${dclz.dclzStts}</td>
						</tr>
					`
				});
			}else{
				trTags = `
					<tr>
						<td colspan="5">조건에 맞는 근태 기록이 없습니다.</td>
					</tr>
				`;
			}
			$listBody.append(trTags);
			$pagingArea.append(pagingHTML);
		}, error:function(jqXHR, txt, status){
			console.log(jqXHR, txt, status);
		}
	}).done(()=>{
		form.page.value="";
	});
	return false;
}).submit();


document.addEventListener("DOMContentLoaded",()=>{
	empTel.addEventListener("keyup", function(e){
		convertPhoneNumber(e.target);
	});
	empHomeTel.addEventListener("keyup", function(e){
		convertPhoneNumber(e.target);
	});
});

let myInfoUpdateInfoForm = document.getElementById("myInfoUpdateInfoForm");

myInfoUpdateInfoForm.addEventListener("submit", ()=>{
	event.preventDefault();
	
	let url = myInfoUpdateInfoForm.action;
	let method = myInfoUpdateInfoForm.method;
	
	let formData = new FormData(myInfoUpdateInfoForm)
	
	fetch(url, {
		method:method,
		headers:{
			"Accept":"application/json"
		},
		body:formData
	}).then(resp=>{
		if(resp.ok){
			return resp.json();
		}else{
			throw Error("오류 발생", {cause:resp});
		}
	}).then(jsonObj=>{
		console.log(jsonObj);
		if(jsonObj['message'].includes('error')){
			Swal.fire({
				title:"정보 변경에 실패했습니다. 다시 시도해주세요!"
				, icon:"error"
			})
		}else{
			Swal.fire({
				title:"정보 변경이 완료되었습니다."
				, icon:"success"
				, confirmButtonText:"확인"
			}).then(result=>{
				if(result.isConfirmed){
					window.location.reload();
				}
			})
		}
	})
	
	return false;
});

newPwdChk.addEventListener("keyup", ()=>{
	if(newPwd.value != newPwdChk.value){
		dismatch.style.display = "block";
	}else{
		dismatch.style.display = "none";
		
	}
});



myinfoChangePwdForm.addEventListener("submit", ()=>{
	event.preventDefault();
	if(dismatch.style.display =="block"){
		return false;
	}
	let url = myinfoChangePwdForm.action;
	let method = myinfoChangePwdForm.method;
	
	let formData = new FormData(myinfoChangePwdForm);
	let jsonData = {};
	
	formData.forEach((value, key)=>{
		jsonData[key] = value;
	})
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
		console.log(jsonObj);
		if(jsonObj['message'].includes("error")){
			let errorMessage = jsonObj['errorMessage']
			errorMessageField.innerHTML = errorMessage;
			
		} else if(jsonObj['message'].includes("ok")){
			Swal.fire({
				title:"비밀번호 변경이 완료되었습니다",
				icon:"success"
			})
			empPw.value = "";
			newPwd.value = "";
			newPwdChk.value = "";
		}
	})

	return false;
});


function proflDelete(){
	console.log(empNo.value)
	console.log(contextPath+"/emp/myInfo/deleteProfl.do")
	let url = contextPath+"/emp/myInfo/deleteProfl.do";
	let jsonData = {
		'empNo':empNo.value
	}
	fetch(url, {
		method:"post",
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
			currentProfl.src = contextPath+'/resources/empProf/basic.png'
		}
	})
}

function workTypeFunction(target){
	let workType = target.parentElement.id
	
	if(workType.includes("All")){
		searchWord.value=""
		
	}else{
		searchWord.value = workType
	}
	
	
	$(searchForm).submit();
	
}