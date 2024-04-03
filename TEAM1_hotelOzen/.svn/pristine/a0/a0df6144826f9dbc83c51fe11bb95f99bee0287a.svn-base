/**
 * 
 */
$(function() {
	$('#fullpage').fullpage({
		//options here
		autoScrolling : true,
		scrollHorizontally : true,
		navigation : true,
		navigationPosition : 'right',
		scrollingSpeed : 1000,
		navigationTooltips : ['첫번째','두번째','세번째','네번째']
	});
});


// 인원 수 증가
function plus(btnId){
	var cnt = document.getElementById(btnId);
	var curCnt = parseInt(cnt.value);
	var peoId = null;
	var inputId = null;

	if (btnId.substr(0,5) == 'adult'){
		inputId = "rsvtAdultCnt";
		peoId = "adultCnt"
	}else{
		inputId = "rsvtChildCnt";
		peoId = "childCnt"
	}
	
	var peoCnt = document.getElementById(inputId);
	var peoValue = parseInt(peoCnt.value);
	
	if (isNaN(curCnt)) {
        curCnt = 0;
    }
	// 최대인원 수 4명
	if(curCnt < 4){
	cnt.value = curCnt + 1;
	peoCnt.value = peoValue + 1; 
	}

	var spanElement = cnt.parentElement.querySelector('span em');
		document.getElementById(btnId).value = cnt.value;
		spanElement.innerText = cnt.value;
	
	var peoText = document.getElementById(peoId);
		document.getElementById(inputId).value = peoCnt.value;
		document.getElementById(peoId).innerText = peoCnt.value;
		roomCnt();
}

// 인원 수 감소
function minus(btnId){
	var cnt = document.getElementById(btnId);
	var curCnt = parseInt(cnt.value);
	var peoId = null;
	var inputId = null;

	if (btnId.substr(0,5) == 'adult'){
		inputId = "rsvtAdultCnt";
		peoId = "adultCnt"
	}else{
		inputId = "rsvtChildCnt";
		peoId = "childCnt"
	}
	
	var peoCnt = document.getElementById(inputId);
	var peoValue = parseInt(peoCnt.value);
	
	
	if (isNaN(curCnt)) {
        curCnt = 0;	
    }
	
	switch(true){
		case btnId === "adultCnt1" && curCnt <= 1:
			cnt.value = 1;
			break;
		case curCnt>0:
			cnt.value = curCnt - 1;
			peoCnt.value = peoValue - 1;
			break;
	}
	
	var spanElement = cnt.parentElement.querySelector('span em');
		document.getElementById(btnId).value = cnt.value;
		spanElement.innerText = cnt.value;
		
	var peoText = document.getElementById(peoId);
		document.getElementById(inputId).value = peoCnt.value;
		document.getElementById(peoId).innerText = peoCnt.value;
		
		roomCnt();
}


function roomCnt(){
	var adult1 = document.getElementById('adultCnt1').value;
	var adult2 = document.getElementById('adultCnt2').value;
	var adult3 = document.getElementById('adultCnt3').value;
	var child1 = document.getElementById('childCnt1').value;
	var child2 = document.getElementById('childCnt2').value;
	var child3 = document.getElementById('childCnt3').value;
	var roomCnt = 0;
	if((adult1+child1) > 0){
		roomCnt++;
	}
	if((adult2 + child2) > 0){
		roomCnt++;
	}
	if((adult3 + child3) > 0){
		roomCnt++;
	}
	var roomText = document.getElementById('roomCnt');
	var roomInput = document.getElementById('rsvtRoomCnt');
	
	roomText.innerText = roomCnt;
	roomInput.value = roomCnt;	
}

// 객실별 인원수 폼 가리기
function home(){
	var roomBoxElement = document.getElementById("roomBox");
	var title = document.getElementById("title");
	
	console.log("클릭");
	roomBoxElement.style.display = "none";
	title.style.display = "block";
};

// 객실별 인원수 폼 표출
function room(){
	var roomBoxElement = document.getElementById("roomBox");
	var title = document.getElementById("title");
	console.log("클릭");
  	roomBoxElement.style.display = "block";
	title.style.display = "none";
};

// form전송
$(document).ready(function() {
	$("#submitBtn").click(function() {
		$("#submitForm").submit();
	});
});

$(document).ready(function(){
	let date = new Date();
	
 	var today = new Date().toISOString().slice(0, 10);

    // 내일 날짜 계산
    var tomorrow = new Date(date.setDate(date.getDate() + 1)).toISOString().slice(0, 10);

	let oneYear = new Date(date.getFullYear()+1, date.getMonth(), date.getDate()).toISOString().slice(0, 10);
	
	document.getElementById('rsvtCheckinYmd').value = today;
	document.getElementById('rsvtCheckoutYmd').value = tomorrow;
	
	document.getElementById("rsvtCheckinYmd").setAttribute("min", today);
	document.getElementById("rsvtCheckinYmd").setAttribute("max", oneYear);
	
	document.getElementById("rsvtCheckoutYmd").setAttribute("min", tomorrow);
	document.getElementById("rsvtCheckoutYmd").setAttribute("max", oneYear);
	$('#rsvtCheckinYmd').change(function(){
		

	var checkin = document.getElementById('rsvtCheckinYmd');
	var checkinDate = new Date(checkin.value);
	var nextDate = new Date(checkinDate);
	nextDate.setDate(checkinDate.getDate()+1);
	let nextDay = nextDate.toISOString().slice(0,10);
	document.getElementById("rsvtCheckoutYmd").value = nextDay;
	document.getElementById("rsvtCheckoutYmd").setAttribute("min", nextDay);
//	document.getElementById("rsvtCheckoutYmd").setAttribute("max", thrMon);
    });
});

var submitBtn = document.getElementById("submitBtn");

rsvtCheckinYmd.addEventListener('input',listener);
rsvtCheckoutYmd.addEventListener('input',listener);

function listener() {
    var isValid = true;
    // 모든 필드에 값이 있는지 확인
    if (
        !rsvtCheckinYmd.value ||
        !rsvtCheckoutYmd.value 
    ) {
        isValid = false;
    }
    // 버튼 활성화/비활성화 설정
    submitBtn.disabled = !isValid;
}


/* swiper.js script */
const progressLine = document.querySelector('.autoplay-progress svg')
const mainSwiper = new Swiper(".main-swiper", {
    // 무한 슬라이드
    loop: true,

    //자동 재생
    autoplay: {
        delay: 5500,
        disableOnInteraction: false,
    },

    // bullet
    pagination: {
        el: ".main-swiper .swiper-pagination",
        clickable: false,
        type: "custom",
        renderCustom: function(swiper, current, total) {
            return (
                '<span class="current">' + 0 + (current) + '</span>' + '<span class="total">' + 0 + (total) + '</span>'
            );
        }
    },

    //arrow
    navigation: {
        nextEl: ".main-swiper .swiper-button-next",
        prevEl: ".main-swiper .swiper-button-prev",
    },

    on: {
        autoplayTimeLeft(s, time, progress) {
            progressLine.style.setProperty("--progress", 1 - progress)
        }
    }
});

