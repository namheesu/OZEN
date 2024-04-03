/**
 * 
 */
// 생일, 번호, 이메일 결합
function combine(){
	var emailFront = document.getElementById("email-front").value;
	var emailEnd = document.getElementById("email-end").value;
	
	var cstMail = emailFront + "@" + emailEnd;
	
	var hp1 = document.getElementById("hp1").value;
	var hp2 = document.getElementById("hp2").value;
	var hp3 = document.getElementById("hp3").value;
	
	var cstHp = hp1 + "-" + hp2 + "-" + hp3;
	
	var bir1 = document.getElementById("bir1").value;
	var bir2 = document.getElementById("bir2").value;
	var bir3 = document.getElementById("bir3").value;
	
	var Birth = bir1 + "-" + bir2 + "-" + bir3;
		
	document.getElementById("cstHp").value = cstHp;
	document.getElementById("cstMail").value = cstMail;
	document.getElementById("cstBirth").value = Birth;
}
$(document).ready(function(){
	var birth = String(document.getElementById("hibir").value);
	console.log(birth);
	document.getElementById("bir1").value = birth.substr(0,4);
	document.getElementById("bir2").value = birth.substr(5,2);
	document.getElementById("bir3").value = birth.substr(8,2);
});
// 자동 칸 넘김
$('#bir2').on('blur',function(){
    if(this.value.length == 1){
        var bir = this.value;
        document.getElementById("bir2").value = String(bir).padStart(2, "0");
    }
});
$('#cstGen').on('change', function() {    
	$('#bir1').focus()  
	console.log("변경")
});

$('#bir1').on('keyup', function() {    
	if(this.value.length == 4) {      
		  $('#bir2').focus()      
}});
$('#bir2').on('keyup', function() {    
	if(this.value.length == 2) {      
		  $('#bir3').focus()      
}});
$('#bir3').on('keyup', function() {    
	if(this.value.length == 2) {      
		  $('#hp1').focus()      
}});

$('#hp1').on('keyup', function() {    
	if(this.value.length == 3) {      
		  $('#hp2').focus()      
}});
$('#hp2').on('keyup', function() {    
	if(this.value.length == 4) {      
		  $('#hp3').focus()      
}});
$('#hp3').on('keyup', function() {    
	if(this.value.length == 4) {      
		  $('#email-front').focus()      
}});

// 쿠폰
$('#coupon').on("change",function(event){
	var coupon = document.getElementById('coupon');
	var data = coupon.value.split('|');
	var add = data[0];
	var no = data[1];
	var price = document.getElementById('defaultAmnt');
	var total = document.getElementById('total');
	
	if(add === "객실"){
		// 쿠폰비율
		var discount = parseInt($("#coupon option:checked").text().substr(0,2));
		// 할인금액
		var discountAmnt = (price.value/discount);
		// 할인된 금액
		var sale = price.value - discountAmnt;
		// 할인 후 금액 설정
		total.innerText = sale.toLocaleString('ko-KR')+ " 원";
		// 할인금액 div 표시
		document.getElementById('discount').style.display = 'block';
		// 할인 금액 설정
		document.getElementById('discountAmnt').innerText = "- "+ discountAmnt.toLocaleString('ko-KR')+ " 원";
		document.getElementById('setleAmnt').value = sale;
		document.getElementById('cpnNo').value = no;
		console.log(no);
		
	}else if(add === "숙박권"){
		document.getElementById('discount').style.display = 'block';
		var couponNm = $("#coupon option:checked").text().substr(0,3);
		
		// 할인 금액 설정
		document.getElementById('discountAmnt').innerText = '-'+ parseInt(price.value).toLocaleString('ko-KR')+ " 원";
		document.getElementById('setleAmnt').value = 0;
		total.innerText =  " 0 원";
		document.getElementById('cpnNo').value = no;
		console.log(no);
	
	}else if(add === "쿠폰"){
		total.innerText = parseInt(document.getElementById('defaultAmnt').value).toLocaleString('ko-KR')+ " 원";
		document.getElementById('discountAmnt').innerText = '- 0 원';
		document.getElementById('setleAmnt').value = document.getElementById('defaultAmnt').value;
		document.getElementById('cpnNo').value = '';
		console.log(no);
	}
});


// 이메일 폼 형식
var emailEndInput = document.getElementById("email-end");
var emailFrontInput = document.getElementById("email-front");
var mailAddrSelect = document.getElementById("mailAddrSelect");


mailAddrSelect.addEventListener("change", ()=>{
	if(mailAddrSelect.value != ""){
		 emailEndInput.value = mailAddrSelect.value;
	}else{
		emailEndInput.value = "";
	}
});

$(document).on("keyup", "input[numberOnly]", function() {
	$(this).val( $(this).val().replace(/[^0-9]/gi,"") );
});

$(document).on("keyup", "input[noKorean]", function() {
	$(this).val( $(this).val().replace(/[^a-zA-Z0-9.]/gi,"") );
});
$(document).on("keyup", "input[noKorean]", function() {
	$(this).val( $(this).val().replace(/[^a-zA-Z0-9.]/gi,"") );
});
$(document).on("keyup", "input[koreanOnly]", function() {
	$(this).val( $(this).val().replace(/[^ㄱ-힣]/gi,"") );
});

var submitBtn = document.getElementById("submitBtn");

cstNm.addEventListener('input', listener);
cstGen.addEventListener('change', listener);
bir1.addEventListener('input', listener);
bir2.addEventListener('input', listener);
bir3.addEventListener('input', listener);
hp1.addEventListener('input', listener);
hp2.addEventListener('input', listener);
hp3.addEventListener('input', listener);
emailEndInput.addEventListener('input', listener);
mailAddrSelect.addEventListener('change', listener);
emailFrontInput.addEventListener('input', listener);

function listener() {
    var isValid = true;
console.log("돼라");
    // 모든 필드에 값이 있는지 확인
    if (
        !cstNm.value ||
        !cstGen.value ||
        !bir1.value ||
        !bir2.value ||
        !bir3.value ||
        !hp1.value ||
        !hp2.value ||
        !hp3.value ||
        !emailEndInput.value ||
        !emailFrontInput.value
    ) {
        isValid = false;
    }

    // 버튼 활성화/비활성화 설정
    submitBtn.disabled = !isValid;
}


