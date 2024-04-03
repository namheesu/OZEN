/**
 * 
 */
const cPath = document.body.dataset.contextPath;

let checkFlag = false;

document.addEventListener("DOMContentLoaded",()=>{
	cstHp.addEventListener("keyup", function(e){
		convertPhoneNumber(e.target);
	});
	mberHomeTel.addEventListener("keyup", function(e){
		convertPhoneNumber(e.target);
	});
});

$('#birYear').on('keyup', function() {    
	if(this.value.length == 4) {      
		  $('#birMon').focus()      
}});
$('#birMon').on('keyup', function() {    
	if(this.value.length == 2) {      
		  $('#birDay').focus()      
	}
});

$('#mberPwCheck').on('keyup', function() {    
	if(mberPw.value !== mberPwCheck.value){
		pwCheckField.style.display = "block"
	}else{
		pwCheckField.style.display = "none"
	}
});



function checkMberId(){
	let mberId = document.getElementById("mberId").value;
	
	let jsonData = {
		'mberId':mberId
	};
	fetch(cPath+'/auth/idvalid.do', {
		method:'POST',
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
		let message = '';
		checkFlag = true;
		console.log(jsonObj)
		if(jsonObj['check']){
			message = '사용 가능한 아이디입니다.'
		}else{
			if(jsonObj['message'].includes("duplicated")){
				message = '중복된 아이디입니다.'
			}else{
				message = '아이디는 영문, 숫자만을 포함할 수 있습니다.'
			}
		}
		console.log(message)
		checkResult.innerHTML = message;
		cstNm.value = "김승연";
		cstGen.value = "F";
		
		mberPw.value = "1111aaaa!"
		mberPwCheck.value = "1111aaaa!"
		
		cstMail.value = "faker0507"
		
		mailAddrSelect.value = "gmail.com"
		mailAddr.value = "gmail.com"
		
		cstHp.value = "010-4671-2684"
		
		birYear.value = "1999"
		birMon.value = "08"
		birDay.value = "04"
	})
}

mailAddrSelect.addEventListener("change", ()=>{
	if(mailAddrSelect.value != ""){
		 mailAddr.value = mailAddrSelect.value;
	}else{
		mailAddr.value = "";
	}
	
});

joinForm.addEventListener("submit", ()=>{
	
	let birYear = document.getElementById("birYear").value;
	let birMon = document.getElementById("birMon").value;
	let birDay = document.getElementById("birDay").value;
	
	document.getElementById("cstBirth").value = birYear + "-" + birMon + "-" + birDay
	
	if(!checkFlag){
		event.preventDefault();
		Swal.fire({
			title:"아이디 중복 확인을 진행해주세요"
			, icon:'error'
		})
		return false;
	}
	
	let checked = checkResult.innerHTML;
	
	if(!checked.includes("사용 가능한 아이디입니다.")){
		event.preventDefault();
		Swal.fire({
			title:"사용할 수 없는 아이디입니다."
			, icon:'error'
		})		
		return false;
	}
	
	let mberPw = document.getElementById("mberPw").value;
	let mberPwCheck = document.getElementById("mberPwCheck").value;
	
	if(mberPw !== mberPwCheck){
		event.preventDefault();
		return false;
	}
	
	let cstGen = document.getElementById("cstGen").value;
	
	if(cstGen == ""){
		event.preventDefault();
		genCheckField.innerHTML = "성별을 선택해주세요";
		return false;
	}
	
});

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