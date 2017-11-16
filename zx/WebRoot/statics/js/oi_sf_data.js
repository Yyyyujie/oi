$(function () {
  data_chart.init();
  $(".sure").click(function(){
	  $(".tip").hide();
  });
});
function getId(elem) {
  return document.getElementById(elem);
}
var path=window.location.href;
var lastPath=path.substring(0, path.lastIndexOf("/"));
var rootPath=lastPath.substring(0, lastPath.lastIndexOf("/"));


var data_chart = {
  d_person: getId("__d_current_tsk"),//个人任务
  d_month: getId("__d_month_tsk"),
  d_real: getId("__d_real_tsk"),
  d_rank: getId("__d_rank_tsk"),
  d_tab: $("#__dtTabContainer"),
  init: function () {
    this._d_chart_person();
    this._d_chart_month();
    this._d_chart_real();
    this._d_chart_rank();
    this._d_change_tab();
  },
  _d_chart_person: function () {  //当前任务状态  圆环图
    var _d_chart = echarts.init(this.d_person);
    _d_chart.showLoading();
    /*当前任务状态*/
    $.ajax({
        type: "post", //要用post方式                 
        url: lastPath+"/selectStaffer.do",//方法所在页面和方法名
        contentType: "json; charset=utf-8",
        dataType: "json",
        success: function (data) {     
        	_d_chart.hideLoading();
        	_d_chart.setOption({
        	      tooltip: {
        	        trigger: 'item',
        	        formatter: "{a} <br/>{b}: {c} ({d}%)"
        	      },
        	      series: [
        	               {
        	                 name:'个人接收数据',
        	                 type:'pie',
        	                 selectedMode: 'single',
        	                 radius: [0, '30%'],
        	                 label: {
        	                   normal: {
        	                     position: 'inner'
        	                   }
        	                 },
        	                 labelLine: {
        	                   normal: {
        	                     show: false
        	                   }
        	                 },
        	                 data:[  //中心数据
        	                   {value:data.completeReceive.count, name:'接收',},
        	                   {value:data.receiveReceive.count, name:'进行'},
        	                   {value:data.completeReceive.count, name:'完成'}
        	                 ]
        	               },
        	               {
        	                 name:'个人发布数据',
        	                 type:'pie',
        	                 radius: ['40%', '55%'],
        	                 data:[  //外部数据
        	                         {value:data.carryPublish.count, name:'接收',},
              	                   {value:data.receivePublish.count, name:'进行'},
              	                   {value:data.completePublish.count, name:'完成'}
        	                 ]
        	               }
        	             ]
        	            
        	    });
        	
        },
        error: function (err) {
        	kAlert({
		        title: "获取数据失败",
		        subtitle: "点击关闭",
		        btns: ["确定"]
		      },function(){
		    	 $("._shade_box").hide();
		      })
        }
    });
    
  },
  _d_chart_month: function () {  //统计月报  折线图
    var _d_chart = echarts.init(this.d_month);
    _d_chart.showLoading();
    /*统计月报*/
    $.ajax({
        type: "post", //要用post方式                 
        url: lastPath+"/selectStafferDay.do",//方法所在页面和方法名
        contentType: "json; charset=utf-8",
        dataType: "json",
        success: function (data) {
        	_d_chart.hideLoading();
        	  _d_chart.setOption({
        		  tooltip:{
          			trigger: 'axis'
          			},
        	      xAxis: { //横轴
        	        data: data.month
        	      },
        	      yAxis: {
        	        type: "value"
        	      },
        	      legend:{        	    	  
        	    	  data:["进行","完成"]
        	      },
        	      
        	      series: [
        	        {
        	          name: "进行",
        	          type: "line",
        	          color: ["#13fcff"],
        	          smooth: true,
        	          data: data.carry
        	        },
        	        {
        	          name: "完成",
        	          type: "line",
        	          color: ["#13a3ff"],
        	          smooth: true,
        	          data: data.complete
        	        }
        	      ]
        	    });
        	
        },
        error: function (err) {
        	kAlert({
		        title: "获取数据失败",
		        subtitle: "点击关闭",
		        btns: ["确定"]
		      },function(){
		    	 $("._shade_box").hide();
		      })
        }
    });
  
  },
  _d_chart_real: function () {  //折线图
    var _d_chart = echarts.init(this.d_real);
    _d_chart.showLoading();
    $.ajax({
        type: "post", //要用post方式                 
        url: lastPath+"/selectGather.do",//方法所在页面和方法名
        contentType: "json; charset=utf-8",
        dataType: "json",
        success: function (data) {
        	_d_chart.hideLoading();
        	_d_chart.setOption({
        		tooltip:{
        			trigger: 'axis'
        		},
        	      xAxis: { //横轴
        	        data: data.month
        	      },
        	      yAxis: {
        	        type: "value"
        	      },
        	      legend:{        	    	  
        	    	  data:["进行","完成","总数"]
        	      },
        	      series: [
        	        {
        	          name: "进行",
        	          type: "line",
        	          color: ["#13fcff"],
        	          smooth: true,
        	          data: data.carry
        	        },
        	        {
        	          name: "完成",
        	          type: "line",
        	          color: ["#13a3ff"],
        	          smooth: true,
        	          data: data.accomp
        	        },
        	        {
          	          name: "总数",
          	          type: "line",
          	          color: ["blue"],
          	          smooth: true,
          	          data: data.count
          	        }
        	      ]
        	    })
        },
        error: function (err) {
        	kAlert({
		        title: "获取数据失败",
		        subtitle: "点击关闭",
		        btns: ["确定"]
		      },function(){
		    	 $("._shade_box").hide();
		      })
        }
    });
    
  },
  
  _d_chart_rank: function () {   //柱状图
    var _d_chart = echarts.init(this.d_rank);
    _d_chart.showLoading();
    var name=[];
    var perponCount=[];
    $.ajax({
        type: "post", //要用post方式                 
        url: lastPath+"/selectTop.do",//方法所在页面和方法名
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
        	_d_chart.hideLoading();
        	 _d_chart.setOption({
        	      color: ['#13a3ff'],
        	      tooltip: {
        	        trigger: 'axis',
        	        axisPointer: {            // 坐标轴指示器，坐标轴触发有效
        	          type: 'shadow'        // 默认为直线，可选为：'line' | 'shadow'
        	        }
        	      },
        	      legend:{
        	    	  data:["完成数"]
        	      },
        	      grid: {
        	        left: '3%',
        	        right: '4%',
        	        bottom: '3%',
        	        containLabel: true
        	      },
        	      xAxis: [
        	        {
        	          type: 'category',
        	          data: name,
        	          axisTick: {
        	            alignWithLabel: true
        	          }
        	        }
        	      ],
        	      yAxis: [
        	        {
        	          type: 'value'
        	        }
        	      ],
        	      series: [
        	        {
        	          name: '完成数',
        	          type: 'bar',
        	          barWidth: '60%',
        	          data: perponCount,
        	          itemStyle: {
        	            normal: {
        	              barBorderRadius: [50]
        	            }
        	          }
        	        }
        	      ]
        	    })
        },
        error: function (err) {
        	kAlert({
		        title: "获取数据失败",
		        subtitle: "点击关闭",
		        btns: ["确定"]
		      },function(){
		    	 $("._shade_box").hide();
		      })
        }
    });
   
  },
  _d_change_tab:function(){
    var _d_tal_target=$(".__data_total_box"),_d_per_target=$('.__data_person_box');
    this.d_tab.on("click",".__tab",function(){
      var self=$(this),targetBox=self.attr("data-target");
      self.addClass("__tab_on").siblings(".__tab").removeClass("__tab_on");
      if(targetBox == "__data_person_box"){
        _d_tal_target.hide()&&_d_per_target.show();
      }else if(targetBox == "__data_total_box"){
        _d_per_target.hide()&&_d_tal_target.show();
      }
    });
  },
  
};