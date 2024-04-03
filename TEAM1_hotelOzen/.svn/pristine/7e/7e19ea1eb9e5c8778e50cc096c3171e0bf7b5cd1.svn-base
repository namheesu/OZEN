/**
 * 
 */

let empNo = ''

let sendBtn = document.querySelector("#send");
let myDiv = document.querySelector("#checkId");

 document.addEventListener("DOMContentLoaded",()=>{
	empTel.addEventListener("keyup", function(e){
		convertPhoneNumber(e.target);
	});
});

let findPwdForm = document.querySelector("#findPwdForm")

findPwdForm.addEventListener("submit", ()=>{
	event.preventDefault();
	
	let url = findPwdForm.action;
	let method = findPwdForm.method;
	
	let formData = new FormData(findPwdForm);
	let jsonData = {};
	
	formData.forEach((value, key)=>{
		jsonData[key] = value;
	});
	console.log(jsonData);
	empNo = jsonData['empNo'];
	console.log(empNo)
	fetch(url, {
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
			throw new Error("오류발생", {cause:resp})
		}
	}).then(jsonObj=>{
		console.log(jsonObj);
		otpAuth.style.display = "block";
		otpCd.value = jsonObj;	
	});
	
	return false;
});

let otpAuthForm = document.querySelector("#otpAuthForm");


otpAuthForm.addEventListener("submit",()=>{
	event.preventDefault();
	let url = otpAuthForm.action;
	let method = otpAuthForm.method;
	
	let formData = new FormData(otpAuthForm);
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
			throw new Error("오류발생", {cause:resp})			
		}
	}).then(jsonObj=>{
		console.log(jsonObj)
		if(jsonObj['message'].includes("error")){
			failDiv.style.display = "block";
		}else{
			$('#changePwdModal').modal('show');
		}
	});
	return false;
});

let changePwdForm = document.querySelector("#changePwdForm");

changeBtn.addEventListener("click", ()=>{
	event.preventDefault();
	if(newPwd.value !== newPwdChk.value){
		dismatch.style.display = "block";
	}else{	
		dismatch.style.display = "none";
		changePwdForm.requestSubmit();
	}
});

changePwdForm.addEventListener("submit", ()=>{
	event.preventDefault();
	
	let url = changePwdForm.action;
	let method = changePwdForm.method;
	
	let formData = new FormData(changePwdForm);
	let jsonData = {};
	
	formData.forEach((value, key)=>{
		jsonData[key] = value;
	});
	jsonData['empNo'] = empNo;
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
			throw new Error("오류발생", {cause:resp})			
		}
	}).then(jsonObj=>{
		console.log(jsonObj);
		if(jsonObj['message'].includes("error")){
			console.log(jsonObj.errors);
			
			changedFail.innerHTML = jsonObj.errors['newPwd']
			changedFail.style.display = "block";
		}else if(jsonObj['message'].includes("ok")){
			//완전 성공한 경우 sweet alert 띄우기
			Swal.fire({
				title:'비밀번호 변경이 완료되었습니다!',
				text:'새로운 비밀번호로 로그인해주세요.',
				icon:"success",
				confirmButtonText:"Login"
			}).then((result)=>{
				if(result.isConfirmed){
					window.location.href = loginPage.getAttribute('href');
				}
			});
		}else{
			throw new Error("오류발생")						
		}
		
	});
	return false;
});