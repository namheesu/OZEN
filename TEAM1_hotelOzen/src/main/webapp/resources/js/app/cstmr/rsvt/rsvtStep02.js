/**
 * 
 */
//var floatPosition = parseInt($(".sideBanner").css('top'))
//
//// scroll 인식
//$(window).scroll(function() {
//  
//    // 현재 스크롤 위치
//    var currentTop = $(window).scrollTop();
//    var bannerTop = currentTop + floatPosition + "px";
//
//    //이동 애니메이션
//    $(".sideBanner").stop().animate({
//      "top" : bannerTop
//    }, 400);
//
//}).scroll();


flatpickr(timepicker2, {
	mode : "range",
	minDate : "today",
	dateFormat : "Y-m-d",
	"locale" : "ko"
});