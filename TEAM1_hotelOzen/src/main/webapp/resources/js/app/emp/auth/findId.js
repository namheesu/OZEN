/**
 * 
 */

document.addEventListener("DOMContentLoaded",()=>{
	empTel.addEventListener("keyup", function(e){
		convertPhoneNumber(e.target);
	});
});

autoComplete.addEventListener("click", ()=>{
	empNm.value = "하은경"
	empTel.value = "010-4894-1864"
});

let findIdForm = document.querySelector("#findIdForm");

findIdForm.addEventListener("submit", ()=>{
	event.preventDefault();
	let url = findIdForm.action;
	let method = findIdForm.method;
	
	let formData = new FormData(findIdForm);
	let jsonData = {};
	formData.forEach((value, key)=>{
		jsonData[key] = value;
	});
	console.log(jsonData)
	fetch(url, {
		method:method,
		headers:{
			"Content-Type":"application/json",
			"Accept":"application/json"
		},
		body:JSON.stringify(jsonData)
	}).then(resp =>{
		if(resp.ok){
			return resp.json();
		}else{
			throw new Error("오류발생", {cause:resp})
		}
	}).then(jsonObj =>{
		otpAuth.style.display = "block";
		console.log(jsonObj);
		otpCd.value = jsonObj;
		if(!jsonObj.includes("서버")){
			let seconds = 60;
		    const countdownDisplay = document.getElementById('countDown');
		    countdownDisplay.textContent = `01:00`;
		
		    // 1초마다 카운트다운 감소
		    const intervalId = setInterval(() => {
		        seconds--;
		        countdownDisplay.textContent = `00:${seconds}`;
		
		        // 시간이 다 되면 카운트다운 중지
		        if (seconds === 0) {
		            clearInterval(intervalId);
		            countdownDisplay.textContent = '';
					otpCd.value = 'otp 코드가 만료되었습니다. 다시 시도해주세요.'
		        }
		    }, 1000);
		}
	})
	
	return false;
});

let otpAuthForm = document.querySelector("#otpAuthForm");

otpAuthForm.addEventListener("submit", ()=>{
	event.preventDefault();
	let url = otpAuthForm.action;
	let method = otpAuthForm.method;
	
	let formData = new FormData(otpAuthForm);
	let jsonData = {};
	
	formData.forEach((value,key)=>{
		jsonData[key] = value;
	});
	console.log(jsonData)
	
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
		if(jsonObj['message'].includes("error")){
			failDiv.style.display = "block";
		}else{
			$('#showIdModal').modal('show');
			showId.value = jsonObj['empNo']
		}
	});
	return false;
});

