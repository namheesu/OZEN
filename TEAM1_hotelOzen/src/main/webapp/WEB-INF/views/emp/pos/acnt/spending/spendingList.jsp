<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<link href="${pageContext.request.contextPath}/resources/css/emp/pos/acnt/selling/selling.css"
	rel="stylesheet">
<link href="${pageContext.request.contextPath}/resources/css/common/btn.css"
	rel="stylesheet">
<script type="module"
	src="<c:url value='/resources/js/app/common/line-share-dataset-chart.js'/>"></script>

<div class="col mb-3 d-flex">
	<div class="card  label-box">
		<div>
			<label><font id="yearTop"></font>년 지출</label>
			<h5 id="yearTopValue">
				<fmt:formatNumber value="${yearTotal}" pattern="#,###" />
				원
			</h5>
		</div>
	</div>
	<div class="card mx-2 label-box">
		<div>
			<label><font id="monthTop"></font>월 지출</label>
			<h5 id="monthTopValue">
				<fmt:formatNumber value="${monthTotal}" pattern="#,###" />
				원
			</h5>
		</div>
	</div>
	<div class="card label-box">
		<div>
			<label><font id="dayTop"></font>전월 대비</label>
			<h5 id="dayTopValue">
				
				<fmt:formatNumber value="" pattern="#,###" />
				원
			</h5>
		</div>
	</div>
</div>
<div class="mb-2 date-box d-flex"
	style="justify-content: space-between;">
	<div style="margin-left: 5px;">
		<button type="button" class="custom-btn btn-7" id="selling"
			onclick="movePage('${pageContext.request.contextPath}/emp/pos/acnt/selling')">매출</button>
		<button type="button" class="custom-btn btn-7" id="spending"
			onclick="movePage('${pageContext.request.contextPath}/emp/pos/acnt/spending')">지출</button>
	</div>
	<div>
		<input type="date" id="searchDate" name="searchDate">
	</div>
</div>
<div class="col mb-3">
	<div class="card h-100">
		<div class="card-header">
			<div class="row flex-between-end">
				<div class="col-auto align-self-center d-flex">
					<div class="d-flex" style="align-items: center;">
						<h5 class="mb-0" data-anchor="data-anchor" id="share-dataset">
							<font style="vertical-align: inherit;"> 
							<font id="year" style="vertical-align: inherit;"></font> 
							<font style="vertical-align: inherit;">지출현황</font>
							</font>
						</h5>
					</div>
					<input type="hidden" id="yearDate" 	value="${yearSalarySpending[0].spendingDate }"> 
					<input type="hidden" id="monthDate" value="${monthSalarySpending[0].spendingDate }">
				</div>
				<div class="col-auto ms-auto">
					<div class="nav nav-pills nav-pills-falcon flex-grow-1"
						role="tablist"></div>
				</div>
			</div>
		</div>
		<div class="card-body bg-light">
			<div class="tab-content">
				<div class="echart-line-share-dataset-chart-example"
					style="min-height: 500px; user-select: none; position: relative;"
					data-echart-responsive="true"></div>
			</div>
		</div>
	</div>
</div>



<script
	src="<c:url value='/resources/js/app/common/echarts-example.js'/>"></script>
<script defer
	src="<c:url value='/resources/js/app/emp/pos/acnt/spending/spending.js'/>"></script>
<script>
	// 연도별 매출현황

		var echartsLineShareDatasetChartInit = function echartsLineShareDatasetChartInit() {
			  var $lineShareChartEl = document.querySelector('.echart-line-share-dataset-chart-example');
			  var currentDay = new Date();
			  var currentMonth = currentDay.getMonth()+1;
			  if ($lineShareChartEl) {
			    var userOptions = utils.getData($lineShareChartEl, 'options');
			    var chart = window.echarts.init($lineShareChartEl);

			    var getDefaultOptions = function getDefaultOptions() {
				console.log("getDefaultOptions", chart)
			      return {
			        color: ['#FD9394', '#9CF99F', '#F0FF6C'],
			        legend: {
			          top: 0,
			          textStyle: {
			            color: utils.getGrays()['700']
			          }
			        },
			        tooltip: {
			          trigger: 'axis',
			          showContent: false
			        },
			        dataset: {
			          source: [['product', '1월', '2월', '3월', '4월', '5월', '6월', '7월', '8월', '9월', '10월', '11월', '12월']
							, ['인건비'
								, ${yearSalarySpending[0].total}
								, ${yearSalarySpending[1].total}
								, ${yearSalarySpending[2].total}
								, ${yearSalarySpending[3].total}
								, ${yearSalarySpending[4].total}
								, ${yearSalarySpending[5].total}
								, ${yearSalarySpending[6].total}
								, ${yearSalarySpending[7].total}
								, ${yearSalarySpending[8].total}
								, ${yearSalarySpending[9].total}
								, ${yearSalarySpending[10].total}
								, ${yearSalarySpending[11].total}
									]
							, ['비품비'
								, ${yearFxtrsSpending[0].total}
								, ${yearFxtrsSpending[1].total}
								, ${yearFxtrsSpending[2].total}
								, ${yearFxtrsSpending[3].total}
								, ${yearFxtrsSpending[4].total}
								, ${yearFxtrsSpending[5].total}
								, ${yearFxtrsSpending[6].total}
								, ${yearFxtrsSpending[7].total}
								, ${yearFxtrsSpending[8].total}
								, ${yearFxtrsSpending[9].total}
								, ${yearFxtrsSpending[10].total}
								, ${yearFxtrsSpending[11].total}
									]
							, ['유지비'
								, ${yearMainSpending[0].total}
								, ${yearMainSpending[1].total}
								, ${yearMainSpending[2].total}
								, ${yearMainSpending[3].total}
								, ${yearMainSpending[4].total}
								, ${yearMainSpending[5].total}
								, ${yearMainSpending[6].total}
								, ${yearMainSpending[7].total}
								, ${yearMainSpending[8].total}
								, ${yearMainSpending[9].total}
								, ${yearMainSpending[10].total}
								, ${yearMainSpending[11].total}
								]]
			        },
			        xAxis: {
			          type: 'category',
			          axisLine: {
			            lineStyle: {
			              color: utils.getGrays()['300']
			            }
			          },
			          axisLabel: {
			            color: utils.getGrays()['600']
			          },
			          axisPointer: {
			            lineStyle: {
			              color: utils.getGrays()['300']
			            }
			          }
			        },
			        yAxis: {
			          gridIndex: 0,
			          axisLabel: {
			            color: utils.getGrays()['600']
			          },
			          splitLine: {
			            lineStyle: {
			              color: utils.getGrays()['200']
			            }
			          }
			        },
			        series: [{
			          type: 'line',
			          smooth: true,
			          seriesLayoutBy: 'row',
			          emphasis: {
			            focus: 'series'
			          },
			          symbolSize: 10,
			          itemStyle: {
			            color: utils.getGrays().white,
			            borderColor: '#FD9394',
			            borderWidth: 2
			          },
			          lineStyle: {
			            color: '#FD9394'
			          },
			          symbol: 'circle'
			        }, {
			          type: 'line',
			          smooth: true,
			          seriesLayoutBy: 'row',
			          emphasis: {
			            focus: 'series'
			          },
			          symbolSize: 10,
			          itemStyle: {
			            color: utils.getGrays().white,
			            borderColor: '#9CF99F',
			            borderWidth: 2
			          },
			          lineStyle: {
			            color:'#9CF99F'
			          },
			          symbol: 'circle'
			        }, {
			          type: 'line',
			          smooth: true,
			          seriesLayoutBy: 'row',
			          emphasis: {
			            focus: 'series'
			          },
			          symbolSize: 10,
			          itemStyle: {
			            color: utils.getGrays().white,
			            borderColor: '#F0FF6C',
			            borderWidth: 2
			          },
			          lineStyle: {
			            color: '#F0FF6C'
			          },
			          symbol: 'circle'
			        }, {
			          type: 'pie',
			          id: 'pie',
			          radius: '30%',
			          center: ['50%', '28%'],
			          emphasis: {
			            focus: 'data'
			          },
			          label: {
			            formatter: '{b}: {@'+currentMonth+'월} ({d}%)',
			            color: utils.getGrays()['600']
			          },
			          encode: {
			            itemName: 'product',
			            value: currentMonth+'월',
			            tooltip: currentMonth+'월'
			          }
			        }],
			        grid: {
			          right: 10,
			          left: 5,
			          bottom: 5,
			          top: '55%',
			          containLabel: true
			        }
			      };
			    };
				console.log( '{b}: {'+currentMonth+'월} ({d}%)');
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
	    
</script>