/**
 * 
 */

const cPath = document.body.dataset.contextPath;

let content = document.querySelector("#mypage-content");

let today = document.querySelector(".txtGuide")

let initialContent;
document.addEventListener("DOMContentLoaded", ()=>{
	initialContent = content.innerHTML;
})


today.innerHTML = new Date().toLocaleDateString();

function myPageHome(){
	content.innerHTML = initialContent;
}

function mileageList(){
	fetch(cPath+'/myinfo/mileageList.do')
		.then(resp=> resp.text())
		.then(data=>{
			content.innerHTML= data;
	});
}

function couponList(){
	fetch(cPath+'/myinfo/couponList.do')
		.then(resp=> resp.text())
		.then(data=>{
			content.innerHTML= data;
	});
	
}

function updateForm(){
	fetch(cPath+'/myinfo/updateInfo.do')
		.then(resp=> resp.text())
		.then(data=>{
			content.innerHTML= data;
			let mbtiSelect = document.getElementsByName("mberMbti")[0];
			let mbti = mbtiSelect.id;
			if(mbti!=null){
				mbtiSelect.value = mbti;
			}else{
				document.getElementById('MBTI').selected;
			}
			
			mailAddrSelect.addEventListener("change", ()=>{
				mailAddr.value = mailAddrSelect.value;
			});
			 
			infoUpdateForm.addEventListener("submit", function(event){
				event.preventDefault();
				submitForm(event.target);
				return false;
			})
		});
}

function submitForm(form){
	let url = form.action;
	let method = form.method;
	
	let formData = new FormData(form);
	let jsonData = {};
	
	formData.forEach((value, key)=>{
		jsonData[key] = value;
	});
	
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
		if(jsonObj['message'].includes("ok")){
			Swal.fire({
				title:"개인정보가 변경되었습니다.",
				icon:"success",
				confirmButtonText:"확인"
			}).then((result)=>{
				if(result.isConfirmed){
					window.location.href = '';
				}
			});
		}else{
			Swal.fire({
				title:"개인정보 변경에 실패했습니다.",
				icon:"error"
			})
		}
		
	});
}

function execDaumPostcode() {
    new daum.Postcode({
        oncomplete: function(data) {
            var addr = ''; // 주소 변수
            var extraAddr = ''; // 참고항목 변수

            if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
                addr = data.roadAddress;
            } else { // 사용자가 지번 주소를 선택했을 경우(J)
                addr = data.jibunAddress;
            }

            if(data.userSelectedType === 'R'){
                if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                    extraAddr += data.bname;
                }
                if(data.buildingName !== '' && data.apartment === 'Y'){
                    extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                }
            }
            document.getElementById('postcode').value = data.zonecode;
            document.getElementById("mberAddr").value = addr;
            document.getElementById("mberDetailAddress").focus();
        }
    }).open();
}

function mypwchange(){
	fetch(cPath+'/myinfo/mypwchange.do')
		.then(resp=> resp.text())
		.then(data=>{
			content.innerHTML= data;
			
		newPwdChk.addEventListener("keyup", ()=>{
			if(newPw.value != newPwdChk.value){
				sameMessage.style.display = "block";
			}else{
				sameMessage.style.display = "none";
			}
		});

			pwChangeForm.addEventListener("submit", function(event){
				event.preventDefault();
				if(sameMessage.style.display =="block"){
					return false;
				}
				
				if(newPw.value.trim().length == 0){
					pwdMessage.style.display = "block"
					return false;
				}
			
				pwChange(event.target);
				
				return false;
			});
		});
}

function pwChange(form){
	let url = form.action;
	let method = form.method;
	
	let formData = new FormData(form);
	let jsonData = {};
	
	formData.forEach((value, key)=>{
		jsonData[key] = value;
	});
	
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
		if(jsonObj['message'].includes("ok")){
			Swal.fire({
				title:"비밀번호 변경이 완료되었습니다.",
				text:"새로운 비밀번호로 로그인해주세요.",
				icon:"success",
				confirmButtonText:"확인"
			}).then((result)=>{
				if(result.isConfirmed){
					logoutForm.submit();
				}
			});
			empPw.value = "";
			newPwd.value = "";
			newPwdChk.value = "";
		}else if(jsonObj['message'].includes("error")){
			let errorMessage = jsonObj['errors']['newPw']
			errorMessageField.innerHTML = errorMessage;
		}else{
			errorMessageField.innerHTML = "기존 비밀번호와 일치하지 않습니다.";
		}
	});
}


function secsn(){
	fetch(cPath+'/myinfo/secsn.do')
		.then(resp=> resp.text())
		.then(data=>{
			content.innerHTML= data;
	});
}

function mbrshSetle(){
	fetch(cPath+'/myinfo/mbrshSetle.do')
		.then(resp=> resp.text())
		.then(data=>{
			content.innerHTML= data;
	});
}

$(document).on('click','.secsnBtn',function(event){
	event.preventDefault();

	let url = checkPwForm.action;
	let method = checkPwForm.method;
	let formData = new FormData(checkPwForm);
	let jsonData = {}
	formData.forEach((value, key)=>{
		jsonData[key] = value;
	});
	
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
			secsnCheck();
		}else{
			Swal.fire({
				title:'비밀번호가 일치하지 않습니다.',
				icon:'error'
			})
		}
	});
	
	return false;
})

$(document).on('click','#secsnConfirmBtn',function(event){
	event.preventDefault();
	
	fetch(cPath+'/myinfo/secsnCheck.do',{
		method:"post",
		headers:{
			"Content-Type":"application/json",
			"Accept":"application/json"	
		}
	}).then(resp=>{
		if(resp.ok){
			return resp.json();
		}else{
			throw new Error("오류 발생", {cause:resp})
		}
	}).then(jsonObj=>{
		if(jsonObj['message'].includes("ok")){
			Swal.fire({
				title:'탈퇴되었습니다.',
				icon:'success',
				confirmButtonText:"Home"
			}).then((result)=>{
				if(result.isConfirmed){
					logoutForm.submit();
				}
			});
		}else{
			Swal.fire({
				title:'서버에 에러가 발생했습니다. 다시 시도해주세요',
				icon:'error'
			})
		}		
	})
	
	return false;

})

function secsnCheck(){
	fetch(cPath+'/myinfo/secsnCheck.do')
		.then(resp=> resp.text())
		.then(data=>{
			content.innerHTML= data;
	});	
}

function myscrapList(){
	fetch(cPath+'/myinfo/myscrapList.do')
		.then(resp=> resp.text())
		.then(data=>{
			content.innerHTML= data;
	});	
}

