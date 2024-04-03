/**
 * 
 */

// 서브메뉴 아코디언
$(function(){
	$(".navi>li").mouseover(function(){
		$(this).find(".sub01")
           .stop()
           .slideDown(500)
           .css({
               'text-align': 'center'
           });
	});
	$(".navi>li").mouseleave(function(){
		$(this).find(".sub01").stop().slideUp(500);
	});
});

if(document.getElementById('logoutATag') != null){	
	logoutATag.addEventListener('click', function(){
		event.preventDefault();
		logoutForm.submit();
	
	})
}
	
$.getJSON('https://api.openweathermap.org/data/2.5/weather?q=Jeju%20City,%20KR&appid=724a70fb80baa29d45cb708820e544e4&units=metric', function (WeatherResult) {
    var weatherIconCode = WeatherResult.weather[0].icon;
    var weatherCondition = ""; // 날씨 상태를 저장할 변수 추가

    if (weatherIconCode.includes('01')) {
        weatherCondition = "맑음";
    } else if (weatherIconCode.includes('02') || weatherIconCode.includes('03')) {
        weatherCondition = "흐림";
    } else if (weatherIconCode.includes('04')) {
        weatherCondition = "구름 많음";
    }

	var tempCut = Math.floor(WeatherResult.main.temp);
	$('.Jejutemp').append('<span class="tempDetail">' + tempCut + "°C</span>" + '<span class="wcDetail">' + weatherCondition + "</span>"); // 온도와 날씨 상태 함께 출력
	
	
	var weathericonUrl = '<img src="http://openweathermap.org/img/wn/' + WeatherResult.weather[0].icon + '.png" alt="' + WeatherResult.weather[0].description + '"/>';
	$('.JejuIcon').html(weathericonUrl);
});

$.getJSON('http://api.openweathermap.org/data/2.5/air_pollution?lat=33.5097&lon=126.5219&appid=724a70fb80baa29d45cb708820e544e4', function(AirResult) {
	var dustLevel = AirResult.list[0].components.pm2_5;

    // 조건문을 사용하여 대기 오염 레벨에 따른 텍스트 표시
    var airQualityMessage = "";
    if (dustLevel < 30) {
        airQualityMessage = "좋음";
    } else if (dustLevel < 80) {
        airQualityMessage = "보통";
    } else {
        airQualityMessage = "나쁨";
    }
	
    $('.Jejudust').append(airQualityMessage);
});
