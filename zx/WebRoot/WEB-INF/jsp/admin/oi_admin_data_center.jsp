<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<base href="<%=basePath%>">
<title>OI平台-数据中心</title>
<meta name="keywords" content="H+后台主题,后台bootstrap框架,会员中心主题,后台HTML,响应式后台">
<meta name="description"
	content="H+是一个完全响应式，基于Bootstrap3最新版本开发的扁平化主题，她采用了主流的左右两栏式布局，使用了Html5+CSS3等现代技术">
<link rel="shortcut icon" href="favicon.ico">
<link
	href="${pageContext.request.contextPath}/statics/css/bootstrap.min.css?v=3.3.6"
	rel="stylesheet">
<link
	href="${pageContext.request.contextPath}/statics/css/font-awesome.css?v=4.4.0"
	rel="stylesheet">
<link
	href="${pageContext.request.contextPath}/statics/css/plugins/iCheck/custom.css"
	rel="stylesheet">
<link href="${pageContext.request.contextPath}/statics/css/animate.css"
	rel="stylesheet">
<link
	href="${pageContext.request.contextPath}/statics/css/style.css?v=4.1.0"
	rel="stylesheet">
<style>
.echarts-box {
	min-height: 300px;
}
</style>
</head>
<body class="gray-bg">
	<div class="wrapper wrapper-content animated fadeInRight">
		<div class="row">
			<div class="col-sm-12">
				<div class="ibox float-e-margins">
					<div class="ibox-title">
						<div class="ibox-tools">
							<a class="collapse-link"> <i class="fa fa-chevron-up"></i>
							</a>
						</div>
					</div>
					<!--公司任务汇总图-->
					<div class="ibox-content">
						<div class="row">
							<!--企业入驻-->
							<div class="col-sm-6 echarts-box" id="enter_total_task"></div>
							<!--员工完成任务TOP10-->
							<div class="col-sm-6 echarts-box" id="enter_total_task_1"></div>
							<!--漏斗图-->
							<div class="col-sm-6 echarts-box" id="enter_total_task_2"></div>
							<!--公司整体任务完成情况-->
							<div class="col-sm-6 echarts-box" id="enter_total_task_3"></div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<script
		src="${pageContext.request.contextPath}/statics/js/jquery.min.js?v=2.1.4"></script>
	<script
		src="${pageContext.request.contextPath}/statics/js/plugins/echarts/echarts.js"></script>
	<script src="${pageContext.request.contextPath}/statics/js/china.js"></script>
	<script>
	$(function(){
		var myChart = echarts.init(document.getElementById('enter_total_task')); //公司任务
		var myChart_2 = echarts.init(document.getElementById('enter_total_task_1')); //top10排名
		var myChart_3 = echarts.init(document.getElementById('enter_total_task_2')); //漏斗图
		var myChart_4 = echarts.init(document.getElementById('enter_total_task_3')); //漏斗图
		
		var d_name=[],d_value=[],m_data=[];
		
		var typedata=(gettype());
		var prodata=(getpro());
		var taskdata=(gettask());
	function gettype(){
	var data;
	$.ajax({  //企业类型
			url:"${pageContext.request.contextPath}/Admin/gettypedata",
			type:"GET",
			dataType:"json",
			success:function(result){
			console.log(result);
			data=result;
			myChart.setOption({
			title : {
				text : "入驻企业分类"
			},
			tooltip : {
				trigger : 'item',
				formatter : "{a} <br/>{b} : {c} ({d}%)"
			},
			series : [
				{
					name : "任务状态占比",
					type : 'pie',
					radius : '55%',
					roseType : 'angle',
					data :data,
					itemStyle : {
						normal : {
							shadowBlur : 200,
							shadowColor : 'rgba(0, 0, 0, 0.5)'
						}
					}
				}
			]
		});
		for(var i=0;i<data.length;i++){
			d_name.push(data[i].name);
			d_value.push(data[i].value);
		}
		myChart_2.setOption({
			title : {
				text : "企业分类"
			},
			tooltip : {
				trigger : 'axis'
			},
			xAxis : {
				type : 'category',
				boundaryGap : false,
				data :d_name
			},
			yAxis : {
				type : 'value'
			},
			series : [ {
				type : 'line',
				smooth : true,
				data :d_value //数组的每个下标的值对应员工完成任务的总数
			} ]
		})
		}
	 });
	 return data;
	};
	function getpro(){ //地图数据
	$.ajax({
			url:"${pageContext.request.contextPath}/Admin/getprodata",
			type:"GET",
			dataType:"json",
			success:function(result){
			console.log(result);
			$.each(result,function(i,v){
				m_data.push({
					"name":v.name.replace(/省/,""),
					"value":v.value
				})
			})
			myChart_3.setOption({
			title : {
				text : '全国入驻企业数量',
				left : 'center'
			},
			tooltip : {
				trigger : 'item'
			},
			legend : {
				orient : 'vertical',
				left : 'left',
				data : [ '入驻数' ]
			},
			visualMap : {
				min : 0,
				max : 2500,
				left : 'left',
				top : 'bottom',
				text : [ '高', '低' ], // 文本，默认为数值文本
				calculable : true
			},
			series : [
				{
					name : '入驻数',
					type : 'map',
					mapType : 'china',
					roam : false,
					label : {
						normal : {
							show : false
						},
						emphasis : {
							show : true
						}
					},
					data : m_data
				}
			]
		})
		}
	 });
	};
	function gettask(){  //各公司实时任务统计
	$.ajax({
			url:"${pageContext.request.contextPath}/Admin/gettaskdata",
			type:"GET",
			dataType:"json",
			success:function(result){
				console.log(result);
				myChart_4.setOption({
			title : {
				text : '各公司实时任务统计'
			},
			tooltip : {
				trigger : 'axis',
				axisPointer : {
					type : 'shadow'
				}
			},
			legend : {
				data : [ "完成", "进行" ]
			},
			grid : {
				left : '3%',
				right : '4%',
				bottom : '3%',
				containLabel : true
			},
			xAxis : {
				type : 'value',
				boundaryGap : [ 0, 0.01 ]
			},
			yAxis : {
				type : 'category',
				data : result[0]
			},
			series : [
				{
					name : '完成',
					type : 'bar',
					data : result[1]
				},
				{
					name : '进行',
					type : 'bar',
					data : result[2]
				},
			]
		})
		}
	 });
	};
});
	</script>
	<!-- 全局js -->
	<script
		src="${pageContext.request.contextPath}/statics/js/jquery.min.js?v=2.1.4"></script>
	<script
		src="${pageContext.request.contextPath}/statics/js/bootstrap.min.js?v=3.3.6"></script>
</body>
</html>
