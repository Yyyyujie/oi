<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="utf-8"/>
  <meta http-equiv="x-ua-compatible" content="IE=Edge,chrome=1"/>
  <meta name="apple-mobile-web-app-capable" content="yes"/>
  <meta name="apple-mobile-web-app-status-bar-style" content="black"/>
  <title>OI - ${companyStaffer.company_name}</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath }/statics/css/allReset.css"/>
  <link rel="stylesheet" href="${pageContext.request.contextPath }/statics/css/sf_header.css"/>
  <link rel="stylesheet" href="${pageContext.request.contextPath }/statics/css/oi_alert.css"/>
  <link rel="stylesheet" href="${pageContext.request.contextPath }/statics/css/sf_data_center.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath }/statics/css/yj-footer-header.css"/>
  <script src="${pageContext.request.contextPath }/statics/js/flexible.js"></script>
</head>
<style>
.li-msg{
	background: url(${pageContext.request.contextPath }/statics/images/footer/msg.png) no-repeat;
	background-size: contain;
    background-position: center;
}
.li-data{
	background: url(${pageContext.request.contextPath }/statics/images/footer/data_on.png) no-repeat;
	background-size: contain;
    background-position: center;
}

</style>

<body>
<div class="tip">
	<div class="tipBox">
			<p>提示</p>
			<p>获取数据失败</p>
			<div class="sure">确定</div>
	</div>
</div>
<!--任务中心-->
<input type="hidden" id="status" value="">  
<div class="sf_reg_container">
  <!--页面顶部-->
  <header class="sf_header_bar clearfix">
    <!-- <a class="__back_btn" href="javascript:window.history.go(-1);" style="background-image:url(images/icons/back.png);"></a> -->
    <span class="header_bar_title">数据统计</span>
  </header>
  <!--页面顶部 结束-->
  <div class="__data_container">
    <!--数据分页-->
    <div class="__dt_tab" id="__dtTabContainer">
      <!--个人版-->
      <div data-target="__data_person_box" class="__tab __tab_on __dt_ps">个人</div>
      <!--整体版-->
      <div data-target="__data_total_box" class="__tab __dt_tt">综合</div>
    </div>
    <!--个人版数据-->
    <div class="_data_box_container __data_person_box">
      <ul>
        <!--当前任务状态-->
        <li>
          <div class="__d_tt">
            <!--数据标题-->
            <div>当前任务状态</div>
            <div class="t_en">Current task status</div>
          </div>
    
          <div class="__data_chart __chart_dot" id="__d_current_tsk" ></div>
        </li>
        <!--统计月报-->
        <li>
          <div class="__d_tt">
            <!--数据标题-->
            <div>统计月报</div>
            <div class="t_en">Monthly statistics</div>
          </div>
          <div class="__data_chart" id="__d_month_tsk"></div>
        </li>
        <li>
        <div class="__d_tt">
            <!--数据标题-->
            <div>统计数据</div>
            <div class="t_en">Monthly statistics</div>
          </div>
          <div class="__data_chart" id="main4"></div>
        </li>
      </ul>
    </div>
    <!--个人版数据 结束-->
    <!--综合版数据-->
    <div class="_data_box_container __data_total_box" style="display:none;">
      <ul>
        <!--当前任务状态-->
        <li>
          <div class="__d_tt">
            <!--数据标题-->
            <div>实时统计</div>
            <div class="t_en">Real time statistics</div>
          </div>
          <div class="__data_chart" id="__d_real_tsk"></div>
        </li>
        <!--统计月报-->
        <li>
          <div class="__d_tt">
            <!--数据标题-->
            <div>完成任务排名</div>
            <div class="t_en">Mission ranking</div>
          </div>
          <div class="__data_chart __chart_dot" id="__d_rank_tsk"></div>
        </li>
      </ul>
    </div>
    <!--综合版数据 结束-->
  </div>
  <!--页面底部-->
   <footer>
        <ul>
            <li>
                <a href="${pageContext.request.contextPath }/Newstaff/yj-index.html" class="li-a li-msg">         
                </a>
            </li>
            <li>
                <a href="${pageContext.request.contextPath }/Newstaff/oi_staff_task_center.html" class="li-a li-task">
                </a>
            </li>
            <li >
                <a href="${pageContext.request.contextPath }/Newstaff/oi_staff_task_release.html" class="li-a li-release-on">

                </a>
            </li>
            <li>
                <a href="${pageContext.request.contextPath }/staff/oi_staff_data_center.html" class="li-a li-data">
                </a>
            </li>
            <li>
                <a href="${pageContext.request.contextPath }/staff/yj-member.html" class="li-me">
                </a>
            </li>
        </ul>
    </footer>

</div>
<!--任务中心 结束-->
<!--遮罩层 确认遮罩层-->
	<div class="_shade_box _alert_box" style="display: none;"></div>
	<!--遮罩层-->
<script src="${pageContext.request.contextPath }/statics/js/jquery-1.11.3.min.js"></script>
<script src="${pageContext.request.contextPath }/statics/js/echarts.min.js"></script>
<script src="${pageContext.request.contextPath }/statics/js/oi_sf_data.js"></script>
<script src="${pageContext.request.contextPath }/statics/js/oi_alert.js"></script>
<script src="${pageContext.request.contextPath }/statics/js/drill.js"></script>
</body>
</html>