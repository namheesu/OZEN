/**
 * 
 */

let mberId = '';

document.addEventListener("DOMContentLoaded",()=>{
	cstHp.addEventListener("keyup", function(e){
		convertPhoneNumber(e.target);
	});
});


let checkUserByIdForm = document.querySelector("#checkUserByIdForm");

checkUserByIdForm.addEventListener("submit", function(){
	event.preventDefault();
	let mberId = document.getElementById("mberId").value;
	let cstNm = document.getElementById("cstNm").value;
	let cstHp = document.getElementById("cstHp").value;
	
	let jsonData = {
		'cstNm':cstNm,
		'cstHp':cstHp,
		'mber':{
			'mberId':mberId
		}
	}
	console.log(jsonData);
	
	let url = checkUserByIdForm.action;
	let method = checkUserByIdForm.method;
	
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
			throw new Error("오류", {cause:resp})
		}
	}).then(jsonObj=>{
		console.log(jsonObj)
		otpAuth.style.display = "block";
		otpCd.value = jsonObj;
	})
	return false;
});

let otpAuthForm = document.querySelector("#otpAuthForm");

otpAuthForm.addEventListener("submit", function(){
	event.preventDefault();
	let url = otpAuthForm.action;
	let method = otpAuthForm.method;
	
	let formData = new FormData(otpAuthForm);
	let jsonData = {};
	
	formData.forEach((value, key)=>{
		jsonData[key] = value;
	});
	
	console.log(jsonData);
	
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
			throw new Error("오류 발생", {cause:resp})
		}
	}).then(jsonObj=>{
		console.log(jsonObj);
		if(jsonObj['message'].includes("error")){
			failDiv.style.display = "block";
		}else{
			$('#changePwdModal').modal('show');
			mberId = jsonObj['mberId']
		}
	});
	return false;
});


newPwdChk.addEventListener("keyup", function(e){
	let pwdChk = newPwdChk.value;
	let pwd = newPwd.value;
	
	if(pwd != pwdChk){
		dismatch.style.display = "block";
	}else{
		dismatch.style.display = "none";
	}
});

let changePwdForm = document.querySelector("#changePwdForm");

changeBtn.addEventListener("click", ()=>{
	if(dismatch.style.display === "none"){
		changePwdForm.requestSubmit();
	}else{
		return false;
	}
})

changePwdForm.addEventListener("submit", function(){
	event.preventDefault();
	let url = changePwdForm.action;
	let method = changePwdForm.method;
	
	let formData = new FormData(changePwdForm);
	let jsonData = {};
	
	formData.forEach((value, key)=>{
		jsonData[key] = value;
	});
	
	jsonData['mber'] = {
		'mberId':''
	};
	jsonData.mber['mberId'] = mberId
	
	console.log(jsonData);
	
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
		if(jsonObj['message'].includes("error")){
			console.log(jsonObj.errors);
			
			changedFail.innerHTML = jsonObj.errors['newPw']
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
		}
	});
	return false;
});


