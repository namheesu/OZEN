/**
 * 
 */
const cPath = document.body.dataset.contextPath;

$(document).ready(function(){
	let date = new Date();
	// 오늘
	var today = new Date().toISOString().slice(0,10);
	// 올해
	var year = document.getElementById('yearDate').value;
	
	// 오늘 기본 값 설정
	document.getElementById('searchDate').value = today;
	// 미래 선택 불가
	document.getElementById('searchDate').setAttribute("max",today);
	// 그래프 연도
	document.getElementById('year').innerHTML = year.substring(0,4)+'년';
	// 상단바 연도
	document.getElementById('yearTop').innerHTML = year.substring(0,4);
	// 상단바 월
	document.getElementById('monthTop').innerHTML = today.substring(5,7);
	
	var searchDate = document.getElementById("searchDate").value
	$.ajax({
		type:"POST"
		, url: cPath + `/emp/pos/acnt/spending/search`
		, dataType:"json"
		, contentType:"application/json"
		, data: JSON.stringify(searchDate)
		, success: function(jsonObj){
		var month = parseInt(jsonObj.monthSalarySpending[0].spendingDate.substring(5,7)) - 1;
			if(month < 1){
				month = 12;
			}
			// 전월 지출
			var salary = parseInt(jsonObj.yearSalarySpending[month - 1].total) ;
			var fxtr = parseInt(jsonObj.yearFxtrsSpending[month - 1].total);
			var main = parseInt(jsonObj.yearMainSpending[month - 1].total);
			var total = salary + fxtr + main ;
			var beforMonth = parseInt(jsonObj.monthTotal) - total;	
		if(beforMonth > 0 ){
			// 상단 바 전월대비
			document.getElementById('dayTopValue').innerHTML = "+" + beforMonth.toLocaleString('ko-KR') + "원";				
			}else{
			document.getElementById('dayTopValue').innerHTML = "-" + beforMonth.toLocaleString('ko-KR') + "원";				
			}
			
		}, error : function(resp, status, error){
			console.log(error);
		}
			
});
});
// 달력 값이 변경될 시
$("#searchDate").on("change",(event)=>{
	var searchDate = document.getElementById("searchDate").value
	$.ajax({
		type:"POST"
		, url: cPath + `/emp/pos/acnt/spending/search`
		, dataType:"json"
		, contentType:"application/json"
		, data: JSON.stringify(searchDate)
		, success: function(jsonObj){
			// 그래프 값 변경
			updateGraph(jsonObj);
			// 연도 변경
			document.getElementById('year').innerHTML = jsonObj.yearSalarySpending[0].spendingDate.substring(0,4)+'년';
			// 상단 바 연도 변경
			document.getElementById('yearTop').innerHTML = jsonObj.yearSalarySpending[0].spendingDate.substring(0,4);
			// 상단 바 연매출 변경
			document.getElementById('yearTopValue').textContent = jsonObj.yearTotal.toLocaleString('ko-KR') + "원";
			// 상단 바 월 변경
			document.getElementById('monthTop').innerHTML = jsonObj.monthSalarySpending[0].spendingDate.substring(5,7);
			// 상단 바 월매출 변경
			document.getElementById('monthTopValue').textContent = jsonObj.monthTotal.toLocaleString('ko-KR') + "원";
			
			var month = parseInt(jsonObj.monthSalarySpending[0].spendingDate.substring(5,7)) - 1;
			if(month < 1){
				month = 12;
			}
			// 전월 지출
			var salary = parseInt(jsonObj.yearSalarySpending[month - 1].total) ;
			var fxtr = parseInt(jsonObj.yearFxtrsSpending[month - 1].total);
			var main = parseInt(jsonObj.yearMainSpending[month - 1].total);
			var total = salary + fxtr + main ;
			var beforMonth = parseInt(jsonObj.monthTotal) - total;
			if(beforMonth > 0 ){
			// 상단 바 전월대비
			document.getElementById('dayTopValue').innerHTML = "+" + beforMonth.toLocaleString('ko-KR') + "원";				
			}else{
			document.getElementById('dayTopValue').innerHTML = "-" + beforMonth.toLocaleString('ko-KR') + "원";				
			}
			
		}, error : function(resp, status, error){
			console.log(error);
		}
	});
});

function movePage(url){
	window.location.href = url;
}


// 그래프 값 변경
function updateGraph(jsonObj){
	
 	var echartsLineShareDatasetChartInit = function echartsLineShareDatasetChartInit() {
	var $lineShareChartEl = document.querySelector('.echart-line-share-dataset-chart-example');
		var currentDay = new Date();
		var currentMonth = currentDay.getMonth()+1;
		if ($lineShareChartEl) {
			    // Get options from data attribute
			    var userOptions = utils.getData($lineShareChartEl, 'options');
			    var chart = window.echarts.init($lineShareChartEl);

			    var getDefaultOptions = function getDefaultOptions() {
			      return {
			        dataset: {
			          source: [['product', '1월', '2월', '3월', '4월', '5월', '6월', '7월', '8월', '9월', '10월', '11월', '12월']
							, ['인건비'
								, jsonObj.yearSalarySpending[0].total
								, jsonObj.yearSalarySpending[1].total
								, jsonObj.yearSalarySpending[2].total
								, jsonObj.yearSalarySpending[3].total
								, jsonObj.yearSalarySpending[4].total
								, jsonObj.yearSalarySpending[5].total
								, jsonObj.yearSalarySpending[6].total
								, jsonObj.yearSalarySpending[7].total
								, jsonObj.yearSalarySpending[8].total
								, jsonObj.yearSalarySpending[9].total
								, jsonObj.yearSalarySpending[10].total
								, jsonObj.yearSalarySpending[11].total
									]
							, ['비품비'
								, jsonObj.yearFxtrsSpending[0].total
								, jsonObj.yearFxtrsSpending[1].total
								, jsonObj.yearFxtrsSpending[2].total
								, jsonObj.yearFxtrsSpending[3].total
								, jsonObj.yearFxtrsSpending[4].total
								, jsonObj.yearFxtrsSpending[5].total
								, jsonObj.yearFxtrsSpending[6].total
								, jsonObj.yearFxtrsSpending[7].total
								, jsonObj.yearFxtrsSpending[8].total
								, jsonObj.yearFxtrsSpending[9].total
								, jsonObj.yearFxtrsSpending[10].total
								, jsonObj.yearFxtrsSpending[11].total
									]
							, ['유지비'
								, jsonObj.yearMainSpending[0].total
								, jsonObj.yearMainSpending[1].total
								, jsonObj.yearMainSpending[2].total
								, jsonObj.yearMainSpending[3].total
								, jsonObj.yearMainSpending[4].total
								, jsonObj.yearMainSpending[5].total
								, jsonObj.yearMainSpending[6].total
								, jsonObj.yearMainSpending[7].total
								, jsonObj.yearMainSpending[8].total
								, jsonObj.yearMainSpending[9].total
								, jsonObj.yearMainSpending[10].total
								, jsonObj.yearMainSpending[11].total
									]]
			        },
			      };
			    };
			    echartSetOption(chart, userOptions, getDefaultOptions);
			    chart.on('updateAxisPointer', function (event) {
			      var xAxisInfo = event.axesInfo[0];

			      if (xAxisInfo) {
			        var dimension = xAxisInfo.value + 1;
			        chart.setOption({
			          series: {
			            id: 'pie',
			            label: {
			              formatter: "{b}: {@[".concat(dimension, "]} ({d}%)")
			            },
			            encode: {
			              value: dimension,
			              tooltip: dimension
			            }
			          }
			        });
			      }
			    });
			  }
			};
			
			docReady(echartsLineShareDatasetChartInit);
	
	
}