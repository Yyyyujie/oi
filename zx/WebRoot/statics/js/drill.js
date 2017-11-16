var drillDown = {
	flag : true,
	canBack : true,
	taskStatus : null, //任务状态 0-未完成 1-已完成
	dataType:"first",
	getOption : function() { //设置部分
		var option = null;
		option = {
			title : {
				text : '',
				subtext : '',
				x : 'center'
			},
			tooltip : {
				trigger : 'item',
				formatter : "{a} <br/>{b} : {c}件"
			},
			legend : {
				orient : 'vertical',
				left : 'left',
				data : []
			},
			grid : {
				top : '40%',
				width : '100%',
				bottom : 0,
				left : 10,
				containLabel : true
			},
			yAxis : [
				{
					'type' : 'category',
					'axisLabel' : {
						'interval' : 0
					},
					'nameRotate' : 180,
					'insie' : true,
					'data' : []
				}
			],
			xAxis : [
				{
					type : 'value',
					name : '个',
					
				}
			],
			series : [
				{
					name : '未完成',
					type : 'bar',
				
					label : {
						normal : {
							show : true,
							position : 'inside',
							formatter : '{c}',
						}
					}
				},
				{
					name : '已完成',
					type : 'bar',
			
					label : {
						normal : {
							show : true,
							position : 'inside',
							formatter : '{c}',
						}
					},
				/*                    markPoint:{
				                        data:[
				                            {type:'max',name:'最大值'},
				                            {type:'min',name:'最小值'}

				                        ]
				                    },*/
				},

				{
					name : '部门情况',
					type : 'pie',
					center : [ '50%', '22%' ],
					radius : '30%',
					z : 100,
					/*center:[150,100],*/
					label : {
						normal : {
							show : true,
							position : 'outside',
							formatter : '{b}\n({d}%)',
						}
					},
					labelLine : {
						normal : {
							show : true,
						}
					},
					data : [],
					itemStyle : {
						emphasis : {
							shadowBlur : 10,
							shadowOffsetX : 0,
							shadowColor : 'rgba(0, 0, 0, 0.5)'
						}
					}
				}
			]
		};
		return option;
	},
	initChart : function(myChart, option) {
		myChart.setOption(option);
		// 异步加载数据
		if(drillDown.dataType==="first"){
			$.ajax({
				url : rootPath + '/Newstaff/DataCenterFirst',
				dataType : "json",
				type : "post",
				success : function(data) {
					var e = data.extend;
					var val = [];

					val[0] = {
						value : e.finish.value,
						name : e.finish.name
					};
					val[1] = {
						value : e.unfinish.value,
						name : e.unfinish.name
					};
					myChart.setOption({
						series : [
							{
								name : '部门情况',
								type : 'pie',
								data : val,
								itemStyle : {
									emphasis : {
										shadowBlur : 10,
										shadowOffsetX : 0,
										shadowColor : 'rgba(0, 0, 0, 0.5)'
									}
								}
							},

						]
					});
					drillDown.dataType="second";
				}
			})
		}
		myChart.on('click', function(object) {
			echarts.dispose(dom4);
			console.log(object);
			// 初始化一个新的实例
			console.log("initChart");
			var myChart = echarts.init(dom4);
			if (object.componentSubType == 'pie') {
				var dept_id=object.data.id,data;
				console.log(drillDown.dataType);
				if (object.name == "已完成") {
					drillDown.taskStatus = 1;
					data=drillDown.dataType=="second"&&"status=1";
					getChartAjax(data, myChart,"DataCenterLoop2");
				} else if (object.name == "未完成") {
					drillDown.taskStatus = 0;
					data=drillDown.dataType=="second"&&"status=0";
					getChartAjax(data, myChart,"DataCenterLoop2");
				}else {
					if(drillDown.taskStatus==1){
						data=drillDown.dataType=="three"&&"status=1&dept_id="+dept_id;
						getChartAjax(data, myChart,"DataCenterLoop2");
					}else if(drillDown.taskStatus==0){
						data=drillDown.dataType=="three"&&"status=0&dept_id="+dept_id;
						getChartAjax(data, myChart,"DataCenterLoop2");
					}
				}
			} else if (object.componentSubType == 'bar') {
				console.log("id:", object.data.id);
				if(drillDown.dataType=="three"){
					if(drillDown.taskStatus==1){
						data=drillDown.dataType=="three"&&"status=1&user_id="+object.data.id;
						getChartAjax_2(data, myChart,"DataCenterList");
					}else if(drillDown.taskStatus==0){
						data=drillDown.dataType=="three"&&"status=0&user_id="+object.data.id;
						getChartAjax_2(data, myChart,"DataCenterList");
					}
				}else if(drillDown.dataType=="four"){
					kAlert({
				        title: "没有更多数据",
				        subtitle: "确定返回之前的数据",
				        btns: ["确定"]
				      },function(){
				    	  echarts.dispose(dom4);
				    	  drillDown.dataType="first";
				    	  var myChart = echarts.init(dom4);
				    	  var option = drillDown.getOption();
				    	  drillDown.initChart(myChart, option);
				      })
				}
			}
		});

	},
};

//初始化表格JS
var dom4 = document.getElementById("main4");
var myChart4 = echarts.init(dom4);
var option4 = drillDown.getOption();
drillDown.initChart(myChart4, option4);


function getChartAjax(data, myChart,link) { //一级获取数据
	$.ajax({
		url : rootPath + '/Newstaff/'+link+'?' + data,
		type : "post",
		dataType : "json",
		success : function(data) {
			console.log(data);
			var data = data.extend; 
			if(data.cake.length<=0){
				kAlert({
			        title: "没有更多数据",
			        subtitle: "确定返回之前的数据",
			        btns: ["确定"]
			      },function(){
			    	  echarts.dispose(dom4);
			    	  drillDown.dataType="first";
			    	  var myChart = echarts.init(dom4);
			    	  var option = drillDown.getOption();
			    	  drillDown.initChart(myChart, option);
			      })
			}
			var val = [],
				names = data.names;
			var counts = [];
			for (var i = 0; i < data.counts.length; i++) {
				console.log(data.counts[i]);
				for (var k = 0; k < data.ids.length; k++) {
					counts.push({
						value : data.counts[i],
						id : data.ids[k]
					})
					break;
				}
			}
			for (var i = 0; i < data.cake.length; i++) {
				val.push({
					value : data.cake[i].value_b,
					name : data.cake[i].name,
					id : data.cake[i].value
				});
			}
			var option = drillDown.getOption();
			option.yAxis[0].data = names;
			option.series[0].data = counts;
			option.series[2].data = val;
			var dom4 = document.getElementById("main4");
			var myChart4 = echarts.init(dom4);
			drillDown.initChart(myChart4, option);
			drillDown.flag = false;
			drillDown.canBack = true;
			drillDown.dataType="three";
		}
	})
}
function getChartAjax_2(data, myChart,link) { //一级获取数据
	$.ajax({
		url : rootPath + '/Newstaff/'+link+'?' + data,
		type : "post",
		dataType : "json",
		success : function(data) {
			
			var data=data.extend.list;
			var names=[],value=[];
			for(var i=0;i<data.length;i++){
				names.push(data[i].name);
				value.push(data[i].value);
			}
			console.log(data);
			var option = drillDown.getOption();
			option.yAxis[0].data = names;
			option.series[0].data = value;
			var dom4 = document.getElementById("main4");
			var myChart4 = echarts.init(dom4);
			drillDown.initChart(myChart4, option);
			drillDown.flag = false;
			drillDown.canBack = true;
			drillDown.dataType="four";
		}
	})
}