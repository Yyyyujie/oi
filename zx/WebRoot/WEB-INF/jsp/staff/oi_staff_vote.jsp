<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>OI - ${companyStaffer.company_name}</title>
    <script src="${pageContext.request.contextPath }/statics/js/rem.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath }/statics/css/iconfont.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/statics/css/yj-jinsheng.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/statics/css/header.css">
    <script src="${pageContext.request.contextPath }/statics/js/jquery-1.11.3.min.js"></script>
    <!--<script src="${pageContext.request.contextPath }/statics/js/jquery.knob-1.0.1.js"></script>-->
   <%--  <script src="${pageContext.request.contextPath }/statics/js/echarts.common.min.js"></script> --%>
    <script src="${pageContext.request.contextPath }/statics/js/circleChart.min.js"></script>
    <script src="${pageContext.request.contextPath }/statics/js/yj-jinshneg.js"></script>
    
		<style>
			header{
				margin: 0 auto;
				width: 960px;
				color: #808080;
				font-weight: bold;
				font-family: Arial;
			}
			
			header h1{
				font-size: 44px;
			}
			
			#container{
				margin: 0 auto;
				padding:0;
				width: 960px;
				border: 10px solid #303030;
				border-radius: 5px 5px 5px 5px;
				background: #000;
				box-shadow: 0px 0px 30px #2B99E6;
			}
			
			#imgwrapper{
				width: 460px;
				float: left;
				text-align: center;
				padding:0;
				margin:0;
			}
			
			#knobwrapper{
				width: 300px;
				float: right;
				text-align: center;
			}
			
			#img{
				margin: 0 auto;
				width: 500px;
				border-radius: 5px 5px 5px 5px;
			}
			
			.clear{
				clear:both;
			}
			.circleChart{
				padding-top: 24px;
    padding-left: 28px;
			}
			#2{
	position: absolute;
	left: 0;
	right: 0;
	top: 0;
	bottom: 0;
	margin:auto;
}
#3{
	position: absolute;
	left: 0;
	right: 0;
	top: 0;
	bottom: 0;
	margin:auto;
}


		</style>
</head>
<body>
    <div class="headerr">
        <div class="header-zhe">
            <i class="iconfont icon-fanhui back"></i>
            <span>晋升进度</span>
        </div>
    </div>
    <main>
    <div class="message">
        <div class="tx">
            <div class="img">
                <img src="${promotion.face==null ||promotion.face==''?promotion.header:promotion.face}" alt="" style="width: 100%;;height: 100%;">
            </div>
        </div>
        <div class="xinxi">
            <p class="name">${promotion.realname }</p>
            <p>下一晋升目标：<span>${promotion.level_name }</span></p>
            <p><i class="iconfont icon-bumen">&nbsp&nbsp<span>${depart.dept_name }</span></i> &nbsp&nbsp <i class="iconfont icon-zhiwei">&nbsp<span>${post.post_name }</span></i></p>
           	<!-- 页面隐藏域 -->
            <input type="hidden" value="${promotion.promotion_id }" id="promotionId" name="promotion_id">
            <input type="hidden" value="${promotion.user_id }" id="useID" name="user_id"> 
            <input type="hidden" value="${promotion.end_time }" id="endTime" name="end_time"> 
            <input type="hidden" value="${isVote }" id="isVote">
            <input type="hidden" value="${day }" id="day">
            <div class="rili">
                <i class="iconfont icon-rili"> <span>${day }</span></i>
            </div>
        </div>
    </div>
    <div class="main">
        <div class="mark">
            <ul>
                <li>
                    <span>${conCompanyStaffer.qualityavg}</span>
                    <div class="mark1">
                        <ul>
                            <li>mark</li>
                            <li>工作质量</li>
                        </ul>
                    </div>
                </li>
                <li>
                    <span>${conCompanyStaffer.efficiencyavg}</span>
                    <div class="mark1">
                        <ul>
                            <li>mark</li>
                            <li>工作效率</li>
                        </ul>
                    </div>
                </li>
            </ul>
        </div>

        <div class="data-title">
            <p>当前任务状态</p>
            <p>Current task status</p>
        </div>
        <div class="data-tip">
        	<li>
        		<span></span>
        		<span>已完成</span>
        	</li>
        	<li>
        		<span></span>
        		<span>进行中</span>
        	</li>
        	<li>
        		<span></span>
        		<span>未完成</span>
        	</li>
        </div>
        <div class="data-img">
			<div class="circleChart" id="1" data-value="${complete.count/count.count*100 }" style="padding: 0;position: absolute;left: 0;right: 0;top: 0;bottom: 0;margin: auto;"></div>
			<div class="circleChart" id="2" data-value="${receive.count/count.count*100 }" style="padding: 0;position: absolute!important;left: 0;right: 0;
top: 0;bottom: 0;margin: auto;margin-top: -174px;"></div>
			<div class="circleChart" id="3" data-value="${(count.count-complete.count)/count.count*100 }" style="padding: 0;position: absolute!important;left: 0;right: 0;
top: 0;bottom: 0;margin: auto;margin-top: -124px;"></div>
			<!--<div id="chars" style="width: 6.38rem;
    height: 5.63rem;"></div>-->
       </div>
    </div>
     <div class="butt">
            <button class="ok">同意</button>
            <button class="no">拒绝</button>
            <button class="wait">保留</button>
        </div>
        </main>
</body>
<script>
    $(".back").click(function () {
        history.back();
    });
    
        $(".circleChart#1").circleChart({
	            size:200,
	            color:"#13a3ff"
	        });
	        $(".circleChart#2").circleChart({
	            size:150,
	            color:"#13fcff"
	        });
	        $(".circleChart#3").circleChart({
	            size:100,
	            color:"#1fd280"
	        });
	        setInterval(function() {
	            $("#0").circleChart({
	                value: Math.random() * 100
	            });
	        }, 4000);
</script>
</html>