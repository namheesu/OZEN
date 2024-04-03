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
	// 검색 시작일
	var searchStart = document.getElementById('rsvtStart').value;
	// 검색 종료일
	var searchEnd = document.getElementById('rsvtEnd').value;
	
	
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
	// 상단바 예약일
	document.getElementById('rsvtTop').innerHTML = today.substring(5,7)+'월'+today.substring(8,10);
	// 상단바 일매출
	document.getElementById('dayTop').innerHTML = today.substring(5,7)+'월'+today.substring(8,10);
	// 주 날짜 주입
	document.getElementById('weekRsvt').innerHTML = searchStart + "(월) ~ " + searchEnd+"(일)";
	// 주간 예약 날짜 주입
	document.getElementById('week').innerHTML = searchStart + "(월) ~ " + searchEnd+"(일)";
});

// 달력 값이 변경될 시
$("#searchDate").on("change",(event)=>{
	var searchDate = document.getElementById("searchDate").value
	$.ajax({
		type:"POST"
		, url: cPath + `/emp/pos/acnt/selling/search`
		, dataType:"json"
		, contentType:"application/json"
		, data: JSON.stringify(searchDate)
		, success: function(jsonObj){
			// 그래프 값 변경
			updateGraph(jsonObj);
			// 연도 변경
			document.getElementById('year').innerHTML = jsonObj.yearCPROSelling[0].sellingDate.substring(0,4)+'년';
			// 상단 바 연도 변경
			document.getElementById('yearTop').innerHTML = jsonObj.yearCPROSelling[0].sellingDate.substring(0,4);
			// 상단 바 연매출 변경
			document.getElementById('yearTopValue').textContent = jsonObj.yearTotal.toLocaleString('ko-KR') + "원";
			// 상단 바 월 변경
			document.getElementById('monthTop').innerHTML = jsonObj.monthCPROSelling[0].sellingDate.substring(5,7);
			// 상단 바 월매출 변경
			document.getElementById('monthTopValue').textContent = jsonObj.monthTotal.toLocaleString('ko-KR') + "원";
			// 상단 바 일 변경
			document.getElementById('dayTop').innerHTML = searchDate.substring(5,7)+'월'+searchDate.substring(8,10);
			// 상단 바 일매출 변경
			document.getElementById('dayTopValue').textContent = jsonObj.dayTotal.toLocaleString('ko-KR') + "원";
			// 상단 예약일 변경
			document.getElementById('rsvtTop').innerHTML = searchDate.substring(5,7)+'월'+searchDate.substring(8,10);
			// 상단 바 예약 수 변경
			document.getElementById('rsvtTopValue').textContent = jsonObj.rsvtCount + "건";
			// 주 변경
			document.getElementById('week').innerHTML = jsonObj.weekCPROSelling[0].sellingDate +'(월) ~ ' + jsonObj.weekCPROSelling[6].sellingDate + '(일)';
			// 예약 주 변경
			document.getElementById('weekRsvt').innerHTML = jsonObj.weekRsvt[0].rsvtDate +'(월) ~ ' + jsonObj.weekRsvt[6].rsvtDate + '(일)';
		}, error : function(resp, status, error){
			console.log(error);
		}
	});
});

function movePage(url){
//	$.ajax({
//		type:"GET"
//		, url : url
//		, dataType : "html"
//		, data : document.getElementById('bodyContents').html
//		, success : function(data){
//			$('#bodyContents').empty().html(data);
//		},
//		error:function(xhr, status, error){
//			console.log(error);
//		}
//	});
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
							, ['호텔예약'
								, jsonObj.yearCPROSelling[0].total
								, jsonObj.yearCPROSelling[1].total
								, jsonObj.yearCPROSelling[2].total
								, jsonObj.yearCPROSelling[3].total
								, jsonObj.yearCPROSelling[4].total
								, jsonObj.yearCPROSelling[5].total
								, jsonObj.yearCPROSelling[6].total
								, jsonObj.yearCPROSelling[7].total
								, jsonObj.yearCPROSelling[8].total
								, jsonObj.yearCPROSelling[9].total
								, jsonObj.yearCPROSelling[10].total
								, jsonObj.yearCPROSelling[11].total
									]
							, ['룸서비스'
								, jsonObj.yearCKOTSelling[0].total
								, jsonObj.yearCKOTSelling[1].total
								, jsonObj.yearCKOTSelling[2].total
								, jsonObj.yearCKOTSelling[3].total
								, jsonObj.yearCKOTSelling[4].total
								, jsonObj.yearCKOTSelling[5].total
								, jsonObj.yearCKOTSelling[6].total
								, jsonObj.yearCKOTSelling[7].total
								, jsonObj.yearCKOTSelling[8].total
								, jsonObj.yearCKOTSelling[9].total
								, jsonObj.yearCKOTSelling[10].total
								, jsonObj.yearCKOTSelling[11].total
									]
							, ['워크인'
								, jsonObj.yearWALKSelling[0].total
								, jsonObj.yearWALKSelling[1].total
								, jsonObj.yearWALKSelling[2].total
								, jsonObj.yearWALKSelling[3].total
								, jsonObj.yearWALKSelling[4].total
								, jsonObj.yearWALKSelling[5].total
								, jsonObj.yearWALKSelling[6].total
								, jsonObj.yearWALKSelling[7].total
								, jsonObj.yearWALKSelling[8].total
								, jsonObj.yearWALKSelling[9].total
								, jsonObj.yearWALKSelling[10].total
								, jsonObj.yearWALKSelling[11].total
									]
							, ['멤버십'
								, jsonObj.yearCPMBSelling[0].total
								, jsonObj.yearCPMBSelling[1].total
								, jsonObj.yearCPMBSelling[2].total
								, jsonObj.yearCPMBSelling[3].total
								, jsonObj.yearCPMBSelling[4].total
								, jsonObj.yearCPMBSelling[5].total
								, jsonObj.yearCPMBSelling[6].total
								, jsonObj.yearCPMBSelling[7].total
								, jsonObj.yearCPMBSelling[8].total
								, jsonObj.yearCPMBSelling[9].total
								, jsonObj.yearCPMBSelling[10].total
								, jsonObj.yearCPMBSelling[11].total
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
	
	
  var echartsHorizontalStackedChartInit = function echartsHorizontalStackedChartInit() {
  var $horizontalStackChartEl = document.querySelector('.echart-horizontal-stacked-chart-example');

  if ($horizontalStackChartEl) {
    // Get options from data attribute
    var userOptions = utils.getData($horizontalStackChartEl, 'options');
    var chart = window.echarts.init($horizontalStackChartEl);

    var getDefaultOptions = function getDefaultOptions() {
      return {
        series: [{
        
          data: [
        	  jsonObj.weekCPROSelling[6].total
        	  , jsonObj.weekCPROSelling[5].total
        	  , jsonObj.weekCPROSelling[4].total
        	  , jsonObj.weekCPROSelling[3].total
        	  , jsonObj.weekCPROSelling[2].total
        	  , jsonObj.weekCPROSelling[1].total
        	  , jsonObj.weekCPROSelling[0].total
        	  ]
        }, {
        
          data: [
        	  jsonObj.weekCKOTSelling[6].total
        	  , jsonObj.weekCKOTSelling[5].total
        	  , jsonObj.weekCKOTSelling[4].total
        	  , jsonObj.weekCKOTSelling[3].total
        	  , jsonObj.weekCKOTSelling[2].total
        	  , jsonObj.weekCKOTSelling[1].total
        	  , jsonObj.weekCKOTSelling[0].total
          ]
        }, {
          
          data: [
        	  jsonObj.weekWALKSelling[6].total
        	  , jsonObj.weekWALKSelling[5].total
        	  , jsonObj.weekWALKSelling[4].total
        	  , jsonObj.weekWALKSelling[3].total
        	  , jsonObj.weekWALKSelling[2].total
        	  , jsonObj.weekWALKSelling[1].total
        	  , jsonObj.weekWALKSelling[0].total
          ]
        }, {
          
          data: [
        	  jsonObj.weekCPMBSelling[6].total
        	  , jsonObj.weekCPMBSelling[5].total
        	  , jsonObj.weekCPMBSelling[4].total
        	  , jsonObj.weekCPMBSelling[3].total
        	  , jsonObj.weekCPMBSelling[2].total
        	  , jsonObj.weekCPMBSelling[1].total
        	  , jsonObj.weekCPMBSelling[0].total
          ]
        }]
      };
    };
    echartSetOption(chart, userOptions, getDefaultOptions);
  }
};
docReady(echartsHorizontalStackedChartInit);


var echartsLineAreaChartInit = function echartsLineAreaChartInit() {
var $lineAreaChartEl = document.querySelector('.echart-line-area-chart-example');

		  if ($lineAreaChartEl) {
		    var userOptions = utils.getData($lineAreaChartEl, 'options');
		    var chart = window.echarts.init($lineAreaChartEl);
		    var months = ['월', '화', '수', '목', '금', '토', '일'];
		    var data = [
		    	jsonObj.weekRsvt[0].rsvtCount
		    	, jsonObj.weekRsvt[1].rsvtCount
		    	, jsonObj.weekRsvt[2].rsvtCount
		    	, jsonObj.weekRsvt[3].rsvtCount
		    	, jsonObj.weekRsvt[4].rsvtCount
		    	, jsonObj.weekRsvt[5].rsvtCount
		    	, jsonObj.weekRsvt[6].rsvtCount
		    ];

		    var _tooltipFormatter7 = function _tooltipFormatter7(params) {
		      return "\n      <div>\n          <h6 class=\"fs--1 text-700 mb-0\">\n            <span class=\"fas fa-circle me-1\" style='color:".concat(params[0].borderColor, "'></span>\n            ").concat(params[0].name, " : ").concat(params[0].value, "\n          </h6>\n      </div>\n      ");
		    };

		    var getDefaultOptions = function getDefaultOptions() {
		      return {
		
		        series: [{
		          type: 'line',
		          data: data,
		          itemStyle: {
		            color: utils.getGrays().white,
		            borderColor: utils.getColor('primary'),
		            borderWidth: 2
		          },
		          lineStyle: {
		            color: utils.getColor('primary')
		          },
		          showSymbol: false,
		          symbolSize: 10,
		          symbol: 'circle',
		          smooth: false,
		          hoverAnimation: true,
		          areaStyle: {
		            color: {
		              type: 'linear',
		              x: 0,
		              y: 0,
		              x2: 0,
		              y2: 1,
		              colorStops: [{
		                offset: 0,
		                color: utils.rgbaColor(utils.getColors().primary, 0.5)
		              }, {
		                offset: 1,
		                color: utils.rgbaColor(utils.getColors().primary, 0)
		              }]
		            }
		          }
		        }],
		      };
		    };
		    echartSetOption(chart, userOptions, getDefaultOptions);
		  }
		};
		  docReady(echartsLineAreaChartInit);
}