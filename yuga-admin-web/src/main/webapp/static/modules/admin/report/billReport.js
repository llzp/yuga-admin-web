$(document).ready(function() {
	var url,title;
	var date = new Date();
	var myChart = echarts.init(document.getElementById('main'));
	var option = {
		title : {
			text : "",
			x:"center"
		},
		tooltip : {
			trigger : 'axis'
		},
		toolbox : {
			show : true,
			feature : {
				dataView : {
					show : true,
					readOnly : false
				},
				saveAsImage : {
					show : true
				}
			}
		},
		calculable : true,
		xAxis : [ {
			type : 'category',
			boundaryGap : false,
			data : []
		} ],
		yAxis : [ {
			type : 'value',
			axisLabel : {
				formatter : '{value} 元'
			}
		} ],
		series : [ {
			name : '销售额',
			type : 'line',
			stack : '销售额',
			data : []
		} ]
	};
	myChart.setOption(option);
	$("#week").click(function() {
		title=date.getFullYear()+"年"+(date.getMonth()+1)+"月"+date.getDate()+"日本周营收报表";
		getMessage($("#week").attr('id'),title);
	});
	$("#month").click(function() {
		title=date.getFullYear()+"年"+(date.getMonth()+1)+"月营收报表";
		getMessage($("#month").attr('id'),title);
	});
	$("#year").click(function() {
		title=date.getFullYear()+"年营收报表";
		getMessage($("#year").attr('id'),title);
	});
	$("#resetbtn").click(function() {
		$("#orgIdId").val("-1");
	});
	
	function getMessage(state,title) {
		var myChart = echarts.init(document.getElementById('main'));
		var orgId=$("#orgIdId").val();
		var orgName=$("#orgIdName").val();
		if(orgId==-1){
			orgName="微动";
		}
		if(orgId==undefined){
			orgId="-2";
			orgName="";
		}
		$.post("/yuga-admin/a/admin/report/billReport/list", {
			"state" : state,"orgId":orgId
		}, function(data) {
			option.title.text=orgName+title;
			option.xAxis[0].data = eval(data.categories);
			option.series[0].data = eval(data.data);
			myChart.hideLoading();
			myChart.setOption(option);
		});
	}
});

function page(n, s) {
	$("#pageNo").val(n);
	$("#pageSize").val(s);
	$("#searchForm").submit();
	return false;
}