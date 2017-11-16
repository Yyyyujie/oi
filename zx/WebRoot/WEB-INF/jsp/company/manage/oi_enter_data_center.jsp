<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>OI平台-角色管理</title>
  <meta name="keywords" content="H+后台主题,后台bootstrap框架,会员中心主题,后台HTML,响应式后台">
  <meta name="description" content="H+是一个完全响应式，基于Bootstrap3最新版本开发的扁平化主题，她采用了主流的左右两栏式布局，使用了Html5+CSS3等现代技术">
  <link rel="shortcut icon" href="${pageContext.request.contextPath }/statics/favicon.ico">
  <link href="${pageContext.request.contextPath }/statics/css/bootstrap.min.css?v=3.3.6" rel="stylesheet">
  <link href="${pageContext.request.contextPath }/statics/css/font-awesome.css?v=4.4.0" rel="stylesheet">
  <link href="${pageContext.request.contextPath }/statics/css/plugins/iCheck/custom.css" rel="stylesheet">
  <link href="${pageContext.request.contextPath }/statics/css/animate.css" rel="stylesheet">
  <link href="${pageContext.request.contextPath }/statics/css/style.css?v=4.1.0" rel="stylesheet">
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
            <a class="collapse-link">
              <i class="fa fa-chevron-up"></i>
            </a>
          </div>
        </div>
        <!--公司任务汇总图-->
        <div class="ibox-content">
          <div class="row">
            <!--公司任务汇总图-->
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
<script src="${pageContext.request.contextPath }/statics/js/jquery.min.js"></script>
<script src="${pageContext.request.contextPath }/statics/js/plugins/layer/layer.js"></script>
<script src="${pageContext.request.contextPath }/statics/js/plugins/echarts/echarts.js"></script>
<script>
	$(function(){
	/*公司任务汇总图：*/
		var month=[];
		var count=[];
		var accomp=[];
		var carry=[];
		//任务
		 $.ajax({
                    type: "post", //要用post方式                 
                    url: "${pageContext.request.contextPath }/company/task/selectGather.do",//方法所在页面和方法名
                    contentType: "json; charset=utf-8",
                    dataType: "json",
                    success: function (data) {
                    	for(var i=0;i<data.month.length;i++){
                    		month.push(data.month[i]+"月");
                    	}
                    	for(var i=0;i<data.count.length;i++){
                    		count.push(data.count[i]);;
                    	}
                    	for(var i=0;i<data.accomp.length;i++){
                    		accomp.push(data.accomp[i]);
                    	}
                    	for(var i=0;i<data.carry.length;i++){
                    		carry.push(data.carry[i]);
                    	}
                    	myChart.setOption({
				          title: {
				            text: "公司任务汇总图"
				          },
				          tooltip: {
				            trigger: 'axis'
				          },
				          legend: {
				            data: ['进行', '完成', '总数']
				          },
				          xAxis: {
				            type: 'category',
				            boundaryGap: false,
				            data: month
				          },
				          yAxis: {
				            type: 'value'
				          },
				          series: [{
				            name: '总数',
				            type: 'line',
				            smooth: true,
				            data: count      //数组的每个下标的值对应每个月的总数
				          },
				            {
				              name: '进行',
				              type: 'line',
				              smooth: true,
				              data: carry //数组的每个下标的值对应每个月的进行数量
				            },
				            {
				              name: '完成',
				              type: 'line',
				              smooth: true,
				              data:accomp //数组的每个下标的值对应每个月的完成数量
				            }]
				        });
                    },
                    error: function (err) {
                        /* alert("失败"); */
                    }
                });
             //TOP10
             
             var name=[];
             var perponCount=[];
             $.ajax({
                    type: "post", //要用post方式                 
                    url: "${pageContext.request.contextPath }/company/task/selectTop.do",//方法所在页面和方法名
                    contentType: "json; charset=utf-8",
                    dataType: "json",
                    success: function (data) {
                    	for(var i=0;i<data.length;i++){
                    		if(data[i] != null){
                    			name.push(data[i].realname);
                    			perponCount.push(data[i].count);
                    		}else{
                    			name.push("");
                    			perponCount.push(0);
                    		}             		
                    		
                    	}
                    	myChart_2.setOption({
				          title: {
				            text: "员工Top10"
				          },
				          tooltip: {
				            trigger: 'axis'
				          },
				          xAxis: {
				            type: 'value',
				          },
				          yAxis: {
				            type: 'category',
				            data: name
				          },
				          series: [{
				            type: 'bar',
				            smooth: true,
				            data: perponCount      //数组的每个下标的值对应员工完成任务的总数
				          }]
				        });
                    },
                    error: function (err) {
                        /* alert("失败"); */
                    }
                }); 
                //所占百分比   
               var  count,receive,carry,evaluate,accomplish,back,remove;
               
              $.ajax({
                    type: "post", //要用post方式                 
                    url: "${pageContext.request.contextPath }/company/task/selectPercentage.do",//方法所在页面和方法名
                    contentType: "json; charset=utf-8",
                    dataType: "json",
                    success: function (data) {
                    	if(data.count != null){
                    		count=data.count.count;
                    	}else{
                    		count=0;
                    	}
                    	if(data.receive != null){
                    		receive=data.receive.count;
                    	}else{
                    		receive=0;
                    	}
                    	if(data.carry != null){
                    		carry=data.carry.count;
                    	}else{
                    		carry=0;
                    	}
                    	if(data.evaluate != null){
                    		evaluate=data.evaluate.count;
                    	}else{
                    		evaluate=0;
                    	}
                    	if(data.accomplish != null){
                    		accomplish=data.accomplish.count;
                    	}else{
                    		accomplish=0;
                    	}
                    	if(data.back != null){
                    		back=data.back.count;
                    	}else{
                    		back=0;
                    	}
                    	if(data.remove != null){
                    		remove=data.remove.count;
                    	}else{
                    		remove=0;
                    	}
                    	
                    	myChart_3.setOption({
				          title: {
				            text: "任务状态占比"
				          },
				          tooltip: {
				            trigger: 'item',
				            formatter: "{a} <br/>{b} : {c} ({d}%)"
				          },
				          series: [
				            {
				              name: "任务状态占比",
				              type: 'pie',
				              radius: '55%',
				              roseType: 'angle',
				              data: [
				                {value: count, name: '发出'},
				                {value: receive, name: '接受'},
				                {value: carry, name: '进行'},
				                {value: evaluate, name: '评价'},
				                {value: accomplish, name: '完成'},
				                {value: back, name: '退回'},
				                {value: remove, name: '取消'}
				              ],
				              itemStyle: {
				                normal: {
				                  shadowBlur: 200,
				                  shadowColor: 'rgba(0, 0, 0, 0.5)'
				                }
				              }
				            }
				          ]
				        });
                    },
                    error: function (err) {
                        /* alert("失败"); */
                    }
                }); 
                //饼图    
                $.ajax({
                    type: "post", //要用post方式                 
                    url: "${pageContext.request.contextPath }/company/task/selectPicture.do",//方法所在页面和方法名
                    contentType: "json; charset=utf-8",
                    dataType: "json",
                    success: function (data) {
                    	myChart_4.setOption({
			          title: {
			            text: "公司整体任务完成情况"
			          },
			          tooltip: {
			            trigger: 'item',
			            formatter: "{a} <br/>{b} : {c} ({d}%)"
			          },
			          series: [
			            {
			              name: "公司整体任务完成情况",
			              type: 'pie',
			              radius: '55%',
			              roseType: 'angle',
			              data: [
			                {value: data.rough, name: '未完成'},
			                {value: data.accomplish.count, name: '完成'}
			              ],
			              itemStyle: {
			                normal: {
			                  shadowBlur: 200,
			                  shadowColor: 'rgba(0, 0, 0, 0.5)'
			                }
			              }
			            }
			          ]
			        });
                    },
                    error: function (err) {
                        /* alert("失败"); */
                    }
                });    
               
	});
	
  var myChart = echarts.init(document.getElementById('enter_total_task')); //公司任务
  var myChart_2 = echarts.init(document.getElementById('enter_total_task_1')); //top10排名
  var myChart_3 = echarts.init(document.getElementById('enter_total_task_2')); //漏斗图
  var myChart_4 = echarts.init(document.getElementById('enter_total_task_3')); //漏斗图
  document.addEventListener("DOMContentLoaded",function(){
    
  });
 
</script>
<!-- 全局js -->
<script src="js/jquery.min.js?v=2.1.4"></script>
<script src="js/bootstrap.min.js?v=3.3.6"></script>
</body>
</html>
